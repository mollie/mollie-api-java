# SalesInvoiceStatusResponse

The current status of the invoice.

## Example Usage

```java
import com.mollie.mollie.models.components.SalesInvoiceStatusResponse;

SalesInvoiceStatusResponse value = SalesInvoiceStatusResponse.DRAFT;

// Open enum: use .of() to create instances from custom string values
SalesInvoiceStatusResponse custom = SalesInvoiceStatusResponse.of("custom_value");
```


## Values

| Name               | Value              |
| ------------------ | ------------------ |
| `DRAFT`            | draft              |
| `ISSUING`          | issuing            |
| `ISSUED`           | issued             |
| `PENDING_PAYMENT`  | pending-payment    |
| `PAID`             | paid               |
| `OVERDUE`          | overdue            |
| `PAYMENT_REVERSED` | payment_reversed   |
| `CANCELLED`        | cancelled          |
| `EXPIRED`          | expired            |
| `FAILED`           | failed             |