# DelayedRoutingAPI
(*delayedRoutingAPI()*)

## Overview

### Available Operations

* [create](#create) - Create a delayed route
* [list](#list) - List payment routes

## create

Create a route for a specific payment.
The routed amount is credited to the account of your customer.

### Example Usage

```java
package hello.world;

import com.mollie.mollie.Mollie;
import com.mollie.mollie.models.errors.PaymentCreateRouteResponseBody;
import com.mollie.mollie.models.operations.PaymentCreateRouteAmount;
import com.mollie.mollie.models.operations.PaymentCreateRouteDestination;
import com.mollie.mollie.models.operations.PaymentCreateRouteRequestBody;
import com.mollie.mollie.models.operations.PaymentCreateRouteResponse;
import com.mollie.mollie.models.operations.PaymentCreateRouteSecurity;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws PaymentCreateRouteResponseBody, Exception {

        Mollie sdk = Mollie.builder()
            .build();

        PaymentCreateRouteResponse res = sdk.delayedRoutingAPI().create()
                .security(PaymentCreateRouteSecurity.builder()
                    .apiKey("<YOUR_BEARER_TOKEN_HERE>")
                    .build())
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

| Parameter                                                                                                               | Type                                                                                                                    | Required                                                                                                                | Description                                                                                                             | Example                                                                                                                 |
| ----------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------- |
| `security`                                                                                                              | [com.mollie.mollie.models.operations.PaymentCreateRouteSecurity](../../models/operations/PaymentCreateRouteSecurity.md) | :heavy_check_mark:                                                                                                      | The security requirements to use for the request.                                                                       |                                                                                                                         |
| `paymentId`                                                                                                             | *String*                                                                                                                | :heavy_check_mark:                                                                                                      | Provide the ID of the related payment.                                                                                  | tr_5B8cwPMGnU6qLbRvo7qEZo                                                                                               |
| `requestBody`                                                                                                           | [Optional\<PaymentCreateRouteRequestBody>](../../models/operations/PaymentCreateRouteRequestBody.md)                    | :heavy_minus_sign:                                                                                                      | N/A                                                                                                                     |                                                                                                                         |

### Response

**[PaymentCreateRouteResponse](../../models/operations/PaymentCreateRouteResponse.md)**

### Errors

| Error Type                                   | Status Code                                  | Content Type                                 |
| -------------------------------------------- | -------------------------------------------- | -------------------------------------------- |
| models/errors/PaymentCreateRouteResponseBody | 404                                          | application/hal+json                         |
| models/errors/APIException                   | 4XX, 5XX                                     | \*/\*                                        |

## list

Retrieve a list of all routes created for a specific payment.

### Example Usage

```java
package hello.world;

import com.mollie.mollie.Mollie;
import com.mollie.mollie.models.errors.PaymentListRoutesResponseBody;
import com.mollie.mollie.models.operations.PaymentListRoutesResponse;
import com.mollie.mollie.models.operations.PaymentListRoutesSecurity;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws PaymentListRoutesResponseBody, Exception {

        Mollie sdk = Mollie.builder()
            .build();

        PaymentListRoutesResponse res = sdk.delayedRoutingAPI().list()
                .security(PaymentListRoutesSecurity.builder()
                    .apiKey("<YOUR_BEARER_TOKEN_HERE>")
                    .build())
                .paymentId("tr_5B8cwPMGnU6qLbRvo7qEZo")
                .call();

        if (res.object().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                             | Type                                                                                                                  | Required                                                                                                              | Description                                                                                                           | Example                                                                                                               |
| --------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------- |
| `security`                                                                                                            | [com.mollie.mollie.models.operations.PaymentListRoutesSecurity](../../models/operations/PaymentListRoutesSecurity.md) | :heavy_check_mark:                                                                                                    | The security requirements to use for the request.                                                                     |                                                                                                                       |
| `paymentId`                                                                                                           | *String*                                                                                                              | :heavy_check_mark:                                                                                                    | Provide the ID of the related payment.                                                                                | tr_5B8cwPMGnU6qLbRvo7qEZo                                                                                             |

### Response

**[PaymentListRoutesResponse](../../models/operations/PaymentListRoutesResponse.md)**

### Errors

| Error Type                                  | Status Code                                 | Content Type                                |
| ------------------------------------------- | ------------------------------------------- | ------------------------------------------- |
| models/errors/PaymentListRoutesResponseBody | 404                                         | application/hal+json                        |
| models/errors/APIException                  | 4XX, 5XX                                    | \*/\*                                       |