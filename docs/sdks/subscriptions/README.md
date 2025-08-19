# Subscriptions
(*subscriptions()*)

## Overview

### Available Operations

* [create](#create) - Create subscription
* [list](#list) - List customer subscriptions
* [get](#get) - Get subscription
* [update](#update) - Update subscription
* [cancel](#cancel) - Cancel subscription
* [all](#all) - List all subscriptions
* [listPayments](#listpayments) - List subscription payments

## create

With subscriptions, you can schedule recurring payments to take place at regular intervals.

For example, by simply specifying an `amount` and an `interval`, you can create an endless subscription to charge a
monthly fee, until you cancel the subscription.

Or, you could use the times parameter to only charge a limited number of times, for example to split a big
transaction in multiple parts.

A few example usages:

`amount[currency]="EUR"` `amount[value]="5.00"` `interval="2 weeks"`
Your customer will be charged €5 once every two weeks.

`amount[currency]="EUR"` `amount[value]="20.00"` `interval="1 day" times=5`
Your customer will be charged €20 every day, for five consecutive days.

`amount[currency]="EUR"` `amount[value]="10.00"` `interval="1 month"`
`startDate="2018-04-30"`
Your customer will be charged €10 on the last day of each month, starting in April 2018.

### Example Usage

<!-- UsageSnippet language="java" operationID="create-subscription" method="post" path="/customers/{customerId}/subscriptions" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.CreateSubscriptionResponseBody;
import com.mollie.mollie.models.operations.*;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws CreateSubscriptionResponseBody, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        CreateSubscriptionResponse res = sdk.subscriptions().create()
                .customerId("cst_5B8cwPMGnU")
                .requestBody(CreateSubscriptionRequestBody.builder()
                    .amount(CreateSubscriptionAmount.builder()
                        .currency("EUR")
                        .value("10.00")
                        .build())
                    .interval("2 days")
                    .description("Subscription of streaming channel")
                    .times(6L)
                    .startDate("2025-01-01")
                    .method(CreateSubscriptionMethod.PAYPAL)
                    .applicationFee(CreateSubscriptionApplicationFee.builder()
                        .amount(CreateSubscriptionSubscriptionsAmount.builder()
                            .currency("EUR")
                            .value("10.00")
                            .build())
                        .description("Platform fee")
                        .build())
                    .webhookUrl("https://example.com/webhook")
                    .mandateId("mdt_5B8cwPMGnU")
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

| Parameter                                                                                            | Type                                                                                                 | Required                                                                                             | Description                                                                                          | Example                                                                                              |
| ---------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------- |
| `customerId`                                                                                         | *String*                                                                                             | :heavy_check_mark:                                                                                   | Provide the ID of the related customer.                                                              | cst_5B8cwPMGnU                                                                                       |
| `requestBody`                                                                                        | [Optional\<CreateSubscriptionRequestBody>](../../models/operations/CreateSubscriptionRequestBody.md) | :heavy_minus_sign:                                                                                   | N/A                                                                                                  |                                                                                                      |

### Response

**[CreateSubscriptionResponse](../../models/operations/CreateSubscriptionResponse.md)**

### Errors

| Error Type                                   | Status Code                                  | Content Type                                 |
| -------------------------------------------- | -------------------------------------------- | -------------------------------------------- |
| models/errors/CreateSubscriptionResponseBody | 404                                          | application/hal+json                         |
| models/errors/APIException                   | 4XX, 5XX                                     | \*/\*                                        |

## list

Retrieve all subscriptions of a customer.

The results are paginated.

### Example Usage

<!-- UsageSnippet language="java" operationID="list-subscriptions" method="get" path="/customers/{customerId}/subscriptions" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.ListSubscriptionsResponseBody;
import com.mollie.mollie.models.errors.ListSubscriptionsSubscriptionsResponseBody;
import com.mollie.mollie.models.operations.*;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ListSubscriptionsResponseBody, ListSubscriptionsSubscriptionsResponseBody, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        ListSubscriptionsRequest req = ListSubscriptionsRequest.builder()
                .customerId("cst_5B8cwPMGnU")
                .from("sub_5B8cwPMGnU")
                .limit(50L)
                .sort(ListSubscriptionsQueryParamSort.DESC)
                .testmode(false)
                .build();

        ListSubscriptionsResponse res = sdk.subscriptions().list()
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
| `request`                                                                       | [ListSubscriptionsRequest](../../models/operations/ListSubscriptionsRequest.md) | :heavy_check_mark:                                                              | The request object to use for the request.                                      |

### Response

**[ListSubscriptionsResponse](../../models/operations/ListSubscriptionsResponse.md)**

### Errors

| Error Type                                               | Status Code                                              | Content Type                                             |
| -------------------------------------------------------- | -------------------------------------------------------- | -------------------------------------------------------- |
| models/errors/ListSubscriptionsResponseBody              | 400                                                      | application/hal+json                                     |
| models/errors/ListSubscriptionsSubscriptionsResponseBody | 404                                                      | application/hal+json                                     |
| models/errors/APIException                               | 4XX, 5XX                                                 | \*/\*                                                    |

## get

Retrieve a single subscription by its ID and the ID of its parent customer.

### Example Usage

<!-- UsageSnippet language="java" operationID="get-subscription" method="get" path="/customers/{customerId}/subscriptions/{subscriptionId}" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.GetSubscriptionResponseBody;
import com.mollie.mollie.models.operations.GetSubscriptionResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws GetSubscriptionResponseBody, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        GetSubscriptionResponse res = sdk.subscriptions().get()
                .customerId("cst_5B8cwPMGnU")
                .subscriptionId("sub_5B8cwPMGnU")
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
| `customerId`                                                                                                                                                                                                                                                                                                                                                                           | *String*                                                                                                                                                                                                                                                                                                                                                                               | :heavy_check_mark:                                                                                                                                                                                                                                                                                                                                                                     | Provide the ID of the related customer.                                                                                                                                                                                                                                                                                                                                                | cst_5B8cwPMGnU                                                                                                                                                                                                                                                                                                                                                                         |
| `subscriptionId`                                                                                                                                                                                                                                                                                                                                                                       | *String*                                                                                                                                                                                                                                                                                                                                                                               | :heavy_check_mark:                                                                                                                                                                                                                                                                                                                                                                     | Provide the ID of the related subscription.                                                                                                                                                                                                                                                                                                                                            | sub_5B8cwPMGnU                                                                                                                                                                                                                                                                                                                                                                         |
| `testmode`                                                                                                                                                                                                                                                                                                                                                                             | *JsonNullable\<Boolean>*                                                                                                                                                                                                                                                                                                                                                               | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                     | Most API credentials are specifically created for either live mode or test mode. In those cases the `testmode` query<br/>parameter can be omitted. For organization-level credentials such as OAuth access tokens, you can enable test mode by<br/>setting the `testmode` query parameter to `true`.<br/><br/>Test entities cannot be retrieved when the endpoint is set to live mode, and vice versa. | false                                                                                                                                                                                                                                                                                                                                                                                  |

### Response

**[GetSubscriptionResponse](../../models/operations/GetSubscriptionResponse.md)**

### Errors

| Error Type                                | Status Code                               | Content Type                              |
| ----------------------------------------- | ----------------------------------------- | ----------------------------------------- |
| models/errors/GetSubscriptionResponseBody | 404                                       | application/hal+json                      |
| models/errors/APIException                | 4XX, 5XX                                  | \*/\*                                     |

## update

Update an existing subscription.

Canceled subscriptions cannot be updated.

For an in-depth explanation of each parameter, refer to the [Create subscription](create-subscription) endpoint.

### Example Usage

<!-- UsageSnippet language="java" operationID="update-subscription" method="patch" path="/customers/{customerId}/subscriptions/{subscriptionId}" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.UpdateSubscriptionResponseBody;
import com.mollie.mollie.models.operations.*;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws UpdateSubscriptionResponseBody, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        UpdateSubscriptionResponse res = sdk.subscriptions().update()
                .customerId("cst_5B8cwPMGnU")
                .subscriptionId("sub_5B8cwPMGnU")
                .requestBody(UpdateSubscriptionRequestBody.builder()
                    .amount(UpdateSubscriptionAmount.builder()
                        .currency("EUR")
                        .value("10.00")
                        .build())
                    .description("Subscription of streaming channel")
                    .interval("1 months")
                    .startDate("2025-01-01")
                    .times(6L)
                    .webhookUrl("https://example.com/webhook")
                    .mandateId("mdt_5B8cwPMGnU")
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

| Parameter                                                                                            | Type                                                                                                 | Required                                                                                             | Description                                                                                          | Example                                                                                              |
| ---------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------- |
| `customerId`                                                                                         | *String*                                                                                             | :heavy_check_mark:                                                                                   | Provide the ID of the related customer.                                                              | cst_5B8cwPMGnU                                                                                       |
| `subscriptionId`                                                                                     | *String*                                                                                             | :heavy_check_mark:                                                                                   | Provide the ID of the related subscription.                                                          | sub_5B8cwPMGnU                                                                                       |
| `requestBody`                                                                                        | [Optional\<UpdateSubscriptionRequestBody>](../../models/operations/UpdateSubscriptionRequestBody.md) | :heavy_minus_sign:                                                                                   | N/A                                                                                                  |                                                                                                      |

### Response

**[UpdateSubscriptionResponse](../../models/operations/UpdateSubscriptionResponse.md)**

### Errors

| Error Type                                   | Status Code                                  | Content Type                                 |
| -------------------------------------------- | -------------------------------------------- | -------------------------------------------- |
| models/errors/UpdateSubscriptionResponseBody | 404                                          | application/hal+json                         |
| models/errors/APIException                   | 4XX, 5XX                                     | \*/\*                                        |

## cancel

Cancel an existing subscription. Canceling a subscription has no effect on the mandates of the customer.

### Example Usage

<!-- UsageSnippet language="java" operationID="cancel-subscription" method="delete" path="/customers/{customerId}/subscriptions/{subscriptionId}" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.CancelSubscriptionResponseBody;
import com.mollie.mollie.models.operations.CancelSubscriptionRequestBody;
import com.mollie.mollie.models.operations.CancelSubscriptionResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws CancelSubscriptionResponseBody, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        CancelSubscriptionResponse res = sdk.subscriptions().cancel()
                .customerId("cst_5B8cwPMGnU")
                .subscriptionId("sub_5B8cwPMGnU")
                .requestBody(CancelSubscriptionRequestBody.builder()
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

| Parameter                                                                                            | Type                                                                                                 | Required                                                                                             | Description                                                                                          | Example                                                                                              |
| ---------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------- |
| `customerId`                                                                                         | *String*                                                                                             | :heavy_check_mark:                                                                                   | Provide the ID of the related customer.                                                              | cst_5B8cwPMGnU                                                                                       |
| `subscriptionId`                                                                                     | *String*                                                                                             | :heavy_check_mark:                                                                                   | Provide the ID of the related subscription.                                                          | sub_5B8cwPMGnU                                                                                       |
| `requestBody`                                                                                        | [Optional\<CancelSubscriptionRequestBody>](../../models/operations/CancelSubscriptionRequestBody.md) | :heavy_minus_sign:                                                                                   | N/A                                                                                                  |                                                                                                      |

### Response

**[CancelSubscriptionResponse](../../models/operations/CancelSubscriptionResponse.md)**

### Errors

| Error Type                                   | Status Code                                  | Content Type                                 |
| -------------------------------------------- | -------------------------------------------- | -------------------------------------------- |
| models/errors/CancelSubscriptionResponseBody | 404                                          | application/hal+json                         |
| models/errors/APIException                   | 4XX, 5XX                                     | \*/\*                                        |

## all

Retrieve all subscriptions initiated across all your customers.

The results are paginated.

### Example Usage

<!-- UsageSnippet language="java" operationID="list-all-subscriptions" method="get" path="/subscriptions" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.ListAllSubscriptionsResponseBody;
import com.mollie.mollie.models.errors.ListAllSubscriptionsSubscriptionsResponseBody;
import com.mollie.mollie.models.operations.ListAllSubscriptionsResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ListAllSubscriptionsResponseBody, ListAllSubscriptionsSubscriptionsResponseBody, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        ListAllSubscriptionsResponse res = sdk.subscriptions().all()
                .from("tr_5B8cwPMGnU")
                .limit(50L)
                .profileId("pfl_5B8cwPMGnU")
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
| `from`                                                                                                                                                                                                                                                                                                                                                                                 | *Optional\<String>*                                                                                                                                                                                                                                                                                                                                                                    | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                     | Provide an ID to start the result set from the item with the given ID and onwards. This allows you to paginate the<br/>result set.                                                                                                                                                                                                                                                     | sub_rVKGtNd6s3                                                                                                                                                                                                                                                                                                                                                                         |
| `limit`                                                                                                                                                                                                                                                                                                                                                                                | *JsonNullable\<Long>*                                                                                                                                                                                                                                                                                                                                                                  | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                     | The maximum number of items to return. Defaults to 50 items.                                                                                                                                                                                                                                                                                                                           | 50                                                                                                                                                                                                                                                                                                                                                                                     |
| `profileId`                                                                                                                                                                                                                                                                                                                                                                            | *JsonNullable\<String>*                                                                                                                                                                                                                                                                                                                                                                | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                     | The identifier referring to the [profile](get-profile) you wish to retrieve subscriptions for.<br/><br/>Most API credentials are linked to a single profile. In these cases the `profileId` is already implied.<br/><br/>To retrieve all subscriptions across the organization, use an organization-level API credential and omit the<br/>`profileId` parameter.                       | pfl_QkEhN94Ba                                                                                                                                                                                                                                                                                                                                                                          |
| `testmode`                                                                                                                                                                                                                                                                                                                                                                             | *JsonNullable\<Boolean>*                                                                                                                                                                                                                                                                                                                                                               | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                     | Most API credentials are specifically created for either live mode or test mode. In those cases the `testmode` query<br/>parameter can be omitted. For organization-level credentials such as OAuth access tokens, you can enable test mode by<br/>setting the `testmode` query parameter to `true`.<br/><br/>Test entities cannot be retrieved when the endpoint is set to live mode, and vice versa. | false                                                                                                                                                                                                                                                                                                                                                                                  |

### Response

**[ListAllSubscriptionsResponse](../../models/operations/ListAllSubscriptionsResponse.md)**

### Errors

| Error Type                                                  | Status Code                                                 | Content Type                                                |
| ----------------------------------------------------------- | ----------------------------------------------------------- | ----------------------------------------------------------- |
| models/errors/ListAllSubscriptionsResponseBody              | 400                                                         | application/hal+json                                        |
| models/errors/ListAllSubscriptionsSubscriptionsResponseBody | 404                                                         | application/hal+json                                        |
| models/errors/APIException                                  | 4XX, 5XX                                                    | \*/\*                                                       |

## listPayments

Retrieve all payments of a specific subscription.

The results are paginated.

### Example Usage

<!-- UsageSnippet language="java" operationID="list-subscription-payments" method="get" path="/customers/{customerId}/subscriptions/{subscriptionId}/payments" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.ListSubscriptionPaymentsResponseBody;
import com.mollie.mollie.models.operations.*;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ListSubscriptionPaymentsResponseBody, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        ListSubscriptionPaymentsRequest req = ListSubscriptionPaymentsRequest.builder()
                .customerId("cst_5B8cwPMGnU")
                .subscriptionId("sub_5B8cwPMGnU")
                .from("tr_5B8cwPMGnU")
                .limit(50L)
                .sort(ListSubscriptionPaymentsQueryParamSort.DESC)
                .profileId("pfl_5B8cwPMGnU")
                .testmode(false)
                .build();

        ListSubscriptionPaymentsResponse res = sdk.subscriptions().listPayments()
                .request(req)
                .call();

        if (res.object().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                     | Type                                                                                          | Required                                                                                      | Description                                                                                   |
| --------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------- |
| `request`                                                                                     | [ListSubscriptionPaymentsRequest](../../models/operations/ListSubscriptionPaymentsRequest.md) | :heavy_check_mark:                                                                            | The request object to use for the request.                                                    |

### Response

**[ListSubscriptionPaymentsResponse](../../models/operations/ListSubscriptionPaymentsResponse.md)**

### Errors

| Error Type                                         | Status Code                                        | Content Type                                       |
| -------------------------------------------------- | -------------------------------------------------- | -------------------------------------------------- |
| models/errors/ListSubscriptionPaymentsResponseBody | 400                                                | application/hal+json                               |
| models/errors/APIException                         | 4XX, 5XX                                           | \*/\*                                              |