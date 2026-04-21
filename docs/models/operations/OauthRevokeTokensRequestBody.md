# OauthRevokeTokensRequestBody


## Fields

| Field                                                                                  | Type                                                                                   | Required                                                                               | Description                                                                            |
| -------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------- |
| `tokenTypeHint`                                                                        | *String*                                                                               | :heavy_check_mark:                                                                     | The type of token you want to revoke.<br/><br/>Possible values: `access_token` `refresh_token` |
| `token`                                                                                | *String*                                                                               | :heavy_check_mark:                                                                     | The token you want to revoke.                                                          |