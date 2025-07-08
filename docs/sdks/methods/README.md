# Methods
(*methods()*)

## Overview

### Available Operations

* [list](#list) - List payment methods
* [all](#all) - List all payment methods
* [get](#get) - Get payment method

## list

Retrieve all enabled payment methods. The results of this endpoint are **not** paginated — unlike most other list endpoints in our API.

For test mode, all pending and enabled payment methods are returned. If no payment methods are requested yet, the most popular payment methods are returned in the test mode. For live mode, only fully enabled payment methods are returned.

Payment methods can be requested and enabled via the Mollie Dashboard, or via the [Enable payment method endpoint](enable-method) of the Profiles API.

The list can optionally be filtered using a number of parameters described below.

By default, only payment methods for the Euro currency are returned. If you wish to retrieve payment methods which exclusively support other currencies (e.g. Twint), you need to use the `amount` parameters.

> 🔑 Access with
>
> [API key](/reference/authentication)
>
> [Access token with **payments.read**](/reference/authentication)

### Example Usage

```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.ListMethodsResponseBody;
import com.mollie.mollie.models.operations.*;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ListMethodsResponseBody, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        ListMethodsRequest req = ListMethodsRequest.builder()
                .locale("en_US")
                .amount(QueryParamAmount.builder()
                    .currency("EUR")
                    .value("10.00")
                    .build())
                .billingCountry("DE")
                .includeWallets("applepay")
                .orderLineCategories("eco")
                .profileId("pfl_5B8cwPMGnU")
                .include(ListMethodsQueryParamInclude.ISSUERS)
                .testmode(false)
                .build();

        ListMethodsResponse res = sdk.methods().list()
                .request(req)
                .call();

        if (res.object().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                           | Type                                                                | Required                                                            | Description                                                         |
| ------------------------------------------------------------------- | ------------------------------------------------------------------- | ------------------------------------------------------------------- | ------------------------------------------------------------------- |
| `request`                                                           | [ListMethodsRequest](../../models/operations/ListMethodsRequest.md) | :heavy_check_mark:                                                  | The request object to use for the request.                          |

### Response

**[ListMethodsResponse](../../models/operations/ListMethodsResponse.md)**

### Errors

| Error Type                            | Status Code                           | Content Type                          |
| ------------------------------------- | ------------------------------------- | ------------------------------------- |
| models/errors/ListMethodsResponseBody | 400                                   | application/hal+json                  |
| models/errors/APIException            | 4XX, 5XX                              | \*/\*                                 |

## all

Retrieve all payment methods that Mollie offers, regardless of the eligibility of the organization for the specific method. The results of this endpoint are **not** paginated — unlike most other list endpoints in our API.

The list can optionally be filtered using a number of parameters described below.

> 🔑 Access with
>
> [API key](/reference/authentication)
>
> [Access token with **payments.read**](/reference/authentication)

### Example Usage

```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.ListAllMethodsResponseBody;
import com.mollie.mollie.models.operations.*;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ListAllMethodsResponseBody, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        ListAllMethodsRequest req = ListAllMethodsRequest.builder()
                .locale("en_US")
                .amount(ListAllMethodsQueryParamAmount.builder()
                    .currency("EUR")
                    .value("10.00")
                    .build())
                .include(ListAllMethodsQueryParamInclude.ISSUERS)
                .profileId("pfl_5B8cwPMGnU")
                .testmode(false)
                .build();

        ListAllMethodsResponse res = sdk.methods().all()
                .request(req)
                .call();

        if (res.object().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                 | Type                                                                      | Required                                                                  | Description                                                               |
| ------------------------------------------------------------------------- | ------------------------------------------------------------------------- | ------------------------------------------------------------------------- | ------------------------------------------------------------------------- |
| `request`                                                                 | [ListAllMethodsRequest](../../models/operations/ListAllMethodsRequest.md) | :heavy_check_mark:                                                        | The request object to use for the request.                                |

### Response

**[ListAllMethodsResponse](../../models/operations/ListAllMethodsResponse.md)**

### Errors

| Error Type                               | Status Code                              | Content Type                             |
| ---------------------------------------- | ---------------------------------------- | ---------------------------------------- |
| models/errors/ListAllMethodsResponseBody | 400                                      | application/hal+json                     |
| models/errors/APIException               | 4XX, 5XX                                 | \*/\*                                    |

## get

Retrieve a single payment method by its ID.

If a method is not available on this profile, a `404 Not Found` response is returned. If the method is available but not enabled yet, a status `403 Forbidden` is returned. You can enable payments methods via the [Enable payment method endpoint](enable-method) of the Profiles API, or via the Mollie Dashboard.

If you do not know the method's ID, you can use the [methods list endpoint](list-methods) to retrieve all payment methods that are available.

Additionally, it is possible to check if wallet methods such as Apple Pay are enabled by passing the wallet ID (`applepay`) as the method ID.

> 🔑 Access with
>
> [API key](/reference/authentication)
>
> [Access token with **payments.read**](/reference/authentication)

### Example Usage

```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.GetMethodMethodsResponseBody;
import com.mollie.mollie.models.errors.GetMethodResponseBody;
import com.mollie.mollie.models.operations.*;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws GetMethodResponseBody, GetMethodMethodsResponseBody, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        GetMethodRequest req = GetMethodRequest.builder()
                .id("ideal")
                .locale("en_US")
                .currency("EUR")
                .profileId("pfl_5B8cwPMGnU")
                .include(GetMethodQueryParamInclude.ISSUERS)
                .testmode(false)
                .build();

        GetMethodResponse res = sdk.methods().get()
                .request(req)
                .call();

        if (res.object().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                       | Type                                                            | Required                                                        | Description                                                     |
| --------------------------------------------------------------- | --------------------------------------------------------------- | --------------------------------------------------------------- | --------------------------------------------------------------- |
| `request`                                                       | [GetMethodRequest](../../models/operations/GetMethodRequest.md) | :heavy_check_mark:                                              | The request object to use for the request.                      |

### Response

**[GetMethodResponse](../../models/operations/GetMethodResponse.md)**

### Errors

| Error Type                                 | Status Code                                | Content Type                               |
| ------------------------------------------ | ------------------------------------------ | ------------------------------------------ |
| models/errors/GetMethodResponseBody        | 400                                        | application/hal+json                       |
| models/errors/GetMethodMethodsResponseBody | 404                                        | application/hal+json                       |
| models/errors/APIException                 | 4XX, 5XX                                   | \*/\*                                      |