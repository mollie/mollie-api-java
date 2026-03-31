package com.mollie.mollie.utils;

import com.mollie.mollie.SDKConfiguration;
import com.mollie.mollie.SecuritySource;
import com.mollie.mollie.models.components.Security;

public final class MollieAuthUtils {

    private MollieAuthUtils() {
        // prevent instantiation
    }

    public static boolean canHaveGlobalFields(SDKConfiguration sdkConfiguration) {
        SecuritySource securitySource = sdkConfiguration != null ? sdkConfiguration.securitySource() : null;
        HasSecurity security = securitySource != null ? securitySource.getSecurity() : null;

        if (security == null || !(security instanceof Security)) {
            return false;
        }

        Security securityObj = (Security) security;
        String apiKey = securityObj.apiKey().orElse(null);
        String organizationAccessToken = securityObj.organizationAccessToken().orElse(null);
        String oAuth = securityObj.oAuth().orElse(null);

        String token = apiKey != null ? apiKey : organizationAccessToken != null ? organizationAccessToken : oAuth;
        return token != null && token.startsWith("access_");
    }

    public static boolean hasGlobalFields(SDKConfiguration sdkConfiguration) {
        if (sdkConfiguration == null) {
            return false;
        }

        return !sdkConfiguration.globals.queryParamsAsStream().findAny().isEmpty();
    }
}
