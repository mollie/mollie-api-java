# Sessions

## Overview

### Available Operations

* [create](#create) - Create session
* [get](#get) - Get session

## create

> 🚧 Beta feature
>
> This feature is currently in private beta, and the final specification may still change.

Create a session to start a checkout process with Mollie Components.

### Example Usage

<!-- UsageSnippet language="java" operationID="create-session" method="post" path="/v2/sessions" example="create-session-201-1" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.*;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.CreateSessionResponse;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        CreateSessionResponse res = sdk.sessions().create()
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .sessionRequest(SessionRequest.builder()
                    .amount(Amount.builder()
                        .currency("EUR")
                        .value("10.00")
                        .build())
                    .description("Order #12345")
                    .lines(List.of())
                    .redirectUrl("https://example.org/redirect")
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
                    .customerId("cst_5B8cwPMGnU")
                    .sequenceType(SessionSequenceType.ONEOFF)
                    .payment(Payment.builder()
                        .webhookUrl("https://example.org/webhook")
                        .build())
                    .profileId("pfl_5B8cwPMGnU")
                    .testmode(false)
                    .build())
                .call();

        if (res.sessionResponse().isPresent()) {
            System.out.println(res.sessionResponse().get());
        }
    }
}
```

### Parameters

| Parameter                                                                        | Type                                                                             | Required                                                                         | Description                                                                      | Example                                                                          |
| -------------------------------------------------------------------------------- | -------------------------------------------------------------------------------- | -------------------------------------------------------------------------------- | -------------------------------------------------------------------------------- | -------------------------------------------------------------------------------- |
| `idempotencyKey`                                                                 | *Optional\<String>*                                                              | :heavy_minus_sign:                                                               | A unique key to ensure idempotent requests. This key should be a UUID v4 string. | 123e4567-e89b-12d3-a456-426                                                      |
| `sessionRequest`                                                                 | [Optional\<SessionRequest>](../../models/components/SessionRequest.md)           | :heavy_minus_sign:                                                               | N/A                                                                              |                                                                                  |

### Response

**[CreateSessionResponse](../../models/operations/CreateSessionResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 422                         | application/hal+json        |
| models/errors/APIException  | 4XX, 5XX                    | \*/\*                       |

## get

> 🚧 Beta feature
>
> This feature is currently in private beta, and the final specification may still change.

Retrieve a session to view its details and status to inform your customers about the checkout process.

### Example Usage

<!-- UsageSnippet language="java" operationID="get-session" method="get" path="/v2/sessions/{sessionId}" example="get-session-200-1" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.operations.GetSessionResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        GetSessionResponse res = sdk.sessions().get()
                .sessionId("sess_82jFYDTrLcCQV68NLDvMJ")
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .call();

        if (res.sessionResponse().isPresent()) {
            System.out.println(res.sessionResponse().get());
        }
    }
}
```

### Parameters

| Parameter                                                                        | Type                                                                             | Required                                                                         | Description                                                                      | Example                                                                          |
| -------------------------------------------------------------------------------- | -------------------------------------------------------------------------------- | -------------------------------------------------------------------------------- | -------------------------------------------------------------------------------- | -------------------------------------------------------------------------------- |
| `sessionId`                                                                      | *String*                                                                         | :heavy_check_mark:                                                               | Provide the ID of the related session.                                           | sess_82jFYDTrLcCQV68NLDvMJ                                                       |
| `idempotencyKey`                                                                 | *Optional\<String>*                                                              | :heavy_minus_sign:                                                               | A unique key to ensure idempotent requests. This key should be a UUID v4 string. | 123e4567-e89b-12d3-a456-426                                                      |

### Response

**[GetSessionResponse](../../models/operations/GetSessionResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |