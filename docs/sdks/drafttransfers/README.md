# DraftTransfers

## Overview

### Available Operations

* [create](#create) - Create draft transfer
* [list](#list) - List draft transfers
* [get](#get) - Get draft transfer
* [cancel](#cancel) - Cancel draft transfer

## create

> 🚧 Beta feature
>
> This feature is currently in beta testing, and the final specification may still change.

Creates a draft transfer. The draft transfer immediately enters `awaiting-initiation` and appears in the
initiator's queue in Mollie Apps. It carries no legal weight and moves no funds until a human initiator
approves it there.

### Test mode

| Action | Test-mode behavior |
|---|---|
| Create | Always returns a synthetic draft in `awaiting-initiation`, regardless of most input values |
| Get / List | Always returns synthetic `awaiting-initiation` draft(s), not your real data |
| Cancel | Always returns a synthetic `declined` draft |

There is currently no way to synthesize an `initiated` draft via test mode alone. Initiation only happens when
a real initiator approves in Mollie Apps, which test mode doesn't touch.

### Example Usage

<!-- UsageSnippet language="java" operationID="create-draft-transfer" method="post" path="/v2/business-accounts/draft-transfers" example="create-draft-transfer-201" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.*;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.CreateDraftTransferResponse;
import java.lang.Exception;
import java.time.LocalDate;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .advancedAccessToken(System.getenv().getOrDefault("ADVANCED_ACCESS_TOKEN", ""))
                    .build())
            .build();

        CreateDraftTransferResponse res = sdk.draftTransfers().create()
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .createDraftTransferRequest(CreateDraftTransferRequest.builder()
                    .creditor(DraftTransferParty.builder()
                        .fullName("Jan Jansen")
                        .account(DraftTransferPartyAccount.builder()
                            .iban("NL02ABNA0123456789")
                            .build())
                        .build())
                    .amount(Amount.builder()
                        .currency("EUR")
                        .value("10.00")
                        .build())
                    .description("Invoice 12345")
                    .debtorIban("NL55MLLE0123456789")
                    .scheduledFor(LocalDate.parse("2025-03-01"))
                    .build())
                .call();

        if (res.draftTransferResponse().isPresent()) {
            System.out.println(res.draftTransferResponse().get());
        }
    }
}
```

### Parameters

| Parameter                                                                                      | Type                                                                                           | Required                                                                                       | Description                                                                                    | Example                                                                                        |
| ---------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------- |
| `idempotencyKey`                                                                               | *Optional\<String>*                                                                            | :heavy_minus_sign:                                                                             | A unique key to ensure idempotent requests. This key should be a UUID v4 string.               | 123e4567-e89b-12d3-a456-426                                                                    |
| `createDraftTransferRequest`                                                                   | [Optional\<CreateDraftTransferRequest>](../../models/components/CreateDraftTransferRequest.md) | :heavy_minus_sign:                                                                             | N/A                                                                                            |                                                                                                |

### Response

**[CreateDraftTransferResponse](../../models/operations/CreateDraftTransferResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 422, 429                    | application/hal+json        |
| models/errors/APIException  | 4XX, 5XX                    | \*/\*                       |

## list

> 🚧 Beta feature
>
> This feature is currently in beta testing, and the final specification may still change.

Retrieves a list of draft transfers for the organization including ones created in Mollie Apps, not just
ones created via this API.

The results are paginated.

In test mode, this always returns a synthetic `awaiting-initiation` list. See [Create draft
transfer](create-draft-transfer) for full test-mode behavior.

### Example Usage

<!-- UsageSnippet language="java" operationID="list-draft-transfers" method="get" path="/v2/business-accounts/draft-transfers" example="list-draft-transfers-200" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.*;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.ListDraftTransfersRequest;
import com.mollie.mollie.models.operations.ListDraftTransfersResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .advancedAccessToken(System.getenv().getOrDefault("ADVANCED_ACCESS_TOKEN", ""))
                    .build())
            .build();

        ListDraftTransfersRequest req = ListDraftTransfersRequest.builder()
                .limit(50L)
                .status(DraftTransferStatus.AWAITING_INITIATION)
                .source(DraftTransferSource.API)
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .build();


        sdk.draftTransfers().list()
                .callAsStream()
                .forEach((ListDraftTransfersResponse item) -> {
                   // handle page
                });

    }
}
```

### Parameters

| Parameter                                                                         | Type                                                                              | Required                                                                          | Description                                                                       |
| --------------------------------------------------------------------------------- | --------------------------------------------------------------------------------- | --------------------------------------------------------------------------------- | --------------------------------------------------------------------------------- |
| `request`                                                                         | [ListDraftTransfersRequest](../../models/operations/ListDraftTransfersRequest.md) | :heavy_check_mark:                                                                | The request object to use for the request.                                        |

### Response

**[ListDraftTransfersResponse](../../models/operations/ListDraftTransfersResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 400, 429                    | application/hal+json        |
| models/errors/APIException  | 4XX, 5XX                    | \*/\*                       |

## get

> 🚧 Beta feature
>
> This feature is currently in beta testing, and the final specification may still change.

Retrieves a single draft transfer by its identifier.

Only draft transfers created via this API are visible via this endpoint. Draft transfers created in Mollie
Apps return a `404`, even though they appear in the [list endpoint](list-draft-transfers).

In test mode, this always returns a synthetic `awaiting-initiation` draft. See [Create draft
transfer](create-draft-transfer) for full test-mode behavior.

### Example Usage: get-draft-transfer-200

<!-- UsageSnippet language="java" operationID="get-draft-transfer" method="get" path="/v2/business-accounts/draft-transfers/{draftTransferId}" example="get-draft-transfer-200" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.GetDraftTransferResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .advancedAccessToken(System.getenv().getOrDefault("ADVANCED_ACCESS_TOKEN", ""))
                    .build())
            .build();

        GetDraftTransferResponse res = sdk.draftTransfers().get()
                .draftTransferId("badrt_87GByBuj4UCcUTEbs6aGJ")
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .call();

        if (res.draftTransferResponse().isPresent()) {
            System.out.println(res.draftTransferResponse().get());
        }
    }
}
```
### Example Usage: initiated-draft-transfer

<!-- UsageSnippet language="java" operationID="get-draft-transfer" method="get" path="/v2/business-accounts/draft-transfers/{draftTransferId}" example="initiated-draft-transfer" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.GetDraftTransferResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .advancedAccessToken(System.getenv().getOrDefault("ADVANCED_ACCESS_TOKEN", ""))
                    .build())
            .build();

        GetDraftTransferResponse res = sdk.draftTransfers().get()
                .draftTransferId("badrt_87GByBuj4UCcUTEbs6aGJ")
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .call();

        if (res.draftTransferResponse().isPresent()) {
            System.out.println(res.draftTransferResponse().get());
        }
    }
}
```

### Parameters

| Parameter                                                                        | Type                                                                             | Required                                                                         | Description                                                                      | Example                                                                          |
| -------------------------------------------------------------------------------- | -------------------------------------------------------------------------------- | -------------------------------------------------------------------------------- | -------------------------------------------------------------------------------- | -------------------------------------------------------------------------------- |
| `draftTransferId`                                                                | *String*                                                                         | :heavy_check_mark:                                                               | Provide the ID of the related draft transfer.                                    | badrt_87GByBuj4UCcUTEbs6aGJ                                                      |
| `idempotencyKey`                                                                 | *Optional\<String>*                                                              | :heavy_minus_sign:                                                               | A unique key to ensure idempotent requests. This key should be a UUID v4 string. | 123e4567-e89b-12d3-a456-426                                                      |

### Response

**[GetDraftTransferResponse](../../models/operations/GetDraftTransferResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 404, 429                    | application/hal+json        |
| models/errors/APIException  | 4XX, 5XX                    | \*/\*                       |

## cancel

> 🚧 Beta feature
>
> This feature is currently in beta testing, and the final specification may still change.

Cancels a draft transfer created via this API. Transitions the draft transfer to `declined` with
`statusReason` set to `"Declined by creator"`.

Only draft transfers created via this API, and still in `awaiting-initiation`, can be cancelled this way. A
`422` is returned if the initiator has already started approving it.

In test mode, this always returns a synthetic `declined` draft. See [Create draft
transfer](create-draft-transfer) for full test-mode behavior.

### Example Usage

<!-- UsageSnippet language="java" operationID="cancel-draft-transfer" method="delete" path="/v2/business-accounts/draft-transfers/{draftTransferId}" example="cancel-draft-transfer-200" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.CancelDraftTransferResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .advancedAccessToken(System.getenv().getOrDefault("ADVANCED_ACCESS_TOKEN", ""))
                    .build())
            .build();

        CancelDraftTransferResponse res = sdk.draftTransfers().cancel()
                .draftTransferId("badrt_87GByBuj4UCcUTEbs6aGJ")
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .call();

        if (res.draftTransferResponse().isPresent()) {
            System.out.println(res.draftTransferResponse().get());
        }
    }
}
```

### Parameters

| Parameter                                                                        | Type                                                                             | Required                                                                         | Description                                                                      | Example                                                                          |
| -------------------------------------------------------------------------------- | -------------------------------------------------------------------------------- | -------------------------------------------------------------------------------- | -------------------------------------------------------------------------------- | -------------------------------------------------------------------------------- |
| `draftTransferId`                                                                | *String*                                                                         | :heavy_check_mark:                                                               | Provide the ID of the related draft transfer.                                    | badrt_87GByBuj4UCcUTEbs6aGJ                                                      |
| `idempotencyKey`                                                                 | *Optional\<String>*                                                              | :heavy_minus_sign:                                                               | A unique key to ensure idempotent requests. This key should be a UUID v4 string. | 123e4567-e89b-12d3-a456-426                                                      |

### Response

**[CancelDraftTransferResponse](../../models/operations/CancelDraftTransferResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 404, 422, 429               | application/hal+json        |
| models/errors/APIException  | 4XX, 5XX                    | \*/\*                       |