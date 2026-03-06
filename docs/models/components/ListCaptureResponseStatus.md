# ListCaptureResponseStatus

The capture's status.

## Example Usage

```java
import com.mollie.mollie.models.components.ListCaptureResponseStatus;

ListCaptureResponseStatus value = ListCaptureResponseStatus.PENDING;

// Open enum: use .of() to create instances from custom string values
ListCaptureResponseStatus custom = ListCaptureResponseStatus.of("custom_value");
```


## Values

| Name        | Value       |
| ----------- | ----------- |
| `PENDING`   | pending     |
| `SUCCEEDED` | succeeded   |
| `FAILED`    | failed      |