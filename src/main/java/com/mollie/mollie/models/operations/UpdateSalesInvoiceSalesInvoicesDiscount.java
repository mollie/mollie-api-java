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
 * UpdateSalesInvoiceSalesInvoicesDiscount
 * 
 * <p>The discount to be applied to the entire invoice, possibly on top of the line item discounts.
 */
public class UpdateSalesInvoiceSalesInvoicesDiscount {
    /**
     * The type of discount.
     * 
     * <p>Possible values: `amount` `percentage`
     */
    @JsonProperty("type")
    private String type;

    /**
     * A string containing an exact monetary amount in the given currency, or the percentage.
     */
    @JsonProperty("value")
    private String value;

    @JsonCreator
    public UpdateSalesInvoiceSalesInvoicesDiscount(
            @JsonProperty("type") String type,
            @JsonProperty("value") String value) {
        Utils.checkNotNull(type, "type");
        Utils.checkNotNull(value, "value");
        this.type = type;
        this.value = value;
    }

    /**
     * The type of discount.
     * 
     * <p>Possible values: `amount` `percentage`
     */
    @JsonIgnore
    public String type() {
        return type;
    }

    /**
     * A string containing an exact monetary amount in the given currency, or the percentage.
     */
    @JsonIgnore
    public String value() {
        return value;
    }

    public static Builder builder() {
        return new Builder();
    }


    /**
     * The type of discount.
     * 
     * <p>Possible values: `amount` `percentage`
     */
    public UpdateSalesInvoiceSalesInvoicesDiscount withType(String type) {
        Utils.checkNotNull(type, "type");
        this.type = type;
        return this;
    }

    /**
     * A string containing an exact monetary amount in the given currency, or the percentage.
     */
    public UpdateSalesInvoiceSalesInvoicesDiscount withValue(String value) {
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
        UpdateSalesInvoiceSalesInvoicesDiscount other = (UpdateSalesInvoiceSalesInvoicesDiscount) o;
        return 
            Utils.enhancedDeepEquals(this.type, other.type) &&
            Utils.enhancedDeepEquals(this.value, other.value);
    }
    
    @Override
    public int hashCode() {
        return Utils.enhancedHash(
            type, value);
    }
    
    @Override
    public String toString() {
        return Utils.toString(UpdateSalesInvoiceSalesInvoicesDiscount.class,
                "type", type,
                "value", value);
    }

    @SuppressWarnings("UnusedReturnValue")
    public final static class Builder {

        private String type;

        private String value;

        private Builder() {
          // force use of static builder() method
        }


        /**
         * The type of discount.
         * 
         * <p>Possible values: `amount` `percentage`
         */
        public Builder type(String type) {
            Utils.checkNotNull(type, "type");
            this.type = type;
            return this;
        }


        /**
         * A string containing an exact monetary amount in the given currency, or the percentage.
         */
        public Builder value(String value) {
            Utils.checkNotNull(value, "value");
            this.value = value;
            return this;
        }

        public UpdateSalesInvoiceSalesInvoicesDiscount build() {

            return new UpdateSalesInvoiceSalesInvoicesDiscount(
                type, value);
        }

    }
}
