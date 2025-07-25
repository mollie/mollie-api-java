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

/**
 * GetBalanceResponseBody
 * 
 * <p>The balance object.
 */
public class GetBalanceResponseBody {
    /**
     * Indicates the response contains a balance object. Will always contain the string `balance` for this endpoint.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("resource")
    private Optional<String> resource;

    /**
     * The identifier uniquely referring to this balance.
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
     * The entity's date and time of creation, in [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601) format.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("createdAt")
    private Optional<String> createdAt;

    /**
     * The balance's ISO 4217 currency code.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("currency")
    private Optional<? extends Currency> currency;

    /**
     * The description or name of the balance. Can be used to denote the purpose of the balance.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("description")
    private Optional<String> description;

    /**
     * The status of the balance.
     * 
     * <p>Possible values: `active` `inactive`
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("status")
    private Optional<String> status;

    /**
     * The frequency with which the available amount on the balance will be settled to the configured transfer destination.
     * 
     * <p>Settlements created during weekends or on bank holidays will take place on the next business day.
     * 
     * <p>Possible values: `daily` `every-monday` `every-tuesday` `every-wednesday` `every-thursday` `every-friday` `monthly` `never`
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("transferFrequency")
    private Optional<String> transferFrequency;

    /**
     * The minimum amount configured for scheduled automatic settlements. As soon as the amount on the balance exceeds this threshold, the complete balance will be paid out to the transfer destination according to the configured frequency.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("transferThreshold")
    private Optional<? extends TransferThreshold> transferThreshold;

    /**
     * The transfer reference set to be included in all the transfers for this balance.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("transferReference")
    private JsonNullable<String> transferReference;

    /**
     * The destination where the available amount will be automatically transferred to according to the configured transfer frequency.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("transferDestination")
    private JsonNullable<? extends TransferDestination> transferDestination;

    /**
     * The amount directly available on the balance, e.g. `{"currency":"EUR", "value":"100.00"}`.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("availableAmount")
    private Optional<? extends AvailableAmount> availableAmount;

    /**
     * The total amount that is queued to be transferred to your balance. For example, a credit card payment can take a few days to clear.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("pendingAmount")
    private Optional<? extends PendingAmount> pendingAmount;

    /**
     * An object with several relevant URLs. Every URL object will contain an `href` and a `type` field.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("_links")
    private Optional<? extends GetBalanceLinks> links;

    @JsonCreator
    public GetBalanceResponseBody(
            @JsonProperty("resource") Optional<String> resource,
            @JsonProperty("id") Optional<String> id,
            @JsonProperty("mode") Optional<String> mode,
            @JsonProperty("createdAt") Optional<String> createdAt,
            @JsonProperty("currency") Optional<? extends Currency> currency,
            @JsonProperty("description") Optional<String> description,
            @JsonProperty("status") Optional<String> status,
            @JsonProperty("transferFrequency") Optional<String> transferFrequency,
            @JsonProperty("transferThreshold") Optional<? extends TransferThreshold> transferThreshold,
            @JsonProperty("transferReference") JsonNullable<String> transferReference,
            @JsonProperty("transferDestination") JsonNullable<? extends TransferDestination> transferDestination,
            @JsonProperty("availableAmount") Optional<? extends AvailableAmount> availableAmount,
            @JsonProperty("pendingAmount") Optional<? extends PendingAmount> pendingAmount,
            @JsonProperty("_links") Optional<? extends GetBalanceLinks> links) {
        Utils.checkNotNull(resource, "resource");
        Utils.checkNotNull(id, "id");
        Utils.checkNotNull(mode, "mode");
        Utils.checkNotNull(createdAt, "createdAt");
        Utils.checkNotNull(currency, "currency");
        Utils.checkNotNull(description, "description");
        Utils.checkNotNull(status, "status");
        Utils.checkNotNull(transferFrequency, "transferFrequency");
        Utils.checkNotNull(transferThreshold, "transferThreshold");
        Utils.checkNotNull(transferReference, "transferReference");
        Utils.checkNotNull(transferDestination, "transferDestination");
        Utils.checkNotNull(availableAmount, "availableAmount");
        Utils.checkNotNull(pendingAmount, "pendingAmount");
        Utils.checkNotNull(links, "links");
        this.resource = resource;
        this.id = id;
        this.mode = mode;
        this.createdAt = createdAt;
        this.currency = currency;
        this.description = description;
        this.status = status;
        this.transferFrequency = transferFrequency;
        this.transferThreshold = transferThreshold;
        this.transferReference = transferReference;
        this.transferDestination = transferDestination;
        this.availableAmount = availableAmount;
        this.pendingAmount = pendingAmount;
        this.links = links;
    }
    
    public GetBalanceResponseBody() {
        this(Optional.empty(), Optional.empty(), Optional.empty(),
            Optional.empty(), Optional.empty(), Optional.empty(),
            Optional.empty(), Optional.empty(), Optional.empty(),
            JsonNullable.undefined(), JsonNullable.undefined(), Optional.empty(),
            Optional.empty(), Optional.empty());
    }

    /**
     * Indicates the response contains a balance object. Will always contain the string `balance` for this endpoint.
     */
    @JsonIgnore
    public Optional<String> resource() {
        return resource;
    }

    /**
     * The identifier uniquely referring to this balance.
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
     * The entity's date and time of creation, in [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601) format.
     */
    @JsonIgnore
    public Optional<String> createdAt() {
        return createdAt;
    }

    /**
     * The balance's ISO 4217 currency code.
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<Currency> currency() {
        return (Optional<Currency>) currency;
    }

    /**
     * The description or name of the balance. Can be used to denote the purpose of the balance.
     */
    @JsonIgnore
    public Optional<String> description() {
        return description;
    }

    /**
     * The status of the balance.
     * 
     * <p>Possible values: `active` `inactive`
     */
    @JsonIgnore
    public Optional<String> status() {
        return status;
    }

    /**
     * The frequency with which the available amount on the balance will be settled to the configured transfer destination.
     * 
     * <p>Settlements created during weekends or on bank holidays will take place on the next business day.
     * 
     * <p>Possible values: `daily` `every-monday` `every-tuesday` `every-wednesday` `every-thursday` `every-friday` `monthly` `never`
     */
    @JsonIgnore
    public Optional<String> transferFrequency() {
        return transferFrequency;
    }

    /**
     * The minimum amount configured for scheduled automatic settlements. As soon as the amount on the balance exceeds this threshold, the complete balance will be paid out to the transfer destination according to the configured frequency.
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<TransferThreshold> transferThreshold() {
        return (Optional<TransferThreshold>) transferThreshold;
    }

    /**
     * The transfer reference set to be included in all the transfers for this balance.
     */
    @JsonIgnore
    public JsonNullable<String> transferReference() {
        return transferReference;
    }

    /**
     * The destination where the available amount will be automatically transferred to according to the configured transfer frequency.
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public JsonNullable<TransferDestination> transferDestination() {
        return (JsonNullable<TransferDestination>) transferDestination;
    }

    /**
     * The amount directly available on the balance, e.g. `{"currency":"EUR", "value":"100.00"}`.
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<AvailableAmount> availableAmount() {
        return (Optional<AvailableAmount>) availableAmount;
    }

    /**
     * The total amount that is queued to be transferred to your balance. For example, a credit card payment can take a few days to clear.
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<PendingAmount> pendingAmount() {
        return (Optional<PendingAmount>) pendingAmount;
    }

    /**
     * An object with several relevant URLs. Every URL object will contain an `href` and a `type` field.
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<GetBalanceLinks> links() {
        return (Optional<GetBalanceLinks>) links;
    }

    public static Builder builder() {
        return new Builder();
    }


    /**
     * Indicates the response contains a balance object. Will always contain the string `balance` for this endpoint.
     */
    public GetBalanceResponseBody withResource(String resource) {
        Utils.checkNotNull(resource, "resource");
        this.resource = Optional.ofNullable(resource);
        return this;
    }


    /**
     * Indicates the response contains a balance object. Will always contain the string `balance` for this endpoint.
     */
    public GetBalanceResponseBody withResource(Optional<String> resource) {
        Utils.checkNotNull(resource, "resource");
        this.resource = resource;
        return this;
    }

    /**
     * The identifier uniquely referring to this balance.
     */
    public GetBalanceResponseBody withId(String id) {
        Utils.checkNotNull(id, "id");
        this.id = Optional.ofNullable(id);
        return this;
    }


    /**
     * The identifier uniquely referring to this balance.
     */
    public GetBalanceResponseBody withId(Optional<String> id) {
        Utils.checkNotNull(id, "id");
        this.id = id;
        return this;
    }

    /**
     * Whether this entity was created in live mode or in test mode.
     * 
     * <p>Possible values: `live` `test`
     */
    public GetBalanceResponseBody withMode(String mode) {
        Utils.checkNotNull(mode, "mode");
        this.mode = Optional.ofNullable(mode);
        return this;
    }


    /**
     * Whether this entity was created in live mode or in test mode.
     * 
     * <p>Possible values: `live` `test`
     */
    public GetBalanceResponseBody withMode(Optional<String> mode) {
        Utils.checkNotNull(mode, "mode");
        this.mode = mode;
        return this;
    }

    /**
     * The entity's date and time of creation, in [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601) format.
     */
    public GetBalanceResponseBody withCreatedAt(String createdAt) {
        Utils.checkNotNull(createdAt, "createdAt");
        this.createdAt = Optional.ofNullable(createdAt);
        return this;
    }


    /**
     * The entity's date and time of creation, in [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601) format.
     */
    public GetBalanceResponseBody withCreatedAt(Optional<String> createdAt) {
        Utils.checkNotNull(createdAt, "createdAt");
        this.createdAt = createdAt;
        return this;
    }

    /**
     * The balance's ISO 4217 currency code.
     */
    public GetBalanceResponseBody withCurrency(Currency currency) {
        Utils.checkNotNull(currency, "currency");
        this.currency = Optional.ofNullable(currency);
        return this;
    }


    /**
     * The balance's ISO 4217 currency code.
     */
    public GetBalanceResponseBody withCurrency(Optional<? extends Currency> currency) {
        Utils.checkNotNull(currency, "currency");
        this.currency = currency;
        return this;
    }

    /**
     * The description or name of the balance. Can be used to denote the purpose of the balance.
     */
    public GetBalanceResponseBody withDescription(String description) {
        Utils.checkNotNull(description, "description");
        this.description = Optional.ofNullable(description);
        return this;
    }


    /**
     * The description or name of the balance. Can be used to denote the purpose of the balance.
     */
    public GetBalanceResponseBody withDescription(Optional<String> description) {
        Utils.checkNotNull(description, "description");
        this.description = description;
        return this;
    }

    /**
     * The status of the balance.
     * 
     * <p>Possible values: `active` `inactive`
     */
    public GetBalanceResponseBody withStatus(String status) {
        Utils.checkNotNull(status, "status");
        this.status = Optional.ofNullable(status);
        return this;
    }


    /**
     * The status of the balance.
     * 
     * <p>Possible values: `active` `inactive`
     */
    public GetBalanceResponseBody withStatus(Optional<String> status) {
        Utils.checkNotNull(status, "status");
        this.status = status;
        return this;
    }

    /**
     * The frequency with which the available amount on the balance will be settled to the configured transfer destination.
     * 
     * <p>Settlements created during weekends or on bank holidays will take place on the next business day.
     * 
     * <p>Possible values: `daily` `every-monday` `every-tuesday` `every-wednesday` `every-thursday` `every-friday` `monthly` `never`
     */
    public GetBalanceResponseBody withTransferFrequency(String transferFrequency) {
        Utils.checkNotNull(transferFrequency, "transferFrequency");
        this.transferFrequency = Optional.ofNullable(transferFrequency);
        return this;
    }


    /**
     * The frequency with which the available amount on the balance will be settled to the configured transfer destination.
     * 
     * <p>Settlements created during weekends or on bank holidays will take place on the next business day.
     * 
     * <p>Possible values: `daily` `every-monday` `every-tuesday` `every-wednesday` `every-thursday` `every-friday` `monthly` `never`
     */
    public GetBalanceResponseBody withTransferFrequency(Optional<String> transferFrequency) {
        Utils.checkNotNull(transferFrequency, "transferFrequency");
        this.transferFrequency = transferFrequency;
        return this;
    }

    /**
     * The minimum amount configured for scheduled automatic settlements. As soon as the amount on the balance exceeds this threshold, the complete balance will be paid out to the transfer destination according to the configured frequency.
     */
    public GetBalanceResponseBody withTransferThreshold(TransferThreshold transferThreshold) {
        Utils.checkNotNull(transferThreshold, "transferThreshold");
        this.transferThreshold = Optional.ofNullable(transferThreshold);
        return this;
    }


    /**
     * The minimum amount configured for scheduled automatic settlements. As soon as the amount on the balance exceeds this threshold, the complete balance will be paid out to the transfer destination according to the configured frequency.
     */
    public GetBalanceResponseBody withTransferThreshold(Optional<? extends TransferThreshold> transferThreshold) {
        Utils.checkNotNull(transferThreshold, "transferThreshold");
        this.transferThreshold = transferThreshold;
        return this;
    }

    /**
     * The transfer reference set to be included in all the transfers for this balance.
     */
    public GetBalanceResponseBody withTransferReference(String transferReference) {
        Utils.checkNotNull(transferReference, "transferReference");
        this.transferReference = JsonNullable.of(transferReference);
        return this;
    }

    /**
     * The transfer reference set to be included in all the transfers for this balance.
     */
    public GetBalanceResponseBody withTransferReference(JsonNullable<String> transferReference) {
        Utils.checkNotNull(transferReference, "transferReference");
        this.transferReference = transferReference;
        return this;
    }

    /**
     * The destination where the available amount will be automatically transferred to according to the configured transfer frequency.
     */
    public GetBalanceResponseBody withTransferDestination(TransferDestination transferDestination) {
        Utils.checkNotNull(transferDestination, "transferDestination");
        this.transferDestination = JsonNullable.of(transferDestination);
        return this;
    }

    /**
     * The destination where the available amount will be automatically transferred to according to the configured transfer frequency.
     */
    public GetBalanceResponseBody withTransferDestination(JsonNullable<? extends TransferDestination> transferDestination) {
        Utils.checkNotNull(transferDestination, "transferDestination");
        this.transferDestination = transferDestination;
        return this;
    }

    /**
     * The amount directly available on the balance, e.g. `{"currency":"EUR", "value":"100.00"}`.
     */
    public GetBalanceResponseBody withAvailableAmount(AvailableAmount availableAmount) {
        Utils.checkNotNull(availableAmount, "availableAmount");
        this.availableAmount = Optional.ofNullable(availableAmount);
        return this;
    }


    /**
     * The amount directly available on the balance, e.g. `{"currency":"EUR", "value":"100.00"}`.
     */
    public GetBalanceResponseBody withAvailableAmount(Optional<? extends AvailableAmount> availableAmount) {
        Utils.checkNotNull(availableAmount, "availableAmount");
        this.availableAmount = availableAmount;
        return this;
    }

    /**
     * The total amount that is queued to be transferred to your balance. For example, a credit card payment can take a few days to clear.
     */
    public GetBalanceResponseBody withPendingAmount(PendingAmount pendingAmount) {
        Utils.checkNotNull(pendingAmount, "pendingAmount");
        this.pendingAmount = Optional.ofNullable(pendingAmount);
        return this;
    }


    /**
     * The total amount that is queued to be transferred to your balance. For example, a credit card payment can take a few days to clear.
     */
    public GetBalanceResponseBody withPendingAmount(Optional<? extends PendingAmount> pendingAmount) {
        Utils.checkNotNull(pendingAmount, "pendingAmount");
        this.pendingAmount = pendingAmount;
        return this;
    }

    /**
     * An object with several relevant URLs. Every URL object will contain an `href` and a `type` field.
     */
    public GetBalanceResponseBody withLinks(GetBalanceLinks links) {
        Utils.checkNotNull(links, "links");
        this.links = Optional.ofNullable(links);
        return this;
    }


    /**
     * An object with several relevant URLs. Every URL object will contain an `href` and a `type` field.
     */
    public GetBalanceResponseBody withLinks(Optional<? extends GetBalanceLinks> links) {
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
        GetBalanceResponseBody other = (GetBalanceResponseBody) o;
        return 
            Utils.enhancedDeepEquals(this.resource, other.resource) &&
            Utils.enhancedDeepEquals(this.id, other.id) &&
            Utils.enhancedDeepEquals(this.mode, other.mode) &&
            Utils.enhancedDeepEquals(this.createdAt, other.createdAt) &&
            Utils.enhancedDeepEquals(this.currency, other.currency) &&
            Utils.enhancedDeepEquals(this.description, other.description) &&
            Utils.enhancedDeepEquals(this.status, other.status) &&
            Utils.enhancedDeepEquals(this.transferFrequency, other.transferFrequency) &&
            Utils.enhancedDeepEquals(this.transferThreshold, other.transferThreshold) &&
            Utils.enhancedDeepEquals(this.transferReference, other.transferReference) &&
            Utils.enhancedDeepEquals(this.transferDestination, other.transferDestination) &&
            Utils.enhancedDeepEquals(this.availableAmount, other.availableAmount) &&
            Utils.enhancedDeepEquals(this.pendingAmount, other.pendingAmount) &&
            Utils.enhancedDeepEquals(this.links, other.links);
    }
    
    @Override
    public int hashCode() {
        return Utils.enhancedHash(
            resource, id, mode,
            createdAt, currency, description,
            status, transferFrequency, transferThreshold,
            transferReference, transferDestination, availableAmount,
            pendingAmount, links);
    }
    
    @Override
    public String toString() {
        return Utils.toString(GetBalanceResponseBody.class,
                "resource", resource,
                "id", id,
                "mode", mode,
                "createdAt", createdAt,
                "currency", currency,
                "description", description,
                "status", status,
                "transferFrequency", transferFrequency,
                "transferThreshold", transferThreshold,
                "transferReference", transferReference,
                "transferDestination", transferDestination,
                "availableAmount", availableAmount,
                "pendingAmount", pendingAmount,
                "links", links);
    }

    @SuppressWarnings("UnusedReturnValue")
    public final static class Builder {

        private Optional<String> resource;

        private Optional<String> id = Optional.empty();

        private Optional<String> mode = Optional.empty();

        private Optional<String> createdAt = Optional.empty();

        private Optional<? extends Currency> currency = Optional.empty();

        private Optional<String> description = Optional.empty();

        private Optional<String> status = Optional.empty();

        private Optional<String> transferFrequency = Optional.empty();

        private Optional<? extends TransferThreshold> transferThreshold = Optional.empty();

        private JsonNullable<String> transferReference = JsonNullable.undefined();

        private JsonNullable<? extends TransferDestination> transferDestination = JsonNullable.undefined();

        private Optional<? extends AvailableAmount> availableAmount = Optional.empty();

        private Optional<? extends PendingAmount> pendingAmount = Optional.empty();

        private Optional<? extends GetBalanceLinks> links = Optional.empty();

        private Builder() {
          // force use of static builder() method
        }


        /**
         * Indicates the response contains a balance object. Will always contain the string `balance` for this endpoint.
         */
        public Builder resource(String resource) {
            Utils.checkNotNull(resource, "resource");
            this.resource = Optional.ofNullable(resource);
            return this;
        }

        /**
         * Indicates the response contains a balance object. Will always contain the string `balance` for this endpoint.
         */
        public Builder resource(Optional<String> resource) {
            Utils.checkNotNull(resource, "resource");
            this.resource = resource;
            return this;
        }


        /**
         * The identifier uniquely referring to this balance.
         */
        public Builder id(String id) {
            Utils.checkNotNull(id, "id");
            this.id = Optional.ofNullable(id);
            return this;
        }

        /**
         * The identifier uniquely referring to this balance.
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
         * The balance's ISO 4217 currency code.
         */
        public Builder currency(Currency currency) {
            Utils.checkNotNull(currency, "currency");
            this.currency = Optional.ofNullable(currency);
            return this;
        }

        /**
         * The balance's ISO 4217 currency code.
         */
        public Builder currency(Optional<? extends Currency> currency) {
            Utils.checkNotNull(currency, "currency");
            this.currency = currency;
            return this;
        }


        /**
         * The description or name of the balance. Can be used to denote the purpose of the balance.
         */
        public Builder description(String description) {
            Utils.checkNotNull(description, "description");
            this.description = Optional.ofNullable(description);
            return this;
        }

        /**
         * The description or name of the balance. Can be used to denote the purpose of the balance.
         */
        public Builder description(Optional<String> description) {
            Utils.checkNotNull(description, "description");
            this.description = description;
            return this;
        }


        /**
         * The status of the balance.
         * 
         * <p>Possible values: `active` `inactive`
         */
        public Builder status(String status) {
            Utils.checkNotNull(status, "status");
            this.status = Optional.ofNullable(status);
            return this;
        }

        /**
         * The status of the balance.
         * 
         * <p>Possible values: `active` `inactive`
         */
        public Builder status(Optional<String> status) {
            Utils.checkNotNull(status, "status");
            this.status = status;
            return this;
        }


        /**
         * The frequency with which the available amount on the balance will be settled to the configured transfer destination.
         * 
         * <p>Settlements created during weekends or on bank holidays will take place on the next business day.
         * 
         * <p>Possible values: `daily` `every-monday` `every-tuesday` `every-wednesday` `every-thursday` `every-friday` `monthly` `never`
         */
        public Builder transferFrequency(String transferFrequency) {
            Utils.checkNotNull(transferFrequency, "transferFrequency");
            this.transferFrequency = Optional.ofNullable(transferFrequency);
            return this;
        }

        /**
         * The frequency with which the available amount on the balance will be settled to the configured transfer destination.
         * 
         * <p>Settlements created during weekends or on bank holidays will take place on the next business day.
         * 
         * <p>Possible values: `daily` `every-monday` `every-tuesday` `every-wednesday` `every-thursday` `every-friday` `monthly` `never`
         */
        public Builder transferFrequency(Optional<String> transferFrequency) {
            Utils.checkNotNull(transferFrequency, "transferFrequency");
            this.transferFrequency = transferFrequency;
            return this;
        }


        /**
         * The minimum amount configured for scheduled automatic settlements. As soon as the amount on the balance exceeds this threshold, the complete balance will be paid out to the transfer destination according to the configured frequency.
         */
        public Builder transferThreshold(TransferThreshold transferThreshold) {
            Utils.checkNotNull(transferThreshold, "transferThreshold");
            this.transferThreshold = Optional.ofNullable(transferThreshold);
            return this;
        }

        /**
         * The minimum amount configured for scheduled automatic settlements. As soon as the amount on the balance exceeds this threshold, the complete balance will be paid out to the transfer destination according to the configured frequency.
         */
        public Builder transferThreshold(Optional<? extends TransferThreshold> transferThreshold) {
            Utils.checkNotNull(transferThreshold, "transferThreshold");
            this.transferThreshold = transferThreshold;
            return this;
        }


        /**
         * The transfer reference set to be included in all the transfers for this balance.
         */
        public Builder transferReference(String transferReference) {
            Utils.checkNotNull(transferReference, "transferReference");
            this.transferReference = JsonNullable.of(transferReference);
            return this;
        }

        /**
         * The transfer reference set to be included in all the transfers for this balance.
         */
        public Builder transferReference(JsonNullable<String> transferReference) {
            Utils.checkNotNull(transferReference, "transferReference");
            this.transferReference = transferReference;
            return this;
        }


        /**
         * The destination where the available amount will be automatically transferred to according to the configured transfer frequency.
         */
        public Builder transferDestination(TransferDestination transferDestination) {
            Utils.checkNotNull(transferDestination, "transferDestination");
            this.transferDestination = JsonNullable.of(transferDestination);
            return this;
        }

        /**
         * The destination where the available amount will be automatically transferred to according to the configured transfer frequency.
         */
        public Builder transferDestination(JsonNullable<? extends TransferDestination> transferDestination) {
            Utils.checkNotNull(transferDestination, "transferDestination");
            this.transferDestination = transferDestination;
            return this;
        }


        /**
         * The amount directly available on the balance, e.g. `{"currency":"EUR", "value":"100.00"}`.
         */
        public Builder availableAmount(AvailableAmount availableAmount) {
            Utils.checkNotNull(availableAmount, "availableAmount");
            this.availableAmount = Optional.ofNullable(availableAmount);
            return this;
        }

        /**
         * The amount directly available on the balance, e.g. `{"currency":"EUR", "value":"100.00"}`.
         */
        public Builder availableAmount(Optional<? extends AvailableAmount> availableAmount) {
            Utils.checkNotNull(availableAmount, "availableAmount");
            this.availableAmount = availableAmount;
            return this;
        }


        /**
         * The total amount that is queued to be transferred to your balance. For example, a credit card payment can take a few days to clear.
         */
        public Builder pendingAmount(PendingAmount pendingAmount) {
            Utils.checkNotNull(pendingAmount, "pendingAmount");
            this.pendingAmount = Optional.ofNullable(pendingAmount);
            return this;
        }

        /**
         * The total amount that is queued to be transferred to your balance. For example, a credit card payment can take a few days to clear.
         */
        public Builder pendingAmount(Optional<? extends PendingAmount> pendingAmount) {
            Utils.checkNotNull(pendingAmount, "pendingAmount");
            this.pendingAmount = pendingAmount;
            return this;
        }


        /**
         * An object with several relevant URLs. Every URL object will contain an `href` and a `type` field.
         */
        public Builder links(GetBalanceLinks links) {
            Utils.checkNotNull(links, "links");
            this.links = Optional.ofNullable(links);
            return this;
        }

        /**
         * An object with several relevant URLs. Every URL object will contain an `href` and a `type` field.
         */
        public Builder links(Optional<? extends GetBalanceLinks> links) {
            Utils.checkNotNull(links, "links");
            this.links = links;
            return this;
        }

        public GetBalanceResponseBody build() {
            if (resource == null) {
                resource = _SINGLETON_VALUE_Resource.value();
            }

            return new GetBalanceResponseBody(
                resource, id, mode,
                createdAt, currency, description,
                status, transferFrequency, transferThreshold,
                transferReference, transferDestination, availableAmount,
                pendingAmount, links);
        }


        private static final LazySingletonValue<Optional<String>> _SINGLETON_VALUE_Resource =
                new LazySingletonValue<>(
                        "resource",
                        "\"balance\"",
                        new TypeReference<Optional<String>>() {});
    }
}
