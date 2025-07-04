/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.mollie.mollie.models.operations;

import com.fasterxml.jackson.annotation.JsonValue;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

/**
 * GetCaptureQueryParamEmbed
 * 
 * <p>This endpoint allows you to embed additional resources via the `embed` query string parameter.
 */
public enum GetCaptureQueryParamEmbed {
    PAYMENT("payment");

    @JsonValue
    private final String value;

    GetCaptureQueryParamEmbed(String value) {
        this.value = value;
    }
    
    public String value() {
        return value;
    }
    
    public static Optional<GetCaptureQueryParamEmbed> fromValue(String value) {
        for (GetCaptureQueryParamEmbed o: GetCaptureQueryParamEmbed.values()) {
            if (Objects.deepEquals(o.value, value)) {
                return Optional.of(o);
            }
        }
        return Optional.empty();
    }
}

