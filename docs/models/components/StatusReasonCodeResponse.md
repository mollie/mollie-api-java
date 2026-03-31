# StatusReasonCodeResponse

A machine-readable code indicating the reason for the transfer's terminal status.

## Example Usage

```java
import com.mollie.mollie.models.components.StatusReasonCodeResponse;

StatusReasonCodeResponse value = StatusReasonCodeResponse.INSUFFICIENT_FUNDS;

// Open enum: use .of() to create instances from custom string values
StatusReasonCodeResponse custom = StatusReasonCodeResponse.of("custom_value");
```


## Values

| Name                 | Value                |
| -------------------- | -------------------- |
| `INSUFFICIENT_FUNDS` | insufficient-funds   |
| `REJECTED`           | rejected             |
| `ERROR`              | error                |