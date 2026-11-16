# Profiles

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

### Example Usage: create-profile-201-1

<!-- UsageSnippet language="java" operationID="create-profile" method="post" path="/v2/profiles" example="create-profile-201-1" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.ProfileRequest;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.CreateProfileResponse;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .advancedAccessToken(System.getenv().getOrDefault("ADVANCED_ACCESS_TOKEN", ""))
                    .build())
            .build();

        CreateProfileResponse res = sdk.profiles().create()
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .xClientSignature("MEUCIQDx8sJvK3z...")
                .xClientSignedAt("2025-01-01T12:00:00Z")
                .profileRequest(ProfileRequest.builder()
                    .name("My website name")
                    .website("https://example.com")
                    .email("test@mollie.com")
                    .phone("+31208202070")
                    .description("My website description")
                    .countriesOfActivity(List.of(
                        "NL",
                        "GB"))
                    .businessCategory("OTHER_MERCHANDISE")
                    .build())
                .call();

        if (res.profileResponse().isPresent()) {
            System.out.println(res.profileResponse().get());
        }
    }
}
```
### Example Usage: create-profile-201-2

<!-- UsageSnippet language="java" operationID="create-profile" method="post" path="/v2/profiles" example="create-profile-201-2" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.ProfileRequest;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.CreateProfileResponse;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .advancedAccessToken(System.getenv().getOrDefault("ADVANCED_ACCESS_TOKEN", ""))
                    .build())
            .build();

        CreateProfileResponse res = sdk.profiles().create()
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .xClientSignature("MEUCIQDx8sJvK3z...")
                .xClientSignedAt("2025-01-01T12:00:00Z")
                .profileRequest(ProfileRequest.builder()
                    .name("My website name")
                    .website("https://example.com")
                    .email("test@mollie.com")
                    .phone("+31208202070")
                    .description("My website description")
                    .countriesOfActivity(List.of(
                        "NL",
                        "GB"))
                    .businessCategory("OTHER_MERCHANDISE")
                    .build())
                .call();

        if (res.profileResponse().isPresent()) {
            System.out.println(res.profileResponse().get());
        }
    }
}
```

### Parameters

| Parameter                                                                                                                                                                               | Type                                                                                                                                                                                    | Required                                                                                                                                                                                | Description                                                                                                                                                                             | Example                                                                                                                                                                                 |
| --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `idempotencyKey`                                                                                                                                                                        | *Optional\<String>*                                                                                                                                                                     | :heavy_minus_sign:                                                                                                                                                                      | A unique key to ensure idempotent requests. This key should be a UUID v4 string.                                                                                                        | 123e4567-e89b-12d3-a456-426                                                                                                                                                             |
| `xClientSignature`                                                                                                                                                                      | *Optional\<String>*                                                                                                                                                                     | :heavy_minus_sign:                                                                                                                                                                      | A cryptographic signature of the request, used to verify that it was sent by you and hasn't been tampered with. Required if you've enabled request signing for your integration.        | MEUCIQDx8sJvK3z...                                                                                                                                                                      |
| `xClientSignedAt`                                                                                                                                                                       | *Optional\<String>*                                                                                                                                                                     | :heavy_minus_sign:                                                                                                                                                                      | The timestamp, in ISO 8601 format, at which you generated the `X-Client-Signature`. Required together with `X-Client-Signature` if you've enabled request signing for your integration. | 2025-01-01T12:00:00Z                                                                                                                                                                    |
| `profileRequest`                                                                                                                                                                        | [ProfileRequest](../../models/components/ProfileRequest.md)                                                                                                                             | :heavy_check_mark:                                                                                                                                                                      | N/A                                                                                                                                                                                     |                                                                                                                                                                                         |

### Response

**[CreateProfileResponse](../../models/operations/CreateProfileResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 403, 422, 429               | application/hal+json        |
| models/errors/APIException  | 4XX, 5XX                    | \*/\*                       |

## list

Retrieve a list of all of your profiles.

The results are paginated.

### Example Usage

<!-- UsageSnippet language="java" operationID="list-profiles" method="get" path="/v2/profiles" example="list-profiles-200-1" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.ListProfilesRequest;
import com.mollie.mollie.models.operations.ListProfilesResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .advancedAccessToken(System.getenv().getOrDefault("ADVANCED_ACCESS_TOKEN", ""))
                    .build())
            .build();

        ListProfilesRequest req = ListProfilesRequest.builder()
                .from("pfl_QkEhN94Ba")
                .limit(50L)
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .xClientSignature("MEUCIQDx8sJvK3z...")
                .xClientSignedAt("2025-01-01T12:00:00Z")
                .build();


        sdk.profiles().list()
                .callAsStream()
                .forEach((ListProfilesResponse item) -> {
                   // handle page
                });

    }
}
```

### Parameters

| Parameter                                                             | Type                                                                  | Required                                                              | Description                                                           |
| --------------------------------------------------------------------- | --------------------------------------------------------------------- | --------------------------------------------------------------------- | --------------------------------------------------------------------- |
| `request`                                                             | [ListProfilesRequest](../../models/operations/ListProfilesRequest.md) | :heavy_check_mark:                                                    | The request object to use for the request.                            |

### Response

**[ListProfilesResponse](../../models/operations/ListProfilesResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 400, 429                    | application/hal+json        |
| models/errors/APIException  | 4XX, 5XX                    | \*/\*                       |

## get

Retrieve a single profile by its ID.

### Example Usage

<!-- UsageSnippet language="java" operationID="get-profile" method="get" path="/v2/profiles/{profileId}" example="get-profile-200-1" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.GetProfileRequest;
import com.mollie.mollie.models.operations.GetProfileResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .testmode(false)
                .security(Security.builder()
                    .advancedAccessToken(System.getenv().getOrDefault("ADVANCED_ACCESS_TOKEN", ""))
                    .build())
            .build();

        GetProfileRequest req = GetProfileRequest.builder()
                .profileId("pfl_5B8cwPMGnU")
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .xClientSignature("MEUCIQDx8sJvK3z...")
                .xClientSignedAt("2025-01-01T12:00:00Z")
                .build();

        GetProfileResponse res = sdk.profiles().get()
                .request(req)
                .call();

        if (res.profileResponse().isPresent()) {
            System.out.println(res.profileResponse().get());
        }
    }
}
```

### Parameters

| Parameter                                                         | Type                                                              | Required                                                          | Description                                                       |
| ----------------------------------------------------------------- | ----------------------------------------------------------------- | ----------------------------------------------------------------- | ----------------------------------------------------------------- |
| `request`                                                         | [GetProfileRequest](../../models/operations/GetProfileRequest.md) | :heavy_check_mark:                                                | The request object to use for the request.                        |

### Response

**[GetProfileResponse](../../models/operations/GetProfileResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 404, 410, 429               | application/hal+json        |
| models/errors/APIException  | 4XX, 5XX                    | \*/\*                       |

## update

Update an existing profile.

Profiles are required for payment processing. Normally they are created and updated via the Mollie dashboard.
Alternatively, you can use this endpoint to automate profile management.

### Example Usage: update-profile-200-1

<!-- UsageSnippet language="java" operationID="update-profile" method="patch" path="/v2/profiles/{profileId}" example="update-profile-200-1" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.*;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .advancedAccessToken(System.getenv().getOrDefault("ADVANCED_ACCESS_TOKEN", ""))
                    .build())
            .build();

        UpdateProfileRequest req = UpdateProfileRequest.builder()
                .profileId("pfl_5B8cwPMGnU")
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
                    .build())
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .xClientSignature("MEUCIQDx8sJvK3z...")
                .xClientSignedAt("2025-01-01T12:00:00Z")
                .build();

        UpdateProfileResponse res = sdk.profiles().update()
                .request(req)
                .call();

        if (res.profileResponse().isPresent()) {
            System.out.println(res.profileResponse().get());
        }
    }
}
```
### Example Usage: update-profile-200-2

<!-- UsageSnippet language="java" operationID="update-profile" method="patch" path="/v2/profiles/{profileId}" example="update-profile-200-2" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.*;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .advancedAccessToken(System.getenv().getOrDefault("ADVANCED_ACCESS_TOKEN", ""))
                    .build())
            .build();

        UpdateProfileRequest req = UpdateProfileRequest.builder()
                .profileId("pfl_5B8cwPMGnU")
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
                    .build())
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .xClientSignature("MEUCIQDx8sJvK3z...")
                .xClientSignedAt("2025-01-01T12:00:00Z")
                .build();

        UpdateProfileResponse res = sdk.profiles().update()
                .request(req)
                .call();

        if (res.profileResponse().isPresent()) {
            System.out.println(res.profileResponse().get());
        }
    }
}
```

### Parameters

| Parameter                                                               | Type                                                                    | Required                                                                | Description                                                             |
| ----------------------------------------------------------------------- | ----------------------------------------------------------------------- | ----------------------------------------------------------------------- | ----------------------------------------------------------------------- |
| `request`                                                               | [UpdateProfileRequest](../../models/operations/UpdateProfileRequest.md) | :heavy_check_mark:                                                      | The request object to use for the request.                              |

### Response

**[UpdateProfileResponse](../../models/operations/UpdateProfileResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 403, 404, 410, 422, 429     | application/hal+json        |
| models/errors/APIException  | 4XX, 5XX                    | \*/\*                       |

## delete

Delete a profile. A deleted profile and its related credentials can no longer be used for accepting payments.

### Example Usage

<!-- UsageSnippet language="java" operationID="delete-profile" method="delete" path="/v2/profiles/{profileId}" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.DeleteProfileResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .advancedAccessToken(System.getenv().getOrDefault("ADVANCED_ACCESS_TOKEN", ""))
                    .build())
            .build();

        DeleteProfileResponse res = sdk.profiles().delete()
                .profileId("pfl_5B8cwPMGnU")
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .xClientSignature("MEUCIQDx8sJvK3z...")
                .xClientSignedAt("2025-01-01T12:00:00Z")
                .call();

        // handle response
    }
}
```

### Parameters

| Parameter                                                                                                                                                                               | Type                                                                                                                                                                                    | Required                                                                                                                                                                                | Description                                                                                                                                                                             | Example                                                                                                                                                                                 |
| --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `profileId`                                                                                                                                                                             | *String*                                                                                                                                                                                | :heavy_check_mark:                                                                                                                                                                      | Provide the ID of the related profile.                                                                                                                                                  | pfl_5B8cwPMGnU                                                                                                                                                                          |
| `idempotencyKey`                                                                                                                                                                        | *Optional\<String>*                                                                                                                                                                     | :heavy_minus_sign:                                                                                                                                                                      | A unique key to ensure idempotent requests. This key should be a UUID v4 string.                                                                                                        | 123e4567-e89b-12d3-a456-426                                                                                                                                                             |
| `xClientSignature`                                                                                                                                                                      | *Optional\<String>*                                                                                                                                                                     | :heavy_minus_sign:                                                                                                                                                                      | A cryptographic signature of the request, used to verify that it was sent by you and hasn't been tampered with. Required if you've enabled request signing for your integration.        | MEUCIQDx8sJvK3z...                                                                                                                                                                      |
| `xClientSignedAt`                                                                                                                                                                       | *Optional\<String>*                                                                                                                                                                     | :heavy_minus_sign:                                                                                                                                                                      | The timestamp, in ISO 8601 format, at which you generated the `X-Client-Signature`. Required together with `X-Client-Signature` if you've enabled request signing for your integration. | 2025-01-01T12:00:00Z                                                                                                                                                                    |

### Response

**[DeleteProfileResponse](../../models/operations/DeleteProfileResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 404, 410, 429               | application/hal+json        |
| models/errors/APIException  | 4XX, 5XX                    | \*/\*                       |

## getCurrent

Retrieve the currently authenticated profile. A convenient alias of the [Get profile](get-profile)
endpoint.

For a complete reference of the profile object, refer to the [Get profile](get-profile) endpoint
documentation.

### Example Usage

<!-- UsageSnippet language="java" operationID="get-current-profile" method="get" path="/v2/profiles/me" example="get-current-profile-200-1" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.GetCurrentProfileResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        GetCurrentProfileResponse res = sdk.profiles().getCurrent()
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .xClientSignature("MEUCIQDx8sJvK3z...")
                .xClientSignedAt("2025-01-01T12:00:00Z")
                .call();

        if (res.profileResponse().isPresent()) {
            System.out.println(res.profileResponse().get());
        }
    }
}
```

### Parameters

| Parameter                                                                                                                                                                               | Type                                                                                                                                                                                    | Required                                                                                                                                                                                | Description                                                                                                                                                                             | Example                                                                                                                                                                                 |
| --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `idempotencyKey`                                                                                                                                                                        | *Optional\<String>*                                                                                                                                                                     | :heavy_minus_sign:                                                                                                                                                                      | A unique key to ensure idempotent requests. This key should be a UUID v4 string.                                                                                                        | 123e4567-e89b-12d3-a456-426                                                                                                                                                             |
| `xClientSignature`                                                                                                                                                                      | *Optional\<String>*                                                                                                                                                                     | :heavy_minus_sign:                                                                                                                                                                      | A cryptographic signature of the request, used to verify that it was sent by you and hasn't been tampered with. Required if you've enabled request signing for your integration.        | MEUCIQDx8sJvK3z...                                                                                                                                                                      |
| `xClientSignedAt`                                                                                                                                                                       | *Optional\<String>*                                                                                                                                                                     | :heavy_minus_sign:                                                                                                                                                                      | The timestamp, in ISO 8601 format, at which you generated the `X-Client-Signature`. Required together with `X-Client-Signature` if you've enabled request signing for your integration. | 2025-01-01T12:00:00Z                                                                                                                                                                    |

### Response

**[GetCurrentProfileResponse](../../models/operations/GetCurrentProfileResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 429                         | application/hal+json        |
| models/errors/APIException  | 4XX, 5XX                    | \*/\*                       |