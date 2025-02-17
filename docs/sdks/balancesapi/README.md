# BalancesAPI
(*balancesAPI()*)

## Overview

### Available Operations

* [list](#list) - List balances
* [get](#get) - Get balance
* [getPrimary](#getprimary) - Get primary balance
* [getReport](#getreport) - Get balance report
* [listTransactions](#listtransactions) - List balance transactions

## list

Retrieve a list of the organization's balances, including the primary balance.

The results are paginated.

### Example Usage

```java
package hello.world;

import com.mollie.mollie.Mollie;
import com.mollie.mollie.models.errors.ListBalancesBalancesAPIResponseBody;
import com.mollie.mollie.models.errors.ListBalancesResponseBody;
import com.mollie.mollie.models.operations.ListBalancesResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ListBalancesResponseBody, ListBalancesBalancesAPIResponseBody, Exception {

        Mollie sdk = Mollie.builder()
                .oAuth("<YOUR_O_AUTH_HERE>")
            .build();

        ListBalancesResponse res = sdk.balancesAPI().list()
                .currency("EUR")
                .from("bal_gVMhHKqSSRYJyPsuoPNFH")
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
| `currency`                                                                                                                                                                                                                                                                                                                                                                             | *JsonNullable\<String>*                                                                                                                                                                                                                                                                                                                                                                | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                     | Optionally only return balances with the given currency. For example: `EUR`.                                                                                                                                                                                                                                                                                                           | EUR                                                                                                                                                                                                                                                                                                                                                                                    |
| `from`                                                                                                                                                                                                                                                                                                                                                                                 | *Optional\<String>*                                                                                                                                                                                                                                                                                                                                                                    | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                     | Provide an ID to start the result set from the item with the given ID and onwards. This allows you to paginate the<br/>result set.                                                                                                                                                                                                                                                     | bal_gVMhHKqSSRYJyPsuoPNFH                                                                                                                                                                                                                                                                                                                                                              |
| `limit`                                                                                                                                                                                                                                                                                                                                                                                | *JsonNullable\<Long>*                                                                                                                                                                                                                                                                                                                                                                  | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                     | The maximum number of items to return. Defaults to 50 items.                                                                                                                                                                                                                                                                                                                           | 50                                                                                                                                                                                                                                                                                                                                                                                     |
| `testmode`                                                                                                                                                                                                                                                                                                                                                                             | *JsonNullable\<Boolean>*                                                                                                                                                                                                                                                                                                                                                               | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                     | Most API credentials are specifically created for either live mode or test mode. In those cases the `testmode` query<br/>parameter can be omitted. For organization-level credentials such as OAuth access tokens, you can enable test mode by<br/>setting the `testmode` query parameter to `true`.<br/><br/>Test entities cannot be retrieved when the endpoint is set to live mode, and vice versa. | false                                                                                                                                                                                                                                                                                                                                                                                  |

### Response

**[ListBalancesResponse](../../models/operations/ListBalancesResponse.md)**

### Errors

| Error Type                                        | Status Code                                       | Content Type                                      |
| ------------------------------------------------- | ------------------------------------------------- | ------------------------------------------------- |
| models/errors/ListBalancesResponseBody            | 400                                               | application/hal+json                              |
| models/errors/ListBalancesBalancesAPIResponseBody | 404                                               | application/hal+json                              |
| models/errors/APIException                        | 4XX, 5XX                                          | \*/\*                                             |

## get

When processing payments with Mollie, we put all pending funds — usually
minus Mollie fees — on a balance. Once you have linked a bank account to your Mollie account, we can pay out your
balance towards this bank account.

With the Balances API you can retrieve your current balance. The response
includes two amounts:

* The *pending amount*. These are payments that have been marked as `paid`,
but are not yet available on your balance.
* The *available amount*. This is the amount that you can get paid out to
your bank account, or use for refunds.

With instant payment methods like iDEAL, payments are moved to the available
balance instantly. With slower payment methods, like credit card for example, it can take a few days before the
funds are available on your balance. These funds will be shown under the *pending amount* in the meanwhile.

### Example Usage

```java
package hello.world;

import com.mollie.mollie.Mollie;
import com.mollie.mollie.models.errors.GetBalanceResponseBody;
import com.mollie.mollie.models.operations.GetBalanceResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws GetBalanceResponseBody, Exception {

        Mollie sdk = Mollie.builder()
                .oAuth("<YOUR_O_AUTH_HERE>")
            .build();

        GetBalanceResponse res = sdk.balancesAPI().get()
                .id("bal_gVMhHKqSSRYJyPsuoPNFH")
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
| `id`                                                                                                                                                                                                                                                                                                                                                                                   | *String*                                                                                                                                                                                                                                                                                                                                                                               | :heavy_check_mark:                                                                                                                                                                                                                                                                                                                                                                     | Provide the ID of the item you want to perform this operation on.                                                                                                                                                                                                                                                                                                                      | bal_gVMhHKqSSRYJyPsuoPNFH                                                                                                                                                                                                                                                                                                                                                              |
| `testmode`                                                                                                                                                                                                                                                                                                                                                                             | *JsonNullable\<Boolean>*                                                                                                                                                                                                                                                                                                                                                               | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                     | Most API credentials are specifically created for either live mode or test mode. In those cases the `testmode` query<br/>parameter can be omitted. For organization-level credentials such as OAuth access tokens, you can enable test mode by<br/>setting the `testmode` query parameter to `true`.<br/><br/>Test entities cannot be retrieved when the endpoint is set to live mode, and vice versa. | false                                                                                                                                                                                                                                                                                                                                                                                  |

### Response

**[GetBalanceResponse](../../models/operations/GetBalanceResponse.md)**

### Errors

| Error Type                           | Status Code                          | Content Type                         |
| ------------------------------------ | ------------------------------------ | ------------------------------------ |
| models/errors/GetBalanceResponseBody | 404                                  | application/hal+json                 |
| models/errors/APIException           | 4XX, 5XX                             | \*/\*                                |

## getPrimary

Retrieve the primary balance. This is the balance of your account's primary
currency, where all payments are settled to by default.

This endpoint is a convenient alias of the [Get balance](get-balance)
endpoint. For a complete reference of the balance object, refer to that endpoint's documentation.

### Example Usage

```java
package hello.world;

import com.mollie.mollie.Mollie;
import com.mollie.mollie.models.operations.GetPrimaryBalanceResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Mollie sdk = Mollie.builder()
                .oAuth("<YOUR_O_AUTH_HERE>")
            .build();

        GetPrimaryBalanceResponse res = sdk.balancesAPI().getPrimary()
                .call();

        if (res.any().isPresent()) {
            // handle response
        }
    }
}
```

### Response

**[GetPrimaryBalanceResponse](../../models/operations/GetPrimaryBalanceResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## getReport

Retrieve a summarized report for all transactions on a given balance within a given timeframe.

The API also provides a detailed report on all 'prepayments' for Mollie fees that were deducted from your balance
during the reported period, ahead of your Mollie invoice.

The alias `primary` can be used instead of the balance ID to refer to the
organization's primary balance.

### Example Usage

```java
package hello.world;

import com.mollie.mollie.Mollie;
import com.mollie.mollie.models.errors.GetBalanceReportResponseBody;
import com.mollie.mollie.models.operations.GetBalanceReportRequest;
import com.mollie.mollie.models.operations.GetBalanceReportResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws GetBalanceReportResponseBody, Exception {

        Mollie sdk = Mollie.builder()
                .oAuth("<YOUR_O_AUTH_HERE>")
            .build();

        GetBalanceReportRequest req = GetBalanceReportRequest.builder()
                .balanceId("bal_gVMhHKqSSRYJyPsuoPNFH")
                .from("2024-01-01")
                .until("2024-02-01")
                .build();

        GetBalanceReportResponse res = sdk.balancesAPI().getReport()
                .request(req)
                .call();

        if (res.object().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                     | Type                                                                          | Required                                                                      | Description                                                                   |
| ----------------------------------------------------------------------------- | ----------------------------------------------------------------------------- | ----------------------------------------------------------------------------- | ----------------------------------------------------------------------------- |
| `request`                                                                     | [GetBalanceReportRequest](../../models/operations/GetBalanceReportRequest.md) | :heavy_check_mark:                                                            | The request object to use for the request.                                    |

### Response

**[GetBalanceReportResponse](../../models/operations/GetBalanceReportResponse.md)**

### Errors

| Error Type                                 | Status Code                                | Content Type                               |
| ------------------------------------------ | ------------------------------------------ | ------------------------------------------ |
| models/errors/GetBalanceReportResponseBody | 404                                        | application/hal+json                       |
| models/errors/APIException                 | 4XX, 5XX                                   | \*/\*                                      |

## listTransactions

Retrieve a list of all balance transactions. Transactions include for
example payments, refunds, chargebacks, and settlements.

For an aggregated report of these balance transactions, refer to the [Get
balance report](get-balance-report) endpoint.

The alias `primary` can be used instead of the balance ID to refer to the
organization's primary balance.

The results are paginated.

### Example Usage

```java
package hello.world;

import com.mollie.mollie.Mollie;
import com.mollie.mollie.models.errors.ListBalanceTransactionsBalancesAPIResponseBody;
import com.mollie.mollie.models.errors.ListBalanceTransactionsResponseBody;
import com.mollie.mollie.models.operations.ListBalanceTransactionsResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ListBalanceTransactionsResponseBody, ListBalanceTransactionsBalancesAPIResponseBody, Exception {

        Mollie sdk = Mollie.builder()
                .oAuth("<YOUR_O_AUTH_HERE>")
            .build();

        ListBalanceTransactionsResponse res = sdk.balancesAPI().listTransactions()
                .balanceId("bal_gVMhHKqSSRYJyPsuoPNFH")
                .from("baltr_QM24QwzUWR4ev4Xfgyt29A")
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
| `balanceId`                                                                                                                                                                                                                                                                                                                                                                            | *String*                                                                                                                                                                                                                                                                                                                                                                               | :heavy_check_mark:                                                                                                                                                                                                                                                                                                                                                                     | Provide the ID of the related balance.                                                                                                                                                                                                                                                                                                                                                 | bal_gVMhHKqSSRYJyPsuoPNFH                                                                                                                                                                                                                                                                                                                                                              |
| `from`                                                                                                                                                                                                                                                                                                                                                                                 | *Optional\<String>*                                                                                                                                                                                                                                                                                                                                                                    | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                     | Provide an ID to start the result set from the item with the given ID and onwards. This allows you to paginate the<br/>result set.                                                                                                                                                                                                                                                     | baltr_QM24QwzUWR4ev4Xfgyt29A                                                                                                                                                                                                                                                                                                                                                           |
| `limit`                                                                                                                                                                                                                                                                                                                                                                                | *JsonNullable\<Long>*                                                                                                                                                                                                                                                                                                                                                                  | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                     | The maximum number of items to return. Defaults to 50 items.                                                                                                                                                                                                                                                                                                                           | 50                                                                                                                                                                                                                                                                                                                                                                                     |
| `testmode`                                                                                                                                                                                                                                                                                                                                                                             | *JsonNullable\<Boolean>*                                                                                                                                                                                                                                                                                                                                                               | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                     | Most API credentials are specifically created for either live mode or test mode. In those cases the `testmode` query<br/>parameter can be omitted. For organization-level credentials such as OAuth access tokens, you can enable test mode by<br/>setting the `testmode` query parameter to `true`.<br/><br/>Test entities cannot be retrieved when the endpoint is set to live mode, and vice versa. | false                                                                                                                                                                                                                                                                                                                                                                                  |

### Response

**[ListBalanceTransactionsResponse](../../models/operations/ListBalanceTransactionsResponse.md)**

### Errors

| Error Type                                                   | Status Code                                                  | Content Type                                                 |
| ------------------------------------------------------------ | ------------------------------------------------------------ | ------------------------------------------------------------ |
| models/errors/ListBalanceTransactionsResponseBody            | 400                                                          | application/hal+json                                         |
| models/errors/ListBalanceTransactionsBalancesAPIResponseBody | 404                                                          | application/hal+json                                         |
| models/errors/APIException                                   | 4XX, 5XX                                                     | \*/\*                                                        |