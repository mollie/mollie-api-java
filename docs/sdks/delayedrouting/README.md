# DelayedRouting
(*delayedRouting()*)

## Overview

### Available Operations

* [create](#create) - Create a delayed route
* [list](#list) - List payment routes

## create

Create a route for a specific payment. The routed amount is credited to the account of your customer.

> 🔑 Access with
>
> [API key](/reference/authentication)

### Example Usage

```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.PaymentCreateRouteResponseBody;
import com.mollie.mollie.models.operations.PaymentCreateRouteAmount;
import com.mollie.mollie.models.operations.PaymentCreateRouteDestination;
import com.mollie.mollie.models.operations.PaymentCreateRouteRequestBody;
import com.mollie.mollie.models.operations.PaymentCreateRouteResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws PaymentCreateRouteResponseBody, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey("<YOUR_BEARER_TOKEN_HERE>")
                    .build())
            .build();

        PaymentCreateRouteResponse res = sdk.delayedRouting().create()
                .paymentId("tr_5B8cwPMGnU6qLbRvo7qEZo")
                .requestBody(PaymentCreateRouteRequestBody.builder()
                    .amount(PaymentCreateRouteAmount.builder()
                        .currency("EUR")
                        .value("10.00")
                        .build())
                    .description("Payment for Order #12345")
                    .destination(PaymentCreateRouteDestination.builder()
                        .organizationId("org_123")
                        .build())
                    .build())
                .call();

        if (res.object().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                            | Type                                                                                                 | Required                                                                                             | Description                                                                                          | Example                                                                                              |
| ---------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------- |
| `paymentId`                                                                                          | *String*                                                                                             | :heavy_check_mark:                                                                                   | Provide the ID of the related payment.                                                               | tr_5B8cwPMGnU6qLbRvo7qEZo                                                                            |
| `requestBody`                                                                                        | [Optional\<PaymentCreateRouteRequestBody>](../../models/operations/PaymentCreateRouteRequestBody.md) | :heavy_minus_sign:                                                                                   | N/A                                                                                                  |                                                                                                      |

### Response

**[PaymentCreateRouteResponse](../../models/operations/PaymentCreateRouteResponse.md)**

### Errors

| Error Type                                   | Status Code                                  | Content Type                                 |
| -------------------------------------------- | -------------------------------------------- | -------------------------------------------- |
| models/errors/PaymentCreateRouteResponseBody | 404                                          | application/hal+json                         |
| models/errors/APIException                   | 4XX, 5XX                                     | \*/\*                                        |

## list

Retrieve a list of all routes created for a specific payment.

> 🔑 Access with
>
> [API key](/reference/authentication)

### Example Usage

```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.PaymentListRoutesResponseBody;
import com.mollie.mollie.models.operations.PaymentListRoutesResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws PaymentListRoutesResponseBody, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey("<YOUR_BEARER_TOKEN_HERE>")
                    .build())
            .build();

        PaymentListRoutesResponse res = sdk.delayedRouting().list()
                .paymentId("tr_5B8cwPMGnU6qLbRvo7qEZo")
                .call();

        if (res.object().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                              | Type                                   | Required                               | Description                            | Example                                |
| -------------------------------------- | -------------------------------------- | -------------------------------------- | -------------------------------------- | -------------------------------------- |
| `paymentId`                            | *String*                               | :heavy_check_mark:                     | Provide the ID of the related payment. | tr_5B8cwPMGnU6qLbRvo7qEZo              |

### Response

**[PaymentListRoutesResponse](../../models/operations/PaymentListRoutesResponse.md)**

### Errors

| Error Type                                  | Status Code                                 | Content Type                                |
| ------------------------------------------- | ------------------------------------------- | ------------------------------------------- |
| models/errors/PaymentListRoutesResponseBody | 404                                         | application/hal+json                        |
| models/errors/APIException                  | 4XX, 5XX                                    | \*/\*                                       |