# BalanceTransferPartyTypeResponse

Defines the type of the party. At the moment, only `organization` is supported.

## Example Usage

```java
import com.mollie.mollie.models.components.BalanceTransferPartyTypeResponse;

BalanceTransferPartyTypeResponse value = BalanceTransferPartyTypeResponse.ORGANIZATION;

// Open enum: use .of() to create instances from custom string values
BalanceTransferPartyTypeResponse custom = BalanceTransferPartyTypeResponse.of("custom_value");
```


## Values

| Name           | Value          |
| -------------- | -------------- |
| `ORGANIZATION` | organization   |