# Transfers

## Overview

### Available Operations

* [create](#create) - Create transfer
* [get](#get) - Get transfer

## create

> 🚧 Beta feature
>
> This feature is currently in beta testing, and the final specification may still change.

Create a SEPA Credit Transfer from your Mollie Business Account.

To initiate a transfer, you must provide the transfer scheme, the amount, the debtor IBAN (your Mollie Business
Account IBAN), and the creditor (recipient) details.

Each request must include an `Idempotency-Key` header to prevent duplicate transfers, and must be signed using the
`X-Client-Signature` and `X-Client-Signed-At` headers.

### Simulating transfer scenarios in test mode

In test mode, you can simulate various transfer scenarios by adjusting the transfer amount. This allows you to
mimic the typical status progression of a real-world transfer. Note that a transfer's progression will stop once
it reaches a final status: `blocked`, `failed`, `processed`, or `returned`.

| Amount  | Scenario                                            | Webhook sequence                                                                                                                                                   |
|---------|-----------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| `11.00` | Transfer initiated, pending review by Mollie        | `business-account-transfer.requested` → `business-account-transfer.initiated` → `business-account-transfer.pending-review`                                         |
| `12.00` | Transfer initiated, blocked by Mollie               | `business-account-transfer.requested` → `business-account-transfer.initiated` → `business-account-transfer.pending-review` → `business-account-transfer.blocked`   |
| `13.00` | Transfer initiated, failed on scheme submission     | `business-account-transfer.requested` → `business-account-transfer.initiated` → `business-account-transfer.failed`                                                 |
| `14.00` | Transfer processed, then returned by receiving bank | `business-account-transfer.requested` → `business-account-transfer.initiated` → `business-account-transfer.processed` → `business-account-transfer.returned`       |
| Other   | Default: transfer is processed                      | `business-account-transfer.requested` → `business-account-transfer.initiated` → `business-account-transfer.processed`                                              |

### Example Usage

<!-- UsageSnippet language="java" operationID="create-transfer" method="post" path="/business-accounts/transfers" example="create-transfer-201" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.*;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.CreateTransferRequest;
import com.mollie.mollie.models.operations.CreateTransferResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .organizationAccessToken(System.getenv().getOrDefault("ORGANIZATION_ACCESS_TOKEN", ""))
                    .build())
            .build();

        CreateTransferRequest req = CreateTransferRequest.builder()
                .xClientSignature("<value>")
                .xClientSignedAt("2025-01-01T12:00:00Z")
                .idempotencyKey("aa84d3c0-1484-4f45-8a8d-4674a0147f3f")
                .idempotencyKey1("123e4567-e89b-12d3-a456-426")
                .transferRequest(TransferRequest.builder()
                    .debtorIban("NL55MLLE0123456789")
                    .creditor(TransferParty.builder()
                        .fullName("Jan Jansen")
                        .account(Account.builder()
                            .iban("NL02ABNA0123456789")
                            .build())
                        .build())
                    .amount(Amount.builder()
                        .currency("EUR")
                        .value("10.00")
                        .build())
                    .transferScheme(TransferScheme.builder()
                        .type(TransferSchemeType.SEPA_CREDIT_INST)
                        .build())
                    .description("Invoice 12345")
                    .testmode(false)
                    .build())
                .build();

        CreateTransferResponse res = sdk.transfers().create()
                .request(req)
                .call();

        if (res.transferResponse().isPresent()) {
            System.out.println(res.transferResponse().get());
        }
    }
}
```

### Parameters

| Parameter                                                                 | Type                                                                      | Required                                                                  | Description                                                               |
| ------------------------------------------------------------------------- | ------------------------------------------------------------------------- | ------------------------------------------------------------------------- | ------------------------------------------------------------------------- |
| `request`                                                                 | [CreateTransferRequest](../../models/operations/CreateTransferRequest.md) | :heavy_check_mark:                                                        | The request object to use for the request.                                |

### Response

**[CreateTransferResponse](../../models/operations/CreateTransferResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 422                         | application/hal+json        |
| models/errors/ErrorResponse | 503                         | application/hal+json        |
| models/errors/APIException  | 4XX, 5XX                    | \*/\*                       |

## get

> 🚧 Beta feature
>
> This feature is currently in beta testing, and the final specification may still change.

Retrieve a single transfer object by its transfer ID. This allows you to check the current status
and details of a previously created transfer.

### Example Usage: get-transfer-200

<!-- UsageSnippet language="java" operationID="get-transfer" method="get" path="/business-accounts/transfers/{businessAccountsTransferId}" example="get-transfer-200" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.GetTransferResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .testmode(false)
                .security(Security.builder()
                    .organizationAccessToken(System.getenv().getOrDefault("ORGANIZATION_ACCESS_TOKEN", ""))
                    .build())
            .build();

        GetTransferResponse res = sdk.transfers().get()
                .businessAccountsTransferId("batrf_87GByBuj4UCcUTEbs6aGJ")
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .call();

        if (res.transferResponse().isPresent()) {
            System.out.println(res.transferResponse().get());
        }
    }
}
```
### Example Usage: processed-transfer

<!-- UsageSnippet language="java" operationID="get-transfer" method="get" path="/business-accounts/transfers/{businessAccountsTransferId}" example="processed-transfer" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.GetTransferResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .testmode(false)
                .security(Security.builder()
                    .organizationAccessToken(System.getenv().getOrDefault("ORGANIZATION_ACCESS_TOKEN", ""))
                    .build())
            .build();

        GetTransferResponse res = sdk.transfers().get()
                .businessAccountsTransferId("batrf_87GByBuj4UCcUTEbs6aGJ")
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .call();

        if (res.transferResponse().isPresent()) {
            System.out.println(res.transferResponse().get());
        }
    }
}
```

### Parameters

| Parameter                                                                                                                                                                                                                                                                                                                                                                                | Type                                                                                                                                                                                                                                                                                                                                                                                     | Required                                                                                                                                                                                                                                                                                                                                                                                 | Description                                                                                                                                                                                                                                                                                                                                                                              | Example                                                                                                                                                                                                                                                                                                                                                                                  |
| ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `businessAccountsTransferId`                                                                                                                                                                                                                                                                                                                                                             | *String*                                                                                                                                                                                                                                                                                                                                                                                 | :heavy_check_mark:                                                                                                                                                                                                                                                                                                                                                                       | Provide the ID of the related transfer.                                                                                                                                                                                                                                                                                                                                                  | batrf_87GByBuj4UCcUTEbs6aGJ                                                                                                                                                                                                                                                                                                                                                              |
| `testmode`                                                                                                                                                                                                                                                                                                                                                                               | *Optional\<Boolean>*                                                                                                                                                                                                                                                                                                                                                                     | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                       | Most API credentials are specifically created for either live mode or test mode. In those cases the `testmode` query<br/>parameter must not be sent. For organization-level credentials such as OAuth access tokens, you can enable test mode by<br/>setting the `testmode` query parameter to `true`.<br/><br/>Test entities cannot be retrieved when the endpoint is set to live mode, and vice versa. |                                                                                                                                                                                                                                                                                                                                                                                          |
| `idempotencyKey`                                                                                                                                                                                                                                                                                                                                                                         | *Optional\<String>*                                                                                                                                                                                                                                                                                                                                                                      | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                       | A unique key to ensure idempotent requests. This key should be a UUID v4 string.                                                                                                                                                                                                                                                                                                         | 123e4567-e89b-12d3-a456-426                                                                                                                                                                                                                                                                                                                                                              |

### Response

**[GetTransferResponse](../../models/operations/GetTransferResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 404                         | application/hal+json        |
| models/errors/APIException  | 4XX, 5XX                    | \*/\*                       |