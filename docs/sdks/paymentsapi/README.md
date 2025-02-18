# PaymentsAPI
(*paymentsAPI()*)

## Overview

### Available Operations

* [createPayment](#createpayment) - Create payment
* [listPayments](#listpayments) - List payments
* [getPayment](#getpayment) - Get payment
* [updatePayment](#updatepayment) - Update payment
* [cancelPayment](#cancelpayment) - Cancel payment
* [releaseAuthorization](#releaseauthorization) - Release payment authorization

## createPayment

Payment creation is elemental to the Mollie API: this is where most payment implementations start off.

Once you have created a payment, you should redirect your customer to the URL in the `_links.checkout` property from the response.

To wrap your head around the payment process, an explanation and flow charts can be found in the 'Accepting payments' guide.

If you specify the `method` parameter when creating a payment, optional additional parameters may be available for the payment method that are not listed below. Please refer to the guide on [method-specific parameters](extra-payment-parameters).

> 🔑 Access with
>
> [API key](/reference/authentication)
>
> [Access token with **payments.write**](/reference/authentication)

### Example Usage

```java
package hello.world;

import com.mollie.mollie.Mollie;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.CreatePaymentPaymentsAPIResponseBody;
import com.mollie.mollie.models.errors.CreatePaymentResponseBody;
import com.mollie.mollie.models.operations.ApplicationFee;
import com.mollie.mollie.models.operations.CreatePaymentAmount;
import com.mollie.mollie.models.operations.CreatePaymentDiscountAmount;
import com.mollie.mollie.models.operations.CreatePaymentLines;
import com.mollie.mollie.models.operations.CreatePaymentPaymentsAPIAmount;
import com.mollie.mollie.models.operations.CreatePaymentPaymentsAPIRequestAmount;
import com.mollie.mollie.models.operations.CreatePaymentPaymentsAPIRequestRequestBodyAmount;
import com.mollie.mollie.models.operations.CreatePaymentRequestBody;
import com.mollie.mollie.models.operations.CreatePaymentResponse;
import com.mollie.mollie.models.operations.CreatePaymentTotalAmount;
import com.mollie.mollie.models.operations.CreatePaymentUnitPrice;
import com.mollie.mollie.models.operations.CreatePaymentVatAmount;
import com.mollie.mollie.models.operations.Destination;
import com.mollie.mollie.models.operations.Recurring;
import com.mollie.mollie.models.operations.Routing;
import java.lang.Exception;
import java.util.List;

public class Application {

    public static void main(String[] args) throws CreatePaymentResponseBody, CreatePaymentPaymentsAPIResponseBody, Exception {

        Mollie sdk = Mollie.builder()
                .security(Security.builder()
                    .apiKey("<YOUR_BEARER_TOKEN_HERE>")
                    .build())
            .build();

        CreatePaymentResponse res = sdk.paymentsAPI().createPayment()
                .include("details.qrCode")
                .requestBody(CreatePaymentRequestBody.builder()
                    .description("yuck vice between gee ugh ha")
                    .amount(CreatePaymentAmount.builder()
                        .currency("EUR")
                        .value("10.00")
                        .build())
                    .redirectUrl("https://sparse-rim.biz")
                    .lines(List.of(
                        CreatePaymentLines.builder()
                            .description("attend alongside aw blend ha ew")
                            .quantity(497070L)
                            .unitPrice(CreatePaymentUnitPrice.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .totalAmount(CreatePaymentTotalAmount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .type("physical")
                            .discountAmount(CreatePaymentDiscountAmount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .recurring(Recurring.builder()
                                .interval("... weeks")
                                .amount(CreatePaymentPaymentsAPIAmount.builder()
                                    .currency("EUR")
                                    .value("10.00")
                                    .build())
                                .build())
                            .vatAmount(CreatePaymentVatAmount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .categories(List.of(
                                "meal",
                                "eco"))
                            .build(),
                        CreatePaymentLines.builder()
                            .description("stealthily without trick yahoo until planula conceal")
                            .quantity(721880L)
                            .unitPrice(CreatePaymentUnitPrice.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .totalAmount(CreatePaymentTotalAmount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .type("physical")
                            .discountAmount(CreatePaymentDiscountAmount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .recurring(Recurring.builder()
                                .interval("... days")
                                .amount(CreatePaymentPaymentsAPIAmount.builder()
                                    .currency("EUR")
                                    .value("10.00")
                                    .build())
                                .build())
                            .vatAmount(CreatePaymentVatAmount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .categories(List.of(
                                "meal",
                                "eco"))
                            .build()))
                    .captureMode("automatic")
                    .applicationFee(ApplicationFee.builder()
                        .amount(CreatePaymentPaymentsAPIRequestAmount.builder()
                            .currency("EUR")
                            .value("10.00")
                            .build())
                        .build())
                    .routing(List.of(
                        Routing.builder()
                            .amount(CreatePaymentPaymentsAPIRequestRequestBodyAmount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .destination(Destination.builder()
                                .organizationId("org_12345678")
                                .build())
                            .build(),
                        Routing.builder()
                            .amount(CreatePaymentPaymentsAPIRequestRequestBodyAmount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .destination(Destination.builder()
                                .organizationId("org_12345678")
                                .build())
                            .build(),
                        Routing.builder()
                            .amount(CreatePaymentPaymentsAPIRequestRequestBodyAmount.builder()
                                .currency("EUR")
                                .value("10.00")
                                .build())
                            .destination(Destination.builder()
                                .organizationId("org_12345678")
                                .build())
                            .build()))
                    .sequenceType("oneoff")
                    .mandateId("mdt_pWUnw6pkBN")
                    .customerId("cst_8wmqcHMN4U")
                    .profileId("pfl_QkEhN94Ba")
                    .build())
                .call();

        // handle response
    }
}
```

### Parameters

| Parameter                                                                                                                                                                                                            | Type                                                                                                                                                                                                                 | Required                                                                                                                                                                                                             | Description                                                                                                                                                                                                          | Example                                                                                                                                                                                                              |
| -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `include`                                                                                                                                                                                                            | *JsonNullable\<String>*                                                                                                                                                                                              | :heavy_minus_sign:                                                                                                                                                                                                   | This endpoint allows you to include additional information via the `include` query string parameter.<br/><br/>* `details.qrCode`: Include a QR code object. Only available for iDEAL, Bancontact and bank transfer payments. | details.qrCode                                                                                                                                                                                                       |
| `requestBody`                                                                                                                                                                                                        | [Optional\<CreatePaymentRequestBody>](../../models/operations/CreatePaymentRequestBody.md)                                                                                                                           | :heavy_minus_sign:                                                                                                                                                                                                   | N/A                                                                                                                                                                                                                  |                                                                                                                                                                                                                      |

### Response

**[CreatePaymentResponse](../../models/operations/CreatePaymentResponse.md)**

### Errors

| Error Type                                         | Status Code                                        | Content Type                                       |
| -------------------------------------------------- | -------------------------------------------------- | -------------------------------------------------- |
| models/errors/CreatePaymentResponseBody            | 422                                                | application/hal+json                               |
| models/errors/CreatePaymentPaymentsAPIResponseBody | 503                                                | application/hal+json                               |
| models/errors/APIException                         | 4XX, 5XX                                           | \*/\*                                              |

## listPayments

Retrieve all payments created with the current website profile.

The results are paginated.

> 🔑 Access with
>
> [API key](/reference/authentication)
>
> [Access token with **payments.read**](/reference/authentication)

### Example Usage

```java
package hello.world;

import com.mollie.mollie.Mollie;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.ListPaymentsResponseBody;
import com.mollie.mollie.models.operations.ListPaymentsResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ListPaymentsResponseBody, Exception {

        Mollie sdk = Mollie.builder()
                .security(Security.builder()
                    .apiKey("<YOUR_BEARER_TOKEN_HERE>")
                    .build())
            .build();

        ListPaymentsResponse res = sdk.paymentsAPI().listPayments()
                .from("tr_5B8cwPMGnU6qLbRvo7qEZo")
                .limit(50L)
                .sort("desc")
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
| `from`                                                                                                                                                                                                                                                                                                                                                                                 | *Optional\<String>*                                                                                                                                                                                                                                                                                                                                                                    | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                     | Provide an ID to start the result set from the item with the given ID and onwards. This allows you to paginate the result set.                                                                                                                                                                                                                                                         | tr_5B8cwPMGnU6qLbRvo7qEZo                                                                                                                                                                                                                                                                                                                                                              |
| `limit`                                                                                                                                                                                                                                                                                                                                                                                | *JsonNullable\<Long>*                                                                                                                                                                                                                                                                                                                                                                  | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                     | The maximum number of items to return. Defaults to 50 items.                                                                                                                                                                                                                                                                                                                           | 50                                                                                                                                                                                                                                                                                                                                                                                     |
| `sort`                                                                                                                                                                                                                                                                                                                                                                                 | *JsonNullable\<String>*                                                                                                                                                                                                                                                                                                                                                                | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                     | Used for setting the direction of the result set. Defaults to descending order, meaning the results are ordered from newest to oldest.<br/><br/>Possible values: `asc` `desc` (default: `desc`)                                                                                                                                                                                        | desc                                                                                                                                                                                                                                                                                                                                                                                   |
| `testmode`                                                                                                                                                                                                                                                                                                                                                                             | *JsonNullable\<Boolean>*                                                                                                                                                                                                                                                                                                                                                               | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                     | Most API credentials are specifically created for either live mode or test mode. In those cases the `testmode` query parameter can be omitted. For organization-level credentials such as OAuth access tokens, you can enable test mode by setting the `testmode` query parameter to `true`.<br/><br/>Test entities cannot be retrieved when the endpoint is set to live mode, and vice versa. | false                                                                                                                                                                                                                                                                                                                                                                                  |

### Response

**[ListPaymentsResponse](../../models/operations/ListPaymentsResponse.md)**

### Errors

| Error Type                             | Status Code                            | Content Type                           |
| -------------------------------------- | -------------------------------------- | -------------------------------------- |
| models/errors/ListPaymentsResponseBody | 400                                    | application/hal+json                   |
| models/errors/APIException             | 4XX, 5XX                               | \*/\*                                  |

## getPayment

Retrieve a single payment object by its payment ID.

> 🔑 Access with
>
> [API key](/reference/authentication)
>
> [Access token with **payments.read**](/reference/authentication)

### Example Usage

```java
package hello.world;

import com.mollie.mollie.Mollie;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.GetPaymentResponseBody;
import com.mollie.mollie.models.operations.GetPaymentResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws GetPaymentResponseBody, Exception {

        Mollie sdk = Mollie.builder()
                .security(Security.builder()
                    .apiKey("<YOUR_BEARER_TOKEN_HERE>")
                    .build())
            .build();

        GetPaymentResponse res = sdk.paymentsAPI().getPayment()
                .paymentId("tr_5B8cwPMGnU6qLbRvo7qEZo")
                .include("details.qrCode")
                .embed("captures")
                .testmode(false)
                .call();

        if (res.object().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                                                                                                                                                                                                                                                                                                                                                                       | Type                                                                                                                                                                                                                                                                                                                                                                                                                                                            | Required                                                                                                                                                                                                                                                                                                                                                                                                                                                        | Description                                                                                                                                                                                                                                                                                                                                                                                                                                                     | Example                                                                                                                                                                                                                                                                                                                                                                                                                                                         |
| --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `paymentId`                                                                                                                                                                                                                                                                                                                                                                                                                                                     | *String*                                                                                                                                                                                                                                                                                                                                                                                                                                                        | :heavy_check_mark:                                                                                                                                                                                                                                                                                                                                                                                                                                              | Provide the ID of the related payment.                                                                                                                                                                                                                                                                                                                                                                                                                          | tr_5B8cwPMGnU6qLbRvo7qEZo                                                                                                                                                                                                                                                                                                                                                                                                                                       |
| `include`                                                                                                                                                                                                                                                                                                                                                                                                                                                       | *JsonNullable\<String>*                                                                                                                                                                                                                                                                                                                                                                                                                                         | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                                                                                              | This endpoint allows you to include additional information via the `include` query string parameter.<br/><br/>* `details.qrCode`: Include a QR code object. Only available for iDEAL, Bancontact and bank transfer payments.<br/>* `details.remainderDetails`: For payments where gift cards or vouchers were applied and the remaining amount was paid with another payment method, this include will add another `details` object specifically for the remainder payment. | details.qrCode                                                                                                                                                                                                                                                                                                                                                                                                                                                  |
| `embed`                                                                                                                                                                                                                                                                                                                                                                                                                                                         | *JsonNullable\<String>*                                                                                                                                                                                                                                                                                                                                                                                                                                         | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                                                                                              | This endpoint allows embedding related API items by appending the following values via the `embed` query string parameter.<br/><br/>* `captures`: Embed all captures created for this payment.<br/>* `refunds`: Embed all refunds created for this payment.<br/>* `chargebacks`: Embed all chargebacks created for this payment.                                                                                                                                | captures                                                                                                                                                                                                                                                                                                                                                                                                                                                        |
| `testmode`                                                                                                                                                                                                                                                                                                                                                                                                                                                      | *JsonNullable\<Boolean>*                                                                                                                                                                                                                                                                                                                                                                                                                                        | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                                                                                              | Most API credentials are specifically created for either live mode or test mode. In those cases the `testmode` query parameter can be omitted. For organization-level credentials such as OAuth access tokens, you can enable test mode by setting the `testmode` query parameter to `true`.<br/><br/>Test entities cannot be retrieved when the endpoint is set to live mode, and vice versa.                                                                  | false                                                                                                                                                                                                                                                                                                                                                                                                                                                           |

### Response

**[GetPaymentResponse](../../models/operations/GetPaymentResponse.md)**

### Errors

| Error Type                           | Status Code                          | Content Type                         |
| ------------------------------------ | ------------------------------------ | ------------------------------------ |
| models/errors/GetPaymentResponseBody | 404                                  | application/hal+json                 |
| models/errors/APIException           | 4XX, 5XX                             | \*/\*                                |

## updatePayment

Certain details of an existing payment can be updated. For an in-depth explanation of each parameter, see [Create payment](create-payment).

Updating the payment details will not result in a webhook call.

> 🔑 Access with
>
> [API key](/reference/authentication)
>
> [Access token with **payments.write**](/reference/authentication)

### Example Usage

```java
package hello.world;

import com.mollie.mollie.Mollie;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.UpdatePaymentPaymentsAPIResponseBody;
import com.mollie.mollie.models.errors.UpdatePaymentResponseBody;
import com.mollie.mollie.models.operations.UpdatePaymentRequestBody;
import com.mollie.mollie.models.operations.UpdatePaymentResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws UpdatePaymentResponseBody, UpdatePaymentPaymentsAPIResponseBody, Exception {

        Mollie sdk = Mollie.builder()
                .security(Security.builder()
                    .apiKey("<YOUR_BEARER_TOKEN_HERE>")
                    .build())
            .build();

        UpdatePaymentResponse res = sdk.paymentsAPI().updatePayment()
                .paymentId("tr_5B8cwPMGnU6qLbRvo7qEZo")
                .requestBody(UpdatePaymentRequestBody.builder()
                    .build())
                .call();

        // handle response
    }
}
```

### Parameters

| Parameter                                                                                  | Type                                                                                       | Required                                                                                   | Description                                                                                | Example                                                                                    |
| ------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------ |
| `paymentId`                                                                                | *String*                                                                                   | :heavy_check_mark:                                                                         | Provide the ID of the related payment.                                                     | tr_5B8cwPMGnU6qLbRvo7qEZo                                                                  |
| `requestBody`                                                                              | [Optional\<UpdatePaymentRequestBody>](../../models/operations/UpdatePaymentRequestBody.md) | :heavy_minus_sign:                                                                         | N/A                                                                                        |                                                                                            |

### Response

**[UpdatePaymentResponse](../../models/operations/UpdatePaymentResponse.md)**

### Errors

| Error Type                                         | Status Code                                        | Content Type                                       |
| -------------------------------------------------- | -------------------------------------------------- | -------------------------------------------------- |
| models/errors/UpdatePaymentResponseBody            | 404                                                | application/hal+json                               |
| models/errors/UpdatePaymentPaymentsAPIResponseBody | 422                                                | application/hal+json                               |
| models/errors/APIException                         | 4XX, 5XX                                           | \*/\*                                              |

## cancelPayment

Depending on the payment method, you may be able to cancel a payment for a certain amount of time — usually until the next business day or as long as the payment status is open.

Payments may also be canceled manually from the Mollie Dashboard.

The `isCancelable` property on the [Payment object](get-payment) will indicate if the payment can be canceled.

> 🔑 Access with
>
> [API key](/reference/authentication)
>
> [Access token with **payments.write**](/reference/authentication)

### Example Usage

```java
package hello.world;

import com.mollie.mollie.Mollie;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.CancelPaymentPaymentsAPIResponseBody;
import com.mollie.mollie.models.errors.CancelPaymentResponseBody;
import com.mollie.mollie.models.operations.CancelPaymentResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws CancelPaymentResponseBody, CancelPaymentPaymentsAPIResponseBody, Exception {

        Mollie sdk = Mollie.builder()
                .security(Security.builder()
                    .apiKey("<YOUR_BEARER_TOKEN_HERE>")
                    .build())
            .build();

        CancelPaymentResponse res = sdk.paymentsAPI().cancelPayment()
                .paymentId("tr_5B8cwPMGnU6qLbRvo7qEZo")
                .testmode(false)
                .call();

        // handle response
    }
}
```

### Parameters

| Parameter                                                                                                                                                                                                                                                                                                                                                                              | Type                                                                                                                                                                                                                                                                                                                                                                                   | Required                                                                                                                                                                                                                                                                                                                                                                               | Description                                                                                                                                                                                                                                                                                                                                                                            | Example                                                                                                                                                                                                                                                                                                                                                                                |
| -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `paymentId`                                                                                                                                                                                                                                                                                                                                                                            | *String*                                                                                                                                                                                                                                                                                                                                                                               | :heavy_check_mark:                                                                                                                                                                                                                                                                                                                                                                     | Provide the ID of the related payment.                                                                                                                                                                                                                                                                                                                                                 | tr_5B8cwPMGnU6qLbRvo7qEZo                                                                                                                                                                                                                                                                                                                                                              |
| `testmode`                                                                                                                                                                                                                                                                                                                                                                             | *JsonNullable\<Boolean>*                                                                                                                                                                                                                                                                                                                                                               | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                     | Most API credentials are specifically created for either live mode or test mode. In those cases the `testmode` query parameter can be omitted. For organization-level credentials such as OAuth access tokens, you can enable test mode by setting the `testmode` query parameter to `true`.<br/><br/>Test entities cannot be retrieved when the endpoint is set to live mode, and vice versa. | false                                                                                                                                                                                                                                                                                                                                                                                  |

### Response

**[CancelPaymentResponse](../../models/operations/CancelPaymentResponse.md)**

### Errors

| Error Type                                         | Status Code                                        | Content Type                                       |
| -------------------------------------------------- | -------------------------------------------------- | -------------------------------------------------- |
| models/errors/CancelPaymentResponseBody            | 404                                                | application/hal+json                               |
| models/errors/CancelPaymentPaymentsAPIResponseBody | 422                                                | application/hal+json                               |
| models/errors/APIException                         | 4XX, 5XX                                           | \*/\*                                              |

## releaseAuthorization

Releases the full remaining authorized amount. Call this endpoint when you will not be making any additional captures. Payment authorizations may also be released manually from the Mollie Dashboard.

Mollie will do its best to process release requests, but it is not guaranteed that it will succeed. It is up to the issuing bank if and when the hold will be released.

If the request does succeed, the payment status will change to `canceled` for payments without captures. If there is a successful capture, the payment will transition to `paid`.

> 🔑 Access with
>
> [API key](/reference/authentication)
>
> [Access token with **payments.write**](/reference/authentication)

### Example Usage

```java
package hello.world;

import com.mollie.mollie.Mollie;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.ReleaseAuthorizationPaymentsAPIResponseBody;
import com.mollie.mollie.models.errors.ReleaseAuthorizationResponseBody;
import com.mollie.mollie.models.operations.ReleaseAuthorizationResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ReleaseAuthorizationResponseBody, ReleaseAuthorizationPaymentsAPIResponseBody, Exception {

        Mollie sdk = Mollie.builder()
                .security(Security.builder()
                    .apiKey("<YOUR_BEARER_TOKEN_HERE>")
                    .build())
            .build();

        ReleaseAuthorizationResponse res = sdk.paymentsAPI().releaseAuthorization()
                .paymentId("tr_5B8cwPMGnU6qLbRvo7qEZo")
                .testmode(false)
                .call();

        if (res.any().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                                                                                                                                                                                                                                                                                              | Type                                                                                                                                                                                                                                                                                                                                                                                   | Required                                                                                                                                                                                                                                                                                                                                                                               | Description                                                                                                                                                                                                                                                                                                                                                                            | Example                                                                                                                                                                                                                                                                                                                                                                                |
| -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `paymentId`                                                                                                                                                                                                                                                                                                                                                                            | *String*                                                                                                                                                                                                                                                                                                                                                                               | :heavy_check_mark:                                                                                                                                                                                                                                                                                                                                                                     | Provide the ID of the related payment.                                                                                                                                                                                                                                                                                                                                                 | tr_5B8cwPMGnU6qLbRvo7qEZo                                                                                                                                                                                                                                                                                                                                                              |
| `testmode`                                                                                                                                                                                                                                                                                                                                                                             | *JsonNullable\<Boolean>*                                                                                                                                                                                                                                                                                                                                                               | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                     | Most API credentials are specifically created for either live mode or test mode. In those cases the `testmode` query parameter can be omitted. For organization-level credentials such as OAuth access tokens, you can enable test mode by setting the `testmode` query parameter to `true`.<br/><br/>Test entities cannot be retrieved when the endpoint is set to live mode, and vice versa. | false                                                                                                                                                                                                                                                                                                                                                                                  |

### Response

**[ReleaseAuthorizationResponse](../../models/operations/ReleaseAuthorizationResponse.md)**

### Errors

| Error Type                                                | Status Code                                               | Content Type                                              |
| --------------------------------------------------------- | --------------------------------------------------------- | --------------------------------------------------------- |
| models/errors/ReleaseAuthorizationResponseBody            | 404                                                       | application/hal+json                                      |
| models/errors/ReleaseAuthorizationPaymentsAPIResponseBody | 422                                                       | application/hal+json                                      |
| models/errors/APIException                                | 4XX, 5XX                                                  | \*/\*                                                     |