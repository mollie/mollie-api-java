# GetClientLinks

An object with several relevant URLs. Every URL object will contain an `href` and a `type` field.


## Fields

| Field                                                                                      | Type                                                                                       | Required                                                                                   | Description                                                                                |
| ------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------ |
| `self`                                                                                     | [Optional\<GetClientSelf>](../../models/operations/GetClientSelf.md)                       | :heavy_minus_sign:                                                                         | In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field. |
| `organization`                                                                             | [Optional\<GetClientOrganization>](../../models/operations/GetClientOrganization.md)       | :heavy_minus_sign:                                                                         | The API resource URL of the client's organization.                                         |
| `onboarding`                                                                               | [Optional\<Onboarding>](../../models/operations/Onboarding.md)                             | :heavy_minus_sign:                                                                         | The API resource URL of the client's onboarding status.                                    |
| `documentation`                                                                            | [Optional\<GetClientDocumentation>](../../models/operations/GetClientDocumentation.md)     | :heavy_minus_sign:                                                                         | In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field. |