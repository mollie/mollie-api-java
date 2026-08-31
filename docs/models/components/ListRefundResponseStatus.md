# ListRefundResponseStatus

## Example Usage

```java
import com.mollie.mollie.models.components.ListRefundResponseStatus;

ListRefundResponseStatus value = ListRefundResponseStatus.QUEUED;

// Open enum: use .of() to create instances from custom string values
ListRefundResponseStatus custom = ListRefundResponseStatus.of("custom_value");
```


## Values

| Name         | Value        |
| ------------ | ------------ |
| `QUEUED`     | queued       |
| `PENDING`    | pending      |
| `PROCESSING` | processing   |
| `REFUNDED`   | refunded     |
| `FAILED`     | failed       |
| `CANCELED`   | canceled     |