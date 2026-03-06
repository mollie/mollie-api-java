# SalesInvoiceRecipientTypeResponse

The type of recipient, either `consumer` or `business`. This will determine what further fields are
required on the `recipient` object.

## Example Usage

```java
import com.mollie.mollie.models.components.SalesInvoiceRecipientTypeResponse;

SalesInvoiceRecipientTypeResponse value = SalesInvoiceRecipientTypeResponse.CONSUMER;

// Open enum: use .of() to create instances from custom string values
SalesInvoiceRecipientTypeResponse custom = SalesInvoiceRecipientTypeResponse.of("custom_value");
```


## Values

| Name       | Value      |
| ---------- | ---------- |
| `CONSUMER` | consumer   |
| `BUSINESS` | business   |