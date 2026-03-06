# CapabilityRequirementStatus

The status of the requirement depends on its due date.
If no due date is given, the status will be `requested`.

## Example Usage

```java
import com.mollie.mollie.models.components.CapabilityRequirementStatus;

CapabilityRequirementStatus value = CapabilityRequirementStatus.CURRENTLY_DUE;

// Open enum: use .of() to create instances from custom string values
CapabilityRequirementStatus custom = CapabilityRequirementStatus.of("custom_value");
```


## Values

| Name            | Value           |
| --------------- | --------------- |
| `CURRENTLY_DUE` | currently-due   |
| `PAST_DUE`      | past-due        |
| `REQUESTED`     | requested       |