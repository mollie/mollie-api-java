# SalesInvoiceEInvoiceStatus

The e-invoice submission status for the invoice, if it was configured to be an e-invoice.

## Example Usage

```java
import com.mollie.mollie.models.components.SalesInvoiceEInvoiceStatus;

SalesInvoiceEInvoiceStatus value = SalesInvoiceEInvoiceStatus.ISSUING;

// Open enum: use .of() to create instances from custom string values
SalesInvoiceEInvoiceStatus custom = SalesInvoiceEInvoiceStatus.of("custom_value");
```


## Values

| Name      | Value     |
| --------- | --------- |
| `ISSUING` | issuing   |
| `ISSUED`  | issued    |
| `FAILED`  | failed    |