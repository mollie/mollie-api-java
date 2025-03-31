# Migration Guide for Mollie API Java
Learn how to migrate to the latest version of the Java SDK

> [!WARNING]
> ### Alpha Feature
> This feature is currently in Alpha testing, and the final specification may still change.

Mollie uses API specification to autogenerate the SDK and enhance its consistency, ensure frequent updates and provide a more streamlined integration experience for developers.

The new version of Java SDK introduces a number of changes that might affect the way your integration works and require adjustments in your current setup: new ways of defining specific arguments, changes to methods and parameter names etc. 

This guide takes you through all the changes specific to Java SDK to help you upgrade your integration.

*You can still use the legacy version of this SDK along with the new version but we advise to upgrade as soon as possible to ensure continuous compatibility.*

## Major Changes
Here are some things you need to know about the new Java SDK to ensure a consistent integration:

1. **Client Creation**
The method to create the client changed, consolidating the Api Key and the oAuth methods.

2. **Method Names**
The method names have been updated for better clarity and consistency across all the SDKs.

## Client Creation
### Example - Api Key Client
**Old**
```java
import be.woutschoovaerts.mollie.Client;
import be.woutschoovaerts.mollie.ClientBuilder;

public class Application {
  public static void main(String[] args) {
    Client client = new ClientBuilder()
      .withApiKey("API_KEY")
      .build();
  }
}

```

**New**
```java
import com.mollie.mollie.Mollie;
import com.mollie.mollie.models.components.Security;
import java.lang.Exception;

public class Application {
  public static void main(String[] args) throws Exception {
    Mollie sdk = Mollie.builder().security(
      Security.builder().apiKey("API_KEY").build()
    ).build();
  }
}

```

### Example - oAuth Client
**Old**
```
Could not find an example.
```

**New**
```java
import com.mollie.mollie.Mollie;
import com.mollie.mollie.models.components.Security;
import java.lang.Exception;

public class Application {

  public static void main(String[] args) throws Exception {
    Mollie sdk = Mollie.builder().security(
      Security.builder().apiKey("OAUTH_KEY").build()
    ).build();
  }
}

```

## Method Names
To see code examples for each method refer to the [README](./README.md).

<table>
  <tr>
    <td>
      API
    </td>
    <td>
      Endpoint
    </td>
    <td>
      Java Method Name
    </td>
    <td>
      New SDK Method Name
    </td>
  </tr>
  <tr>
    <td rowspan="6">
      Payments API
    </td>
    <td>
      Create payment
    </td>
    <td>
      client.payments.createPayment
    </td>
    <td>
      client.payments.create
    </td>
  </tr>
  <tr>
    <td>
      List payments
    </td>
    <td>
      client.payments.listPayments
    </td>
    <td>
      client.payments.list
    </td>
  </tr>
  <tr>
    <td>
      Get payment
    </td>
    <td>
      client.payments.getPayment
    </td>
    <td>
      client.payments.get
    </td>
  </tr>
  <tr>
    <td>
      Update payment
    </td>
    <td>
      client.payments.updatePayment
    </td>
    <td>
      client.payments.update
    </td>
  </tr>
  <tr>
    <td>
      Cancel payment
    </td>
    <td>
      client.payments.cancelPayment
    </td>
    <td>
      client.payments.cancel
    </td>
  </tr>
  <tr>
    <td>
      Release payment authorization
    </td>
    <td>
      -
    </td>
    <td>
      client.payments.releaseAuthorization
    </td>
  </tr>
  <tr>
    <td rowspan="7">
      Methods API
    </td>
    <td>
      List payment methods
    </td>
    <td>
      client.methods.listMethods
    </td>
    <td>
      client.methods.list
    </td>
  </tr>
  <tr>
    <td>
      List all payment methods
    </td>
    <td>
      client.methods.listAllMethods
    </td>
    <td>
      client.methods.all
    </td>
  </tr>
  <tr>
    <td>
      Get payment method
    </td>
    <td>
      client.methods.getMethod
    </td>
    <td>
      client.methods.get
    </td>
  </tr>
  <tr>
    <td>
      Enable payment method
    </td>
    <td>
      client.profiles.enablePaymentMethod
    </td>
    <td>
      client.methods.enable
    </td>
  </tr>
  <tr>
    <td>
      Disable payment method
    </td>
    <td>
      client.profiles.disablePaymentMethod
    </td>
    <td>
      client.methods.disable
    </td>
  </tr>
  <tr>
    <td>
      Enable payment method issuer
    </td>
    <td>
      client.profiles.enableGiftCardIssuer
      client.profiles.enableVoucherIssuer
    </td>
    <td>
      client.methods.enableIssuer
    </td>
  </tr>
  <tr>
    <td>
      Disable payment method issuer
    </td>
    <td>
      client.profiles.disableGiftCardIssuer
      client.profiles.disableVoucherIssuer
    </td>
    <td>
      client.methods.disableIssuer
    </td>
  </tr>
  <tr>
    <td rowspan="7">
      Refunds API
    </td>
    <td>
      Create payment refund
    </td>
    <td>
      client.refunds.createRefund
    </td>
    <td>
      client.refunds.create
    </td>
  </tr>
  <tr>
    <td>
      List payment refunds
    </td>
    <td>
      client.refunds.listRefunds
    </td>
    <td>
      client.refunds.list
    </td>
  </tr>
  <tr>
    <td>
      Get payment refund
    </td>
    <td>
      client.refunds.getRefund
    </td>
    <td>
      client.refunds.get
    </td>
  </tr>
  <tr>
    <td>
      Cancel payment refund
    </td>
    <td>
      client.refunds.cancelRefund
    </td>
    <td>
      client.refunds.cancel
    </td>
  </tr>
  <tr>
    <td>
      Create order refund
    </td>
    <td>
      client.orders.createOrderRefund
    </td>
    <td>
      client.refunds.createOrder
    </td>
  </tr>
  <tr>
    <td>
      List order refunds
    </td>
    <td>
      client.orders.getOrderRefunds
    </td>
    <td>
      client.refunds.getOrder
    </td>
  </tr>
  <tr>
    <td>
      List all refunds
    </td>
    <td>
      client.refunds.listRefunds
    </td>
    <td>
      client.refunds.all
    </td>
  </tr>
  <tr>
    <td rowspan="3">
      Chargebacks API
    </td>
    <td>
      List payment chargebacks
    </td>
    <td>
      client.chargebacks.listChargebacks
    </td>
    <td>
      client.chargebacks.list
    </td>
  </tr>
  <tr>
    <td>
      Get payment chargeback
    </td>
    <td>
      client.chargebacks.getChargeback
    </td>
    <td>
      client.chargebacks.get
    </td>
  </tr>
  <tr>
    <td>
      List all chargebacks
    </td>
    <td>
      client.chargebacks.listChargebacks
    </td>
    <td>
      client.chargebacks.all
    </td>
  </tr>
  <tr>
    <td rowspan="3">
      Captures API
    </td>
    <td>
      Create capture
    </td>
    <td>
      client.captures.createCapture
    </td>
    <td>
      client.captures.create
    </td>
  </tr>
  <tr>
    <td>
      List captures
    </td>
    <td>
      client.captures.listCaptures
    </td>
    <td>
      client.captures.list
    </td>
  </tr>
  <tr>
    <td>
      Get capture
    </td>
    <td>
      client.captures.getCapture
    </td>
    <td>
      client.captures.get
    </td>
  </tr>
  <tr>
    <td>
      Wallets API
    </td>
    <td>
      Request Apple Pay payment session
    </td>
    <td>
      client.wallets.requestApplePaySession
    </td>
    <td>
      client.wallets.requestApplePaySession
    </td>
  </tr>
  <tr>
    <td rowspan="6">
      Payment Links API
    </td>
    <td>
      Create payment link
    </td>
    <td>
      client.paymentLinks.createPaymentLink
    </td>
    <td>
      client.paymentLinks.create
    </td>
  </tr>
  <tr>
    <td>
      List payment links
    </td>
    <td>
      client.paymentLinks.listPaymentLinks
    </td>
    <td>
      client.paymentLinks.list
    </td>
  </tr>
  <tr>
    <td>
      Get payment link
    </td>
    <td>
      client.paymentLinks.getPaymentLink
    </td>
    <td>
      client.paymentLinks.get
    </td>
  </tr>
  <tr>
    <td>
      Update payment link
    </td>
    <td>
      client.paymentLinks.updatePaymentLink
    </td>
    <td>
      client.paymentLinks.update
    </td>
  </tr>
  <tr>
    <td>
      Delete payment link
    </td>
    <td>
      client.paymentLinks.deletePaymentLink
    </td>
    <td>
      client.paymentLinks.delete
    </td>
  </tr>
  <tr>
    <td>
      Get payment link payments
    </td>
    <td>
      client.paymentLinks.listPaymentLinkPayments
    </td>
    <td>
      client.paymentLinks.listPayments
    </td>
  </tr>
  <tr>
    <td rowspan="2">
      Terminals API
    </td>
    <td>
      List terminals
    </td>
    <td>
      client.terminals.listTerminals
    </td>
    <td>
      client.terminals.list
    </td>
  </tr>
  <tr>
    <td>
      Get terminal
    </td>
    <td>
      client.terminals.getTerminal
    </td>
    <td>
      client.terminals.get
    </td>
  </tr>
  <tr>
    <td rowspan="2">
      Delayed Routing API
    </td>
    <td>
      Create a delayed route
    </td>
    <td>
      -
    </td>
    <td>
      client.delayedRouting.create
    </td>
  </tr>
  <tr>
    <td>
      List payment routes
    </td>
    <td>
      -
    </td>
    <td>
      client.delayedRouting.list
    </td>
  </tr>
  <tr>
    <td rowspan="9">
      Orders API
    </td>
    <td>
      Create order
    </td>
    <td>
      client.orders.createOrder
    </td>
    <td>
      client.orders.create
    </td>
  </tr>
  <tr>
    <td>
      List orders
    </td>
    <td>
      client.orders.getOrders
    </td>
    <td>
      client.orders.list
    </td>
  </tr>
  <tr>
    <td>
      Get order
    </td>
    <td>
      client.orders.getOrder
    </td>
    <td>
      client.orders.get
    </td>
  </tr>
  <tr>
    <td>
      Update order
    </td>
    <td>
      client.orders.updateOrder
    </td>
    <td>
      client.orders.update
    </td>
  </tr>
  <tr>
    <td>
      Cancel order
    </td>
    <td>
      client.orders.cancelOrder
    </td>
    <td>
      client.orders.cancel
    </td>
  </tr>
  <tr>
    <td>
      Manage order lines
    </td>
    <td>
      client.orders.manageOrderLines
    </td>
    <td>
      client.orders.manageLines
    </td>
  </tr>
  <tr>
    <td>
      Cancel order lines
    </td>
    <td>
      client.orders.cancelOrderLines
    </td>
    <td>
      client.orders.cancelLines
    </td>
  </tr>
  <tr>
    <td>
      Update order line
    </td>
    <td>
      client.orders.updateOrderLine
    </td>
    <td>
      client.orders.updateLine
    </td>
  </tr>
  <tr>
    <td>
      Create order payment
    </td>
    <td>
      client.orders.createOrderPayment
    </td>
    <td>
      client.orders.createPayment
    </td>
  </tr>
  <tr>
    <td rowspan="4">
      Shipments API
    </td>
    <td>
      Create shipment
    </td>
    <td>
      client.shipments.createShipment
    </td>
    <td>
      client.shipments.create
    </td>
  </tr>
  <tr>
    <td>
      List shipments
    </td>
    <td>
      client.shipments.getShipments
    </td>
    <td>
      client.shipments.list
    </td>
  </tr>
  <tr>
    <td>
      Get shipment
    </td>
    <td>
      client.shipments.getShipment
    </td>
    <td>
      client.shipments.get
    </td>
  </tr>
  <tr>
    <td>
      Update shipment
    </td>
    <td>
      client.shipments.updateShipment
    </td>
    <td>
      client.shipments.update
    </td>
  </tr>
  <tr>
    <td rowspan="7">
      Customers API
    </td>
    <td>
      Create customer
    </td>
    <td>
      client.customer.createCustomer
    </td>
    <td>
      client.customers.create
    </td>
  </tr>
  <tr>
    <td>
      List customers
    </td>
    <td>
      client.customer.listCustomers
    </td>
    <td>
      client.customers.list
    </td>
  </tr>
  <tr>
    <td>
      Get customer
    </td>
    <td>
      client.customer.getCustomer
    </td>
    <td>
      client.customers.get
    </td>
  </tr>
  <tr>
    <td>
      Update customer
    </td>
    <td>
      client.customer.updateCustomer
    </td>
    <td>
      client.customers.update
    </td>
  </tr>
  <tr>
    <td>
      Delete customer
    </td>
    <td>
      client.customer.deleteCustomer
    </td>
    <td>
      client.customers.delete
    </td>
  </tr>
  <tr>
    <td>
      Create customer payment
    </td>
    <td>
      client.customer.createCustomerPayment
    </td>
    <td>
      client.customers.createPayment
    </td>
  </tr>
  <tr>
    <td>
      List customer payments
    </td>
    <td>
      client.customer.listCustomerPayments
    </td>
    <td>
      client.customers.listPayment
    </td>
  </tr>
  <tr>
    <td rowspan="4">
      Mandates API
    </td>
    <td>
      Create mandate
    </td>
    <td>
      client.mandates.createMandate
    </td>
    <td>
      client.mandates.create
    </td>
  </tr>
  <tr>
    <td>
      List mandates
    </td>
    <td>
      client.mandates.listMandates
    </td>
    <td>
      client.mandates.list
    </td>
  </tr>
  <tr>
    <td>
      Get mandate
    </td>
    <td>
      client.mandates.getMandate
    </td>
    <td>
      client.mandates.get
    </td>
  </tr>
  <tr>
    <td>
      Revoke mandate
    </td>
    <td>
      client.mandates.revokeMandate
    </td>
    <td>
      client.mandates.revoke
    </td>
  </tr>
  <tr>
    <td rowspan="7">
      Subscriptions API
    </td>
    <td>
      Create subscription
    </td>
    <td>
      client.subscriptions.createSubscription
    </td>
    <td>
      client.subscriptions.create
    </td>
  </tr>
  <tr>
    <td>
      List customer subscriptions
    </td>
    <td>
      client.subscriptions.listSubscriptions
    </td>
    <td>
      client.subscriptions.list
    </td>
  </tr>
  <tr>
    <td>
      Get subscription
    </td>
    <td>
      client.subscriptions.getSubscription
    </td>
    <td>
      client.subscriptions.get
    </td>
  </tr>
  <tr>
    <td>
      Update subscription
    </td>
    <td>
      client.subscriptions.updateSubscription
    </td>
    <td>
      client.subscriptions.update
    </td>
  </tr>
  <tr>
    <td>
      Cancel subscription
    </td>
    <td>
      client.subscriptions.cancelSubscription
    </td>
    <td>
      client.subscriptions.cancel
    </td>
  </tr>
  <tr>
    <td>
      List all subscriptions
    </td>
    <td>
      client.subscriptions.listAllSubscriptions
    </td>
    <td>
      client.subscriptions.all
    </td>
  </tr>
  <tr>
    <td>
      List subscription payments
    </td>
    <td>
      client.subscriptions.listSubscriptionPayments
    </td>
    <td>
      client.subscriptions.listPayments
    </td>
  </tr>
  <tr>
    <td rowspan="3">
      OAuth API
    </td>
    <td>
      Authorize
    </td>
    <td>
      client.oAuth.createAuthorizationUrl
    </td>
    <td>
      client.oauth.authorize
    </td>
  </tr>
  <tr>
    <td>
      Generate tokens
    </td>
    <td>
      client.oAuth.generateTokens
    </td>
    <td>
      client.oauth.generate
    </td>
  </tr>
  <tr>
    <td>
      Revoke tokens
    </td>
    <td>
      client.oAuth.revokeToken
    </td>
    <td>
      client.oauth.revoke
    </td>
  </tr>
  <tr>
    <td rowspan="2">
      Permissions API
    </td>
    <td>
      List permissions
    </td>
    <td>
      client.permissions.getPermissions
    </td>
    <td>
      client.permissions.list
    </td>
  </tr>
  <tr>
    <td>
      Get permission
    </td>
    <td>
      client.permissions.getPermission
    </td>
    <td>
      client.permissions.get
    </td>
  </tr>
  <tr>
    <td rowspan="3">
      Organizations API
    </td>
    <td>
      Get organization
    </td>
    <td>
      client.organizations.getOrganization
    </td>
    <td>
      client.organizations.get
    </td>
  </tr>
  <tr>
    <td>
      Get current organization
    </td>
    <td>
      client.organizations.getMyOrganization
    </td>
    <td>
      client.organizations.current
    </td>
  </tr>
  <tr>
    <td>
      Get partner status
    </td>
    <td>
      client.organizations.getPartner
    </td>
    <td>
      client.organizations.partner
    </td>
  </tr>
  <tr>
    <td rowspan="6">
      Profiles API
    </td>
    <td>
      Create profile
    </td>
    <td>
      client.profiles.createProfile
    </td>
    <td>
      client.profiles.create
    </td>
  </tr>
  <tr>
    <td>
      List profiles
    </td>
    <td>
      client.profiles.getProfiles
    </td>
    <td>
      client.profiles.list
    </td>
  </tr>
  <tr>
    <td>
      Get profile
    </td>
    <td>
      client.profiles.getProfile
    </td>
    <td>
      client.profiles.get
    </td>
  </tr>
  <tr>
    <td>
      Update profile
    </td>
    <td>
      client.profiles.updateProfile
    </td>
    <td>
      client.profiles.update
    </td>
  </tr>
  <tr>
    <td>
      Delete profile
    </td>
    <td>
      client.profiles.deleteProfile
    </td>
    <td>
      client.profiles.delete
    </td>
  </tr>
  <tr>
    <td>
      Get current profile
    </td>
    <td>
      client.profiles.getMyProfile
    </td>
    <td>
      client.profiles.current
    </td>
  </tr>
  <tr>
    <td rowspan="2">
      Onboarding API
    </td>
    <td>
      Get onboarding status
    </td>
    <td>
      client.onboarding.getOnboardingStatus
    </td>
    <td>
      client.onboarding.get
    </td>
  </tr>
  <tr>
    <td>
      Submit onboarding data
    </td>
    <td>
      client.onboarding.submitOnboardingData
    </td>
    <td>
      client.onboarding.submit
    </td>
  </tr>
  <tr>
    <td>
      Capabilities API
    </td>
    <td>
      List capabilities
    </td>
    <td>
      -
    </td>
    <td>
      client.capabilities.list
    </td>
  </tr>
  <tr>
    <td rowspan="2">
      Clients API
    </td>
    <td>
      List clients
    </td>
    <td>
      client.clients.getClients
    </td>
    <td>
      client.clients.list
    </td>
  </tr>
  <tr>
    <td>
      Get client
    </td>
    <td>
      client.clients.getClient
    </td>
    <td>
      client.clients.get
    </td>
  </tr>
  <tr>
    <td>
      Client Links API
    </td>
    <td>
      Create client link
    </td>
    <td>
      client.clientLinks.createClientLink
    </td>
    <td>
      client.clientLinks.create
    </td>
  </tr>
  <tr>
    <td rowspan="5">
      Balances API
    </td>
    <td>
      List balances
    </td>
    <td>
      client.balances.getBalances
    </td>
    <td>
      client.balances.list
    </td>
  </tr>
  <tr>
    <td>
      Get balance
    </td>
    <td>
      client.balances.getBalance
    </td>
    <td>
      client.balances.get
    </td>
  </tr>
  <tr>
    <td>
      Get primary balance
    </td>
    <td>
      client.balances.getPrimaryBalance
    </td>
    <td>
      client.balances.primary
    </td>
  </tr>
  <tr>
    <td>
      Get balance report
    </td>
    <td>
      client.balances.getBalanceReport
    </td>
    <td>
      client.balances.report
    </td>
  </tr>
  <tr>
    <td>
      List balance transactions
    </td>
    <td>
      client.balances.getBalanceTransactions
    </td>
    <td>
      client.balances.transactions
    </td>
  </tr>
  <tr>
    <td rowspan="8">
      Settlements API
    </td>
    <td>
      List settlements
    </td>
    <td>
      client.settlements.getSettlements
    </td>
    <td>
      client.settlements.list
    </td>
  </tr>
  <tr>
    <td>
      Get settlement
    </td>
    <td>
      client.settlements.getSettlement
    </td>
    <td>
      client.settlements.get
    </td>
  </tr>
  <tr>
    <td>
      Get open settlement
    </td>
    <td>
      client.settlements.getOpenSettlement
    </td>
    <td>
      client.settlements.open
    </td>
  </tr>
  <tr>
    <td>
      Get next settlement
    </td>
    <td>
      client.settlements.getNextSettlement
    </td>
    <td>
      client.settlements.next
    </td>
  </tr>
  <tr>
    <td>
      Get settlement payments
    </td>
    <td>
      client.settlements.getSettlementPayments
    </td>
    <td>
      client.settlements.payments
    </td>
  </tr>
  <tr>
    <td>
      Get settlement captures
    </td>
    <td>
      client.settlements.getSettlementCaptures
    </td>
    <td>
      client.settlements.captures
    </td>
  </tr>
  <tr>
    <td>
      Get settlement refunds
    </td>
    <td>
      client.settlements.getSettlementRefund
    </td>
    <td>
      client.settlements.refunds
    </td>
  </tr>
  <tr>
    <td>
      Get settlement chargebacks
    </td>
    <td>
      client.settlements.getSettlementChargebacks
    </td>
    <td>
      client.settlements.chargebacks
    </td>
  </tr>
  <tr>
    <td rowspan="2">
      Invoices API
    </td>
    <td>
      List invoices
    </td>
    <td>
      client.invoices.getInvoices
    </td>
    <td>
      client.invoices.list
    </td>
  </tr>
  <tr>
    <td>
      Get invoice
    </td>
    <td>
      client.invoices.getInvoice
    </td>
    <td>
      client.invoices.get
    </td>
  </tr>
</table>