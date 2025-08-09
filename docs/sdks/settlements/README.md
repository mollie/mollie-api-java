# Settlements
(*settlements()*)

## Overview

### Available Operations

* [list](#list) - List settlements
* [get](#get) - Get settlement
* [getOpen](#getopen) - Get open settlement
* [getNext](#getnext) - Get next settlement
* [listPayments](#listpayments) - List settlement payments
* [listCaptures](#listcaptures) - List settlement captures
* [listRefunds](#listrefunds) - List settlement refunds
* [listChargebacks](#listchargebacks) - List settlement chargebacks

## list

Retrieve a list of all your settlements.

The results are paginated.

### Example Usage

<!-- UsageSnippet language="java" operationID="list-settlements" method="get" path="/settlements" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.ListSettlementsResponseBody;
import com.mollie.mollie.models.errors.ListSettlementsSettlementsResponseBody;
import com.mollie.mollie.models.operations.*;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ListSettlementsResponseBody, ListSettlementsSettlementsResponseBody, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        ListSettlementsRequest req = ListSettlementsRequest.builder()
                .from("stl_jDk30akdN")
                .limit(50L)
                .balanceId("bal_gVMhHKqSSRYJyPsuoPNFH")
                .year("2025")
                .month("1")
                .currencies(Currencies.EUR)
                .build();

        ListSettlementsResponse res = sdk.settlements().list()
                .request(req)
                .call();

        if (res.object().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                   | Type                                                                        | Required                                                                    | Description                                                                 |
| --------------------------------------------------------------------------- | --------------------------------------------------------------------------- | --------------------------------------------------------------------------- | --------------------------------------------------------------------------- |
| `request`                                                                   | [ListSettlementsRequest](../../models/operations/ListSettlementsRequest.md) | :heavy_check_mark:                                                          | The request object to use for the request.                                  |

### Response

**[ListSettlementsResponse](../../models/operations/ListSettlementsResponse.md)**

### Errors

| Error Type                                           | Status Code                                          | Content Type                                         |
| ---------------------------------------------------- | ---------------------------------------------------- | ---------------------------------------------------- |
| models/errors/ListSettlementsResponseBody            | 400                                                  | application/hal+json                                 |
| models/errors/ListSettlementsSettlementsResponseBody | 404                                                  | application/hal+json                                 |
| models/errors/APIException                           | 4XX, 5XX                                             | \*/\*                                                |

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

<!-- UsageSnippet language="java" operationID="get-settlement" method="get" path="/settlements/{id}" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.GetSettlementResponseBody;
import com.mollie.mollie.models.operations.GetSettlementResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws GetSettlementResponseBody, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        GetSettlementResponse res = sdk.settlements().get()
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

<!-- UsageSnippet language="java" operationID="get-open-settlement" method="get" path="/settlements/open" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.operations.GetOpenSettlementResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        GetOpenSettlementResponse res = sdk.settlements().getOpen()
                .call();

        if (res.object().isPresent()) {
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

<!-- UsageSnippet language="java" operationID="get-next-settlement" method="get" path="/settlements/next" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.operations.GetNextSettlementResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        GetNextSettlementResponse res = sdk.settlements().getNext()
                .call();

        if (res.object().isPresent()) {
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

## listPayments

Retrieve all payments included in the given settlement.

The response is in the same format as the response of the [List payments endpoint](list-payments).

For capture-based payment methods such as Klarna, the payments are not listed here. Refer to the
[List captures endpoint](list-captures) endpoint instead.

### Example Usage

<!-- UsageSnippet language="java" operationID="list-settlement-payments" method="get" path="/settlements/{settlementId}/payments" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.ListSettlementPaymentsResponseBody;
import com.mollie.mollie.models.operations.*;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ListSettlementPaymentsResponseBody, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        ListSettlementPaymentsRequest req = ListSettlementPaymentsRequest.builder()
                .settlementId("stl_jDk30akdN")
                .from("tr_5B8cwPMGnU")
                .limit(50L)
                .sort(ListSettlementPaymentsQueryParamSort.DESC)
                .profileId("pfl_5B8cwPMGnU")
                .testmode(false)
                .build();

        ListSettlementPaymentsResponse res = sdk.settlements().listPayments()
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
| `request`                                                                                 | [ListSettlementPaymentsRequest](../../models/operations/ListSettlementPaymentsRequest.md) | :heavy_check_mark:                                                                        | The request object to use for the request.                                                |

### Response

**[ListSettlementPaymentsResponse](../../models/operations/ListSettlementPaymentsResponse.md)**

### Errors

| Error Type                                       | Status Code                                      | Content Type                                     |
| ------------------------------------------------ | ------------------------------------------------ | ------------------------------------------------ |
| models/errors/ListSettlementPaymentsResponseBody | 400                                              | application/hal+json                             |
| models/errors/APIException                       | 4XX, 5XX                                         | \*/\*                                            |

## listCaptures

Retrieve all captures included in the given settlement.

The response is in the same format as the response of the [List captures endpoint](list-captures).

### Example Usage

<!-- UsageSnippet language="java" operationID="list-settlement-captures" method="get" path="/settlements/{settlementId}/captures" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.ListSettlementCapturesResponseBody;
import com.mollie.mollie.models.errors.ListSettlementCapturesSettlementsResponseBody;
import com.mollie.mollie.models.operations.*;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ListSettlementCapturesResponseBody, ListSettlementCapturesSettlementsResponseBody, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        ListSettlementCapturesRequest req = ListSettlementCapturesRequest.builder()
                .settlementId("stl_jDk30akdN")
                .from("cpt_vytxeTZskVKR7C7WgdSP3d")
                .limit(50L)
                .embed(ListSettlementCapturesQueryParamEmbed.PAYMENT)
                .testmode(false)
                .build();

        ListSettlementCapturesResponse res = sdk.settlements().listCaptures()
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
| `request`                                                                                 | [ListSettlementCapturesRequest](../../models/operations/ListSettlementCapturesRequest.md) | :heavy_check_mark:                                                                        | The request object to use for the request.                                                |

### Response

**[ListSettlementCapturesResponse](../../models/operations/ListSettlementCapturesResponse.md)**

### Errors

| Error Type                                                  | Status Code                                                 | Content Type                                                |
| ----------------------------------------------------------- | ----------------------------------------------------------- | ----------------------------------------------------------- |
| models/errors/ListSettlementCapturesResponseBody            | 400                                                         | application/hal+json                                        |
| models/errors/ListSettlementCapturesSettlementsResponseBody | 404                                                         | application/hal+json                                        |
| models/errors/APIException                                  | 4XX, 5XX                                                    | \*/\*                                                       |

## listRefunds

Retrieve all refunds 'deducted' from the given settlement.

The response is in the same format as the response of the [List refunds endpoint](list-refunds).

### Example Usage

<!-- UsageSnippet language="java" operationID="list-settlement-refunds" method="get" path="/settlements/{settlementId}/refunds" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.ListSettlementRefundsResponseBody;
import com.mollie.mollie.models.errors.ListSettlementRefundsSettlementsResponseBody;
import com.mollie.mollie.models.operations.*;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ListSettlementRefundsResponseBody, ListSettlementRefundsSettlementsResponseBody, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        ListSettlementRefundsRequest req = ListSettlementRefundsRequest.builder()
                .settlementId("stl_jDk30akdN")
                .from("re_5B8cwPMGnU")
                .limit(50L)
                .embed(ListSettlementRefundsQueryParamEmbed.PAYMENT)
                .testmode(false)
                .build();

        ListSettlementRefundsResponse res = sdk.settlements().listRefunds()
                .request(req)
                .call();

        if (res.object().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                               | Type                                                                                    | Required                                                                                | Description                                                                             |
| --------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------- |
| `request`                                                                               | [ListSettlementRefundsRequest](../../models/operations/ListSettlementRefundsRequest.md) | :heavy_check_mark:                                                                      | The request object to use for the request.                                              |

### Response

**[ListSettlementRefundsResponse](../../models/operations/ListSettlementRefundsResponse.md)**

### Errors

| Error Type                                                 | Status Code                                                | Content Type                                               |
| ---------------------------------------------------------- | ---------------------------------------------------------- | ---------------------------------------------------------- |
| models/errors/ListSettlementRefundsResponseBody            | 400                                                        | application/hal+json                                       |
| models/errors/ListSettlementRefundsSettlementsResponseBody | 404                                                        | application/hal+json                                       |
| models/errors/APIException                                 | 4XX, 5XX                                                   | \*/\*                                                      |

## listChargebacks

Retrieve all chargebacks 'deducted' from the given settlement.

The response is in the same format as the response of the [List chargebacks endpoint](list-chargebacks).

### Example Usage

<!-- UsageSnippet language="java" operationID="list-settlement-chargebacks" method="get" path="/settlements/{settlementId}/chargebacks" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.ListSettlementChargebacksResponseBody;
import com.mollie.mollie.models.errors.ListSettlementChargebacksSettlementsResponseBody;
import com.mollie.mollie.models.operations.*;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ListSettlementChargebacksResponseBody, ListSettlementChargebacksSettlementsResponseBody, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        ListSettlementChargebacksRequest req = ListSettlementChargebacksRequest.builder()
                .settlementId("stl_jDk30akdN")
                .from("chb_xFzwUN4ci8HAmSGUACS4J")
                .limit(50L)
                .embed(ListSettlementChargebacksQueryParamEmbed.PAYMENT)
                .testmode(false)
                .build();

        ListSettlementChargebacksResponse res = sdk.settlements().listChargebacks()
                .request(req)
                .call();

        if (res.object().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                       | Type                                                                                            | Required                                                                                        | Description                                                                                     |
| ----------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------- |
| `request`                                                                                       | [ListSettlementChargebacksRequest](../../models/operations/ListSettlementChargebacksRequest.md) | :heavy_check_mark:                                                                              | The request object to use for the request.                                                      |

### Response

**[ListSettlementChargebacksResponse](../../models/operations/ListSettlementChargebacksResponse.md)**

### Errors

| Error Type                                                     | Status Code                                                    | Content Type                                                   |
| -------------------------------------------------------------- | -------------------------------------------------------------- | -------------------------------------------------------------- |
| models/errors/ListSettlementChargebacksResponseBody            | 400                                                            | application/hal+json                                           |
| models/errors/ListSettlementChargebacksSettlementsResponseBody | 404                                                            | application/hal+json                                           |
| models/errors/APIException                                     | 4XX, 5XX                                                       | \*/\*                                                          |