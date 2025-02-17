# SubscriptionsAPI
(*subscriptionsAPI()*)

## Overview

### Available Operations

* [create](#create) - Create subscription
* [list](#list) - List customer subscriptions
* [get](#get) - Get subscription
* [update](#update) - Update subscription
* [cancel](#cancel) - Cancel subscription
* [listAll](#listall) - List all subscriptions
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

```java
package hello.world;

import com.mollie.mollie.Mollie;
import com.mollie.mollie.models.errors.CreateSubscriptionResponseBody;
import com.mollie.mollie.models.operations.CreateSubscriptionAmount;
import com.mollie.mollie.models.operations.CreateSubscriptionApplicationFee;
import com.mollie.mollie.models.operations.CreateSubscriptionInterval;
import com.mollie.mollie.models.operations.CreateSubscriptionRequestBody;
import com.mollie.mollie.models.operations.CreateSubscriptionResponse;
import com.mollie.mollie.models.operations.CreateSubscriptionSecurity;
import com.mollie.mollie.models.operations.CreateSubscriptionSubscriptionsAPIAmount;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws CreateSubscriptionResponseBody, Exception {

        Mollie sdk = Mollie.builder()
            .build();

        CreateSubscriptionResponse res = sdk.subscriptionsAPI().create()
                .security(CreateSubscriptionSecurity.builder()
                    .apiKey("<YOUR_BEARER_TOKEN_HERE>")
                    .build())
                .customerId("cst_8wmqcHMN4U")
                .requestBody(CreateSubscriptionRequestBody.builder()
                    .amount(CreateSubscriptionAmount.builder()
                        .currency("EUR")
                        .value("10.00")
                        .build())
                    .interval(CreateSubscriptionInterval.DOT_WEEKS)
                    .description("delightfully fumigate convection though zowie up bulky electronics")
                    .applicationFee(CreateSubscriptionApplicationFee.builder()
                        .amount(CreateSubscriptionSubscriptionsAPIAmount.builder()
                            .currency("EUR")
                            .value("10.00")
                            .build())
                        .build())
                    .profileId("pfl_QkEhN94Ba")
                    .build())
                .call();

        if (res.any().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                               | Type                                                                                                                    | Required                                                                                                                | Description                                                                                                             | Example                                                                                                                 |
| ----------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------- |
| `security`                                                                                                              | [com.mollie.mollie.models.operations.CreateSubscriptionSecurity](../../models/operations/CreateSubscriptionSecurity.md) | :heavy_check_mark:                                                                                                      | The security requirements to use for the request.                                                                       |                                                                                                                         |
| `customerId`                                                                                                            | *String*                                                                                                                | :heavy_check_mark:                                                                                                      | Provide the ID of the related customer.                                                                                 | cst_8wmqcHMN4U                                                                                                          |
| `requestBody`                                                                                                           | [Optional\<CreateSubscriptionRequestBody>](../../models/operations/CreateSubscriptionRequestBody.md)                    | :heavy_minus_sign:                                                                                                      | N/A                                                                                                                     |                                                                                                                         |

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

```java
package hello.world;

import com.mollie.mollie.Mollie;
import com.mollie.mollie.models.errors.ListSubscriptionsResponseBody;
import com.mollie.mollie.models.errors.ListSubscriptionsSubscriptionsAPIResponseBody;
import com.mollie.mollie.models.operations.ListSubscriptionsResponse;
import com.mollie.mollie.models.operations.ListSubscriptionsSecurity;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ListSubscriptionsResponseBody, ListSubscriptionsSubscriptionsAPIResponseBody, Exception {

        Mollie sdk = Mollie.builder()
            .build();

        ListSubscriptionsResponse res = sdk.subscriptionsAPI().list()
                .security(ListSubscriptionsSecurity.builder()
                    .apiKey("<YOUR_BEARER_TOKEN_HERE>")
                    .build())
                .customerId("cst_8wmqcHMN4U")
                .from("sub_rVKGtNd6s3")
                .limit(50L)
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
| `security`                                                                                                                                                                                                                                                                                                                                                                             | [com.mollie.mollie.models.operations.ListSubscriptionsSecurity](../../models/operations/ListSubscriptionsSecurity.md)                                                                                                                                                                                                                                                                  | :heavy_check_mark:                                                                                                                                                                                                                                                                                                                                                                     | The security requirements to use for the request.                                                                                                                                                                                                                                                                                                                                      |                                                                                                                                                                                                                                                                                                                                                                                        |
| `customerId`                                                                                                                                                                                                                                                                                                                                                                           | *String*                                                                                                                                                                                                                                                                                                                                                                               | :heavy_check_mark:                                                                                                                                                                                                                                                                                                                                                                     | Provide the ID of the related customer.                                                                                                                                                                                                                                                                                                                                                | cst_8wmqcHMN4U                                                                                                                                                                                                                                                                                                                                                                         |
| `from`                                                                                                                                                                                                                                                                                                                                                                                 | *Optional\<String>*                                                                                                                                                                                                                                                                                                                                                                    | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                     | Provide an ID to start the result set from the item with the given ID and onwards. This allows you to paginate the<br/>result set.                                                                                                                                                                                                                                                     | sub_rVKGtNd6s3                                                                                                                                                                                                                                                                                                                                                                         |
| `limit`                                                                                                                                                                                                                                                                                                                                                                                | *JsonNullable\<Long>*                                                                                                                                                                                                                                                                                                                                                                  | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                     | The maximum number of items to return. Defaults to 50 items.                                                                                                                                                                                                                                                                                                                           | 50                                                                                                                                                                                                                                                                                                                                                                                     |
| `testmode`                                                                                                                                                                                                                                                                                                                                                                             | *JsonNullable\<Boolean>*                                                                                                                                                                                                                                                                                                                                                               | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                     | Most API credentials are specifically created for either live mode or test mode. In those cases the `testmode` query<br/>parameter can be omitted. For organization-level credentials such as OAuth access tokens, you can enable test mode by<br/>setting the `testmode` query parameter to `true`.<br/><br/>Test entities cannot be retrieved when the endpoint is set to live mode, and vice versa. | false                                                                                                                                                                                                                                                                                                                                                                                  |

### Response

**[ListSubscriptionsResponse](../../models/operations/ListSubscriptionsResponse.md)**

### Errors

| Error Type                                                  | Status Code                                                 | Content Type                                                |
| ----------------------------------------------------------- | ----------------------------------------------------------- | ----------------------------------------------------------- |
| models/errors/ListSubscriptionsResponseBody                 | 400                                                         | application/hal+json                                        |
| models/errors/ListSubscriptionsSubscriptionsAPIResponseBody | 404                                                         | application/hal+json                                        |
| models/errors/APIException                                  | 4XX, 5XX                                                    | \*/\*                                                       |

## get

Retrieve a single subscription by its ID and the ID of its parent customer.

### Example Usage

```java
package hello.world;

import com.mollie.mollie.Mollie;
import com.mollie.mollie.models.errors.GetSubscriptionResponseBody;
import com.mollie.mollie.models.operations.GetSubscriptionResponse;
import com.mollie.mollie.models.operations.GetSubscriptionSecurity;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws GetSubscriptionResponseBody, Exception {

        Mollie sdk = Mollie.builder()
            .build();

        GetSubscriptionResponse res = sdk.subscriptionsAPI().get()
                .security(GetSubscriptionSecurity.builder()
                    .apiKey("<YOUR_BEARER_TOKEN_HERE>")
                    .build())
                .customerId("cst_8wmqcHMN4U")
                .id("sub_rVKGtNd6s3")
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
| `security`                                                                                                                                                                                                                                                                                                                                                                             | [com.mollie.mollie.models.operations.GetSubscriptionSecurity](../../models/operations/GetSubscriptionSecurity.md)                                                                                                                                                                                                                                                                      | :heavy_check_mark:                                                                                                                                                                                                                                                                                                                                                                     | The security requirements to use for the request.                                                                                                                                                                                                                                                                                                                                      |                                                                                                                                                                                                                                                                                                                                                                                        |
| `customerId`                                                                                                                                                                                                                                                                                                                                                                           | *String*                                                                                                                                                                                                                                                                                                                                                                               | :heavy_check_mark:                                                                                                                                                                                                                                                                                                                                                                     | Provide the ID of the related customer.                                                                                                                                                                                                                                                                                                                                                | cst_8wmqcHMN4U                                                                                                                                                                                                                                                                                                                                                                         |
| `id`                                                                                                                                                                                                                                                                                                                                                                                   | *String*                                                                                                                                                                                                                                                                                                                                                                               | :heavy_check_mark:                                                                                                                                                                                                                                                                                                                                                                     | Provide the ID of the item you want to perform this operation on.                                                                                                                                                                                                                                                                                                                      | sub_rVKGtNd6s3                                                                                                                                                                                                                                                                                                                                                                         |
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

```java
package hello.world;

import com.mollie.mollie.Mollie;
import com.mollie.mollie.models.errors.UpdateSubscriptionResponseBody;
import com.mollie.mollie.models.operations.UpdateSubscriptionAmount;
import com.mollie.mollie.models.operations.UpdateSubscriptionRequestBody;
import com.mollie.mollie.models.operations.UpdateSubscriptionResponse;
import com.mollie.mollie.models.operations.UpdateSubscriptionSecurity;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws UpdateSubscriptionResponseBody, Exception {

        Mollie sdk = Mollie.builder()
            .build();

        UpdateSubscriptionResponse res = sdk.subscriptionsAPI().update()
                .security(UpdateSubscriptionSecurity.builder()
                    .apiKey("<YOUR_BEARER_TOKEN_HERE>")
                    .build())
                .customerId("cst_8wmqcHMN4U")
                .id("sub_rVKGtNd6s3")
                .testmode(false)
                .requestBody(UpdateSubscriptionRequestBody.builder()
                    .amount(UpdateSubscriptionAmount.builder()
                        .currency("EUR")
                        .value("10.00")
                        .build())
                    .build())
                .call();

        if (res.any().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                                                                                                                                                                                                                                                                                              | Type                                                                                                                                                                                                                                                                                                                                                                                   | Required                                                                                                                                                                                                                                                                                                                                                                               | Description                                                                                                                                                                                                                                                                                                                                                                            | Example                                                                                                                                                                                                                                                                                                                                                                                |
| -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `security`                                                                                                                                                                                                                                                                                                                                                                             | [com.mollie.mollie.models.operations.UpdateSubscriptionSecurity](../../models/operations/UpdateSubscriptionSecurity.md)                                                                                                                                                                                                                                                                | :heavy_check_mark:                                                                                                                                                                                                                                                                                                                                                                     | The security requirements to use for the request.                                                                                                                                                                                                                                                                                                                                      |                                                                                                                                                                                                                                                                                                                                                                                        |
| `customerId`                                                                                                                                                                                                                                                                                                                                                                           | *String*                                                                                                                                                                                                                                                                                                                                                                               | :heavy_check_mark:                                                                                                                                                                                                                                                                                                                                                                     | Provide the ID of the related customer.                                                                                                                                                                                                                                                                                                                                                | cst_8wmqcHMN4U                                                                                                                                                                                                                                                                                                                                                                         |
| `id`                                                                                                                                                                                                                                                                                                                                                                                   | *String*                                                                                                                                                                                                                                                                                                                                                                               | :heavy_check_mark:                                                                                                                                                                                                                                                                                                                                                                     | Provide the ID of the item you want to perform this operation on.                                                                                                                                                                                                                                                                                                                      | sub_rVKGtNd6s3                                                                                                                                                                                                                                                                                                                                                                         |
| `testmode`                                                                                                                                                                                                                                                                                                                                                                             | *JsonNullable\<Boolean>*                                                                                                                                                                                                                                                                                                                                                               | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                     | Most API credentials are specifically created for either live mode or test mode. In those cases the `testmode` query<br/>parameter can be omitted. For organization-level credentials such as OAuth access tokens, you can enable test mode by<br/>setting the `testmode` query parameter to `true`.<br/><br/>Test entities cannot be retrieved when the endpoint is set to live mode, and vice versa. | false                                                                                                                                                                                                                                                                                                                                                                                  |
| `requestBody`                                                                                                                                                                                                                                                                                                                                                                          | [Optional\<UpdateSubscriptionRequestBody>](../../models/operations/UpdateSubscriptionRequestBody.md)                                                                                                                                                                                                                                                                                   | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                     | N/A                                                                                                                                                                                                                                                                                                                                                                                    |                                                                                                                                                                                                                                                                                                                                                                                        |

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

```java
package hello.world;

import com.mollie.mollie.Mollie;
import com.mollie.mollie.models.errors.CancelSubscriptionResponseBody;
import com.mollie.mollie.models.operations.CancelSubscriptionResponse;
import com.mollie.mollie.models.operations.CancelSubscriptionSecurity;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws CancelSubscriptionResponseBody, Exception {

        Mollie sdk = Mollie.builder()
            .build();

        CancelSubscriptionResponse res = sdk.subscriptionsAPI().cancel()
                .security(CancelSubscriptionSecurity.builder()
                    .apiKey("<YOUR_BEARER_TOKEN_HERE>")
                    .build())
                .customerId("cst_8wmqcHMN4U")
                .id("sub_rVKGtNd6s3")
                .testmode(false)
                .call();

        if (res.any().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                                                                                                                                                                                                                                                                                              | Type                                                                                                                                                                                                                                                                                                                                                                                   | Required                                                                                                                                                                                                                                                                                                                                                                               | Description                                                                                                                                                                                                                                                                                                                                                                            | Example                                                                                                                                                                                                                                                                                                                                                                                |
| -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `security`                                                                                                                                                                                                                                                                                                                                                                             | [com.mollie.mollie.models.operations.CancelSubscriptionSecurity](../../models/operations/CancelSubscriptionSecurity.md)                                                                                                                                                                                                                                                                | :heavy_check_mark:                                                                                                                                                                                                                                                                                                                                                                     | The security requirements to use for the request.                                                                                                                                                                                                                                                                                                                                      |                                                                                                                                                                                                                                                                                                                                                                                        |
| `customerId`                                                                                                                                                                                                                                                                                                                                                                           | *String*                                                                                                                                                                                                                                                                                                                                                                               | :heavy_check_mark:                                                                                                                                                                                                                                                                                                                                                                     | Provide the ID of the related customer.                                                                                                                                                                                                                                                                                                                                                | cst_8wmqcHMN4U                                                                                                                                                                                                                                                                                                                                                                         |
| `id`                                                                                                                                                                                                                                                                                                                                                                                   | *String*                                                                                                                                                                                                                                                                                                                                                                               | :heavy_check_mark:                                                                                                                                                                                                                                                                                                                                                                     | Provide the ID of the item you want to perform this operation on.                                                                                                                                                                                                                                                                                                                      | sub_rVKGtNd6s3                                                                                                                                                                                                                                                                                                                                                                         |
| `testmode`                                                                                                                                                                                                                                                                                                                                                                             | *JsonNullable\<Boolean>*                                                                                                                                                                                                                                                                                                                                                               | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                     | Most API credentials are specifically created for either live mode or test mode. In those cases the `testmode` query<br/>parameter can be omitted. For organization-level credentials such as OAuth access tokens, you can enable test mode by<br/>setting the `testmode` query parameter to `true`.<br/><br/>Test entities cannot be retrieved when the endpoint is set to live mode, and vice versa. | false                                                                                                                                                                                                                                                                                                                                                                                  |

### Response

**[CancelSubscriptionResponse](../../models/operations/CancelSubscriptionResponse.md)**

### Errors

| Error Type                                   | Status Code                                  | Content Type                                 |
| -------------------------------------------- | -------------------------------------------- | -------------------------------------------- |
| models/errors/CancelSubscriptionResponseBody | 404                                          | application/hal+json                         |
| models/errors/APIException                   | 4XX, 5XX                                     | \*/\*                                        |

## listAll

Retrieve all subscriptions initiated across all your customers.

The results are paginated.

### Example Usage

```java
package hello.world;

import com.mollie.mollie.Mollie;
import com.mollie.mollie.models.errors.ListAllSubscriptionsResponseBody;
import com.mollie.mollie.models.errors.ListAllSubscriptionsSubscriptionsAPIResponseBody;
import com.mollie.mollie.models.operations.ListAllSubscriptionsResponse;
import com.mollie.mollie.models.operations.ListAllSubscriptionsSecurity;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ListAllSubscriptionsResponseBody, ListAllSubscriptionsSubscriptionsAPIResponseBody, Exception {

        Mollie sdk = Mollie.builder()
            .build();

        ListAllSubscriptionsResponse res = sdk.subscriptionsAPI().listAll()
                .security(ListAllSubscriptionsSecurity.builder()
                    .apiKey("<YOUR_BEARER_TOKEN_HERE>")
                    .build())
                .from("sub_rVKGtNd6s3")
                .limit(50L)
                .profileId("pfl_QkEhN94Ba")
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
| `security`                                                                                                                                                                                                                                                                                                                                                                             | [com.mollie.mollie.models.operations.ListAllSubscriptionsSecurity](../../models/operations/ListAllSubscriptionsSecurity.md)                                                                                                                                                                                                                                                            | :heavy_check_mark:                                                                                                                                                                                                                                                                                                                                                                     | The security requirements to use for the request.                                                                                                                                                                                                                                                                                                                                      |                                                                                                                                                                                                                                                                                                                                                                                        |
| `from`                                                                                                                                                                                                                                                                                                                                                                                 | *Optional\<String>*                                                                                                                                                                                                                                                                                                                                                                    | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                     | Provide an ID to start the result set from the item with the given ID and onwards. This allows you to paginate the<br/>result set.                                                                                                                                                                                                                                                     | sub_rVKGtNd6s3                                                                                                                                                                                                                                                                                                                                                                         |
| `limit`                                                                                                                                                                                                                                                                                                                                                                                | *JsonNullable\<Long>*                                                                                                                                                                                                                                                                                                                                                                  | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                     | The maximum number of items to return. Defaults to 50 items.                                                                                                                                                                                                                                                                                                                           | 50                                                                                                                                                                                                                                                                                                                                                                                     |
| `profileId`                                                                                                                                                                                                                                                                                                                                                                            | *JsonNullable\<String>*                                                                                                                                                                                                                                                                                                                                                                | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                     | The identifier referring to the [profile](get-profile) you wish to retrieve subscriptions for.<br/><br/>Most API credentials are linked to a single profile. In these cases the `profileId` is already implied.<br/><br/>To retrieve all subscriptions across the organization, use an organization-level API credential and omit the<br/>`profileId` parameter.                       | pfl_QkEhN94Ba                                                                                                                                                                                                                                                                                                                                                                          |
| `testmode`                                                                                                                                                                                                                                                                                                                                                                             | *JsonNullable\<Boolean>*                                                                                                                                                                                                                                                                                                                                                               | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                     | Most API credentials are specifically created for either live mode or test mode. In those cases the `testmode` query<br/>parameter can be omitted. For organization-level credentials such as OAuth access tokens, you can enable test mode by<br/>setting the `testmode` query parameter to `true`.<br/><br/>Test entities cannot be retrieved when the endpoint is set to live mode, and vice versa. | false                                                                                                                                                                                                                                                                                                                                                                                  |

### Response

**[ListAllSubscriptionsResponse](../../models/operations/ListAllSubscriptionsResponse.md)**

### Errors

| Error Type                                                     | Status Code                                                    | Content Type                                                   |
| -------------------------------------------------------------- | -------------------------------------------------------------- | -------------------------------------------------------------- |
| models/errors/ListAllSubscriptionsResponseBody                 | 400                                                            | application/hal+json                                           |
| models/errors/ListAllSubscriptionsSubscriptionsAPIResponseBody | 404                                                            | application/hal+json                                           |
| models/errors/APIException                                     | 4XX, 5XX                                                       | \*/\*                                                          |

## listPayments

Retrieve all payments of a specific subscription.

The results are paginated.

### Example Usage

```java
package hello.world;

import com.mollie.mollie.Mollie;
import com.mollie.mollie.models.errors.ListSubscriptionPaymentsResponseBody;
import com.mollie.mollie.models.operations.ListSubscriptionPaymentsRequest;
import com.mollie.mollie.models.operations.ListSubscriptionPaymentsResponse;
import com.mollie.mollie.models.operations.ListSubscriptionPaymentsSecurity;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ListSubscriptionPaymentsResponseBody, Exception {

        Mollie sdk = Mollie.builder()
            .build();

        ListSubscriptionPaymentsRequest req = ListSubscriptionPaymentsRequest.builder()
                .customerId("cst_8wmqcHMN4U")
                .subscriptionId("sub_rVKGtNd6s3")
                .from("tr_5B8cwPMGnU6qLbRvo7qEZo")
                .build();

        ListSubscriptionPaymentsResponse res = sdk.subscriptionsAPI().listPayments()
                .request(req)
                .security(ListSubscriptionPaymentsSecurity.builder()
                    .apiKey("<YOUR_BEARER_TOKEN_HERE>")
                    .build())
                .call();

        if (res.object().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                                           | Type                                                                                                                                | Required                                                                                                                            | Description                                                                                                                         |
| ----------------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------- |
| `request`                                                                                                                           | [ListSubscriptionPaymentsRequest](../../models/operations/ListSubscriptionPaymentsRequest.md)                                       | :heavy_check_mark:                                                                                                                  | The request object to use for the request.                                                                                          |
| `security`                                                                                                                          | [com.mollie.mollie.models.operations.ListSubscriptionPaymentsSecurity](../../models/operations/ListSubscriptionPaymentsSecurity.md) | :heavy_check_mark:                                                                                                                  | The security requirements to use for the request.                                                                                   |

### Response

**[ListSubscriptionPaymentsResponse](../../models/operations/ListSubscriptionPaymentsResponse.md)**

### Errors

| Error Type                                         | Status Code                                        | Content Type                                       |
| -------------------------------------------------- | -------------------------------------------------- | -------------------------------------------------- |
| models/errors/ListSubscriptionPaymentsResponseBody | 400                                                | application/hal+json                               |
| models/errors/APIException                         | 4XX, 5XX                                           | \*/\*                                              |