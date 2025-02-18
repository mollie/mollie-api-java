# CapturesAPI
(*capturesAPI()*)

## Overview

### Available Operations

* [createCapture](#createcapture) - Create capture
* [listCaptures](#listcaptures) - List captures
* [getCapture](#getcapture) - Get capture

## createCapture

**This feature is currently in open beta. The final specification may still change.**

Capture an *authorized* payment.

Some payment methods allow you to first collect a customer's authorization, and capture the amount at a later point.

By default, Mollie captures payments automatically. If however you configured your payment with `captureMode: manual`, you can capture the payment using this endpoint after having collected the customer's authorization.

> 🔑 Access with
>
> [API key](/reference/authentication)
>
> [Access token with **payments.write**](/reference/authentication)

### Example Usage

```java
package hello.world;

import com.mollie.mollie.Mollie;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.CreateCaptureCapturesAPIResponseBody;
import com.mollie.mollie.models.errors.CreateCaptureResponseBody;
import com.mollie.mollie.models.operations.CreateCaptureAmount;
import com.mollie.mollie.models.operations.CreateCaptureRequestBody;
import com.mollie.mollie.models.operations.CreateCaptureResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws CreateCaptureResponseBody, CreateCaptureCapturesAPIResponseBody, Exception {

        Mollie sdk = Mollie.builder()
                .security(Security.builder()
                    .apiKey("<YOUR_BEARER_TOKEN_HERE>")
                    .build())
            .build();

        CreateCaptureResponse res = sdk.capturesAPI().createCapture()
                .paymentId("tr_5B8cwPMGnU6qLbRvo7qEZo")
                .requestBody(CreateCaptureRequestBody.builder()
                    .amount(CreateCaptureAmount.builder()
                        .currency("EUR")
                        .value("10.00")
                        .build())
                    .build())
                .call();

        // handle response
    }
}
```

### Parameters

| Parameter                                                                                  | Type                                                                                       | Required                                                                                   | Description                                                                                | Example                                                                                    |
| ------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------ |
| `paymentId`                                                                                | *String*                                                                                   | :heavy_check_mark:                                                                         | Provide the ID of the related payment.                                                     | tr_5B8cwPMGnU6qLbRvo7qEZo                                                                  |
| `requestBody`                                                                              | [Optional\<CreateCaptureRequestBody>](../../models/operations/CreateCaptureRequestBody.md) | :heavy_minus_sign:                                                                         | N/A                                                                                        |                                                                                            |

### Response

**[CreateCaptureResponse](../../models/operations/CreateCaptureResponse.md)**

### Errors

| Error Type                                         | Status Code                                        | Content Type                                       |
| -------------------------------------------------- | -------------------------------------------------- | -------------------------------------------------- |
| models/errors/CreateCaptureResponseBody            | 404                                                | application/hal+json                               |
| models/errors/CreateCaptureCapturesAPIResponseBody | 422                                                | application/hal+json                               |
| models/errors/APIException                         | 4XX, 5XX                                           | \*/\*                                              |

## listCaptures

Retrieve a list of all captures created for a specific payment.

The results are paginated.

> 🔑 Access with
>
> [API key](/reference/authentication)
>
> [Access token with **payments.read**](/reference/authentication)

### Example Usage

```java
package hello.world;

import com.mollie.mollie.Mollie;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.ListCapturesCapturesAPIResponseBody;
import com.mollie.mollie.models.errors.ListCapturesResponseBody;
import com.mollie.mollie.models.operations.ListCapturesRequest;
import com.mollie.mollie.models.operations.ListCapturesResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ListCapturesResponseBody, ListCapturesCapturesAPIResponseBody, Exception {

        Mollie sdk = Mollie.builder()
                .security(Security.builder()
                    .apiKey("<YOUR_BEARER_TOKEN_HERE>")
                    .build())
            .build();

        ListCapturesRequest req = ListCapturesRequest.builder()
                .paymentId("tr_5B8cwPMGnU6qLbRvo7qEZo")
                .from("cpt_mNepDkEtco6ah3QNPUGYH")
                .include("payment")
                .build();

        ListCapturesResponse res = sdk.capturesAPI().listCaptures()
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

| Error Type                                        | Status Code                                       | Content Type                                      |
| ------------------------------------------------- | ------------------------------------------------- | ------------------------------------------------- |
| models/errors/ListCapturesResponseBody            | 400                                               | application/hal+json                              |
| models/errors/ListCapturesCapturesAPIResponseBody | 404                                               | application/hal+json                              |
| models/errors/APIException                        | 4XX, 5XX                                          | \*/\*                                             |

## getCapture

Retrieve a single payment capture by its ID and the ID of its parent payment.

> 🔑 Access with
>
> [API key](/reference/authentication)
>
> [Access token with **payments.read**](/reference/authentication)

### Example Usage

```java
package hello.world;

import com.mollie.mollie.Mollie;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.GetCaptureResponseBody;
import com.mollie.mollie.models.operations.GetCaptureResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws GetCaptureResponseBody, Exception {

        Mollie sdk = Mollie.builder()
                .security(Security.builder()
                    .apiKey("<YOUR_BEARER_TOKEN_HERE>")
                    .build())
            .build();

        GetCaptureResponse res = sdk.capturesAPI().getCapture()
                .paymentId("tr_5B8cwPMGnU6qLbRvo7qEZo")
                .id("cpt_mNepDkEtco6ah3QNPUGYH")
                .include("payment")
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
| `paymentId`                                                                                                                                                                                                                                                                                                                                                                            | *String*                                                                                                                                                                                                                                                                                                                                                                               | :heavy_check_mark:                                                                                                                                                                                                                                                                                                                                                                     | Provide the ID of the related payment.                                                                                                                                                                                                                                                                                                                                                 | tr_5B8cwPMGnU6qLbRvo7qEZo                                                                                                                                                                                                                                                                                                                                                              |
| `id`                                                                                                                                                                                                                                                                                                                                                                                   | *String*                                                                                                                                                                                                                                                                                                                                                                               | :heavy_check_mark:                                                                                                                                                                                                                                                                                                                                                                     | Provide the ID of the item you want to perform this operation on.                                                                                                                                                                                                                                                                                                                      | cpt_mNepDkEtco6ah3QNPUGYH                                                                                                                                                                                                                                                                                                                                                              |
| `include`                                                                                                                                                                                                                                                                                                                                                                              | *JsonNullable\<String>*                                                                                                                                                                                                                                                                                                                                                                | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                     | This endpoint allows you to include additional information via the `include` query string parameter.<br/><br/>* `payment`: Include the payment this capture was created for.                                                                                                                                                                                                           | payment                                                                                                                                                                                                                                                                                                                                                                                |
| `testmode`                                                                                                                                                                                                                                                                                                                                                                             | *JsonNullable\<Boolean>*                                                                                                                                                                                                                                                                                                                                                               | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                     | Most API credentials are specifically created for either live mode or test mode. In those cases the `testmode` query parameter can be omitted. For organization-level credentials such as OAuth access tokens, you can enable test mode by setting the `testmode` query parameter to `true`.<br/><br/>Test entities cannot be retrieved when the endpoint is set to live mode, and vice versa. | false                                                                                                                                                                                                                                                                                                                                                                                  |

### Response

**[GetCaptureResponse](../../models/operations/GetCaptureResponse.md)**

### Errors

| Error Type                           | Status Code                          | Content Type                         |
| ------------------------------------ | ------------------------------------ | ------------------------------------ |
| models/errors/GetCaptureResponseBody | 404                                  | application/hal+json                 |
| models/errors/APIException           | 4XX, 5XX                             | \*/\*                                |