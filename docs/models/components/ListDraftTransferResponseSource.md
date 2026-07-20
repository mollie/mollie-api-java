# ListDraftTransferResponseSource

Whether the draft transfer was created via this API, or created in Mollie Apps.

## Example Usage

```java
import com.mollie.mollie.models.components.ListDraftTransferResponseSource;

ListDraftTransferResponseSource value = ListDraftTransferResponseSource.API;

// Open enum: use .of() to create instances from custom string values
ListDraftTransferResponseSource custom = ListDraftTransferResponseSource.of("custom_value");
```


## Values

| Name         | Value        |
| ------------ | ------------ |
| `API`        | api          |
| `MOLLIE_APP` | mollie-app   |