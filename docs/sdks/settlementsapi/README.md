# SettlementsAPI
(*settlementsAPI()*)

## Overview

### Available Operations

* [list](#list) - List settlements
* [get](#get) - Get settlement
* [getOpen](#getopen) - Get open settlement
* [getNext](#getnext) - Get next settlement
* [getPayments](#getpayments) - Get settlement payments
* [getCaptures](#getcaptures) - Get settlement captures
* [getRefunds](#getrefunds) - Get settlement refunds
* [getChargebacks](#getchargebacks) - Get settlement chargebacks

## list

Retrieve a list of all your settlements.

The results are paginated.

### Example Usage

```java
package hello.world;

import com.mollie.mollie.Mollie;
import com.mollie.mollie.models.errors.ListSettlementsResponseBody;
import com.mollie.mollie.models.errors.ListSettlementsSettlementsAPIResponseBody;
import com.mollie.mollie.models.operations.ListSettlementsResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ListSettlementsResponseBody, ListSettlementsSettlementsAPIResponseBody, Exception {

        Mollie sdk = Mollie.builder()
                .oAuth("<YOUR_O_AUTH_HERE>")
            .build();

        ListSettlementsResponse res = sdk.settlementsAPI().list()
                .from("stl_jDk30akdN")
                .limit(50L)
                .balanceId("bal_3kUf4yU2nT")
                .call();

        if (res.object().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                                      | Type                                                                                                                           | Required                                                                                                                       | Description                                                                                                                    | Example                                                                                                                        |
| ------------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------------ |
| `from`                                                                                                                         | *Optional\<String>*                                                                                                            | :heavy_minus_sign:                                                                                                             | Provide an ID to start the result set from the item with the given ID and onwards. This allows you to paginate the<br/>result set. | stl_jDk30akdN                                                                                                                  |
| `limit`                                                                                                                        | *JsonNullable\<Long>*                                                                                                          | :heavy_minus_sign:                                                                                                             | The maximum number of items to return. Defaults to 50 items.                                                                   | 50                                                                                                                             |
| `balanceId`                                                                                                                    | *JsonNullable\<String>*                                                                                                        | :heavy_minus_sign:                                                                                                             | Provide the token of the balance to filter the settlements by. This is<br/>the balance token that the settlement was settled to. | bal_3kUf4yU2nT                                                                                                                 |

### Response

**[ListSettlementsResponse](../../models/operations/ListSettlementsResponse.md)**

### Errors

| Error Type                                              | Status Code                                             | Content Type                                            |
| ------------------------------------------------------- | ------------------------------------------------------- | ------------------------------------------------------- |
| models/errors/ListSettlementsResponseBody               | 400                                                     | application/hal+json                                    |
| models/errors/ListSettlementsSettlementsAPIResponseBody | 404                                                     | application/hal+json                                    |
| models/errors/APIException                              | 4XX, 5XX                                                | \*/\*                                                   |

## get

Retrieve a single settlement by its ID.

To lookup settlements by their bank reference, replace the ID in the URL by
a reference. For example: `1234567.2404.03`.

A settlement represents a transfer of your balance funds to your external bank account.

Settlements will typically include a report that details what balance transactions have taken place between this
settlement and the previous one.

For more accurate bookkeeping, refer to the [balance report](get-balance-report) endpoint or the
[balance transactions](list-balance-transactions) endpoint.

### Example Usage

```java
package hello.world;

import com.mollie.mollie.Mollie;
import com.mollie.mollie.models.errors.GetSettlementResponseBody;
import com.mollie.mollie.models.operations.GetSettlementResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws GetSettlementResponseBody, Exception {

        Mollie sdk = Mollie.builder()
                .oAuth("<YOUR_O_AUTH_HERE>")
            .build();

        GetSettlementResponse res = sdk.settlementsAPI().get()
                .id("stl_jDk30akdN")
                .call();

        if (res.object().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                         | Type                                                              | Required                                                          | Description                                                       | Example                                                           |
| ----------------------------------------------------------------- | ----------------------------------------------------------------- | ----------------------------------------------------------------- | ----------------------------------------------------------------- | ----------------------------------------------------------------- |
| `id`                                                              | *String*                                                          | :heavy_check_mark:                                                | Provide the ID of the item you want to perform this operation on. | stl_jDk30akdN                                                     |

### Response

**[GetSettlementResponse](../../models/operations/GetSettlementResponse.md)**

### Errors

| Error Type                              | Status Code                             | Content Type                            |
| --------------------------------------- | --------------------------------------- | --------------------------------------- |
| models/errors/GetSettlementResponseBody | 404                                     | application/hal+json                    |
| models/errors/APIException              | 4XX, 5XX                                | \*/\*                                   |

## getOpen

Retrieve the details of the open balance of the organization. This will return a settlement object representing your
organization's balance.

For a complete reference of the settlement object, refer to the [Get settlement endpoint](get-settlement)
documentation.

For more accurate bookkeeping, refer to the [balance report](get-balance-report) endpoint or the
[balance transactions](list-balance-transactions) endpoint.

### Example Usage

```java
package hello.world;

import com.mollie.mollie.Mollie;
import com.mollie.mollie.models.operations.GetOpenSettlementResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Mollie sdk = Mollie.builder()
                .oAuth("<YOUR_O_AUTH_HERE>")
            .build();

        GetOpenSettlementResponse res = sdk.settlementsAPI().getOpen()
                .call();

        if (res.any().isPresent()) {
            // handle response
        }
    }
}
```

### Response

**[GetOpenSettlementResponse](../../models/operations/GetOpenSettlementResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## getNext

Retrieve the details of the current settlement, that has not yet been paid out.

For a complete reference of the settlement object, refer to the [Get settlement endpoint](get-settlement)
documentation.

For more accurate bookkeeping, refer to the [balance report](get-balance-report) endpoint or the
[balance transactions](list-balance-transactions) endpoint.

### Example Usage

```java
package hello.world;

import com.mollie.mollie.Mollie;
import com.mollie.mollie.models.operations.GetNextSettlementResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Mollie sdk = Mollie.builder()
                .oAuth("<YOUR_O_AUTH_HERE>")
            .build();

        GetNextSettlementResponse res = sdk.settlementsAPI().getNext()
                .call();

        if (res.any().isPresent()) {
            // handle response
        }
    }
}
```

### Response

**[GetNextSettlementResponse](../../models/operations/GetNextSettlementResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## getPayments

Retrieve all payments included in the given settlement.

The response is in the same format as the response of the [List payments endpoint](list-payments). Refer to that
endpoint's documentation for more details.

For capture-based payment methods such as Klarna, the payments are not listed here. Refer to the
[List captures endpoint](list-captures) endpoint instead.

### Example Usage

```java
package hello.world;

import com.mollie.mollie.Mollie;
import com.mollie.mollie.models.errors.GetSettlementPaymentsResponseBody;
import com.mollie.mollie.models.operations.GetSettlementPaymentsResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws GetSettlementPaymentsResponseBody, Exception {

        Mollie sdk = Mollie.builder()
                .oAuth("<YOUR_O_AUTH_HERE>")
            .build();

        GetSettlementPaymentsResponse res = sdk.settlementsAPI().getPayments()
                .settlementId("stl_jDk30akdN")
                .call();

        if (res.any().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                 | Type                                      | Required                                  | Description                               | Example                                   |
| ----------------------------------------- | ----------------------------------------- | ----------------------------------------- | ----------------------------------------- | ----------------------------------------- |
| `settlementId`                            | *String*                                  | :heavy_check_mark:                        | Provide the ID of the related settlement. | stl_jDk30akdN                             |

### Response

**[GetSettlementPaymentsResponse](../../models/operations/GetSettlementPaymentsResponse.md)**

### Errors

| Error Type                                      | Status Code                                     | Content Type                                    |
| ----------------------------------------------- | ----------------------------------------------- | ----------------------------------------------- |
| models/errors/GetSettlementPaymentsResponseBody | 404                                             | application/hal+json                            |
| models/errors/APIException                      | 4XX, 5XX                                        | \*/\*                                           |

## getCaptures

Retrieve all captures included in the given settlement.

The response is in the same format as the response of the [List captures endpoint](list-captures). Refer to that
endpoint's documentation for more details.

### Example Usage

```java
package hello.world;

import com.mollie.mollie.Mollie;
import com.mollie.mollie.models.errors.GetSettlementCapturesResponseBody;
import com.mollie.mollie.models.operations.GetSettlementCapturesResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws GetSettlementCapturesResponseBody, Exception {

        Mollie sdk = Mollie.builder()
                .oAuth("<YOUR_O_AUTH_HERE>")
            .build();

        GetSettlementCapturesResponse res = sdk.settlementsAPI().getCaptures()
                .settlementId("stl_jDk30akdN")
                .call();

        if (res.any().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                 | Type                                      | Required                                  | Description                               | Example                                   |
| ----------------------------------------- | ----------------------------------------- | ----------------------------------------- | ----------------------------------------- | ----------------------------------------- |
| `settlementId`                            | *String*                                  | :heavy_check_mark:                        | Provide the ID of the related settlement. | stl_jDk30akdN                             |

### Response

**[GetSettlementCapturesResponse](../../models/operations/GetSettlementCapturesResponse.md)**

### Errors

| Error Type                                      | Status Code                                     | Content Type                                    |
| ----------------------------------------------- | ----------------------------------------------- | ----------------------------------------------- |
| models/errors/GetSettlementCapturesResponseBody | 404                                             | application/hal+json                            |
| models/errors/APIException                      | 4XX, 5XX                                        | \*/\*                                           |

## getRefunds

Retrieve all refunds 'deducted' from the given settlement.

The response is in the same format as the response of the [List refunds endpoint](list-refunds). Refer to that
endpoint's documentation for more details.

### Example Usage

```java
package hello.world;

import com.mollie.mollie.Mollie;
import com.mollie.mollie.models.errors.GetSettlementRefundsResponseBody;
import com.mollie.mollie.models.operations.GetSettlementRefundsResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws GetSettlementRefundsResponseBody, Exception {

        Mollie sdk = Mollie.builder()
                .oAuth("<YOUR_O_AUTH_HERE>")
            .build();

        GetSettlementRefundsResponse res = sdk.settlementsAPI().getRefunds()
                .settlementId("stl_jDk30akdN")
                .call();

        if (res.any().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                 | Type                                      | Required                                  | Description                               | Example                                   |
| ----------------------------------------- | ----------------------------------------- | ----------------------------------------- | ----------------------------------------- | ----------------------------------------- |
| `settlementId`                            | *String*                                  | :heavy_check_mark:                        | Provide the ID of the related settlement. | stl_jDk30akdN                             |

### Response

**[GetSettlementRefundsResponse](../../models/operations/GetSettlementRefundsResponse.md)**

### Errors

| Error Type                                     | Status Code                                    | Content Type                                   |
| ---------------------------------------------- | ---------------------------------------------- | ---------------------------------------------- |
| models/errors/GetSettlementRefundsResponseBody | 404                                            | application/hal+json                           |
| models/errors/APIException                     | 4XX, 5XX                                       | \*/\*                                          |

## getChargebacks

Retrieve all chargebacks 'deducted' from the given settlement.

The response is in the same format as the response of the [List chargebacks endpoint](list-chargebacks). Refer to
that endpoint's documentation for more details.

### Example Usage

```java
package hello.world;

import com.mollie.mollie.Mollie;
import com.mollie.mollie.models.errors.GetSettlementChargebacksResponseBody;
import com.mollie.mollie.models.operations.GetSettlementChargebacksResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws GetSettlementChargebacksResponseBody, Exception {

        Mollie sdk = Mollie.builder()
                .oAuth("<YOUR_O_AUTH_HERE>")
            .build();

        GetSettlementChargebacksResponse res = sdk.settlementsAPI().getChargebacks()
                .settlementId("stl_jDk30akdN")
                .call();

        if (res.any().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                 | Type                                      | Required                                  | Description                               | Example                                   |
| ----------------------------------------- | ----------------------------------------- | ----------------------------------------- | ----------------------------------------- | ----------------------------------------- |
| `settlementId`                            | *String*                                  | :heavy_check_mark:                        | Provide the ID of the related settlement. | stl_jDk30akdN                             |

### Response

**[GetSettlementChargebacksResponse](../../models/operations/GetSettlementChargebacksResponse.md)**

### Errors

| Error Type                                         | Status Code                                        | Content Type                                       |
| -------------------------------------------------- | -------------------------------------------------- | -------------------------------------------------- |
| models/errors/GetSettlementChargebacksResponseBody | 404                                                | application/hal+json                               |
| models/errors/APIException                         | 4XX, 5XX                                           | \*/\*                                              |