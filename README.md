# mollie-api-java

Developer-friendly & type-safe Java SDK specifically catered to leverage *mollie-api-java* API.

<div align="left">
    <a href="https://www.speakeasy.com/?utm_source=openapi&utm_campaign=java"><img src="https://custom-icon-badges.demolab.com/badge/-Built%20By%20Speakeasy-212015?style=for-the-badge&logoColor=FBE331&logo=speakeasy&labelColor=545454" /></a>
    <a href="https://mit-license.org/">
        <img src="https://img.shields.io/badge/License-MIT-blue.svg" style="width: 100px; height: 28px;" />
    </a>
</div>

## Migration
This documentation is for the new Mollie's SDK. You can find more details on how to migrate from the old version to the new one [here](/MIGRATION.md).

<!-- Start Summary [summary] -->
## Summary


<!-- End Summary [summary] -->

<!-- Start Table of Contents [toc] -->
## Table of Contents
<!-- $toc-max-depth=2 -->
* [mollie-api-java](#mollie-api-java)
  * [Migration](#migration)
  * [SDK Installation](#sdk-installation)
  * [SDK Example Usage](#sdk-example-usage)
  * [Asynchronous Support](#asynchronous-support)
  * [Authentication](#authentication)
  * [Idempotency Key](#idempotency-key)
  * [Add Custom User-Agent Header](#add-custom-user-agent-header)
  * [Add Profile ID and Testmode to Client](#add-profile-id-and-testmode-to-client)
  * [Available Resources and Operations](#available-resources-and-operations)
  * [Global Parameters](#global-parameters)
  * [Retries](#retries)
  * [Error Handling](#error-handling)
  * [Server Selection](#server-selection)
  * [Custom HTTP Client](#custom-http-client)
  * [Debugging](#debugging)
* [Development](#development)
  * [Contributions](#contributions)

<!-- End Table of Contents [toc] -->

<!-- Start SDK Installation [installation] -->
## SDK Installation

### Getting started

JDK 11 or later is required.

The samples below show how a published SDK artifact is used:

Gradle:
```groovy
implementation 'com.mollie:mollie:1.0.9'
```

Maven:
```xml
<dependency>
    <groupId>com.mollie</groupId>
    <artifactId>mollie</artifactId>
    <version>1.0.9</version>
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

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.ListBalancesRequest;
import com.mollie.mollie.models.operations.ListBalancesResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .testmode(false)
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        ListBalancesRequest req = ListBalancesRequest.builder()
                .currency("EUR")
                .from("bal_gVMhHKqSSRYJyPsuoPNFH")
                .limit(50L)
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .build();

        ListBalancesResponse res = sdk.balances().list()
                .request(req)
                .call();

        if (res.object().isPresent()) {
            // handle response
        }
    }
}
```
#### Asynchronous Call
An asynchronous SDK client is also available that returns a [`CompletableFuture<T>`][comp-fut]. See [Asynchronous Support](#asynchronous-support) for more details on async benefits and reactive library integration.
```java
package hello.world;

import com.mollie.mollie.AsyncClient;
import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.operations.ListBalancesRequest;
import com.mollie.mollie.models.operations.async.ListBalancesResponse;
import java.util.concurrent.CompletableFuture;

public class Application {

    public static void main(String[] args) {

        AsyncClient sdk = Client.builder()
                .testmode(false)
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build()
            .async();

        ListBalancesRequest req = ListBalancesRequest.builder()
                .currency("EUR")
                .from("bal_gVMhHKqSSRYJyPsuoPNFH")
                .limit(50L)
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .build();

        CompletableFuture<ListBalancesResponse> resFut = sdk.balances().list()
                .request(req)
                .call();

        resFut.thenAccept(res -> {
            if (res.object().isPresent()) {
            // handle response
            }
        });
    }
}
```

[comp-fut]: https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/CompletableFuture.html
<!-- End SDK Example Usage [usage] -->

<!-- Start Asynchronous Support [async-support] -->
## Asynchronous Support

The SDK provides comprehensive asynchronous support using Java's [`CompletableFuture<T>`][comp-fut] and [Reactive Streams `Publisher<T>`][reactive-streams] APIs. This design makes no assumptions about your choice of reactive toolkit, allowing seamless integration with any reactive library.

<details>
<summary>Why Use Async?</summary>

Asynchronous operations provide several key benefits:

- **Non-blocking I/O**: Your threads stay free for other work while operations are in flight
- **Better resource utilization**: Handle more concurrent operations with fewer threads
- **Improved scalability**: Build highly responsive applications that can handle thousands of concurrent requests
- **Reactive integration**: Works seamlessly with reactive streams and backpressure handling

</details>

<details>
<summary>Reactive Library Integration</summary>

The SDK returns [Reactive Streams `Publisher<T>`][reactive-streams] instances for operations dealing with streams involving multiple I/O interactions. We use Reactive Streams instead of JDK Flow API to provide broader compatibility with the reactive ecosystem, as most reactive libraries natively support Reactive Streams.

**Why Reactive Streams over JDK Flow?**
- **Broader ecosystem compatibility**: Most reactive libraries (Project Reactor, RxJava, Akka Streams, etc.) natively support Reactive Streams
- **Industry standard**: Reactive Streams is the de facto standard for reactive programming in Java
- **Better interoperability**: Seamless integration without additional adapters for most use cases

**Integration with Popular Libraries:**
- **Project Reactor**: Use `Flux.from(publisher)` to convert to Reactor types
- **RxJava**: Use `Flowable.fromPublisher(publisher)` for RxJava integration
- **Akka Streams**: Use `Source.fromPublisher(publisher)` for Akka Streams integration
- **Vert.x**: Use `ReadStream.fromPublisher(vertx, publisher)` for Vert.x reactive streams
- **Mutiny**: Use `Multi.createFrom().publisher(publisher)` for Quarkus Mutiny integration

**For JDK Flow API Integration:**
If you need JDK Flow API compatibility (e.g., for Quarkus/Mutiny 2), you can use adapters:
```java
// Convert Reactive Streams Publisher to Flow Publisher
Flow.Publisher<T> flowPublisher = FlowAdapters.toFlowPublisher(reactiveStreamsPublisher);

// Convert Flow Publisher to Reactive Streams Publisher
Publisher<T> reactiveStreamsPublisher = FlowAdapters.toPublisher(flowPublisher);
```

For standard single-response operations, the SDK returns `CompletableFuture<T>` for straightforward async execution.

</details>

<details>
<summary>Supported Operations</summary>

Async support is available for:

- **[Server-sent Events](#server-sent-event-streaming)**: Stream real-time events with Reactive Streams `Publisher<T>`
- **[JSONL Streaming](#jsonl-streaming)**: Process streaming JSON lines asynchronously
- **[Pagination](#pagination)**: Iterate through paginated results using `callAsPublisher()` and `callAsPublisherUnwrapped()`
- **[File Uploads](#file-uploads)**: Upload files asynchronously with progress tracking
- **[File Downloads](#file-downloads)**: Download files asynchronously with streaming support
- **[Standard Operations](#example)**: All regular API calls return `CompletableFuture<T>` for async execution

</details>

[comp-fut]: https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/CompletableFuture.html
[reactive-streams]: https://www.reactive-streams.org/
<!-- End Asynchronous Support [async-support] -->

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

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.ListBalancesRequest;
import com.mollie.mollie.models.operations.ListBalancesResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
                .testmode(false)
            .build();

        ListBalancesRequest req = ListBalancesRequest.builder()
                .currency("EUR")
                .from("bal_gVMhHKqSSRYJyPsuoPNFH")
                .limit(50L)
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .build();

        ListBalancesResponse res = sdk.balances().list()
                .request(req)
                .call();

        if (res.object().isPresent()) {
            // handle response
        }
    }
}
```
<!-- End Authentication [security] -->

<!-- Start Idempotency Key -->
## Idempotency Key

This SDK supports the usage of Idempotency Keys. See our [documentation](https://docs.mollie.com/reference/api-idempotency) on how to use it.

```java
package com.example.app;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.*;
import com.mollie.mollie.models.operations.*;
import java.lang.Exception;
import java.lang.RuntimeException;

public class App 
{
    public static void main(String[] args) throws ErrorResponse, Exception {
        try {
            Client sdk = Client.builder()
                    .security(Security.builder()
                        .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                        .build())
                .build();

            String idempotencyKey = "<some-idempotency-key>";

            CreatePaymentResponse res = sdk.payments().create()
                .idempotencyKey(idempotencyKey)
                .paymentRequest(PaymentRequest.builder()
                    .description("My first payment")
                    .redirectUrl("https://example.org/redirect")
                    .amount(Amount.builder()
                        .currency("EUR")
                        .value("10.00")
                        .build())
                    .build())
                .call();

            CreatePaymentResponse res2 = sdk.payments().create()
                .idempotencyKey(idempotencyKey)
                .paymentRequest(PaymentRequest.builder()
                    .description("My first payment")
                    .redirectUrl("https://example.org/redirect")
                    .amount(Amount.builder()
                        .currency("EUR")
                        .value("10.00")
                        .build())
                    .build())
                .call();

            String paymentId1 = res.paymentResponse().orElseThrow().id().orElseThrow();
            String paymentId2 = res2.paymentResponse().orElseThrow().id().orElseThrow();
            System.out.println(paymentId1);
            System.out.println(paymentId2);
            if (paymentId1.equals(paymentId2)) {
                System.out.println("Payments are the same");
            } else {
                System.out.println("Payments are different");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

```
<!-- End Idempotency Key -->

<!-- Start Add Custom User-Agent Header -->

## Add Custom User-Agent Header
The SDK allows you to append a custom suffix to the `User-Agent` header for all requests. This can be used to identify
your application or integration when interacting with the API, making it easier to track usage or debug requests. The suffix is automatically added to the default User-Agent string generated by the SDK. You can add it when creating the
client:

```java
Client sdk = Client.builder()
    .security(Security.builder()
        .apiKey(System.getenv().getOrDefault("API_KEY", ""))
        .build())
    .customUserAgent("insert something here")
.build();
```

<!-- End Add Custom User-Agent Header -->

<!-- Start Add Profile ID and Testmode to Client -->

## Add Profile ID and Testmode to Client
The SDK allows you to define the `profileId` and `testmode` in the client. This way, you don't need to add this
information to the payload every time when using OAuth. This will not override the details provided in the individual
requests.

```java
Client sdk = Client.builder()
    .security(Security.builder()
        .apiKey(System.getenv().getOrDefault("OAUTH_KEY", ""))
        .build())
    .testmode(true)
    .profileId("pfl_...")
.build();
```

<!-- End Add Profile ID and Testmode to Client -->

<!-- Start Available Resources and Operations [operations] -->
## Available Resources and Operations

<details open>
<summary>Available methods</summary>

### [BalanceTransfers](docs/sdks/balancetransfers/README.md)

* [create](docs/sdks/balancetransfers/README.md#create) - Create a Connect balance transfer
* [list](docs/sdks/balancetransfers/README.md#list) - List all Connect balance transfers
* [get](docs/sdks/balancetransfers/README.md#get) - Get a Connect balance transfer

### [Balances](docs/sdks/balances/README.md)

* [list](docs/sdks/balances/README.md#list) - List balances
* [get](docs/sdks/balances/README.md#get) - Get balance
* [getPrimary](docs/sdks/balances/README.md#getprimary) - Get primary balance
* [getReport](docs/sdks/balances/README.md#getreport) - Get balance report
* [listTransactions](docs/sdks/balances/README.md#listtransactions) - List balance transactions

### [Capabilities](docs/sdks/capabilities/README.md)

* [list](docs/sdks/capabilities/README.md#list) - List capabilities

### [Captures](docs/sdks/captures/README.md)

* [create](docs/sdks/captures/README.md#create) - Create capture
* [list](docs/sdks/captures/README.md#list) - List captures
* [get](docs/sdks/captures/README.md#get) - Get capture

### [Chargebacks](docs/sdks/chargebacks/README.md)

* [list](docs/sdks/chargebacks/README.md#list) - List payment chargebacks
* [get](docs/sdks/chargebacks/README.md#get) - Get payment chargeback
* [all](docs/sdks/chargebacks/README.md#all) - List all chargebacks

### [ClientLinks](docs/sdks/clientlinks/README.md)

* [create](docs/sdks/clientlinks/README.md#create) - Create client link

### [Clients](docs/sdks/clients/README.md)

* [list](docs/sdks/clients/README.md#list) - List clients
* [get](docs/sdks/clients/README.md#get) - Get client

### [Customers](docs/sdks/customers/README.md)

* [create](docs/sdks/customers/README.md#create) - Create customer
* [list](docs/sdks/customers/README.md#list) - List customers
* [get](docs/sdks/customers/README.md#get) - Get customer
* [update](docs/sdks/customers/README.md#update) - Update customer
* [delete](docs/sdks/customers/README.md#delete) - Delete customer
* [createPayment](docs/sdks/customers/README.md#createpayment) - Create customer payment
* [listPayments](docs/sdks/customers/README.md#listpayments) - List customer payments

### [DelayedRouting](docs/sdks/delayedrouting/README.md)

* [create](docs/sdks/delayedrouting/README.md#create) - Create a delayed route
* [list](docs/sdks/delayedrouting/README.md#list) - List payment routes
* [get](docs/sdks/delayedrouting/README.md#get) - Get a delayed route

### [Invoices](docs/sdks/invoices/README.md)

* [list](docs/sdks/invoices/README.md#list) - List invoices
* [get](docs/sdks/invoices/README.md#get) - Get invoice

### [Mandates](docs/sdks/mandates/README.md)

* [create](docs/sdks/mandates/README.md#create) - Create mandate
* [list](docs/sdks/mandates/README.md#list) - List mandates
* [get](docs/sdks/mandates/README.md#get) - Get mandate
* [revoke](docs/sdks/mandates/README.md#revoke) - Revoke mandate

### [Methods](docs/sdks/methods/README.md)

* [list](docs/sdks/methods/README.md#list) - List payment methods
* [all](docs/sdks/methods/README.md#all) - List all payment methods
* [get](docs/sdks/methods/README.md#get) - Get payment method

### [Onboarding](docs/sdks/onboarding/README.md)

* [get](docs/sdks/onboarding/README.md#get) - Get onboarding status
* [submit](docs/sdks/onboarding/README.md#submit) - Submit onboarding data

### [Organizations](docs/sdks/organizations/README.md)

* [get](docs/sdks/organizations/README.md#get) - Get organization
* [getCurrent](docs/sdks/organizations/README.md#getcurrent) - Get current organization
* [getPartner](docs/sdks/organizations/README.md#getpartner) - Get partner status

### [PaymentLinks](docs/sdks/paymentlinks/README.md)

* [create](docs/sdks/paymentlinks/README.md#create) - Create payment link
* [list](docs/sdks/paymentlinks/README.md#list) - List payment links
* [get](docs/sdks/paymentlinks/README.md#get) - Get payment link
* [update](docs/sdks/paymentlinks/README.md#update) - Update payment link
* [delete](docs/sdks/paymentlinks/README.md#delete) - Delete payment link
* [listPayments](docs/sdks/paymentlinks/README.md#listpayments) - Get payment link payments

### [Payments](docs/sdks/payments/README.md)

* [create](docs/sdks/payments/README.md#create) - Create payment
* [list](docs/sdks/payments/README.md#list) - List payments
* [get](docs/sdks/payments/README.md#get) - Get payment
* [update](docs/sdks/payments/README.md#update) - Update payment
* [cancel](docs/sdks/payments/README.md#cancel) - Cancel payment
* [releaseAuthorization](docs/sdks/payments/README.md#releaseauthorization) - Release payment authorization

### [Permissions](docs/sdks/permissions/README.md)

* [list](docs/sdks/permissions/README.md#list) - List permissions
* [get](docs/sdks/permissions/README.md#get) - Get permission

### [Profiles](docs/sdks/profiles/README.md)

* [create](docs/sdks/profiles/README.md#create) - Create profile
* [list](docs/sdks/profiles/README.md#list) - List profiles
* [get](docs/sdks/profiles/README.md#get) - Get profile
* [update](docs/sdks/profiles/README.md#update) - Update profile
* [delete](docs/sdks/profiles/README.md#delete) - Delete profile
* [getCurrent](docs/sdks/profiles/README.md#getcurrent) - Get current profile

### [Refunds](docs/sdks/refunds/README.md)

* [create](docs/sdks/refunds/README.md#create) - Create payment refund
* [list](docs/sdks/refunds/README.md#list) - List payment refunds
* [get](docs/sdks/refunds/README.md#get) - Get payment refund
* [cancel](docs/sdks/refunds/README.md#cancel) - Cancel payment refund
* [all](docs/sdks/refunds/README.md#all) - List all refunds

### [SalesInvoices](docs/sdks/salesinvoices/README.md)

* [create](docs/sdks/salesinvoices/README.md#create) - Create sales invoice
* [list](docs/sdks/salesinvoices/README.md#list) - List sales invoices
* [get](docs/sdks/salesinvoices/README.md#get) - Get sales invoice
* [update](docs/sdks/salesinvoices/README.md#update) - Update sales invoice
* [delete](docs/sdks/salesinvoices/README.md#delete) - Delete sales invoice

### [Settlements](docs/sdks/settlements/README.md)

* [list](docs/sdks/settlements/README.md#list) - List settlements
* [get](docs/sdks/settlements/README.md#get) - Get settlement
* [getOpen](docs/sdks/settlements/README.md#getopen) - Get open settlement
* [getNext](docs/sdks/settlements/README.md#getnext) - Get next settlement
* [listPayments](docs/sdks/settlements/README.md#listpayments) - List settlement payments
* [listCaptures](docs/sdks/settlements/README.md#listcaptures) - List settlement captures
* [listRefunds](docs/sdks/settlements/README.md#listrefunds) - List settlement refunds
* [listChargebacks](docs/sdks/settlements/README.md#listchargebacks) - List settlement chargebacks

### [Subscriptions](docs/sdks/subscriptions/README.md)

* [create](docs/sdks/subscriptions/README.md#create) - Create subscription
* [list](docs/sdks/subscriptions/README.md#list) - List customer subscriptions
* [get](docs/sdks/subscriptions/README.md#get) - Get subscription
* [update](docs/sdks/subscriptions/README.md#update) - Update subscription
* [cancel](docs/sdks/subscriptions/README.md#cancel) - Cancel subscription
* [all](docs/sdks/subscriptions/README.md#all) - List all subscriptions
* [listPayments](docs/sdks/subscriptions/README.md#listpayments) - List subscription payments

### [Terminals](docs/sdks/terminals/README.md)

* [list](docs/sdks/terminals/README.md#list) - List terminals
* [get](docs/sdks/terminals/README.md#get) - Get terminal

### [Wallets](docs/sdks/wallets/README.md)

* [requestApplePaySession](docs/sdks/wallets/README.md#requestapplepaysession) - Request Apple Pay payment session

### [WebhookEvents](docs/sdks/webhookevents/README.md)

* [get](docs/sdks/webhookevents/README.md#get) - Get a Webhook Event

### [Webhooks](docs/sdks/webhooks/README.md)

* [create](docs/sdks/webhooks/README.md#create) - Create a webhook
* [list](docs/sdks/webhooks/README.md#list) - List all webhooks
* [update](docs/sdks/webhooks/README.md#update) - Update a webhook
* [get](docs/sdks/webhooks/README.md#get) - Get a webhook
* [delete](docs/sdks/webhooks/README.md#delete) - Delete a webhook
* [test](docs/sdks/webhooks/README.md#test) - Test a webhook

</details>
<!-- End Available Resources and Operations [operations] -->

<!-- Start Global Parameters [global-parameters] -->
## Global Parameters

Certain parameters are configured globally. These parameters may be set on the SDK client instance itself during initialization. When configured as an option during SDK initialization, These global values will be used as defaults on the operations that use them. When such operations are called, there is a place in each to override the global value, if needed.

For example, you can set `profileId` to `` at SDK initialization and then you do not have to pass the same value on calls to operations like `list`. But if you want to do so you may, which will locally override the global setting. See the example code below for a demonstration.


### Available Globals

The following global parameters are available.

| Name            | Type             | Description                                                                                                                                                                                                                                                                                                                                                                                            |
| --------------- | ---------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ |
| profileId       | java.lang.String | The identifier referring to the [profile](get-profile) you wish to<br/>retrieve the resources for.<br/><br/>Most API credentials are linked to a single profile. In these cases the `profileId` can be omitted. For<br/>organization-level credentials such as OAuth access tokens however, the `profileId` parameter is required.                                                                     |
| testmode        | boolean          | Most API credentials are specifically created for either live mode or test mode. In those cases the `testmode` query<br/>parameter can be omitted. For organization-level credentials such as OAuth access tokens, you can enable test mode by<br/>setting the `testmode` query parameter to `true`.<br/><br/>Test entities cannot be retrieved when the endpoint is set to live mode, and vice versa. |
| customUserAgent | java.lang.String | Custom user agent string to be appended to the default Mollie SDK user agent.                                                                                                                                                                                                                                                                                                                          |

### Example

```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.ListBalancesRequest;
import com.mollie.mollie.models.operations.ListBalancesResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .testmode(false)
                .profileId("<id>")
                .customUserAgent("<value>")
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        ListBalancesRequest req = ListBalancesRequest.builder()
                .currency("EUR")
                .from("bal_gVMhHKqSSRYJyPsuoPNFH")
                .limit(50L)
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .build();

        ListBalancesResponse res = sdk.balances().list()
                .request(req)
                .call();

        if (res.object().isPresent()) {
            // handle response
        }
    }
}
```
<!-- End Global Parameters [global-parameters] -->

<!-- Start Retries [retries] -->
## Retries

Some of the endpoints in this SDK support retries. If you use the SDK without any configuration, it will fall back to the default retry strategy provided by the API. However, the default retry strategy can be overridden on a per-operation basis, or across the entire SDK.

To change the default retry strategy for a single API call, you can provide a `RetryConfig` object through the `retryConfig` builder method:
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.ListBalancesRequest;
import com.mollie.mollie.models.operations.ListBalancesResponse;
import com.mollie.mollie.utils.BackoffStrategy;
import com.mollie.mollie.utils.RetryConfig;
import java.lang.Exception;
import java.util.concurrent.TimeUnit;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .testmode(false)
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        ListBalancesRequest req = ListBalancesRequest.builder()
                .currency("EUR")
                .from("bal_gVMhHKqSSRYJyPsuoPNFH")
                .limit(50L)
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .build();

        ListBalancesResponse res = sdk.balances().list()
                .request(req)
                .retryConfig(RetryConfig.builder()
                    .backoff(BackoffStrategy.builder()
                        .initialInterval(1L, TimeUnit.MILLISECONDS)
                        .maxInterval(50L, TimeUnit.MILLISECONDS)
                        .maxElapsedTime(1000L, TimeUnit.MILLISECONDS)
                        .baseFactor(1.1)
                        .jitterFactor(0.15)
                        .retryConnectError(false)
                        .build())
                    .build())
                .call();

        if (res.object().isPresent()) {
            // handle response
        }
    }
}
```

If you'd like to override the default retry strategy for all operations that support retries, you can provide a configuration at SDK initialization:
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.ListBalancesRequest;
import com.mollie.mollie.models.operations.ListBalancesResponse;
import com.mollie.mollie.utils.BackoffStrategy;
import com.mollie.mollie.utils.RetryConfig;
import java.lang.Exception;
import java.util.concurrent.TimeUnit;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .retryConfig(RetryConfig.builder()
                    .backoff(BackoffStrategy.builder()
                        .initialInterval(1L, TimeUnit.MILLISECONDS)
                        .maxInterval(50L, TimeUnit.MILLISECONDS)
                        .maxElapsedTime(1000L, TimeUnit.MILLISECONDS)
                        .baseFactor(1.1)
                        .jitterFactor(0.15)
                        .retryConnectError(false)
                        .build())
                    .build())
                .testmode(false)
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        ListBalancesRequest req = ListBalancesRequest.builder()
                .currency("EUR")
                .from("bal_gVMhHKqSSRYJyPsuoPNFH")
                .limit(50L)
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .build();

        ListBalancesResponse res = sdk.balances().list()
                .request(req)
                .call();

        if (res.object().isPresent()) {
            // handle response
        }
    }
}
```
<!-- End Retries [retries] -->

<!-- Start Error Handling [errors] -->
## Error Handling

Handling errors in this SDK should largely match your expectations. All operations return a response object or raise an exception.


[`ClientError`](./src/main/java/models/errors/ClientError.java) is the base class for all HTTP error responses. It has the following properties:

| Method           | Type                        | Description                                                              |
| ---------------- | --------------------------- | ------------------------------------------------------------------------ |
| `message()`      | `String`                    | Error message                                                            |
| `code()`         | `int`                       | HTTP response status code eg `404`                                       |
| `headers`        | `Map<String, List<String>>` | HTTP response headers                                                    |
| `body()`         | `byte[]`                    | HTTP body as a byte array. Can be empty array if no body is returned.    |
| `bodyAsString()` | `String`                    | HTTP body as a UTF-8 string. Can be empty string if no body is returned. |
| `rawResponse()`  | `HttpResponse<?>`           | Raw HTTP response (body already read and not available for re-read)      |

### Example
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.ClientError;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.ListBalancesRequest;
import com.mollie.mollie.models.operations.ListBalancesResponse;
import java.io.UncheckedIOException;
import java.lang.Exception;
import java.lang.String;
import java.util.Optional;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .testmode(false)
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();
        try {

            ListBalancesRequest req = ListBalancesRequest.builder()
                    .currency("EUR")
                    .from("bal_gVMhHKqSSRYJyPsuoPNFH")
                    .limit(50L)
                    .idempotencyKey("123e4567-e89b-12d3-a456-426")
                    .build();

            ListBalancesResponse res = sdk.balances().list()
                    .request(req)
                    .call();

            if (res.object().isPresent()) {
                // handle response
            }
        } catch (ClientError ex) { // all SDK exceptions inherit from ClientError

            // ex.ToString() provides a detailed error message including
            // HTTP status code, headers, and error payload (if any)
            System.out.println(ex);

            // Base exception fields
            var rawResponse = ex.rawResponse();
            var headers = ex.headers();
            var contentType = headers.first("Content-Type");
            int statusCode = ex.code();
            Optional<byte[]> responseBody = ex.body();

            // different error subclasses may be thrown 
            // depending on the service call
            if (ex instanceof ErrorResponse) {
                var e = (ErrorResponse) ex;
                // Check error data fields
                e.data().ifPresent(payload -> {
                      long status = payload.status();
                      String title = payload.title();
                      // ...
                });
            }

            // An underlying cause may be provided. If the error payload 
            // cannot be deserialized then the deserialization exception 
            // will be set as the cause.
            if (ex.getCause() != null) {
                var cause = ex.getCause();
            }
        } catch (UncheckedIOException ex) {
            // handle IO error (connection, timeout, etc)
        }    }
}
```

### Error Classes
**Primary errors:**
* [`ClientError`](./src/main/java/models/errors/ClientError.java): The base class for HTTP error responses.
  * [`com.mollie.mollie.models.errors.ErrorResponse`](./src/main/java/models/errors/com.mollie.mollie.models.errors.ErrorResponse.java): An error response object. *

<details><summary>Less common errors (6)</summary>

<br />

**Network errors:**
* `java.io.IOException` (always wrapped by `java.io.UncheckedIOException`). Commonly encountered subclasses of
`IOException` include `java.net.ConnectException`, `java.net.SocketTimeoutException`, `EOFException` (there are
many more subclasses in the JDK platform).

**Inherit from [`ClientError`](./src/main/java/models/errors/ClientError.java)**:


</details>

\* Check [the method documentation](#available-resources-and-operations) to see if the error is applicable.
<!-- End Error Handling [errors] -->

<!-- Start Server Selection [server] -->
## Server Selection

### Override Server URL Per-Client

The default server can be overridden globally using the `.serverURL(String serverUrl)` builder method when initializing the SDK client instance. For example:
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.ListBalancesRequest;
import com.mollie.mollie.models.operations.ListBalancesResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .serverURL("https://api.mollie.com/v2")
                .testmode(false)
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        ListBalancesRequest req = ListBalancesRequest.builder()
                .currency("EUR")
                .from("bal_gVMhHKqSSRYJyPsuoPNFH")
                .limit(50L)
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .build();

        ListBalancesResponse res = sdk.balances().list()
                .request(req)
                .call();

        if (res.object().isPresent()) {
            // handle response
        }
    }
}
```
<!-- End Server Selection [server] -->

<!-- Start Custom HTTP Client [http-client] -->
## Custom HTTP Client

The Java SDK makes API calls using an `HTTPClient` that wraps the native
[HttpClient](https://docs.oracle.com/en/java/javase/11/docs/api/java.net.http/java/net/http/HttpClient.html). This
client provides the ability to attach hooks around the request lifecycle that can be used to modify the request or handle
errors and response.

The `HTTPClient` interface allows you to either use the default `SpeakeasyHTTPClient` that comes with the SDK,
or provide your own custom implementation with customized configuration such as custom executors, SSL context,
connection pools, and other HTTP client settings.

The interface provides synchronous (`send`) methods and asynchronous (`sendAsync`) methods. The `sendAsync` method
is used to power the async SDK methods and returns a `CompletableFuture<HttpResponse<Blob>>` for non-blocking operations.

The following example shows how to add a custom header and handle errors:

```java
import com.mollie.mollie.Client;
import com.mollie.mollie.utils.HTTPClient;
import com.mollie.mollie.utils.SpeakeasyHTTPClient;
import com.mollie.mollie.utils.Utils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.io.InputStream;
import java.time.Duration;

public class Application {
    public static void main(String[] args) {
        // Create a custom HTTP client with hooks
        HTTPClient httpClient = new HTTPClient() {
            private final HTTPClient defaultClient = new SpeakeasyHTTPClient();
            
            @Override
            public HttpResponse<InputStream> send(HttpRequest request) throws IOException, URISyntaxException, InterruptedException {
                // Add custom header and timeout using Utils.copy()
                HttpRequest modifiedRequest = Utils.copy(request)
                    .header("x-custom-header", "custom value")
                    .timeout(Duration.ofSeconds(30))
                    .build();
                    
                try {
                    HttpResponse<InputStream> response = defaultClient.send(modifiedRequest);
                    // Log successful response
                    System.out.println("Request successful: " + response.statusCode());
                    return response;
                } catch (Exception error) {
                    // Log error
                    System.err.println("Request failed: " + error.getMessage());
                    throw error;
                }
            }
        };

        Client sdk = Client.builder()
            .client(httpClient)
            .build();
    }
}
```

<details>
<summary>Custom HTTP Client Configuration</summary>

You can also provide a completely custom HTTP client with your own configuration:

```java
import com.mollie.mollie.Client;
import com.mollie.mollie.utils.HTTPClient;
import com.mollie.mollie.utils.Blob;
import com.mollie.mollie.utils.ResponseWithBody;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.io.InputStream;
import java.time.Duration;
import java.util.concurrent.Executors;
import java.util.concurrent.CompletableFuture;

public class Application {
    public static void main(String[] args) {
        // Custom HTTP client with custom configuration
        HTTPClient customHttpClient = new HTTPClient() {
            private final HttpClient client = HttpClient.newBuilder()
                .executor(Executors.newFixedThreadPool(10))
                .connectTimeout(Duration.ofSeconds(30))
                // .sslContext(customSslContext) // Add custom SSL context if needed
                .build();

            @Override
            public HttpResponse<InputStream> send(HttpRequest request) throws IOException, URISyntaxException, InterruptedException {
                return client.send(request, HttpResponse.BodyHandlers.ofInputStream());
            }

            @Override
            public CompletableFuture<HttpResponse<Blob>> sendAsync(HttpRequest request) {
                // Convert response to HttpResponse<Blob> for async operations
                return client.sendAsync(request, HttpResponse.BodyHandlers.ofPublisher())
                    .thenApply(resp -> new ResponseWithBody<>(resp, Blob::from));
            }
        };

        Client sdk = Client.builder()
            .client(customHttpClient)
            .build();
    }
}
```

</details>

You can also enable debug logging on the default `SpeakeasyHTTPClient`:

```java
import com.mollie.mollie.Client;
import com.mollie.mollie.utils.SpeakeasyHTTPClient;

public class Application {
    public static void main(String[] args) {
        SpeakeasyHTTPClient httpClient = new SpeakeasyHTTPClient();
        httpClient.enableDebugLogging(true);

        Client sdk = Client.builder()
            .client(httpClient)
            .build();
    }
}
```
<!-- End Custom HTTP Client [http-client] -->

<!-- Start Debugging [debug] -->
## Debugging

### Debug

You can setup your SDK to emit debug logs for SDK requests and responses.

For request and response logging (especially json bodies), call `enableHTTPDebugLogging(boolean)` on the SDK builder like so:

```java
SDK.builder()
    .enableHTTPDebugLogging(true)
    .build();
```
Example output:
```
Sending request: http://localhost:35123/bearer#global GET
Request headers: {Accept=[application/json], Authorization=[******], Client-Level-Header=[added by client], Idempotency-Key=[some-key], x-speakeasy-user-agent=[speakeasy-sdk/java 0.0.1 internal 0.1.0 org.openapis.openapi]}
Received response: (GET http://localhost:35123/bearer#global) 200
Response headers: {access-control-allow-credentials=[true], access-control-allow-origin=[*], connection=[keep-alive], content-length=[50], content-type=[application/json], date=[Wed, 09 Apr 2025 01:43:29 GMT], server=[gunicorn/19.9.0]}
Response body:
{
  "authenticated": true, 
  "token": "global"
}
```
__WARNING__: This logging should only be used for temporary debugging purposes. Leaving this option on in a production system could expose credentials/secrets in logs. <i>Authorization</i> headers are redacted by default and there is the ability to specify redacted header names via `SpeakeasyHTTPClient.setRedactedHeaders`.

__NOTE__: This is a convenience method that calls `HTTPClient.enableDebugLogging()`. The `SpeakeasyHTTPClient` honors this setting. If you are using a custom HTTP client, it is up to the custom client to honor this setting.


Another option is to set the System property `-Djdk.httpclient.HttpClient.log=all`. However, this second option does not log bodies.
<!-- End Debugging [debug] -->

<!-- Placeholder for Future Speakeasy SDK Sections -->

# Development

## Contributions

While we value open-source contributions to this SDK, this library is generated programmatically. Any manual changes added to internal files will be overwritten on the next generation. 
We look forward to hearing your feedback. Feel free to open a PR or an issue with a proof of concept and we'll do our best to include it in a future release. 

### SDK Created by [Speakeasy](https://www.speakeasy.com/?utm_source=openapi&utm_campaign=java)
