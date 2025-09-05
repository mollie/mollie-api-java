# Captures
(*captures()*)

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
                .entityCapture(EntityCapture.builder()
                    .id("cpt_vytxeTZskVKR7C7WgdSP3d")
                    .description("Capture for cart #12345")
                    .amount(AmountNullable.builder()
                        .currency("EUR")
                        .value("10.00")
                        .build())
                    .settlementAmount(AmountNullable.builder()
                        .currency("EUR")
                        .value("10.00")
                        .build())
                    .paymentId("tr_5B8cwPMGnU")
                    .shipmentId("shp_5x4xQJDWGNcY3tKGL7X5J")
                    .settlementId("stl_5B8cwPMGnU")
                    .build())
                .call();

        if (res.captureResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                            | Type                                                                 | Required                                                             | Description                                                          | Example                                                              |
| -------------------------------------------------------------------- | -------------------------------------------------------------------- | -------------------------------------------------------------------- | -------------------------------------------------------------------- | -------------------------------------------------------------------- |
| `paymentId`                                                          | *String*                                                             | :heavy_check_mark:                                                   | Provide the ID of the related payment.                               | tr_5B8cwPMGnU                                                        |
| `entityCapture`                                                      | [Optional\<EntityCapture>](../../models/components/EntityCapture.md) | :heavy_minus_sign:                                                   | N/A                                                                  |                                                                      |

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
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        ListCapturesRequest req = ListCapturesRequest.builder()
                .paymentId("tr_5B8cwPMGnU")
                .from("cpt_vytxeTZskVKR7C7WgdSP3d")
                .limit(50L)
                .embed("payment")
                .testmode(false)
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
import com.mollie.mollie.models.operations.GetCaptureResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        GetCaptureResponse res = sdk.captures().get()
                .paymentId("tr_5B8cwPMGnU")
                .captureId("cpt_gVMhHKqSSRYJyPsuoPNFH")
                .embed("payment")
                .testmode(false)
                .call();

        if (res.captureResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                                                                                                                                                                                                                                                                                              | Type                                                                                                                                                                                                                                                                                                                                                                                   | Required                                                                                                                                                                                                                                                                                                                                                                               | Description                                                                                                                                                                                                                                                                                                                                                                            | Example                                                                                                                                                                                                                                                                                                                                                                                |
| -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `paymentId`                                                                                                                                                                                                                                                                                                                                                                            | *String*                                                                                                                                                                                                                                                                                                                                                                               | :heavy_check_mark:                                                                                                                                                                                                                                                                                                                                                                     | Provide the ID of the related payment.                                                                                                                                                                                                                                                                                                                                                 | tr_5B8cwPMGnU                                                                                                                                                                                                                                                                                                                                                                          |
| `captureId`                                                                                                                                                                                                                                                                                                                                                                            | *String*                                                                                                                                                                                                                                                                                                                                                                               | :heavy_check_mark:                                                                                                                                                                                                                                                                                                                                                                     | Provide the ID of the related capture.                                                                                                                                                                                                                                                                                                                                                 | cpt_gVMhHKqSSRYJyPsuoPNFH                                                                                                                                                                                                                                                                                                                                                              |
| `embed`                                                                                                                                                                                                                                                                                                                                                                                | *JsonNullable\<String>*                                                                                                                                                                                                                                                                                                                                                                | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                     | This endpoint allows embedding related API items by appending the following values via the `embed` query string<br/>parameter.                                                                                                                                                                                                                                                         |                                                                                                                                                                                                                                                                                                                                                                                        |
| `testmode`                                                                                                                                                                                                                                                                                                                                                                             | *JsonNullable\<Boolean>*                                                                                                                                                                                                                                                                                                                                                               | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                     | Most API credentials are specifically created for either live mode or test mode. In those cases the `testmode` query<br/>parameter can be omitted. For organization-level credentials such as OAuth access tokens, you can enable test mode by<br/>setting the `testmode` query parameter to `true`.<br/><br/>Test entities cannot be retrieved when the endpoint is set to live mode, and vice versa. | false                                                                                                                                                                                                                                                                                                                                                                                  |

### Response

**[GetCaptureResponse](../../models/operations/GetCaptureResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 404                         | application/hal+json        |
| models/errors/APIException  | 4XX, 5XX                    | \*/\*                       |