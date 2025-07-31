# ListBalanceTransactionsType

The type of transaction, for example `payment` or `refund`. Values include the below examples, although this list
is not definitive.

* Regular payment processing: `payment` `capture` `unauthorized-direct-debit` `failed-payment`
* Refunds and chargebacks: `refund` `returned-refund` `chargeback` `chargeback-reversal`
* Settlements: `outgoing-transfer` `canceled-outgoing-transfer` `returned-transfer`
* Invoicing: `invoice-compensation` `balance-correction`
* Mollie Connect: `application-fee` `split-payment` `platform-payment-refund` `platform-payment-chargeback`


## Values

| Name                                   | Value                                  |
| -------------------------------------- | -------------------------------------- |
| `APPLICATION_FEE`                      | application-fee                        |
| `CAPTURE`                              | capture                                |
| `CHARGEBACK`                           | chargeback                             |
| `CHARGEBACK_REVERSAL`                  | chargeback-reversal                    |
| `FAILED_PAYMENT_FEE`                   | failed-payment-fee                     |
| `FAILED_PAYMENT`                       | failed-payment                         |
| `INVOICE_COMPENSATION`                 | invoice-compensation                   |
| `PAYMENT`                              | payment                                |
| `PAYMENT_FEE`                          | payment-fee                            |
| `PAYMENT_COMMISSION`                   | payment-commission                     |
| `REFUND`                               | refund                                 |
| `RETURNED_REFUND`                      | returned-refund                        |
| `RETURNED_TRANSFER`                    | returned-transfer                      |
| `SPLIT_PAYMENT`                        | split-payment                          |
| `OUTGOING_TRANSFER`                    | outgoing-transfer                      |
| `CAPTURE_COMMISSION`                   | capture-commission                     |
| `CANCELED_OUTGOING_TRANSFER`           | canceled-outgoing-transfer             |
| `INCOMING_TRANSFER`                    | incoming-transfer                      |
| `API_PAYMENT_ROLLING_RESERVE_RELEASE`  | api-payment-rolling-reserve-release    |
| `CAPTURE_ROLLING_RESERVE_RELEASE`      | capture-rolling-reserve-release        |
| `REIMBURSEMENT_FEE`                    | reimbursement-fee                      |
| `BALANCE_CORRECTION`                   | balance-correction                     |
| `UNAUTHORIZED_DIRECT_DEBIT`            | unauthorized-direct-debit              |
| `BANK_CHARGED_FAILURE_FEE`             | bank-charged-failure-fee               |
| `PLATFORM_PAYMENT_REFUND`              | platform-payment-refund                |
| `REFUND_COMPENSATION`                  | refund-compensation                    |
| `RETURNED_REFUND_COMPENSATION`         | returned-refund-compensation           |
| `RETURNED_PLATFORM_PAYMENT_REFUND`     | returned-platform-payment-refund       |
| `PLATFORM_PAYMENT_CHARGEBACK`          | platform-payment-chargeback            |
| `CHARGEBACK_COMPENSATION`              | chargeback-compensation                |
| `REVERSED_PLATFORM_PAYMENT_CHARGEBACK` | reversed-platform-payment-chargeback   |
| `REVERSED_CHARGEBACK_COMPENSATION`     | reversed-chargeback-compensation       |
| `FAILED_SPLIT_PAYMENT_PLATFORM`        | failed-split-payment-platform          |
| `FAILED_SPLIT_PAYMENT_COMPENSATION`    | failed-split-payment-compensation      |
| `CASH_ADVANCE_LOAN`                    | cash-advance-loan                      |
| `PLATFORM_CONNECTED_ORGANIZATIONS_FEE` | platform-connected-organizations-fee   |
| `SPLIT_TRANSACTION`                    | split-transaction                      |
| `MANAGED_FEE`                          | managed-fee                            |
| `RETURNED_MANAGED_FEE`                 | returned-managed-fee                   |
| `TOPUP`                                | topup                                  |
| `BALANCE_RESERVE`                      | balance-reserve                        |
| `BALANCE_RESERVE_RETURN`               | balance-reserve-return                 |
| `MOVEMENT`                             | movement                               |
| `POST_PAYMENT_SPLIT_PAYMENT`           | post-payment-split-payment             |
| `CASH_COLLATERAL_ISSUANCE`             | cash-collateral-issuance               |
| `CASH_COLLATERAL_RELEASE`              | cash-collateral-release                |