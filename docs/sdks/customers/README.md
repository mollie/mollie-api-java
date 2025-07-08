# Customers
(*customers()*)

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

Creates a simple minimal representation of a customer. Payments, recurring mandates, and subscriptions can be linked to this customer object, which simplifies management of recurring payments.

Once registered, customers will also appear in your Mollie dashboard.

> 🔑 Access with
>
> [API key](/reference/authentication)
>
> [Access token with **customers.write**](/reference/authentication)

### Example Usage

```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.CreateCustomerResponseBody;
import com.mollie.mollie.models.operations.CreateCustomerRequestBody;
import com.mollie.mollie.models.operations.CreateCustomerResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws CreateCustomerResponseBody, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        CreateCustomerRequestBody req = CreateCustomerRequestBody.builder()
                .name("John Doe")
                .email("example@email.com")
                .locale("en_US")
                .testmode(false)
                .build();

        CreateCustomerResponse res = sdk.customers().create()
                .request(req)
                .call();

        if (res.object().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                         | Type                                                                              | Required                                                                          | Description                                                                       |
| --------------------------------------------------------------------------------- | --------------------------------------------------------------------------------- | --------------------------------------------------------------------------------- | --------------------------------------------------------------------------------- |
| `request`                                                                         | [CreateCustomerRequestBody](../../models/operations/CreateCustomerRequestBody.md) | :heavy_check_mark:                                                                | The request object to use for the request.                                        |

### Response

**[CreateCustomerResponse](../../models/operations/CreateCustomerResponse.md)**

### Errors

| Error Type                               | Status Code                              | Content Type                             |
| ---------------------------------------- | ---------------------------------------- | ---------------------------------------- |
| models/errors/CreateCustomerResponseBody | 404                                      | application/hal+json                     |
| models/errors/APIException               | 4XX, 5XX                                 | \*/\*                                    |

## list

Retrieve a list of all customers.

The results are paginated.

> 🔑 Access with
>
> [API key](/reference/authentication)
>
> [Access token with **customers.read**](/reference/authentication)

### Example Usage

```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.ListCustomersCustomersResponseBody;
import com.mollie.mollie.models.errors.ListCustomersResponseBody;
import com.mollie.mollie.models.operations.ListCustomersResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ListCustomersResponseBody, ListCustomersCustomersResponseBody, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        ListCustomersResponse res = sdk.customers().list()
                .from("cst_5B8cwPMGnU")
                .limit(50L)
                .sort("desc")
                .testmode(false)
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
| `from`                                                                                                                                                                                                                                                                                                                                                                                 | *Optional\<String>*                                                                                                                                                                                                                                                                                                                                                                    | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                     | Provide an ID to start the result set from the item with the given ID and onwards. This allows you to paginate the result set.                                                                                                                                                                                                                                                         | cst_5B8cwPMGnU                                                                                                                                                                                                                                                                                                                                                                         |
| `limit`                                                                                                                                                                                                                                                                                                                                                                                | *JsonNullable\<Long>*                                                                                                                                                                                                                                                                                                                                                                  | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                     | The maximum number of items to return. Defaults to 50 items.                                                                                                                                                                                                                                                                                                                           | 50                                                                                                                                                                                                                                                                                                                                                                                     |
| `sort`                                                                                                                                                                                                                                                                                                                                                                                 | *JsonNullable\<String>*                                                                                                                                                                                                                                                                                                                                                                | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                     | Used for setting the direction of the result set. Defaults to descending order, meaning the results are ordered from newest to oldest.<br/><br/>Possible values: `asc` `desc` (default: `desc`)                                                                                                                                                                                        | desc                                                                                                                                                                                                                                                                                                                                                                                   |
| `testmode`                                                                                                                                                                                                                                                                                                                                                                             | *JsonNullable\<Boolean>*                                                                                                                                                                                                                                                                                                                                                               | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                     | Most API credentials are specifically created for either live mode or test mode. In those cases the `testmode` query parameter can be omitted. For organization-level credentials such as OAuth access tokens, you can enable test mode by setting the `testmode` query parameter to `true`.<br/><br/>Test entities cannot be retrieved when the endpoint is set to live mode, and vice versa. | false                                                                                                                                                                                                                                                                                                                                                                                  |

### Response

**[ListCustomersResponse](../../models/operations/ListCustomersResponse.md)**

### Errors

| Error Type                                       | Status Code                                      | Content Type                                     |
| ------------------------------------------------ | ------------------------------------------------ | ------------------------------------------------ |
| models/errors/ListCustomersResponseBody          | 400                                              | application/hal+json                             |
| models/errors/ListCustomersCustomersResponseBody | 404                                              | application/hal+json                             |
| models/errors/APIException                       | 4XX, 5XX                                         | \*/\*                                            |

## get

Retrieve a single customer by its ID.

> 🔑 Access with
>
> [API key](/reference/authentication)

### Example Usage

```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.GetCustomerResponseBody;
import com.mollie.mollie.models.operations.GetCustomerQueryParamInclude;
import com.mollie.mollie.models.operations.GetCustomerResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws GetCustomerResponseBody, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        GetCustomerResponse res = sdk.customers().get()
                .customerId("cst_5B8cwPMGnU")
                .include(GetCustomerQueryParamInclude.EVENTS)
                .testmode(false)
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
| `include`                                                                                                                                                                                                                                                                                                                                                                              | [JsonNullable\<GetCustomerQueryParamInclude>](../../models/operations/GetCustomerQueryParamInclude.md)                                                                                                                                                                                                                                                                                 | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                     | This endpoint allows you to include additional information via the `include` query string parameter.                                                                                                                                                                                                                                                                                   | events                                                                                                                                                                                                                                                                                                                                                                                 |
| `testmode`                                                                                                                                                                                                                                                                                                                                                                             | *JsonNullable\<Boolean>*                                                                                                                                                                                                                                                                                                                                                               | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                     | Most API credentials are specifically created for either live mode or test mode. In those cases the `testmode` query parameter can be omitted. For organization-level credentials such as OAuth access tokens, you can enable test mode by setting the `testmode` query parameter to `true`.<br/><br/>Test entities cannot be retrieved when the endpoint is set to live mode, and vice versa. | false                                                                                                                                                                                                                                                                                                                                                                                  |

### Response

**[GetCustomerResponse](../../models/operations/GetCustomerResponse.md)**

### Errors

| Error Type                            | Status Code                           | Content Type                          |
| ------------------------------------- | ------------------------------------- | ------------------------------------- |
| models/errors/GetCustomerResponseBody | 404                                   | application/hal+json                  |
| models/errors/APIException            | 4XX, 5XX                              | \*/\*                                 |

## update

Update an existing customer.

For an in-depth explanation of each parameter, refer to the [Create customer](create-customer) endpoint.

> 🔑 Access with
>
> [API key](/reference/authentication)

### Example Usage

```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.UpdateCustomerResponseBody;
import com.mollie.mollie.models.operations.UpdateCustomerRequestBody;
import com.mollie.mollie.models.operations.UpdateCustomerResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws UpdateCustomerResponseBody, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        UpdateCustomerResponse res = sdk.customers().update()
                .customerId("cst_5B8cwPMGnU")
                .requestBody(UpdateCustomerRequestBody.builder()
                    .name("John Doe")
                    .email("example@email.com")
                    .locale("en_US")
                    .testmode(false)
                    .build())
                .call();

        if (res.object().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                    | Type                                                                                         | Required                                                                                     | Description                                                                                  | Example                                                                                      |
| -------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------- |
| `customerId`                                                                                 | *String*                                                                                     | :heavy_check_mark:                                                                           | Provide the ID of the related customer.                                                      | cst_5B8cwPMGnU                                                                               |
| `requestBody`                                                                                | [Optional\<UpdateCustomerRequestBody>](../../models/operations/UpdateCustomerRequestBody.md) | :heavy_minus_sign:                                                                           | N/A                                                                                          |                                                                                              |

### Response

**[UpdateCustomerResponse](../../models/operations/UpdateCustomerResponse.md)**

### Errors

| Error Type                               | Status Code                              | Content Type                             |
| ---------------------------------------- | ---------------------------------------- | ---------------------------------------- |
| models/errors/UpdateCustomerResponseBody | 404                                      | application/hal+json                     |
| models/errors/APIException               | 4XX, 5XX                                 | \*/\*                                    |

## delete

Delete a customer. All mandates and subscriptions created for this customer will be canceled as well.

> 🔑 Access with
>
> [API key](/reference/authentication)

### Example Usage

```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.DeleteCustomerResponseBody;
import com.mollie.mollie.models.operations.DeleteCustomerRequestBody;
import com.mollie.mollie.models.operations.DeleteCustomerResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws DeleteCustomerResponseBody, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        DeleteCustomerResponse res = sdk.customers().delete()
                .customerId("cst_5B8cwPMGnU")
                .requestBody(DeleteCustomerRequestBody.builder()
                    .testmode(false)
                    .build())
                .call();

        if (res.any().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                    | Type                                                                                         | Required                                                                                     | Description                                                                                  | Example                                                                                      |
| -------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------- |
| `customerId`                                                                                 | *String*                                                                                     | :heavy_check_mark:                                                                           | Provide the ID of the related customer.                                                      | cst_5B8cwPMGnU                                                                               |
| `requestBody`                                                                                | [Optional\<DeleteCustomerRequestBody>](../../models/operations/DeleteCustomerRequestBody.md) | :heavy_minus_sign:                                                                           | N/A                                                                                          |                                                                                              |

### Response

**[DeleteCustomerResponse](../../models/operations/DeleteCustomerResponse.md)**

### Errors

| Error Type                               | Status Code                              | Content Type                             |
| ---------------------------------------- | ---------------------------------------- | ---------------------------------------- |
| models/errors/DeleteCustomerResponseBody | 404                                      | application/hal+json                     |
| models/errors/APIException               | 4XX, 5XX                                 | \*/\*                                    |

## createPayment

Creates a payment for the customer.

Linking customers to payments enables you to:

* Keep track of payment preferences for your customers
* Allow your customers to charge a previously used credit card with a single click in our hosted checkout
* Improve payment insights in the Mollie dashboard
* Use recurring payments

This endpoint is effectively an alias of the [Create payment endpoint](create-payment) with the `customerId` parameter predefined.

> 🔑 Access with
>
> [API key](/reference/authentication)
>
> [Access token with **payments.write**](/reference/authentication)

### Example Usage

```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.CreateCustomerPaymentCustomersResponseBody;
import com.mollie.mollie.models.errors.CreateCustomerPaymentResponseBody;
import com.mollie.mollie.models.operations.*;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws CreateCustomerPaymentResponseBody, CreateCustomerPaymentCustomersResponseBody, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        CreateCustomerPaymentResponse res = sdk.customers().createPayment()
                .customerId("cst_5B8cwPMGnU")
                .requestBody(CreateCustomerPaymentRequestBody.builder()
                    .description("Chess Board")
                    .amount(CreateCustomerPaymentAmount.builder()
                        .currency("EUR")
                        .value("10.00")
                        .build())
                    .redirectUrl("https://example.org/redirect")
                    .cancelUrl("https://example.org/cancel")
                    .webhookUrl("https://example.org/webhooks")
                    .lines(List.of(
                        CreateCustomerPaymentLines.builder()
                            .description("LEGO 4440 Forest Police Station")
                            .quantity(1L)
                            .unitPrice(CreateCustomerPaymentUnitPrice.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .totalAmount(CreateCustomerPaymentTotalAmount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .quantityUnit("pcs")
                            .discountAmount(CreateCustomerPaymentDiscountAmount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .vatRate("21.00")
                            .vatAmount(CreateCustomerPaymentVatAmount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .sku("9780241661628")
                            .categories(List.of(
                                CreateCustomerPaymentCategories.MEAL,
                                CreateCustomerPaymentCategories.ECO))
                            .imageUrl("https://...")
                            .productUrl("https://...")
                            .recurring(CreateCustomerPaymentRecurring.builder()
                                .interval("12 months")
                                .description("Gym subscription")
                                .amount(CreateCustomerPaymentCustomersAmount.builder()
                                    .currency("EUR")
                                    .value("10.00")
                                    .build())
                                .times(1L)
                                .startDate("2024-12-12")
                                .build())
                            .build()))
                    .billingAddress(CreateCustomerPaymentBillingAddress.builder()
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
                    .shippingAddress(CreateCustomerPaymentShippingAddress.builder()
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
                    .locale("en_US")
                    .method("ideal")
                    .issuer("ideal_INGBNL2A")
                    .restrictPaymentMethodsToCountry("NL")
                    .captureMode("manual")
                    .captureDelay("8 hours")
                    .applicationFee(CreateCustomerPaymentApplicationFee.builder()
                        .amount(CreateCustomerPaymentCustomersRequestAmount.builder()
                            .currency("EUR")
                            .value("10.00")
                            .build())
                        .description("10")
                        .build())
                    .routing(List.of(
                        CreateCustomerPaymentRouting.builder()
                            .amount(CreateCustomerPaymentCustomersRequestRequestBodyAmount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .destination(CreateCustomerPaymentDestination.builder()
                                .type("organization")
                                .organizationId("org_1234567")
                                .build())
                            .links(CreateCustomerPaymentLinks.builder()
                                .self(CreateCustomerPaymentSelf.builder()
                                    .href("https://...")
                                    .type("application/hal+json")
                                    .build())
                                .payment(CreateCustomerPaymentPayment.builder()
                                    .href("https://...")
                                    .type("application/hal+json")
                                    .build())
                                .build())
                            .releaseDate("2024-12-12")
                            .build(),
                        CreateCustomerPaymentRouting.builder()
                            .amount(CreateCustomerPaymentCustomersRequestRequestBodyAmount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .destination(CreateCustomerPaymentDestination.builder()
                                .type("organization")
                                .organizationId("org_1234567")
                                .build())
                            .links(CreateCustomerPaymentLinks.builder()
                                .self(CreateCustomerPaymentSelf.builder()
                                    .href("https://...")
                                    .type("application/hal+json")
                                    .build())
                                .payment(CreateCustomerPaymentPayment.builder()
                                    .href("https://...")
                                    .type("application/hal+json")
                                    .build())
                                .build())
                            .releaseDate("2024-12-12")
                            .build()))
                    .sequenceType("oneoff")
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

### Parameters

| Parameter                                                                                                  | Type                                                                                                       | Required                                                                                                   | Description                                                                                                | Example                                                                                                    |
| ---------------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------- |
| `customerId`                                                                                               | *String*                                                                                                   | :heavy_check_mark:                                                                                         | Provide the ID of the related customer.                                                                    | cst_5B8cwPMGnU                                                                                             |
| `requestBody`                                                                                              | [Optional\<CreateCustomerPaymentRequestBody>](../../models/operations/CreateCustomerPaymentRequestBody.md) | :heavy_minus_sign:                                                                                         | N/A                                                                                                        |                                                                                                            |

### Response

**[CreateCustomerPaymentResponse](../../models/operations/CreateCustomerPaymentResponse.md)**

### Errors

| Error Type                                               | Status Code                                              | Content Type                                             |
| -------------------------------------------------------- | -------------------------------------------------------- | -------------------------------------------------------- |
| models/errors/CreateCustomerPaymentResponseBody          | 422                                                      | application/hal+json                                     |
| models/errors/CreateCustomerPaymentCustomersResponseBody | 503                                                      | application/hal+json                                     |
| models/errors/APIException                               | 4XX, 5XX                                                 | \*/\*                                                    |

## listPayments

Retrieve all payments linked to the customer.

> 🔑 Access with
>
> [API key](/reference/authentication)
>
> [Access token with **payments.read**](/reference/authentication)

### Example Usage

```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.ListCustomerPaymentsResponseBody;
import com.mollie.mollie.models.operations.ListCustomerPaymentsRequest;
import com.mollie.mollie.models.operations.ListCustomerPaymentsResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ListCustomerPaymentsResponseBody, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        ListCustomerPaymentsRequest req = ListCustomerPaymentsRequest.builder()
                .customerId("cst_5B8cwPMGnU")
                .from("tr_5B8cwPMGnU")
                .sort("desc")
                .profileId("pfl_5B8cwPMGnU")
                .testmode(false)
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

| Error Type                                     | Status Code                                    | Content Type                                   |
| ---------------------------------------------- | ---------------------------------------------- | ---------------------------------------------- |
| models/errors/ListCustomerPaymentsResponseBody | 400                                            | application/hal+json                           |
| models/errors/APIException                     | 4XX, 5XX                                       | \*/\*                                          |