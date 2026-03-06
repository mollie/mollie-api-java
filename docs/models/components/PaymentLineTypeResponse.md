# PaymentLineTypeResponse

The type of product purchased. For example, a physical or a digital product.

The `tip` payment line type is not available when creating a payment.

## Example Usage

```java
import com.mollie.mollie.models.components.PaymentLineTypeResponse;

PaymentLineTypeResponse value = PaymentLineTypeResponse.PHYSICAL;

// Open enum: use .of() to create instances from custom string values
PaymentLineTypeResponse custom = PaymentLineTypeResponse.of("custom_value");
```


## Values

| Name           | Value          |
| -------------- | -------------- |
| `PHYSICAL`     | physical       |
| `DIGITAL`      | digital        |
| `SHIPPING_FEE` | shipping_fee   |
| `DISCOUNT`     | discount       |
| `STORE_CREDIT` | store_credit   |
| `GIFT_CARD`    | gift_card      |
| `SURCHARGE`    | surcharge      |
| `TIP`          | tip            |