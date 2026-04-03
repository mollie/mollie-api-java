# UnmatchedCreditTransferStatus

## Example Usage

```java
import com.mollie.mollie.models.components.UnmatchedCreditTransferStatus;

UnmatchedCreditTransferStatus value = UnmatchedCreditTransferStatus.RECEIVED;

// Open enum: use .of() to create instances from custom string values
UnmatchedCreditTransferStatus custom = UnmatchedCreditTransferStatus.of("custom_value");
```


## Values

| Name       | Value      |
| ---------- | ---------- |
| `RECEIVED` | received   |
| `MATCHED`  | matched    |
| `RETURNED` | returned   |
| `EXPIRED`  | expired    |