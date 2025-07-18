# Chargebacks
(*chargebacks()*)

## Overview

### Available Operations

* [list](#list) - List payment chargebacks
* [get](#get) - Get payment chargeback
* [all](#all) - List all chargebacks

## list

Retrieve the chargebacks initiated for a specific payment.

The results are paginated.

> 🔑 Access with
>
> [API key](/reference/authentication)
>
> [Access token with **payments.read**](/reference/authentication)

### Example Usage

```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.ListChargebacksChargebacksResponseBody;
import com.mollie.mollie.models.errors.ListChargebacksResponseBody;
import com.mollie.mollie.models.operations.*;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ListChargebacksResponseBody, ListChargebacksChargebacksResponseBody, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        ListChargebacksRequest req = ListChargebacksRequest.builder()
                .paymentId("tr_5B8cwPMGnU")
                .from("chb_xFzwUN4ci8HAmSGUACS4J")
                .embed(ListChargebacksQueryParamEmbed.PAYMENT)
                .testmode(false)
                .build();

        ListChargebacksResponse res = sdk.chargebacks().list()
                .request(req)
                .call();

        if (res.object().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                   | Type                                                                        | Required                                                                    | Description                                                                 |
| --------------------------------------------------------------------------- | --------------------------------------------------------------------------- | --------------------------------------------------------------------------- | --------------------------------------------------------------------------- |
| `request`                                                                   | [ListChargebacksRequest](../../models/operations/ListChargebacksRequest.md) | :heavy_check_mark:                                                          | The request object to use for the request.                                  |

### Response

**[ListChargebacksResponse](../../models/operations/ListChargebacksResponse.md)**

### Errors

| Error Type                                           | Status Code                                          | Content Type                                         |
| ---------------------------------------------------- | ---------------------------------------------------- | ---------------------------------------------------- |
| models/errors/ListChargebacksResponseBody            | 400                                                  | application/hal+json                                 |
| models/errors/ListChargebacksChargebacksResponseBody | 404                                                  | application/hal+json                                 |
| models/errors/APIException                           | 4XX, 5XX                                             | \*/\*                                                |

## get

Retrieve a single payment chargeback by its ID and the ID of its parent payment.

> 🔑 Access with
>
> [API key](/reference/authentication)
>
> [Access token with **payments.read**](/reference/authentication)

### Example Usage

```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.GetChargebackResponseBody;
import com.mollie.mollie.models.operations.GetChargebackQueryParamEmbed;
import com.mollie.mollie.models.operations.GetChargebackResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws GetChargebackResponseBody, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        GetChargebackResponse res = sdk.chargebacks().get()
                .paymentId("tr_5B8cwPMGnU")
                .chargebackId("chb_xFzwUN4ci8HAmSGUACS4J")
                .embed(GetChargebackQueryParamEmbed.PAYMENT)
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
| `chargebackId`                                                                                                                                                                                                                                                                                                                                                                         | *String*                                                                                                                                                                                                                                                                                                                                                                               | :heavy_check_mark:                                                                                                                                                                                                                                                                                                                                                                     | Provide the ID of the related chargeback.                                                                                                                                                                                                                                                                                                                                              | chb_xFzwUN4ci8HAmSGUACS4J                                                                                                                                                                                                                                                                                                                                                              |
| `embed`                                                                                                                                                                                                                                                                                                                                                                                | [JsonNullable\<GetChargebackQueryParamEmbed>](../../models/operations/GetChargebackQueryParamEmbed.md)                                                                                                                                                                                                                                                                                 | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                     | This endpoint allows you to embed additional information via the `embed` query string parameter.                                                                                                                                                                                                                                                                                       | payment                                                                                                                                                                                                                                                                                                                                                                                |
| `testmode`                                                                                                                                                                                                                                                                                                                                                                             | *JsonNullable\<Boolean>*                                                                                                                                                                                                                                                                                                                                                               | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                     | Most API credentials are specifically created for either live mode or test mode. In those cases the `testmode` query parameter can be omitted. For organization-level credentials such as OAuth access tokens, you can enable test mode by setting the `testmode` query parameter to `true`.<br/><br/>Test entities cannot be retrieved when the endpoint is set to live mode, and vice versa. | false                                                                                                                                                                                                                                                                                                                                                                                  |

### Response

**[GetChargebackResponse](../../models/operations/GetChargebackResponse.md)**

### Errors

| Error Type                              | Status Code                             | Content Type                            |
| --------------------------------------- | --------------------------------------- | --------------------------------------- |
| models/errors/GetChargebackResponseBody | 404                                     | application/hal+json                    |
| models/errors/APIException              | 4XX, 5XX                                | \*/\*                                   |

## all

Retrieve all chargebacks initiated for all your payments.

The results are paginated.

> 🔑 Access with
>
> [API key](/reference/authentication)
>
> [Access token with **payments.read**](/reference/authentication)

### Example Usage

```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.ListAllChargebacksChargebacksResponseBody;
import com.mollie.mollie.models.errors.ListAllChargebacksResponseBody;
import com.mollie.mollie.models.operations.*;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ListAllChargebacksResponseBody, ListAllChargebacksChargebacksResponseBody, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        ListAllChargebacksRequest req = ListAllChargebacksRequest.builder()
                .from("chb_xFzwUN4ci8HAmSGUACS4J")
                .embed(ListAllChargebacksQueryParamEmbed.PAYMENT)
                .sort("desc")
                .profileId("pfl_5B8cwPMGnU")
                .testmode(false)
                .build();

        ListAllChargebacksResponse res = sdk.chargebacks().all()
                .request(req)
                .call();

        if (res.object().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                         | Type                                                                              | Required                                                                          | Description                                                                       |
| --------------------------------------------------------------------------------- | --------------------------------------------------------------------------------- | --------------------------------------------------------------------------------- | --------------------------------------------------------------------------------- |
| `request`                                                                         | [ListAllChargebacksRequest](../../models/operations/ListAllChargebacksRequest.md) | :heavy_check_mark:                                                                | The request object to use for the request.                                        |

### Response

**[ListAllChargebacksResponse](../../models/operations/ListAllChargebacksResponse.md)**

### Errors

| Error Type                                              | Status Code                                             | Content Type                                            |
| ------------------------------------------------------- | ------------------------------------------------------- | ------------------------------------------------------- |
| models/errors/ListAllChargebacksResponseBody            | 400                                                     | application/hal+json                                    |
| models/errors/ListAllChargebacksChargebacksResponseBody | 404                                                     | application/hal+json                                    |
| models/errors/APIException                              | 4XX, 5XX                                                | \*/\*                                                   |