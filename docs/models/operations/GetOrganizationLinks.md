# GetOrganizationLinks

An object with several relevant URLs. Every URL object will contain an `href` and a `type` field.


## Fields

| Field                                                                                              | Type                                                                                               | Required                                                                                           | Description                                                                                        |
| -------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------- |
| `self`                                                                                             | [Optional\<GetOrganizationSelf>](../../models/operations/GetOrganizationSelf.md)                   | :heavy_minus_sign:                                                                                 | In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field.         |
| `dashboard`                                                                                        | [Optional\<GetOrganizationDashboard>](../../models/operations/GetOrganizationDashboard.md)         | :heavy_minus_sign:                                                                                 | Direct link to the organization's Mollie dashboard.                                                |
| `documentation`                                                                                    | [Optional\<GetOrganizationDocumentation>](../../models/operations/GetOrganizationDocumentation.md) | :heavy_minus_sign:                                                                                 | In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field.         |