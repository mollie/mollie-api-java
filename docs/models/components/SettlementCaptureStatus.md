# SettlementCaptureStatus

The capture's status. Settlement captures always have a status of `succeeded`.

## Example Usage

```java
import com.mollie.mollie.models.components.SettlementCaptureStatus;

SettlementCaptureStatus value = SettlementCaptureStatus.SUCCEEDED;

// Open enum: use .of() to create instances from custom string values
SettlementCaptureStatus custom = SettlementCaptureStatus.of("custom_value");
```


## Values

| Name        | Value       |
| ----------- | ----------- |
| `SUCCEEDED` | succeeded   |