# ListOrdersLinks

Links to help navigate through the lists of items. Every URL object will contain an `href` and a `type` field.


## Fields

| Field                                                                                      | Type                                                                                       | Required                                                                                   | Description                                                                                |
| ------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------ |
| `self`                                                                                     | [Optional\<ListOrdersSelf>](../../models/operations/ListOrdersSelf.md)                     | :heavy_minus_sign:                                                                         | The URL to the current set of items.                                                       |
| `previous`                                                                                 | [JsonNullable\<ListOrdersPrevious>](../../models/operations/ListOrdersPrevious.md)         | :heavy_minus_sign:                                                                         | The previous set of items, if available.                                                   |
| `next`                                                                                     | [JsonNullable\<ListOrdersNext>](../../models/operations/ListOrdersNext.md)                 | :heavy_minus_sign:                                                                         | The next set of items, if available.                                                       |
| `documentation`                                                                            | [Optional\<ListOrdersDocumentation>](../../models/operations/ListOrdersDocumentation.md)   | :heavy_minus_sign:                                                                         | In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field. |