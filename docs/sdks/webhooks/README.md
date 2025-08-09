# Webhooks
(*webhooks()*)

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
import com.mollie.mollie.models.errors.CreateWebhookResponseBody;
import com.mollie.mollie.models.operations.*;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws CreateWebhookResponseBody, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        CreateWebhookRequestBody req = CreateWebhookRequestBody.builder()
                .name("Webhook #1")
                .url("https://mollie.com/")
                .eventTypes(EventTypes.PAYMENT_LINK_PAID)
                .testmode(false)
                .build();

        CreateWebhookResponse res = sdk.webhooks().create()
                .request(req)
                .call();

        if (res.object().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                       | Type                                                                            | Required                                                                        | Description                                                                     |
| ------------------------------------------------------------------------------- | ------------------------------------------------------------------------------- | ------------------------------------------------------------------------------- | ------------------------------------------------------------------------------- |
| `request`                                                                       | [CreateWebhookRequestBody](../../models/operations/CreateWebhookRequestBody.md) | :heavy_check_mark:                                                              | The request object to use for the request.                                      |

### Response

**[CreateWebhookResponse](../../models/operations/CreateWebhookResponse.md)**

### Errors

| Error Type                              | Status Code                             | Content Type                            |
| --------------------------------------- | --------------------------------------- | --------------------------------------- |
| models/errors/CreateWebhookResponseBody | 422                                     | application/hal+json                    |
| models/errors/APIException              | 4XX, 5XX                                | \*/\*                                   |

## list

Returns a paginated list of your webhooks. If no webhook endpoints are available, the resulting array will be empty. This request should never throw an error.

### Example Usage

<!-- UsageSnippet language="java" operationID="list-webhooks" method="get" path="/webhooks" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.ListWebhooksResponseBody;
import com.mollie.mollie.models.operations.*;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ListWebhooksResponseBody, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        ListWebhooksRequest req = ListWebhooksRequest.builder()
                .from("hook_B2EyhTH5N4KWUnoYPcgiH")
                .limit(50L)
                .sort(ListWebhooksQueryParamSort.DESC)
                .eventTypes(QueryParamEventTypes.PAYMENT_LINK_PAID)
                .testmode(false)
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

| Error Type                             | Status Code                            | Content Type                           |
| -------------------------------------- | -------------------------------------- | -------------------------------------- |
| models/errors/ListWebhooksResponseBody | 400                                    | application/hal+json                   |
| models/errors/APIException             | 4XX, 5XX                               | \*/\*                                  |

## update

Updates the webhook. You may edit the name, url and the list of subscribed event types.

### Example Usage

<!-- UsageSnippet language="java" operationID="update-webhook" method="patch" path="/webhooks/{id}" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.UpdateWebhookResponseBody;
import com.mollie.mollie.models.errors.UpdateWebhookWebhooksResponseBody;
import com.mollie.mollie.models.operations.*;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws UpdateWebhookResponseBody, UpdateWebhookWebhooksResponseBody, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        UpdateWebhookResponse res = sdk.webhooks().update()
                .id("hook_B2EyhTH5N4KWUnoYPcgiH")
                .requestBody(UpdateWebhookRequestBody.builder()
                    .name("Webhook #1")
                    .url("https://mollie.com/")
                    .eventTypes(UpdateWebhookEventTypes.PAYMENT_LINK_PAID)
                    .testmode(false)
                    .build())
                .call();

        if (res.object().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                  | Type                                                                                       | Required                                                                                   | Description                                                                                | Example                                                                                    |
| ------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------ |
| `id`                                                                                       | *String*                                                                                   | :heavy_check_mark:                                                                         | Provide the ID of the item you want to perform this operation on.                          | hook_B2EyhTH5N4KWUnoYPcgiH                                                                 |
| `requestBody`                                                                              | [Optional\<UpdateWebhookRequestBody>](../../models/operations/UpdateWebhookRequestBody.md) | :heavy_minus_sign:                                                                         | N/A                                                                                        |                                                                                            |

### Response

**[UpdateWebhookResponse](../../models/operations/UpdateWebhookResponse.md)**

### Errors

| Error Type                                      | Status Code                                     | Content Type                                    |
| ----------------------------------------------- | ----------------------------------------------- | ----------------------------------------------- |
| models/errors/UpdateWebhookResponseBody         | 404                                             | application/hal+json                            |
| models/errors/UpdateWebhookWebhooksResponseBody | 422                                             | application/hal+json                            |
| models/errors/APIException                      | 4XX, 5XX                                        | \*/\*                                           |

## get

Retrieve a single webhook object by its ID.

### Example Usage

<!-- UsageSnippet language="java" operationID="get-webhook" method="get" path="/webhooks/{id}" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.GetWebhookResponseBody;
import com.mollie.mollie.models.errors.GetWebhookWebhooksResponseBody;
import com.mollie.mollie.models.operations.GetWebhookResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws GetWebhookResponseBody, GetWebhookWebhooksResponseBody, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        GetWebhookResponse res = sdk.webhooks().get()
                .id("hook_B2EyhTH5N4KWUnoYPcgiH")
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
| `id`                                                                                                                                                                                                                                                                                                                                                                                   | *String*                                                                                                                                                                                                                                                                                                                                                                               | :heavy_check_mark:                                                                                                                                                                                                                                                                                                                                                                     | Provide the ID of the item you want to perform this operation on.                                                                                                                                                                                                                                                                                                                      | hook_B2EyhTH5N4KWUnoYPcgiH                                                                                                                                                                                                                                                                                                                                                             |
| `testmode`                                                                                                                                                                                                                                                                                                                                                                             | *JsonNullable\<Boolean>*                                                                                                                                                                                                                                                                                                                                                               | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                     | Most API credentials are specifically created for either live mode or test mode. In those cases the `testmode` query<br/>parameter can be omitted. For organization-level credentials such as OAuth access tokens, you can enable test mode by<br/>setting the `testmode` query parameter to `true`.<br/><br/>Test entities cannot be retrieved when the endpoint is set to live mode, and vice versa. | false                                                                                                                                                                                                                                                                                                                                                                                  |

### Response

**[GetWebhookResponse](../../models/operations/GetWebhookResponse.md)**

### Errors

| Error Type                                   | Status Code                                  | Content Type                                 |
| -------------------------------------------- | -------------------------------------------- | -------------------------------------------- |
| models/errors/GetWebhookResponseBody         | 404                                          | application/hal+json                         |
| models/errors/GetWebhookWebhooksResponseBody | 422                                          | application/hal+json                         |
| models/errors/APIException                   | 4XX, 5XX                                     | \*/\*                                        |

## delete

Delete a single webhook object by its webhook ID.

### Example Usage

<!-- UsageSnippet language="java" operationID="delete-webhook" method="delete" path="/webhooks/{id}" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.DeleteWebhookResponseBody;
import com.mollie.mollie.models.errors.DeleteWebhookWebhooksResponseBody;
import com.mollie.mollie.models.operations.DeleteWebhookRequestBody;
import com.mollie.mollie.models.operations.DeleteWebhookResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws DeleteWebhookResponseBody, DeleteWebhookWebhooksResponseBody, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        DeleteWebhookResponse res = sdk.webhooks().delete()
                .id("hook_B2EyhTH5N4KWUnoYPcgiH")
                .requestBody(DeleteWebhookRequestBody.builder()
                    .testmode(false)
                    .build())
                .call();

        if (res.any().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                  | Type                                                                                       | Required                                                                                   | Description                                                                                | Example                                                                                    |
| ------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------ |
| `id`                                                                                       | *String*                                                                                   | :heavy_check_mark:                                                                         | Provide the ID of the item you want to perform this operation on.                          | hook_B2EyhTH5N4KWUnoYPcgiH                                                                 |
| `requestBody`                                                                              | [Optional\<DeleteWebhookRequestBody>](../../models/operations/DeleteWebhookRequestBody.md) | :heavy_minus_sign:                                                                         | N/A                                                                                        |                                                                                            |

### Response

**[DeleteWebhookResponse](../../models/operations/DeleteWebhookResponse.md)**

### Errors

| Error Type                                      | Status Code                                     | Content Type                                    |
| ----------------------------------------------- | ----------------------------------------------- | ----------------------------------------------- |
| models/errors/DeleteWebhookResponseBody         | 404                                             | application/hal+json                            |
| models/errors/DeleteWebhookWebhooksResponseBody | 422                                             | application/hal+json                            |
| models/errors/APIException                      | 4XX, 5XX                                        | \*/\*                                           |

## test

Sends a test event to the webhook to verify the endpoint is working as expected.

### Example Usage

<!-- UsageSnippet language="java" operationID="test-webhook" method="post" path="/webhooks/{id}/ping" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.TestWebhookResponseBody;
import com.mollie.mollie.models.errors.TestWebhookWebhooksResponseBody;
import com.mollie.mollie.models.operations.TestWebhookRequestBody;
import com.mollie.mollie.models.operations.TestWebhookResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws TestWebhookResponseBody, TestWebhookWebhooksResponseBody, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        TestWebhookResponse res = sdk.webhooks().test()
                .id("hook_B2EyhTH5N4KWUnoYPcgiH")
                .requestBody(TestWebhookRequestBody.builder()
                    .testmode(false)
                    .build())
                .call();

        if (res.any().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                              | Type                                                                                   | Required                                                                               | Description                                                                            | Example                                                                                |
| -------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------- |
| `id`                                                                                   | *String*                                                                               | :heavy_check_mark:                                                                     | Provide the ID of the item you want to perform this operation on.                      | hook_B2EyhTH5N4KWUnoYPcgiH                                                             |
| `requestBody`                                                                          | [Optional\<TestWebhookRequestBody>](../../models/operations/TestWebhookRequestBody.md) | :heavy_minus_sign:                                                                     | N/A                                                                                    |                                                                                        |

### Response

**[TestWebhookResponse](../../models/operations/TestWebhookResponse.md)**

### Errors

| Error Type                                    | Status Code                                   | Content Type                                  |
| --------------------------------------------- | --------------------------------------------- | --------------------------------------------- |
| models/errors/TestWebhookResponseBody         | 404                                           | application/hal+json                          |
| models/errors/TestWebhookWebhooksResponseBody | 422                                           | application/hal+json                          |
| models/errors/APIException                    | 4XX, 5XX                                      | \*/\*                                         |