# SubscriptionResponseStatus

The subscription's current status is directly related to the status of the underlying customer or mandate that is
enabling the subscription.

## Example Usage

```java
import com.mollie.mollie.models.components.SubscriptionResponseStatus;

SubscriptionResponseStatus value = SubscriptionResponseStatus.PENDING;

// Open enum: use .of() to create instances from custom string values
SubscriptionResponseStatus custom = SubscriptionResponseStatus.of("custom_value");
```


## Values

| Name        | Value       |
| ----------- | ----------- |
| `PENDING`   | pending     |
| `ACTIVE`    | active      |
| `CANCELED`  | canceled    |
| `SUSPENDED` | suspended   |
| `COMPLETED` | completed   |