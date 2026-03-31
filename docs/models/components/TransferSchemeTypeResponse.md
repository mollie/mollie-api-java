# TransferSchemeTypeResponse

The transfer scheme to be used for the transfer. The transfer scheme determines the processing time and method of the transfer.

## Example Usage

```java
import com.mollie.mollie.models.components.TransferSchemeTypeResponse;

TransferSchemeTypeResponse value = TransferSchemeTypeResponse.SEPA_CREDIT_INST;

// Open enum: use .of() to create instances from custom string values
TransferSchemeTypeResponse custom = TransferSchemeTypeResponse.of("custom_value");
```


## Values

| Name               | Value              |
| ------------------ | ------------------ |
| `SEPA_CREDIT_INST` | sepa-credit-inst   |
| `SEPA_CREDIT`      | sepa-credit        |