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
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.List;
import java.util.Optional;


public class ListSettlementPaymentsEmbedded {
    /**
     * An array of payment objects.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("payments")
    private Optional<? extends List<ListSettlementPaymentsPayments>> payments;

    @JsonCreator
    public ListSettlementPaymentsEmbedded(
            @JsonProperty("payments") Optional<? extends List<ListSettlementPaymentsPayments>> payments) {
        Utils.checkNotNull(payments, "payments");
        this.payments = payments;
    }
    
    public ListSettlementPaymentsEmbedded() {
        this(Optional.empty());
    }

    /**
     * An array of payment objects.
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<List<ListSettlementPaymentsPayments>> payments() {
        return (Optional<List<ListSettlementPaymentsPayments>>) payments;
    }

    public static Builder builder() {
        return new Builder();
    }


    /**
     * An array of payment objects.
     */
    public ListSettlementPaymentsEmbedded withPayments(List<ListSettlementPaymentsPayments> payments) {
        Utils.checkNotNull(payments, "payments");
        this.payments = Optional.ofNullable(payments);
        return this;
    }


    /**
     * An array of payment objects.
     */
    public ListSettlementPaymentsEmbedded withPayments(Optional<? extends List<ListSettlementPaymentsPayments>> payments) {
        Utils.checkNotNull(payments, "payments");
        this.payments = payments;
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
        ListSettlementPaymentsEmbedded other = (ListSettlementPaymentsEmbedded) o;
        return 
            Utils.enhancedDeepEquals(this.payments, other.payments);
    }
    
    @Override
    public int hashCode() {
        return Utils.enhancedHash(
            payments);
    }
    
    @Override
    public String toString() {
        return Utils.toString(ListSettlementPaymentsEmbedded.class,
                "payments", payments);
    }

    @SuppressWarnings("UnusedReturnValue")
    public final static class Builder {

        private Optional<? extends List<ListSettlementPaymentsPayments>> payments = Optional.empty();

        private Builder() {
          // force use of static builder() method
        }


        /**
         * An array of payment objects.
         */
        public Builder payments(List<ListSettlementPaymentsPayments> payments) {
            Utils.checkNotNull(payments, "payments");
            this.payments = Optional.ofNullable(payments);
            return this;
        }

        /**
         * An array of payment objects.
         */
        public Builder payments(Optional<? extends List<ListSettlementPaymentsPayments>> payments) {
            Utils.checkNotNull(payments, "payments");
            this.payments = payments;
            return this;
        }

        public ListSettlementPaymentsEmbedded build() {

            return new ListSettlementPaymentsEmbedded(
                payments);
        }

    }
}
