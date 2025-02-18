# Context

Depending on the type of the balance transaction, we will try to give more context about the specific event that triggered it. For example, the context object for a payment transaction will look like `{"paymentId": "tr_5B8cwPMGnU6qLbRvo7qEZo"}`.

Below is a complete list of the context values that each type of transaction will have.

* Type `payment: `paymentId`
* Type `capture`: `paymentId` `captureId`
* Type `unauthorized-direct-debit`: `paymentId`
* Type `failed-payment`: `paymentId`
* Type `refund`: `paymentId` `refundId`
* Type `returned-refund`: `paymentId` `refundId`
* Type `chargeback`: `paymentId` `chargebackId`
* Type `chargeback-reversal`: `paymentId`
* Type `outgoing-transfer`: `settlementId` `transferId`
* Type `canceled-outgoing-transfer`: `settlementId` `transferId`
* Type `returned-transfer`: `settlementId` `transferId`
* Type `invoice-compensation`: `invoiceId`
* Type `balance-correction`: none
* Type `application-fee`: `paymentId`
* Type `split-payment`: `paymentId`
* Type `platform-payment-refund`: `paymentId` `refundId`
* Type `platform-payment-chargeback`: `paymentId` `chargebackId`


## Fields

| Field       | Type        | Required    | Description |
| ----------- | ----------- | ----------- | ----------- |