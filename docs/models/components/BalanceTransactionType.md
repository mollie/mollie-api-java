# BalanceTransactionType

## Example Usage

```java
import com.mollie.mollie.models.components.BalanceTransactionType;

BalanceTransactionType value = BalanceTransactionType.BALANCE_CHARGE_FEE;

// Open enum: use .of() to create instances from custom string values
BalanceTransactionType custom = BalanceTransactionType.of("custom_value");
```


## Values

| Name                                   | Value                                  |
| -------------------------------------- | -------------------------------------- |
| `BALANCE_CHARGE_FEE`                   | balance-charge-fee                     |
| `BALANCE_CORRECTION`                   | balance-correction                     |
| `BALANCE_RESERVE`                      | balance-reserve                        |
| `BALANCE_RESERVE_RETURN`               | balance-reserve-return                 |
| `BALANCE_TOPUP`                        | balance-topup                          |
| `CANCELED_TRANSFER`                    | canceled-transfer                      |
| `CAPTURE`                              | capture                                |
| `CASH_COLLATERAL_ISSUANCE`             | cash-collateral-issuance               |
| `CASH_COLLATERAL_RELEASE`              | cash-collateral-release                |
| `CHARGEBACK`                           | chargeback                             |
| `CHARGEBACK_COMPENSATION`              | chargeback-compensation                |
| `CHARGEBACK_REVERSAL`                  | chargeback-reversal                    |
| `FAILED_PAYMENT`                       | failed-payment                         |
| `FAILED_PLATFORM_SPLIT_PAYMENT`        | failed-platform-split-payment          |
| `FAILED_SPLIT_PAYMENT_COMPENSATION`    | failed-split-payment-compensation      |
| `FEE_PREPAYMENT`                       | fee-prepayment                         |
| `HELD_ROLLING_RESERVE`                 | held-rolling-reserve                   |
| `INCOMING_TRANSFER`                    | incoming-transfer                      |
| `INVOICE_COMPENSATION`                 | invoice-compensation                   |
| `INVOICE_ROUNDING_COMPENSATION`        | invoice-rounding-compensation          |
| `LOAN`                                 | loan                                   |
| `MOVEMENT`                             | movement                               |
| `OUTGOING_CUSTOM_AMOUNT_TRANSFER`      | outgoing-custom-amount-transfer        |
| `OUTGOING_TRANSFER`                    | outgoing-transfer                      |
| `PAYMENT`                              | payment                                |
| `PENDING_ROLLING_RESERVE`              | pending-rolling-reserve                |
| `PLATFORM_PAYMENT_CHARGEBACK`          | platform-payment-chargeback            |
| `PLATFORM_PAYMENT_REFUND`              | platform-payment-refund                |
| `REFUND`                               | refund                                 |
| `REFUND_COMPENSATION`                  | refund-compensation                    |
| `RELEASED_ROLLING_RESERVE`             | released-rolling-reserve               |
| `REPAYMENT`                            | repayment                              |
| `RETURNED_PLATFORM_PAYMENT_REFUND`     | returned-platform-payment-refund       |
| `RETURNED_REFUND`                      | returned-refund                        |
| `RETURNED_REFUND_COMPENSATION`         | returned-refund-compensation           |
| `RETURNED_TRANSFER`                    | returned-transfer                      |
| `REVERSED_CHARGEBACK_COMPENSATION`     | reversed-chargeback-compensation       |
| `REVERSED_PLATFORM_PAYMENT_CHARGEBACK` | reversed-platform-payment-chargeback   |
| `ROLLING_RESERVE_HOLD`                 | rolling-reserve-hold                   |
| `ROLLING_RESERVE_RELEASE`              | rolling-reserve-release                |
| `SPLIT_PAYMENT`                        | split-payment                          |
| `SPLIT_TRANSACTION`                    | split-transaction                      |
| `TO_BE_RELEASED_ROLLING_RESERVE`       | to-be-released-rolling-reserve         |
| `TOPUP`                                | topup                                  |