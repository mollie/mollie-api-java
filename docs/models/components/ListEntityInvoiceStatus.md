# ListEntityInvoiceStatus

Status of the invoice.

## Example Usage

```java
import com.mollie.mollie.models.components.ListEntityInvoiceStatus;

ListEntityInvoiceStatus value = ListEntityInvoiceStatus.OPEN;

// Open enum: use .of() to create instances from custom string values
ListEntityInvoiceStatus custom = ListEntityInvoiceStatus.of("custom_value");
```


## Values

| Name      | Value     |
| --------- | --------- |
| `OPEN`    | open      |
| `PAID`    | paid      |
| `OVERDUE` | overdue   |