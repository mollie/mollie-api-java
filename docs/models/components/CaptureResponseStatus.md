# CaptureResponseStatus

The capture's status.

## Example Usage

```java
import com.mollie.mollie.models.components.CaptureResponseStatus;

CaptureResponseStatus value = CaptureResponseStatus.PENDING;

// Open enum: use .of() to create instances from custom string values
CaptureResponseStatus custom = CaptureResponseStatus.of("custom_value");
```


## Values

| Name        | Value       |
| ----------- | ----------- |
| `PENDING`   | pending     |
| `SUCCEEDED` | succeeded   |
| `FAILED`    | failed      |