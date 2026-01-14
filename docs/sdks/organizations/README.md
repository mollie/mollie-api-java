# Organizations

## Overview

### Available Operations

* [get](#get) - Get organization
* [getCurrent](#getcurrent) - Get current organization
* [getPartner](#getpartner) - Get partner status

## get

Retrieve a single organization by its ID.

You can normally only retrieve the currently authenticated organization with this endpoint. This is primarily useful
for OAuth apps. See also [Get current organization](get-current-organization).

If you have a *partner account*', you can retrieve organization details of connected organizations.

### Example Usage

<!-- UsageSnippet language="java" operationID="get-organization" method="get" path="/organizations/{organizationId}" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.GetOrganizationResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .testmode(false)
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        GetOrganizationResponse res = sdk.organizations().get()
                .organizationId("org_1234567")
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .call();

        if (res.entityOrganization().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                                                                               | Type                                                                                                                                                                    | Required                                                                                                                                                                | Description                                                                                                                                                             | Example                                                                                                                                                                 |
| ----------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `organizationId`                                                                                                                                                        | *String*                                                                                                                                                                | :heavy_check_mark:                                                                                                                                                      | Provide the ID of the related organization.                                                                                                                             | org_1234567                                                                                                                                                             |
| `testmode`                                                                                                                                                              | *Optional\<Boolean>*                                                                                                                                                    | :heavy_minus_sign:                                                                                                                                                      | You can enable test mode by setting the `testmode` query parameter to `true`.<br/><br/>Test entities cannot be retrieved when the endpoint is set to live mode, and vice versa. |                                                                                                                                                                         |
| `idempotencyKey`                                                                                                                                                        | *Optional\<String>*                                                                                                                                                     | :heavy_minus_sign:                                                                                                                                                      | A unique key to ensure idempotent requests. This key should be a UUID v4 string.                                                                                        | 123e4567-e89b-12d3-a456-426                                                                                                                                             |

### Response

**[GetOrganizationResponse](../../models/operations/GetOrganizationResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 404                         | application/hal+json        |
| models/errors/APIException  | 4XX, 5XX                    | \*/\*                       |

## getCurrent

Retrieve the currently authenticated organization. A convenient alias of the [Get organization](get-organization)
endpoint.

For a complete reference of the organization object, refer to the [Get organization](get-organization) endpoint
documentation.

### Example Usage

<!-- UsageSnippet language="java" operationID="get-current-organization" method="get" path="/organizations/me" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.operations.GetCurrentOrganizationResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        GetCurrentOrganizationResponse res = sdk.organizations().getCurrent()
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .call();

        if (res.entityOrganization().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                        | Type                                                                             | Required                                                                         | Description                                                                      | Example                                                                          |
| -------------------------------------------------------------------------------- | -------------------------------------------------------------------------------- | -------------------------------------------------------------------------------- | -------------------------------------------------------------------------------- | -------------------------------------------------------------------------------- |
| `idempotencyKey`                                                                 | *Optional\<String>*                                                              | :heavy_minus_sign:                                                               | A unique key to ensure idempotent requests. This key should be a UUID v4 string. | 123e4567-e89b-12d3-a456-426                                                      |

### Response

**[GetCurrentOrganizationResponse](../../models/operations/GetCurrentOrganizationResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## getPartner

Retrieve partnership details about the currently authenticated organization. Only relevant for so-called *partner
accounts*.

### Example Usage

<!-- UsageSnippet language="java" operationID="get-partner-status" method="get" path="/organizations/me/partner" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.operations.GetPartnerStatusResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        GetPartnerStatusResponse res = sdk.organizations().getPartner()
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .call();

        if (res.object().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                        | Type                                                                             | Required                                                                         | Description                                                                      | Example                                                                          |
| -------------------------------------------------------------------------------- | -------------------------------------------------------------------------------- | -------------------------------------------------------------------------------- | -------------------------------------------------------------------------------- | -------------------------------------------------------------------------------- |
| `idempotencyKey`                                                                 | *Optional\<String>*                                                              | :heavy_minus_sign:                                                               | A unique key to ensure idempotent requests. This key should be a UUID v4 string. | 123e4567-e89b-12d3-a456-426                                                      |

### Response

**[GetPartnerStatusResponse](../../models/operations/GetPartnerStatusResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |