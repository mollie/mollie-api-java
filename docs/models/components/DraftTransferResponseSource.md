# DraftTransferResponseSource

Whether the draft transfer was created via this API, or created in Mollie Apps.

## Example Usage

```java
import com.mollie.mollie.models.components.DraftTransferResponseSource;

DraftTransferResponseSource value = DraftTransferResponseSource.API;

// Open enum: use .of() to create instances from custom string values
DraftTransferResponseSource custom = DraftTransferResponseSource.of("custom_value");
```


## Values

| Name         | Value        |
| ------------ | ------------ |
| `API`        | api          |
| `MOLLIE_APP` | mollie-app   |