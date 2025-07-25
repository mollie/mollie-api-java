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
import java.lang.Boolean;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.List;
import java.util.Optional;
import org.openapitools.jackson.nullable.JsonNullable;


public class CreateRefundRequestBody {
    /**
     * The description of the refund that may be shown to your customer, depending on the payment method used.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("description")
    private Optional<String> description;

    /**
     * The amount refunded to your customer with this refund. The amount is allowed to be lower than the original payment amount.
     */
    @JsonProperty("amount")
    private CreateRefundAmount amount;

    /**
     * Provide any data you like, for example a string or a JSON object. We will save the data alongside the entity. Whenever you fetch the entity with our API, we will also include the metadata. You can use up to approximately 1kB.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("metadata")
    private JsonNullable<? extends CreateRefundMetadata> metadata;


    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("externalReference")
    private Optional<? extends ExternalReference> externalReference;

    /**
     * *This feature is only available to marketplace operators.*
     * 
     * <p>With Mollie Connect you can charge fees on payments that your app is processing on behalf of other Mollie merchants, by providing the `routing` object during [payment creation](create-payment).
     * 
     * <p>When creating refunds for these *routed* payments, by default the full amount is deducted from your balance.
     * 
     * <p>If you want to pull back the funds that were routed to the connected merchant(s), you can set this parameter to `true` when issuing a full refund.
     * 
     * <p>For more fine-grained control and for partial refunds, use the `routingReversals` parameter instead.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("reverseRouting")
    private JsonNullable<Boolean> reverseRouting;

    /**
     * *This feature is only available to marketplace operators.*
     * 
     * <p>When creating refunds for *routed* payments, by default the full amount is deducted from your balance.
     * 
     * <p>If you want to pull back funds from the connected merchant(s), you can use this parameter to specify what amount needs to be reversed from which merchant(s).
     * 
     * <p>If you simply want to fully reverse the routed funds, you can also use the `reverseRouting` parameter instead.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("routingReversals")
    private JsonNullable<? extends List<RoutingReversals>> routingReversals;

    /**
     * Whether to create the entity in test mode or live mode.
     * 
     * <p>Most API credentials are specifically created for either live mode or test mode, in which case this parameter can be omitted. For organization-level credentials such as OAuth access tokens, you can enable test mode by setting `testmode` to `true`.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("testmode")
    private JsonNullable<Boolean> testmode;

    @JsonCreator
    public CreateRefundRequestBody(
            @JsonProperty("description") Optional<String> description,
            @JsonProperty("amount") CreateRefundAmount amount,
            @JsonProperty("metadata") JsonNullable<? extends CreateRefundMetadata> metadata,
            @JsonProperty("externalReference") Optional<? extends ExternalReference> externalReference,
            @JsonProperty("reverseRouting") JsonNullable<Boolean> reverseRouting,
            @JsonProperty("routingReversals") JsonNullable<? extends List<RoutingReversals>> routingReversals,
            @JsonProperty("testmode") JsonNullable<Boolean> testmode) {
        Utils.checkNotNull(description, "description");
        Utils.checkNotNull(amount, "amount");
        Utils.checkNotNull(metadata, "metadata");
        Utils.checkNotNull(externalReference, "externalReference");
        Utils.checkNotNull(reverseRouting, "reverseRouting");
        Utils.checkNotNull(routingReversals, "routingReversals");
        Utils.checkNotNull(testmode, "testmode");
        this.description = description;
        this.amount = amount;
        this.metadata = metadata;
        this.externalReference = externalReference;
        this.reverseRouting = reverseRouting;
        this.routingReversals = routingReversals;
        this.testmode = testmode;
    }
    
    public CreateRefundRequestBody(
            CreateRefundAmount amount) {
        this(Optional.empty(), amount, JsonNullable.undefined(),
            Optional.empty(), JsonNullable.undefined(), JsonNullable.undefined(),
            JsonNullable.undefined());
    }

    /**
     * The description of the refund that may be shown to your customer, depending on the payment method used.
     */
    @JsonIgnore
    public Optional<String> description() {
        return description;
    }

    /**
     * The amount refunded to your customer with this refund. The amount is allowed to be lower than the original payment amount.
     */
    @JsonIgnore
    public CreateRefundAmount amount() {
        return amount;
    }

    /**
     * Provide any data you like, for example a string or a JSON object. We will save the data alongside the entity. Whenever you fetch the entity with our API, we will also include the metadata. You can use up to approximately 1kB.
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public JsonNullable<CreateRefundMetadata> metadata() {
        return (JsonNullable<CreateRefundMetadata>) metadata;
    }

    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<ExternalReference> externalReference() {
        return (Optional<ExternalReference>) externalReference;
    }

    /**
     * *This feature is only available to marketplace operators.*
     * 
     * <p>With Mollie Connect you can charge fees on payments that your app is processing on behalf of other Mollie merchants, by providing the `routing` object during [payment creation](create-payment).
     * 
     * <p>When creating refunds for these *routed* payments, by default the full amount is deducted from your balance.
     * 
     * <p>If you want to pull back the funds that were routed to the connected merchant(s), you can set this parameter to `true` when issuing a full refund.
     * 
     * <p>For more fine-grained control and for partial refunds, use the `routingReversals` parameter instead.
     */
    @JsonIgnore
    public JsonNullable<Boolean> reverseRouting() {
        return reverseRouting;
    }

    /**
     * *This feature is only available to marketplace operators.*
     * 
     * <p>When creating refunds for *routed* payments, by default the full amount is deducted from your balance.
     * 
     * <p>If you want to pull back funds from the connected merchant(s), you can use this parameter to specify what amount needs to be reversed from which merchant(s).
     * 
     * <p>If you simply want to fully reverse the routed funds, you can also use the `reverseRouting` parameter instead.
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public JsonNullable<List<RoutingReversals>> routingReversals() {
        return (JsonNullable<List<RoutingReversals>>) routingReversals;
    }

    /**
     * Whether to create the entity in test mode or live mode.
     * 
     * <p>Most API credentials are specifically created for either live mode or test mode, in which case this parameter can be omitted. For organization-level credentials such as OAuth access tokens, you can enable test mode by setting `testmode` to `true`.
     */
    @JsonIgnore
    public JsonNullable<Boolean> testmode() {
        return testmode;
    }

    public static Builder builder() {
        return new Builder();
    }


    /**
     * The description of the refund that may be shown to your customer, depending on the payment method used.
     */
    public CreateRefundRequestBody withDescription(String description) {
        Utils.checkNotNull(description, "description");
        this.description = Optional.ofNullable(description);
        return this;
    }


    /**
     * The description of the refund that may be shown to your customer, depending on the payment method used.
     */
    public CreateRefundRequestBody withDescription(Optional<String> description) {
        Utils.checkNotNull(description, "description");
        this.description = description;
        return this;
    }

    /**
     * The amount refunded to your customer with this refund. The amount is allowed to be lower than the original payment amount.
     */
    public CreateRefundRequestBody withAmount(CreateRefundAmount amount) {
        Utils.checkNotNull(amount, "amount");
        this.amount = amount;
        return this;
    }

    /**
     * Provide any data you like, for example a string or a JSON object. We will save the data alongside the entity. Whenever you fetch the entity with our API, we will also include the metadata. You can use up to approximately 1kB.
     */
    public CreateRefundRequestBody withMetadata(CreateRefundMetadata metadata) {
        Utils.checkNotNull(metadata, "metadata");
        this.metadata = JsonNullable.of(metadata);
        return this;
    }

    /**
     * Provide any data you like, for example a string or a JSON object. We will save the data alongside the entity. Whenever you fetch the entity with our API, we will also include the metadata. You can use up to approximately 1kB.
     */
    public CreateRefundRequestBody withMetadata(JsonNullable<? extends CreateRefundMetadata> metadata) {
        Utils.checkNotNull(metadata, "metadata");
        this.metadata = metadata;
        return this;
    }

    public CreateRefundRequestBody withExternalReference(ExternalReference externalReference) {
        Utils.checkNotNull(externalReference, "externalReference");
        this.externalReference = Optional.ofNullable(externalReference);
        return this;
    }


    public CreateRefundRequestBody withExternalReference(Optional<? extends ExternalReference> externalReference) {
        Utils.checkNotNull(externalReference, "externalReference");
        this.externalReference = externalReference;
        return this;
    }

    /**
     * *This feature is only available to marketplace operators.*
     * 
     * <p>With Mollie Connect you can charge fees on payments that your app is processing on behalf of other Mollie merchants, by providing the `routing` object during [payment creation](create-payment).
     * 
     * <p>When creating refunds for these *routed* payments, by default the full amount is deducted from your balance.
     * 
     * <p>If you want to pull back the funds that were routed to the connected merchant(s), you can set this parameter to `true` when issuing a full refund.
     * 
     * <p>For more fine-grained control and for partial refunds, use the `routingReversals` parameter instead.
     */
    public CreateRefundRequestBody withReverseRouting(boolean reverseRouting) {
        Utils.checkNotNull(reverseRouting, "reverseRouting");
        this.reverseRouting = JsonNullable.of(reverseRouting);
        return this;
    }

    /**
     * *This feature is only available to marketplace operators.*
     * 
     * <p>With Mollie Connect you can charge fees on payments that your app is processing on behalf of other Mollie merchants, by providing the `routing` object during [payment creation](create-payment).
     * 
     * <p>When creating refunds for these *routed* payments, by default the full amount is deducted from your balance.
     * 
     * <p>If you want to pull back the funds that were routed to the connected merchant(s), you can set this parameter to `true` when issuing a full refund.
     * 
     * <p>For more fine-grained control and for partial refunds, use the `routingReversals` parameter instead.
     */
    public CreateRefundRequestBody withReverseRouting(JsonNullable<Boolean> reverseRouting) {
        Utils.checkNotNull(reverseRouting, "reverseRouting");
        this.reverseRouting = reverseRouting;
        return this;
    }

    /**
     * *This feature is only available to marketplace operators.*
     * 
     * <p>When creating refunds for *routed* payments, by default the full amount is deducted from your balance.
     * 
     * <p>If you want to pull back funds from the connected merchant(s), you can use this parameter to specify what amount needs to be reversed from which merchant(s).
     * 
     * <p>If you simply want to fully reverse the routed funds, you can also use the `reverseRouting` parameter instead.
     */
    public CreateRefundRequestBody withRoutingReversals(List<RoutingReversals> routingReversals) {
        Utils.checkNotNull(routingReversals, "routingReversals");
        this.routingReversals = JsonNullable.of(routingReversals);
        return this;
    }

    /**
     * *This feature is only available to marketplace operators.*
     * 
     * <p>When creating refunds for *routed* payments, by default the full amount is deducted from your balance.
     * 
     * <p>If you want to pull back funds from the connected merchant(s), you can use this parameter to specify what amount needs to be reversed from which merchant(s).
     * 
     * <p>If you simply want to fully reverse the routed funds, you can also use the `reverseRouting` parameter instead.
     */
    public CreateRefundRequestBody withRoutingReversals(JsonNullable<? extends List<RoutingReversals>> routingReversals) {
        Utils.checkNotNull(routingReversals, "routingReversals");
        this.routingReversals = routingReversals;
        return this;
    }

    /**
     * Whether to create the entity in test mode or live mode.
     * 
     * <p>Most API credentials are specifically created for either live mode or test mode, in which case this parameter can be omitted. For organization-level credentials such as OAuth access tokens, you can enable test mode by setting `testmode` to `true`.
     */
    public CreateRefundRequestBody withTestmode(boolean testmode) {
        Utils.checkNotNull(testmode, "testmode");
        this.testmode = JsonNullable.of(testmode);
        return this;
    }

    /**
     * Whether to create the entity in test mode or live mode.
     * 
     * <p>Most API credentials are specifically created for either live mode or test mode, in which case this parameter can be omitted. For organization-level credentials such as OAuth access tokens, you can enable test mode by setting `testmode` to `true`.
     */
    public CreateRefundRequestBody withTestmode(JsonNullable<Boolean> testmode) {
        Utils.checkNotNull(testmode, "testmode");
        this.testmode = testmode;
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
        CreateRefundRequestBody other = (CreateRefundRequestBody) o;
        return 
            Utils.enhancedDeepEquals(this.description, other.description) &&
            Utils.enhancedDeepEquals(this.amount, other.amount) &&
            Utils.enhancedDeepEquals(this.metadata, other.metadata) &&
            Utils.enhancedDeepEquals(this.externalReference, other.externalReference) &&
            Utils.enhancedDeepEquals(this.reverseRouting, other.reverseRouting) &&
            Utils.enhancedDeepEquals(this.routingReversals, other.routingReversals) &&
            Utils.enhancedDeepEquals(this.testmode, other.testmode);
    }
    
    @Override
    public int hashCode() {
        return Utils.enhancedHash(
            description, amount, metadata,
            externalReference, reverseRouting, routingReversals,
            testmode);
    }
    
    @Override
    public String toString() {
        return Utils.toString(CreateRefundRequestBody.class,
                "description", description,
                "amount", amount,
                "metadata", metadata,
                "externalReference", externalReference,
                "reverseRouting", reverseRouting,
                "routingReversals", routingReversals,
                "testmode", testmode);
    }

    @SuppressWarnings("UnusedReturnValue")
    public final static class Builder {

        private Optional<String> description = Optional.empty();

        private CreateRefundAmount amount;

        private JsonNullable<? extends CreateRefundMetadata> metadata = JsonNullable.undefined();

        private Optional<? extends ExternalReference> externalReference = Optional.empty();

        private JsonNullable<Boolean> reverseRouting = JsonNullable.undefined();

        private JsonNullable<? extends List<RoutingReversals>> routingReversals = JsonNullable.undefined();

        private JsonNullable<Boolean> testmode = JsonNullable.undefined();

        private Builder() {
          // force use of static builder() method
        }


        /**
         * The description of the refund that may be shown to your customer, depending on the payment method used.
         */
        public Builder description(String description) {
            Utils.checkNotNull(description, "description");
            this.description = Optional.ofNullable(description);
            return this;
        }

        /**
         * The description of the refund that may be shown to your customer, depending on the payment method used.
         */
        public Builder description(Optional<String> description) {
            Utils.checkNotNull(description, "description");
            this.description = description;
            return this;
        }


        /**
         * The amount refunded to your customer with this refund. The amount is allowed to be lower than the original payment amount.
         */
        public Builder amount(CreateRefundAmount amount) {
            Utils.checkNotNull(amount, "amount");
            this.amount = amount;
            return this;
        }


        /**
         * Provide any data you like, for example a string or a JSON object. We will save the data alongside the entity. Whenever you fetch the entity with our API, we will also include the metadata. You can use up to approximately 1kB.
         */
        public Builder metadata(CreateRefundMetadata metadata) {
            Utils.checkNotNull(metadata, "metadata");
            this.metadata = JsonNullable.of(metadata);
            return this;
        }

        /**
         * Provide any data you like, for example a string or a JSON object. We will save the data alongside the entity. Whenever you fetch the entity with our API, we will also include the metadata. You can use up to approximately 1kB.
         */
        public Builder metadata(JsonNullable<? extends CreateRefundMetadata> metadata) {
            Utils.checkNotNull(metadata, "metadata");
            this.metadata = metadata;
            return this;
        }


        public Builder externalReference(ExternalReference externalReference) {
            Utils.checkNotNull(externalReference, "externalReference");
            this.externalReference = Optional.ofNullable(externalReference);
            return this;
        }

        public Builder externalReference(Optional<? extends ExternalReference> externalReference) {
            Utils.checkNotNull(externalReference, "externalReference");
            this.externalReference = externalReference;
            return this;
        }


        /**
         * *This feature is only available to marketplace operators.*
         * 
         * <p>With Mollie Connect you can charge fees on payments that your app is processing on behalf of other Mollie merchants, by providing the `routing` object during [payment creation](create-payment).
         * 
         * <p>When creating refunds for these *routed* payments, by default the full amount is deducted from your balance.
         * 
         * <p>If you want to pull back the funds that were routed to the connected merchant(s), you can set this parameter to `true` when issuing a full refund.
         * 
         * <p>For more fine-grained control and for partial refunds, use the `routingReversals` parameter instead.
         */
        public Builder reverseRouting(boolean reverseRouting) {
            Utils.checkNotNull(reverseRouting, "reverseRouting");
            this.reverseRouting = JsonNullable.of(reverseRouting);
            return this;
        }

        /**
         * *This feature is only available to marketplace operators.*
         * 
         * <p>With Mollie Connect you can charge fees on payments that your app is processing on behalf of other Mollie merchants, by providing the `routing` object during [payment creation](create-payment).
         * 
         * <p>When creating refunds for these *routed* payments, by default the full amount is deducted from your balance.
         * 
         * <p>If you want to pull back the funds that were routed to the connected merchant(s), you can set this parameter to `true` when issuing a full refund.
         * 
         * <p>For more fine-grained control and for partial refunds, use the `routingReversals` parameter instead.
         */
        public Builder reverseRouting(JsonNullable<Boolean> reverseRouting) {
            Utils.checkNotNull(reverseRouting, "reverseRouting");
            this.reverseRouting = reverseRouting;
            return this;
        }


        /**
         * *This feature is only available to marketplace operators.*
         * 
         * <p>When creating refunds for *routed* payments, by default the full amount is deducted from your balance.
         * 
         * <p>If you want to pull back funds from the connected merchant(s), you can use this parameter to specify what amount needs to be reversed from which merchant(s).
         * 
         * <p>If you simply want to fully reverse the routed funds, you can also use the `reverseRouting` parameter instead.
         */
        public Builder routingReversals(List<RoutingReversals> routingReversals) {
            Utils.checkNotNull(routingReversals, "routingReversals");
            this.routingReversals = JsonNullable.of(routingReversals);
            return this;
        }

        /**
         * *This feature is only available to marketplace operators.*
         * 
         * <p>When creating refunds for *routed* payments, by default the full amount is deducted from your balance.
         * 
         * <p>If you want to pull back funds from the connected merchant(s), you can use this parameter to specify what amount needs to be reversed from which merchant(s).
         * 
         * <p>If you simply want to fully reverse the routed funds, you can also use the `reverseRouting` parameter instead.
         */
        public Builder routingReversals(JsonNullable<? extends List<RoutingReversals>> routingReversals) {
            Utils.checkNotNull(routingReversals, "routingReversals");
            this.routingReversals = routingReversals;
            return this;
        }


        /**
         * Whether to create the entity in test mode or live mode.
         * 
         * <p>Most API credentials are specifically created for either live mode or test mode, in which case this parameter can be omitted. For organization-level credentials such as OAuth access tokens, you can enable test mode by setting `testmode` to `true`.
         */
        public Builder testmode(boolean testmode) {
            Utils.checkNotNull(testmode, "testmode");
            this.testmode = JsonNullable.of(testmode);
            return this;
        }

        /**
         * Whether to create the entity in test mode or live mode.
         * 
         * <p>Most API credentials are specifically created for either live mode or test mode, in which case this parameter can be omitted. For organization-level credentials such as OAuth access tokens, you can enable test mode by setting `testmode` to `true`.
         */
        public Builder testmode(JsonNullable<Boolean> testmode) {
            Utils.checkNotNull(testmode, "testmode");
            this.testmode = testmode;
            return this;
        }

        public CreateRefundRequestBody build() {

            return new CreateRefundRequestBody(
                description, amount, metadata,
                externalReference, reverseRouting, routingReversals,
                testmode);
        }

    }
}
