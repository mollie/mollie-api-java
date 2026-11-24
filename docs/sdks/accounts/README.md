# Accounts

## Overview

### Available Operations

* [createAccount](#createaccount) - Create business account
* [listAccounts](#listaccounts) - List business accounts
* [getAccount](#getaccount) - Get business account
* [list](#list) - List transactions
* [get](#get) - Get transaction

## createAccount

> 🚧 Beta feature
>
> This feature is currently in beta testing, and the final specification may still change.

> 🔐 **Request signing required**
>
> Signature enforcement is mandatory for Direct Customer API users for `live` mode requests.
>
> Sign every request with the `X-Client-Signature` and `X-Client-Signed-At` headers.
>
> [Learn how to sign requests](https://docs.mollie.com/reference/request-signing)

Create a new business account for the authenticated organization.

The response contains the newly created business account.

Each organization can have up to 5 active business accounts. Need more? [Contact us](https://www.mollie.com/contact)
and we'll help you out.

### Example Usage

<!-- UsageSnippet language="java" operationID="create-business-account" method="post" path="/v2/business-accounts/accounts" example="create-business-account-201" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.AccountCurrency;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.CreateBusinessAccountRequestBody;
import com.mollie.mollie.models.operations.CreateBusinessAccountResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .oAuth(System.getenv().getOrDefault("O_AUTH", ""))
                    .build())
            .build();

        CreateBusinessAccountResponse res = sdk.accounts().createAccount()
                .idempotencyKey("123e4567-e89b-12d3-a456-426614174000")
                .xClientSignature("MEUCIQDx8sJvK3z...")
                .xClientSignedAt("2025-01-01T12:00:00Z")
                .requestBody(CreateBusinessAccountRequestBody.builder()
                    .name("Main Checking Account")
                    .currency(AccountCurrency.EUR)
                    .testmode(false)
                    .build())
                .call();

        if (res.businessAccountResponse().isPresent()) {
            System.out.println(res.businessAccountResponse().get());
        }
    }
}
```

### Parameters

| Parameter                                                                                                                                                                                                                                                                                                                                                                                                                           | Type                                                                                                                                                                                                                                                                                                                                                                                                                                | Required                                                                                                                                                                                                                                                                                                                                                                                                                            | Description                                                                                                                                                                                                                                                                                                                                                                                                                         | Example                                                                                                                                                                                                                                                                                                                                                                                                                             |
| ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `idempotencyKey`                                                                                                                                                                                                                                                                                                                                                                                                                    | *Optional\<String>*                                                                                                                                                                                                                                                                                                                                                                                                                 | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                                                                  | A unique value that identifies this request, so you can safely retry it without creating a second account.<br/>Retrying with the same key within one hour returns the original response. We recommend a UUIDv4.<br/><br/>Keys are tied to the credential that sent the original request, so a refreshed OAuth token won't match<br/>earlier keys. View the [public documentation](https://docs.mollie.com/reference/api-idempotency) to learn<br/>more. | 00000000-0000-0000-0000-000000000000                                                                                                                                                                                                                                                                                                                                                                                                |
| `xClientSignature`                                                                                                                                                                                                                                                                                                                                                                                                                  | *Optional\<String>*                                                                                                                                                                                                                                                                                                                                                                                                                 | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                                                                  | A cryptographic signature of the request, used to verify that it was sent by you and hasn't been tampered with. Required if you've enabled request signing for your integration.                                                                                                                                                                                                                                                    | MEUCIQDx8sJvK3z...                                                                                                                                                                                                                                                                                                                                                                                                                  |
| `xClientSignedAt`                                                                                                                                                                                                                                                                                                                                                                                                                   | *Optional\<String>*                                                                                                                                                                                                                                                                                                                                                                                                                 | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                                                                  | The timestamp, in ISO 8601 format, at which you generated the `X-Client-Signature`. Required together with `X-Client-Signature` if you've enabled request signing for your integration.                                                                                                                                                                                                                                             | 2025-01-01T12:00:00Z                                                                                                                                                                                                                                                                                                                                                                                                                |
| `requestBody`                                                                                                                                                                                                                                                                                                                                                                                                                       | [Optional\<CreateBusinessAccountRequestBody>](../../models/operations/CreateBusinessAccountRequestBody.md)                                                                                                                                                                                                                                                                                                                          | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                                                                  | N/A                                                                                                                                                                                                                                                                                                                                                                                                                                 |                                                                                                                                                                                                                                                                                                                                                                                                                                     |

### Response

**[CreateBusinessAccountResponse](../../models/operations/CreateBusinessAccountResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 400, 409, 422, 429          | application/hal+json        |
| models/errors/APIException  | 4XX, 5XX                    | \*/\*                       |

## listAccounts

> 🔐 **Request signing required**
>
> Signature enforcement is mandatory for Direct Customer API users for `live` mode requests.
>
> Sign every request with the `X-Client-Signature` and `X-Client-Signed-At` headers.
>
> [Learn how to sign requests](https://docs.mollie.com/reference/request-signing)

Retrieve all business accounts for the authenticated organization.

The results are paginated.

### Example Usage

<!-- UsageSnippet language="java" operationID="list-business-accounts" method="get" path="/v2/business-accounts/accounts" example="list-business-accounts-200" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.components.Sorting;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.ListBusinessAccountsRequest;
import com.mollie.mollie.models.operations.ListBusinessAccountsResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .testmode(true)
                .security(Security.builder()
                    .oAuth(System.getenv().getOrDefault("O_AUTH", ""))
                    .build())
            .build();

        ListBusinessAccountsRequest req = ListBusinessAccountsRequest.builder()
                .iban("NL95MLLE1234567890")
                .from("ba_nopqrstuvwxyz23456789A")
                .limit(50L)
                .sort(Sorting.DESC)
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .xClientSignature("MEUCIQDx8sJvK3z...")
                .xClientSignedAt("2025-01-01T12:00:00Z")
                .build();


        sdk.accounts().listAccounts()
                .callAsStream()
                .forEach((ListBusinessAccountsResponse item) -> {
                   // handle page
                });

    }
}
```

### Parameters

| Parameter                                                                             | Type                                                                                  | Required                                                                              | Description                                                                           |
| ------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------- |
| `request`                                                                             | [ListBusinessAccountsRequest](../../models/operations/ListBusinessAccountsRequest.md) | :heavy_check_mark:                                                                    | The request object to use for the request.                                            |

### Response

**[ListBusinessAccountsResponse](../../models/operations/ListBusinessAccountsResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 400, 429                    | application/hal+json        |
| models/errors/APIException  | 4XX, 5XX                    | \*/\*                       |

## getAccount

> 🔐 **Request signing required**
>
> Signature enforcement is mandatory for Direct Customer API users for `live` mode requests.
>
> Sign every request with the `X-Client-Signature` and `X-Client-Signed-At` headers.
>
> [Learn how to sign requests](https://docs.mollie.com/reference/request-signing)

Retrieve a single business account object by its account ID. This allows you to check the current status,
balance, and account details.

### Example Usage

<!-- UsageSnippet language="java" operationID="get-business-account" method="get" path="/v2/business-accounts/accounts/{businessAccountId}" example="get-business-account-200" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.GetBusinessAccountRequest;
import com.mollie.mollie.models.operations.GetBusinessAccountResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .testmode(true)
                .security(Security.builder()
                    .oAuth(System.getenv().getOrDefault("O_AUTH", ""))
                    .build())
            .build();

        GetBusinessAccountRequest req = GetBusinessAccountRequest.builder()
                .businessAccountId("ba_nopqrstuvwxyz23456789A")
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .xClientSignature("MEUCIQDx8sJvK3z...")
                .xClientSignedAt("2025-01-01T12:00:00Z")
                .build();

        GetBusinessAccountResponse res = sdk.accounts().getAccount()
                .request(req)
                .call();

        if (res.businessAccountResponse().isPresent()) {
            System.out.println(res.businessAccountResponse().get());
        }
    }
}
```

### Parameters

| Parameter                                                                         | Type                                                                              | Required                                                                          | Description                                                                       |
| --------------------------------------------------------------------------------- | --------------------------------------------------------------------------------- | --------------------------------------------------------------------------------- | --------------------------------------------------------------------------------- |
| `request`                                                                         | [GetBusinessAccountRequest](../../models/operations/GetBusinessAccountRequest.md) | :heavy_check_mark:                                                                | The request object to use for the request.                                        |

### Response

**[GetBusinessAccountResponse](../../models/operations/GetBusinessAccountResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 404, 429                    | application/hal+json        |
| models/errors/APIException  | 4XX, 5XX                    | \*/\*                       |

## list

> 🔐 **Request signing required**
>
> Signature enforcement is mandatory for Direct Customer API users for `live` mode requests.
>
> Sign every request with the `X-Client-Signature` and `X-Client-Signed-At` headers.
>
> [Learn how to sign requests](https://docs.mollie.com/reference/request-signing)

Retrieve all transactions for a specific business account.

The results are paginated.

### Example Usage

<!-- UsageSnippet language="java" operationID="list-business-account-transactions" method="get" path="/v2/business-accounts/accounts/{businessAccountId}/transactions" example="list-transactions-200" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.*;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.ListBusinessAccountTransactionsRequest;
import com.mollie.mollie.models.operations.ListBusinessAccountTransactionsResponse;
import java.lang.Exception;
import java.time.OffsetDateTime;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .testmode(true)
                .security(Security.builder()
                    .oAuth(System.getenv().getOrDefault("O_AUTH", ""))
                    .build())
            .build();

        ListBusinessAccountTransactionsRequest req = ListBusinessAccountTransactionsRequest.builder()
                .businessAccountId("ba_nopqrstuvwxyz23456789A")
                .creditDebitIndicator(CreditDebitIndicator.DEBIT)
                .processedAfter(OffsetDateTime.parse("2025-02-01T00:00:00+00:00"))
                .processedBefore(OffsetDateTime.parse("2025-02-26T23:59:59+00:00"))
                .from("batr_87GByBuj4UCcUTEbs6aGJ")
                .limit(50L)
                .sort(Sorting.DESC)
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .xClientSignature("MEUCIQDx8sJvK3z...")
                .xClientSignedAt("2025-01-01T12:00:00Z")
                .build();


        sdk.accounts().list()
                .callAsStream()
                .forEach((ListBusinessAccountTransactionsResponse item) -> {
                   // handle page
                });

    }
}
```

### Parameters

| Parameter                                                                                                   | Type                                                                                                        | Required                                                                                                    | Description                                                                                                 |
| ----------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------- |
| `request`                                                                                                   | [ListBusinessAccountTransactionsRequest](../../models/operations/ListBusinessAccountTransactionsRequest.md) | :heavy_check_mark:                                                                                          | The request object to use for the request.                                                                  |

### Response

**[ListBusinessAccountTransactionsResponse](../../models/operations/ListBusinessAccountTransactionsResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 400, 429                    | application/hal+json        |
| models/errors/APIException  | 4XX, 5XX                    | \*/\*                       |

## get

> 🔐 **Request signing required**
>
> Signature enforcement is mandatory for Direct Customer API users for `live` mode requests.
>
> Sign every request with the `X-Client-Signature` and `X-Client-Signed-At` headers.
>
> [Learn how to sign requests](https://docs.mollie.com/reference/request-signing)

Retrieve a single transaction object by its transaction ID. This allows you to check the details,
amount, counterparty, and balance impact of a specific transaction.

### Example Usage: get-transaction-200

<!-- UsageSnippet language="java" operationID="get-business-account-transaction" method="get" path="/v2/business-accounts/accounts/{businessAccountId}/transactions/{transactionId}" example="get-transaction-200" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.GetBusinessAccountTransactionRequest;
import com.mollie.mollie.models.operations.GetBusinessAccountTransactionResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .testmode(true)
                .security(Security.builder()
                    .oAuth(System.getenv().getOrDefault("O_AUTH", ""))
                    .build())
            .build();

        GetBusinessAccountTransactionRequest req = GetBusinessAccountTransactionRequest.builder()
                .businessAccountId("ba_nopqrstuvwxyz23456789A")
                .transactionId("batr_87GByBuj4UCcUTEbs6aGJ")
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .xClientSignature("MEUCIQDx8sJvK3z...")
                .xClientSignedAt("2025-01-01T12:00:00Z")
                .build();

        GetBusinessAccountTransactionResponse res = sdk.accounts().get()
                .request(req)
                .call();

        if (res.transactionResponse().isPresent()) {
            System.out.println(res.transactionResponse().get());
        }
    }
}
```
### Example Usage: get-transaction-200-credit

<!-- UsageSnippet language="java" operationID="get-business-account-transaction" method="get" path="/v2/business-accounts/accounts/{businessAccountId}/transactions/{transactionId}" example="get-transaction-200-credit" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.GetBusinessAccountTransactionRequest;
import com.mollie.mollie.models.operations.GetBusinessAccountTransactionResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .testmode(true)
                .security(Security.builder()
                    .oAuth(System.getenv().getOrDefault("O_AUTH", ""))
                    .build())
            .build();

        GetBusinessAccountTransactionRequest req = GetBusinessAccountTransactionRequest.builder()
                .businessAccountId("ba_nopqrstuvwxyz23456789A")
                .transactionId("batr_87GByBuj4UCcUTEbs6aGJ")
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .xClientSignature("MEUCIQDx8sJvK3z...")
                .xClientSignedAt("2025-01-01T12:00:00Z")
                .build();

        GetBusinessAccountTransactionResponse res = sdk.accounts().get()
                .request(req)
                .call();

        if (res.transactionResponse().isPresent()) {
            System.out.println(res.transactionResponse().get());
        }
    }
}
```

### Parameters

| Parameter                                                                                               | Type                                                                                                    | Required                                                                                                | Description                                                                                             |
| ------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------- |
| `request`                                                                                               | [GetBusinessAccountTransactionRequest](../../models/operations/GetBusinessAccountTransactionRequest.md) | :heavy_check_mark:                                                                                      | The request object to use for the request.                                                              |

### Response

**[GetBusinessAccountTransactionResponse](../../models/operations/GetBusinessAccountTransactionResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 404, 429                    | application/hal+json        |
| models/errors/APIException  | 4XX, 5XX                    | \*/\*                       |