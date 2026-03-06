# BalancePrepaymentPartType

## Example Usage

```java
import com.mollie.mollie.models.components.BalancePrepaymentPartType;

BalancePrepaymentPartType value = BalancePrepaymentPartType.FEE;

// Open enum: use .of() to create instances from custom string values
BalancePrepaymentPartType custom = BalancePrepaymentPartType.of("custom_value");
```


## Values

| Name                        | Value                       |
| --------------------------- | --------------------------- |
| `FEE`                       | fee                         |
| `FEE_REIMBURSEMENT`         | fee-reimbursement           |
| `FEE_DISCOUNT`              | fee-discount                |
| `FEE_VAT`                   | fee-vat                     |
| `FEE_ROUNDING_COMPENSATION` | fee-rounding-compensation   |