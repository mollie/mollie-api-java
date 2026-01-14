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

<!-- UsageSnippet language="java" operationID="create-webhook" method="post" path="/webhooks" -->
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
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        CreateWebhookResponse res = sdk.webhooks().create()
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .requestBody(CreateWebhookRequestBody.builder()
                    .name("Webhook #1")
                    .url("https://mollie.com/")
                    .eventTypes(EventTypes.of(WebhookEventTypes.PAYMENT_LINK_PAID))
                    .testmode(false)
                    .build())
                .call();

        if (res.createWebhook().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                  | Type                                                                                       | Required                                                                                   | Description                                                                                | Example                                                                                    |
| ------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------ |
| `idempotencyKey`                                                                           | *Optional\<String>*                                                                        | :heavy_minus_sign:                                                                         | A unique key to ensure idempotent requests. This key should be a UUID v4 string.           | 123e4567-e89b-12d3-a456-426                                                                |
| `requestBody`                                                                              | [Optional\<CreateWebhookRequestBody>](../../models/operations/CreateWebhookRequestBody.md) | :heavy_minus_sign:                                                                         | N/A                                                                                        |                                                                                            |

### Response

**[CreateWebhookResponse](../../models/operations/CreateWebhookResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 422                         | application/hal+json        |
| models/errors/APIException  | 4XX, 5XX                    | \*/\*                       |

## list

Returns a paginated list of your webhooks. If no webhook endpoints are available, the resulting array will be empty. This request should never throw an error.

### Example Usage

<!-- UsageSnippet language="java" operationID="list-webhooks" method="get" path="/webhooks" -->
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
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        ListWebhooksRequest req = ListWebhooksRequest.builder()
                .from("hook_B2EyhTH5N4KWUnoYPcgiH")
                .limit(50L)
                .sort(Sorting.DESC)
                .eventTypes(WebhookEventTypes.PAYMENT_LINK_PAID)
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .build();

        ListWebhooksResponse res = sdk.webhooks().list()
                .request(req)
                .call();

        if (res.object().isPresent()) {
            // handle response
        }
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
| models/errors/ErrorResponse | 400                         | application/hal+json        |
| models/errors/APIException  | 4XX, 5XX                    | \*/\*                       |

## update

Updates the webhook. You may edit the name, url and the list of subscribed event types.

### Example Usage

<!-- UsageSnippet language="java" operationID="update-webhook" method="patch" path="/webhooks/{webhookId}" -->
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
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        UpdateWebhookResponse res = sdk.webhooks().update()
                .webhookId("hook_1234567890")
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .requestBody(UpdateWebhookRequestBody.builder()
                    .name("Webhook #1")
                    .url("https://mollie.com/")
                    .eventTypes(UpdateWebhookEventTypes.of(WebhookEventTypes.PAYMENT_LINK_PAID))
                    .testmode(false)
                    .build())
                .call();

        if (res.entityWebhook().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                  | Type                                                                                       | Required                                                                                   | Description                                                                                | Example                                                                                    |
| ------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------ |
| `webhookId`                                                                                | *String*                                                                                   | :heavy_check_mark:                                                                         | Provide the ID of the related webhook.                                                     | hook_1234567890                                                                            |
| `idempotencyKey`                                                                           | *Optional\<String>*                                                                        | :heavy_minus_sign:                                                                         | A unique key to ensure idempotent requests. This key should be a UUID v4 string.           | 123e4567-e89b-12d3-a456-426                                                                |
| `requestBody`                                                                              | [Optional\<UpdateWebhookRequestBody>](../../models/operations/UpdateWebhookRequestBody.md) | :heavy_minus_sign:                                                                         | N/A                                                                                        |                                                                                            |

### Response

**[UpdateWebhookResponse](../../models/operations/UpdateWebhookResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 404, 422                    | application/hal+json        |
| models/errors/APIException  | 4XX, 5XX                    | \*/\*                       |

## get

Retrieve a single webhook object by its ID.

### Example Usage

<!-- UsageSnippet language="java" operationID="get-webhook" method="get" path="/webhooks/{webhookId}" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.GetWebhookResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .testmode(false)
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        GetWebhookResponse res = sdk.webhooks().get()
                .webhookId("hook_1234567890")
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .call();

        if (res.entityWebhook().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                                                                               | Type                                                                                                                                                                    | Required                                                                                                                                                                | Description                                                                                                                                                             | Example                                                                                                                                                                 |
| ----------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `webhookId`                                                                                                                                                             | *String*                                                                                                                                                                | :heavy_check_mark:                                                                                                                                                      | Provide the ID of the related webhook.                                                                                                                                  | hook_1234567890                                                                                                                                                         |
| `testmode`                                                                                                                                                              | *Optional\<Boolean>*                                                                                                                                                    | :heavy_minus_sign:                                                                                                                                                      | You can enable test mode by setting the `testmode` query parameter to `true`.<br/><br/>Test entities cannot be retrieved when the endpoint is set to live mode, and vice versa. |                                                                                                                                                                         |
| `idempotencyKey`                                                                                                                                                        | *Optional\<String>*                                                                                                                                                     | :heavy_minus_sign:                                                                                                                                                      | A unique key to ensure idempotent requests. This key should be a UUID v4 string.                                                                                        | 123e4567-e89b-12d3-a456-426                                                                                                                                             |

### Response

**[GetWebhookResponse](../../models/operations/GetWebhookResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 404, 422                    | application/hal+json        |
| models/errors/APIException  | 4XX, 5XX                    | \*/\*                       |

## delete

Delete a single webhook object by its webhook ID.

### Example Usage

<!-- UsageSnippet language="java" operationID="delete-webhook" method="delete" path="/webhooks/{webhookId}" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.DeleteWebhookRequestBody;
import com.mollie.mollie.models.operations.DeleteWebhookResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        DeleteWebhookResponse res = sdk.webhooks().delete()
                .webhookId("hook_1234567890")
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .requestBody(DeleteWebhookRequestBody.builder()
                    .testmode(false)
                    .build())
                .call();

        // handle response
    }
}
```

### Parameters

| Parameter                                                                                  | Type                                                                                       | Required                                                                                   | Description                                                                                | Example                                                                                    |
| ------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------ |
| `webhookId`                                                                                | *String*                                                                                   | :heavy_check_mark:                                                                         | Provide the ID of the related webhook.                                                     | hook_1234567890                                                                            |
| `idempotencyKey`                                                                           | *Optional\<String>*                                                                        | :heavy_minus_sign:                                                                         | A unique key to ensure idempotent requests. This key should be a UUID v4 string.           | 123e4567-e89b-12d3-a456-426                                                                |
| `requestBody`                                                                              | [Optional\<DeleteWebhookRequestBody>](../../models/operations/DeleteWebhookRequestBody.md) | :heavy_minus_sign:                                                                         | N/A                                                                                        |                                                                                            |

### Response

**[DeleteWebhookResponse](../../models/operations/DeleteWebhookResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 404, 422                    | application/hal+json        |
| models/errors/APIException  | 4XX, 5XX                    | \*/\*                       |

## test

Sends a test event to the webhook to verify the endpoint is working as expected.

### Example Usage

<!-- UsageSnippet language="java" operationID="test-webhook" method="post" path="/webhooks/{webhookId}/ping" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.TestWebhookRequestBody;
import com.mollie.mollie.models.operations.TestWebhookResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        TestWebhookResponse res = sdk.webhooks().test()
                .webhookId("hook_1234567890")
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .requestBody(TestWebhookRequestBody.builder()
                    .testmode(false)
                    .build())
                .call();

        // handle response
    }
}
```

### Parameters

| Parameter                                                                              | Type                                                                                   | Required                                                                               | Description                                                                            | Example                                                                                |
| -------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------- |
| `webhookId`                                                                            | *String*                                                                               | :heavy_check_mark:                                                                     | Provide the ID of the related webhook.                                                 | hook_1234567890                                                                        |
| `idempotencyKey`                                                                       | *Optional\<String>*                                                                    | :heavy_minus_sign:                                                                     | A unique key to ensure idempotent requests. This key should be a UUID v4 string.       | 123e4567-e89b-12d3-a456-426                                                            |
| `requestBody`                                                                          | [Optional\<TestWebhookRequestBody>](../../models/operations/TestWebhookRequestBody.md) | :heavy_minus_sign:                                                                     | N/A                                                                                    |                                                                                        |

### Response

**[TestWebhookResponse](../../models/operations/TestWebhookResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 404, 422                    | application/hal+json        |
| models/errors/APIException  | 4XX, 5XX                    | \*/\*                       |