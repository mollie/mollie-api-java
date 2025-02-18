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
implementation 'com.mollie:mollie:0.1.0'
```

Maven:
```xml
<dependency>
    <groupId>com.mollie</groupId>
    <artifactId>mollie</artifactId>
    <version>0.1.0</version>
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
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.ListBalancesBalancesAPIResponseBody;
import com.mollie.mollie.models.errors.ListBalancesResponseBody;
import com.mollie.mollie.models.operations.ListBalancesResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ListBalancesResponseBody, ListBalancesBalancesAPIResponseBody, Exception {

        Mollie sdk = Mollie.builder()
                .security(Security.builder()
                    .apiKey("<YOUR_BEARER_TOKEN_HERE>")
                    .build())
            .build();

        ListBalancesResponse res = sdk.balancesAPI().listBalances()
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

This SDK supports the following security schemes globally:

| Name     | Type   | Scheme       |
| -------- | ------ | ------------ |
| `apiKey` | http   | HTTP Bearer  |
| `oAuth`  | oauth2 | OAuth2 token |

You can set the security parameters through the `security` builder method when initializing the SDK client instance. The selected scheme will be used by default to authenticate with the API for all operations that support it. For example:
```java
package hello.world;

import com.mollie.mollie.Mollie;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.ListBalancesBalancesAPIResponseBody;
import com.mollie.mollie.models.errors.ListBalancesResponseBody;
import com.mollie.mollie.models.operations.ListBalancesResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ListBalancesResponseBody, ListBalancesBalancesAPIResponseBody, Exception {

        Mollie sdk = Mollie.builder()
                .security(Security.builder()
                    .apiKey("<YOUR_BEARER_TOKEN_HERE>")
                    .build())
            .build();

        ListBalancesResponse res = sdk.balancesAPI().listBalances()
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
<!-- End Authentication [security] -->

<!-- Start Available Resources and Operations [operations] -->
## Available Resources and Operations

<details open>
<summary>Available methods</summary>

### [balancesAPI()](docs/sdks/balancesapi/README.md)

* [listBalances](docs/sdks/balancesapi/README.md#listbalances) - List balances
* [getBalance](docs/sdks/balancesapi/README.md#getbalance) - Get balance
* [getPrimaryBalance](docs/sdks/balancesapi/README.md#getprimarybalance) - Get primary balance
* [getBalanceReport](docs/sdks/balancesapi/README.md#getbalancereport) - Get balance report
* [listBalanceTransactions](docs/sdks/balancesapi/README.md#listbalancetransactions) - List balance transactions

### [capabilitiesAPI()](docs/sdks/capabilitiesapi/README.md)

* [listCapabilities](docs/sdks/capabilitiesapi/README.md#listcapabilities) - List capabilities

### [capturesAPI()](docs/sdks/capturesapi/README.md)

* [createCapture](docs/sdks/capturesapi/README.md#createcapture) - Create capture
* [listCaptures](docs/sdks/capturesapi/README.md#listcaptures) - List captures
* [getCapture](docs/sdks/capturesapi/README.md#getcapture) - Get capture

### [chargebacksAPI()](docs/sdks/chargebacksapi/README.md)

* [listChargebacks](docs/sdks/chargebacksapi/README.md#listchargebacks) - List payment chargebacks
* [getChargeback](docs/sdks/chargebacksapi/README.md#getchargeback) - Get payment chargeback
* [listAllChargebacks](docs/sdks/chargebacksapi/README.md#listallchargebacks) - List all chargebacks

### [clientLinksAPI()](docs/sdks/clientlinksapi/README.md)

* [createClientLink](docs/sdks/clientlinksapi/README.md#createclientlink) - Create client link

### [clientsAPI()](docs/sdks/clientsapi/README.md)

* [listClients](docs/sdks/clientsapi/README.md#listclients) - List clients
* [getClient](docs/sdks/clientsapi/README.md#getclient) - Get client

### [customersAPI()](docs/sdks/customersapi/README.md)

* [createCustomer](docs/sdks/customersapi/README.md#createcustomer) - Create customer
* [listCustomers](docs/sdks/customersapi/README.md#listcustomers) - List customers
* [getCustomer](docs/sdks/customersapi/README.md#getcustomer) - Get customer
* [updateCustomer](docs/sdks/customersapi/README.md#updatecustomer) - Update customer
* [deleteCustomer](docs/sdks/customersapi/README.md#deletecustomer) - Delete customer
* [createCustomerPayment](docs/sdks/customersapi/README.md#createcustomerpayment) - Create customer payment
* [listCustomerPayments](docs/sdks/customersapi/README.md#listcustomerpayments) - List customer payments

### [delayedRoutingAPI()](docs/sdks/delayedroutingapi/README.md)

* [paymentCreateRoute](docs/sdks/delayedroutingapi/README.md#paymentcreateroute) - Create a delayed route
* [paymentListRoutes](docs/sdks/delayedroutingapi/README.md#paymentlistroutes) - List payment routes

### [invoicesAPI()](docs/sdks/invoicesapi/README.md)

* [listInvoices](docs/sdks/invoicesapi/README.md#listinvoices) - List invoices
* [getInvoice](docs/sdks/invoicesapi/README.md#getinvoice) - Get invoice

### [mandatesAPI()](docs/sdks/mandatesapi/README.md)

* [createMandate](docs/sdks/mandatesapi/README.md#createmandate) - Create mandate
* [listMandates](docs/sdks/mandatesapi/README.md#listmandates) - List mandates
* [getMandate](docs/sdks/mandatesapi/README.md#getmandate) - Get mandate
* [revokeMandate](docs/sdks/mandatesapi/README.md#revokemandate) - Revoke mandate

### [methodsAPI()](docs/sdks/methodsapi/README.md)

* [listMethods](docs/sdks/methodsapi/README.md#listmethods) - List payment methods
* [listAllMethods](docs/sdks/methodsapi/README.md#listallmethods) - List all payment methods
* [getMethod](docs/sdks/methodsapi/README.md#getmethod) - Get payment method
* [enableMethod](docs/sdks/methodsapi/README.md#enablemethod) - Enable payment method
* [disableMethod](docs/sdks/methodsapi/README.md#disablemethod) - Disable payment method
* [enableMethodIssuer](docs/sdks/methodsapi/README.md#enablemethodissuer) - Enable payment method issuer
* [disableMethodIssuer](docs/sdks/methodsapi/README.md#disablemethodissuer) - Disable payment method issuer


### [onboardingAPI()](docs/sdks/onboardingapi/README.md)

* [getOnboardingStatus](docs/sdks/onboardingapi/README.md#getonboardingstatus) - Get onboarding status
* [submitOnboardingData](docs/sdks/onboardingapi/README.md#submitonboardingdata) - Submit onboarding data

### [ordersAPI()](docs/sdks/ordersapi/README.md)

* [createOrder](docs/sdks/ordersapi/README.md#createorder) - Create order
* [listOrders](docs/sdks/ordersapi/README.md#listorders) - List orders
* [getOrder](docs/sdks/ordersapi/README.md#getorder) - Get order
* [updateOrder](docs/sdks/ordersapi/README.md#updateorder) - Update order
* [cancelOrder](docs/sdks/ordersapi/README.md#cancelorder) - Cancel order
* [manageOrderLines](docs/sdks/ordersapi/README.md#manageorderlines) - Manage order lines
* [cancelOrderLines](docs/sdks/ordersapi/README.md#cancelorderlines) - Cancel order lines
* [updateOrderLine](docs/sdks/ordersapi/README.md#updateorderline) - Update order line
* [createOrderPayment](docs/sdks/ordersapi/README.md#createorderpayment) - Create order payment

### [organizationsAPI()](docs/sdks/organizationsapi/README.md)

* [getOrganization](docs/sdks/organizationsapi/README.md#getorganization) - Get organization
* [getCurrentOrganization](docs/sdks/organizationsapi/README.md#getcurrentorganization) - Get current organization
* [getPartnerStatus](docs/sdks/organizationsapi/README.md#getpartnerstatus) - Get partner status

### [paymentLinksAPI()](docs/sdks/paymentlinksapi/README.md)

* [createPaymentLink](docs/sdks/paymentlinksapi/README.md#createpaymentlink) - Create payment link
* [listPaymentLinks](docs/sdks/paymentlinksapi/README.md#listpaymentlinks) - List payment links
* [getPaymentLink](docs/sdks/paymentlinksapi/README.md#getpaymentlink) - Get payment link
* [updatePaymentLink](docs/sdks/paymentlinksapi/README.md#updatepaymentlink) - Update payment link
* [deletePaymentLink](docs/sdks/paymentlinksapi/README.md#deletepaymentlink) - Delete payment link
* [getPaymentLinkPayments](docs/sdks/paymentlinksapi/README.md#getpaymentlinkpayments) - Get payment link payments

### [paymentsAPI()](docs/sdks/paymentsapi/README.md)

* [createPayment](docs/sdks/paymentsapi/README.md#createpayment) - Create payment
* [listPayments](docs/sdks/paymentsapi/README.md#listpayments) - List payments
* [getPayment](docs/sdks/paymentsapi/README.md#getpayment) - Get payment
* [updatePayment](docs/sdks/paymentsapi/README.md#updatepayment) - Update payment
* [cancelPayment](docs/sdks/paymentsapi/README.md#cancelpayment) - Cancel payment
* [releaseAuthorization](docs/sdks/paymentsapi/README.md#releaseauthorization) - Release payment authorization

### [permissionsAPI()](docs/sdks/permissionsapi/README.md)

* [listPermissions](docs/sdks/permissionsapi/README.md#listpermissions) - List permissions
* [getPermission](docs/sdks/permissionsapi/README.md#getpermission) - Get permission

### [profilesAPI()](docs/sdks/profilesapi/README.md)

* [createProfile](docs/sdks/profilesapi/README.md#createprofile) - Create profile
* [listProfiles](docs/sdks/profilesapi/README.md#listprofiles) - List profiles
* [getProfile](docs/sdks/profilesapi/README.md#getprofile) - Get profile
* [updateProfile](docs/sdks/profilesapi/README.md#updateprofile) - Update profile
* [deleteProfile](docs/sdks/profilesapi/README.md#deleteprofile) - Delete profile
* [getCurrentProfile](docs/sdks/profilesapi/README.md#getcurrentprofile) - Get current profile

### [refundsAPI()](docs/sdks/refundsapi/README.md)

* [createRefund](docs/sdks/refundsapi/README.md#createrefund) - Create payment refund
* [listRefunds](docs/sdks/refundsapi/README.md#listrefunds) - List payment refunds
* [getRefund](docs/sdks/refundsapi/README.md#getrefund) - Get payment refund
* [cancelRefund](docs/sdks/refundsapi/README.md#cancelrefund) - Cancel payment refund
* [createOrderRefund](docs/sdks/refundsapi/README.md#createorderrefund) - Create order refund
* [listOrderRefunds](docs/sdks/refundsapi/README.md#listorderrefunds) - List order refunds
* [listAllRefunds](docs/sdks/refundsapi/README.md#listallrefunds) - List all refunds

### [settlementsAPI()](docs/sdks/settlementsapi/README.md)

* [listSettlements](docs/sdks/settlementsapi/README.md#listsettlements) - List settlements
* [getSettlement](docs/sdks/settlementsapi/README.md#getsettlement) - Get settlement
* [getOpenSettlement](docs/sdks/settlementsapi/README.md#getopensettlement) - Get open settlement
* [getNextSettlement](docs/sdks/settlementsapi/README.md#getnextsettlement) - Get next settlement
* [getSettlementPayments](docs/sdks/settlementsapi/README.md#getsettlementpayments) - Get settlement payments
* [getSettlementCaptures](docs/sdks/settlementsapi/README.md#getsettlementcaptures) - Get settlement captures
* [getSettlementRefunds](docs/sdks/settlementsapi/README.md#getsettlementrefunds) - Get settlement refunds
* [getSettlementChargebacks](docs/sdks/settlementsapi/README.md#getsettlementchargebacks) - Get settlement chargebacks

### [shipmentsAPI()](docs/sdks/shipmentsapi/README.md)

* [createShipment](docs/sdks/shipmentsapi/README.md#createshipment) - Create shipment
* [listShipments](docs/sdks/shipmentsapi/README.md#listshipments) - List shipments
* [getShipment](docs/sdks/shipmentsapi/README.md#getshipment) - Get shipment
* [updateShipment](docs/sdks/shipmentsapi/README.md#updateshipment) - Update shipment

### [subscriptionsAPI()](docs/sdks/subscriptionsapi/README.md)

* [createSubscription](docs/sdks/subscriptionsapi/README.md#createsubscription) - Create subscription
* [listSubscriptions](docs/sdks/subscriptionsapi/README.md#listsubscriptions) - List customer subscriptions
* [getSubscription](docs/sdks/subscriptionsapi/README.md#getsubscription) - Get subscription
* [updateSubscription](docs/sdks/subscriptionsapi/README.md#updatesubscription) - Update subscription
* [cancelSubscription](docs/sdks/subscriptionsapi/README.md#cancelsubscription) - Cancel subscription
* [listAllSubscriptions](docs/sdks/subscriptionsapi/README.md#listallsubscriptions) - List all subscriptions
* [listSubscriptionPayments](docs/sdks/subscriptionsapi/README.md#listsubscriptionpayments) - List subscription payments

### [terminalsAPI()](docs/sdks/terminalsapi/README.md)

* [listTerminals](docs/sdks/terminalsapi/README.md#listterminals) - List terminals
* [getTerminal](docs/sdks/terminalsapi/README.md#getterminal) - Get terminal

### [walletsAPI()](docs/sdks/walletsapi/README.md)

* [requestApplePayPaymentSession](docs/sdks/walletsapi/README.md#requestapplepaypaymentsession) - Request Apple Pay payment session

</details>
<!-- End Available Resources and Operations [operations] -->

<!-- Start Error Handling [errors] -->
## Error Handling

Handling errors in this SDK should largely match your expectations. All operations return a response object or raise an exception.

By default, an API error will throw a `models/errors/APIException` exception. When custom error responses are specified for an operation, the SDK may also throw their associated exception. You can refer to respective *Errors* tables in SDK docs for more details on possible exception types for each operation. For example, the `listBalances` method throws the following exceptions:

| Error Type                                        | Status Code | Content Type         |
| ------------------------------------------------- | ----------- | -------------------- |
| models/errors/ListBalancesResponseBody            | 400         | application/hal+json |
| models/errors/ListBalancesBalancesAPIResponseBody | 404         | application/hal+json |
| models/errors/APIException                        | 4XX, 5XX    | \*/\*                |

### Example

```java
package hello.world;

import com.mollie.mollie.Mollie;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.ListBalancesBalancesAPIResponseBody;
import com.mollie.mollie.models.errors.ListBalancesResponseBody;
import com.mollie.mollie.models.operations.ListBalancesResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ListBalancesResponseBody, ListBalancesBalancesAPIResponseBody, Exception {

        Mollie sdk = Mollie.builder()
                .security(Security.builder()
                    .apiKey("<YOUR_BEARER_TOKEN_HERE>")
                    .build())
            .build();

        ListBalancesResponse res = sdk.balancesAPI().listBalances()
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

The default server can be overridden globally using the `.serverURL(String serverUrl)` builder method when initializing the SDK client instance. For example:
```java
package hello.world;

import com.mollie.mollie.Mollie;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.ListBalancesBalancesAPIResponseBody;
import com.mollie.mollie.models.errors.ListBalancesResponseBody;
import com.mollie.mollie.models.operations.ListBalancesResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ListBalancesResponseBody, ListBalancesBalancesAPIResponseBody, Exception {

        Mollie sdk = Mollie.builder()
                .serverURL("https://api.mollie.com/v2")
                .security(Security.builder()
                    .apiKey("<YOUR_BEARER_TOKEN_HERE>")
                    .build())
            .build();

        ListBalancesResponse res = sdk.balancesAPI().listBalances()
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
