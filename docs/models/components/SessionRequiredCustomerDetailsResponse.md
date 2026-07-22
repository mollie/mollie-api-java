# SessionRequiredCustomerDetailsResponse

Customer details that should be collected during checkout.

## Example Usage

```java
import com.mollie.mollie.models.components.SessionRequiredCustomerDetailsResponse;

SessionRequiredCustomerDetailsResponse value = SessionRequiredCustomerDetailsResponse.EMAIL;

// Open enum: use .of() to create instances from custom string values
SessionRequiredCustomerDetailsResponse custom = SessionRequiredCustomerDetailsResponse.of("custom_value");
```


## Values

| Name               | Value              |
| ------------------ | ------------------ |
| `EMAIL`            | email              |
| `BILLING_ADDRESS`  | billing-address    |
| `SHIPPING_ADDRESS` | shipping-address   |