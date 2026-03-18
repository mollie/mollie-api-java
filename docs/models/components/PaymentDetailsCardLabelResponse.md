# PaymentDetailsCardLabelResponse

The card's label, if known.

## Example Usage

```java
import com.mollie.mollie.models.components.PaymentDetailsCardLabelResponse;

PaymentDetailsCardLabelResponse value = PaymentDetailsCardLabelResponse.AMERICAN_EXPRESS;

// Open enum: use .of() to create instances from custom string values
PaymentDetailsCardLabelResponse custom = PaymentDetailsCardLabelResponse.of("custom_value");
```


## Values

| Name               | Value              |
| ------------------ | ------------------ |
| `AMERICAN_EXPRESS` | American Express   |
| `CARTA_SI`         | Carta Si           |
| `CARTE_BLEUE`      | Carte Bleue        |
| `DANKORT`          | Dankort            |
| `DINERS_CLUB`      | Diners Club        |
| `DISCOVER`         | Discover           |
| `JCB`              | JCB                |
| `LASER`            | Laser              |
| `MAESTRO`          | Maestro            |
| `MASTERCARD`       | Mastercard         |
| `UNIONPAY`         | Unionpay           |
| `VISA`             | Visa               |
| `VPAY`             | Vpay               |