# ProfileReviewStatusResponse

The status of the requested changes.

## Example Usage

```java
import com.mollie.mollie.models.components.ProfileReviewStatusResponse;

ProfileReviewStatusResponse value = ProfileReviewStatusResponse.PENDING;

// Open enum: use .of() to create instances from custom string values
ProfileReviewStatusResponse custom = ProfileReviewStatusResponse.of("custom_value");
```


## Values

| Name       | Value      |
| ---------- | ---------- |
| `PENDING`  | pending    |
| `REJECTED` | rejected   |