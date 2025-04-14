# CreateMandateLinks

An object with several relevant URLs. Every URL object will contain an `href` and a `type` field.


## Fields

| Field                                                                                          | Type                                                                                           | Required                                                                                       | Description                                                                                    |
| ---------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------- |
| `self`                                                                                         | [Optional\<CreateMandateSelf>](../../models/operations/CreateMandateSelf.md)                   | :heavy_minus_sign:                                                                             | In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field.     |
| `customer`                                                                                     | [Optional\<CreateMandateCustomer>](../../models/operations/CreateMandateCustomer.md)           | :heavy_minus_sign:                                                                             | The API resource URL of the [customer](get-customer) that this mandate belongs to.             |
| `documentation`                                                                                | [Optional\<CreateMandateDocumentation>](../../models/operations/CreateMandateDocumentation.md) | :heavy_minus_sign:                                                                             | In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field.     |