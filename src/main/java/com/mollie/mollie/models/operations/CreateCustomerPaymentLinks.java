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
import java.util.Objects;
import java.util.Optional;

/**
 * CreateCustomerPaymentLinks
 * 
 * <p>An object with several relevant URLs. Every URL object will contain an `href` and a `type` field.
 */
public class CreateCustomerPaymentLinks {

    /**
     * In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("self")
    private Optional<? extends CreateCustomerPaymentSelf> self;

    /**
     * The API resource URL of the [payment](get-payment) that belong to this route.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("payment")
    private Optional<? extends CreateCustomerPaymentPayment> payment;

    @JsonCreator
    public CreateCustomerPaymentLinks(
            @JsonProperty("self") Optional<? extends CreateCustomerPaymentSelf> self,
            @JsonProperty("payment") Optional<? extends CreateCustomerPaymentPayment> payment) {
        Utils.checkNotNull(self, "self");
        Utils.checkNotNull(payment, "payment");
        this.self = self;
        this.payment = payment;
    }
    
    public CreateCustomerPaymentLinks() {
        this(Optional.empty(), Optional.empty());
    }

    /**
     * In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field.
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<CreateCustomerPaymentSelf> self() {
        return (Optional<CreateCustomerPaymentSelf>) self;
    }

    /**
     * The API resource URL of the [payment](get-payment) that belong to this route.
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<CreateCustomerPaymentPayment> payment() {
        return (Optional<CreateCustomerPaymentPayment>) payment;
    }

    public final static Builder builder() {
        return new Builder();
    }    

    /**
     * In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field.
     */
    public CreateCustomerPaymentLinks withSelf(CreateCustomerPaymentSelf self) {
        Utils.checkNotNull(self, "self");
        this.self = Optional.ofNullable(self);
        return this;
    }

    /**
     * In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field.
     */
    public CreateCustomerPaymentLinks withSelf(Optional<? extends CreateCustomerPaymentSelf> self) {
        Utils.checkNotNull(self, "self");
        this.self = self;
        return this;
    }

    /**
     * The API resource URL of the [payment](get-payment) that belong to this route.
     */
    public CreateCustomerPaymentLinks withPayment(CreateCustomerPaymentPayment payment) {
        Utils.checkNotNull(payment, "payment");
        this.payment = Optional.ofNullable(payment);
        return this;
    }

    /**
     * The API resource URL of the [payment](get-payment) that belong to this route.
     */
    public CreateCustomerPaymentLinks withPayment(Optional<? extends CreateCustomerPaymentPayment> payment) {
        Utils.checkNotNull(payment, "payment");
        this.payment = payment;
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
        CreateCustomerPaymentLinks other = (CreateCustomerPaymentLinks) o;
        return 
            Objects.deepEquals(this.self, other.self) &&
            Objects.deepEquals(this.payment, other.payment);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(
            self,
            payment);
    }
    
    @Override
    public String toString() {
        return Utils.toString(CreateCustomerPaymentLinks.class,
                "self", self,
                "payment", payment);
    }
    
    public final static class Builder {
 
        private Optional<? extends CreateCustomerPaymentSelf> self = Optional.empty();
 
        private Optional<? extends CreateCustomerPaymentPayment> payment = Optional.empty();
        
        private Builder() {
          // force use of static builder() method
        }

        /**
         * In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field.
         */
        public Builder self(CreateCustomerPaymentSelf self) {
            Utils.checkNotNull(self, "self");
            this.self = Optional.ofNullable(self);
            return this;
        }

        /**
         * In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field.
         */
        public Builder self(Optional<? extends CreateCustomerPaymentSelf> self) {
            Utils.checkNotNull(self, "self");
            this.self = self;
            return this;
        }

        /**
         * The API resource URL of the [payment](get-payment) that belong to this route.
         */
        public Builder payment(CreateCustomerPaymentPayment payment) {
            Utils.checkNotNull(payment, "payment");
            this.payment = Optional.ofNullable(payment);
            return this;
        }

        /**
         * The API resource URL of the [payment](get-payment) that belong to this route.
         */
        public Builder payment(Optional<? extends CreateCustomerPaymentPayment> payment) {
            Utils.checkNotNull(payment, "payment");
            this.payment = payment;
            return this;
        }
        
        public CreateCustomerPaymentLinks build() {
            return new CreateCustomerPaymentLinks(
                self,
                payment);
        }
    }
}
