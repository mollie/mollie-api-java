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
import java.util.Optional;

/**
 * ListWebhooksResponseBody
 * 
 * <p>A list of webhooks. For a complete reference of the webhook object, refer to the [Get hook endpoint](get-webhook) documentation.
 */
public class ListWebhooksResponseBody {
    /**
     * The number of items in this result set. If more items are available, a `_links.next` URL will be present in the result as well.
     * 
     * <p>The maximum number of items per result set is controlled by the `limit` property provided in the request. The default limit is 50 items.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("count")
    private Optional<Long> count;


    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("_embedded")
    private Optional<? extends ListWebhooksEmbedded> embedded;

    /**
     * Links to help navigate through the lists of items. Every URL object will contain an `href` and a `type` field.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("_links")
    private Optional<? extends ListWebhooksLinks> links;

    @JsonCreator
    public ListWebhooksResponseBody(
            @JsonProperty("count") Optional<Long> count,
            @JsonProperty("_embedded") Optional<? extends ListWebhooksEmbedded> embedded,
            @JsonProperty("_links") Optional<? extends ListWebhooksLinks> links) {
        Utils.checkNotNull(count, "count");
        Utils.checkNotNull(embedded, "embedded");
        Utils.checkNotNull(links, "links");
        this.count = count;
        this.embedded = embedded;
        this.links = links;
    }
    
    public ListWebhooksResponseBody() {
        this(Optional.empty(), Optional.empty(), Optional.empty());
    }

    /**
     * The number of items in this result set. If more items are available, a `_links.next` URL will be present in the result as well.
     * 
     * <p>The maximum number of items per result set is controlled by the `limit` property provided in the request. The default limit is 50 items.
     */
    @JsonIgnore
    public Optional<Long> count() {
        return count;
    }

    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<ListWebhooksEmbedded> embedded() {
        return (Optional<ListWebhooksEmbedded>) embedded;
    }

    /**
     * Links to help navigate through the lists of items. Every URL object will contain an `href` and a `type` field.
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<ListWebhooksLinks> links() {
        return (Optional<ListWebhooksLinks>) links;
    }

    public static Builder builder() {
        return new Builder();
    }


    /**
     * The number of items in this result set. If more items are available, a `_links.next` URL will be present in the result as well.
     * 
     * <p>The maximum number of items per result set is controlled by the `limit` property provided in the request. The default limit is 50 items.
     */
    public ListWebhooksResponseBody withCount(long count) {
        Utils.checkNotNull(count, "count");
        this.count = Optional.ofNullable(count);
        return this;
    }


    /**
     * The number of items in this result set. If more items are available, a `_links.next` URL will be present in the result as well.
     * 
     * <p>The maximum number of items per result set is controlled by the `limit` property provided in the request. The default limit is 50 items.
     */
    public ListWebhooksResponseBody withCount(Optional<Long> count) {
        Utils.checkNotNull(count, "count");
        this.count = count;
        return this;
    }

    public ListWebhooksResponseBody withEmbedded(ListWebhooksEmbedded embedded) {
        Utils.checkNotNull(embedded, "embedded");
        this.embedded = Optional.ofNullable(embedded);
        return this;
    }


    public ListWebhooksResponseBody withEmbedded(Optional<? extends ListWebhooksEmbedded> embedded) {
        Utils.checkNotNull(embedded, "embedded");
        this.embedded = embedded;
        return this;
    }

    /**
     * Links to help navigate through the lists of items. Every URL object will contain an `href` and a `type` field.
     */
    public ListWebhooksResponseBody withLinks(ListWebhooksLinks links) {
        Utils.checkNotNull(links, "links");
        this.links = Optional.ofNullable(links);
        return this;
    }


    /**
     * Links to help navigate through the lists of items. Every URL object will contain an `href` and a `type` field.
     */
    public ListWebhooksResponseBody withLinks(Optional<? extends ListWebhooksLinks> links) {
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
        ListWebhooksResponseBody other = (ListWebhooksResponseBody) o;
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
        return Utils.toString(ListWebhooksResponseBody.class,
                "count", count,
                "embedded", embedded,
                "links", links);
    }

    @SuppressWarnings("UnusedReturnValue")
    public final static class Builder {

        private Optional<Long> count = Optional.empty();

        private Optional<? extends ListWebhooksEmbedded> embedded = Optional.empty();

        private Optional<? extends ListWebhooksLinks> links = Optional.empty();

        private Builder() {
          // force use of static builder() method
        }


        /**
         * The number of items in this result set. If more items are available, a `_links.next` URL will be present in the result as well.
         * 
         * <p>The maximum number of items per result set is controlled by the `limit` property provided in the request. The default limit is 50 items.
         */
        public Builder count(long count) {
            Utils.checkNotNull(count, "count");
            this.count = Optional.ofNullable(count);
            return this;
        }

        /**
         * The number of items in this result set. If more items are available, a `_links.next` URL will be present in the result as well.
         * 
         * <p>The maximum number of items per result set is controlled by the `limit` property provided in the request. The default limit is 50 items.
         */
        public Builder count(Optional<Long> count) {
            Utils.checkNotNull(count, "count");
            this.count = count;
            return this;
        }


        public Builder embedded(ListWebhooksEmbedded embedded) {
            Utils.checkNotNull(embedded, "embedded");
            this.embedded = Optional.ofNullable(embedded);
            return this;
        }

        public Builder embedded(Optional<? extends ListWebhooksEmbedded> embedded) {
            Utils.checkNotNull(embedded, "embedded");
            this.embedded = embedded;
            return this;
        }


        /**
         * Links to help navigate through the lists of items. Every URL object will contain an `href` and a `type` field.
         */
        public Builder links(ListWebhooksLinks links) {
            Utils.checkNotNull(links, "links");
            this.links = Optional.ofNullable(links);
            return this;
        }

        /**
         * Links to help navigate through the lists of items. Every URL object will contain an `href` and a `type` field.
         */
        public Builder links(Optional<? extends ListWebhooksLinks> links) {
            Utils.checkNotNull(links, "links");
            this.links = links;
            return this;
        }

        public ListWebhooksResponseBody build() {

            return new ListWebhooksResponseBody(
                count, embedded, links);
        }

    }
}
