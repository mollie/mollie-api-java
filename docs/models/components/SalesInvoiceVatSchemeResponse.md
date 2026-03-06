# SalesInvoiceVatSchemeResponse

The VAT scheme to create the invoice for. You must be enrolled with One Stop Shop enabled to use it.

## Example Usage

```java
import com.mollie.mollie.models.components.SalesInvoiceVatSchemeResponse;

SalesInvoiceVatSchemeResponse value = SalesInvoiceVatSchemeResponse.STANDARD;

// Open enum: use .of() to create instances from custom string values
SalesInvoiceVatSchemeResponse custom = SalesInvoiceVatSchemeResponse.of("custom_value");
```


## Values

| Name            | Value           |
| --------------- | --------------- |
| `STANDARD`      | standard        |
| `ONE_STOP_SHOP` | one-stop-shop   |