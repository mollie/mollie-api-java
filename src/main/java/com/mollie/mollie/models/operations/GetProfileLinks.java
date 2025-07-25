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
 * GetProfileLinks
 * 
 * <p>An object with several relevant URLs. Every URL object will contain an `href` and a `type` field.
 */
public class GetProfileLinks {
    /**
     * In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("self")
    private Optional<? extends GetProfileSelf> self;

    /**
     * Link to the profile in the Mollie dashboard.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("dashboard")
    private Optional<? extends GetProfileDashboard> dashboard;

    /**
     * The API resource URL of the chargebacks that belong to this profile.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("chargebacks")
    private Optional<? extends GetProfileChargebacks> chargebacks;

    /**
     * The API resource URL of the methods that are enabled for this profile.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("methods")
    private Optional<? extends GetProfileMethods> methods;

    /**
     * The API resource URL of the payments that belong to this profile.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("payments")
    private Optional<? extends GetProfilePayments> payments;

    /**
     * The API resource URL of the refunds that belong to this profile.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("refunds")
    private Optional<? extends GetProfileRefunds> refunds;

    /**
     * The hosted checkout preview URL. You need to be logged in to access this page.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("checkoutPreviewUrl")
    private Optional<? extends GetProfileCheckoutPreviewUrl> checkoutPreviewUrl;

    /**
     * In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("documentation")
    private Optional<? extends GetProfileDocumentation> documentation;

    @JsonCreator
    public GetProfileLinks(
            @JsonProperty("self") Optional<? extends GetProfileSelf> self,
            @JsonProperty("dashboard") Optional<? extends GetProfileDashboard> dashboard,
            @JsonProperty("chargebacks") Optional<? extends GetProfileChargebacks> chargebacks,
            @JsonProperty("methods") Optional<? extends GetProfileMethods> methods,
            @JsonProperty("payments") Optional<? extends GetProfilePayments> payments,
            @JsonProperty("refunds") Optional<? extends GetProfileRefunds> refunds,
            @JsonProperty("checkoutPreviewUrl") Optional<? extends GetProfileCheckoutPreviewUrl> checkoutPreviewUrl,
            @JsonProperty("documentation") Optional<? extends GetProfileDocumentation> documentation) {
        Utils.checkNotNull(self, "self");
        Utils.checkNotNull(dashboard, "dashboard");
        Utils.checkNotNull(chargebacks, "chargebacks");
        Utils.checkNotNull(methods, "methods");
        Utils.checkNotNull(payments, "payments");
        Utils.checkNotNull(refunds, "refunds");
        Utils.checkNotNull(checkoutPreviewUrl, "checkoutPreviewUrl");
        Utils.checkNotNull(documentation, "documentation");
        this.self = self;
        this.dashboard = dashboard;
        this.chargebacks = chargebacks;
        this.methods = methods;
        this.payments = payments;
        this.refunds = refunds;
        this.checkoutPreviewUrl = checkoutPreviewUrl;
        this.documentation = documentation;
    }
    
    public GetProfileLinks() {
        this(Optional.empty(), Optional.empty(), Optional.empty(),
            Optional.empty(), Optional.empty(), Optional.empty(),
            Optional.empty(), Optional.empty());
    }

    /**
     * In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field.
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<GetProfileSelf> self() {
        return (Optional<GetProfileSelf>) self;
    }

    /**
     * Link to the profile in the Mollie dashboard.
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<GetProfileDashboard> dashboard() {
        return (Optional<GetProfileDashboard>) dashboard;
    }

    /**
     * The API resource URL of the chargebacks that belong to this profile.
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<GetProfileChargebacks> chargebacks() {
        return (Optional<GetProfileChargebacks>) chargebacks;
    }

    /**
     * The API resource URL of the methods that are enabled for this profile.
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<GetProfileMethods> methods() {
        return (Optional<GetProfileMethods>) methods;
    }

    /**
     * The API resource URL of the payments that belong to this profile.
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<GetProfilePayments> payments() {
        return (Optional<GetProfilePayments>) payments;
    }

    /**
     * The API resource URL of the refunds that belong to this profile.
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<GetProfileRefunds> refunds() {
        return (Optional<GetProfileRefunds>) refunds;
    }

    /**
     * The hosted checkout preview URL. You need to be logged in to access this page.
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<GetProfileCheckoutPreviewUrl> checkoutPreviewUrl() {
        return (Optional<GetProfileCheckoutPreviewUrl>) checkoutPreviewUrl;
    }

    /**
     * In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field.
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<GetProfileDocumentation> documentation() {
        return (Optional<GetProfileDocumentation>) documentation;
    }

    public static Builder builder() {
        return new Builder();
    }


    /**
     * In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field.
     */
    public GetProfileLinks withSelf(GetProfileSelf self) {
        Utils.checkNotNull(self, "self");
        this.self = Optional.ofNullable(self);
        return this;
    }


    /**
     * In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field.
     */
    public GetProfileLinks withSelf(Optional<? extends GetProfileSelf> self) {
        Utils.checkNotNull(self, "self");
        this.self = self;
        return this;
    }

    /**
     * Link to the profile in the Mollie dashboard.
     */
    public GetProfileLinks withDashboard(GetProfileDashboard dashboard) {
        Utils.checkNotNull(dashboard, "dashboard");
        this.dashboard = Optional.ofNullable(dashboard);
        return this;
    }


    /**
     * Link to the profile in the Mollie dashboard.
     */
    public GetProfileLinks withDashboard(Optional<? extends GetProfileDashboard> dashboard) {
        Utils.checkNotNull(dashboard, "dashboard");
        this.dashboard = dashboard;
        return this;
    }

    /**
     * The API resource URL of the chargebacks that belong to this profile.
     */
    public GetProfileLinks withChargebacks(GetProfileChargebacks chargebacks) {
        Utils.checkNotNull(chargebacks, "chargebacks");
        this.chargebacks = Optional.ofNullable(chargebacks);
        return this;
    }


    /**
     * The API resource URL of the chargebacks that belong to this profile.
     */
    public GetProfileLinks withChargebacks(Optional<? extends GetProfileChargebacks> chargebacks) {
        Utils.checkNotNull(chargebacks, "chargebacks");
        this.chargebacks = chargebacks;
        return this;
    }

    /**
     * The API resource URL of the methods that are enabled for this profile.
     */
    public GetProfileLinks withMethods(GetProfileMethods methods) {
        Utils.checkNotNull(methods, "methods");
        this.methods = Optional.ofNullable(methods);
        return this;
    }


    /**
     * The API resource URL of the methods that are enabled for this profile.
     */
    public GetProfileLinks withMethods(Optional<? extends GetProfileMethods> methods) {
        Utils.checkNotNull(methods, "methods");
        this.methods = methods;
        return this;
    }

    /**
     * The API resource URL of the payments that belong to this profile.
     */
    public GetProfileLinks withPayments(GetProfilePayments payments) {
        Utils.checkNotNull(payments, "payments");
        this.payments = Optional.ofNullable(payments);
        return this;
    }


    /**
     * The API resource URL of the payments that belong to this profile.
     */
    public GetProfileLinks withPayments(Optional<? extends GetProfilePayments> payments) {
        Utils.checkNotNull(payments, "payments");
        this.payments = payments;
        return this;
    }

    /**
     * The API resource URL of the refunds that belong to this profile.
     */
    public GetProfileLinks withRefunds(GetProfileRefunds refunds) {
        Utils.checkNotNull(refunds, "refunds");
        this.refunds = Optional.ofNullable(refunds);
        return this;
    }


    /**
     * The API resource URL of the refunds that belong to this profile.
     */
    public GetProfileLinks withRefunds(Optional<? extends GetProfileRefunds> refunds) {
        Utils.checkNotNull(refunds, "refunds");
        this.refunds = refunds;
        return this;
    }

    /**
     * The hosted checkout preview URL. You need to be logged in to access this page.
     */
    public GetProfileLinks withCheckoutPreviewUrl(GetProfileCheckoutPreviewUrl checkoutPreviewUrl) {
        Utils.checkNotNull(checkoutPreviewUrl, "checkoutPreviewUrl");
        this.checkoutPreviewUrl = Optional.ofNullable(checkoutPreviewUrl);
        return this;
    }


    /**
     * The hosted checkout preview URL. You need to be logged in to access this page.
     */
    public GetProfileLinks withCheckoutPreviewUrl(Optional<? extends GetProfileCheckoutPreviewUrl> checkoutPreviewUrl) {
        Utils.checkNotNull(checkoutPreviewUrl, "checkoutPreviewUrl");
        this.checkoutPreviewUrl = checkoutPreviewUrl;
        return this;
    }

    /**
     * In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field.
     */
    public GetProfileLinks withDocumentation(GetProfileDocumentation documentation) {
        Utils.checkNotNull(documentation, "documentation");
        this.documentation = Optional.ofNullable(documentation);
        return this;
    }


    /**
     * In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field.
     */
    public GetProfileLinks withDocumentation(Optional<? extends GetProfileDocumentation> documentation) {
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
        GetProfileLinks other = (GetProfileLinks) o;
        return 
            Utils.enhancedDeepEquals(this.self, other.self) &&
            Utils.enhancedDeepEquals(this.dashboard, other.dashboard) &&
            Utils.enhancedDeepEquals(this.chargebacks, other.chargebacks) &&
            Utils.enhancedDeepEquals(this.methods, other.methods) &&
            Utils.enhancedDeepEquals(this.payments, other.payments) &&
            Utils.enhancedDeepEquals(this.refunds, other.refunds) &&
            Utils.enhancedDeepEquals(this.checkoutPreviewUrl, other.checkoutPreviewUrl) &&
            Utils.enhancedDeepEquals(this.documentation, other.documentation);
    }
    
    @Override
    public int hashCode() {
        return Utils.enhancedHash(
            self, dashboard, chargebacks,
            methods, payments, refunds,
            checkoutPreviewUrl, documentation);
    }
    
    @Override
    public String toString() {
        return Utils.toString(GetProfileLinks.class,
                "self", self,
                "dashboard", dashboard,
                "chargebacks", chargebacks,
                "methods", methods,
                "payments", payments,
                "refunds", refunds,
                "checkoutPreviewUrl", checkoutPreviewUrl,
                "documentation", documentation);
    }

    @SuppressWarnings("UnusedReturnValue")
    public final static class Builder {

        private Optional<? extends GetProfileSelf> self = Optional.empty();

        private Optional<? extends GetProfileDashboard> dashboard = Optional.empty();

        private Optional<? extends GetProfileChargebacks> chargebacks = Optional.empty();

        private Optional<? extends GetProfileMethods> methods = Optional.empty();

        private Optional<? extends GetProfilePayments> payments = Optional.empty();

        private Optional<? extends GetProfileRefunds> refunds = Optional.empty();

        private Optional<? extends GetProfileCheckoutPreviewUrl> checkoutPreviewUrl = Optional.empty();

        private Optional<? extends GetProfileDocumentation> documentation = Optional.empty();

        private Builder() {
          // force use of static builder() method
        }


        /**
         * In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field.
         */
        public Builder self(GetProfileSelf self) {
            Utils.checkNotNull(self, "self");
            this.self = Optional.ofNullable(self);
            return this;
        }

        /**
         * In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field.
         */
        public Builder self(Optional<? extends GetProfileSelf> self) {
            Utils.checkNotNull(self, "self");
            this.self = self;
            return this;
        }


        /**
         * Link to the profile in the Mollie dashboard.
         */
        public Builder dashboard(GetProfileDashboard dashboard) {
            Utils.checkNotNull(dashboard, "dashboard");
            this.dashboard = Optional.ofNullable(dashboard);
            return this;
        }

        /**
         * Link to the profile in the Mollie dashboard.
         */
        public Builder dashboard(Optional<? extends GetProfileDashboard> dashboard) {
            Utils.checkNotNull(dashboard, "dashboard");
            this.dashboard = dashboard;
            return this;
        }


        /**
         * The API resource URL of the chargebacks that belong to this profile.
         */
        public Builder chargebacks(GetProfileChargebacks chargebacks) {
            Utils.checkNotNull(chargebacks, "chargebacks");
            this.chargebacks = Optional.ofNullable(chargebacks);
            return this;
        }

        /**
         * The API resource URL of the chargebacks that belong to this profile.
         */
        public Builder chargebacks(Optional<? extends GetProfileChargebacks> chargebacks) {
            Utils.checkNotNull(chargebacks, "chargebacks");
            this.chargebacks = chargebacks;
            return this;
        }


        /**
         * The API resource URL of the methods that are enabled for this profile.
         */
        public Builder methods(GetProfileMethods methods) {
            Utils.checkNotNull(methods, "methods");
            this.methods = Optional.ofNullable(methods);
            return this;
        }

        /**
         * The API resource URL of the methods that are enabled for this profile.
         */
        public Builder methods(Optional<? extends GetProfileMethods> methods) {
            Utils.checkNotNull(methods, "methods");
            this.methods = methods;
            return this;
        }


        /**
         * The API resource URL of the payments that belong to this profile.
         */
        public Builder payments(GetProfilePayments payments) {
            Utils.checkNotNull(payments, "payments");
            this.payments = Optional.ofNullable(payments);
            return this;
        }

        /**
         * The API resource URL of the payments that belong to this profile.
         */
        public Builder payments(Optional<? extends GetProfilePayments> payments) {
            Utils.checkNotNull(payments, "payments");
            this.payments = payments;
            return this;
        }


        /**
         * The API resource URL of the refunds that belong to this profile.
         */
        public Builder refunds(GetProfileRefunds refunds) {
            Utils.checkNotNull(refunds, "refunds");
            this.refunds = Optional.ofNullable(refunds);
            return this;
        }

        /**
         * The API resource URL of the refunds that belong to this profile.
         */
        public Builder refunds(Optional<? extends GetProfileRefunds> refunds) {
            Utils.checkNotNull(refunds, "refunds");
            this.refunds = refunds;
            return this;
        }


        /**
         * The hosted checkout preview URL. You need to be logged in to access this page.
         */
        public Builder checkoutPreviewUrl(GetProfileCheckoutPreviewUrl checkoutPreviewUrl) {
            Utils.checkNotNull(checkoutPreviewUrl, "checkoutPreviewUrl");
            this.checkoutPreviewUrl = Optional.ofNullable(checkoutPreviewUrl);
            return this;
        }

        /**
         * The hosted checkout preview URL. You need to be logged in to access this page.
         */
        public Builder checkoutPreviewUrl(Optional<? extends GetProfileCheckoutPreviewUrl> checkoutPreviewUrl) {
            Utils.checkNotNull(checkoutPreviewUrl, "checkoutPreviewUrl");
            this.checkoutPreviewUrl = checkoutPreviewUrl;
            return this;
        }


        /**
         * In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field.
         */
        public Builder documentation(GetProfileDocumentation documentation) {
            Utils.checkNotNull(documentation, "documentation");
            this.documentation = Optional.ofNullable(documentation);
            return this;
        }

        /**
         * In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field.
         */
        public Builder documentation(Optional<? extends GetProfileDocumentation> documentation) {
            Utils.checkNotNull(documentation, "documentation");
            this.documentation = documentation;
            return this;
        }

        public GetProfileLinks build() {

            return new GetProfileLinks(
                self, dashboard, chargebacks,
                methods, payments, refunds,
                checkoutPreviewUrl, documentation);
        }

    }
}
