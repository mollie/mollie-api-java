# ListEntitySettlementStatus

The status of the settlement.

## Example Usage

```java
import com.mollie.mollie.models.components.ListEntitySettlementStatus;

ListEntitySettlementStatus value = ListEntitySettlementStatus.OPEN;

// Open enum: use .of() to create instances from custom string values
ListEntitySettlementStatus custom = ListEntitySettlementStatus.of("custom_value");
```


## Values

| Name      | Value     |
| --------- | --------- |
| `OPEN`    | open      |
| `PENDING` | pending   |
| `PAIDOUT` | paidout   |
| `FAILED`  | failed    |