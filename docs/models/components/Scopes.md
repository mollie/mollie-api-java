# Scopes

An array defining the eligible use cases for the mandate. For creditcard mandates, this field will always be 
present and can contain one or both of the following values:

## Example Usage

```java
import com.mollie.mollie.models.components.Scopes;

Scopes value = Scopes.CUSTOMER_PRESENT;

// Open enum: use .of() to create instances from custom string values
Scopes custom = Scopes.of("custom_value");
```


## Values

| Name                   | Value                  |
| ---------------------- | ---------------------- |
| `CUSTOMER_PRESENT`     | customer-present       |
| `CUSTOMER_NOT_PRESENT` | customer-not-present   |