# Payments
(*payments()*)

## Overview

### Available Operations

* [create](#create) - Create payment
* [list](#list) - List payments
* [get](#get) - Get payment
* [update](#update) - Update payment
* [cancel](#cancel) - Cancel payment
* [releaseAuthorization](#releaseauthorization) - Release payment authorization

## create

Payment creation is elemental to the Mollie API: this is where most payment
implementations start off.

Once you have created a payment, you should redirect your customer to the
URL in the `_links.checkout` property from the response.

To wrap your head around the payment process, an explanation and flow charts
can be found in the 'Accepting payments' guide.

If you specify the `method` parameter when creating a payment, optional
additional parameters may be available for the payment method that are not listed below. Please refer to the
guide on [method-specific parameters](extra-payment-parameters).

### Example Usage

<!-- UsageSnippet language="java" operationID="create-payment" method="post" path="/payments" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.*;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.CreatePaymentResponse;
import java.lang.Exception;
import java.time.LocalDate;
import java.util.List;

public class Application {

    public static void main(String[] args) throws ErrorResponse, ErrorResponse, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        CreatePaymentResponse res = sdk.payments().create()
                .include("details.qrCode")
                .paymentRequest(PaymentRequest.builder()
                    .id("tr_5B8cwPMGnU")
                    .description("Chess Board")
                    .amount(Amount.builder()
                        .currency("EUR")
                        .value("10.00")
                        .build())
                    .amountRefunded(Amount.builder()
                        .currency("EUR")
                        .value("10.00")
                        .build())
                    .amountRemaining(Amount.builder()
                        .currency("EUR")
                        .value("10.00")
                        .build())
                    .amountCaptured(Amount.builder()
                        .currency("EUR")
                        .value("10.00")
                        .build())
                    .amountChargedBack(Amount.builder()
                        .currency("EUR")
                        .value("10.00")
                        .build())
                    .settlementAmount(Amount.builder()
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
                                PaymentRequestCategories.MEAL,
                                PaymentRequestCategories.ECO))
                            .imageUrl("https://...")
                            .productUrl("https://...")
                            .recurring(RecurringLineItem.builder()
                                .interval("... days")
                                .description("Gym subscription")
                                .amount(Amount.builder()
                                    .currency("EUR")
                                    .value("10.00")
                                    .build())
                                .times(1L)
                                .startDate("2024-12-12")
                                .build())
                            .build(),
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
                                PaymentRequestCategories.MEAL,
                                PaymentRequestCategories.ECO))
                            .imageUrl("https://...")
                            .productUrl("https://...")
                            .recurring(RecurringLineItem.builder()
                                .interval("... weeks")
                                .description("Gym subscription")
                                .amount(Amount.builder()
                                    .currency("EUR")
                                    .value("10.00")
                                    .build())
                                .times(1L)
                                .startDate("2024-12-12")
                                .build())
                            .build(),
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
                                PaymentRequestCategories.MEAL,
                                PaymentRequestCategories.ECO))
                            .imageUrl("https://...")
                            .productUrl("https://...")
                            .recurring(RecurringLineItem.builder()
                                .interval("... days")
                                .description("Gym subscription")
                                .amount(Amount.builder()
                                    .currency("EUR")
                                    .value("10.00")
                                    .build())
                                .times(1L)
                                .startDate("2024-12-12")
                                .build())
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
                    .locale(Locale.EN_US)
                    .method(Method.IDEAL)
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
                            .id("rt_5B8cwPMGnU")
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
                            .id("rt_5B8cwPMGnU")
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
                    .subscriptionId("sub_5B8cwPMGnU")
                    .mandateId("mdt_5B8cwPMGnU")
                    .customerId("cst_5B8cwPMGnU")
                    .profileId("pfl_5B8cwPMGnU")
                    .settlementId("stl_5B8cwPMGnU")
                    .orderId("ord_5B8cwPMGnU")
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

| Parameter                                                                                            | Type                                                                                                 | Required                                                                                             | Description                                                                                          |
| ---------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------- |
| `include`                                                                                            | *JsonNullable\<String>*                                                                              | :heavy_minus_sign:                                                                                   | This endpoint allows you to include additional information via the `include` query string parameter. |
| `paymentRequest`                                                                                     | [Optional\<PaymentRequest>](../../models/components/PaymentRequest.md)                               | :heavy_minus_sign:                                                                                   | N/A                                                                                                  |

### Response

**[CreatePaymentResponse](../../models/operations/CreatePaymentResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 422                         | application/hal+json        |
| models/errors/ErrorResponse | 503                         | application/hal+json        |
| models/errors/APIException  | 4XX, 5XX                    | \*/\*                       |

## list

Retrieve all payments created with the current website profile.

The results are paginated.

### Example Usage

<!-- UsageSnippet language="java" operationID="list-payments" method="get" path="/payments" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.ListSort;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.ListPaymentsRequest;
import com.mollie.mollie.models.operations.ListPaymentsResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        ListPaymentsRequest req = ListPaymentsRequest.builder()
                .from("tr_5B8cwPMGnU")
                .limit(50L)
                .sort(ListSort.DESC)
                .profileId("pfl_5B8cwPMGnU")
                .testmode(false)
                .build();

        ListPaymentsResponse res = sdk.payments().list()
                .request(req)
                .call();

        if (res.object().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                             | Type                                                                  | Required                                                              | Description                                                           |
| --------------------------------------------------------------------- | --------------------------------------------------------------------- | --------------------------------------------------------------------- | --------------------------------------------------------------------- |
| `request`                                                             | [ListPaymentsRequest](../../models/operations/ListPaymentsRequest.md) | :heavy_check_mark:                                                    | The request object to use for the request.                            |

### Response

**[ListPaymentsResponse](../../models/operations/ListPaymentsResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 400                         | application/hal+json        |
| models/errors/APIException  | 4XX, 5XX                    | \*/\*                       |

## get

Retrieve a single payment object by its payment ID.

### Example Usage

<!-- UsageSnippet language="java" operationID="get-payment" method="get" path="/payments/{paymentId}" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.GetPaymentResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        GetPaymentResponse res = sdk.payments().get()
                .paymentId("tr_5B8cwPMGnU")
                .include("details.qrCode")
                .embed("captures")
                .testmode(false)
                .call();

        if (res.paymentResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                                                                                                                                                                                                                                                                                              | Type                                                                                                                                                                                                                                                                                                                                                                                   | Required                                                                                                                                                                                                                                                                                                                                                                               | Description                                                                                                                                                                                                                                                                                                                                                                            | Example                                                                                                                                                                                                                                                                                                                                                                                |
| -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `paymentId`                                                                                                                                                                                                                                                                                                                                                                            | *String*                                                                                                                                                                                                                                                                                                                                                                               | :heavy_check_mark:                                                                                                                                                                                                                                                                                                                                                                     | Provide the ID of the related payment.                                                                                                                                                                                                                                                                                                                                                 | tr_5B8cwPMGnU                                                                                                                                                                                                                                                                                                                                                                          |
| `include`                                                                                                                                                                                                                                                                                                                                                                              | *JsonNullable\<String>*                                                                                                                                                                                                                                                                                                                                                                | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                     | This endpoint allows you to include additional information via the `include` query string parameter.                                                                                                                                                                                                                                                                                   |                                                                                                                                                                                                                                                                                                                                                                                        |
| `embed`                                                                                                                                                                                                                                                                                                                                                                                | *JsonNullable\<String>*                                                                                                                                                                                                                                                                                                                                                                | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                     | This endpoint allows embedding related API items by appending the following values via the `embed` query string<br/>parameter.                                                                                                                                                                                                                                                         |                                                                                                                                                                                                                                                                                                                                                                                        |
| `testmode`                                                                                                                                                                                                                                                                                                                                                                             | *JsonNullable\<Boolean>*                                                                                                                                                                                                                                                                                                                                                               | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                     | Most API credentials are specifically created for either live mode or test mode. In those cases the `testmode` query<br/>parameter can be omitted. For organization-level credentials such as OAuth access tokens, you can enable test mode by<br/>setting the `testmode` query parameter to `true`.<br/><br/>Test entities cannot be retrieved when the endpoint is set to live mode, and vice versa. | false                                                                                                                                                                                                                                                                                                                                                                                  |

### Response

**[GetPaymentResponse](../../models/operations/GetPaymentResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 404                         | application/hal+json        |
| models/errors/APIException  | 4XX, 5XX                    | \*/\*                       |

## update

Certain details of an existing payment can be updated.

Updating the payment details will not result in a webhook call.

### Example Usage

<!-- UsageSnippet language="java" operationID="update-payment" method="patch" path="/payments/{paymentId}" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.*;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.UpdatePaymentRequestBody;
import com.mollie.mollie.models.operations.UpdatePaymentResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        UpdatePaymentResponse res = sdk.payments().update()
                .paymentId("tr_5B8cwPMGnU")
                .requestBody(UpdatePaymentRequestBody.builder()
                    .description("Chess Board")
                    .redirectUrl("https://example.org/redirect")
                    .cancelUrl("https://example.org/cancel")
                    .webhookUrl("https://example.org/webhooks")
                    .method(Method.IDEAL)
                    .locale(Locale.EN_US)
                    .dueDate("2025-01-01")
                    .restrictPaymentMethodsToCountry("NL")
                    .testmode(false)
                    .issuer("ideal_INGBNL2A")
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
                    .billingEmail("test@example.com")
                    .build())
                .call();

        if (res.paymentResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                  | Type                                                                                       | Required                                                                                   | Description                                                                                | Example                                                                                    |
| ------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------ |
| `paymentId`                                                                                | *String*                                                                                   | :heavy_check_mark:                                                                         | Provide the ID of the related payment.                                                     | tr_5B8cwPMGnU                                                                              |
| `requestBody`                                                                              | [Optional\<UpdatePaymentRequestBody>](../../models/operations/UpdatePaymentRequestBody.md) | :heavy_minus_sign:                                                                         | N/A                                                                                        |                                                                                            |

### Response

**[UpdatePaymentResponse](../../models/operations/UpdatePaymentResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 404, 422                    | application/hal+json        |
| models/errors/APIException  | 4XX, 5XX                    | \*/\*                       |

## cancel

Depending on the payment method, you may be able to cancel a payment for a certain amount of time — usually until
the next business day or as long as the payment status is open.

Payments may also be canceled manually from the Mollie Dashboard.

The `isCancelable` property on the [Payment object](get-payment) will indicate if the payment can be canceled.

### Example Usage

<!-- UsageSnippet language="java" operationID="cancel-payment" method="delete" path="/payments/{paymentId}" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.CancelPaymentRequestBody;
import com.mollie.mollie.models.operations.CancelPaymentResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        CancelPaymentResponse res = sdk.payments().cancel()
                .paymentId("tr_5B8cwPMGnU")
                .requestBody(CancelPaymentRequestBody.builder()
                    .testmode(false)
                    .build())
                .call();

        if (res.paymentResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                  | Type                                                                                       | Required                                                                                   | Description                                                                                | Example                                                                                    |
| ------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------ |
| `paymentId`                                                                                | *String*                                                                                   | :heavy_check_mark:                                                                         | Provide the ID of the related payment.                                                     | tr_5B8cwPMGnU                                                                              |
| `requestBody`                                                                              | [Optional\<CancelPaymentRequestBody>](../../models/operations/CancelPaymentRequestBody.md) | :heavy_minus_sign:                                                                         | N/A                                                                                        |                                                                                            |

### Response

**[CancelPaymentResponse](../../models/operations/CancelPaymentResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 404, 422                    | application/hal+json        |
| models/errors/APIException  | 4XX, 5XX                    | \*/\*                       |

## releaseAuthorization

Releases the full remaining authorized amount. Call this endpoint when you will not be making any additional
captures. Payment authorizations may also be released manually from the Mollie Dashboard.

Mollie will do its best to process release requests, but it is not guaranteed that it will succeed. It is up to
the issuing bank if and when the hold will be released.

If the request does succeed, the payment status will change to `canceled` for payments without captures.
If there is a successful capture, the payment will transition to `paid`.

### Example Usage

<!-- UsageSnippet language="java" operationID="release-authorization" method="post" path="/payments/{paymentId}/release-authorization" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.ReleaseAuthorizationRequestBody;
import com.mollie.mollie.models.operations.ReleaseAuthorizationResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        ReleaseAuthorizationResponse res = sdk.payments().releaseAuthorization()
                .paymentId("tr_5B8cwPMGnU")
                .requestBody(ReleaseAuthorizationRequestBody.builder()
                    .profileId("pfl_5B8cwPMGnU")
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

| Parameter                                                                                                | Type                                                                                                     | Required                                                                                                 | Description                                                                                              | Example                                                                                                  |
| -------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------- |
| `paymentId`                                                                                              | *String*                                                                                                 | :heavy_check_mark:                                                                                       | Provide the ID of the related payment.                                                                   | tr_5B8cwPMGnU                                                                                            |
| `requestBody`                                                                                            | [Optional\<ReleaseAuthorizationRequestBody>](../../models/operations/ReleaseAuthorizationRequestBody.md) | :heavy_minus_sign:                                                                                       | N/A                                                                                                      |                                                                                                          |

### Response

**[ReleaseAuthorizationResponse](../../models/operations/ReleaseAuthorizationResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 404, 422                    | application/hal+json        |
| models/errors/APIException  | 4XX, 5XX                    | \*/\*                       |