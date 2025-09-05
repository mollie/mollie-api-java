# Onboarding
(*onboarding()*)

## Overview

### Available Operations

* [get](#get) - Get onboarding status
* [submit](#submit) - Submit onboarding data

## get

Retrieve the onboarding status of the currently authenticated organization.

### Example Usage

<!-- UsageSnippet language="java" operationID="get-onboarding-status" method="get" path="/onboarding/me" -->
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
                .call();

        if (res.entityOnboardingStatus().isPresent()) {
            // handle response
        }
    }
}
```

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

        SubmitOnboardingDataRequestBody req = SubmitOnboardingDataRequestBody.builder()
                .organization(Organization.builder()
                    .name("Mollie B.V.")
                    .registrationNumber("30204462")
                    .vatNumber("NL815839091B01")
                    .vatRegulation(VatRegulation.DUTCH)
                    .build())
                .profile(Profile.builder()
                    .name("Mollie")
                    .url("https://www.mollie.com")
                    .email("info@mollie.com")
                    .phone("+31208202070")
                    .description("Payment service provider")
                    .businessCategory("MONEY_SERVICES")
                    .build())
                .build();

        SubmitOnboardingDataResponse res = sdk.onboarding().submit()
                .request(req)
                .call();

        if (res.any().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                     | Type                                                                                          | Required                                                                                      | Description                                                                                   |
| --------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------- |
| `request`                                                                                     | [SubmitOnboardingDataRequestBody](../../models/operations/SubmitOnboardingDataRequestBody.md) | :heavy_check_mark:                                                                            | The request object to use for the request.                                                    |

### Response

**[SubmitOnboardingDataResponse](../../models/operations/SubmitOnboardingDataResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |