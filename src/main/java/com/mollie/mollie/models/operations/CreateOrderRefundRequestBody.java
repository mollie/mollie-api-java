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


public class CreateOrderRefundRequestBody {
    /**
     * The description of the refund that may be shown to your customer, depending on the payment method used.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("description")
    private Optional<String> description;

    /**
     * The amount refunded to your customer with this refund. The amount is allowed to be lower than the original payment amount.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("amount")
    private Optional<? extends CreateOrderRefundAmount> amount;

    /**
     * Provide any data you like, for example a string or a JSON object. We will save the data alongside the entity. Whenever you fetch the entity with our API, we will also include the metadata. You can use up to approximately 1kB.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("metadata")
    private JsonNullable<? extends CreateOrderRefundMetadata> metadata;


    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("externalReference")
    private Optional<? extends CreateOrderRefundExternalReference> externalReference;

    /**
     * Whether to create the entity in test mode or live mode.
     * 
     * <p>Most API credentials are specifically created for either live mode or test mode, in which case this parameter can be omitted. For organization-level credentials such as OAuth access tokens, you can enable test mode by setting `testmode` to `true`.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("testmode")
    private JsonNullable<Boolean> testmode;

    /**
     * A refund can optionally be linked to specific order lines.
     * 
     * <p>The lines will show the `quantity`, `discountAmount`, `vatAmount`, and `totalAmount` refunded. If the line was partially refunded, these values will be different from the values in response from the [Get payment](get-payment) endpoint.
     */
    @JsonProperty("lines")
    private List<CreateOrderRefundLines> lines;

    @JsonCreator
    public CreateOrderRefundRequestBody(
            @JsonProperty("description") Optional<String> description,
            @JsonProperty("amount") Optional<? extends CreateOrderRefundAmount> amount,
            @JsonProperty("metadata") JsonNullable<? extends CreateOrderRefundMetadata> metadata,
            @JsonProperty("externalReference") Optional<? extends CreateOrderRefundExternalReference> externalReference,
            @JsonProperty("testmode") JsonNullable<Boolean> testmode,
            @JsonProperty("lines") List<CreateOrderRefundLines> lines) {
        Utils.checkNotNull(description, "description");
        Utils.checkNotNull(amount, "amount");
        Utils.checkNotNull(metadata, "metadata");
        Utils.checkNotNull(externalReference, "externalReference");
        Utils.checkNotNull(testmode, "testmode");
        Utils.checkNotNull(lines, "lines");
        this.description = description;
        this.amount = amount;
        this.metadata = metadata;
        this.externalReference = externalReference;
        this.testmode = testmode;
        this.lines = lines;
    }
    
    public CreateOrderRefundRequestBody(
            List<CreateOrderRefundLines> lines) {
        this(Optional.empty(), Optional.empty(), JsonNullable.undefined(),
            Optional.empty(), JsonNullable.undefined(), lines);
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
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<CreateOrderRefundAmount> amount() {
        return (Optional<CreateOrderRefundAmount>) amount;
    }

    /**
     * Provide any data you like, for example a string or a JSON object. We will save the data alongside the entity. Whenever you fetch the entity with our API, we will also include the metadata. You can use up to approximately 1kB.
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public JsonNullable<CreateOrderRefundMetadata> metadata() {
        return (JsonNullable<CreateOrderRefundMetadata>) metadata;
    }

    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<CreateOrderRefundExternalReference> externalReference() {
        return (Optional<CreateOrderRefundExternalReference>) externalReference;
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

    /**
     * A refund can optionally be linked to specific order lines.
     * 
     * <p>The lines will show the `quantity`, `discountAmount`, `vatAmount`, and `totalAmount` refunded. If the line was partially refunded, these values will be different from the values in response from the [Get payment](get-payment) endpoint.
     */
    @JsonIgnore
    public List<CreateOrderRefundLines> lines() {
        return lines;
    }

    public static Builder builder() {
        return new Builder();
    }


    /**
     * The description of the refund that may be shown to your customer, depending on the payment method used.
     */
    public CreateOrderRefundRequestBody withDescription(String description) {
        Utils.checkNotNull(description, "description");
        this.description = Optional.ofNullable(description);
        return this;
    }


    /**
     * The description of the refund that may be shown to your customer, depending on the payment method used.
     */
    public CreateOrderRefundRequestBody withDescription(Optional<String> description) {
        Utils.checkNotNull(description, "description");
        this.description = description;
        return this;
    }

    /**
     * The amount refunded to your customer with this refund. The amount is allowed to be lower than the original payment amount.
     */
    public CreateOrderRefundRequestBody withAmount(CreateOrderRefundAmount amount) {
        Utils.checkNotNull(amount, "amount");
        this.amount = Optional.ofNullable(amount);
        return this;
    }


    /**
     * The amount refunded to your customer with this refund. The amount is allowed to be lower than the original payment amount.
     */
    public CreateOrderRefundRequestBody withAmount(Optional<? extends CreateOrderRefundAmount> amount) {
        Utils.checkNotNull(amount, "amount");
        this.amount = amount;
        return this;
    }

    /**
     * Provide any data you like, for example a string or a JSON object. We will save the data alongside the entity. Whenever you fetch the entity with our API, we will also include the metadata. You can use up to approximately 1kB.
     */
    public CreateOrderRefundRequestBody withMetadata(CreateOrderRefundMetadata metadata) {
        Utils.checkNotNull(metadata, "metadata");
        this.metadata = JsonNullable.of(metadata);
        return this;
    }

    /**
     * Provide any data you like, for example a string or a JSON object. We will save the data alongside the entity. Whenever you fetch the entity with our API, we will also include the metadata. You can use up to approximately 1kB.
     */
    public CreateOrderRefundRequestBody withMetadata(JsonNullable<? extends CreateOrderRefundMetadata> metadata) {
        Utils.checkNotNull(metadata, "metadata");
        this.metadata = metadata;
        return this;
    }

    public CreateOrderRefundRequestBody withExternalReference(CreateOrderRefundExternalReference externalReference) {
        Utils.checkNotNull(externalReference, "externalReference");
        this.externalReference = Optional.ofNullable(externalReference);
        return this;
    }


    public CreateOrderRefundRequestBody withExternalReference(Optional<? extends CreateOrderRefundExternalReference> externalReference) {
        Utils.checkNotNull(externalReference, "externalReference");
        this.externalReference = externalReference;
        return this;
    }

    /**
     * Whether to create the entity in test mode or live mode.
     * 
     * <p>Most API credentials are specifically created for either live mode or test mode, in which case this parameter can be omitted. For organization-level credentials such as OAuth access tokens, you can enable test mode by setting `testmode` to `true`.
     */
    public CreateOrderRefundRequestBody withTestmode(boolean testmode) {
        Utils.checkNotNull(testmode, "testmode");
        this.testmode = JsonNullable.of(testmode);
        return this;
    }

    /**
     * Whether to create the entity in test mode or live mode.
     * 
     * <p>Most API credentials are specifically created for either live mode or test mode, in which case this parameter can be omitted. For organization-level credentials such as OAuth access tokens, you can enable test mode by setting `testmode` to `true`.
     */
    public CreateOrderRefundRequestBody withTestmode(JsonNullable<Boolean> testmode) {
        Utils.checkNotNull(testmode, "testmode");
        this.testmode = testmode;
        return this;
    }

    /**
     * A refund can optionally be linked to specific order lines.
     * 
     * <p>The lines will show the `quantity`, `discountAmount`, `vatAmount`, and `totalAmount` refunded. If the line was partially refunded, these values will be different from the values in response from the [Get payment](get-payment) endpoint.
     */
    public CreateOrderRefundRequestBody withLines(List<CreateOrderRefundLines> lines) {
        Utils.checkNotNull(lines, "lines");
        this.lines = lines;
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
        CreateOrderRefundRequestBody other = (CreateOrderRefundRequestBody) o;
        return 
            Utils.enhancedDeepEquals(this.description, other.description) &&
            Utils.enhancedDeepEquals(this.amount, other.amount) &&
            Utils.enhancedDeepEquals(this.metadata, other.metadata) &&
            Utils.enhancedDeepEquals(this.externalReference, other.externalReference) &&
            Utils.enhancedDeepEquals(this.testmode, other.testmode) &&
            Utils.enhancedDeepEquals(this.lines, other.lines);
    }
    
    @Override
    public int hashCode() {
        return Utils.enhancedHash(
            description, amount, metadata,
            externalReference, testmode, lines);
    }
    
    @Override
    public String toString() {
        return Utils.toString(CreateOrderRefundRequestBody.class,
                "description", description,
                "amount", amount,
                "metadata", metadata,
                "externalReference", externalReference,
                "testmode", testmode,
                "lines", lines);
    }

    @SuppressWarnings("UnusedReturnValue")
    public final static class Builder {

        private Optional<String> description = Optional.empty();

        private Optional<? extends CreateOrderRefundAmount> amount = Optional.empty();

        private JsonNullable<? extends CreateOrderRefundMetadata> metadata = JsonNullable.undefined();

        private Optional<? extends CreateOrderRefundExternalReference> externalReference = Optional.empty();

        private JsonNullable<Boolean> testmode = JsonNullable.undefined();

        private List<CreateOrderRefundLines> lines;

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
        public Builder amount(CreateOrderRefundAmount amount) {
            Utils.checkNotNull(amount, "amount");
            this.amount = Optional.ofNullable(amount);
            return this;
        }

        /**
         * The amount refunded to your customer with this refund. The amount is allowed to be lower than the original payment amount.
         */
        public Builder amount(Optional<? extends CreateOrderRefundAmount> amount) {
            Utils.checkNotNull(amount, "amount");
            this.amount = amount;
            return this;
        }


        /**
         * Provide any data you like, for example a string or a JSON object. We will save the data alongside the entity. Whenever you fetch the entity with our API, we will also include the metadata. You can use up to approximately 1kB.
         */
        public Builder metadata(CreateOrderRefundMetadata metadata) {
            Utils.checkNotNull(metadata, "metadata");
            this.metadata = JsonNullable.of(metadata);
            return this;
        }

        /**
         * Provide any data you like, for example a string or a JSON object. We will save the data alongside the entity. Whenever you fetch the entity with our API, we will also include the metadata. You can use up to approximately 1kB.
         */
        public Builder metadata(JsonNullable<? extends CreateOrderRefundMetadata> metadata) {
            Utils.checkNotNull(metadata, "metadata");
            this.metadata = metadata;
            return this;
        }


        public Builder externalReference(CreateOrderRefundExternalReference externalReference) {
            Utils.checkNotNull(externalReference, "externalReference");
            this.externalReference = Optional.ofNullable(externalReference);
            return this;
        }

        public Builder externalReference(Optional<? extends CreateOrderRefundExternalReference> externalReference) {
            Utils.checkNotNull(externalReference, "externalReference");
            this.externalReference = externalReference;
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


        /**
         * A refund can optionally be linked to specific order lines.
         * 
         * <p>The lines will show the `quantity`, `discountAmount`, `vatAmount`, and `totalAmount` refunded. If the line was partially refunded, these values will be different from the values in response from the [Get payment](get-payment) endpoint.
         */
        public Builder lines(List<CreateOrderRefundLines> lines) {
            Utils.checkNotNull(lines, "lines");
            this.lines = lines;
            return this;
        }

        public CreateOrderRefundRequestBody build() {

            return new CreateOrderRefundRequestBody(
                description, amount, metadata,
                externalReference, testmode, lines);
        }

    }
}
