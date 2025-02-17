# GetShipmentLinks

An object with several relevant URLs. Every URL object will contain an `href` and a `type` field.


## Fields

| Field                                                                                      | Type                                                                                       | Required                                                                                   | Description                                                                                |
| ------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------ |
| `self`                                                                                     | [Optional\<GetShipmentSelf>](../../models/operations/GetShipmentSelf.md)                   | :heavy_minus_sign:                                                                         | In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field. |
| `order`                                                                                    | [Optional\<Order>](../../models/operations/Order.md)                                       | :heavy_minus_sign:                                                                         | The API resource URL of the [order](get-order) that this shipment belongs to.              |
| `documentation`                                                                            | [Optional\<GetShipmentDocumentation>](../../models/operations/GetShipmentDocumentation.md) | :heavy_minus_sign:                                                                         | In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field. |