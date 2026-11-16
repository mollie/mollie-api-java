# Clients

## Overview

### Available Operations

* [list](#list) - List clients
* [get](#get) - Get client

## list

Retrieve a list of all clients linked to your account.

The results are paginated.

### Example Usage

<!-- UsageSnippet language="java" operationID="list-clients" method="get" path="/v2/clients" example="list-clients-200-1" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.ListClientsRequest;
import com.mollie.mollie.models.operations.ListClientsResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .advancedAccessToken(System.getenv().getOrDefault("ADVANCED_ACCESS_TOKEN", ""))
                    .build())
            .build();

        ListClientsRequest req = ListClientsRequest.builder()
                .embed("organization")
                .from("org_12345678")
                .limit(50L)
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .xClientSignature("MEUCIQDx8sJvK3z...")
                .xClientSignedAt("2025-01-01T12:00:00Z")
                .build();


        sdk.clients().list()
                .callAsStream()
                .forEach((ListClientsResponse item) -> {
                   // handle page
                });

    }
}
```

### Parameters

| Parameter                                                           | Type                                                                | Required                                                            | Description                                                         |
| ------------------------------------------------------------------- | ------------------------------------------------------------------- | ------------------------------------------------------------------- | ------------------------------------------------------------------- |
| `request`                                                           | [ListClientsRequest](../../models/operations/ListClientsRequest.md) | :heavy_check_mark:                                                  | The request object to use for the request.                          |

### Response

**[ListClientsResponse](../../models/operations/ListClientsResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 400, 404, 429               | application/hal+json        |
| models/errors/APIException  | 4XX, 5XX                    | \*/\*                       |

## get

Retrieve a single client by its ID.

### Example Usage: get-client-200-1

<!-- UsageSnippet language="java" operationID="get-client" method="get" path="/v2/clients/{organizationId}" example="get-client-200-1" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.GetClientRequest;
import com.mollie.mollie.models.operations.GetClientResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .advancedAccessToken(System.getenv().getOrDefault("ADVANCED_ACCESS_TOKEN", ""))
                    .build())
            .build();

        GetClientRequest req = GetClientRequest.builder()
                .organizationId("org_1234567")
                .embed("organization")
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .xClientSignature("MEUCIQDx8sJvK3z...")
                .xClientSignedAt("2025-01-01T12:00:00Z")
                .build();

        GetClientResponse res = sdk.clients().get()
                .request(req)
                .call();

        if (res.object().isPresent()) {
            System.out.println(res.object().get());
        }
    }
}
```
### Example Usage: get-client-200-2

<!-- UsageSnippet language="java" operationID="get-client" method="get" path="/v2/clients/{organizationId}" example="get-client-200-2" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.GetClientRequest;
import com.mollie.mollie.models.operations.GetClientResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .advancedAccessToken(System.getenv().getOrDefault("ADVANCED_ACCESS_TOKEN", ""))
                    .build())
            .build();

        GetClientRequest req = GetClientRequest.builder()
                .organizationId("org_1234567")
                .embed("organization")
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .xClientSignature("MEUCIQDx8sJvK3z...")
                .xClientSignedAt("2025-01-01T12:00:00Z")
                .build();

        GetClientResponse res = sdk.clients().get()
                .request(req)
                .call();

        if (res.object().isPresent()) {
            System.out.println(res.object().get());
        }
    }
}
```
### Example Usage: get-client-200-3

<!-- UsageSnippet language="java" operationID="get-client" method="get" path="/v2/clients/{organizationId}" example="get-client-200-3" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.GetClientRequest;
import com.mollie.mollie.models.operations.GetClientResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .advancedAccessToken(System.getenv().getOrDefault("ADVANCED_ACCESS_TOKEN", ""))
                    .build())
            .build();

        GetClientRequest req = GetClientRequest.builder()
                .organizationId("org_1234567")
                .embed("organization")
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .xClientSignature("MEUCIQDx8sJvK3z...")
                .xClientSignedAt("2025-01-01T12:00:00Z")
                .build();

        GetClientResponse res = sdk.clients().get()
                .request(req)
                .call();

        if (res.object().isPresent()) {
            System.out.println(res.object().get());
        }
    }
}
```
### Example Usage: get-client-200-4

<!-- UsageSnippet language="java" operationID="get-client" method="get" path="/v2/clients/{organizationId}" example="get-client-200-4" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.GetClientRequest;
import com.mollie.mollie.models.operations.GetClientResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .advancedAccessToken(System.getenv().getOrDefault("ADVANCED_ACCESS_TOKEN", ""))
                    .build())
            .build();

        GetClientRequest req = GetClientRequest.builder()
                .organizationId("org_1234567")
                .embed("organization")
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .xClientSignature("MEUCIQDx8sJvK3z...")
                .xClientSignedAt("2025-01-01T12:00:00Z")
                .build();

        GetClientResponse res = sdk.clients().get()
                .request(req)
                .call();

        if (res.object().isPresent()) {
            System.out.println(res.object().get());
        }
    }
}
```

### Parameters

| Parameter                                                       | Type                                                            | Required                                                        | Description                                                     |
| --------------------------------------------------------------- | --------------------------------------------------------------- | --------------------------------------------------------------- | --------------------------------------------------------------- |
| `request`                                                       | [GetClientRequest](../../models/operations/GetClientRequest.md) | :heavy_check_mark:                                              | The request object to use for the request.                      |

### Response

**[GetClientResponse](../../models/operations/GetClientResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 404, 429                    | application/hal+json        |
| models/errors/APIException  | 4XX, 5XX                    | \*/\*                       |