# DraftTransferStatusReasonCodeResponse

A machine-readable code that indicates the reason for the draft transfer's current status.

## Example Usage

```java
import com.mollie.mollie.models.components.DraftTransferStatusReasonCodeResponse;

DraftTransferStatusReasonCodeResponse value = DraftTransferStatusReasonCodeResponse.DELETED_BY_CREATOR;

// Open enum: use .of() to create instances from custom string values
DraftTransferStatusReasonCodeResponse custom = DraftTransferStatusReasonCodeResponse.of("custom_value");
```


## Values

| Name                    | Value                   |
| ----------------------- | ----------------------- |
| `DELETED_BY_CREATOR`    | deleted-by-creator      |
| `DECLINED_BY_INITIATOR` | declined-by-initiator   |
| `ACCOUNT_CLOSED`        | account-closed          |