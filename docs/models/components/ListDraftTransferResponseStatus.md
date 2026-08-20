# ListDraftTransferResponseStatus

The status of the draft transfer.

## Example Usage

```java
import com.mollie.mollie.models.components.ListDraftTransferResponseStatus;

ListDraftTransferResponseStatus value = ListDraftTransferResponseStatus.PENDING_REVIEW;

// Open enum: use .of() to create instances from custom string values
ListDraftTransferResponseStatus custom = ListDraftTransferResponseStatus.of("custom_value");
```


## Values

| Name             | Value            |
| ---------------- | ---------------- |
| `PENDING_REVIEW` | pending-review   |
| `APPROVED`       | approved         |
| `DECLINED`       | declined         |