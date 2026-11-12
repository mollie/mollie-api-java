# ReportStatusReasonCode

A machine-readable code for the failure reason.

## Example Usage

```java
import com.mollie.mollie.models.components.ReportStatusReasonCode;

ReportStatusReasonCode value = ReportStatusReasonCode.GENERATION_FAILED;

// Open enum: use .of() to create instances from custom string values
ReportStatusReasonCode custom = ReportStatusReasonCode.of("custom_value");
```


## Values

| Name                       | Value                      |
| -------------------------- | -------------------------- |
| `GENERATION_FAILED`        | generation-failed          |
| `EMPTY_REPORT`             | empty-report               |
| `REPORT_VALIDATION_FAILED` | report-validation-failed   |