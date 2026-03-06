# ProfileResponseStatus

The profile status determines whether the profile is able to receive live payments.

* `unverified`: The profile has not been verified yet and can only be used to create test payments.
* `verified`: The profile has been verified and can be used to create live payments and test payments.
* `blocked`: The profile is blocked and can no longer be used or changed.

## Example Usage

```java
import com.mollie.mollie.models.components.ProfileResponseStatus;

ProfileResponseStatus value = ProfileResponseStatus.UNVERIFIED;

// Open enum: use .of() to create instances from custom string values
ProfileResponseStatus custom = ProfileResponseStatus.of("custom_value");
```


## Values

| Name         | Value        |
| ------------ | ------------ |
| `UNVERIFIED` | unverified   |
| `VERIFIED`   | verified     |
| `BLOCKED`    | blocked      |