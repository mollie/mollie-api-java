# Subscriptions

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

<!-- UsageSnippet language="java" operationID="create-subscription" method="post" path="/v2/customers/{customerId}/subscriptions" example="get-subscription-200-1" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.*;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.CreateSubscriptionRequest;
import com.mollie.mollie.models.operations.CreateSubscriptionResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        CreateSubscriptionRequest req = CreateSubscriptionRequest.builder()
                .customerId("cst_5B8cwPMGnU")
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .xClientSignature("MEUCIQDx8sJvK3z...")
                .xClientSignedAt("2025-01-01T12:00:00Z")
                .subscriptionRequest(SubscriptionRequest.builder()
                    .amount(Amount.builder()
                        .currency("EUR")
                        .value("10.00")
                        .build())
                    .times(6L)
                    .interval("2 days")
                    .startDate("2025-01-01")
                    .description("Subscription of streaming channel")
                    .method(SubscriptionMethod.PAYPAL)
                    .applicationFee(SubscriptionRequestApplicationFee.builder()
                        .amount(Amount.builder()
                            .currency("EUR")
                            .value("10.00")
                            .build())
                        .description("Platform fee")
                        .build())
                    .webhookUrl("https://example.com/webhook")
                    .mandateId("mdt_5B8cwPMGnU")
                    .profileId("pfl_5B8cwPMGnU")
                    .testmode(false)
                    .build())
                .build();

        CreateSubscriptionResponse res = sdk.subscriptions().create()
                .request(req)
                .call();

        if (res.subscriptionResponse().isPresent()) {
            System.out.println(res.subscriptionResponse().get());
        }
    }
}
```

### Parameters

| Parameter                                                                         | Type                                                                              | Required                                                                          | Description                                                                       |
| --------------------------------------------------------------------------------- | --------------------------------------------------------------------------------- | --------------------------------------------------------------------------------- | --------------------------------------------------------------------------------- |
| `request`                                                                         | [CreateSubscriptionRequest](../../models/operations/CreateSubscriptionRequest.md) | :heavy_check_mark:                                                                | The request object to use for the request.                                        |

### Response

**[CreateSubscriptionResponse](../../models/operations/CreateSubscriptionResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 404, 429                    | application/hal+json        |
| models/errors/APIException  | 4XX, 5XX                    | \*/\*                       |

## list

Retrieve all subscriptions of a customer.

The results are paginated.

### Example Usage

<!-- UsageSnippet language="java" operationID="list-subscriptions" method="get" path="/v2/customers/{customerId}/subscriptions" example="list-subscriptions-200-1" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.components.Sorting;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.ListSubscriptionsRequest;
import com.mollie.mollie.models.operations.ListSubscriptionsResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .testmode(false)
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        ListSubscriptionsRequest req = ListSubscriptionsRequest.builder()
                .customerId("cst_5B8cwPMGnU")
                .from("sub_5B8cwPMGnU")
                .limit(50L)
                .sort(Sorting.DESC)
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .xClientSignature("MEUCIQDx8sJvK3z...")
                .xClientSignedAt("2025-01-01T12:00:00Z")
                .build();


        sdk.subscriptions().list()
                .callAsStream()
                .forEach((ListSubscriptionsResponse item) -> {
                   // handle page
                });

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

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 400, 404, 429               | application/hal+json        |
| models/errors/APIException  | 4XX, 5XX                    | \*/\*                       |

## get

Retrieve a single subscription by its ID and the ID of its parent customer.

### Example Usage

<!-- UsageSnippet language="java" operationID="get-subscription" method="get" path="/v2/customers/{customerId}/subscriptions/{subscriptionId}" example="get-subscription-200-1" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.GetSubscriptionRequest;
import com.mollie.mollie.models.operations.GetSubscriptionResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .testmode(false)
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        GetSubscriptionRequest req = GetSubscriptionRequest.builder()
                .customerId("cst_5B8cwPMGnU")
                .subscriptionId("sub_5B8cwPMGnU")
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .xClientSignature("MEUCIQDx8sJvK3z...")
                .xClientSignedAt("2025-01-01T12:00:00Z")
                .build();

        GetSubscriptionResponse res = sdk.subscriptions().get()
                .request(req)
                .call();

        if (res.subscriptionResponse().isPresent()) {
            System.out.println(res.subscriptionResponse().get());
        }
    }
}
```

### Parameters

| Parameter                                                                   | Type                                                                        | Required                                                                    | Description                                                                 |
| --------------------------------------------------------------------------- | --------------------------------------------------------------------------- | --------------------------------------------------------------------------- | --------------------------------------------------------------------------- |
| `request`                                                                   | [GetSubscriptionRequest](../../models/operations/GetSubscriptionRequest.md) | :heavy_check_mark:                                                          | The request object to use for the request.                                  |

### Response

**[GetSubscriptionResponse](../../models/operations/GetSubscriptionResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 404, 429                    | application/hal+json        |
| models/errors/APIException  | 4XX, 5XX                    | \*/\*                       |

## update

Update an existing subscription.

Canceled subscriptions cannot be updated.

For an in-depth explanation of each parameter, refer to the [Create subscription](create-subscription) endpoint.

### Example Usage: update-subscription-200-1

<!-- UsageSnippet language="java" operationID="update-subscription" method="patch" path="/v2/customers/{customerId}/subscriptions/{subscriptionId}" example="update-subscription-200-1" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Amount;
import com.mollie.mollie.models.components.Security;
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

        UpdateSubscriptionRequest req = UpdateSubscriptionRequest.builder()
                .customerId("cst_5B8cwPMGnU")
                .subscriptionId("sub_5B8cwPMGnU")
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .xClientSignature("MEUCIQDx8sJvK3z...")
                .xClientSignedAt("2025-01-01T12:00:00Z")
                .requestBody(UpdateSubscriptionRequestBody.builder()
                    .amount(Amount.builder()
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
                .build();

        UpdateSubscriptionResponse res = sdk.subscriptions().update()
                .request(req)
                .call();

        if (res.subscriptionResponse().isPresent()) {
            System.out.println(res.subscriptionResponse().get());
        }
    }
}
```
### Example Usage: update-subscription-200-2

<!-- UsageSnippet language="java" operationID="update-subscription" method="patch" path="/v2/customers/{customerId}/subscriptions/{subscriptionId}" example="update-subscription-200-2" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Amount;
import com.mollie.mollie.models.components.Security;
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

        UpdateSubscriptionRequest req = UpdateSubscriptionRequest.builder()
                .customerId("cst_5B8cwPMGnU")
                .subscriptionId("sub_5B8cwPMGnU")
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .xClientSignature("MEUCIQDx8sJvK3z...")
                .xClientSignedAt("2025-01-01T12:00:00Z")
                .requestBody(UpdateSubscriptionRequestBody.builder()
                    .amount(Amount.builder()
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
                .build();

        UpdateSubscriptionResponse res = sdk.subscriptions().update()
                .request(req)
                .call();

        if (res.subscriptionResponse().isPresent()) {
            System.out.println(res.subscriptionResponse().get());
        }
    }
}
```

### Parameters

| Parameter                                                                         | Type                                                                              | Required                                                                          | Description                                                                       |
| --------------------------------------------------------------------------------- | --------------------------------------------------------------------------------- | --------------------------------------------------------------------------------- | --------------------------------------------------------------------------------- |
| `request`                                                                         | [UpdateSubscriptionRequest](../../models/operations/UpdateSubscriptionRequest.md) | :heavy_check_mark:                                                                | The request object to use for the request.                                        |

### Response

**[UpdateSubscriptionResponse](../../models/operations/UpdateSubscriptionResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 404, 429                    | application/hal+json        |
| models/errors/APIException  | 4XX, 5XX                    | \*/\*                       |

## cancel

Cancel an existing subscription. Canceling a subscription has no effect on the mandates of the customer.

### Example Usage

<!-- UsageSnippet language="java" operationID="cancel-subscription" method="delete" path="/v2/customers/{customerId}/subscriptions/{subscriptionId}" example="cancel-subscription-200-1" -->
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
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        CancelSubscriptionRequest req = CancelSubscriptionRequest.builder()
                .customerId("cst_5B8cwPMGnU")
                .subscriptionId("sub_5B8cwPMGnU")
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .xClientSignature("MEUCIQDx8sJvK3z...")
                .xClientSignedAt("2025-01-01T12:00:00Z")
                .requestBody(CancelSubscriptionRequestBody.builder()
                    .testmode(false)
                    .build())
                .build();

        CancelSubscriptionResponse res = sdk.subscriptions().cancel()
                .request(req)
                .call();

        if (res.subscriptionResponse().isPresent()) {
            System.out.println(res.subscriptionResponse().get());
        }
    }
}
```

### Parameters

| Parameter                                                                         | Type                                                                              | Required                                                                          | Description                                                                       |
| --------------------------------------------------------------------------------- | --------------------------------------------------------------------------------- | --------------------------------------------------------------------------------- | --------------------------------------------------------------------------------- |
| `request`                                                                         | [CancelSubscriptionRequest](../../models/operations/CancelSubscriptionRequest.md) | :heavy_check_mark:                                                                | The request object to use for the request.                                        |

### Response

**[CancelSubscriptionResponse](../../models/operations/CancelSubscriptionResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 404, 429                    | application/hal+json        |
| models/errors/APIException  | 4XX, 5XX                    | \*/\*                       |

## all

Retrieve all subscriptions initiated across all your customers.

The results are paginated.

### Example Usage: list-payments-200-1

<!-- UsageSnippet language="java" operationID="list-all-subscriptions" method="get" path="/v2/subscriptions" example="list-payments-200-1" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.ListAllSubscriptionsRequest;
import com.mollie.mollie.models.operations.ListAllSubscriptionsResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .profileId("pfl_5B8cwPMGnU")
                .testmode(false)
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        ListAllSubscriptionsRequest req = ListAllSubscriptionsRequest.builder()
                .from("tr_5B8cwPMGnU")
                .limit(50L)
                .build();


        sdk.subscriptions().all()
                .callAsStream()
                .forEach((ListAllSubscriptionsResponse item) -> {
                   // handle page
                });

    }
}
```
### Example Usage: list-payments-200-2

<!-- UsageSnippet language="java" operationID="list-all-subscriptions" method="get" path="/v2/subscriptions" example="list-payments-200-2" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.ListAllSubscriptionsRequest;
import com.mollie.mollie.models.operations.ListAllSubscriptionsResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .profileId("pfl_5B8cwPMGnU")
                .testmode(false)
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        ListAllSubscriptionsRequest req = ListAllSubscriptionsRequest.builder()
                .from("tr_5B8cwPMGnU")
                .limit(50L)
                .build();


        sdk.subscriptions().all()
                .callAsStream()
                .forEach((ListAllSubscriptionsResponse item) -> {
                   // handle page
                });

    }
}
```
### Example Usage: list-payments-200-3

<!-- UsageSnippet language="java" operationID="list-all-subscriptions" method="get" path="/v2/subscriptions" example="list-payments-200-3" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.ListAllSubscriptionsRequest;
import com.mollie.mollie.models.operations.ListAllSubscriptionsResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .profileId("pfl_5B8cwPMGnU")
                .testmode(false)
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        ListAllSubscriptionsRequest req = ListAllSubscriptionsRequest.builder()
                .from("tr_5B8cwPMGnU")
                .limit(50L)
                .build();


        sdk.subscriptions().all()
                .callAsStream()
                .forEach((ListAllSubscriptionsResponse item) -> {
                   // handle page
                });

    }
}
```
### Example Usage: list-subscriptions-200-1

<!-- UsageSnippet language="java" operationID="list-all-subscriptions" method="get" path="/v2/subscriptions" example="list-subscriptions-200-1" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.ListAllSubscriptionsRequest;
import com.mollie.mollie.models.operations.ListAllSubscriptionsResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .profileId("pfl_5B8cwPMGnU")
                .testmode(false)
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        ListAllSubscriptionsRequest req = ListAllSubscriptionsRequest.builder()
                .from("sub_rVKGtNd6s3")
                .limit(50L)
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .xClientSignature("MEUCIQDx8sJvK3z...")
                .xClientSignedAt("2025-01-01T12:00:00Z")
                .build();


        sdk.subscriptions().all()
                .callAsStream()
                .forEach((ListAllSubscriptionsResponse item) -> {
                   // handle page
                });

    }
}
```

### Parameters

| Parameter                                                                             | Type                                                                                  | Required                                                                              | Description                                                                           |
| ------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------- |
| `request`                                                                             | [ListAllSubscriptionsRequest](../../models/operations/ListAllSubscriptionsRequest.md) | :heavy_check_mark:                                                                    | The request object to use for the request.                                            |

### Response

**[ListAllSubscriptionsResponse](../../models/operations/ListAllSubscriptionsResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 400, 404, 429               | application/hal+json        |
| models/errors/APIException  | 4XX, 5XX                    | \*/\*                       |

## listPayments

Retrieve all payments of a specific subscription.

The results are paginated.

### Example Usage: list-payments-200-1

<!-- UsageSnippet language="java" operationID="list-subscription-payments" method="get" path="/v2/customers/{customerId}/subscriptions/{subscriptionId}/payments" example="list-payments-200-1" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.components.Sorting;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.ListSubscriptionPaymentsRequest;
import com.mollie.mollie.models.operations.ListSubscriptionPaymentsResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .profileId("pfl_5B8cwPMGnU")
                .testmode(false)
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        ListSubscriptionPaymentsRequest req = ListSubscriptionPaymentsRequest.builder()
                .customerId("cst_5B8cwPMGnU")
                .subscriptionId("sub_5B8cwPMGnU")
                .from("tr_5B8cwPMGnU")
                .limit(50L)
                .sort(Sorting.DESC)
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .xClientSignature("MEUCIQDx8sJvK3z...")
                .xClientSignedAt("2025-01-01T12:00:00Z")
                .build();


        sdk.subscriptions().listPayments()
                .callAsStream()
                .forEach((ListSubscriptionPaymentsResponse item) -> {
                   // handle page
                });

    }
}
```
### Example Usage: list-payments-200-2

<!-- UsageSnippet language="java" operationID="list-subscription-payments" method="get" path="/v2/customers/{customerId}/subscriptions/{subscriptionId}/payments" example="list-payments-200-2" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.components.Sorting;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.ListSubscriptionPaymentsRequest;
import com.mollie.mollie.models.operations.ListSubscriptionPaymentsResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .profileId("pfl_5B8cwPMGnU")
                .testmode(false)
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        ListSubscriptionPaymentsRequest req = ListSubscriptionPaymentsRequest.builder()
                .customerId("cst_5B8cwPMGnU")
                .subscriptionId("sub_5B8cwPMGnU")
                .from("tr_5B8cwPMGnU")
                .limit(50L)
                .sort(Sorting.DESC)
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .xClientSignature("MEUCIQDx8sJvK3z...")
                .xClientSignedAt("2025-01-01T12:00:00Z")
                .build();


        sdk.subscriptions().listPayments()
                .callAsStream()
                .forEach((ListSubscriptionPaymentsResponse item) -> {
                   // handle page
                });

    }
}
```
### Example Usage: list-payments-200-3

<!-- UsageSnippet language="java" operationID="list-subscription-payments" method="get" path="/v2/customers/{customerId}/subscriptions/{subscriptionId}/payments" example="list-payments-200-3" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.components.Sorting;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.ListSubscriptionPaymentsRequest;
import com.mollie.mollie.models.operations.ListSubscriptionPaymentsResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .profileId("pfl_5B8cwPMGnU")
                .testmode(false)
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        ListSubscriptionPaymentsRequest req = ListSubscriptionPaymentsRequest.builder()
                .customerId("cst_5B8cwPMGnU")
                .subscriptionId("sub_5B8cwPMGnU")
                .from("tr_5B8cwPMGnU")
                .limit(50L)
                .sort(Sorting.DESC)
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .xClientSignature("MEUCIQDx8sJvK3z...")
                .xClientSignedAt("2025-01-01T12:00:00Z")
                .build();


        sdk.subscriptions().listPayments()
                .callAsStream()
                .forEach((ListSubscriptionPaymentsResponse item) -> {
                   // handle page
                });

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

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 400, 429                    | application/hal+json        |
| models/errors/APIException  | 4XX, 5XX                    | \*/\*                       |