# SettlementRefundStatus

The refund's status. Settlement refunds are normally `refunded`, but can be `failed` if the refund
could not be processed.

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
| `FAILED`   | failed     |