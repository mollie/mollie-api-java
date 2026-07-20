# DraftTransferResponseStatus

The status of the draft transfer.

## Example Usage

```java
import com.mollie.mollie.models.components.DraftTransferResponseStatus;

DraftTransferResponseStatus value = DraftTransferResponseStatus.AWAITING_INITIATION;

// Open enum: use .of() to create instances from custom string values
DraftTransferResponseStatus custom = DraftTransferResponseStatus.of("custom_value");
```


## Values

| Name                  | Value                 |
| --------------------- | --------------------- |
| `AWAITING_INITIATION` | awaiting-initiation   |
| `INITIATED`           | initiated             |
| `DECLINED`            | declined              |