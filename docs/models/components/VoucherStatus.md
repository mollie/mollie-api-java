# VoucherStatus

The status of the issuer.
If the status is `pending-issuer`, an additional action from your side may be required with the issuer.

## Example Usage

```java
import com.mollie.mollie.models.components.VoucherStatus;

VoucherStatus value = VoucherStatus.ACTIVATED;

// Open enum: use .of() to create instances from custom string values
VoucherStatus custom = VoucherStatus.of("custom_value");
```


## Values

| Name             | Value            |
| ---------------- | ---------------- |
| `ACTIVATED`      | activated        |
| `PENDING_ISSUER` | pending-issuer   |