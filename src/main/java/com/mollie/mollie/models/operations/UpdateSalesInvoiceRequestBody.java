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


public class UpdateSalesInvoiceRequestBody {
    /**
     * Most API credentials are specifically created for either live mode or test mode. For organization-level credentials such as OAuth access tokens, you can enable test mode by setting `testmode` to `true`.
     * 
     * <p>Test entities cannot be retrieved when the endpoint is set to live mode, and vice versa.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("testmode")
    private JsonNullable<Boolean> testmode;

    /**
     * The status for the invoice to end up in.
     * 
     * <p>Dependent parameters: `paymentDetails` for `paid`, `emailDetails` for `issued` and `paid`.
     * 
     * <p>Possible values: `draft` `issued` `paid`
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("status")
    private Optional<String> status;

    /**
     * A free-form memo you can set on the invoice, and will be shown on the invoice PDF.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("memo")
    private JsonNullable<String> memo;

    /**
     * The payment term to be set on the invoice.
     * 
     * <p>Possible values: `7 days` `14 days` `30 days` `45 days` `60 days` `90 days` `120 days` (default: `30 days`)
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("paymentTerm")
    private JsonNullable<String> paymentTerm;

    /**
     * Used when setting an invoice to status of `paid`, and will store a payment that fully pays the invoice with the provided details. Required for `paid` status.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("paymentDetails")
    private JsonNullable<? extends UpdateSalesInvoicePaymentDetails> paymentDetails;

    /**
     * Used when setting an invoice to status of either `issued` or `paid`. Will be used to issue the invoice to the recipient with the provided `subject` and `body`. Required for `issued` status.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("emailDetails")
    private JsonNullable<? extends UpdateSalesInvoiceEmailDetails> emailDetails;

    /**
     * An identifier tied to the recipient data. This should be a unique value based on data your system contains, so that both you and us know who we're referring to. It is a value you provide to us so that recipient management is not required to send a first invoice to a recipient.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("recipientIdentifier")
    private Optional<String> recipientIdentifier;

    /**
     * The recipient object should contain all the information relevant to create an invoice for an intended recipient. This data will be stored, updated, and re-used as appropriate, based on the `recipientIdentifier`.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("recipient")
    private JsonNullable<? extends UpdateSalesInvoiceRecipient> recipient;

    /**
     * Provide the line items for the invoice. Each line contains details such as a description of the item ordered and its price.
     * 
     * <p>All lines must have the same currency as the invoice.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("lines")
    private JsonNullable<? extends List<UpdateSalesInvoiceLines>> lines;

    /**
     * The discount to be applied to the entire invoice, possibly on top of the line item discounts.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("discount")
    private JsonNullable<? extends UpdateSalesInvoiceSalesInvoicesDiscount> discount;

    @JsonCreator
    public UpdateSalesInvoiceRequestBody(
            @JsonProperty("testmode") JsonNullable<Boolean> testmode,
            @JsonProperty("status") Optional<String> status,
            @JsonProperty("memo") JsonNullable<String> memo,
            @JsonProperty("paymentTerm") JsonNullable<String> paymentTerm,
            @JsonProperty("paymentDetails") JsonNullable<? extends UpdateSalesInvoicePaymentDetails> paymentDetails,
            @JsonProperty("emailDetails") JsonNullable<? extends UpdateSalesInvoiceEmailDetails> emailDetails,
            @JsonProperty("recipientIdentifier") Optional<String> recipientIdentifier,
            @JsonProperty("recipient") JsonNullable<? extends UpdateSalesInvoiceRecipient> recipient,
            @JsonProperty("lines") JsonNullable<? extends List<UpdateSalesInvoiceLines>> lines,
            @JsonProperty("discount") JsonNullable<? extends UpdateSalesInvoiceSalesInvoicesDiscount> discount) {
        Utils.checkNotNull(testmode, "testmode");
        Utils.checkNotNull(status, "status");
        Utils.checkNotNull(memo, "memo");
        Utils.checkNotNull(paymentTerm, "paymentTerm");
        Utils.checkNotNull(paymentDetails, "paymentDetails");
        Utils.checkNotNull(emailDetails, "emailDetails");
        Utils.checkNotNull(recipientIdentifier, "recipientIdentifier");
        Utils.checkNotNull(recipient, "recipient");
        Utils.checkNotNull(lines, "lines");
        Utils.checkNotNull(discount, "discount");
        this.testmode = testmode;
        this.status = status;
        this.memo = memo;
        this.paymentTerm = paymentTerm;
        this.paymentDetails = paymentDetails;
        this.emailDetails = emailDetails;
        this.recipientIdentifier = recipientIdentifier;
        this.recipient = recipient;
        this.lines = lines;
        this.discount = discount;
    }
    
    public UpdateSalesInvoiceRequestBody() {
        this(JsonNullable.undefined(), Optional.empty(), JsonNullable.undefined(),
            JsonNullable.undefined(), JsonNullable.undefined(), JsonNullable.undefined(),
            Optional.empty(), JsonNullable.undefined(), JsonNullable.undefined(),
            JsonNullable.undefined());
    }

    /**
     * Most API credentials are specifically created for either live mode or test mode. For organization-level credentials such as OAuth access tokens, you can enable test mode by setting `testmode` to `true`.
     * 
     * <p>Test entities cannot be retrieved when the endpoint is set to live mode, and vice versa.
     */
    @JsonIgnore
    public JsonNullable<Boolean> testmode() {
        return testmode;
    }

    /**
     * The status for the invoice to end up in.
     * 
     * <p>Dependent parameters: `paymentDetails` for `paid`, `emailDetails` for `issued` and `paid`.
     * 
     * <p>Possible values: `draft` `issued` `paid`
     */
    @JsonIgnore
    public Optional<String> status() {
        return status;
    }

    /**
     * A free-form memo you can set on the invoice, and will be shown on the invoice PDF.
     */
    @JsonIgnore
    public JsonNullable<String> memo() {
        return memo;
    }

    /**
     * The payment term to be set on the invoice.
     * 
     * <p>Possible values: `7 days` `14 days` `30 days` `45 days` `60 days` `90 days` `120 days` (default: `30 days`)
     */
    @JsonIgnore
    public JsonNullable<String> paymentTerm() {
        return paymentTerm;
    }

    /**
     * Used when setting an invoice to status of `paid`, and will store a payment that fully pays the invoice with the provided details. Required for `paid` status.
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public JsonNullable<UpdateSalesInvoicePaymentDetails> paymentDetails() {
        return (JsonNullable<UpdateSalesInvoicePaymentDetails>) paymentDetails;
    }

    /**
     * Used when setting an invoice to status of either `issued` or `paid`. Will be used to issue the invoice to the recipient with the provided `subject` and `body`. Required for `issued` status.
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public JsonNullable<UpdateSalesInvoiceEmailDetails> emailDetails() {
        return (JsonNullable<UpdateSalesInvoiceEmailDetails>) emailDetails;
    }

    /**
     * An identifier tied to the recipient data. This should be a unique value based on data your system contains, so that both you and us know who we're referring to. It is a value you provide to us so that recipient management is not required to send a first invoice to a recipient.
     */
    @JsonIgnore
    public Optional<String> recipientIdentifier() {
        return recipientIdentifier;
    }

    /**
     * The recipient object should contain all the information relevant to create an invoice for an intended recipient. This data will be stored, updated, and re-used as appropriate, based on the `recipientIdentifier`.
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public JsonNullable<UpdateSalesInvoiceRecipient> recipient() {
        return (JsonNullable<UpdateSalesInvoiceRecipient>) recipient;
    }

    /**
     * Provide the line items for the invoice. Each line contains details such as a description of the item ordered and its price.
     * 
     * <p>All lines must have the same currency as the invoice.
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public JsonNullable<List<UpdateSalesInvoiceLines>> lines() {
        return (JsonNullable<List<UpdateSalesInvoiceLines>>) lines;
    }

    /**
     * The discount to be applied to the entire invoice, possibly on top of the line item discounts.
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public JsonNullable<UpdateSalesInvoiceSalesInvoicesDiscount> discount() {
        return (JsonNullable<UpdateSalesInvoiceSalesInvoicesDiscount>) discount;
    }

    public static Builder builder() {
        return new Builder();
    }


    /**
     * Most API credentials are specifically created for either live mode or test mode. For organization-level credentials such as OAuth access tokens, you can enable test mode by setting `testmode` to `true`.
     * 
     * <p>Test entities cannot be retrieved when the endpoint is set to live mode, and vice versa.
     */
    public UpdateSalesInvoiceRequestBody withTestmode(boolean testmode) {
        Utils.checkNotNull(testmode, "testmode");
        this.testmode = JsonNullable.of(testmode);
        return this;
    }

    /**
     * Most API credentials are specifically created for either live mode or test mode. For organization-level credentials such as OAuth access tokens, you can enable test mode by setting `testmode` to `true`.
     * 
     * <p>Test entities cannot be retrieved when the endpoint is set to live mode, and vice versa.
     */
    public UpdateSalesInvoiceRequestBody withTestmode(JsonNullable<Boolean> testmode) {
        Utils.checkNotNull(testmode, "testmode");
        this.testmode = testmode;
        return this;
    }

    /**
     * The status for the invoice to end up in.
     * 
     * <p>Dependent parameters: `paymentDetails` for `paid`, `emailDetails` for `issued` and `paid`.
     * 
     * <p>Possible values: `draft` `issued` `paid`
     */
    public UpdateSalesInvoiceRequestBody withStatus(String status) {
        Utils.checkNotNull(status, "status");
        this.status = Optional.ofNullable(status);
        return this;
    }


    /**
     * The status for the invoice to end up in.
     * 
     * <p>Dependent parameters: `paymentDetails` for `paid`, `emailDetails` for `issued` and `paid`.
     * 
     * <p>Possible values: `draft` `issued` `paid`
     */
    public UpdateSalesInvoiceRequestBody withStatus(Optional<String> status) {
        Utils.checkNotNull(status, "status");
        this.status = status;
        return this;
    }

    /**
     * A free-form memo you can set on the invoice, and will be shown on the invoice PDF.
     */
    public UpdateSalesInvoiceRequestBody withMemo(String memo) {
        Utils.checkNotNull(memo, "memo");
        this.memo = JsonNullable.of(memo);
        return this;
    }

    /**
     * A free-form memo you can set on the invoice, and will be shown on the invoice PDF.
     */
    public UpdateSalesInvoiceRequestBody withMemo(JsonNullable<String> memo) {
        Utils.checkNotNull(memo, "memo");
        this.memo = memo;
        return this;
    }

    /**
     * The payment term to be set on the invoice.
     * 
     * <p>Possible values: `7 days` `14 days` `30 days` `45 days` `60 days` `90 days` `120 days` (default: `30 days`)
     */
    public UpdateSalesInvoiceRequestBody withPaymentTerm(String paymentTerm) {
        Utils.checkNotNull(paymentTerm, "paymentTerm");
        this.paymentTerm = JsonNullable.of(paymentTerm);
        return this;
    }

    /**
     * The payment term to be set on the invoice.
     * 
     * <p>Possible values: `7 days` `14 days` `30 days` `45 days` `60 days` `90 days` `120 days` (default: `30 days`)
     */
    public UpdateSalesInvoiceRequestBody withPaymentTerm(JsonNullable<String> paymentTerm) {
        Utils.checkNotNull(paymentTerm, "paymentTerm");
        this.paymentTerm = paymentTerm;
        return this;
    }

    /**
     * Used when setting an invoice to status of `paid`, and will store a payment that fully pays the invoice with the provided details. Required for `paid` status.
     */
    public UpdateSalesInvoiceRequestBody withPaymentDetails(UpdateSalesInvoicePaymentDetails paymentDetails) {
        Utils.checkNotNull(paymentDetails, "paymentDetails");
        this.paymentDetails = JsonNullable.of(paymentDetails);
        return this;
    }

    /**
     * Used when setting an invoice to status of `paid`, and will store a payment that fully pays the invoice with the provided details. Required for `paid` status.
     */
    public UpdateSalesInvoiceRequestBody withPaymentDetails(JsonNullable<? extends UpdateSalesInvoicePaymentDetails> paymentDetails) {
        Utils.checkNotNull(paymentDetails, "paymentDetails");
        this.paymentDetails = paymentDetails;
        return this;
    }

    /**
     * Used when setting an invoice to status of either `issued` or `paid`. Will be used to issue the invoice to the recipient with the provided `subject` and `body`. Required for `issued` status.
     */
    public UpdateSalesInvoiceRequestBody withEmailDetails(UpdateSalesInvoiceEmailDetails emailDetails) {
        Utils.checkNotNull(emailDetails, "emailDetails");
        this.emailDetails = JsonNullable.of(emailDetails);
        return this;
    }

    /**
     * Used when setting an invoice to status of either `issued` or `paid`. Will be used to issue the invoice to the recipient with the provided `subject` and `body`. Required for `issued` status.
     */
    public UpdateSalesInvoiceRequestBody withEmailDetails(JsonNullable<? extends UpdateSalesInvoiceEmailDetails> emailDetails) {
        Utils.checkNotNull(emailDetails, "emailDetails");
        this.emailDetails = emailDetails;
        return this;
    }

    /**
     * An identifier tied to the recipient data. This should be a unique value based on data your system contains, so that both you and us know who we're referring to. It is a value you provide to us so that recipient management is not required to send a first invoice to a recipient.
     */
    public UpdateSalesInvoiceRequestBody withRecipientIdentifier(String recipientIdentifier) {
        Utils.checkNotNull(recipientIdentifier, "recipientIdentifier");
        this.recipientIdentifier = Optional.ofNullable(recipientIdentifier);
        return this;
    }


    /**
     * An identifier tied to the recipient data. This should be a unique value based on data your system contains, so that both you and us know who we're referring to. It is a value you provide to us so that recipient management is not required to send a first invoice to a recipient.
     */
    public UpdateSalesInvoiceRequestBody withRecipientIdentifier(Optional<String> recipientIdentifier) {
        Utils.checkNotNull(recipientIdentifier, "recipientIdentifier");
        this.recipientIdentifier = recipientIdentifier;
        return this;
    }

    /**
     * The recipient object should contain all the information relevant to create an invoice for an intended recipient. This data will be stored, updated, and re-used as appropriate, based on the `recipientIdentifier`.
     */
    public UpdateSalesInvoiceRequestBody withRecipient(UpdateSalesInvoiceRecipient recipient) {
        Utils.checkNotNull(recipient, "recipient");
        this.recipient = JsonNullable.of(recipient);
        return this;
    }

    /**
     * The recipient object should contain all the information relevant to create an invoice for an intended recipient. This data will be stored, updated, and re-used as appropriate, based on the `recipientIdentifier`.
     */
    public UpdateSalesInvoiceRequestBody withRecipient(JsonNullable<? extends UpdateSalesInvoiceRecipient> recipient) {
        Utils.checkNotNull(recipient, "recipient");
        this.recipient = recipient;
        return this;
    }

    /**
     * Provide the line items for the invoice. Each line contains details such as a description of the item ordered and its price.
     * 
     * <p>All lines must have the same currency as the invoice.
     */
    public UpdateSalesInvoiceRequestBody withLines(List<UpdateSalesInvoiceLines> lines) {
        Utils.checkNotNull(lines, "lines");
        this.lines = JsonNullable.of(lines);
        return this;
    }

    /**
     * Provide the line items for the invoice. Each line contains details such as a description of the item ordered and its price.
     * 
     * <p>All lines must have the same currency as the invoice.
     */
    public UpdateSalesInvoiceRequestBody withLines(JsonNullable<? extends List<UpdateSalesInvoiceLines>> lines) {
        Utils.checkNotNull(lines, "lines");
        this.lines = lines;
        return this;
    }

    /**
     * The discount to be applied to the entire invoice, possibly on top of the line item discounts.
     */
    public UpdateSalesInvoiceRequestBody withDiscount(UpdateSalesInvoiceSalesInvoicesDiscount discount) {
        Utils.checkNotNull(discount, "discount");
        this.discount = JsonNullable.of(discount);
        return this;
    }

    /**
     * The discount to be applied to the entire invoice, possibly on top of the line item discounts.
     */
    public UpdateSalesInvoiceRequestBody withDiscount(JsonNullable<? extends UpdateSalesInvoiceSalesInvoicesDiscount> discount) {
        Utils.checkNotNull(discount, "discount");
        this.discount = discount;
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
        UpdateSalesInvoiceRequestBody other = (UpdateSalesInvoiceRequestBody) o;
        return 
            Utils.enhancedDeepEquals(this.testmode, other.testmode) &&
            Utils.enhancedDeepEquals(this.status, other.status) &&
            Utils.enhancedDeepEquals(this.memo, other.memo) &&
            Utils.enhancedDeepEquals(this.paymentTerm, other.paymentTerm) &&
            Utils.enhancedDeepEquals(this.paymentDetails, other.paymentDetails) &&
            Utils.enhancedDeepEquals(this.emailDetails, other.emailDetails) &&
            Utils.enhancedDeepEquals(this.recipientIdentifier, other.recipientIdentifier) &&
            Utils.enhancedDeepEquals(this.recipient, other.recipient) &&
            Utils.enhancedDeepEquals(this.lines, other.lines) &&
            Utils.enhancedDeepEquals(this.discount, other.discount);
    }
    
    @Override
    public int hashCode() {
        return Utils.enhancedHash(
            testmode, status, memo,
            paymentTerm, paymentDetails, emailDetails,
            recipientIdentifier, recipient, lines,
            discount);
    }
    
    @Override
    public String toString() {
        return Utils.toString(UpdateSalesInvoiceRequestBody.class,
                "testmode", testmode,
                "status", status,
                "memo", memo,
                "paymentTerm", paymentTerm,
                "paymentDetails", paymentDetails,
                "emailDetails", emailDetails,
                "recipientIdentifier", recipientIdentifier,
                "recipient", recipient,
                "lines", lines,
                "discount", discount);
    }

    @SuppressWarnings("UnusedReturnValue")
    public final static class Builder {

        private JsonNullable<Boolean> testmode = JsonNullable.undefined();

        private Optional<String> status = Optional.empty();

        private JsonNullable<String> memo = JsonNullable.undefined();

        private JsonNullable<String> paymentTerm = JsonNullable.undefined();

        private JsonNullable<? extends UpdateSalesInvoicePaymentDetails> paymentDetails = JsonNullable.undefined();

        private JsonNullable<? extends UpdateSalesInvoiceEmailDetails> emailDetails = JsonNullable.undefined();

        private Optional<String> recipientIdentifier = Optional.empty();

        private JsonNullable<? extends UpdateSalesInvoiceRecipient> recipient = JsonNullable.undefined();

        private JsonNullable<? extends List<UpdateSalesInvoiceLines>> lines = JsonNullable.undefined();

        private JsonNullable<? extends UpdateSalesInvoiceSalesInvoicesDiscount> discount = JsonNullable.undefined();

        private Builder() {
          // force use of static builder() method
        }


        /**
         * Most API credentials are specifically created for either live mode or test mode. For organization-level credentials such as OAuth access tokens, you can enable test mode by setting `testmode` to `true`.
         * 
         * <p>Test entities cannot be retrieved when the endpoint is set to live mode, and vice versa.
         */
        public Builder testmode(boolean testmode) {
            Utils.checkNotNull(testmode, "testmode");
            this.testmode = JsonNullable.of(testmode);
            return this;
        }

        /**
         * Most API credentials are specifically created for either live mode or test mode. For organization-level credentials such as OAuth access tokens, you can enable test mode by setting `testmode` to `true`.
         * 
         * <p>Test entities cannot be retrieved when the endpoint is set to live mode, and vice versa.
         */
        public Builder testmode(JsonNullable<Boolean> testmode) {
            Utils.checkNotNull(testmode, "testmode");
            this.testmode = testmode;
            return this;
        }


        /**
         * The status for the invoice to end up in.
         * 
         * <p>Dependent parameters: `paymentDetails` for `paid`, `emailDetails` for `issued` and `paid`.
         * 
         * <p>Possible values: `draft` `issued` `paid`
         */
        public Builder status(String status) {
            Utils.checkNotNull(status, "status");
            this.status = Optional.ofNullable(status);
            return this;
        }

        /**
         * The status for the invoice to end up in.
         * 
         * <p>Dependent parameters: `paymentDetails` for `paid`, `emailDetails` for `issued` and `paid`.
         * 
         * <p>Possible values: `draft` `issued` `paid`
         */
        public Builder status(Optional<String> status) {
            Utils.checkNotNull(status, "status");
            this.status = status;
            return this;
        }


        /**
         * A free-form memo you can set on the invoice, and will be shown on the invoice PDF.
         */
        public Builder memo(String memo) {
            Utils.checkNotNull(memo, "memo");
            this.memo = JsonNullable.of(memo);
            return this;
        }

        /**
         * A free-form memo you can set on the invoice, and will be shown on the invoice PDF.
         */
        public Builder memo(JsonNullable<String> memo) {
            Utils.checkNotNull(memo, "memo");
            this.memo = memo;
            return this;
        }


        /**
         * The payment term to be set on the invoice.
         * 
         * <p>Possible values: `7 days` `14 days` `30 days` `45 days` `60 days` `90 days` `120 days` (default: `30 days`)
         */
        public Builder paymentTerm(String paymentTerm) {
            Utils.checkNotNull(paymentTerm, "paymentTerm");
            this.paymentTerm = JsonNullable.of(paymentTerm);
            return this;
        }

        /**
         * The payment term to be set on the invoice.
         * 
         * <p>Possible values: `7 days` `14 days` `30 days` `45 days` `60 days` `90 days` `120 days` (default: `30 days`)
         */
        public Builder paymentTerm(JsonNullable<String> paymentTerm) {
            Utils.checkNotNull(paymentTerm, "paymentTerm");
            this.paymentTerm = paymentTerm;
            return this;
        }


        /**
         * Used when setting an invoice to status of `paid`, and will store a payment that fully pays the invoice with the provided details. Required for `paid` status.
         */
        public Builder paymentDetails(UpdateSalesInvoicePaymentDetails paymentDetails) {
            Utils.checkNotNull(paymentDetails, "paymentDetails");
            this.paymentDetails = JsonNullable.of(paymentDetails);
            return this;
        }

        /**
         * Used when setting an invoice to status of `paid`, and will store a payment that fully pays the invoice with the provided details. Required for `paid` status.
         */
        public Builder paymentDetails(JsonNullable<? extends UpdateSalesInvoicePaymentDetails> paymentDetails) {
            Utils.checkNotNull(paymentDetails, "paymentDetails");
            this.paymentDetails = paymentDetails;
            return this;
        }


        /**
         * Used when setting an invoice to status of either `issued` or `paid`. Will be used to issue the invoice to the recipient with the provided `subject` and `body`. Required for `issued` status.
         */
        public Builder emailDetails(UpdateSalesInvoiceEmailDetails emailDetails) {
            Utils.checkNotNull(emailDetails, "emailDetails");
            this.emailDetails = JsonNullable.of(emailDetails);
            return this;
        }

        /**
         * Used when setting an invoice to status of either `issued` or `paid`. Will be used to issue the invoice to the recipient with the provided `subject` and `body`. Required for `issued` status.
         */
        public Builder emailDetails(JsonNullable<? extends UpdateSalesInvoiceEmailDetails> emailDetails) {
            Utils.checkNotNull(emailDetails, "emailDetails");
            this.emailDetails = emailDetails;
            return this;
        }


        /**
         * An identifier tied to the recipient data. This should be a unique value based on data your system contains, so that both you and us know who we're referring to. It is a value you provide to us so that recipient management is not required to send a first invoice to a recipient.
         */
        public Builder recipientIdentifier(String recipientIdentifier) {
            Utils.checkNotNull(recipientIdentifier, "recipientIdentifier");
            this.recipientIdentifier = Optional.ofNullable(recipientIdentifier);
            return this;
        }

        /**
         * An identifier tied to the recipient data. This should be a unique value based on data your system contains, so that both you and us know who we're referring to. It is a value you provide to us so that recipient management is not required to send a first invoice to a recipient.
         */
        public Builder recipientIdentifier(Optional<String> recipientIdentifier) {
            Utils.checkNotNull(recipientIdentifier, "recipientIdentifier");
            this.recipientIdentifier = recipientIdentifier;
            return this;
        }


        /**
         * The recipient object should contain all the information relevant to create an invoice for an intended recipient. This data will be stored, updated, and re-used as appropriate, based on the `recipientIdentifier`.
         */
        public Builder recipient(UpdateSalesInvoiceRecipient recipient) {
            Utils.checkNotNull(recipient, "recipient");
            this.recipient = JsonNullable.of(recipient);
            return this;
        }

        /**
         * The recipient object should contain all the information relevant to create an invoice for an intended recipient. This data will be stored, updated, and re-used as appropriate, based on the `recipientIdentifier`.
         */
        public Builder recipient(JsonNullable<? extends UpdateSalesInvoiceRecipient> recipient) {
            Utils.checkNotNull(recipient, "recipient");
            this.recipient = recipient;
            return this;
        }


        /**
         * Provide the line items for the invoice. Each line contains details such as a description of the item ordered and its price.
         * 
         * <p>All lines must have the same currency as the invoice.
         */
        public Builder lines(List<UpdateSalesInvoiceLines> lines) {
            Utils.checkNotNull(lines, "lines");
            this.lines = JsonNullable.of(lines);
            return this;
        }

        /**
         * Provide the line items for the invoice. Each line contains details such as a description of the item ordered and its price.
         * 
         * <p>All lines must have the same currency as the invoice.
         */
        public Builder lines(JsonNullable<? extends List<UpdateSalesInvoiceLines>> lines) {
            Utils.checkNotNull(lines, "lines");
            this.lines = lines;
            return this;
        }


        /**
         * The discount to be applied to the entire invoice, possibly on top of the line item discounts.
         */
        public Builder discount(UpdateSalesInvoiceSalesInvoicesDiscount discount) {
            Utils.checkNotNull(discount, "discount");
            this.discount = JsonNullable.of(discount);
            return this;
        }

        /**
         * The discount to be applied to the entire invoice, possibly on top of the line item discounts.
         */
        public Builder discount(JsonNullable<? extends UpdateSalesInvoiceSalesInvoicesDiscount> discount) {
            Utils.checkNotNull(discount, "discount");
            this.discount = discount;
            return this;
        }

        public UpdateSalesInvoiceRequestBody build() {

            return new UpdateSalesInvoiceRequestBody(
                testmode, status, memo,
                paymentTerm, paymentDetails, emailDetails,
                recipientIdentifier, recipient, lines,
                discount);
        }

    }
}
