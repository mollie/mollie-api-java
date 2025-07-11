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


public class GetSettlementCapturesEmbedded {
    /**
     * An array of capture objects.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("captures")
    private Optional<? extends List<GetSettlementCapturesCaptures>> captures;

    @JsonCreator
    public GetSettlementCapturesEmbedded(
            @JsonProperty("captures") Optional<? extends List<GetSettlementCapturesCaptures>> captures) {
        Utils.checkNotNull(captures, "captures");
        this.captures = captures;
    }
    
    public GetSettlementCapturesEmbedded() {
        this(Optional.empty());
    }

    /**
     * An array of capture objects.
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<List<GetSettlementCapturesCaptures>> captures() {
        return (Optional<List<GetSettlementCapturesCaptures>>) captures;
    }

    public static Builder builder() {
        return new Builder();
    }


    /**
     * An array of capture objects.
     */
    public GetSettlementCapturesEmbedded withCaptures(List<GetSettlementCapturesCaptures> captures) {
        Utils.checkNotNull(captures, "captures");
        this.captures = Optional.ofNullable(captures);
        return this;
    }


    /**
     * An array of capture objects.
     */
    public GetSettlementCapturesEmbedded withCaptures(Optional<? extends List<GetSettlementCapturesCaptures>> captures) {
        Utils.checkNotNull(captures, "captures");
        this.captures = captures;
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
        GetSettlementCapturesEmbedded other = (GetSettlementCapturesEmbedded) o;
        return 
            Utils.enhancedDeepEquals(this.captures, other.captures);
    }
    
    @Override
    public int hashCode() {
        return Utils.enhancedHash(
            captures);
    }
    
    @Override
    public String toString() {
        return Utils.toString(GetSettlementCapturesEmbedded.class,
                "captures", captures);
    }

    @SuppressWarnings("UnusedReturnValue")
    public final static class Builder {

        private Optional<? extends List<GetSettlementCapturesCaptures>> captures = Optional.empty();

        private Builder() {
          // force use of static builder() method
        }


        /**
         * An array of capture objects.
         */
        public Builder captures(List<GetSettlementCapturesCaptures> captures) {
            Utils.checkNotNull(captures, "captures");
            this.captures = Optional.ofNullable(captures);
            return this;
        }

        /**
         * An array of capture objects.
         */
        public Builder captures(Optional<? extends List<GetSettlementCapturesCaptures>> captures) {
            Utils.checkNotNull(captures, "captures");
            this.captures = captures;
            return this;
        }

        public GetSettlementCapturesEmbedded build() {

            return new GetSettlementCapturesEmbedded(
                captures);
        }

    }
}
