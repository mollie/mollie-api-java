# EntityTerminalStatus

The status of the terminal.

## Example Usage

```java
import com.mollie.mollie.models.components.EntityTerminalStatus;

EntityTerminalStatus value = EntityTerminalStatus.PENDING;

// Open enum: use .of() to create instances from custom string values
EntityTerminalStatus custom = EntityTerminalStatus.of("custom_value");
```


## Values

| Name       | Value      |
| ---------- | ---------- |
| `PENDING`  | pending    |
| `ACTIVE`   | active     |
| `INACTIVE` | inactive   |