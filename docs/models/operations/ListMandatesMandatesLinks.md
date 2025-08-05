# ListMandatesMandatesLinks

An object with several relevant URLs. Every URL object will contain an `href` and a `type` field.


## Fields

| Field                                                                                             | Type                                                                                              | Required                                                                                          | Description                                                                                       |
| ------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------- |
| `self`                                                                                            | [ListMandatesMandatesSelf](../../models/operations/ListMandatesMandatesSelf.md)                   | :heavy_check_mark:                                                                                | In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field.        |
| `customer`                                                                                        | [ListMandatesCustomer](../../models/operations/ListMandatesCustomer.md)                           | :heavy_check_mark:                                                                                | The API resource URL of the [customer](get-customer) that this mandate belongs to.                |
| `documentation`                                                                                   | [ListMandatesMandatesDocumentation](../../models/operations/ListMandatesMandatesDocumentation.md) | :heavy_check_mark:                                                                                | In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field.        |