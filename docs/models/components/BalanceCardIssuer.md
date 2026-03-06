# BalanceCardIssuer

## Example Usage

```java
import com.mollie.mollie.models.components.BalanceCardIssuer;

BalanceCardIssuer value = BalanceCardIssuer.AMEX;

// Open enum: use .of() to create instances from custom string values
BalanceCardIssuer custom = BalanceCardIssuer.of("custom_value");
```


## Values

| Name             | Value            |
| ---------------- | ---------------- |
| `AMEX`           | amex             |
| `MAESTRO`        | maestro          |
| `CARTE_BANCAIRE` | carte-bancaire   |
| `OTHER`          | other            |