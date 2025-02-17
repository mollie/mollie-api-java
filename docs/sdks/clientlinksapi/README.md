# ClientLinksAPI
(*clientLinksAPI()*)

## Overview

### Available Operations

* [create](#create) - Create client link

## create

> 🚧 Open beta
>
> This feature is currently in open beta, and the final specification may still change.

Link a new or existing organization to your OAuth application, in effect creating a new client. The response
contains a `clientLink` where you should redirect your customer to.

The `clientLink` URL behaves similar to the regular OAuth authorization URL. It supports the following parameters
from the [Authorize](authorize) endpoint:

* `client_id`
* `state`
* `approval_prompt`
* `scope`

We recommend at least requesting the scopes `onboarding.read onboarding.write` this way.

Error handling is also dealt with similar to the [Authorize](authorize) endpoint: the customer is redirected back to
your app's redirect URL with the `error` and `error_description` parameters added to the URL.

### Example Usage

```java
package hello.world;

import com.mollie.mollie.Mollie;
import com.mollie.mollie.models.errors.CreateClientLinkClientLinksAPIResponseBody;
import com.mollie.mollie.models.errors.CreateClientLinkResponseBody;
import com.mollie.mollie.models.operations.CreateClientLinkAddress;
import com.mollie.mollie.models.operations.CreateClientLinkRequestBody;
import com.mollie.mollie.models.operations.CreateClientLinkResponse;
import com.mollie.mollie.models.operations.Owner;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws CreateClientLinkResponseBody, CreateClientLinkClientLinksAPIResponseBody, Exception {

        Mollie sdk = Mollie.builder()
                .oAuth("<YOUR_O_AUTH_HERE>")
            .build();

        CreateClientLinkRequestBody req = CreateClientLinkRequestBody.builder()
                .owner(Owner.builder()
                    .email("Loyal79@yahoo.com")
                    .givenName("<value>")
                    .familyName("<value>")
                    .build())
                .name("<value>")
                .address(CreateClientLinkAddress.builder()
                    .country("Afghanistan")
                    .build())
                .build();

        CreateClientLinkResponse res = sdk.clientLinksAPI().create()
                .request(req)
                .call();

        if (res.object().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                             | Type                                                                                  | Required                                                                              | Description                                                                           |
| ------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------- |
| `request`                                                                             | [CreateClientLinkRequestBody](../../models/operations/CreateClientLinkRequestBody.md) | :heavy_check_mark:                                                                    | The request object to use for the request.                                            |

### Response

**[CreateClientLinkResponse](../../models/operations/CreateClientLinkResponse.md)**

### Errors

| Error Type                                               | Status Code                                              | Content Type                                             |
| -------------------------------------------------------- | -------------------------------------------------------- | -------------------------------------------------------- |
| models/errors/CreateClientLinkResponseBody               | 404                                                      | application/hal+json                                     |
| models/errors/CreateClientLinkClientLinksAPIResponseBody | 422                                                      | application/hal+json                                     |
| models/errors/APIException                               | 4XX, 5XX                                                 | \*/\*                                                    |