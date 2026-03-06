# MandateResponseStatus

The status of the mandate. A status can be `pending` for mandates when the first payment is not yet finalized, or
when we did not received the IBAN yet from the first payment.

## Example Usage

```java
import com.mollie.mollie.models.components.MandateResponseStatus;

MandateResponseStatus value = MandateResponseStatus.VALID;

// Open enum: use .of() to create instances from custom string values
MandateResponseStatus custom = MandateResponseStatus.of("custom_value");
```


## Values

| Name      | Value     |
| --------- | --------- |
| `VALID`   | valid     |
| `PENDING` | pending   |
| `INVALID` | invalid   |