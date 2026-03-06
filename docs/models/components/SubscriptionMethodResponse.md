# SubscriptionMethodResponse

The payment method used for this subscription. If omitted, any of the customer's valid mandates may be used.

## Example Usage

```java
import com.mollie.mollie.models.components.SubscriptionMethodResponse;

SubscriptionMethodResponse value = SubscriptionMethodResponse.CREDITCARD;

// Open enum: use .of() to create instances from custom string values
SubscriptionMethodResponse custom = SubscriptionMethodResponse.of("custom_value");
```


## Values

| Name          | Value         |
| ------------- | ------------- |
| `CREDITCARD`  | creditcard    |
| `DIRECTDEBIT` | directdebit   |
| `PAYPAL`      | paypal        |