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
import org.openapitools.jackson.nullable.JsonNullable;

/**
 * ListSettlementRefundsLinks
 * 
 * <p>Links to help navigate through the lists of items. Every URL object will contain an `href` and a `type` field.
 */
public class ListSettlementRefundsLinks {
    /**
     * The URL to the current set of items.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("self")
    private Optional<? extends ListSettlementRefundsSelf> self;

    /**
     * The previous set of items, if available.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("previous")
    private JsonNullable<? extends ListSettlementRefundsPrevious> previous;

    /**
     * The next set of items, if available.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("next")
    private JsonNullable<? extends ListSettlementRefundsNext> next;

    /**
     * In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("documentation")
    private Optional<? extends ListSettlementRefundsDocumentation> documentation;

    @JsonCreator
    public ListSettlementRefundsLinks(
            @JsonProperty("self") Optional<? extends ListSettlementRefundsSelf> self,
            @JsonProperty("previous") JsonNullable<? extends ListSettlementRefundsPrevious> previous,
            @JsonProperty("next") JsonNullable<? extends ListSettlementRefundsNext> next,
            @JsonProperty("documentation") Optional<? extends ListSettlementRefundsDocumentation> documentation) {
        Utils.checkNotNull(self, "self");
        Utils.checkNotNull(previous, "previous");
        Utils.checkNotNull(next, "next");
        Utils.checkNotNull(documentation, "documentation");
        this.self = self;
        this.previous = previous;
        this.next = next;
        this.documentation = documentation;
    }
    
    public ListSettlementRefundsLinks() {
        this(Optional.empty(), JsonNullable.undefined(), JsonNullable.undefined(),
            Optional.empty());
    }

    /**
     * The URL to the current set of items.
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<ListSettlementRefundsSelf> self() {
        return (Optional<ListSettlementRefundsSelf>) self;
    }

    /**
     * The previous set of items, if available.
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public JsonNullable<ListSettlementRefundsPrevious> previous() {
        return (JsonNullable<ListSettlementRefundsPrevious>) previous;
    }

    /**
     * The next set of items, if available.
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public JsonNullable<ListSettlementRefundsNext> next() {
        return (JsonNullable<ListSettlementRefundsNext>) next;
    }

    /**
     * In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field.
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<ListSettlementRefundsDocumentation> documentation() {
        return (Optional<ListSettlementRefundsDocumentation>) documentation;
    }

    public static Builder builder() {
        return new Builder();
    }


    /**
     * The URL to the current set of items.
     */
    public ListSettlementRefundsLinks withSelf(ListSettlementRefundsSelf self) {
        Utils.checkNotNull(self, "self");
        this.self = Optional.ofNullable(self);
        return this;
    }


    /**
     * The URL to the current set of items.
     */
    public ListSettlementRefundsLinks withSelf(Optional<? extends ListSettlementRefundsSelf> self) {
        Utils.checkNotNull(self, "self");
        this.self = self;
        return this;
    }

    /**
     * The previous set of items, if available.
     */
    public ListSettlementRefundsLinks withPrevious(ListSettlementRefundsPrevious previous) {
        Utils.checkNotNull(previous, "previous");
        this.previous = JsonNullable.of(previous);
        return this;
    }

    /**
     * The previous set of items, if available.
     */
    public ListSettlementRefundsLinks withPrevious(JsonNullable<? extends ListSettlementRefundsPrevious> previous) {
        Utils.checkNotNull(previous, "previous");
        this.previous = previous;
        return this;
    }

    /**
     * The next set of items, if available.
     */
    public ListSettlementRefundsLinks withNext(ListSettlementRefundsNext next) {
        Utils.checkNotNull(next, "next");
        this.next = JsonNullable.of(next);
        return this;
    }

    /**
     * The next set of items, if available.
     */
    public ListSettlementRefundsLinks withNext(JsonNullable<? extends ListSettlementRefundsNext> next) {
        Utils.checkNotNull(next, "next");
        this.next = next;
        return this;
    }

    /**
     * In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field.
     */
    public ListSettlementRefundsLinks withDocumentation(ListSettlementRefundsDocumentation documentation) {
        Utils.checkNotNull(documentation, "documentation");
        this.documentation = Optional.ofNullable(documentation);
        return this;
    }


    /**
     * In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field.
     */
    public ListSettlementRefundsLinks withDocumentation(Optional<? extends ListSettlementRefundsDocumentation> documentation) {
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
        ListSettlementRefundsLinks other = (ListSettlementRefundsLinks) o;
        return 
            Utils.enhancedDeepEquals(this.self, other.self) &&
            Utils.enhancedDeepEquals(this.previous, other.previous) &&
            Utils.enhancedDeepEquals(this.next, other.next) &&
            Utils.enhancedDeepEquals(this.documentation, other.documentation);
    }
    
    @Override
    public int hashCode() {
        return Utils.enhancedHash(
            self, previous, next,
            documentation);
    }
    
    @Override
    public String toString() {
        return Utils.toString(ListSettlementRefundsLinks.class,
                "self", self,
                "previous", previous,
                "next", next,
                "documentation", documentation);
    }

    @SuppressWarnings("UnusedReturnValue")
    public final static class Builder {

        private Optional<? extends ListSettlementRefundsSelf> self = Optional.empty();

        private JsonNullable<? extends ListSettlementRefundsPrevious> previous = JsonNullable.undefined();

        private JsonNullable<? extends ListSettlementRefundsNext> next = JsonNullable.undefined();

        private Optional<? extends ListSettlementRefundsDocumentation> documentation = Optional.empty();

        private Builder() {
          // force use of static builder() method
        }


        /**
         * The URL to the current set of items.
         */
        public Builder self(ListSettlementRefundsSelf self) {
            Utils.checkNotNull(self, "self");
            this.self = Optional.ofNullable(self);
            return this;
        }

        /**
         * The URL to the current set of items.
         */
        public Builder self(Optional<? extends ListSettlementRefundsSelf> self) {
            Utils.checkNotNull(self, "self");
            this.self = self;
            return this;
        }


        /**
         * The previous set of items, if available.
         */
        public Builder previous(ListSettlementRefundsPrevious previous) {
            Utils.checkNotNull(previous, "previous");
            this.previous = JsonNullable.of(previous);
            return this;
        }

        /**
         * The previous set of items, if available.
         */
        public Builder previous(JsonNullable<? extends ListSettlementRefundsPrevious> previous) {
            Utils.checkNotNull(previous, "previous");
            this.previous = previous;
            return this;
        }


        /**
         * The next set of items, if available.
         */
        public Builder next(ListSettlementRefundsNext next) {
            Utils.checkNotNull(next, "next");
            this.next = JsonNullable.of(next);
            return this;
        }

        /**
         * The next set of items, if available.
         */
        public Builder next(JsonNullable<? extends ListSettlementRefundsNext> next) {
            Utils.checkNotNull(next, "next");
            this.next = next;
            return this;
        }


        /**
         * In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field.
         */
        public Builder documentation(ListSettlementRefundsDocumentation documentation) {
            Utils.checkNotNull(documentation, "documentation");
            this.documentation = Optional.ofNullable(documentation);
            return this;
        }

        /**
         * In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field.
         */
        public Builder documentation(Optional<? extends ListSettlementRefundsDocumentation> documentation) {
            Utils.checkNotNull(documentation, "documentation");
            this.documentation = documentation;
            return this;
        }

        public ListSettlementRefundsLinks build() {

            return new ListSettlementRefundsLinks(
                self, previous, next,
                documentation);
        }

    }
}
