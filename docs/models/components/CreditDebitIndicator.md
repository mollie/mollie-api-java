# CreditDebitIndicator

Indicates whether the transfer is a credit or debit transaction from the perspective of the account holder.

## Example Usage

```java
import com.mollie.mollie.models.components.CreditDebitIndicator;

CreditDebitIndicator value = CreditDebitIndicator.CREDIT;

// Open enum: use .of() to create instances from custom string values
CreditDebitIndicator custom = CreditDebitIndicator.of("custom_value");
```


## Values

| Name     | Value    |
| -------- | -------- |
| `CREDIT` | credit   |
| `DEBIT`  | debit    |