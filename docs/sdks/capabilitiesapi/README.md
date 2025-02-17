# CapabilitiesAPI
(*capabilitiesAPI()*)

## Overview

### Available Operations

* [list](#list) - List capabilities

## list

> 🚧 Beta feature
>
> This feature is currently in beta testing, and the final specification may still change.

Retrieve a list of capabilities for an organization.

This API provides detailed insights into the specific requirements and status of each client's onboarding journey.

Capabilities are at the organization level, indicating if the organization can perform a given capability.

For payments, regardless them being at the profile level, the capability is listed at the organization level.
This means that if at least one of the clients's profiles can receive payments,
the payments capability is enabled, communicating that the organization can indeed receive payments.

### Example Usage

```java
package hello.world;

import com.mollie.mollie.Mollie;
import com.mollie.mollie.models.operations.ListCapabilitiesResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Mollie sdk = Mollie.builder()
                .oAuth("<YOUR_O_AUTH_HERE>")
            .build();

        ListCapabilitiesResponse res = sdk.capabilitiesAPI().list()
                .call();

        if (res.object().isPresent()) {
            // handle response
        }
    }
}
```

### Response

**[ListCapabilitiesResponse](../../models/operations/ListCapabilitiesResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |