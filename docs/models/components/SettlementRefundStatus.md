# SettlementRefundStatus

The refund's status. Settlement refunds always have a status of `refunded`.

## Example Usage

```java
import com.mollie.mollie.models.components.SettlementRefundStatus;

SettlementRefundStatus value = SettlementRefundStatus.REFUNDED;

// Open enum: use .of() to create instances from custom string values
SettlementRefundStatus custom = SettlementRefundStatus.of("custom_value");
```


## Values

| Name       | Value      |
| ---------- | ---------- |
| `REFUNDED` | refunded   |