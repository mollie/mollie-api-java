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

| Name                                   | Value                                  |
| -------------------------------------- | -------------------------------------- |
| `AMERICAN_EXPRESS`                     | american-express                       |
| `AMEX_INTRA_EEA`                       | amex-intra-eea                         |
| `CARTE_BANCAIRE`                       | carte-bancaire                         |
| `DOMESTIC`                             | domestic                               |
| `INTER`                                | inter                                  |
| `INTRA_EU`                             | intra-eu                               |
| `INTRA_EU_CORPORATE`                   | intra-eu-corporate                     |
| `INTRA_EEA`                            | intra_eea                              |
| `MAESTRO`                              | maestro                                |
| `MASTERCARD_CREDIT_BUSINESS_DOMESTIC`  | mastercard-credit-business-domestic    |
| `MASTERCARD_CREDIT_CONSUMER_DOMESTIC`  | mastercard-credit-consumer-domestic    |
| `MASTERCARD_CREDIT_CONSUMER_INTRA_EEA` | mastercard-credit-consumer-intra-eea   |
| `MASTERCARD_DEBIT_BUSINESS_DOMESTIC`   | mastercard-debit-business-domestic     |
| `MASTERCARD_DEBIT_BUSINESS_INTRA_EEA`  | mastercard-debit-business-intra-eea    |
| `MASTERCARD_DEBIT_CONSUMER_DOMESTIC`   | mastercard-debit-consumer-domestic     |
| `MASTERCARD_DEBIT_CONSUMER_INTRA_EEA`  | mastercard-debit-consumer-intra-eea    |
| `OTHER`                                | other                                  |
| `VISA_CREDIT_BUSINESS_DOMESTIC`        | visa-credit-business-domestic          |
| `VISA_CREDIT_CONSUMER_DOMESTIC`        | visa-credit-consumer-domestic          |
| `VISA_CREDIT_CONSUMER_INTER`           | visa-credit-consumer-inter             |
| `VISA_CREDIT_CONSUMER_INTRA_EEA`       | visa-credit-consumer-intra-eea         |
| `VISA_DEBIT_BUSINESS_DOMESTIC`         | visa-debit-business-domestic           |
| `VISA_DEBIT_BUSINESS_INTRA_EEA`        | visa-debit-business-intra-eea          |
| `VISA_DEBIT_CONSUMER_DOMESTIC`         | visa-debit-consumer-domestic           |