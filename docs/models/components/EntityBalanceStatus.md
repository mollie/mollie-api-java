# EntityBalanceStatus

The status of the balance.

## Example Usage

```java
import com.mollie.mollie.models.components.EntityBalanceStatus;

EntityBalanceStatus value = EntityBalanceStatus.ACTIVE;

// Open enum: use .of() to create instances from custom string values
EntityBalanceStatus custom = EntityBalanceStatus.of("custom_value");
```


## Values

| Name       | Value      |
| ---------- | ---------- |
| `ACTIVE`   | active     |
| `INACTIVE` | inactive   |