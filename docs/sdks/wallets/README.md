# Wallets
(*wallets()*)

## Overview

### Available Operations

* [requestApplePaySession](#requestapplepaysession) - Request Apple Pay payment session

## requestApplePaySession

When integrating Apple Pay in your own checkout on the web, you need to [provide merchant validation](https://developer.apple.com/documentation/apple_pay_on_the_web/apple_pay_js_api/providing_merchant_validation). This is normally done using Apple's [Requesting an Apple Pay Session](https://developer.apple.com/documentation/apple_pay_on_the_web/apple_pay_js_api/requesting_an_apple_pay_payment_session). The merchant validation proves to Apple that a validated merchant is calling the Apple Pay Javascript APIs.

To integrate Apple Pay via Mollie, you will have to call the Mollie API instead of Apple's API. The response of this API call can then be passed as-is to the completion method, `completeMerchantValidation`.

Before requesting an Apple Pay Payment Session, you must place the domain validation file on your server at: `https://[domain]/.well-known/apple-developer-merchantid-domain-association`. Without this file, it will not be possible to use Apple Pay on your domain.

Each new transaction requires a new payment session object. Merchant session objects are not reusable, and they expire after five minutes.

Payment sessions cannot be requested directly from the browser. The request must be sent from your server. For the full documentation, see the official [Apple Pay JS API](https://developer.apple.com/documentation/apple_pay_on_the_web/apple_pay_js_api) documentation.

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
import com.mollie.mollie.models.errors.RequestApplePayPaymentSessionResponseBody;
import com.mollie.mollie.models.operations.RequestApplePayPaymentSessionRequestBody;
import com.mollie.mollie.models.operations.RequestApplePayPaymentSessionResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws RequestApplePayPaymentSessionResponseBody, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey("<YOUR_BEARER_TOKEN_HERE>")
                    .build())
            .build();

        RequestApplePayPaymentSessionRequestBody req = RequestApplePayPaymentSessionRequestBody.builder()
                .validationUrl("https://apple-pay-gateway-cert.apple.com/paymentservices/paymentSession")
                .domain("pay.myshop.com")
                .profileId("pfl_5B8cwPMGnU")
                .build();

        RequestApplePayPaymentSessionResponse res = sdk.wallets().requestApplePaySession()
                .request(req)
                .call();

        if (res.object().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                       | Type                                                                                                            | Required                                                                                                        | Description                                                                                                     |
| --------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------- |
| `request`                                                                                                       | [RequestApplePayPaymentSessionRequestBody](../../models/operations/RequestApplePayPaymentSessionRequestBody.md) | :heavy_check_mark:                                                                                              | The request object to use for the request.                                                                      |

### Response

**[RequestApplePayPaymentSessionResponse](../../models/operations/RequestApplePayPaymentSessionResponse.md)**

### Errors

| Error Type                                              | Status Code                                             | Content Type                                            |
| ------------------------------------------------------- | ------------------------------------------------------- | ------------------------------------------------------- |
| models/errors/RequestApplePayPaymentSessionResponseBody | 422                                                     | application/hal+json                                    |
| models/errors/APIException                              | 4XX, 5XX                                                | \*/\*                                                   |