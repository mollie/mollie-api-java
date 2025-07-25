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
 * ListSubscriptionPaymentsStatusReason
 * 
 * <p>This object offers details about the status of a payment. Currently it is only available for point-of-sale payments.
 * 
 * <p>You can find more information about the possible values of this object on [this page](status-reasons).**
 */
public class ListSubscriptionPaymentsStatusReason {
    /**
     * A machine-readable code that indicates the reason for the payment's status.
     */
    @JsonProperty("code")
    private String code;

    /**
     * A description of the status reason, localized according to the payment `locale`.
     */
    @JsonProperty("message")
    private String message;

    @JsonCreator
    public ListSubscriptionPaymentsStatusReason(
            @JsonProperty("code") String code,
            @JsonProperty("message") String message) {
        Utils.checkNotNull(code, "code");
        Utils.checkNotNull(message, "message");
        this.code = code;
        this.message = message;
    }

    /**
     * A machine-readable code that indicates the reason for the payment's status.
     */
    @JsonIgnore
    public String code() {
        return code;
    }

    /**
     * A description of the status reason, localized according to the payment `locale`.
     */
    @JsonIgnore
    public String message() {
        return message;
    }

    public static Builder builder() {
        return new Builder();
    }


    /**
     * A machine-readable code that indicates the reason for the payment's status.
     */
    public ListSubscriptionPaymentsStatusReason withCode(String code) {
        Utils.checkNotNull(code, "code");
        this.code = code;
        return this;
    }

    /**
     * A description of the status reason, localized according to the payment `locale`.
     */
    public ListSubscriptionPaymentsStatusReason withMessage(String message) {
        Utils.checkNotNull(message, "message");
        this.message = message;
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
        ListSubscriptionPaymentsStatusReason other = (ListSubscriptionPaymentsStatusReason) o;
        return 
            Utils.enhancedDeepEquals(this.code, other.code) &&
            Utils.enhancedDeepEquals(this.message, other.message);
    }
    
    @Override
    public int hashCode() {
        return Utils.enhancedHash(
            code, message);
    }
    
    @Override
    public String toString() {
        return Utils.toString(ListSubscriptionPaymentsStatusReason.class,
                "code", code,
                "message", message);
    }

    @SuppressWarnings("UnusedReturnValue")
    public final static class Builder {

        private String code;

        private String message;

        private Builder() {
          // force use of static builder() method
        }


        /**
         * A machine-readable code that indicates the reason for the payment's status.
         */
        public Builder code(String code) {
            Utils.checkNotNull(code, "code");
            this.code = code;
            return this;
        }


        /**
         * A description of the status reason, localized according to the payment `locale`.
         */
        public Builder message(String message) {
            Utils.checkNotNull(message, "message");
            this.message = message;
            return this;
        }

        public ListSubscriptionPaymentsStatusReason build() {

            return new ListSubscriptionPaymentsStatusReason(
                code, message);
        }

    }
}
