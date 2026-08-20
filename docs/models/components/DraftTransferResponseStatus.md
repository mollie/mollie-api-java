# DraftTransferResponseStatus

The status of the draft transfer.

## Example Usage

```java
import com.mollie.mollie.models.components.DraftTransferResponseStatus;

DraftTransferResponseStatus value = DraftTransferResponseStatus.PENDING_REVIEW;

// Open enum: use .of() to create instances from custom string values
DraftTransferResponseStatus custom = DraftTransferResponseStatus.of("custom_value");
```


## Values

| Name             | Value            |
| ---------------- | ---------------- |
| `PENDING_REVIEW` | pending-review   |
| `APPROVED`       | approved         |
| `DECLINED`       | declined         |