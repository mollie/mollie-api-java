# PayoutStatusReasonCode

A machine-readable code describing the reason for the payout's current status.

## Example Usage

```java
import com.mollie.mollie.models.components.PayoutStatusReasonCode;

PayoutStatusReasonCode value = PayoutStatusReasonCode.REQUESTED;

// Open enum: use .of() to create instances from custom string values
PayoutStatusReasonCode custom = PayoutStatusReasonCode.of("custom_value");
```


## Values

| Name                     | Value                    |
| ------------------------ | ------------------------ |
| `REQUESTED`              | requested                |
| `INITIATED`              | initiated                |
| `PROCESSING_AT_BANK`     | processing_at_bank       |
| `COMPLETED`              | completed                |
| `CANCELED`               | canceled                 |
| `FAILED`                 | failed                   |
| `INSUFFICIENT_FUNDS`     | insufficient_funds       |
| `RETURNED`               | returned                 |
| `INVALID_REQUEST`        | invalid_request          |
| `ORGANIZATION_INACTIVE`  | organization_inactive    |
| `PAYOUTS_BLOCKED`        | payouts_blocked          |
| `BANK_PROCESSING_FAILED` | bank_processing_failed   |
| `BALANCE_NOT_FOUND`      | balance_not_found        |
| `EXPIRED`                | expired                  |