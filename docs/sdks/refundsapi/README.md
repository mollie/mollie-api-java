# RefundsAPI
(*refundsAPI()*)

## Overview

### Available Operations

* [create](#create) - Create payment refund
* [list](#list) - List payment refunds
* [get](#get) - Get payment refund
* [cancel](#cancel) - Cancel payment refund
* [createOrder](#createorder) - Create order refund
* [listOrder](#listorder) - List order refunds
* [listAll](#listall) - List all refunds

## create

Creates a refund for a specific payment. The refunded amount is credited to your customer usually either via a bank
transfer or by refunding the amount to your customer's credit card.

### Example Usage

```java
package hello.world;

import com.mollie.mollie.Mollie;
import com.mollie.mollie.models.errors.CreateRefundRefundsAPIResponseBody;
import com.mollie.mollie.models.errors.CreateRefundRefundsAPIResponseResponseBody;
import com.mollie.mollie.models.errors.CreateRefundResponseBody;
import com.mollie.mollie.models.operations.CreateRefundAmount;
import com.mollie.mollie.models.operations.CreateRefundRefundsAPIAmount;
import com.mollie.mollie.models.operations.CreateRefundRequestBody;
import com.mollie.mollie.models.operations.CreateRefundResponse;
import com.mollie.mollie.models.operations.CreateRefundSecurity;
import com.mollie.mollie.models.operations.RoutingReversals;
import com.mollie.mollie.models.operations.Source;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws CreateRefundResponseBody, CreateRefundRefundsAPIResponseBody, CreateRefundRefundsAPIResponseResponseBody, Exception {

        Mollie sdk = Mollie.builder()
            .build();

        CreateRefundResponse res = sdk.refundsAPI().create()
                .security(CreateRefundSecurity.builder()
                    .apiKey("<YOUR_BEARER_TOKEN_HERE>")
                    .build())
                .paymentId("tr_5B8cwPMGnU6qLbRvo7qEZo")
                .requestBody(CreateRefundRequestBody.builder()
                    .amount(CreateRefundAmount.builder()
                        .currency("EUR")
                        .value("10.00")
                        .build())
                    .routingReversals(List.of(
                        RoutingReversals.builder()
                            .amount(CreateRefundRefundsAPIAmount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .source(Source.builder()
                                .organizationId("org_12345678")
                                .build())
                            .build(),
                        RoutingReversals.builder()
                            .amount(CreateRefundRefundsAPIAmount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .source(Source.builder()
                                .organizationId("org_12345678")
                                .build())
                            .build()))
                    .build())
                .call();

        if (res.any().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                   | Type                                                                                                        | Required                                                                                                    | Description                                                                                                 | Example                                                                                                     |
| ----------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------- |
| `security`                                                                                                  | [com.mollie.mollie.models.operations.CreateRefundSecurity](../../models/operations/CreateRefundSecurity.md) | :heavy_check_mark:                                                                                          | The security requirements to use for the request.                                                           |                                                                                                             |
| `paymentId`                                                                                                 | *String*                                                                                                    | :heavy_check_mark:                                                                                          | Provide the ID of the related payment.                                                                      | tr_5B8cwPMGnU6qLbRvo7qEZo                                                                                   |
| `requestBody`                                                                                               | [Optional\<CreateRefundRequestBody>](../../models/operations/CreateRefundRequestBody.md)                    | :heavy_minus_sign:                                                                                          | N/A                                                                                                         |                                                                                                             |

### Response

**[CreateRefundResponse](../../models/operations/CreateRefundResponse.md)**

### Errors

| Error Type                                               | Status Code                                              | Content Type                                             |
| -------------------------------------------------------- | -------------------------------------------------------- | -------------------------------------------------------- |
| models/errors/CreateRefundResponseBody                   | 404                                                      | application/hal+json                                     |
| models/errors/CreateRefundRefundsAPIResponseBody         | 409                                                      | application/hal+json                                     |
| models/errors/CreateRefundRefundsAPIResponseResponseBody | 422                                                      | application/hal+json                                     |
| models/errors/APIException                               | 4XX, 5XX                                                 | \*/\*                                                    |

## list

Retrieve a list of all refunds created for a specific payment.

The results are paginated.

### Example Usage

```java
package hello.world;

import com.mollie.mollie.Mollie;
import com.mollie.mollie.models.errors.ListRefundsRefundsAPIResponseBody;
import com.mollie.mollie.models.errors.ListRefundsResponseBody;
import com.mollie.mollie.models.operations.ListRefundsRequest;
import com.mollie.mollie.models.operations.ListRefundsResponse;
import com.mollie.mollie.models.operations.ListRefundsSecurity;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ListRefundsResponseBody, ListRefundsRefundsAPIResponseBody, Exception {

        Mollie sdk = Mollie.builder()
            .build();

        ListRefundsRequest req = ListRefundsRequest.builder()
                .paymentId("tr_5B8cwPMGnU6qLbRvo7qEZo")
                .from("re_4qqhO89gsT")
                .include("payment")
                .build();

        ListRefundsResponse res = sdk.refundsAPI().list()
                .request(req)
                .security(ListRefundsSecurity.builder()
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

| Parameter                                                                                                 | Type                                                                                                      | Required                                                                                                  | Description                                                                                               |
| --------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------- |
| `request`                                                                                                 | [ListRefundsRequest](../../models/operations/ListRefundsRequest.md)                                       | :heavy_check_mark:                                                                                        | The request object to use for the request.                                                                |
| `security`                                                                                                | [com.mollie.mollie.models.operations.ListRefundsSecurity](../../models/operations/ListRefundsSecurity.md) | :heavy_check_mark:                                                                                        | The security requirements to use for the request.                                                         |

### Response

**[ListRefundsResponse](../../models/operations/ListRefundsResponse.md)**

### Errors

| Error Type                                      | Status Code                                     | Content Type                                    |
| ----------------------------------------------- | ----------------------------------------------- | ----------------------------------------------- |
| models/errors/ListRefundsResponseBody           | 400                                             | application/hal+json                            |
| models/errors/ListRefundsRefundsAPIResponseBody | 404                                             | application/hal+json                            |
| models/errors/APIException                      | 4XX, 5XX                                        | \*/\*                                           |

## get

Retrieve a single payment refund by its ID and the ID of its parent payment.

### Example Usage

```java
package hello.world;

import com.mollie.mollie.Mollie;
import com.mollie.mollie.models.errors.GetRefundResponseBody;
import com.mollie.mollie.models.operations.GetRefundResponse;
import com.mollie.mollie.models.operations.GetRefundSecurity;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws GetRefundResponseBody, Exception {

        Mollie sdk = Mollie.builder()
            .build();

        GetRefundResponse res = sdk.refundsAPI().get()
                .security(GetRefundSecurity.builder()
                    .apiKey("<YOUR_BEARER_TOKEN_HERE>")
                    .build())
                .paymentId("tr_5B8cwPMGnU6qLbRvo7qEZo")
                .id("re_4qqhO89gsT")
                .include("payment")
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
| `security`                                                                                                                                                                                                                                                                                                                                                                             | [com.mollie.mollie.models.operations.GetRefundSecurity](../../models/operations/GetRefundSecurity.md)                                                                                                                                                                                                                                                                                  | :heavy_check_mark:                                                                                                                                                                                                                                                                                                                                                                     | The security requirements to use for the request.                                                                                                                                                                                                                                                                                                                                      |                                                                                                                                                                                                                                                                                                                                                                                        |
| `paymentId`                                                                                                                                                                                                                                                                                                                                                                            | *String*                                                                                                                                                                                                                                                                                                                                                                               | :heavy_check_mark:                                                                                                                                                                                                                                                                                                                                                                     | Provide the ID of the related payment.                                                                                                                                                                                                                                                                                                                                                 | tr_5B8cwPMGnU6qLbRvo7qEZo                                                                                                                                                                                                                                                                                                                                                              |
| `id`                                                                                                                                                                                                                                                                                                                                                                                   | *String*                                                                                                                                                                                                                                                                                                                                                                               | :heavy_check_mark:                                                                                                                                                                                                                                                                                                                                                                     | Provide the ID of the item you want to perform this operation on.                                                                                                                                                                                                                                                                                                                      | re_4qqhO89gsT                                                                                                                                                                                                                                                                                                                                                                          |
| `include`                                                                                                                                                                                                                                                                                                                                                                              | *JsonNullable\<String>*                                                                                                                                                                                                                                                                                                                                                                | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                     | This endpoint allows you to include additional information via the `include` query string parameter.<br/><br/>* `payment`: Include the payment this refund was created for.                                                                                                                                                                                                            | payment                                                                                                                                                                                                                                                                                                                                                                                |
| `testmode`                                                                                                                                                                                                                                                                                                                                                                             | *JsonNullable\<Boolean>*                                                                                                                                                                                                                                                                                                                                                               | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                     | Most API credentials are specifically created for either live mode or test mode. In those cases the `testmode` query<br/>parameter can be omitted. For organization-level credentials such as OAuth access tokens, you can enable test mode by<br/>setting the `testmode` query parameter to `true`.<br/><br/>Test entities cannot be retrieved when the endpoint is set to live mode, and vice versa. | false                                                                                                                                                                                                                                                                                                                                                                                  |

### Response

**[GetRefundResponse](../../models/operations/GetRefundResponse.md)**

### Errors

| Error Type                          | Status Code                         | Content Type                        |
| ----------------------------------- | ----------------------------------- | ----------------------------------- |
| models/errors/GetRefundResponseBody | 404                                 | application/hal+json                |
| models/errors/APIException          | 4XX, 5XX                            | \*/\*                               |

## cancel

Refunds will be executed with a delay of two hours. Until that time, refunds may be canceled manually via the
Mollie Dashboard, or by using this endpoint.

A refund can only be canceled while its `status` field is either `queued` or `pending`. See the
[Get refund endpoint](get-refund) for more information.

### Example Usage

```java
package hello.world;

import com.mollie.mollie.Mollie;
import com.mollie.mollie.models.errors.CancelRefundResponseBody;
import com.mollie.mollie.models.operations.CancelRefundResponse;
import com.mollie.mollie.models.operations.CancelRefundSecurity;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws CancelRefundResponseBody, Exception {

        Mollie sdk = Mollie.builder()
            .build();

        CancelRefundResponse res = sdk.refundsAPI().cancel()
                .security(CancelRefundSecurity.builder()
                    .apiKey("<YOUR_BEARER_TOKEN_HERE>")
                    .build())
                .paymentId("tr_5B8cwPMGnU6qLbRvo7qEZo")
                .id("re_4qqhO89gsT")
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
| `security`                                                                                                                                                                                                                                                                                                                                                                             | [com.mollie.mollie.models.operations.CancelRefundSecurity](../../models/operations/CancelRefundSecurity.md)                                                                                                                                                                                                                                                                            | :heavy_check_mark:                                                                                                                                                                                                                                                                                                                                                                     | The security requirements to use for the request.                                                                                                                                                                                                                                                                                                                                      |                                                                                                                                                                                                                                                                                                                                                                                        |
| `paymentId`                                                                                                                                                                                                                                                                                                                                                                            | *String*                                                                                                                                                                                                                                                                                                                                                                               | :heavy_check_mark:                                                                                                                                                                                                                                                                                                                                                                     | Provide the ID of the related payment.                                                                                                                                                                                                                                                                                                                                                 | tr_5B8cwPMGnU6qLbRvo7qEZo                                                                                                                                                                                                                                                                                                                                                              |
| `id`                                                                                                                                                                                                                                                                                                                                                                                   | *String*                                                                                                                                                                                                                                                                                                                                                                               | :heavy_check_mark:                                                                                                                                                                                                                                                                                                                                                                     | Provide the ID of the item you want to perform this operation on.                                                                                                                                                                                                                                                                                                                      | re_4qqhO89gsT                                                                                                                                                                                                                                                                                                                                                                          |
| `testmode`                                                                                                                                                                                                                                                                                                                                                                             | *JsonNullable\<Boolean>*                                                                                                                                                                                                                                                                                                                                                               | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                     | Most API credentials are specifically created for either live mode or test mode. In those cases the `testmode` query<br/>parameter can be omitted. For organization-level credentials such as OAuth access tokens, you can enable test mode by<br/>setting the `testmode` query parameter to `true`.<br/><br/>Test entities cannot be retrieved when the endpoint is set to live mode, and vice versa. | false                                                                                                                                                                                                                                                                                                                                                                                  |

### Response

**[CancelRefundResponse](../../models/operations/CancelRefundResponse.md)**

### Errors

| Error Type                             | Status Code                            | Content Type                           |
| -------------------------------------- | -------------------------------------- | -------------------------------------- |
| models/errors/CancelRefundResponseBody | 404                                    | application/hal+json                   |
| models/errors/APIException             | 4XX, 5XX                               | \*/\*                                  |

## createOrder

When using the Orders API, refunds should be made for a specific order.

If you want to refund arbitrary amounts, however, you can also use the
[Create payment refund endpoint](create-refund) by creating a refund on the payment itself.

If an order line is still in the `authorized` state, it cannot be refunded. You should cancel it instead. Order
lines that are `paid`, `shipping` or `completed` can be refunded.

### Example Usage

```java
package hello.world;

import com.mollie.mollie.Mollie;
import com.mollie.mollie.models.errors.CreateOrderRefundRefundsAPIResponseBody;
import com.mollie.mollie.models.errors.CreateOrderRefundResponseBody;
import com.mollie.mollie.models.operations.CreateOrderRefundAmount;
import com.mollie.mollie.models.operations.CreateOrderRefundLines;
import com.mollie.mollie.models.operations.CreateOrderRefundRequestBody;
import com.mollie.mollie.models.operations.CreateOrderRefundResponse;
import com.mollie.mollie.models.operations.CreateOrderRefundSecurity;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws CreateOrderRefundResponseBody, CreateOrderRefundRefundsAPIResponseBody, Exception {

        Mollie sdk = Mollie.builder()
            .build();

        CreateOrderRefundResponse res = sdk.refundsAPI().createOrder()
                .security(CreateOrderRefundSecurity.builder()
                    .apiKey("<YOUR_BEARER_TOKEN_HERE>")
                    .build())
                .orderId("ord_pbjz8x")
                .requestBody(CreateOrderRefundRequestBody.builder()
                    .lines(List.of(
                        CreateOrderRefundLines.builder()
                            .amount(CreateOrderRefundAmount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .build(),
                        CreateOrderRefundLines.builder()
                            .amount(CreateOrderRefundAmount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .build(),
                        CreateOrderRefundLines.builder()
                            .amount(CreateOrderRefundAmount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .build()))
                    .build())
                .call();

        if (res.object().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                             | Type                                                                                                                  | Required                                                                                                              | Description                                                                                                           | Example                                                                                                               |
| --------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------- |
| `security`                                                                                                            | [com.mollie.mollie.models.operations.CreateOrderRefundSecurity](../../models/operations/CreateOrderRefundSecurity.md) | :heavy_check_mark:                                                                                                    | The security requirements to use for the request.                                                                     |                                                                                                                       |
| `orderId`                                                                                                             | *String*                                                                                                              | :heavy_check_mark:                                                                                                    | Provide the ID of the related order.                                                                                  | ord_pbjz8x                                                                                                            |
| `requestBody`                                                                                                         | [Optional\<CreateOrderRefundRequestBody>](../../models/operations/CreateOrderRefundRequestBody.md)                    | :heavy_minus_sign:                                                                                                    | N/A                                                                                                                   |                                                                                                                       |

### Response

**[CreateOrderRefundResponse](../../models/operations/CreateOrderRefundResponse.md)**

### Errors

| Error Type                                            | Status Code                                           | Content Type                                          |
| ----------------------------------------------------- | ----------------------------------------------------- | ----------------------------------------------------- |
| models/errors/CreateOrderRefundResponseBody           | 404                                                   | application/hal+json                                  |
| models/errors/CreateOrderRefundRefundsAPIResponseBody | 422                                                   | application/hal+json                                  |
| models/errors/APIException                            | 4XX, 5XX                                              | \*/\*                                                 |

## listOrder

Retrieve a list of all refunds created for a specific order.

The results are paginated.

### Example Usage

```java
package hello.world;

import com.mollie.mollie.Mollie;
import com.mollie.mollie.models.errors.ListOrderRefundsResponseBody;
import com.mollie.mollie.models.operations.ListOrderRefundsRequest;
import com.mollie.mollie.models.operations.ListOrderRefundsResponse;
import com.mollie.mollie.models.operations.ListOrderRefundsSecurity;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ListOrderRefundsResponseBody, Exception {

        Mollie sdk = Mollie.builder()
            .build();

        ListOrderRefundsRequest req = ListOrderRefundsRequest.builder()
                .orderId("ord_pbjz8x")
                .from("re_4qqhO89gsT")
                .include("payment")
                .build();

        ListOrderRefundsResponse res = sdk.refundsAPI().listOrder()
                .request(req)
                .security(ListOrderRefundsSecurity.builder()
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

| Parameter                                                                                                           | Type                                                                                                                | Required                                                                                                            | Description                                                                                                         |
| ------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------- |
| `request`                                                                                                           | [ListOrderRefundsRequest](../../models/operations/ListOrderRefundsRequest.md)                                       | :heavy_check_mark:                                                                                                  | The request object to use for the request.                                                                          |
| `security`                                                                                                          | [com.mollie.mollie.models.operations.ListOrderRefundsSecurity](../../models/operations/ListOrderRefundsSecurity.md) | :heavy_check_mark:                                                                                                  | The security requirements to use for the request.                                                                   |

### Response

**[ListOrderRefundsResponse](../../models/operations/ListOrderRefundsResponse.md)**

### Errors

| Error Type                                 | Status Code                                | Content Type                               |
| ------------------------------------------ | ------------------------------------------ | ------------------------------------------ |
| models/errors/ListOrderRefundsResponseBody | 400                                        | application/hal+json                       |
| models/errors/APIException                 | 4XX, 5XX                                   | \*/\*                                      |

## listAll

Retrieve a list of all of your refunds.

The results are paginated.

### Example Usage

```java
package hello.world;

import com.mollie.mollie.Mollie;
import com.mollie.mollie.models.errors.ListAllRefundsResponseBody;
import com.mollie.mollie.models.operations.ListAllRefundsRequest;
import com.mollie.mollie.models.operations.ListAllRefundsResponse;
import com.mollie.mollie.models.operations.ListAllRefundsSecurity;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ListAllRefundsResponseBody, Exception {

        Mollie sdk = Mollie.builder()
            .build();

        ListAllRefundsRequest req = ListAllRefundsRequest.builder()
                .from("re_4qqhO89gsT")
                .embed("payment")
                .profileId("pfl_QkEhN94Ba")
                .build();

        ListAllRefundsResponse res = sdk.refundsAPI().listAll()
                .request(req)
                .security(ListAllRefundsSecurity.builder()
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

| Parameter                                                                                                       | Type                                                                                                            | Required                                                                                                        | Description                                                                                                     |
| --------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------- |
| `request`                                                                                                       | [ListAllRefundsRequest](../../models/operations/ListAllRefundsRequest.md)                                       | :heavy_check_mark:                                                                                              | The request object to use for the request.                                                                      |
| `security`                                                                                                      | [com.mollie.mollie.models.operations.ListAllRefundsSecurity](../../models/operations/ListAllRefundsSecurity.md) | :heavy_check_mark:                                                                                              | The security requirements to use for the request.                                                               |

### Response

**[ListAllRefundsResponse](../../models/operations/ListAllRefundsResponse.md)**

### Errors

| Error Type                               | Status Code                              | Content Type                             |
| ---------------------------------------- | ---------------------------------------- | ---------------------------------------- |
| models/errors/ListAllRefundsResponseBody | 400                                      | application/hal+json                     |
| models/errors/APIException               | 4XX, 5XX                                 | \*/\*                                    |