# WebhookEvents
(*webhookEvents()*)

## Overview

### Available Operations

* [getEvent](#getevent) - Get a Webhook Event

## getEvent

Retrieve a single webhook event object by its event ID.

> 🔑 Access with
>
> [Access token with **events.read**](/reference/authentication)

### Example Usage

```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.GetWebhookEventResponseBody;
import com.mollie.mollie.models.operations.GetWebhookEventResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws GetWebhookEventResponseBody, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey("<YOUR_BEARER_TOKEN_HERE>")
                    .build())
            .build();

        GetWebhookEventResponse res = sdk.webhookEvents().getEvent()
                .id("event_jd9v34P5YqN9pT8n3HJyH")
                .call();

        if (res.object().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                         | Type                                                              | Required                                                          | Description                                                       | Example                                                           |
| ----------------------------------------------------------------- | ----------------------------------------------------------------- | ----------------------------------------------------------------- | ----------------------------------------------------------------- | ----------------------------------------------------------------- |
| `id`                                                              | *String*                                                          | :heavy_check_mark:                                                | Provide the ID of the item you want to perform this operation on. | event_jd9v34P5YqN9pT8n3HJyH                                       |

### Response

**[GetWebhookEventResponse](../../models/operations/GetWebhookEventResponse.md)**

### Errors

| Error Type                                | Status Code                               | Content Type                              |
| ----------------------------------------- | ----------------------------------------- | ----------------------------------------- |
| models/errors/GetWebhookEventResponseBody | 404                                       | application/hal+json                      |
| models/errors/APIException                | 4XX, 5XX                                  | \*/\*                                     |