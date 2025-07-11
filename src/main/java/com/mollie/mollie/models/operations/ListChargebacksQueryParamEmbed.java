/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.mollie.mollie.models.operations;

import com.fasterxml.jackson.annotation.JsonValue;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

/**
 * ListChargebacksQueryParamEmbed
 * 
 * <p>This endpoint allows you to embed additional information via the `embed` query string parameter.
 */
public enum ListChargebacksQueryParamEmbed {
    PAYMENT("payment");

    @JsonValue
    private final String value;

    ListChargebacksQueryParamEmbed(String value) {
        this.value = value;
    }
    
    public String value() {
        return value;
    }
    
    public static Optional<ListChargebacksQueryParamEmbed> fromValue(String value) {
        for (ListChargebacksQueryParamEmbed o: ListChargebacksQueryParamEmbed.values()) {
            if (Objects.deepEquals(o.value, value)) {
                return Optional.of(o);
            }
        }
        return Optional.empty();
    }
}

