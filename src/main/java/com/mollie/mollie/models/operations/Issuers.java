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


public class Issuers {

    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("resource")
    private Optional<String> resource;


    @JsonProperty("id")
    private String id;

    /**
     * The full name of the issuer.
     */
    @JsonProperty("name")
    private String name;

    /**
     * URLs of images representing the issuer. required: - size1x - size2x - svg
     */
    @JsonProperty("image")
    private GetMethodImage image;

    @JsonCreator
    public Issuers(
            @JsonProperty("resource") Optional<String> resource,
            @JsonProperty("id") String id,
            @JsonProperty("name") String name,
            @JsonProperty("image") GetMethodImage image) {
        Utils.checkNotNull(resource, "resource");
        Utils.checkNotNull(id, "id");
        Utils.checkNotNull(name, "name");
        Utils.checkNotNull(image, "image");
        this.resource = resource;
        this.id = id;
        this.name = name;
        this.image = image;
    }
    
    public Issuers(
            String id,
            String name,
            GetMethodImage image) {
        this(Optional.empty(), id, name,
            image);
    }

    @JsonIgnore
    public Optional<String> resource() {
        return resource;
    }

    @JsonIgnore
    public String id() {
        return id;
    }

    /**
     * The full name of the issuer.
     */
    @JsonIgnore
    public String name() {
        return name;
    }

    /**
     * URLs of images representing the issuer. required: - size1x - size2x - svg
     */
    @JsonIgnore
    public GetMethodImage image() {
        return image;
    }

    public static Builder builder() {
        return new Builder();
    }


    public Issuers withResource(String resource) {
        Utils.checkNotNull(resource, "resource");
        this.resource = Optional.ofNullable(resource);
        return this;
    }


    public Issuers withResource(Optional<String> resource) {
        Utils.checkNotNull(resource, "resource");
        this.resource = resource;
        return this;
    }

    public Issuers withId(String id) {
        Utils.checkNotNull(id, "id");
        this.id = id;
        return this;
    }

    /**
     * The full name of the issuer.
     */
    public Issuers withName(String name) {
        Utils.checkNotNull(name, "name");
        this.name = name;
        return this;
    }

    /**
     * URLs of images representing the issuer. required: - size1x - size2x - svg
     */
    public Issuers withImage(GetMethodImage image) {
        Utils.checkNotNull(image, "image");
        this.image = image;
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
        Issuers other = (Issuers) o;
        return 
            Utils.enhancedDeepEquals(this.resource, other.resource) &&
            Utils.enhancedDeepEquals(this.id, other.id) &&
            Utils.enhancedDeepEquals(this.name, other.name) &&
            Utils.enhancedDeepEquals(this.image, other.image);
    }
    
    @Override
    public int hashCode() {
        return Utils.enhancedHash(
            resource, id, name,
            image);
    }
    
    @Override
    public String toString() {
        return Utils.toString(Issuers.class,
                "resource", resource,
                "id", id,
                "name", name,
                "image", image);
    }

    @SuppressWarnings("UnusedReturnValue")
    public final static class Builder {

        private Optional<String> resource;

        private String id;

        private String name;

        private GetMethodImage image;

        private Builder() {
          // force use of static builder() method
        }


        public Builder resource(String resource) {
            Utils.checkNotNull(resource, "resource");
            this.resource = Optional.ofNullable(resource);
            return this;
        }

        public Builder resource(Optional<String> resource) {
            Utils.checkNotNull(resource, "resource");
            this.resource = resource;
            return this;
        }


        public Builder id(String id) {
            Utils.checkNotNull(id, "id");
            this.id = id;
            return this;
        }


        /**
         * The full name of the issuer.
         */
        public Builder name(String name) {
            Utils.checkNotNull(name, "name");
            this.name = name;
            return this;
        }


        /**
         * URLs of images representing the issuer. required: - size1x - size2x - svg
         */
        public Builder image(GetMethodImage image) {
            Utils.checkNotNull(image, "image");
            this.image = image;
            return this;
        }

        public Issuers build() {
            if (resource == null) {
                resource = _SINGLETON_VALUE_Resource.value();
            }

            return new Issuers(
                resource, id, name,
                image);
        }


        private static final LazySingletonValue<Optional<String>> _SINGLETON_VALUE_Resource =
                new LazySingletonValue<>(
                        "resource",
                        "\"issuer\"",
                        new TypeReference<Optional<String>>() {});
    }
}
