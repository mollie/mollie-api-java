# GetNextSettlementStatus

The status of the settlement.

## Example Usage

```java
import com.mollie.mollie.models.operations.GetNextSettlementStatus;

GetNextSettlementStatus value = GetNextSettlementStatus.OPEN;

// Open enum: use .of() to create instances from custom string values
GetNextSettlementStatus custom = GetNextSettlementStatus.of("custom_value");
```


## Values

| Name                 | Value                |
| -------------------- | -------------------- |
| `OPEN`               | open                 |
| `PENDING`            | pending              |
| `PROCESSING_AT_BANK` | processing-at-bank   |
| `PAIDOUT`            | paidout              |
| `FAILED`             | failed               |