# SalesInvoicePaymentTermResponse

The payment term to be set on the invoice.

## Example Usage

```java
import com.mollie.mollie.models.components.SalesInvoicePaymentTermResponse;

SalesInvoicePaymentTermResponse value = SalesInvoicePaymentTermResponse.SEVENDAYS;

// Open enum: use .of() to create instances from custom string values
SalesInvoicePaymentTermResponse custom = SalesInvoicePaymentTermResponse.of("custom_value");
```


## Values

| Name                         | Value                        |
| ---------------------------- | ---------------------------- |
| `SEVENDAYS`                  | 7 days                       |
| `FOURTEENDAYS`               | 14 days                      |
| `THIRTYDAYS`                 | 30 days                      |
| `FORTY_FIVEDAYS`             | 45 days                      |
| `SIXTYDAYS`                  | 60 days                      |
| `NINETYDAYS`                 | 90 days                      |
| `ONE_HUNDRED_AND_TWENTYDAYS` | 120 days                     |