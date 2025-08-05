# mollie-api-java

Developer-friendly & type-safe Java SDK specifically catered to leverage *mollie-api-java* API.

<div align="left">
    <a href="https://www.speakeasy.com/?utm_source=openapi&utm_campaign=java"><img src="https://custom-icon-badges.demolab.com/badge/-Built%20By%20Speakeasy-212015?style=for-the-badge&logoColor=FBE331&logo=speakeasy&labelColor=545454" /></a>
    <a href="https://mit-license.org/">
        <img src="https://img.shields.io/badge/License-MIT-blue.svg" style="width: 100px; height: 28px;" />
    </a>
</div>

## Migration
This documentation is for the new Mollie's SDK. You can find more details on how to migrate from the old version to the new one [here](/MIGRATION.md).

<!-- Start Summary [summary] -->
## Summary


<!-- End Summary [summary] -->

<!-- Start Table of Contents [toc] -->
## Table of Contents
<!-- $toc-max-depth=2 -->
* [mollie-api-java](#mollie-api-java)
  * [Migration](#migration)
  * [SDK Installation](#sdk-installation)
  * [SDK Example Usage](#sdk-example-usage)
  * [Authentication](#authentication)
  * [Available Resources and Operations](#available-resources-and-operations)
  * [Retries](#retries)
  * [Error Handling](#error-handling)
  * [Server Selection](#server-selection)
  * [Debugging](#debugging)
* [Development](#development)
  * [Maturity](#maturity)
  * [Contributions](#contributions)

<!-- End Table of Contents [toc] -->

<!-- Start SDK Installation [installation] -->
## SDK Installation

### Getting started

JDK 11 or later is required.

The samples below show how a published SDK artifact is used:

Gradle:
```groovy
implementation 'com.mollie:mollie:0.14.3'
```

Maven:
```xml
<dependency>
    <groupId>com.mollie</groupId>
    <artifactId>mollie</artifactId>
    <version>0.14.3</version>
</dependency>
```

### How to build
After cloning the git repository to your file system you can build the SDK artifact from source to the `build` directory by running `./gradlew build` on *nix systems or `gradlew.bat` on Windows systems.

If you wish to build from source and publish the SDK artifact to your local Maven repository (on your filesystem) then use the following command (after cloning the git repo locally):

On *nix:
```bash
./gradlew publishToMavenLocal -Pskip.signing
```
On Windows:
```bash
gradlew.bat publishToMavenLocal -Pskip.signing
```
<!-- End SDK Installation [installation] -->

<!-- Start SDK Example Usage [usage] -->
## SDK Example Usage

### Example

```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.CreatePaymentPaymentsResponseBody;
import com.mollie.mollie.models.errors.CreatePaymentResponseBody;
import com.mollie.mollie.models.operations.*;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws CreatePaymentResponseBody, CreatePaymentPaymentsResponseBody, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        CreatePaymentResponse res = sdk.payments().create()
                .include(Include.DETAILS_QR_CODE)
                .requestBody(CreatePaymentRequestBody.builder()
                    .description("Chess Board")
                    .amount(Amount.builder()
                        .currency("EUR")
                        .value("10.00")
                        .build())
                    .redirectUrl("https://example.org/redirect")
                    .cancelUrl("https://example.org/cancel")
                    .webhookUrl("https://example.org/webhooks")
                    .lines(List.of(
                        Lines.builder()
                            .description("LEGO 4440 Forest Police Station")
                            .quantity(1L)
                            .unitPrice(UnitPrice.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .totalAmount(TotalAmount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .quantityUnit("pcs")
                            .discountAmount(DiscountAmount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .vatRate("21.00")
                            .vatAmount(VatAmount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .sku("9780241661628")
                            .categories(List.of(
                                Categories.MEAL,
                                Categories.ECO))
                            .imageUrl("https://...")
                            .productUrl("https://...")
                            .recurring(Recurring.builder()
                                .interval(Interval.DOT_DOT_DOT_DAYS)
                                .description("Gym subscription")
                                .amount(CreatePaymentAmount.builder()
                                    .currency("EUR")
                                    .value("10.00")
                                    .build())
                                .times(1L)
                                .startDate("2024-12-12")
                                .build())
                            .build(),
                        Lines.builder()
                            .description("LEGO 4440 Forest Police Station")
                            .quantity(1L)
                            .unitPrice(UnitPrice.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .totalAmount(TotalAmount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .quantityUnit("pcs")
                            .discountAmount(DiscountAmount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .vatRate("21.00")
                            .vatAmount(VatAmount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .sku("9780241661628")
                            .categories(List.of(
                                Categories.MEAL,
                                Categories.ECO))
                            .imageUrl("https://...")
                            .productUrl("https://...")
                            .recurring(Recurring.builder()
                                .interval(Interval.DOT_DOT_DOT_WEEKS)
                                .description("Gym subscription")
                                .amount(CreatePaymentAmount.builder()
                                    .currency("EUR")
                                    .value("10.00")
                                    .build())
                                .times(1L)
                                .startDate("2024-12-12")
                                .build())
                            .build(),
                        Lines.builder()
                            .description("LEGO 4440 Forest Police Station")
                            .quantity(1L)
                            .unitPrice(UnitPrice.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .totalAmount(TotalAmount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .quantityUnit("pcs")
                            .discountAmount(DiscountAmount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .vatRate("21.00")
                            .vatAmount(VatAmount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .sku("9780241661628")
                            .categories(List.of(
                                Categories.MEAL,
                                Categories.ECO))
                            .imageUrl("https://...")
                            .productUrl("https://...")
                            .recurring(Recurring.builder()
                                .interval(Interval.DOT_DOT_DOT_DAYS)
                                .description("Gym subscription")
                                .amount(CreatePaymentAmount.builder()
                                    .currency("EUR")
                                    .value("10.00")
                                    .build())
                                .times(1L)
                                .startDate("2024-12-12")
                                .build())
                            .build()))
                    .billingAddress(BillingAddress.builder()
                        .title("Mr.")
                        .givenName("Piet")
                        .familyName("Mondriaan")
                        .organizationName("Mollie B.V.")
                        .streetAndNumber("Keizersgracht 126")
                        .streetAdditional("Apt. 1")
                        .postalCode("1234AB")
                        .email("piet@example.org")
                        .phone("31208202070")
                        .city("Amsterdam")
                        .region("Noord-Holland")
                        .country("NL")
                        .build())
                    .shippingAddress(ShippingAddress.builder()
                        .title("Mr.")
                        .givenName("Piet")
                        .familyName("Mondriaan")
                        .organizationName("Mollie B.V.")
                        .streetAndNumber("Keizersgracht 126")
                        .streetAdditional("Apt. 1")
                        .postalCode("1234AB")
                        .email("piet@example.org")
                        .phone("31208202070")
                        .city("Amsterdam")
                        .region("Noord-Holland")
                        .country("NL")
                        .build())
                    .locale(Locale.EN_US)
                    .method(Method.IDEAL)
                    .issuer("ideal_INGBNL2A")
                    .restrictPaymentMethodsToCountry("NL")
                    .captureMode(CaptureMode.MANUAL)
                    .captureDelay("8 hours")
                    .applicationFee(ApplicationFee.builder()
                        .amount(CreatePaymentPaymentsAmount.builder()
                            .currency("EUR")
                            .value("10.00")
                            .build())
                        .description("10")
                        .build())
                    .routing(List.of(
                        Routing.builder()
                            .amount(CreatePaymentPaymentsRequestAmount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .destination(Destination.builder()
                                .type(CreatePaymentType.ORGANIZATION)
                                .organizationId("org_1234567")
                                .build())
                            .links(Links.builder()
                                .self(Self.builder()
                                    .href("https://...")
                                    .type("application/hal+json")
                                    .build())
                                .payment(Payment.builder()
                                    .href("https://...")
                                    .type("application/hal+json")
                                    .build())
                                .build())
                            .releaseDate("2024-12-12")
                            .build(),
                        Routing.builder()
                            .amount(CreatePaymentPaymentsRequestAmount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .destination(Destination.builder()
                                .type(CreatePaymentType.ORGANIZATION)
                                .organizationId("org_1234567")
                                .build())
                            .links(Links.builder()
                                .self(Self.builder()
                                    .href("https://...")
                                    .type("application/hal+json")
                                    .build())
                                .payment(Payment.builder()
                                    .href("https://...")
                                    .type("application/hal+json")
                                    .build())
                                .build())
                            .releaseDate("2024-12-12")
                            .build()))
                    .mandateId("mdt_5B8cwPMGnU")
                    .customerId("cst_5B8cwPMGnU")
                    .profileId("pfl_5B8cwPMGnU")
                    .dueDate("2025-01-01")
                    .testmode(false)
                    .build())
                .call();

        if (res.object().isPresent()) {
            // handle response
        }
    }
}
```
<!-- End SDK Example Usage [usage] -->

<!-- Start Authentication [security] -->
## Authentication

### Per-Client Security Schemes

This SDK supports the following security schemes globally:

| Name     | Type   | Scheme       |
| -------- | ------ | ------------ |
| `apiKey` | http   | HTTP Bearer  |
| `oAuth`  | oauth2 | OAuth2 token |

You can set the security parameters through the `security` builder method when initializing the SDK client instance. The selected scheme will be used by default to authenticate with the API for all operations that support it. For example:
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.CreatePaymentPaymentsResponseBody;
import com.mollie.mollie.models.errors.CreatePaymentResponseBody;
import com.mollie.mollie.models.operations.*;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws CreatePaymentResponseBody, CreatePaymentPaymentsResponseBody, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        CreatePaymentResponse res = sdk.payments().create()
                .include(Include.DETAILS_QR_CODE)
                .requestBody(CreatePaymentRequestBody.builder()
                    .description("Chess Board")
                    .amount(Amount.builder()
                        .currency("EUR")
                        .value("10.00")
                        .build())
                    .redirectUrl("https://example.org/redirect")
                    .cancelUrl("https://example.org/cancel")
                    .webhookUrl("https://example.org/webhooks")
                    .lines(List.of(
                        Lines.builder()
                            .description("LEGO 4440 Forest Police Station")
                            .quantity(1L)
                            .unitPrice(UnitPrice.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .totalAmount(TotalAmount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .quantityUnit("pcs")
                            .discountAmount(DiscountAmount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .vatRate("21.00")
                            .vatAmount(VatAmount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .sku("9780241661628")
                            .categories(List.of(
                                Categories.MEAL,
                                Categories.ECO))
                            .imageUrl("https://...")
                            .productUrl("https://...")
                            .recurring(Recurring.builder()
                                .interval(Interval.DOT_DOT_DOT_DAYS)
                                .description("Gym subscription")
                                .amount(CreatePaymentAmount.builder()
                                    .currency("EUR")
                                    .value("10.00")
                                    .build())
                                .times(1L)
                                .startDate("2024-12-12")
                                .build())
                            .build(),
                        Lines.builder()
                            .description("LEGO 4440 Forest Police Station")
                            .quantity(1L)
                            .unitPrice(UnitPrice.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .totalAmount(TotalAmount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .quantityUnit("pcs")
                            .discountAmount(DiscountAmount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .vatRate("21.00")
                            .vatAmount(VatAmount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .sku("9780241661628")
                            .categories(List.of(
                                Categories.MEAL,
                                Categories.ECO))
                            .imageUrl("https://...")
                            .productUrl("https://...")
                            .recurring(Recurring.builder()
                                .interval(Interval.DOT_DOT_DOT_WEEKS)
                                .description("Gym subscription")
                                .amount(CreatePaymentAmount.builder()
                                    .currency("EUR")
                                    .value("10.00")
                                    .build())
                                .times(1L)
                                .startDate("2024-12-12")
                                .build())
                            .build(),
                        Lines.builder()
                            .description("LEGO 4440 Forest Police Station")
                            .quantity(1L)
                            .unitPrice(UnitPrice.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .totalAmount(TotalAmount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .quantityUnit("pcs")
                            .discountAmount(DiscountAmount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .vatRate("21.00")
                            .vatAmount(VatAmount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .sku("9780241661628")
                            .categories(List.of(
                                Categories.MEAL,
                                Categories.ECO))
                            .imageUrl("https://...")
                            .productUrl("https://...")
                            .recurring(Recurring.builder()
                                .interval(Interval.DOT_DOT_DOT_DAYS)
                                .description("Gym subscription")
                                .amount(CreatePaymentAmount.builder()
                                    .currency("EUR")
                                    .value("10.00")
                                    .build())
                                .times(1L)
                                .startDate("2024-12-12")
                                .build())
                            .build()))
                    .billingAddress(BillingAddress.builder()
                        .title("Mr.")
                        .givenName("Piet")
                        .familyName("Mondriaan")
                        .organizationName("Mollie B.V.")
                        .streetAndNumber("Keizersgracht 126")
                        .streetAdditional("Apt. 1")
                        .postalCode("1234AB")
                        .email("piet@example.org")
                        .phone("31208202070")
                        .city("Amsterdam")
                        .region("Noord-Holland")
                        .country("NL")
                        .build())
                    .shippingAddress(ShippingAddress.builder()
                        .title("Mr.")
                        .givenName("Piet")
                        .familyName("Mondriaan")
                        .organizationName("Mollie B.V.")
                        .streetAndNumber("Keizersgracht 126")
                        .streetAdditional("Apt. 1")
                        .postalCode("1234AB")
                        .email("piet@example.org")
                        .phone("31208202070")
                        .city("Amsterdam")
                        .region("Noord-Holland")
                        .country("NL")
                        .build())
                    .locale(Locale.EN_US)
                    .method(Method.IDEAL)
                    .issuer("ideal_INGBNL2A")
                    .restrictPaymentMethodsToCountry("NL")
                    .captureMode(CaptureMode.MANUAL)
                    .captureDelay("8 hours")
                    .applicationFee(ApplicationFee.builder()
                        .amount(CreatePaymentPaymentsAmount.builder()
                            .currency("EUR")
                            .value("10.00")
                            .build())
                        .description("10")
                        .build())
                    .routing(List.of(
                        Routing.builder()
                            .amount(CreatePaymentPaymentsRequestAmount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .destination(Destination.builder()
                                .type(CreatePaymentType.ORGANIZATION)
                                .organizationId("org_1234567")
                                .build())
                            .links(Links.builder()
                                .self(Self.builder()
                                    .href("https://...")
                                    .type("application/hal+json")
                                    .build())
                                .payment(Payment.builder()
                                    .href("https://...")
                                    .type("application/hal+json")
                                    .build())
                                .build())
                            .releaseDate("2024-12-12")
                            .build(),
                        Routing.builder()
                            .amount(CreatePaymentPaymentsRequestAmount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .destination(Destination.builder()
                                .type(CreatePaymentType.ORGANIZATION)
                                .organizationId("org_1234567")
                                .build())
                            .links(Links.builder()
                                .self(Self.builder()
                                    .href("https://...")
                                    .type("application/hal+json")
                                    .build())
                                .payment(Payment.builder()
                                    .href("https://...")
                                    .type("application/hal+json")
                                    .build())
                                .build())
                            .releaseDate("2024-12-12")
                            .build()))
                    .mandateId("mdt_5B8cwPMGnU")
                    .customerId("cst_5B8cwPMGnU")
                    .profileId("pfl_5B8cwPMGnU")
                    .dueDate("2025-01-01")
                    .testmode(false)
                    .build())
                .call();

        if (res.object().isPresent()) {
            // handle response
        }
    }
}
```
<!-- End Authentication [security] -->

<!-- Start Available Resources and Operations [operations] -->
## Available Resources and Operations

<details open>
<summary>Available methods</summary>

### [balances()](docs/sdks/balances/README.md)

* [list](docs/sdks/balances/README.md#list) - List balances
* [get](docs/sdks/balances/README.md#get) - Get balance
* [getPrimary](docs/sdks/balances/README.md#getprimary) - Get primary balance
* [getReport](docs/sdks/balances/README.md#getreport) - Get balance report
* [listTransactions](docs/sdks/balances/README.md#listtransactions) - List balance transactions

### [capabilities()](docs/sdks/capabilities/README.md)

* [list](docs/sdks/capabilities/README.md#list) - List capabilities

### [captures()](docs/sdks/captures/README.md)

* [create](docs/sdks/captures/README.md#create) - Create capture
* [list](docs/sdks/captures/README.md#list) - List captures
* [get](docs/sdks/captures/README.md#get) - Get capture

### [chargebacks()](docs/sdks/chargebacks/README.md)

* [list](docs/sdks/chargebacks/README.md#list) - List payment chargebacks
* [get](docs/sdks/chargebacks/README.md#get) - Get payment chargeback
* [all](docs/sdks/chargebacks/README.md#all) - List all chargebacks


### [clientLinks()](docs/sdks/clientlinks/README.md)

* [create](docs/sdks/clientlinks/README.md#create) - Create client link

### [clients()](docs/sdks/clients/README.md)

* [list](docs/sdks/clients/README.md#list) - List clients
* [get](docs/sdks/clients/README.md#get) - Get client

### [customers()](docs/sdks/customers/README.md)

* [create](docs/sdks/customers/README.md#create) - Create customer
* [list](docs/sdks/customers/README.md#list) - List customers
* [get](docs/sdks/customers/README.md#get) - Get customer
* [update](docs/sdks/customers/README.md#update) - Update customer
* [delete](docs/sdks/customers/README.md#delete) - Delete customer
* [createPayment](docs/sdks/customers/README.md#createpayment) - Create customer payment
* [listPayments](docs/sdks/customers/README.md#listpayments) - List customer payments

### [delayedRouting()](docs/sdks/delayedrouting/README.md)

* [create](docs/sdks/delayedrouting/README.md#create) - Create a delayed route
* [list](docs/sdks/delayedrouting/README.md#list) - List payment routes

### [invoices()](docs/sdks/invoices/README.md)

* [list](docs/sdks/invoices/README.md#list) - List invoices
* [get](docs/sdks/invoices/README.md#get) - Get invoice

### [mandates()](docs/sdks/mandates/README.md)

* [create](docs/sdks/mandates/README.md#create) - Create mandate
* [list](docs/sdks/mandates/README.md#list) - List mandates
* [get](docs/sdks/mandates/README.md#get) - Get mandate
* [revoke](docs/sdks/mandates/README.md#revoke) - Revoke mandate

### [methods()](docs/sdks/methods/README.md)

* [list](docs/sdks/methods/README.md#list) - List payment methods
* [all](docs/sdks/methods/README.md#all) - List all payment methods
* [get](docs/sdks/methods/README.md#get) - Get payment method

### [onboarding()](docs/sdks/onboarding/README.md)

* [get](docs/sdks/onboarding/README.md#get) - Get onboarding status
* [submit](docs/sdks/onboarding/README.md#submit) - Submit onboarding data

### [organizations()](docs/sdks/organizations/README.md)

* [get](docs/sdks/organizations/README.md#get) - Get organization
* [getCurrent](docs/sdks/organizations/README.md#getcurrent) - Get current organization
* [getPartner](docs/sdks/organizations/README.md#getpartner) - Get partner status

### [paymentLinks()](docs/sdks/paymentlinks/README.md)

* [create](docs/sdks/paymentlinks/README.md#create) - Create payment link
* [list](docs/sdks/paymentlinks/README.md#list) - List payment links
* [get](docs/sdks/paymentlinks/README.md#get) - Get payment link
* [update](docs/sdks/paymentlinks/README.md#update) - Update payment link
* [delete](docs/sdks/paymentlinks/README.md#delete) - Delete payment link
* [listPayments](docs/sdks/paymentlinks/README.md#listpayments) - Get payment link payments

### [payments()](docs/sdks/payments/README.md)

* [create](docs/sdks/payments/README.md#create) - Create payment
* [list](docs/sdks/payments/README.md#list) - List payments
* [get](docs/sdks/payments/README.md#get) - Get payment
* [update](docs/sdks/payments/README.md#update) - Update payment
* [cancel](docs/sdks/payments/README.md#cancel) - Cancel payment
* [releaseAuthorization](docs/sdks/payments/README.md#releaseauthorization) - Release payment authorization

### [permissions()](docs/sdks/permissions/README.md)

* [list](docs/sdks/permissions/README.md#list) - List permissions
* [get](docs/sdks/permissions/README.md#get) - Get permission

### [profiles()](docs/sdks/profiles/README.md)

* [create](docs/sdks/profiles/README.md#create) - Create profile
* [list](docs/sdks/profiles/README.md#list) - List profiles
* [get](docs/sdks/profiles/README.md#get) - Get profile
* [update](docs/sdks/profiles/README.md#update) - Update profile
* [delete](docs/sdks/profiles/README.md#delete) - Delete profile
* [getCurrent](docs/sdks/profiles/README.md#getcurrent) - Get current profile

### [refunds()](docs/sdks/refunds/README.md)

* [create](docs/sdks/refunds/README.md#create) - Create payment refund
* [list](docs/sdks/refunds/README.md#list) - List payment refunds
* [get](docs/sdks/refunds/README.md#get) - Get payment refund
* [cancel](docs/sdks/refunds/README.md#cancel) - Cancel payment refund
* [all](docs/sdks/refunds/README.md#all) - List all refunds

### [salesInvoices()](docs/sdks/salesinvoices/README.md)

* [create](docs/sdks/salesinvoices/README.md#create) - Create sales invoice
* [list](docs/sdks/salesinvoices/README.md#list) - List sales invoices
* [get](docs/sdks/salesinvoices/README.md#get) - Get sales invoice
* [update](docs/sdks/salesinvoices/README.md#update) - Update sales invoice
* [delete](docs/sdks/salesinvoices/README.md#delete) - Delete sales invoice

### [settlements()](docs/sdks/settlements/README.md)

* [list](docs/sdks/settlements/README.md#list) - List settlements
* [get](docs/sdks/settlements/README.md#get) - Get settlement
* [getOpen](docs/sdks/settlements/README.md#getopen) - Get open settlement
* [getNext](docs/sdks/settlements/README.md#getnext) - Get next settlement
* [listPayments](docs/sdks/settlements/README.md#listpayments) - List settlement payments
* [listCaptures](docs/sdks/settlements/README.md#listcaptures) - List settlement captures
* [listRefunds](docs/sdks/settlements/README.md#listrefunds) - List settlement refunds
* [listChargebacks](docs/sdks/settlements/README.md#listchargebacks) - List settlement chargebacks

### [subscriptions()](docs/sdks/subscriptions/README.md)

* [create](docs/sdks/subscriptions/README.md#create) - Create subscription
* [list](docs/sdks/subscriptions/README.md#list) - List customer subscriptions
* [get](docs/sdks/subscriptions/README.md#get) - Get subscription
* [update](docs/sdks/subscriptions/README.md#update) - Update subscription
* [cancel](docs/sdks/subscriptions/README.md#cancel) - Cancel subscription
* [all](docs/sdks/subscriptions/README.md#all) - List all subscriptions
* [listPayments](docs/sdks/subscriptions/README.md#listpayments) - List subscription payments

### [terminals()](docs/sdks/terminals/README.md)

* [list](docs/sdks/terminals/README.md#list) - List terminals
* [get](docs/sdks/terminals/README.md#get) - Get terminal

### [wallets()](docs/sdks/wallets/README.md)

* [requestApplePaySession](docs/sdks/wallets/README.md#requestapplepaysession) - Request Apple Pay payment session

### [webhookEvents()](docs/sdks/webhookevents/README.md)

* [get](docs/sdks/webhookevents/README.md#get) - Get a Webhook Event

### [webhooks()](docs/sdks/webhooks/README.md)

* [create](docs/sdks/webhooks/README.md#create) - Create a webhook
* [list](docs/sdks/webhooks/README.md#list) - List all webhooks
* [update](docs/sdks/webhooks/README.md#update) - Update a webhook
* [get](docs/sdks/webhooks/README.md#get) - Get a webhook
* [delete](docs/sdks/webhooks/README.md#delete) - Delete a webhook
* [test](docs/sdks/webhooks/README.md#test) - Test a webhook

</details>
<!-- End Available Resources and Operations [operations] -->

<!-- Start Retries [retries] -->
## Retries

Some of the endpoints in this SDK support retries. If you use the SDK without any configuration, it will fall back to the default retry strategy provided by the API. However, the default retry strategy can be overridden on a per-operation basis, or across the entire SDK.

To change the default retry strategy for a single API call, you can provide a `RetryConfig` object through the `retryConfig` builder method:
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.CreatePaymentPaymentsResponseBody;
import com.mollie.mollie.models.errors.CreatePaymentResponseBody;
import com.mollie.mollie.models.operations.*;
import com.mollie.mollie.utils.BackoffStrategy;
import com.mollie.mollie.utils.RetryConfig;
import java.lang.Exception;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Application {

    public static void main(String[] args) throws CreatePaymentResponseBody, CreatePaymentPaymentsResponseBody, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        CreatePaymentResponse res = sdk.payments().create()
                .retryConfig(RetryConfig.builder()
                    .backoff(BackoffStrategy.builder()
                        .initialInterval(1L, TimeUnit.MILLISECONDS)
                        .maxInterval(50L, TimeUnit.MILLISECONDS)
                        .maxElapsedTime(1000L, TimeUnit.MILLISECONDS)
                        .baseFactor(1.1)
                        .jitterFactor(0.15)
                        .retryConnectError(false)
                        .build())
                    .build())
                .include(Include.DETAILS_QR_CODE)
                .requestBody(CreatePaymentRequestBody.builder()
                    .description("Chess Board")
                    .amount(Amount.builder()
                        .currency("EUR")
                        .value("10.00")
                        .build())
                    .redirectUrl("https://example.org/redirect")
                    .cancelUrl("https://example.org/cancel")
                    .webhookUrl("https://example.org/webhooks")
                    .lines(List.of(
                        Lines.builder()
                            .description("LEGO 4440 Forest Police Station")
                            .quantity(1L)
                            .unitPrice(UnitPrice.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .totalAmount(TotalAmount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .quantityUnit("pcs")
                            .discountAmount(DiscountAmount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .vatRate("21.00")
                            .vatAmount(VatAmount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .sku("9780241661628")
                            .categories(List.of(
                                Categories.MEAL,
                                Categories.ECO))
                            .imageUrl("https://...")
                            .productUrl("https://...")
                            .recurring(Recurring.builder()
                                .interval(Interval.DOT_DOT_DOT_DAYS)
                                .description("Gym subscription")
                                .amount(CreatePaymentAmount.builder()
                                    .currency("EUR")
                                    .value("10.00")
                                    .build())
                                .times(1L)
                                .startDate("2024-12-12")
                                .build())
                            .build(),
                        Lines.builder()
                            .description("LEGO 4440 Forest Police Station")
                            .quantity(1L)
                            .unitPrice(UnitPrice.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .totalAmount(TotalAmount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .quantityUnit("pcs")
                            .discountAmount(DiscountAmount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .vatRate("21.00")
                            .vatAmount(VatAmount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .sku("9780241661628")
                            .categories(List.of(
                                Categories.MEAL,
                                Categories.ECO))
                            .imageUrl("https://...")
                            .productUrl("https://...")
                            .recurring(Recurring.builder()
                                .interval(Interval.DOT_DOT_DOT_WEEKS)
                                .description("Gym subscription")
                                .amount(CreatePaymentAmount.builder()
                                    .currency("EUR")
                                    .value("10.00")
                                    .build())
                                .times(1L)
                                .startDate("2024-12-12")
                                .build())
                            .build(),
                        Lines.builder()
                            .description("LEGO 4440 Forest Police Station")
                            .quantity(1L)
                            .unitPrice(UnitPrice.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .totalAmount(TotalAmount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .quantityUnit("pcs")
                            .discountAmount(DiscountAmount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .vatRate("21.00")
                            .vatAmount(VatAmount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .sku("9780241661628")
                            .categories(List.of(
                                Categories.MEAL,
                                Categories.ECO))
                            .imageUrl("https://...")
                            .productUrl("https://...")
                            .recurring(Recurring.builder()
                                .interval(Interval.DOT_DOT_DOT_DAYS)
                                .description("Gym subscription")
                                .amount(CreatePaymentAmount.builder()
                                    .currency("EUR")
                                    .value("10.00")
                                    .build())
                                .times(1L)
                                .startDate("2024-12-12")
                                .build())
                            .build()))
                    .billingAddress(BillingAddress.builder()
                        .title("Mr.")
                        .givenName("Piet")
                        .familyName("Mondriaan")
                        .organizationName("Mollie B.V.")
                        .streetAndNumber("Keizersgracht 126")
                        .streetAdditional("Apt. 1")
                        .postalCode("1234AB")
                        .email("piet@example.org")
                        .phone("31208202070")
                        .city("Amsterdam")
                        .region("Noord-Holland")
                        .country("NL")
                        .build())
                    .shippingAddress(ShippingAddress.builder()
                        .title("Mr.")
                        .givenName("Piet")
                        .familyName("Mondriaan")
                        .organizationName("Mollie B.V.")
                        .streetAndNumber("Keizersgracht 126")
                        .streetAdditional("Apt. 1")
                        .postalCode("1234AB")
                        .email("piet@example.org")
                        .phone("31208202070")
                        .city("Amsterdam")
                        .region("Noord-Holland")
                        .country("NL")
                        .build())
                    .locale(Locale.EN_US)
                    .method(Method.IDEAL)
                    .issuer("ideal_INGBNL2A")
                    .restrictPaymentMethodsToCountry("NL")
                    .captureMode(CaptureMode.MANUAL)
                    .captureDelay("8 hours")
                    .applicationFee(ApplicationFee.builder()
                        .amount(CreatePaymentPaymentsAmount.builder()
                            .currency("EUR")
                            .value("10.00")
                            .build())
                        .description("10")
                        .build())
                    .routing(List.of(
                        Routing.builder()
                            .amount(CreatePaymentPaymentsRequestAmount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .destination(Destination.builder()
                                .type(CreatePaymentType.ORGANIZATION)
                                .organizationId("org_1234567")
                                .build())
                            .links(Links.builder()
                                .self(Self.builder()
                                    .href("https://...")
                                    .type("application/hal+json")
                                    .build())
                                .payment(Payment.builder()
                                    .href("https://...")
                                    .type("application/hal+json")
                                    .build())
                                .build())
                            .releaseDate("2024-12-12")
                            .build(),
                        Routing.builder()
                            .amount(CreatePaymentPaymentsRequestAmount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .destination(Destination.builder()
                                .type(CreatePaymentType.ORGANIZATION)
                                .organizationId("org_1234567")
                                .build())
                            .links(Links.builder()
                                .self(Self.builder()
                                    .href("https://...")
                                    .type("application/hal+json")
                                    .build())
                                .payment(Payment.builder()
                                    .href("https://...")
                                    .type("application/hal+json")
                                    .build())
                                .build())
                            .releaseDate("2024-12-12")
                            .build()))
                    .mandateId("mdt_5B8cwPMGnU")
                    .customerId("cst_5B8cwPMGnU")
                    .profileId("pfl_5B8cwPMGnU")
                    .dueDate("2025-01-01")
                    .testmode(false)
                    .build())
                .call();

        if (res.object().isPresent()) {
            // handle response
        }
    }
}
```

If you'd like to override the default retry strategy for all operations that support retries, you can provide a configuration at SDK initialization:
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.CreatePaymentPaymentsResponseBody;
import com.mollie.mollie.models.errors.CreatePaymentResponseBody;
import com.mollie.mollie.models.operations.*;
import com.mollie.mollie.utils.BackoffStrategy;
import com.mollie.mollie.utils.RetryConfig;
import java.lang.Exception;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Application {

    public static void main(String[] args) throws CreatePaymentResponseBody, CreatePaymentPaymentsResponseBody, Exception {

        Client sdk = Client.builder()
                .retryConfig(RetryConfig.builder()
                    .backoff(BackoffStrategy.builder()
                        .initialInterval(1L, TimeUnit.MILLISECONDS)
                        .maxInterval(50L, TimeUnit.MILLISECONDS)
                        .maxElapsedTime(1000L, TimeUnit.MILLISECONDS)
                        .baseFactor(1.1)
                        .jitterFactor(0.15)
                        .retryConnectError(false)
                        .build())
                    .build())
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        CreatePaymentResponse res = sdk.payments().create()
                .include(Include.DETAILS_QR_CODE)
                .requestBody(CreatePaymentRequestBody.builder()
                    .description("Chess Board")
                    .amount(Amount.builder()
                        .currency("EUR")
                        .value("10.00")
                        .build())
                    .redirectUrl("https://example.org/redirect")
                    .cancelUrl("https://example.org/cancel")
                    .webhookUrl("https://example.org/webhooks")
                    .lines(List.of(
                        Lines.builder()
                            .description("LEGO 4440 Forest Police Station")
                            .quantity(1L)
                            .unitPrice(UnitPrice.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .totalAmount(TotalAmount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .quantityUnit("pcs")
                            .discountAmount(DiscountAmount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .vatRate("21.00")
                            .vatAmount(VatAmount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .sku("9780241661628")
                            .categories(List.of(
                                Categories.MEAL,
                                Categories.ECO))
                            .imageUrl("https://...")
                            .productUrl("https://...")
                            .recurring(Recurring.builder()
                                .interval(Interval.DOT_DOT_DOT_DAYS)
                                .description("Gym subscription")
                                .amount(CreatePaymentAmount.builder()
                                    .currency("EUR")
                                    .value("10.00")
                                    .build())
                                .times(1L)
                                .startDate("2024-12-12")
                                .build())
                            .build(),
                        Lines.builder()
                            .description("LEGO 4440 Forest Police Station")
                            .quantity(1L)
                            .unitPrice(UnitPrice.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .totalAmount(TotalAmount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .quantityUnit("pcs")
                            .discountAmount(DiscountAmount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .vatRate("21.00")
                            .vatAmount(VatAmount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .sku("9780241661628")
                            .categories(List.of(
                                Categories.MEAL,
                                Categories.ECO))
                            .imageUrl("https://...")
                            .productUrl("https://...")
                            .recurring(Recurring.builder()
                                .interval(Interval.DOT_DOT_DOT_WEEKS)
                                .description("Gym subscription")
                                .amount(CreatePaymentAmount.builder()
                                    .currency("EUR")
                                    .value("10.00")
                                    .build())
                                .times(1L)
                                .startDate("2024-12-12")
                                .build())
                            .build(),
                        Lines.builder()
                            .description("LEGO 4440 Forest Police Station")
                            .quantity(1L)
                            .unitPrice(UnitPrice.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .totalAmount(TotalAmount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .quantityUnit("pcs")
                            .discountAmount(DiscountAmount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .vatRate("21.00")
                            .vatAmount(VatAmount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .sku("9780241661628")
                            .categories(List.of(
                                Categories.MEAL,
                                Categories.ECO))
                            .imageUrl("https://...")
                            .productUrl("https://...")
                            .recurring(Recurring.builder()
                                .interval(Interval.DOT_DOT_DOT_DAYS)
                                .description("Gym subscription")
                                .amount(CreatePaymentAmount.builder()
                                    .currency("EUR")
                                    .value("10.00")
                                    .build())
                                .times(1L)
                                .startDate("2024-12-12")
                                .build())
                            .build()))
                    .billingAddress(BillingAddress.builder()
                        .title("Mr.")
                        .givenName("Piet")
                        .familyName("Mondriaan")
                        .organizationName("Mollie B.V.")
                        .streetAndNumber("Keizersgracht 126")
                        .streetAdditional("Apt. 1")
                        .postalCode("1234AB")
                        .email("piet@example.org")
                        .phone("31208202070")
                        .city("Amsterdam")
                        .region("Noord-Holland")
                        .country("NL")
                        .build())
                    .shippingAddress(ShippingAddress.builder()
                        .title("Mr.")
                        .givenName("Piet")
                        .familyName("Mondriaan")
                        .organizationName("Mollie B.V.")
                        .streetAndNumber("Keizersgracht 126")
                        .streetAdditional("Apt. 1")
                        .postalCode("1234AB")
                        .email("piet@example.org")
                        .phone("31208202070")
                        .city("Amsterdam")
                        .region("Noord-Holland")
                        .country("NL")
                        .build())
                    .locale(Locale.EN_US)
                    .method(Method.IDEAL)
                    .issuer("ideal_INGBNL2A")
                    .restrictPaymentMethodsToCountry("NL")
                    .captureMode(CaptureMode.MANUAL)
                    .captureDelay("8 hours")
                    .applicationFee(ApplicationFee.builder()
                        .amount(CreatePaymentPaymentsAmount.builder()
                            .currency("EUR")
                            .value("10.00")
                            .build())
                        .description("10")
                        .build())
                    .routing(List.of(
                        Routing.builder()
                            .amount(CreatePaymentPaymentsRequestAmount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .destination(Destination.builder()
                                .type(CreatePaymentType.ORGANIZATION)
                                .organizationId("org_1234567")
                                .build())
                            .links(Links.builder()
                                .self(Self.builder()
                                    .href("https://...")
                                    .type("application/hal+json")
                                    .build())
                                .payment(Payment.builder()
                                    .href("https://...")
                                    .type("application/hal+json")
                                    .build())
                                .build())
                            .releaseDate("2024-12-12")
                            .build(),
                        Routing.builder()
                            .amount(CreatePaymentPaymentsRequestAmount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .destination(Destination.builder()
                                .type(CreatePaymentType.ORGANIZATION)
                                .organizationId("org_1234567")
                                .build())
                            .links(Links.builder()
                                .self(Self.builder()
                                    .href("https://...")
                                    .type("application/hal+json")
                                    .build())
                                .payment(Payment.builder()
                                    .href("https://...")
                                    .type("application/hal+json")
                                    .build())
                                .build())
                            .releaseDate("2024-12-12")
                            .build()))
                    .mandateId("mdt_5B8cwPMGnU")
                    .customerId("cst_5B8cwPMGnU")
                    .profileId("pfl_5B8cwPMGnU")
                    .dueDate("2025-01-01")
                    .testmode(false)
                    .build())
                .call();

        if (res.object().isPresent()) {
            // handle response
        }
    }
}
```
<!-- End Retries [retries] -->

<!-- Start Error Handling [errors] -->
## Error Handling

Handling errors in this SDK should largely match your expectations. All operations return a response object or raise an exception.

By default, an API error will throw a `models/errors/APIException` exception. When custom error responses are specified for an operation, the SDK may also throw their associated exception. You can refer to respective *Errors* tables in SDK docs for more details on possible exception types for each operation. For example, the `create` method throws the following exceptions:

| Error Type                                      | Status Code | Content Type         |
| ----------------------------------------------- | ----------- | -------------------- |
| models/errors/CreatePaymentResponseBody         | 422         | application/hal+json |
| models/errors/CreatePaymentPaymentsResponseBody | 503         | application/hal+json |
| models/errors/APIException                      | 4XX, 5XX    | \*/\*                |

### Example

```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.CreatePaymentPaymentsResponseBody;
import com.mollie.mollie.models.errors.CreatePaymentResponseBody;
import com.mollie.mollie.models.operations.*;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws CreatePaymentResponseBody, CreatePaymentPaymentsResponseBody, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        CreatePaymentResponse res = sdk.payments().create()
                .include(Include.DETAILS_QR_CODE)
                .requestBody(CreatePaymentRequestBody.builder()
                    .description("Chess Board")
                    .amount(Amount.builder()
                        .currency("EUR")
                        .value("10.00")
                        .build())
                    .redirectUrl("https://example.org/redirect")
                    .cancelUrl("https://example.org/cancel")
                    .webhookUrl("https://example.org/webhooks")
                    .lines(List.of(
                        Lines.builder()
                            .description("LEGO 4440 Forest Police Station")
                            .quantity(1L)
                            .unitPrice(UnitPrice.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .totalAmount(TotalAmount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .quantityUnit("pcs")
                            .discountAmount(DiscountAmount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .vatRate("21.00")
                            .vatAmount(VatAmount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .sku("9780241661628")
                            .categories(List.of(
                                Categories.MEAL,
                                Categories.ECO))
                            .imageUrl("https://...")
                            .productUrl("https://...")
                            .recurring(Recurring.builder()
                                .interval(Interval.DOT_DOT_DOT_DAYS)
                                .description("Gym subscription")
                                .amount(CreatePaymentAmount.builder()
                                    .currency("EUR")
                                    .value("10.00")
                                    .build())
                                .times(1L)
                                .startDate("2024-12-12")
                                .build())
                            .build(),
                        Lines.builder()
                            .description("LEGO 4440 Forest Police Station")
                            .quantity(1L)
                            .unitPrice(UnitPrice.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .totalAmount(TotalAmount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .quantityUnit("pcs")
                            .discountAmount(DiscountAmount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .vatRate("21.00")
                            .vatAmount(VatAmount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .sku("9780241661628")
                            .categories(List.of(
                                Categories.MEAL,
                                Categories.ECO))
                            .imageUrl("https://...")
                            .productUrl("https://...")
                            .recurring(Recurring.builder()
                                .interval(Interval.DOT_DOT_DOT_WEEKS)
                                .description("Gym subscription")
                                .amount(CreatePaymentAmount.builder()
                                    .currency("EUR")
                                    .value("10.00")
                                    .build())
                                .times(1L)
                                .startDate("2024-12-12")
                                .build())
                            .build(),
                        Lines.builder()
                            .description("LEGO 4440 Forest Police Station")
                            .quantity(1L)
                            .unitPrice(UnitPrice.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .totalAmount(TotalAmount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .quantityUnit("pcs")
                            .discountAmount(DiscountAmount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .vatRate("21.00")
                            .vatAmount(VatAmount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .sku("9780241661628")
                            .categories(List.of(
                                Categories.MEAL,
                                Categories.ECO))
                            .imageUrl("https://...")
                            .productUrl("https://...")
                            .recurring(Recurring.builder()
                                .interval(Interval.DOT_DOT_DOT_DAYS)
                                .description("Gym subscription")
                                .amount(CreatePaymentAmount.builder()
                                    .currency("EUR")
                                    .value("10.00")
                                    .build())
                                .times(1L)
                                .startDate("2024-12-12")
                                .build())
                            .build()))
                    .billingAddress(BillingAddress.builder()
                        .title("Mr.")
                        .givenName("Piet")
                        .familyName("Mondriaan")
                        .organizationName("Mollie B.V.")
                        .streetAndNumber("Keizersgracht 126")
                        .streetAdditional("Apt. 1")
                        .postalCode("1234AB")
                        .email("piet@example.org")
                        .phone("31208202070")
                        .city("Amsterdam")
                        .region("Noord-Holland")
                        .country("NL")
                        .build())
                    .shippingAddress(ShippingAddress.builder()
                        .title("Mr.")
                        .givenName("Piet")
                        .familyName("Mondriaan")
                        .organizationName("Mollie B.V.")
                        .streetAndNumber("Keizersgracht 126")
                        .streetAdditional("Apt. 1")
                        .postalCode("1234AB")
                        .email("piet@example.org")
                        .phone("31208202070")
                        .city("Amsterdam")
                        .region("Noord-Holland")
                        .country("NL")
                        .build())
                    .locale(Locale.EN_US)
                    .method(Method.IDEAL)
                    .issuer("ideal_INGBNL2A")
                    .restrictPaymentMethodsToCountry("NL")
                    .captureMode(CaptureMode.MANUAL)
                    .captureDelay("8 hours")
                    .applicationFee(ApplicationFee.builder()
                        .amount(CreatePaymentPaymentsAmount.builder()
                            .currency("EUR")
                            .value("10.00")
                            .build())
                        .description("10")
                        .build())
                    .routing(List.of(
                        Routing.builder()
                            .amount(CreatePaymentPaymentsRequestAmount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .destination(Destination.builder()
                                .type(CreatePaymentType.ORGANIZATION)
                                .organizationId("org_1234567")
                                .build())
                            .links(Links.builder()
                                .self(Self.builder()
                                    .href("https://...")
                                    .type("application/hal+json")
                                    .build())
                                .payment(Payment.builder()
                                    .href("https://...")
                                    .type("application/hal+json")
                                    .build())
                                .build())
                            .releaseDate("2024-12-12")
                            .build(),
                        Routing.builder()
                            .amount(CreatePaymentPaymentsRequestAmount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .destination(Destination.builder()
                                .type(CreatePaymentType.ORGANIZATION)
                                .organizationId("org_1234567")
                                .build())
                            .links(Links.builder()
                                .self(Self.builder()
                                    .href("https://...")
                                    .type("application/hal+json")
                                    .build())
                                .payment(Payment.builder()
                                    .href("https://...")
                                    .type("application/hal+json")
                                    .build())
                                .build())
                            .releaseDate("2024-12-12")
                            .build()))
                    .mandateId("mdt_5B8cwPMGnU")
                    .customerId("cst_5B8cwPMGnU")
                    .profileId("pfl_5B8cwPMGnU")
                    .dueDate("2025-01-01")
                    .testmode(false)
                    .build())
                .call();

        if (res.object().isPresent()) {
            // handle response
        }
    }
}
```
<!-- End Error Handling [errors] -->

<!-- Start Server Selection [server] -->
## Server Selection

### Override Server URL Per-Client

The default server can be overridden globally using the `.serverURL(String serverUrl)` builder method when initializing the SDK client instance. For example:
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.CreatePaymentPaymentsResponseBody;
import com.mollie.mollie.models.errors.CreatePaymentResponseBody;
import com.mollie.mollie.models.operations.*;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws CreatePaymentResponseBody, CreatePaymentPaymentsResponseBody, Exception {

        Client sdk = Client.builder()
                .serverURL("https://api.mollie.com/v2")
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        CreatePaymentResponse res = sdk.payments().create()
                .include(Include.DETAILS_QR_CODE)
                .requestBody(CreatePaymentRequestBody.builder()
                    .description("Chess Board")
                    .amount(Amount.builder()
                        .currency("EUR")
                        .value("10.00")
                        .build())
                    .redirectUrl("https://example.org/redirect")
                    .cancelUrl("https://example.org/cancel")
                    .webhookUrl("https://example.org/webhooks")
                    .lines(List.of(
                        Lines.builder()
                            .description("LEGO 4440 Forest Police Station")
                            .quantity(1L)
                            .unitPrice(UnitPrice.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .totalAmount(TotalAmount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .quantityUnit("pcs")
                            .discountAmount(DiscountAmount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .vatRate("21.00")
                            .vatAmount(VatAmount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .sku("9780241661628")
                            .categories(List.of(
                                Categories.MEAL,
                                Categories.ECO))
                            .imageUrl("https://...")
                            .productUrl("https://...")
                            .recurring(Recurring.builder()
                                .interval(Interval.DOT_DOT_DOT_DAYS)
                                .description("Gym subscription")
                                .amount(CreatePaymentAmount.builder()
                                    .currency("EUR")
                                    .value("10.00")
                                    .build())
                                .times(1L)
                                .startDate("2024-12-12")
                                .build())
                            .build(),
                        Lines.builder()
                            .description("LEGO 4440 Forest Police Station")
                            .quantity(1L)
                            .unitPrice(UnitPrice.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .totalAmount(TotalAmount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .quantityUnit("pcs")
                            .discountAmount(DiscountAmount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .vatRate("21.00")
                            .vatAmount(VatAmount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .sku("9780241661628")
                            .categories(List.of(
                                Categories.MEAL,
                                Categories.ECO))
                            .imageUrl("https://...")
                            .productUrl("https://...")
                            .recurring(Recurring.builder()
                                .interval(Interval.DOT_DOT_DOT_WEEKS)
                                .description("Gym subscription")
                                .amount(CreatePaymentAmount.builder()
                                    .currency("EUR")
                                    .value("10.00")
                                    .build())
                                .times(1L)
                                .startDate("2024-12-12")
                                .build())
                            .build(),
                        Lines.builder()
                            .description("LEGO 4440 Forest Police Station")
                            .quantity(1L)
                            .unitPrice(UnitPrice.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .totalAmount(TotalAmount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .quantityUnit("pcs")
                            .discountAmount(DiscountAmount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .vatRate("21.00")
                            .vatAmount(VatAmount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .sku("9780241661628")
                            .categories(List.of(
                                Categories.MEAL,
                                Categories.ECO))
                            .imageUrl("https://...")
                            .productUrl("https://...")
                            .recurring(Recurring.builder()
                                .interval(Interval.DOT_DOT_DOT_DAYS)
                                .description("Gym subscription")
                                .amount(CreatePaymentAmount.builder()
                                    .currency("EUR")
                                    .value("10.00")
                                    .build())
                                .times(1L)
                                .startDate("2024-12-12")
                                .build())
                            .build()))
                    .billingAddress(BillingAddress.builder()
                        .title("Mr.")
                        .givenName("Piet")
                        .familyName("Mondriaan")
                        .organizationName("Mollie B.V.")
                        .streetAndNumber("Keizersgracht 126")
                        .streetAdditional("Apt. 1")
                        .postalCode("1234AB")
                        .email("piet@example.org")
                        .phone("31208202070")
                        .city("Amsterdam")
                        .region("Noord-Holland")
                        .country("NL")
                        .build())
                    .shippingAddress(ShippingAddress.builder()
                        .title("Mr.")
                        .givenName("Piet")
                        .familyName("Mondriaan")
                        .organizationName("Mollie B.V.")
                        .streetAndNumber("Keizersgracht 126")
                        .streetAdditional("Apt. 1")
                        .postalCode("1234AB")
                        .email("piet@example.org")
                        .phone("31208202070")
                        .city("Amsterdam")
                        .region("Noord-Holland")
                        .country("NL")
                        .build())
                    .locale(Locale.EN_US)
                    .method(Method.IDEAL)
                    .issuer("ideal_INGBNL2A")
                    .restrictPaymentMethodsToCountry("NL")
                    .captureMode(CaptureMode.MANUAL)
                    .captureDelay("8 hours")
                    .applicationFee(ApplicationFee.builder()
                        .amount(CreatePaymentPaymentsAmount.builder()
                            .currency("EUR")
                            .value("10.00")
                            .build())
                        .description("10")
                        .build())
                    .routing(List.of(
                        Routing.builder()
                            .amount(CreatePaymentPaymentsRequestAmount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .destination(Destination.builder()
                                .type(CreatePaymentType.ORGANIZATION)
                                .organizationId("org_1234567")
                                .build())
                            .links(Links.builder()
                                .self(Self.builder()
                                    .href("https://...")
                                    .type("application/hal+json")
                                    .build())
                                .payment(Payment.builder()
                                    .href("https://...")
                                    .type("application/hal+json")
                                    .build())
                                .build())
                            .releaseDate("2024-12-12")
                            .build(),
                        Routing.builder()
                            .amount(CreatePaymentPaymentsRequestAmount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .destination(Destination.builder()
                                .type(CreatePaymentType.ORGANIZATION)
                                .organizationId("org_1234567")
                                .build())
                            .links(Links.builder()
                                .self(Self.builder()
                                    .href("https://...")
                                    .type("application/hal+json")
                                    .build())
                                .payment(Payment.builder()
                                    .href("https://...")
                                    .type("application/hal+json")
                                    .build())
                                .build())
                            .releaseDate("2024-12-12")
                            .build()))
                    .mandateId("mdt_5B8cwPMGnU")
                    .customerId("cst_5B8cwPMGnU")
                    .profileId("pfl_5B8cwPMGnU")
                    .dueDate("2025-01-01")
                    .testmode(false)
                    .build())
                .call();

        if (res.object().isPresent()) {
            // handle response
        }
    }
}
```
<!-- End Server Selection [server] -->

<!-- Start Debugging [debug] -->
## Debugging

### Debug
You can setup your SDK to emit debug logs for SDK requests and responses.

For request and response logging (especially json bodies), call `enableHTTPDebugLogging(boolean)` on the SDK builder like so:
```java
SDK.builder()
    .enableHTTPDebugLogging(true)
    .build();
```
Example output:
```
Sending request: http://localhost:35123/bearer#global GET
Request headers: {Accept=[application/json], Authorization=[******], Client-Level-Header=[added by client], Idempotency-Key=[some-key], x-speakeasy-user-agent=[speakeasy-sdk/java 0.0.1 internal 0.1.0 org.openapis.openapi]}
Received response: (GET http://localhost:35123/bearer#global) 200
Response headers: {access-control-allow-credentials=[true], access-control-allow-origin=[*], connection=[keep-alive], content-length=[50], content-type=[application/json], date=[Wed, 09 Apr 2025 01:43:29 GMT], server=[gunicorn/19.9.0]}
Response body:
{
  "authenticated": true, 
  "token": "global"
}
```
__WARNING__: This should only used for temporary debugging purposes. Leaving this option on in a production system could expose credentials/secrets in logs. <i>Authorization</i> headers are redacted by default and there is the ability to specify redacted header names via `SpeakeasyHTTPClient.setRedactedHeaders`.

__NOTE__: This is a convenience method that calls `HTTPClient.enableDebugLogging()`. The `SpeakeasyHTTPClient` honors this setting. If you are using a custom HTTP client, it is up to the custom client to honor this setting.

Another option is to set the System property `-Djdk.httpclient.HttpClient.log=all`. However, this second option does not log bodies.
<!-- End Debugging [debug] -->

<!-- Placeholder for Future Speakeasy SDK Sections -->

# Development

## Maturity

This SDK is in beta, and there may be breaking changes between versions without a major version update. Therefore, we recommend pinning usage
to a specific package version. This way, you can install the same version each time without breaking changes unless you are intentionally
looking for the latest version.

## Contributions

While we value open-source contributions to this SDK, this library is generated programmatically. Any manual changes added to internal files will be overwritten on the next generation. 
We look forward to hearing your feedback. Feel free to open a PR or an issue with a proof of concept and we'll do our best to include it in a future release. 

### SDK Created by [Speakeasy](https://www.speakeasy.com/?utm_source=openapi&utm_campaign=java)
