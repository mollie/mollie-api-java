# Webhooks

## Overview

### Available Operations

* [create](#create) - Create a webhook
* [list](#list) - List all webhooks
* [update](#update) - Update a webhook
* [get](#get) - Get a webhook
* [delete](#delete) - Delete a webhook
* [test](#test) - Test a webhook

## create

A webhook must have a name, an url and a list of event types. You can also create webhooks in the webhooks settings section of the Dashboard.

### Example Usage

<!-- UsageSnippet language="java" operationID="create-webhook" method="post" path="/v2/webhooks" example="create-webhook-200" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.components.WebhookEventTypes;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.*;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .advancedAccessToken(System.getenv().getOrDefault("ADVANCED_ACCESS_TOKEN", ""))
                    .build())
            .build();

        CreateWebhookResponse res = sdk.webhooks().create()
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .xClientSignature("MEUCIQDx8sJvK3z...")
                .xClientSignedAt("2025-01-01T12:00:00Z")
                .requestBody(CreateWebhookRequestBody.builder()
                    .name("Webhook #1")
                    .url("https://mollie.com/")
                    .eventTypes(EventTypes.of(WebhookEventTypes.PAYMENT_LINK_PAID))
                    .testmode(false)
                    .build())
                .call();

        if (res.createWebhook().isPresent()) {
            System.out.println(res.createWebhook().get());
        }
    }
}
```

### Parameters

| Parameter                                                                                                                                                                               | Type                                                                                                                                                                                    | Required                                                                                                                                                                                | Description                                                                                                                                                                             | Example                                                                                                                                                                                 |
| --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `idempotencyKey`                                                                                                                                                                        | *Optional\<String>*                                                                                                                                                                     | :heavy_minus_sign:                                                                                                                                                                      | A unique key to ensure idempotent requests. This key should be a UUID v4 string.                                                                                                        | 123e4567-e89b-12d3-a456-426                                                                                                                                                             |
| `xClientSignature`                                                                                                                                                                      | *Optional\<String>*                                                                                                                                                                     | :heavy_minus_sign:                                                                                                                                                                      | A cryptographic signature of the request, used to verify that it was sent by you and hasn't been tampered with. Required if you've enabled request signing for your integration.        | MEUCIQDx8sJvK3z...                                                                                                                                                                      |
| `xClientSignedAt`                                                                                                                                                                       | *Optional\<String>*                                                                                                                                                                     | :heavy_minus_sign:                                                                                                                                                                      | The timestamp, in ISO 8601 format, at which you generated the `X-Client-Signature`. Required together with `X-Client-Signature` if you've enabled request signing for your integration. | 2025-01-01T12:00:00Z                                                                                                                                                                    |
| `requestBody`                                                                                                                                                                           | [Optional\<CreateWebhookRequestBody>](../../models/operations/CreateWebhookRequestBody.md)                                                                                              | :heavy_minus_sign:                                                                                                                                                                      | N/A                                                                                                                                                                                     |                                                                                                                                                                                         |

### Response

**[CreateWebhookResponse](../../models/operations/CreateWebhookResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 422, 429                    | application/hal+json        |
| models/errors/APIException  | 4XX, 5XX                    | \*/\*                       |

## list

Returns a paginated list of your webhooks. If no webhook endpoints are available, the resulting array will be empty. This request should never throw an error.

### Example Usage

<!-- UsageSnippet language="java" operationID="list-webhooks" method="get" path="/v2/webhooks" example="list-webhook-200" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.*;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.ListWebhooksRequest;
import com.mollie.mollie.models.operations.ListWebhooksResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .testmode(false)
                .security(Security.builder()
                    .advancedAccessToken(System.getenv().getOrDefault("ADVANCED_ACCESS_TOKEN", ""))
                    .build())
            .build();

        ListWebhooksRequest req = ListWebhooksRequest.builder()
                .from("hook_B2EyhTH5N4KWUnoYPcgiH")
                .limit(50L)
                .sort(Sorting.DESC)
                .eventTypes(WebhookEventTypes.PAYMENT_LINK_PAID)
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .xClientSignature("MEUCIQDx8sJvK3z...")
                .xClientSignedAt("2025-01-01T12:00:00Z")
                .build();


        sdk.webhooks().list()
                .callAsStream()
                .forEach((ListWebhooksResponse item) -> {
                   // handle page
                });

    }
}
```

### Parameters

| Parameter                                                             | Type                                                                  | Required                                                              | Description                                                           |
| --------------------------------------------------------------------- | --------------------------------------------------------------------- | --------------------------------------------------------------------- | --------------------------------------------------------------------- |
| `request`                                                             | [ListWebhooksRequest](../../models/operations/ListWebhooksRequest.md) | :heavy_check_mark:                                                    | The request object to use for the request.                            |

### Response

**[ListWebhooksResponse](../../models/operations/ListWebhooksResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 400, 429                    | application/hal+json        |
| models/errors/APIException  | 4XX, 5XX                    | \*/\*                       |

## update

Updates the webhook. You may edit the name, url and the list of subscribed event types.

### Example Usage: create-webhook-200

<!-- UsageSnippet language="java" operationID="update-webhook" method="patch" path="/v2/webhooks/{webhookId}" example="create-webhook-200" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.components.WebhookEventTypes;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.*;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .advancedAccessToken(System.getenv().getOrDefault("ADVANCED_ACCESS_TOKEN", ""))
                    .build())
            .build();

        UpdateWebhookRequest req = UpdateWebhookRequest.builder()
                .webhookId("hook_1234567890")
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .requestBody(UpdateWebhookRequestBody.builder()
                    .name("Webhook #1")
                    .url("https://mollie.com/")
                    .eventTypes(UpdateWebhookEventTypes.of(WebhookEventTypes.PAYMENT_LINK_PAID))
                    .testmode(false)
                    .build())
                .build();

        UpdateWebhookResponse res = sdk.webhooks().update()
                .request(req)
                .call();

        if (res.entityWebhook().isPresent()) {
            System.out.println(res.entityWebhook().get());
        }
    }
}
```
### Example Usage: get-webhook-200

<!-- UsageSnippet language="java" operationID="update-webhook" method="patch" path="/v2/webhooks/{webhookId}" example="get-webhook-200" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.components.WebhookEventTypes;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.*;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .advancedAccessToken(System.getenv().getOrDefault("ADVANCED_ACCESS_TOKEN", ""))
                    .build())
            .build();

        UpdateWebhookRequest req = UpdateWebhookRequest.builder()
                .webhookId("hook_1234567890")
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .xClientSignature("MEUCIQDx8sJvK3z...")
                .xClientSignedAt("2025-01-01T12:00:00Z")
                .requestBody(UpdateWebhookRequestBody.builder()
                    .name("Webhook #1")
                    .url("https://mollie.com/")
                    .eventTypes(UpdateWebhookEventTypes.of(WebhookEventTypes.PAYMENT_LINK_PAID))
                    .testmode(false)
                    .build())
                .build();

        UpdateWebhookResponse res = sdk.webhooks().update()
                .request(req)
                .call();

        if (res.entityWebhook().isPresent()) {
            System.out.println(res.entityWebhook().get());
        }
    }
}
```
### Example Usage: get-webhook-200-1

<!-- UsageSnippet language="java" operationID="update-webhook" method="patch" path="/v2/webhooks/{webhookId}" example="get-webhook-200-1" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.components.WebhookEventTypes;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.*;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .advancedAccessToken(System.getenv().getOrDefault("ADVANCED_ACCESS_TOKEN", ""))
                    .build())
            .build();

        UpdateWebhookRequest req = UpdateWebhookRequest.builder()
                .webhookId("hook_1234567890")
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .xClientSignature("MEUCIQDx8sJvK3z...")
                .xClientSignedAt("2025-01-01T12:00:00Z")
                .requestBody(UpdateWebhookRequestBody.builder()
                    .name("Webhook #1")
                    .url("https://mollie.com/")
                    .eventTypes(UpdateWebhookEventTypes.of(WebhookEventTypes.PAYMENT_LINK_PAID))
                    .testmode(false)
                    .build())
                .build();

        UpdateWebhookResponse res = sdk.webhooks().update()
                .request(req)
                .call();

        if (res.entityWebhook().isPresent()) {
            System.out.println(res.entityWebhook().get());
        }
    }
}
```

### Parameters

| Parameter                                                               | Type                                                                    | Required                                                                | Description                                                             |
| ----------------------------------------------------------------------- | ----------------------------------------------------------------------- | ----------------------------------------------------------------------- | ----------------------------------------------------------------------- |
| `request`                                                               | [UpdateWebhookRequest](../../models/operations/UpdateWebhookRequest.md) | :heavy_check_mark:                                                      | The request object to use for the request.                              |

### Response

**[UpdateWebhookResponse](../../models/operations/UpdateWebhookResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 404, 422, 429               | application/hal+json        |
| models/errors/APIException  | 4XX, 5XX                    | \*/\*                       |

## get

Retrieve a single webhook object by its ID.

### Example Usage: get-webhook-200

<!-- UsageSnippet language="java" operationID="get-webhook" method="get" path="/v2/webhooks/{webhookId}" example="get-webhook-200" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.GetWebhookRequest;
import com.mollie.mollie.models.operations.GetWebhookResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .testmode(false)
                .security(Security.builder()
                    .advancedAccessToken(System.getenv().getOrDefault("ADVANCED_ACCESS_TOKEN", ""))
                    .build())
            .build();

        GetWebhookRequest req = GetWebhookRequest.builder()
                .webhookId("hook_1234567890")
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .xClientSignature("MEUCIQDx8sJvK3z...")
                .xClientSignedAt("2025-01-01T12:00:00Z")
                .build();

        GetWebhookResponse res = sdk.webhooks().get()
                .request(req)
                .call();

        if (res.entityWebhook().isPresent()) {
            System.out.println(res.entityWebhook().get());
        }
    }
}
```
### Example Usage: get-webhook-200-1

<!-- UsageSnippet language="java" operationID="get-webhook" method="get" path="/v2/webhooks/{webhookId}" example="get-webhook-200-1" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.GetWebhookRequest;
import com.mollie.mollie.models.operations.GetWebhookResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .testmode(false)
                .security(Security.builder()
                    .advancedAccessToken(System.getenv().getOrDefault("ADVANCED_ACCESS_TOKEN", ""))
                    .build())
            .build();

        GetWebhookRequest req = GetWebhookRequest.builder()
                .webhookId("hook_1234567890")
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .xClientSignature("MEUCIQDx8sJvK3z...")
                .xClientSignedAt("2025-01-01T12:00:00Z")
                .build();

        GetWebhookResponse res = sdk.webhooks().get()
                .request(req)
                .call();

        if (res.entityWebhook().isPresent()) {
            System.out.println(res.entityWebhook().get());
        }
    }
}
```

### Parameters

| Parameter                                                         | Type                                                              | Required                                                          | Description                                                       |
| ----------------------------------------------------------------- | ----------------------------------------------------------------- | ----------------------------------------------------------------- | ----------------------------------------------------------------- |
| `request`                                                         | [GetWebhookRequest](../../models/operations/GetWebhookRequest.md) | :heavy_check_mark:                                                | The request object to use for the request.                        |

### Response

**[GetWebhookResponse](../../models/operations/GetWebhookResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 404, 422, 429               | application/hal+json        |
| models/errors/APIException  | 4XX, 5XX                    | \*/\*                       |

## delete

Delete a single webhook object by its webhook ID.

### Example Usage

<!-- UsageSnippet language="java" operationID="delete-webhook" method="delete" path="/v2/webhooks/{webhookId}" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.*;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .advancedAccessToken(System.getenv().getOrDefault("ADVANCED_ACCESS_TOKEN", ""))
                    .build())
            .build();

        DeleteWebhookRequest req = DeleteWebhookRequest.builder()
                .webhookId("hook_1234567890")
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .xClientSignature("MEUCIQDx8sJvK3z...")
                .xClientSignedAt("2025-01-01T12:00:00Z")
                .requestBody(DeleteWebhookRequestBody.builder()
                    .testmode(false)
                    .build())
                .build();

        DeleteWebhookResponse res = sdk.webhooks().delete()
                .request(req)
                .call();

        // handle response
    }
}
```

### Parameters

| Parameter                                                               | Type                                                                    | Required                                                                | Description                                                             |
| ----------------------------------------------------------------------- | ----------------------------------------------------------------------- | ----------------------------------------------------------------------- | ----------------------------------------------------------------------- |
| `request`                                                               | [DeleteWebhookRequest](../../models/operations/DeleteWebhookRequest.md) | :heavy_check_mark:                                                      | The request object to use for the request.                              |

### Response

**[DeleteWebhookResponse](../../models/operations/DeleteWebhookResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 404, 422, 429               | application/hal+json        |
| models/errors/APIException  | 4XX, 5XX                    | \*/\*                       |

## test

Sends a test event to the webhook to verify the endpoint is working as expected.

### Example Usage

<!-- UsageSnippet language="java" operationID="test-webhook" method="post" path="/v2/webhooks/{webhookId}/ping" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.*;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .advancedAccessToken(System.getenv().getOrDefault("ADVANCED_ACCESS_TOKEN", ""))
                    .build())
            .build();

        TestWebhookRequest req = TestWebhookRequest.builder()
                .webhookId("hook_1234567890")
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .xClientSignature("MEUCIQDx8sJvK3z...")
                .xClientSignedAt("2025-01-01T12:00:00Z")
                .requestBody(TestWebhookRequestBody.builder()
                    .testmode(false)
                    .build())
                .build();

        TestWebhookResponse res = sdk.webhooks().test()
                .request(req)
                .call();

        // handle response
    }
}
```

### Parameters

| Parameter                                                           | Type                                                                | Required                                                            | Description                                                         |
| ------------------------------------------------------------------- | ------------------------------------------------------------------- | ------------------------------------------------------------------- | ------------------------------------------------------------------- |
| `request`                                                           | [TestWebhookRequest](../../models/operations/TestWebhookRequest.md) | :heavy_check_mark:                                                  | The request object to use for the request.                          |

### Response

**[TestWebhookResponse](../../models/operations/TestWebhookResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 404, 422, 429               | application/hal+json        |
| models/errors/APIException  | 4XX, 5XX                    | \*/\*                       |