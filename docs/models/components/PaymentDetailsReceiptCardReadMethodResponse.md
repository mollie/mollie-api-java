# PaymentDetailsReceiptCardReadMethodResponse

The method by which the card was read by the terminal.

## Example Usage

```java
import com.mollie.mollie.models.components.PaymentDetailsReceiptCardReadMethodResponse;

PaymentDetailsReceiptCardReadMethodResponse value = PaymentDetailsReceiptCardReadMethodResponse.CHIP;

// Open enum: use .of() to create instances from custom string values
PaymentDetailsReceiptCardReadMethodResponse custom = PaymentDetailsReceiptCardReadMethodResponse.of("custom_value");
```


## Values

| Name                       | Value                      |
| -------------------------- | -------------------------- |
| `CHIP`                     | chip                       |
| `MAGNETIC_STRIPE`          | magnetic-stripe            |
| `NEAR_FIELD_COMMUNICATION` | near-field-communication   |
| `CONTACTLESS`              | contactless                |
| `MOTO`                     | moto                       |