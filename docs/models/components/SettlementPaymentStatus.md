# SettlementPaymentStatus

The payment's status. Settlement payments always have a status of `paid`.

## Example Usage

```java
import com.mollie.mollie.models.components.SettlementPaymentStatus;

SettlementPaymentStatus value = SettlementPaymentStatus.PAID;

// Open enum: use .of() to create instances from custom string values
SettlementPaymentStatus custom = SettlementPaymentStatus.of("custom_value");
```


## Values

| Name   | Value  |
| ------ | ------ |
| `PAID` | paid   |