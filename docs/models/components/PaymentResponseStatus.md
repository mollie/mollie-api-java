# PaymentResponseStatus

The payment's status. Refer to the [documentation regarding statuses](https://docs.mollie.com/docs/handling-payment-status) for more info about which
statuses occur at what point.

## Example Usage

```java
import com.mollie.mollie.models.components.PaymentResponseStatus;

PaymentResponseStatus value = PaymentResponseStatus.OPEN;

// Open enum: use .of() to create instances from custom string values
PaymentResponseStatus custom = PaymentResponseStatus.of("custom_value");
```


## Values

| Name         | Value        |
| ------------ | ------------ |
| `OPEN`       | open         |
| `PENDING`    | pending      |
| `AUTHORIZED` | authorized   |
| `PAID`       | paid         |
| `CANCELED`   | canceled     |
| `EXPIRED`    | expired      |
| `FAILED`     | failed       |