/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.mollie.mollie.models.operations;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mollie.mollie.utils.Utils;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import org.openapitools.jackson.nullable.JsonNullable;


public class UpdateSalesInvoiceLines {
    /**
     * A description of the line item. For example *LEGO 4440 Forest Police Station*.
     */
    @JsonProperty("description")
    private String description;

    /**
     * The number of items.
     */
    @JsonProperty("quantity")
    private long quantity;

    /**
     * The vat rate to be applied to this line item.
     */
    @JsonProperty("vatRate")
    private String vatRate;

    /**
     * The price of a single item excluding VAT.
     * 
     * <p>For example: `{"currency":"EUR", "value":"89.00"}` if the box of LEGO costs €89.00 each.
     * 
     * <p>The unit price can be zero in case of free items.
     */
    @JsonProperty("unitPrice")
    private UpdateSalesInvoiceUnitPrice unitPrice;

    /**
     * The discount to be applied to the line item.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("discount")
    private JsonNullable<? extends UpdateSalesInvoiceDiscount> discount;

    @JsonCreator
    public UpdateSalesInvoiceLines(
            @JsonProperty("description") String description,
            @JsonProperty("quantity") long quantity,
            @JsonProperty("vatRate") String vatRate,
            @JsonProperty("unitPrice") UpdateSalesInvoiceUnitPrice unitPrice,
            @JsonProperty("discount") JsonNullable<? extends UpdateSalesInvoiceDiscount> discount) {
        Utils.checkNotNull(description, "description");
        Utils.checkNotNull(quantity, "quantity");
        Utils.checkNotNull(vatRate, "vatRate");
        Utils.checkNotNull(unitPrice, "unitPrice");
        Utils.checkNotNull(discount, "discount");
        this.description = description;
        this.quantity = quantity;
        this.vatRate = vatRate;
        this.unitPrice = unitPrice;
        this.discount = discount;
    }
    
    public UpdateSalesInvoiceLines(
            String description,
            long quantity,
            String vatRate,
            UpdateSalesInvoiceUnitPrice unitPrice) {
        this(description, quantity, vatRate,
            unitPrice, JsonNullable.undefined());
    }

    /**
     * A description of the line item. For example *LEGO 4440 Forest Police Station*.
     */
    @JsonIgnore
    public String description() {
        return description;
    }

    /**
     * The number of items.
     */
    @JsonIgnore
    public long quantity() {
        return quantity;
    }

    /**
     * The vat rate to be applied to this line item.
     */
    @JsonIgnore
    public String vatRate() {
        return vatRate;
    }

    /**
     * The price of a single item excluding VAT.
     * 
     * <p>For example: `{"currency":"EUR", "value":"89.00"}` if the box of LEGO costs €89.00 each.
     * 
     * <p>The unit price can be zero in case of free items.
     */
    @JsonIgnore
    public UpdateSalesInvoiceUnitPrice unitPrice() {
        return unitPrice;
    }

    /**
     * The discount to be applied to the line item.
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public JsonNullable<UpdateSalesInvoiceDiscount> discount() {
        return (JsonNullable<UpdateSalesInvoiceDiscount>) discount;
    }

    public static Builder builder() {
        return new Builder();
    }


    /**
     * A description of the line item. For example *LEGO 4440 Forest Police Station*.
     */
    public UpdateSalesInvoiceLines withDescription(String description) {
        Utils.checkNotNull(description, "description");
        this.description = description;
        return this;
    }

    /**
     * The number of items.
     */
    public UpdateSalesInvoiceLines withQuantity(long quantity) {
        Utils.checkNotNull(quantity, "quantity");
        this.quantity = quantity;
        return this;
    }

    /**
     * The vat rate to be applied to this line item.
     */
    public UpdateSalesInvoiceLines withVatRate(String vatRate) {
        Utils.checkNotNull(vatRate, "vatRate");
        this.vatRate = vatRate;
        return this;
    }

    /**
     * The price of a single item excluding VAT.
     * 
     * <p>For example: `{"currency":"EUR", "value":"89.00"}` if the box of LEGO costs €89.00 each.
     * 
     * <p>The unit price can be zero in case of free items.
     */
    public UpdateSalesInvoiceLines withUnitPrice(UpdateSalesInvoiceUnitPrice unitPrice) {
        Utils.checkNotNull(unitPrice, "unitPrice");
        this.unitPrice = unitPrice;
        return this;
    }

    /**
     * The discount to be applied to the line item.
     */
    public UpdateSalesInvoiceLines withDiscount(UpdateSalesInvoiceDiscount discount) {
        Utils.checkNotNull(discount, "discount");
        this.discount = JsonNullable.of(discount);
        return this;
    }

    /**
     * The discount to be applied to the line item.
     */
    public UpdateSalesInvoiceLines withDiscount(JsonNullable<? extends UpdateSalesInvoiceDiscount> discount) {
        Utils.checkNotNull(discount, "discount");
        this.discount = discount;
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
        UpdateSalesInvoiceLines other = (UpdateSalesInvoiceLines) o;
        return 
            Utils.enhancedDeepEquals(this.description, other.description) &&
            Utils.enhancedDeepEquals(this.quantity, other.quantity) &&
            Utils.enhancedDeepEquals(this.vatRate, other.vatRate) &&
            Utils.enhancedDeepEquals(this.unitPrice, other.unitPrice) &&
            Utils.enhancedDeepEquals(this.discount, other.discount);
    }
    
    @Override
    public int hashCode() {
        return Utils.enhancedHash(
            description, quantity, vatRate,
            unitPrice, discount);
    }
    
    @Override
    public String toString() {
        return Utils.toString(UpdateSalesInvoiceLines.class,
                "description", description,
                "quantity", quantity,
                "vatRate", vatRate,
                "unitPrice", unitPrice,
                "discount", discount);
    }

    @SuppressWarnings("UnusedReturnValue")
    public final static class Builder {

        private String description;

        private Long quantity;

        private String vatRate;

        private UpdateSalesInvoiceUnitPrice unitPrice;

        private JsonNullable<? extends UpdateSalesInvoiceDiscount> discount = JsonNullable.undefined();

        private Builder() {
          // force use of static builder() method
        }


        /**
         * A description of the line item. For example *LEGO 4440 Forest Police Station*.
         */
        public Builder description(String description) {
            Utils.checkNotNull(description, "description");
            this.description = description;
            return this;
        }


        /**
         * The number of items.
         */
        public Builder quantity(long quantity) {
            Utils.checkNotNull(quantity, "quantity");
            this.quantity = quantity;
            return this;
        }


        /**
         * The vat rate to be applied to this line item.
         */
        public Builder vatRate(String vatRate) {
            Utils.checkNotNull(vatRate, "vatRate");
            this.vatRate = vatRate;
            return this;
        }


        /**
         * The price of a single item excluding VAT.
         * 
         * <p>For example: `{"currency":"EUR", "value":"89.00"}` if the box of LEGO costs €89.00 each.
         * 
         * <p>The unit price can be zero in case of free items.
         */
        public Builder unitPrice(UpdateSalesInvoiceUnitPrice unitPrice) {
            Utils.checkNotNull(unitPrice, "unitPrice");
            this.unitPrice = unitPrice;
            return this;
        }


        /**
         * The discount to be applied to the line item.
         */
        public Builder discount(UpdateSalesInvoiceDiscount discount) {
            Utils.checkNotNull(discount, "discount");
            this.discount = JsonNullable.of(discount);
            return this;
        }

        /**
         * The discount to be applied to the line item.
         */
        public Builder discount(JsonNullable<? extends UpdateSalesInvoiceDiscount> discount) {
            Utils.checkNotNull(discount, "discount");
            this.discount = discount;
            return this;
        }

        public UpdateSalesInvoiceLines build() {

            return new UpdateSalesInvoiceLines(
                description, quantity, vatRate,
                unitPrice, discount);
        }

    }
}
