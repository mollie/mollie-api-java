# SubscriptionMethod

The payment method used for this subscription. If omitted, any of the customer's valid mandates may be used.

## Example Usage

```java
import com.mollie.mollie.models.components.SubscriptionMethod;

SubscriptionMethod value = SubscriptionMethod.CREDITCARD;
```


## Values

| Name          | Value         |
| ------------- | ------------- |
| `CREDITCARD`  | creditcard    |
| `DIRECTDEBIT` | directdebit   |
| `PAYPAL`      | paypal        |