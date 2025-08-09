# SalesInvoices
(*salesInvoices()*)

## Overview

### Available Operations

* [create](#create) - Create sales invoice
* [list](#list) - List sales invoices
* [get](#get) - Get sales invoice
* [update](#update) - Update sales invoice
* [delete](#delete) - Delete sales invoice

## create

> 🚧 Beta feature
>
> This feature is currently in beta testing, and the final specification may still change.

With the Sales Invoice API you can generate sales invoices to send to your customers.

### Example Usage

<!-- UsageSnippet language="java" operationID="create-sales-invoice" method="post" path="/sales-invoices" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.CreateSalesInvoiceResponseBody;
import com.mollie.mollie.models.errors.CreateSalesInvoiceSalesInvoicesResponseBody;
import com.mollie.mollie.models.operations.*;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws CreateSalesInvoiceResponseBody, CreateSalesInvoiceSalesInvoicesResponseBody, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        CreateSalesInvoiceRequestBody req = CreateSalesInvoiceRequestBody.builder()
                .status(Status.DRAFT)
                .recipientIdentifier("customer-xyz-0123")
                .recipient(Recipient.builder()
                    .type(CreateSalesInvoiceType.CONSUMER)
                    .email("example@email.com")
                    .streetAndNumber("Keizersgracht 126")
                    .postalCode("5678AB")
                    .city("Amsterdam")
                    .country("NL")
                    .locale(CreateSalesInvoiceLocale.NLNL)
                    .title("Mrs.")
                    .givenName("Jane")
                    .familyName("Doe")
                    .organizationName("Organization Corp.")
                    .organizationNumber("12345678")
                    .vatNumber("NL123456789B01")
                    .phone("+0123456789")
                    .streetAdditional("4th floor")
                    .region("Noord-Holland")
                    .build())
                .lines(List.of())
                .testmode(false)
                .profileId("pfl_QkEhN94Ba")
                .vatScheme(VatScheme.STANDARD)
                .vatMode(VatMode.EXCLUSIVE)
                .memo("This is a memo!")
                .paymentTerm(PaymentTerm.THIRTYDAYS)
                .paymentDetails(PaymentDetails.builder()
                    .source(CreateSalesInvoiceSource.PAYMENT_LINK)
                    .sourceReference("pl_d9fQur83kFdhH8hIhaZfq")
                    .build())
                .emailDetails(EmailDetails.builder()
                    .subject("Your invoice is available")
                    .body("Please find your invoice enclosed.")
                    .build())
                .customerId("cst_8wmqcHMN4U")
                .mandateId("mdt_pWUnw6pkBN")
                .discount(CreateSalesInvoiceDiscount.builder()
                    .type(CreateSalesInvoiceSalesInvoicesRequestType.AMOUNT)
                    .value("10.00")
                    .build())
                .build();

        CreateSalesInvoiceResponse res = sdk.salesInvoices().create()
                .request(req)
                .call();

        if (res.object().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                 | Type                                                                                      | Required                                                                                  | Description                                                                               |
| ----------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------- |
| `request`                                                                                 | [CreateSalesInvoiceRequestBody](../../models/operations/CreateSalesInvoiceRequestBody.md) | :heavy_check_mark:                                                                        | The request object to use for the request.                                                |

### Response

**[CreateSalesInvoiceResponse](../../models/operations/CreateSalesInvoiceResponse.md)**

### Errors

| Error Type                                                | Status Code                                               | Content Type                                              |
| --------------------------------------------------------- | --------------------------------------------------------- | --------------------------------------------------------- |
| models/errors/CreateSalesInvoiceResponseBody              | 404                                                       | application/hal+json                                      |
| models/errors/CreateSalesInvoiceSalesInvoicesResponseBody | 422                                                       | application/hal+json                                      |
| models/errors/APIException                                | 4XX, 5XX                                                  | \*/\*                                                     |

## list

> 🚧 Beta feature
>
> This feature is currently in beta testing, and the final specification may still change.

Retrieve a list of all sales invoices created through the API.

The results are paginated.

### Example Usage

<!-- UsageSnippet language="java" operationID="list-sales-invoices" method="get" path="/sales-invoices" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.ListSalesInvoicesResponseBody;
import com.mollie.mollie.models.operations.ListSalesInvoicesResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ListSalesInvoicesResponseBody, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        ListSalesInvoicesResponse res = sdk.salesInvoices().list()
                .from("invoice_4Y0eZitmBnQ6IDoMqZQKh")
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
| `from`                                                                                                                                                                                                                                                                                                                                                                                 | *Optional\<String>*                                                                                                                                                                                                                                                                                                                                                                    | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                     | Provide an ID to start the result set from the item with the given ID and onwards. This allows you to paginate the<br/>result set.                                                                                                                                                                                                                                                     | invoice_4Y0eZitmBnQ6IDoMqZQKh                                                                                                                                                                                                                                                                                                                                                          |
| `limit`                                                                                                                                                                                                                                                                                                                                                                                | *JsonNullable\<Long>*                                                                                                                                                                                                                                                                                                                                                                  | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                     | The maximum number of items to return. Defaults to 50 items.                                                                                                                                                                                                                                                                                                                           | 50                                                                                                                                                                                                                                                                                                                                                                                     |
| `testmode`                                                                                                                                                                                                                                                                                                                                                                             | *JsonNullable\<Boolean>*                                                                                                                                                                                                                                                                                                                                                               | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                     | Most API credentials are specifically created for either live mode or test mode. In those cases the `testmode` query<br/>parameter can be omitted. For organization-level credentials such as OAuth access tokens, you can enable test mode by<br/>setting the `testmode` query parameter to `true`.<br/><br/>Test entities cannot be retrieved when the endpoint is set to live mode, and vice versa. | false                                                                                                                                                                                                                                                                                                                                                                                  |

### Response

**[ListSalesInvoicesResponse](../../models/operations/ListSalesInvoicesResponse.md)**

### Errors

| Error Type                                  | Status Code                                 | Content Type                                |
| ------------------------------------------- | ------------------------------------------- | ------------------------------------------- |
| models/errors/ListSalesInvoicesResponseBody | 400                                         | application/hal+json                        |
| models/errors/APIException                  | 4XX, 5XX                                    | \*/\*                                       |

## get

> 🚧 Beta feature
>
> This feature is currently in beta testing, and the final specification may still change.

Retrieve a single sales invoice by its ID.

### Example Usage

<!-- UsageSnippet language="java" operationID="get-sales-invoice" method="get" path="/sales-invoices/{id}" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.GetSalesInvoiceResponseBody;
import com.mollie.mollie.models.operations.GetSalesInvoiceResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws GetSalesInvoiceResponseBody, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        GetSalesInvoiceResponse res = sdk.salesInvoices().get()
                .id("invoice_4Y0eZitmBnQ6IDoMqZQKh")
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
| `id`                                                                                                                                                                                                                                                                                                                                                                                   | *String*                                                                                                                                                                                                                                                                                                                                                                               | :heavy_check_mark:                                                                                                                                                                                                                                                                                                                                                                     | Provide the ID of the item you want to perform this operation on.                                                                                                                                                                                                                                                                                                                      | invoice_4Y0eZitmBnQ6IDoMqZQKh                                                                                                                                                                                                                                                                                                                                                          |
| `testmode`                                                                                                                                                                                                                                                                                                                                                                             | *JsonNullable\<Boolean>*                                                                                                                                                                                                                                                                                                                                                               | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                     | Most API credentials are specifically created for either live mode or test mode. In those cases the `testmode` query<br/>parameter can be omitted. For organization-level credentials such as OAuth access tokens, you can enable test mode by<br/>setting the `testmode` query parameter to `true`.<br/><br/>Test entities cannot be retrieved when the endpoint is set to live mode, and vice versa. | false                                                                                                                                                                                                                                                                                                                                                                                  |

### Response

**[GetSalesInvoiceResponse](../../models/operations/GetSalesInvoiceResponse.md)**

### Errors

| Error Type                                | Status Code                               | Content Type                              |
| ----------------------------------------- | ----------------------------------------- | ----------------------------------------- |
| models/errors/GetSalesInvoiceResponseBody | 404                                       | application/hal+json                      |
| models/errors/APIException                | 4XX, 5XX                                  | \*/\*                                     |

## update

> 🚧 Beta feature
>
> This feature is currently in beta testing, and the final specification may still change.

Certain details of an existing sales invoice can be updated. For `draft` it is all values listed below, but for
statuses `paid` and `issued` there are certain additional requirements (`paymentDetails` and `emailDetails`,
respectively).

### Example Usage

<!-- UsageSnippet language="java" operationID="update-sales-invoice" method="patch" path="/sales-invoices/{id}" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.UpdateSalesInvoiceResponseBody;
import com.mollie.mollie.models.errors.UpdateSalesInvoiceSalesInvoicesResponseBody;
import com.mollie.mollie.models.operations.*;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws UpdateSalesInvoiceResponseBody, UpdateSalesInvoiceSalesInvoicesResponseBody, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        UpdateSalesInvoiceResponse res = sdk.salesInvoices().update()
                .id("invoice_4Y0eZitmBnQ6IDoMqZQKh")
                .requestBody(UpdateSalesInvoiceRequestBody.builder()
                    .testmode(false)
                    .status(UpdateSalesInvoiceStatus.PAID)
                    .memo("An updated memo!")
                    .paymentTerm(UpdateSalesInvoicePaymentTerm.THIRTYDAYS)
                    .paymentDetails(UpdateSalesInvoicePaymentDetails.builder()
                        .source(UpdateSalesInvoiceSource.PAYMENT_LINK)
                        .sourceReference("pl_d9fQur83kFdhH8hIhaZfq")
                        .build())
                    .emailDetails(UpdateSalesInvoiceEmailDetails.builder()
                        .subject("Your invoice is available")
                        .body("Please find your invoice enclosed.")
                        .build())
                    .recipientIdentifier("customer-xyz-0123")
                    .recipient(UpdateSalesInvoiceRecipient.builder()
                        .type(UpdateSalesInvoiceType.CONSUMER)
                        .email("example@email.com")
                        .streetAndNumber("Keizersgracht 126")
                        .postalCode("5678AB")
                        .city("Amsterdam")
                        .country("NL")
                        .locale(UpdateSalesInvoiceLocale.NLNL)
                        .title("Mrs.")
                        .givenName("Jane")
                        .familyName("Doe")
                        .organizationName("Organization Corp.")
                        .organizationNumber("12345678")
                        .vatNumber("NL123456789B01")
                        .phone("+0123456789")
                        .streetAdditional("4th floor")
                        .region("Noord-Holland")
                        .build())
                    .lines(List.of(
                        UpdateSalesInvoiceLines.builder()
                            .description("LEGO 4440 Forest Police Station")
                            .quantity(1L)
                            .vatRate("21.00")
                            .unitPrice(UpdateSalesInvoiceUnitPrice.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .discount(UpdateSalesInvoiceDiscount.builder()
                                .type(UpdateSalesInvoiceSalesInvoicesType.AMOUNT)
                                .value("10.00")
                                .build())
                            .build()))
                    .discount(UpdateSalesInvoiceSalesInvoicesDiscount.builder()
                        .type(UpdateSalesInvoiceSalesInvoicesRequestType.AMOUNT)
                        .value("10.00")
                        .build())
                    .build())
                .call();

        if (res.object().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                            | Type                                                                                                 | Required                                                                                             | Description                                                                                          | Example                                                                                              |
| ---------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------- |
| `id`                                                                                                 | *String*                                                                                             | :heavy_check_mark:                                                                                   | Provide the ID of the item you want to perform this operation on.                                    | invoice_4Y0eZitmBnQ6IDoMqZQKh                                                                        |
| `requestBody`                                                                                        | [Optional\<UpdateSalesInvoiceRequestBody>](../../models/operations/UpdateSalesInvoiceRequestBody.md) | :heavy_minus_sign:                                                                                   | N/A                                                                                                  |                                                                                                      |

### Response

**[UpdateSalesInvoiceResponse](../../models/operations/UpdateSalesInvoiceResponse.md)**

### Errors

| Error Type                                                | Status Code                                               | Content Type                                              |
| --------------------------------------------------------- | --------------------------------------------------------- | --------------------------------------------------------- |
| models/errors/UpdateSalesInvoiceResponseBody              | 404                                                       | application/hal+json                                      |
| models/errors/UpdateSalesInvoiceSalesInvoicesResponseBody | 422                                                       | application/hal+json                                      |
| models/errors/APIException                                | 4XX, 5XX                                                  | \*/\*                                                     |

## delete

> 🚧 Beta feature
>
> This feature is currently in beta testing, and the final specification may still change.

Sales invoices which are in status `draft` can be deleted. For all other statuses, please use the
[Update sales invoice](update-sales-invoice) endpoint instead.

### Example Usage

<!-- UsageSnippet language="java" operationID="delete-sales-invoice" method="delete" path="/sales-invoices/{id}" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.DeleteSalesInvoiceResponseBody;
import com.mollie.mollie.models.errors.DeleteSalesInvoiceSalesInvoicesResponseBody;
import com.mollie.mollie.models.operations.DeleteSalesInvoiceRequestBody;
import com.mollie.mollie.models.operations.DeleteSalesInvoiceResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws DeleteSalesInvoiceResponseBody, DeleteSalesInvoiceSalesInvoicesResponseBody, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        DeleteSalesInvoiceResponse res = sdk.salesInvoices().delete()
                .id("invoice_4Y0eZitmBnQ6IDoMqZQKh")
                .requestBody(DeleteSalesInvoiceRequestBody.builder()
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

| Parameter                                                                                            | Type                                                                                                 | Required                                                                                             | Description                                                                                          | Example                                                                                              |
| ---------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------- |
| `id`                                                                                                 | *String*                                                                                             | :heavy_check_mark:                                                                                   | Provide the ID of the item you want to perform this operation on.                                    | invoice_4Y0eZitmBnQ6IDoMqZQKh                                                                        |
| `requestBody`                                                                                        | [Optional\<DeleteSalesInvoiceRequestBody>](../../models/operations/DeleteSalesInvoiceRequestBody.md) | :heavy_minus_sign:                                                                                   | N/A                                                                                                  |                                                                                                      |

### Response

**[DeleteSalesInvoiceResponse](../../models/operations/DeleteSalesInvoiceResponse.md)**

### Errors

| Error Type                                                | Status Code                                               | Content Type                                              |
| --------------------------------------------------------- | --------------------------------------------------------- | --------------------------------------------------------- |
| models/errors/DeleteSalesInvoiceResponseBody              | 404                                                       | application/hal+json                                      |
| models/errors/DeleteSalesInvoiceSalesInvoicesResponseBody | 422                                                       | application/hal+json                                      |
| models/errors/APIException                                | 4XX, 5XX                                                  | \*/\*                                                     |