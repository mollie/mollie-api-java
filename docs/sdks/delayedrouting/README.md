# DelayedRouting
(*delayedRouting()*)

## Overview

### Available Operations

* [create](#create) - Create a delayed route
* [list](#list) - List payment routes

## create

Create a route for a specific payment.
The routed amount is credited to the account of your customer.

### Example Usage

<!-- UsageSnippet language="java" operationID="payment-create-route" method="post" path="/payments/{paymentId}/routes" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.PaymentCreateRouteResponseBody;
import com.mollie.mollie.models.operations.*;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws PaymentCreateRouteResponseBody, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        PaymentCreateRouteResponse res = sdk.delayedRouting().create()
                .paymentId("tr_5B8cwPMGnU")
                .requestBody(PaymentCreateRouteRequestBody.builder()
                    .amount(PaymentCreateRouteAmount.builder()
                        .currency("EUR")
                        .value("10.00")
                        .build())
                    .description("Payment for Order #12345")
                    .destination(PaymentCreateRouteDestination.builder()
                        .type(PaymentCreateRouteType.ORGANIZATION)
                        .organizationId("org_1234567")
                        .build())
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

| Parameter                                                                                            | Type                                                                                                 | Required                                                                                             | Description                                                                                          | Example                                                                                              |
| ---------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------- |
| `paymentId`                                                                                          | *String*                                                                                             | :heavy_check_mark:                                                                                   | Provide the ID of the related payment.                                                               | tr_5B8cwPMGnU                                                                                        |
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

### Example Usage

<!-- UsageSnippet language="java" operationID="payment-list-routes" method="get" path="/payments/{paymentId}/routes" -->
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
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        PaymentListRoutesResponse res = sdk.delayedRouting().list()
                .paymentId("tr_5B8cwPMGnU")
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
| `paymentId`                                                                                                                                                                                                                                                                                                                                                                            | *String*                                                                                                                                                                                                                                                                                                                                                                               | :heavy_check_mark:                                                                                                                                                                                                                                                                                                                                                                     | Provide the ID of the related payment.                                                                                                                                                                                                                                                                                                                                                 | tr_5B8cwPMGnU                                                                                                                                                                                                                                                                                                                                                                          |
| `testmode`                                                                                                                                                                                                                                                                                                                                                                             | *JsonNullable\<Boolean>*                                                                                                                                                                                                                                                                                                                                                               | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                     | Most API credentials are specifically created for either live mode or test mode. In those cases the `testmode` query<br/>parameter can be omitted. For organization-level credentials such as OAuth access tokens, you can enable test mode by<br/>setting the `testmode` query parameter to `true`.<br/><br/>Test entities cannot be retrieved when the endpoint is set to live mode, and vice versa. | false                                                                                                                                                                                                                                                                                                                                                                                  |

### Response

**[PaymentListRoutesResponse](../../models/operations/PaymentListRoutesResponse.md)**

### Errors

| Error Type                                  | Status Code                                 | Content Type                                |
| ------------------------------------------- | ------------------------------------------- | ------------------------------------------- |
| models/errors/PaymentListRoutesResponseBody | 404                                         | application/hal+json                        |
| models/errors/APIException                  | 4XX, 5XX                                    | \*/\*                                       |