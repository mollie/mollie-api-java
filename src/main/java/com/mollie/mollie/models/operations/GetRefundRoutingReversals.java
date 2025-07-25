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
import java.util.Optional;


public class GetRefundRoutingReversals {
    /**
     * The amount that will be pulled back.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("amount")
    private Optional<? extends GetRefundRefundsAmount> amount;

    /**
     * Where the funds will be pulled back from.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("source")
    private Optional<? extends GetRefundSource> source;

    @JsonCreator
    public GetRefundRoutingReversals(
            @JsonProperty("amount") Optional<? extends GetRefundRefundsAmount> amount,
            @JsonProperty("source") Optional<? extends GetRefundSource> source) {
        Utils.checkNotNull(amount, "amount");
        Utils.checkNotNull(source, "source");
        this.amount = amount;
        this.source = source;
    }
    
    public GetRefundRoutingReversals() {
        this(Optional.empty(), Optional.empty());
    }

    /**
     * The amount that will be pulled back.
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<GetRefundRefundsAmount> amount() {
        return (Optional<GetRefundRefundsAmount>) amount;
    }

    /**
     * Where the funds will be pulled back from.
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<GetRefundSource> source() {
        return (Optional<GetRefundSource>) source;
    }

    public static Builder builder() {
        return new Builder();
    }


    /**
     * The amount that will be pulled back.
     */
    public GetRefundRoutingReversals withAmount(GetRefundRefundsAmount amount) {
        Utils.checkNotNull(amount, "amount");
        this.amount = Optional.ofNullable(amount);
        return this;
    }


    /**
     * The amount that will be pulled back.
     */
    public GetRefundRoutingReversals withAmount(Optional<? extends GetRefundRefundsAmount> amount) {
        Utils.checkNotNull(amount, "amount");
        this.amount = amount;
        return this;
    }

    /**
     * Where the funds will be pulled back from.
     */
    public GetRefundRoutingReversals withSource(GetRefundSource source) {
        Utils.checkNotNull(source, "source");
        this.source = Optional.ofNullable(source);
        return this;
    }


    /**
     * Where the funds will be pulled back from.
     */
    public GetRefundRoutingReversals withSource(Optional<? extends GetRefundSource> source) {
        Utils.checkNotNull(source, "source");
        this.source = source;
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
        GetRefundRoutingReversals other = (GetRefundRoutingReversals) o;
        return 
            Utils.enhancedDeepEquals(this.amount, other.amount) &&
            Utils.enhancedDeepEquals(this.source, other.source);
    }
    
    @Override
    public int hashCode() {
        return Utils.enhancedHash(
            amount, source);
    }
    
    @Override
    public String toString() {
        return Utils.toString(GetRefundRoutingReversals.class,
                "amount", amount,
                "source", source);
    }

    @SuppressWarnings("UnusedReturnValue")
    public final static class Builder {

        private Optional<? extends GetRefundRefundsAmount> amount = Optional.empty();

        private Optional<? extends GetRefundSource> source = Optional.empty();

        private Builder() {
          // force use of static builder() method
        }


        /**
         * The amount that will be pulled back.
         */
        public Builder amount(GetRefundRefundsAmount amount) {
            Utils.checkNotNull(amount, "amount");
            this.amount = Optional.ofNullable(amount);
            return this;
        }

        /**
         * The amount that will be pulled back.
         */
        public Builder amount(Optional<? extends GetRefundRefundsAmount> amount) {
            Utils.checkNotNull(amount, "amount");
            this.amount = amount;
            return this;
        }


        /**
         * Where the funds will be pulled back from.
         */
        public Builder source(GetRefundSource source) {
            Utils.checkNotNull(source, "source");
            this.source = Optional.ofNullable(source);
            return this;
        }

        /**
         * Where the funds will be pulled back from.
         */
        public Builder source(Optional<? extends GetRefundSource> source) {
            Utils.checkNotNull(source, "source");
            this.source = source;
            return this;
        }

        public GetRefundRoutingReversals build() {

            return new GetRefundRoutingReversals(
                amount, source);
        }

    }
}
