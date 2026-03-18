# EntityInvoiceStatus

Status of the invoice.

## Example Usage

```java
import com.mollie.mollie.models.components.EntityInvoiceStatus;

EntityInvoiceStatus value = EntityInvoiceStatus.OPEN;

// Open enum: use .of() to create instances from custom string values
EntityInvoiceStatus custom = EntityInvoiceStatus.of("custom_value");
```


## Values

| Name      | Value     |
| --------- | --------- |
| `OPEN`    | open      |
| `PAID`    | paid      |
| `OVERDUE` | overdue   |