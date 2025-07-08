# Mandates
(*mandates()*)

## Overview

### Available Operations

* [create](#create) - Create mandate
* [list](#list) - List mandates
* [get](#get) - Get mandate
* [revoke](#revoke) - Revoke mandate

## create

Create a mandate for a specific customer. Mandates allow you to charge a customer's card, PayPal account or bank account recurrently.

It is only possible to create mandates for IBANs and PayPal billing agreements with this endpoint. To create mandates for cards, your customers need to perform a 'first payment' with their card.

> 🔑 Access with
>
> [API key](/reference/authentication)
>
> [Access token with **mandates.write**](/reference/authentication)

### Example Usage

```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.CreateMandateResponseBody;
import com.mollie.mollie.models.operations.CreateMandateRequestBody;
import com.mollie.mollie.models.operations.CreateMandateResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws CreateMandateResponseBody, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        CreateMandateResponse res = sdk.mandates().create()
                .customerId("cst_5B8cwPMGnU")
                .requestBody(CreateMandateRequestBody.builder()
                    .method("directdebit")
                    .consumerName("John Doe")
                    .id("mdt_5B8cwPMGnU")
                    .consumerAccount("NL55INGB0000000000")
                    .consumerBic("BANKBIC")
                    .consumerEmail("example@email.com")
                    .signatureDate("2025-01-01")
                    .mandateReference("ID-1023892")
                    .paypalBillingAgreementId("B-12A34567B8901234CD")
                    .payPalVaultId("8kk8451t")
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
| `customerId`                                                                               | *String*                                                                                   | :heavy_check_mark:                                                                         | Provide the ID of the related customer.                                                    | cst_5B8cwPMGnU                                                                             |
| `requestBody`                                                                              | [Optional\<CreateMandateRequestBody>](../../models/operations/CreateMandateRequestBody.md) | :heavy_minus_sign:                                                                         | N/A                                                                                        |                                                                                            |

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

> 🔑 Access with
>
> [API key](/reference/authentication)
>
> [Access token with **mandates.read**](/reference/authentication)

### Example Usage

```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.ListMandatesMandatesResponseBody;
import com.mollie.mollie.models.errors.ListMandatesResponseBody;
import com.mollie.mollie.models.operations.ListMandatesRequest;
import com.mollie.mollie.models.operations.ListMandatesResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ListMandatesResponseBody, ListMandatesMandatesResponseBody, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        ListMandatesRequest req = ListMandatesRequest.builder()
                .customerId("cst_5B8cwPMGnU")
                .from("mdt_5B8cwPMGnU")
                .sort("desc")
                .testmode(false)
                .build();

        ListMandatesResponse res = sdk.mandates().list()
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
| `request`                                                             | [ListMandatesRequest](../../models/operations/ListMandatesRequest.md) | :heavy_check_mark:                                                    | The request object to use for the request.                            |

### Response

**[ListMandatesResponse](../../models/operations/ListMandatesResponse.md)**

### Errors

| Error Type                                     | Status Code                                    | Content Type                                   |
| ---------------------------------------------- | ---------------------------------------------- | ---------------------------------------------- |
| models/errors/ListMandatesResponseBody         | 400                                            | application/hal+json                           |
| models/errors/ListMandatesMandatesResponseBody | 404                                            | application/hal+json                           |
| models/errors/APIException                     | 4XX, 5XX                                       | \*/\*                                          |

## get

Retrieve a single mandate by its ID. Depending on the type of mandate, the object will contain the customer's bank account details, card details, or PayPal account details.

> 🔑 Access with
>
> [API key](/reference/authentication)
>
> [Access token with **mandates.read**](/reference/authentication)

### Example Usage

```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.GetMandateResponseBody;
import com.mollie.mollie.models.operations.GetMandateResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws GetMandateResponseBody, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        GetMandateResponse res = sdk.mandates().get()
                .customerId("cst_5B8cwPMGnU")
                .mandateId("mdt_5B8cwPMGnU")
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
| `mandateId`                                                                                                                                                                                                                                                                                                                                                                            | *String*                                                                                                                                                                                                                                                                                                                                                                               | :heavy_check_mark:                                                                                                                                                                                                                                                                                                                                                                     | Provide the ID of the related mandate.                                                                                                                                                                                                                                                                                                                                                 | mdt_5B8cwPMGnU                                                                                                                                                                                                                                                                                                                                                                         |
| `testmode`                                                                                                                                                                                                                                                                                                                                                                             | *JsonNullable\<Boolean>*                                                                                                                                                                                                                                                                                                                                                               | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                     | Most API credentials are specifically created for either live mode or test mode. In those cases the `testmode` query parameter can be omitted. For organization-level credentials such as OAuth access tokens, you can enable test mode by setting the `testmode` query parameter to `true`.<br/><br/>Test entities cannot be retrieved when the endpoint is set to live mode, and vice versa. | false                                                                                                                                                                                                                                                                                                                                                                                  |

### Response

**[GetMandateResponse](../../models/operations/GetMandateResponse.md)**

### Errors

| Error Type                           | Status Code                          | Content Type                         |
| ------------------------------------ | ------------------------------------ | ------------------------------------ |
| models/errors/GetMandateResponseBody | 404                                  | application/hal+json                 |
| models/errors/APIException           | 4XX, 5XX                             | \*/\*                                |

## revoke

Revoke a customer's mandate. You will no longer be able to charge the customer's bank account or card with this mandate, and all connected subscriptions will be canceled.

> 🔑 Access with
>
> [API key](/reference/authentication)
>
> [Access token with **mandates.write**](/reference/authentication)

### Example Usage

```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.RevokeMandateResponseBody;
import com.mollie.mollie.models.operations.RevokeMandateRequestBody;
import com.mollie.mollie.models.operations.RevokeMandateResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws RevokeMandateResponseBody, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        RevokeMandateResponse res = sdk.mandates().revoke()
                .customerId("cst_5B8cwPMGnU")
                .mandateId("mdt_5B8cwPMGnU")
                .requestBody(RevokeMandateRequestBody.builder()
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
| `customerId`                                                                               | *String*                                                                                   | :heavy_check_mark:                                                                         | Provide the ID of the related customer.                                                    | cst_5B8cwPMGnU                                                                             |
| `mandateId`                                                                                | *String*                                                                                   | :heavy_check_mark:                                                                         | Provide the ID of the related mandate.                                                     | mdt_5B8cwPMGnU                                                                             |
| `requestBody`                                                                              | [Optional\<RevokeMandateRequestBody>](../../models/operations/RevokeMandateRequestBody.md) | :heavy_minus_sign:                                                                         | N/A                                                                                        |                                                                                            |

### Response

**[RevokeMandateResponse](../../models/operations/RevokeMandateResponse.md)**

### Errors

| Error Type                              | Status Code                             | Content Type                            |
| --------------------------------------- | --------------------------------------- | --------------------------------------- |
| models/errors/RevokeMandateResponseBody | 404                                     | application/hal+json                    |
| models/errors/APIException              | 4XX, 5XX                                | \*/\*                                   |