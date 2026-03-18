# TerminalModel

The model of the terminal. For example for a PAX A920, this field's value will be `A920`.

## Example Usage

```java
import com.mollie.mollie.models.components.TerminalModel;

TerminalModel value = TerminalModel.A35;

// Open enum: use .of() to create instances from custom string values
TerminalModel custom = TerminalModel.of("custom_value");
```


## Values

| Name       | Value      |
| ---------- | ---------- |
| `A35`      | A35        |
| `A77`      | A77        |
| `A920`     | A920       |
| `A920_PRO` | A920Pro    |
| `IM30`     | IM30       |
| `TAP`      | Tap        |