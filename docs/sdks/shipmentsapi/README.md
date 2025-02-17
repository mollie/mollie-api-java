# ShipmentsAPI
(*shipmentsAPI()*)

## Overview

### Available Operations

* [create](#create) - Create shipment
* [list](#list) - List shipments
* [get](#get) - Get shipment
* [update](#update) - Update shipment

## create

**⚠️ We no longer recommend implementing the Shipments API. Please refer to the Captures API instead. We are
actively working on adding support for line-specific captures to the Captures API.**

Create a shipment for specific order lines of an order.

When using Klarna, using this endpoint is mandatory for the order amount to be captured. A [capture](get-capture)
will automatically be created for the shipment.

The word 'shipment' is used in the figurative sense here. It can also mean that a service was provided or digital
content was delivered.

### Example Usage

```java
package hello.world;

import com.mollie.mollie.Mollie;
import com.mollie.mollie.models.errors.CreateShipmentResponseBody;
import com.mollie.mollie.models.errors.CreateShipmentShipmentsAPIResponseBody;
import com.mollie.mollie.models.operations.CreateShipmentAmount;
import com.mollie.mollie.models.operations.CreateShipmentLines;
import com.mollie.mollie.models.operations.CreateShipmentRequestBody;
import com.mollie.mollie.models.operations.CreateShipmentResponse;
import com.mollie.mollie.models.operations.CreateShipmentSecurity;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws CreateShipmentResponseBody, CreateShipmentShipmentsAPIResponseBody, Exception {

        Mollie sdk = Mollie.builder()
            .build();

        CreateShipmentResponse res = sdk.shipmentsAPI().create()
                .security(CreateShipmentSecurity.builder()
                    .apiKey("<YOUR_BEARER_TOKEN_HERE>")
                    .build())
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

        if (res.any().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                       | Type                                                                                                            | Required                                                                                                        | Description                                                                                                     | Example                                                                                                         |
| --------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------- |
| `security`                                                                                                      | [com.mollie.mollie.models.operations.CreateShipmentSecurity](../../models/operations/CreateShipmentSecurity.md) | :heavy_check_mark:                                                                                              | The security requirements to use for the request.                                                               |                                                                                                                 |
| `orderId`                                                                                                       | *String*                                                                                                        | :heavy_check_mark:                                                                                              | Provide the ID of the related order.                                                                            | ord_pbjz8x                                                                                                      |
| `requestBody`                                                                                                   | [Optional\<CreateShipmentRequestBody>](../../models/operations/CreateShipmentRequestBody.md)                    | :heavy_minus_sign:                                                                                              | N/A                                                                                                             |                                                                                                                 |

### Response

**[CreateShipmentResponse](../../models/operations/CreateShipmentResponse.md)**

### Errors

| Error Type                                           | Status Code                                          | Content Type                                         |
| ---------------------------------------------------- | ---------------------------------------------------- | ---------------------------------------------------- |
| models/errors/CreateShipmentResponseBody             | 404                                                  | application/hal+json                                 |
| models/errors/CreateShipmentShipmentsAPIResponseBody | 422                                                  | application/hal+json                                 |
| models/errors/APIException                           | 4XX, 5XX                                             | \*/\*                                                |

## list

**⚠️ We no longer recommend implementing the Shipments API. Please refer to the Captures API instead. We are
actively working on adding support for line-specific captures to the Captures API.**

Retrieve a list of all shipments created for a specific order.

The results are paginated.

### Example Usage

```java
package hello.world;

import com.mollie.mollie.Mollie;
import com.mollie.mollie.models.errors.ListShipmentsResponseBody;
import com.mollie.mollie.models.errors.ListShipmentsShipmentsAPIResponseBody;
import com.mollie.mollie.models.operations.ListShipmentsResponse;
import com.mollie.mollie.models.operations.ListShipmentsSecurity;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ListShipmentsResponseBody, ListShipmentsShipmentsAPIResponseBody, Exception {

        Mollie sdk = Mollie.builder()
            .build();

        ListShipmentsResponse res = sdk.shipmentsAPI().list()
                .security(ListShipmentsSecurity.builder()
                    .apiKey("<YOUR_BEARER_TOKEN_HERE>")
                    .build())
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
| `security`                                                                                                                                                                                                                                                                                                                                                                             | [com.mollie.mollie.models.operations.ListShipmentsSecurity](../../models/operations/ListShipmentsSecurity.md)                                                                                                                                                                                                                                                                          | :heavy_check_mark:                                                                                                                                                                                                                                                                                                                                                                     | The security requirements to use for the request.                                                                                                                                                                                                                                                                                                                                      |                                                                                                                                                                                                                                                                                                                                                                                        |
| `orderId`                                                                                                                                                                                                                                                                                                                                                                              | *String*                                                                                                                                                                                                                                                                                                                                                                               | :heavy_check_mark:                                                                                                                                                                                                                                                                                                                                                                     | Provide the ID of the related order.                                                                                                                                                                                                                                                                                                                                                   | ord_pbjz8x                                                                                                                                                                                                                                                                                                                                                                             |
| `from`                                                                                                                                                                                                                                                                                                                                                                                 | *Optional\<String>*                                                                                                                                                                                                                                                                                                                                                                    | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                     | Provide an ID to start the result set from the item with the given ID and onwards. This allows you to paginate the<br/>result set.                                                                                                                                                                                                                                                     | shp_3wmsgCJN4U                                                                                                                                                                                                                                                                                                                                                                         |
| `limit`                                                                                                                                                                                                                                                                                                                                                                                | *JsonNullable\<Long>*                                                                                                                                                                                                                                                                                                                                                                  | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                     | The maximum number of items to return. Defaults to 50 items.                                                                                                                                                                                                                                                                                                                           | 50                                                                                                                                                                                                                                                                                                                                                                                     |
| `testmode`                                                                                                                                                                                                                                                                                                                                                                             | *JsonNullable\<Boolean>*                                                                                                                                                                                                                                                                                                                                                               | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                     | Most API credentials are specifically created for either live mode or test mode. In those cases the `testmode` query<br/>parameter can be omitted. For organization-level credentials such as OAuth access tokens, you can enable test mode by<br/>setting the `testmode` query parameter to `true`.<br/><br/>Test entities cannot be retrieved when the endpoint is set to live mode, and vice versa. | false                                                                                                                                                                                                                                                                                                                                                                                  |

### Response

**[ListShipmentsResponse](../../models/operations/ListShipmentsResponse.md)**

### Errors

| Error Type                                          | Status Code                                         | Content Type                                        |
| --------------------------------------------------- | --------------------------------------------------- | --------------------------------------------------- |
| models/errors/ListShipmentsResponseBody             | 400                                                 | application/hal+json                                |
| models/errors/ListShipmentsShipmentsAPIResponseBody | 404                                                 | application/hal+json                                |
| models/errors/APIException                          | 4XX, 5XX                                            | \*/\*                                               |

## get

**⚠️ We no longer recommend implementing the Shipments API. Please refer to the Captures API instead. We are
actively working on adding support for line-specific captures to the Captures API.**

Retrieve a single shipment by its ID and the ID of its parent order.

### Example Usage

```java
package hello.world;

import com.mollie.mollie.Mollie;
import com.mollie.mollie.models.errors.GetShipmentResponseBody;
import com.mollie.mollie.models.operations.GetShipmentResponse;
import com.mollie.mollie.models.operations.GetShipmentSecurity;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws GetShipmentResponseBody, Exception {

        Mollie sdk = Mollie.builder()
            .build();

        GetShipmentResponse res = sdk.shipmentsAPI().get()
                .security(GetShipmentSecurity.builder()
                    .apiKey("<YOUR_BEARER_TOKEN_HERE>")
                    .build())
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
| `security`                                                                                                                                                                                                                                                                                                                                                                             | [com.mollie.mollie.models.operations.GetShipmentSecurity](../../models/operations/GetShipmentSecurity.md)                                                                                                                                                                                                                                                                              | :heavy_check_mark:                                                                                                                                                                                                                                                                                                                                                                     | The security requirements to use for the request.                                                                                                                                                                                                                                                                                                                                      |                                                                                                                                                                                                                                                                                                                                                                                        |
| `orderId`                                                                                                                                                                                                                                                                                                                                                                              | *String*                                                                                                                                                                                                                                                                                                                                                                               | :heavy_check_mark:                                                                                                                                                                                                                                                                                                                                                                     | Provide the ID of the related order.                                                                                                                                                                                                                                                                                                                                                   | ord_pbjz8x                                                                                                                                                                                                                                                                                                                                                                             |
| `id`                                                                                                                                                                                                                                                                                                                                                                                   | *String*                                                                                                                                                                                                                                                                                                                                                                               | :heavy_check_mark:                                                                                                                                                                                                                                                                                                                                                                     | Provide the ID of the item you want to perform this operation on.                                                                                                                                                                                                                                                                                                                      | shp_3wmsgCJN4U                                                                                                                                                                                                                                                                                                                                                                         |
| `testmode`                                                                                                                                                                                                                                                                                                                                                                             | *JsonNullable\<Boolean>*                                                                                                                                                                                                                                                                                                                                                               | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                     | Most API credentials are specifically created for either live mode or test mode. In those cases the `testmode` query<br/>parameter can be omitted. For organization-level credentials such as OAuth access tokens, you can enable test mode by<br/>setting the `testmode` query parameter to `true`.<br/><br/>Test entities cannot be retrieved when the endpoint is set to live mode, and vice versa. | false                                                                                                                                                                                                                                                                                                                                                                                  |

### Response

**[GetShipmentResponse](../../models/operations/GetShipmentResponse.md)**

### Errors

| Error Type                            | Status Code                           | Content Type                          |
| ------------------------------------- | ------------------------------------- | ------------------------------------- |
| models/errors/GetShipmentResponseBody | 404                                   | application/hal+json                  |
| models/errors/APIException            | 4XX, 5XX                              | \*/\*                                 |

## update

**⚠️ We no longer recommend implementing the Shipments API. Please refer to the Captures API instead. We are
actively working on adding support for line-specific captures to the Captures API.**

Update the tracking information on a shipment.

For an in-depth explanation of each parameter, refer to the [Create shipment](create-shipment) endpoint.

### Example Usage

```java
package hello.world;

import com.mollie.mollie.Mollie;
import com.mollie.mollie.models.errors.UpdateShipmentResponseBody;
import com.mollie.mollie.models.operations.UpdateShipmentRequestBody;
import com.mollie.mollie.models.operations.UpdateShipmentResponse;
import com.mollie.mollie.models.operations.UpdateShipmentSecurity;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws UpdateShipmentResponseBody, Exception {

        Mollie sdk = Mollie.builder()
            .build();

        UpdateShipmentResponse res = sdk.shipmentsAPI().update()
                .security(UpdateShipmentSecurity.builder()
                    .apiKey("<YOUR_BEARER_TOKEN_HERE>")
                    .build())
                .orderId("ord_pbjz8x")
                .id("shp_3wmsgCJN4U")
                .testmode(false)
                .requestBody(UpdateShipmentRequestBody.builder()
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
| `security`                                                                                                                                                                                                                                                                                                                                                                             | [com.mollie.mollie.models.operations.UpdateShipmentSecurity](../../models/operations/UpdateShipmentSecurity.md)                                                                                                                                                                                                                                                                        | :heavy_check_mark:                                                                                                                                                                                                                                                                                                                                                                     | The security requirements to use for the request.                                                                                                                                                                                                                                                                                                                                      |                                                                                                                                                                                                                                                                                                                                                                                        |
| `orderId`                                                                                                                                                                                                                                                                                                                                                                              | *String*                                                                                                                                                                                                                                                                                                                                                                               | :heavy_check_mark:                                                                                                                                                                                                                                                                                                                                                                     | Provide the ID of the related order.                                                                                                                                                                                                                                                                                                                                                   | ord_pbjz8x                                                                                                                                                                                                                                                                                                                                                                             |
| `id`                                                                                                                                                                                                                                                                                                                                                                                   | *String*                                                                                                                                                                                                                                                                                                                                                                               | :heavy_check_mark:                                                                                                                                                                                                                                                                                                                                                                     | Provide the ID of the item you want to perform this operation on.                                                                                                                                                                                                                                                                                                                      | shp_3wmsgCJN4U                                                                                                                                                                                                                                                                                                                                                                         |
| `testmode`                                                                                                                                                                                                                                                                                                                                                                             | *JsonNullable\<Boolean>*                                                                                                                                                                                                                                                                                                                                                               | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                     | Most API credentials are specifically created for either live mode or test mode. In those cases the `testmode` query<br/>parameter can be omitted. For organization-level credentials such as OAuth access tokens, you can enable test mode by<br/>setting the `testmode` query parameter to `true`.<br/><br/>Test entities cannot be retrieved when the endpoint is set to live mode, and vice versa. | false                                                                                                                                                                                                                                                                                                                                                                                  |
| `requestBody`                                                                                                                                                                                                                                                                                                                                                                          | [Optional\<UpdateShipmentRequestBody>](../../models/operations/UpdateShipmentRequestBody.md)                                                                                                                                                                                                                                                                                           | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                     | N/A                                                                                                                                                                                                                                                                                                                                                                                    |                                                                                                                                                                                                                                                                                                                                                                                        |

### Response

**[UpdateShipmentResponse](../../models/operations/UpdateShipmentResponse.md)**

### Errors

| Error Type                               | Status Code                              | Content Type                             |
| ---------------------------------------- | ---------------------------------------- | ---------------------------------------- |
| models/errors/UpdateShipmentResponseBody | 404                                      | application/hal+json                     |
| models/errors/APIException               | 4XX, 5XX                                 | \*/\*                                    |