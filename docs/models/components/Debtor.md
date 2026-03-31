# Debtor

The debtor (sender) of the transfer, including their name and account details.


## Fields

| Field                                                                         | Type                                                                          | Required                                                                      | Description                                                                   | Example                                                                       |
| ----------------------------------------------------------------------------- | ----------------------------------------------------------------------------- | ----------------------------------------------------------------------------- | ----------------------------------------------------------------------------- | ----------------------------------------------------------------------------- |
| `fullName`                                                                    | *String*                                                                      | :heavy_check_mark:                                                            | The full name of the account holder.                                          | Jan Jansen                                                                    |
| `account`                                                                     | [TransferResponseAccount](../../models/components/TransferResponseAccount.md) | :heavy_check_mark:                                                            | The bank account details of the party.                                        |                                                                               |