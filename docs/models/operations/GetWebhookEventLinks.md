# GetWebhookEventLinks

An object with several relevant URLs. Every URL object will contain an `href` and a `type` field.


## Fields

| Field                                                                                      | Type                                                                                       | Required                                                                                   | Description                                                                                |
| ------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------ |
| `self`                                                                                     | [GetWebhookEventSelf](../../models/operations/GetWebhookEventSelf.md)                      | :heavy_check_mark:                                                                         | In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field. |
| `documentation`                                                                            | [GetWebhookEventDocumentation](../../models/operations/GetWebhookEventDocumentation.md)    | :heavy_check_mark:                                                                         | In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field. |
| `entity`                                                                                   | [Optional\<Entity>](../../models/operations/Entity.md)                                     | :heavy_minus_sign:                                                                         | The API resource URL of the entity that this event belongs to.                             |