# BalanceTransferCategoryResponse

The type of the transfer. Different fees may apply to different types of transfers.

## Example Usage

```java
import com.mollie.mollie.models.components.BalanceTransferCategoryResponse;

BalanceTransferCategoryResponse value = BalanceTransferCategoryResponse.INVOICE_COLLECTION;

// Open enum: use .of() to create instances from custom string values
BalanceTransferCategoryResponse custom = BalanceTransferCategoryResponse.of("custom_value");
```


## Values

| Name                    | Value                   |
| ----------------------- | ----------------------- |
| `INVOICE_COLLECTION`    | invoice_collection      |
| `PURCHASE`              | purchase                |
| `CHARGEBACK`            | chargeback              |
| `REFUND`                | refund                  |
| `SERVICE_PENALTY`       | service_penalty         |
| `DISCOUNT_COMPENSATION` | discount_compensation   |
| `MANUAL_CORRECTION`     | manual_correction       |
| `OTHER_FEE`             | other_fee               |