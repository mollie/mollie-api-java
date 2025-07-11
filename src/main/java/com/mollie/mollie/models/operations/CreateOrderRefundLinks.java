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
 * CreateOrderRefundLinks
 * 
 * <p>An object with several relevant URLs. Every URL object will contain an `href` and a `type` field.
 */
public class CreateOrderRefundLinks {
    /**
     * In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("self")
    private Optional<? extends CreateOrderRefundSelf> self;

    /**
     * The API resource URL of the [order](get-order) that this refund belongs to, if applicable.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("order")
    private Optional<? extends CreateOrderRefundOrder> order;

    /**
     * The API resource URL of the [settlement](get-settlement) this refund has been settled with. Not present if not yet settled.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("settlement")
    private JsonNullable<? extends CreateOrderRefundSettlement> settlement;

    /**
     * In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("documentation")
    private Optional<? extends CreateOrderRefundDocumentation> documentation;

    @JsonCreator
    public CreateOrderRefundLinks(
            @JsonProperty("self") Optional<? extends CreateOrderRefundSelf> self,
            @JsonProperty("order") Optional<? extends CreateOrderRefundOrder> order,
            @JsonProperty("settlement") JsonNullable<? extends CreateOrderRefundSettlement> settlement,
            @JsonProperty("documentation") Optional<? extends CreateOrderRefundDocumentation> documentation) {
        Utils.checkNotNull(self, "self");
        Utils.checkNotNull(order, "order");
        Utils.checkNotNull(settlement, "settlement");
        Utils.checkNotNull(documentation, "documentation");
        this.self = self;
        this.order = order;
        this.settlement = settlement;
        this.documentation = documentation;
    }
    
    public CreateOrderRefundLinks() {
        this(Optional.empty(), Optional.empty(), JsonNullable.undefined(),
            Optional.empty());
    }

    /**
     * In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field.
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<CreateOrderRefundSelf> self() {
        return (Optional<CreateOrderRefundSelf>) self;
    }

    /**
     * The API resource URL of the [order](get-order) that this refund belongs to, if applicable.
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<CreateOrderRefundOrder> order() {
        return (Optional<CreateOrderRefundOrder>) order;
    }

    /**
     * The API resource URL of the [settlement](get-settlement) this refund has been settled with. Not present if not yet settled.
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public JsonNullable<CreateOrderRefundSettlement> settlement() {
        return (JsonNullable<CreateOrderRefundSettlement>) settlement;
    }

    /**
     * In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field.
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<CreateOrderRefundDocumentation> documentation() {
        return (Optional<CreateOrderRefundDocumentation>) documentation;
    }

    public static Builder builder() {
        return new Builder();
    }


    /**
     * In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field.
     */
    public CreateOrderRefundLinks withSelf(CreateOrderRefundSelf self) {
        Utils.checkNotNull(self, "self");
        this.self = Optional.ofNullable(self);
        return this;
    }


    /**
     * In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field.
     */
    public CreateOrderRefundLinks withSelf(Optional<? extends CreateOrderRefundSelf> self) {
        Utils.checkNotNull(self, "self");
        this.self = self;
        return this;
    }

    /**
     * The API resource URL of the [order](get-order) that this refund belongs to, if applicable.
     */
    public CreateOrderRefundLinks withOrder(CreateOrderRefundOrder order) {
        Utils.checkNotNull(order, "order");
        this.order = Optional.ofNullable(order);
        return this;
    }


    /**
     * The API resource URL of the [order](get-order) that this refund belongs to, if applicable.
     */
    public CreateOrderRefundLinks withOrder(Optional<? extends CreateOrderRefundOrder> order) {
        Utils.checkNotNull(order, "order");
        this.order = order;
        return this;
    }

    /**
     * The API resource URL of the [settlement](get-settlement) this refund has been settled with. Not present if not yet settled.
     */
    public CreateOrderRefundLinks withSettlement(CreateOrderRefundSettlement settlement) {
        Utils.checkNotNull(settlement, "settlement");
        this.settlement = JsonNullable.of(settlement);
        return this;
    }

    /**
     * The API resource URL of the [settlement](get-settlement) this refund has been settled with. Not present if not yet settled.
     */
    public CreateOrderRefundLinks withSettlement(JsonNullable<? extends CreateOrderRefundSettlement> settlement) {
        Utils.checkNotNull(settlement, "settlement");
        this.settlement = settlement;
        return this;
    }

    /**
     * In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field.
     */
    public CreateOrderRefundLinks withDocumentation(CreateOrderRefundDocumentation documentation) {
        Utils.checkNotNull(documentation, "documentation");
        this.documentation = Optional.ofNullable(documentation);
        return this;
    }


    /**
     * In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field.
     */
    public CreateOrderRefundLinks withDocumentation(Optional<? extends CreateOrderRefundDocumentation> documentation) {
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
        CreateOrderRefundLinks other = (CreateOrderRefundLinks) o;
        return 
            Utils.enhancedDeepEquals(this.self, other.self) &&
            Utils.enhancedDeepEquals(this.order, other.order) &&
            Utils.enhancedDeepEquals(this.settlement, other.settlement) &&
            Utils.enhancedDeepEquals(this.documentation, other.documentation);
    }
    
    @Override
    public int hashCode() {
        return Utils.enhancedHash(
            self, order, settlement,
            documentation);
    }
    
    @Override
    public String toString() {
        return Utils.toString(CreateOrderRefundLinks.class,
                "self", self,
                "order", order,
                "settlement", settlement,
                "documentation", documentation);
    }

    @SuppressWarnings("UnusedReturnValue")
    public final static class Builder {

        private Optional<? extends CreateOrderRefundSelf> self = Optional.empty();

        private Optional<? extends CreateOrderRefundOrder> order = Optional.empty();

        private JsonNullable<? extends CreateOrderRefundSettlement> settlement = JsonNullable.undefined();

        private Optional<? extends CreateOrderRefundDocumentation> documentation = Optional.empty();

        private Builder() {
          // force use of static builder() method
        }


        /**
         * In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field.
         */
        public Builder self(CreateOrderRefundSelf self) {
            Utils.checkNotNull(self, "self");
            this.self = Optional.ofNullable(self);
            return this;
        }

        /**
         * In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field.
         */
        public Builder self(Optional<? extends CreateOrderRefundSelf> self) {
            Utils.checkNotNull(self, "self");
            this.self = self;
            return this;
        }


        /**
         * The API resource URL of the [order](get-order) that this refund belongs to, if applicable.
         */
        public Builder order(CreateOrderRefundOrder order) {
            Utils.checkNotNull(order, "order");
            this.order = Optional.ofNullable(order);
            return this;
        }

        /**
         * The API resource URL of the [order](get-order) that this refund belongs to, if applicable.
         */
        public Builder order(Optional<? extends CreateOrderRefundOrder> order) {
            Utils.checkNotNull(order, "order");
            this.order = order;
            return this;
        }


        /**
         * The API resource URL of the [settlement](get-settlement) this refund has been settled with. Not present if not yet settled.
         */
        public Builder settlement(CreateOrderRefundSettlement settlement) {
            Utils.checkNotNull(settlement, "settlement");
            this.settlement = JsonNullable.of(settlement);
            return this;
        }

        /**
         * The API resource URL of the [settlement](get-settlement) this refund has been settled with. Not present if not yet settled.
         */
        public Builder settlement(JsonNullable<? extends CreateOrderRefundSettlement> settlement) {
            Utils.checkNotNull(settlement, "settlement");
            this.settlement = settlement;
            return this;
        }


        /**
         * In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field.
         */
        public Builder documentation(CreateOrderRefundDocumentation documentation) {
            Utils.checkNotNull(documentation, "documentation");
            this.documentation = Optional.ofNullable(documentation);
            return this;
        }

        /**
         * In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field.
         */
        public Builder documentation(Optional<? extends CreateOrderRefundDocumentation> documentation) {
            Utils.checkNotNull(documentation, "documentation");
            this.documentation = documentation;
            return this;
        }

        public CreateOrderRefundLinks build() {

            return new CreateOrderRefundLinks(
                self, order, settlement,
                documentation);
        }

    }
}
