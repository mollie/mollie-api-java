# GetInvoiceLines


## Fields

| Field                                                                      | Type                                                                       | Required                                                                   | Description                                                                |
| -------------------------------------------------------------------------- | -------------------------------------------------------------------------- | -------------------------------------------------------------------------- | -------------------------------------------------------------------------- |
| `period`                                                                   | *Optional\<String>*                                                        | :heavy_minus_sign:                                                         | The administrative period in `YYYY-MM` on which the line should be booked. |
| `description`                                                              | *Optional\<String>*                                                        | :heavy_minus_sign:                                                         | Description of the product.                                                |
| `count`                                                                    | *Optional\<Long>*                                                          | :heavy_minus_sign:                                                         | Number of products invoiced. For example, the number of payments.          |
| `vatPercentage`                                                            | *Optional\<Long>*                                                          | :heavy_minus_sign:                                                         | VAT percentage rate that applies to this product.                          |
| `amount`                                                                   | [Optional\<GetInvoiceAmount>](../../models/operations/GetInvoiceAmount.md) | :heavy_minus_sign:                                                         | Line item amount excluding VAT.                                            |