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
import com.mollie.mollie.models.components.OauthGrantType;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.*;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
            .build();

        OauthGenerateTokensResponse res = sdk.oauth().generate()
                .security(OauthGenerateTokensSecurity.builder()
                    .username("")
                    .password("")
                    .build())
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .requestBody(OauthGenerateTokensRequestBody.builder()
                    .grantType(OauthGrantType.AUTHORIZATION_CODE)
                    .code("auth_...")
                    .refreshToken("refresh_...")
                    .redirectUri("https://example.com/redirect")
                    .build())
                .call();

        if (res.object().isPresent()) {
            System.out.println(res.object().get());
        }
    }
}
```

### Parameters

| Parameter                                                                                                                 | Type                                                                                                                      | Required                                                                                                                  | Description                                                                                                               | Example                                                                                                                   |
| ------------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------- |
| `security`                                                                                                                | [com.mollie.mollie.models.operations.OauthGenerateTokensSecurity](../../models/operations/OauthGenerateTokensSecurity.md) | :heavy_check_mark:                                                                                                        | The security requirements to use for the request.                                                                         |                                                                                                                           |
| `idempotencyKey`                                                                                                          | *Optional\<String>*                                                                                                       | :heavy_minus_sign:                                                                                                        | A unique key to ensure idempotent requests. This key should be a UUID v4 string.                                          | 123e4567-e89b-12d3-a456-426                                                                                               |
| `requestBody`                                                                                                             | [Optional\<OauthGenerateTokensRequestBody>](../../models/operations/OauthGenerateTokensRequestBody.md)                    | :heavy_minus_sign:                                                                                                        | N/A                                                                                                                       |                                                                                                                           |
| `serverURL`                                                                                                               | *String*                                                                                                                  | :heavy_minus_sign:                                                                                                        | An optional server URL to use.                                                                                            | http://localhost:8080                                                                                                     |

### Response

**[OauthGenerateTokensResponse](../../models/operations/OauthGenerateTokensResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 429                         | application/hal+json        |
| models/errors/APIException  | 4XX, 5XX                    | \*/\*                       |

## revoke

Revoke an access token or refresh token. Once revoked, the token can no longer be used.

Revoking a refresh token revokes all access tokens that were created using the same authorization.

This endpoint can only be accessed using **OAuth client credentials**.

### Example Usage

<!-- UsageSnippet language="java" operationID="oauth-revoke-tokens" method="delete" path="/oauth2/tokens" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.OauthTokenTypeHint;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.*;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
            .build();

        OauthRevokeTokensResponse res = sdk.oauth().revoke()
                .security(OauthRevokeTokensSecurity.builder()
                    .username("")
                    .password("")
                    .build())
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .requestBody(OauthRevokeTokensRequestBody.builder()
                    .tokenTypeHint(OauthTokenTypeHint.ACCESS_TOKEN)
                    .token("access_...")
                    .build())
                .call();

        // handle response
    }
}
```

### Parameters

| Parameter                                                                                                             | Type                                                                                                                  | Required                                                                                                              | Description                                                                                                           | Example                                                                                                               |
| --------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------- |
| `security`                                                                                                            | [com.mollie.mollie.models.operations.OauthRevokeTokensSecurity](../../models/operations/OauthRevokeTokensSecurity.md) | :heavy_check_mark:                                                                                                    | The security requirements to use for the request.                                                                     |                                                                                                                       |
| `idempotencyKey`                                                                                                      | *Optional\<String>*                                                                                                   | :heavy_minus_sign:                                                                                                    | A unique key to ensure idempotent requests. This key should be a UUID v4 string.                                      | 123e4567-e89b-12d3-a456-426                                                                                           |
| `requestBody`                                                                                                         | [Optional\<OauthRevokeTokensRequestBody>](../../models/operations/OauthRevokeTokensRequestBody.md)                    | :heavy_minus_sign:                                                                                                    | N/A                                                                                                                   |                                                                                                                       |
| `serverURL`                                                                                                           | *String*                                                                                                              | :heavy_minus_sign:                                                                                                    | An optional server URL to use.                                                                                        | http://localhost:8080                                                                                                 |

### Response

**[OauthRevokeTokensResponse](../../models/operations/OauthRevokeTokensResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 429                         | application/hal+json        |
| models/errors/APIException  | 4XX, 5XX                    | \*/\*                       |