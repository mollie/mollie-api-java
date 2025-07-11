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


public class ListAllRefundsRoutingReversals {
    /**
     * The amount that will be pulled back.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("amount")
    private Optional<? extends ListAllRefundsRefundsAmount> amount;

    /**
     * Where the funds will be pulled back from.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("source")
    private Optional<? extends ListAllRefundsSource> source;

    @JsonCreator
    public ListAllRefundsRoutingReversals(
            @JsonProperty("amount") Optional<? extends ListAllRefundsRefundsAmount> amount,
            @JsonProperty("source") Optional<? extends ListAllRefundsSource> source) {
        Utils.checkNotNull(amount, "amount");
        Utils.checkNotNull(source, "source");
        this.amount = amount;
        this.source = source;
    }
    
    public ListAllRefundsRoutingReversals() {
        this(Optional.empty(), Optional.empty());
    }

    /**
     * The amount that will be pulled back.
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<ListAllRefundsRefundsAmount> amount() {
        return (Optional<ListAllRefundsRefundsAmount>) amount;
    }

    /**
     * Where the funds will be pulled back from.
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<ListAllRefundsSource> source() {
        return (Optional<ListAllRefundsSource>) source;
    }

    public static Builder builder() {
        return new Builder();
    }


    /**
     * The amount that will be pulled back.
     */
    public ListAllRefundsRoutingReversals withAmount(ListAllRefundsRefundsAmount amount) {
        Utils.checkNotNull(amount, "amount");
        this.amount = Optional.ofNullable(amount);
        return this;
    }


    /**
     * The amount that will be pulled back.
     */
    public ListAllRefundsRoutingReversals withAmount(Optional<? extends ListAllRefundsRefundsAmount> amount) {
        Utils.checkNotNull(amount, "amount");
        this.amount = amount;
        return this;
    }

    /**
     * Where the funds will be pulled back from.
     */
    public ListAllRefundsRoutingReversals withSource(ListAllRefundsSource source) {
        Utils.checkNotNull(source, "source");
        this.source = Optional.ofNullable(source);
        return this;
    }


    /**
     * Where the funds will be pulled back from.
     */
    public ListAllRefundsRoutingReversals withSource(Optional<? extends ListAllRefundsSource> source) {
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
        ListAllRefundsRoutingReversals other = (ListAllRefundsRoutingReversals) o;
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
        return Utils.toString(ListAllRefundsRoutingReversals.class,
                "amount", amount,
                "source", source);
    }

    @SuppressWarnings("UnusedReturnValue")
    public final static class Builder {

        private Optional<? extends ListAllRefundsRefundsAmount> amount = Optional.empty();

        private Optional<? extends ListAllRefundsSource> source = Optional.empty();

        private Builder() {
          // force use of static builder() method
        }


        /**
         * The amount that will be pulled back.
         */
        public Builder amount(ListAllRefundsRefundsAmount amount) {
            Utils.checkNotNull(amount, "amount");
            this.amount = Optional.ofNullable(amount);
            return this;
        }

        /**
         * The amount that will be pulled back.
         */
        public Builder amount(Optional<? extends ListAllRefundsRefundsAmount> amount) {
            Utils.checkNotNull(amount, "amount");
            this.amount = amount;
            return this;
        }


        /**
         * Where the funds will be pulled back from.
         */
        public Builder source(ListAllRefundsSource source) {
            Utils.checkNotNull(source, "source");
            this.source = Optional.ofNullable(source);
            return this;
        }

        /**
         * Where the funds will be pulled back from.
         */
        public Builder source(Optional<? extends ListAllRefundsSource> source) {
            Utils.checkNotNull(source, "source");
            this.source = source;
            return this;
        }

        public ListAllRefundsRoutingReversals build() {

            return new ListAllRefundsRoutingReversals(
                amount, source);
        }

    }
}
