# UpdateOrderLineVatAmount

Required when a `quantity`, `unitPrice`, `discountAmount`, `totalAmount`, or `vatRate` is also provided
in the same request.


## Fields

| Field                                                               | Type                                                                | Required                                                            | Description                                                         | Example                                                             |
| ------------------------------------------------------------------- | ------------------------------------------------------------------- | ------------------------------------------------------------------- | ------------------------------------------------------------------- | ------------------------------------------------------------------- |
| `currency`                                                          | *String*                                                            | :heavy_check_mark:                                                  | A three-character ISO 4217 currency code.                           | EUR                                                                 |
| `value`                                                             | *String*                                                            | :heavy_check_mark:                                                  | A string containing an exact monetary amount in the given currency. | 10.00                                                               |