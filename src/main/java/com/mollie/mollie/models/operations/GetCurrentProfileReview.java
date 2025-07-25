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

/**
 * GetCurrentProfileReview
 * 
 * <p>Present if changes have been made that have not yet been approved by Mollie. Changes to test profiles are approved automatically, unless a switch to a live profile has been requested. The review object will therefore usually be `null` in test mode.
 */
public class GetCurrentProfileReview {
    /**
     * The status of the requested changes.
     * 
     * <p>Possible values: `pending` `rejected`
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("status")
    private Optional<String> status;

    @JsonCreator
    public GetCurrentProfileReview(
            @JsonProperty("status") Optional<String> status) {
        Utils.checkNotNull(status, "status");
        this.status = status;
    }
    
    public GetCurrentProfileReview() {
        this(Optional.empty());
    }

    /**
     * The status of the requested changes.
     * 
     * <p>Possible values: `pending` `rejected`
     */
    @JsonIgnore
    public Optional<String> status() {
        return status;
    }

    public static Builder builder() {
        return new Builder();
    }


    /**
     * The status of the requested changes.
     * 
     * <p>Possible values: `pending` `rejected`
     */
    public GetCurrentProfileReview withStatus(String status) {
        Utils.checkNotNull(status, "status");
        this.status = Optional.ofNullable(status);
        return this;
    }


    /**
     * The status of the requested changes.
     * 
     * <p>Possible values: `pending` `rejected`
     */
    public GetCurrentProfileReview withStatus(Optional<String> status) {
        Utils.checkNotNull(status, "status");
        this.status = status;
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
        GetCurrentProfileReview other = (GetCurrentProfileReview) o;
        return 
            Utils.enhancedDeepEquals(this.status, other.status);
    }
    
    @Override
    public int hashCode() {
        return Utils.enhancedHash(
            status);
    }
    
    @Override
    public String toString() {
        return Utils.toString(GetCurrentProfileReview.class,
                "status", status);
    }

    @SuppressWarnings("UnusedReturnValue")
    public final static class Builder {

        private Optional<String> status = Optional.empty();

        private Builder() {
          // force use of static builder() method
        }


        /**
         * The status of the requested changes.
         * 
         * <p>Possible values: `pending` `rejected`
         */
        public Builder status(String status) {
            Utils.checkNotNull(status, "status");
            this.status = Optional.ofNullable(status);
            return this;
        }

        /**
         * The status of the requested changes.
         * 
         * <p>Possible values: `pending` `rejected`
         */
        public Builder status(Optional<String> status) {
            Utils.checkNotNull(status, "status");
            this.status = status;
            return this;
        }

        public GetCurrentProfileReview build() {

            return new GetCurrentProfileReview(
                status);
        }

    }
}
