# WebhookEventTypes

The list of events to enable for this webhook. You may specify `'*'` to add all events, except those
that require explicit selection.

## Example Usage

```java
import com.mollie.mollie.models.components.WebhookEventTypes;

WebhookEventTypes value = WebhookEventTypes.PAYMENT_LINK_PAID;
```


## Values

| Name                                       | Value                                      |
| ------------------------------------------ | ------------------------------------------ |
| `PAYMENT_LINK_PAID`                        | payment-link.paid                          |
| `BALANCE_TRANSACTION_CREATED`              | balance-transaction.created                |
| `SALES_INVOICE_CREATED`                    | sales-invoice.created                      |
| `SALES_INVOICE_ISSUED`                     | sales-invoice.issued                       |
| `SALES_INVOICE_CANCELED`                   | sales-invoice.canceled                     |
| `SALES_INVOICE_PAID`                       | sales-invoice.paid                         |
| `BUSINESS_ACCOUNT_TRANSFER_REQUESTED`      | business-account-transfer.requested        |
| `BUSINESS_ACCOUNT_TRANSFER_INITIATED`      | business-account-transfer.initiated        |
| `BUSINESS_ACCOUNT_TRANSFER_PENDING_REVIEW` | business-account-transfer.pending-review   |
| `BUSINESS_ACCOUNT_TRANSFER_PROCESSED`      | business-account-transfer.processed        |
| `BUSINESS_ACCOUNT_TRANSFER_FAILED`         | business-account-transfer.failed           |
| `BUSINESS_ACCOUNT_TRANSFER_BLOCKED`        | business-account-transfer.blocked          |
| `BUSINESS_ACCOUNT_TRANSFER_RETURNED`       | business-account-transfer.returned         |
| `WILDCARD`                                 | *                                          |