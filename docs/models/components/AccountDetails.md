# AccountDetails

The account holder details and bank account information for the business account.


## Fields

| Field                                                        | Type                                                         | Required                                                     | Description                                                  | Example                                                      |
| ------------------------------------------------------------ | ------------------------------------------------------------ | ------------------------------------------------------------ | ------------------------------------------------------------ | ------------------------------------------------------------ |
| `accountHolderName`                                          | *String*                                                     | :heavy_check_mark:                                           | The name of the account holder.                              | Mollie B.V.                                                  |
| `name`                                                       | *Optional\<String>*                                          | :heavy_minus_sign:                                           | A name of the account.                                       | Main Checking Account                                        |
| `currency`                                                   | *String*                                                     | :heavy_check_mark:                                           | The currency of the account in ISO 4217 format.              | EUR                                                          |
| `iban`                                                       | *String*                                                     | :heavy_check_mark:                                           | The IBAN (International Bank Account Number) of the account. | NL02MLLE123456780                                            |
| `bic`                                                        | *Optional\<String>*                                          | :heavy_minus_sign:                                           | The BIC (Bank Identifier Code) of the account.               | MLLENL2AXXX                                                  |