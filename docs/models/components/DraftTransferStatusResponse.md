# DraftTransferStatusResponse

The status of the draft transfer.

## Example Usage

```java
import com.mollie.mollie.models.components.DraftTransferStatusResponse;

DraftTransferStatusResponse value = DraftTransferStatusResponse.AWAITING_INITIATION;

// Open enum: use .of() to create instances from custom string values
DraftTransferStatusResponse custom = DraftTransferStatusResponse.of("custom_value");
```


## Values

| Name                  | Value                 |
| --------------------- | --------------------- |
| `AWAITING_INITIATION` | awaiting-initiation   |
| `INITIATED`           | initiated             |
| `DECLINED`            | declined              |