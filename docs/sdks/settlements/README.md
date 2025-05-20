# Settlements
(*settlements()*)

## Overview

### Available Operations

* [list](#list) - List settlements
* [get](#get) - Get settlement
* [getOpen](#getopen) - Get open settlement
* [getNext](#getnext) - Get next settlement
* [listPayments](#listpayments) - Get settlement payments
* [listCaptures](#listcaptures) - Get settlement captures
* [listRefunds](#listrefunds) - Get settlement refunds
* [listChargebacks](#listchargebacks) - Get settlement chargebacks

## list

Retrieve a list of all your settlements.

The results are paginated.

> 🔑 Access with
>
> [Access token with **settlements.read**](/reference/authentication)

### Example Usage

```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.ListSettlementsResponseBody;
import com.mollie.mollie.models.errors.ListSettlementsSettlementsResponseBody;
import com.mollie.mollie.models.operations.ListSettlementsRequest;
import com.mollie.mollie.models.operations.ListSettlementsResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ListSettlementsResponseBody, ListSettlementsSettlementsResponseBody, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey("<YOUR_BEARER_TOKEN_HERE>")
                    .build())
            .build();

        ListSettlementsRequest req = ListSettlementsRequest.builder()
                .from("stl_jDk30akdN")
                .balanceId("bal_gVMhHKqSSRYJyPsuoPNFH")
                .year("2025")
                .month("1")
                .currencies("EUR")
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

To lookup settlements by their bank reference, replace the ID in the URL by a reference. For example: `1234567.2404.03`.

A settlement represents a transfer of your balance funds to your external bank account.

Settlements will typically include a report that details what balance transactions have taken place between this settlement and the previous one.

For more accurate bookkeeping, refer to the [balance report](get-balance-report) endpoint or the [balance transactions](list-balance-transactions) endpoint.

> 🔑 Access with
>
> [Access token with **settlements.read**](/reference/authentication)

### Example Usage

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
                    .apiKey("<YOUR_BEARER_TOKEN_HERE>")
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

Retrieve the details of the open balance of the organization. This will return a settlement object representing your organization's balance.

For a complete reference of the settlement object, refer to the [Get settlement endpoint](get-settlement) documentation.

For more accurate bookkeeping, refer to the [balance report](get-balance-report) endpoint or the [balance transactions](list-balance-transactions) endpoint.

> 🔑 Access with
>
> [Access token with **settlements.read**](/reference/authentication)

### Example Usage

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
                    .apiKey("<YOUR_BEARER_TOKEN_HERE>")
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

For a complete reference of the settlement object, refer to the [Get settlement endpoint](get-settlement) documentation.

For more accurate bookkeeping, refer to the [balance report](get-balance-report) endpoint or the [balance transactions](list-balance-transactions) endpoint.

> 🔑 Access with
>
> [Access token with **settlements.read**](/reference/authentication)

### Example Usage

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
                    .apiKey("<YOUR_BEARER_TOKEN_HERE>")
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

For capture-based payment methods such as Klarna, the payments are not listed here. Refer to the [List captures endpoint](list-captures) endpoint instead.

> 🔑 Access with
>
> [Access token with **settlements.read** **payments.read**](/reference/authentication)

### Example Usage

```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.GetSettlementPaymentsResponseBody;
import com.mollie.mollie.models.operations.GetSettlementPaymentsRequest;
import com.mollie.mollie.models.operations.GetSettlementPaymentsResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws GetSettlementPaymentsResponseBody, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey("<YOUR_BEARER_TOKEN_HERE>")
                    .build())
            .build();

        GetSettlementPaymentsRequest req = GetSettlementPaymentsRequest.builder()
                .settlementId("stl_jDk30akdN")
                .from("tr_5B8cwPMGnU")
                .sort("desc")
                .testmode(false)
                .build();

        GetSettlementPaymentsResponse res = sdk.settlements().listPayments()
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
| `request`                                                                               | [GetSettlementPaymentsRequest](../../models/operations/GetSettlementPaymentsRequest.md) | :heavy_check_mark:                                                                      | The request object to use for the request.                                              |

### Response

**[GetSettlementPaymentsResponse](../../models/operations/GetSettlementPaymentsResponse.md)**

### Errors

| Error Type                                      | Status Code                                     | Content Type                                    |
| ----------------------------------------------- | ----------------------------------------------- | ----------------------------------------------- |
| models/errors/GetSettlementPaymentsResponseBody | 400                                             | application/hal+json                            |
| models/errors/APIException                      | 4XX, 5XX                                        | \*/\*                                           |

## listCaptures

Retrieve all captures included in the given settlement.

The response is in the same format as the response of the [List captures endpoint](list-captures).

> 🔑 Access with
>
> [Access token with **settlements.read** **payments.read**](/reference/authentication)

### Example Usage

```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.GetSettlementCapturesResponseBody;
import com.mollie.mollie.models.errors.GetSettlementCapturesSettlementsResponseBody;
import com.mollie.mollie.models.operations.*;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws GetSettlementCapturesResponseBody, GetSettlementCapturesSettlementsResponseBody, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey("<YOUR_BEARER_TOKEN_HERE>")
                    .build())
            .build();

        GetSettlementCapturesRequest req = GetSettlementCapturesRequest.builder()
                .settlementId("stl_jDk30akdN")
                .from("cpt_vytxeTZskVKR7C7WgdSP3d")
                .embed(GetSettlementCapturesQueryParamEmbed.PAYMENT)
                .testmode(false)
                .build();

        GetSettlementCapturesResponse res = sdk.settlements().listCaptures()
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
| `request`                                                                               | [GetSettlementCapturesRequest](../../models/operations/GetSettlementCapturesRequest.md) | :heavy_check_mark:                                                                      | The request object to use for the request.                                              |

### Response

**[GetSettlementCapturesResponse](../../models/operations/GetSettlementCapturesResponse.md)**

### Errors

| Error Type                                                 | Status Code                                                | Content Type                                               |
| ---------------------------------------------------------- | ---------------------------------------------------------- | ---------------------------------------------------------- |
| models/errors/GetSettlementCapturesResponseBody            | 400                                                        | application/hal+json                                       |
| models/errors/GetSettlementCapturesSettlementsResponseBody | 404                                                        | application/hal+json                                       |
| models/errors/APIException                                 | 4XX, 5XX                                                   | \*/\*                                                      |

## listRefunds

Retrieve all refunds 'deducted' from the given settlement.

The response is in the same format as the response of the [List refunds endpoint](list-refunds).

> 🔑 Access with
>
> [Access token with **settlements.read** **refunds.read**](/reference/authentication)

### Example Usage

```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.GetSettlementRefundsResponseBody;
import com.mollie.mollie.models.errors.GetSettlementRefundsSettlementsResponseBody;
import com.mollie.mollie.models.operations.*;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws GetSettlementRefundsResponseBody, GetSettlementRefundsSettlementsResponseBody, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey("<YOUR_BEARER_TOKEN_HERE>")
                    .build())
            .build();

        GetSettlementRefundsRequest req = GetSettlementRefundsRequest.builder()
                .settlementId("stl_jDk30akdN")
                .from("re_5B8cwPMGnU")
                .include(GetSettlementRefundsQueryParamInclude.PAYMENT)
                .testmode(false)
                .build();

        GetSettlementRefundsResponse res = sdk.settlements().listRefunds()
                .request(req)
                .call();

        if (res.object().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                             | Type                                                                                  | Required                                                                              | Description                                                                           |
| ------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------- |
| `request`                                                                             | [GetSettlementRefundsRequest](../../models/operations/GetSettlementRefundsRequest.md) | :heavy_check_mark:                                                                    | The request object to use for the request.                                            |

### Response

**[GetSettlementRefundsResponse](../../models/operations/GetSettlementRefundsResponse.md)**

### Errors

| Error Type                                                | Status Code                                               | Content Type                                              |
| --------------------------------------------------------- | --------------------------------------------------------- | --------------------------------------------------------- |
| models/errors/GetSettlementRefundsResponseBody            | 400                                                       | application/hal+json                                      |
| models/errors/GetSettlementRefundsSettlementsResponseBody | 404                                                       | application/hal+json                                      |
| models/errors/APIException                                | 4XX, 5XX                                                  | \*/\*                                                     |

## listChargebacks

Retrieve all chargebacks 'deducted' from the given settlement.

The response is in the same format as the response of the [List chargebacks endpoint](list-chargebacks).

> 🔑 Access with
>
> [Access token with **settlements.read** **payments.read**](/reference/authentication)

### Example Usage

```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.GetSettlementChargebacksResponseBody;
import com.mollie.mollie.models.errors.GetSettlementChargebacksSettlementsResponseBody;
import com.mollie.mollie.models.operations.*;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws GetSettlementChargebacksResponseBody, GetSettlementChargebacksSettlementsResponseBody, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey("<YOUR_BEARER_TOKEN_HERE>")
                    .build())
            .build();

        GetSettlementChargebacksRequest req = GetSettlementChargebacksRequest.builder()
                .settlementId("stl_jDk30akdN")
                .from("chb_xFzwUN4ci8HAmSGUACS4J")
                .embed(GetSettlementChargebacksQueryParamEmbed.PAYMENT)
                .testmode(false)
                .build();

        GetSettlementChargebacksResponse res = sdk.settlements().listChargebacks()
                .request(req)
                .call();

        if (res.object().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                     | Type                                                                                          | Required                                                                                      | Description                                                                                   |
| --------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------- |
| `request`                                                                                     | [GetSettlementChargebacksRequest](../../models/operations/GetSettlementChargebacksRequest.md) | :heavy_check_mark:                                                                            | The request object to use for the request.                                                    |

### Response

**[GetSettlementChargebacksResponse](../../models/operations/GetSettlementChargebacksResponse.md)**

### Errors

| Error Type                                                    | Status Code                                                   | Content Type                                                  |
| ------------------------------------------------------------- | ------------------------------------------------------------- | ------------------------------------------------------------- |
| models/errors/GetSettlementChargebacksResponseBody            | 400                                                           | application/hal+json                                          |
| models/errors/GetSettlementChargebacksSettlementsResponseBody | 404                                                           | application/hal+json                                          |
| models/errors/APIException                                    | 4XX, 5XX                                                      | \*/\*                                                         |