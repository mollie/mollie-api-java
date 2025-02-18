# CreateShipmentAmount

The amount that you want to ship. In almost all cases, Mollie can determine the amount automatically.

The amount is required only if you are *partially* fulfilling an order line which has a non-zero `discountAmount`.

If you do not send an amount, Mollie will determine the amount automatically or respond with an error if the amount cannot be determined automatically.


## Fields

| Field                                                               | Type                                                                | Required                                                            | Description                                                         | Example                                                             |
| ------------------------------------------------------------------- | ------------------------------------------------------------------- | ------------------------------------------------------------------- | ------------------------------------------------------------------- | ------------------------------------------------------------------- |
| `currency`                                                          | *String*                                                            | :heavy_check_mark:                                                  | A three-character ISO 4217 currency code.                           | EUR                                                                 |
| `value`                                                             | *String*                                                            | :heavy_check_mark:                                                  | A string containing an exact monetary amount in the given currency. | 10.00                                                               |