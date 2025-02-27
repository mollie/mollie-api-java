# Chargebacks
(*chargebacks()*)

## Overview

### Available Operations

* [list](#list) - List payment chargebacks
* [get](#get) - Get payment chargeback
* [listAll](#listall) - List all chargebacks

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
import com.mollie.mollie.models.operations.ListChargebacksRequest;
import com.mollie.mollie.models.operations.ListChargebacksResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ListChargebacksResponseBody, ListChargebacksChargebacksResponseBody, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey("<YOUR_BEARER_TOKEN_HERE>")
                    .build())
            .build();

        ListChargebacksRequest req = ListChargebacksRequest.builder()
                .paymentId("tr_5B8cwPMGnU6qLbRvo7qEZo")
                .from("chb_n9z0tp")
                .include("payment")
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
import com.mollie.mollie.models.operations.GetChargebackResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws GetChargebackResponseBody, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey("<YOUR_BEARER_TOKEN_HERE>")
                    .build())
            .build();

        GetChargebackResponse res = sdk.chargebacks().get()
                .paymentId("tr_5B8cwPMGnU6qLbRvo7qEZo")
                .id("chb_n9z0tp")
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
| `id`                                                                                                                                                                                                                                                                                                                                                                                   | *String*                                                                                                                                                                                                                                                                                                                                                                               | :heavy_check_mark:                                                                                                                                                                                                                                                                                                                                                                     | Provide the ID of the item you want to perform this operation on.                                                                                                                                                                                                                                                                                                                      | chb_n9z0tp                                                                                                                                                                                                                                                                                                                                                                             |
| `include`                                                                                                                                                                                                                                                                                                                                                                              | *JsonNullable\<String>*                                                                                                                                                                                                                                                                                                                                                                | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                     | This endpoint allows you to include additional information via the `include` query string parameter.<br/><br/>* `payment`: Include the payment this chargeback was issued for.                                                                                                                                                                                                         | payment                                                                                                                                                                                                                                                                                                                                                                                |
| `testmode`                                                                                                                                                                                                                                                                                                                                                                             | *JsonNullable\<Boolean>*                                                                                                                                                                                                                                                                                                                                                               | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                     | Most API credentials are specifically created for either live mode or test mode. In those cases the `testmode` query parameter can be omitted. For organization-level credentials such as OAuth access tokens, you can enable test mode by setting the `testmode` query parameter to `true`.<br/><br/>Test entities cannot be retrieved when the endpoint is set to live mode, and vice versa. | false                                                                                                                                                                                                                                                                                                                                                                                  |

### Response

**[GetChargebackResponse](../../models/operations/GetChargebackResponse.md)**

### Errors

| Error Type                              | Status Code                             | Content Type                            |
| --------------------------------------- | --------------------------------------- | --------------------------------------- |
| models/errors/GetChargebackResponseBody | 404                                     | application/hal+json                    |
| models/errors/APIException              | 4XX, 5XX                                | \*/\*                                   |

## listAll

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
import com.mollie.mollie.models.operations.ListAllChargebacksRequest;
import com.mollie.mollie.models.operations.ListAllChargebacksResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ListAllChargebacksResponseBody, ListAllChargebacksChargebacksResponseBody, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey("<YOUR_BEARER_TOKEN_HERE>")
                    .build())
            .build();

        ListAllChargebacksRequest req = ListAllChargebacksRequest.builder()
                .from("chb_n9z0tp")
                .include("payment")
                .profileId("pfl_QkEhN94Ba")
                .build();

        ListAllChargebacksResponse res = sdk.chargebacks().listAll()
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