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
 * CreatePaymentLinkLinks
 * 
 * <p>An object with several relevant URLs. Every URL object will contain an `href` and a `type` field.
 */
public class CreatePaymentLinkLinks {
    /**
     * In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field.
     */
    @JsonProperty("self")
    private CreatePaymentLinkSelf self;

    /**
     * The URL your customer should visit to make the payment. This is where you should redirect the customer to.
     */
    @JsonProperty("paymentLink")
    private PaymentLink paymentLink;

    @JsonCreator
    public CreatePaymentLinkLinks(
            @JsonProperty("self") CreatePaymentLinkSelf self,
            @JsonProperty("paymentLink") PaymentLink paymentLink) {
        Utils.checkNotNull(self, "self");
        Utils.checkNotNull(paymentLink, "paymentLink");
        this.self = self;
        this.paymentLink = paymentLink;
    }

    /**
     * In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field.
     */
    @JsonIgnore
    public CreatePaymentLinkSelf self() {
        return self;
    }

    /**
     * The URL your customer should visit to make the payment. This is where you should redirect the customer to.
     */
    @JsonIgnore
    public PaymentLink paymentLink() {
        return paymentLink;
    }

    public static Builder builder() {
        return new Builder();
    }


    /**
     * In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field.
     */
    public CreatePaymentLinkLinks withSelf(CreatePaymentLinkSelf self) {
        Utils.checkNotNull(self, "self");
        this.self = self;
        return this;
    }

    /**
     * The URL your customer should visit to make the payment. This is where you should redirect the customer to.
     */
    public CreatePaymentLinkLinks withPaymentLink(PaymentLink paymentLink) {
        Utils.checkNotNull(paymentLink, "paymentLink");
        this.paymentLink = paymentLink;
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
        CreatePaymentLinkLinks other = (CreatePaymentLinkLinks) o;
        return 
            Utils.enhancedDeepEquals(this.self, other.self) &&
            Utils.enhancedDeepEquals(this.paymentLink, other.paymentLink);
    }
    
    @Override
    public int hashCode() {
        return Utils.enhancedHash(
            self, paymentLink);
    }
    
    @Override
    public String toString() {
        return Utils.toString(CreatePaymentLinkLinks.class,
                "self", self,
                "paymentLink", paymentLink);
    }

    @SuppressWarnings("UnusedReturnValue")
    public final static class Builder {

        private CreatePaymentLinkSelf self;

        private PaymentLink paymentLink;

        private Builder() {
          // force use of static builder() method
        }


        /**
         * In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field.
         */
        public Builder self(CreatePaymentLinkSelf self) {
            Utils.checkNotNull(self, "self");
            this.self = self;
            return this;
        }


        /**
         * The URL your customer should visit to make the payment. This is where you should redirect the customer to.
         */
        public Builder paymentLink(PaymentLink paymentLink) {
            Utils.checkNotNull(paymentLink, "paymentLink");
            this.paymentLink = paymentLink;
            return this;
        }

        public CreatePaymentLinkLinks build() {

            return new CreatePaymentLinkLinks(
                self, paymentLink);
        }

    }
}
