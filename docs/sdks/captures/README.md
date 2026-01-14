# Captures

## Overview

### Available Operations

* [create](#create) - Create capture
* [list](#list) - List captures
* [get](#get) - Get capture

## create

Capture an *authorized* payment.

Some payment methods allow you to first collect a customer's authorization,
and capture the amount at a later point.

By default, Mollie captures payments automatically. If however you
configured your payment with `captureMode: manual`, you can capture the payment using this endpoint after
having collected the customer's authorization.

### Example Usage

<!-- UsageSnippet language="java" operationID="create-capture" method="post" path="/payments/{paymentId}/captures" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.*;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.CreateCaptureResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        CreateCaptureResponse res = sdk.captures().create()
                .paymentId("tr_5B8cwPMGnU")
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .entityCapture(EntityCapture.builder()
                    .description("Capture for cart #12345")
                    .amount(AmountNullable.builder()
                        .currency("EUR")
                        .value("10.00")
                        .build())
                    .build())
                .call();

        if (res.captureResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                        | Type                                                                             | Required                                                                         | Description                                                                      | Example                                                                          |
| -------------------------------------------------------------------------------- | -------------------------------------------------------------------------------- | -------------------------------------------------------------------------------- | -------------------------------------------------------------------------------- | -------------------------------------------------------------------------------- |
| `paymentId`                                                                      | *String*                                                                         | :heavy_check_mark:                                                               | Provide the ID of the related payment.                                           | tr_5B8cwPMGnU                                                                    |
| `idempotencyKey`                                                                 | *Optional\<String>*                                                              | :heavy_minus_sign:                                                               | A unique key to ensure idempotent requests. This key should be a UUID v4 string. | 123e4567-e89b-12d3-a456-426                                                      |
| `entityCapture`                                                                  | [Optional\<EntityCapture>](../../models/components/EntityCapture.md)             | :heavy_minus_sign:                                                               | N/A                                                                              |                                                                                  |

### Response

**[CreateCaptureResponse](../../models/operations/CreateCaptureResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 404, 422                    | application/hal+json        |
| models/errors/APIException  | 4XX, 5XX                    | \*/\*                       |

## list

Retrieve a list of all captures created for a specific payment.

The results are paginated.

### Example Usage

<!-- UsageSnippet language="java" operationID="list-captures" method="get" path="/payments/{paymentId}/captures" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.ListCapturesRequest;
import com.mollie.mollie.models.operations.ListCapturesResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .testmode(false)
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        ListCapturesRequest req = ListCapturesRequest.builder()
                .paymentId("tr_5B8cwPMGnU")
                .from("cpt_vytxeTZskVKR7C7WgdSP3d")
                .limit(50L)
                .embed("payment")
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .build();

        ListCapturesResponse res = sdk.captures().list()
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
| `request`                                                             | [ListCapturesRequest](../../models/operations/ListCapturesRequest.md) | :heavy_check_mark:                                                    | The request object to use for the request.                            |

### Response

**[ListCapturesResponse](../../models/operations/ListCapturesResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 400, 404                    | application/hal+json        |
| models/errors/APIException  | 4XX, 5XX                    | \*/\*                       |

## get

Retrieve a single payment capture by its ID and the ID of its parent
payment.

### Example Usage

<!-- UsageSnippet language="java" operationID="get-capture" method="get" path="/payments/{paymentId}/captures/{captureId}" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.GetCaptureRequest;
import com.mollie.mollie.models.operations.GetCaptureResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .testmode(false)
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        GetCaptureRequest req = GetCaptureRequest.builder()
                .paymentId("tr_5B8cwPMGnU")
                .captureId("cpt_vytxeTZskVKR7C7WgdSP3d")
                .embed("payment")
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .build();

        GetCaptureResponse res = sdk.captures().get()
                .request(req)
                .call();

        if (res.captureResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                         | Type                                                              | Required                                                          | Description                                                       |
| ----------------------------------------------------------------- | ----------------------------------------------------------------- | ----------------------------------------------------------------- | ----------------------------------------------------------------- |
| `request`                                                         | [GetCaptureRequest](../../models/operations/GetCaptureRequest.md) | :heavy_check_mark:                                                | The request object to use for the request.                        |

### Response

**[GetCaptureResponse](../../models/operations/GetCaptureResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 404                         | application/hal+json        |
| models/errors/APIException  | 4XX, 5XX                    | \*/\*                       |