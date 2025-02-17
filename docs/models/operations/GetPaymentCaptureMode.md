# GetPaymentCaptureMode

**Only relevant if you wish to manage authorization and capturing separately.**

By default, the customer's card or bank account is immediately charged when they complete the payment.

Some payment methods also allow placing a hold on the card or bank account. This hold or 'authorization' can then
at a later point either be 'captured' or canceled.

To enable this way of working, set the capture mode to `manual` and capture the payment manually using the
[Create capture endpoint](create-capture).


## Values

| Name        | Value       |
| ----------- | ----------- |
| `AUTOMATIC` | automatic   |
| `MANUAL`    | manual      |