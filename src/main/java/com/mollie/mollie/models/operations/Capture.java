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


public class Capture {

    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("paymentId")
    private Optional<String> paymentId;


    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("captureId")
    private Optional<String> captureId;

    @JsonCreator
    public Capture(
            @JsonProperty("paymentId") Optional<String> paymentId,
            @JsonProperty("captureId") Optional<String> captureId) {
        Utils.checkNotNull(paymentId, "paymentId");
        Utils.checkNotNull(captureId, "captureId");
        this.paymentId = paymentId;
        this.captureId = captureId;
    }
    
    public Capture() {
        this(Optional.empty(), Optional.empty());
    }

    @JsonIgnore
    public Optional<String> paymentId() {
        return paymentId;
    }

    @JsonIgnore
    public Optional<String> captureId() {
        return captureId;
    }

    public static Builder builder() {
        return new Builder();
    }


    public Capture withPaymentId(String paymentId) {
        Utils.checkNotNull(paymentId, "paymentId");
        this.paymentId = Optional.ofNullable(paymentId);
        return this;
    }


    public Capture withPaymentId(Optional<String> paymentId) {
        Utils.checkNotNull(paymentId, "paymentId");
        this.paymentId = paymentId;
        return this;
    }

    public Capture withCaptureId(String captureId) {
        Utils.checkNotNull(captureId, "captureId");
        this.captureId = Optional.ofNullable(captureId);
        return this;
    }


    public Capture withCaptureId(Optional<String> captureId) {
        Utils.checkNotNull(captureId, "captureId");
        this.captureId = captureId;
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
        Capture other = (Capture) o;
        return 
            Utils.enhancedDeepEquals(this.paymentId, other.paymentId) &&
            Utils.enhancedDeepEquals(this.captureId, other.captureId);
    }
    
    @Override
    public int hashCode() {
        return Utils.enhancedHash(
            paymentId, captureId);
    }
    
    @Override
    public String toString() {
        return Utils.toString(Capture.class,
                "paymentId", paymentId,
                "captureId", captureId);
    }

    @SuppressWarnings("UnusedReturnValue")
    public final static class Builder {

        private Optional<String> paymentId = Optional.empty();

        private Optional<String> captureId = Optional.empty();

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


        public Builder captureId(String captureId) {
            Utils.checkNotNull(captureId, "captureId");
            this.captureId = Optional.ofNullable(captureId);
            return this;
        }

        public Builder captureId(Optional<String> captureId) {
            Utils.checkNotNull(captureId, "captureId");
            this.captureId = captureId;
            return this;
        }

        public Capture build() {

            return new Capture(
                paymentId, captureId);
        }

    }
}
