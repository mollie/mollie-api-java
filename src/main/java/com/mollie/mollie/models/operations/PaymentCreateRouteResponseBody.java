/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.mollie.mollie.models.operations;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.mollie.mollie.utils.LazySingletonValue;
import com.mollie.mollie.utils.Utils;
import java.lang.Override;
import java.lang.String;
import java.util.Optional;

/**
 * PaymentCreateRouteResponseBody
 * 
 * <p>The route object.
 */
public class PaymentCreateRouteResponseBody {
    /**
     * Indicates the response contains a route object. Will always contain the string `route` for this endpoint.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("resource")
    private Optional<String> resource;

    /**
     * The identifier uniquely referring to this route. Mollie assigns this identifier at route creation time. Mollie will always refer to the route by this ID. Example: `crt_dyARQ3JzCgtPDhU2Pbq3J`.
     */
    @JsonProperty("id")
    private String id;

    /**
     * The unique identifier of the payment. For example: `tr_5B8cwPMGnU6qLbRvo7qEZo`. The full payment object can be retrieved via the payment URL in the `_links` object.
     */
    @JsonProperty("paymentId")
    private String paymentId;

    /**
     * The amount of the route. That amount that will be routed to the specified destination.
     */
    @JsonProperty("amount")
    private PaymentCreateRouteDelayedRoutingAmount amount;

    /**
     * The description of the route. This description is shown in the reports.
     */
    @JsonProperty("description")
    private String description;

    /**
     * The destination of the route.
     */
    @JsonProperty("destination")
    private PaymentCreateRouteDelayedRoutingDestination destination;

    /**
     * An object with several relevant URLs. Every URL object will contain an `href` and a `type` field.
     */
    @JsonProperty("_links")
    private PaymentCreateRouteLinks links;

    @JsonCreator
    public PaymentCreateRouteResponseBody(
            @JsonProperty("resource") Optional<String> resource,
            @JsonProperty("id") String id,
            @JsonProperty("paymentId") String paymentId,
            @JsonProperty("amount") PaymentCreateRouteDelayedRoutingAmount amount,
            @JsonProperty("description") String description,
            @JsonProperty("destination") PaymentCreateRouteDelayedRoutingDestination destination,
            @JsonProperty("_links") PaymentCreateRouteLinks links) {
        Utils.checkNotNull(resource, "resource");
        Utils.checkNotNull(id, "id");
        Utils.checkNotNull(paymentId, "paymentId");
        Utils.checkNotNull(amount, "amount");
        Utils.checkNotNull(description, "description");
        Utils.checkNotNull(destination, "destination");
        Utils.checkNotNull(links, "links");
        this.resource = resource;
        this.id = id;
        this.paymentId = paymentId;
        this.amount = amount;
        this.description = description;
        this.destination = destination;
        this.links = links;
    }
    
    public PaymentCreateRouteResponseBody(
            String id,
            String paymentId,
            PaymentCreateRouteDelayedRoutingAmount amount,
            String description,
            PaymentCreateRouteDelayedRoutingDestination destination,
            PaymentCreateRouteLinks links) {
        this(Optional.empty(), id, paymentId,
            amount, description, destination,
            links);
    }

    /**
     * Indicates the response contains a route object. Will always contain the string `route` for this endpoint.
     */
    @JsonIgnore
    public Optional<String> resource() {
        return resource;
    }

    /**
     * The identifier uniquely referring to this route. Mollie assigns this identifier at route creation time. Mollie will always refer to the route by this ID. Example: `crt_dyARQ3JzCgtPDhU2Pbq3J`.
     */
    @JsonIgnore
    public String id() {
        return id;
    }

    /**
     * The unique identifier of the payment. For example: `tr_5B8cwPMGnU6qLbRvo7qEZo`. The full payment object can be retrieved via the payment URL in the `_links` object.
     */
    @JsonIgnore
    public String paymentId() {
        return paymentId;
    }

    /**
     * The amount of the route. That amount that will be routed to the specified destination.
     */
    @JsonIgnore
    public PaymentCreateRouteDelayedRoutingAmount amount() {
        return amount;
    }

    /**
     * The description of the route. This description is shown in the reports.
     */
    @JsonIgnore
    public String description() {
        return description;
    }

    /**
     * The destination of the route.
     */
    @JsonIgnore
    public PaymentCreateRouteDelayedRoutingDestination destination() {
        return destination;
    }

    /**
     * An object with several relevant URLs. Every URL object will contain an `href` and a `type` field.
     */
    @JsonIgnore
    public PaymentCreateRouteLinks links() {
        return links;
    }

    public static Builder builder() {
        return new Builder();
    }


    /**
     * Indicates the response contains a route object. Will always contain the string `route` for this endpoint.
     */
    public PaymentCreateRouteResponseBody withResource(String resource) {
        Utils.checkNotNull(resource, "resource");
        this.resource = Optional.ofNullable(resource);
        return this;
    }


    /**
     * Indicates the response contains a route object. Will always contain the string `route` for this endpoint.
     */
    public PaymentCreateRouteResponseBody withResource(Optional<String> resource) {
        Utils.checkNotNull(resource, "resource");
        this.resource = resource;
        return this;
    }

    /**
     * The identifier uniquely referring to this route. Mollie assigns this identifier at route creation time. Mollie will always refer to the route by this ID. Example: `crt_dyARQ3JzCgtPDhU2Pbq3J`.
     */
    public PaymentCreateRouteResponseBody withId(String id) {
        Utils.checkNotNull(id, "id");
        this.id = id;
        return this;
    }

    /**
     * The unique identifier of the payment. For example: `tr_5B8cwPMGnU6qLbRvo7qEZo`. The full payment object can be retrieved via the payment URL in the `_links` object.
     */
    public PaymentCreateRouteResponseBody withPaymentId(String paymentId) {
        Utils.checkNotNull(paymentId, "paymentId");
        this.paymentId = paymentId;
        return this;
    }

    /**
     * The amount of the route. That amount that will be routed to the specified destination.
     */
    public PaymentCreateRouteResponseBody withAmount(PaymentCreateRouteDelayedRoutingAmount amount) {
        Utils.checkNotNull(amount, "amount");
        this.amount = amount;
        return this;
    }

    /**
     * The description of the route. This description is shown in the reports.
     */
    public PaymentCreateRouteResponseBody withDescription(String description) {
        Utils.checkNotNull(description, "description");
        this.description = description;
        return this;
    }

    /**
     * The destination of the route.
     */
    public PaymentCreateRouteResponseBody withDestination(PaymentCreateRouteDelayedRoutingDestination destination) {
        Utils.checkNotNull(destination, "destination");
        this.destination = destination;
        return this;
    }

    /**
     * An object with several relevant URLs. Every URL object will contain an `href` and a `type` field.
     */
    public PaymentCreateRouteResponseBody withLinks(PaymentCreateRouteLinks links) {
        Utils.checkNotNull(links, "links");
        this.links = links;
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
        PaymentCreateRouteResponseBody other = (PaymentCreateRouteResponseBody) o;
        return 
            Utils.enhancedDeepEquals(this.resource, other.resource) &&
            Utils.enhancedDeepEquals(this.id, other.id) &&
            Utils.enhancedDeepEquals(this.paymentId, other.paymentId) &&
            Utils.enhancedDeepEquals(this.amount, other.amount) &&
            Utils.enhancedDeepEquals(this.description, other.description) &&
            Utils.enhancedDeepEquals(this.destination, other.destination) &&
            Utils.enhancedDeepEquals(this.links, other.links);
    }
    
    @Override
    public int hashCode() {
        return Utils.enhancedHash(
            resource, id, paymentId,
            amount, description, destination,
            links);
    }
    
    @Override
    public String toString() {
        return Utils.toString(PaymentCreateRouteResponseBody.class,
                "resource", resource,
                "id", id,
                "paymentId", paymentId,
                "amount", amount,
                "description", description,
                "destination", destination,
                "links", links);
    }

    @SuppressWarnings("UnusedReturnValue")
    public final static class Builder {

        private Optional<String> resource;

        private String id;

        private String paymentId;

        private PaymentCreateRouteDelayedRoutingAmount amount;

        private String description;

        private PaymentCreateRouteDelayedRoutingDestination destination;

        private PaymentCreateRouteLinks links;

        private Builder() {
          // force use of static builder() method
        }


        /**
         * Indicates the response contains a route object. Will always contain the string `route` for this endpoint.
         */
        public Builder resource(String resource) {
            Utils.checkNotNull(resource, "resource");
            this.resource = Optional.ofNullable(resource);
            return this;
        }

        /**
         * Indicates the response contains a route object. Will always contain the string `route` for this endpoint.
         */
        public Builder resource(Optional<String> resource) {
            Utils.checkNotNull(resource, "resource");
            this.resource = resource;
            return this;
        }


        /**
         * The identifier uniquely referring to this route. Mollie assigns this identifier at route creation time. Mollie will always refer to the route by this ID. Example: `crt_dyARQ3JzCgtPDhU2Pbq3J`.
         */
        public Builder id(String id) {
            Utils.checkNotNull(id, "id");
            this.id = id;
            return this;
        }


        /**
         * The unique identifier of the payment. For example: `tr_5B8cwPMGnU6qLbRvo7qEZo`. The full payment object can be retrieved via the payment URL in the `_links` object.
         */
        public Builder paymentId(String paymentId) {
            Utils.checkNotNull(paymentId, "paymentId");
            this.paymentId = paymentId;
            return this;
        }


        /**
         * The amount of the route. That amount that will be routed to the specified destination.
         */
        public Builder amount(PaymentCreateRouteDelayedRoutingAmount amount) {
            Utils.checkNotNull(amount, "amount");
            this.amount = amount;
            return this;
        }


        /**
         * The description of the route. This description is shown in the reports.
         */
        public Builder description(String description) {
            Utils.checkNotNull(description, "description");
            this.description = description;
            return this;
        }


        /**
         * The destination of the route.
         */
        public Builder destination(PaymentCreateRouteDelayedRoutingDestination destination) {
            Utils.checkNotNull(destination, "destination");
            this.destination = destination;
            return this;
        }


        /**
         * An object with several relevant URLs. Every URL object will contain an `href` and a `type` field.
         */
        public Builder links(PaymentCreateRouteLinks links) {
            Utils.checkNotNull(links, "links");
            this.links = links;
            return this;
        }

        public PaymentCreateRouteResponseBody build() {
            if (resource == null) {
                resource = _SINGLETON_VALUE_Resource.value();
            }

            return new PaymentCreateRouteResponseBody(
                resource, id, paymentId,
                amount, description, destination,
                links);
        }


        private static final LazySingletonValue<Optional<String>> _SINGLETON_VALUE_Resource =
                new LazySingletonValue<>(
                        "resource",
                        "\"route\"",
                        new TypeReference<Optional<String>>() {});
    }
}
