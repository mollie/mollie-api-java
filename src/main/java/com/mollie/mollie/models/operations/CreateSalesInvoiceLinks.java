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
 * CreateSalesInvoiceLinks
 * 
 * <p>An object with several relevant URLs. Every URL object will contain an `href` and a `type` field.
 */
public class CreateSalesInvoiceLinks {
    /**
     * In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("self")
    private Optional<? extends CreateSalesInvoiceSelf> self;

    /**
     * The URL your customer should visit to make payment for the invoice. This is where you should redirect the customer to unless the `status` is set to `paid`.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("invoicePayment")
    private Optional<? extends InvoicePayment> invoicePayment;

    /**
     * The URL the invoice is available at, if generated.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("pdfLink")
    private JsonNullable<? extends PdfLink> pdfLink;

    /**
     * In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("documentation")
    private Optional<? extends CreateSalesInvoiceDocumentation> documentation;

    @JsonCreator
    public CreateSalesInvoiceLinks(
            @JsonProperty("self") Optional<? extends CreateSalesInvoiceSelf> self,
            @JsonProperty("invoicePayment") Optional<? extends InvoicePayment> invoicePayment,
            @JsonProperty("pdfLink") JsonNullable<? extends PdfLink> pdfLink,
            @JsonProperty("documentation") Optional<? extends CreateSalesInvoiceDocumentation> documentation) {
        Utils.checkNotNull(self, "self");
        Utils.checkNotNull(invoicePayment, "invoicePayment");
        Utils.checkNotNull(pdfLink, "pdfLink");
        Utils.checkNotNull(documentation, "documentation");
        this.self = self;
        this.invoicePayment = invoicePayment;
        this.pdfLink = pdfLink;
        this.documentation = documentation;
    }
    
    public CreateSalesInvoiceLinks() {
        this(Optional.empty(), Optional.empty(), JsonNullable.undefined(),
            Optional.empty());
    }

    /**
     * In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field.
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<CreateSalesInvoiceSelf> self() {
        return (Optional<CreateSalesInvoiceSelf>) self;
    }

    /**
     * The URL your customer should visit to make payment for the invoice. This is where you should redirect the customer to unless the `status` is set to `paid`.
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<InvoicePayment> invoicePayment() {
        return (Optional<InvoicePayment>) invoicePayment;
    }

    /**
     * The URL the invoice is available at, if generated.
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public JsonNullable<PdfLink> pdfLink() {
        return (JsonNullable<PdfLink>) pdfLink;
    }

    /**
     * In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field.
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<CreateSalesInvoiceDocumentation> documentation() {
        return (Optional<CreateSalesInvoiceDocumentation>) documentation;
    }

    public static Builder builder() {
        return new Builder();
    }


    /**
     * In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field.
     */
    public CreateSalesInvoiceLinks withSelf(CreateSalesInvoiceSelf self) {
        Utils.checkNotNull(self, "self");
        this.self = Optional.ofNullable(self);
        return this;
    }


    /**
     * In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field.
     */
    public CreateSalesInvoiceLinks withSelf(Optional<? extends CreateSalesInvoiceSelf> self) {
        Utils.checkNotNull(self, "self");
        this.self = self;
        return this;
    }

    /**
     * The URL your customer should visit to make payment for the invoice. This is where you should redirect the customer to unless the `status` is set to `paid`.
     */
    public CreateSalesInvoiceLinks withInvoicePayment(InvoicePayment invoicePayment) {
        Utils.checkNotNull(invoicePayment, "invoicePayment");
        this.invoicePayment = Optional.ofNullable(invoicePayment);
        return this;
    }


    /**
     * The URL your customer should visit to make payment for the invoice. This is where you should redirect the customer to unless the `status` is set to `paid`.
     */
    public CreateSalesInvoiceLinks withInvoicePayment(Optional<? extends InvoicePayment> invoicePayment) {
        Utils.checkNotNull(invoicePayment, "invoicePayment");
        this.invoicePayment = invoicePayment;
        return this;
    }

    /**
     * The URL the invoice is available at, if generated.
     */
    public CreateSalesInvoiceLinks withPdfLink(PdfLink pdfLink) {
        Utils.checkNotNull(pdfLink, "pdfLink");
        this.pdfLink = JsonNullable.of(pdfLink);
        return this;
    }

    /**
     * The URL the invoice is available at, if generated.
     */
    public CreateSalesInvoiceLinks withPdfLink(JsonNullable<? extends PdfLink> pdfLink) {
        Utils.checkNotNull(pdfLink, "pdfLink");
        this.pdfLink = pdfLink;
        return this;
    }

    /**
     * In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field.
     */
    public CreateSalesInvoiceLinks withDocumentation(CreateSalesInvoiceDocumentation documentation) {
        Utils.checkNotNull(documentation, "documentation");
        this.documentation = Optional.ofNullable(documentation);
        return this;
    }


    /**
     * In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field.
     */
    public CreateSalesInvoiceLinks withDocumentation(Optional<? extends CreateSalesInvoiceDocumentation> documentation) {
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
        CreateSalesInvoiceLinks other = (CreateSalesInvoiceLinks) o;
        return 
            Utils.enhancedDeepEquals(this.self, other.self) &&
            Utils.enhancedDeepEquals(this.invoicePayment, other.invoicePayment) &&
            Utils.enhancedDeepEquals(this.pdfLink, other.pdfLink) &&
            Utils.enhancedDeepEquals(this.documentation, other.documentation);
    }
    
    @Override
    public int hashCode() {
        return Utils.enhancedHash(
            self, invoicePayment, pdfLink,
            documentation);
    }
    
    @Override
    public String toString() {
        return Utils.toString(CreateSalesInvoiceLinks.class,
                "self", self,
                "invoicePayment", invoicePayment,
                "pdfLink", pdfLink,
                "documentation", documentation);
    }

    @SuppressWarnings("UnusedReturnValue")
    public final static class Builder {

        private Optional<? extends CreateSalesInvoiceSelf> self = Optional.empty();

        private Optional<? extends InvoicePayment> invoicePayment = Optional.empty();

        private JsonNullable<? extends PdfLink> pdfLink = JsonNullable.undefined();

        private Optional<? extends CreateSalesInvoiceDocumentation> documentation = Optional.empty();

        private Builder() {
          // force use of static builder() method
        }


        /**
         * In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field.
         */
        public Builder self(CreateSalesInvoiceSelf self) {
            Utils.checkNotNull(self, "self");
            this.self = Optional.ofNullable(self);
            return this;
        }

        /**
         * In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field.
         */
        public Builder self(Optional<? extends CreateSalesInvoiceSelf> self) {
            Utils.checkNotNull(self, "self");
            this.self = self;
            return this;
        }


        /**
         * The URL your customer should visit to make payment for the invoice. This is where you should redirect the customer to unless the `status` is set to `paid`.
         */
        public Builder invoicePayment(InvoicePayment invoicePayment) {
            Utils.checkNotNull(invoicePayment, "invoicePayment");
            this.invoicePayment = Optional.ofNullable(invoicePayment);
            return this;
        }

        /**
         * The URL your customer should visit to make payment for the invoice. This is where you should redirect the customer to unless the `status` is set to `paid`.
         */
        public Builder invoicePayment(Optional<? extends InvoicePayment> invoicePayment) {
            Utils.checkNotNull(invoicePayment, "invoicePayment");
            this.invoicePayment = invoicePayment;
            return this;
        }


        /**
         * The URL the invoice is available at, if generated.
         */
        public Builder pdfLink(PdfLink pdfLink) {
            Utils.checkNotNull(pdfLink, "pdfLink");
            this.pdfLink = JsonNullable.of(pdfLink);
            return this;
        }

        /**
         * The URL the invoice is available at, if generated.
         */
        public Builder pdfLink(JsonNullable<? extends PdfLink> pdfLink) {
            Utils.checkNotNull(pdfLink, "pdfLink");
            this.pdfLink = pdfLink;
            return this;
        }


        /**
         * In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field.
         */
        public Builder documentation(CreateSalesInvoiceDocumentation documentation) {
            Utils.checkNotNull(documentation, "documentation");
            this.documentation = Optional.ofNullable(documentation);
            return this;
        }

        /**
         * In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field.
         */
        public Builder documentation(Optional<? extends CreateSalesInvoiceDocumentation> documentation) {
            Utils.checkNotNull(documentation, "documentation");
            this.documentation = documentation;
            return this;
        }

        public CreateSalesInvoiceLinks build() {

            return new CreateSalesInvoiceLinks(
                self, invoicePayment, pdfLink,
                documentation);
        }

    }
}
