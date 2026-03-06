# EntityWebhookEventWebhookEventTypes

The list of events to enable for this webhook. You may specify `'*'` to add all events, except those
that require explicit selection.

## Example Usage

```java
import com.mollie.mollie.models.components.EntityWebhookEventWebhookEventTypes;

EntityWebhookEventWebhookEventTypes value = EntityWebhookEventWebhookEventTypes.PAYMENT_LINK_PAID;

// Open enum: use .of() to create instances from custom string values
EntityWebhookEventWebhookEventTypes custom = EntityWebhookEventWebhookEventTypes.of("custom_value");
```


## Values

| Name                          | Value                         |
| ----------------------------- | ----------------------------- |
| `PAYMENT_LINK_PAID`           | payment-link.paid             |
| `BALANCE_TRANSACTION_CREATED` | balance-transaction.created   |
| `SALES_INVOICE_CREATED`       | sales-invoice.created         |
| `SALES_INVOICE_ISSUED`        | sales-invoice.issued          |
| `SALES_INVOICE_CANCELED`      | sales-invoice.canceled        |
| `SALES_INVOICE_PAID`          | sales-invoice.paid            |
| `WILDCARD`                    | *                             |