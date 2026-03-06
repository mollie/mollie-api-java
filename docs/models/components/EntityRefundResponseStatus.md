# EntityRefundResponseStatus

## Example Usage

```java
import com.mollie.mollie.models.components.EntityRefundResponseStatus;

EntityRefundResponseStatus value = EntityRefundResponseStatus.QUEUED;

// Open enum: use .of() to create instances from custom string values
EntityRefundResponseStatus custom = EntityRefundResponseStatus.of("custom_value");
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