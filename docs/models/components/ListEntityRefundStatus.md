# ListEntityRefundStatus

## Example Usage

```java
import com.mollie.mollie.models.components.ListEntityRefundStatus;

ListEntityRefundStatus value = ListEntityRefundStatus.QUEUED;

// Open enum: use .of() to create instances from custom string values
ListEntityRefundStatus custom = ListEntityRefundStatus.of("custom_value");
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