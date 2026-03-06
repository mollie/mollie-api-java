# TransferFrequency

The frequency with which the available amount on the balance will be settled to the configured transfer
destination.

Settlements created during weekends or on bank holidays will take place on the next business day.

## Example Usage

```java
import com.mollie.mollie.models.components.TransferFrequency;

TransferFrequency value = TransferFrequency.EVERY_DAY;

// Open enum: use .of() to create instances from custom string values
TransferFrequency custom = TransferFrequency.of("custom_value");
```


## Values

| Name              | Value             |
| ----------------- | ----------------- |
| `EVERY_DAY`       | every-day         |
| `DAILY`           | daily             |
| `EVERY_MONDAY`    | every-monday      |
| `EVERY_TUESDAY`   | every-tuesday     |
| `EVERY_WEDNESDAY` | every-wednesday   |
| `EVERY_THURSDAY`  | every-thursday    |
| `EVERY_FRIDAY`    | every-friday      |
| `MONTHLY`         | monthly           |
| `REVENUE_DAY`     | revenue-day       |
| `NEVER`           | never             |