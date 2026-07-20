# ListDraftTransferResponseStatus

The status of the draft transfer.

## Example Usage

```java
import com.mollie.mollie.models.components.ListDraftTransferResponseStatus;

ListDraftTransferResponseStatus value = ListDraftTransferResponseStatus.AWAITING_INITIATION;

// Open enum: use .of() to create instances from custom string values
ListDraftTransferResponseStatus custom = ListDraftTransferResponseStatus.of("custom_value");
```


## Values

| Name                  | Value                 |
| --------------------- | --------------------- |
| `AWAITING_INITIATION` | awaiting-initiation   |
| `INITIATED`           | initiated             |
| `DECLINED`            | declined              |