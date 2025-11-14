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
import com.mollie.mollie.models.components.*;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.CreateSalesInvoiceResponse;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        CreateSalesInvoiceResponse res = sdk.salesInvoices().create()
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .entitySalesInvoice(EntitySalesInvoice.builder()
                    .id("invoice_4Y0eZitmBnQ6IDoMqZQKh")
                    .testmode(false)
                    .profileId("pfl_QkEhN94Ba")
                    .status(SalesInvoiceStatus.DRAFT)
                    .vatScheme(SalesInvoiceVatScheme.STANDARD)
                    .vatMode(SalesInvoiceVatMode.EXCLUSIVE)
                    .memo("This is a memo!")
                    .paymentTerm(SalesInvoicePaymentTerm.THIRTYDAYS)
                    .paymentDetails(SalesInvoicePaymentDetails.builder()
                        .source(SalesInvoicePaymentDetailsSource.PAYMENT_LINK)
                        .sourceReference("pl_d9fQur83kFdhH8hIhaZfq")
                        .build())
                    .emailDetails(SalesInvoiceEmailDetails.builder()
                        .subject("Your invoice is available")
                        .body("Please find your invoice enclosed.")
                        .build())
                    .customerId("cst_8wmqcHMN4U")
                    .mandateId("mdt_pWUnw6pkBN")
                    .recipientIdentifier("customer-xyz-0123")
                    .recipient(SalesInvoiceRecipient.builder()
                        .type(SalesInvoiceRecipientType.CONSUMER)
                        .email("example@email.com")
                        .streetAndNumber("Keizersgracht 126")
                        .postalCode("5678AB")
                        .city("Amsterdam")
                        .country("NL")
                        .locale(SalesInvoiceRecipientLocale.NLNL)
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
                    .discount(SalesInvoiceDiscount.builder()
                        .type(SalesInvoiceDiscountType.AMOUNT)
                        .value("10.00")
                        .build())
                    .amountDue(Amount.builder()
                        .currency("EUR")
                        .value("10.00")
                        .build())
                    .subtotalAmount(Amount.builder()
                        .currency("EUR")
                        .value("10.00")
                        .build())
                    .totalAmount(Amount.builder()
                        .currency("EUR")
                        .value("10.00")
                        .build())
                    .totalVatAmount(Amount.builder()
                        .currency("EUR")
                        .value("10.00")
                        .build())
                    .discountedSubtotalAmount(Amount.builder()
                        .currency("EUR")
                        .value("10.00")
                        .build())
                    .build())
                .call();

        if (res.entitySalesInvoiceResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                        | Type                                                                             | Required                                                                         | Description                                                                      | Example                                                                          |
| -------------------------------------------------------------------------------- | -------------------------------------------------------------------------------- | -------------------------------------------------------------------------------- | -------------------------------------------------------------------------------- | -------------------------------------------------------------------------------- |
| `idempotencyKey`                                                                 | *Optional\<String>*                                                              | :heavy_minus_sign:                                                               | A unique key to ensure idempotent requests. This key should be a UUID v4 string. | 123e4567-e89b-12d3-a456-426                                                      |
| `entitySalesInvoice`                                                             | [Optional\<EntitySalesInvoice>](../../models/components/EntitySalesInvoice.md)   | :heavy_minus_sign:                                                               | N/A                                                                              |                                                                                  |

### Response

**[CreateSalesInvoiceResponse](../../models/operations/CreateSalesInvoiceResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 404, 422                    | application/hal+json        |
| models/errors/APIException  | 4XX, 5XX                    | \*/\*                       |

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
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.ListSalesInvoicesResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .testmode(false)
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        ListSalesInvoicesResponse res = sdk.salesInvoices().list()
                .from("invoice_4Y0eZitmBnQ6IDoMqZQKh")
                .limit(50L)
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
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
| `from`                                                                                                                                                                                                                                                                                                                                                                                 | *JsonNullable\<String>*                                                                                                                                                                                                                                                                                                                                                                | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                     | Provide an ID to start the result set from the item with the given ID and onwards. This allows you to paginate the<br/>result set.                                                                                                                                                                                                                                                     |                                                                                                                                                                                                                                                                                                                                                                                        |
| `limit`                                                                                                                                                                                                                                                                                                                                                                                | *JsonNullable\<Long>*                                                                                                                                                                                                                                                                                                                                                                  | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                     | The maximum number of items to return. Defaults to 50 items.                                                                                                                                                                                                                                                                                                                           | 50                                                                                                                                                                                                                                                                                                                                                                                     |
| `testmode`                                                                                                                                                                                                                                                                                                                                                                             | *Optional\<Boolean>*                                                                                                                                                                                                                                                                                                                                                                   | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                     | Most API credentials are specifically created for either live mode or test mode. In those cases the `testmode` query<br/>parameter can be omitted. For organization-level credentials such as OAuth access tokens, you can enable test mode by<br/>setting the `testmode` query parameter to `true`.<br/><br/>Test entities cannot be retrieved when the endpoint is set to live mode, and vice versa. |                                                                                                                                                                                                                                                                                                                                                                                        |
| `idempotencyKey`                                                                                                                                                                                                                                                                                                                                                                       | *Optional\<String>*                                                                                                                                                                                                                                                                                                                                                                    | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                     | A unique key to ensure idempotent requests. This key should be a UUID v4 string.                                                                                                                                                                                                                                                                                                       | 123e4567-e89b-12d3-a456-426                                                                                                                                                                                                                                                                                                                                                            |

### Response

**[ListSalesInvoicesResponse](../../models/operations/ListSalesInvoicesResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 400                         | application/hal+json        |
| models/errors/APIException  | 4XX, 5XX                    | \*/\*                       |

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
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.GetSalesInvoiceResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .testmode(false)
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        GetSalesInvoiceResponse res = sdk.salesInvoices().get()
                .id("invoice_4Y0eZitmBnQ6IDoMqZQKh")
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .call();

        if (res.entitySalesInvoiceResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                                                                                                                                                                                                                                                                                              | Type                                                                                                                                                                                                                                                                                                                                                                                   | Required                                                                                                                                                                                                                                                                                                                                                                               | Description                                                                                                                                                                                                                                                                                                                                                                            | Example                                                                                                                                                                                                                                                                                                                                                                                |
| -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `id`                                                                                                                                                                                                                                                                                                                                                                                   | *String*                                                                                                                                                                                                                                                                                                                                                                               | :heavy_check_mark:                                                                                                                                                                                                                                                                                                                                                                     | Provide the ID of the item you want to perform this operation on.                                                                                                                                                                                                                                                                                                                      |                                                                                                                                                                                                                                                                                                                                                                                        |
| `testmode`                                                                                                                                                                                                                                                                                                                                                                             | *Optional\<Boolean>*                                                                                                                                                                                                                                                                                                                                                                   | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                     | Most API credentials are specifically created for either live mode or test mode. In those cases the `testmode` query<br/>parameter can be omitted. For organization-level credentials such as OAuth access tokens, you can enable test mode by<br/>setting the `testmode` query parameter to `true`.<br/><br/>Test entities cannot be retrieved when the endpoint is set to live mode, and vice versa. |                                                                                                                                                                                                                                                                                                                                                                                        |
| `idempotencyKey`                                                                                                                                                                                                                                                                                                                                                                       | *Optional\<String>*                                                                                                                                                                                                                                                                                                                                                                    | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                     | A unique key to ensure idempotent requests. This key should be a UUID v4 string.                                                                                                                                                                                                                                                                                                       | 123e4567-e89b-12d3-a456-426                                                                                                                                                                                                                                                                                                                                                            |

### Response

**[GetSalesInvoiceResponse](../../models/operations/GetSalesInvoiceResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 404                         | application/hal+json        |
| models/errors/APIException  | 4XX, 5XX                    | \*/\*                       |

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
import com.mollie.mollie.models.components.*;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.UpdateSalesInvoiceResponse;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        UpdateSalesInvoiceResponse res = sdk.salesInvoices().update()
                .id("invoice_4Y0eZitmBnQ6IDoMqZQKh")
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .updateValuesSalesInvoice(UpdateValuesSalesInvoice.builder()
                    .testmode(false)
                    .status(SalesInvoiceStatus.DRAFT)
                    .memo("An updated memo!")
                    .paymentTerm(SalesInvoicePaymentTerm.THIRTYDAYS)
                    .paymentDetails(SalesInvoicePaymentDetails.builder()
                        .source(SalesInvoicePaymentDetailsSource.PAYMENT_LINK)
                        .sourceReference("pl_d9fQur83kFdhH8hIhaZfq")
                        .build())
                    .emailDetails(SalesInvoiceEmailDetails.builder()
                        .subject("Your invoice is available")
                        .body("Please find your invoice enclosed.")
                        .build())
                    .recipientIdentifier("customer-xyz-0123")
                    .recipient(SalesInvoiceRecipient.builder()
                        .type(SalesInvoiceRecipientType.CONSUMER)
                        .email("example@email.com")
                        .streetAndNumber("Keizersgracht 126")
                        .postalCode("5678AB")
                        .city("Amsterdam")
                        .country("NL")
                        .locale(SalesInvoiceRecipientLocale.NLNL)
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
                        SalesInvoiceLineItem.builder()
                            .description("LEGO 4440 Forest Police Station")
                            .quantity(1L)
                            .vatRate("21.00")
                            .unitPrice(Amount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .discount(SalesInvoiceDiscount.builder()
                                .type(SalesInvoiceDiscountType.AMOUNT)
                                .value("10.00")
                                .build())
                            .build()))
                    .discount(SalesInvoiceDiscount.builder()
                        .type(SalesInvoiceDiscountType.AMOUNT)
                        .value("10.00")
                        .build())
                    .build())
                .call();

        if (res.entitySalesInvoiceResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                  | Type                                                                                       | Required                                                                                   | Description                                                                                | Example                                                                                    |
| ------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------ |
| `id`                                                                                       | *String*                                                                                   | :heavy_check_mark:                                                                         | Provide the ID of the item you want to perform this operation on.                          |                                                                                            |
| `idempotencyKey`                                                                           | *Optional\<String>*                                                                        | :heavy_minus_sign:                                                                         | A unique key to ensure idempotent requests. This key should be a UUID v4 string.           | 123e4567-e89b-12d3-a456-426                                                                |
| `updateValuesSalesInvoice`                                                                 | [Optional\<UpdateValuesSalesInvoice>](../../models/components/UpdateValuesSalesInvoice.md) | :heavy_minus_sign:                                                                         | N/A                                                                                        |                                                                                            |

### Response

**[UpdateSalesInvoiceResponse](../../models/operations/UpdateSalesInvoiceResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 404, 422                    | application/hal+json        |
| models/errors/APIException  | 4XX, 5XX                    | \*/\*                       |

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
import com.mollie.mollie.models.components.DeleteValuesSalesInvoice;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.DeleteSalesInvoiceResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        DeleteSalesInvoiceResponse res = sdk.salesInvoices().delete()
                .id("invoice_4Y0eZitmBnQ6IDoMqZQKh")
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .deleteValuesSalesInvoice(DeleteValuesSalesInvoice.builder()
                    .testmode(false)
                    .build())
                .call();

        // handle response
    }
}
```

### Parameters

| Parameter                                                                                  | Type                                                                                       | Required                                                                                   | Description                                                                                | Example                                                                                    |
| ------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------ |
| `id`                                                                                       | *String*                                                                                   | :heavy_check_mark:                                                                         | Provide the ID of the item you want to perform this operation on.                          |                                                                                            |
| `idempotencyKey`                                                                           | *Optional\<String>*                                                                        | :heavy_minus_sign:                                                                         | A unique key to ensure idempotent requests. This key should be a UUID v4 string.           | 123e4567-e89b-12d3-a456-426                                                                |
| `deleteValuesSalesInvoice`                                                                 | [Optional\<DeleteValuesSalesInvoice>](../../models/components/DeleteValuesSalesInvoice.md) | :heavy_minus_sign:                                                                         | N/A                                                                                        |                                                                                            |

### Response

**[DeleteSalesInvoiceResponse](../../models/operations/DeleteSalesInvoiceResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 404, 422                    | application/hal+json        |
| models/errors/APIException  | 4XX, 5XX                    | \*/\*                       |