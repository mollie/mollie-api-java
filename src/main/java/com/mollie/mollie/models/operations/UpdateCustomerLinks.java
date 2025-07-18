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
import org.openapitools.jackson.nullable.JsonNullable;

/**
 * UpdateCustomerLinks
 * 
 * <p>An object with several relevant URLs. Every URL object will contain an `href` and a `type` field.
 */
public class UpdateCustomerLinks {
    /**
     * In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("self")
    private Optional<? extends UpdateCustomerSelf> self;

    /**
     * In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("dashboard")
    private Optional<? extends UpdateCustomerDashboard> dashboard;

    /**
     * The API resource URL of the [payments](list-payments) linked to this customer. Omitted if no such payments exist (yet).
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("payments")
    private JsonNullable<? extends UpdateCustomerPayments> payments;

    /**
     * The API resource URL of the [mandates](list-mandates) linked to this customer. Omitted if no such mandates exist (yet).
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("mandates")
    private JsonNullable<? extends UpdateCustomerMandates> mandates;

    /**
     * The API resource URL of the [subscriptions](list-subscriptions) linked to this customer. Omitted if no such subscriptions exist (yet).
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("subscriptions")
    private JsonNullable<? extends UpdateCustomerSubscriptions> subscriptions;

    /**
     * In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("documentation")
    private Optional<? extends UpdateCustomerDocumentation> documentation;

    @JsonCreator
    public UpdateCustomerLinks(
            @JsonProperty("self") Optional<? extends UpdateCustomerSelf> self,
            @JsonProperty("dashboard") Optional<? extends UpdateCustomerDashboard> dashboard,
            @JsonProperty("payments") JsonNullable<? extends UpdateCustomerPayments> payments,
            @JsonProperty("mandates") JsonNullable<? extends UpdateCustomerMandates> mandates,
            @JsonProperty("subscriptions") JsonNullable<? extends UpdateCustomerSubscriptions> subscriptions,
            @JsonProperty("documentation") Optional<? extends UpdateCustomerDocumentation> documentation) {
        Utils.checkNotNull(self, "self");
        Utils.checkNotNull(dashboard, "dashboard");
        Utils.checkNotNull(payments, "payments");
        Utils.checkNotNull(mandates, "mandates");
        Utils.checkNotNull(subscriptions, "subscriptions");
        Utils.checkNotNull(documentation, "documentation");
        this.self = self;
        this.dashboard = dashboard;
        this.payments = payments;
        this.mandates = mandates;
        this.subscriptions = subscriptions;
        this.documentation = documentation;
    }
    
    public UpdateCustomerLinks() {
        this(Optional.empty(), Optional.empty(), JsonNullable.undefined(),
            JsonNullable.undefined(), JsonNullable.undefined(), Optional.empty());
    }

    /**
     * In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field.
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<UpdateCustomerSelf> self() {
        return (Optional<UpdateCustomerSelf>) self;
    }

    /**
     * In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field.
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<UpdateCustomerDashboard> dashboard() {
        return (Optional<UpdateCustomerDashboard>) dashboard;
    }

    /**
     * The API resource URL of the [payments](list-payments) linked to this customer. Omitted if no such payments exist (yet).
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public JsonNullable<UpdateCustomerPayments> payments() {
        return (JsonNullable<UpdateCustomerPayments>) payments;
    }

    /**
     * The API resource URL of the [mandates](list-mandates) linked to this customer. Omitted if no such mandates exist (yet).
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public JsonNullable<UpdateCustomerMandates> mandates() {
        return (JsonNullable<UpdateCustomerMandates>) mandates;
    }

    /**
     * The API resource URL of the [subscriptions](list-subscriptions) linked to this customer. Omitted if no such subscriptions exist (yet).
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public JsonNullable<UpdateCustomerSubscriptions> subscriptions() {
        return (JsonNullable<UpdateCustomerSubscriptions>) subscriptions;
    }

    /**
     * In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field.
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<UpdateCustomerDocumentation> documentation() {
        return (Optional<UpdateCustomerDocumentation>) documentation;
    }

    public static Builder builder() {
        return new Builder();
    }


    /**
     * In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field.
     */
    public UpdateCustomerLinks withSelf(UpdateCustomerSelf self) {
        Utils.checkNotNull(self, "self");
        this.self = Optional.ofNullable(self);
        return this;
    }


    /**
     * In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field.
     */
    public UpdateCustomerLinks withSelf(Optional<? extends UpdateCustomerSelf> self) {
        Utils.checkNotNull(self, "self");
        this.self = self;
        return this;
    }

    /**
     * In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field.
     */
    public UpdateCustomerLinks withDashboard(UpdateCustomerDashboard dashboard) {
        Utils.checkNotNull(dashboard, "dashboard");
        this.dashboard = Optional.ofNullable(dashboard);
        return this;
    }


    /**
     * In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field.
     */
    public UpdateCustomerLinks withDashboard(Optional<? extends UpdateCustomerDashboard> dashboard) {
        Utils.checkNotNull(dashboard, "dashboard");
        this.dashboard = dashboard;
        return this;
    }

    /**
     * The API resource URL of the [payments](list-payments) linked to this customer. Omitted if no such payments exist (yet).
     */
    public UpdateCustomerLinks withPayments(UpdateCustomerPayments payments) {
        Utils.checkNotNull(payments, "payments");
        this.payments = JsonNullable.of(payments);
        return this;
    }

    /**
     * The API resource URL of the [payments](list-payments) linked to this customer. Omitted if no such payments exist (yet).
     */
    public UpdateCustomerLinks withPayments(JsonNullable<? extends UpdateCustomerPayments> payments) {
        Utils.checkNotNull(payments, "payments");
        this.payments = payments;
        return this;
    }

    /**
     * The API resource URL of the [mandates](list-mandates) linked to this customer. Omitted if no such mandates exist (yet).
     */
    public UpdateCustomerLinks withMandates(UpdateCustomerMandates mandates) {
        Utils.checkNotNull(mandates, "mandates");
        this.mandates = JsonNullable.of(mandates);
        return this;
    }

    /**
     * The API resource URL of the [mandates](list-mandates) linked to this customer. Omitted if no such mandates exist (yet).
     */
    public UpdateCustomerLinks withMandates(JsonNullable<? extends UpdateCustomerMandates> mandates) {
        Utils.checkNotNull(mandates, "mandates");
        this.mandates = mandates;
        return this;
    }

    /**
     * The API resource URL of the [subscriptions](list-subscriptions) linked to this customer. Omitted if no such subscriptions exist (yet).
     */
    public UpdateCustomerLinks withSubscriptions(UpdateCustomerSubscriptions subscriptions) {
        Utils.checkNotNull(subscriptions, "subscriptions");
        this.subscriptions = JsonNullable.of(subscriptions);
        return this;
    }

    /**
     * The API resource URL of the [subscriptions](list-subscriptions) linked to this customer. Omitted if no such subscriptions exist (yet).
     */
    public UpdateCustomerLinks withSubscriptions(JsonNullable<? extends UpdateCustomerSubscriptions> subscriptions) {
        Utils.checkNotNull(subscriptions, "subscriptions");
        this.subscriptions = subscriptions;
        return this;
    }

    /**
     * In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field.
     */
    public UpdateCustomerLinks withDocumentation(UpdateCustomerDocumentation documentation) {
        Utils.checkNotNull(documentation, "documentation");
        this.documentation = Optional.ofNullable(documentation);
        return this;
    }


    /**
     * In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field.
     */
    public UpdateCustomerLinks withDocumentation(Optional<? extends UpdateCustomerDocumentation> documentation) {
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
        UpdateCustomerLinks other = (UpdateCustomerLinks) o;
        return 
            Utils.enhancedDeepEquals(this.self, other.self) &&
            Utils.enhancedDeepEquals(this.dashboard, other.dashboard) &&
            Utils.enhancedDeepEquals(this.payments, other.payments) &&
            Utils.enhancedDeepEquals(this.mandates, other.mandates) &&
            Utils.enhancedDeepEquals(this.subscriptions, other.subscriptions) &&
            Utils.enhancedDeepEquals(this.documentation, other.documentation);
    }
    
    @Override
    public int hashCode() {
        return Utils.enhancedHash(
            self, dashboard, payments,
            mandates, subscriptions, documentation);
    }
    
    @Override
    public String toString() {
        return Utils.toString(UpdateCustomerLinks.class,
                "self", self,
                "dashboard", dashboard,
                "payments", payments,
                "mandates", mandates,
                "subscriptions", subscriptions,
                "documentation", documentation);
    }

    @SuppressWarnings("UnusedReturnValue")
    public final static class Builder {

        private Optional<? extends UpdateCustomerSelf> self = Optional.empty();

        private Optional<? extends UpdateCustomerDashboard> dashboard = Optional.empty();

        private JsonNullable<? extends UpdateCustomerPayments> payments = JsonNullable.undefined();

        private JsonNullable<? extends UpdateCustomerMandates> mandates = JsonNullable.undefined();

        private JsonNullable<? extends UpdateCustomerSubscriptions> subscriptions = JsonNullable.undefined();

        private Optional<? extends UpdateCustomerDocumentation> documentation = Optional.empty();

        private Builder() {
          // force use of static builder() method
        }


        /**
         * In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field.
         */
        public Builder self(UpdateCustomerSelf self) {
            Utils.checkNotNull(self, "self");
            this.self = Optional.ofNullable(self);
            return this;
        }

        /**
         * In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field.
         */
        public Builder self(Optional<? extends UpdateCustomerSelf> self) {
            Utils.checkNotNull(self, "self");
            this.self = self;
            return this;
        }


        /**
         * In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field.
         */
        public Builder dashboard(UpdateCustomerDashboard dashboard) {
            Utils.checkNotNull(dashboard, "dashboard");
            this.dashboard = Optional.ofNullable(dashboard);
            return this;
        }

        /**
         * In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field.
         */
        public Builder dashboard(Optional<? extends UpdateCustomerDashboard> dashboard) {
            Utils.checkNotNull(dashboard, "dashboard");
            this.dashboard = dashboard;
            return this;
        }


        /**
         * The API resource URL of the [payments](list-payments) linked to this customer. Omitted if no such payments exist (yet).
         */
        public Builder payments(UpdateCustomerPayments payments) {
            Utils.checkNotNull(payments, "payments");
            this.payments = JsonNullable.of(payments);
            return this;
        }

        /**
         * The API resource URL of the [payments](list-payments) linked to this customer. Omitted if no such payments exist (yet).
         */
        public Builder payments(JsonNullable<? extends UpdateCustomerPayments> payments) {
            Utils.checkNotNull(payments, "payments");
            this.payments = payments;
            return this;
        }


        /**
         * The API resource URL of the [mandates](list-mandates) linked to this customer. Omitted if no such mandates exist (yet).
         */
        public Builder mandates(UpdateCustomerMandates mandates) {
            Utils.checkNotNull(mandates, "mandates");
            this.mandates = JsonNullable.of(mandates);
            return this;
        }

        /**
         * The API resource URL of the [mandates](list-mandates) linked to this customer. Omitted if no such mandates exist (yet).
         */
        public Builder mandates(JsonNullable<? extends UpdateCustomerMandates> mandates) {
            Utils.checkNotNull(mandates, "mandates");
            this.mandates = mandates;
            return this;
        }


        /**
         * The API resource URL of the [subscriptions](list-subscriptions) linked to this customer. Omitted if no such subscriptions exist (yet).
         */
        public Builder subscriptions(UpdateCustomerSubscriptions subscriptions) {
            Utils.checkNotNull(subscriptions, "subscriptions");
            this.subscriptions = JsonNullable.of(subscriptions);
            return this;
        }

        /**
         * The API resource URL of the [subscriptions](list-subscriptions) linked to this customer. Omitted if no such subscriptions exist (yet).
         */
        public Builder subscriptions(JsonNullable<? extends UpdateCustomerSubscriptions> subscriptions) {
            Utils.checkNotNull(subscriptions, "subscriptions");
            this.subscriptions = subscriptions;
            return this;
        }


        /**
         * In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field.
         */
        public Builder documentation(UpdateCustomerDocumentation documentation) {
            Utils.checkNotNull(documentation, "documentation");
            this.documentation = Optional.ofNullable(documentation);
            return this;
        }

        /**
         * In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field.
         */
        public Builder documentation(Optional<? extends UpdateCustomerDocumentation> documentation) {
            Utils.checkNotNull(documentation, "documentation");
            this.documentation = documentation;
            return this;
        }

        public UpdateCustomerLinks build() {

            return new UpdateCustomerLinks(
                self, dashboard, payments,
                mandates, subscriptions, documentation);
        }

    }
}
