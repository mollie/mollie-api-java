# DelayedRouting

## Overview

### Available Operations

* [create](#create) - Create a delayed route
* [list](#list) - List payment routes
* [get](#get) - Get a delayed route

## create

Create a route for a specific payment.
The routed amount is credited to the account of your customer.

### Example Usage

<!-- UsageSnippet language="java" operationID="payment-create-route" method="post" path="/v2/payments/{paymentId}/routes" example="create-route-201-1" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.*;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.PaymentCreateRouteRequest;
import com.mollie.mollie.models.operations.PaymentCreateRouteResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        PaymentCreateRouteRequest req = PaymentCreateRouteRequest.builder()
                .paymentId("tr_5B8cwPMGnU")
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .xClientSignature("MEUCIQDx8sJvK3z...")
                .xClientSignedAt("2025-01-01T12:00:00Z")
                .routeCreateRequest(RouteCreateRequest.builder()
                    .amount(Amount.builder()
                        .currency("EUR")
                        .value("10.00")
                        .build())
                    .destination(RouteCreateRequestDestination.builder()
                        .type(RouteDestinationType.ORGANIZATION)
                        .organizationId("org_1234567")
                        .build())
                    .description("Payment for Order #12345")
                    .build())
                .build();

        PaymentCreateRouteResponse res = sdk.delayedRouting().create()
                .request(req)
                .call();

        if (res.routeCreateResponse().isPresent()) {
            System.out.println(res.routeCreateResponse().get());
        }
    }
}
```

### Parameters

| Parameter                                                                         | Type                                                                              | Required                                                                          | Description                                                                       |
| --------------------------------------------------------------------------------- | --------------------------------------------------------------------------------- | --------------------------------------------------------------------------------- | --------------------------------------------------------------------------------- |
| `request`                                                                         | [PaymentCreateRouteRequest](../../models/operations/PaymentCreateRouteRequest.md) | :heavy_check_mark:                                                                | The request object to use for the request.                                        |

### Response

**[PaymentCreateRouteResponse](../../models/operations/PaymentCreateRouteResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 404, 429                    | application/hal+json        |
| models/errors/APIException  | 4XX, 5XX                    | \*/\*                       |

## list

Retrieve a list of all routes created for a specific payment.

### Example Usage

<!-- UsageSnippet language="java" operationID="payment-list-routes" method="get" path="/v2/payments/{paymentId}/routes" example="list-routes-200-1" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.PaymentListRoutesRequest;
import com.mollie.mollie.models.operations.PaymentListRoutesResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .testmode(false)
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        PaymentListRoutesRequest req = PaymentListRoutesRequest.builder()
                .paymentId("tr_5B8cwPMGnU")
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .xClientSignature("MEUCIQDx8sJvK3z...")
                .xClientSignedAt("2025-01-01T12:00:00Z")
                .build();

        PaymentListRoutesResponse res = sdk.delayedRouting().list()
                .request(req)
                .call();

        if (res.object().isPresent()) {
            System.out.println(res.object().get());
        }
    }
}
```

### Parameters

| Parameter                                                                       | Type                                                                            | Required                                                                        | Description                                                                     |
| ------------------------------------------------------------------------------- | ------------------------------------------------------------------------------- | ------------------------------------------------------------------------------- | ------------------------------------------------------------------------------- |
| `request`                                                                       | [PaymentListRoutesRequest](../../models/operations/PaymentListRoutesRequest.md) | :heavy_check_mark:                                                              | The request object to use for the request.                                      |

### Response

**[PaymentListRoutesResponse](../../models/operations/PaymentListRoutesResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 404, 429                    | application/hal+json        |
| models/errors/APIException  | 4XX, 5XX                    | \*/\*                       |

## get

Retrieve a single route created for a specific payment.

### Example Usage

<!-- UsageSnippet language="java" operationID="payment-get-route" method="get" path="/v2/payments/{paymentId}/routes/{routeId}" example="get-route-200-1" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.PaymentGetRouteRequest;
import com.mollie.mollie.models.operations.PaymentGetRouteResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        PaymentGetRouteRequest req = PaymentGetRouteRequest.builder()
                .paymentId("tr_5B8cwPMGnU")
                .routeId("crt_dyARQ3JzCgtPDhU2Pbq3J")
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .xClientSignature("MEUCIQDx8sJvK3z...")
                .xClientSignedAt("2025-01-01T12:00:00Z")
                .build();

        PaymentGetRouteResponse res = sdk.delayedRouting().get()
                .request(req)
                .call();

        if (res.routeGetResponse().isPresent()) {
            System.out.println(res.routeGetResponse().get());
        }
    }
}
```

### Parameters

| Parameter                                                                   | Type                                                                        | Required                                                                    | Description                                                                 |
| --------------------------------------------------------------------------- | --------------------------------------------------------------------------- | --------------------------------------------------------------------------- | --------------------------------------------------------------------------- |
| `request`                                                                   | [PaymentGetRouteRequest](../../models/operations/PaymentGetRouteRequest.md) | :heavy_check_mark:                                                          | The request object to use for the request.                                  |

### Response

**[PaymentGetRouteResponse](../../models/operations/PaymentGetRouteResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 404, 429                    | application/hal+json        |
| models/errors/APIException  | 4XX, 5XX                    | \*/\*                       |