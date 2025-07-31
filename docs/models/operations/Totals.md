# Totals

Totals are grouped according to the chosen grouping rule. The example response should give a good idea of what a
typical grouping looks like.

If grouping `status-balances` is chosen, the main grouping is as follows:

* `pendingBalance` containing an `open`, `pending`, `movedToAvailable`, and `close` sub-group
* `availableBalance` containing an `open`, `movedFromPending`, `immediatelyAvailable`, and `close` sub-group

If grouping `transaction-categories` is chosen, the main grouping is as follows:

* `open` and `close` groups, each containing a `pending` and `available` sub-group
* Transaction type groups such as `payments`, `refunds`, `chargebacks`, `capital`, `transfers`, `fee-prepayments`, `corrections`, `topups`
each containing a `pending`, `movedToAvailable`, and
`immediatelyAvailable` sub-group

Each sub-group typically has:

* An `amount` object containing the group's total amount
* A `count` integer if relevant (for example, counting the number of refunds)
* A `subtotals` array containing more sub-group objects if applicable


## Fields

| Field                                                                                            | Type                                                                                             | Required                                                                                         | Description                                                                                      |
| ------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------ |
| `pendingBalance`                                                                                 | [JsonNullable\<PendingBalance>](../../models/operations/PendingBalance.md)                       | :heavy_minus_sign:                                                                               | The pending balance. Only available if grouping is `status-balances`.                            |
| `availableBalance`                                                                               | [JsonNullable\<AvailableBalance>](../../models/operations/AvailableBalance.md)                   | :heavy_minus_sign:                                                                               | The available balance. Only available if grouping is `status-balances`.                          |
| `open`                                                                                           | [Optional\<Open>](../../models/operations/Open.md)                                               | :heavy_minus_sign:                                                                               | Only available on `transaction-categories` grouping.                                             |
| `close`                                                                                          | [Optional\<Close>](../../models/operations/Close.md)                                             | :heavy_minus_sign:                                                                               | Only available on `transaction-categories` grouping.                                             |
| `payments`                                                                                       | [Optional\<GetBalanceReportPayments>](../../models/operations/GetBalanceReportPayments.md)       | :heavy_minus_sign:                                                                               | Only available on `transaction-categories` grouping.                                             |
| `refunds`                                                                                        | [Optional\<GetBalanceReportRefunds>](../../models/operations/GetBalanceReportRefunds.md)         | :heavy_minus_sign:                                                                               | Only available on `transaction-categories` grouping.                                             |
| `chargebacks`                                                                                    | [Optional\<GetBalanceReportChargebacks>](../../models/operations/GetBalanceReportChargebacks.md) | :heavy_minus_sign:                                                                               | Only available on `transaction-categories` grouping.                                             |
| `capital`                                                                                        | [Optional\<Capital>](../../models/operations/Capital.md)                                         | :heavy_minus_sign:                                                                               | Only available on `transaction-categories` grouping.                                             |
| `transfers`                                                                                      | [Optional\<Transfers>](../../models/operations/Transfers.md)                                     | :heavy_minus_sign:                                                                               | Only available on `transaction-categories` grouping.                                             |
| `feePrepayments`                                                                                 | [Optional\<FeePrepayments>](../../models/operations/FeePrepayments.md)                           | :heavy_minus_sign:                                                                               | Only available on `transaction-categories` grouping.                                             |
| `corrections`                                                                                    | [Optional\<Corrections>](../../models/operations/Corrections.md)                                 | :heavy_minus_sign:                                                                               | Only available on `transaction-categories` grouping.                                             |
| `topups`                                                                                         | [Optional\<Topups>](../../models/operations/Topups.md)                                           | :heavy_minus_sign:                                                                               | Only available on `transaction-categories` grouping.                                             |