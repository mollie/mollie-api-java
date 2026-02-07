# Onboarding

## Overview

### Available Operations

* [get](#get) - Get onboarding status
* [submit](#submit) - Submit onboarding data

## get

Retrieve the onboarding status of the currently authenticated organization.

### Example Usage

<!-- UsageSnippet language="java" operationID="get-onboarding-status" method="get" path="/onboarding/me" example="get-onboarding-status-200-1" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.operations.GetOnboardingStatusResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        GetOnboardingStatusResponse res = sdk.onboarding().get()
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .call();

        if (res.entityOnboardingStatus().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                        | Type                                                                             | Required                                                                         | Description                                                                      | Example                                                                          |
| -------------------------------------------------------------------------------- | -------------------------------------------------------------------------------- | -------------------------------------------------------------------------------- | -------------------------------------------------------------------------------- | -------------------------------------------------------------------------------- |
| `idempotencyKey`                                                                 | *Optional\<String>*                                                              | :heavy_minus_sign:                                                               | A unique key to ensure idempotent requests. This key should be a UUID v4 string. | 123e4567-e89b-12d3-a456-426                                                      |

### Response

**[GetOnboardingStatusResponse](../../models/operations/GetOnboardingStatusResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## submit

**⚠️ We no longer recommend implementing this endpoint. Please refer to the Client Links API instead to kick off the
onboarding process for your merchants.**

Submit data that will be prefilled in the merchant's onboarding. The data you submit will only be processed when the
onboarding status is `needs-data`.  
Information that the merchant has entered in their dashboard will not be overwritten.

### Example Usage

<!-- UsageSnippet language="java" operationID="submit-onboarding-data" method="post" path="/onboarding/me" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.OnboardingVatRegulation;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.operations.*;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        SubmitOnboardingDataResponse res = sdk.onboarding().submit()
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .requestBody(SubmitOnboardingDataRequestBody.builder()
                    .organization(Organization.builder()
                        .name("Mollie B.V.")
                        .registrationNumber("30204462")
                        .vatNumber("NL815839091B01")
                        .vatRegulation(OnboardingVatRegulation.DUTCH)
                        .build())
                    .profile(Profile.builder()
                        .name("Mollie")
                        .url("https://www.mollie.com")
                        .email("info@mollie.com")
                        .phone("+31208202070")
                        .description("Payment service provider")
                        .businessCategory("MONEY_SERVICES")
                        .build())
                    .build())
                .call();

        // handle response
    }
}
```

### Parameters

| Parameter                                                                                                | Type                                                                                                     | Required                                                                                                 | Description                                                                                              | Example                                                                                                  |
| -------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------- |
| `idempotencyKey`                                                                                         | *Optional\<String>*                                                                                      | :heavy_minus_sign:                                                                                       | A unique key to ensure idempotent requests. This key should be a UUID v4 string.                         | 123e4567-e89b-12d3-a456-426                                                                              |
| `requestBody`                                                                                            | [Optional\<SubmitOnboardingDataRequestBody>](../../models/operations/SubmitOnboardingDataRequestBody.md) | :heavy_minus_sign:                                                                                       | N/A                                                                                                      |                                                                                                          |

### Response

**[SubmitOnboardingDataResponse](../../models/operations/SubmitOnboardingDataResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |