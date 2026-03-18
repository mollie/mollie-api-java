# WebhookStatus

The subscription's current status.

## Example Usage

```java
import com.mollie.mollie.models.components.WebhookStatus;

WebhookStatus value = WebhookStatus.ENABLED;

// Open enum: use .of() to create instances from custom string values
WebhookStatus custom = WebhookStatus.of("custom_value");
```


## Values

| Name       | Value      |
| ---------- | ---------- |
| `ENABLED`  | enabled    |
| `BLOCKED`  | blocked    |
| `DISABLED` | disabled   |
| `DELETED`  | deleted    |