# PaymentLinksAPI
(*paymentLinksAPI()*)

## Overview

### Available Operations

* [create](#create) - Create payment link
* [list](#list) - List payment links
* [get](#get) - Get payment link
* [update](#update) - Update payment link
* [delete](#delete) - Delete payment link
* [getPayments](#getpayments) - Get payment link payments

## create

With the Payment links API you can generate payment links that by default, unlike regular payments, do not expire.
The payment link can be shared with your customers and will redirect them to them the payment page where they can
complete the payment. A [payment](get-payment) will only be created once the customer initiates the payment.

### Example Usage

```java
package hello.world;

import com.mollie.mollie.Mollie;
import com.mollie.mollie.models.errors.CreatePaymentLinkPaymentLinksAPIResponseBody;
import com.mollie.mollie.models.errors.CreatePaymentLinkResponseBody;
import com.mollie.mollie.models.operations.CreatePaymentLinkAmount;
import com.mollie.mollie.models.operations.CreatePaymentLinkRequestBody;
import com.mollie.mollie.models.operations.CreatePaymentLinkResponse;
import com.mollie.mollie.models.operations.CreatePaymentLinkSecurity;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws CreatePaymentLinkResponseBody, CreatePaymentLinkPaymentLinksAPIResponseBody, Exception {

        Mollie sdk = Mollie.builder()
            .build();

        CreatePaymentLinkRequestBody req = CreatePaymentLinkRequestBody.builder()
                .amount(CreatePaymentLinkAmount.builder()
                    .currency("EUR")
                    .value("10.00")
                    .build())
                .profileId("pfl_QkEhN94Ba")
                .build();

        CreatePaymentLinkResponse res = sdk.paymentLinksAPI().create()
                .request(req)
                .security(CreatePaymentLinkSecurity.builder()
                    .apiKey("<YOUR_BEARER_TOKEN_HERE>")
                    .build())
                .call();

        if (res.any().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                             | Type                                                                                                                  | Required                                                                                                              | Description                                                                                                           |
| --------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------- |
| `request`                                                                                                             | [CreatePaymentLinkRequestBody](../../models/operations/CreatePaymentLinkRequestBody.md)                               | :heavy_check_mark:                                                                                                    | The request object to use for the request.                                                                            |
| `security`                                                                                                            | [com.mollie.mollie.models.operations.CreatePaymentLinkSecurity](../../models/operations/CreatePaymentLinkSecurity.md) | :heavy_check_mark:                                                                                                    | The security requirements to use for the request.                                                                     |

### Response

**[CreatePaymentLinkResponse](../../models/operations/CreatePaymentLinkResponse.md)**

### Errors

| Error Type                                                 | Status Code                                                | Content Type                                               |
| ---------------------------------------------------------- | ---------------------------------------------------------- | ---------------------------------------------------------- |
| models/errors/CreatePaymentLinkResponseBody                | 404                                                        | application/hal+json                                       |
| models/errors/CreatePaymentLinkPaymentLinksAPIResponseBody | 422                                                        | application/hal+json                                       |
| models/errors/APIException                                 | 4XX, 5XX                                                   | \*/\*                                                      |

## list

Retrieve a list of all payment links.

The results are paginated.

### Example Usage

```java
package hello.world;

import com.mollie.mollie.Mollie;
import com.mollie.mollie.models.errors.ListPaymentLinksResponseBody;
import com.mollie.mollie.models.operations.ListPaymentLinksResponse;
import com.mollie.mollie.models.operations.ListPaymentLinksSecurity;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ListPaymentLinksResponseBody, Exception {

        Mollie sdk = Mollie.builder()
            .build();

        ListPaymentLinksResponse res = sdk.paymentLinksAPI().list()
                .security(ListPaymentLinksSecurity.builder()
                    .apiKey("<YOUR_BEARER_TOKEN_HERE>")
                    .build())
                .from("pl_4Y0eZitmBnQ6IDoMqZQKh")
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
| `security`                                                                                                                                                                                                                                                                                                                                                                             | [com.mollie.mollie.models.operations.ListPaymentLinksSecurity](../../models/operations/ListPaymentLinksSecurity.md)                                                                                                                                                                                                                                                                    | :heavy_check_mark:                                                                                                                                                                                                                                                                                                                                                                     | The security requirements to use for the request.                                                                                                                                                                                                                                                                                                                                      |                                                                                                                                                                                                                                                                                                                                                                                        |
| `from`                                                                                                                                                                                                                                                                                                                                                                                 | *Optional\<String>*                                                                                                                                                                                                                                                                                                                                                                    | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                     | Provide an ID to start the result set from the item with the given ID and onwards. This allows you to paginate the<br/>result set.                                                                                                                                                                                                                                                     | pl_4Y0eZitmBnQ6IDoMqZQKh                                                                                                                                                                                                                                                                                                                                                               |
| `limit`                                                                                                                                                                                                                                                                                                                                                                                | *JsonNullable\<Long>*                                                                                                                                                                                                                                                                                                                                                                  | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                     | The maximum number of items to return. Defaults to 50 items.                                                                                                                                                                                                                                                                                                                           | 50                                                                                                                                                                                                                                                                                                                                                                                     |
| `testmode`                                                                                                                                                                                                                                                                                                                                                                             | *JsonNullable\<Boolean>*                                                                                                                                                                                                                                                                                                                                                               | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                     | Most API credentials are specifically created for either live mode or test mode. In those cases the `testmode` query<br/>parameter can be omitted. For organization-level credentials such as OAuth access tokens, you can enable test mode by<br/>setting the `testmode` query parameter to `true`.<br/><br/>Test entities cannot be retrieved when the endpoint is set to live mode, and vice versa. | false                                                                                                                                                                                                                                                                                                                                                                                  |

### Response

**[ListPaymentLinksResponse](../../models/operations/ListPaymentLinksResponse.md)**

### Errors

| Error Type                                 | Status Code                                | Content Type                               |
| ------------------------------------------ | ------------------------------------------ | ------------------------------------------ |
| models/errors/ListPaymentLinksResponseBody | 400                                        | application/hal+json                       |
| models/errors/APIException                 | 4XX, 5XX                                   | \*/\*                                      |

## get

Retrieve a single payment link by its ID.

### Example Usage

```java
package hello.world;

import com.mollie.mollie.Mollie;
import com.mollie.mollie.models.errors.GetPaymentLinkResponseBody;
import com.mollie.mollie.models.operations.GetPaymentLinkResponse;
import com.mollie.mollie.models.operations.GetPaymentLinkSecurity;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws GetPaymentLinkResponseBody, Exception {

        Mollie sdk = Mollie.builder()
            .build();

        GetPaymentLinkResponse res = sdk.paymentLinksAPI().get()
                .security(GetPaymentLinkSecurity.builder()
                    .apiKey("<YOUR_BEARER_TOKEN_HERE>")
                    .build())
                .id("pl_4Y0eZitmBnQ6IDoMqZQKh")
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
| `security`                                                                                                                                                                                                                                                                                                                                                                             | [com.mollie.mollie.models.operations.GetPaymentLinkSecurity](../../models/operations/GetPaymentLinkSecurity.md)                                                                                                                                                                                                                                                                        | :heavy_check_mark:                                                                                                                                                                                                                                                                                                                                                                     | The security requirements to use for the request.                                                                                                                                                                                                                                                                                                                                      |                                                                                                                                                                                                                                                                                                                                                                                        |
| `id`                                                                                                                                                                                                                                                                                                                                                                                   | *String*                                                                                                                                                                                                                                                                                                                                                                               | :heavy_check_mark:                                                                                                                                                                                                                                                                                                                                                                     | Provide the ID of the item you want to perform this operation on.                                                                                                                                                                                                                                                                                                                      | pl_4Y0eZitmBnQ6IDoMqZQKh                                                                                                                                                                                                                                                                                                                                                               |
| `testmode`                                                                                                                                                                                                                                                                                                                                                                             | *JsonNullable\<Boolean>*                                                                                                                                                                                                                                                                                                                                                               | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                     | Most API credentials are specifically created for either live mode or test mode. In those cases the `testmode` query<br/>parameter can be omitted. For organization-level credentials such as OAuth access tokens, you can enable test mode by<br/>setting the `testmode` query parameter to `true`.<br/><br/>Test entities cannot be retrieved when the endpoint is set to live mode, and vice versa. | false                                                                                                                                                                                                                                                                                                                                                                                  |

### Response

**[GetPaymentLinkResponse](../../models/operations/GetPaymentLinkResponse.md)**

### Errors

| Error Type                               | Status Code                              | Content Type                             |
| ---------------------------------------- | ---------------------------------------- | ---------------------------------------- |
| models/errors/GetPaymentLinkResponseBody | 404                                      | application/hal+json                     |
| models/errors/APIException               | 4XX, 5XX                                 | \*/\*                                    |

## update

Certain details of an existing payment link can be updated.

### Example Usage

```java
package hello.world;

import com.mollie.mollie.Mollie;
import com.mollie.mollie.models.errors.UpdatePaymentLinkPaymentLinksAPIResponseBody;
import com.mollie.mollie.models.errors.UpdatePaymentLinkResponseBody;
import com.mollie.mollie.models.operations.UpdatePaymentLinkRequestBody;
import com.mollie.mollie.models.operations.UpdatePaymentLinkResponse;
import com.mollie.mollie.models.operations.UpdatePaymentLinkSecurity;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws UpdatePaymentLinkResponseBody, UpdatePaymentLinkPaymentLinksAPIResponseBody, Exception {

        Mollie sdk = Mollie.builder()
            .build();

        UpdatePaymentLinkResponse res = sdk.paymentLinksAPI().update()
                .security(UpdatePaymentLinkSecurity.builder()
                    .apiKey("<YOUR_BEARER_TOKEN_HERE>")
                    .build())
                .id("pl_4Y0eZitmBnQ6IDoMqZQKh")
                .testmode(false)
                .requestBody(UpdatePaymentLinkRequestBody.builder()
                    .build())
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
| `security`                                                                                                                                                                                                                                                                                                                                                                             | [com.mollie.mollie.models.operations.UpdatePaymentLinkSecurity](../../models/operations/UpdatePaymentLinkSecurity.md)                                                                                                                                                                                                                                                                  | :heavy_check_mark:                                                                                                                                                                                                                                                                                                                                                                     | The security requirements to use for the request.                                                                                                                                                                                                                                                                                                                                      |                                                                                                                                                                                                                                                                                                                                                                                        |
| `id`                                                                                                                                                                                                                                                                                                                                                                                   | *String*                                                                                                                                                                                                                                                                                                                                                                               | :heavy_check_mark:                                                                                                                                                                                                                                                                                                                                                                     | Provide the ID of the item you want to perform this operation on.                                                                                                                                                                                                                                                                                                                      | pl_4Y0eZitmBnQ6IDoMqZQKh                                                                                                                                                                                                                                                                                                                                                               |
| `testmode`                                                                                                                                                                                                                                                                                                                                                                             | *JsonNullable\<Boolean>*                                                                                                                                                                                                                                                                                                                                                               | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                     | Most API credentials are specifically created for either live mode or test mode. In those cases the `testmode` query<br/>parameter can be omitted. For organization-level credentials such as OAuth access tokens, you can enable test mode by<br/>setting the `testmode` query parameter to `true`.<br/><br/>Test entities cannot be retrieved when the endpoint is set to live mode, and vice versa. | false                                                                                                                                                                                                                                                                                                                                                                                  |
| `requestBody`                                                                                                                                                                                                                                                                                                                                                                          | [Optional\<UpdatePaymentLinkRequestBody>](../../models/operations/UpdatePaymentLinkRequestBody.md)                                                                                                                                                                                                                                                                                     | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                     | N/A                                                                                                                                                                                                                                                                                                                                                                                    |                                                                                                                                                                                                                                                                                                                                                                                        |

### Response

**[UpdatePaymentLinkResponse](../../models/operations/UpdatePaymentLinkResponse.md)**

### Errors

| Error Type                                                 | Status Code                                                | Content Type                                               |
| ---------------------------------------------------------- | ---------------------------------------------------------- | ---------------------------------------------------------- |
| models/errors/UpdatePaymentLinkResponseBody                | 404                                                        | application/hal+json                                       |
| models/errors/UpdatePaymentLinkPaymentLinksAPIResponseBody | 422                                                        | application/hal+json                                       |
| models/errors/APIException                                 | 4XX, 5XX                                                   | \*/\*                                                      |

## delete

Payment links which have not been opened and no payments have been made yet can be deleted entirely.
This can be useful for removing payment links that have been incorrectly configured or that are no longer relevant.

Once deleted, the payment link will no longer show up in the API or Mollie dashboard.

To simply disable a payment link without fully deleting it, you can use the `archived` parameter on the
[Update payment link](update-payment-link) endpoint instead.

### Example Usage

```java
package hello.world;

import com.mollie.mollie.Mollie;
import com.mollie.mollie.models.errors.DeletePaymentLinkPaymentLinksAPIResponseBody;
import com.mollie.mollie.models.errors.DeletePaymentLinkResponseBody;
import com.mollie.mollie.models.operations.DeletePaymentLinkResponse;
import com.mollie.mollie.models.operations.DeletePaymentLinkSecurity;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws DeletePaymentLinkResponseBody, DeletePaymentLinkPaymentLinksAPIResponseBody, Exception {

        Mollie sdk = Mollie.builder()
            .build();

        DeletePaymentLinkResponse res = sdk.paymentLinksAPI().delete()
                .security(DeletePaymentLinkSecurity.builder()
                    .apiKey("<YOUR_BEARER_TOKEN_HERE>")
                    .build())
                .id("pl_4Y0eZitmBnQ6IDoMqZQKh")
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
| `security`                                                                                                                                                                                                                                                                                                                                                                             | [com.mollie.mollie.models.operations.DeletePaymentLinkSecurity](../../models/operations/DeletePaymentLinkSecurity.md)                                                                                                                                                                                                                                                                  | :heavy_check_mark:                                                                                                                                                                                                                                                                                                                                                                     | The security requirements to use for the request.                                                                                                                                                                                                                                                                                                                                      |                                                                                                                                                                                                                                                                                                                                                                                        |
| `id`                                                                                                                                                                                                                                                                                                                                                                                   | *String*                                                                                                                                                                                                                                                                                                                                                                               | :heavy_check_mark:                                                                                                                                                                                                                                                                                                                                                                     | Provide the ID of the item you want to perform this operation on.                                                                                                                                                                                                                                                                                                                      | pl_4Y0eZitmBnQ6IDoMqZQKh                                                                                                                                                                                                                                                                                                                                                               |
| `testmode`                                                                                                                                                                                                                                                                                                                                                                             | *JsonNullable\<Boolean>*                                                                                                                                                                                                                                                                                                                                                               | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                     | Most API credentials are specifically created for either live mode or test mode. In those cases the `testmode` query<br/>parameter can be omitted. For organization-level credentials such as OAuth access tokens, you can enable test mode by<br/>setting the `testmode` query parameter to `true`.<br/><br/>Test entities cannot be retrieved when the endpoint is set to live mode, and vice versa. | false                                                                                                                                                                                                                                                                                                                                                                                  |

### Response

**[DeletePaymentLinkResponse](../../models/operations/DeletePaymentLinkResponse.md)**

### Errors

| Error Type                                                 | Status Code                                                | Content Type                                               |
| ---------------------------------------------------------- | ---------------------------------------------------------- | ---------------------------------------------------------- |
| models/errors/DeletePaymentLinkResponseBody                | 404                                                        | application/hal+json                                       |
| models/errors/DeletePaymentLinkPaymentLinksAPIResponseBody | 422                                                        | application/hal+json                                       |
| models/errors/APIException                                 | 4XX, 5XX                                                   | \*/\*                                                      |

## getPayments

Retrieve the list of payments for a specific payment link.

The results are paginated.

### Example Usage

```java
package hello.world;

import com.mollie.mollie.Mollie;
import com.mollie.mollie.models.errors.GetPaymentLinkPaymentsResponseBody;
import com.mollie.mollie.models.operations.GetPaymentLinkPaymentsRequest;
import com.mollie.mollie.models.operations.GetPaymentLinkPaymentsResponse;
import com.mollie.mollie.models.operations.GetPaymentLinkPaymentsSecurity;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws GetPaymentLinkPaymentsResponseBody, Exception {

        Mollie sdk = Mollie.builder()
            .build();

        GetPaymentLinkPaymentsRequest req = GetPaymentLinkPaymentsRequest.builder()
                .id("pl_4Y0eZitmBnQ6IDoMqZQKh")
                .from("tr_5B8cwPMGnU6qLbRvo7qEZo")
                .build();

        GetPaymentLinkPaymentsResponse res = sdk.paymentLinksAPI().getPayments()
                .request(req)
                .security(GetPaymentLinkPaymentsSecurity.builder()
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

| Parameter                                                                                                                       | Type                                                                                                                            | Required                                                                                                                        | Description                                                                                                                     |
| ------------------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------- |
| `request`                                                                                                                       | [GetPaymentLinkPaymentsRequest](../../models/operations/GetPaymentLinkPaymentsRequest.md)                                       | :heavy_check_mark:                                                                                                              | The request object to use for the request.                                                                                      |
| `security`                                                                                                                      | [com.mollie.mollie.models.operations.GetPaymentLinkPaymentsSecurity](../../models/operations/GetPaymentLinkPaymentsSecurity.md) | :heavy_check_mark:                                                                                                              | The security requirements to use for the request.                                                                               |

### Response

**[GetPaymentLinkPaymentsResponse](../../models/operations/GetPaymentLinkPaymentsResponse.md)**

### Errors

| Error Type                                       | Status Code                                      | Content Type                                     |
| ------------------------------------------------ | ------------------------------------------------ | ------------------------------------------------ |
| models/errors/GetPaymentLinkPaymentsResponseBody | 400                                              | application/hal+json                             |
| models/errors/APIException                       | 4XX, 5XX                                         | \*/\*                                            |