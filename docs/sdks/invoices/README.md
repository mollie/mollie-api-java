# Invoices
(*invoices()*)

## Overview

### Available Operations

* [list](#list) - List invoices
* [get](#get) - Get invoice

## list

Retrieve a list of all your invoices, optionally filtered by year or by
invoice reference.

The results are paginated.

### Example Usage

<!-- UsageSnippet language="java" operationID="list-invoices" method="get" path="/invoices" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.ListSort;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.ListInvoicesRequest;
import com.mollie.mollie.models.operations.ListInvoicesResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        ListInvoicesRequest req = ListInvoicesRequest.builder()
                .reference("2024.10000")
                .year("2024")
                .month("01")
                .from("inv_xBEbP9rvAq")
                .limit(50L)
                .sort(ListSort.DESC)
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

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 400, 404                    | application/hal+json        |
| models/errors/APIException  | 4XX, 5XX                    | \*/\*                       |

## get

Retrieve a single invoice by its ID.

If you want to retrieve the details of an invoice by its invoice number,
call the [List invoices](list-invoices) endpoint with the `reference` parameter.

### Example Usage

<!-- UsageSnippet language="java" operationID="get-invoice" method="get" path="/invoices/{id}" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.GetInvoiceResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        GetInvoiceResponse res = sdk.invoices().get()
                .id("inv_FrvewDA3Pr")
                .call();

        if (res.entityInvoice().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                         | Type                                                              | Required                                                          | Description                                                       |
| ----------------------------------------------------------------- | ----------------------------------------------------------------- | ----------------------------------------------------------------- | ----------------------------------------------------------------- |
| `id`                                                              | *String*                                                          | :heavy_check_mark:                                                | Provide the ID of the item you want to perform this operation on. |

### Response

**[GetInvoiceResponse](../../models/operations/GetInvoiceResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 404                         | application/hal+json        |
| models/errors/APIException  | 4XX, 5XX                    | \*/\*                       |