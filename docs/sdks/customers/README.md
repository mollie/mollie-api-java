# Customers
(*customers()*)

## Overview

### Available Operations

* [create](#create) - Create customer
* [list](#list) - List customers
* [get](#get) - Get customer
* [update](#update) - Update customer
* [delete](#delete) - Delete customer
* [createPayment](#createpayment) - Create customer payment
* [listPayments](#listpayments) - List customer payments

## create

Creates a simple minimal representation of a customer. Payments, recurring mandates, and subscriptions can be linked to this customer object, which simplifies management of recurring payments.

Once registered, customers will also appear in your Mollie dashboard.

> 🔑 Access with
>
> [API key](/reference/authentication)
>
> [Access token with **customers.write**](/reference/authentication)

### Example Usage

```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.CreateCustomerResponseBody;
import com.mollie.mollie.models.operations.CreateCustomerRequestBody;
import com.mollie.mollie.models.operations.CreateCustomerResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws CreateCustomerResponseBody, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey("<YOUR_BEARER_TOKEN_HERE>")
                    .build())
            .build();

        CreateCustomerRequestBody req = CreateCustomerRequestBody.builder()
                .build();

        CreateCustomerResponse res = sdk.customers().create()
                .request(req)
                .call();

        if (res.any().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                         | Type                                                                              | Required                                                                          | Description                                                                       |
| --------------------------------------------------------------------------------- | --------------------------------------------------------------------------------- | --------------------------------------------------------------------------------- | --------------------------------------------------------------------------------- |
| `request`                                                                         | [CreateCustomerRequestBody](../../models/operations/CreateCustomerRequestBody.md) | :heavy_check_mark:                                                                | The request object to use for the request.                                        |

### Response

**[CreateCustomerResponse](../../models/operations/CreateCustomerResponse.md)**

### Errors

| Error Type                               | Status Code                              | Content Type                             |
| ---------------------------------------- | ---------------------------------------- | ---------------------------------------- |
| models/errors/CreateCustomerResponseBody | 404                                      | application/hal+json                     |
| models/errors/APIException               | 4XX, 5XX                                 | \*/\*                                    |

## list

Retrieve a list of all customers.

The results are paginated.

> 🔑 Access with
>
> [API key](/reference/authentication)
>
> [Access token with **customers.read**](/reference/authentication)

### Example Usage

```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.ListCustomersCustomersResponseBody;
import com.mollie.mollie.models.errors.ListCustomersResponseBody;
import com.mollie.mollie.models.operations.ListCustomersResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ListCustomersResponseBody, ListCustomersCustomersResponseBody, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey("<YOUR_BEARER_TOKEN_HERE>")
                    .build())
            .build();

        ListCustomersResponse res = sdk.customers().list()
                .from("cst_8wmqcHMN4U")
                .limit(50L)
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
| `from`                                                                                                                                                                                                                                                                                                                                                                                 | *Optional\<String>*                                                                                                                                                                                                                                                                                                                                                                    | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                     | Provide an ID to start the result set from the item with the given ID and onwards. This allows you to paginate the result set.                                                                                                                                                                                                                                                         | cst_8wmqcHMN4U                                                                                                                                                                                                                                                                                                                                                                         |
| `limit`                                                                                                                                                                                                                                                                                                                                                                                | *JsonNullable\<Long>*                                                                                                                                                                                                                                                                                                                                                                  | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                     | The maximum number of items to return. Defaults to 50 items.                                                                                                                                                                                                                                                                                                                           | 50                                                                                                                                                                                                                                                                                                                                                                                     |
| `testmode`                                                                                                                                                                                                                                                                                                                                                                             | *JsonNullable\<Boolean>*                                                                                                                                                                                                                                                                                                                                                               | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                     | Most API credentials are specifically created for either live mode or test mode. In those cases the `testmode` query parameter can be omitted. For organization-level credentials such as OAuth access tokens, you can enable test mode by setting the `testmode` query parameter to `true`.<br/><br/>Test entities cannot be retrieved when the endpoint is set to live mode, and vice versa. | false                                                                                                                                                                                                                                                                                                                                                                                  |

### Response

**[ListCustomersResponse](../../models/operations/ListCustomersResponse.md)**

### Errors

| Error Type                                       | Status Code                                      | Content Type                                     |
| ------------------------------------------------ | ------------------------------------------------ | ------------------------------------------------ |
| models/errors/ListCustomersResponseBody          | 400                                              | application/hal+json                             |
| models/errors/ListCustomersCustomersResponseBody | 404                                              | application/hal+json                             |
| models/errors/APIException                       | 4XX, 5XX                                         | \*/\*                                            |

## get

Retrieve a single customer by its ID.

> 🔑 Access with
>
> [API key](/reference/authentication)

### Example Usage

```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.GetCustomerResponseBody;
import com.mollie.mollie.models.operations.GetCustomerResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws GetCustomerResponseBody, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey("<YOUR_BEARER_TOKEN_HERE>")
                    .build())
            .build();

        GetCustomerResponse res = sdk.customers().get()
                .id("cst_8wmqcHMN4U")
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
| `id`                                                                                                                                                                                                                                                                                                                                                                                   | *String*                                                                                                                                                                                                                                                                                                                                                                               | :heavy_check_mark:                                                                                                                                                                                                                                                                                                                                                                     | Provide the ID of the item you want to perform this operation on.                                                                                                                                                                                                                                                                                                                      | cst_8wmqcHMN4U                                                                                                                                                                                                                                                                                                                                                                         |
| `testmode`                                                                                                                                                                                                                                                                                                                                                                             | *JsonNullable\<Boolean>*                                                                                                                                                                                                                                                                                                                                                               | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                     | Most API credentials are specifically created for either live mode or test mode. In those cases the `testmode` query parameter can be omitted. For organization-level credentials such as OAuth access tokens, you can enable test mode by setting the `testmode` query parameter to `true`.<br/><br/>Test entities cannot be retrieved when the endpoint is set to live mode, and vice versa. | false                                                                                                                                                                                                                                                                                                                                                                                  |

### Response

**[GetCustomerResponse](../../models/operations/GetCustomerResponse.md)**

### Errors

| Error Type                            | Status Code                           | Content Type                          |
| ------------------------------------- | ------------------------------------- | ------------------------------------- |
| models/errors/GetCustomerResponseBody | 404                                   | application/hal+json                  |
| models/errors/APIException            | 4XX, 5XX                              | \*/\*                                 |

## update

Update an existing customer.

For an in-depth explanation of each parameter, refer to the [Create customer](create-customer) endpoint.

> 🔑 Access with
>
> [API key](/reference/authentication)

### Example Usage

```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.UpdateCustomerResponseBody;
import com.mollie.mollie.models.operations.UpdateCustomerRequestBody;
import com.mollie.mollie.models.operations.UpdateCustomerResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws UpdateCustomerResponseBody, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey("<YOUR_BEARER_TOKEN_HERE>")
                    .build())
            .build();

        UpdateCustomerResponse res = sdk.customers().update()
                .id("cst_8wmqcHMN4U")
                .requestBody(UpdateCustomerRequestBody.builder()
                    .build())
                .call();

        if (res.any().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                    | Type                                                                                         | Required                                                                                     | Description                                                                                  | Example                                                                                      |
| -------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------- |
| `id`                                                                                         | *String*                                                                                     | :heavy_check_mark:                                                                           | Provide the ID of the item you want to perform this operation on.                            | cst_8wmqcHMN4U                                                                               |
| `requestBody`                                                                                | [Optional\<UpdateCustomerRequestBody>](../../models/operations/UpdateCustomerRequestBody.md) | :heavy_minus_sign:                                                                           | N/A                                                                                          |                                                                                              |

### Response

**[UpdateCustomerResponse](../../models/operations/UpdateCustomerResponse.md)**

### Errors

| Error Type                               | Status Code                              | Content Type                             |
| ---------------------------------------- | ---------------------------------------- | ---------------------------------------- |
| models/errors/UpdateCustomerResponseBody | 404                                      | application/hal+json                     |
| models/errors/APIException               | 4XX, 5XX                                 | \*/\*                                    |

## delete

Delete a customer. All mandates and subscriptions created for this customer will be canceled as well.

> 🔑 Access with
>
> [API key](/reference/authentication)

### Example Usage

```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.DeleteCustomerResponseBody;
import com.mollie.mollie.models.operations.DeleteCustomerResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws DeleteCustomerResponseBody, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey("<YOUR_BEARER_TOKEN_HERE>")
                    .build())
            .build();

        DeleteCustomerResponse res = sdk.customers().delete()
                .id("cst_8wmqcHMN4U")
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
| `id`                                                                                                                                                                                                                                                                                                                                                                                   | *String*                                                                                                                                                                                                                                                                                                                                                                               | :heavy_check_mark:                                                                                                                                                                                                                                                                                                                                                                     | Provide the ID of the item you want to perform this operation on.                                                                                                                                                                                                                                                                                                                      | cst_8wmqcHMN4U                                                                                                                                                                                                                                                                                                                                                                         |
| `testmode`                                                                                                                                                                                                                                                                                                                                                                             | *JsonNullable\<Boolean>*                                                                                                                                                                                                                                                                                                                                                               | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                     | Most API credentials are specifically created for either live mode or test mode. In those cases the `testmode` query parameter can be omitted. For organization-level credentials such as OAuth access tokens, you can enable test mode by setting the `testmode` query parameter to `true`.<br/><br/>Test entities cannot be retrieved when the endpoint is set to live mode, and vice versa. | false                                                                                                                                                                                                                                                                                                                                                                                  |

### Response

**[DeleteCustomerResponse](../../models/operations/DeleteCustomerResponse.md)**

### Errors

| Error Type                               | Status Code                              | Content Type                             |
| ---------------------------------------- | ---------------------------------------- | ---------------------------------------- |
| models/errors/DeleteCustomerResponseBody | 404                                      | application/hal+json                     |
| models/errors/APIException               | 4XX, 5XX                                 | \*/\*                                    |

## createPayment

Creates a payment for the customer.

Linking customers to payments enables you to:

* Keep track of payment preferences for your customers
* Allow your customers to charge a previously used credit card with a single click in our hosted checkout
* Improve payment insights in the Mollie dashboard
* Use recurring payments

This endpoint is effectively an alias of the [Create payment endpoint](create-payment) with the `customerId` parameter predefined. Please refer to the documentation of that endpoint for all possible parameters.

> 🔑 Access with
>
> [API key](/reference/authentication)
>
> [Access token with **payments.write**](/reference/authentication)

### Example Usage

```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.CreateCustomerPaymentResponseBody;
import com.mollie.mollie.models.operations.CreateCustomerPaymentRequestBody;
import com.mollie.mollie.models.operations.CreateCustomerPaymentResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws CreateCustomerPaymentResponseBody, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey("<YOUR_BEARER_TOKEN_HERE>")
                    .build())
            .build();

        CreateCustomerPaymentResponse res = sdk.customers().createPayment()
                .customerId("cst_8wmqcHMN4U")
                .requestBody(CreateCustomerPaymentRequestBody.builder()
                    .profileId("pfl_QkEhN94Ba")
                    .build())
                .call();

        if (res.any().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                  | Type                                                                                                       | Required                                                                                                   | Description                                                                                                | Example                                                                                                    |
| ---------------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------- |
| `customerId`                                                                                               | *String*                                                                                                   | :heavy_check_mark:                                                                                         | Provide the ID of the related customer.                                                                    | cst_8wmqcHMN4U                                                                                             |
| `requestBody`                                                                                              | [Optional\<CreateCustomerPaymentRequestBody>](../../models/operations/CreateCustomerPaymentRequestBody.md) | :heavy_minus_sign:                                                                                         | N/A                                                                                                        |                                                                                                            |

### Response

**[CreateCustomerPaymentResponse](../../models/operations/CreateCustomerPaymentResponse.md)**

### Errors

| Error Type                                      | Status Code                                     | Content Type                                    |
| ----------------------------------------------- | ----------------------------------------------- | ----------------------------------------------- |
| models/errors/CreateCustomerPaymentResponseBody | 404                                             | application/hal+json                            |
| models/errors/APIException                      | 4XX, 5XX                                        | \*/\*                                           |

## listPayments

Retrieve all payments linked to the customer.

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
import com.mollie.mollie.models.errors.ListCustomerPaymentsResponseBody;
import com.mollie.mollie.models.operations.ListCustomerPaymentsResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ListCustomerPaymentsResponseBody, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey("<YOUR_BEARER_TOKEN_HERE>")
                    .build())
            .build();

        ListCustomerPaymentsResponse res = sdk.customers().listPayments()
                .customerId("cst_8wmqcHMN4U")
                .profileId("pfl_QkEhN94Ba")
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
| `customerId`                                                                                                                                                                                                                                                                                                                                                                           | *String*                                                                                                                                                                                                                                                                                                                                                                               | :heavy_check_mark:                                                                                                                                                                                                                                                                                                                                                                     | Provide the ID of the related customer.                                                                                                                                                                                                                                                                                                                                                | cst_8wmqcHMN4U                                                                                                                                                                                                                                                                                                                                                                         |
| `profileId`                                                                                                                                                                                                                                                                                                                                                                            | *JsonNullable\<String>*                                                                                                                                                                                                                                                                                                                                                                | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                     | The identifier referring to the [profile](get-profile) this entity belongs to.<br/><br/>Most API credentials are linked to a single profile. In these cases the `profileId` can be omitted in the creation request. For organization-level credentials such as OAuth access tokens however, the `profileId` parameter is required.                                                     | pfl_QkEhN94Ba                                                                                                                                                                                                                                                                                                                                                                          |
| `testmode`                                                                                                                                                                                                                                                                                                                                                                             | *JsonNullable\<Boolean>*                                                                                                                                                                                                                                                                                                                                                               | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                     | Most API credentials are specifically created for either live mode or test mode. In those cases the `testmode` query parameter can be omitted. For organization-level credentials such as OAuth access tokens, you can enable test mode by setting the `testmode` query parameter to `true`.<br/><br/>Test entities cannot be retrieved when the endpoint is set to live mode, and vice versa. | false                                                                                                                                                                                                                                                                                                                                                                                  |

### Response

**[ListCustomerPaymentsResponse](../../models/operations/ListCustomerPaymentsResponse.md)**

### Errors

| Error Type                                     | Status Code                                    | Content Type                                   |
| ---------------------------------------------- | ---------------------------------------------- | ---------------------------------------------- |
| models/errors/ListCustomerPaymentsResponseBody | 404                                            | application/hal+json                           |
| models/errors/APIException                     | 4XX, 5XX                                       | \*/\*                                          |