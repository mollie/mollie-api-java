# Terminals

## Overview

### Available Operations

* [list](#list) - List terminals
* [get](#get) - Get terminal
* [terminalsRequestPairingCode](#terminalsrequestpairingcode) - Request terminal pairing code
* [terminalsListPairingCodes](#terminalslistpairingcodes) - List terminal pairing codes
* [terminalsGetPairingCode](#terminalsgetpairingcode) - Get terminal pairing code
* [terminalsRevokePairingCode](#terminalsrevokepairingcode) - Revoke terminal pairing code

## list

Retrieve a list of all physical point-of-sale devices.

The results are paginated.

### Example Usage: list-terminals-200-1

<!-- UsageSnippet language="java" operationID="list-terminals" method="get" path="/v2/terminals" example="list-terminals-200-1" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.components.Sorting;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.ListTerminalsRequest;
import com.mollie.mollie.models.operations.ListTerminalsResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .testmode(false)
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        ListTerminalsRequest req = ListTerminalsRequest.builder()
                .from("term_vytxeTZskVKR7C7WgdSP3d")
                .limit(50L)
                .sort(Sorting.DESC)
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .build();


        sdk.terminals().list()
                .callAsStream()
                .forEach((ListTerminalsResponse item) -> {
                   // handle page
                });

    }
}
```
### Example Usage: list-terminals-200-2

<!-- UsageSnippet language="java" operationID="list-terminals" method="get" path="/v2/terminals" example="list-terminals-200-2" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.components.Sorting;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.ListTerminalsRequest;
import com.mollie.mollie.models.operations.ListTerminalsResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .testmode(false)
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        ListTerminalsRequest req = ListTerminalsRequest.builder()
                .from("term_vytxeTZskVKR7C7WgdSP3d")
                .limit(50L)
                .sort(Sorting.DESC)
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .build();


        sdk.terminals().list()
                .callAsStream()
                .forEach((ListTerminalsResponse item) -> {
                   // handle page
                });

    }
}
```

### Parameters

| Parameter                                                               | Type                                                                    | Required                                                                | Description                                                             |
| ----------------------------------------------------------------------- | ----------------------------------------------------------------------- | ----------------------------------------------------------------------- | ----------------------------------------------------------------------- |
| `request`                                                               | [ListTerminalsRequest](../../models/operations/ListTerminalsRequest.md) | :heavy_check_mark:                                                      | The request object to use for the request.                              |

### Response

**[ListTerminalsResponse](../../models/operations/ListTerminalsResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 400, 429                    | application/hal+json        |
| models/errors/APIException  | 4XX, 5XX                    | \*/\*                       |

## get

Retrieve a single terminal by its ID.

### Example Usage

<!-- UsageSnippet language="java" operationID="get-terminal" method="get" path="/v2/terminals/{terminalId}" example="get-terminal-200-1" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.GetTerminalResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .testmode(false)
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        GetTerminalResponse res = sdk.terminals().get()
                .terminalId("term_vytxeTZskVKR7C7WgdSP3d")
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .call();

        if (res.entityTerminal().isPresent()) {
            System.out.println(res.entityTerminal().get());
        }
    }
}
```

### Parameters

| Parameter                                                                                                                                                                                                                                                                                                                                                                                | Type                                                                                                                                                                                                                                                                                                                                                                                     | Required                                                                                                                                                                                                                                                                                                                                                                                 | Description                                                                                                                                                                                                                                                                                                                                                                              | Example                                                                                                                                                                                                                                                                                                                                                                                  |
| ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `terminalId`                                                                                                                                                                                                                                                                                                                                                                             | *String*                                                                                                                                                                                                                                                                                                                                                                                 | :heavy_check_mark:                                                                                                                                                                                                                                                                                                                                                                       | Provide the ID of the related terminal.                                                                                                                                                                                                                                                                                                                                                  | term_vytxeTZskVKR7C7WgdSP3d                                                                                                                                                                                                                                                                                                                                                              |
| `testmode`                                                                                                                                                                                                                                                                                                                                                                               | *Optional\<Boolean>*                                                                                                                                                                                                                                                                                                                                                                     | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                       | Most API credentials are specifically created for either live mode or test mode. In those cases the `testmode` query<br/>parameter must not be sent. For organization-level credentials such as OAuth access tokens, you can enable test mode by<br/>setting the `testmode` query parameter to `true`.<br/><br/>Test entities cannot be retrieved when the endpoint is set to live mode, and vice versa. |                                                                                                                                                                                                                                                                                                                                                                                          |
| `idempotencyKey`                                                                                                                                                                                                                                                                                                                                                                         | *Optional\<String>*                                                                                                                                                                                                                                                                                                                                                                      | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                       | A unique key to ensure idempotent requests. This key should be a UUID v4 string.                                                                                                                                                                                                                                                                                                         | 123e4567-e89b-12d3-a456-426                                                                                                                                                                                                                                                                                                                                                              |

### Response

**[GetTerminalResponse](../../models/operations/GetTerminalResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 404, 429                    | application/hal+json        |
| models/errors/APIException  | 4XX, 5XX                    | \*/\*                       |

## terminalsRequestPairingCode

> ℹ️ **Test mode**
>
> This endpoint currently does not support test mode yet.

Request a pairing code to onboard a point-of-sale terminal.

The response includes a human-readable `code` for manual entry on the terminal, and a QR Code as a
base64 encoded SVG data URI for scanning if you specify the query parameter `include` with value `details.qrCode`.

Pairing codes expire after 90 days (see `expiresAt`) and can be used multiple times.

### Example Usage

<!-- UsageSnippet language="java" operationID="terminals-request-pairing-code" method="post" path="/v2/terminals/pairing-codes" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.TerminalsRequestPairingCodeRequestBody;
import com.mollie.mollie.models.operations.TerminalsRequestPairingCodeResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        TerminalsRequestPairingCodeResponse res = sdk.terminals().terminalsRequestPairingCode()
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .requestBody(TerminalsRequestPairingCodeRequestBody.builder()
                    .profileId("pfl_jA9bC4DkFj3G")
                    .build())
                .call();

        if (res.entityPairingCode().isPresent()) {
            System.out.println(res.entityPairingCode().get());
        }
    }
}
```

### Parameters

| Parameter                                                                                                              | Type                                                                                                                   | Required                                                                                                               | Description                                                                                                            | Example                                                                                                                |
| ---------------------------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------------------- |
| `include`                                                                                                              | *JsonNullable\<String>*                                                                                                | :heavy_minus_sign:                                                                                                     | Include additional information in the response.                                                                        |                                                                                                                        |
| `idempotencyKey`                                                                                                       | *Optional\<String>*                                                                                                    | :heavy_minus_sign:                                                                                                     | A unique key to ensure idempotent requests. This key should be a UUID v4 string.                                       | 123e4567-e89b-12d3-a456-426                                                                                            |
| `requestBody`                                                                                                          | [Optional\<TerminalsRequestPairingCodeRequestBody>](../../models/operations/TerminalsRequestPairingCodeRequestBody.md) | :heavy_minus_sign:                                                                                                     | N/A                                                                                                                    |                                                                                                                        |

### Response

**[TerminalsRequestPairingCodeResponse](../../models/operations/TerminalsRequestPairingCodeResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 422, 429                    | application/hal+json        |
| models/errors/APIException  | 4XX, 5XX                    | \*/\*                       |

## terminalsListPairingCodes

> ℹ️ **Test mode**
>
> This endpoint currently does not support test mode yet.

Returns all pairing codes: `active`, `expired`, and `revoked`. Results are paginated.

### Example Usage

<!-- UsageSnippet language="java" operationID="terminals-list-pairing-codes" method="get" path="/v2/terminals/pairing-codes" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.components.Sorting;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.TerminalsListPairingCodesRequest;
import com.mollie.mollie.models.operations.TerminalsListPairingCodesResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .profileId("<id>")
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        TerminalsListPairingCodesRequest req = TerminalsListPairingCodesRequest.builder()
                .limit(50L)
                .sort(Sorting.DESC)
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .build();

        TerminalsListPairingCodesResponse res = sdk.terminals().terminalsListPairingCodes()
                .request(req)
                .call();

        if (res.object().isPresent()) {
            System.out.println(res.object().get());
        }
    }
}
```

### Parameters

| Parameter                                                                                       | Type                                                                                            | Required                                                                                        | Description                                                                                     |
| ----------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------- |
| `request`                                                                                       | [TerminalsListPairingCodesRequest](../../models/operations/TerminalsListPairingCodesRequest.md) | :heavy_check_mark:                                                                              | The request object to use for the request.                                                      |

### Response

**[TerminalsListPairingCodesResponse](../../models/operations/TerminalsListPairingCodesResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 400, 429                    | application/hal+json        |
| models/errors/APIException  | 4XX, 5XX                    | \*/\*                       |

## terminalsGetPairingCode

> ℹ️ **Test mode**
>
> This endpoint currently does not support test mode yet.

Get a pairing code to onboard a point-of-sale terminal.

The response includes a human-readable `code` for manual entry on the terminal and, optionally, a QR Code as a
base64 encoded SVG data URI when you use the `include` query parameter with value `details.qrCode`.

### Example Usage

<!-- UsageSnippet language="java" operationID="terminals-get-pairing-code" method="get" path="/v2/terminals/pairing-codes/{pairingCodeId}" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.TerminalsGetPairingCodeResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        TerminalsGetPairingCodeResponse res = sdk.terminals().terminalsGetPairingCode()
                .pairingCodeId("termpc_R7gX5Ea9bC4DkFj3G")
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .call();

        if (res.entityPairingCode().isPresent()) {
            System.out.println(res.entityPairingCode().get());
        }
    }
}
```

### Parameters

| Parameter                                                                        | Type                                                                             | Required                                                                         | Description                                                                      | Example                                                                          |
| -------------------------------------------------------------------------------- | -------------------------------------------------------------------------------- | -------------------------------------------------------------------------------- | -------------------------------------------------------------------------------- | -------------------------------------------------------------------------------- |
| `pairingCodeId`                                                                  | *String*                                                                         | :heavy_check_mark:                                                               | Provide the ID of the terminal pairing code.                                     | termpc_R7gX5Ea9bC4DkFj3G                                                         |
| `include`                                                                        | *JsonNullable\<String>*                                                          | :heavy_minus_sign:                                                               | Include additional information in the response.                                  |                                                                                  |
| `idempotencyKey`                                                                 | *Optional\<String>*                                                              | :heavy_minus_sign:                                                               | A unique key to ensure idempotent requests. This key should be a UUID v4 string. | 123e4567-e89b-12d3-a456-426                                                      |

### Response

**[TerminalsGetPairingCodeResponse](../../models/operations/TerminalsGetPairingCodeResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 404, 429                    | application/hal+json        |
| models/errors/APIException  | 4XX, 5XX                    | \*/\*                       |

## terminalsRevokePairingCode

> ℹ️ **Test mode**
>
> This endpoint currently does not support test mode yet.

Revoke a pairing code, preventing the onboarding of new point-of-sale terminals.

Terminals that have already paired with this code are not affected.

### Example Usage

<!-- UsageSnippet language="java" operationID="terminals-revoke-pairing-code" method="delete" path="/v2/terminals/pairing-codes/{pairingCodeId}" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.TerminalsRevokePairingCodeResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        TerminalsRevokePairingCodeResponse res = sdk.terminals().terminalsRevokePairingCode()
                .pairingCodeId("termpc_R7gX5Ea9bC4DkFj3G")
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .call();

        if (res.entityPairingCode().isPresent()) {
            System.out.println(res.entityPairingCode().get());
        }
    }
}
```

### Parameters

| Parameter                                                                        | Type                                                                             | Required                                                                         | Description                                                                      | Example                                                                          |
| -------------------------------------------------------------------------------- | -------------------------------------------------------------------------------- | -------------------------------------------------------------------------------- | -------------------------------------------------------------------------------- | -------------------------------------------------------------------------------- |
| `pairingCodeId`                                                                  | *String*                                                                         | :heavy_check_mark:                                                               | Provide the ID of the terminal pairing code.                                     | termpc_R7gX5Ea9bC4DkFj3G                                                         |
| `idempotencyKey`                                                                 | *Optional\<String>*                                                              | :heavy_minus_sign:                                                               | A unique key to ensure idempotent requests. This key should be a UUID v4 string. | 123e4567-e89b-12d3-a456-426                                                      |

### Response

**[TerminalsRevokePairingCodeResponse](../../models/operations/TerminalsRevokePairingCodeResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 404, 422, 429               | application/hal+json        |
| models/errors/APIException  | 4XX, 5XX                    | \*/\*                       |