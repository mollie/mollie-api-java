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
import org.openapitools.jackson.nullable.JsonNullable;


public class ListAllSubscriptionsRouting {
    /**
     * Indicates the response contains a route object. Will always contain the string `route` for this endpoint.
     */
    @JsonProperty("resource")
    private String resource;

    /**
     * The identifier uniquely referring to this route. Mollie will always refer to the route by this ID. Example: `rt_5B8cwPMGnU6qLbRvo7qEZo`.
     */
    @JsonProperty("id")
    private String id;

    /**
     * Whether this entity was created in live mode or in test mode.
     * 
     * <p>Possible values: `live` `test`
     */
    @JsonProperty("mode")
    private String mode;

    /**
     * The portion of the total payment amount being routed. Currently only `EUR` payments can be routed.
     */
    @JsonProperty("amount")
    private ListAllSubscriptionsSubscriptionsResponseAmount amount;

    /**
     * The destination of this portion of the payment.
     */
    @JsonProperty("destination")
    private ListAllSubscriptionsDestination destination;

    /**
     * The date and time when the route was created. The date is given in ISO 8601 format.
     */
    @JsonProperty("createdAt")
    private String createdAt;

    /**
     * Optionally, schedule this portion of the payment to be transferred to its destination on a later date. The date must be given in `YYYY-MM-DD` format.
     * 
     * <p>If no date is given, the funds become available to the connected merchant as soon as the payment succeeds.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("releaseDate")
    private JsonNullable<String> releaseDate;

    /**
     * An object with several relevant URLs. Every URL object will contain an `href` and a `type` field.
     */
    @JsonProperty("_links")
    private ListAllSubscriptionsSubscriptionsResponseLinks links;

    @JsonCreator
    public ListAllSubscriptionsRouting(
            @JsonProperty("resource") String resource,
            @JsonProperty("id") String id,
            @JsonProperty("mode") String mode,
            @JsonProperty("amount") ListAllSubscriptionsSubscriptionsResponseAmount amount,
            @JsonProperty("destination") ListAllSubscriptionsDestination destination,
            @JsonProperty("createdAt") String createdAt,
            @JsonProperty("releaseDate") JsonNullable<String> releaseDate,
            @JsonProperty("_links") ListAllSubscriptionsSubscriptionsResponseLinks links) {
        Utils.checkNotNull(resource, "resource");
        Utils.checkNotNull(id, "id");
        Utils.checkNotNull(mode, "mode");
        Utils.checkNotNull(amount, "amount");
        Utils.checkNotNull(destination, "destination");
        Utils.checkNotNull(createdAt, "createdAt");
        Utils.checkNotNull(releaseDate, "releaseDate");
        Utils.checkNotNull(links, "links");
        this.resource = resource;
        this.id = id;
        this.mode = mode;
        this.amount = amount;
        this.destination = destination;
        this.createdAt = createdAt;
        this.releaseDate = releaseDate;
        this.links = links;
    }
    
    public ListAllSubscriptionsRouting(
            String resource,
            String id,
            String mode,
            ListAllSubscriptionsSubscriptionsResponseAmount amount,
            ListAllSubscriptionsDestination destination,
            String createdAt,
            ListAllSubscriptionsSubscriptionsResponseLinks links) {
        this(resource, id, mode,
            amount, destination, createdAt,
            JsonNullable.undefined(), links);
    }

    /**
     * Indicates the response contains a route object. Will always contain the string `route` for this endpoint.
     */
    @JsonIgnore
    public String resource() {
        return resource;
    }

    /**
     * The identifier uniquely referring to this route. Mollie will always refer to the route by this ID. Example: `rt_5B8cwPMGnU6qLbRvo7qEZo`.
     */
    @JsonIgnore
    public String id() {
        return id;
    }

    /**
     * Whether this entity was created in live mode or in test mode.
     * 
     * <p>Possible values: `live` `test`
     */
    @JsonIgnore
    public String mode() {
        return mode;
    }

    /**
     * The portion of the total payment amount being routed. Currently only `EUR` payments can be routed.
     */
    @JsonIgnore
    public ListAllSubscriptionsSubscriptionsResponseAmount amount() {
        return amount;
    }

    /**
     * The destination of this portion of the payment.
     */
    @JsonIgnore
    public ListAllSubscriptionsDestination destination() {
        return destination;
    }

    /**
     * The date and time when the route was created. The date is given in ISO 8601 format.
     */
    @JsonIgnore
    public String createdAt() {
        return createdAt;
    }

    /**
     * Optionally, schedule this portion of the payment to be transferred to its destination on a later date. The date must be given in `YYYY-MM-DD` format.
     * 
     * <p>If no date is given, the funds become available to the connected merchant as soon as the payment succeeds.
     */
    @JsonIgnore
    public JsonNullable<String> releaseDate() {
        return releaseDate;
    }

    /**
     * An object with several relevant URLs. Every URL object will contain an `href` and a `type` field.
     */
    @JsonIgnore
    public ListAllSubscriptionsSubscriptionsResponseLinks links() {
        return links;
    }

    public static Builder builder() {
        return new Builder();
    }


    /**
     * Indicates the response contains a route object. Will always contain the string `route` for this endpoint.
     */
    public ListAllSubscriptionsRouting withResource(String resource) {
        Utils.checkNotNull(resource, "resource");
        this.resource = resource;
        return this;
    }

    /**
     * The identifier uniquely referring to this route. Mollie will always refer to the route by this ID. Example: `rt_5B8cwPMGnU6qLbRvo7qEZo`.
     */
    public ListAllSubscriptionsRouting withId(String id) {
        Utils.checkNotNull(id, "id");
        this.id = id;
        return this;
    }

    /**
     * Whether this entity was created in live mode or in test mode.
     * 
     * <p>Possible values: `live` `test`
     */
    public ListAllSubscriptionsRouting withMode(String mode) {
        Utils.checkNotNull(mode, "mode");
        this.mode = mode;
        return this;
    }

    /**
     * The portion of the total payment amount being routed. Currently only `EUR` payments can be routed.
     */
    public ListAllSubscriptionsRouting withAmount(ListAllSubscriptionsSubscriptionsResponseAmount amount) {
        Utils.checkNotNull(amount, "amount");
        this.amount = amount;
        return this;
    }

    /**
     * The destination of this portion of the payment.
     */
    public ListAllSubscriptionsRouting withDestination(ListAllSubscriptionsDestination destination) {
        Utils.checkNotNull(destination, "destination");
        this.destination = destination;
        return this;
    }

    /**
     * The date and time when the route was created. The date is given in ISO 8601 format.
     */
    public ListAllSubscriptionsRouting withCreatedAt(String createdAt) {
        Utils.checkNotNull(createdAt, "createdAt");
        this.createdAt = createdAt;
        return this;
    }

    /**
     * Optionally, schedule this portion of the payment to be transferred to its destination on a later date. The date must be given in `YYYY-MM-DD` format.
     * 
     * <p>If no date is given, the funds become available to the connected merchant as soon as the payment succeeds.
     */
    public ListAllSubscriptionsRouting withReleaseDate(String releaseDate) {
        Utils.checkNotNull(releaseDate, "releaseDate");
        this.releaseDate = JsonNullable.of(releaseDate);
        return this;
    }

    /**
     * Optionally, schedule this portion of the payment to be transferred to its destination on a later date. The date must be given in `YYYY-MM-DD` format.
     * 
     * <p>If no date is given, the funds become available to the connected merchant as soon as the payment succeeds.
     */
    public ListAllSubscriptionsRouting withReleaseDate(JsonNullable<String> releaseDate) {
        Utils.checkNotNull(releaseDate, "releaseDate");
        this.releaseDate = releaseDate;
        return this;
    }

    /**
     * An object with several relevant URLs. Every URL object will contain an `href` and a `type` field.
     */
    public ListAllSubscriptionsRouting withLinks(ListAllSubscriptionsSubscriptionsResponseLinks links) {
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
        ListAllSubscriptionsRouting other = (ListAllSubscriptionsRouting) o;
        return 
            Utils.enhancedDeepEquals(this.resource, other.resource) &&
            Utils.enhancedDeepEquals(this.id, other.id) &&
            Utils.enhancedDeepEquals(this.mode, other.mode) &&
            Utils.enhancedDeepEquals(this.amount, other.amount) &&
            Utils.enhancedDeepEquals(this.destination, other.destination) &&
            Utils.enhancedDeepEquals(this.createdAt, other.createdAt) &&
            Utils.enhancedDeepEquals(this.releaseDate, other.releaseDate) &&
            Utils.enhancedDeepEquals(this.links, other.links);
    }
    
    @Override
    public int hashCode() {
        return Utils.enhancedHash(
            resource, id, mode,
            amount, destination, createdAt,
            releaseDate, links);
    }
    
    @Override
    public String toString() {
        return Utils.toString(ListAllSubscriptionsRouting.class,
                "resource", resource,
                "id", id,
                "mode", mode,
                "amount", amount,
                "destination", destination,
                "createdAt", createdAt,
                "releaseDate", releaseDate,
                "links", links);
    }

    @SuppressWarnings("UnusedReturnValue")
    public final static class Builder {

        private String resource;

        private String id;

        private String mode;

        private ListAllSubscriptionsSubscriptionsResponseAmount amount;

        private ListAllSubscriptionsDestination destination;

        private String createdAt;

        private JsonNullable<String> releaseDate = JsonNullable.undefined();

        private ListAllSubscriptionsSubscriptionsResponseLinks links;

        private Builder() {
          // force use of static builder() method
        }


        /**
         * Indicates the response contains a route object. Will always contain the string `route` for this endpoint.
         */
        public Builder resource(String resource) {
            Utils.checkNotNull(resource, "resource");
            this.resource = resource;
            return this;
        }


        /**
         * The identifier uniquely referring to this route. Mollie will always refer to the route by this ID. Example: `rt_5B8cwPMGnU6qLbRvo7qEZo`.
         */
        public Builder id(String id) {
            Utils.checkNotNull(id, "id");
            this.id = id;
            return this;
        }


        /**
         * Whether this entity was created in live mode or in test mode.
         * 
         * <p>Possible values: `live` `test`
         */
        public Builder mode(String mode) {
            Utils.checkNotNull(mode, "mode");
            this.mode = mode;
            return this;
        }


        /**
         * The portion of the total payment amount being routed. Currently only `EUR` payments can be routed.
         */
        public Builder amount(ListAllSubscriptionsSubscriptionsResponseAmount amount) {
            Utils.checkNotNull(amount, "amount");
            this.amount = amount;
            return this;
        }


        /**
         * The destination of this portion of the payment.
         */
        public Builder destination(ListAllSubscriptionsDestination destination) {
            Utils.checkNotNull(destination, "destination");
            this.destination = destination;
            return this;
        }


        /**
         * The date and time when the route was created. The date is given in ISO 8601 format.
         */
        public Builder createdAt(String createdAt) {
            Utils.checkNotNull(createdAt, "createdAt");
            this.createdAt = createdAt;
            return this;
        }


        /**
         * Optionally, schedule this portion of the payment to be transferred to its destination on a later date. The date must be given in `YYYY-MM-DD` format.
         * 
         * <p>If no date is given, the funds become available to the connected merchant as soon as the payment succeeds.
         */
        public Builder releaseDate(String releaseDate) {
            Utils.checkNotNull(releaseDate, "releaseDate");
            this.releaseDate = JsonNullable.of(releaseDate);
            return this;
        }

        /**
         * Optionally, schedule this portion of the payment to be transferred to its destination on a later date. The date must be given in `YYYY-MM-DD` format.
         * 
         * <p>If no date is given, the funds become available to the connected merchant as soon as the payment succeeds.
         */
        public Builder releaseDate(JsonNullable<String> releaseDate) {
            Utils.checkNotNull(releaseDate, "releaseDate");
            this.releaseDate = releaseDate;
            return this;
        }


        /**
         * An object with several relevant URLs. Every URL object will contain an `href` and a `type` field.
         */
        public Builder links(ListAllSubscriptionsSubscriptionsResponseLinks links) {
            Utils.checkNotNull(links, "links");
            this.links = links;
            return this;
        }

        public ListAllSubscriptionsRouting build() {

            return new ListAllSubscriptionsRouting(
                resource, id, mode,
                amount, destination, createdAt,
                releaseDate, links);
        }

    }
}
