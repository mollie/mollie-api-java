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

/**
 * GetPrimaryBalanceLinks
 * 
 * <p>An object with several relevant URLs. Every URL object will contain an `href` and a `type` field.
 */
public class GetPrimaryBalanceLinks {
    /**
     * In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("self")
    private Optional<? extends GetPrimaryBalanceSelf> self;

    /**
     * In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("documentation")
    private Optional<? extends GetPrimaryBalanceDocumentation> documentation;

    @JsonCreator
    public GetPrimaryBalanceLinks(
            @JsonProperty("self") Optional<? extends GetPrimaryBalanceSelf> self,
            @JsonProperty("documentation") Optional<? extends GetPrimaryBalanceDocumentation> documentation) {
        Utils.checkNotNull(self, "self");
        Utils.checkNotNull(documentation, "documentation");
        this.self = self;
        this.documentation = documentation;
    }
    
    public GetPrimaryBalanceLinks() {
        this(Optional.empty(), Optional.empty());
    }

    /**
     * In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field.
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<GetPrimaryBalanceSelf> self() {
        return (Optional<GetPrimaryBalanceSelf>) self;
    }

    /**
     * In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field.
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<GetPrimaryBalanceDocumentation> documentation() {
        return (Optional<GetPrimaryBalanceDocumentation>) documentation;
    }

    public static Builder builder() {
        return new Builder();
    }


    /**
     * In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field.
     */
    public GetPrimaryBalanceLinks withSelf(GetPrimaryBalanceSelf self) {
        Utils.checkNotNull(self, "self");
        this.self = Optional.ofNullable(self);
        return this;
    }


    /**
     * In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field.
     */
    public GetPrimaryBalanceLinks withSelf(Optional<? extends GetPrimaryBalanceSelf> self) {
        Utils.checkNotNull(self, "self");
        this.self = self;
        return this;
    }

    /**
     * In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field.
     */
    public GetPrimaryBalanceLinks withDocumentation(GetPrimaryBalanceDocumentation documentation) {
        Utils.checkNotNull(documentation, "documentation");
        this.documentation = Optional.ofNullable(documentation);
        return this;
    }


    /**
     * In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field.
     */
    public GetPrimaryBalanceLinks withDocumentation(Optional<? extends GetPrimaryBalanceDocumentation> documentation) {
        Utils.checkNotNull(documentation, "documentation");
        this.documentation = documentation;
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
        GetPrimaryBalanceLinks other = (GetPrimaryBalanceLinks) o;
        return 
            Utils.enhancedDeepEquals(this.self, other.self) &&
            Utils.enhancedDeepEquals(this.documentation, other.documentation);
    }
    
    @Override
    public int hashCode() {
        return Utils.enhancedHash(
            self, documentation);
    }
    
    @Override
    public String toString() {
        return Utils.toString(GetPrimaryBalanceLinks.class,
                "self", self,
                "documentation", documentation);
    }

    @SuppressWarnings("UnusedReturnValue")
    public final static class Builder {

        private Optional<? extends GetPrimaryBalanceSelf> self = Optional.empty();

        private Optional<? extends GetPrimaryBalanceDocumentation> documentation = Optional.empty();

        private Builder() {
          // force use of static builder() method
        }


        /**
         * In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field.
         */
        public Builder self(GetPrimaryBalanceSelf self) {
            Utils.checkNotNull(self, "self");
            this.self = Optional.ofNullable(self);
            return this;
        }

        /**
         * In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field.
         */
        public Builder self(Optional<? extends GetPrimaryBalanceSelf> self) {
            Utils.checkNotNull(self, "self");
            this.self = self;
            return this;
        }


        /**
         * In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field.
         */
        public Builder documentation(GetPrimaryBalanceDocumentation documentation) {
            Utils.checkNotNull(documentation, "documentation");
            this.documentation = Optional.ofNullable(documentation);
            return this;
        }

        /**
         * In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field.
         */
        public Builder documentation(Optional<? extends GetPrimaryBalanceDocumentation> documentation) {
            Utils.checkNotNull(documentation, "documentation");
            this.documentation = documentation;
            return this;
        }

        public GetPrimaryBalanceLinks build() {

            return new GetPrimaryBalanceLinks(
                self, documentation);
        }

    }
}
