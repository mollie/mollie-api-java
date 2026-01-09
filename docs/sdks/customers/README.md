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

<!-- UsageSnippet language="java" operationID="create-customer" method="post" path="/customers" -->
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
                .entityCustomer(EntityCustomer.builder()
                    .name("John Doe")
                    .email("example@email.com")
                    .locale(LocaleResponse.EN_US)
                    .testmode(false)
                    .build())
                .call();

        if (res.customerResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                        | Type                                                                             | Required                                                                         | Description                                                                      | Example                                                                          |
| -------------------------------------------------------------------------------- | -------------------------------------------------------------------------------- | -------------------------------------------------------------------------------- | -------------------------------------------------------------------------------- | -------------------------------------------------------------------------------- |
| `idempotencyKey`                                                                 | *Optional\<String>*                                                              | :heavy_minus_sign:                                                               | A unique key to ensure idempotent requests. This key should be a UUID v4 string. | 123e4567-e89b-12d3-a456-426                                                      |
| `entityCustomer`                                                                 | [Optional\<EntityCustomer>](../../models/components/EntityCustomer.md)           | :heavy_minus_sign:                                                               | N/A                                                                              |                                                                                  |

### Response

**[CreateCustomerResponse](../../models/operations/CreateCustomerResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 404                         | application/hal+json        |
| models/errors/APIException  | 4XX, 5XX                    | \*/\*                       |

## list

Retrieve a list of all customers.

The results are paginated.

### Example Usage

<!-- UsageSnippet language="java" operationID="list-customers" method="get" path="/customers" -->
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
                .build();

        ListCustomersResponse res = sdk.customers().list()
                .request(req)
                .call();

        if (res.object().isPresent()) {
            // handle response
        }
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
| models/errors/ErrorResponse | 400, 404                    | application/hal+json        |
| models/errors/APIException  | 4XX, 5XX                    | \*/\*                       |

## get

Retrieve a single customer by its ID.

### Example Usage

<!-- UsageSnippet language="java" operationID="get-customer" method="get" path="/customers/{customerId}" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.ErrorResponse;
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

        GetCustomerResponse res = sdk.customers().get()
                .customerId("cst_5B8cwPMGnU")
                .include("events")
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .call();

        if (res.object().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                                                                                                                                                                                                                                                                                              | Type                                                                                                                                                                                                                                                                                                                                                                                   | Required                                                                                                                                                                                                                                                                                                                                                                               | Description                                                                                                                                                                                                                                                                                                                                                                            | Example                                                                                                                                                                                                                                                                                                                                                                                |
| -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `customerId`                                                                                                                                                                                                                                                                                                                                                                           | *String*                                                                                                                                                                                                                                                                                                                                                                               | :heavy_check_mark:                                                                                                                                                                                                                                                                                                                                                                     | Provide the ID of the related customer.                                                                                                                                                                                                                                                                                                                                                | cst_5B8cwPMGnU                                                                                                                                                                                                                                                                                                                                                                         |
| `include`                                                                                                                                                                                                                                                                                                                                                                              | *JsonNullable\<String>*                                                                                                                                                                                                                                                                                                                                                                | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                     | This endpoint allows you to include additional information via the `include` query string parameter.                                                                                                                                                                                                                                                                                   |                                                                                                                                                                                                                                                                                                                                                                                        |
| `testmode`                                                                                                                                                                                                                                                                                                                                                                             | *Optional\<Boolean>*                                                                                                                                                                                                                                                                                                                                                                   | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                     | Most API credentials are specifically created for either live mode or test mode. In those cases the `testmode` query<br/>parameter can be omitted. For organization-level credentials such as OAuth access tokens, you can enable test mode by<br/>setting the `testmode` query parameter to `true`.<br/><br/>Test entities cannot be retrieved when the endpoint is set to live mode, and vice versa. |                                                                                                                                                                                                                                                                                                                                                                                        |
| `idempotencyKey`                                                                                                                                                                                                                                                                                                                                                                       | *Optional\<String>*                                                                                                                                                                                                                                                                                                                                                                    | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                     | A unique key to ensure idempotent requests. This key should be a UUID v4 string.                                                                                                                                                                                                                                                                                                       | 123e4567-e89b-12d3-a456-426                                                                                                                                                                                                                                                                                                                                                            |

### Response

**[GetCustomerResponse](../../models/operations/GetCustomerResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 404                         | application/hal+json        |
| models/errors/APIException  | 4XX, 5XX                    | \*/\*                       |

## update

Update an existing customer.

For an in-depth explanation of each parameter, refer to the [Create customer](create-customer) endpoint.

### Example Usage

<!-- UsageSnippet language="java" operationID="update-customer" method="patch" path="/customers/{customerId}" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.*;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.UpdateCustomerResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        UpdateCustomerResponse res = sdk.customers().update()
                .customerId("cst_5B8cwPMGnU")
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .entityCustomer(EntityCustomer.builder()
                    .name("John Doe")
                    .email("example@email.com")
                    .locale(LocaleResponse.EN_US)
                    .testmode(false)
                    .build())
                .call();

        if (res.customerResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                        | Type                                                                             | Required                                                                         | Description                                                                      | Example                                                                          |
| -------------------------------------------------------------------------------- | -------------------------------------------------------------------------------- | -------------------------------------------------------------------------------- | -------------------------------------------------------------------------------- | -------------------------------------------------------------------------------- |
| `customerId`                                                                     | *String*                                                                         | :heavy_check_mark:                                                               | Provide the ID of the related customer.                                          | cst_5B8cwPMGnU                                                                   |
| `idempotencyKey`                                                                 | *Optional\<String>*                                                              | :heavy_minus_sign:                                                               | A unique key to ensure idempotent requests. This key should be a UUID v4 string. | 123e4567-e89b-12d3-a456-426                                                      |
| `entityCustomer`                                                                 | [Optional\<EntityCustomer>](../../models/components/EntityCustomer.md)           | :heavy_minus_sign:                                                               | N/A                                                                              |                                                                                  |

### Response

**[UpdateCustomerResponse](../../models/operations/UpdateCustomerResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 404                         | application/hal+json        |
| models/errors/APIException  | 4XX, 5XX                    | \*/\*                       |

## delete

Delete a customer. All mandates and subscriptions created for this customer will be canceled as well.

### Example Usage

<!-- UsageSnippet language="java" operationID="delete-customer" method="delete" path="/customers/{customerId}" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.DeleteCustomerRequestBody;
import com.mollie.mollie.models.operations.DeleteCustomerResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        DeleteCustomerResponse res = sdk.customers().delete()
                .customerId("cst_5B8cwPMGnU")
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .requestBody(DeleteCustomerRequestBody.builder()
                    .testmode(false)
                    .build())
                .call();

        // handle response
    }
}
```

### Parameters

| Parameter                                                                                    | Type                                                                                         | Required                                                                                     | Description                                                                                  | Example                                                                                      |
| -------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------- |
| `customerId`                                                                                 | *String*                                                                                     | :heavy_check_mark:                                                                           | Provide the ID of the related customer.                                                      | cst_5B8cwPMGnU                                                                               |
| `idempotencyKey`                                                                             | *Optional\<String>*                                                                          | :heavy_minus_sign:                                                                           | A unique key to ensure idempotent requests. This key should be a UUID v4 string.             | 123e4567-e89b-12d3-a456-426                                                                  |
| `requestBody`                                                                                | [Optional\<DeleteCustomerRequestBody>](../../models/operations/DeleteCustomerRequestBody.md) | :heavy_minus_sign:                                                                           | N/A                                                                                          |                                                                                              |

### Response

**[DeleteCustomerResponse](../../models/operations/DeleteCustomerResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 404                         | application/hal+json        |
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

### Example Usage

<!-- UsageSnippet language="java" operationID="create-customer-payment" method="post" path="/customers/{customerId}/payments" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.*;
import com.mollie.mollie.models.errors.ErrorResponse;
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

        CreateCustomerPaymentResponse res = sdk.customers().createPayment()
                .customerId("cst_5B8cwPMGnU")
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
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
                    .shippingAddress(PaymentAddress.builder()
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
                            .links(EntityPaymentRouteLinks.builder()
                                .self(Url.builder()
                                    .href("https://...")
                                    .type("application/hal+json")
                                    .build())
                                .payment(Url.builder()
                                    .href("https://...")
                                    .type("application/hal+json")
                                    .build())
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
                            .links(EntityPaymentRouteLinks.builder()
                                .self(Url.builder()
                                    .href("https://...")
                                    .type("application/hal+json")
                                    .build())
                                .payment(Url.builder()
                                    .href("https://...")
                                    .type("application/hal+json")
                                    .build())
                                .build())
                            .releaseDate("2024-12-12")
                            .build()))
                    .sequenceType(SequenceType.ONEOFF)
                    .mandateId("mdt_5B8cwPMGnU")
                    .customerId("cst_5B8cwPMGnU")
                    .profileId("pfl_5B8cwPMGnU")
                    .dueDate("2025-01-01")
                    .testmode(false)
                    .applePayPaymentToken("{\"paymentData\": {\"version\": \"EC_v1\", \"data\": \"vK3BbrCbI/....\"}}")
                    .company(Company.builder()
                        .registrationNumber("12345678")
                        .vatNumber("NL123456789B01")
                        .build())
                    .cardToken("tkn_12345")
                    .voucherNumber("1234567890")
                    .voucherPin("1234")
                    .consumerDateOfBirth(LocalDate.parse("2000-01-01"))
                    .digitalGoods(true)
                    .customerReference("1234567890")
                    .terminalId("term_1234567890")
                    .build())
                .call();

        if (res.paymentResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                        | Type                                                                             | Required                                                                         | Description                                                                      | Example                                                                          |
| -------------------------------------------------------------------------------- | -------------------------------------------------------------------------------- | -------------------------------------------------------------------------------- | -------------------------------------------------------------------------------- | -------------------------------------------------------------------------------- |
| `customerId`                                                                     | *String*                                                                         | :heavy_check_mark:                                                               | Provide the ID of the related customer.                                          | cst_5B8cwPMGnU                                                                   |
| `idempotencyKey`                                                                 | *Optional\<String>*                                                              | :heavy_minus_sign:                                                               | A unique key to ensure idempotent requests. This key should be a UUID v4 string. | 123e4567-e89b-12d3-a456-426                                                      |
| `paymentRequest`                                                                 | [Optional\<PaymentRequest>](../../models/components/PaymentRequest.md)           | :heavy_minus_sign:                                                               | N/A                                                                              |                                                                                  |

### Response

**[CreateCustomerPaymentResponse](../../models/operations/CreateCustomerPaymentResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 422                         | application/hal+json        |
| models/errors/ErrorResponse | 503                         | application/hal+json        |
| models/errors/APIException  | 4XX, 5XX                    | \*/\*                       |

## listPayments

Retrieve all payments linked to the customer.

### Example Usage

<!-- UsageSnippet language="java" operationID="list-customer-payments" method="get" path="/customers/{customerId}/payments" -->
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
                .build();

        ListCustomerPaymentsResponse res = sdk.customers().listPayments()
                .request(req)
                .call();

        if (res.object().isPresent()) {
            // handle response
        }
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
| models/errors/ErrorResponse | 400                         | application/hal+json        |
| models/errors/APIException  | 4XX, 5XX                    | \*/\*                       |