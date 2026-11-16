# Customers

## Overview

### Available Operations

* [create](#create) - Create customer
* [list](#list) - List customers
* [get](#get) - Get customer
* [update](#update) - Update customer
* [delete](#delete) - Delete customer
* [createPayment](#createpayment) - Create customer payment
* [listPayments](#listpayments) - List customer payments

## create

Creates a simple minimal representation of a customer. Payments, recurring mandates, and subscriptions can be linked
to this customer object, which simplifies management of recurring payments.

Once registered, customers will also appear in your Mollie dashboard.

### Example Usage

<!-- UsageSnippet language="java" operationID="create-customer" method="post" path="/v2/customers" example="create-customer-201-1" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.*;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.CreateCustomerResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        CreateCustomerResponse res = sdk.customers().create()
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .xClientSignature("MEUCIQDx8sJvK3z...")
                .xClientSignedAt("2025-01-01T12:00:00Z")
                .entityCustomer(EntityCustomer.builder()
                    .name("John Doe")
                    .email("example@email.com")
                    .locale(LocaleResponse.EN_US)
                    .testmode(false)
                    .build())
                .call();

        if (res.customerResponse().isPresent()) {
            System.out.println(res.customerResponse().get());
        }
    }
}
```

### Parameters

| Parameter                                                                                                                                                                               | Type                                                                                                                                                                                    | Required                                                                                                                                                                                | Description                                                                                                                                                                             | Example                                                                                                                                                                                 |
| --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `idempotencyKey`                                                                                                                                                                        | *Optional\<String>*                                                                                                                                                                     | :heavy_minus_sign:                                                                                                                                                                      | A unique key to ensure idempotent requests. This key should be a UUID v4 string.                                                                                                        | 123e4567-e89b-12d3-a456-426                                                                                                                                                             |
| `xClientSignature`                                                                                                                                                                      | *Optional\<String>*                                                                                                                                                                     | :heavy_minus_sign:                                                                                                                                                                      | A cryptographic signature of the request, used to verify that it was sent by you and hasn't been tampered with. Required if you've enabled request signing for your integration.        | MEUCIQDx8sJvK3z...                                                                                                                                                                      |
| `xClientSignedAt`                                                                                                                                                                       | *Optional\<String>*                                                                                                                                                                     | :heavy_minus_sign:                                                                                                                                                                      | The timestamp, in ISO 8601 format, at which you generated the `X-Client-Signature`. Required together with `X-Client-Signature` if you've enabled request signing for your integration. | 2025-01-01T12:00:00Z                                                                                                                                                                    |
| `entityCustomer`                                                                                                                                                                        | [Optional\<EntityCustomer>](../../models/components/EntityCustomer.md)                                                                                                                  | :heavy_minus_sign:                                                                                                                                                                      | N/A                                                                                                                                                                                     |                                                                                                                                                                                         |

### Response

**[CreateCustomerResponse](../../models/operations/CreateCustomerResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 404, 429                    | application/hal+json        |
| models/errors/APIException  | 4XX, 5XX                    | \*/\*                       |

## list

Retrieve a list of all customers.

The results are paginated.

### Example Usage

<!-- UsageSnippet language="java" operationID="list-customers" method="get" path="/v2/customers" example="list-customers" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.components.Sorting;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.ListCustomersRequest;
import com.mollie.mollie.models.operations.ListCustomersResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .testmode(false)
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        ListCustomersRequest req = ListCustomersRequest.builder()
                .from("cst_5B8cwPMGnU")
                .limit(50L)
                .sort(Sorting.DESC)
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .xClientSignature("MEUCIQDx8sJvK3z...")
                .xClientSignedAt("2025-01-01T12:00:00Z")
                .build();


        sdk.customers().list()
                .callAsStream()
                .forEach((ListCustomersResponse item) -> {
                   // handle page
                });

    }
}
```

### Parameters

| Parameter                                                               | Type                                                                    | Required                                                                | Description                                                             |
| ----------------------------------------------------------------------- | ----------------------------------------------------------------------- | ----------------------------------------------------------------------- | ----------------------------------------------------------------------- |
| `request`                                                               | [ListCustomersRequest](../../models/operations/ListCustomersRequest.md) | :heavy_check_mark:                                                      | The request object to use for the request.                              |

### Response

**[ListCustomersResponse](../../models/operations/ListCustomersResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 400, 404, 429               | application/hal+json        |
| models/errors/APIException  | 4XX, 5XX                    | \*/\*                       |

## get

Retrieve a single customer by its ID.

### Example Usage

<!-- UsageSnippet language="java" operationID="get-customer" method="get" path="/v2/customers/{customerId}" example="get-customer-200-1" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.GetCustomerRequest;
import com.mollie.mollie.models.operations.GetCustomerResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .testmode(false)
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        GetCustomerRequest req = GetCustomerRequest.builder()
                .customerId("cst_5B8cwPMGnU")
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .xClientSignature("MEUCIQDx8sJvK3z...")
                .xClientSignedAt("2025-01-01T12:00:00Z")
                .build();

        GetCustomerResponse res = sdk.customers().get()
                .request(req)
                .call();

        if (res.customerResponse().isPresent()) {
            System.out.println(res.customerResponse().get());
        }
    }
}
```

### Parameters

| Parameter                                                           | Type                                                                | Required                                                            | Description                                                         |
| ------------------------------------------------------------------- | ------------------------------------------------------------------- | ------------------------------------------------------------------- | ------------------------------------------------------------------- |
| `request`                                                           | [GetCustomerRequest](../../models/operations/GetCustomerRequest.md) | :heavy_check_mark:                                                  | The request object to use for the request.                          |

### Response

**[GetCustomerResponse](../../models/operations/GetCustomerResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 404, 429                    | application/hal+json        |
| models/errors/APIException  | 4XX, 5XX                    | \*/\*                       |

## update

Update an existing customer.

For an in-depth explanation of each parameter, refer to the [Create customer](create-customer) endpoint.

### Example Usage: update-customer-200-1

<!-- UsageSnippet language="java" operationID="update-customer" method="patch" path="/v2/customers/{customerId}" example="update-customer-200-1" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.LocaleResponse;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.*;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        UpdateCustomerRequest req = UpdateCustomerRequest.builder()
                .customerId("cst_5B8cwPMGnU")
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .xClientSignature("MEUCIQDx8sJvK3z...")
                .xClientSignedAt("2025-01-01T12:00:00Z")
                .requestBody(UpdateCustomerRequestBody.builder()
                    .name("John Doe")
                    .email("example@email.com")
                    .locale(LocaleResponse.EN_US)
                    .testmode(false)
                    .build())
                .build();

        UpdateCustomerResponse res = sdk.customers().update()
                .request(req)
                .call();

        if (res.customerResponse().isPresent()) {
            System.out.println(res.customerResponse().get());
        }
    }
}
```
### Example Usage: update-customer-200-2

<!-- UsageSnippet language="java" operationID="update-customer" method="patch" path="/v2/customers/{customerId}" example="update-customer-200-2" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.LocaleResponse;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.*;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        UpdateCustomerRequest req = UpdateCustomerRequest.builder()
                .customerId("cst_5B8cwPMGnU")
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .xClientSignature("MEUCIQDx8sJvK3z...")
                .xClientSignedAt("2025-01-01T12:00:00Z")
                .requestBody(UpdateCustomerRequestBody.builder()
                    .name("John Doe")
                    .email("example@email.com")
                    .locale(LocaleResponse.EN_US)
                    .testmode(false)
                    .build())
                .build();

        UpdateCustomerResponse res = sdk.customers().update()
                .request(req)
                .call();

        if (res.customerResponse().isPresent()) {
            System.out.println(res.customerResponse().get());
        }
    }
}
```

### Parameters

| Parameter                                                                 | Type                                                                      | Required                                                                  | Description                                                               |
| ------------------------------------------------------------------------- | ------------------------------------------------------------------------- | ------------------------------------------------------------------------- | ------------------------------------------------------------------------- |
| `request`                                                                 | [UpdateCustomerRequest](../../models/operations/UpdateCustomerRequest.md) | :heavy_check_mark:                                                        | The request object to use for the request.                                |

### Response

**[UpdateCustomerResponse](../../models/operations/UpdateCustomerResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 404, 429                    | application/hal+json        |
| models/errors/APIException  | 4XX, 5XX                    | \*/\*                       |

## delete

Delete a customer. All mandates and subscriptions created for this customer will be canceled as well.

### Example Usage

<!-- UsageSnippet language="java" operationID="delete-customer" method="delete" path="/v2/customers/{customerId}" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.*;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        DeleteCustomerRequest req = DeleteCustomerRequest.builder()
                .customerId("cst_5B8cwPMGnU")
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .xClientSignature("MEUCIQDx8sJvK3z...")
                .xClientSignedAt("2025-01-01T12:00:00Z")
                .requestBody(DeleteCustomerRequestBody.builder()
                    .testmode(false)
                    .build())
                .build();

        DeleteCustomerResponse res = sdk.customers().delete()
                .request(req)
                .call();

        // handle response
    }
}
```

### Parameters

| Parameter                                                                 | Type                                                                      | Required                                                                  | Description                                                               |
| ------------------------------------------------------------------------- | ------------------------------------------------------------------------- | ------------------------------------------------------------------------- | ------------------------------------------------------------------------- |
| `request`                                                                 | [DeleteCustomerRequest](../../models/operations/DeleteCustomerRequest.md) | :heavy_check_mark:                                                        | The request object to use for the request.                                |

### Response

**[DeleteCustomerResponse](../../models/operations/DeleteCustomerResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 404, 429                    | application/hal+json        |
| models/errors/APIException  | 4XX, 5XX                    | \*/\*                       |

## createPayment

Creates a payment for the customer.

Linking customers to payments enables you to:

* Keep track of payment preferences for your customers
* Allow your customers to charge a previously used credit card with a single click in our hosted checkout
* Improve payment insights in the Mollie dashboard
* Use recurring payments

This endpoint is effectively an alias of the [Create payment endpoint](create-payment) with the `customerId`
parameter predefined.

### Example Usage: create-payment-201-1

<!-- UsageSnippet language="java" operationID="create-customer-payment" method="post" path="/v2/customers/{customerId}/payments" example="create-payment-201-1" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.*;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.CreateCustomerPaymentRequest;
import com.mollie.mollie.models.operations.CreateCustomerPaymentResponse;
import java.lang.Exception;
import java.time.LocalDate;
import java.util.List;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        CreateCustomerPaymentRequest req = CreateCustomerPaymentRequest.builder()
                .customerId("cst_5B8cwPMGnU")
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .xClientSignature("MEUCIQDx8sJvK3z...")
                .xClientSignedAt("2025-01-01T12:00:00Z")
                .paymentRequest(PaymentRequest.builder()
                    .description("Chess Board")
                    .amount(Amount.builder()
                        .currency("EUR")
                        .value("10.00")
                        .build())
                    .redirectUrl("https://example.org/redirect")
                    .cancelUrl("https://example.org/cancel")
                    .webhookUrl("https://example.org/webhooks")
                    .lines(List.of(
                        PaymentRequestLines.builder()
                            .description("LEGO 4440 Forest Police Station")
                            .quantity(1L)
                            .unitPrice(Amount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .totalAmount(Amount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .type(PaymentLineType.PHYSICAL)
                            .quantityUnit("pcs")
                            .discountAmount(Amount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .vatRate("21.00")
                            .vatAmount(Amount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .sku("9780241661628")
                            .categories(List.of(
                                LineCategories.MEAL,
                                LineCategories.ECO))
                            .imageUrl("https://...")
                            .productUrl("https://...")
                            .recurring(RecurringLineItem.builder()
                                .interval("... months")
                                .description("Gym subscription")
                                .amount(Amount.builder()
                                    .currency("EUR")
                                    .value("10.00")
                                    .build())
                                .times(1L)
                                .startDate("2024-12-12")
                                .build())
                            .build()))
                    .billingAddress(PaymentRequestBillingAddress.builder()
                        .title("Mr.")
                        .givenName("Piet")
                        .familyName("Mondriaan")
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
                    .locale(Locale2.EN_US)
                    .method(PaymentRequestMethod.of(Method.IDEAL))
                    .issuer("ideal_INGBNL2A")
                    .restrictPaymentMethodsToCountry("NL")
                    .captureMode(CaptureMode.MANUAL)
                    .captureDelay("8 hours")
                    .applicationFee(PaymentRequestApplicationFee.builder()
                        .amount(Amount.builder()
                            .currency("EUR")
                            .value("10.00")
                            .build())
                        .description("10")
                        .build())
                    .routing(List.of(
                        EntityPaymentRoute.builder()
                            .amount(Amount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .destination(EntityPaymentRouteDestination.builder()
                                .type(RouteDestinationType.ORGANIZATION)
                                .organizationId("org_1234567")
                                .build())
                            .releaseDate("2024-12-12")
                            .build(),
                        EntityPaymentRoute.builder()
                            .amount(Amount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .destination(EntityPaymentRouteDestination.builder()
                                .type(RouteDestinationType.ORGANIZATION)
                                .organizationId("org_1234567")
                                .build())
                            .releaseDate("2024-12-12")
                            .build()))
                    .sequenceType(SequenceType.ONEOFF)
                    .mandateId("mdt_5B8cwPMGnU")
                    .customerId("cst_5B8cwPMGnU")
                    .profileId("pfl_5B8cwPMGnU")
                    .dueDate("2025-01-01")
                    .storeCredentials(true)
                    .testmode(false)
                    .applePayPaymentToken("{\"paymentData\": {\"version\": \"EC_v1\", \"data\": \"vK3BbrCbI/....\"}}")
                    .company(Company.builder()
                        .registrationNumber("12345678")
                        .vatNumber("NL123456789B01")
                        .build())
                    .cardToken("tkn_12345")
                    .googlePayPaymentToken("{\"signature\": \"MEYCIQCv...\", \"protocolVersion\": \"ECv2\", \"signedMessage\": \"{\\\"encryptedMessage\\\":\\\"...\\\",\\\"ephemeralPublicKey\\\":\\\"...\\\",\\\"tag\\\":\\\"...\\\"}\"}")
                    .voucherNumber("1234567890")
                    .voucherPin("1234")
                    .consumerDateOfBirth(LocalDate.parse("2000-01-01"))
                    .digitalGoods(true)
                    .customerReference("1234567890")
                    .terminalId("term_1234567890")
                    .build())
                .build();

        CreateCustomerPaymentResponse res = sdk.customers().createPayment()
                .request(req)
                .call();

        if (res.paymentResponse().isPresent()) {
            System.out.println(res.paymentResponse().get());
        }
    }
}
```
### Example Usage: create-payment-201-10

<!-- UsageSnippet language="java" operationID="create-customer-payment" method="post" path="/v2/customers/{customerId}/payments" example="create-payment-201-10" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.*;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.CreateCustomerPaymentRequest;
import com.mollie.mollie.models.operations.CreateCustomerPaymentResponse;
import java.lang.Exception;
import java.time.LocalDate;
import java.util.List;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        CreateCustomerPaymentRequest req = CreateCustomerPaymentRequest.builder()
                .customerId("cst_5B8cwPMGnU")
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .xClientSignature("MEUCIQDx8sJvK3z...")
                .xClientSignedAt("2025-01-01T12:00:00Z")
                .paymentRequest(PaymentRequest.builder()
                    .description("Chess Board")
                    .amount(Amount.builder()
                        .currency("EUR")
                        .value("10.00")
                        .build())
                    .redirectUrl("https://example.org/redirect")
                    .cancelUrl("https://example.org/cancel")
                    .webhookUrl("https://example.org/webhooks")
                    .lines(List.of(
                        PaymentRequestLines.builder()
                            .description("LEGO 4440 Forest Police Station")
                            .quantity(1L)
                            .unitPrice(Amount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .totalAmount(Amount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .type(PaymentLineType.PHYSICAL)
                            .quantityUnit("pcs")
                            .discountAmount(Amount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .vatRate("21.00")
                            .vatAmount(Amount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .sku("9780241661628")
                            .categories(List.of(
                                LineCategories.MEAL,
                                LineCategories.ECO))
                            .imageUrl("https://...")
                            .productUrl("https://...")
                            .recurring(RecurringLineItem.builder()
                                .interval("... months")
                                .description("Gym subscription")
                                .amount(Amount.builder()
                                    .currency("EUR")
                                    .value("10.00")
                                    .build())
                                .times(1L)
                                .startDate("2024-12-12")
                                .build())
                            .build()))
                    .billingAddress(PaymentRequestBillingAddress.builder()
                        .title("Mr.")
                        .givenName("Piet")
                        .familyName("Mondriaan")
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
                    .locale(Locale2.EN_US)
                    .method(PaymentRequestMethod.of(Method.IDEAL))
                    .issuer("ideal_INGBNL2A")
                    .restrictPaymentMethodsToCountry("NL")
                    .captureMode(CaptureMode.MANUAL)
                    .captureDelay("8 hours")
                    .applicationFee(PaymentRequestApplicationFee.builder()
                        .amount(Amount.builder()
                            .currency("EUR")
                            .value("10.00")
                            .build())
                        .description("10")
                        .build())
                    .routing(List.of(
                        EntityPaymentRoute.builder()
                            .amount(Amount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .destination(EntityPaymentRouteDestination.builder()
                                .type(RouteDestinationType.ORGANIZATION)
                                .organizationId("org_1234567")
                                .build())
                            .releaseDate("2024-12-12")
                            .build(),
                        EntityPaymentRoute.builder()
                            .amount(Amount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .destination(EntityPaymentRouteDestination.builder()
                                .type(RouteDestinationType.ORGANIZATION)
                                .organizationId("org_1234567")
                                .build())
                            .releaseDate("2024-12-12")
                            .build()))
                    .sequenceType(SequenceType.ONEOFF)
                    .mandateId("mdt_5B8cwPMGnU")
                    .customerId("cst_5B8cwPMGnU")
                    .profileId("pfl_5B8cwPMGnU")
                    .dueDate("2025-01-01")
                    .storeCredentials(true)
                    .testmode(false)
                    .applePayPaymentToken("{\"paymentData\": {\"version\": \"EC_v1\", \"data\": \"vK3BbrCbI/....\"}}")
                    .company(Company.builder()
                        .registrationNumber("12345678")
                        .vatNumber("NL123456789B01")
                        .build())
                    .cardToken("tkn_12345")
                    .googlePayPaymentToken("{\"signature\": \"MEYCIQCv...\", \"protocolVersion\": \"ECv2\", \"signedMessage\": \"{\\\"encryptedMessage\\\":\\\"...\\\",\\\"ephemeralPublicKey\\\":\\\"...\\\",\\\"tag\\\":\\\"...\\\"}\"}")
                    .voucherNumber("1234567890")
                    .voucherPin("1234")
                    .consumerDateOfBirth(LocalDate.parse("2000-01-01"))
                    .digitalGoods(true)
                    .customerReference("1234567890")
                    .terminalId("term_1234567890")
                    .build())
                .build();

        CreateCustomerPaymentResponse res = sdk.customers().createPayment()
                .request(req)
                .call();

        if (res.paymentResponse().isPresent()) {
            System.out.println(res.paymentResponse().get());
        }
    }
}
```
### Example Usage: create-payment-201-11

<!-- UsageSnippet language="java" operationID="create-customer-payment" method="post" path="/v2/customers/{customerId}/payments" example="create-payment-201-11" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.*;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.CreateCustomerPaymentRequest;
import com.mollie.mollie.models.operations.CreateCustomerPaymentResponse;
import java.lang.Exception;
import java.time.LocalDate;
import java.util.List;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        CreateCustomerPaymentRequest req = CreateCustomerPaymentRequest.builder()
                .customerId("cst_5B8cwPMGnU")
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .xClientSignature("MEUCIQDx8sJvK3z...")
                .xClientSignedAt("2025-01-01T12:00:00Z")
                .paymentRequest(PaymentRequest.builder()
                    .description("Chess Board")
                    .amount(Amount.builder()
                        .currency("EUR")
                        .value("10.00")
                        .build())
                    .redirectUrl("https://example.org/redirect")
                    .cancelUrl("https://example.org/cancel")
                    .webhookUrl("https://example.org/webhooks")
                    .lines(List.of(
                        PaymentRequestLines.builder()
                            .description("LEGO 4440 Forest Police Station")
                            .quantity(1L)
                            .unitPrice(Amount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .totalAmount(Amount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .type(PaymentLineType.PHYSICAL)
                            .quantityUnit("pcs")
                            .discountAmount(Amount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .vatRate("21.00")
                            .vatAmount(Amount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .sku("9780241661628")
                            .categories(List.of(
                                LineCategories.MEAL,
                                LineCategories.ECO))
                            .imageUrl("https://...")
                            .productUrl("https://...")
                            .recurring(RecurringLineItem.builder()
                                .interval("... months")
                                .description("Gym subscription")
                                .amount(Amount.builder()
                                    .currency("EUR")
                                    .value("10.00")
                                    .build())
                                .times(1L)
                                .startDate("2024-12-12")
                                .build())
                            .build()))
                    .billingAddress(PaymentRequestBillingAddress.builder()
                        .title("Mr.")
                        .givenName("Piet")
                        .familyName("Mondriaan")
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
                    .locale(Locale2.EN_US)
                    .method(PaymentRequestMethod.of(Method.IDEAL))
                    .issuer("ideal_INGBNL2A")
                    .restrictPaymentMethodsToCountry("NL")
                    .captureMode(CaptureMode.MANUAL)
                    .captureDelay("8 hours")
                    .applicationFee(PaymentRequestApplicationFee.builder()
                        .amount(Amount.builder()
                            .currency("EUR")
                            .value("10.00")
                            .build())
                        .description("10")
                        .build())
                    .routing(List.of(
                        EntityPaymentRoute.builder()
                            .amount(Amount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .destination(EntityPaymentRouteDestination.builder()
                                .type(RouteDestinationType.ORGANIZATION)
                                .organizationId("org_1234567")
                                .build())
                            .releaseDate("2024-12-12")
                            .build(),
                        EntityPaymentRoute.builder()
                            .amount(Amount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .destination(EntityPaymentRouteDestination.builder()
                                .type(RouteDestinationType.ORGANIZATION)
                                .organizationId("org_1234567")
                                .build())
                            .releaseDate("2024-12-12")
                            .build()))
                    .sequenceType(SequenceType.ONEOFF)
                    .mandateId("mdt_5B8cwPMGnU")
                    .customerId("cst_5B8cwPMGnU")
                    .profileId("pfl_5B8cwPMGnU")
                    .dueDate("2025-01-01")
                    .storeCredentials(true)
                    .testmode(false)
                    .applePayPaymentToken("{\"paymentData\": {\"version\": \"EC_v1\", \"data\": \"vK3BbrCbI/....\"}}")
                    .company(Company.builder()
                        .registrationNumber("12345678")
                        .vatNumber("NL123456789B01")
                        .build())
                    .cardToken("tkn_12345")
                    .googlePayPaymentToken("{\"signature\": \"MEYCIQCv...\", \"protocolVersion\": \"ECv2\", \"signedMessage\": \"{\\\"encryptedMessage\\\":\\\"...\\\",\\\"ephemeralPublicKey\\\":\\\"...\\\",\\\"tag\\\":\\\"...\\\"}\"}")
                    .voucherNumber("1234567890")
                    .voucherPin("1234")
                    .consumerDateOfBirth(LocalDate.parse("2000-01-01"))
                    .digitalGoods(true)
                    .customerReference("1234567890")
                    .terminalId("term_1234567890")
                    .build())
                .build();

        CreateCustomerPaymentResponse res = sdk.customers().createPayment()
                .request(req)
                .call();

        if (res.paymentResponse().isPresent()) {
            System.out.println(res.paymentResponse().get());
        }
    }
}
```
### Example Usage: create-payment-201-12

<!-- UsageSnippet language="java" operationID="create-customer-payment" method="post" path="/v2/customers/{customerId}/payments" example="create-payment-201-12" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.*;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.CreateCustomerPaymentRequest;
import com.mollie.mollie.models.operations.CreateCustomerPaymentResponse;
import java.lang.Exception;
import java.time.LocalDate;
import java.util.List;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        CreateCustomerPaymentRequest req = CreateCustomerPaymentRequest.builder()
                .customerId("cst_5B8cwPMGnU")
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .xClientSignature("MEUCIQDx8sJvK3z...")
                .xClientSignedAt("2025-01-01T12:00:00Z")
                .paymentRequest(PaymentRequest.builder()
                    .description("Chess Board")
                    .amount(Amount.builder()
                        .currency("EUR")
                        .value("10.00")
                        .build())
                    .redirectUrl("https://example.org/redirect")
                    .cancelUrl("https://example.org/cancel")
                    .webhookUrl("https://example.org/webhooks")
                    .lines(List.of(
                        PaymentRequestLines.builder()
                            .description("LEGO 4440 Forest Police Station")
                            .quantity(1L)
                            .unitPrice(Amount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .totalAmount(Amount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .type(PaymentLineType.PHYSICAL)
                            .quantityUnit("pcs")
                            .discountAmount(Amount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .vatRate("21.00")
                            .vatAmount(Amount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .sku("9780241661628")
                            .categories(List.of(
                                LineCategories.MEAL,
                                LineCategories.ECO))
                            .imageUrl("https://...")
                            .productUrl("https://...")
                            .recurring(RecurringLineItem.builder()
                                .interval("... months")
                                .description("Gym subscription")
                                .amount(Amount.builder()
                                    .currency("EUR")
                                    .value("10.00")
                                    .build())
                                .times(1L)
                                .startDate("2024-12-12")
                                .build())
                            .build()))
                    .billingAddress(PaymentRequestBillingAddress.builder()
                        .title("Mr.")
                        .givenName("Piet")
                        .familyName("Mondriaan")
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
                    .locale(Locale2.EN_US)
                    .method(PaymentRequestMethod.of(Method.IDEAL))
                    .issuer("ideal_INGBNL2A")
                    .restrictPaymentMethodsToCountry("NL")
                    .captureMode(CaptureMode.MANUAL)
                    .captureDelay("8 hours")
                    .applicationFee(PaymentRequestApplicationFee.builder()
                        .amount(Amount.builder()
                            .currency("EUR")
                            .value("10.00")
                            .build())
                        .description("10")
                        .build())
                    .routing(List.of(
                        EntityPaymentRoute.builder()
                            .amount(Amount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .destination(EntityPaymentRouteDestination.builder()
                                .type(RouteDestinationType.ORGANIZATION)
                                .organizationId("org_1234567")
                                .build())
                            .releaseDate("2024-12-12")
                            .build(),
                        EntityPaymentRoute.builder()
                            .amount(Amount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .destination(EntityPaymentRouteDestination.builder()
                                .type(RouteDestinationType.ORGANIZATION)
                                .organizationId("org_1234567")
                                .build())
                            .releaseDate("2024-12-12")
                            .build()))
                    .sequenceType(SequenceType.ONEOFF)
                    .mandateId("mdt_5B8cwPMGnU")
                    .customerId("cst_5B8cwPMGnU")
                    .profileId("pfl_5B8cwPMGnU")
                    .dueDate("2025-01-01")
                    .storeCredentials(true)
                    .testmode(false)
                    .applePayPaymentToken("{\"paymentData\": {\"version\": \"EC_v1\", \"data\": \"vK3BbrCbI/....\"}}")
                    .company(Company.builder()
                        .registrationNumber("12345678")
                        .vatNumber("NL123456789B01")
                        .build())
                    .cardToken("tkn_12345")
                    .googlePayPaymentToken("{\"signature\": \"MEYCIQCv...\", \"protocolVersion\": \"ECv2\", \"signedMessage\": \"{\\\"encryptedMessage\\\":\\\"...\\\",\\\"ephemeralPublicKey\\\":\\\"...\\\",\\\"tag\\\":\\\"...\\\"}\"}")
                    .voucherNumber("1234567890")
                    .voucherPin("1234")
                    .consumerDateOfBirth(LocalDate.parse("2000-01-01"))
                    .digitalGoods(true)
                    .customerReference("1234567890")
                    .terminalId("term_1234567890")
                    .build())
                .build();

        CreateCustomerPaymentResponse res = sdk.customers().createPayment()
                .request(req)
                .call();

        if (res.paymentResponse().isPresent()) {
            System.out.println(res.paymentResponse().get());
        }
    }
}
```
### Example Usage: create-payment-201-13

<!-- UsageSnippet language="java" operationID="create-customer-payment" method="post" path="/v2/customers/{customerId}/payments" example="create-payment-201-13" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.*;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.CreateCustomerPaymentRequest;
import com.mollie.mollie.models.operations.CreateCustomerPaymentResponse;
import java.lang.Exception;
import java.time.LocalDate;
import java.util.List;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        CreateCustomerPaymentRequest req = CreateCustomerPaymentRequest.builder()
                .customerId("cst_5B8cwPMGnU")
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .xClientSignature("MEUCIQDx8sJvK3z...")
                .xClientSignedAt("2025-01-01T12:00:00Z")
                .paymentRequest(PaymentRequest.builder()
                    .description("Chess Board")
                    .amount(Amount.builder()
                        .currency("EUR")
                        .value("10.00")
                        .build())
                    .redirectUrl("https://example.org/redirect")
                    .cancelUrl("https://example.org/cancel")
                    .webhookUrl("https://example.org/webhooks")
                    .lines(List.of(
                        PaymentRequestLines.builder()
                            .description("LEGO 4440 Forest Police Station")
                            .quantity(1L)
                            .unitPrice(Amount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .totalAmount(Amount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .type(PaymentLineType.PHYSICAL)
                            .quantityUnit("pcs")
                            .discountAmount(Amount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .vatRate("21.00")
                            .vatAmount(Amount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .sku("9780241661628")
                            .categories(List.of(
                                LineCategories.MEAL,
                                LineCategories.ECO))
                            .imageUrl("https://...")
                            .productUrl("https://...")
                            .recurring(RecurringLineItem.builder()
                                .interval("... months")
                                .description("Gym subscription")
                                .amount(Amount.builder()
                                    .currency("EUR")
                                    .value("10.00")
                                    .build())
                                .times(1L)
                                .startDate("2024-12-12")
                                .build())
                            .build()))
                    .billingAddress(PaymentRequestBillingAddress.builder()
                        .title("Mr.")
                        .givenName("Piet")
                        .familyName("Mondriaan")
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
                    .locale(Locale2.EN_US)
                    .method(PaymentRequestMethod.of(Method.IDEAL))
                    .issuer("ideal_INGBNL2A")
                    .restrictPaymentMethodsToCountry("NL")
                    .captureMode(CaptureMode.MANUAL)
                    .captureDelay("8 hours")
                    .applicationFee(PaymentRequestApplicationFee.builder()
                        .amount(Amount.builder()
                            .currency("EUR")
                            .value("10.00")
                            .build())
                        .description("10")
                        .build())
                    .routing(List.of(
                        EntityPaymentRoute.builder()
                            .amount(Amount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .destination(EntityPaymentRouteDestination.builder()
                                .type(RouteDestinationType.ORGANIZATION)
                                .organizationId("org_1234567")
                                .build())
                            .releaseDate("2024-12-12")
                            .build(),
                        EntityPaymentRoute.builder()
                            .amount(Amount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .destination(EntityPaymentRouteDestination.builder()
                                .type(RouteDestinationType.ORGANIZATION)
                                .organizationId("org_1234567")
                                .build())
                            .releaseDate("2024-12-12")
                            .build()))
                    .sequenceType(SequenceType.ONEOFF)
                    .mandateId("mdt_5B8cwPMGnU")
                    .customerId("cst_5B8cwPMGnU")
                    .profileId("pfl_5B8cwPMGnU")
                    .dueDate("2025-01-01")
                    .storeCredentials(true)
                    .testmode(false)
                    .applePayPaymentToken("{\"paymentData\": {\"version\": \"EC_v1\", \"data\": \"vK3BbrCbI/....\"}}")
                    .company(Company.builder()
                        .registrationNumber("12345678")
                        .vatNumber("NL123456789B01")
                        .build())
                    .cardToken("tkn_12345")
                    .googlePayPaymentToken("{\"signature\": \"MEYCIQCv...\", \"protocolVersion\": \"ECv2\", \"signedMessage\": \"{\\\"encryptedMessage\\\":\\\"...\\\",\\\"ephemeralPublicKey\\\":\\\"...\\\",\\\"tag\\\":\\\"...\\\"}\"}")
                    .voucherNumber("1234567890")
                    .voucherPin("1234")
                    .consumerDateOfBirth(LocalDate.parse("2000-01-01"))
                    .digitalGoods(true)
                    .customerReference("1234567890")
                    .terminalId("term_1234567890")
                    .build())
                .build();

        CreateCustomerPaymentResponse res = sdk.customers().createPayment()
                .request(req)
                .call();

        if (res.paymentResponse().isPresent()) {
            System.out.println(res.paymentResponse().get());
        }
    }
}
```
### Example Usage: create-payment-201-2

<!-- UsageSnippet language="java" operationID="create-customer-payment" method="post" path="/v2/customers/{customerId}/payments" example="create-payment-201-2" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.*;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.CreateCustomerPaymentRequest;
import com.mollie.mollie.models.operations.CreateCustomerPaymentResponse;
import java.lang.Exception;
import java.time.LocalDate;
import java.util.List;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        CreateCustomerPaymentRequest req = CreateCustomerPaymentRequest.builder()
                .customerId("cst_5B8cwPMGnU")
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .xClientSignature("MEUCIQDx8sJvK3z...")
                .xClientSignedAt("2025-01-01T12:00:00Z")
                .paymentRequest(PaymentRequest.builder()
                    .description("Chess Board")
                    .amount(Amount.builder()
                        .currency("EUR")
                        .value("10.00")
                        .build())
                    .redirectUrl("https://example.org/redirect")
                    .cancelUrl("https://example.org/cancel")
                    .webhookUrl("https://example.org/webhooks")
                    .lines(List.of(
                        PaymentRequestLines.builder()
                            .description("LEGO 4440 Forest Police Station")
                            .quantity(1L)
                            .unitPrice(Amount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .totalAmount(Amount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .type(PaymentLineType.PHYSICAL)
                            .quantityUnit("pcs")
                            .discountAmount(Amount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .vatRate("21.00")
                            .vatAmount(Amount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .sku("9780241661628")
                            .categories(List.of(
                                LineCategories.MEAL,
                                LineCategories.ECO))
                            .imageUrl("https://...")
                            .productUrl("https://...")
                            .recurring(RecurringLineItem.builder()
                                .interval("... months")
                                .description("Gym subscription")
                                .amount(Amount.builder()
                                    .currency("EUR")
                                    .value("10.00")
                                    .build())
                                .times(1L)
                                .startDate("2024-12-12")
                                .build())
                            .build()))
                    .billingAddress(PaymentRequestBillingAddress.builder()
                        .title("Mr.")
                        .givenName("Piet")
                        .familyName("Mondriaan")
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
                    .locale(Locale2.EN_US)
                    .method(PaymentRequestMethod.of(Method.IDEAL))
                    .issuer("ideal_INGBNL2A")
                    .restrictPaymentMethodsToCountry("NL")
                    .captureMode(CaptureMode.MANUAL)
                    .captureDelay("8 hours")
                    .applicationFee(PaymentRequestApplicationFee.builder()
                        .amount(Amount.builder()
                            .currency("EUR")
                            .value("10.00")
                            .build())
                        .description("10")
                        .build())
                    .routing(List.of(
                        EntityPaymentRoute.builder()
                            .amount(Amount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .destination(EntityPaymentRouteDestination.builder()
                                .type(RouteDestinationType.ORGANIZATION)
                                .organizationId("org_1234567")
                                .build())
                            .releaseDate("2024-12-12")
                            .build(),
                        EntityPaymentRoute.builder()
                            .amount(Amount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .destination(EntityPaymentRouteDestination.builder()
                                .type(RouteDestinationType.ORGANIZATION)
                                .organizationId("org_1234567")
                                .build())
                            .releaseDate("2024-12-12")
                            .build()))
                    .sequenceType(SequenceType.ONEOFF)
                    .mandateId("mdt_5B8cwPMGnU")
                    .customerId("cst_5B8cwPMGnU")
                    .profileId("pfl_5B8cwPMGnU")
                    .dueDate("2025-01-01")
                    .storeCredentials(true)
                    .testmode(false)
                    .applePayPaymentToken("{\"paymentData\": {\"version\": \"EC_v1\", \"data\": \"vK3BbrCbI/....\"}}")
                    .company(Company.builder()
                        .registrationNumber("12345678")
                        .vatNumber("NL123456789B01")
                        .build())
                    .cardToken("tkn_12345")
                    .googlePayPaymentToken("{\"signature\": \"MEYCIQCv...\", \"protocolVersion\": \"ECv2\", \"signedMessage\": \"{\\\"encryptedMessage\\\":\\\"...\\\",\\\"ephemeralPublicKey\\\":\\\"...\\\",\\\"tag\\\":\\\"...\\\"}\"}")
                    .voucherNumber("1234567890")
                    .voucherPin("1234")
                    .consumerDateOfBirth(LocalDate.parse("2000-01-01"))
                    .digitalGoods(true)
                    .customerReference("1234567890")
                    .terminalId("term_1234567890")
                    .build())
                .build();

        CreateCustomerPaymentResponse res = sdk.customers().createPayment()
                .request(req)
                .call();

        if (res.paymentResponse().isPresent()) {
            System.out.println(res.paymentResponse().get());
        }
    }
}
```
### Example Usage: create-payment-201-3

<!-- UsageSnippet language="java" operationID="create-customer-payment" method="post" path="/v2/customers/{customerId}/payments" example="create-payment-201-3" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.*;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.CreateCustomerPaymentRequest;
import com.mollie.mollie.models.operations.CreateCustomerPaymentResponse;
import java.lang.Exception;
import java.time.LocalDate;
import java.util.List;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        CreateCustomerPaymentRequest req = CreateCustomerPaymentRequest.builder()
                .customerId("cst_5B8cwPMGnU")
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .xClientSignature("MEUCIQDx8sJvK3z...")
                .xClientSignedAt("2025-01-01T12:00:00Z")
                .paymentRequest(PaymentRequest.builder()
                    .description("Chess Board")
                    .amount(Amount.builder()
                        .currency("EUR")
                        .value("10.00")
                        .build())
                    .redirectUrl("https://example.org/redirect")
                    .cancelUrl("https://example.org/cancel")
                    .webhookUrl("https://example.org/webhooks")
                    .lines(List.of(
                        PaymentRequestLines.builder()
                            .description("LEGO 4440 Forest Police Station")
                            .quantity(1L)
                            .unitPrice(Amount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .totalAmount(Amount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .type(PaymentLineType.PHYSICAL)
                            .quantityUnit("pcs")
                            .discountAmount(Amount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .vatRate("21.00")
                            .vatAmount(Amount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .sku("9780241661628")
                            .categories(List.of(
                                LineCategories.MEAL,
                                LineCategories.ECO))
                            .imageUrl("https://...")
                            .productUrl("https://...")
                            .recurring(RecurringLineItem.builder()
                                .interval("... months")
                                .description("Gym subscription")
                                .amount(Amount.builder()
                                    .currency("EUR")
                                    .value("10.00")
                                    .build())
                                .times(1L)
                                .startDate("2024-12-12")
                                .build())
                            .build()))
                    .billingAddress(PaymentRequestBillingAddress.builder()
                        .title("Mr.")
                        .givenName("Piet")
                        .familyName("Mondriaan")
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
                    .locale(Locale2.EN_US)
                    .method(PaymentRequestMethod.of(Method.IDEAL))
                    .issuer("ideal_INGBNL2A")
                    .restrictPaymentMethodsToCountry("NL")
                    .captureMode(CaptureMode.MANUAL)
                    .captureDelay("8 hours")
                    .applicationFee(PaymentRequestApplicationFee.builder()
                        .amount(Amount.builder()
                            .currency("EUR")
                            .value("10.00")
                            .build())
                        .description("10")
                        .build())
                    .routing(List.of(
                        EntityPaymentRoute.builder()
                            .amount(Amount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .destination(EntityPaymentRouteDestination.builder()
                                .type(RouteDestinationType.ORGANIZATION)
                                .organizationId("org_1234567")
                                .build())
                            .releaseDate("2024-12-12")
                            .build(),
                        EntityPaymentRoute.builder()
                            .amount(Amount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .destination(EntityPaymentRouteDestination.builder()
                                .type(RouteDestinationType.ORGANIZATION)
                                .organizationId("org_1234567")
                                .build())
                            .releaseDate("2024-12-12")
                            .build()))
                    .sequenceType(SequenceType.ONEOFF)
                    .mandateId("mdt_5B8cwPMGnU")
                    .customerId("cst_5B8cwPMGnU")
                    .profileId("pfl_5B8cwPMGnU")
                    .dueDate("2025-01-01")
                    .storeCredentials(true)
                    .testmode(false)
                    .applePayPaymentToken("{\"paymentData\": {\"version\": \"EC_v1\", \"data\": \"vK3BbrCbI/....\"}}")
                    .company(Company.builder()
                        .registrationNumber("12345678")
                        .vatNumber("NL123456789B01")
                        .build())
                    .cardToken("tkn_12345")
                    .googlePayPaymentToken("{\"signature\": \"MEYCIQCv...\", \"protocolVersion\": \"ECv2\", \"signedMessage\": \"{\\\"encryptedMessage\\\":\\\"...\\\",\\\"ephemeralPublicKey\\\":\\\"...\\\",\\\"tag\\\":\\\"...\\\"}\"}")
                    .voucherNumber("1234567890")
                    .voucherPin("1234")
                    .consumerDateOfBirth(LocalDate.parse("2000-01-01"))
                    .digitalGoods(true)
                    .customerReference("1234567890")
                    .terminalId("term_1234567890")
                    .build())
                .build();

        CreateCustomerPaymentResponse res = sdk.customers().createPayment()
                .request(req)
                .call();

        if (res.paymentResponse().isPresent()) {
            System.out.println(res.paymentResponse().get());
        }
    }
}
```
### Example Usage: create-payment-201-4

<!-- UsageSnippet language="java" operationID="create-customer-payment" method="post" path="/v2/customers/{customerId}/payments" example="create-payment-201-4" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.*;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.CreateCustomerPaymentRequest;
import com.mollie.mollie.models.operations.CreateCustomerPaymentResponse;
import java.lang.Exception;
import java.time.LocalDate;
import java.util.List;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        CreateCustomerPaymentRequest req = CreateCustomerPaymentRequest.builder()
                .customerId("cst_5B8cwPMGnU")
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .xClientSignature("MEUCIQDx8sJvK3z...")
                .xClientSignedAt("2025-01-01T12:00:00Z")
                .paymentRequest(PaymentRequest.builder()
                    .description("Chess Board")
                    .amount(Amount.builder()
                        .currency("EUR")
                        .value("10.00")
                        .build())
                    .redirectUrl("https://example.org/redirect")
                    .cancelUrl("https://example.org/cancel")
                    .webhookUrl("https://example.org/webhooks")
                    .lines(List.of(
                        PaymentRequestLines.builder()
                            .description("LEGO 4440 Forest Police Station")
                            .quantity(1L)
                            .unitPrice(Amount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .totalAmount(Amount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .type(PaymentLineType.PHYSICAL)
                            .quantityUnit("pcs")
                            .discountAmount(Amount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .vatRate("21.00")
                            .vatAmount(Amount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .sku("9780241661628")
                            .categories(List.of(
                                LineCategories.MEAL,
                                LineCategories.ECO))
                            .imageUrl("https://...")
                            .productUrl("https://...")
                            .recurring(RecurringLineItem.builder()
                                .interval("... months")
                                .description("Gym subscription")
                                .amount(Amount.builder()
                                    .currency("EUR")
                                    .value("10.00")
                                    .build())
                                .times(1L)
                                .startDate("2024-12-12")
                                .build())
                            .build()))
                    .billingAddress(PaymentRequestBillingAddress.builder()
                        .title("Mr.")
                        .givenName("Piet")
                        .familyName("Mondriaan")
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
                    .locale(Locale2.EN_US)
                    .method(PaymentRequestMethod.of(Method.IDEAL))
                    .issuer("ideal_INGBNL2A")
                    .restrictPaymentMethodsToCountry("NL")
                    .captureMode(CaptureMode.MANUAL)
                    .captureDelay("8 hours")
                    .applicationFee(PaymentRequestApplicationFee.builder()
                        .amount(Amount.builder()
                            .currency("EUR")
                            .value("10.00")
                            .build())
                        .description("10")
                        .build())
                    .routing(List.of(
                        EntityPaymentRoute.builder()
                            .amount(Amount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .destination(EntityPaymentRouteDestination.builder()
                                .type(RouteDestinationType.ORGANIZATION)
                                .organizationId("org_1234567")
                                .build())
                            .releaseDate("2024-12-12")
                            .build(),
                        EntityPaymentRoute.builder()
                            .amount(Amount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .destination(EntityPaymentRouteDestination.builder()
                                .type(RouteDestinationType.ORGANIZATION)
                                .organizationId("org_1234567")
                                .build())
                            .releaseDate("2024-12-12")
                            .build()))
                    .sequenceType(SequenceType.ONEOFF)
                    .mandateId("mdt_5B8cwPMGnU")
                    .customerId("cst_5B8cwPMGnU")
                    .profileId("pfl_5B8cwPMGnU")
                    .dueDate("2025-01-01")
                    .storeCredentials(true)
                    .testmode(false)
                    .applePayPaymentToken("{\"paymentData\": {\"version\": \"EC_v1\", \"data\": \"vK3BbrCbI/....\"}}")
                    .company(Company.builder()
                        .registrationNumber("12345678")
                        .vatNumber("NL123456789B01")
                        .build())
                    .cardToken("tkn_12345")
                    .googlePayPaymentToken("{\"signature\": \"MEYCIQCv...\", \"protocolVersion\": \"ECv2\", \"signedMessage\": \"{\\\"encryptedMessage\\\":\\\"...\\\",\\\"ephemeralPublicKey\\\":\\\"...\\\",\\\"tag\\\":\\\"...\\\"}\"}")
                    .voucherNumber("1234567890")
                    .voucherPin("1234")
                    .consumerDateOfBirth(LocalDate.parse("2000-01-01"))
                    .digitalGoods(true)
                    .customerReference("1234567890")
                    .terminalId("term_1234567890")
                    .build())
                .build();

        CreateCustomerPaymentResponse res = sdk.customers().createPayment()
                .request(req)
                .call();

        if (res.paymentResponse().isPresent()) {
            System.out.println(res.paymentResponse().get());
        }
    }
}
```
### Example Usage: create-payment-201-5

<!-- UsageSnippet language="java" operationID="create-customer-payment" method="post" path="/v2/customers/{customerId}/payments" example="create-payment-201-5" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.*;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.CreateCustomerPaymentRequest;
import com.mollie.mollie.models.operations.CreateCustomerPaymentResponse;
import java.lang.Exception;
import java.time.LocalDate;
import java.util.List;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        CreateCustomerPaymentRequest req = CreateCustomerPaymentRequest.builder()
                .customerId("cst_5B8cwPMGnU")
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .xClientSignature("MEUCIQDx8sJvK3z...")
                .xClientSignedAt("2025-01-01T12:00:00Z")
                .paymentRequest(PaymentRequest.builder()
                    .description("Chess Board")
                    .amount(Amount.builder()
                        .currency("EUR")
                        .value("10.00")
                        .build())
                    .redirectUrl("https://example.org/redirect")
                    .cancelUrl("https://example.org/cancel")
                    .webhookUrl("https://example.org/webhooks")
                    .lines(List.of(
                        PaymentRequestLines.builder()
                            .description("LEGO 4440 Forest Police Station")
                            .quantity(1L)
                            .unitPrice(Amount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .totalAmount(Amount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .type(PaymentLineType.PHYSICAL)
                            .quantityUnit("pcs")
                            .discountAmount(Amount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .vatRate("21.00")
                            .vatAmount(Amount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .sku("9780241661628")
                            .categories(List.of(
                                LineCategories.MEAL,
                                LineCategories.ECO))
                            .imageUrl("https://...")
                            .productUrl("https://...")
                            .recurring(RecurringLineItem.builder()
                                .interval("... months")
                                .description("Gym subscription")
                                .amount(Amount.builder()
                                    .currency("EUR")
                                    .value("10.00")
                                    .build())
                                .times(1L)
                                .startDate("2024-12-12")
                                .build())
                            .build()))
                    .billingAddress(PaymentRequestBillingAddress.builder()
                        .title("Mr.")
                        .givenName("Piet")
                        .familyName("Mondriaan")
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
                    .locale(Locale2.EN_US)
                    .method(PaymentRequestMethod.of(Method.IDEAL))
                    .issuer("ideal_INGBNL2A")
                    .restrictPaymentMethodsToCountry("NL")
                    .captureMode(CaptureMode.MANUAL)
                    .captureDelay("8 hours")
                    .applicationFee(PaymentRequestApplicationFee.builder()
                        .amount(Amount.builder()
                            .currency("EUR")
                            .value("10.00")
                            .build())
                        .description("10")
                        .build())
                    .routing(List.of(
                        EntityPaymentRoute.builder()
                            .amount(Amount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .destination(EntityPaymentRouteDestination.builder()
                                .type(RouteDestinationType.ORGANIZATION)
                                .organizationId("org_1234567")
                                .build())
                            .releaseDate("2024-12-12")
                            .build(),
                        EntityPaymentRoute.builder()
                            .amount(Amount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .destination(EntityPaymentRouteDestination.builder()
                                .type(RouteDestinationType.ORGANIZATION)
                                .organizationId("org_1234567")
                                .build())
                            .releaseDate("2024-12-12")
                            .build()))
                    .sequenceType(SequenceType.ONEOFF)
                    .mandateId("mdt_5B8cwPMGnU")
                    .customerId("cst_5B8cwPMGnU")
                    .profileId("pfl_5B8cwPMGnU")
                    .dueDate("2025-01-01")
                    .storeCredentials(true)
                    .testmode(false)
                    .applePayPaymentToken("{\"paymentData\": {\"version\": \"EC_v1\", \"data\": \"vK3BbrCbI/....\"}}")
                    .company(Company.builder()
                        .registrationNumber("12345678")
                        .vatNumber("NL123456789B01")
                        .build())
                    .cardToken("tkn_12345")
                    .googlePayPaymentToken("{\"signature\": \"MEYCIQCv...\", \"protocolVersion\": \"ECv2\", \"signedMessage\": \"{\\\"encryptedMessage\\\":\\\"...\\\",\\\"ephemeralPublicKey\\\":\\\"...\\\",\\\"tag\\\":\\\"...\\\"}\"}")
                    .voucherNumber("1234567890")
                    .voucherPin("1234")
                    .consumerDateOfBirth(LocalDate.parse("2000-01-01"))
                    .digitalGoods(true)
                    .customerReference("1234567890")
                    .terminalId("term_1234567890")
                    .build())
                .build();

        CreateCustomerPaymentResponse res = sdk.customers().createPayment()
                .request(req)
                .call();

        if (res.paymentResponse().isPresent()) {
            System.out.println(res.paymentResponse().get());
        }
    }
}
```
### Example Usage: create-payment-201-6

<!-- UsageSnippet language="java" operationID="create-customer-payment" method="post" path="/v2/customers/{customerId}/payments" example="create-payment-201-6" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.*;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.CreateCustomerPaymentRequest;
import com.mollie.mollie.models.operations.CreateCustomerPaymentResponse;
import java.lang.Exception;
import java.time.LocalDate;
import java.util.List;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        CreateCustomerPaymentRequest req = CreateCustomerPaymentRequest.builder()
                .customerId("cst_5B8cwPMGnU")
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .xClientSignature("MEUCIQDx8sJvK3z...")
                .xClientSignedAt("2025-01-01T12:00:00Z")
                .paymentRequest(PaymentRequest.builder()
                    .description("Chess Board")
                    .amount(Amount.builder()
                        .currency("EUR")
                        .value("10.00")
                        .build())
                    .redirectUrl("https://example.org/redirect")
                    .cancelUrl("https://example.org/cancel")
                    .webhookUrl("https://example.org/webhooks")
                    .lines(List.of(
                        PaymentRequestLines.builder()
                            .description("LEGO 4440 Forest Police Station")
                            .quantity(1L)
                            .unitPrice(Amount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .totalAmount(Amount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .type(PaymentLineType.PHYSICAL)
                            .quantityUnit("pcs")
                            .discountAmount(Amount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .vatRate("21.00")
                            .vatAmount(Amount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .sku("9780241661628")
                            .categories(List.of(
                                LineCategories.MEAL,
                                LineCategories.ECO))
                            .imageUrl("https://...")
                            .productUrl("https://...")
                            .recurring(RecurringLineItem.builder()
                                .interval("... months")
                                .description("Gym subscription")
                                .amount(Amount.builder()
                                    .currency("EUR")
                                    .value("10.00")
                                    .build())
                                .times(1L)
                                .startDate("2024-12-12")
                                .build())
                            .build()))
                    .billingAddress(PaymentRequestBillingAddress.builder()
                        .title("Mr.")
                        .givenName("Piet")
                        .familyName("Mondriaan")
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
                    .locale(Locale2.EN_US)
                    .method(PaymentRequestMethod.of(Method.IDEAL))
                    .issuer("ideal_INGBNL2A")
                    .restrictPaymentMethodsToCountry("NL")
                    .captureMode(CaptureMode.MANUAL)
                    .captureDelay("8 hours")
                    .applicationFee(PaymentRequestApplicationFee.builder()
                        .amount(Amount.builder()
                            .currency("EUR")
                            .value("10.00")
                            .build())
                        .description("10")
                        .build())
                    .routing(List.of(
                        EntityPaymentRoute.builder()
                            .amount(Amount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .destination(EntityPaymentRouteDestination.builder()
                                .type(RouteDestinationType.ORGANIZATION)
                                .organizationId("org_1234567")
                                .build())
                            .releaseDate("2024-12-12")
                            .build(),
                        EntityPaymentRoute.builder()
                            .amount(Amount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .destination(EntityPaymentRouteDestination.builder()
                                .type(RouteDestinationType.ORGANIZATION)
                                .organizationId("org_1234567")
                                .build())
                            .releaseDate("2024-12-12")
                            .build()))
                    .sequenceType(SequenceType.ONEOFF)
                    .mandateId("mdt_5B8cwPMGnU")
                    .customerId("cst_5B8cwPMGnU")
                    .profileId("pfl_5B8cwPMGnU")
                    .dueDate("2025-01-01")
                    .storeCredentials(true)
                    .testmode(false)
                    .applePayPaymentToken("{\"paymentData\": {\"version\": \"EC_v1\", \"data\": \"vK3BbrCbI/....\"}}")
                    .company(Company.builder()
                        .registrationNumber("12345678")
                        .vatNumber("NL123456789B01")
                        .build())
                    .cardToken("tkn_12345")
                    .googlePayPaymentToken("{\"signature\": \"MEYCIQCv...\", \"protocolVersion\": \"ECv2\", \"signedMessage\": \"{\\\"encryptedMessage\\\":\\\"...\\\",\\\"ephemeralPublicKey\\\":\\\"...\\\",\\\"tag\\\":\\\"...\\\"}\"}")
                    .voucherNumber("1234567890")
                    .voucherPin("1234")
                    .consumerDateOfBirth(LocalDate.parse("2000-01-01"))
                    .digitalGoods(true)
                    .customerReference("1234567890")
                    .terminalId("term_1234567890")
                    .build())
                .build();

        CreateCustomerPaymentResponse res = sdk.customers().createPayment()
                .request(req)
                .call();

        if (res.paymentResponse().isPresent()) {
            System.out.println(res.paymentResponse().get());
        }
    }
}
```
### Example Usage: create-payment-201-7

<!-- UsageSnippet language="java" operationID="create-customer-payment" method="post" path="/v2/customers/{customerId}/payments" example="create-payment-201-7" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.*;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.CreateCustomerPaymentRequest;
import com.mollie.mollie.models.operations.CreateCustomerPaymentResponse;
import java.lang.Exception;
import java.time.LocalDate;
import java.util.List;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        CreateCustomerPaymentRequest req = CreateCustomerPaymentRequest.builder()
                .customerId("cst_5B8cwPMGnU")
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .xClientSignature("MEUCIQDx8sJvK3z...")
                .xClientSignedAt("2025-01-01T12:00:00Z")
                .paymentRequest(PaymentRequest.builder()
                    .description("Chess Board")
                    .amount(Amount.builder()
                        .currency("EUR")
                        .value("10.00")
                        .build())
                    .redirectUrl("https://example.org/redirect")
                    .cancelUrl("https://example.org/cancel")
                    .webhookUrl("https://example.org/webhooks")
                    .lines(List.of(
                        PaymentRequestLines.builder()
                            .description("LEGO 4440 Forest Police Station")
                            .quantity(1L)
                            .unitPrice(Amount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .totalAmount(Amount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .type(PaymentLineType.PHYSICAL)
                            .quantityUnit("pcs")
                            .discountAmount(Amount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .vatRate("21.00")
                            .vatAmount(Amount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .sku("9780241661628")
                            .categories(List.of(
                                LineCategories.MEAL,
                                LineCategories.ECO))
                            .imageUrl("https://...")
                            .productUrl("https://...")
                            .recurring(RecurringLineItem.builder()
                                .interval("... months")
                                .description("Gym subscription")
                                .amount(Amount.builder()
                                    .currency("EUR")
                                    .value("10.00")
                                    .build())
                                .times(1L)
                                .startDate("2024-12-12")
                                .build())
                            .build()))
                    .billingAddress(PaymentRequestBillingAddress.builder()
                        .title("Mr.")
                        .givenName("Piet")
                        .familyName("Mondriaan")
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
                    .locale(Locale2.EN_US)
                    .method(PaymentRequestMethod.of(Method.IDEAL))
                    .issuer("ideal_INGBNL2A")
                    .restrictPaymentMethodsToCountry("NL")
                    .captureMode(CaptureMode.MANUAL)
                    .captureDelay("8 hours")
                    .applicationFee(PaymentRequestApplicationFee.builder()
                        .amount(Amount.builder()
                            .currency("EUR")
                            .value("10.00")
                            .build())
                        .description("10")
                        .build())
                    .routing(List.of(
                        EntityPaymentRoute.builder()
                            .amount(Amount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .destination(EntityPaymentRouteDestination.builder()
                                .type(RouteDestinationType.ORGANIZATION)
                                .organizationId("org_1234567")
                                .build())
                            .releaseDate("2024-12-12")
                            .build(),
                        EntityPaymentRoute.builder()
                            .amount(Amount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .destination(EntityPaymentRouteDestination.builder()
                                .type(RouteDestinationType.ORGANIZATION)
                                .organizationId("org_1234567")
                                .build())
                            .releaseDate("2024-12-12")
                            .build()))
                    .sequenceType(SequenceType.ONEOFF)
                    .mandateId("mdt_5B8cwPMGnU")
                    .customerId("cst_5B8cwPMGnU")
                    .profileId("pfl_5B8cwPMGnU")
                    .dueDate("2025-01-01")
                    .storeCredentials(true)
                    .testmode(false)
                    .applePayPaymentToken("{\"paymentData\": {\"version\": \"EC_v1\", \"data\": \"vK3BbrCbI/....\"}}")
                    .company(Company.builder()
                        .registrationNumber("12345678")
                        .vatNumber("NL123456789B01")
                        .build())
                    .cardToken("tkn_12345")
                    .googlePayPaymentToken("{\"signature\": \"MEYCIQCv...\", \"protocolVersion\": \"ECv2\", \"signedMessage\": \"{\\\"encryptedMessage\\\":\\\"...\\\",\\\"ephemeralPublicKey\\\":\\\"...\\\",\\\"tag\\\":\\\"...\\\"}\"}")
                    .voucherNumber("1234567890")
                    .voucherPin("1234")
                    .consumerDateOfBirth(LocalDate.parse("2000-01-01"))
                    .digitalGoods(true)
                    .customerReference("1234567890")
                    .terminalId("term_1234567890")
                    .build())
                .build();

        CreateCustomerPaymentResponse res = sdk.customers().createPayment()
                .request(req)
                .call();

        if (res.paymentResponse().isPresent()) {
            System.out.println(res.paymentResponse().get());
        }
    }
}
```
### Example Usage: create-payment-201-8

<!-- UsageSnippet language="java" operationID="create-customer-payment" method="post" path="/v2/customers/{customerId}/payments" example="create-payment-201-8" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.*;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.CreateCustomerPaymentRequest;
import com.mollie.mollie.models.operations.CreateCustomerPaymentResponse;
import java.lang.Exception;
import java.time.LocalDate;
import java.util.List;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        CreateCustomerPaymentRequest req = CreateCustomerPaymentRequest.builder()
                .customerId("cst_5B8cwPMGnU")
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .xClientSignature("MEUCIQDx8sJvK3z...")
                .xClientSignedAt("2025-01-01T12:00:00Z")
                .paymentRequest(PaymentRequest.builder()
                    .description("Chess Board")
                    .amount(Amount.builder()
                        .currency("EUR")
                        .value("10.00")
                        .build())
                    .redirectUrl("https://example.org/redirect")
                    .cancelUrl("https://example.org/cancel")
                    .webhookUrl("https://example.org/webhooks")
                    .lines(List.of(
                        PaymentRequestLines.builder()
                            .description("LEGO 4440 Forest Police Station")
                            .quantity(1L)
                            .unitPrice(Amount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .totalAmount(Amount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .type(PaymentLineType.PHYSICAL)
                            .quantityUnit("pcs")
                            .discountAmount(Amount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .vatRate("21.00")
                            .vatAmount(Amount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .sku("9780241661628")
                            .categories(List.of(
                                LineCategories.MEAL,
                                LineCategories.ECO))
                            .imageUrl("https://...")
                            .productUrl("https://...")
                            .recurring(RecurringLineItem.builder()
                                .interval("... months")
                                .description("Gym subscription")
                                .amount(Amount.builder()
                                    .currency("EUR")
                                    .value("10.00")
                                    .build())
                                .times(1L)
                                .startDate("2024-12-12")
                                .build())
                            .build()))
                    .billingAddress(PaymentRequestBillingAddress.builder()
                        .title("Mr.")
                        .givenName("Piet")
                        .familyName("Mondriaan")
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
                    .locale(Locale2.EN_US)
                    .method(PaymentRequestMethod.of(Method.IDEAL))
                    .issuer("ideal_INGBNL2A")
                    .restrictPaymentMethodsToCountry("NL")
                    .captureMode(CaptureMode.MANUAL)
                    .captureDelay("8 hours")
                    .applicationFee(PaymentRequestApplicationFee.builder()
                        .amount(Amount.builder()
                            .currency("EUR")
                            .value("10.00")
                            .build())
                        .description("10")
                        .build())
                    .routing(List.of(
                        EntityPaymentRoute.builder()
                            .amount(Amount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .destination(EntityPaymentRouteDestination.builder()
                                .type(RouteDestinationType.ORGANIZATION)
                                .organizationId("org_1234567")
                                .build())
                            .releaseDate("2024-12-12")
                            .build(),
                        EntityPaymentRoute.builder()
                            .amount(Amount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .destination(EntityPaymentRouteDestination.builder()
                                .type(RouteDestinationType.ORGANIZATION)
                                .organizationId("org_1234567")
                                .build())
                            .releaseDate("2024-12-12")
                            .build()))
                    .sequenceType(SequenceType.ONEOFF)
                    .mandateId("mdt_5B8cwPMGnU")
                    .customerId("cst_5B8cwPMGnU")
                    .profileId("pfl_5B8cwPMGnU")
                    .dueDate("2025-01-01")
                    .storeCredentials(true)
                    .testmode(false)
                    .applePayPaymentToken("{\"paymentData\": {\"version\": \"EC_v1\", \"data\": \"vK3BbrCbI/....\"}}")
                    .company(Company.builder()
                        .registrationNumber("12345678")
                        .vatNumber("NL123456789B01")
                        .build())
                    .cardToken("tkn_12345")
                    .googlePayPaymentToken("{\"signature\": \"MEYCIQCv...\", \"protocolVersion\": \"ECv2\", \"signedMessage\": \"{\\\"encryptedMessage\\\":\\\"...\\\",\\\"ephemeralPublicKey\\\":\\\"...\\\",\\\"tag\\\":\\\"...\\\"}\"}")
                    .voucherNumber("1234567890")
                    .voucherPin("1234")
                    .consumerDateOfBirth(LocalDate.parse("2000-01-01"))
                    .digitalGoods(true)
                    .customerReference("1234567890")
                    .terminalId("term_1234567890")
                    .build())
                .build();

        CreateCustomerPaymentResponse res = sdk.customers().createPayment()
                .request(req)
                .call();

        if (res.paymentResponse().isPresent()) {
            System.out.println(res.paymentResponse().get());
        }
    }
}
```
### Example Usage: create-payment-201-9

<!-- UsageSnippet language="java" operationID="create-customer-payment" method="post" path="/v2/customers/{customerId}/payments" example="create-payment-201-9" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.*;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.CreateCustomerPaymentRequest;
import com.mollie.mollie.models.operations.CreateCustomerPaymentResponse;
import java.lang.Exception;
import java.time.LocalDate;
import java.util.List;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        CreateCustomerPaymentRequest req = CreateCustomerPaymentRequest.builder()
                .customerId("cst_5B8cwPMGnU")
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .xClientSignature("MEUCIQDx8sJvK3z...")
                .xClientSignedAt("2025-01-01T12:00:00Z")
                .paymentRequest(PaymentRequest.builder()
                    .description("Chess Board")
                    .amount(Amount.builder()
                        .currency("EUR")
                        .value("10.00")
                        .build())
                    .redirectUrl("https://example.org/redirect")
                    .cancelUrl("https://example.org/cancel")
                    .webhookUrl("https://example.org/webhooks")
                    .lines(List.of(
                        PaymentRequestLines.builder()
                            .description("LEGO 4440 Forest Police Station")
                            .quantity(1L)
                            .unitPrice(Amount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .totalAmount(Amount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .type(PaymentLineType.PHYSICAL)
                            .quantityUnit("pcs")
                            .discountAmount(Amount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .vatRate("21.00")
                            .vatAmount(Amount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .sku("9780241661628")
                            .categories(List.of(
                                LineCategories.MEAL,
                                LineCategories.ECO))
                            .imageUrl("https://...")
                            .productUrl("https://...")
                            .recurring(RecurringLineItem.builder()
                                .interval("... months")
                                .description("Gym subscription")
                                .amount(Amount.builder()
                                    .currency("EUR")
                                    .value("10.00")
                                    .build())
                                .times(1L)
                                .startDate("2024-12-12")
                                .build())
                            .build()))
                    .billingAddress(PaymentRequestBillingAddress.builder()
                        .title("Mr.")
                        .givenName("Piet")
                        .familyName("Mondriaan")
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
                    .locale(Locale2.EN_US)
                    .method(PaymentRequestMethod.of(Method.IDEAL))
                    .issuer("ideal_INGBNL2A")
                    .restrictPaymentMethodsToCountry("NL")
                    .captureMode(CaptureMode.MANUAL)
                    .captureDelay("8 hours")
                    .applicationFee(PaymentRequestApplicationFee.builder()
                        .amount(Amount.builder()
                            .currency("EUR")
                            .value("10.00")
                            .build())
                        .description("10")
                        .build())
                    .routing(List.of(
                        EntityPaymentRoute.builder()
                            .amount(Amount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .destination(EntityPaymentRouteDestination.builder()
                                .type(RouteDestinationType.ORGANIZATION)
                                .organizationId("org_1234567")
                                .build())
                            .releaseDate("2024-12-12")
                            .build(),
                        EntityPaymentRoute.builder()
                            .amount(Amount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .destination(EntityPaymentRouteDestination.builder()
                                .type(RouteDestinationType.ORGANIZATION)
                                .organizationId("org_1234567")
                                .build())
                            .releaseDate("2024-12-12")
                            .build()))
                    .sequenceType(SequenceType.ONEOFF)
                    .mandateId("mdt_5B8cwPMGnU")
                    .customerId("cst_5B8cwPMGnU")
                    .profileId("pfl_5B8cwPMGnU")
                    .dueDate("2025-01-01")
                    .storeCredentials(true)
                    .testmode(false)
                    .applePayPaymentToken("{\"paymentData\": {\"version\": \"EC_v1\", \"data\": \"vK3BbrCbI/....\"}}")
                    .company(Company.builder()
                        .registrationNumber("12345678")
                        .vatNumber("NL123456789B01")
                        .build())
                    .cardToken("tkn_12345")
                    .googlePayPaymentToken("{\"signature\": \"MEYCIQCv...\", \"protocolVersion\": \"ECv2\", \"signedMessage\": \"{\\\"encryptedMessage\\\":\\\"...\\\",\\\"ephemeralPublicKey\\\":\\\"...\\\",\\\"tag\\\":\\\"...\\\"}\"}")
                    .voucherNumber("1234567890")
                    .voucherPin("1234")
                    .consumerDateOfBirth(LocalDate.parse("2000-01-01"))
                    .digitalGoods(true)
                    .customerReference("1234567890")
                    .terminalId("term_1234567890")
                    .build())
                .build();

        CreateCustomerPaymentResponse res = sdk.customers().createPayment()
                .request(req)
                .call();

        if (res.paymentResponse().isPresent()) {
            System.out.println(res.paymentResponse().get());
        }
    }
}
```

### Parameters

| Parameter                                                                               | Type                                                                                    | Required                                                                                | Description                                                                             |
| --------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------- |
| `request`                                                                               | [CreateCustomerPaymentRequest](../../models/operations/CreateCustomerPaymentRequest.md) | :heavy_check_mark:                                                                      | The request object to use for the request.                                              |

### Response

**[CreateCustomerPaymentResponse](../../models/operations/CreateCustomerPaymentResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 422, 429                    | application/hal+json        |
| models/errors/ErrorResponse | 503                         | application/hal+json        |
| models/errors/APIException  | 4XX, 5XX                    | \*/\*                       |

## listPayments

Retrieve all payments linked to the customer.

### Example Usage: list-payments-200-1

<!-- UsageSnippet language="java" operationID="list-customer-payments" method="get" path="/v2/customers/{customerId}/payments" example="list-payments-200-1" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.components.Sorting;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.ListCustomerPaymentsRequest;
import com.mollie.mollie.models.operations.ListCustomerPaymentsResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .profileId("pfl_5B8cwPMGnU")
                .testmode(false)
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        ListCustomerPaymentsRequest req = ListCustomerPaymentsRequest.builder()
                .customerId("cst_5B8cwPMGnU")
                .from("tr_5B8cwPMGnU")
                .limit(50L)
                .sort(Sorting.DESC)
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .xClientSignature("MEUCIQDx8sJvK3z...")
                .xClientSignedAt("2025-01-01T12:00:00Z")
                .build();


        sdk.customers().listPayments()
                .callAsStream()
                .forEach((ListCustomerPaymentsResponse item) -> {
                   // handle page
                });

    }
}
```
### Example Usage: list-payments-200-2

<!-- UsageSnippet language="java" operationID="list-customer-payments" method="get" path="/v2/customers/{customerId}/payments" example="list-payments-200-2" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.components.Sorting;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.ListCustomerPaymentsRequest;
import com.mollie.mollie.models.operations.ListCustomerPaymentsResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .profileId("pfl_5B8cwPMGnU")
                .testmode(false)
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        ListCustomerPaymentsRequest req = ListCustomerPaymentsRequest.builder()
                .customerId("cst_5B8cwPMGnU")
                .from("tr_5B8cwPMGnU")
                .limit(50L)
                .sort(Sorting.DESC)
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .xClientSignature("MEUCIQDx8sJvK3z...")
                .xClientSignedAt("2025-01-01T12:00:00Z")
                .build();


        sdk.customers().listPayments()
                .callAsStream()
                .forEach((ListCustomerPaymentsResponse item) -> {
                   // handle page
                });

    }
}
```
### Example Usage: list-payments-200-3

<!-- UsageSnippet language="java" operationID="list-customer-payments" method="get" path="/v2/customers/{customerId}/payments" example="list-payments-200-3" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.components.Sorting;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.ListCustomerPaymentsRequest;
import com.mollie.mollie.models.operations.ListCustomerPaymentsResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .profileId("pfl_5B8cwPMGnU")
                .testmode(false)
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        ListCustomerPaymentsRequest req = ListCustomerPaymentsRequest.builder()
                .customerId("cst_5B8cwPMGnU")
                .from("tr_5B8cwPMGnU")
                .limit(50L)
                .sort(Sorting.DESC)
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .xClientSignature("MEUCIQDx8sJvK3z...")
                .xClientSignedAt("2025-01-01T12:00:00Z")
                .build();


        sdk.customers().listPayments()
                .callAsStream()
                .forEach((ListCustomerPaymentsResponse item) -> {
                   // handle page
                });

    }
}
```

### Parameters

| Parameter                                                                             | Type                                                                                  | Required                                                                              | Description                                                                           |
| ------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------- |
| `request`                                                                             | [ListCustomerPaymentsRequest](../../models/operations/ListCustomerPaymentsRequest.md) | :heavy_check_mark:                                                                    | The request object to use for the request.                                            |

### Response

**[ListCustomerPaymentsResponse](../../models/operations/ListCustomerPaymentsResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 400, 429                    | application/hal+json        |
| models/errors/APIException  | 4XX, 5XX                    | \*/\*                       |