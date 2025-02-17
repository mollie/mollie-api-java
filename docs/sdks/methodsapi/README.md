# MethodsAPI
(*methodsAPI()*)

## Overview

### Available Operations

* [list](#list) - List payment methods
* [listAll](#listall) - List all payment methods
* [get](#get) - Get payment method
* [enableMethod](#enablemethod) - Enable payment method
* [disableMethod](#disablemethod) - Disable payment method
* [enableMethodIssuer](#enablemethodissuer) - Enable payment method issuer
* [disableMethodIssuer](#disablemethodissuer) - Disable payment method issuer

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

### Example Usage

```java
package hello.world;

import com.mollie.mollie.Mollie;
import com.mollie.mollie.models.errors.ListMethodsResponseBody;
import com.mollie.mollie.models.operations.IncludeWallets;
import com.mollie.mollie.models.operations.ListMethodsRequest;
import com.mollie.mollie.models.operations.ListMethodsResponse;
import com.mollie.mollie.models.operations.ListMethodsSecurity;
import com.mollie.mollie.models.operations.QueryParamAmount;
import com.mollie.mollie.models.operations.QueryParamLocale;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ListMethodsResponseBody, Exception {

        Mollie sdk = Mollie.builder()
            .build();

        ListMethodsRequest req = ListMethodsRequest.builder()
                .locale(QueryParamLocale.EN_US)
                .amount(QueryParamAmount.builder()
                    .currency("EUR")
                    .value("10.00")
                    .build())
                .billingCountry("DE")
                .includeWallets(IncludeWallets.APPLEPAY)
                .orderLineCategories("eco")
                .profileId("pfl_QkEhN94Ba")
                .include("issuers")
                .build();

        ListMethodsResponse res = sdk.methodsAPI().list()
                .request(req)
                .security(ListMethodsSecurity.builder()
                    .apiKey("<YOUR_BEARER_TOKEN_HERE>")
                    .build())
                .call();

        if (res.object().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                 | Type                                                                                                      | Required                                                                                                  | Description                                                                                               |
| --------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------- |
| `request`                                                                                                 | [ListMethodsRequest](../../models/operations/ListMethodsRequest.md)                                       | :heavy_check_mark:                                                                                        | The request object to use for the request.                                                                |
| `security`                                                                                                | [com.mollie.mollie.models.operations.ListMethodsSecurity](../../models/operations/ListMethodsSecurity.md) | :heavy_check_mark:                                                                                        | The security requirements to use for the request.                                                         |

### Response

**[ListMethodsResponse](../../models/operations/ListMethodsResponse.md)**

### Errors

| Error Type                            | Status Code                           | Content Type                          |
| ------------------------------------- | ------------------------------------- | ------------------------------------- |
| models/errors/ListMethodsResponseBody | 400                                   | application/hal+json                  |
| models/errors/APIException            | 4XX, 5XX                              | \*/\*                                 |

## listAll

Retrieve all payment methods that Mollie offers, regardless of the eligibility of the organization for the specific
method. The results of this endpoint are **not** paginated — unlike most other list endpoints in our API.

The list can optionally be filtered using a number of parameters described below.

### Example Usage

```java
package hello.world;

import com.mollie.mollie.Mollie;
import com.mollie.mollie.models.errors.ListAllMethodsResponseBody;
import com.mollie.mollie.models.operations.ListAllMethodsQueryParamAmount;
import com.mollie.mollie.models.operations.ListAllMethodsResponse;
import com.mollie.mollie.models.operations.ListAllMethodsSecurity;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ListAllMethodsResponseBody, Exception {

        Mollie sdk = Mollie.builder()
            .build();

        ListAllMethodsResponse res = sdk.methodsAPI().listAll()
                .security(ListAllMethodsSecurity.builder()
                    .apiKey("<YOUR_BEARER_TOKEN_HERE>")
                    .build())
                .locale("en_US")
                .amount(ListAllMethodsQueryParamAmount.builder()
                    .currency("EUR")
                    .value("10.00")
                    .build())
                .include("issuers")
                .call();

        if (res.object().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                                                                                                                                                                                                                                                                      | Type                                                                                                                                                                                                                                                                                                                                                           | Required                                                                                                                                                                                                                                                                                                                                                       | Description                                                                                                                                                                                                                                                                                                                                                    | Example                                                                                                                                                                                                                                                                                                                                                        |
| -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `security`                                                                                                                                                                                                                                                                                                                                                     | [com.mollie.mollie.models.operations.ListAllMethodsSecurity](../../models/operations/ListAllMethodsSecurity.md)                                                                                                                                                                                                                                                | :heavy_check_mark:                                                                                                                                                                                                                                                                                                                                             | The security requirements to use for the request.                                                                                                                                                                                                                                                                                                              |                                                                                                                                                                                                                                                                                                                                                                |
| `locale`                                                                                                                                                                                                                                                                                                                                                       | *Optional\<String>*                                                                                                                                                                                                                                                                                                                                            | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                             | Passing a locale will sort the payment methods in the preferred order<br/>for the country, and translate the payment method names in the corresponding language.<br/><br/>Possible values: `en_US` `en_GB` `nl_NL` `nl_BE` `de_DE` `de_AT` `de_CH`<br/>`fr_FR` `fr_BE` `es_ES` `ca_ES` `pt_PT` `it_IT` `nb_NO` `sv_SE` `fi_FI` `da_DK` `is_IS` `hu_HU` `pl_PL` `lv_LV`<br/>`lt_LT` | en_US                                                                                                                                                                                                                                                                                                                                                          |
| `amount`                                                                                                                                                                                                                                                                                                                                                       | [Optional\<ListAllMethodsQueryParamAmount>](../../models/operations/ListAllMethodsQueryParamAmount.md)                                                                                                                                                                                                                                                         | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                             | If supplied, only payment methods that support the amount and currency<br/>are returned.<br/><br/>Example: `/v2/methods/all?amount[value]=100.00&amount[currency]=USD`                                                                                                                                                                                         |                                                                                                                                                                                                                                                                                                                                                                |
| `include`                                                                                                                                                                                                                                                                                                                                                      | *JsonNullable\<String>*                                                                                                                                                                                                                                                                                                                                        | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                             | This endpoint allows you to include additional information via the<br/>`include` query string parameter.<br/><br/>* `issuers`: Include issuer details such as which iDEAL or gift card<br/>issuers are available.<br/>* `pricing`: Include pricing for each payment method.                                                                                    | issuers                                                                                                                                                                                                                                                                                                                                                        |

### Response

**[ListAllMethodsResponse](../../models/operations/ListAllMethodsResponse.md)**

### Errors

| Error Type                               | Status Code                              | Content Type                             |
| ---------------------------------------- | ---------------------------------------- | ---------------------------------------- |
| models/errors/ListAllMethodsResponseBody | 400                                      | application/hal+json                     |
| models/errors/APIException               | 4XX, 5XX                                 | \*/\*                                    |

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

```java
package hello.world;

import com.mollie.mollie.Mollie;
import com.mollie.mollie.models.errors.GetMethodMethodsAPIResponseBody;
import com.mollie.mollie.models.errors.GetMethodResponseBody;
import com.mollie.mollie.models.operations.GetMethodRequest;
import com.mollie.mollie.models.operations.GetMethodResponse;
import com.mollie.mollie.models.operations.GetMethodSecurity;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws GetMethodResponseBody, GetMethodMethodsAPIResponseBody, Exception {

        Mollie sdk = Mollie.builder()
            .build();

        GetMethodRequest req = GetMethodRequest.builder()
                .id("ideal")
                .locale("en_US")
                .currency("EUR")
                .profileId("pfl_QkEhN94Ba")
                .include("issuers")
                .build();

        GetMethodResponse res = sdk.methodsAPI().get()
                .request(req)
                .security(GetMethodSecurity.builder()
                    .apiKey("<YOUR_BEARER_TOKEN_HERE>")
                    .build())
                .call();

        if (res.object().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                             | Type                                                                                                  | Required                                                                                              | Description                                                                                           |
| ----------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------- |
| `request`                                                                                             | [GetMethodRequest](../../models/operations/GetMethodRequest.md)                                       | :heavy_check_mark:                                                                                    | The request object to use for the request.                                                            |
| `security`                                                                                            | [com.mollie.mollie.models.operations.GetMethodSecurity](../../models/operations/GetMethodSecurity.md) | :heavy_check_mark:                                                                                    | The security requirements to use for the request.                                                     |

### Response

**[GetMethodResponse](../../models/operations/GetMethodResponse.md)**

### Errors

| Error Type                                    | Status Code                                   | Content Type                                  |
| --------------------------------------------- | --------------------------------------------- | --------------------------------------------- |
| models/errors/GetMethodResponseBody           | 400                                           | application/hal+json                          |
| models/errors/GetMethodMethodsAPIResponseBody | 404                                           | application/hal+json                          |
| models/errors/APIException                    | 4XX, 5XX                                      | \*/\*                                         |

## enableMethod

Enable a payment method on a specific profile.

When using a profile-specific API credential, the alias `me` can be used
instead of the profile ID to refer to the current profile.

Some payment methods require extra steps in order to be activated. In cases
where a step at the payment method provider needs to be completed first, the status will be set to
`pending-external` and the response will contain a link to complete the activation at the provider.

To enable voucher or gift card issuers, refer to the [Enable payment method issuer](enable-method-issuer) endpoint.

### Example Usage

```java
package hello.world;

import com.mollie.mollie.Mollie;
import com.mollie.mollie.models.errors.EnableMethodResponseBody;
import com.mollie.mollie.models.operations.EnableMethodResponse;
import com.mollie.mollie.models.operations.EnableMethodSecurity;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws EnableMethodResponseBody, Exception {

        Mollie sdk = Mollie.builder()
            .build();

        EnableMethodResponse res = sdk.methodsAPI().enableMethod()
                .security(EnableMethodSecurity.builder()
                    .apiKey("<YOUR_BEARER_TOKEN_HERE>")
                    .build())
                .profileId("pfl_QkEhN94Ba")
                .id("ideal")
                .call();

        if (res.object().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                   | Type                                                                                                        | Required                                                                                                    | Description                                                                                                 | Example                                                                                                     |
| ----------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------- |
| `security`                                                                                                  | [com.mollie.mollie.models.operations.EnableMethodSecurity](../../models/operations/EnableMethodSecurity.md) | :heavy_check_mark:                                                                                          | The security requirements to use for the request.                                                           |                                                                                                             |
| `profileId`                                                                                                 | *String*                                                                                                    | :heavy_check_mark:                                                                                          | Provide the ID of the related profile.                                                                      | pfl_QkEhN94Ba                                                                                               |
| `id`                                                                                                        | *String*                                                                                                    | :heavy_check_mark:                                                                                          | Provide the ID of the item you want to perform this operation on.                                           | ideal                                                                                                       |

### Response

**[EnableMethodResponse](../../models/operations/EnableMethodResponse.md)**

### Errors

| Error Type                             | Status Code                            | Content Type                           |
| -------------------------------------- | -------------------------------------- | -------------------------------------- |
| models/errors/EnableMethodResponseBody | 404                                    | application/hal+json                   |
| models/errors/APIException             | 4XX, 5XX                               | \*/\*                                  |

## disableMethod

Disable a payment method on a specific profile.

When using a profile-specific API credential, the alias `me` can be used
instead of the profile ID to refer to the current profile.

### Example Usage

```java
package hello.world;

import com.mollie.mollie.Mollie;
import com.mollie.mollie.models.errors.DisableMethodResponseBody;
import com.mollie.mollie.models.operations.DisableMethodResponse;
import com.mollie.mollie.models.operations.DisableMethodSecurity;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws DisableMethodResponseBody, Exception {

        Mollie sdk = Mollie.builder()
            .build();

        DisableMethodResponse res = sdk.methodsAPI().disableMethod()
                .security(DisableMethodSecurity.builder()
                    .apiKey("<YOUR_BEARER_TOKEN_HERE>")
                    .build())
                .profileId("pfl_QkEhN94Ba")
                .id("ideal")
                .call();

        if (res.any().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                     | Type                                                                                                          | Required                                                                                                      | Description                                                                                                   | Example                                                                                                       |
| ------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------- |
| `security`                                                                                                    | [com.mollie.mollie.models.operations.DisableMethodSecurity](../../models/operations/DisableMethodSecurity.md) | :heavy_check_mark:                                                                                            | The security requirements to use for the request.                                                             |                                                                                                               |
| `profileId`                                                                                                   | *String*                                                                                                      | :heavy_check_mark:                                                                                            | Provide the ID of the related profile.                                                                        | pfl_QkEhN94Ba                                                                                                 |
| `id`                                                                                                          | *String*                                                                                                      | :heavy_check_mark:                                                                                            | Provide the ID of the item you want to perform this operation on.                                             | ideal                                                                                                         |

### Response

**[DisableMethodResponse](../../models/operations/DisableMethodResponse.md)**

### Errors

| Error Type                              | Status Code                             | Content Type                            |
| --------------------------------------- | --------------------------------------- | --------------------------------------- |
| models/errors/DisableMethodResponseBody | 404                                     | application/hal+json                    |
| models/errors/APIException              | 4XX, 5XX                                | \*/\*                                   |

## enableMethodIssuer

Enable an issuer for a payment method on a specific profile.

Currently only the payment methods `voucher` and `giftcard` are supported.

When using a profile-specific API credential, the alias `me` can be used instead of the profile ID to refer to the
current profile.

### Example Usage

```java
package hello.world;

import com.mollie.mollie.Mollie;
import com.mollie.mollie.models.errors.EnableMethodIssuerResponseBody;
import com.mollie.mollie.models.operations.EnableMethodIssuerRequestBody;
import com.mollie.mollie.models.operations.EnableMethodIssuerResponse;
import com.mollie.mollie.models.operations.EnableMethodIssuerSecurity;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws EnableMethodIssuerResponseBody, Exception {

        Mollie sdk = Mollie.builder()
            .build();

        EnableMethodIssuerResponse res = sdk.methodsAPI().enableMethodIssuer()
                .security(EnableMethodIssuerSecurity.builder()
                    .apiKey("<YOUR_BEARER_TOKEN_HERE>")
                    .build())
                .profileId("pfl_QkEhN94Ba")
                .methodId("voucher")
                .id("edenred-france-sports")
                .requestBody(EnableMethodIssuerRequestBody.builder()
                    .build())
                .call();

        if (res.object().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                               | Type                                                                                                                    | Required                                                                                                                | Description                                                                                                             | Example                                                                                                                 |
| ----------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------- |
| `security`                                                                                                              | [com.mollie.mollie.models.operations.EnableMethodIssuerSecurity](../../models/operations/EnableMethodIssuerSecurity.md) | :heavy_check_mark:                                                                                                      | The security requirements to use for the request.                                                                       |                                                                                                                         |
| `profileId`                                                                                                             | *String*                                                                                                                | :heavy_check_mark:                                                                                                      | Provide the ID of the related profile.                                                                                  | pfl_QkEhN94Ba                                                                                                           |
| `methodId`                                                                                                              | *String*                                                                                                                | :heavy_check_mark:                                                                                                      | Provide the ID of the related payment method.                                                                           | voucher                                                                                                                 |
| `id`                                                                                                                    | *String*                                                                                                                | :heavy_check_mark:                                                                                                      | Provide the ID of the item you want to perform this operation on.                                                       | edenred-france-sports                                                                                                   |
| `requestBody`                                                                                                           | [Optional\<EnableMethodIssuerRequestBody>](../../models/operations/EnableMethodIssuerRequestBody.md)                    | :heavy_minus_sign:                                                                                                      | N/A                                                                                                                     |                                                                                                                         |

### Response

**[EnableMethodIssuerResponse](../../models/operations/EnableMethodIssuerResponse.md)**

### Errors

| Error Type                                   | Status Code                                  | Content Type                                 |
| -------------------------------------------- | -------------------------------------------- | -------------------------------------------- |
| models/errors/EnableMethodIssuerResponseBody | 404                                          | application/hal+json                         |
| models/errors/APIException                   | 4XX, 5XX                                     | \*/\*                                        |

## disableMethodIssuer

Disable an issuer for a payment method on a specific profile.

Currently only the payment methods `voucher` and `giftcard` are supported.

When using a profile-specific API credential, the alias `me` can be used instead of the profile ID to refer to the
current profile.

### Example Usage

```java
package hello.world;

import com.mollie.mollie.Mollie;
import com.mollie.mollie.models.errors.DisableMethodIssuerResponseBody;
import com.mollie.mollie.models.operations.DisableMethodIssuerResponse;
import com.mollie.mollie.models.operations.DisableMethodIssuerSecurity;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws DisableMethodIssuerResponseBody, Exception {

        Mollie sdk = Mollie.builder()
            .build();

        DisableMethodIssuerResponse res = sdk.methodsAPI().disableMethodIssuer()
                .security(DisableMethodIssuerSecurity.builder()
                    .apiKey("<YOUR_BEARER_TOKEN_HERE>")
                    .build())
                .profileId("pfl_QkEhN94Ba")
                .methodId("voucher")
                .id("edenred-france-sports")
                .call();

        if (res.any().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                                 | Type                                                                                                                      | Required                                                                                                                  | Description                                                                                                               | Example                                                                                                                   |
| ------------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------- |
| `security`                                                                                                                | [com.mollie.mollie.models.operations.DisableMethodIssuerSecurity](../../models/operations/DisableMethodIssuerSecurity.md) | :heavy_check_mark:                                                                                                        | The security requirements to use for the request.                                                                         |                                                                                                                           |
| `profileId`                                                                                                               | *String*                                                                                                                  | :heavy_check_mark:                                                                                                        | Provide the ID of the related profile.                                                                                    | pfl_QkEhN94Ba                                                                                                             |
| `methodId`                                                                                                                | *String*                                                                                                                  | :heavy_check_mark:                                                                                                        | Provide the ID of the related payment method.                                                                             | voucher                                                                                                                   |
| `id`                                                                                                                      | *String*                                                                                                                  | :heavy_check_mark:                                                                                                        | Provide the ID of the item you want to perform this operation on.                                                         | edenred-france-sports                                                                                                     |

### Response

**[DisableMethodIssuerResponse](../../models/operations/DisableMethodIssuerResponse.md)**

### Errors

| Error Type                                    | Status Code                                   | Content Type                                  |
| --------------------------------------------- | --------------------------------------------- | --------------------------------------------- |
| models/errors/DisableMethodIssuerResponseBody | 404                                           | application/hal+json                          |
| models/errors/APIException                    | 4XX, 5XX                                      | \*/\*                                         |