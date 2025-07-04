/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.mollie.mollie.models.operations;

import com.fasterxml.jackson.annotation.JsonValue;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

public enum GetClientStatusReason {
    REQUIREMENT_PAST_DUE("requirement-past-due"),
    ONBOARDING_INFORMATION_NEEDED("onboarding-information-needed");

    @JsonValue
    private final String value;

    GetClientStatusReason(String value) {
        this.value = value;
    }
    
    public String value() {
        return value;
    }
    
    public static Optional<GetClientStatusReason> fromValue(String value) {
        for (GetClientStatusReason o: GetClientStatusReason.values()) {
            if (Objects.deepEquals(o.value, value)) {
                return Optional.of(o);
            }
        }
        return Optional.empty();
    }
}

