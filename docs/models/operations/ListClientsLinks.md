# ListClientsLinks

Links to help navigate through the lists of items. Every URL object will contain an `href` and a `type` field.


## Fields

| Field                                                                                      | Type                                                                                       | Required                                                                                   | Description                                                                                |
| ------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------ |
| `self`                                                                                     | [Optional\<ListClientsSelf>](../../models/operations/ListClientsSelf.md)                   | :heavy_minus_sign:                                                                         | The URL to the current set of items.                                                       |
| `previous`                                                                                 | [JsonNullable\<ListClientsPrevious>](../../models/operations/ListClientsPrevious.md)       | :heavy_minus_sign:                                                                         | The previous set of items, if available.                                                   |
| `next`                                                                                     | [JsonNullable\<ListClientsNext>](../../models/operations/ListClientsNext.md)               | :heavy_minus_sign:                                                                         | The next set of items, if available.                                                       |
| `documentation`                                                                            | [Optional\<ListClientsDocumentation>](../../models/operations/ListClientsDocumentation.md) | :heavy_minus_sign:                                                                         | In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field. |