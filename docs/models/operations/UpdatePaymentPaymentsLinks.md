# UpdatePaymentPaymentsLinks

An object with several relevant URLs. Every URL object will contain an `href` and a `type` field.


## Fields

| Field                                                                                        | Type                                                                                         | Required                                                                                     | Description                                                                                  |
| -------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------- |
| `self`                                                                                       | [Optional\<UpdatePaymentPaymentsSelf>](../../models/operations/UpdatePaymentPaymentsSelf.md) | :heavy_minus_sign:                                                                           | In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field.   |
| `payment`                                                                                    | [Optional\<UpdatePaymentPayment>](../../models/operations/UpdatePaymentPayment.md)           | :heavy_minus_sign:                                                                           | The API resource URL of the [payment](get-payment) that belong to this route.                |