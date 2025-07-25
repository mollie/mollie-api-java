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
import java.util.Optional;


public class PostPaymentSplitPayment {

    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("paymentId")
    private Optional<String> paymentId;

    @JsonCreator
    public PostPaymentSplitPayment(
            @JsonProperty("paymentId") Optional<String> paymentId) {
        Utils.checkNotNull(paymentId, "paymentId");
        this.paymentId = paymentId;
    }
    
    public PostPaymentSplitPayment() {
        this(Optional.empty());
    }

    @JsonIgnore
    public Optional<String> paymentId() {
        return paymentId;
    }

    public static Builder builder() {
        return new Builder();
    }


    public PostPaymentSplitPayment withPaymentId(String paymentId) {
        Utils.checkNotNull(paymentId, "paymentId");
        this.paymentId = Optional.ofNullable(paymentId);
        return this;
    }


    public PostPaymentSplitPayment withPaymentId(Optional<String> paymentId) {
        Utils.checkNotNull(paymentId, "paymentId");
        this.paymentId = paymentId;
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
        PostPaymentSplitPayment other = (PostPaymentSplitPayment) o;
        return 
            Utils.enhancedDeepEquals(this.paymentId, other.paymentId);
    }
    
    @Override
    public int hashCode() {
        return Utils.enhancedHash(
            paymentId);
    }
    
    @Override
    public String toString() {
        return Utils.toString(PostPaymentSplitPayment.class,
                "paymentId", paymentId);
    }

    @SuppressWarnings("UnusedReturnValue")
    public final static class Builder {

        private Optional<String> paymentId = Optional.empty();

        private Builder() {
          // force use of static builder() method
        }


        public Builder paymentId(String paymentId) {
            Utils.checkNotNull(paymentId, "paymentId");
            this.paymentId = Optional.ofNullable(paymentId);
            return this;
        }

        public Builder paymentId(Optional<String> paymentId) {
            Utils.checkNotNull(paymentId, "paymentId");
            this.paymentId = paymentId;
            return this;
        }

        public PostPaymentSplitPayment build() {

            return new PostPaymentSplitPayment(
                paymentId);
        }

    }
}
