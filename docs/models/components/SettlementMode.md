# SettlementMode

Whether this entity was created in live mode or in test mode. Settlements are always in live mode.

## Example Usage

```java
import com.mollie.mollie.models.components.SettlementMode;

SettlementMode value = SettlementMode.LIVE;

// Open enum: use .of() to create instances from custom string values
SettlementMode custom = SettlementMode.of("custom_value");
```


## Values

| Name   | Value  |
| ------ | ------ |
| `LIVE` | live   |