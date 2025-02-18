# OrdersAPI
(*ordersAPI()*)

## Overview

### Available Operations

* [createOrder](#createorder) - Create order
* [listOrders](#listorders) - List orders
* [getOrder](#getorder) - Get order
* [updateOrder](#updateorder) - Update order
* [cancelOrder](#cancelorder) - Cancel order
* [manageOrderLines](#manageorderlines) - Manage order lines
* [cancelOrderLines](#cancelorderlines) - Cancel order lines
* [updateOrderLine](#updateorderline) - Update order line
* [createOrderPayment](#createorderpayment) - Create order payment

## createOrder

**⚠️ We no longer recommend implementing the Orders API. Please refer to the Payments API instead. We are actively working on adding support for Klarna, Billie, in3 and Vouchers to the Payments API later this year.**

When creating an order, a payment will automatically be created to allow your customer to pay for the order. You can then redirect your customer to the URL in the `_links.checkout` property from the response, similar to the Payments API.

Unlike the Payments API, if a payment fails, expires, or is canceled, you can create a new payment under the same order using the [Create order payment endpoint](create-order-payment). This is only possible for orders that still have the `created` status.

> 🔑 Access with
>
> [API key](/reference/authentication)
>
> [Access token with **orders.write**](/reference/authentication)

### Example Usage

```java
package hello.world;

import com.mollie.mollie.Mollie;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.CreateOrderResponseBody;
import com.mollie.mollie.models.operations.Amount;
import com.mollie.mollie.models.operations.BillingAddress;
import com.mollie.mollie.models.operations.CreateOrderRequestBody;
import com.mollie.mollie.models.operations.CreateOrderResponse;
import com.mollie.mollie.models.operations.DiscountAmount;
import com.mollie.mollie.models.operations.Lines;
import com.mollie.mollie.models.operations.TotalAmount;
import com.mollie.mollie.models.operations.UnitPrice;
import com.mollie.mollie.models.operations.VatAmount;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws CreateOrderResponseBody, Exception {

        Mollie sdk = Mollie.builder()
                .security(Security.builder()
                    .apiKey("<YOUR_BEARER_TOKEN_HERE>")
                    .build())
            .build();

        CreateOrderResponse res = sdk.ordersAPI().createOrder()
                .embed("payments")
                .requestBody(CreateOrderRequestBody.builder()
                    .orderNumber("<value>")
                    .lines(List.of(
                        Lines.builder()
                            .name("<value>")
                            .quantity(638424L)
                            .unitPrice(UnitPrice.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .totalAmount(TotalAmount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .type("physical")
                            .discountAmount(DiscountAmount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .vatAmount(VatAmount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .category("meal")
                            .build()))
                    .amount(Amount.builder()
                        .currency("EUR")
                        .value("10.00")
                        .build())
                    .billingAddress(BillingAddress.builder()
                        .streetAndNumber("<value>")
                        .city("Briaton")
                        .country("Seychelles")
                        .build())
                    .locale("lv_LV")
                    .profileId("pfl_QkEhN94Ba")
                    .build())
                .call();

        // handle response
    }
}
```

### Parameters

| Parameter                                                                                                                                                                              | Type                                                                                                                                                                                   | Required                                                                                                                                                                               | Description                                                                                                                                                                            | Example                                                                                                                                                                                |
| -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `embed`                                                                                                                                                                                | *JsonNullable\<String>*                                                                                                                                                                | :heavy_minus_sign:                                                                                                                                                                     | This endpoint allows embedding related API items by appending the following values via the `embed` query string parameter.<br/><br/>* `payments`: Include all payments created for this order. | payments                                                                                                                                                                               |
| `requestBody`                                                                                                                                                                          | [Optional\<CreateOrderRequestBody>](../../models/operations/CreateOrderRequestBody.md)                                                                                                 | :heavy_minus_sign:                                                                                                                                                                     | N/A                                                                                                                                                                                    |                                                                                                                                                                                        |

### Response

**[CreateOrderResponse](../../models/operations/CreateOrderResponse.md)**

### Errors

| Error Type                            | Status Code                           | Content Type                          |
| ------------------------------------- | ------------------------------------- | ------------------------------------- |
| models/errors/CreateOrderResponseBody | 422                                   | application/hal+json                  |
| models/errors/APIException            | 4XX, 5XX                              | \*/\*                                 |

## listOrders

**⚠️ We no longer recommend implementing the Orders API. Please refer to the Payments API instead. We are actively working on adding support for Klarna, Billie, in3 and Vouchers to the Payments API later this year.**

Retrieve all orders.

The results are paginated.

> 🔑 Access with
>
> [API key](/reference/authentication)
>
> [Access token with **orders.read**](/reference/authentication)

### Example Usage

```java
package hello.world;

import com.mollie.mollie.Mollie;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.ListOrdersResponseBody;
import com.mollie.mollie.models.operations.ListOrdersRequest;
import com.mollie.mollie.models.operations.ListOrdersResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ListOrdersResponseBody, Exception {

        Mollie sdk = Mollie.builder()
                .security(Security.builder()
                    .apiKey("<YOUR_BEARER_TOKEN_HERE>")
                    .build())
            .build();

        ListOrdersRequest req = ListOrdersRequest.builder()
                .from("ord_pbjz8x")
                .sort("desc")
                .profileId("pfl_QkEhN94Ba")
                .build();

        ListOrdersResponse res = sdk.ordersAPI().listOrders()
                .request(req)
                .call();

        if (res.object().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                         | Type                                                              | Required                                                          | Description                                                       |
| ----------------------------------------------------------------- | ----------------------------------------------------------------- | ----------------------------------------------------------------- | ----------------------------------------------------------------- |
| `request`                                                         | [ListOrdersRequest](../../models/operations/ListOrdersRequest.md) | :heavy_check_mark:                                                | The request object to use for the request.                        |

### Response

**[ListOrdersResponse](../../models/operations/ListOrdersResponse.md)**

### Errors

| Error Type                           | Status Code                          | Content Type                         |
| ------------------------------------ | ------------------------------------ | ------------------------------------ |
| models/errors/ListOrdersResponseBody | 400                                  | application/hal+json                 |
| models/errors/APIException           | 4XX, 5XX                             | \*/\*                                |

## getOrder

**⚠️ We no longer recommend implementing the Orders API. Please refer to the Payments API instead. We are actively working on adding support for Klarna, Billie, in3 and Vouchers to the Payments API later this year.**

Retrieve a single order object by its ID.

> 🔑 Access with
>
> [API key](/reference/authentication)
>
> [Access token with **orders.read**](/reference/authentication)

### Example Usage

```java
package hello.world;

import com.mollie.mollie.Mollie;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.GetOrderResponseBody;
import com.mollie.mollie.models.operations.GetOrderResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws GetOrderResponseBody, Exception {

        Mollie sdk = Mollie.builder()
                .security(Security.builder()
                    .apiKey("<YOUR_BEARER_TOKEN_HERE>")
                    .build())
            .build();

        GetOrderResponse res = sdk.ordersAPI().getOrder()
                .id("ord_vsKJpSsabw")
                .embed("payments")
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
| `id`                                                                                                                                                                                                                                                                                                                                                                                   | *String*                                                                                                                                                                                                                                                                                                                                                                               | :heavy_check_mark:                                                                                                                                                                                                                                                                                                                                                                     | Provide the ID of the item you want to perform this operation on.                                                                                                                                                                                                                                                                                                                      | ord_vsKJpSsabw                                                                                                                                                                                                                                                                                                                                                                         |
| `embed`                                                                                                                                                                                                                                                                                                                                                                                | *JsonNullable\<String>*                                                                                                                                                                                                                                                                                                                                                                | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                     | This endpoint allows embedding related API items by appending the following values via the `embed` query string parameter.<br/><br/>* `payments`: Include all payments created for this order.<br/>* `refunds`: Include all refunds created for this order.<br/>* `shipments`: Include all shipments created for this order.                                                           | payments                                                                                                                                                                                                                                                                                                                                                                               |
| `testmode`                                                                                                                                                                                                                                                                                                                                                                             | *JsonNullable\<Boolean>*                                                                                                                                                                                                                                                                                                                                                               | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                     | Most API credentials are specifically created for either live mode or test mode. In those cases the `testmode` query parameter can be omitted. For organization-level credentials such as OAuth access tokens, you can enable test mode by setting the `testmode` query parameter to `true`.<br/><br/>Test entities cannot be retrieved when the endpoint is set to live mode, and vice versa. | false                                                                                                                                                                                                                                                                                                                                                                                  |

### Response

**[GetOrderResponse](../../models/operations/GetOrderResponse.md)**

### Errors

| Error Type                         | Status Code                        | Content Type                       |
| ---------------------------------- | ---------------------------------- | ---------------------------------- |
| models/errors/GetOrderResponseBody | 404                                | application/hal+json               |
| models/errors/APIException         | 4XX, 5XX                           | \*/\*                              |

## updateOrder

**⚠️ We no longer recommend implementing the Orders API. Please refer to the Payments API instead. We are actively working on adding support for Klarna, Billie, in3 and Vouchers to the Payments API later this year.**

Certain details of an existing order can be updated.

For an in-depth explanation of each parameter, see [Create order](create-order).

> 🔑 Access with
>
> [API key](/reference/authentication)
>
> [Access token with **orders.write**](/reference/authentication)

### Example Usage

```java
package hello.world;

import com.mollie.mollie.Mollie;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.UpdateOrderOrdersAPIResponseBody;
import com.mollie.mollie.models.errors.UpdateOrderResponseBody;
import com.mollie.mollie.models.operations.UpdateOrderRequestBody;
import com.mollie.mollie.models.operations.UpdateOrderResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws UpdateOrderResponseBody, UpdateOrderOrdersAPIResponseBody, Exception {

        Mollie sdk = Mollie.builder()
                .security(Security.builder()
                    .apiKey("<YOUR_BEARER_TOKEN_HERE>")
                    .build())
            .build();

        UpdateOrderResponse res = sdk.ordersAPI().updateOrder()
                .id("ord_vsKJpSsabw")
                .requestBody(UpdateOrderRequestBody.builder()
                    .build())
                .call();

        // handle response
    }
}
```

### Parameters

| Parameter                                                                              | Type                                                                                   | Required                                                                               | Description                                                                            | Example                                                                                |
| -------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------- |
| `id`                                                                                   | *String*                                                                               | :heavy_check_mark:                                                                     | Provide the ID of the item you want to perform this operation on.                      | ord_vsKJpSsabw                                                                         |
| `requestBody`                                                                          | [Optional\<UpdateOrderRequestBody>](../../models/operations/UpdateOrderRequestBody.md) | :heavy_minus_sign:                                                                     | N/A                                                                                    |                                                                                        |

### Response

**[UpdateOrderResponse](../../models/operations/UpdateOrderResponse.md)**

### Errors

| Error Type                                     | Status Code                                    | Content Type                                   |
| ---------------------------------------------- | ---------------------------------------------- | ---------------------------------------------- |
| models/errors/UpdateOrderResponseBody          | 404                                            | application/hal+json                           |
| models/errors/UpdateOrderOrdersAPIResponseBody | 422                                            | application/hal+json                           |
| models/errors/APIException                     | 4XX, 5XX                                       | \*/\*                                          |

## cancelOrder

**⚠️ We no longer recommend implementing the Orders API. Please refer to the Payments API instead. We are actively working on adding support for Klarna, Billie, in3 and Vouchers to the Payments API later this year.**

An open order may be canceled if it does not have any open payments yet, and while its status is either `created`, `authorized`, or `shipping`.

If the order was already authorized, the authorization will be released.

For an order with status `shipping`, only the order lines that were still pending will be canceled if possible. If a payment method was used that does not support authorizations, cancelation is no longer possible. You will have to issue a refund instead.

> 🔑 Access with
>
> [API key](/reference/authentication)
>
> [Access token with **orders.write**](/reference/authentication)

### Example Usage

```java
package hello.world;

import com.mollie.mollie.Mollie;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.CancelOrderOrdersAPIResponseBody;
import com.mollie.mollie.models.errors.CancelOrderResponseBody;
import com.mollie.mollie.models.operations.CancelOrderResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws CancelOrderResponseBody, CancelOrderOrdersAPIResponseBody, Exception {

        Mollie sdk = Mollie.builder()
                .security(Security.builder()
                    .apiKey("<YOUR_BEARER_TOKEN_HERE>")
                    .build())
            .build();

        CancelOrderResponse res = sdk.ordersAPI().cancelOrder()
                .id("ord_vsKJpSsabw")
                .testmode(false)
                .call();

        // handle response
    }
}
```

### Parameters

| Parameter                                                                                                                                                                                                                                                                                                                                                                              | Type                                                                                                                                                                                                                                                                                                                                                                                   | Required                                                                                                                                                                                                                                                                                                                                                                               | Description                                                                                                                                                                                                                                                                                                                                                                            | Example                                                                                                                                                                                                                                                                                                                                                                                |
| -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `id`                                                                                                                                                                                                                                                                                                                                                                                   | *String*                                                                                                                                                                                                                                                                                                                                                                               | :heavy_check_mark:                                                                                                                                                                                                                                                                                                                                                                     | Provide the ID of the item you want to perform this operation on.                                                                                                                                                                                                                                                                                                                      | ord_vsKJpSsabw                                                                                                                                                                                                                                                                                                                                                                         |
| `testmode`                                                                                                                                                                                                                                                                                                                                                                             | *JsonNullable\<Boolean>*                                                                                                                                                                                                                                                                                                                                                               | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                     | Most API credentials are specifically created for either live mode or test mode. In those cases the `testmode` query parameter can be omitted. For organization-level credentials such as OAuth access tokens, you can enable test mode by setting the `testmode` query parameter to `true`.<br/><br/>Test entities cannot be retrieved when the endpoint is set to live mode, and vice versa. | false                                                                                                                                                                                                                                                                                                                                                                                  |

### Response

**[CancelOrderResponse](../../models/operations/CancelOrderResponse.md)**

### Errors

| Error Type                                     | Status Code                                    | Content Type                                   |
| ---------------------------------------------- | ---------------------------------------------- | ---------------------------------------------- |
| models/errors/CancelOrderResponseBody          | 404                                            | application/hal+json                           |
| models/errors/CancelOrderOrdersAPIResponseBody | 422                                            | application/hal+json                           |
| models/errors/APIException                     | 4XX, 5XX                                       | \*/\*                                          |

## manageOrderLines

**⚠️ We no longer recommend implementing the Orders API. Please refer to the Payments API instead. We are actively working on adding support for Klarna, Billie, in3 and Vouchers to the Payments API later this year.**

Use this endpoint to update, cancel, or add one or more order lines of a `created`, `pending`, or `authorized` order.

For an already authorized order, updating the order lines will trigger an additional authorization request to the payment method provider.

For example, your customer placed an order that contains two order lines:

* Order line A contains two items and amounts to €100.00.
* Order line B contains a discount of 10% applicable to the items in order line A, which amounts to -€10.00.

The order total is €90.00.

You only have one item of type A left, and therefore contact your customer to find another solution. The customer opts to replace one of order line A's items with item C. Item C costs €40.00, however, discount B does not apply to item C.

Using this endpoint, you can create a request to update the order lines, where:

* Order line A is updated to quantity 1.
* Order line B is updated to discount amount -€5.00.
* Order line C is added with amount €40.00.

The updated order totals €85.00.

> 🔑 Access with
>
> [API key](/reference/authentication)
>
> [Access token with **orders.write**](/reference/authentication)

### Example Usage

```java
package hello.world;

import com.mollie.mollie.Mollie;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.ManageOrderLinesResponseBody;
import com.mollie.mollie.models.operations.ManageOrderLinesRequestBody;
import com.mollie.mollie.models.operations.ManageOrderLinesResponse;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws ManageOrderLinesResponseBody, Exception {

        Mollie sdk = Mollie.builder()
                .security(Security.builder()
                    .apiKey("<YOUR_BEARER_TOKEN_HERE>")
                    .build())
            .build();

        ManageOrderLinesResponse res = sdk.ordersAPI().manageOrderLines()
                .orderId("ord_pbjz8x")
                .requestBody(ManageOrderLinesRequestBody.builder()
                    .operations(List.of(
                    ))
                    .build())
                .call();

        // handle response
    }
}
```

### Parameters

| Parameter                                                                                        | Type                                                                                             | Required                                                                                         | Description                                                                                      | Example                                                                                          |
| ------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------ |
| `orderId`                                                                                        | *String*                                                                                         | :heavy_check_mark:                                                                               | Provide the ID of the related order.                                                             | ord_pbjz8x                                                                                       |
| `requestBody`                                                                                    | [Optional\<ManageOrderLinesRequestBody>](../../models/operations/ManageOrderLinesRequestBody.md) | :heavy_minus_sign:                                                                               | N/A                                                                                              |                                                                                                  |

### Response

**[ManageOrderLinesResponse](../../models/operations/ManageOrderLinesResponse.md)**

### Errors

| Error Type                                 | Status Code                                | Content Type                               |
| ------------------------------------------ | ------------------------------------------ | ------------------------------------------ |
| models/errors/ManageOrderLinesResponseBody | 404                                        | application/hal+json                       |
| models/errors/APIException                 | 4XX, 5XX                                   | \*/\*                                      |

## cancelOrderLines

**⚠️ We no longer recommend implementing the Orders API. Please refer to the Payments API instead. We are actively working on adding support for Klarna, Billie, in3 and Vouchers to the Payments API later this year.**

Cancel one or more order lines that were previously authorized. To cancel the entire order, please refer to the [Cancel order](cancel-order) endpoint instead.

Canceling or partially canceling an order line will immediately release the authorization held for that amount. You should cancel an order line if you do not intend to (fully) ship it.

If the order line was already authorized, the authorization will be released.

For an order line with status `shipping`, the authorization for the quantity that is still pending will be released.

Afterwards, the order line will be marked `completed`.

If the order line is `paid` or already `completed`, you can create a refund using the [Create order refund](create-order-refund) endpoint instead.

> 🔑 Access with
>
> [API key](/reference/authentication)
>
> [Access token with **orders.write**](/reference/authentication)

### Example Usage

```java
package hello.world;

import com.mollie.mollie.Mollie;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.CancelOrderLinesOrdersAPIResponseBody;
import com.mollie.mollie.models.errors.CancelOrderLinesResponseBody;
import com.mollie.mollie.models.operations.CancelOrderLinesAmount;
import com.mollie.mollie.models.operations.CancelOrderLinesLines;
import com.mollie.mollie.models.operations.CancelOrderLinesRequestBody;
import com.mollie.mollie.models.operations.CancelOrderLinesResponse;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws CancelOrderLinesResponseBody, CancelOrderLinesOrdersAPIResponseBody, Exception {

        Mollie sdk = Mollie.builder()
                .security(Security.builder()
                    .apiKey("<YOUR_BEARER_TOKEN_HERE>")
                    .build())
            .build();

        CancelOrderLinesResponse res = sdk.ordersAPI().cancelOrderLines()
                .orderId("ord_pbjz8x")
                .requestBody(CancelOrderLinesRequestBody.builder()
                    .lines(List.of(
                        CancelOrderLinesLines.builder()
                            .id("<id>")
                            .amount(CancelOrderLinesAmount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .build(),
                        CancelOrderLinesLines.builder()
                            .id("<id>")
                            .amount(CancelOrderLinesAmount.builder()
                                .currency("EUR")
                                .value("10.00")
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

| Parameter                                                                                        | Type                                                                                             | Required                                                                                         | Description                                                                                      | Example                                                                                          |
| ------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------ |
| `orderId`                                                                                        | *String*                                                                                         | :heavy_check_mark:                                                                               | Provide the ID of the related order.                                                             | ord_pbjz8x                                                                                       |
| `requestBody`                                                                                    | [Optional\<CancelOrderLinesRequestBody>](../../models/operations/CancelOrderLinesRequestBody.md) | :heavy_minus_sign:                                                                               | N/A                                                                                              |                                                                                                  |

### Response

**[CancelOrderLinesResponse](../../models/operations/CancelOrderLinesResponse.md)**

### Errors

| Error Type                                          | Status Code                                         | Content Type                                        |
| --------------------------------------------------- | --------------------------------------------------- | --------------------------------------------------- |
| models/errors/CancelOrderLinesResponseBody          | 404                                                 | application/hal+json                                |
| models/errors/CancelOrderLinesOrdersAPIResponseBody | 422                                                 | application/hal+json                                |
| models/errors/APIException                          | 4XX, 5XX                                            | \*/\*                                               |

## updateOrderLine

**⚠️ We no longer recommend implementing the Orders API. Please refer to the Payments API instead. We are actively working on adding support for Klarna, Billie, in3 and Vouchers to the Payments API later this year.**

Update an order line belonging to an order. Only lines with status `created`, `pending`, or `authorized` can be updated.

This endpoint is useful for cases where specific details of an order line are changed. For example, if a customer changes a red shirt for a blue one of the same model. In this case only specific properties of the order line need to be updated, such as the `name`, the `imageUrl`, and perhaps the `amount`.

To swap out an order line for an entirely new order line, use the [Manage order lines](manage-order-lines) endpoint instead.

For an in-depth explanation of each parameter, refer to the `lines` parameter of the [Create order](create-order) endpoint.

> 🔑 Access with
>
> [API key](/reference/authentication)
>
> [Access token with **orders.write**](/reference/authentication)

### Example Usage

```java
package hello.world;

import com.mollie.mollie.Mollie;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.UpdateOrderLineOrdersAPIResponseBody;
import com.mollie.mollie.models.errors.UpdateOrderLineResponseBody;
import com.mollie.mollie.models.operations.UpdateOrderLineDiscountAmount;
import com.mollie.mollie.models.operations.UpdateOrderLineRequestBody;
import com.mollie.mollie.models.operations.UpdateOrderLineResponse;
import com.mollie.mollie.models.operations.UpdateOrderLineTotalAmount;
import com.mollie.mollie.models.operations.UpdateOrderLineUnitPrice;
import com.mollie.mollie.models.operations.UpdateOrderLineVatAmount;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws UpdateOrderLineResponseBody, UpdateOrderLineOrdersAPIResponseBody, Exception {

        Mollie sdk = Mollie.builder()
                .security(Security.builder()
                    .apiKey("<YOUR_BEARER_TOKEN_HERE>")
                    .build())
            .build();

        UpdateOrderLineResponse res = sdk.ordersAPI().updateOrderLine()
                .orderId("ord_pbjz8x")
                .id("odl_dgtxyl")
                .requestBody(UpdateOrderLineRequestBody.builder()
                    .unitPrice(UpdateOrderLineUnitPrice.builder()
                        .currency("EUR")
                        .value("10.00")
                        .build())
                    .discountAmount(UpdateOrderLineDiscountAmount.builder()
                        .currency("EUR")
                        .value("10.00")
                        .build())
                    .totalAmount(UpdateOrderLineTotalAmount.builder()
                        .currency("EUR")
                        .value("10.00")
                        .build())
                    .vatAmount(UpdateOrderLineVatAmount.builder()
                        .currency("EUR")
                        .value("10.00")
                        .build())
                    .build())
                .call();

        // handle response
    }
}
```

### Parameters

| Parameter                                                                                      | Type                                                                                           | Required                                                                                       | Description                                                                                    | Example                                                                                        |
| ---------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------- |
| `orderId`                                                                                      | *String*                                                                                       | :heavy_check_mark:                                                                             | Provide the ID of the related order.                                                           | ord_pbjz8x                                                                                     |
| `id`                                                                                           | *String*                                                                                       | :heavy_check_mark:                                                                             | Provide the ID of the item you want to perform this operation on.                              | odl_dgtxyl                                                                                     |
| `requestBody`                                                                                  | [Optional\<UpdateOrderLineRequestBody>](../../models/operations/UpdateOrderLineRequestBody.md) | :heavy_minus_sign:                                                                             | N/A                                                                                            |                                                                                                |

### Response

**[UpdateOrderLineResponse](../../models/operations/UpdateOrderLineResponse.md)**

### Errors

| Error Type                                         | Status Code                                        | Content Type                                       |
| -------------------------------------------------- | -------------------------------------------------- | -------------------------------------------------- |
| models/errors/UpdateOrderLineResponseBody          | 404                                                | application/hal+json                               |
| models/errors/UpdateOrderLineOrdersAPIResponseBody | 422                                                | application/hal+json                               |
| models/errors/APIException                         | 4XX, 5XX                                           | \*/\*                                              |

## createOrderPayment

**⚠️ We no longer recommend implementing the Orders API. Please refer to the Payments API instead. We are actively working on adding support for Klarna, Billie, in3 and Vouchers to the Payments API later this year.**

An order has an automatically created payment that your customer can use to pay for the order. When the payment expires you can create a new payment for the order using this endpoint. A maximum of 25 payments can be created for an order.

A new payment can only be created while the status of the order is `created`, and when the status of the existing payment is either `expired`, `canceled` or `failed`.

The endpoint accepts virtually all parameters accepted by the regular [Create payment](create-payment) endpoint. Please refer to that endpoint for the full documentation of all parameters.

The payment inherits certain properties, such as the `amount` and `webhookUrl`, directly from the order. These cannot be changed via this endpoint.

> 🔑 Access with
>
> [API key](/reference/authentication)
>
> [Access token with **payments.write**](/reference/authentication)

### Example Usage

```java
package hello.world;

import com.mollie.mollie.Mollie;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.CreateOrderPaymentResponseBody;
import com.mollie.mollie.models.operations.CreateOrderPaymentResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws CreateOrderPaymentResponseBody, Exception {

        Mollie sdk = Mollie.builder()
                .security(Security.builder()
                    .apiKey("<YOUR_BEARER_TOKEN_HERE>")
                    .build())
            .build();

        CreateOrderPaymentResponse res = sdk.ordersAPI().createOrderPayment()
                .orderId("ord_pbjz8x")
                .requestBody("<value>")
                .call();

        // handle response
    }
}
```

### Parameters

| Parameter                            | Type                                 | Required                             | Description                          | Example                              |
| ------------------------------------ | ------------------------------------ | ------------------------------------ | ------------------------------------ | ------------------------------------ |
| `orderId`                            | *String*                             | :heavy_check_mark:                   | Provide the ID of the related order. | ord_pbjz8x                           |
| `requestBody`                        | *Optional\<Object>*                  | :heavy_minus_sign:                   | N/A                                  |                                      |

### Response

**[CreateOrderPaymentResponse](../../models/operations/CreateOrderPaymentResponse.md)**

### Errors

| Error Type                                   | Status Code                                  | Content Type                                 |
| -------------------------------------------- | -------------------------------------------- | -------------------------------------------- |
| models/errors/CreateOrderPaymentResponseBody | 404                                          | application/hal+json                         |
| models/errors/APIException                   | 4XX, 5XX                                     | \*/\*                                        |