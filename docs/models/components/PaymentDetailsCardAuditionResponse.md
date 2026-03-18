# PaymentDetailsCardAuditionResponse

The card's target audience, if known.

## Example Usage

```java
import com.mollie.mollie.models.components.PaymentDetailsCardAuditionResponse;

PaymentDetailsCardAuditionResponse value = PaymentDetailsCardAuditionResponse.CONSUMER;

// Open enum: use .of() to create instances from custom string values
PaymentDetailsCardAuditionResponse custom = PaymentDetailsCardAuditionResponse.of("custom_value");
```


## Values

| Name       | Value      |
| ---------- | ---------- |
| `CONSUMER` | consumer   |
| `BUSINESS` | business   |