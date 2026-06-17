# StatusReasonMerchantResponse

## Example Usage

```java
import com.mollie.mollie.models.components.StatusReasonMerchantResponse;

StatusReasonMerchantResponse value = StatusReasonMerchantResponse.MERCHANT_ID_NOT_FOUND;

// Open enum: use .of() to create instances from custom string values
StatusReasonMerchantResponse custom = StatusReasonMerchantResponse.of("custom_value");
```


## Values

| Name                                    | Value                                   |
| --------------------------------------- | --------------------------------------- |
| `MERCHANT_ID_NOT_FOUND`                 | merchant_id_not_found                   |
| `MERCHANT_ACCOUNT_CLOSED`               | merchant_account_closed                 |
| `TERMINAL_ID_NOT_FOUND`                 | terminal_id_not_found                   |
| `TERMINAL_CLOSED`                       | terminal_closed                         |
| `INVALID_CATEGORY_CODE`                 | invalid_category_code                   |
| `INVALID_CURRENCY`                      | invalid_currency                        |
| `MISSING_CVV2_CVC2`                     | missing_cvv2_cvc2                       |
| `CVV2_NOT_ALLOWED`                      | cvv2_not_allowed                        |
| `MERCHANT_NOT_REGISTERED_VBV`           | merchant_not_registered_vbv             |
| `MERCHANT_NOT_REGISTERED_FOR_AMEX`      | merchant_not_registered_for_amex        |
| `TRANSACTION_NOT_PERMITTED_AT_TERMINAL` | transaction_not_permitted_at_terminal   |
| `AGREEMENT_TERMINAL_NOT_RELATED`        | agreement_terminal_not_related          |
| `INVALID_PROCESSOR_ID`                  | invalid_processor_id                    |
| `INVALID_MERCHANT_DATA`                 | invalid_merchant_data                   |
| `SUB_MERCHANT_ACCOUNT_CLOSED`           | sub_merchant_account_closed             |