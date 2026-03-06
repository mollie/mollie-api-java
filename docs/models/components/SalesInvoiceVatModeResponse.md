# SalesInvoiceVatModeResponse

The VAT mode to use for VAT calculation. `exclusive` mode means we will apply the relevant VAT on top of the
price. `inclusive` means the prices you are providing to us already contain the VAT you want to apply.

## Example Usage

```java
import com.mollie.mollie.models.components.SalesInvoiceVatModeResponse;

SalesInvoiceVatModeResponse value = SalesInvoiceVatModeResponse.EXCLUSIVE;

// Open enum: use .of() to create instances from custom string values
SalesInvoiceVatModeResponse custom = SalesInvoiceVatModeResponse.of("custom_value");
```


## Values

| Name        | Value       |
| ----------- | ----------- |
| `EXCLUSIVE` | exclusive   |
| `INCLUSIVE` | inclusive   |