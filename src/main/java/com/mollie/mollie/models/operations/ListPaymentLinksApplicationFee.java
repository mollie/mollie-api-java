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
 * ListPaymentLinksApplicationFee
 * 
 * <p>With Mollie Connect you can charge fees on payment links that your app is processing on behalf of other Mollie merchants.
 * 
 * <p>If you use OAuth to create payment links on a connected merchant's account, you can charge a fee using this `applicationFee` parameter. If a payment on the payment link succeeds, the fee will be deducted from the merchant's balance and sent to your own account balance.
 */
public class ListPaymentLinksApplicationFee {
    /**
     * The fee that you wish to charge.
     * 
     * <p>Be careful to leave enough space for Mollie's own fees to be deducted as well. For example, you cannot charge a €0.99 fee on a €1.00 payment.
     */
    @JsonProperty("amount")
    private ListPaymentLinksPaymentLinksAmount amount;

    /**
     * The description of the application fee. This will appear on settlement reports towards both you and the connected merchant.
     */
    @JsonProperty("description")
    private String description;

    @JsonCreator
    public ListPaymentLinksApplicationFee(
            @JsonProperty("amount") ListPaymentLinksPaymentLinksAmount amount,
            @JsonProperty("description") String description) {
        Utils.checkNotNull(amount, "amount");
        Utils.checkNotNull(description, "description");
        this.amount = amount;
        this.description = description;
    }

    /**
     * The fee that you wish to charge.
     * 
     * <p>Be careful to leave enough space for Mollie's own fees to be deducted as well. For example, you cannot charge a €0.99 fee on a €1.00 payment.
     */
    @JsonIgnore
    public ListPaymentLinksPaymentLinksAmount amount() {
        return amount;
    }

    /**
     * The description of the application fee. This will appear on settlement reports towards both you and the connected merchant.
     */
    @JsonIgnore
    public String description() {
        return description;
    }

    public static Builder builder() {
        return new Builder();
    }


    /**
     * The fee that you wish to charge.
     * 
     * <p>Be careful to leave enough space for Mollie's own fees to be deducted as well. For example, you cannot charge a €0.99 fee on a €1.00 payment.
     */
    public ListPaymentLinksApplicationFee withAmount(ListPaymentLinksPaymentLinksAmount amount) {
        Utils.checkNotNull(amount, "amount");
        this.amount = amount;
        return this;
    }

    /**
     * The description of the application fee. This will appear on settlement reports towards both you and the connected merchant.
     */
    public ListPaymentLinksApplicationFee withDescription(String description) {
        Utils.checkNotNull(description, "description");
        this.description = description;
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
        ListPaymentLinksApplicationFee other = (ListPaymentLinksApplicationFee) o;
        return 
            Utils.enhancedDeepEquals(this.amount, other.amount) &&
            Utils.enhancedDeepEquals(this.description, other.description);
    }
    
    @Override
    public int hashCode() {
        return Utils.enhancedHash(
            amount, description);
    }
    
    @Override
    public String toString() {
        return Utils.toString(ListPaymentLinksApplicationFee.class,
                "amount", amount,
                "description", description);
    }

    @SuppressWarnings("UnusedReturnValue")
    public final static class Builder {

        private ListPaymentLinksPaymentLinksAmount amount;

        private String description;

        private Builder() {
          // force use of static builder() method
        }


        /**
         * The fee that you wish to charge.
         * 
         * <p>Be careful to leave enough space for Mollie's own fees to be deducted as well. For example, you cannot charge a €0.99 fee on a €1.00 payment.
         */
        public Builder amount(ListPaymentLinksPaymentLinksAmount amount) {
            Utils.checkNotNull(amount, "amount");
            this.amount = amount;
            return this;
        }


        /**
         * The description of the application fee. This will appear on settlement reports towards both you and the connected merchant.
         */
        public Builder description(String description) {
            Utils.checkNotNull(description, "description");
            this.description = description;
            return this;
        }

        public ListPaymentLinksApplicationFee build() {

            return new ListPaymentLinksApplicationFee(
                amount, description);
        }

    }
}
