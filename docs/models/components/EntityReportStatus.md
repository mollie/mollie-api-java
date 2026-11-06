# EntityReportStatus

The report's current status.

## Example Usage

```java
import com.mollie.mollie.models.components.EntityReportStatus;

EntityReportStatus value = EntityReportStatus.PENDING;

// Open enum: use .of() to create instances from custom string values
EntityReportStatus custom = EntityReportStatus.of("custom_value");
```


## Values

| Name        | Value       |
| ----------- | ----------- |
| `PENDING`   | pending     |
| `COMPLETED` | completed   |
| `FAILED`    | failed      |