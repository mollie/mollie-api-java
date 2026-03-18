# Owner

Personal data of your customer.


## Fields

| Field                                                                      | Type                                                                       | Required                                                                   | Description                                                                | Example                                                                    |
| -------------------------------------------------------------------------- | -------------------------------------------------------------------------- | -------------------------------------------------------------------------- | -------------------------------------------------------------------------- | -------------------------------------------------------------------------- |
| `email`                                                                    | *String*                                                                   | :heavy_check_mark:                                                         | The email address of your customer.                                        | john@example.org                                                           |
| `givenName`                                                                | *String*                                                                   | :heavy_check_mark:                                                         | The given name (first name) of your customer.                              | John                                                                       |
| `familyName`                                                               | *String*                                                                   | :heavy_check_mark:                                                         | The family name (surname) of your customer.                                | Doe                                                                        |
| `locale`                                                                   | [JsonNullable\<LocaleResponse>](../../models/components/LocaleResponse.md) | :heavy_minus_sign:                                                         | Allows you to preset the language to be used.                              | en_US                                                                      |