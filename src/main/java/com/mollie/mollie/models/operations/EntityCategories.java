/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.mollie.mollie.models.operations;

import com.fasterxml.jackson.annotation.JsonValue;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

public enum EntityCategories {
    MEAL("meal"),
    ECO("eco"),
    GIFT("gift"),
    SPORT_CULTURE("sport_culture");

    @JsonValue
    private final String value;

    EntityCategories(String value) {
        this.value = value;
    }
    
    public String value() {
        return value;
    }
    
    public static Optional<EntityCategories> fromValue(String value) {
        for (EntityCategories o: EntityCategories.values()) {
            if (Objects.deepEquals(o.value, value)) {
                return Optional.of(o);
            }
        }
        return Optional.empty();
    }
}

