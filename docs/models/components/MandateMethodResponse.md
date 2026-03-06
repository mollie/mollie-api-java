# MandateMethodResponse

Payment method of the mandate.

SEPA Direct Debit and PayPal mandates can be created directly.

## Example Usage

```java
import com.mollie.mollie.models.components.MandateMethodResponse;

MandateMethodResponse value = MandateMethodResponse.CREDITCARD;

// Open enum: use .of() to create instances from custom string values
MandateMethodResponse custom = MandateMethodResponse.of("custom_value");
```


## Values

| Name          | Value         |
| ------------- | ------------- |
| `CREDITCARD`  | creditcard    |
| `DIRECTDEBIT` | directdebit   |
| `PAYPAL`      | paypal        |