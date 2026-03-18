# PaymentDetailsReceiptCardVerificationMethodResponse

The method used to verify the cardholder's identity.

## Example Usage

```java
import com.mollie.mollie.models.components.PaymentDetailsReceiptCardVerificationMethodResponse;

PaymentDetailsReceiptCardVerificationMethodResponse value = PaymentDetailsReceiptCardVerificationMethodResponse.NO_CVM_REQUIRED;

// Open enum: use .of() to create instances from custom string values
PaymentDetailsReceiptCardVerificationMethodResponse custom = PaymentDetailsReceiptCardVerificationMethodResponse.of("custom_value");
```


## Values

| Name                       | Value                      |
| -------------------------- | -------------------------- |
| `NO_CVM_REQUIRED`          | no-cvm-required            |
| `ONLINE_PIN`               | online-pin                 |
| `OFFLINE_PIN`              | offline-pin                |
| `CONSUMER_DEVICE`          | consumer-device            |
| `SIGNATURE`                | signature                  |
| `SIGNATURE_AND_ONLINE_PIN` | signature-and-online-pin   |
| `ONLINE_PIN_AND_SIGNATURE` | online-pin-and-signature   |
| `NONE`                     | none                       |
| `FAILED`                   | failed                     |