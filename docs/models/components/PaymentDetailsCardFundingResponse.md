# PaymentDetailsCardFundingResponse

The card type.

## Example Usage

```java
import com.mollie.mollie.models.components.PaymentDetailsCardFundingResponse;

PaymentDetailsCardFundingResponse value = PaymentDetailsCardFundingResponse.DEBIT;

// Open enum: use .of() to create instances from custom string values
PaymentDetailsCardFundingResponse custom = PaymentDetailsCardFundingResponse.of("custom_value");
```


## Values

| Name             | Value            |
| ---------------- | ---------------- |
| `DEBIT`          | debit            |
| `CREDIT`         | credit           |
| `PREPAID`        | prepaid          |
| `DEFERRED_DEBIT` | deferred-debit   |