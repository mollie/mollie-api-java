# Status

The status of the balance.

## Example Usage

```java
import com.mollie.mollie.models.components.Status;

Status value = Status.ACTIVE;

// Open enum: use .of() to create instances from custom string values
Status custom = Status.of("custom_value");
```


## Values

| Name       | Value      |
| ---------- | ---------- |
| `ACTIVE`   | active     |
| `INACTIVE` | inactive   |