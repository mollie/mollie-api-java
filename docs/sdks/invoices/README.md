# Invoices
(*invoices()*)

## Overview

### Available Operations

* [list](#list) - List invoices
* [get](#get) - Get invoice

## list

Retrieve a list of all your invoices, optionally filtered by year or by invoice reference.

The results are paginated.

> 🔑 Access with
>
> [Access token with **invoices.read**](/reference/authentication)

### Example Usage

```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.ListInvoicesInvoicesResponseBody;
import com.mollie.mollie.models.errors.ListInvoicesResponseBody;
import com.mollie.mollie.models.operations.ListInvoicesRequest;
import com.mollie.mollie.models.operations.ListInvoicesResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ListInvoicesResponseBody, ListInvoicesInvoicesResponseBody, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey("<YOUR_BEARER_TOKEN_HERE>")
                    .build())
            .build();

        ListInvoicesRequest req = ListInvoicesRequest.builder()
                .reference("2024.10000")
                .year("2024")
                .month("01")
                .from("inv_xBEbP9rvAq")
                .sort("desc")
                .build();

        ListInvoicesResponse res = sdk.invoices().list()
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
| `request`                                                             | [ListInvoicesRequest](../../models/operations/ListInvoicesRequest.md) | :heavy_check_mark:                                                    | The request object to use for the request.                            |

### Response

**[ListInvoicesResponse](../../models/operations/ListInvoicesResponse.md)**

### Errors

| Error Type                                     | Status Code                                    | Content Type                                   |
| ---------------------------------------------- | ---------------------------------------------- | ---------------------------------------------- |
| models/errors/ListInvoicesResponseBody         | 400                                            | application/hal+json                           |
| models/errors/ListInvoicesInvoicesResponseBody | 404                                            | application/hal+json                           |
| models/errors/APIException                     | 4XX, 5XX                                       | \*/\*                                          |

## get

Retrieve a single invoice by its ID.

If you want to retrieve the details of an invoice by its invoice number, call the [List invoices](list-invoices) endpoint with the `reference` parameter.

> 🔑 Access with
>
> [Access token with **invoices.read**](/reference/authentication)

### Example Usage

```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.GetInvoiceResponseBody;
import com.mollie.mollie.models.operations.GetInvoiceResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws GetInvoiceResponseBody, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey("<YOUR_BEARER_TOKEN_HERE>")
                    .build())
            .build();

        GetInvoiceResponse res = sdk.invoices().get()
                .id("inv_FrvewDA3Pr")
                .call();

        if (res.object().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                         | Type                                                              | Required                                                          | Description                                                       | Example                                                           |
| ----------------------------------------------------------------- | ----------------------------------------------------------------- | ----------------------------------------------------------------- | ----------------------------------------------------------------- | ----------------------------------------------------------------- |
| `id`                                                              | *String*                                                          | :heavy_check_mark:                                                | Provide the ID of the item you want to perform this operation on. | inv_FrvewDA3Pr                                                    |

### Response

**[GetInvoiceResponse](../../models/operations/GetInvoiceResponse.md)**

### Errors

| Error Type                           | Status Code                          | Content Type                         |
| ------------------------------------ | ------------------------------------ | ------------------------------------ |
| models/errors/GetInvoiceResponseBody | 404                                  | application/hal+json                 |
| models/errors/APIException           | 4XX, 5XX                             | \*/\*                                |