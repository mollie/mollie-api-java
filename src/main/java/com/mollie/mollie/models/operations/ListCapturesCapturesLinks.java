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
import org.openapitools.jackson.nullable.JsonNullable;

/**
 * ListCapturesCapturesLinks
 * 
 * <p>An object with several relevant URLs. Every URL object will contain an `href` and a `type` field.
 */
public class ListCapturesCapturesLinks {
    /**
     * In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field.
     */
    @JsonProperty("self")
    private ListCapturesCapturesSelf self;

    /**
     * The API resource URL of the [payment](get-payment) that this capture belongs to.
     */
    @JsonProperty("payment")
    private ListCapturesPayment payment;

    /**
     * The API resource URL of the [settlement](get-settlement) this capture has been settled with. Not present if not yet settled.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("settlement")
    private JsonNullable<? extends ListCapturesSettlement> settlement;

    /**
     * The API resource URL of the [shipment](get-shipment) this capture is associated with. Not present if it isn't associated with a shipment.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("shipment")
    private JsonNullable<? extends ListCapturesShipment> shipment;

    /**
     * In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field.
     */
    @JsonProperty("documentation")
    private ListCapturesCapturesDocumentation documentation;

    @JsonCreator
    public ListCapturesCapturesLinks(
            @JsonProperty("self") ListCapturesCapturesSelf self,
            @JsonProperty("payment") ListCapturesPayment payment,
            @JsonProperty("settlement") JsonNullable<? extends ListCapturesSettlement> settlement,
            @JsonProperty("shipment") JsonNullable<? extends ListCapturesShipment> shipment,
            @JsonProperty("documentation") ListCapturesCapturesDocumentation documentation) {
        Utils.checkNotNull(self, "self");
        Utils.checkNotNull(payment, "payment");
        Utils.checkNotNull(settlement, "settlement");
        Utils.checkNotNull(shipment, "shipment");
        Utils.checkNotNull(documentation, "documentation");
        this.self = self;
        this.payment = payment;
        this.settlement = settlement;
        this.shipment = shipment;
        this.documentation = documentation;
    }
    
    public ListCapturesCapturesLinks(
            ListCapturesCapturesSelf self,
            ListCapturesPayment payment,
            ListCapturesCapturesDocumentation documentation) {
        this(self, payment, JsonNullable.undefined(),
            JsonNullable.undefined(), documentation);
    }

    /**
     * In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field.
     */
    @JsonIgnore
    public ListCapturesCapturesSelf self() {
        return self;
    }

    /**
     * The API resource URL of the [payment](get-payment) that this capture belongs to.
     */
    @JsonIgnore
    public ListCapturesPayment payment() {
        return payment;
    }

    /**
     * The API resource URL of the [settlement](get-settlement) this capture has been settled with. Not present if not yet settled.
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public JsonNullable<ListCapturesSettlement> settlement() {
        return (JsonNullable<ListCapturesSettlement>) settlement;
    }

    /**
     * The API resource URL of the [shipment](get-shipment) this capture is associated with. Not present if it isn't associated with a shipment.
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public JsonNullable<ListCapturesShipment> shipment() {
        return (JsonNullable<ListCapturesShipment>) shipment;
    }

    /**
     * In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field.
     */
    @JsonIgnore
    public ListCapturesCapturesDocumentation documentation() {
        return documentation;
    }

    public static Builder builder() {
        return new Builder();
    }


    /**
     * In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field.
     */
    public ListCapturesCapturesLinks withSelf(ListCapturesCapturesSelf self) {
        Utils.checkNotNull(self, "self");
        this.self = self;
        return this;
    }

    /**
     * The API resource URL of the [payment](get-payment) that this capture belongs to.
     */
    public ListCapturesCapturesLinks withPayment(ListCapturesPayment payment) {
        Utils.checkNotNull(payment, "payment");
        this.payment = payment;
        return this;
    }

    /**
     * The API resource URL of the [settlement](get-settlement) this capture has been settled with. Not present if not yet settled.
     */
    public ListCapturesCapturesLinks withSettlement(ListCapturesSettlement settlement) {
        Utils.checkNotNull(settlement, "settlement");
        this.settlement = JsonNullable.of(settlement);
        return this;
    }

    /**
     * The API resource URL of the [settlement](get-settlement) this capture has been settled with. Not present if not yet settled.
     */
    public ListCapturesCapturesLinks withSettlement(JsonNullable<? extends ListCapturesSettlement> settlement) {
        Utils.checkNotNull(settlement, "settlement");
        this.settlement = settlement;
        return this;
    }

    /**
     * The API resource URL of the [shipment](get-shipment) this capture is associated with. Not present if it isn't associated with a shipment.
     */
    public ListCapturesCapturesLinks withShipment(ListCapturesShipment shipment) {
        Utils.checkNotNull(shipment, "shipment");
        this.shipment = JsonNullable.of(shipment);
        return this;
    }

    /**
     * The API resource URL of the [shipment](get-shipment) this capture is associated with. Not present if it isn't associated with a shipment.
     */
    public ListCapturesCapturesLinks withShipment(JsonNullable<? extends ListCapturesShipment> shipment) {
        Utils.checkNotNull(shipment, "shipment");
        this.shipment = shipment;
        return this;
    }

    /**
     * In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field.
     */
    public ListCapturesCapturesLinks withDocumentation(ListCapturesCapturesDocumentation documentation) {
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
        ListCapturesCapturesLinks other = (ListCapturesCapturesLinks) o;
        return 
            Utils.enhancedDeepEquals(this.self, other.self) &&
            Utils.enhancedDeepEquals(this.payment, other.payment) &&
            Utils.enhancedDeepEquals(this.settlement, other.settlement) &&
            Utils.enhancedDeepEquals(this.shipment, other.shipment) &&
            Utils.enhancedDeepEquals(this.documentation, other.documentation);
    }
    
    @Override
    public int hashCode() {
        return Utils.enhancedHash(
            self, payment, settlement,
            shipment, documentation);
    }
    
    @Override
    public String toString() {
        return Utils.toString(ListCapturesCapturesLinks.class,
                "self", self,
                "payment", payment,
                "settlement", settlement,
                "shipment", shipment,
                "documentation", documentation);
    }

    @SuppressWarnings("UnusedReturnValue")
    public final static class Builder {

        private ListCapturesCapturesSelf self;

        private ListCapturesPayment payment;

        private JsonNullable<? extends ListCapturesSettlement> settlement = JsonNullable.undefined();

        private JsonNullable<? extends ListCapturesShipment> shipment = JsonNullable.undefined();

        private ListCapturesCapturesDocumentation documentation;

        private Builder() {
          // force use of static builder() method
        }


        /**
         * In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field.
         */
        public Builder self(ListCapturesCapturesSelf self) {
            Utils.checkNotNull(self, "self");
            this.self = self;
            return this;
        }


        /**
         * The API resource URL of the [payment](get-payment) that this capture belongs to.
         */
        public Builder payment(ListCapturesPayment payment) {
            Utils.checkNotNull(payment, "payment");
            this.payment = payment;
            return this;
        }


        /**
         * The API resource URL of the [settlement](get-settlement) this capture has been settled with. Not present if not yet settled.
         */
        public Builder settlement(ListCapturesSettlement settlement) {
            Utils.checkNotNull(settlement, "settlement");
            this.settlement = JsonNullable.of(settlement);
            return this;
        }

        /**
         * The API resource URL of the [settlement](get-settlement) this capture has been settled with. Not present if not yet settled.
         */
        public Builder settlement(JsonNullable<? extends ListCapturesSettlement> settlement) {
            Utils.checkNotNull(settlement, "settlement");
            this.settlement = settlement;
            return this;
        }


        /**
         * The API resource URL of the [shipment](get-shipment) this capture is associated with. Not present if it isn't associated with a shipment.
         */
        public Builder shipment(ListCapturesShipment shipment) {
            Utils.checkNotNull(shipment, "shipment");
            this.shipment = JsonNullable.of(shipment);
            return this;
        }

        /**
         * The API resource URL of the [shipment](get-shipment) this capture is associated with. Not present if it isn't associated with a shipment.
         */
        public Builder shipment(JsonNullable<? extends ListCapturesShipment> shipment) {
            Utils.checkNotNull(shipment, "shipment");
            this.shipment = shipment;
            return this;
        }


        /**
         * In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field.
         */
        public Builder documentation(ListCapturesCapturesDocumentation documentation) {
            Utils.checkNotNull(documentation, "documentation");
            this.documentation = documentation;
            return this;
        }

        public ListCapturesCapturesLinks build() {

            return new ListCapturesCapturesLinks(
                self, payment, settlement,
                shipment, documentation);
        }

    }
}
