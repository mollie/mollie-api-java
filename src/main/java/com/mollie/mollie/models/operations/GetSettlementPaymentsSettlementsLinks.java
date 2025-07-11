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
import java.util.Optional;

/**
 * GetSettlementPaymentsSettlementsLinks
 * 
 * <p>An object with several relevant URLs. Every URL object will contain an `href` and a `type` field.
 */
public class GetSettlementPaymentsSettlementsLinks {
    /**
     * In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field.
     */
    @JsonProperty("self")
    private GetSettlementPaymentsSettlementsSelf self;

    /**
     * The URL your customer should visit to make the payment. This is where you should redirect the customer to.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("checkout")
    private Optional<? extends GetSettlementPaymentsCheckout> checkout;

    /**
     * The deeplink URL to the app of the payment method. Currently only available for `bancontact`.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("mobileAppCheckout")
    private Optional<? extends GetSettlementPaymentsMobileAppCheckout> mobileAppCheckout;

    /**
     * For test mode payments in certain scenarios, a hosted interface is available to help you test different payment states.
     * 
     * <p>Firstly, for recurring test mode payments. Recurring payments do not have a checkout URL, because these payments are executed without any user interaction.
     * 
     * <p>Secondly, for paid test mode payments. The payment state screen will then allow you to create a refund or chargeback for the test payment.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("changePaymentState")
    private Optional<? extends GetSettlementPaymentsChangePaymentState> changePaymentState;

    /**
     * Direct link to the payment in the Mollie Dashboard.
     */
    @JsonProperty("dashboard")
    private GetSettlementPaymentsDashboard dashboard;

    /**
     * The API resource URL of the [refunds](list-payment-refunds) that belong to this payment.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("refunds")
    private Optional<? extends GetSettlementPaymentsRefunds> refunds;

    /**
     * The API resource URL of the [chargebacks](list-payment-chargebacks) that belong to this payment.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("chargebacks")
    private Optional<? extends GetSettlementPaymentsChargebacks> chargebacks;

    /**
     * The API resource URL of the [captures](list-payment-captures) that belong to this payment.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("captures")
    private Optional<? extends GetSettlementPaymentsCaptures> captures;

    /**
     * The API resource URL of the [settlement](get-settlement) this payment has been settled with. Not present if not yet settled.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("settlement")
    private Optional<? extends GetSettlementPaymentsSettlement> settlement;

    /**
     * The API resource URL of the [customer](get-customer).
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("customer")
    private Optional<? extends GetSettlementPaymentsCustomer> customer;

    /**
     * The API resource URL of the [mandate](get-mandate).
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("mandate")
    private Optional<? extends GetSettlementPaymentsMandate> mandate;

    /**
     * The API resource URL of the [subscription](get-subscription).
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("subscription")
    private Optional<? extends GetSettlementPaymentsSubscription> subscription;

    /**
     * The API resource URL of the [order](get-order) this payment was created for. Not present if not created for an order.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("order")
    private Optional<? extends GetSettlementPaymentsOrder> order;

    /**
     * The API resource URL of the [terminal](get-terminal) this payment was created for. Only present for point-of-sale payments.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("terminal")
    private Optional<? extends GetSettlementPaymentsTerminal> terminal;

    /**
     * In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("documentation")
    private Optional<? extends GetSettlementPaymentsSettlementsDocumentation> documentation;

    @JsonCreator
    public GetSettlementPaymentsSettlementsLinks(
            @JsonProperty("self") GetSettlementPaymentsSettlementsSelf self,
            @JsonProperty("checkout") Optional<? extends GetSettlementPaymentsCheckout> checkout,
            @JsonProperty("mobileAppCheckout") Optional<? extends GetSettlementPaymentsMobileAppCheckout> mobileAppCheckout,
            @JsonProperty("changePaymentState") Optional<? extends GetSettlementPaymentsChangePaymentState> changePaymentState,
            @JsonProperty("dashboard") GetSettlementPaymentsDashboard dashboard,
            @JsonProperty("refunds") Optional<? extends GetSettlementPaymentsRefunds> refunds,
            @JsonProperty("chargebacks") Optional<? extends GetSettlementPaymentsChargebacks> chargebacks,
            @JsonProperty("captures") Optional<? extends GetSettlementPaymentsCaptures> captures,
            @JsonProperty("settlement") Optional<? extends GetSettlementPaymentsSettlement> settlement,
            @JsonProperty("customer") Optional<? extends GetSettlementPaymentsCustomer> customer,
            @JsonProperty("mandate") Optional<? extends GetSettlementPaymentsMandate> mandate,
            @JsonProperty("subscription") Optional<? extends GetSettlementPaymentsSubscription> subscription,
            @JsonProperty("order") Optional<? extends GetSettlementPaymentsOrder> order,
            @JsonProperty("terminal") Optional<? extends GetSettlementPaymentsTerminal> terminal,
            @JsonProperty("documentation") Optional<? extends GetSettlementPaymentsSettlementsDocumentation> documentation) {
        Utils.checkNotNull(self, "self");
        Utils.checkNotNull(checkout, "checkout");
        Utils.checkNotNull(mobileAppCheckout, "mobileAppCheckout");
        Utils.checkNotNull(changePaymentState, "changePaymentState");
        Utils.checkNotNull(dashboard, "dashboard");
        Utils.checkNotNull(refunds, "refunds");
        Utils.checkNotNull(chargebacks, "chargebacks");
        Utils.checkNotNull(captures, "captures");
        Utils.checkNotNull(settlement, "settlement");
        Utils.checkNotNull(customer, "customer");
        Utils.checkNotNull(mandate, "mandate");
        Utils.checkNotNull(subscription, "subscription");
        Utils.checkNotNull(order, "order");
        Utils.checkNotNull(terminal, "terminal");
        Utils.checkNotNull(documentation, "documentation");
        this.self = self;
        this.checkout = checkout;
        this.mobileAppCheckout = mobileAppCheckout;
        this.changePaymentState = changePaymentState;
        this.dashboard = dashboard;
        this.refunds = refunds;
        this.chargebacks = chargebacks;
        this.captures = captures;
        this.settlement = settlement;
        this.customer = customer;
        this.mandate = mandate;
        this.subscription = subscription;
        this.order = order;
        this.terminal = terminal;
        this.documentation = documentation;
    }
    
    public GetSettlementPaymentsSettlementsLinks(
            GetSettlementPaymentsSettlementsSelf self,
            GetSettlementPaymentsDashboard dashboard) {
        this(self, Optional.empty(), Optional.empty(),
            Optional.empty(), dashboard, Optional.empty(),
            Optional.empty(), Optional.empty(), Optional.empty(),
            Optional.empty(), Optional.empty(), Optional.empty(),
            Optional.empty(), Optional.empty(), Optional.empty());
    }

    /**
     * In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field.
     */
    @JsonIgnore
    public GetSettlementPaymentsSettlementsSelf self() {
        return self;
    }

    /**
     * The URL your customer should visit to make the payment. This is where you should redirect the customer to.
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<GetSettlementPaymentsCheckout> checkout() {
        return (Optional<GetSettlementPaymentsCheckout>) checkout;
    }

    /**
     * The deeplink URL to the app of the payment method. Currently only available for `bancontact`.
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<GetSettlementPaymentsMobileAppCheckout> mobileAppCheckout() {
        return (Optional<GetSettlementPaymentsMobileAppCheckout>) mobileAppCheckout;
    }

    /**
     * For test mode payments in certain scenarios, a hosted interface is available to help you test different payment states.
     * 
     * <p>Firstly, for recurring test mode payments. Recurring payments do not have a checkout URL, because these payments are executed without any user interaction.
     * 
     * <p>Secondly, for paid test mode payments. The payment state screen will then allow you to create a refund or chargeback for the test payment.
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<GetSettlementPaymentsChangePaymentState> changePaymentState() {
        return (Optional<GetSettlementPaymentsChangePaymentState>) changePaymentState;
    }

    /**
     * Direct link to the payment in the Mollie Dashboard.
     */
    @JsonIgnore
    public GetSettlementPaymentsDashboard dashboard() {
        return dashboard;
    }

    /**
     * The API resource URL of the [refunds](list-payment-refunds) that belong to this payment.
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<GetSettlementPaymentsRefunds> refunds() {
        return (Optional<GetSettlementPaymentsRefunds>) refunds;
    }

    /**
     * The API resource URL of the [chargebacks](list-payment-chargebacks) that belong to this payment.
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<GetSettlementPaymentsChargebacks> chargebacks() {
        return (Optional<GetSettlementPaymentsChargebacks>) chargebacks;
    }

    /**
     * The API resource URL of the [captures](list-payment-captures) that belong to this payment.
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<GetSettlementPaymentsCaptures> captures() {
        return (Optional<GetSettlementPaymentsCaptures>) captures;
    }

    /**
     * The API resource URL of the [settlement](get-settlement) this payment has been settled with. Not present if not yet settled.
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<GetSettlementPaymentsSettlement> settlement() {
        return (Optional<GetSettlementPaymentsSettlement>) settlement;
    }

    /**
     * The API resource URL of the [customer](get-customer).
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<GetSettlementPaymentsCustomer> customer() {
        return (Optional<GetSettlementPaymentsCustomer>) customer;
    }

    /**
     * The API resource URL of the [mandate](get-mandate).
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<GetSettlementPaymentsMandate> mandate() {
        return (Optional<GetSettlementPaymentsMandate>) mandate;
    }

    /**
     * The API resource URL of the [subscription](get-subscription).
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<GetSettlementPaymentsSubscription> subscription() {
        return (Optional<GetSettlementPaymentsSubscription>) subscription;
    }

    /**
     * The API resource URL of the [order](get-order) this payment was created for. Not present if not created for an order.
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<GetSettlementPaymentsOrder> order() {
        return (Optional<GetSettlementPaymentsOrder>) order;
    }

    /**
     * The API resource URL of the [terminal](get-terminal) this payment was created for. Only present for point-of-sale payments.
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<GetSettlementPaymentsTerminal> terminal() {
        return (Optional<GetSettlementPaymentsTerminal>) terminal;
    }

    /**
     * In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field.
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<GetSettlementPaymentsSettlementsDocumentation> documentation() {
        return (Optional<GetSettlementPaymentsSettlementsDocumentation>) documentation;
    }

    public static Builder builder() {
        return new Builder();
    }


    /**
     * In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field.
     */
    public GetSettlementPaymentsSettlementsLinks withSelf(GetSettlementPaymentsSettlementsSelf self) {
        Utils.checkNotNull(self, "self");
        this.self = self;
        return this;
    }

    /**
     * The URL your customer should visit to make the payment. This is where you should redirect the customer to.
     */
    public GetSettlementPaymentsSettlementsLinks withCheckout(GetSettlementPaymentsCheckout checkout) {
        Utils.checkNotNull(checkout, "checkout");
        this.checkout = Optional.ofNullable(checkout);
        return this;
    }


    /**
     * The URL your customer should visit to make the payment. This is where you should redirect the customer to.
     */
    public GetSettlementPaymentsSettlementsLinks withCheckout(Optional<? extends GetSettlementPaymentsCheckout> checkout) {
        Utils.checkNotNull(checkout, "checkout");
        this.checkout = checkout;
        return this;
    }

    /**
     * The deeplink URL to the app of the payment method. Currently only available for `bancontact`.
     */
    public GetSettlementPaymentsSettlementsLinks withMobileAppCheckout(GetSettlementPaymentsMobileAppCheckout mobileAppCheckout) {
        Utils.checkNotNull(mobileAppCheckout, "mobileAppCheckout");
        this.mobileAppCheckout = Optional.ofNullable(mobileAppCheckout);
        return this;
    }


    /**
     * The deeplink URL to the app of the payment method. Currently only available for `bancontact`.
     */
    public GetSettlementPaymentsSettlementsLinks withMobileAppCheckout(Optional<? extends GetSettlementPaymentsMobileAppCheckout> mobileAppCheckout) {
        Utils.checkNotNull(mobileAppCheckout, "mobileAppCheckout");
        this.mobileAppCheckout = mobileAppCheckout;
        return this;
    }

    /**
     * For test mode payments in certain scenarios, a hosted interface is available to help you test different payment states.
     * 
     * <p>Firstly, for recurring test mode payments. Recurring payments do not have a checkout URL, because these payments are executed without any user interaction.
     * 
     * <p>Secondly, for paid test mode payments. The payment state screen will then allow you to create a refund or chargeback for the test payment.
     */
    public GetSettlementPaymentsSettlementsLinks withChangePaymentState(GetSettlementPaymentsChangePaymentState changePaymentState) {
        Utils.checkNotNull(changePaymentState, "changePaymentState");
        this.changePaymentState = Optional.ofNullable(changePaymentState);
        return this;
    }


    /**
     * For test mode payments in certain scenarios, a hosted interface is available to help you test different payment states.
     * 
     * <p>Firstly, for recurring test mode payments. Recurring payments do not have a checkout URL, because these payments are executed without any user interaction.
     * 
     * <p>Secondly, for paid test mode payments. The payment state screen will then allow you to create a refund or chargeback for the test payment.
     */
    public GetSettlementPaymentsSettlementsLinks withChangePaymentState(Optional<? extends GetSettlementPaymentsChangePaymentState> changePaymentState) {
        Utils.checkNotNull(changePaymentState, "changePaymentState");
        this.changePaymentState = changePaymentState;
        return this;
    }

    /**
     * Direct link to the payment in the Mollie Dashboard.
     */
    public GetSettlementPaymentsSettlementsLinks withDashboard(GetSettlementPaymentsDashboard dashboard) {
        Utils.checkNotNull(dashboard, "dashboard");
        this.dashboard = dashboard;
        return this;
    }

    /**
     * The API resource URL of the [refunds](list-payment-refunds) that belong to this payment.
     */
    public GetSettlementPaymentsSettlementsLinks withRefunds(GetSettlementPaymentsRefunds refunds) {
        Utils.checkNotNull(refunds, "refunds");
        this.refunds = Optional.ofNullable(refunds);
        return this;
    }


    /**
     * The API resource URL of the [refunds](list-payment-refunds) that belong to this payment.
     */
    public GetSettlementPaymentsSettlementsLinks withRefunds(Optional<? extends GetSettlementPaymentsRefunds> refunds) {
        Utils.checkNotNull(refunds, "refunds");
        this.refunds = refunds;
        return this;
    }

    /**
     * The API resource URL of the [chargebacks](list-payment-chargebacks) that belong to this payment.
     */
    public GetSettlementPaymentsSettlementsLinks withChargebacks(GetSettlementPaymentsChargebacks chargebacks) {
        Utils.checkNotNull(chargebacks, "chargebacks");
        this.chargebacks = Optional.ofNullable(chargebacks);
        return this;
    }


    /**
     * The API resource URL of the [chargebacks](list-payment-chargebacks) that belong to this payment.
     */
    public GetSettlementPaymentsSettlementsLinks withChargebacks(Optional<? extends GetSettlementPaymentsChargebacks> chargebacks) {
        Utils.checkNotNull(chargebacks, "chargebacks");
        this.chargebacks = chargebacks;
        return this;
    }

    /**
     * The API resource URL of the [captures](list-payment-captures) that belong to this payment.
     */
    public GetSettlementPaymentsSettlementsLinks withCaptures(GetSettlementPaymentsCaptures captures) {
        Utils.checkNotNull(captures, "captures");
        this.captures = Optional.ofNullable(captures);
        return this;
    }


    /**
     * The API resource URL of the [captures](list-payment-captures) that belong to this payment.
     */
    public GetSettlementPaymentsSettlementsLinks withCaptures(Optional<? extends GetSettlementPaymentsCaptures> captures) {
        Utils.checkNotNull(captures, "captures");
        this.captures = captures;
        return this;
    }

    /**
     * The API resource URL of the [settlement](get-settlement) this payment has been settled with. Not present if not yet settled.
     */
    public GetSettlementPaymentsSettlementsLinks withSettlement(GetSettlementPaymentsSettlement settlement) {
        Utils.checkNotNull(settlement, "settlement");
        this.settlement = Optional.ofNullable(settlement);
        return this;
    }


    /**
     * The API resource URL of the [settlement](get-settlement) this payment has been settled with. Not present if not yet settled.
     */
    public GetSettlementPaymentsSettlementsLinks withSettlement(Optional<? extends GetSettlementPaymentsSettlement> settlement) {
        Utils.checkNotNull(settlement, "settlement");
        this.settlement = settlement;
        return this;
    }

    /**
     * The API resource URL of the [customer](get-customer).
     */
    public GetSettlementPaymentsSettlementsLinks withCustomer(GetSettlementPaymentsCustomer customer) {
        Utils.checkNotNull(customer, "customer");
        this.customer = Optional.ofNullable(customer);
        return this;
    }


    /**
     * The API resource URL of the [customer](get-customer).
     */
    public GetSettlementPaymentsSettlementsLinks withCustomer(Optional<? extends GetSettlementPaymentsCustomer> customer) {
        Utils.checkNotNull(customer, "customer");
        this.customer = customer;
        return this;
    }

    /**
     * The API resource URL of the [mandate](get-mandate).
     */
    public GetSettlementPaymentsSettlementsLinks withMandate(GetSettlementPaymentsMandate mandate) {
        Utils.checkNotNull(mandate, "mandate");
        this.mandate = Optional.ofNullable(mandate);
        return this;
    }


    /**
     * The API resource URL of the [mandate](get-mandate).
     */
    public GetSettlementPaymentsSettlementsLinks withMandate(Optional<? extends GetSettlementPaymentsMandate> mandate) {
        Utils.checkNotNull(mandate, "mandate");
        this.mandate = mandate;
        return this;
    }

    /**
     * The API resource URL of the [subscription](get-subscription).
     */
    public GetSettlementPaymentsSettlementsLinks withSubscription(GetSettlementPaymentsSubscription subscription) {
        Utils.checkNotNull(subscription, "subscription");
        this.subscription = Optional.ofNullable(subscription);
        return this;
    }


    /**
     * The API resource URL of the [subscription](get-subscription).
     */
    public GetSettlementPaymentsSettlementsLinks withSubscription(Optional<? extends GetSettlementPaymentsSubscription> subscription) {
        Utils.checkNotNull(subscription, "subscription");
        this.subscription = subscription;
        return this;
    }

    /**
     * The API resource URL of the [order](get-order) this payment was created for. Not present if not created for an order.
     */
    public GetSettlementPaymentsSettlementsLinks withOrder(GetSettlementPaymentsOrder order) {
        Utils.checkNotNull(order, "order");
        this.order = Optional.ofNullable(order);
        return this;
    }


    /**
     * The API resource URL of the [order](get-order) this payment was created for. Not present if not created for an order.
     */
    public GetSettlementPaymentsSettlementsLinks withOrder(Optional<? extends GetSettlementPaymentsOrder> order) {
        Utils.checkNotNull(order, "order");
        this.order = order;
        return this;
    }

    /**
     * The API resource URL of the [terminal](get-terminal) this payment was created for. Only present for point-of-sale payments.
     */
    public GetSettlementPaymentsSettlementsLinks withTerminal(GetSettlementPaymentsTerminal terminal) {
        Utils.checkNotNull(terminal, "terminal");
        this.terminal = Optional.ofNullable(terminal);
        return this;
    }


    /**
     * The API resource URL of the [terminal](get-terminal) this payment was created for. Only present for point-of-sale payments.
     */
    public GetSettlementPaymentsSettlementsLinks withTerminal(Optional<? extends GetSettlementPaymentsTerminal> terminal) {
        Utils.checkNotNull(terminal, "terminal");
        this.terminal = terminal;
        return this;
    }

    /**
     * In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field.
     */
    public GetSettlementPaymentsSettlementsLinks withDocumentation(GetSettlementPaymentsSettlementsDocumentation documentation) {
        Utils.checkNotNull(documentation, "documentation");
        this.documentation = Optional.ofNullable(documentation);
        return this;
    }


    /**
     * In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field.
     */
    public GetSettlementPaymentsSettlementsLinks withDocumentation(Optional<? extends GetSettlementPaymentsSettlementsDocumentation> documentation) {
        Utils.checkNotNull(documentation, "documentation");
        this.documentation = documentation;
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
        GetSettlementPaymentsSettlementsLinks other = (GetSettlementPaymentsSettlementsLinks) o;
        return 
            Utils.enhancedDeepEquals(this.self, other.self) &&
            Utils.enhancedDeepEquals(this.checkout, other.checkout) &&
            Utils.enhancedDeepEquals(this.mobileAppCheckout, other.mobileAppCheckout) &&
            Utils.enhancedDeepEquals(this.changePaymentState, other.changePaymentState) &&
            Utils.enhancedDeepEquals(this.dashboard, other.dashboard) &&
            Utils.enhancedDeepEquals(this.refunds, other.refunds) &&
            Utils.enhancedDeepEquals(this.chargebacks, other.chargebacks) &&
            Utils.enhancedDeepEquals(this.captures, other.captures) &&
            Utils.enhancedDeepEquals(this.settlement, other.settlement) &&
            Utils.enhancedDeepEquals(this.customer, other.customer) &&
            Utils.enhancedDeepEquals(this.mandate, other.mandate) &&
            Utils.enhancedDeepEquals(this.subscription, other.subscription) &&
            Utils.enhancedDeepEquals(this.order, other.order) &&
            Utils.enhancedDeepEquals(this.terminal, other.terminal) &&
            Utils.enhancedDeepEquals(this.documentation, other.documentation);
    }
    
    @Override
    public int hashCode() {
        return Utils.enhancedHash(
            self, checkout, mobileAppCheckout,
            changePaymentState, dashboard, refunds,
            chargebacks, captures, settlement,
            customer, mandate, subscription,
            order, terminal, documentation);
    }
    
    @Override
    public String toString() {
        return Utils.toString(GetSettlementPaymentsSettlementsLinks.class,
                "self", self,
                "checkout", checkout,
                "mobileAppCheckout", mobileAppCheckout,
                "changePaymentState", changePaymentState,
                "dashboard", dashboard,
                "refunds", refunds,
                "chargebacks", chargebacks,
                "captures", captures,
                "settlement", settlement,
                "customer", customer,
                "mandate", mandate,
                "subscription", subscription,
                "order", order,
                "terminal", terminal,
                "documentation", documentation);
    }

    @SuppressWarnings("UnusedReturnValue")
    public final static class Builder {

        private GetSettlementPaymentsSettlementsSelf self;

        private Optional<? extends GetSettlementPaymentsCheckout> checkout = Optional.empty();

        private Optional<? extends GetSettlementPaymentsMobileAppCheckout> mobileAppCheckout = Optional.empty();

        private Optional<? extends GetSettlementPaymentsChangePaymentState> changePaymentState = Optional.empty();

        private GetSettlementPaymentsDashboard dashboard;

        private Optional<? extends GetSettlementPaymentsRefunds> refunds = Optional.empty();

        private Optional<? extends GetSettlementPaymentsChargebacks> chargebacks = Optional.empty();

        private Optional<? extends GetSettlementPaymentsCaptures> captures = Optional.empty();

        private Optional<? extends GetSettlementPaymentsSettlement> settlement = Optional.empty();

        private Optional<? extends GetSettlementPaymentsCustomer> customer = Optional.empty();

        private Optional<? extends GetSettlementPaymentsMandate> mandate = Optional.empty();

        private Optional<? extends GetSettlementPaymentsSubscription> subscription = Optional.empty();

        private Optional<? extends GetSettlementPaymentsOrder> order = Optional.empty();

        private Optional<? extends GetSettlementPaymentsTerminal> terminal = Optional.empty();

        private Optional<? extends GetSettlementPaymentsSettlementsDocumentation> documentation = Optional.empty();

        private Builder() {
          // force use of static builder() method
        }


        /**
         * In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field.
         */
        public Builder self(GetSettlementPaymentsSettlementsSelf self) {
            Utils.checkNotNull(self, "self");
            this.self = self;
            return this;
        }


        /**
         * The URL your customer should visit to make the payment. This is where you should redirect the customer to.
         */
        public Builder checkout(GetSettlementPaymentsCheckout checkout) {
            Utils.checkNotNull(checkout, "checkout");
            this.checkout = Optional.ofNullable(checkout);
            return this;
        }

        /**
         * The URL your customer should visit to make the payment. This is where you should redirect the customer to.
         */
        public Builder checkout(Optional<? extends GetSettlementPaymentsCheckout> checkout) {
            Utils.checkNotNull(checkout, "checkout");
            this.checkout = checkout;
            return this;
        }


        /**
         * The deeplink URL to the app of the payment method. Currently only available for `bancontact`.
         */
        public Builder mobileAppCheckout(GetSettlementPaymentsMobileAppCheckout mobileAppCheckout) {
            Utils.checkNotNull(mobileAppCheckout, "mobileAppCheckout");
            this.mobileAppCheckout = Optional.ofNullable(mobileAppCheckout);
            return this;
        }

        /**
         * The deeplink URL to the app of the payment method. Currently only available for `bancontact`.
         */
        public Builder mobileAppCheckout(Optional<? extends GetSettlementPaymentsMobileAppCheckout> mobileAppCheckout) {
            Utils.checkNotNull(mobileAppCheckout, "mobileAppCheckout");
            this.mobileAppCheckout = mobileAppCheckout;
            return this;
        }


        /**
         * For test mode payments in certain scenarios, a hosted interface is available to help you test different payment states.
         * 
         * <p>Firstly, for recurring test mode payments. Recurring payments do not have a checkout URL, because these payments are executed without any user interaction.
         * 
         * <p>Secondly, for paid test mode payments. The payment state screen will then allow you to create a refund or chargeback for the test payment.
         */
        public Builder changePaymentState(GetSettlementPaymentsChangePaymentState changePaymentState) {
            Utils.checkNotNull(changePaymentState, "changePaymentState");
            this.changePaymentState = Optional.ofNullable(changePaymentState);
            return this;
        }

        /**
         * For test mode payments in certain scenarios, a hosted interface is available to help you test different payment states.
         * 
         * <p>Firstly, for recurring test mode payments. Recurring payments do not have a checkout URL, because these payments are executed without any user interaction.
         * 
         * <p>Secondly, for paid test mode payments. The payment state screen will then allow you to create a refund or chargeback for the test payment.
         */
        public Builder changePaymentState(Optional<? extends GetSettlementPaymentsChangePaymentState> changePaymentState) {
            Utils.checkNotNull(changePaymentState, "changePaymentState");
            this.changePaymentState = changePaymentState;
            return this;
        }


        /**
         * Direct link to the payment in the Mollie Dashboard.
         */
        public Builder dashboard(GetSettlementPaymentsDashboard dashboard) {
            Utils.checkNotNull(dashboard, "dashboard");
            this.dashboard = dashboard;
            return this;
        }


        /**
         * The API resource URL of the [refunds](list-payment-refunds) that belong to this payment.
         */
        public Builder refunds(GetSettlementPaymentsRefunds refunds) {
            Utils.checkNotNull(refunds, "refunds");
            this.refunds = Optional.ofNullable(refunds);
            return this;
        }

        /**
         * The API resource URL of the [refunds](list-payment-refunds) that belong to this payment.
         */
        public Builder refunds(Optional<? extends GetSettlementPaymentsRefunds> refunds) {
            Utils.checkNotNull(refunds, "refunds");
            this.refunds = refunds;
            return this;
        }


        /**
         * The API resource URL of the [chargebacks](list-payment-chargebacks) that belong to this payment.
         */
        public Builder chargebacks(GetSettlementPaymentsChargebacks chargebacks) {
            Utils.checkNotNull(chargebacks, "chargebacks");
            this.chargebacks = Optional.ofNullable(chargebacks);
            return this;
        }

        /**
         * The API resource URL of the [chargebacks](list-payment-chargebacks) that belong to this payment.
         */
        public Builder chargebacks(Optional<? extends GetSettlementPaymentsChargebacks> chargebacks) {
            Utils.checkNotNull(chargebacks, "chargebacks");
            this.chargebacks = chargebacks;
            return this;
        }


        /**
         * The API resource URL of the [captures](list-payment-captures) that belong to this payment.
         */
        public Builder captures(GetSettlementPaymentsCaptures captures) {
            Utils.checkNotNull(captures, "captures");
            this.captures = Optional.ofNullable(captures);
            return this;
        }

        /**
         * The API resource URL of the [captures](list-payment-captures) that belong to this payment.
         */
        public Builder captures(Optional<? extends GetSettlementPaymentsCaptures> captures) {
            Utils.checkNotNull(captures, "captures");
            this.captures = captures;
            return this;
        }


        /**
         * The API resource URL of the [settlement](get-settlement) this payment has been settled with. Not present if not yet settled.
         */
        public Builder settlement(GetSettlementPaymentsSettlement settlement) {
            Utils.checkNotNull(settlement, "settlement");
            this.settlement = Optional.ofNullable(settlement);
            return this;
        }

        /**
         * The API resource URL of the [settlement](get-settlement) this payment has been settled with. Not present if not yet settled.
         */
        public Builder settlement(Optional<? extends GetSettlementPaymentsSettlement> settlement) {
            Utils.checkNotNull(settlement, "settlement");
            this.settlement = settlement;
            return this;
        }


        /**
         * The API resource URL of the [customer](get-customer).
         */
        public Builder customer(GetSettlementPaymentsCustomer customer) {
            Utils.checkNotNull(customer, "customer");
            this.customer = Optional.ofNullable(customer);
            return this;
        }

        /**
         * The API resource URL of the [customer](get-customer).
         */
        public Builder customer(Optional<? extends GetSettlementPaymentsCustomer> customer) {
            Utils.checkNotNull(customer, "customer");
            this.customer = customer;
            return this;
        }


        /**
         * The API resource URL of the [mandate](get-mandate).
         */
        public Builder mandate(GetSettlementPaymentsMandate mandate) {
            Utils.checkNotNull(mandate, "mandate");
            this.mandate = Optional.ofNullable(mandate);
            return this;
        }

        /**
         * The API resource URL of the [mandate](get-mandate).
         */
        public Builder mandate(Optional<? extends GetSettlementPaymentsMandate> mandate) {
            Utils.checkNotNull(mandate, "mandate");
            this.mandate = mandate;
            return this;
        }


        /**
         * The API resource URL of the [subscription](get-subscription).
         */
        public Builder subscription(GetSettlementPaymentsSubscription subscription) {
            Utils.checkNotNull(subscription, "subscription");
            this.subscription = Optional.ofNullable(subscription);
            return this;
        }

        /**
         * The API resource URL of the [subscription](get-subscription).
         */
        public Builder subscription(Optional<? extends GetSettlementPaymentsSubscription> subscription) {
            Utils.checkNotNull(subscription, "subscription");
            this.subscription = subscription;
            return this;
        }


        /**
         * The API resource URL of the [order](get-order) this payment was created for. Not present if not created for an order.
         */
        public Builder order(GetSettlementPaymentsOrder order) {
            Utils.checkNotNull(order, "order");
            this.order = Optional.ofNullable(order);
            return this;
        }

        /**
         * The API resource URL of the [order](get-order) this payment was created for. Not present if not created for an order.
         */
        public Builder order(Optional<? extends GetSettlementPaymentsOrder> order) {
            Utils.checkNotNull(order, "order");
            this.order = order;
            return this;
        }


        /**
         * The API resource URL of the [terminal](get-terminal) this payment was created for. Only present for point-of-sale payments.
         */
        public Builder terminal(GetSettlementPaymentsTerminal terminal) {
            Utils.checkNotNull(terminal, "terminal");
            this.terminal = Optional.ofNullable(terminal);
            return this;
        }

        /**
         * The API resource URL of the [terminal](get-terminal) this payment was created for. Only present for point-of-sale payments.
         */
        public Builder terminal(Optional<? extends GetSettlementPaymentsTerminal> terminal) {
            Utils.checkNotNull(terminal, "terminal");
            this.terminal = terminal;
            return this;
        }


        /**
         * In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field.
         */
        public Builder documentation(GetSettlementPaymentsSettlementsDocumentation documentation) {
            Utils.checkNotNull(documentation, "documentation");
            this.documentation = Optional.ofNullable(documentation);
            return this;
        }

        /**
         * In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field.
         */
        public Builder documentation(Optional<? extends GetSettlementPaymentsSettlementsDocumentation> documentation) {
            Utils.checkNotNull(documentation, "documentation");
            this.documentation = documentation;
            return this;
        }

        public GetSettlementPaymentsSettlementsLinks build() {

            return new GetSettlementPaymentsSettlementsLinks(
                self, checkout, mobileAppCheckout,
                changePaymentState, dashboard, refunds,
                chargebacks, captures, settlement,
                customer, mandate, subscription,
                order, terminal, documentation);
        }

    }
}
