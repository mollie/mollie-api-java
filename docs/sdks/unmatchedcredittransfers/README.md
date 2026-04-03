# UnmatchedCreditTransfers

## Overview

### Available Operations

* [list](#list) - List unmatched credit transfers
* [get](#get) - Get unmatched credit transfer
* [match](#match) - Match unmatched credit transfer
* [return_](#return_) - Return unmatched credit transfer

## list

> 🚧 Beta feature
>
> This feature is currently in private beta, and the final specification may still change.

Retrieves a list of unmatched credit transfers for the profile.

The results are paginated.

### Example Usage

<!-- UsageSnippet language="java" operationID="list-unmatched-credit-transfers" method="get" path="/unmatched-credit-transfers" example="list-unmatched-credit-transfers-200-1" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.ListUnmatchedCreditTransfersResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();


        sdk.unmatchedCreditTransfers().list()
                .limit(50L)
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .callAsStream()
                .forEach((ListUnmatchedCreditTransfersResponse item) -> {
                   // handle page
                });

    }
}
```

### Parameters

| Parameter                                                                                                                      | Type                                                                                                                           | Required                                                                                                                       | Description                                                                                                                    | Example                                                                                                                        |
| ------------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------------ |
| `from`                                                                                                                         | *JsonNullable\<String>*                                                                                                        | :heavy_minus_sign:                                                                                                             | Provide an ID to start the result set from the item with the given ID and onwards. This allows you to paginate the<br/>result set. |                                                                                                                                |
| `limit`                                                                                                                        | *JsonNullable\<Long>*                                                                                                          | :heavy_minus_sign:                                                                                                             | The maximum number of items to return. Defaults to 50 items.                                                                   | 50                                                                                                                             |
| `idempotencyKey`                                                                                                               | *Optional\<String>*                                                                                                            | :heavy_minus_sign:                                                                                                             | A unique key to ensure idempotent requests. This key should be a UUID v4 string.                                               | 123e4567-e89b-12d3-a456-426                                                                                                    |

### Response

**[ListUnmatchedCreditTransfersResponse](../../models/operations/ListUnmatchedCreditTransfersResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 400                         | application/hal+json        |
| models/errors/APIException  | 4XX, 5XX                    | \*/\*                       |

## get

> 🚧 Beta feature
>
> This feature is currently in private beta, and the final specification may still change.

Retrieves a single unmatched credit transfer by its identifier.

### Example Usage

<!-- UsageSnippet language="java" operationID="get-unmatched-credit-transfer" method="get" path="/unmatched-credit-transfers/{unmatchedCreditTransferId}" example="get-unmatched-credit-transfer-200-1" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.GetUnmatchedCreditTransferResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        GetUnmatchedCreditTransferResponse res = sdk.unmatchedCreditTransfers().get()
                .unmatchedCreditTransferId("uct_abcDEFghij123456789")
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .call();

        if (res.entityUnmatchedCreditTransfer().isPresent()) {
            System.out.println(res.entityUnmatchedCreditTransfer().get());
        }
    }
}
```

### Parameters

| Parameter                                                                        | Type                                                                             | Required                                                                         | Description                                                                      | Example                                                                          |
| -------------------------------------------------------------------------------- | -------------------------------------------------------------------------------- | -------------------------------------------------------------------------------- | -------------------------------------------------------------------------------- | -------------------------------------------------------------------------------- |
| `unmatchedCreditTransferId`                                                      | *String*                                                                         | :heavy_check_mark:                                                               | Provide the ID of the related unmatched credit transfer.                         | uct_abcDEFghij123456789                                                          |
| `idempotencyKey`                                                                 | *Optional\<String>*                                                              | :heavy_minus_sign:                                                               | A unique key to ensure idempotent requests. This key should be a UUID v4 string. | 123e4567-e89b-12d3-a456-426                                                      |

### Response

**[GetUnmatchedCreditTransferResponse](../../models/operations/GetUnmatchedCreditTransferResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 404                         | application/hal+json        |
| models/errors/APIException  | 4XX, 5XX                    | \*/\*                       |

## match

> 🚧 Beta feature
>
> This feature is currently in private beta, and the final specification may still change.

Matches an unmatched credit transfer to one or more payments, settling the funds accordingly.

### Example Usage

<!-- UsageSnippet language="java" operationID="match-unmatched-credit-transfer" method="post" path="/unmatched-credit-transfers/{unmatchedCreditTransferId}/match" example="match-unmatched-credit-transfer-201-1" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.components.UnmatchedCreditTransferMatchRequest;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.MatchUnmatchedCreditTransferResponse;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        MatchUnmatchedCreditTransferResponse res = sdk.unmatchedCreditTransfers().match()
                .unmatchedCreditTransferId("uct_abcDEFghij123456789")
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .unmatchedCreditTransferMatchRequest(UnmatchedCreditTransferMatchRequest.builder()
                    .paymentIds(List.of(
                        "tr_5B8cwPMGnU"))
                    .build())
                .call();

        if (res.unmatchedCreditTransferActionResponse().isPresent()) {
            System.out.println(res.unmatchedCreditTransferActionResponse().get());
        }
    }
}
```

### Parameters

| Parameter                                                                                                        | Type                                                                                                             | Required                                                                                                         | Description                                                                                                      | Example                                                                                                          |
| ---------------------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------------- |
| `unmatchedCreditTransferId`                                                                                      | *String*                                                                                                         | :heavy_check_mark:                                                                                               | Provide the ID of the related unmatched credit transfer.                                                         | uct_abcDEFghij123456789                                                                                          |
| `idempotencyKey`                                                                                                 | *Optional\<String>*                                                                                              | :heavy_minus_sign:                                                                                               | A unique key to ensure idempotent requests. This key should be a UUID v4 string.                                 | 123e4567-e89b-12d3-a456-426                                                                                      |
| `unmatchedCreditTransferMatchRequest`                                                                            | [Optional\<UnmatchedCreditTransferMatchRequest>](../../models/components/UnmatchedCreditTransferMatchRequest.md) | :heavy_minus_sign:                                                                                               | N/A                                                                                                              |                                                                                                                  |

### Response

**[MatchUnmatchedCreditTransferResponse](../../models/operations/MatchUnmatchedCreditTransferResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 404, 422                    | application/hal+json        |
| models/errors/APIException  | 4XX, 5XX                    | \*/\*                       |

## return_

> 🚧 Beta feature
>
> This feature is currently in private beta, and the final specification may still change.

Returns an unmatched credit transfer, sending the funds back to the original sender.

### Example Usage

<!-- UsageSnippet language="java" operationID="return-unmatched-credit-transfer" method="post" path="/unmatched-credit-transfers/{unmatchedCreditTransferId}/return" example="return-unmatched-credit-transfer-201-1" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.ReturnUnmatchedCreditTransferResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        ReturnUnmatchedCreditTransferResponse res = sdk.unmatchedCreditTransfers().return_()
                .unmatchedCreditTransferId("uct_abcDEFghij123456789")
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .call();

        if (res.unmatchedCreditTransferActionResponse().isPresent()) {
            System.out.println(res.unmatchedCreditTransferActionResponse().get());
        }
    }
}
```

### Parameters

| Parameter                                                                        | Type                                                                             | Required                                                                         | Description                                                                      | Example                                                                          |
| -------------------------------------------------------------------------------- | -------------------------------------------------------------------------------- | -------------------------------------------------------------------------------- | -------------------------------------------------------------------------------- | -------------------------------------------------------------------------------- |
| `unmatchedCreditTransferId`                                                      | *String*                                                                         | :heavy_check_mark:                                                               | Provide the ID of the related unmatched credit transfer.                         | uct_abcDEFghij123456789                                                          |
| `idempotencyKey`                                                                 | *Optional\<String>*                                                              | :heavy_minus_sign:                                                               | A unique key to ensure idempotent requests. This key should be a UUID v4 string. | 123e4567-e89b-12d3-a456-426                                                      |

### Response

**[ReturnUnmatchedCreditTransferResponse](../../models/operations/ReturnUnmatchedCreditTransferResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 404                         | application/hal+json        |
| models/errors/APIException  | 4XX, 5XX                    | \*/\*                       |