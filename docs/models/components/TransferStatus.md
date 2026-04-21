# TransferStatus

The status of the transfer.

## Example Usage

```java
import com.mollie.mollie.models.components.TransferStatus;

TransferStatus value = TransferStatus.REQUESTED;

// Open enum: use .of() to create instances from custom string values
TransferStatus custom = TransferStatus.of("custom_value");
```


## Values

| Name             | Value            |
| ---------------- | ---------------- |
| `REQUESTED`      | requested        |
| `INITIATED`      | initiated        |
| `PENDING_REVIEW` | pending-review   |
| `PROCESSED`      | processed        |
| `FAILED`         | failed           |
| `BLOCKED`        | blocked          |
| `RETURNED`       | returned         |