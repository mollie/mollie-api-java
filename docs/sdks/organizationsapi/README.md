# OrganizationsAPI
(*organizationsAPI()*)

## Overview

### Available Operations

* [get](#get) - Get organization
* [getCurrent](#getcurrent) - Get current organization
* [getPartnerStatus](#getpartnerstatus) - Get partner status

## get

Retrieve a single organization by its ID.

You can normally only retrieve the currently authenticated organization with this endpoint. This is primarily useful
for OAuth apps. See also [Get current organization](get-current-organization).

If you have a *partner account*', you can retrieve organization details of connected organizations.

### Example Usage

```java
package hello.world;

import com.mollie.mollie.Mollie;
import com.mollie.mollie.models.errors.GetOrganizationResponseBody;
import com.mollie.mollie.models.operations.GetOrganizationResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws GetOrganizationResponseBody, Exception {

        Mollie sdk = Mollie.builder()
                .oAuth("<YOUR_O_AUTH_HERE>")
            .build();

        GetOrganizationResponse res = sdk.organizationsAPI().get()
                .id("org_12345678")
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
| `id`                                                                                                                                                                                                                                                                                                                                                                                   | *String*                                                                                                                                                                                                                                                                                                                                                                               | :heavy_check_mark:                                                                                                                                                                                                                                                                                                                                                                     | Provide the ID of the item you want to perform this operation on.                                                                                                                                                                                                                                                                                                                      | org_12345678                                                                                                                                                                                                                                                                                                                                                                           |
| `testmode`                                                                                                                                                                                                                                                                                                                                                                             | *JsonNullable\<Boolean>*                                                                                                                                                                                                                                                                                                                                                               | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                     | Most API credentials are specifically created for either live mode or test mode. In those cases the `testmode` query<br/>parameter can be omitted. For organization-level credentials such as OAuth access tokens, you can enable test mode by<br/>setting the `testmode` query parameter to `true`.<br/><br/>Test entities cannot be retrieved when the endpoint is set to live mode, and vice versa. | false                                                                                                                                                                                                                                                                                                                                                                                  |

### Response

**[GetOrganizationResponse](../../models/operations/GetOrganizationResponse.md)**

### Errors

| Error Type                                | Status Code                               | Content Type                              |
| ----------------------------------------- | ----------------------------------------- | ----------------------------------------- |
| models/errors/GetOrganizationResponseBody | 404                                       | application/hal+json                      |
| models/errors/APIException                | 4XX, 5XX                                  | \*/\*                                     |

## getCurrent

Retrieve the currently authenticated organization. A convenient alias of the [Get organization](get-organization)
endpoint.

For a complete reference of the organization object, refer to the [Get organization](get-organization) endpoint
documentation.

### Example Usage

```java
package hello.world;

import com.mollie.mollie.Mollie;
import com.mollie.mollie.models.operations.GetCurrentOrganizationResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Mollie sdk = Mollie.builder()
                .oAuth("<YOUR_O_AUTH_HERE>")
            .build();

        GetCurrentOrganizationResponse res = sdk.organizationsAPI().getCurrent()
                .call();

        if (res.any().isPresent()) {
            // handle response
        }
    }
}
```

### Response

**[GetCurrentOrganizationResponse](../../models/operations/GetCurrentOrganizationResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## getPartnerStatus

Retrieve partnership details about the currently authenticated organization. Only relevant for so-called *partner
accounts*.

### Example Usage

```java
package hello.world;

import com.mollie.mollie.Mollie;
import com.mollie.mollie.models.operations.GetPartnerStatusResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Mollie sdk = Mollie.builder()
                .oAuth("<YOUR_O_AUTH_HERE>")
            .build();

        GetPartnerStatusResponse res = sdk.organizationsAPI().getPartnerStatus()
                .call();

        if (res.object().isPresent()) {
            // handle response
        }
    }
}
```

### Response

**[GetPartnerStatusResponse](../../models/operations/GetPartnerStatusResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |