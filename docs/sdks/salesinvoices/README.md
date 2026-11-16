# SalesInvoices

## Overview

### Available Operations

* [create](#create) - Create sales invoice
* [list](#list) - List sales invoices
* [get](#get) - Get sales invoice
* [update](#update) - Update sales invoice
* [delete](#delete) - Delete sales invoice

## create

With the Sales Invoice API you can generate sales invoices to send to your customers.

### Example Usage

<!-- UsageSnippet language="java" operationID="create-sales-invoice" method="post" path="/v2/sales-invoices" -->
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
                .xClientSignature("MEUCIQDx8sJvK3z...")
                .xClientSignedAt("2025-01-01T12:00:00Z")
                .salesInvoiceRequest(SalesInvoiceRequest.builder()
                    .status(SalesInvoiceStatus.DRAFT)
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
                    .testmode(false)
                    .profileId("pfl_QkEhN94Ba")
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
                    .discount(SalesInvoiceDiscount.builder()
                        .type(SalesInvoiceDiscountType.AMOUNT)
                        .value("10.00")
                        .build())
                    .isEInvoice(false)
                    .build())
                .call();

        if (res.salesInvoiceResponse().isPresent()) {
            System.out.println(res.salesInvoiceResponse().get());
        }
    }
}
```

### Parameters

| Parameter                                                                                                                                                                               | Type                                                                                                                                                                                    | Required                                                                                                                                                                                | Description                                                                                                                                                                             | Example                                                                                                                                                                                 |
| --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `idempotencyKey`                                                                                                                                                                        | *Optional\<String>*                                                                                                                                                                     | :heavy_minus_sign:                                                                                                                                                                      | A unique key to ensure idempotent requests. This key should be a UUID v4 string.                                                                                                        | 123e4567-e89b-12d3-a456-426                                                                                                                                                             |
| `xClientSignature`                                                                                                                                                                      | *Optional\<String>*                                                                                                                                                                     | :heavy_minus_sign:                                                                                                                                                                      | A cryptographic signature of the request, used to verify that it was sent by you and hasn't been tampered with. Required if you've enabled request signing for your integration.        | MEUCIQDx8sJvK3z...                                                                                                                                                                      |
| `xClientSignedAt`                                                                                                                                                                       | *Optional\<String>*                                                                                                                                                                     | :heavy_minus_sign:                                                                                                                                                                      | The timestamp, in ISO 8601 format, at which you generated the `X-Client-Signature`. Required together with `X-Client-Signature` if you've enabled request signing for your integration. | 2025-01-01T12:00:00Z                                                                                                                                                                    |
| `salesInvoiceRequest`                                                                                                                                                                   | [Optional\<SalesInvoiceRequest>](../../models/components/SalesInvoiceRequest.md)                                                                                                        | :heavy_minus_sign:                                                                                                                                                                      | N/A                                                                                                                                                                                     |                                                                                                                                                                                         |

### Response

**[CreateSalesInvoiceResponse](../../models/operations/CreateSalesInvoiceResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 404, 422, 429               | application/hal+json        |
| models/errors/APIException  | 4XX, 5XX                    | \*/\*                       |

## list

Retrieve a list of all sales invoices created through the API.

The results are paginated.

### Example Usage

<!-- UsageSnippet language="java" operationID="list-sales-invoices" method="get" path="/v2/sales-invoices" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.ListSalesInvoicesRequest;
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

        ListSalesInvoicesRequest req = ListSalesInvoicesRequest.builder()
                .from("invoice_4Y0eZitmBnQ6IDoMqZQKh")
                .limit(50L)
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .xClientSignature("MEUCIQDx8sJvK3z...")
                .xClientSignedAt("2025-01-01T12:00:00Z")
                .build();


        sdk.salesInvoices().list()
                .callAsStream()
                .forEach((ListSalesInvoicesResponse item) -> {
                   // handle page
                });

    }
}
```

### Parameters

| Parameter                                                                       | Type                                                                            | Required                                                                        | Description                                                                     |
| ------------------------------------------------------------------------------- | ------------------------------------------------------------------------------- | ------------------------------------------------------------------------------- | ------------------------------------------------------------------------------- |
| `request`                                                                       | [ListSalesInvoicesRequest](../../models/operations/ListSalesInvoicesRequest.md) | :heavy_check_mark:                                                              | The request object to use for the request.                                      |

### Response

**[ListSalesInvoicesResponse](../../models/operations/ListSalesInvoicesResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 400, 429                    | application/hal+json        |
| models/errors/APIException  | 4XX, 5XX                    | \*/\*                       |

## get

Retrieve a single sales invoice by its ID.

### Example Usage

<!-- UsageSnippet language="java" operationID="get-sales-invoice" method="get" path="/v2/sales-invoices/{salesInvoiceId}" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.GetSalesInvoiceRequest;
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

        GetSalesInvoiceRequest req = GetSalesInvoiceRequest.builder()
                .salesInvoiceId("invoice_4Y0eZitmBnQ6IDoMqZQKh")
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .xClientSignature("MEUCIQDx8sJvK3z...")
                .xClientSignedAt("2025-01-01T12:00:00Z")
                .build();

        GetSalesInvoiceResponse res = sdk.salesInvoices().get()
                .request(req)
                .call();

        if (res.salesInvoiceResponse().isPresent()) {
            System.out.println(res.salesInvoiceResponse().get());
        }
    }
}
```

### Parameters

| Parameter                                                                   | Type                                                                        | Required                                                                    | Description                                                                 |
| --------------------------------------------------------------------------- | --------------------------------------------------------------------------- | --------------------------------------------------------------------------- | --------------------------------------------------------------------------- |
| `request`                                                                   | [GetSalesInvoiceRequest](../../models/operations/GetSalesInvoiceRequest.md) | :heavy_check_mark:                                                          | The request object to use for the request.                                  |

### Response

**[GetSalesInvoiceResponse](../../models/operations/GetSalesInvoiceResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 404, 429                    | application/hal+json        |
| models/errors/APIException  | 4XX, 5XX                    | \*/\*                       |

## update

Certain details of an existing sales invoice can be updated. For `draft` it is all values listed below, but for
statuses `paid` and `issued` there are certain additional requirements (`paymentDetails` and `emailDetails`,
respectively).

### Example Usage

<!-- UsageSnippet language="java" operationID="update-sales-invoice" method="patch" path="/v2/sales-invoices/{salesInvoiceId}" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.*;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.*;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        UpdateSalesInvoiceRequest req = UpdateSalesInvoiceRequest.builder()
                .salesInvoiceId("invoice_4Y0eZitmBnQ6IDoMqZQKh")
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .xClientSignature("MEUCIQDx8sJvK3z...")
                .xClientSignedAt("2025-01-01T12:00:00Z")
                .requestBody(UpdateSalesInvoiceRequestBody.builder()
                    .testmode(false)
                    .status(SalesInvoiceStatusUpdate.DRAFT)
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
                    .isEInvoice(false)
                    .build())
                .build();

        UpdateSalesInvoiceResponse res = sdk.salesInvoices().update()
                .request(req)
                .call();

        if (res.salesInvoiceResponse().isPresent()) {
            System.out.println(res.salesInvoiceResponse().get());
        }
    }
}
```

### Parameters

| Parameter                                                                         | Type                                                                              | Required                                                                          | Description                                                                       |
| --------------------------------------------------------------------------------- | --------------------------------------------------------------------------------- | --------------------------------------------------------------------------------- | --------------------------------------------------------------------------------- |
| `request`                                                                         | [UpdateSalesInvoiceRequest](../../models/operations/UpdateSalesInvoiceRequest.md) | :heavy_check_mark:                                                                | The request object to use for the request.                                        |

### Response

**[UpdateSalesInvoiceResponse](../../models/operations/UpdateSalesInvoiceResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 404, 422, 429               | application/hal+json        |
| models/errors/APIException  | 4XX, 5XX                    | \*/\*                       |

## delete

Sales invoices which are in status `draft` can be deleted. For all other statuses, please use the
[Update sales invoice](update-sales-invoice) endpoint instead.

### Example Usage

<!-- UsageSnippet language="java" operationID="delete-sales-invoice" method="delete" path="/v2/sales-invoices/{salesInvoiceId}" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.DeleteValuesSalesInvoice;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.DeleteSalesInvoiceRequest;
import com.mollie.mollie.models.operations.DeleteSalesInvoiceResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        DeleteSalesInvoiceRequest req = DeleteSalesInvoiceRequest.builder()
                .salesInvoiceId("invoice_4Y0eZitmBnQ6IDoMqZQKh")
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .xClientSignature("MEUCIQDx8sJvK3z...")
                .xClientSignedAt("2025-01-01T12:00:00Z")
                .deleteValuesSalesInvoice(DeleteValuesSalesInvoice.builder()
                    .testmode(false)
                    .build())
                .build();

        DeleteSalesInvoiceResponse res = sdk.salesInvoices().delete()
                .request(req)
                .call();

        // handle response
    }
}
```

### Parameters

| Parameter                                                                         | Type                                                                              | Required                                                                          | Description                                                                       |
| --------------------------------------------------------------------------------- | --------------------------------------------------------------------------------- | --------------------------------------------------------------------------------- | --------------------------------------------------------------------------------- |
| `request`                                                                         | [DeleteSalesInvoiceRequest](../../models/operations/DeleteSalesInvoiceRequest.md) | :heavy_check_mark:                                                                | The request object to use for the request.                                        |

### Response

**[DeleteSalesInvoiceResponse](../../models/operations/DeleteSalesInvoiceResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 404, 422, 429               | application/hal+json        |
| models/errors/APIException  | 4XX, 5XX                    | \*/\*                       |