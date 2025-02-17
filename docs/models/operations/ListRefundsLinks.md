# ListRefundsLinks

Links to help navigate through the lists of items. Every URL object will contain an `href` and a `type` field.


## Fields

| Field                                                                                      | Type                                                                                       | Required                                                                                   | Description                                                                                |
| ------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------ |
| `self`                                                                                     | [Optional\<ListRefundsSelf>](../../models/operations/ListRefundsSelf.md)                   | :heavy_minus_sign:                                                                         | The URL to the current set of items.                                                       |
| `previous`                                                                                 | [JsonNullable\<ListRefundsPrevious>](../../models/operations/ListRefundsPrevious.md)       | :heavy_minus_sign:                                                                         | The previous set of items, if available.                                                   |
| `next`                                                                                     | [JsonNullable\<ListRefundsNext>](../../models/operations/ListRefundsNext.md)               | :heavy_minus_sign:                                                                         | The next set of items, if available.                                                       |
| `documentation`                                                                            | [Optional\<ListRefundsDocumentation>](../../models/operations/ListRefundsDocumentation.md) | :heavy_minus_sign:                                                                         | In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field. |