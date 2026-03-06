# SalesInvoicePaymentDetailsSourceResponse

The way through which the invoice is to be set to paid.

## Example Usage

```java
import com.mollie.mollie.models.components.SalesInvoicePaymentDetailsSourceResponse;

SalesInvoicePaymentDetailsSourceResponse value = SalesInvoicePaymentDetailsSourceResponse.MANUAL;

// Open enum: use .of() to create instances from custom string values
SalesInvoicePaymentDetailsSourceResponse custom = SalesInvoicePaymentDetailsSourceResponse.of("custom_value");
```


## Values

| Name           | Value          |
| -------------- | -------------- |
| `MANUAL`       | manual         |
| `PAYMENT_LINK` | payment-link   |
| `PAYMENT`      | payment        |