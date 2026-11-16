# WebhookEvents

## Overview

### Available Operations

* [get](#get) - Get a Webhook Event

## get

Retrieve a single webhook event object by its event ID.

### Example Usage

<!-- UsageSnippet language="java" operationID="get-webhook-event" method="get" path="/v2/events/{webhookEventId}" example="get-webhook-event-200" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.GetWebhookEventRequest;
import com.mollie.mollie.models.operations.GetWebhookEventResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .testmode(false)
                .security(Security.builder()
                    .advancedAccessToken(System.getenv().getOrDefault("ADVANCED_ACCESS_TOKEN", ""))
                    .build())
            .build();

        GetWebhookEventRequest req = GetWebhookEventRequest.builder()
                .webhookEventId("event_1234567890")
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .xClientSignature("MEUCIQDx8sJvK3z...")
                .xClientSignedAt("2025-01-01T12:00:00Z")
                .build();

        GetWebhookEventResponse res = sdk.webhookEvents().get()
                .request(req)
                .call();

        if (res.entityWebhookEvent().isPresent()) {
            System.out.println(res.entityWebhookEvent().get());
        }
    }
}
```

### Parameters

| Parameter                                                                   | Type                                                                        | Required                                                                    | Description                                                                 |
| --------------------------------------------------------------------------- | --------------------------------------------------------------------------- | --------------------------------------------------------------------------- | --------------------------------------------------------------------------- |
| `request`                                                                   | [GetWebhookEventRequest](../../models/operations/GetWebhookEventRequest.md) | :heavy_check_mark:                                                          | The request object to use for the request.                                  |

### Response

**[GetWebhookEventResponse](../../models/operations/GetWebhookEventResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 404, 429                    | application/hal+json        |
| models/errors/APIException  | 4XX, 5XX                    | \*/\*                       |