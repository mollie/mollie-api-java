/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.mollie.mollie.models.operations;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mollie.mollie.utils.SpeakeasyMetadata;
import com.mollie.mollie.utils.Utils;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Optional;


public class UpdatePaymentRequest {
    /**
     * Provide the ID of the related payment.
     */
    @SpeakeasyMetadata("pathParam:style=simple,explode=false,name=paymentId")
    private String paymentId;


    @SpeakeasyMetadata("request:mediaType=application/json")
    private Optional<? extends UpdatePaymentRequestBody> requestBody;

    @JsonCreator
    public UpdatePaymentRequest(
            String paymentId,
            Optional<? extends UpdatePaymentRequestBody> requestBody) {
        Utils.checkNotNull(paymentId, "paymentId");
        Utils.checkNotNull(requestBody, "requestBody");
        this.paymentId = paymentId;
        this.requestBody = requestBody;
    }
    
    public UpdatePaymentRequest(
            String paymentId) {
        this(paymentId, Optional.empty());
    }

    /**
     * Provide the ID of the related payment.
     */
    @JsonIgnore
    public String paymentId() {
        return paymentId;
    }

    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<UpdatePaymentRequestBody> requestBody() {
        return (Optional<UpdatePaymentRequestBody>) requestBody;
    }

    public static Builder builder() {
        return new Builder();
    }


    /**
     * Provide the ID of the related payment.
     */
    public UpdatePaymentRequest withPaymentId(String paymentId) {
        Utils.checkNotNull(paymentId, "paymentId");
        this.paymentId = paymentId;
        return this;
    }

    public UpdatePaymentRequest withRequestBody(UpdatePaymentRequestBody requestBody) {
        Utils.checkNotNull(requestBody, "requestBody");
        this.requestBody = Optional.ofNullable(requestBody);
        return this;
    }


    public UpdatePaymentRequest withRequestBody(Optional<? extends UpdatePaymentRequestBody> requestBody) {
        Utils.checkNotNull(requestBody, "requestBody");
        this.requestBody = requestBody;
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
        UpdatePaymentRequest other = (UpdatePaymentRequest) o;
        return 
            Utils.enhancedDeepEquals(this.paymentId, other.paymentId) &&
            Utils.enhancedDeepEquals(this.requestBody, other.requestBody);
    }
    
    @Override
    public int hashCode() {
        return Utils.enhancedHash(
            paymentId, requestBody);
    }
    
    @Override
    public String toString() {
        return Utils.toString(UpdatePaymentRequest.class,
                "paymentId", paymentId,
                "requestBody", requestBody);
    }

    @SuppressWarnings("UnusedReturnValue")
    public final static class Builder {

        private String paymentId;

        private Optional<? extends UpdatePaymentRequestBody> requestBody = Optional.empty();

        private Builder() {
          // force use of static builder() method
        }


        /**
         * Provide the ID of the related payment.
         */
        public Builder paymentId(String paymentId) {
            Utils.checkNotNull(paymentId, "paymentId");
            this.paymentId = paymentId;
            return this;
        }


        public Builder requestBody(UpdatePaymentRequestBody requestBody) {
            Utils.checkNotNull(requestBody, "requestBody");
            this.requestBody = Optional.ofNullable(requestBody);
            return this;
        }

        public Builder requestBody(Optional<? extends UpdatePaymentRequestBody> requestBody) {
            Utils.checkNotNull(requestBody, "requestBody");
            this.requestBody = requestBody;
            return this;
        }

        public UpdatePaymentRequest build() {

            return new UpdatePaymentRequest(
                paymentId, requestBody);
        }

    }
}
