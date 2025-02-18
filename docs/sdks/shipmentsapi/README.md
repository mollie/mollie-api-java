# ShipmentsAPI
(*shipmentsAPI()*)

## Overview

### Available Operations

* [createShipment](#createshipment) - Create shipment
* [listShipments](#listshipments) - List shipments
* [getShipment](#getshipment) - Get shipment
* [updateShipment](#updateshipment) - Update shipment

## createShipment

**⚠️ We no longer recommend implementing the Shipments API. Please refer to the Captures API instead. We are actively working on adding support for line-specific captures to the Captures API.**

Create a shipment for specific order lines of an order.

When using Klarna, using this endpoint is mandatory for the order amount to be captured. A [capture](get-capture) will automatically be created for the shipment.

The word 'shipment' is used in the figurative sense here. It can also mean that a service was provided or digital content was delivered.

> 🔑 Access with
>
> [API key](/reference/authentication)
>
> [Access token with **shipments.write**](/reference/authentication)

### Example Usage

```java
package hello.world;

import com.mollie.mollie.Mollie;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.CreateShipmentResponseBody;
import com.mollie.mollie.models.errors.CreateShipmentShipmentsAPIResponseBody;
import com.mollie.mollie.models.operations.CreateShipmentAmount;
import com.mollie.mollie.models.operations.CreateShipmentLines;
import com.mollie.mollie.models.operations.CreateShipmentRequestBody;
import com.mollie.mollie.models.operations.CreateShipmentResponse;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws CreateShipmentResponseBody, CreateShipmentShipmentsAPIResponseBody, Exception {

        Mollie sdk = Mollie.builder()
                .security(Security.builder()
                    .apiKey("<YOUR_BEARER_TOKEN_HERE>")
                    .build())
            .build();

        CreateShipmentResponse res = sdk.shipmentsAPI().createShipment()
                .orderId("ord_pbjz8x")
                .requestBody(CreateShipmentRequestBody.builder()
                    .lines(List.of(
                        CreateShipmentLines.builder()
                            .amount(CreateShipmentAmount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .build(),
                        CreateShipmentLines.builder()
                            .amount(CreateShipmentAmount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .build()))
                    .build())
                .call();

        // handle response
    }
}
```

### Parameters

| Parameter                                                                                    | Type                                                                                         | Required                                                                                     | Description                                                                                  | Example                                                                                      |
| -------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------- |
| `orderId`                                                                                    | *String*                                                                                     | :heavy_check_mark:                                                                           | Provide the ID of the related order.                                                         | ord_pbjz8x                                                                                   |
| `requestBody`                                                                                | [Optional\<CreateShipmentRequestBody>](../../models/operations/CreateShipmentRequestBody.md) | :heavy_minus_sign:                                                                           | N/A                                                                                          |                                                                                              |

### Response

**[CreateShipmentResponse](../../models/operations/CreateShipmentResponse.md)**

### Errors

| Error Type                                           | Status Code                                          | Content Type                                         |
| ---------------------------------------------------- | ---------------------------------------------------- | ---------------------------------------------------- |
| models/errors/CreateShipmentResponseBody             | 404                                                  | application/hal+json                                 |
| models/errors/CreateShipmentShipmentsAPIResponseBody | 422                                                  | application/hal+json                                 |
| models/errors/APIException                           | 4XX, 5XX                                             | \*/\*                                                |

## listShipments

**⚠️ We no longer recommend implementing the Shipments API. Please refer to the Captures API instead. We are actively working on adding support for line-specific captures to the Captures API.**

Retrieve a list of all shipments created for a specific order.

The results are paginated.

> 🔑 Access with
>
> [API key](/reference/authentication)
>
> [Access token with **shipments.read**](/reference/authentication)

### Example Usage

```java
package hello.world;

import com.mollie.mollie.Mollie;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.ListShipmentsResponseBody;
import com.mollie.mollie.models.errors.ListShipmentsShipmentsAPIResponseBody;
import com.mollie.mollie.models.operations.ListShipmentsResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ListShipmentsResponseBody, ListShipmentsShipmentsAPIResponseBody, Exception {

        Mollie sdk = Mollie.builder()
                .security(Security.builder()
                    .apiKey("<YOUR_BEARER_TOKEN_HERE>")
                    .build())
            .build();

        ListShipmentsResponse res = sdk.shipmentsAPI().listShipments()
                .orderId("ord_pbjz8x")
                .from("shp_3wmsgCJN4U")
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
| `orderId`                                                                                                                                                                                                                                                                                                                                                                              | *String*                                                                                                                                                                                                                                                                                                                                                                               | :heavy_check_mark:                                                                                                                                                                                                                                                                                                                                                                     | Provide the ID of the related order.                                                                                                                                                                                                                                                                                                                                                   | ord_pbjz8x                                                                                                                                                                                                                                                                                                                                                                             |
| `from`                                                                                                                                                                                                                                                                                                                                                                                 | *Optional\<String>*                                                                                                                                                                                                                                                                                                                                                                    | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                     | Provide an ID to start the result set from the item with the given ID and onwards. This allows you to paginate the result set.                                                                                                                                                                                                                                                         | shp_3wmsgCJN4U                                                                                                                                                                                                                                                                                                                                                                         |
| `limit`                                                                                                                                                                                                                                                                                                                                                                                | *JsonNullable\<Long>*                                                                                                                                                                                                                                                                                                                                                                  | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                     | The maximum number of items to return. Defaults to 50 items.                                                                                                                                                                                                                                                                                                                           | 50                                                                                                                                                                                                                                                                                                                                                                                     |
| `testmode`                                                                                                                                                                                                                                                                                                                                                                             | *JsonNullable\<Boolean>*                                                                                                                                                                                                                                                                                                                                                               | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                     | Most API credentials are specifically created for either live mode or test mode. In those cases the `testmode` query parameter can be omitted. For organization-level credentials such as OAuth access tokens, you can enable test mode by setting the `testmode` query parameter to `true`.<br/><br/>Test entities cannot be retrieved when the endpoint is set to live mode, and vice versa. | false                                                                                                                                                                                                                                                                                                                                                                                  |

### Response

**[ListShipmentsResponse](../../models/operations/ListShipmentsResponse.md)**

### Errors

| Error Type                                          | Status Code                                         | Content Type                                        |
| --------------------------------------------------- | --------------------------------------------------- | --------------------------------------------------- |
| models/errors/ListShipmentsResponseBody             | 400                                                 | application/hal+json                                |
| models/errors/ListShipmentsShipmentsAPIResponseBody | 404                                                 | application/hal+json                                |
| models/errors/APIException                          | 4XX, 5XX                                            | \*/\*                                               |

## getShipment

**⚠️ We no longer recommend implementing the Shipments API. Please refer to the Captures API instead. We are actively working on adding support for line-specific captures to the Captures API.**

Retrieve a single shipment by its ID and the ID of its parent order.

> 🔑 Access with
>
> [API key](/reference/authentication)
>
> [Access token with **shipments.read**](/reference/authentication)

### Example Usage

```java
package hello.world;

import com.mollie.mollie.Mollie;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.GetShipmentResponseBody;
import com.mollie.mollie.models.operations.GetShipmentResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws GetShipmentResponseBody, Exception {

        Mollie sdk = Mollie.builder()
                .security(Security.builder()
                    .apiKey("<YOUR_BEARER_TOKEN_HERE>")
                    .build())
            .build();

        GetShipmentResponse res = sdk.shipmentsAPI().getShipment()
                .orderId("ord_pbjz8x")
                .id("shp_3wmsgCJN4U")
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
| `orderId`                                                                                                                                                                                                                                                                                                                                                                              | *String*                                                                                                                                                                                                                                                                                                                                                                               | :heavy_check_mark:                                                                                                                                                                                                                                                                                                                                                                     | Provide the ID of the related order.                                                                                                                                                                                                                                                                                                                                                   | ord_pbjz8x                                                                                                                                                                                                                                                                                                                                                                             |
| `id`                                                                                                                                                                                                                                                                                                                                                                                   | *String*                                                                                                                                                                                                                                                                                                                                                                               | :heavy_check_mark:                                                                                                                                                                                                                                                                                                                                                                     | Provide the ID of the item you want to perform this operation on.                                                                                                                                                                                                                                                                                                                      | shp_3wmsgCJN4U                                                                                                                                                                                                                                                                                                                                                                         |
| `testmode`                                                                                                                                                                                                                                                                                                                                                                             | *JsonNullable\<Boolean>*                                                                                                                                                                                                                                                                                                                                                               | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                     | Most API credentials are specifically created for either live mode or test mode. In those cases the `testmode` query parameter can be omitted. For organization-level credentials such as OAuth access tokens, you can enable test mode by setting the `testmode` query parameter to `true`.<br/><br/>Test entities cannot be retrieved when the endpoint is set to live mode, and vice versa. | false                                                                                                                                                                                                                                                                                                                                                                                  |

### Response

**[GetShipmentResponse](../../models/operations/GetShipmentResponse.md)**

### Errors

| Error Type                            | Status Code                           | Content Type                          |
| ------------------------------------- | ------------------------------------- | ------------------------------------- |
| models/errors/GetShipmentResponseBody | 404                                   | application/hal+json                  |
| models/errors/APIException            | 4XX, 5XX                              | \*/\*                                 |

## updateShipment

**⚠️ We no longer recommend implementing the Shipments API. Please refer to the Captures API instead. We are actively working on adding support for line-specific captures to the Captures API.**

Update the tracking information on a shipment.

For an in-depth explanation of each parameter, refer to the [Create shipment](create-shipment) endpoint.

> 🔑 Access with
>
> [API key](/reference/authentication)
>
> [Access token with **shipments.write**](/reference/authentication)

### Example Usage

```java
package hello.world;

import com.mollie.mollie.Mollie;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.UpdateShipmentResponseBody;
import com.mollie.mollie.models.operations.UpdateShipmentRequestBody;
import com.mollie.mollie.models.operations.UpdateShipmentResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws UpdateShipmentResponseBody, Exception {

        Mollie sdk = Mollie.builder()
                .security(Security.builder()
                    .apiKey("<YOUR_BEARER_TOKEN_HERE>")
                    .build())
            .build();

        UpdateShipmentResponse res = sdk.shipmentsAPI().updateShipment()
                .orderId("ord_pbjz8x")
                .id("shp_3wmsgCJN4U")
                .testmode(false)
                .requestBody(UpdateShipmentRequestBody.builder()
                    .build())
                .call();

        // handle response
    }
}
```

### Parameters

| Parameter                                                                                                                                                                                                                                                                                                                                                                              | Type                                                                                                                                                                                                                                                                                                                                                                                   | Required                                                                                                                                                                                                                                                                                                                                                                               | Description                                                                                                                                                                                                                                                                                                                                                                            | Example                                                                                                                                                                                                                                                                                                                                                                                |
| -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `orderId`                                                                                                                                                                                                                                                                                                                                                                              | *String*                                                                                                                                                                                                                                                                                                                                                                               | :heavy_check_mark:                                                                                                                                                                                                                                                                                                                                                                     | Provide the ID of the related order.                                                                                                                                                                                                                                                                                                                                                   | ord_pbjz8x                                                                                                                                                                                                                                                                                                                                                                             |
| `id`                                                                                                                                                                                                                                                                                                                                                                                   | *String*                                                                                                                                                                                                                                                                                                                                                                               | :heavy_check_mark:                                                                                                                                                                                                                                                                                                                                                                     | Provide the ID of the item you want to perform this operation on.                                                                                                                                                                                                                                                                                                                      | shp_3wmsgCJN4U                                                                                                                                                                                                                                                                                                                                                                         |
| `testmode`                                                                                                                                                                                                                                                                                                                                                                             | *JsonNullable\<Boolean>*                                                                                                                                                                                                                                                                                                                                                               | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                     | Most API credentials are specifically created for either live mode or test mode. In those cases the `testmode` query parameter can be omitted. For organization-level credentials such as OAuth access tokens, you can enable test mode by setting the `testmode` query parameter to `true`.<br/><br/>Test entities cannot be retrieved when the endpoint is set to live mode, and vice versa. | false                                                                                                                                                                                                                                                                                                                                                                                  |
| `requestBody`                                                                                                                                                                                                                                                                                                                                                                          | [Optional\<UpdateShipmentRequestBody>](../../models/operations/UpdateShipmentRequestBody.md)                                                                                                                                                                                                                                                                                           | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                     | N/A                                                                                                                                                                                                                                                                                                                                                                                    |                                                                                                                                                                                                                                                                                                                                                                                        |

### Response

**[UpdateShipmentResponse](../../models/operations/UpdateShipmentResponse.md)**

### Errors

| Error Type                               | Status Code                              | Content Type                             |
| ---------------------------------------- | ---------------------------------------- | ---------------------------------------- |
| models/errors/UpdateShipmentResponseBody | 404                                      | application/hal+json                     |
| models/errors/APIException               | 4XX, 5XX                                 | \*/\*                                    |