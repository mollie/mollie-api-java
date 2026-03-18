# EntityOnboardingStatusStatus

The current status of the organization's onboarding process.

## Example Usage

```java
import com.mollie.mollie.models.components.EntityOnboardingStatusStatus;

EntityOnboardingStatusStatus value = EntityOnboardingStatusStatus.NEEDS_DATA;

// Open enum: use .of() to create instances from custom string values
EntityOnboardingStatusStatus custom = EntityOnboardingStatusStatus.of("custom_value");
```


## Values

| Name         | Value        |
| ------------ | ------------ |
| `NEEDS_DATA` | needs-data   |
| `IN_REVIEW`  | in-review    |
| `COMPLETED`  | completed    |