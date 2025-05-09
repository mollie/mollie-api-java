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
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Objects;
import java.util.Optional;

/**
 * ListAllMethodsResponseBody
 * 
 * <p>A list of payment method objects. For a complete reference of the payment method object, refer to the [Get payment method endpoint](get-method) documentation.
 */
public class ListAllMethodsResponseBody {

    /**
     * The number of payment method objects in this result set. Results are **not** paginated.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("count")
    private Optional<Long> count;

    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("_embedded")
    private Optional<? extends ListAllMethodsEmbedded> embedded;

    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("_links")
    private Optional<? extends ListAllMethodsLinks> links;

    @JsonCreator
    public ListAllMethodsResponseBody(
            @JsonProperty("count") Optional<Long> count,
            @JsonProperty("_embedded") Optional<? extends ListAllMethodsEmbedded> embedded,
            @JsonProperty("_links") Optional<? extends ListAllMethodsLinks> links) {
        Utils.checkNotNull(count, "count");
        Utils.checkNotNull(embedded, "embedded");
        Utils.checkNotNull(links, "links");
        this.count = count;
        this.embedded = embedded;
        this.links = links;
    }
    
    public ListAllMethodsResponseBody() {
        this(Optional.empty(), Optional.empty(), Optional.empty());
    }

    /**
     * The number of payment method objects in this result set. Results are **not** paginated.
     */
    @JsonIgnore
    public Optional<Long> count() {
        return count;
    }

    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<ListAllMethodsEmbedded> embedded() {
        return (Optional<ListAllMethodsEmbedded>) embedded;
    }

    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<ListAllMethodsLinks> links() {
        return (Optional<ListAllMethodsLinks>) links;
    }

    public final static Builder builder() {
        return new Builder();
    }    

    /**
     * The number of payment method objects in this result set. Results are **not** paginated.
     */
    public ListAllMethodsResponseBody withCount(long count) {
        Utils.checkNotNull(count, "count");
        this.count = Optional.ofNullable(count);
        return this;
    }

    /**
     * The number of payment method objects in this result set. Results are **not** paginated.
     */
    public ListAllMethodsResponseBody withCount(Optional<Long> count) {
        Utils.checkNotNull(count, "count");
        this.count = count;
        return this;
    }

    public ListAllMethodsResponseBody withEmbedded(ListAllMethodsEmbedded embedded) {
        Utils.checkNotNull(embedded, "embedded");
        this.embedded = Optional.ofNullable(embedded);
        return this;
    }

    public ListAllMethodsResponseBody withEmbedded(Optional<? extends ListAllMethodsEmbedded> embedded) {
        Utils.checkNotNull(embedded, "embedded");
        this.embedded = embedded;
        return this;
    }

    public ListAllMethodsResponseBody withLinks(ListAllMethodsLinks links) {
        Utils.checkNotNull(links, "links");
        this.links = Optional.ofNullable(links);
        return this;
    }

    public ListAllMethodsResponseBody withLinks(Optional<? extends ListAllMethodsLinks> links) {
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
            Objects.deepEquals(this.count, other.count) &&
            Objects.deepEquals(this.embedded, other.embedded) &&
            Objects.deepEquals(this.links, other.links);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(
            count,
            embedded,
            links);
    }
    
    @Override
    public String toString() {
        return Utils.toString(ListAllMethodsResponseBody.class,
                "count", count,
                "embedded", embedded,
                "links", links);
    }
    
    public final static class Builder {
 
        private Optional<Long> count = Optional.empty();
 
        private Optional<? extends ListAllMethodsEmbedded> embedded = Optional.empty();
 
        private Optional<? extends ListAllMethodsLinks> links = Optional.empty();
        
        private Builder() {
          // force use of static builder() method
        }

        /**
         * The number of payment method objects in this result set. Results are **not** paginated.
         */
        public Builder count(long count) {
            Utils.checkNotNull(count, "count");
            this.count = Optional.ofNullable(count);
            return this;
        }

        /**
         * The number of payment method objects in this result set. Results are **not** paginated.
         */
        public Builder count(Optional<Long> count) {
            Utils.checkNotNull(count, "count");
            this.count = count;
            return this;
        }

        public Builder embedded(ListAllMethodsEmbedded embedded) {
            Utils.checkNotNull(embedded, "embedded");
            this.embedded = Optional.ofNullable(embedded);
            return this;
        }

        public Builder embedded(Optional<? extends ListAllMethodsEmbedded> embedded) {
            Utils.checkNotNull(embedded, "embedded");
            this.embedded = embedded;
            return this;
        }

        public Builder links(ListAllMethodsLinks links) {
            Utils.checkNotNull(links, "links");
            this.links = Optional.ofNullable(links);
            return this;
        }

        public Builder links(Optional<? extends ListAllMethodsLinks> links) {
            Utils.checkNotNull(links, "links");
            this.links = links;
            return this;
        }
        
        public ListAllMethodsResponseBody build() {
            return new ListAllMethodsResponseBody(
                count,
                embedded,
                links);
        }
    }
}
