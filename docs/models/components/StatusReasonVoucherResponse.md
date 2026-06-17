# StatusReasonVoucherResponse

## Example Usage

```java
import com.mollie.mollie.models.components.StatusReasonVoucherResponse;

StatusReasonVoucherResponse value = StatusReasonVoucherResponse.SERVICE_FAILED;

// Open enum: use .of() to create instances from custom string values
StatusReasonVoucherResponse custom = StatusReasonVoucherResponse.of("custom_value");
```


## Values

| Name                            | Value                           |
| ------------------------------- | ------------------------------- |
| `SERVICE_FAILED`                | service_failed                  |
| `INVALID_OPERATION`             | invalid_operation               |
| `AUTHORIZATION_ERROR`           | authorization_error             |
| `LOGIN_FAILED_WITHOUT_REASON`   | login_failed_without_reason     |
| `INVALID_RETAILER`              | invalid_retailer                |
| `REFER_TO_CARD_ISSUER`          | refer_to_card_issuer            |
| `CARD_DOES_NOT_EXIST`           | card_does_not_exist             |
| `EXPIRED_CARD`                  | expired_card                    |
| `CARD_IS_BLOCKED`               | card_is_blocked                 |
| `INSUFFICIENT_FUNDS`            | insufficient_funds              |
| `INVALID_CARD_ID`               | invalid_card_id                 |
| `CARD_IS_TRANSFERRED`           | card_is_transferred             |
| `CARD_IS_NOT_ACTIVE`            | card_is_not_active              |
| `INCORRECT_PURCHASE_VALUE`      | incorrect_purchase_value        |
| `CARD_NOT_AVAILABLE`            | card_not_available              |
| `WRONG_CURRENCY`                | wrong_currency                  |
| `LOGIN_FAILED_UNKNOWN_USER`     | login_failed_unknown_user       |
| `LOGIN_FAILED_INVALID_PASSWORD` | login_failed_invalid_password   |
| `INVALID_PIN`                   | invalid_pin                     |
| `INVALID_EAN_CODE`              | invalid_ean_code                |