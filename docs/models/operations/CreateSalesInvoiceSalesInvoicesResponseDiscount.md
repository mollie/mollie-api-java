# CreateSalesInvoiceSalesInvoicesResponseDiscount

The discount to be applied to the line item.


## Fields

| Field                                                                                  | Type                                                                                   | Required                                                                               | Description                                                                            | Example                                                                                |
| -------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------- |
| `type`                                                                                 | *String*                                                                               | :heavy_check_mark:                                                                     | The type of discount.<br/><br/>Possible values: `amount` `percentage`                  | amount                                                                                 |
| `value`                                                                                | *String*                                                                               | :heavy_check_mark:                                                                     | A string containing an exact monetary amount in the given currency, or the percentage. | 10.00                                                                                  |