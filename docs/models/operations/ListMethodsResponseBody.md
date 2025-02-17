# ListMethodsResponseBody

A list of payment method objects. For a complete reference of the
payment method object, refer to the [Get payment method endpoint](get-method) documentation.


## Fields

| Field                                                                                   | Type                                                                                    | Required                                                                                | Description                                                                             |
| --------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------- |
| `count`                                                                                 | *Optional\<Long>*                                                                       | :heavy_minus_sign:                                                                      | The number of payment method objects in this result set.<br/>Results are **not** paginated. |
| `embedded`                                                                              | [Optional\<ListMethodsEmbedded>](../../models/operations/ListMethodsEmbedded.md)        | :heavy_minus_sign:                                                                      | N/A                                                                                     |
| `links`                                                                                 | [Optional\<ListMethodsLinks>](../../models/operations/ListMethodsLinks.md)              | :heavy_minus_sign:                                                                      | N/A                                                                                     |