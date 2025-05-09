/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.mollie.mollie.models.operations;

import com.fasterxml.jackson.annotation.JsonValue;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

/**
 * GetSettlementCapturesQueryParamInclude
 * 
 * <p>This endpoint allows you to include additional information via the `include` query string parameter.
 */
public enum GetSettlementCapturesQueryParamInclude {
    PAYMENT("payment");

    @JsonValue
    private final String value;

    private GetSettlementCapturesQueryParamInclude(String value) {
        this.value = value;
    }
    
    public String value() {
        return value;
    }
    
    public static Optional<GetSettlementCapturesQueryParamInclude> fromValue(String value) {
        for (GetSettlementCapturesQueryParamInclude o: GetSettlementCapturesQueryParamInclude.values()) {
            if (Objects.deepEquals(o.value, value)) {
                return Optional.of(o);
            }
        }
        return Optional.empty();
    }
}

