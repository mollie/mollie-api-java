# Oauth

## Overview

### Available Operations

* [generate](#generate) - Generate tokens
* [revoke](#revoke) - Revoke tokens

## generate

Exchange the authorization code you received from the [Authorize endpoint](oauth-authorize) for an 'access token'
API credential, with which you can communicate with the Mollie API on behalf of the consenting merchant.

This endpoint can only be accessed using **OAuth client credentials**.

### Example Usage

<!-- UsageSnippet language="java" operationID="oauth-generate-tokens" method="post" path="/oauth2/tokens" example="oauth-generate-tokens" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.operations.OauthGenerateTokensResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .oAuth(System.getenv().getOrDefault("O_AUTH", ""))
                    .build())
            .build();

        OauthGenerateTokensResponse res = sdk.oauth().generate()
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .call();

        if (res.body().isPresent()) {
            System.out.println(res.body().get());
        }
    }
}
```

### Parameters

| Parameter                                                                                              | Type                                                                                                   | Required                                                                                               | Description                                                                                            | Example                                                                                                |
| ------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------ |
| `idempotencyKey`                                                                                       | *Optional\<String>*                                                                                    | :heavy_minus_sign:                                                                                     | A unique key to ensure idempotent requests. This key should be a UUID v4 string.                       | 123e4567-e89b-12d3-a456-426                                                                            |
| `requestBody`                                                                                          | [Optional\<OauthGenerateTokensRequestBody>](../../models/operations/OauthGenerateTokensRequestBody.md) | :heavy_minus_sign:                                                                                     | N/A                                                                                                    |                                                                                                        |
| `serverURL`                                                                                            | *String*                                                                                               | :heavy_minus_sign:                                                                                     | An optional server URL to use.                                                                         | http://localhost:8080                                                                                  |

### Response

**[OauthGenerateTokensResponse](../../models/operations/OauthGenerateTokensResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## revoke

Revoke an access token or refresh token. Once revoked, the token can no longer be used.

Revoking a refresh token revokes all access tokens that were created using the same authorization.

This endpoint can only be accessed using **OAuth client credentials**.

### Example Usage

<!-- UsageSnippet language="java" operationID="oauth-revoke-tokens" method="delete" path="/oauth2/tokens" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.operations.OauthRevokeTokensResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .oAuth(System.getenv().getOrDefault("O_AUTH", ""))
                    .build())
            .build();

        OauthRevokeTokensResponse res = sdk.oauth().revoke()
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .call();

        // handle response
    }
}
```

### Parameters

| Parameter                                                                                          | Type                                                                                               | Required                                                                                           | Description                                                                                        | Example                                                                                            |
| -------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------- |
| `idempotencyKey`                                                                                   | *Optional\<String>*                                                                                | :heavy_minus_sign:                                                                                 | A unique key to ensure idempotent requests. This key should be a UUID v4 string.                   | 123e4567-e89b-12d3-a456-426                                                                        |
| `requestBody`                                                                                      | [Optional\<OauthRevokeTokensRequestBody>](../../models/operations/OauthRevokeTokensRequestBody.md) | :heavy_minus_sign:                                                                                 | N/A                                                                                                |                                                                                                    |
| `serverURL`                                                                                        | *String*                                                                                           | :heavy_minus_sign:                                                                                 | An optional server URL to use.                                                                     | http://localhost:8080                                                                              |

### Response

**[OauthRevokeTokensResponse](../../models/operations/OauthRevokeTokensResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |