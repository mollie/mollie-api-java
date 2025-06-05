# GetWebhookEventLinks

An object with several relevant URLs. Every URL object will contain an `href` and a `type` field.


## Fields

| Field                                                                                              | Type                                                                                               | Required                                                                                           | Description                                                                                        |
| -------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------- |
| `self`                                                                                             | [Optional\<GetWebhookEventSelf>](../../models/operations/GetWebhookEventSelf.md)                   | :heavy_minus_sign:                                                                                 | In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field.         |
| `documentation`                                                                                    | [Optional\<GetWebhookEventDocumentation>](../../models/operations/GetWebhookEventDocumentation.md) | :heavy_minus_sign:                                                                                 | In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field.         |
| `entity`                                                                                           | [Optional\<GetWebhookEventEntity>](../../models/operations/GetWebhookEventEntity.md)               | :heavy_minus_sign:                                                                                 | The API resource URL of the entity that this event belongs to.                                     |