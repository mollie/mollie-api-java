# RefundResponseStatus

## Example Usage

```java
import com.mollie.mollie.models.components.RefundResponseStatus;

RefundResponseStatus value = RefundResponseStatus.QUEUED;

// Open enum: use .of() to create instances from custom string values
RefundResponseStatus custom = RefundResponseStatus.of("custom_value");
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