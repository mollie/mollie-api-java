# Clients
(*clients()*)

## Overview

### Available Operations

* [list](#list) - List clients
* [get](#get) - Get client

## list

Retrieve a list of all clients linked to your account.

The results are paginated.

### Example Usage

<!-- UsageSnippet language="java" operationID="list-clients" method="get" path="/clients" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.ListClientsResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        ListClientsResponse res = sdk.clients().list()
                .embed("organization")
                .from("org_12345678")
                .limit(50L)
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .call();

        if (res.object().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                                      | Type                                                                                                                           | Required                                                                                                                       | Description                                                                                                                    | Example                                                                                                                        |
| ------------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------------ |
| `embed`                                                                                                                        | *JsonNullable\<String>*                                                                                                        | :heavy_minus_sign:                                                                                                             | This endpoint allows embedding related API items by appending the following values via the `embed` query string<br/>parameter. |                                                                                                                                |
| `from`                                                                                                                         | *JsonNullable\<String>*                                                                                                        | :heavy_minus_sign:                                                                                                             | Provide an ID to start the result set from the item with the given ID and onwards. This allows you to paginate the<br/>result set. |                                                                                                                                |
| `limit`                                                                                                                        | *JsonNullable\<Long>*                                                                                                          | :heavy_minus_sign:                                                                                                             | The maximum number of items to return. Defaults to 50 items.                                                                   | 50                                                                                                                             |
| `idempotencyKey`                                                                                                               | *Optional\<String>*                                                                                                            | :heavy_minus_sign:                                                                                                             | A unique key to ensure idempotent requests. This key should be a UUID v4 string.                                               | 123e4567-e89b-12d3-a456-426                                                                                                    |

### Response

**[ListClientsResponse](../../models/operations/ListClientsResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 400, 404                    | application/hal+json        |
| models/errors/APIException  | 4XX, 5XX                    | \*/\*                       |

## get

Retrieve a single client by its ID.

### Example Usage

<!-- UsageSnippet language="java" operationID="get-client" method="get" path="/clients/{id}" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.GetClientResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        GetClientResponse res = sdk.clients().get()
                .id("org_12345678")
                .embed("organization")
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .call();

        if (res.object().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                                  | Type                                                                                                                       | Required                                                                                                                   | Description                                                                                                                | Example                                                                                                                    |
| -------------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------- |
| `id`                                                                                                                       | *String*                                                                                                                   | :heavy_check_mark:                                                                                                         | Provide the ID of the item you want to perform this operation on.                                                          |                                                                                                                            |
| `embed`                                                                                                                    | *JsonNullable\<String>*                                                                                                    | :heavy_minus_sign:                                                                                                         | This endpoint allows embedding related API items by appending the following values via the `embed` query string<br/>parameter. |                                                                                                                            |
| `idempotencyKey`                                                                                                           | *Optional\<String>*                                                                                                        | :heavy_minus_sign:                                                                                                         | A unique key to ensure idempotent requests. This key should be a UUID v4 string.                                           | 123e4567-e89b-12d3-a456-426                                                                                                |

### Response

**[GetClientResponse](../../models/operations/GetClientResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 404                         | application/hal+json        |
| models/errors/APIException  | 4XX, 5XX                    | \*/\*                       |