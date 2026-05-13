# PayoutStatus

The status of the payout.

## Example Usage

```java
import com.mollie.mollie.models.components.PayoutStatus;

PayoutStatus value = PayoutStatus.REQUESTED;

// Open enum: use .of() to create instances from custom string values
PayoutStatus custom = PayoutStatus.of("custom_value");
```


## Values

| Name                 | Value                |
| -------------------- | -------------------- |
| `REQUESTED`          | requested            |
| `INITIATED`          | initiated            |
| `PROCESSING_AT_BANK` | processing-at-bank   |
| `COMPLETED`          | completed            |
| `FAILED`             | failed               |
| `CANCELED`           | canceled             |