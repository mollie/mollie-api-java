# CapabilityStatus

## Example Usage

```java
import com.mollie.mollie.models.components.CapabilityStatus;

CapabilityStatus value = CapabilityStatus.UNREQUESTED;

// Open enum: use .of() to create instances from custom string values
CapabilityStatus custom = CapabilityStatus.of("custom_value");
```


## Values

| Name          | Value         |
| ------------- | ------------- |
| `UNREQUESTED` | unrequested   |
| `ENABLED`     | enabled       |
| `DISABLED`    | disabled      |
| `PENDING`     | pending       |