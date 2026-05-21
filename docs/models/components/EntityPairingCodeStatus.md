# EntityPairingCodeStatus

The status of the pairing code.

## Example Usage

```java
import com.mollie.mollie.models.components.EntityPairingCodeStatus;

EntityPairingCodeStatus value = EntityPairingCodeStatus.ACTIVE;

// Open enum: use .of() to create instances from custom string values
EntityPairingCodeStatus custom = EntityPairingCodeStatus.of("custom_value");
```


## Values

| Name      | Value     |
| --------- | --------- |
| `ACTIVE`  | active    |
| `EXPIRED` | expired   |
| `REVOKED` | revoked   |