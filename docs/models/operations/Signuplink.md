# Signuplink

The URL that can be used to have new organizations sign up and be automatically linked to this partner. Will be omitted if the partner is not of type `signuplink`.


## Fields

| Field                                                       | Type                                                        | Required                                                    | Description                                                 | Example                                                     |
| ----------------------------------------------------------- | ----------------------------------------------------------- | ----------------------------------------------------------- | ----------------------------------------------------------- | ----------------------------------------------------------- |
| `href`                                                      | *Optional\<String>*                                         | :heavy_minus_sign:                                          | The actual URL string.                                      | https://...                                                 |
| `type`                                                      | *Optional\<String>*                                         | :heavy_minus_sign:                                          | The content type of the page or endpoint the URL points to. | application/hal+json                                        |