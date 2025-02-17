# MandatesAPI
(*mandatesAPI()*)

## Overview

### Available Operations

* [create](#create) - Create mandate
* [list](#list) - List mandates
* [get](#get) - Get mandate
* [revoke](#revoke) - Revoke mandate

## create

Create a mandate for a specific customer. Mandates allow you to charge a customer's card, PayPal account or bank
account recurrently.

It is only possible to create mandates for IBANs and PayPal billing agreements with this endpoint. To create
mandates for cards, your customers need to perform a 'first payment' with their card.

### Example Usage

```java
package hello.world;

import com.mollie.mollie.Mollie;
import com.mollie.mollie.models.errors.CreateMandateResponseBody;
import com.mollie.mollie.models.operations.CreateMandateMethod;
import com.mollie.mollie.models.operations.CreateMandateRequestBody;
import com.mollie.mollie.models.operations.CreateMandateResponse;
import com.mollie.mollie.models.operations.CreateMandateSecurity;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws CreateMandateResponseBody, Exception {

        Mollie sdk = Mollie.builder()
            .build();

        CreateMandateResponse res = sdk.mandatesAPI().create()
                .security(CreateMandateSecurity.builder()
                    .apiKey("<YOUR_BEARER_TOKEN_HERE>")
                    .build())
                .customerId("cst_8wmqcHMN4U")
                .requestBody(CreateMandateRequestBody.builder()
                    .method(CreateMandateMethod.DIRECTDEBIT)
                    .consumerName("<value>")
                    .build())
                .call();

        if (res.any().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                     | Type                                                                                                          | Required                                                                                                      | Description                                                                                                   | Example                                                                                                       |
| ------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------- |
| `security`                                                                                                    | [com.mollie.mollie.models.operations.CreateMandateSecurity](../../models/operations/CreateMandateSecurity.md) | :heavy_check_mark:                                                                                            | The security requirements to use for the request.                                                             |                                                                                                               |
| `customerId`                                                                                                  | *String*                                                                                                      | :heavy_check_mark:                                                                                            | Provide the ID of the related customer.                                                                       | cst_8wmqcHMN4U                                                                                                |
| `requestBody`                                                                                                 | [Optional\<CreateMandateRequestBody>](../../models/operations/CreateMandateRequestBody.md)                    | :heavy_minus_sign:                                                                                            | N/A                                                                                                           |                                                                                                               |

### Response

**[CreateMandateResponse](../../models/operations/CreateMandateResponse.md)**

### Errors

| Error Type                              | Status Code                             | Content Type                            |
| --------------------------------------- | --------------------------------------- | --------------------------------------- |
| models/errors/CreateMandateResponseBody | 404                                     | application/hal+json                    |
| models/errors/APIException              | 4XX, 5XX                                | \*/\*                                   |

## list

Retrieve a list of all mandates.

The results are paginated.

### Example Usage

```java
package hello.world;

import com.mollie.mollie.Mollie;
import com.mollie.mollie.models.errors.ListMandatesMandatesAPIResponseBody;
import com.mollie.mollie.models.errors.ListMandatesResponseBody;
import com.mollie.mollie.models.operations.ListMandatesResponse;
import com.mollie.mollie.models.operations.ListMandatesSecurity;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ListMandatesResponseBody, ListMandatesMandatesAPIResponseBody, Exception {

        Mollie sdk = Mollie.builder()
            .build();

        ListMandatesResponse res = sdk.mandatesAPI().list()
                .security(ListMandatesSecurity.builder()
                    .apiKey("<YOUR_BEARER_TOKEN_HERE>")
                    .build())
                .customerId("cst_8wmqcHMN4U")
                .from("mdt_h3gAaD5zP")
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
| `security`                                                                                                                                                                                                                                                                                                                                                                             | [com.mollie.mollie.models.operations.ListMandatesSecurity](../../models/operations/ListMandatesSecurity.md)                                                                                                                                                                                                                                                                            | :heavy_check_mark:                                                                                                                                                                                                                                                                                                                                                                     | The security requirements to use for the request.                                                                                                                                                                                                                                                                                                                                      |                                                                                                                                                                                                                                                                                                                                                                                        |
| `customerId`                                                                                                                                                                                                                                                                                                                                                                           | *String*                                                                                                                                                                                                                                                                                                                                                                               | :heavy_check_mark:                                                                                                                                                                                                                                                                                                                                                                     | Provide the ID of the related customer.                                                                                                                                                                                                                                                                                                                                                | cst_8wmqcHMN4U                                                                                                                                                                                                                                                                                                                                                                         |
| `from`                                                                                                                                                                                                                                                                                                                                                                                 | *Optional\<String>*                                                                                                                                                                                                                                                                                                                                                                    | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                     | Provide an ID to start the result set from the item with the given ID and onwards. This allows you to paginate the<br/>result set.                                                                                                                                                                                                                                                     | mdt_h3gAaD5zP                                                                                                                                                                                                                                                                                                                                                                          |
| `limit`                                                                                                                                                                                                                                                                                                                                                                                | *JsonNullable\<Long>*                                                                                                                                                                                                                                                                                                                                                                  | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                     | The maximum number of items to return. Defaults to 50 items.                                                                                                                                                                                                                                                                                                                           | 50                                                                                                                                                                                                                                                                                                                                                                                     |
| `testmode`                                                                                                                                                                                                                                                                                                                                                                             | *JsonNullable\<Boolean>*                                                                                                                                                                                                                                                                                                                                                               | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                     | Most API credentials are specifically created for either live mode or test mode. In those cases the `testmode` query<br/>parameter can be omitted. For organization-level credentials such as OAuth access tokens, you can enable test mode by<br/>setting the `testmode` query parameter to `true`.<br/><br/>Test entities cannot be retrieved when the endpoint is set to live mode, and vice versa. | false                                                                                                                                                                                                                                                                                                                                                                                  |

### Response

**[ListMandatesResponse](../../models/operations/ListMandatesResponse.md)**

### Errors

| Error Type                                        | Status Code                                       | Content Type                                      |
| ------------------------------------------------- | ------------------------------------------------- | ------------------------------------------------- |
| models/errors/ListMandatesResponseBody            | 400                                               | application/hal+json                              |
| models/errors/ListMandatesMandatesAPIResponseBody | 404                                               | application/hal+json                              |
| models/errors/APIException                        | 4XX, 5XX                                          | \*/\*                                             |

## get

Retrieve a single mandate by its ID. Depending on the type of mandate, the object will contain the customer's bank
account details, card details, or PayPal account details.

### Example Usage

```java
package hello.world;

import com.mollie.mollie.Mollie;
import com.mollie.mollie.models.errors.GetMandateResponseBody;
import com.mollie.mollie.models.operations.GetMandateResponse;
import com.mollie.mollie.models.operations.GetMandateSecurity;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws GetMandateResponseBody, Exception {

        Mollie sdk = Mollie.builder()
            .build();

        GetMandateResponse res = sdk.mandatesAPI().get()
                .security(GetMandateSecurity.builder()
                    .apiKey("<YOUR_BEARER_TOKEN_HERE>")
                    .build())
                .customerId("cst_8wmqcHMN4U")
                .id("mdt_pWUnw6pkBN")
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
| `security`                                                                                                                                                                                                                                                                                                                                                                             | [com.mollie.mollie.models.operations.GetMandateSecurity](../../models/operations/GetMandateSecurity.md)                                                                                                                                                                                                                                                                                | :heavy_check_mark:                                                                                                                                                                                                                                                                                                                                                                     | The security requirements to use for the request.                                                                                                                                                                                                                                                                                                                                      |                                                                                                                                                                                                                                                                                                                                                                                        |
| `customerId`                                                                                                                                                                                                                                                                                                                                                                           | *String*                                                                                                                                                                                                                                                                                                                                                                               | :heavy_check_mark:                                                                                                                                                                                                                                                                                                                                                                     | Provide the ID of the related customer.                                                                                                                                                                                                                                                                                                                                                | cst_8wmqcHMN4U                                                                                                                                                                                                                                                                                                                                                                         |
| `id`                                                                                                                                                                                                                                                                                                                                                                                   | *String*                                                                                                                                                                                                                                                                                                                                                                               | :heavy_check_mark:                                                                                                                                                                                                                                                                                                                                                                     | Provide the ID of the item you want to perform this operation on.                                                                                                                                                                                                                                                                                                                      | mdt_pWUnw6pkBN                                                                                                                                                                                                                                                                                                                                                                         |
| `testmode`                                                                                                                                                                                                                                                                                                                                                                             | *JsonNullable\<Boolean>*                                                                                                                                                                                                                                                                                                                                                               | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                     | Most API credentials are specifically created for either live mode or test mode. In those cases the `testmode` query<br/>parameter can be omitted. For organization-level credentials such as OAuth access tokens, you can enable test mode by<br/>setting the `testmode` query parameter to `true`.<br/><br/>Test entities cannot be retrieved when the endpoint is set to live mode, and vice versa. | false                                                                                                                                                                                                                                                                                                                                                                                  |

### Response

**[GetMandateResponse](../../models/operations/GetMandateResponse.md)**

### Errors

| Error Type                           | Status Code                          | Content Type                         |
| ------------------------------------ | ------------------------------------ | ------------------------------------ |
| models/errors/GetMandateResponseBody | 404                                  | application/hal+json                 |
| models/errors/APIException           | 4XX, 5XX                             | \*/\*                                |

## revoke

Revoke a customer's mandate. You will no longer be able to charge the customer's bank account or card with this
mandate, and all connected subscriptions will be canceled.

### Example Usage

```java
package hello.world;

import com.mollie.mollie.Mollie;
import com.mollie.mollie.models.errors.RevokeMandateResponseBody;
import com.mollie.mollie.models.operations.RevokeMandateResponse;
import com.mollie.mollie.models.operations.RevokeMandateSecurity;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws RevokeMandateResponseBody, Exception {

        Mollie sdk = Mollie.builder()
            .build();

        RevokeMandateResponse res = sdk.mandatesAPI().revoke()
                .security(RevokeMandateSecurity.builder()
                    .apiKey("<YOUR_BEARER_TOKEN_HERE>")
                    .build())
                .customerId("cst_8wmqcHMN4U")
                .id("mdt_pWUnw6pkBN")
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
| `security`                                                                                                                                                                                                                                                                                                                                                                             | [com.mollie.mollie.models.operations.RevokeMandateSecurity](../../models/operations/RevokeMandateSecurity.md)                                                                                                                                                                                                                                                                          | :heavy_check_mark:                                                                                                                                                                                                                                                                                                                                                                     | The security requirements to use for the request.                                                                                                                                                                                                                                                                                                                                      |                                                                                                                                                                                                                                                                                                                                                                                        |
| `customerId`                                                                                                                                                                                                                                                                                                                                                                           | *String*                                                                                                                                                                                                                                                                                                                                                                               | :heavy_check_mark:                                                                                                                                                                                                                                                                                                                                                                     | Provide the ID of the related customer.                                                                                                                                                                                                                                                                                                                                                | cst_8wmqcHMN4U                                                                                                                                                                                                                                                                                                                                                                         |
| `id`                                                                                                                                                                                                                                                                                                                                                                                   | *String*                                                                                                                                                                                                                                                                                                                                                                               | :heavy_check_mark:                                                                                                                                                                                                                                                                                                                                                                     | Provide the ID of the item you want to perform this operation on.                                                                                                                                                                                                                                                                                                                      | mdt_pWUnw6pkBN                                                                                                                                                                                                                                                                                                                                                                         |
| `testmode`                                                                                                                                                                                                                                                                                                                                                                             | *JsonNullable\<Boolean>*                                                                                                                                                                                                                                                                                                                                                               | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                     | Most API credentials are specifically created for either live mode or test mode. In those cases the `testmode` query<br/>parameter can be omitted. For organization-level credentials such as OAuth access tokens, you can enable test mode by<br/>setting the `testmode` query parameter to `true`.<br/><br/>Test entities cannot be retrieved when the endpoint is set to live mode, and vice versa. | false                                                                                                                                                                                                                                                                                                                                                                                  |

### Response

**[RevokeMandateResponse](../../models/operations/RevokeMandateResponse.md)**

### Errors

| Error Type                              | Status Code                             | Content Type                            |
| --------------------------------------- | --------------------------------------- | --------------------------------------- |
| models/errors/RevokeMandateResponseBody | 404                                     | application/hal+json                    |
| models/errors/APIException              | 4XX, 5XX                                | \*/\*                                   |