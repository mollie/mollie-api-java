# PaymentDetailsSellerProtectionResponse

Indicates to what extent the payment is eligible for PayPal's Seller Protection. Only available for PayPal
payments, and if the information is made available by PayPal.

## Example Usage

```java
import com.mollie.mollie.models.components.PaymentDetailsSellerProtectionResponse;

PaymentDetailsSellerProtectionResponse value = PaymentDetailsSellerProtectionResponse.ELIGIBLE;

// Open enum: use .of() to create instances from custom string values
PaymentDetailsSellerProtectionResponse custom = PaymentDetailsSellerProtectionResponse.of("custom_value");
```


## Values

| Name                                    | Value                                   |
| --------------------------------------- | --------------------------------------- |
| `ELIGIBLE`                              | Eligible                                |
| `INELIGIBLE`                            | Ineligible                              |
| `PARTIALLY_ELIGIBLE_INR_ONLY`           | Partially Eligible - INR Only           |
| `PARTIALLY_ELIGIBLE_UNAUTH_ONLY`        | Partially Eligible - Unauth Only        |
| `PARTIALLY_ELIGIBLE`                    | Partially Eligible                      |
| `NONE`                                  | None                                    |
| `ACTIVE`                                | Active                                  |
| `FRAUD_CONTROL_UNAUTH_PREMIUM_ELIGIBLE` | Fraud Control - Unauth Premium Eligible |