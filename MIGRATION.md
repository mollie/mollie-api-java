# Migrating from `be.woutschoovaerts:mollie` to `com.mollie:mollie`

This guide covers migrating from the legacy community Java client (`be.woutschoovaerts:mollie`, "Mollie API for Java", v4.x) to the official Speakeasy-generated Java SDK (`com.mollie:mollie`).

## Table of contents

- [Why migrate?](#why-migrate)
- [Installation](#installation)
- [Client initialization](#client-initialization)
- [Authentication](#authentication)
- [Resources and methods](#resources-and-methods)
- [Request parameters](#request-parameters)
- [Pagination and listing resources](#pagination-and-listing-resources)
- [Error handling](#error-handling)
- [New features](#new-features)
- [Full resource mapping](#full-resource-mapping)

---

## Why migrate?

Mollie is working towards fully migrating to the new, **automatically generated SDKs**. Unlike our legacy SDKs, which are updated manually, the new SDKs are generated directly from our API specification, making new features and API updates available within 24 hours of changes being released. This ensures that your integration stays up to date with minimal effort and allows you to benefit from the latest version of our product at all times.

Beyond staying up-to-date automatically, `com.mollie:mollie` also provides:

- Complete API coverage, including Accounts, Balances, Delayed Routing, Payouts, Sales Invoices, Sessions, Transfers, Unmatched Credit Transfers, Verify Payee, Webhooks and Webhook Events.
- Unchecked exceptions instead of a single checked `MollieException`, so you no longer need `throws` declarations everywhere.
- Built-in idempotency key support on every mutating request.
- Automatic pagination via `callAsStream()` / `callAsIterable()`, instead of manually following `_links.next`.
- Built-in retry logic with configurable backoff strategies.
- First-class webhook signature validation.
- Full asynchronous support via `CompletableFuture` and Reactive Streams `Publisher`, alongside the synchronous client.
- `profileId` and `testmode` available as global client options regardless of auth type.
- A pre-configured Jackson `ObjectMapper` with strict deserializers, exposed for reuse in your own code.

---

## Installation

Remove the old dependency and add the new one.

Maven:

```xml
<!-- Remove -->
<dependency>
    <groupId>be.woutschoovaerts</groupId>
    <artifactId>mollie</artifactId>
    <version>4.6.3</version>
</dependency>

<!-- Add -->
<dependency>
    <groupId>com.mollie</groupId>
    <artifactId>mollie</artifactId>
    <version>1.8.18</version>
</dependency>
```

Gradle:

```groovy
// Remove
implementation 'be.woutschoovaerts:mollie:4.6.3'

// Add
implementation 'com.mollie:mollie:1.8.18'
```

JDK 11 or later is required for both SDKs.

---

## Client initialization

The old SDK used a builder that only accepted a plain API key or organization token string. The new SDK uses a builder with a `Security` component that supports all authentication schemes.

**Before:**

```java
import be.woutschoovaerts.mollie.Client;
import be.woutschoovaerts.mollie.ClientBuilder;

Client client = new ClientBuilder()
    .withApiKey("test_...")
    .build();
```

**After:**

```java
import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;

Client sdk = Client.builder()
    .security(Security.builder()
        .apiKey("test_...")
        .build())
    .build();
```

---

## Authentication

### API key

```
-Client client = new ClientBuilder()
-    .withApiKey("test_...")
-    .build();
+Client sdk = Client.builder()
+    .security(Security.builder()
+        .apiKey("test_...")
+        .build())
+    .build();
```

### Advanced Access Token

The old SDK called this an "organization token", set either at build time or afterwards on the client instance. The new SDK calls it an `advancedAccessToken` and it is only ever set through `Security`.

```
-Client client = new ClientBuilder()
-    .withApiKey("test_...")
-    .withOrganizationToken("access_...")
-    .build();
-// or at runtime:
-client.setAccessToken("access_...");
-client.revokeAccessToken();
+Client sdk = Client.builder()
+    .security(Security.builder()
+        .advancedAccessToken("access_...")
+        .build())
+    .build();
```

### OAuth token

The old SDK had no dedicated OAuth security scheme on the client. You exchanged an authorization code for an access token yourself via `client.oAuth().generateTokens(...)`, then fed the resulting token into `setAccessToken(...)`. The new SDK exposes `oAuth` as a first-class client security scheme:

```java
import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;

Client sdk = Client.builder()
    .security(Security.builder()
        .oAuth("Bearer eyJ...")
        .build())
    .build();
```

Token exchange itself is now a regular resource call instead of a bespoke handler method:

```
-TokenResponse tokens = client.oAuth().generateTokens(clientId, clientSecret, TokenRequest.builder()
-    .grantType(GrantType.AUTHORIZATION_CODE)
-    .code("auth_...")
-    .redirectUri("https://example.com/redirect")
-    .build());
+OauthGenerateTokensResponse res = sdk.oauth().generate()
+    .security(OauthGenerateTokensSecurity.builder()
+        .username(clientId)
+        .password(clientSecret)
+        .build())
+    .requestBody(OauthGenerateTokensRequestBody.builder()
+        .grantType(OauthGrantType.AUTHORIZATION_CODE)
+        .code("auth_...")
+        .redirectUri("https://example.com/redirect")
+        .build())
+    .call();
```

### Global defaults (`profileId`, `testmode`)

In the old SDK, `enableTestMode()` / `disableTestMode()` toggled test mode when using an organization token with no built-in concept of a global `profileId` — you had to add it manually to `QueryParams` on every call. In the new SDK, both `profileId` and `testmode` are configured once on the client and apply to every request that supports them:

```
-Client client = new ClientBuilder()
-    .withApiKey("test_...")
-    .withOrganizationToken("access_...")
-    .withTestMode(true)
-    .build();
+Client sdk = Client.builder()
+    .security(Security.builder()
+        .advancedAccessToken("access_...")
+        .build())
+    .testmode(true)
+    .profileId("pfl_...")
+    .build();
```

---

## Resources and methods

### Fluent request builders replace handler getters + POJO arguments

The old SDK exposed a handler per resource (`client.payments()`, `client.customers()`, ...); each handler method took the request body and/or a `QueryParams` map directly as arguments and returned the response model, throwing a checked `MollieException` on failure. The new SDK exposes a resource object per domain; each operation starts a fluent request builder on which you set path parameters, the request body, and per-call options, then execute it with `.call()`. The response comes back wrapped in an operation-specific envelope (for example `CreatePaymentResponse`), which exposes the actual model through an `Optional` accessor (for example `.paymentResponse()`).

```
-PaymentRequest body = PaymentRequest.builder()
-    .amount(new Amount("EUR", "10.00"))
-    .description("Order #478")
-    .redirectUrl("https://example.com/redirect")
-    .build();
-PaymentResponse payment = client.payments().createPayment(body);
+CreatePaymentResponse res = sdk.payments().create()
+    .paymentRequest(PaymentRequest.builder()
+        .amount(Amount.builder().currency("EUR").value("10.00").build())
+        .description("Order #478")
+        .redirectUrl("https://example.com/redirect")
+        .build())
+    .call();
+PaymentResponse payment = res.paymentResponse().orElseThrow();
```

```
-PaymentResponse payment = client.payments().getPayment("tr_WDqYK6vllg");
+GetPaymentResponse res = sdk.payments().get()
+    .request(GetPaymentRequest.builder()
+        .paymentId("tr_WDqYK6vllg")
+        .build())
+    .call();
+PaymentResponse payment = res.paymentResponse().orElseThrow();
```

### Update

```
-PaymentResponse payment = client.payments().updatePayment("tr_...",
-    UpdatePaymentRequest.builder()
-        .description("New description")
-        .build());
+UpdatePaymentResponse res = sdk.payments().update()
+    .paymentId("tr_...")
+    .requestBody(UpdatePaymentRequestBody.builder()
+        .description("New description")
+        .build())
+    .call();
```

### Cancel / delete

```
-client.payments().cancelPayment("tr_...");
+CancelPaymentResponse res = sdk.payments().cancel()
+    .paymentId("tr_...")
+    .call();
```

### Checked exceptions removed

Every method in the old SDK declared `throws MollieException`, forcing a `try`/`catch` or a `throws` clause at every call site — even when you had no way to recover locally. In the new SDK, `ClientError` (the base error type) and its subclasses extend `RuntimeException`, so you only catch them where you actually want to handle a failure.

```
-public PaymentResponse charge(String id) throws MollieException {
-    return client.payments().getPayment(id);
-}
+public PaymentResponse charge(String id) {
+    return sdk.payments().get()
+        .request(GetPaymentRequest.builder().paymentId(id).build())
+        .call()
+        .paymentResponse()
+        .orElseThrow();
+}
```

### Nested resources

The old SDK had a mix of dedicated nested handlers (`client.customers().createCustomerPayment(...)`) and flat handlers that took a parent ID as their first argument (`client.refunds().createRefund(paymentId, ...)`). In the new SDK, nested operations are consistently methods on the parent resource, with the parent ID set as a builder field:

| Old | New |
| --- | --- |
| `client.customers().createCustomerPayment(customerId, body)` | `client.customers().createPayment().customerId(customerId).paymentRequest(...).call()` |
| `client.customers().listCustomerPayments(customerId)` | `client.customers().listPayments().customerId(customerId).call()` |
| `client.mandates().createMandate(customerId, body)` | `client.mandates().create().customerId(customerId).mandateRequest(...).call()` |
| `client.mandates().listMandates(customerId)` | `client.mandates().list().customerId(customerId).call()` |
| `client.mandates().revokeMandate(customerId, mandateId)` | `client.mandates().revoke().customerId(customerId).mandateId(mandateId).call()` |
| `client.subscriptions().createSubscription(customerId, body)` | `client.subscriptions().create().customerId(customerId).subscriptionRequest(...).call()` |
| `client.subscriptions().listAllSubscriptions()` | `client.subscriptions().all().call()` |
| `client.subscriptions().listSubscriptionPayments(customerId, subscriptionId)` | `client.subscriptions().listPayments().customerId(customerId).subscriptionId(subscriptionId).call()` |
| `client.refunds().createRefund(paymentId, body)` | `client.refunds().create().paymentId(paymentId).refundRequest(...).call()` |
| `client.chargebacks().listChargebacks(paymentId)` | `client.chargebacks().list().paymentId(paymentId).call()` |
| `client.captures().createCapture(paymentId, body)` | `client.captures().create().paymentId(paymentId).captureRequest(...).call()` |
| `client.settlements().getSettlementPayments(settlementId)` | `client.settlements().listPayments().settlementId(settlementId).call()` |
| `client.settlements().getSettlementRefund(settlementId)` | `client.settlements().listRefunds().settlementId(settlementId).call()` |
| `client.settlements().getSettlementCaptures(settlementId)` | `client.settlements().listCaptures().settlementId(settlementId).call()` |
| `client.settlements().getSettlementChargebacks(settlementId)` | `client.settlements().listChargebacks().settlementId(settlementId).call()` |
| `client.wallet().requestApplePaySession(body)` | `client.wallets().requestApplePaySession().applePaySessionRequest(...).call()` |

---

## Request parameters

### Idempotency key

The old SDK didn't expose per-request idempotency keys. The new SDK accepts `idempotencyKey` as a builder option on every mutating request:

```java
CreatePaymentResponse res = sdk.payments().create()
    .idempotencyKey("123e4567-e89b-12d3-a456-426614174000")
    .paymentRequest(PaymentRequest.builder()
        .description("My first payment")
        .redirectUrl("https://example.org/redirect")
        .amount(Amount.builder().currency("EUR").value("10.00").build())
        .build())
    .call();
```

### `testmode` and `profileId` per request

These can be overridden per request even when defaults are set on the client:

```java
CreatePaymentResponse res = sdk.payments().create()
    .paymentRequest(PaymentRequest.builder()
        .testmode(false)
        .profileId("pfl_other")
        .description("My first payment")
        .redirectUrl("https://example.org/redirect")
        .amount(Amount.builder().currency("EUR").value("10.00").build())
        .build())
    .call();
```

---

## Pagination and listing resources

### Old SDK — manual `Pagination<T>`

The old SDK returned a `Pagination<T>` wrapper (`count`, `_embedded`, `_links`) from every list method. There was no built-in way to fetch the next page — you had to inspect `_links.next` yourself and issue a new call with the right `from` / `limit` query parameters:

```java
Pagination<PaymentListResponse> page = client.payments().listPayments();
System.out.println(page.getCount());

if (page.getLinks().getNext() != null) {
    // manually parse the next link's query string and call listPayments(QueryParams) again
}
```

### New SDK — `callAsStream()` / `callAsIterable()` auto-paginate

`list()` returns a request builder that can be executed with `callAsStream()` or `callAsIterable()`, both of which follow pagination automatically:

```java
sdk.payments().list()
    .from("tr_5B8cwPMGnU")
    .limit(50L)
    .callAsStream()
    .forEach(page -> {
        // handle page
    });
```

```java
Iterable<ListPaymentsResponse> pages = sdk.payments().list().callAsIterable();
for (ListPaymentsResponse page : pages) {
    // handle page
}
```

An asynchronous client is also available for pagination, returning a `Flow.Publisher<T>` via `callAsPublisher()`. See New features below.

---

## Error handling

Because `ClientError` is unchecked, you no longer need a `throws MollieException` clause on every method that calls the SDK — only wrap calls in `try`/`catch` where you actually want to react to a failure.

### Old SDK — `MollieException`

```java
try {
    PaymentResponse payment = client.payments().getPayment("invalid");
} catch (MollieException ex) {
    System.out.println(ex.getMessage());
    System.out.println(ex.getDetails()); // raw response details, if any
}
```

### New SDK — `ClientError` / `ErrorResponse` / `APIException`

```java
import com.mollie.mollie.models.errors.ClientError;
import com.mollie.mollie.models.errors.ErrorResponse;

try {
    GetPaymentResponse res = sdk.payments().get()
        .request(GetPaymentRequest.builder().paymentId("invalid").build())
        .call();
} catch (ClientError ex) { // all SDK exceptions inherit from ClientError (a RuntimeException)
    int statusCode = ex.code();
    var headers = ex.headers();
    var responseBody = ex.body();

    if (ex instanceof ErrorResponse) {
        ErrorResponse e = (ErrorResponse) ex;
        e.data().ifPresent(payload -> {
            long status = payload.status();
            String title = payload.title();
            String detail = payload.detail();
        });
    }
}
```

---

## New features

### Webhook signature validation

```java
import com.mollie.mollie.utils.webhooks.InvalidSignatureException;
import com.mollie.mollie.utils.webhooks.SignatureValidator;
import java.util.Collections;

SignatureValidator validator = new SignatureValidator(System.getenv("MOLLIE_WEBHOOK_SECRET"));

try {
    boolean isVerified = validator.validatePayload(rawBody, Collections.singletonList(signatureHeader));
    if (!isVerified) {
        // no signature header was provided; treat as a legacy webhook
    }
} catch (InvalidSignatureException exception) {
    // reject the request
}
```

### Asynchronous support

The old SDK was synchronous only. The new SDK also ships an `AsyncClient` that returns `CompletableFuture<T>` for standard operations, and Reactive Streams `Publisher<T>` for paginated operations:

```java
import com.mollie.mollie.AsyncClient;
import com.mollie.mollie.Client;
import java.util.concurrent.CompletableFuture;

AsyncClient sdk = Client.builder()
    .security(Security.builder().apiKey("test_...").build())
    .build()
    .async();

CompletableFuture<CreatePaymentResponse> future = sdk.payments().create()
    .paymentRequest(PaymentRequest.builder()
        .amount(Amount.builder().currency("EUR").value("10.00").build())
        .description("Order #478")
        .redirectUrl("https://example.com/redirect")
        .build())
    .call();

future.thenAccept(res -> res.paymentResponse().ifPresent(System.out::println));
```

### Retries

```java
import com.mollie.mollie.utils.BackoffStrategy;
import com.mollie.mollie.utils.RetryConfig;
import java.util.concurrent.TimeUnit;

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
    .build();
```

Retry behaviour can also be overridden per operation via `.retryConfig(...)` on the request builder.

### Custom HTTP client and debugging

```java
import com.mollie.mollie.utils.SpeakeasyHTTPClient;

SpeakeasyHTTPClient httpClient = new SpeakeasyHTTPClient();
httpClient.enableDebugLogging(true);

Client sdk = Client.builder()
    .client(httpClient)
    .build();
```

The `HTTPClient` interface can also be implemented from scratch to add custom headers, executors, or SSL configuration.

### Jackson configuration

The SDK ships a pre-configured `ObjectMapper` accessible via `JSON.getMapper()`, and a `MollieJacksonModule` you can register on your own mapper for full compatibility:

```java
import com.mollie.mollie.utils.MollieJacksonModule;
import com.fasterxml.jackson.databind.ObjectMapper;

ObjectMapper myMapper = new ObjectMapper()
    .registerModule(new MollieJacksonModule());
```

---

## Full resource mapping

### Resources available in both SDKs

| Old (`client.`) | New (`sdk.`) |
| --- | --- |
| `payments()` | `payments()` |
| `refunds()` (top-level, `paymentId` as arg) | `refunds()` (pass `paymentId` on the builder) |
| `chargebacks()` (top-level, `paymentId` as arg) | `chargebacks()` (pass `paymentId` on the builder) |
| `captures()` (top-level, `paymentId` as arg) | `captures()` (pass `paymentId` on the builder) |
| `methods()` | `methods()` |
| `customers()` | `customers()` |
| `mandates()` (nested under `customers()` args) | `mandates()` (pass `customerId` on the builder) |
| `subscriptions()` (nested under `customers()` args) | `subscriptions()` (pass `customerId` on the builder) |
| `settlements()` | `settlements()` |
| `profiles()` | `profiles()` |
| `organizations()` | `organizations()` |
| `permissions()` | `permissions()` |
| `onboarding()` | `onboarding()` |
| `terminals()` | `terminals()` |
| `paymentLinks()` | `paymentLinks()` |
| `clients()` | `clients()` |
| `clientLinks()` | `clientLinks()` |
| `invoices()` | `invoices()` |
| `oAuth()` | `oauth()` |
| `wallet()` | `wallets()` |
| `balances()` | `balances()` |
| `orders()` (deprecated) | not available — replaced by [Payment Links](https://docs.mollie.com/reference/v2/payment-links-api/create-payment-link) and standard Payments |
| `shipments()` (deprecated) | not available |

### Resources available only in the new SDK

| New (`sdk.`) | Description |
| --- | --- |
| `accounts()` | Business account management |
| `balanceTransfers()` | Connect balance transfers |
| `capabilities()` | List capabilities |
| `delayedRouting()` | Delayed payment routing rules |
| `payouts()` | Payout management |
| `salesInvoices()` | Sales invoice management |
| `sessions()` | Payment sessions |
| `transfers()` | Transfer management |
| `unmatchedCreditTransfers()` | Unmatched credit transfer handling |
| `verifyPayee()` | Payee verification |
| `webhooks()` | Webhook management |
| `webhookEvents()` | Webhook event retrieval |

For a complete list of all resources and operations with usage examples, see the [Available Resources and Operations](https://github.com/mollie/mollie-api-java#available-resources-and-operations) section in the SDK's README.
