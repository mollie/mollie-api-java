/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.mollie.mollie.models.operations;

import com.fasterxml.jackson.annotation.JsonValue;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

public enum CreatePaymentLinkSequenceType {
    ONEOFF("oneoff"),
    FIRST("first"),
    RECURRING("recurring");

    @JsonValue
    private final String value;

    private CreatePaymentLinkSequenceType(String value) {
        this.value = value;
    }
    
    public String value() {
        return value;
    }
    
    public static Optional<CreatePaymentLinkSequenceType> fromValue(String value) {
        for (CreatePaymentLinkSequenceType o: CreatePaymentLinkSequenceType.values()) {
            if (Objects.deepEquals(o.value, value)) {
                return Optional.of(o);
            }
        }
        return Optional.empty();
    }
}

