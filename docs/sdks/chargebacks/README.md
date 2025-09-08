# Chargebacks
(*chargebacks()*)

## Overview

### Available Operations

* [list](#list) - List payment chargebacks
* [get](#get) - Get payment chargeback
* [all](#all) - List all chargebacks

## list

Retrieve the chargebacks initiated for a specific payment.

The results are paginated.

### Example Usage

<!-- UsageSnippet language="java" operationID="list-chargebacks" method="get" path="/payments/{paymentId}/chargebacks" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.ListChargebacksRequest;
import com.mollie.mollie.models.operations.ListChargebacksResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        ListChargebacksRequest req = ListChargebacksRequest.builder()
                .paymentId("tr_5B8cwPMGnU")
                .from("chb_xFzwUN4ci8HAmSGUACS4J")
                .limit(50L)
                .embed("payment")
                .testmode(false)
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .build();

        ListChargebacksResponse res = sdk.chargebacks().list()
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
| `request`                                                                   | [ListChargebacksRequest](../../models/operations/ListChargebacksRequest.md) | :heavy_check_mark:                                                          | The request object to use for the request.                                  |

### Response

**[ListChargebacksResponse](../../models/operations/ListChargebacksResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 400, 404                    | application/hal+json        |
| models/errors/APIException  | 4XX, 5XX                    | \*/\*                       |

## get

Retrieve a single payment chargeback by its ID and the ID of its parent payment.

### Example Usage

<!-- UsageSnippet language="java" operationID="get-chargeback" method="get" path="/payments/{paymentId}/chargebacks/{chargebackId}" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.GetChargebackRequest;
import com.mollie.mollie.models.operations.GetChargebackResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        GetChargebackRequest req = GetChargebackRequest.builder()
                .paymentId("tr_5B8cwPMGnU")
                .chargebackId("chb_xFzwUN4ci8HAmSGUACS4J")
                .embed("payment")
                .testmode(false)
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .build();

        GetChargebackResponse res = sdk.chargebacks().get()
                .request(req)
                .call();

        if (res.entityChargeback().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                               | Type                                                                    | Required                                                                | Description                                                             |
| ----------------------------------------------------------------------- | ----------------------------------------------------------------------- | ----------------------------------------------------------------------- | ----------------------------------------------------------------------- |
| `request`                                                               | [GetChargebackRequest](../../models/operations/GetChargebackRequest.md) | :heavy_check_mark:                                                      | The request object to use for the request.                              |

### Response

**[GetChargebackResponse](../../models/operations/GetChargebackResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 404                         | application/hal+json        |
| models/errors/APIException  | 4XX, 5XX                    | \*/\*                       |

## all

Retrieve all chargebacks initiated for all your payments.

The results are paginated.

### Example Usage

<!-- UsageSnippet language="java" operationID="list-all-chargebacks" method="get" path="/chargebacks" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.ListSort;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.ListAllChargebacksRequest;
import com.mollie.mollie.models.operations.ListAllChargebacksResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        ListAllChargebacksRequest req = ListAllChargebacksRequest.builder()
                .from("chb_xFzwUN4ci8HAmSGUACS4J")
                .limit(50L)
                .embed("payment")
                .sort(ListSort.DESC)
                .profileId("pfl_5B8cwPMGnU")
                .testmode(false)
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .build();

        ListAllChargebacksResponse res = sdk.chargebacks().all()
                .request(req)
                .call();

        if (res.object().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                         | Type                                                                              | Required                                                                          | Description                                                                       |
| --------------------------------------------------------------------------------- | --------------------------------------------------------------------------------- | --------------------------------------------------------------------------------- | --------------------------------------------------------------------------------- |
| `request`                                                                         | [ListAllChargebacksRequest](../../models/operations/ListAllChargebacksRequest.md) | :heavy_check_mark:                                                                | The request object to use for the request.                                        |

### Response

**[ListAllChargebacksResponse](../../models/operations/ListAllChargebacksResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 400, 404                    | application/hal+json        |
| models/errors/APIException  | 4XX, 5XX                    | \*/\*                       |