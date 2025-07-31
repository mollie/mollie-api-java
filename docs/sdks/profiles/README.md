# Profiles
(*profiles()*)

## Overview

### Available Operations

* [create](#create) - Create profile
* [list](#list) - List profiles
* [get](#get) - Get profile
* [update](#update) - Update profile
* [delete](#delete) - Delete profile
* [getCurrent](#getcurrent) - Get current profile

## create

Create a profile to process payments on.

Profiles are required for payment processing. Normally they are created via the Mollie dashboard. Alternatively, you
can use this endpoint to automate profile creation.

### Example Usage

<!-- UsageSnippet language="java" operationID="create-profile" method="post" path="/profiles" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.CreateProfileResponseBody;
import com.mollie.mollie.models.operations.CreateProfileRequestBody;
import com.mollie.mollie.models.operations.CreateProfileResponse;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws CreateProfileResponseBody, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        CreateProfileRequestBody req = CreateProfileRequestBody.builder()
                .name("My website name")
                .website("https://example.com")
                .email("test@mollie.com")
                .phone("+31208202070")
                .description("My website description")
                .countriesOfActivity(List.of(
                    "NL",
                    "GB"))
                .businessCategory("OTHER_MERCHANDISE")
                .build();

        CreateProfileResponse res = sdk.profiles().create()
                .request(req)
                .call();

        if (res.object().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                       | Type                                                                            | Required                                                                        | Description                                                                     |
| ------------------------------------------------------------------------------- | ------------------------------------------------------------------------------- | ------------------------------------------------------------------------------- | ------------------------------------------------------------------------------- |
| `request`                                                                       | [CreateProfileRequestBody](../../models/operations/CreateProfileRequestBody.md) | :heavy_check_mark:                                                              | The request object to use for the request.                                      |

### Response

**[CreateProfileResponse](../../models/operations/CreateProfileResponse.md)**

### Errors

| Error Type                              | Status Code                             | Content Type                            |
| --------------------------------------- | --------------------------------------- | --------------------------------------- |
| models/errors/CreateProfileResponseBody | 422                                     | application/hal+json                    |
| models/errors/APIException              | 4XX, 5XX                                | \*/\*                                   |

## list

Retrieve a list of all of your profiles.

The results are paginated.

### Example Usage

<!-- UsageSnippet language="java" operationID="list-profiles" method="get" path="/profiles" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.ListProfilesResponseBody;
import com.mollie.mollie.models.operations.ListProfilesResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ListProfilesResponseBody, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        ListProfilesResponse res = sdk.profiles().list()
                .from("pfl_QkEhN94Ba")
                .limit(50L)
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
| `from`                                                                                                                         | *Optional\<String>*                                                                                                            | :heavy_minus_sign:                                                                                                             | Provide an ID to start the result set from the item with the given ID and onwards. This allows you to paginate the<br/>result set. | pfl_QkEhN94Ba                                                                                                                  |
| `limit`                                                                                                                        | *JsonNullable\<Long>*                                                                                                          | :heavy_minus_sign:                                                                                                             | The maximum number of items to return. Defaults to 50 items.                                                                   | 50                                                                                                                             |

### Response

**[ListProfilesResponse](../../models/operations/ListProfilesResponse.md)**

### Errors

| Error Type                             | Status Code                            | Content Type                           |
| -------------------------------------- | -------------------------------------- | -------------------------------------- |
| models/errors/ListProfilesResponseBody | 400                                    | application/hal+json                   |
| models/errors/APIException             | 4XX, 5XX                               | \*/\*                                  |

## get

Retrieve a single profile by its ID.

### Example Usage

<!-- UsageSnippet language="java" operationID="get-profile" method="get" path="/profiles/{id}" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.GetProfileProfilesResponseBody;
import com.mollie.mollie.models.errors.GetProfileResponseBody;
import com.mollie.mollie.models.operations.GetProfileResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws GetProfileResponseBody, GetProfileProfilesResponseBody, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        GetProfileResponse res = sdk.profiles().get()
                .id("pfl_QkEhN94Ba")
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
| `id`                                                                                                                                                                                                                                                                                                                                                                                   | *String*                                                                                                                                                                                                                                                                                                                                                                               | :heavy_check_mark:                                                                                                                                                                                                                                                                                                                                                                     | Provide the ID of the item you want to perform this operation on.                                                                                                                                                                                                                                                                                                                      | pfl_QkEhN94Ba                                                                                                                                                                                                                                                                                                                                                                          |
| `testmode`                                                                                                                                                                                                                                                                                                                                                                             | *JsonNullable\<Boolean>*                                                                                                                                                                                                                                                                                                                                                               | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                     | Most API credentials are specifically created for either live mode or test mode. In those cases the `testmode` query<br/>parameter can be omitted. For organization-level credentials such as OAuth access tokens, you can enable test mode by<br/>setting the `testmode` query parameter to `true`.<br/><br/>Test entities cannot be retrieved when the endpoint is set to live mode, and vice versa. | false                                                                                                                                                                                                                                                                                                                                                                                  |

### Response

**[GetProfileResponse](../../models/operations/GetProfileResponse.md)**

### Errors

| Error Type                                   | Status Code                                  | Content Type                                 |
| -------------------------------------------- | -------------------------------------------- | -------------------------------------------- |
| models/errors/GetProfileResponseBody         | 404                                          | application/hal+json                         |
| models/errors/GetProfileProfilesResponseBody | 410                                          | application/hal+json                         |
| models/errors/APIException                   | 4XX, 5XX                                     | \*/\*                                        |

## update

Update an existing profile.

Profiles are required for payment processing. Normally they are created and updated via the Mollie dashboard.
Alternatively, you can use this endpoint to automate profile management.

### Example Usage

<!-- UsageSnippet language="java" operationID="update-profile" method="patch" path="/profiles/{id}" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.*;
import com.mollie.mollie.models.operations.*;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws UpdateProfileResponseBody, UpdateProfileProfilesResponseBody, UpdateProfileProfilesResponseResponseBody, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        UpdateProfileResponse res = sdk.profiles().update()
                .id("pfl_QkEhN94Ba")
                .requestBody(UpdateProfileRequestBody.builder()
                    .name("My new website name")
                    .website("https://example.com")
                    .email("test@mollie.com")
                    .phone("+31208202071")
                    .description("My website description")
                    .countriesOfActivity(List.of(
                        "NL",
                        "GB"))
                    .businessCategory("OTHER_MERCHANDISE")
                    .mode(Mode.LIVE)
                    .build())
                .call();

        if (res.object().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                       | Type                                                                            | Required                                                                        | Description                                                                     | Example                                                                         |
| ------------------------------------------------------------------------------- | ------------------------------------------------------------------------------- | ------------------------------------------------------------------------------- | ------------------------------------------------------------------------------- | ------------------------------------------------------------------------------- |
| `id`                                                                            | *String*                                                                        | :heavy_check_mark:                                                              | Provide the ID of the item you want to perform this operation on.               | pfl_QkEhN94Ba                                                                   |
| `requestBody`                                                                   | [UpdateProfileRequestBody](../../models/operations/UpdateProfileRequestBody.md) | :heavy_check_mark:                                                              | N/A                                                                             |                                                                                 |

### Response

**[UpdateProfileResponse](../../models/operations/UpdateProfileResponse.md)**

### Errors

| Error Type                                              | Status Code                                             | Content Type                                            |
| ------------------------------------------------------- | ------------------------------------------------------- | ------------------------------------------------------- |
| models/errors/UpdateProfileResponseBody                 | 404                                                     | application/hal+json                                    |
| models/errors/UpdateProfileProfilesResponseBody         | 410                                                     | application/hal+json                                    |
| models/errors/UpdateProfileProfilesResponseResponseBody | 422                                                     | application/hal+json                                    |
| models/errors/APIException                              | 4XX, 5XX                                                | \*/\*                                                   |

## delete

Delete a profile. A deleted profile and its related credentials can no longer be used for accepting payments.

### Example Usage

<!-- UsageSnippet language="java" operationID="delete-profile" method="delete" path="/profiles/{id}" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.DeleteProfileProfilesResponseBody;
import com.mollie.mollie.models.errors.DeleteProfileResponseBody;
import com.mollie.mollie.models.operations.DeleteProfileResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws DeleteProfileResponseBody, DeleteProfileProfilesResponseBody, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        DeleteProfileResponse res = sdk.profiles().delete()
                .id("pfl_QkEhN94Ba")
                .call();

        if (res.any().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                         | Type                                                              | Required                                                          | Description                                                       | Example                                                           |
| ----------------------------------------------------------------- | ----------------------------------------------------------------- | ----------------------------------------------------------------- | ----------------------------------------------------------------- | ----------------------------------------------------------------- |
| `id`                                                              | *String*                                                          | :heavy_check_mark:                                                | Provide the ID of the item you want to perform this operation on. | pfl_QkEhN94Ba                                                     |

### Response

**[DeleteProfileResponse](../../models/operations/DeleteProfileResponse.md)**

### Errors

| Error Type                                      | Status Code                                     | Content Type                                    |
| ----------------------------------------------- | ----------------------------------------------- | ----------------------------------------------- |
| models/errors/DeleteProfileResponseBody         | 404                                             | application/hal+json                            |
| models/errors/DeleteProfileProfilesResponseBody | 410                                             | application/hal+json                            |
| models/errors/APIException                      | 4XX, 5XX                                        | \*/\*                                           |

## getCurrent

Retrieve the currently authenticated profile. A convenient alias of the [Get profile](get-profile)
endpoint.

For a complete reference of the profile object, refer to the [Get profile](get-profile) endpoint
documentation.

### Example Usage

<!-- UsageSnippet language="java" operationID="get-current-profile" method="get" path="/profiles/me" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.operations.GetCurrentProfileResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        GetCurrentProfileResponse res = sdk.profiles().getCurrent()
                .call();

        if (res.object().isPresent()) {
            // handle response
        }
    }
}
```

### Response

**[GetCurrentProfileResponse](../../models/operations/GetCurrentProfileResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |