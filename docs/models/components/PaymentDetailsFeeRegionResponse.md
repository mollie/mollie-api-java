# PaymentDetailsFeeRegionResponse

The applicable card fee region.

## Example Usage

```java
import com.mollie.mollie.models.components.PaymentDetailsFeeRegionResponse;

PaymentDetailsFeeRegionResponse value = PaymentDetailsFeeRegionResponse.AMERICAN_EXPRESS;

// Open enum: use .of() to create instances from custom string values
PaymentDetailsFeeRegionResponse custom = PaymentDetailsFeeRegionResponse.of("custom_value");
```


## Values

| Name                 | Value                |
| -------------------- | -------------------- |
| `AMERICAN_EXPRESS`   | american-express     |
| `AMEX_INTRA_EEA`     | amex-intra-eea       |
| `CARTE_BANCAIRE`     | carte-bancaire       |
| `INTRA_EU`           | intra-eu             |
| `INTRA_EU_CORPORATE` | intra-eu-corporate   |
| `DOMESTIC`           | domestic             |
| `MAESTRO`            | maestro              |
| `OTHER`              | other                |
| `INTER`              | inter                |
| `INTRA_EEA`          | intra_eea            |