/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.mollie.mollie.models.operations;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mollie.mollie.utils.Utils;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;

/**
 * ListAllMethodsResponseBody
 * 
 * <p>A list of payment method objects. For a complete reference of the payment method object, refer to the [Get payment method endpoint](get-method) documentation.
 */
public class ListAllMethodsResponseBody {
    /**
     * The number of payment method objects in this result set. Results are **not** paginated.
     */
    @JsonProperty("count")
    private long count;


    @JsonProperty("_embedded")
    private ListAllMethodsEmbedded embedded;


    @JsonProperty("_links")
    private ListAllMethodsLinks links;

    @JsonCreator
    public ListAllMethodsResponseBody(
            @JsonProperty("count") long count,
            @JsonProperty("_embedded") ListAllMethodsEmbedded embedded,
            @JsonProperty("_links") ListAllMethodsLinks links) {
        Utils.checkNotNull(count, "count");
        Utils.checkNotNull(embedded, "embedded");
        Utils.checkNotNull(links, "links");
        this.count = count;
        this.embedded = embedded;
        this.links = links;
    }

    /**
     * The number of payment method objects in this result set. Results are **not** paginated.
     */
    @JsonIgnore
    public long count() {
        return count;
    }

    @JsonIgnore
    public ListAllMethodsEmbedded embedded() {
        return embedded;
    }

    @JsonIgnore
    public ListAllMethodsLinks links() {
        return links;
    }

    public static Builder builder() {
        return new Builder();
    }


    /**
     * The number of payment method objects in this result set. Results are **not** paginated.
     */
    public ListAllMethodsResponseBody withCount(long count) {
        Utils.checkNotNull(count, "count");
        this.count = count;
        return this;
    }

    public ListAllMethodsResponseBody withEmbedded(ListAllMethodsEmbedded embedded) {
        Utils.checkNotNull(embedded, "embedded");
        this.embedded = embedded;
        return this;
    }

    public ListAllMethodsResponseBody withLinks(ListAllMethodsLinks links) {
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
        ListAllMethodsResponseBody other = (ListAllMethodsResponseBody) o;
        return 
            Utils.enhancedDeepEquals(this.count, other.count) &&
            Utils.enhancedDeepEquals(this.embedded, other.embedded) &&
            Utils.enhancedDeepEquals(this.links, other.links);
    }
    
    @Override
    public int hashCode() {
        return Utils.enhancedHash(
            count, embedded, links);
    }
    
    @Override
    public String toString() {
        return Utils.toString(ListAllMethodsResponseBody.class,
                "count", count,
                "embedded", embedded,
                "links", links);
    }

    @SuppressWarnings("UnusedReturnValue")
    public final static class Builder {

        private Long count;

        private ListAllMethodsEmbedded embedded;

        private ListAllMethodsLinks links;

        private Builder() {
          // force use of static builder() method
        }


        /**
         * The number of payment method objects in this result set. Results are **not** paginated.
         */
        public Builder count(long count) {
            Utils.checkNotNull(count, "count");
            this.count = count;
            return this;
        }


        public Builder embedded(ListAllMethodsEmbedded embedded) {
            Utils.checkNotNull(embedded, "embedded");
            this.embedded = embedded;
            return this;
        }


        public Builder links(ListAllMethodsLinks links) {
            Utils.checkNotNull(links, "links");
            this.links = links;
            return this;
        }

        public ListAllMethodsResponseBody build() {

            return new ListAllMethodsResponseBody(
                count, embedded, links);
        }

    }
}
