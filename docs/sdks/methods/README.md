# Methods

## Overview

### Available Operations

* [list](#list) - List payment methods
* [all](#all) - List all payment methods
* [get](#get) - Get payment method
* [enable](#enable) - Enable payment method
* [disable](#disable) - Disable payment method
* [enableIssuer](#enableissuer) - Enable payment method issuer
* [disableIssuer](#disableissuer) - Disable payment method issuer

## list

Retrieve all enabled payment methods. The results of this endpoint are
**not** paginated — unlike most other list endpoints in our API.

For test mode, all pending and enabled payment methods are returned. If no
payment methods are requested yet, the most popular payment methods are returned in the test mode. For live
mode, only fully enabled payment methods are returned.

Payment methods can be requested and enabled via the Mollie Dashboard, or
via the [Enable payment method endpoint](enable-method) of the Profiles API.

The list can optionally be filtered using a number of parameters described
below.

By default, only payment methods for the Euro currency are returned. If you
wish to retrieve payment methods which exclusively support other currencies (e.g. Twint), you need to use the
`amount` parameters.

ℹ️ **Note:** This endpoint only returns **online** payment methods. If you wish to retrieve the information about
a non-online payment method, you can use the [Get payment method endpoint](get-method).

### Example Usage: list-method-200-3

<!-- UsageSnippet language="java" operationID="list-methods" method="get" path="/v2/methods" example="list-method-200-3" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.*;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.ListMethodsRequest;
import com.mollie.mollie.models.operations.ListMethodsResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .profileId("pfl_5B8cwPMGnU")
                .testmode(false)
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        ListMethodsRequest req = ListMethodsRequest.builder()
                .sequenceType(SequenceType.ONEOFF)
                .locale(Locale.EN_US)
                .amount(Amount.builder()
                    .currency("EUR")
                    .value("10.00")
                    .build())
                .resource(MethodResourceParameter.PAYMENTS)
                .billingCountry("DE")
                .includeWallets(MethodIncludeWalletsParameter.APPLEPAY)
                .orderLineCategories(LineCategories.ECO)
                .include("issuers")
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .build();

        ListMethodsResponse res = sdk.methods().list()
                .request(req)
                .call();

        if (res.object().isPresent()) {
            System.out.println(res.object().get());
        }
    }
}
```
### Example Usage: list-methods-200-1

<!-- UsageSnippet language="java" operationID="list-methods" method="get" path="/v2/methods" example="list-methods-200-1" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.*;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.ListMethodsRequest;
import com.mollie.mollie.models.operations.ListMethodsResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .profileId("pfl_5B8cwPMGnU")
                .testmode(false)
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        ListMethodsRequest req = ListMethodsRequest.builder()
                .sequenceType(SequenceType.ONEOFF)
                .locale(Locale.EN_US)
                .amount(Amount.builder()
                    .currency("EUR")
                    .value("10.00")
                    .build())
                .resource(MethodResourceParameter.PAYMENTS)
                .billingCountry("DE")
                .includeWallets(MethodIncludeWalletsParameter.APPLEPAY)
                .orderLineCategories(LineCategories.ECO)
                .include("issuers")
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .build();

        ListMethodsResponse res = sdk.methods().list()
                .request(req)
                .call();

        if (res.object().isPresent()) {
            System.out.println(res.object().get());
        }
    }
}
```
### Example Usage: list-methods-200-2

<!-- UsageSnippet language="java" operationID="list-methods" method="get" path="/v2/methods" example="list-methods-200-2" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.*;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.ListMethodsRequest;
import com.mollie.mollie.models.operations.ListMethodsResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .profileId("pfl_5B8cwPMGnU")
                .testmode(false)
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        ListMethodsRequest req = ListMethodsRequest.builder()
                .sequenceType(SequenceType.ONEOFF)
                .locale(Locale.EN_US)
                .amount(Amount.builder()
                    .currency("EUR")
                    .value("10.00")
                    .build())
                .resource(MethodResourceParameter.PAYMENTS)
                .billingCountry("DE")
                .includeWallets(MethodIncludeWalletsParameter.APPLEPAY)
                .orderLineCategories(LineCategories.ECO)
                .include("issuers")
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .build();

        ListMethodsResponse res = sdk.methods().list()
                .request(req)
                .call();

        if (res.object().isPresent()) {
            System.out.println(res.object().get());
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

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 400, 429                    | application/hal+json        |
| models/errors/APIException  | 4XX, 5XX                    | \*/\*                       |

## all

Retrieve all payment methods that Mollie offers, regardless of the eligibility of the organization for the specific
method. The results of this endpoint are **not** paginated — unlike most other list endpoints in our API.

The list can optionally be filtered using a number of parameters described below.

ℹ️ **Note:** This endpoint only returns **online** payment methods. If you wish to retrieve the information about
a non-online payment method, you can use the [Get payment method endpoint](get-method).

### Example Usage: list-all-methods-200-1

<!-- UsageSnippet language="java" operationID="list-all-methods" method="get" path="/v2/methods/all" example="list-all-methods-200-1" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.*;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.ListAllMethodsRequest;
import com.mollie.mollie.models.operations.ListAllMethodsResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .profileId("pfl_5B8cwPMGnU")
                .testmode(false)
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        ListAllMethodsRequest req = ListAllMethodsRequest.builder()
                .locale(Locale.EN_US)
                .amount(Amount.builder()
                    .currency("EUR")
                    .value("10.00")
                    .build())
                .include("issuers")
                .sequenceType(SequenceType.ONEOFF)
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .build();

        ListAllMethodsResponse res = sdk.methods().all()
                .request(req)
                .call();

        if (res.object().isPresent()) {
            System.out.println(res.object().get());
        }
    }
}
```
### Example Usage: list-all-methods-200-2

<!-- UsageSnippet language="java" operationID="list-all-methods" method="get" path="/v2/methods/all" example="list-all-methods-200-2" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.*;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.ListAllMethodsRequest;
import com.mollie.mollie.models.operations.ListAllMethodsResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .profileId("pfl_5B8cwPMGnU")
                .testmode(false)
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        ListAllMethodsRequest req = ListAllMethodsRequest.builder()
                .locale(Locale.EN_US)
                .amount(Amount.builder()
                    .currency("EUR")
                    .value("10.00")
                    .build())
                .include("issuers")
                .sequenceType(SequenceType.ONEOFF)
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .build();

        ListAllMethodsResponse res = sdk.methods().all()
                .request(req)
                .call();

        if (res.object().isPresent()) {
            System.out.println(res.object().get());
        }
    }
}
```
### Example Usage: list-all-methods-200-3

<!-- UsageSnippet language="java" operationID="list-all-methods" method="get" path="/v2/methods/all" example="list-all-methods-200-3" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.*;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.ListAllMethodsRequest;
import com.mollie.mollie.models.operations.ListAllMethodsResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .profileId("pfl_5B8cwPMGnU")
                .testmode(false)
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        ListAllMethodsRequest req = ListAllMethodsRequest.builder()
                .locale(Locale.EN_US)
                .amount(Amount.builder()
                    .currency("EUR")
                    .value("10.00")
                    .build())
                .include("issuers")
                .sequenceType(SequenceType.ONEOFF)
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .build();

        ListAllMethodsResponse res = sdk.methods().all()
                .request(req)
                .call();

        if (res.object().isPresent()) {
            System.out.println(res.object().get());
        }
    }
}
```
### Example Usage: list-all-methods-200-4

<!-- UsageSnippet language="java" operationID="list-all-methods" method="get" path="/v2/methods/all" example="list-all-methods-200-4" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.*;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.ListAllMethodsRequest;
import com.mollie.mollie.models.operations.ListAllMethodsResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .profileId("pfl_5B8cwPMGnU")
                .testmode(false)
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        ListAllMethodsRequest req = ListAllMethodsRequest.builder()
                .locale(Locale.EN_US)
                .amount(Amount.builder()
                    .currency("EUR")
                    .value("10.00")
                    .build())
                .include("issuers")
                .sequenceType(SequenceType.ONEOFF)
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .build();

        ListAllMethodsResponse res = sdk.methods().all()
                .request(req)
                .call();

        if (res.object().isPresent()) {
            System.out.println(res.object().get());
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

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 400, 429                    | application/hal+json        |
| models/errors/APIException  | 4XX, 5XX                    | \*/\*                       |

## get

Retrieve a single payment method by its ID.

If a method is not available on this profile, a `404 Not Found` response is
returned. If the method is available but not enabled yet, a status `403 Forbidden` is returned. You can enable
payments methods via the [Enable payment method endpoint](enable-method) of the Profiles API, or via
the Mollie Dashboard.

If you do not know the method's ID, you can use the [methods list
endpoint](list-methods) to retrieve all payment methods that are available.

Additionally, it is possible to check if wallet methods such as Apple Pay
are enabled by passing the wallet ID (`applepay`) as the method ID.

### Example Usage

<!-- UsageSnippet language="java" operationID="get-method" method="get" path="/v2/methods/{methodId}" example="get-method-200-1" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.*;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.GetMethodRequest;
import com.mollie.mollie.models.operations.GetMethodResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .profileId("pfl_5B8cwPMGnU")
                .testmode(false)
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        GetMethodRequest req = GetMethodRequest.builder()
                .methodId(Method.IDEAL)
                .locale(Locale.EN_US)
                .currency("EUR")
                .include("issuers")
                .sequenceType(SequenceType.ONEOFF)
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .build();

        GetMethodResponse res = sdk.methods().get()
                .request(req)
                .call();

        if (res.entityMethodGet().isPresent()) {
            System.out.println(res.entityMethodGet().get());
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

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 400, 404, 429               | application/hal+json        |
| models/errors/APIException  | 4XX, 5XX                    | \*/\*                       |

## enable

Enable a payment method on a specific profile.

When using a profile-specific API credential, the alias `me` can be used
instead of the profile ID to refer to the current profile.

Some payment methods require extra steps in order to be activated. In cases
where a step at the payment method provider needs to be completed first, the status will be set to
`pending-external` and the response will contain a link to complete the activation at the provider.

To enable voucher or gift card issuers, refer to the [Enable payment method issuer](enable-method-issuer) endpoint.

### Example Usage: enable-method-200-1

<!-- UsageSnippet language="java" operationID="enable-method" method="post" path="/v2/profiles/{profileId}/methods/{methodId}" example="enable-method-200-1" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Method;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.EnableMethodResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        EnableMethodResponse res = sdk.methods().enable()
                .profileId("pfl_5B8cwPMGnU")
                .methodId(Method.IDEAL)
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .call();

        if (res.entityMethodGet().isPresent()) {
            System.out.println(res.entityMethodGet().get());
        }
    }
}
```
### Example Usage: enable-method-200-2

<!-- UsageSnippet language="java" operationID="enable-method" method="post" path="/v2/profiles/{profileId}/methods/{methodId}" example="enable-method-200-2" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Method;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.EnableMethodResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        EnableMethodResponse res = sdk.methods().enable()
                .profileId("pfl_5B8cwPMGnU")
                .methodId(Method.IDEAL)
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .call();

        if (res.entityMethodGet().isPresent()) {
            System.out.println(res.entityMethodGet().get());
        }
    }
}
```
### Example Usage: enable-method-200-3

<!-- UsageSnippet language="java" operationID="enable-method" method="post" path="/v2/profiles/{profileId}/methods/{methodId}" example="enable-method-200-3" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Method;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.EnableMethodResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        EnableMethodResponse res = sdk.methods().enable()
                .profileId("pfl_5B8cwPMGnU")
                .methodId(Method.IDEAL)
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .call();

        if (res.entityMethodGet().isPresent()) {
            System.out.println(res.entityMethodGet().get());
        }
    }
}
```

### Parameters

| Parameter                                                                        | Type                                                                             | Required                                                                         | Description                                                                      | Example                                                                          |
| -------------------------------------------------------------------------------- | -------------------------------------------------------------------------------- | -------------------------------------------------------------------------------- | -------------------------------------------------------------------------------- | -------------------------------------------------------------------------------- |
| `profileId`                                                                      | *String*                                                                         | :heavy_check_mark:                                                               | Provide the ID of the related profile.                                           | pfl_5B8cwPMGnU                                                                   |
| `methodId`                                                                       | [Optional\<Method>](../../models/components/Method.md)                           | :heavy_check_mark:                                                               | Provide the ID of the related payment method.                                    | ideal                                                                            |
| `idempotencyKey`                                                                 | *Optional\<String>*                                                              | :heavy_minus_sign:                                                               | A unique key to ensure idempotent requests. This key should be a UUID v4 string. | 123e4567-e89b-12d3-a456-426                                                      |

### Response

**[EnableMethodResponse](../../models/operations/EnableMethodResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 404, 429                    | application/hal+json        |
| models/errors/APIException  | 4XX, 5XX                    | \*/\*                       |

## disable

Disable a payment method on a specific profile.

When using a profile-specific API credential, the alias `me` can be used
instead of the profile ID to refer to the current profile.

### Example Usage

<!-- UsageSnippet language="java" operationID="disable-method" method="delete" path="/v2/profiles/{profileId}/methods/{methodId}" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Method;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.DisableMethodResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        DisableMethodResponse res = sdk.methods().disable()
                .profileId("pfl_5B8cwPMGnU")
                .methodId(Method.IDEAL)
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .call();

        // handle response
    }
}
```

### Parameters

| Parameter                                                                        | Type                                                                             | Required                                                                         | Description                                                                      | Example                                                                          |
| -------------------------------------------------------------------------------- | -------------------------------------------------------------------------------- | -------------------------------------------------------------------------------- | -------------------------------------------------------------------------------- | -------------------------------------------------------------------------------- |
| `profileId`                                                                      | *String*                                                                         | :heavy_check_mark:                                                               | Provide the ID of the related profile.                                           | pfl_5B8cwPMGnU                                                                   |
| `methodId`                                                                       | [Optional\<Method>](../../models/components/Method.md)                           | :heavy_check_mark:                                                               | Provide the ID of the related payment method.                                    | ideal                                                                            |
| `idempotencyKey`                                                                 | *Optional\<String>*                                                              | :heavy_minus_sign:                                                               | A unique key to ensure idempotent requests. This key should be a UUID v4 string. | 123e4567-e89b-12d3-a456-426                                                      |

### Response

**[DisableMethodResponse](../../models/operations/DisableMethodResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 404, 429                    | application/hal+json        |
| models/errors/APIException  | 4XX, 5XX                    | \*/\*                       |

## enableIssuer

Enable an issuer for a payment method on a specific profile.

Currently only the payment methods `voucher` and `giftcard` are supported.

When using a profile-specific API credential, the alias `me` can be used instead of the profile ID to refer to the
current profile.

### Example Usage

<!-- UsageSnippet language="java" operationID="enable-method-issuer" method="post" path="/v2/profiles/{profileId}/methods/{methodId}/issuers/{issuerId}" example="enable-method-issuer-200-1" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.*;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.*;
import java.lang.Exception;
import java.lang.Object;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        EnableMethodIssuerRequest req = EnableMethodIssuerRequest.builder()
                .profileId("pfl_5B8cwPMGnU")
                .methodId(MethodIdWithIssuer.VOUCHER)
                .issuerId("edenred-france-sports")
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .requestBody(EnableMethodIssuerRequestBody.builder()
                    .contractId("ideal")
                    .build())
                .build();

        EnableMethodIssuerResponse res = sdk.methods().enableIssuer()
                .request(req)
                .call();

        if (res.oneOf().isPresent()) {
            EnableMethodIssuerResponseBody unionValue = res.oneOf().get();
            Object raw = unionValue.value();
            if (raw instanceof Giftcard) {
                Giftcard giftcardValue = (Giftcard) raw;
                // Handle giftcard variant
            } else if (raw instanceof Voucher) {
                Voucher voucherValue = (Voucher) raw;
                // Handle voucher variant
            } else {
                // Unknown or unsupported variant
            }
        }
    }
}
```

### Parameters

| Parameter                                                                         | Type                                                                              | Required                                                                          | Description                                                                       |
| --------------------------------------------------------------------------------- | --------------------------------------------------------------------------------- | --------------------------------------------------------------------------------- | --------------------------------------------------------------------------------- |
| `request`                                                                         | [EnableMethodIssuerRequest](../../models/operations/EnableMethodIssuerRequest.md) | :heavy_check_mark:                                                                | The request object to use for the request.                                        |

### Response

**[EnableMethodIssuerResponse](../../models/operations/EnableMethodIssuerResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 404, 429                    | application/hal+json        |
| models/errors/APIException  | 4XX, 5XX                    | \*/\*                       |

## disableIssuer

Disable an issuer for a payment method on a specific profile.

Currently only the payment methods `voucher` and `giftcard` are supported.

When using a profile-specific API credential, the alias `me` can be used instead of the profile ID to refer to the
current profile.

### Example Usage

<!-- UsageSnippet language="java" operationID="disable-method-issuer" method="delete" path="/v2/profiles/{profileId}/methods/{methodId}/issuers/{issuerId}" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.MethodIdWithIssuer;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.DisableMethodIssuerResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        DisableMethodIssuerResponse res = sdk.methods().disableIssuer()
                .profileId("pfl_5B8cwPMGnU")
                .methodId(MethodIdWithIssuer.VOUCHER)
                .issuerId("edenred-france-sports")
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .call();

        // handle response
    }
}
```

### Parameters

| Parameter                                                                        | Type                                                                             | Required                                                                         | Description                                                                      | Example                                                                          |
| -------------------------------------------------------------------------------- | -------------------------------------------------------------------------------- | -------------------------------------------------------------------------------- | -------------------------------------------------------------------------------- | -------------------------------------------------------------------------------- |
| `profileId`                                                                      | *String*                                                                         | :heavy_check_mark:                                                               | Provide the ID of the related profile.                                           | pfl_5B8cwPMGnU                                                                   |
| `methodId`                                                                       | [MethodIdWithIssuer](../../models/components/MethodIdWithIssuer.md)              | :heavy_check_mark:                                                               | Provide the ID of the related payment method.                                    | voucher                                                                          |
| `issuerId`                                                                       | *String*                                                                         | :heavy_check_mark:                                                               | Provide the ID of the related issuer.                                            | edenred-france-sports                                                            |
| `idempotencyKey`                                                                 | *Optional\<String>*                                                              | :heavy_minus_sign:                                                               | A unique key to ensure idempotent requests. This key should be a UUID v4 string. | 123e4567-e89b-12d3-a456-426                                                      |

### Response

**[DisableMethodIssuerResponse](../../models/operations/DisableMethodIssuerResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 404, 429                    | application/hal+json        |
| models/errors/APIException  | 4XX, 5XX                    | \*/\*                       |