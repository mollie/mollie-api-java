# Wallets

## Overview

### Available Operations

* [requestApplePaySession](#requestapplepaysession) - Request Apple Pay payment session

## requestApplePaySession

When integrating Apple Pay in your own checkout on the web, you need to
[provide merchant validation](https://developer.apple.com/documentation/apple_pay_on_the_web/apple_pay_js_api/providing_merchant_validation).
This is normally done using Apple's
[Requesting an Apple Pay Session](https://developer.apple.com/documentation/apple_pay_on_the_web/apple_pay_js_api/requesting_an_apple_pay_payment_session).
The merchant validation proves to Apple that a validated merchant is calling the Apple Pay Javascript APIs.

To integrate Apple Pay via Mollie, you will have to call the Mollie API instead of Apple's API. The response of this
API call can then be passed as-is to the completion method, `completeMerchantValidation`.

Before requesting an Apple Pay Payment Session, you must place the domain validation file on your server at:
`https://[domain]/.well-known/apple-developer-merchantid-domain-association`. Without this file, it will not be
possible to use Apple Pay on your domain.

Each new transaction requires a new payment session object. Merchant session objects are not reusable, and they
expire after five minutes.

Payment sessions cannot be requested directly from the browser. The request must be sent from your server. For the
full documentation, see the official
[Apple Pay JS API](https://developer.apple.com/documentation/apple_pay_on_the_web/apple_pay_js_api) documentation.

### Example Usage

<!-- UsageSnippet language="java" operationID="request-apple-pay-payment-session" method="post" path="/wallets/applepay/sessions" example="request-apple-pay-payment-session-201-1" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.RequestApplePayPaymentSessionRequestBody;
import com.mollie.mollie.models.operations.RequestApplePayPaymentSessionResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        RequestApplePayPaymentSessionResponse res = sdk.wallets().requestApplePaySession()
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .requestBody(RequestApplePayPaymentSessionRequestBody.builder()
                    .validationUrl("https://apple-pay-gateway-cert.apple.com/paymentservices/paymentSession")
                    .domain("pay.myshop.com")
                    .profileId("pfl_5B8cwPMGnU")
                    .build())
                .call();

        if (res.entitySession().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                                  | Type                                                                                                                       | Required                                                                                                                   | Description                                                                                                                | Example                                                                                                                    |
| -------------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------- |
| `idempotencyKey`                                                                                                           | *Optional\<String>*                                                                                                        | :heavy_minus_sign:                                                                                                         | A unique key to ensure idempotent requests. This key should be a UUID v4 string.                                           | 123e4567-e89b-12d3-a456-426                                                                                                |
| `requestBody`                                                                                                              | [Optional\<RequestApplePayPaymentSessionRequestBody>](../../models/operations/RequestApplePayPaymentSessionRequestBody.md) | :heavy_minus_sign:                                                                                                         | N/A                                                                                                                        |                                                                                                                            |

### Response

**[RequestApplePayPaymentSessionResponse](../../models/operations/RequestApplePayPaymentSessionResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 422                         | application/hal+json        |
| models/errors/APIException  | 4XX, 5XX                    | \*/\*                       |