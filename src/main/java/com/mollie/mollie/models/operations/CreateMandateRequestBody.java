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
import java.util.Optional;
import org.openapitools.jackson.nullable.JsonNullable;


public class CreateMandateRequestBody {
    /**
     * The identifier uniquely referring to this mandate. Example: `mdt_pWUnw6pkBN`.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("id")
    private Optional<String> id;

    /**
     * Payment method of the mandate.
     * 
     * <p>SEPA Direct Debit and PayPal mandates can be created directly.
     * 
     * <p>Possible values: `creditcard` `directdebit` `paypal`
     */
    @JsonProperty("method")
    private String method;

    /**
     * The customer's name.
     */
    @JsonProperty("consumerName")
    private String consumerName;

    /**
     * The customer's IBAN. Required for SEPA Direct Debit mandates.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("consumerAccount")
    private JsonNullable<String> consumerAccount;

    /**
     * The BIC of the customer's bank.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("consumerBic")
    private JsonNullable<String> consumerBic;

    /**
     * The customer's email address. Required for PayPal mandates.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("consumerEmail")
    private JsonNullable<String> consumerEmail;

    /**
     * The date when the mandate was signed in `YYYY-MM-DD` format.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("signatureDate")
    private JsonNullable<String> signatureDate;

    /**
     * A custom mandate reference. For SEPA Direct Debit, it is vital to provide a unique reference. Some banks will decline Direct Debit payments if the mandate reference is not unique.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("mandateReference")
    private JsonNullable<String> mandateReference;

    /**
     * The billing agreement ID given by PayPal. For example: `B-12A34567B8901234CD`. Required for PayPal mandates. Must provide either this field or `payPalVaultId`, but not both.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("paypalBillingAgreementId")
    private JsonNullable<String> paypalBillingAgreementId;

    /**
     * The Vault ID given by PayPal. For example: `8kk8451t`. Required for PayPal mandates. Must provide either this field or `paypalBillingAgreementId`, but not both.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("payPalVaultId")
    private JsonNullable<String> payPalVaultId;

    /**
     * Whether to create the entity in test mode or live mode.
     * 
     * <p>Most API credentials are specifically created for either live mode or test mode, in which case this parameter can be omitted. For organization-level credentials such as OAuth access tokens, you can enable test mode by setting `testmode` to `true`.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("testmode")
    private JsonNullable<Boolean> testmode;

    @JsonCreator
    public CreateMandateRequestBody(
            @JsonProperty("id") Optional<String> id,
            @JsonProperty("method") String method,
            @JsonProperty("consumerName") String consumerName,
            @JsonProperty("consumerAccount") JsonNullable<String> consumerAccount,
            @JsonProperty("consumerBic") JsonNullable<String> consumerBic,
            @JsonProperty("consumerEmail") JsonNullable<String> consumerEmail,
            @JsonProperty("signatureDate") JsonNullable<String> signatureDate,
            @JsonProperty("mandateReference") JsonNullable<String> mandateReference,
            @JsonProperty("paypalBillingAgreementId") JsonNullable<String> paypalBillingAgreementId,
            @JsonProperty("payPalVaultId") JsonNullable<String> payPalVaultId,
            @JsonProperty("testmode") JsonNullable<Boolean> testmode) {
        Utils.checkNotNull(id, "id");
        Utils.checkNotNull(method, "method");
        Utils.checkNotNull(consumerName, "consumerName");
        Utils.checkNotNull(consumerAccount, "consumerAccount");
        Utils.checkNotNull(consumerBic, "consumerBic");
        Utils.checkNotNull(consumerEmail, "consumerEmail");
        Utils.checkNotNull(signatureDate, "signatureDate");
        Utils.checkNotNull(mandateReference, "mandateReference");
        Utils.checkNotNull(paypalBillingAgreementId, "paypalBillingAgreementId");
        Utils.checkNotNull(payPalVaultId, "payPalVaultId");
        Utils.checkNotNull(testmode, "testmode");
        this.id = id;
        this.method = method;
        this.consumerName = consumerName;
        this.consumerAccount = consumerAccount;
        this.consumerBic = consumerBic;
        this.consumerEmail = consumerEmail;
        this.signatureDate = signatureDate;
        this.mandateReference = mandateReference;
        this.paypalBillingAgreementId = paypalBillingAgreementId;
        this.payPalVaultId = payPalVaultId;
        this.testmode = testmode;
    }
    
    public CreateMandateRequestBody(
            String method,
            String consumerName) {
        this(Optional.empty(), method, consumerName,
            JsonNullable.undefined(), JsonNullable.undefined(), JsonNullable.undefined(),
            JsonNullable.undefined(), JsonNullable.undefined(), JsonNullable.undefined(),
            JsonNullable.undefined(), JsonNullable.undefined());
    }

    /**
     * The identifier uniquely referring to this mandate. Example: `mdt_pWUnw6pkBN`.
     */
    @JsonIgnore
    public Optional<String> id() {
        return id;
    }

    /**
     * Payment method of the mandate.
     * 
     * <p>SEPA Direct Debit and PayPal mandates can be created directly.
     * 
     * <p>Possible values: `creditcard` `directdebit` `paypal`
     */
    @JsonIgnore
    public String method() {
        return method;
    }

    /**
     * The customer's name.
     */
    @JsonIgnore
    public String consumerName() {
        return consumerName;
    }

    /**
     * The customer's IBAN. Required for SEPA Direct Debit mandates.
     */
    @JsonIgnore
    public JsonNullable<String> consumerAccount() {
        return consumerAccount;
    }

    /**
     * The BIC of the customer's bank.
     */
    @JsonIgnore
    public JsonNullable<String> consumerBic() {
        return consumerBic;
    }

    /**
     * The customer's email address. Required for PayPal mandates.
     */
    @JsonIgnore
    public JsonNullable<String> consumerEmail() {
        return consumerEmail;
    }

    /**
     * The date when the mandate was signed in `YYYY-MM-DD` format.
     */
    @JsonIgnore
    public JsonNullable<String> signatureDate() {
        return signatureDate;
    }

    /**
     * A custom mandate reference. For SEPA Direct Debit, it is vital to provide a unique reference. Some banks will decline Direct Debit payments if the mandate reference is not unique.
     */
    @JsonIgnore
    public JsonNullable<String> mandateReference() {
        return mandateReference;
    }

    /**
     * The billing agreement ID given by PayPal. For example: `B-12A34567B8901234CD`. Required for PayPal mandates. Must provide either this field or `payPalVaultId`, but not both.
     */
    @JsonIgnore
    public JsonNullable<String> paypalBillingAgreementId() {
        return paypalBillingAgreementId;
    }

    /**
     * The Vault ID given by PayPal. For example: `8kk8451t`. Required for PayPal mandates. Must provide either this field or `paypalBillingAgreementId`, but not both.
     */
    @JsonIgnore
    public JsonNullable<String> payPalVaultId() {
        return payPalVaultId;
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
     * The identifier uniquely referring to this mandate. Example: `mdt_pWUnw6pkBN`.
     */
    public CreateMandateRequestBody withId(String id) {
        Utils.checkNotNull(id, "id");
        this.id = Optional.ofNullable(id);
        return this;
    }


    /**
     * The identifier uniquely referring to this mandate. Example: `mdt_pWUnw6pkBN`.
     */
    public CreateMandateRequestBody withId(Optional<String> id) {
        Utils.checkNotNull(id, "id");
        this.id = id;
        return this;
    }

    /**
     * Payment method of the mandate.
     * 
     * <p>SEPA Direct Debit and PayPal mandates can be created directly.
     * 
     * <p>Possible values: `creditcard` `directdebit` `paypal`
     */
    public CreateMandateRequestBody withMethod(String method) {
        Utils.checkNotNull(method, "method");
        this.method = method;
        return this;
    }

    /**
     * The customer's name.
     */
    public CreateMandateRequestBody withConsumerName(String consumerName) {
        Utils.checkNotNull(consumerName, "consumerName");
        this.consumerName = consumerName;
        return this;
    }

    /**
     * The customer's IBAN. Required for SEPA Direct Debit mandates.
     */
    public CreateMandateRequestBody withConsumerAccount(String consumerAccount) {
        Utils.checkNotNull(consumerAccount, "consumerAccount");
        this.consumerAccount = JsonNullable.of(consumerAccount);
        return this;
    }

    /**
     * The customer's IBAN. Required for SEPA Direct Debit mandates.
     */
    public CreateMandateRequestBody withConsumerAccount(JsonNullable<String> consumerAccount) {
        Utils.checkNotNull(consumerAccount, "consumerAccount");
        this.consumerAccount = consumerAccount;
        return this;
    }

    /**
     * The BIC of the customer's bank.
     */
    public CreateMandateRequestBody withConsumerBic(String consumerBic) {
        Utils.checkNotNull(consumerBic, "consumerBic");
        this.consumerBic = JsonNullable.of(consumerBic);
        return this;
    }

    /**
     * The BIC of the customer's bank.
     */
    public CreateMandateRequestBody withConsumerBic(JsonNullable<String> consumerBic) {
        Utils.checkNotNull(consumerBic, "consumerBic");
        this.consumerBic = consumerBic;
        return this;
    }

    /**
     * The customer's email address. Required for PayPal mandates.
     */
    public CreateMandateRequestBody withConsumerEmail(String consumerEmail) {
        Utils.checkNotNull(consumerEmail, "consumerEmail");
        this.consumerEmail = JsonNullable.of(consumerEmail);
        return this;
    }

    /**
     * The customer's email address. Required for PayPal mandates.
     */
    public CreateMandateRequestBody withConsumerEmail(JsonNullable<String> consumerEmail) {
        Utils.checkNotNull(consumerEmail, "consumerEmail");
        this.consumerEmail = consumerEmail;
        return this;
    }

    /**
     * The date when the mandate was signed in `YYYY-MM-DD` format.
     */
    public CreateMandateRequestBody withSignatureDate(String signatureDate) {
        Utils.checkNotNull(signatureDate, "signatureDate");
        this.signatureDate = JsonNullable.of(signatureDate);
        return this;
    }

    /**
     * The date when the mandate was signed in `YYYY-MM-DD` format.
     */
    public CreateMandateRequestBody withSignatureDate(JsonNullable<String> signatureDate) {
        Utils.checkNotNull(signatureDate, "signatureDate");
        this.signatureDate = signatureDate;
        return this;
    }

    /**
     * A custom mandate reference. For SEPA Direct Debit, it is vital to provide a unique reference. Some banks will decline Direct Debit payments if the mandate reference is not unique.
     */
    public CreateMandateRequestBody withMandateReference(String mandateReference) {
        Utils.checkNotNull(mandateReference, "mandateReference");
        this.mandateReference = JsonNullable.of(mandateReference);
        return this;
    }

    /**
     * A custom mandate reference. For SEPA Direct Debit, it is vital to provide a unique reference. Some banks will decline Direct Debit payments if the mandate reference is not unique.
     */
    public CreateMandateRequestBody withMandateReference(JsonNullable<String> mandateReference) {
        Utils.checkNotNull(mandateReference, "mandateReference");
        this.mandateReference = mandateReference;
        return this;
    }

    /**
     * The billing agreement ID given by PayPal. For example: `B-12A34567B8901234CD`. Required for PayPal mandates. Must provide either this field or `payPalVaultId`, but not both.
     */
    public CreateMandateRequestBody withPaypalBillingAgreementId(String paypalBillingAgreementId) {
        Utils.checkNotNull(paypalBillingAgreementId, "paypalBillingAgreementId");
        this.paypalBillingAgreementId = JsonNullable.of(paypalBillingAgreementId);
        return this;
    }

    /**
     * The billing agreement ID given by PayPal. For example: `B-12A34567B8901234CD`. Required for PayPal mandates. Must provide either this field or `payPalVaultId`, but not both.
     */
    public CreateMandateRequestBody withPaypalBillingAgreementId(JsonNullable<String> paypalBillingAgreementId) {
        Utils.checkNotNull(paypalBillingAgreementId, "paypalBillingAgreementId");
        this.paypalBillingAgreementId = paypalBillingAgreementId;
        return this;
    }

    /**
     * The Vault ID given by PayPal. For example: `8kk8451t`. Required for PayPal mandates. Must provide either this field or `paypalBillingAgreementId`, but not both.
     */
    public CreateMandateRequestBody withPayPalVaultId(String payPalVaultId) {
        Utils.checkNotNull(payPalVaultId, "payPalVaultId");
        this.payPalVaultId = JsonNullable.of(payPalVaultId);
        return this;
    }

    /**
     * The Vault ID given by PayPal. For example: `8kk8451t`. Required for PayPal mandates. Must provide either this field or `paypalBillingAgreementId`, but not both.
     */
    public CreateMandateRequestBody withPayPalVaultId(JsonNullable<String> payPalVaultId) {
        Utils.checkNotNull(payPalVaultId, "payPalVaultId");
        this.payPalVaultId = payPalVaultId;
        return this;
    }

    /**
     * Whether to create the entity in test mode or live mode.
     * 
     * <p>Most API credentials are specifically created for either live mode or test mode, in which case this parameter can be omitted. For organization-level credentials such as OAuth access tokens, you can enable test mode by setting `testmode` to `true`.
     */
    public CreateMandateRequestBody withTestmode(boolean testmode) {
        Utils.checkNotNull(testmode, "testmode");
        this.testmode = JsonNullable.of(testmode);
        return this;
    }

    /**
     * Whether to create the entity in test mode or live mode.
     * 
     * <p>Most API credentials are specifically created for either live mode or test mode, in which case this parameter can be omitted. For organization-level credentials such as OAuth access tokens, you can enable test mode by setting `testmode` to `true`.
     */
    public CreateMandateRequestBody withTestmode(JsonNullable<Boolean> testmode) {
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
        CreateMandateRequestBody other = (CreateMandateRequestBody) o;
        return 
            Utils.enhancedDeepEquals(this.id, other.id) &&
            Utils.enhancedDeepEquals(this.method, other.method) &&
            Utils.enhancedDeepEquals(this.consumerName, other.consumerName) &&
            Utils.enhancedDeepEquals(this.consumerAccount, other.consumerAccount) &&
            Utils.enhancedDeepEquals(this.consumerBic, other.consumerBic) &&
            Utils.enhancedDeepEquals(this.consumerEmail, other.consumerEmail) &&
            Utils.enhancedDeepEquals(this.signatureDate, other.signatureDate) &&
            Utils.enhancedDeepEquals(this.mandateReference, other.mandateReference) &&
            Utils.enhancedDeepEquals(this.paypalBillingAgreementId, other.paypalBillingAgreementId) &&
            Utils.enhancedDeepEquals(this.payPalVaultId, other.payPalVaultId) &&
            Utils.enhancedDeepEquals(this.testmode, other.testmode);
    }
    
    @Override
    public int hashCode() {
        return Utils.enhancedHash(
            id, method, consumerName,
            consumerAccount, consumerBic, consumerEmail,
            signatureDate, mandateReference, paypalBillingAgreementId,
            payPalVaultId, testmode);
    }
    
    @Override
    public String toString() {
        return Utils.toString(CreateMandateRequestBody.class,
                "id", id,
                "method", method,
                "consumerName", consumerName,
                "consumerAccount", consumerAccount,
                "consumerBic", consumerBic,
                "consumerEmail", consumerEmail,
                "signatureDate", signatureDate,
                "mandateReference", mandateReference,
                "paypalBillingAgreementId", paypalBillingAgreementId,
                "payPalVaultId", payPalVaultId,
                "testmode", testmode);
    }

    @SuppressWarnings("UnusedReturnValue")
    public final static class Builder {

        private Optional<String> id = Optional.empty();

        private String method;

        private String consumerName;

        private JsonNullable<String> consumerAccount = JsonNullable.undefined();

        private JsonNullable<String> consumerBic = JsonNullable.undefined();

        private JsonNullable<String> consumerEmail = JsonNullable.undefined();

        private JsonNullable<String> signatureDate = JsonNullable.undefined();

        private JsonNullable<String> mandateReference = JsonNullable.undefined();

        private JsonNullable<String> paypalBillingAgreementId = JsonNullable.undefined();

        private JsonNullable<String> payPalVaultId = JsonNullable.undefined();

        private JsonNullable<Boolean> testmode = JsonNullable.undefined();

        private Builder() {
          // force use of static builder() method
        }


        /**
         * The identifier uniquely referring to this mandate. Example: `mdt_pWUnw6pkBN`.
         */
        public Builder id(String id) {
            Utils.checkNotNull(id, "id");
            this.id = Optional.ofNullable(id);
            return this;
        }

        /**
         * The identifier uniquely referring to this mandate. Example: `mdt_pWUnw6pkBN`.
         */
        public Builder id(Optional<String> id) {
            Utils.checkNotNull(id, "id");
            this.id = id;
            return this;
        }


        /**
         * Payment method of the mandate.
         * 
         * <p>SEPA Direct Debit and PayPal mandates can be created directly.
         * 
         * <p>Possible values: `creditcard` `directdebit` `paypal`
         */
        public Builder method(String method) {
            Utils.checkNotNull(method, "method");
            this.method = method;
            return this;
        }


        /**
         * The customer's name.
         */
        public Builder consumerName(String consumerName) {
            Utils.checkNotNull(consumerName, "consumerName");
            this.consumerName = consumerName;
            return this;
        }


        /**
         * The customer's IBAN. Required for SEPA Direct Debit mandates.
         */
        public Builder consumerAccount(String consumerAccount) {
            Utils.checkNotNull(consumerAccount, "consumerAccount");
            this.consumerAccount = JsonNullable.of(consumerAccount);
            return this;
        }

        /**
         * The customer's IBAN. Required for SEPA Direct Debit mandates.
         */
        public Builder consumerAccount(JsonNullable<String> consumerAccount) {
            Utils.checkNotNull(consumerAccount, "consumerAccount");
            this.consumerAccount = consumerAccount;
            return this;
        }


        /**
         * The BIC of the customer's bank.
         */
        public Builder consumerBic(String consumerBic) {
            Utils.checkNotNull(consumerBic, "consumerBic");
            this.consumerBic = JsonNullable.of(consumerBic);
            return this;
        }

        /**
         * The BIC of the customer's bank.
         */
        public Builder consumerBic(JsonNullable<String> consumerBic) {
            Utils.checkNotNull(consumerBic, "consumerBic");
            this.consumerBic = consumerBic;
            return this;
        }


        /**
         * The customer's email address. Required for PayPal mandates.
         */
        public Builder consumerEmail(String consumerEmail) {
            Utils.checkNotNull(consumerEmail, "consumerEmail");
            this.consumerEmail = JsonNullable.of(consumerEmail);
            return this;
        }

        /**
         * The customer's email address. Required for PayPal mandates.
         */
        public Builder consumerEmail(JsonNullable<String> consumerEmail) {
            Utils.checkNotNull(consumerEmail, "consumerEmail");
            this.consumerEmail = consumerEmail;
            return this;
        }


        /**
         * The date when the mandate was signed in `YYYY-MM-DD` format.
         */
        public Builder signatureDate(String signatureDate) {
            Utils.checkNotNull(signatureDate, "signatureDate");
            this.signatureDate = JsonNullable.of(signatureDate);
            return this;
        }

        /**
         * The date when the mandate was signed in `YYYY-MM-DD` format.
         */
        public Builder signatureDate(JsonNullable<String> signatureDate) {
            Utils.checkNotNull(signatureDate, "signatureDate");
            this.signatureDate = signatureDate;
            return this;
        }


        /**
         * A custom mandate reference. For SEPA Direct Debit, it is vital to provide a unique reference. Some banks will decline Direct Debit payments if the mandate reference is not unique.
         */
        public Builder mandateReference(String mandateReference) {
            Utils.checkNotNull(mandateReference, "mandateReference");
            this.mandateReference = JsonNullable.of(mandateReference);
            return this;
        }

        /**
         * A custom mandate reference. For SEPA Direct Debit, it is vital to provide a unique reference. Some banks will decline Direct Debit payments if the mandate reference is not unique.
         */
        public Builder mandateReference(JsonNullable<String> mandateReference) {
            Utils.checkNotNull(mandateReference, "mandateReference");
            this.mandateReference = mandateReference;
            return this;
        }


        /**
         * The billing agreement ID given by PayPal. For example: `B-12A34567B8901234CD`. Required for PayPal mandates. Must provide either this field or `payPalVaultId`, but not both.
         */
        public Builder paypalBillingAgreementId(String paypalBillingAgreementId) {
            Utils.checkNotNull(paypalBillingAgreementId, "paypalBillingAgreementId");
            this.paypalBillingAgreementId = JsonNullable.of(paypalBillingAgreementId);
            return this;
        }

        /**
         * The billing agreement ID given by PayPal. For example: `B-12A34567B8901234CD`. Required for PayPal mandates. Must provide either this field or `payPalVaultId`, but not both.
         */
        public Builder paypalBillingAgreementId(JsonNullable<String> paypalBillingAgreementId) {
            Utils.checkNotNull(paypalBillingAgreementId, "paypalBillingAgreementId");
            this.paypalBillingAgreementId = paypalBillingAgreementId;
            return this;
        }


        /**
         * The Vault ID given by PayPal. For example: `8kk8451t`. Required for PayPal mandates. Must provide either this field or `paypalBillingAgreementId`, but not both.
         */
        public Builder payPalVaultId(String payPalVaultId) {
            Utils.checkNotNull(payPalVaultId, "payPalVaultId");
            this.payPalVaultId = JsonNullable.of(payPalVaultId);
            return this;
        }

        /**
         * The Vault ID given by PayPal. For example: `8kk8451t`. Required for PayPal mandates. Must provide either this field or `paypalBillingAgreementId`, but not both.
         */
        public Builder payPalVaultId(JsonNullable<String> payPalVaultId) {
            Utils.checkNotNull(payPalVaultId, "payPalVaultId");
            this.payPalVaultId = payPalVaultId;
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

        public CreateMandateRequestBody build() {

            return new CreateMandateRequestBody(
                id, method, consumerName,
                consumerAccount, consumerBic, consumerEmail,
                signatureDate, mandateReference, paypalBillingAgreementId,
                payPalVaultId, testmode);
        }

    }
}
