package com.mollie.mollie.hooks;

import com.mollie.mollie.utils.Hook;
import com.mollie.mollie.utils.Helpers;
import com.mollie.mollie.models.components.Security;

import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublisher;
import java.net.http.HttpRequest.BodyPublishers;
import java.util.UUID;
import java.nio.charset.StandardCharsets;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.Optional;
import java.util.List;
import com.mollie.mollie.SecuritySource;
import com.mollie.mollie.utils.HasSecurity;
import com.mollie.mollie.utils.MollieAuthUtils;

import java.io.InputStream;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class MollieHooks implements Hook.BeforeRequest {
    
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private final Map<String, Set<String>> globalUsage;

    public MollieHooks() {
        Map<String, Set<String>> usage;
        try (InputStream is = getClass().getResourceAsStream("/com/mollie/mollie/hooks/global_usage.json")) {
            if (is == null) {
                throw new IllegalStateException("global_usage.json not found in classpath");
            }
            usage = objectMapper.readValue(is,
                objectMapper.getTypeFactory().constructMapType(Map.class,
                    objectMapper.getTypeFactory().constructType(String.class),
                    objectMapper.getTypeFactory().constructCollectionType(Set.class, String.class)));
        } catch (Exception e) {
            usage = Collections.emptyMap();
        }
        this.globalUsage = Collections.unmodifiableMap(usage);
    }
    
    @Override
    public HttpRequest beforeRequest(Hook.BeforeRequestContext context, HttpRequest request) throws Exception {
        // Validate path parameters
        validatePathParameters(request);
        
        // Copy the request for modification
        HttpRequest.Builder builder = Helpers.copy(request);
        
        // Handle idempotency key
        if (!request.headers().firstValue("idempotency-key").isPresent()) {
            builder.header("idempotency-key", generateIdempotencyKey());
        }
        
        // Customize User-Agent
        customizeUserAgent(builder, context);

        // Build the updated request first
        HttpRequest updatedRequest = builder.build();

        // Populate profile ID and testmode if OAuth (this may update the request again)
        if (MollieAuthUtils.canHaveGlobalFields(context.sdkConfiguration())) {
            updatedRequest = injectGlobalFields(updatedRequest, context);
        }
        
        return updatedRequest;
    }
    
    private void customizeUserAgent(HttpRequest.Builder builder, Hook.BeforeRequestContext context) {
        // Parse from existing USER_AGENT string
        // "speakeasy-sdk/java 0.19.3 2.709.0 1.0.0 com.mollie.mollie"
        String userAgent = context.sdkConfiguration().USER_AGENT;
        String[] parts = userAgent.split(" ");
        
        String sdkVersion = parts[1];      // "0.19.3"
        String genVersion = parts[2];      // "2.709.0"
        String packageName = parts[4];     // "com.mollie.mollie"
        
        // Get Java version
        String javaVersion = System.getProperty("java.version");
        
        String mollieUserAgent = String.format("Speakeasy/%s Java/%s %s/%s", 
            genVersion, javaVersion, packageName, sdkVersion);
        
        builder.setHeader("User-Agent", mollieUserAgent);
    }
    
    private String generateIdempotencyKey() {
        return UUID.randomUUID().toString();
    }
    
    private void validatePathParameters(HttpRequest request) throws Exception {
        String path = request.uri().getPath();
        String[] pathSegments = path.split("/", -1); // Use -1 to keep trailing empty strings
        
        for (int i = 0; i < pathSegments.length; i++) {
            if (i == 0 && pathSegments[i].isEmpty()) {
                continue;
            }
            
            if (pathSegments[i].isEmpty() || pathSegments[i].trim().isEmpty()) {
                throw new IllegalArgumentException(
                    String.format("Invalid request: empty path parameter detected in [%s] '%s'",
                        request.method(), path));
            }
        }
    }
    
    private HttpRequest injectGlobalFields(HttpRequest request, Hook.BeforeRequestContext context) throws Exception {
        String operationId = context.operationId();

        Map<String, String> fieldsToInject = new LinkedHashMap<>();
        for (Map.Entry<String, Set<String>> entry : globalUsage.entrySet()) {
            String field = entry.getKey();
            if (entry.getValue().contains(operationId)) {
                context.sdkConfiguration().globals.getQueryParam(field)
                    .ifPresent(value -> fieldsToInject.put(field, value));
            }
        }

        if (fieldsToInject.isEmpty()) {
            return request;
        }

        HttpRequest.Builder builder = Helpers.copy(request);

        try {
            byte[] bodyBytes = Helpers.bodyBytes(request);
            String bodyContent = new String(bodyBytes, StandardCharsets.UTF_8);

            JsonNode bodyJson;
            if (bodyContent.isEmpty()) {
                bodyJson = objectMapper.createObjectNode();
            } else {
                try {
                    bodyJson = objectMapper.readTree(bodyContent);
                } catch (Exception e) {
                    return request;
                }
            }

            if (!bodyJson.isObject()) {
                return request;
            }

            ObjectNode bodyObject = (ObjectNode) bodyJson;

            for (Map.Entry<String, String> entry : fieldsToInject.entrySet()) {
                if (!bodyObject.has(entry.getKey())) {
                    bodyObject.put(entry.getKey(), entry.getValue());
                }
            }

            byte[] newBodyBytes = objectMapper.writeValueAsBytes(bodyObject);
            builder.method(request.method(), BodyPublishers.ofByteArray(newBodyBytes));
            return builder.build();

        } catch (Exception e) {
            System.err.println("Error injecting global fields into request body: " + e.getMessage());
            return request;
        }
    }
}
