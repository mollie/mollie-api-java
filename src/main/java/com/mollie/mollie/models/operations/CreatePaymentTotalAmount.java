/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.mollie.mollie.models.operations;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mollie.mollie.utils.Utils;
import java.lang.Override;
import java.lang.String;

/**
 * CreatePaymentTotalAmount
 * 
 * <p>The total amount of the line, including VAT and discounts.
 * 
 * <p>Should match the following formula: `(unitPrice × quantity) - discountAmount`.
 * 
 * <p>The sum of all `totalAmount` values of all order lines should be equal to the full payment amount.
 */
public class CreatePaymentTotalAmount {
    /**
     * A three-character ISO 4217 currency code.
     */
    @JsonProperty("currency")
    private String currency;

    /**
     * A string containing an exact monetary amount in the given currency.
     */
    @JsonProperty("value")
    private String value;

    @JsonCreator
    public CreatePaymentTotalAmount(
            @JsonProperty("currency") String currency,
            @JsonProperty("value") String value) {
        Utils.checkNotNull(currency, "currency");
        Utils.checkNotNull(value, "value");
        this.currency = currency;
        this.value = value;
    }

    /**
     * A three-character ISO 4217 currency code.
     */
    @JsonIgnore
    public String currency() {
        return currency;
    }

    /**
     * A string containing an exact monetary amount in the given currency.
     */
    @JsonIgnore
    public String value() {
        return value;
    }

    public static Builder builder() {
        return new Builder();
    }


    /**
     * A three-character ISO 4217 currency code.
     */
    public CreatePaymentTotalAmount withCurrency(String currency) {
        Utils.checkNotNull(currency, "currency");
        this.currency = currency;
        return this;
    }

    /**
     * A string containing an exact monetary amount in the given currency.
     */
    public CreatePaymentTotalAmount withValue(String value) {
        Utils.checkNotNull(value, "value");
        this.value = value;
        return this;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CreatePaymentTotalAmount other = (CreatePaymentTotalAmount) o;
        return 
            Utils.enhancedDeepEquals(this.currency, other.currency) &&
            Utils.enhancedDeepEquals(this.value, other.value);
    }
    
    @Override
    public int hashCode() {
        return Utils.enhancedHash(
            currency, value);
    }
    
    @Override
    public String toString() {
        return Utils.toString(CreatePaymentTotalAmount.class,
                "currency", currency,
                "value", value);
    }

    @SuppressWarnings("UnusedReturnValue")
    public final static class Builder {

        private String currency;

        private String value;

        private Builder() {
          // force use of static builder() method
        }


        /**
         * A three-character ISO 4217 currency code.
         */
        public Builder currency(String currency) {
            Utils.checkNotNull(currency, "currency");
            this.currency = currency;
            return this;
        }


        /**
         * A string containing an exact monetary amount in the given currency.
         */
        public Builder value(String value) {
            Utils.checkNotNull(value, "value");
            this.value = value;
            return this;
        }

        public CreatePaymentTotalAmount build() {

            return new CreatePaymentTotalAmount(
                currency, value);
        }

    }
}
