# openapi

Developer-friendly & type-safe Java SDK specifically catered to leverage *openapi* API.

<div align="left">
    <a href="https://www.speakeasy.com/?utm_source=openapi&utm_campaign=java"><img src="https://custom-icon-badges.demolab.com/badge/-Built%20By%20Speakeasy-212015?style=for-the-badge&logoColor=FBE331&logo=speakeasy&labelColor=545454" /></a>
    <a href="https://mit-license.org/">
        <img src="https://img.shields.io/badge/License-MIT-blue.svg" style="width: 100px; height: 28px;" />
    </a>
</div>


<br /><br />
> [!IMPORTANT]
> This SDK is not yet ready for production use. To complete setup please follow the steps outlined in your [workspace](https://app.speakeasy.com/org/mollie-oom/mollie). Delete this section before > publishing to a package manager.

<!-- Start Summary [summary] -->
## Summary


<!-- End Summary [summary] -->

<!-- Start Table of Contents [toc] -->
## Table of Contents
<!-- $toc-max-depth=2 -->
* [openapi](#openapi)
  * [SDK Installation](#sdk-installation)
  * [SDK Example Usage](#sdk-example-usage)
  * [Authentication](#authentication)
  * [Available Resources and Operations](#available-resources-and-operations)
  * [Error Handling](#error-handling)
  * [Server Selection](#server-selection)
* [Development](#development)
  * [Maturity](#maturity)
  * [Contributions](#contributions)

<!-- End Table of Contents [toc] -->

<!-- Start SDK Installation [installation] -->
## SDK Installation

### Getting started

JDK 11 or later is required.

The samples below show how a published SDK artifact is used:

Gradle:
```groovy
implementation 'com.mollie:mollie:0.0.1'
```

Maven:
```xml
<dependency>
    <groupId>com.mollie</groupId>
    <artifactId>mollie</artifactId>
    <version>0.0.1</version>
</dependency>
```

### How to build
After cloning the git repository to your file system you can build the SDK artifact from source to the `build` directory by running `./gradlew build` on *nix systems or `gradlew.bat` on Windows systems.

If you wish to build from source and publish the SDK artifact to your local Maven repository (on your filesystem) then use the following command (after cloning the git repo locally):

On *nix:
```bash
./gradlew publishToMavenLocal -Pskip.signing
```
On Windows:
```bash
gradlew.bat publishToMavenLocal -Pskip.signing
```
<!-- End SDK Installation [installation] -->

<!-- Start SDK Example Usage [usage] -->
## SDK Example Usage

### Example

```java
package hello.world;

import com.mollie.mollie.Mollie;
import com.mollie.mollie.models.errors.ListBalancesBalancesAPIResponseBody;
import com.mollie.mollie.models.errors.ListBalancesResponseBody;
import com.mollie.mollie.models.operations.ListBalancesResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ListBalancesResponseBody, ListBalancesBalancesAPIResponseBody, Exception {

        Mollie sdk = Mollie.builder()
                .oAuth("<YOUR_O_AUTH_HERE>")
            .build();

        ListBalancesResponse res = sdk.balancesAPI().list()
                .currency("EUR")
                .from("bal_gVMhHKqSSRYJyPsuoPNFH")
                .limit(50L)
                .testmode(false)
                .call();

        if (res.object().isPresent()) {
            // handle response
        }
    }
}
```
<!-- End SDK Example Usage [usage] -->

<!-- Start Authentication [security] -->
## Authentication

### Per-Client Security Schemes

This SDK supports the following security scheme globally:

| Name    | Type   | Scheme       |
| ------- | ------ | ------------ |
| `oAuth` | oauth2 | OAuth2 token |

To authenticate with the API the `oAuth` parameter must be set when initializing the SDK client instance. For example:
```java
package hello.world;

import com.mollie.mollie.Mollie;
import com.mollie.mollie.models.errors.ListBalancesBalancesAPIResponseBody;
import com.mollie.mollie.models.errors.ListBalancesResponseBody;
import com.mollie.mollie.models.operations.ListBalancesResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ListBalancesResponseBody, ListBalancesBalancesAPIResponseBody, Exception {

        Mollie sdk = Mollie.builder()
                .oAuth("<YOUR_O_AUTH_HERE>")
            .build();

        ListBalancesResponse res = sdk.balancesAPI().list()
                .currency("EUR")
                .from("bal_gVMhHKqSSRYJyPsuoPNFH")
                .limit(50L)
                .testmode(false)
                .call();

        if (res.object().isPresent()) {
            // handle response
        }
    }
}
```

### Per-Operation Security Schemes

Some operations in this SDK require the security scheme to be specified at the request level. For example:
```java
package hello.world;

import com.mollie.mollie.Mollie;
import com.mollie.mollie.models.operations.GetCurrentProfileResponse;
import com.mollie.mollie.models.operations.GetCurrentProfileSecurity;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Mollie sdk = Mollie.builder()
            .build();

        GetCurrentProfileResponse res = sdk.profilesAPI().getCurrent()
                .security(GetCurrentProfileSecurity.builder()
                    .apiKey("<YOUR_BEARER_TOKEN_HERE>")
                    .build())
                .call();

        if (res.object().isPresent()) {
            // handle response
        }
    }
}
```
<!-- End Authentication [security] -->

<!-- Start Available Resources and Operations [operations] -->
## Available Resources and Operations

<details open>
<summary>Available methods</summary>

### [balancesAPI()](docs/sdks/balancesapi/README.md)

* [list](docs/sdks/balancesapi/README.md#list) - List balances
* [get](docs/sdks/balancesapi/README.md#get) - Get balance
* [getPrimary](docs/sdks/balancesapi/README.md#getprimary) - Get primary balance
* [getReport](docs/sdks/balancesapi/README.md#getreport) - Get balance report
* [listTransactions](docs/sdks/balancesapi/README.md#listtransactions) - List balance transactions

### [capabilitiesAPI()](docs/sdks/capabilitiesapi/README.md)

* [list](docs/sdks/capabilitiesapi/README.md#list) - List capabilities

### [capturesAPI()](docs/sdks/capturesapi/README.md)

* [create](docs/sdks/capturesapi/README.md#create) - Create capture
* [list](docs/sdks/capturesapi/README.md#list) - List captures
* [get](docs/sdks/capturesapi/README.md#get) - Get capture

### [chargebacksAPI()](docs/sdks/chargebacksapi/README.md)

* [list](docs/sdks/chargebacksapi/README.md#list) - List payment chargebacks
* [get](docs/sdks/chargebacksapi/README.md#get) - Get payment chargeback
* [listAll](docs/sdks/chargebacksapi/README.md#listall) - List all chargebacks

### [clientLinksAPI()](docs/sdks/clientlinksapi/README.md)

* [create](docs/sdks/clientlinksapi/README.md#create) - Create client link

### [clientsAPI()](docs/sdks/clientsapi/README.md)

* [list](docs/sdks/clientsapi/README.md#list) - List clients
* [get](docs/sdks/clientsapi/README.md#get) - Get client

### [customersAPI()](docs/sdks/customersapi/README.md)

* [create](docs/sdks/customersapi/README.md#create) - Create customer
* [list](docs/sdks/customersapi/README.md#list) - List customers
* [get](docs/sdks/customersapi/README.md#get) - Get customer
* [update](docs/sdks/customersapi/README.md#update) - Update customer
* [delete](docs/sdks/customersapi/README.md#delete) - Delete customer
* [createPayment](docs/sdks/customersapi/README.md#createpayment) - Create customer payment
* [listPayments](docs/sdks/customersapi/README.md#listpayments) - List customer payments

### [delayedRoutingAPI()](docs/sdks/delayedroutingapi/README.md)

* [create](docs/sdks/delayedroutingapi/README.md#create) - Create a delayed route
* [list](docs/sdks/delayedroutingapi/README.md#list) - List payment routes

### [invoicesAPI()](docs/sdks/invoicesapi/README.md)

* [list](docs/sdks/invoicesapi/README.md#list) - List invoices
* [get](docs/sdks/invoicesapi/README.md#get) - Get invoice

### [mandatesAPI()](docs/sdks/mandatesapi/README.md)

* [create](docs/sdks/mandatesapi/README.md#create) - Create mandate
* [list](docs/sdks/mandatesapi/README.md#list) - List mandates
* [get](docs/sdks/mandatesapi/README.md#get) - Get mandate
* [revoke](docs/sdks/mandatesapi/README.md#revoke) - Revoke mandate

### [methodsAPI()](docs/sdks/methodsapi/README.md)

* [list](docs/sdks/methodsapi/README.md#list) - List payment methods
* [listAll](docs/sdks/methodsapi/README.md#listall) - List all payment methods
* [get](docs/sdks/methodsapi/README.md#get) - Get payment method
* [enableMethod](docs/sdks/methodsapi/README.md#enablemethod) - Enable payment method
* [disableMethod](docs/sdks/methodsapi/README.md#disablemethod) - Disable payment method
* [enableMethodIssuer](docs/sdks/methodsapi/README.md#enablemethodissuer) - Enable payment method issuer
* [disableMethodIssuer](docs/sdks/methodsapi/README.md#disablemethodissuer) - Disable payment method issuer


### [onboardingAPI()](docs/sdks/onboardingapi/README.md)

* [get](docs/sdks/onboardingapi/README.md#get) - Get onboarding status
* [create](docs/sdks/onboardingapi/README.md#create) - Submit onboarding data

### [ordersAPI()](docs/sdks/ordersapi/README.md)

* [create](docs/sdks/ordersapi/README.md#create) - Create order
* [list](docs/sdks/ordersapi/README.md#list) - List orders
* [get](docs/sdks/ordersapi/README.md#get) - Get order
* [update](docs/sdks/ordersapi/README.md#update) - Update order
* [cancel](docs/sdks/ordersapi/README.md#cancel) - Cancel order
* [manageLines](docs/sdks/ordersapi/README.md#managelines) - Manage order lines
* [cancelLines](docs/sdks/ordersapi/README.md#cancellines) - Cancel order lines
* [updateLine](docs/sdks/ordersapi/README.md#updateline) - Update order line
* [createPayment](docs/sdks/ordersapi/README.md#createpayment) - Create order payment

### [organizationsAPI()](docs/sdks/organizationsapi/README.md)

* [get](docs/sdks/organizationsapi/README.md#get) - Get organization
* [getCurrent](docs/sdks/organizationsapi/README.md#getcurrent) - Get current organization
* [getPartnerStatus](docs/sdks/organizationsapi/README.md#getpartnerstatus) - Get partner status

### [paymentLinksAPI()](docs/sdks/paymentlinksapi/README.md)

* [create](docs/sdks/paymentlinksapi/README.md#create) - Create payment link
* [list](docs/sdks/paymentlinksapi/README.md#list) - List payment links
* [get](docs/sdks/paymentlinksapi/README.md#get) - Get payment link
* [update](docs/sdks/paymentlinksapi/README.md#update) - Update payment link
* [delete](docs/sdks/paymentlinksapi/README.md#delete) - Delete payment link
* [getPayments](docs/sdks/paymentlinksapi/README.md#getpayments) - Get payment link payments

### [paymentsAPI()](docs/sdks/paymentsapi/README.md)

* [create](docs/sdks/paymentsapi/README.md#create) - Create payment
* [list](docs/sdks/paymentsapi/README.md#list) - List payments
* [get](docs/sdks/paymentsapi/README.md#get) - Get payment
* [update](docs/sdks/paymentsapi/README.md#update) - Update payment
* [cancel](docs/sdks/paymentsapi/README.md#cancel) - Cancel payment

### [permissionsAPI()](docs/sdks/permissionsapi/README.md)

* [list](docs/sdks/permissionsapi/README.md#list) - List permissions
* [get](docs/sdks/permissionsapi/README.md#get) - Get permission

### [profilesAPI()](docs/sdks/profilesapi/README.md)

* [create](docs/sdks/profilesapi/README.md#create) - Create profile
* [list](docs/sdks/profilesapi/README.md#list) - List profiles
* [get](docs/sdks/profilesapi/README.md#get) - Get profile
* [update](docs/sdks/profilesapi/README.md#update) - Update profile
* [delete](docs/sdks/profilesapi/README.md#delete) - Delete profile
* [getCurrent](docs/sdks/profilesapi/README.md#getcurrent) - Get current profile

### [refundsAPI()](docs/sdks/refundsapi/README.md)

* [create](docs/sdks/refundsapi/README.md#create) - Create payment refund
* [list](docs/sdks/refundsapi/README.md#list) - List payment refunds
* [get](docs/sdks/refundsapi/README.md#get) - Get payment refund
* [cancel](docs/sdks/refundsapi/README.md#cancel) - Cancel payment refund
* [createOrder](docs/sdks/refundsapi/README.md#createorder) - Create order refund
* [listOrder](docs/sdks/refundsapi/README.md#listorder) - List order refunds
* [listAll](docs/sdks/refundsapi/README.md#listall) - List all refunds

### [settlementsAPI()](docs/sdks/settlementsapi/README.md)

* [list](docs/sdks/settlementsapi/README.md#list) - List settlements
* [get](docs/sdks/settlementsapi/README.md#get) - Get settlement
* [getOpen](docs/sdks/settlementsapi/README.md#getopen) - Get open settlement
* [getNext](docs/sdks/settlementsapi/README.md#getnext) - Get next settlement
* [getPayments](docs/sdks/settlementsapi/README.md#getpayments) - Get settlement payments
* [getCaptures](docs/sdks/settlementsapi/README.md#getcaptures) - Get settlement captures
* [getRefunds](docs/sdks/settlementsapi/README.md#getrefunds) - Get settlement refunds
* [getChargebacks](docs/sdks/settlementsapi/README.md#getchargebacks) - Get settlement chargebacks

### [shipmentsAPI()](docs/sdks/shipmentsapi/README.md)

* [create](docs/sdks/shipmentsapi/README.md#create) - Create shipment
* [list](docs/sdks/shipmentsapi/README.md#list) - List shipments
* [get](docs/sdks/shipmentsapi/README.md#get) - Get shipment
* [update](docs/sdks/shipmentsapi/README.md#update) - Update shipment

### [subscriptionsAPI()](docs/sdks/subscriptionsapi/README.md)

* [create](docs/sdks/subscriptionsapi/README.md#create) - Create subscription
* [list](docs/sdks/subscriptionsapi/README.md#list) - List customer subscriptions
* [get](docs/sdks/subscriptionsapi/README.md#get) - Get subscription
* [update](docs/sdks/subscriptionsapi/README.md#update) - Update subscription
* [cancel](docs/sdks/subscriptionsapi/README.md#cancel) - Cancel subscription
* [listAll](docs/sdks/subscriptionsapi/README.md#listall) - List all subscriptions
* [listPayments](docs/sdks/subscriptionsapi/README.md#listpayments) - List subscription payments

### [terminalsAPI()](docs/sdks/terminalsapi/README.md)

* [list](docs/sdks/terminalsapi/README.md#list) - List terminals
* [get](docs/sdks/terminalsapi/README.md#get) - Get terminal

### [walletsAPI()](docs/sdks/walletsapi/README.md)

* [requestApplePayPaymentSession](docs/sdks/walletsapi/README.md#requestapplepaypaymentsession) - Request Apple Pay payment session

</details>
<!-- End Available Resources and Operations [operations] -->

<!-- Start Error Handling [errors] -->
## Error Handling

Handling errors in this SDK should largely match your expectations. All operations return a response object or raise an exception.

By default, an API error will throw a `models/errors/APIException` exception. When custom error responses are specified for an operation, the SDK may also throw their associated exception. You can refer to respective *Errors* tables in SDK docs for more details on possible exception types for each operation. For example, the `list` method throws the following exceptions:

| Error Type                                        | Status Code | Content Type         |
| ------------------------------------------------- | ----------- | -------------------- |
| models/errors/ListBalancesResponseBody            | 400         | application/hal+json |
| models/errors/ListBalancesBalancesAPIResponseBody | 404         | application/hal+json |
| models/errors/APIException                        | 4XX, 5XX    | \*/\*                |

### Example

```java
package hello.world;

import com.mollie.mollie.Mollie;
import com.mollie.mollie.models.errors.ListBalancesBalancesAPIResponseBody;
import com.mollie.mollie.models.errors.ListBalancesResponseBody;
import com.mollie.mollie.models.operations.ListBalancesResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ListBalancesResponseBody, ListBalancesBalancesAPIResponseBody, Exception {

        Mollie sdk = Mollie.builder()
                .oAuth("<YOUR_O_AUTH_HERE>")
            .build();

        ListBalancesResponse res = sdk.balancesAPI().list()
                .currency("EUR")
                .from("bal_gVMhHKqSSRYJyPsuoPNFH")
                .limit(50L)
                .testmode(false)
                .call();

        if (res.object().isPresent()) {
            // handle response
        }
    }
}
```
<!-- End Error Handling [errors] -->

<!-- Start Server Selection [server] -->
## Server Selection

### Override Server URL Per-Client

The default server can also be overridden globally using the `.serverURL(String serverUrl)` builder method when initializing the SDK client instance. For example:
```java
package hello.world;

import com.mollie.mollie.Mollie;
import com.mollie.mollie.models.errors.ListBalancesBalancesAPIResponseBody;
import com.mollie.mollie.models.errors.ListBalancesResponseBody;
import com.mollie.mollie.models.operations.ListBalancesResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ListBalancesResponseBody, ListBalancesBalancesAPIResponseBody, Exception {

        Mollie sdk = Mollie.builder()
                .serverURL("https://api.mollie.com/v2")
                .oAuth("<YOUR_O_AUTH_HERE>")
            .build();

        ListBalancesResponse res = sdk.balancesAPI().list()
                .currency("EUR")
                .from("bal_gVMhHKqSSRYJyPsuoPNFH")
                .limit(50L)
                .testmode(false)
                .call();

        if (res.object().isPresent()) {
            // handle response
        }
    }
}
```
<!-- End Server Selection [server] -->

<!-- Placeholder for Future Speakeasy SDK Sections -->

# Development

## Maturity

This SDK is in beta, and there may be breaking changes between versions without a major version update. Therefore, we recommend pinning usage
to a specific package version. This way, you can install the same version each time without breaking changes unless you are intentionally
looking for the latest version.

## Contributions

While we value open-source contributions to this SDK, this library is generated programmatically. Any manual changes added to internal files will be overwritten on the next generation. 
We look forward to hearing your feedback. Feel free to open a PR or an issue with a proof of concept and we'll do our best to include it in a future release. 

### SDK Created by [Speakeasy](https://www.speakeasy.com/?utm_source=openapi&utm_campaign=java)
