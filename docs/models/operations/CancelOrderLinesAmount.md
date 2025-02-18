# CancelOrderLinesAmount

The amount that you want to cancel. In almost all cases, Mollie can determine the amount automatically.

The amount is required only if you are *partially* canceling an order line which has a non-zero `discountAmount`.

The amount you can cancel depends on various properties of the order line and the cancel order lines request. The maximum that can be canceled is `unit price x quantity to cancel`.

The minimum amount depends on the discount applied to the line, the quantity already shipped or canceled, the amounts already shipped or canceled and the quantity you want to cancel.

If you do not send an amount, Mollie will determine the amount automatically or respond with an error if the amount cannot be determined automatically.


## Fields

| Field                                                               | Type                                                                | Required                                                            | Description                                                         | Example                                                             |
| ------------------------------------------------------------------- | ------------------------------------------------------------------- | ------------------------------------------------------------------- | ------------------------------------------------------------------- | ------------------------------------------------------------------- |
| `currency`                                                          | *String*                                                            | :heavy_check_mark:                                                  | A three-character ISO 4217 currency code.                           | EUR                                                                 |
| `value`                                                             | *String*                                                            | :heavy_check_mark:                                                  | A string containing an exact monetary amount in the given currency. | 10.00                                                               |