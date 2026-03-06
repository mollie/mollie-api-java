# EntitySettlementStatus

The status of the settlement.

## Example Usage

```java
import com.mollie.mollie.models.components.EntitySettlementStatus;

EntitySettlementStatus value = EntitySettlementStatus.OPEN;

// Open enum: use .of() to create instances from custom string values
EntitySettlementStatus custom = EntitySettlementStatus.of("custom_value");
```


## Values

| Name      | Value     |
| --------- | --------- |
| `OPEN`    | open      |
| `PENDING` | pending   |
| `PAIDOUT` | paidout   |
| `FAILED`  | failed    |