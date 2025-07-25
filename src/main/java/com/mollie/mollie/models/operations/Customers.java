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
import java.lang.SuppressWarnings;
import java.util.Optional;
import org.openapitools.jackson.nullable.JsonNullable;


public class Customers {
    /**
     * Indicates the response contains a customer object. Will always contain the string `customer` for this endpoint.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("resource")
    private Optional<String> resource;

    /**
     * The identifier uniquely referring to this customer. Example: `cst_vsKJpSsabw`.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("id")
    private Optional<String> id;

    /**
     * Whether this entity was created in live mode or in test mode.
     * 
     * <p>Possible values: `live` `test`
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("mode")
    private Optional<String> mode;

    /**
     * The full name of the customer.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("name")
    private JsonNullable<String> name;

    /**
     * The email address of the customer.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("email")
    private JsonNullable<String> email;

    /**
     * Preconfigure the language to be used in the hosted payment pages shown to the customer. Should only be provided if absolutely necessary. If not provided, the browser language will be used which is typically highly accurate.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("locale")
    private JsonNullable<String> locale;

    /**
     * Provide any data you like, for example a string or a JSON object. We will save the data alongside the entity. Whenever you fetch the entity with our API, we will also include the metadata. You can use up to approximately 1kB.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("metadata")
    private JsonNullable<? extends ListCustomersMetadata> metadata;

    /**
     * The entity's date and time of creation, in [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601) format.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("createdAt")
    private Optional<String> createdAt;

    /**
     * An object with several relevant URLs. Every URL object will contain an `href` and a `type` field.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("_links")
    private Optional<? extends ListCustomersCustomersLinks> links;

    @JsonCreator
    public Customers(
            @JsonProperty("resource") Optional<String> resource,
            @JsonProperty("id") Optional<String> id,
            @JsonProperty("mode") Optional<String> mode,
            @JsonProperty("name") JsonNullable<String> name,
            @JsonProperty("email") JsonNullable<String> email,
            @JsonProperty("locale") JsonNullable<String> locale,
            @JsonProperty("metadata") JsonNullable<? extends ListCustomersMetadata> metadata,
            @JsonProperty("createdAt") Optional<String> createdAt,
            @JsonProperty("_links") Optional<? extends ListCustomersCustomersLinks> links) {
        Utils.checkNotNull(resource, "resource");
        Utils.checkNotNull(id, "id");
        Utils.checkNotNull(mode, "mode");
        Utils.checkNotNull(name, "name");
        Utils.checkNotNull(email, "email");
        Utils.checkNotNull(locale, "locale");
        Utils.checkNotNull(metadata, "metadata");
        Utils.checkNotNull(createdAt, "createdAt");
        Utils.checkNotNull(links, "links");
        this.resource = resource;
        this.id = id;
        this.mode = mode;
        this.name = name;
        this.email = email;
        this.locale = locale;
        this.metadata = metadata;
        this.createdAt = createdAt;
        this.links = links;
    }
    
    public Customers() {
        this(Optional.empty(), Optional.empty(), Optional.empty(),
            JsonNullable.undefined(), JsonNullable.undefined(), JsonNullable.undefined(),
            JsonNullable.undefined(), Optional.empty(), Optional.empty());
    }

    /**
     * Indicates the response contains a customer object. Will always contain the string `customer` for this endpoint.
     */
    @JsonIgnore
    public Optional<String> resource() {
        return resource;
    }

    /**
     * The identifier uniquely referring to this customer. Example: `cst_vsKJpSsabw`.
     */
    @JsonIgnore
    public Optional<String> id() {
        return id;
    }

    /**
     * Whether this entity was created in live mode or in test mode.
     * 
     * <p>Possible values: `live` `test`
     */
    @JsonIgnore
    public Optional<String> mode() {
        return mode;
    }

    /**
     * The full name of the customer.
     */
    @JsonIgnore
    public JsonNullable<String> name() {
        return name;
    }

    /**
     * The email address of the customer.
     */
    @JsonIgnore
    public JsonNullable<String> email() {
        return email;
    }

    /**
     * Preconfigure the language to be used in the hosted payment pages shown to the customer. Should only be provided if absolutely necessary. If not provided, the browser language will be used which is typically highly accurate.
     */
    @JsonIgnore
    public JsonNullable<String> locale() {
        return locale;
    }

    /**
     * Provide any data you like, for example a string or a JSON object. We will save the data alongside the entity. Whenever you fetch the entity with our API, we will also include the metadata. You can use up to approximately 1kB.
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public JsonNullable<ListCustomersMetadata> metadata() {
        return (JsonNullable<ListCustomersMetadata>) metadata;
    }

    /**
     * The entity's date and time of creation, in [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601) format.
     */
    @JsonIgnore
    public Optional<String> createdAt() {
        return createdAt;
    }

    /**
     * An object with several relevant URLs. Every URL object will contain an `href` and a `type` field.
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<ListCustomersCustomersLinks> links() {
        return (Optional<ListCustomersCustomersLinks>) links;
    }

    public static Builder builder() {
        return new Builder();
    }


    /**
     * Indicates the response contains a customer object. Will always contain the string `customer` for this endpoint.
     */
    public Customers withResource(String resource) {
        Utils.checkNotNull(resource, "resource");
        this.resource = Optional.ofNullable(resource);
        return this;
    }


    /**
     * Indicates the response contains a customer object. Will always contain the string `customer` for this endpoint.
     */
    public Customers withResource(Optional<String> resource) {
        Utils.checkNotNull(resource, "resource");
        this.resource = resource;
        return this;
    }

    /**
     * The identifier uniquely referring to this customer. Example: `cst_vsKJpSsabw`.
     */
    public Customers withId(String id) {
        Utils.checkNotNull(id, "id");
        this.id = Optional.ofNullable(id);
        return this;
    }


    /**
     * The identifier uniquely referring to this customer. Example: `cst_vsKJpSsabw`.
     */
    public Customers withId(Optional<String> id) {
        Utils.checkNotNull(id, "id");
        this.id = id;
        return this;
    }

    /**
     * Whether this entity was created in live mode or in test mode.
     * 
     * <p>Possible values: `live` `test`
     */
    public Customers withMode(String mode) {
        Utils.checkNotNull(mode, "mode");
        this.mode = Optional.ofNullable(mode);
        return this;
    }


    /**
     * Whether this entity was created in live mode or in test mode.
     * 
     * <p>Possible values: `live` `test`
     */
    public Customers withMode(Optional<String> mode) {
        Utils.checkNotNull(mode, "mode");
        this.mode = mode;
        return this;
    }

    /**
     * The full name of the customer.
     */
    public Customers withName(String name) {
        Utils.checkNotNull(name, "name");
        this.name = JsonNullable.of(name);
        return this;
    }

    /**
     * The full name of the customer.
     */
    public Customers withName(JsonNullable<String> name) {
        Utils.checkNotNull(name, "name");
        this.name = name;
        return this;
    }

    /**
     * The email address of the customer.
     */
    public Customers withEmail(String email) {
        Utils.checkNotNull(email, "email");
        this.email = JsonNullable.of(email);
        return this;
    }

    /**
     * The email address of the customer.
     */
    public Customers withEmail(JsonNullable<String> email) {
        Utils.checkNotNull(email, "email");
        this.email = email;
        return this;
    }

    /**
     * Preconfigure the language to be used in the hosted payment pages shown to the customer. Should only be provided if absolutely necessary. If not provided, the browser language will be used which is typically highly accurate.
     */
    public Customers withLocale(String locale) {
        Utils.checkNotNull(locale, "locale");
        this.locale = JsonNullable.of(locale);
        return this;
    }

    /**
     * Preconfigure the language to be used in the hosted payment pages shown to the customer. Should only be provided if absolutely necessary. If not provided, the browser language will be used which is typically highly accurate.
     */
    public Customers withLocale(JsonNullable<String> locale) {
        Utils.checkNotNull(locale, "locale");
        this.locale = locale;
        return this;
    }

    /**
     * Provide any data you like, for example a string or a JSON object. We will save the data alongside the entity. Whenever you fetch the entity with our API, we will also include the metadata. You can use up to approximately 1kB.
     */
    public Customers withMetadata(ListCustomersMetadata metadata) {
        Utils.checkNotNull(metadata, "metadata");
        this.metadata = JsonNullable.of(metadata);
        return this;
    }

    /**
     * Provide any data you like, for example a string or a JSON object. We will save the data alongside the entity. Whenever you fetch the entity with our API, we will also include the metadata. You can use up to approximately 1kB.
     */
    public Customers withMetadata(JsonNullable<? extends ListCustomersMetadata> metadata) {
        Utils.checkNotNull(metadata, "metadata");
        this.metadata = metadata;
        return this;
    }

    /**
     * The entity's date and time of creation, in [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601) format.
     */
    public Customers withCreatedAt(String createdAt) {
        Utils.checkNotNull(createdAt, "createdAt");
        this.createdAt = Optional.ofNullable(createdAt);
        return this;
    }


    /**
     * The entity's date and time of creation, in [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601) format.
     */
    public Customers withCreatedAt(Optional<String> createdAt) {
        Utils.checkNotNull(createdAt, "createdAt");
        this.createdAt = createdAt;
        return this;
    }

    /**
     * An object with several relevant URLs. Every URL object will contain an `href` and a `type` field.
     */
    public Customers withLinks(ListCustomersCustomersLinks links) {
        Utils.checkNotNull(links, "links");
        this.links = Optional.ofNullable(links);
        return this;
    }


    /**
     * An object with several relevant URLs. Every URL object will contain an `href` and a `type` field.
     */
    public Customers withLinks(Optional<? extends ListCustomersCustomersLinks> links) {
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
        Customers other = (Customers) o;
        return 
            Utils.enhancedDeepEquals(this.resource, other.resource) &&
            Utils.enhancedDeepEquals(this.id, other.id) &&
            Utils.enhancedDeepEquals(this.mode, other.mode) &&
            Utils.enhancedDeepEquals(this.name, other.name) &&
            Utils.enhancedDeepEquals(this.email, other.email) &&
            Utils.enhancedDeepEquals(this.locale, other.locale) &&
            Utils.enhancedDeepEquals(this.metadata, other.metadata) &&
            Utils.enhancedDeepEquals(this.createdAt, other.createdAt) &&
            Utils.enhancedDeepEquals(this.links, other.links);
    }
    
    @Override
    public int hashCode() {
        return Utils.enhancedHash(
            resource, id, mode,
            name, email, locale,
            metadata, createdAt, links);
    }
    
    @Override
    public String toString() {
        return Utils.toString(Customers.class,
                "resource", resource,
                "id", id,
                "mode", mode,
                "name", name,
                "email", email,
                "locale", locale,
                "metadata", metadata,
                "createdAt", createdAt,
                "links", links);
    }

    @SuppressWarnings("UnusedReturnValue")
    public final static class Builder {

        private Optional<String> resource;

        private Optional<String> id = Optional.empty();

        private Optional<String> mode = Optional.empty();

        private JsonNullable<String> name = JsonNullable.undefined();

        private JsonNullable<String> email = JsonNullable.undefined();

        private JsonNullable<String> locale = JsonNullable.undefined();

        private JsonNullable<? extends ListCustomersMetadata> metadata = JsonNullable.undefined();

        private Optional<String> createdAt = Optional.empty();

        private Optional<? extends ListCustomersCustomersLinks> links = Optional.empty();

        private Builder() {
          // force use of static builder() method
        }


        /**
         * Indicates the response contains a customer object. Will always contain the string `customer` for this endpoint.
         */
        public Builder resource(String resource) {
            Utils.checkNotNull(resource, "resource");
            this.resource = Optional.ofNullable(resource);
            return this;
        }

        /**
         * Indicates the response contains a customer object. Will always contain the string `customer` for this endpoint.
         */
        public Builder resource(Optional<String> resource) {
            Utils.checkNotNull(resource, "resource");
            this.resource = resource;
            return this;
        }


        /**
         * The identifier uniquely referring to this customer. Example: `cst_vsKJpSsabw`.
         */
        public Builder id(String id) {
            Utils.checkNotNull(id, "id");
            this.id = Optional.ofNullable(id);
            return this;
        }

        /**
         * The identifier uniquely referring to this customer. Example: `cst_vsKJpSsabw`.
         */
        public Builder id(Optional<String> id) {
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
            this.mode = Optional.ofNullable(mode);
            return this;
        }

        /**
         * Whether this entity was created in live mode or in test mode.
         * 
         * <p>Possible values: `live` `test`
         */
        public Builder mode(Optional<String> mode) {
            Utils.checkNotNull(mode, "mode");
            this.mode = mode;
            return this;
        }


        /**
         * The full name of the customer.
         */
        public Builder name(String name) {
            Utils.checkNotNull(name, "name");
            this.name = JsonNullable.of(name);
            return this;
        }

        /**
         * The full name of the customer.
         */
        public Builder name(JsonNullable<String> name) {
            Utils.checkNotNull(name, "name");
            this.name = name;
            return this;
        }


        /**
         * The email address of the customer.
         */
        public Builder email(String email) {
            Utils.checkNotNull(email, "email");
            this.email = JsonNullable.of(email);
            return this;
        }

        /**
         * The email address of the customer.
         */
        public Builder email(JsonNullable<String> email) {
            Utils.checkNotNull(email, "email");
            this.email = email;
            return this;
        }


        /**
         * Preconfigure the language to be used in the hosted payment pages shown to the customer. Should only be provided if absolutely necessary. If not provided, the browser language will be used which is typically highly accurate.
         */
        public Builder locale(String locale) {
            Utils.checkNotNull(locale, "locale");
            this.locale = JsonNullable.of(locale);
            return this;
        }

        /**
         * Preconfigure the language to be used in the hosted payment pages shown to the customer. Should only be provided if absolutely necessary. If not provided, the browser language will be used which is typically highly accurate.
         */
        public Builder locale(JsonNullable<String> locale) {
            Utils.checkNotNull(locale, "locale");
            this.locale = locale;
            return this;
        }


        /**
         * Provide any data you like, for example a string or a JSON object. We will save the data alongside the entity. Whenever you fetch the entity with our API, we will also include the metadata. You can use up to approximately 1kB.
         */
        public Builder metadata(ListCustomersMetadata metadata) {
            Utils.checkNotNull(metadata, "metadata");
            this.metadata = JsonNullable.of(metadata);
            return this;
        }

        /**
         * Provide any data you like, for example a string or a JSON object. We will save the data alongside the entity. Whenever you fetch the entity with our API, we will also include the metadata. You can use up to approximately 1kB.
         */
        public Builder metadata(JsonNullable<? extends ListCustomersMetadata> metadata) {
            Utils.checkNotNull(metadata, "metadata");
            this.metadata = metadata;
            return this;
        }


        /**
         * The entity's date and time of creation, in [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601) format.
         */
        public Builder createdAt(String createdAt) {
            Utils.checkNotNull(createdAt, "createdAt");
            this.createdAt = Optional.ofNullable(createdAt);
            return this;
        }

        /**
         * The entity's date and time of creation, in [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601) format.
         */
        public Builder createdAt(Optional<String> createdAt) {
            Utils.checkNotNull(createdAt, "createdAt");
            this.createdAt = createdAt;
            return this;
        }


        /**
         * An object with several relevant URLs. Every URL object will contain an `href` and a `type` field.
         */
        public Builder links(ListCustomersCustomersLinks links) {
            Utils.checkNotNull(links, "links");
            this.links = Optional.ofNullable(links);
            return this;
        }

        /**
         * An object with several relevant URLs. Every URL object will contain an `href` and a `type` field.
         */
        public Builder links(Optional<? extends ListCustomersCustomersLinks> links) {
            Utils.checkNotNull(links, "links");
            this.links = links;
            return this;
        }

        public Customers build() {
            if (resource == null) {
                resource = _SINGLETON_VALUE_Resource.value();
            }

            return new Customers(
                resource, id, mode,
                name, email, locale,
                metadata, createdAt, links);
        }


        private static final LazySingletonValue<Optional<String>> _SINGLETON_VALUE_Resource =
                new LazySingletonValue<>(
                        "resource",
                        "\"customer\"",
                        new TypeReference<Optional<String>>() {});
    }
}
