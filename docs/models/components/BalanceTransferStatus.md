# BalanceTransferStatus

The status of the transfer.

## Example Usage

```java
import com.mollie.mollie.models.components.BalanceTransferStatus;

BalanceTransferStatus value = BalanceTransferStatus.CREATED;

// Open enum: use .of() to create instances from custom string values
BalanceTransferStatus custom = BalanceTransferStatus.of("custom_value");
```


## Values

| Name        | Value       |
| ----------- | ----------- |
| `CREATED`   | created     |
| `FAILED`    | failed      |
| `SUCCEEDED` | succeeded   |