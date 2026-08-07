# SettlementConvenienceLinks

An object with several relevant URLs. Every URL object will contain an `href` and a `type` field.

This endpoint always points to your organization's current open or next settlement rather than one specific
settlement, so it doesn't return links to that settlement's payments, captures, refunds, chargebacks, or invoice.


## Fields

| Field                                                                                      | Type                                                                                       | Required                                                                                   | Description                                                                                |
| ------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------ |
| `self`                                                                                     | [Url](../../models/components/Url.md)                                                      | :heavy_check_mark:                                                                         | In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field. |
| `documentation`                                                                            | [Optional\<Url>](../../models/components/Url.md)                                           | :heavy_minus_sign:                                                                         | In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field. |