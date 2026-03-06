# MethodStatus

The payment method's activation status for this profile.

## Example Usage

```java
import com.mollie.mollie.models.components.MethodStatus;

MethodStatus value = MethodStatus.ACTIVATED;

// Open enum: use .of() to create instances from custom string values
MethodStatus custom = MethodStatus.of("custom_value");
```


## Values

| Name               | Value              |
| ------------------ | ------------------ |
| `ACTIVATED`        | activated          |
| `PENDING_BOARDING` | pending-boarding   |
| `PENDING_REVIEW`   | pending-review     |
| `PENDING_EXTERNAL` | pending-external   |
| `REJECTED`         | rejected           |