# Mode

Whether this entity was created in live mode or in test mode.

## Example Usage

```java
import com.mollie.mollie.models.components.Mode;

Mode value = Mode.LIVE;

// Open enum: use .of() to create instances from custom string values
Mode custom = Mode.of("custom_value");
```


## Values

| Name   | Value  |
| ------ | ------ |
| `LIVE` | live   |
| `TEST` | test   |