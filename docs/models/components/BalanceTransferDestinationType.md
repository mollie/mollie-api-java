# BalanceTransferDestinationType

The default destination of automatic scheduled transfers. Currently only `bank-account` is supported.

* `bank-account` — Transfer the balance amount to an external bank account

## Example Usage

```java
import com.mollie.mollie.models.components.BalanceTransferDestinationType;

BalanceTransferDestinationType value = BalanceTransferDestinationType.BANK_ACCOUNT;

// Open enum: use .of() to create instances from custom string values
BalanceTransferDestinationType custom = BalanceTransferDestinationType.of("custom_value");
```


## Values

| Name           | Value          |
| -------------- | -------------- |
| `BANK_ACCOUNT` | bank-account   |