package com.mollie.mollie.hooks;

import com.mollie.mollie.utils.Hook;
import com.mollie.mollie.utils.Helpers;

import java.net.http.HttpRequest;
import java.util.UUID;

public class MollieHooks implements Hook.BeforeRequest {

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
        
        return builder.build();
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
        
        // Note: Custom user agent support would need to be added to SDKConfiguration
        // For now, just set the standard user agent
        builder.setHeader("User-Agent", mollieUserAgent);
    }
    
    private String generateIdempotencyKey() {
        return UUID.randomUUID().toString();
    }
}