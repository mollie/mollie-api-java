# GetMandateLinks

An object with several relevant URLs. Every URL object will contain an `href` and a `type` field.


## Fields

| Field                                                                                      | Type                                                                                       | Required                                                                                   | Description                                                                                |
| ------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------ |
| `self`                                                                                     | [Optional\<GetMandateSelf>](../../models/operations/GetMandateSelf.md)                     | :heavy_minus_sign:                                                                         | In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field. |
| `customer`                                                                                 | [Optional\<GetMandateCustomer>](../../models/operations/GetMandateCustomer.md)             | :heavy_minus_sign:                                                                         | The API resource URL of the [customer](get-customer) that this mandate belongs to.         |
| `documentation`                                                                            | [Optional\<GetMandateDocumentation>](../../models/operations/GetMandateDocumentation.md)   | :heavy_minus_sign:                                                                         | In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field. |