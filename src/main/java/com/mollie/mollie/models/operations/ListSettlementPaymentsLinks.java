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
 * ListSettlementPaymentsLinks
 * 
 * <p>Links to help navigate through the lists of items. Every URL object will contain an `href` and a `type` field.
 */
public class ListSettlementPaymentsLinks {
    /**
     * The URL to the current set of items.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("self")
    private Optional<? extends ListSettlementPaymentsSelf> self;

    /**
     * The previous set of items, if available.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("previous")
    private JsonNullable<? extends ListSettlementPaymentsPrevious> previous;

    /**
     * The next set of items, if available.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("next")
    private JsonNullable<? extends ListSettlementPaymentsNext> next;

    /**
     * In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("documentation")
    private Optional<? extends ListSettlementPaymentsDocumentation> documentation;

    @JsonCreator
    public ListSettlementPaymentsLinks(
            @JsonProperty("self") Optional<? extends ListSettlementPaymentsSelf> self,
            @JsonProperty("previous") JsonNullable<? extends ListSettlementPaymentsPrevious> previous,
            @JsonProperty("next") JsonNullable<? extends ListSettlementPaymentsNext> next,
            @JsonProperty("documentation") Optional<? extends ListSettlementPaymentsDocumentation> documentation) {
        Utils.checkNotNull(self, "self");
        Utils.checkNotNull(previous, "previous");
        Utils.checkNotNull(next, "next");
        Utils.checkNotNull(documentation, "documentation");
        this.self = self;
        this.previous = previous;
        this.next = next;
        this.documentation = documentation;
    }
    
    public ListSettlementPaymentsLinks() {
        this(Optional.empty(), JsonNullable.undefined(), JsonNullable.undefined(),
            Optional.empty());
    }

    /**
     * The URL to the current set of items.
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<ListSettlementPaymentsSelf> self() {
        return (Optional<ListSettlementPaymentsSelf>) self;
    }

    /**
     * The previous set of items, if available.
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public JsonNullable<ListSettlementPaymentsPrevious> previous() {
        return (JsonNullable<ListSettlementPaymentsPrevious>) previous;
    }

    /**
     * The next set of items, if available.
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public JsonNullable<ListSettlementPaymentsNext> next() {
        return (JsonNullable<ListSettlementPaymentsNext>) next;
    }

    /**
     * In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field.
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<ListSettlementPaymentsDocumentation> documentation() {
        return (Optional<ListSettlementPaymentsDocumentation>) documentation;
    }

    public static Builder builder() {
        return new Builder();
    }


    /**
     * The URL to the current set of items.
     */
    public ListSettlementPaymentsLinks withSelf(ListSettlementPaymentsSelf self) {
        Utils.checkNotNull(self, "self");
        this.self = Optional.ofNullable(self);
        return this;
    }


    /**
     * The URL to the current set of items.
     */
    public ListSettlementPaymentsLinks withSelf(Optional<? extends ListSettlementPaymentsSelf> self) {
        Utils.checkNotNull(self, "self");
        this.self = self;
        return this;
    }

    /**
     * The previous set of items, if available.
     */
    public ListSettlementPaymentsLinks withPrevious(ListSettlementPaymentsPrevious previous) {
        Utils.checkNotNull(previous, "previous");
        this.previous = JsonNullable.of(previous);
        return this;
    }

    /**
     * The previous set of items, if available.
     */
    public ListSettlementPaymentsLinks withPrevious(JsonNullable<? extends ListSettlementPaymentsPrevious> previous) {
        Utils.checkNotNull(previous, "previous");
        this.previous = previous;
        return this;
    }

    /**
     * The next set of items, if available.
     */
    public ListSettlementPaymentsLinks withNext(ListSettlementPaymentsNext next) {
        Utils.checkNotNull(next, "next");
        this.next = JsonNullable.of(next);
        return this;
    }

    /**
     * The next set of items, if available.
     */
    public ListSettlementPaymentsLinks withNext(JsonNullable<? extends ListSettlementPaymentsNext> next) {
        Utils.checkNotNull(next, "next");
        this.next = next;
        return this;
    }

    /**
     * In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field.
     */
    public ListSettlementPaymentsLinks withDocumentation(ListSettlementPaymentsDocumentation documentation) {
        Utils.checkNotNull(documentation, "documentation");
        this.documentation = Optional.ofNullable(documentation);
        return this;
    }


    /**
     * In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field.
     */
    public ListSettlementPaymentsLinks withDocumentation(Optional<? extends ListSettlementPaymentsDocumentation> documentation) {
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
        ListSettlementPaymentsLinks other = (ListSettlementPaymentsLinks) o;
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
        return Utils.toString(ListSettlementPaymentsLinks.class,
                "self", self,
                "previous", previous,
                "next", next,
                "documentation", documentation);
    }

    @SuppressWarnings("UnusedReturnValue")
    public final static class Builder {

        private Optional<? extends ListSettlementPaymentsSelf> self = Optional.empty();

        private JsonNullable<? extends ListSettlementPaymentsPrevious> previous = JsonNullable.undefined();

        private JsonNullable<? extends ListSettlementPaymentsNext> next = JsonNullable.undefined();

        private Optional<? extends ListSettlementPaymentsDocumentation> documentation = Optional.empty();

        private Builder() {
          // force use of static builder() method
        }


        /**
         * The URL to the current set of items.
         */
        public Builder self(ListSettlementPaymentsSelf self) {
            Utils.checkNotNull(self, "self");
            this.self = Optional.ofNullable(self);
            return this;
        }

        /**
         * The URL to the current set of items.
         */
        public Builder self(Optional<? extends ListSettlementPaymentsSelf> self) {
            Utils.checkNotNull(self, "self");
            this.self = self;
            return this;
        }


        /**
         * The previous set of items, if available.
         */
        public Builder previous(ListSettlementPaymentsPrevious previous) {
            Utils.checkNotNull(previous, "previous");
            this.previous = JsonNullable.of(previous);
            return this;
        }

        /**
         * The previous set of items, if available.
         */
        public Builder previous(JsonNullable<? extends ListSettlementPaymentsPrevious> previous) {
            Utils.checkNotNull(previous, "previous");
            this.previous = previous;
            return this;
        }


        /**
         * The next set of items, if available.
         */
        public Builder next(ListSettlementPaymentsNext next) {
            Utils.checkNotNull(next, "next");
            this.next = JsonNullable.of(next);
            return this;
        }

        /**
         * The next set of items, if available.
         */
        public Builder next(JsonNullable<? extends ListSettlementPaymentsNext> next) {
            Utils.checkNotNull(next, "next");
            this.next = next;
            return this;
        }


        /**
         * In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field.
         */
        public Builder documentation(ListSettlementPaymentsDocumentation documentation) {
            Utils.checkNotNull(documentation, "documentation");
            this.documentation = Optional.ofNullable(documentation);
            return this;
        }

        /**
         * In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field.
         */
        public Builder documentation(Optional<? extends ListSettlementPaymentsDocumentation> documentation) {
            Utils.checkNotNull(documentation, "documentation");
            this.documentation = documentation;
            return this;
        }

        public ListSettlementPaymentsLinks build() {

            return new ListSettlementPaymentsLinks(
                self, previous, next,
                documentation);
        }

    }
}
