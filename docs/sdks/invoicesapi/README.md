# InvoicesAPI
(*invoicesAPI()*)

## Overview

### Available Operations

* [list](#list) - List invoices
* [get](#get) - Get invoice

## list

Retrieve a list of all your invoices, optionally filtered by year or by
invoice reference.

The results are paginated.

### Example Usage

```java
package hello.world;

import com.mollie.mollie.Mollie;
import com.mollie.mollie.models.errors.ListInvoicesInvoicesAPIResponseBody;
import com.mollie.mollie.models.errors.ListInvoicesResponseBody;
import com.mollie.mollie.models.operations.ListInvoicesResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ListInvoicesResponseBody, ListInvoicesInvoicesAPIResponseBody, Exception {

        Mollie sdk = Mollie.builder()
                .oAuth("<YOUR_O_AUTH_HERE>")
            .build();

        ListInvoicesResponse res = sdk.invoicesAPI().list()
                .reference("2024.10000")
                .year("2024")
                .from("inv_xBEbP9rvAq")
                .limit(50L)
                .call();

        if (res.object().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                                      | Type                                                                                                                           | Required                                                                                                                       | Description                                                                                                                    | Example                                                                                                                        |
| ------------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------------ |
| `reference`                                                                                                                    | *JsonNullable\<String>*                                                                                                        | :heavy_minus_sign:                                                                                                             | Filter for an invoice with a specific invoice reference, for example<br/>`2024.10000`.                                         | 2024.10000                                                                                                                     |
| `year`                                                                                                                         | *JsonNullable\<String>*                                                                                                        | :heavy_minus_sign:                                                                                                             | Filter for invoices of a specific year, for example `2024`.                                                                    | 2024                                                                                                                           |
| `from`                                                                                                                         | *Optional\<String>*                                                                                                            | :heavy_minus_sign:                                                                                                             | Provide an ID to start the result set from the item with the given ID and onwards. This allows you to paginate the<br/>result set. | inv_xBEbP9rvAq                                                                                                                 |
| `limit`                                                                                                                        | *JsonNullable\<Long>*                                                                                                          | :heavy_minus_sign:                                                                                                             | The maximum number of items to return. Defaults to 50 items.                                                                   | 50                                                                                                                             |

### Response

**[ListInvoicesResponse](../../models/operations/ListInvoicesResponse.md)**

### Errors

| Error Type                                        | Status Code                                       | Content Type                                      |
| ------------------------------------------------- | ------------------------------------------------- | ------------------------------------------------- |
| models/errors/ListInvoicesResponseBody            | 400                                               | application/hal+json                              |
| models/errors/ListInvoicesInvoicesAPIResponseBody | 404                                               | application/hal+json                              |
| models/errors/APIException                        | 4XX, 5XX                                          | \*/\*                                             |

## get

Retrieve a single invoice by its ID.

If you want to retrieve the details of an invoice by its invoice number,
call the [List invoices](list-invoices) endpoint with the `reference` parameter.

### Example Usage

```java
package hello.world;

import com.mollie.mollie.Mollie;
import com.mollie.mollie.models.errors.GetInvoiceResponseBody;
import com.mollie.mollie.models.operations.GetInvoiceResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws GetInvoiceResponseBody, Exception {

        Mollie sdk = Mollie.builder()
                .oAuth("<YOUR_O_AUTH_HERE>")
            .build();

        GetInvoiceResponse res = sdk.invoicesAPI().get()
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