# OnboardingAPI
(*onboardingAPI()*)

## Overview

### Available Operations

* [get](#get) - Get onboarding status
* [create](#create) - Submit onboarding data

## get

Retrieve the onboarding status of the currently authenticated organization.

### Example Usage

```java
package hello.world;

import com.mollie.mollie.Mollie;
import com.mollie.mollie.models.operations.GetOnboardingStatusResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Mollie sdk = Mollie.builder()
                .oAuth("<YOUR_O_AUTH_HERE>")
            .build();

        GetOnboardingStatusResponse res = sdk.onboardingAPI().get()
                .call();

        if (res.object().isPresent()) {
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

## create

**⚠️ We no longer recommend implementing this endpoint. Please refer to the Client Links API instead to kick off the
onboarding process for your merchants.**

Submit data that will be prefilled in the merchant's onboarding. The data you submit will only be processed when the
onboarding status is `needs-data`. Information that the merchant has entered in their dashboard will not be

overwritten.

### Example Usage

```java
package hello.world;

import com.mollie.mollie.Mollie;
import com.mollie.mollie.models.operations.SubmitOnboardingDataRequestBody;
import com.mollie.mollie.models.operations.SubmitOnboardingDataResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Mollie sdk = Mollie.builder()
                .oAuth("<YOUR_O_AUTH_HERE>")
            .build();

        SubmitOnboardingDataRequestBody req = SubmitOnboardingDataRequestBody.builder()
                .build();

        SubmitOnboardingDataResponse res = sdk.onboardingAPI().create()
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