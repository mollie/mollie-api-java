# ReportTypeResponse

The type of report to generate. Determines which other fields the request needs, and which fields show up
on the resulting report.

## Example Usage

```java
import com.mollie.mollie.models.components.ReportTypeResponse;

ReportTypeResponse value = ReportTypeResponse.TRANSACTION_MARGIN;

// Open enum: use .of() to create instances from custom string values
ReportTypeResponse custom = ReportTypeResponse.of("custom_value");
```


## Values

| Name                 | Value                |
| -------------------- | -------------------- |
| `TRANSACTION_MARGIN` | transaction-margin   |