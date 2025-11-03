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

public class MollieHooks implements Hook.BeforeRequest {
    
    private static final ObjectMapper objectMapper = new ObjectMapper();
    
    @Override
    public HttpRequest beforeRequest(Hook.BeforeRequestContext context, HttpRequest request) throws Exception {
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
        if (isOAuthRequest(updatedRequest, context)) {
            updatedRequest = populateProfileIdAndTestmode(updatedRequest, context);
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
    
    private boolean isOAuthRequest(HttpRequest request, Hook.BeforeRequestContext context) {
        SecuritySource securitySource = context.securitySource().orElse(null);
        HasSecurity security = securitySource != null ? securitySource.getSecurity() : null;
        
        if (security == null) {
            return false;
        }

        // Cast to Security to access oAuth() method
        if (!(security instanceof Security)) {
            return false;
        }
        
        Security securityObj = (Security) security;
        String oAuth = securityObj.oAuth().orElse(null);

        if (oAuth == null) {
            return false;
        }

        Optional<String> authHeader = request.headers().firstValue("authorization");
        return authHeader.isPresent() && authHeader.get().equals("Bearer " + oAuth);
    }
    
    private HttpRequest populateProfileIdAndTestmode(HttpRequest request, Hook.BeforeRequestContext context) throws Exception {
        String clientProfileId = context.sdkConfiguration().globals.getQueryParam("profileId").orElse(null);
        String clientTestmode = context.sdkConfiguration().globals.getQueryParam("testmode").orElse(null);

        String method = request.method();

        if ("GET".equals(method)) {
            // SDK already handles Query Parameters automatically
            return request;
        }

        // For POST, PATCH, etc. - remove testmode and profileId from query parameters and add to body
        HttpRequest.Builder builder = Helpers.copy(request);
        
        // Remove testmode and profileId from query string if present
        String originalUri = request.uri().toString();
        String cleanedUri = removeQueryParams(originalUri, "testmode", "profileId");
        
        if (!originalUri.equals(cleanedUri)) {
            builder.uri(java.net.URI.create(cleanedUri));
        }

        try {
            // Extract current body
            byte[] bodyBytes = Helpers.bodyBytes(request);
            String bodyContent = new String(bodyBytes, StandardCharsets.UTF_8);
            
            JsonNode bodyJson;
            if (bodyContent.isEmpty()) {
                bodyJson = objectMapper.createObjectNode();
            } else {
                try {
                    bodyJson = objectMapper.readTree(bodyContent);
                } catch (Exception e) {
                    // If it's not JSON, return request unchanged
                    return request;
                }
            }
            
            // Ensure we have an ObjectNode to modify
            if (!bodyJson.isObject()) {
                return request;
            }
            
            ObjectNode bodyObject = (ObjectNode) bodyJson;
            
            // Add profileId if not already present
            if (clientProfileId != null && !bodyObject.has("profileId")) {
                bodyObject.put("profileId", clientProfileId);
            }
            
            // Add testmode if not already present
            if (clientTestmode != null && !bodyObject.has("testmode")) {
                bodyObject.put("testmode", clientTestmode);
            }
            
            // Create new request with updated body
            String newBodyContent = objectMapper.writeValueAsString(bodyObject);
            byte[] newBodyBytes = newBodyContent.getBytes(StandardCharsets.UTF_8);
            
            builder.method(request.method(), BodyPublishers.ofByteArray(newBodyBytes));
            
            return builder.build();
            
        } catch (Exception e) {
            // If anything goes wrong, return the original request
            System.err.println("Error processing request body: " + e.getMessage());
            return request;
        }
    }
    
    private String removeQueryParams(String uri, String... paramsToRemove) {
        if (!uri.contains("?")) {
            return uri;
        }
        
        String[] parts = uri.split("\\?", 2);
        String baseUri = parts[0];
        String query = parts[1];
        
        String[] queryParams = query.split("&");
        StringBuilder newQuery = new StringBuilder();
        
        for (String param : queryParams) {
            if (param.trim().isEmpty()) {
                continue;
            }
            
            String paramName = param.contains("=") ? param.split("=")[0] : param;
            boolean shouldRemove = false;
            
            for (String paramToRemove : paramsToRemove) {
                if (paramName.equals(paramToRemove)) {
                    shouldRemove = true;
                    break;
                }
            }
            
            if (!shouldRemove) {
                if (newQuery.length() > 0) {
                    newQuery.append("&");
                }
                newQuery.append(param);
            }
        }
        
        if (newQuery.length() > 0) {
            return baseUri + "?" + newQuery.toString();
        } else {
            return baseUri;
        }
    }
}
