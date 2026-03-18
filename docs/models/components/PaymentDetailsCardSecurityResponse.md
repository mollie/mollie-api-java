# PaymentDetailsCardSecurityResponse

The level of security applied during card processing.

## Example Usage

```java
import com.mollie.mollie.models.components.PaymentDetailsCardSecurityResponse;

PaymentDetailsCardSecurityResponse value = PaymentDetailsCardSecurityResponse.NORMAL;

// Open enum: use .of() to create instances from custom string values
PaymentDetailsCardSecurityResponse custom = PaymentDetailsCardSecurityResponse.of("custom_value");
```


## Values

| Name           | Value          |
| -------------- | -------------- |
| `NORMAL`       | normal         |
| `THREEDSECURE` | 3dsecure       |