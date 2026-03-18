# BalanceCardRegion

## Example Usage

```java
import com.mollie.mollie.models.components.BalanceCardRegion;

BalanceCardRegion value = BalanceCardRegion.INTRA_EEA;

// Open enum: use .of() to create instances from custom string values
BalanceCardRegion custom = BalanceCardRegion.of("custom_value");
```


## Values

| Name        | Value       |
| ----------- | ----------- |
| `INTRA_EEA` | intra-eea   |
| `INTRA_EU`  | intra-eu    |
| `DOMESTIC`  | domestic    |
| `OTHER`     | other       |