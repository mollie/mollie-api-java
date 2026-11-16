# PaymentLinks

## Overview

### Available Operations

* [create](#create) - Create payment link
* [list](#list) - List payment links
* [get](#get) - Get payment link
* [update](#update) - Update payment link
* [delete](#delete) - Delete payment link
* [listPayments](#listpayments) - Get payment link payments

## create

With the Payment links API you can generate payment links that by default, unlike regular payments, do not expire.
The payment link can be shared with your customers and will redirect them to them the payment page where they can
complete the payment. A [payment](get-payment) will only be created once the customer initiates the payment.

### Example Usage: create-payment-link-201-1

<!-- UsageSnippet language="java" operationID="create-payment-link" method="post" path="/v2/payment-links" example="create-payment-link-201-1" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.*;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.*;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        CreatePaymentLinkResponse res = sdk.paymentLinks().create()
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .xClientSignature("MEUCIQDx8sJvK3z...")
                .xClientSignedAt("2025-01-01T12:00:00Z")
                .requestBody(CreatePaymentLinkRequestBody.builder()
                    .description("Chess Board")
                    .amount(AmountNullable.builder()
                        .currency("EUR")
                        .value("10.00")
                        .build())
                    .minimumAmount(AmountNullable.builder()
                        .currency("EUR")
                        .value("10.00")
                        .build())
                    .redirectUrl("https://webshop.example.org/payment-links/redirect/")
                    .webhookUrl("https://webshop.example.org/payment-links/webhook/")
                    .lines(List.of(
                        PaymentLineItem.builder()
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
                            .build()))
                    .billingAddress(PaymentAddress.builder()
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
                    .profileId("pfl_QkEhN94Ba")
                    .reusable(false)
                    .expiresAt("2025-12-24T11:00:16+00:00")
                    .allowedMethods(List.of(
                        PaymentLinkMethod.IDEAL))
                    .applicationFee(ApplicationFee.builder()
                        .amount(Amount.builder()
                            .currency("EUR")
                            .value("10.00")
                            .build())
                        .description("Platform fee")
                        .build())
                    .sequenceType(PaymentLinkSequenceType.ONEOFF)
                    .customerId("cst_XimFHuaEzd")
                    .testmode(false)
                    .build())
                .call();

        if (res.paymentLinkResponse().isPresent()) {
            System.out.println(res.paymentLinkResponse().get());
        }
    }
}
```
### Example Usage: create-payment-link-201-2

<!-- UsageSnippet language="java" operationID="create-payment-link" method="post" path="/v2/payment-links" example="create-payment-link-201-2" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.*;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.*;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        CreatePaymentLinkResponse res = sdk.paymentLinks().create()
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .xClientSignature("MEUCIQDx8sJvK3z...")
                .xClientSignedAt("2025-01-01T12:00:00Z")
                .requestBody(CreatePaymentLinkRequestBody.builder()
                    .description("Chess Board")
                    .amount(AmountNullable.builder()
                        .currency("EUR")
                        .value("10.00")
                        .build())
                    .minimumAmount(AmountNullable.builder()
                        .currency("EUR")
                        .value("10.00")
                        .build())
                    .redirectUrl("https://webshop.example.org/payment-links/redirect/")
                    .webhookUrl("https://webshop.example.org/payment-links/webhook/")
                    .lines(List.of(
                        PaymentLineItem.builder()
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
                            .build()))
                    .billingAddress(PaymentAddress.builder()
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
                    .profileId("pfl_QkEhN94Ba")
                    .reusable(false)
                    .expiresAt("2025-12-24T11:00:16+00:00")
                    .allowedMethods(List.of(
                        PaymentLinkMethod.IDEAL))
                    .applicationFee(ApplicationFee.builder()
                        .amount(Amount.builder()
                            .currency("EUR")
                            .value("10.00")
                            .build())
                        .description("Platform fee")
                        .build())
                    .sequenceType(PaymentLinkSequenceType.ONEOFF)
                    .customerId("cst_XimFHuaEzd")
                    .testmode(false)
                    .build())
                .call();

        if (res.paymentLinkResponse().isPresent()) {
            System.out.println(res.paymentLinkResponse().get());
        }
    }
}
```
### Example Usage: create-payment-link-201-3

<!-- UsageSnippet language="java" operationID="create-payment-link" method="post" path="/v2/payment-links" example="create-payment-link-201-3" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.*;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.*;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        CreatePaymentLinkResponse res = sdk.paymentLinks().create()
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .xClientSignature("MEUCIQDx8sJvK3z...")
                .xClientSignedAt("2025-01-01T12:00:00Z")
                .requestBody(CreatePaymentLinkRequestBody.builder()
                    .description("Chess Board")
                    .amount(AmountNullable.builder()
                        .currency("EUR")
                        .value("10.00")
                        .build())
                    .minimumAmount(AmountNullable.builder()
                        .currency("EUR")
                        .value("10.00")
                        .build())
                    .redirectUrl("https://webshop.example.org/payment-links/redirect/")
                    .webhookUrl("https://webshop.example.org/payment-links/webhook/")
                    .lines(List.of(
                        PaymentLineItem.builder()
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
                            .build()))
                    .billingAddress(PaymentAddress.builder()
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
                    .profileId("pfl_QkEhN94Ba")
                    .reusable(false)
                    .expiresAt("2025-12-24T11:00:16+00:00")
                    .allowedMethods(List.of(
                        PaymentLinkMethod.IDEAL))
                    .applicationFee(ApplicationFee.builder()
                        .amount(Amount.builder()
                            .currency("EUR")
                            .value("10.00")
                            .build())
                        .description("Platform fee")
                        .build())
                    .sequenceType(PaymentLinkSequenceType.ONEOFF)
                    .customerId("cst_XimFHuaEzd")
                    .testmode(false)
                    .build())
                .call();

        if (res.paymentLinkResponse().isPresent()) {
            System.out.println(res.paymentLinkResponse().get());
        }
    }
}
```
### Example Usage: create-payment-link-201-4

<!-- UsageSnippet language="java" operationID="create-payment-link" method="post" path="/v2/payment-links" example="create-payment-link-201-4" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.*;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.*;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        CreatePaymentLinkResponse res = sdk.paymentLinks().create()
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .xClientSignature("MEUCIQDx8sJvK3z...")
                .xClientSignedAt("2025-01-01T12:00:00Z")
                .requestBody(CreatePaymentLinkRequestBody.builder()
                    .description("Chess Board")
                    .amount(AmountNullable.builder()
                        .currency("EUR")
                        .value("10.00")
                        .build())
                    .minimumAmount(AmountNullable.builder()
                        .currency("EUR")
                        .value("10.00")
                        .build())
                    .redirectUrl("https://webshop.example.org/payment-links/redirect/")
                    .webhookUrl("https://webshop.example.org/payment-links/webhook/")
                    .lines(List.of(
                        PaymentLineItem.builder()
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
                            .build()))
                    .billingAddress(PaymentAddress.builder()
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
                    .profileId("pfl_QkEhN94Ba")
                    .reusable(false)
                    .expiresAt("2025-12-24T11:00:16+00:00")
                    .allowedMethods(List.of(
                        PaymentLinkMethod.IDEAL))
                    .applicationFee(ApplicationFee.builder()
                        .amount(Amount.builder()
                            .currency("EUR")
                            .value("10.00")
                            .build())
                        .description("Platform fee")
                        .build())
                    .sequenceType(PaymentLinkSequenceType.ONEOFF)
                    .customerId("cst_XimFHuaEzd")
                    .testmode(false)
                    .build())
                .call();

        if (res.paymentLinkResponse().isPresent()) {
            System.out.println(res.paymentLinkResponse().get());
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
| `requestBody`                                                                                                                                                                           | [Optional\<CreatePaymentLinkRequestBody>](../../models/operations/CreatePaymentLinkRequestBody.md)                                                                                      | :heavy_minus_sign:                                                                                                                                                                      | N/A                                                                                                                                                                                     |                                                                                                                                                                                         |

### Response

**[CreatePaymentLinkResponse](../../models/operations/CreatePaymentLinkResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 404, 422, 429               | application/hal+json        |
| models/errors/APIException  | 4XX, 5XX                    | \*/\*                       |

## list

Retrieve a list of all payment links.

The results are paginated.

### Example Usage: list-payment-links-200-1

<!-- UsageSnippet language="java" operationID="list-payment-links" method="get" path="/v2/payment-links" example="list-payment-links-200-1" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.ListPaymentLinksRequest;
import com.mollie.mollie.models.operations.ListPaymentLinksResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .testmode(false)
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        ListPaymentLinksRequest req = ListPaymentLinksRequest.builder()
                .from("pl_d9fQur83kFdhH8hIhaZfq")
                .limit(50L)
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .xClientSignature("MEUCIQDx8sJvK3z...")
                .xClientSignedAt("2025-01-01T12:00:00Z")
                .build();


        sdk.paymentLinks().list()
                .callAsStream()
                .forEach((ListPaymentLinksResponse item) -> {
                   // handle page
                });

    }
}
```
### Example Usage: list-payment-links-200-2

<!-- UsageSnippet language="java" operationID="list-payment-links" method="get" path="/v2/payment-links" example="list-payment-links-200-2" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.ListPaymentLinksRequest;
import com.mollie.mollie.models.operations.ListPaymentLinksResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .testmode(false)
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        ListPaymentLinksRequest req = ListPaymentLinksRequest.builder()
                .from("pl_d9fQur83kFdhH8hIhaZfq")
                .limit(50L)
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .xClientSignature("MEUCIQDx8sJvK3z...")
                .xClientSignedAt("2025-01-01T12:00:00Z")
                .build();


        sdk.paymentLinks().list()
                .callAsStream()
                .forEach((ListPaymentLinksResponse item) -> {
                   // handle page
                });

    }
}
```

### Parameters

| Parameter                                                                     | Type                                                                          | Required                                                                      | Description                                                                   |
| ----------------------------------------------------------------------------- | ----------------------------------------------------------------------------- | ----------------------------------------------------------------------------- | ----------------------------------------------------------------------------- |
| `request`                                                                     | [ListPaymentLinksRequest](../../models/operations/ListPaymentLinksRequest.md) | :heavy_check_mark:                                                            | The request object to use for the request.                                    |

### Response

**[ListPaymentLinksResponse](../../models/operations/ListPaymentLinksResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 400, 429                    | application/hal+json        |
| models/errors/APIException  | 4XX, 5XX                    | \*/\*                       |

## get

Retrieve a single payment link by its ID.

### Example Usage

<!-- UsageSnippet language="java" operationID="get-payment-link" method="get" path="/v2/payment-links/{paymentLinkId}" example="get-payment-link-200-1" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.GetPaymentLinkRequest;
import com.mollie.mollie.models.operations.GetPaymentLinkResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .testmode(false)
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        GetPaymentLinkRequest req = GetPaymentLinkRequest.builder()
                .paymentLinkId("pl_d9fQur83kFdhH8hIhaZfq")
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .xClientSignature("MEUCIQDx8sJvK3z...")
                .xClientSignedAt("2025-01-01T12:00:00Z")
                .build();

        GetPaymentLinkResponse res = sdk.paymentLinks().get()
                .request(req)
                .call();

        if (res.paymentLinkResponse().isPresent()) {
            System.out.println(res.paymentLinkResponse().get());
        }
    }
}
```

### Parameters

| Parameter                                                                 | Type                                                                      | Required                                                                  | Description                                                               |
| ------------------------------------------------------------------------- | ------------------------------------------------------------------------- | ------------------------------------------------------------------------- | ------------------------------------------------------------------------- |
| `request`                                                                 | [GetPaymentLinkRequest](../../models/operations/GetPaymentLinkRequest.md) | :heavy_check_mark:                                                        | The request object to use for the request.                                |

### Response

**[GetPaymentLinkResponse](../../models/operations/GetPaymentLinkResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 404, 429                    | application/hal+json        |
| models/errors/APIException  | 4XX, 5XX                    | \*/\*                       |

## update

Certain details of an existing payment link can be updated.

### Example Usage

<!-- UsageSnippet language="java" operationID="update-payment-link" method="patch" path="/v2/payment-links/{paymentLinkId}" example="update-payment-link-200-1" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.*;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.*;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        UpdatePaymentLinkRequest req = UpdatePaymentLinkRequest.builder()
                .paymentLinkId("pl_d9fQur83kFdhH8hIhaZfq")
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .xClientSignature("MEUCIQDx8sJvK3z...")
                .xClientSignedAt("2025-01-01T12:00:00Z")
                .requestBody(UpdatePaymentLinkRequestBody.builder()
                    .description("Chess Board")
                    .minimumAmount(Amount.builder()
                        .currency("EUR")
                        .value("10.00")
                        .build())
                    .archived(false)
                    .allowedMethods(List.of(
                        PaymentLinkMethod.IDEAL))
                    .lines(List.of(
                        PaymentLineItem.builder()
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
                            .build()))
                    .billingAddress(PaymentAddress.builder()
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
                    .testmode(false)
                    .build())
                .build();

        UpdatePaymentLinkResponse res = sdk.paymentLinks().update()
                .request(req)
                .call();

        if (res.paymentLinkResponse().isPresent()) {
            System.out.println(res.paymentLinkResponse().get());
        }
    }
}
```

### Parameters

| Parameter                                                                       | Type                                                                            | Required                                                                        | Description                                                                     |
| ------------------------------------------------------------------------------- | ------------------------------------------------------------------------------- | ------------------------------------------------------------------------------- | ------------------------------------------------------------------------------- |
| `request`                                                                       | [UpdatePaymentLinkRequest](../../models/operations/UpdatePaymentLinkRequest.md) | :heavy_check_mark:                                                              | The request object to use for the request.                                      |

### Response

**[UpdatePaymentLinkResponse](../../models/operations/UpdatePaymentLinkResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 404, 422, 429               | application/hal+json        |
| models/errors/APIException  | 4XX, 5XX                    | \*/\*                       |

## delete

Payment links which have not been opened and no payments have been made yet can be deleted entirely.
This can be useful for removing payment links that have been incorrectly configured or that are no longer relevant.

Once deleted, the payment link will no longer show up in the API or Mollie dashboard.

To simply disable a payment link without fully deleting it, you can use the `archived` parameter on the
[Update payment link](update-payment-link) endpoint instead.

### Example Usage

<!-- UsageSnippet language="java" operationID="delete-payment-link" method="delete" path="/v2/payment-links/{paymentLinkId}" -->
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

        DeletePaymentLinkRequest req = DeletePaymentLinkRequest.builder()
                .paymentLinkId("pl_d9fQur83kFdhH8hIhaZfq")
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .xClientSignature("MEUCIQDx8sJvK3z...")
                .xClientSignedAt("2025-01-01T12:00:00Z")
                .requestBody(DeletePaymentLinkRequestBody.builder()
                    .testmode(false)
                    .build())
                .build();

        DeletePaymentLinkResponse res = sdk.paymentLinks().delete()
                .request(req)
                .call();

        // handle response
    }
}
```

### Parameters

| Parameter                                                                       | Type                                                                            | Required                                                                        | Description                                                                     |
| ------------------------------------------------------------------------------- | ------------------------------------------------------------------------------- | ------------------------------------------------------------------------------- | ------------------------------------------------------------------------------- |
| `request`                                                                       | [DeletePaymentLinkRequest](../../models/operations/DeletePaymentLinkRequest.md) | :heavy_check_mark:                                                              | The request object to use for the request.                                      |

### Response

**[DeletePaymentLinkResponse](../../models/operations/DeletePaymentLinkResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 404, 422, 429               | application/hal+json        |
| models/errors/APIException  | 4XX, 5XX                    | \*/\*                       |

## listPayments

Retrieve the list of payments for a specific payment link.

The results are paginated.

### Example Usage

<!-- UsageSnippet language="java" operationID="get-payment-link-payments" method="get" path="/v2/payment-links/{paymentLinkId}/payments" example="get-payment-link-payments-200-1" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.components.Sorting;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.GetPaymentLinkPaymentsRequest;
import com.mollie.mollie.models.operations.GetPaymentLinkPaymentsResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .testmode(false)
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        GetPaymentLinkPaymentsRequest req = GetPaymentLinkPaymentsRequest.builder()
                .paymentLinkId("pl_d9fQur83kFdhH8hIhaZfq")
                .from("tr_5B8cwPMGnU")
                .limit(50L)
                .sort(Sorting.DESC)
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .xClientSignature("MEUCIQDx8sJvK3z...")
                .xClientSignedAt("2025-01-01T12:00:00Z")
                .build();


        sdk.paymentLinks().listPayments()
                .callAsStream()
                .forEach((GetPaymentLinkPaymentsResponse item) -> {
                   // handle page
                });

    }
}
```

### Parameters

| Parameter                                                                                 | Type                                                                                      | Required                                                                                  | Description                                                                               |
| ----------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------- |
| `request`                                                                                 | [GetPaymentLinkPaymentsRequest](../../models/operations/GetPaymentLinkPaymentsRequest.md) | :heavy_check_mark:                                                                        | The request object to use for the request.                                                |

### Response

**[GetPaymentLinkPaymentsResponse](../../models/operations/GetPaymentLinkPaymentsResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 400, 429                    | application/hal+json        |
| models/errors/APIException  | 4XX, 5XX                    | \*/\*                       |