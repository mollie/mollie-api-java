# Action

The action performed on the unmatched credit transfer.

## Example Usage

```java
import com.mollie.mollie.models.components.Action;

Action value = Action.MATCH;

// Open enum: use .of() to create instances from custom string values
Action custom = Action.of("custom_value");
```


## Values

| Name     | Value    |
| -------- | -------- |
| `MATCH`  | match    |
| `RETURN` | return   |