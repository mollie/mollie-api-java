# Reason

Reason for the chargeback as given by the bank. Only available for chargebacks of SEPA Direct Debit payments.


## Fields

| Field                                            | Type                                             | Required                                         | Description                                      | Example                                          |
| ------------------------------------------------ | ------------------------------------------------ | ------------------------------------------------ | ------------------------------------------------ | ------------------------------------------------ |
| `code`                                           | *String*                                         | :heavy_check_mark:                               | Technical code provided by the bank.             | AC01                                             |
| `description`                                    | *String*                                         | :heavy_check_mark:                               | A more detailed human-friendly description.      | Account identifier incorrect (i.e. invalid IBAN) |