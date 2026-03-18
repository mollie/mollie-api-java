# OrganizationVatRegulation

Mollie applies Dutch VAT for merchants based in The Netherlands, British VAT for merchants based in The United
Kingdom, and shifted VAT for merchants in the European Union.

The field is not present for merchants residing in other countries.

## Example Usage

```java
import com.mollie.mollie.models.components.OrganizationVatRegulation;

OrganizationVatRegulation value = OrganizationVatRegulation.DUTCH;

// Open enum: use .of() to create instances from custom string values
OrganizationVatRegulation custom = OrganizationVatRegulation.of("custom_value");
```


## Values

| Name      | Value     |
| --------- | --------- |
| `DUTCH`   | dutch     |
| `BRITISH` | british   |
| `SHIFTED` | shifted   |