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
import java.util.List;
import java.util.Optional;
import org.openapitools.jackson.nullable.JsonNullable;


public class GetBalanceReportBalancesResponse200ApplicationHalPlusJsonResponseBodySubtotals {

    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("sub-totals")
    private JsonNullable<? extends List<GetBalanceReportBalancesResponse200ApplicationHalPlusJsonResponseBodyTotalsAvailableBalanceImmediatelyAvailableSubTotals>> subTotals;

    /**
     * Number of transactions of this type
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("count")
    private Optional<Long> count;

    /**
     * Payment type of the transactions
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("method")
    private JsonNullable<String> method;

    /**
     * In case of payments transactions with card, the card issuer will be available
     * 
     * <p>Possible values: `amex` `maestro` `carte-bancaire` `other`
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("cardIssuer")
    private JsonNullable<String> cardIssuer;

    /**
     * In case of payments trnsactions with card, the card audience will be available.
     * 
     * <p>Possible values: `corporate` `other`
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("cardAudience")
    private JsonNullable<String> cardAudience;

    /**
     * In case of payments transactions with card, the card region will be available.
     * 
     * <p>Possible values: `intra-eea` `intra-eu` `domestic` `other`
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("cardRegion")
    private JsonNullable<String> cardRegion;

    /**
     * Present when the transaction represents a fee.
     * 
     * <p>Possible values: `payment-fee` `direct-debit-failure-fee` `unauthorized-direct-debit-fee` `bank-charged-direct-debit-failure-fee` `partner-commission` `application-fee` `capture-fee` `refund-fee` `chargeback-fee` `payment-notification-fee` `transfer-notification-fee` `payout-fee` `fee-discount` `fee-reimbursement` `platform-volume-fee` `platform-connected-organizations-fee` `balance-charge-fee` `3ds-authentication-attempt-fee` `terminal-monthly-fee` `acceptance-risk-fee` `top-up-fee` `payment-gateway-fee` `mastercard-specialty-merchant-program-processing-fee` `mastercard-specialty-merchant-program-registration-fee` `visa-integrity-risk-program-processing-fee` `visa-integrity-risk-program-registration-fee` `minimum-invoice-amount-fee`
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("feeType")
    private JsonNullable<String> feeType;

    /**
     * Prepayment part: fee itself, reimbursement, discount, VAT or rounding compensation.
     * 
     * <p>Possible values: `fee` `fee-reimbursement` `fee-discount` `fee-vat` `fee-rounding-compensation`
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("prepaymentPartType")
    private JsonNullable<String> prepaymentPartType;

    /**
     * Represents the transaction type
     * 
     * <p>Possible values: `payment` `split-payment` `failed-payment` `failed-platform-split-payment` `failed-split-payment-compensation` `capture` `split-transaction` `refund` `platform-payment-refund` `returned-platform-payment-refund` `refund-compensation` `returned-refund-compensation` `returned-refund` `chargeback` `chargeback-reversal` `chargeback-compensation` `reversed-chargeback-compensation` `platform-payment-chargeback` `reversed-platform-payment-chargeback` `fee-prepayment` `outgoing-transfer` `incoming-transfer` `canceled-transfer` `returned-transfer` `balance-reserve` `balance-reserve-return` `invoice-rounding-compensation` `rolling-reserve-hold` `rolling-reserve-release` `balance-correction` `repayment` `loan` `balance-topup` `cash-collateral-issuance';` `cash-collateral-release` `pending-rolling-reserve` `to-be-released-rolling-reserve` `held-rolling-reserve` `released-rolling-reserve`
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("transactionType")
    private JsonNullable<String> transactionType;

    @JsonCreator
    public GetBalanceReportBalancesResponse200ApplicationHalPlusJsonResponseBodySubtotals(
            @JsonProperty("sub-totals") JsonNullable<? extends List<GetBalanceReportBalancesResponse200ApplicationHalPlusJsonResponseBodyTotalsAvailableBalanceImmediatelyAvailableSubTotals>> subTotals,
            @JsonProperty("count") Optional<Long> count,
            @JsonProperty("method") JsonNullable<String> method,
            @JsonProperty("cardIssuer") JsonNullable<String> cardIssuer,
            @JsonProperty("cardAudience") JsonNullable<String> cardAudience,
            @JsonProperty("cardRegion") JsonNullable<String> cardRegion,
            @JsonProperty("feeType") JsonNullable<String> feeType,
            @JsonProperty("prepaymentPartType") JsonNullable<String> prepaymentPartType,
            @JsonProperty("transactionType") JsonNullable<String> transactionType) {
        Utils.checkNotNull(subTotals, "subTotals");
        Utils.checkNotNull(count, "count");
        Utils.checkNotNull(method, "method");
        Utils.checkNotNull(cardIssuer, "cardIssuer");
        Utils.checkNotNull(cardAudience, "cardAudience");
        Utils.checkNotNull(cardRegion, "cardRegion");
        Utils.checkNotNull(feeType, "feeType");
        Utils.checkNotNull(prepaymentPartType, "prepaymentPartType");
        Utils.checkNotNull(transactionType, "transactionType");
        this.subTotals = subTotals;
        this.count = count;
        this.method = method;
        this.cardIssuer = cardIssuer;
        this.cardAudience = cardAudience;
        this.cardRegion = cardRegion;
        this.feeType = feeType;
        this.prepaymentPartType = prepaymentPartType;
        this.transactionType = transactionType;
    }
    
    public GetBalanceReportBalancesResponse200ApplicationHalPlusJsonResponseBodySubtotals() {
        this(JsonNullable.undefined(), Optional.empty(), JsonNullable.undefined(),
            JsonNullable.undefined(), JsonNullable.undefined(), JsonNullable.undefined(),
            JsonNullable.undefined(), JsonNullable.undefined(), JsonNullable.undefined());
    }

    @SuppressWarnings("unchecked")
    @JsonIgnore
    public JsonNullable<List<GetBalanceReportBalancesResponse200ApplicationHalPlusJsonResponseBodyTotalsAvailableBalanceImmediatelyAvailableSubTotals>> subTotals() {
        return (JsonNullable<List<GetBalanceReportBalancesResponse200ApplicationHalPlusJsonResponseBodyTotalsAvailableBalanceImmediatelyAvailableSubTotals>>) subTotals;
    }

    /**
     * Number of transactions of this type
     */
    @JsonIgnore
    public Optional<Long> count() {
        return count;
    }

    /**
     * Payment type of the transactions
     */
    @JsonIgnore
    public JsonNullable<String> method() {
        return method;
    }

    /**
     * In case of payments transactions with card, the card issuer will be available
     * 
     * <p>Possible values: `amex` `maestro` `carte-bancaire` `other`
     */
    @JsonIgnore
    public JsonNullable<String> cardIssuer() {
        return cardIssuer;
    }

    /**
     * In case of payments trnsactions with card, the card audience will be available.
     * 
     * <p>Possible values: `corporate` `other`
     */
    @JsonIgnore
    public JsonNullable<String> cardAudience() {
        return cardAudience;
    }

    /**
     * In case of payments transactions with card, the card region will be available.
     * 
     * <p>Possible values: `intra-eea` `intra-eu` `domestic` `other`
     */
    @JsonIgnore
    public JsonNullable<String> cardRegion() {
        return cardRegion;
    }

    /**
     * Present when the transaction represents a fee.
     * 
     * <p>Possible values: `payment-fee` `direct-debit-failure-fee` `unauthorized-direct-debit-fee` `bank-charged-direct-debit-failure-fee` `partner-commission` `application-fee` `capture-fee` `refund-fee` `chargeback-fee` `payment-notification-fee` `transfer-notification-fee` `payout-fee` `fee-discount` `fee-reimbursement` `platform-volume-fee` `platform-connected-organizations-fee` `balance-charge-fee` `3ds-authentication-attempt-fee` `terminal-monthly-fee` `acceptance-risk-fee` `top-up-fee` `payment-gateway-fee` `mastercard-specialty-merchant-program-processing-fee` `mastercard-specialty-merchant-program-registration-fee` `visa-integrity-risk-program-processing-fee` `visa-integrity-risk-program-registration-fee` `minimum-invoice-amount-fee`
     */
    @JsonIgnore
    public JsonNullable<String> feeType() {
        return feeType;
    }

    /**
     * Prepayment part: fee itself, reimbursement, discount, VAT or rounding compensation.
     * 
     * <p>Possible values: `fee` `fee-reimbursement` `fee-discount` `fee-vat` `fee-rounding-compensation`
     */
    @JsonIgnore
    public JsonNullable<String> prepaymentPartType() {
        return prepaymentPartType;
    }

    /**
     * Represents the transaction type
     * 
     * <p>Possible values: `payment` `split-payment` `failed-payment` `failed-platform-split-payment` `failed-split-payment-compensation` `capture` `split-transaction` `refund` `platform-payment-refund` `returned-platform-payment-refund` `refund-compensation` `returned-refund-compensation` `returned-refund` `chargeback` `chargeback-reversal` `chargeback-compensation` `reversed-chargeback-compensation` `platform-payment-chargeback` `reversed-platform-payment-chargeback` `fee-prepayment` `outgoing-transfer` `incoming-transfer` `canceled-transfer` `returned-transfer` `balance-reserve` `balance-reserve-return` `invoice-rounding-compensation` `rolling-reserve-hold` `rolling-reserve-release` `balance-correction` `repayment` `loan` `balance-topup` `cash-collateral-issuance';` `cash-collateral-release` `pending-rolling-reserve` `to-be-released-rolling-reserve` `held-rolling-reserve` `released-rolling-reserve`
     */
    @JsonIgnore
    public JsonNullable<String> transactionType() {
        return transactionType;
    }

    public static Builder builder() {
        return new Builder();
    }


    public GetBalanceReportBalancesResponse200ApplicationHalPlusJsonResponseBodySubtotals withSubTotals(List<GetBalanceReportBalancesResponse200ApplicationHalPlusJsonResponseBodyTotalsAvailableBalanceImmediatelyAvailableSubTotals> subTotals) {
        Utils.checkNotNull(subTotals, "subTotals");
        this.subTotals = JsonNullable.of(subTotals);
        return this;
    }

    public GetBalanceReportBalancesResponse200ApplicationHalPlusJsonResponseBodySubtotals withSubTotals(JsonNullable<? extends List<GetBalanceReportBalancesResponse200ApplicationHalPlusJsonResponseBodyTotalsAvailableBalanceImmediatelyAvailableSubTotals>> subTotals) {
        Utils.checkNotNull(subTotals, "subTotals");
        this.subTotals = subTotals;
        return this;
    }

    /**
     * Number of transactions of this type
     */
    public GetBalanceReportBalancesResponse200ApplicationHalPlusJsonResponseBodySubtotals withCount(long count) {
        Utils.checkNotNull(count, "count");
        this.count = Optional.ofNullable(count);
        return this;
    }


    /**
     * Number of transactions of this type
     */
    public GetBalanceReportBalancesResponse200ApplicationHalPlusJsonResponseBodySubtotals withCount(Optional<Long> count) {
        Utils.checkNotNull(count, "count");
        this.count = count;
        return this;
    }

    /**
     * Payment type of the transactions
     */
    public GetBalanceReportBalancesResponse200ApplicationHalPlusJsonResponseBodySubtotals withMethod(String method) {
        Utils.checkNotNull(method, "method");
        this.method = JsonNullable.of(method);
        return this;
    }

    /**
     * Payment type of the transactions
     */
    public GetBalanceReportBalancesResponse200ApplicationHalPlusJsonResponseBodySubtotals withMethod(JsonNullable<String> method) {
        Utils.checkNotNull(method, "method");
        this.method = method;
        return this;
    }

    /**
     * In case of payments transactions with card, the card issuer will be available
     * 
     * <p>Possible values: `amex` `maestro` `carte-bancaire` `other`
     */
    public GetBalanceReportBalancesResponse200ApplicationHalPlusJsonResponseBodySubtotals withCardIssuer(String cardIssuer) {
        Utils.checkNotNull(cardIssuer, "cardIssuer");
        this.cardIssuer = JsonNullable.of(cardIssuer);
        return this;
    }

    /**
     * In case of payments transactions with card, the card issuer will be available
     * 
     * <p>Possible values: `amex` `maestro` `carte-bancaire` `other`
     */
    public GetBalanceReportBalancesResponse200ApplicationHalPlusJsonResponseBodySubtotals withCardIssuer(JsonNullable<String> cardIssuer) {
        Utils.checkNotNull(cardIssuer, "cardIssuer");
        this.cardIssuer = cardIssuer;
        return this;
    }

    /**
     * In case of payments trnsactions with card, the card audience will be available.
     * 
     * <p>Possible values: `corporate` `other`
     */
    public GetBalanceReportBalancesResponse200ApplicationHalPlusJsonResponseBodySubtotals withCardAudience(String cardAudience) {
        Utils.checkNotNull(cardAudience, "cardAudience");
        this.cardAudience = JsonNullable.of(cardAudience);
        return this;
    }

    /**
     * In case of payments trnsactions with card, the card audience will be available.
     * 
     * <p>Possible values: `corporate` `other`
     */
    public GetBalanceReportBalancesResponse200ApplicationHalPlusJsonResponseBodySubtotals withCardAudience(JsonNullable<String> cardAudience) {
        Utils.checkNotNull(cardAudience, "cardAudience");
        this.cardAudience = cardAudience;
        return this;
    }

    /**
     * In case of payments transactions with card, the card region will be available.
     * 
     * <p>Possible values: `intra-eea` `intra-eu` `domestic` `other`
     */
    public GetBalanceReportBalancesResponse200ApplicationHalPlusJsonResponseBodySubtotals withCardRegion(String cardRegion) {
        Utils.checkNotNull(cardRegion, "cardRegion");
        this.cardRegion = JsonNullable.of(cardRegion);
        return this;
    }

    /**
     * In case of payments transactions with card, the card region will be available.
     * 
     * <p>Possible values: `intra-eea` `intra-eu` `domestic` `other`
     */
    public GetBalanceReportBalancesResponse200ApplicationHalPlusJsonResponseBodySubtotals withCardRegion(JsonNullable<String> cardRegion) {
        Utils.checkNotNull(cardRegion, "cardRegion");
        this.cardRegion = cardRegion;
        return this;
    }

    /**
     * Present when the transaction represents a fee.
     * 
     * <p>Possible values: `payment-fee` `direct-debit-failure-fee` `unauthorized-direct-debit-fee` `bank-charged-direct-debit-failure-fee` `partner-commission` `application-fee` `capture-fee` `refund-fee` `chargeback-fee` `payment-notification-fee` `transfer-notification-fee` `payout-fee` `fee-discount` `fee-reimbursement` `platform-volume-fee` `platform-connected-organizations-fee` `balance-charge-fee` `3ds-authentication-attempt-fee` `terminal-monthly-fee` `acceptance-risk-fee` `top-up-fee` `payment-gateway-fee` `mastercard-specialty-merchant-program-processing-fee` `mastercard-specialty-merchant-program-registration-fee` `visa-integrity-risk-program-processing-fee` `visa-integrity-risk-program-registration-fee` `minimum-invoice-amount-fee`
     */
    public GetBalanceReportBalancesResponse200ApplicationHalPlusJsonResponseBodySubtotals withFeeType(String feeType) {
        Utils.checkNotNull(feeType, "feeType");
        this.feeType = JsonNullable.of(feeType);
        return this;
    }

    /**
     * Present when the transaction represents a fee.
     * 
     * <p>Possible values: `payment-fee` `direct-debit-failure-fee` `unauthorized-direct-debit-fee` `bank-charged-direct-debit-failure-fee` `partner-commission` `application-fee` `capture-fee` `refund-fee` `chargeback-fee` `payment-notification-fee` `transfer-notification-fee` `payout-fee` `fee-discount` `fee-reimbursement` `platform-volume-fee` `platform-connected-organizations-fee` `balance-charge-fee` `3ds-authentication-attempt-fee` `terminal-monthly-fee` `acceptance-risk-fee` `top-up-fee` `payment-gateway-fee` `mastercard-specialty-merchant-program-processing-fee` `mastercard-specialty-merchant-program-registration-fee` `visa-integrity-risk-program-processing-fee` `visa-integrity-risk-program-registration-fee` `minimum-invoice-amount-fee`
     */
    public GetBalanceReportBalancesResponse200ApplicationHalPlusJsonResponseBodySubtotals withFeeType(JsonNullable<String> feeType) {
        Utils.checkNotNull(feeType, "feeType");
        this.feeType = feeType;
        return this;
    }

    /**
     * Prepayment part: fee itself, reimbursement, discount, VAT or rounding compensation.
     * 
     * <p>Possible values: `fee` `fee-reimbursement` `fee-discount` `fee-vat` `fee-rounding-compensation`
     */
    public GetBalanceReportBalancesResponse200ApplicationHalPlusJsonResponseBodySubtotals withPrepaymentPartType(String prepaymentPartType) {
        Utils.checkNotNull(prepaymentPartType, "prepaymentPartType");
        this.prepaymentPartType = JsonNullable.of(prepaymentPartType);
        return this;
    }

    /**
     * Prepayment part: fee itself, reimbursement, discount, VAT or rounding compensation.
     * 
     * <p>Possible values: `fee` `fee-reimbursement` `fee-discount` `fee-vat` `fee-rounding-compensation`
     */
    public GetBalanceReportBalancesResponse200ApplicationHalPlusJsonResponseBodySubtotals withPrepaymentPartType(JsonNullable<String> prepaymentPartType) {
        Utils.checkNotNull(prepaymentPartType, "prepaymentPartType");
        this.prepaymentPartType = prepaymentPartType;
        return this;
    }

    /**
     * Represents the transaction type
     * 
     * <p>Possible values: `payment` `split-payment` `failed-payment` `failed-platform-split-payment` `failed-split-payment-compensation` `capture` `split-transaction` `refund` `platform-payment-refund` `returned-platform-payment-refund` `refund-compensation` `returned-refund-compensation` `returned-refund` `chargeback` `chargeback-reversal` `chargeback-compensation` `reversed-chargeback-compensation` `platform-payment-chargeback` `reversed-platform-payment-chargeback` `fee-prepayment` `outgoing-transfer` `incoming-transfer` `canceled-transfer` `returned-transfer` `balance-reserve` `balance-reserve-return` `invoice-rounding-compensation` `rolling-reserve-hold` `rolling-reserve-release` `balance-correction` `repayment` `loan` `balance-topup` `cash-collateral-issuance';` `cash-collateral-release` `pending-rolling-reserve` `to-be-released-rolling-reserve` `held-rolling-reserve` `released-rolling-reserve`
     */
    public GetBalanceReportBalancesResponse200ApplicationHalPlusJsonResponseBodySubtotals withTransactionType(String transactionType) {
        Utils.checkNotNull(transactionType, "transactionType");
        this.transactionType = JsonNullable.of(transactionType);
        return this;
    }

    /**
     * Represents the transaction type
     * 
     * <p>Possible values: `payment` `split-payment` `failed-payment` `failed-platform-split-payment` `failed-split-payment-compensation` `capture` `split-transaction` `refund` `platform-payment-refund` `returned-platform-payment-refund` `refund-compensation` `returned-refund-compensation` `returned-refund` `chargeback` `chargeback-reversal` `chargeback-compensation` `reversed-chargeback-compensation` `platform-payment-chargeback` `reversed-platform-payment-chargeback` `fee-prepayment` `outgoing-transfer` `incoming-transfer` `canceled-transfer` `returned-transfer` `balance-reserve` `balance-reserve-return` `invoice-rounding-compensation` `rolling-reserve-hold` `rolling-reserve-release` `balance-correction` `repayment` `loan` `balance-topup` `cash-collateral-issuance';` `cash-collateral-release` `pending-rolling-reserve` `to-be-released-rolling-reserve` `held-rolling-reserve` `released-rolling-reserve`
     */
    public GetBalanceReportBalancesResponse200ApplicationHalPlusJsonResponseBodySubtotals withTransactionType(JsonNullable<String> transactionType) {
        Utils.checkNotNull(transactionType, "transactionType");
        this.transactionType = transactionType;
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
        GetBalanceReportBalancesResponse200ApplicationHalPlusJsonResponseBodySubtotals other = (GetBalanceReportBalancesResponse200ApplicationHalPlusJsonResponseBodySubtotals) o;
        return 
            Utils.enhancedDeepEquals(this.subTotals, other.subTotals) &&
            Utils.enhancedDeepEquals(this.count, other.count) &&
            Utils.enhancedDeepEquals(this.method, other.method) &&
            Utils.enhancedDeepEquals(this.cardIssuer, other.cardIssuer) &&
            Utils.enhancedDeepEquals(this.cardAudience, other.cardAudience) &&
            Utils.enhancedDeepEquals(this.cardRegion, other.cardRegion) &&
            Utils.enhancedDeepEquals(this.feeType, other.feeType) &&
            Utils.enhancedDeepEquals(this.prepaymentPartType, other.prepaymentPartType) &&
            Utils.enhancedDeepEquals(this.transactionType, other.transactionType);
    }
    
    @Override
    public int hashCode() {
        return Utils.enhancedHash(
            subTotals, count, method,
            cardIssuer, cardAudience, cardRegion,
            feeType, prepaymentPartType, transactionType);
    }
    
    @Override
    public String toString() {
        return Utils.toString(GetBalanceReportBalancesResponse200ApplicationHalPlusJsonResponseBodySubtotals.class,
                "subTotals", subTotals,
                "count", count,
                "method", method,
                "cardIssuer", cardIssuer,
                "cardAudience", cardAudience,
                "cardRegion", cardRegion,
                "feeType", feeType,
                "prepaymentPartType", prepaymentPartType,
                "transactionType", transactionType);
    }

    @SuppressWarnings("UnusedReturnValue")
    public final static class Builder {

        private JsonNullable<? extends List<GetBalanceReportBalancesResponse200ApplicationHalPlusJsonResponseBodyTotalsAvailableBalanceImmediatelyAvailableSubTotals>> subTotals = JsonNullable.undefined();

        private Optional<Long> count = Optional.empty();

        private JsonNullable<String> method = JsonNullable.undefined();

        private JsonNullable<String> cardIssuer = JsonNullable.undefined();

        private JsonNullable<String> cardAudience = JsonNullable.undefined();

        private JsonNullable<String> cardRegion = JsonNullable.undefined();

        private JsonNullable<String> feeType = JsonNullable.undefined();

        private JsonNullable<String> prepaymentPartType = JsonNullable.undefined();

        private JsonNullable<String> transactionType = JsonNullable.undefined();

        private Builder() {
          // force use of static builder() method
        }


        public Builder subTotals(List<GetBalanceReportBalancesResponse200ApplicationHalPlusJsonResponseBodyTotalsAvailableBalanceImmediatelyAvailableSubTotals> subTotals) {
            Utils.checkNotNull(subTotals, "subTotals");
            this.subTotals = JsonNullable.of(subTotals);
            return this;
        }

        public Builder subTotals(JsonNullable<? extends List<GetBalanceReportBalancesResponse200ApplicationHalPlusJsonResponseBodyTotalsAvailableBalanceImmediatelyAvailableSubTotals>> subTotals) {
            Utils.checkNotNull(subTotals, "subTotals");
            this.subTotals = subTotals;
            return this;
        }


        /**
         * Number of transactions of this type
         */
        public Builder count(long count) {
            Utils.checkNotNull(count, "count");
            this.count = Optional.ofNullable(count);
            return this;
        }

        /**
         * Number of transactions of this type
         */
        public Builder count(Optional<Long> count) {
            Utils.checkNotNull(count, "count");
            this.count = count;
            return this;
        }


        /**
         * Payment type of the transactions
         */
        public Builder method(String method) {
            Utils.checkNotNull(method, "method");
            this.method = JsonNullable.of(method);
            return this;
        }

        /**
         * Payment type of the transactions
         */
        public Builder method(JsonNullable<String> method) {
            Utils.checkNotNull(method, "method");
            this.method = method;
            return this;
        }


        /**
         * In case of payments transactions with card, the card issuer will be available
         * 
         * <p>Possible values: `amex` `maestro` `carte-bancaire` `other`
         */
        public Builder cardIssuer(String cardIssuer) {
            Utils.checkNotNull(cardIssuer, "cardIssuer");
            this.cardIssuer = JsonNullable.of(cardIssuer);
            return this;
        }

        /**
         * In case of payments transactions with card, the card issuer will be available
         * 
         * <p>Possible values: `amex` `maestro` `carte-bancaire` `other`
         */
        public Builder cardIssuer(JsonNullable<String> cardIssuer) {
            Utils.checkNotNull(cardIssuer, "cardIssuer");
            this.cardIssuer = cardIssuer;
            return this;
        }


        /**
         * In case of payments trnsactions with card, the card audience will be available.
         * 
         * <p>Possible values: `corporate` `other`
         */
        public Builder cardAudience(String cardAudience) {
            Utils.checkNotNull(cardAudience, "cardAudience");
            this.cardAudience = JsonNullable.of(cardAudience);
            return this;
        }

        /**
         * In case of payments trnsactions with card, the card audience will be available.
         * 
         * <p>Possible values: `corporate` `other`
         */
        public Builder cardAudience(JsonNullable<String> cardAudience) {
            Utils.checkNotNull(cardAudience, "cardAudience");
            this.cardAudience = cardAudience;
            return this;
        }


        /**
         * In case of payments transactions with card, the card region will be available.
         * 
         * <p>Possible values: `intra-eea` `intra-eu` `domestic` `other`
         */
        public Builder cardRegion(String cardRegion) {
            Utils.checkNotNull(cardRegion, "cardRegion");
            this.cardRegion = JsonNullable.of(cardRegion);
            return this;
        }

        /**
         * In case of payments transactions with card, the card region will be available.
         * 
         * <p>Possible values: `intra-eea` `intra-eu` `domestic` `other`
         */
        public Builder cardRegion(JsonNullable<String> cardRegion) {
            Utils.checkNotNull(cardRegion, "cardRegion");
            this.cardRegion = cardRegion;
            return this;
        }


        /**
         * Present when the transaction represents a fee.
         * 
         * <p>Possible values: `payment-fee` `direct-debit-failure-fee` `unauthorized-direct-debit-fee` `bank-charged-direct-debit-failure-fee` `partner-commission` `application-fee` `capture-fee` `refund-fee` `chargeback-fee` `payment-notification-fee` `transfer-notification-fee` `payout-fee` `fee-discount` `fee-reimbursement` `platform-volume-fee` `platform-connected-organizations-fee` `balance-charge-fee` `3ds-authentication-attempt-fee` `terminal-monthly-fee` `acceptance-risk-fee` `top-up-fee` `payment-gateway-fee` `mastercard-specialty-merchant-program-processing-fee` `mastercard-specialty-merchant-program-registration-fee` `visa-integrity-risk-program-processing-fee` `visa-integrity-risk-program-registration-fee` `minimum-invoice-amount-fee`
         */
        public Builder feeType(String feeType) {
            Utils.checkNotNull(feeType, "feeType");
            this.feeType = JsonNullable.of(feeType);
            return this;
        }

        /**
         * Present when the transaction represents a fee.
         * 
         * <p>Possible values: `payment-fee` `direct-debit-failure-fee` `unauthorized-direct-debit-fee` `bank-charged-direct-debit-failure-fee` `partner-commission` `application-fee` `capture-fee` `refund-fee` `chargeback-fee` `payment-notification-fee` `transfer-notification-fee` `payout-fee` `fee-discount` `fee-reimbursement` `platform-volume-fee` `platform-connected-organizations-fee` `balance-charge-fee` `3ds-authentication-attempt-fee` `terminal-monthly-fee` `acceptance-risk-fee` `top-up-fee` `payment-gateway-fee` `mastercard-specialty-merchant-program-processing-fee` `mastercard-specialty-merchant-program-registration-fee` `visa-integrity-risk-program-processing-fee` `visa-integrity-risk-program-registration-fee` `minimum-invoice-amount-fee`
         */
        public Builder feeType(JsonNullable<String> feeType) {
            Utils.checkNotNull(feeType, "feeType");
            this.feeType = feeType;
            return this;
        }


        /**
         * Prepayment part: fee itself, reimbursement, discount, VAT or rounding compensation.
         * 
         * <p>Possible values: `fee` `fee-reimbursement` `fee-discount` `fee-vat` `fee-rounding-compensation`
         */
        public Builder prepaymentPartType(String prepaymentPartType) {
            Utils.checkNotNull(prepaymentPartType, "prepaymentPartType");
            this.prepaymentPartType = JsonNullable.of(prepaymentPartType);
            return this;
        }

        /**
         * Prepayment part: fee itself, reimbursement, discount, VAT or rounding compensation.
         * 
         * <p>Possible values: `fee` `fee-reimbursement` `fee-discount` `fee-vat` `fee-rounding-compensation`
         */
        public Builder prepaymentPartType(JsonNullable<String> prepaymentPartType) {
            Utils.checkNotNull(prepaymentPartType, "prepaymentPartType");
            this.prepaymentPartType = prepaymentPartType;
            return this;
        }


        /**
         * Represents the transaction type
         * 
         * <p>Possible values: `payment` `split-payment` `failed-payment` `failed-platform-split-payment` `failed-split-payment-compensation` `capture` `split-transaction` `refund` `platform-payment-refund` `returned-platform-payment-refund` `refund-compensation` `returned-refund-compensation` `returned-refund` `chargeback` `chargeback-reversal` `chargeback-compensation` `reversed-chargeback-compensation` `platform-payment-chargeback` `reversed-platform-payment-chargeback` `fee-prepayment` `outgoing-transfer` `incoming-transfer` `canceled-transfer` `returned-transfer` `balance-reserve` `balance-reserve-return` `invoice-rounding-compensation` `rolling-reserve-hold` `rolling-reserve-release` `balance-correction` `repayment` `loan` `balance-topup` `cash-collateral-issuance';` `cash-collateral-release` `pending-rolling-reserve` `to-be-released-rolling-reserve` `held-rolling-reserve` `released-rolling-reserve`
         */
        public Builder transactionType(String transactionType) {
            Utils.checkNotNull(transactionType, "transactionType");
            this.transactionType = JsonNullable.of(transactionType);
            return this;
        }

        /**
         * Represents the transaction type
         * 
         * <p>Possible values: `payment` `split-payment` `failed-payment` `failed-platform-split-payment` `failed-split-payment-compensation` `capture` `split-transaction` `refund` `platform-payment-refund` `returned-platform-payment-refund` `refund-compensation` `returned-refund-compensation` `returned-refund` `chargeback` `chargeback-reversal` `chargeback-compensation` `reversed-chargeback-compensation` `platform-payment-chargeback` `reversed-platform-payment-chargeback` `fee-prepayment` `outgoing-transfer` `incoming-transfer` `canceled-transfer` `returned-transfer` `balance-reserve` `balance-reserve-return` `invoice-rounding-compensation` `rolling-reserve-hold` `rolling-reserve-release` `balance-correction` `repayment` `loan` `balance-topup` `cash-collateral-issuance';` `cash-collateral-release` `pending-rolling-reserve` `to-be-released-rolling-reserve` `held-rolling-reserve` `released-rolling-reserve`
         */
        public Builder transactionType(JsonNullable<String> transactionType) {
            Utils.checkNotNull(transactionType, "transactionType");
            this.transactionType = transactionType;
            return this;
        }

        public GetBalanceReportBalancesResponse200ApplicationHalPlusJsonResponseBodySubtotals build() {

            return new GetBalanceReportBalancesResponse200ApplicationHalPlusJsonResponseBodySubtotals(
                subTotals, count, method,
                cardIssuer, cardAudience, cardRegion,
                feeType, prepaymentPartType, transactionType);
        }

    }
}
