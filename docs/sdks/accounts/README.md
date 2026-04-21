# Accounts

## Overview

### Available Operations

* [listAccounts](#listaccounts) - List business accounts
* [getAccount](#getaccount) - Get business account
* [list](#list) - List transactions
* [get](#get) - Get transaction

## listAccounts

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
                .from("ba_nopqrstuvwxyz23456789A")
                .limit(50L)
                .sort(Sorting.DESC)
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
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
| models/errors/ErrorResponse | 400                         | application/hal+json        |
| models/errors/APIException  | 4XX, 5XX                    | \*/\*                       |

## getAccount

Retrieve a single business account object by its account ID. This allows you to check the current status,
balance, and account details.

### Example Usage

<!-- UsageSnippet language="java" operationID="get-business-account" method="get" path="/v2/business-accounts/accounts/{businessAccountId}" example="get-business-account-200" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.ErrorResponse;
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

        GetBusinessAccountResponse res = sdk.accounts().getAccount()
                .businessAccountId("ba_nopqrstuvwxyz23456789A")
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .call();

        if (res.businessAccountResponse().isPresent()) {
            System.out.println(res.businessAccountResponse().get());
        }
    }
}
```

### Parameters

| Parameter                                                                                                                                                                                                                                                                                                                                                                                | Type                                                                                                                                                                                                                                                                                                                                                                                     | Required                                                                                                                                                                                                                                                                                                                                                                                 | Description                                                                                                                                                                                                                                                                                                                                                                              | Example                                                                                                                                                                                                                                                                                                                                                                                  |
| ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `businessAccountId`                                                                                                                                                                                                                                                                                                                                                                      | *String*                                                                                                                                                                                                                                                                                                                                                                                 | :heavy_check_mark:                                                                                                                                                                                                                                                                                                                                                                       | Provide the ID of the related business account.                                                                                                                                                                                                                                                                                                                                          | ba_nopqrstuvwxyz23456789A                                                                                                                                                                                                                                                                                                                                                                |
| `testmode`                                                                                                                                                                                                                                                                                                                                                                               | *Optional\<Boolean>*                                                                                                                                                                                                                                                                                                                                                                     | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                       | Most API credentials are specifically created for either live mode or test mode. In those cases the `testmode` query<br/>parameter must not be sent. For organization-level credentials such as OAuth access tokens, you can enable test mode by<br/>setting the `testmode` query parameter to `true`.<br/><br/>Test entities cannot be retrieved when the endpoint is set to live mode, and vice versa. |                                                                                                                                                                                                                                                                                                                                                                                          |
| `idempotencyKey`                                                                                                                                                                                                                                                                                                                                                                         | *Optional\<String>*                                                                                                                                                                                                                                                                                                                                                                      | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                       | A unique key to ensure idempotent requests. This key should be a UUID v4 string.                                                                                                                                                                                                                                                                                                         | 123e4567-e89b-12d3-a456-426                                                                                                                                                                                                                                                                                                                                                              |

### Response

**[GetBusinessAccountResponse](../../models/operations/GetBusinessAccountResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 404                         | application/hal+json        |
| models/errors/APIException  | 4XX, 5XX                    | \*/\*                       |

## list

Retrieve all transactions for a specific business account.

The results are paginated.

### Example Usage

<!-- UsageSnippet language="java" operationID="list-business-account-transactions" method="get" path="/v2/business-accounts/accounts/{businessAccountId}/transactions" example="list-transactions-200" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.components.Sorting;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.ListBusinessAccountTransactionsRequest;
import com.mollie.mollie.models.operations.ListBusinessAccountTransactionsResponse;
import java.lang.Exception;

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
                .from("batr_87GByBuj4UCcUTEbs6aGJ")
                .limit(50L)
                .sort(Sorting.DESC)
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
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
| models/errors/ErrorResponse | 400                         | application/hal+json        |
| models/errors/APIException  | 4XX, 5XX                    | \*/\*                       |

## get

Retrieve a single transaction object by its transaction ID. This allows you to check the details,
amount, counterparty, and balance impact of a specific transaction.

### Example Usage: get-transaction-200

<!-- UsageSnippet language="java" operationID="get-business-account-transaction" method="get" path="/v2/business-accounts/accounts/{businessAccountId}/transactions/{transactionId}" example="get-transaction-200" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.ErrorResponse;
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

        GetBusinessAccountTransactionResponse res = sdk.accounts().get()
                .businessAccountId("ba_nopqrstuvwxyz23456789A")
                .transactionId("batr_87GByBuj4UCcUTEbs6aGJ")
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
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

        GetBusinessAccountTransactionResponse res = sdk.accounts().get()
                .businessAccountId("ba_nopqrstuvwxyz23456789A")
                .transactionId("batr_87GByBuj4UCcUTEbs6aGJ")
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .call();

        if (res.transactionResponse().isPresent()) {
            System.out.println(res.transactionResponse().get());
        }
    }
}
```

### Parameters

| Parameter                                                                                                                                                                                                                                                                                                                                                                                | Type                                                                                                                                                                                                                                                                                                                                                                                     | Required                                                                                                                                                                                                                                                                                                                                                                                 | Description                                                                                                                                                                                                                                                                                                                                                                              | Example                                                                                                                                                                                                                                                                                                                                                                                  |
| ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `businessAccountId`                                                                                                                                                                                                                                                                                                                                                                      | *String*                                                                                                                                                                                                                                                                                                                                                                                 | :heavy_check_mark:                                                                                                                                                                                                                                                                                                                                                                       | Provide the ID of the related business account.                                                                                                                                                                                                                                                                                                                                          | ba_nopqrstuvwxyz23456789A                                                                                                                                                                                                                                                                                                                                                                |
| `transactionId`                                                                                                                                                                                                                                                                                                                                                                          | *String*                                                                                                                                                                                                                                                                                                                                                                                 | :heavy_check_mark:                                                                                                                                                                                                                                                                                                                                                                       | Provide the ID of the related transaction.                                                                                                                                                                                                                                                                                                                                               | batr_87GByBuj4UCcUTEbs6aGJ                                                                                                                                                                                                                                                                                                                                                               |
| `testmode`                                                                                                                                                                                                                                                                                                                                                                               | *Optional\<Boolean>*                                                                                                                                                                                                                                                                                                                                                                     | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                       | Most API credentials are specifically created for either live mode or test mode. In those cases the `testmode` query<br/>parameter must not be sent. For organization-level credentials such as OAuth access tokens, you can enable test mode by<br/>setting the `testmode` query parameter to `true`.<br/><br/>Test entities cannot be retrieved when the endpoint is set to live mode, and vice versa. |                                                                                                                                                                                                                                                                                                                                                                                          |
| `idempotencyKey`                                                                                                                                                                                                                                                                                                                                                                         | *Optional\<String>*                                                                                                                                                                                                                                                                                                                                                                      | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                       | A unique key to ensure idempotent requests. This key should be a UUID v4 string.                                                                                                                                                                                                                                                                                                         | 123e4567-e89b-12d3-a456-426                                                                                                                                                                                                                                                                                                                                                              |

### Response

**[GetBusinessAccountTransactionResponse](../../models/operations/GetBusinessAccountTransactionResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 404                         | application/hal+json        |
| models/errors/APIException  | 4XX, 5XX                    | \*/\*                       |