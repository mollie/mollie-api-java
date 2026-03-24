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
        String oAuth = securityObj.oAuth().orElse(null);
        String apiKey = securityObj.apiKey().orElse(null);

        return (apiKey != null && apiKey.startsWith("access_")) ||
               (oAuth != null && oAuth.startsWith("access_"));
    }

    public static boolean hasGlobalFields(SDKConfiguration sdkConfiguration) {
        if (sdkConfiguration == null) {
            return false;
        }

        return !sdkConfiguration.globals.queryParamsAsStream().findAny().isEmpty();
    }
}
