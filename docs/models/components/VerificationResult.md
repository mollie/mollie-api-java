# VerificationResult

The result of the Verification of Payee check.

## Example Usage

```java
import com.mollie.mollie.models.components.VerificationResult;

VerificationResult value = VerificationResult.MATCH;

// Open enum: use .of() to create instances from custom string values
VerificationResult custom = VerificationResult.of("custom_value");
```


## Values

| Name            | Value           |
| --------------- | --------------- |
| `MATCH`         | match           |
| `NO_MATCH`      | no-match        |
| `CLOSE_MATCH`   | close-match     |
| `NOT_AVAILABLE` | not-available   |