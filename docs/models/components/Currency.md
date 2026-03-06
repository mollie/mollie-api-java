# Currency

The balance's ISO 4217 currency code.

## Example Usage

```java
import com.mollie.mollie.models.components.Currency;

Currency value = Currency.EUR;

// Open enum: use .of() to create instances from custom string values
Currency custom = Currency.of("custom_value");
```


## Values

| Name  | Value |
| ----- | ----- |
| `EUR` | EUR   |
| `GBP` | GBP   |
| `CHF` | CHF   |
| `DKK` | DKK   |
| `NOK` | NOK   |
| `PLN` | PLN   |
| `SEK` | SEK   |
| `USD` | USD   |
| `CZK` | CZK   |
| `HUF` | HUF   |
| `AUD` | AUD   |
| `CAD` | CAD   |