# VerifyPayees

## Overview

### Available Operations

* [create](#create) - Verify Payee

## create

> 🚧 Beta feature
>
> This feature is currently in beta testing, and the final specification may still change.

Perform a Verification of Payee (VoP) check. This allows you to verify the account holder name against the
records held by the receiving bank before initiating a transfer.

The verification result indicates whether the provided name matches, closely matches, or does not match the
name on file at the receiving bank. This helps prevent misdirected payments.

### Simulating verification scenarios in test mode

In test mode, you can simulate various verification outcomes by adjusting the creditor name in the
`creditorBankAccount.accountHolderName` property. This allows you to test all possible Verification of Payee
results without needing special properties. The names are case insensitive.

| Account holder name                    | Scenario                                      | Verification result | Suggested name |
|----------------------------------------|-----------------------------------------------|---------------------|----------------|
| `John Close Match`                     | Name closely matches the bank records          | `close-match`       | `John Match`   |
| `John No Match`                        | Name does not match the bank records           | `no-match`          | —              |
| `John Unavailable`                     | Verification is not available                  | `not-available`     | —              |
| Any other name                         | Default: name matches the bank records         | `match`             | —              |

### Example Usage: verify-payee-200-close-match

<!-- UsageSnippet language="java" operationID="verify-payee" method="post" path="/business-accounts/payee-verifications" example="verify-payee-200-close-match" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.*;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.VerifyPayeeResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .organizationAccessToken(System.getenv().getOrDefault("ORGANIZATION_ACCESS_TOKEN", ""))
                    .build())
            .build();

        VerifyPayeeResponse res = sdk.verifyPayees().create()
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .verificationOfPayeeRequest(VerificationOfPayeeRequest.builder()
                    .creditorBankAccount(CreditorBankAccount.builder()
                        .accountHolderName("Jan Jansen")
                        .format(AccountNumberFormat.IBAN)
                        .accountNumber("NL02ABNA0123456789")
                        .build())
                    .testmode(false)
                    .build())
                .call();

        if (res.verificationOfPayeeResponse().isPresent()) {
            System.out.println(res.verificationOfPayeeResponse().get());
        }
    }
}
```
### Example Usage: verify-payee-200-match

<!-- UsageSnippet language="java" operationID="verify-payee" method="post" path="/business-accounts/payee-verifications" example="verify-payee-200-match" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.*;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.VerifyPayeeResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .organizationAccessToken(System.getenv().getOrDefault("ORGANIZATION_ACCESS_TOKEN", ""))
                    .build())
            .build();

        VerifyPayeeResponse res = sdk.verifyPayees().create()
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .verificationOfPayeeRequest(VerificationOfPayeeRequest.builder()
                    .creditorBankAccount(CreditorBankAccount.builder()
                        .accountHolderName("Jan Jansen")
                        .format(AccountNumberFormat.IBAN)
                        .accountNumber("NL02ABNA0123456789")
                        .build())
                    .testmode(false)
                    .build())
                .call();

        if (res.verificationOfPayeeResponse().isPresent()) {
            System.out.println(res.verificationOfPayeeResponse().get());
        }
    }
}
```
### Example Usage: verify-payee-200-no-match

<!-- UsageSnippet language="java" operationID="verify-payee" method="post" path="/business-accounts/payee-verifications" example="verify-payee-200-no-match" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.*;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.VerifyPayeeResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .organizationAccessToken(System.getenv().getOrDefault("ORGANIZATION_ACCESS_TOKEN", ""))
                    .build())
            .build();

        VerifyPayeeResponse res = sdk.verifyPayees().create()
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .verificationOfPayeeRequest(VerificationOfPayeeRequest.builder()
                    .creditorBankAccount(CreditorBankAccount.builder()
                        .accountHolderName("Jan Jansen")
                        .format(AccountNumberFormat.IBAN)
                        .accountNumber("NL02ABNA0123456789")
                        .build())
                    .testmode(false)
                    .build())
                .call();

        if (res.verificationOfPayeeResponse().isPresent()) {
            System.out.println(res.verificationOfPayeeResponse().get());
        }
    }
}
```
### Example Usage: verify-payee-200-not-available

<!-- UsageSnippet language="java" operationID="verify-payee" method="post" path="/business-accounts/payee-verifications" example="verify-payee-200-not-available" -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.*;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.VerifyPayeeResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .organizationAccessToken(System.getenv().getOrDefault("ORGANIZATION_ACCESS_TOKEN", ""))
                    .build())
            .build();

        VerifyPayeeResponse res = sdk.verifyPayees().create()
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .verificationOfPayeeRequest(VerificationOfPayeeRequest.builder()
                    .creditorBankAccount(CreditorBankAccount.builder()
                        .accountHolderName("Jan Jansen")
                        .format(AccountNumberFormat.IBAN)
                        .accountNumber("NL02ABNA0123456789")
                        .build())
                    .testmode(false)
                    .build())
                .call();

        if (res.verificationOfPayeeResponse().isPresent()) {
            System.out.println(res.verificationOfPayeeResponse().get());
        }
    }
}
```

### Parameters

| Parameter                                                                                      | Type                                                                                           | Required                                                                                       | Description                                                                                    | Example                                                                                        |
| ---------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------- |
| `idempotencyKey`                                                                               | *Optional\<String>*                                                                            | :heavy_minus_sign:                                                                             | A unique key to ensure idempotent requests. This key should be a UUID v4 string.               | 123e4567-e89b-12d3-a456-426                                                                    |
| `verificationOfPayeeRequest`                                                                   | [Optional\<VerificationOfPayeeRequest>](../../models/components/VerificationOfPayeeRequest.md) | :heavy_minus_sign:                                                                             | N/A                                                                                            |                                                                                                |

### Response

**[VerifyPayeeResponse](../../models/operations/VerifyPayeeResponse.md)**

### Errors

| Error Type                  | Status Code                 | Content Type                |
| --------------------------- | --------------------------- | --------------------------- |
| models/errors/ErrorResponse | 422, 429                    | application/hal+json        |
| models/errors/ErrorResponse | 503                         | application/hal+json        |
| models/errors/APIException  | 4XX, 5XX                    | \*/\*                       |