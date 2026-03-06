# SalesInvoiceRecipientLocaleResponse

The locale for the recipient, to be used for translations in PDF generation and payment pages.

## Example Usage

```java
import com.mollie.mollie.models.components.SalesInvoiceRecipientLocaleResponse;

SalesInvoiceRecipientLocaleResponse value = SalesInvoiceRecipientLocaleResponse.EN_US;

// Open enum: use .of() to create instances from custom string values
SalesInvoiceRecipientLocaleResponse custom = SalesInvoiceRecipientLocaleResponse.of("custom_value");
```


## Values

| Name    | Value   |
| ------- | ------- |
| `EN_US` | en_US   |
| `EN_GB` | en_GB   |
| `NLNL`  | nl_NL   |
| `NL_BE` | nl_BE   |
| `DEDE`  | de_DE   |
| `DE_AT` | de_AT   |
| `DE_CH` | de_CH   |
| `FRFR`  | fr_FR   |
| `FR_BE` | fr_BE   |