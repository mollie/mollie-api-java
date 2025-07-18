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
import java.util.List;
import java.util.Optional;

/**
 * GetMethodResponseBody
 * 
 * <p>The payment method object.
 */
public class GetMethodResponseBody {
    /**
     * Indicates the response contains a payment method object. Will always contain the string `method` for this endpoint.
     */
    @JsonProperty("resource")
    private String resource;

    /**
     * The unique identifier of the payment method. When used during [payment creation](create-payment), the payment method selection screen will be skipped.
     * 
     * <p>Possible values: `alma` `applepay` `bacs` `bancomatpay` `bancontact` `banktransfer` `belfius` `billie` `blik` `creditcard` `directdebit` `eps` `giftcard` `ideal` `in3` `kbc` `klarna` `klarnapaylater` `klarnapaynow` `klarnasliceit` `mybank` `paypal` `paysafecard` `przelewy24` `riverty` `satispay` `swish` `trustly` `twint` `voucher`
     */
    @JsonProperty("id")
    private String id;

    /**
     * The full name of the payment method.
     * 
     * <p>If a `locale` parameter is provided, the name is translated to the given locale if possible.
     */
    @JsonProperty("description")
    private String description;

    /**
     * The minimum payment amount required to use this payment method.
     */
    @JsonProperty("minimumAmount")
    private GetMethodMinimumAmount minimumAmount;

    /**
     * The maximum payment amount allowed when using this payment method. If there is no method-specific maximum, `null` is returned instead.
     */
    @JsonInclude(Include.ALWAYS)
    @JsonProperty("maximumAmount")
    private Optional<? extends MaximumAmount> maximumAmount;

    /**
     * URLs of images representing the payment method.
     */
    @JsonProperty("image")
    private Image image;

    /**
     * The payment method's activation status for this profile.
     * 
     * <p>Possible values: `activated` `pending-boarding` `pending-review` `pending-external` `rejected`
     */
    @JsonInclude(Include.ALWAYS)
    @JsonProperty("status")
    private Optional<String> status;

    /**
     * **Optional include.** Array of objects for each 'issuer' that is available for this payment method. Only relevant for iDEAL, KBC/CBC, gift cards, and vouchers.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("issuers")
    private Optional<? extends List<Issuers>> issuers;

    /**
     * An object with several relevant URLs. Every URL object will contain an `href` and a `type` field.
     */
    @JsonProperty("_links")
    private GetMethodLinks links;

    @JsonCreator
    public GetMethodResponseBody(
            @JsonProperty("resource") String resource,
            @JsonProperty("id") String id,
            @JsonProperty("description") String description,
            @JsonProperty("minimumAmount") GetMethodMinimumAmount minimumAmount,
            @JsonProperty("maximumAmount") Optional<? extends MaximumAmount> maximumAmount,
            @JsonProperty("image") Image image,
            @JsonProperty("status") Optional<String> status,
            @JsonProperty("issuers") Optional<? extends List<Issuers>> issuers,
            @JsonProperty("_links") GetMethodLinks links) {
        Utils.checkNotNull(resource, "resource");
        Utils.checkNotNull(id, "id");
        Utils.checkNotNull(description, "description");
        Utils.checkNotNull(minimumAmount, "minimumAmount");
        Utils.checkNotNull(maximumAmount, "maximumAmount");
        Utils.checkNotNull(image, "image");
        Utils.checkNotNull(status, "status");
        Utils.checkNotNull(issuers, "issuers");
        Utils.checkNotNull(links, "links");
        this.resource = resource;
        this.id = id;
        this.description = description;
        this.minimumAmount = minimumAmount;
        this.maximumAmount = maximumAmount;
        this.image = image;
        this.status = status;
        this.issuers = issuers;
        this.links = links;
    }
    
    public GetMethodResponseBody(
            String resource,
            String id,
            String description,
            GetMethodMinimumAmount minimumAmount,
            Image image,
            GetMethodLinks links) {
        this(resource, id, description,
            minimumAmount, Optional.empty(), image,
            Optional.empty(), Optional.empty(), links);
    }

    /**
     * Indicates the response contains a payment method object. Will always contain the string `method` for this endpoint.
     */
    @JsonIgnore
    public String resource() {
        return resource;
    }

    /**
     * The unique identifier of the payment method. When used during [payment creation](create-payment), the payment method selection screen will be skipped.
     * 
     * <p>Possible values: `alma` `applepay` `bacs` `bancomatpay` `bancontact` `banktransfer` `belfius` `billie` `blik` `creditcard` `directdebit` `eps` `giftcard` `ideal` `in3` `kbc` `klarna` `klarnapaylater` `klarnapaynow` `klarnasliceit` `mybank` `paypal` `paysafecard` `przelewy24` `riverty` `satispay` `swish` `trustly` `twint` `voucher`
     */
    @JsonIgnore
    public String id() {
        return id;
    }

    /**
     * The full name of the payment method.
     * 
     * <p>If a `locale` parameter is provided, the name is translated to the given locale if possible.
     */
    @JsonIgnore
    public String description() {
        return description;
    }

    /**
     * The minimum payment amount required to use this payment method.
     */
    @JsonIgnore
    public GetMethodMinimumAmount minimumAmount() {
        return minimumAmount;
    }

    /**
     * The maximum payment amount allowed when using this payment method. If there is no method-specific maximum, `null` is returned instead.
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<MaximumAmount> maximumAmount() {
        return (Optional<MaximumAmount>) maximumAmount;
    }

    /**
     * URLs of images representing the payment method.
     */
    @JsonIgnore
    public Image image() {
        return image;
    }

    /**
     * The payment method's activation status for this profile.
     * 
     * <p>Possible values: `activated` `pending-boarding` `pending-review` `pending-external` `rejected`
     */
    @JsonIgnore
    public Optional<String> status() {
        return status;
    }

    /**
     * **Optional include.** Array of objects for each 'issuer' that is available for this payment method. Only relevant for iDEAL, KBC/CBC, gift cards, and vouchers.
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<List<Issuers>> issuers() {
        return (Optional<List<Issuers>>) issuers;
    }

    /**
     * An object with several relevant URLs. Every URL object will contain an `href` and a `type` field.
     */
    @JsonIgnore
    public GetMethodLinks links() {
        return links;
    }

    public static Builder builder() {
        return new Builder();
    }


    /**
     * Indicates the response contains a payment method object. Will always contain the string `method` for this endpoint.
     */
    public GetMethodResponseBody withResource(String resource) {
        Utils.checkNotNull(resource, "resource");
        this.resource = resource;
        return this;
    }

    /**
     * The unique identifier of the payment method. When used during [payment creation](create-payment), the payment method selection screen will be skipped.
     * 
     * <p>Possible values: `alma` `applepay` `bacs` `bancomatpay` `bancontact` `banktransfer` `belfius` `billie` `blik` `creditcard` `directdebit` `eps` `giftcard` `ideal` `in3` `kbc` `klarna` `klarnapaylater` `klarnapaynow` `klarnasliceit` `mybank` `paypal` `paysafecard` `przelewy24` `riverty` `satispay` `swish` `trustly` `twint` `voucher`
     */
    public GetMethodResponseBody withId(String id) {
        Utils.checkNotNull(id, "id");
        this.id = id;
        return this;
    }

    /**
     * The full name of the payment method.
     * 
     * <p>If a `locale` parameter is provided, the name is translated to the given locale if possible.
     */
    public GetMethodResponseBody withDescription(String description) {
        Utils.checkNotNull(description, "description");
        this.description = description;
        return this;
    }

    /**
     * The minimum payment amount required to use this payment method.
     */
    public GetMethodResponseBody withMinimumAmount(GetMethodMinimumAmount minimumAmount) {
        Utils.checkNotNull(minimumAmount, "minimumAmount");
        this.minimumAmount = minimumAmount;
        return this;
    }

    /**
     * The maximum payment amount allowed when using this payment method. If there is no method-specific maximum, `null` is returned instead.
     */
    public GetMethodResponseBody withMaximumAmount(MaximumAmount maximumAmount) {
        Utils.checkNotNull(maximumAmount, "maximumAmount");
        this.maximumAmount = Optional.ofNullable(maximumAmount);
        return this;
    }


    /**
     * The maximum payment amount allowed when using this payment method. If there is no method-specific maximum, `null` is returned instead.
     */
    public GetMethodResponseBody withMaximumAmount(Optional<? extends MaximumAmount> maximumAmount) {
        Utils.checkNotNull(maximumAmount, "maximumAmount");
        this.maximumAmount = maximumAmount;
        return this;
    }

    /**
     * URLs of images representing the payment method.
     */
    public GetMethodResponseBody withImage(Image image) {
        Utils.checkNotNull(image, "image");
        this.image = image;
        return this;
    }

    /**
     * The payment method's activation status for this profile.
     * 
     * <p>Possible values: `activated` `pending-boarding` `pending-review` `pending-external` `rejected`
     */
    public GetMethodResponseBody withStatus(String status) {
        Utils.checkNotNull(status, "status");
        this.status = Optional.ofNullable(status);
        return this;
    }


    /**
     * The payment method's activation status for this profile.
     * 
     * <p>Possible values: `activated` `pending-boarding` `pending-review` `pending-external` `rejected`
     */
    public GetMethodResponseBody withStatus(Optional<String> status) {
        Utils.checkNotNull(status, "status");
        this.status = status;
        return this;
    }

    /**
     * **Optional include.** Array of objects for each 'issuer' that is available for this payment method. Only relevant for iDEAL, KBC/CBC, gift cards, and vouchers.
     */
    public GetMethodResponseBody withIssuers(List<Issuers> issuers) {
        Utils.checkNotNull(issuers, "issuers");
        this.issuers = Optional.ofNullable(issuers);
        return this;
    }


    /**
     * **Optional include.** Array of objects for each 'issuer' that is available for this payment method. Only relevant for iDEAL, KBC/CBC, gift cards, and vouchers.
     */
    public GetMethodResponseBody withIssuers(Optional<? extends List<Issuers>> issuers) {
        Utils.checkNotNull(issuers, "issuers");
        this.issuers = issuers;
        return this;
    }

    /**
     * An object with several relevant URLs. Every URL object will contain an `href` and a `type` field.
     */
    public GetMethodResponseBody withLinks(GetMethodLinks links) {
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
        GetMethodResponseBody other = (GetMethodResponseBody) o;
        return 
            Utils.enhancedDeepEquals(this.resource, other.resource) &&
            Utils.enhancedDeepEquals(this.id, other.id) &&
            Utils.enhancedDeepEquals(this.description, other.description) &&
            Utils.enhancedDeepEquals(this.minimumAmount, other.minimumAmount) &&
            Utils.enhancedDeepEquals(this.maximumAmount, other.maximumAmount) &&
            Utils.enhancedDeepEquals(this.image, other.image) &&
            Utils.enhancedDeepEquals(this.status, other.status) &&
            Utils.enhancedDeepEquals(this.issuers, other.issuers) &&
            Utils.enhancedDeepEquals(this.links, other.links);
    }
    
    @Override
    public int hashCode() {
        return Utils.enhancedHash(
            resource, id, description,
            minimumAmount, maximumAmount, image,
            status, issuers, links);
    }
    
    @Override
    public String toString() {
        return Utils.toString(GetMethodResponseBody.class,
                "resource", resource,
                "id", id,
                "description", description,
                "minimumAmount", minimumAmount,
                "maximumAmount", maximumAmount,
                "image", image,
                "status", status,
                "issuers", issuers,
                "links", links);
    }

    @SuppressWarnings("UnusedReturnValue")
    public final static class Builder {

        private String resource;

        private String id;

        private String description;

        private GetMethodMinimumAmount minimumAmount;

        private Optional<? extends MaximumAmount> maximumAmount = Optional.empty();

        private Image image;

        private Optional<String> status = Optional.empty();

        private Optional<? extends List<Issuers>> issuers = Optional.empty();

        private GetMethodLinks links;

        private Builder() {
          // force use of static builder() method
        }


        /**
         * Indicates the response contains a payment method object. Will always contain the string `method` for this endpoint.
         */
        public Builder resource(String resource) {
            Utils.checkNotNull(resource, "resource");
            this.resource = resource;
            return this;
        }


        /**
         * The unique identifier of the payment method. When used during [payment creation](create-payment), the payment method selection screen will be skipped.
         * 
         * <p>Possible values: `alma` `applepay` `bacs` `bancomatpay` `bancontact` `banktransfer` `belfius` `billie` `blik` `creditcard` `directdebit` `eps` `giftcard` `ideal` `in3` `kbc` `klarna` `klarnapaylater` `klarnapaynow` `klarnasliceit` `mybank` `paypal` `paysafecard` `przelewy24` `riverty` `satispay` `swish` `trustly` `twint` `voucher`
         */
        public Builder id(String id) {
            Utils.checkNotNull(id, "id");
            this.id = id;
            return this;
        }


        /**
         * The full name of the payment method.
         * 
         * <p>If a `locale` parameter is provided, the name is translated to the given locale if possible.
         */
        public Builder description(String description) {
            Utils.checkNotNull(description, "description");
            this.description = description;
            return this;
        }


        /**
         * The minimum payment amount required to use this payment method.
         */
        public Builder minimumAmount(GetMethodMinimumAmount minimumAmount) {
            Utils.checkNotNull(minimumAmount, "minimumAmount");
            this.minimumAmount = minimumAmount;
            return this;
        }


        /**
         * The maximum payment amount allowed when using this payment method. If there is no method-specific maximum, `null` is returned instead.
         */
        public Builder maximumAmount(MaximumAmount maximumAmount) {
            Utils.checkNotNull(maximumAmount, "maximumAmount");
            this.maximumAmount = Optional.ofNullable(maximumAmount);
            return this;
        }

        /**
         * The maximum payment amount allowed when using this payment method. If there is no method-specific maximum, `null` is returned instead.
         */
        public Builder maximumAmount(Optional<? extends MaximumAmount> maximumAmount) {
            Utils.checkNotNull(maximumAmount, "maximumAmount");
            this.maximumAmount = maximumAmount;
            return this;
        }


        /**
         * URLs of images representing the payment method.
         */
        public Builder image(Image image) {
            Utils.checkNotNull(image, "image");
            this.image = image;
            return this;
        }


        /**
         * The payment method's activation status for this profile.
         * 
         * <p>Possible values: `activated` `pending-boarding` `pending-review` `pending-external` `rejected`
         */
        public Builder status(String status) {
            Utils.checkNotNull(status, "status");
            this.status = Optional.ofNullable(status);
            return this;
        }

        /**
         * The payment method's activation status for this profile.
         * 
         * <p>Possible values: `activated` `pending-boarding` `pending-review` `pending-external` `rejected`
         */
        public Builder status(Optional<String> status) {
            Utils.checkNotNull(status, "status");
            this.status = status;
            return this;
        }


        /**
         * **Optional include.** Array of objects for each 'issuer' that is available for this payment method. Only relevant for iDEAL, KBC/CBC, gift cards, and vouchers.
         */
        public Builder issuers(List<Issuers> issuers) {
            Utils.checkNotNull(issuers, "issuers");
            this.issuers = Optional.ofNullable(issuers);
            return this;
        }

        /**
         * **Optional include.** Array of objects for each 'issuer' that is available for this payment method. Only relevant for iDEAL, KBC/CBC, gift cards, and vouchers.
         */
        public Builder issuers(Optional<? extends List<Issuers>> issuers) {
            Utils.checkNotNull(issuers, "issuers");
            this.issuers = issuers;
            return this;
        }


        /**
         * An object with several relevant URLs. Every URL object will contain an `href` and a `type` field.
         */
        public Builder links(GetMethodLinks links) {
            Utils.checkNotNull(links, "links");
            this.links = links;
            return this;
        }

        public GetMethodResponseBody build() {

            return new GetMethodResponseBody(
                resource, id, description,
                minimumAmount, maximumAmount, image,
                status, issuers, links);
        }

    }
}
