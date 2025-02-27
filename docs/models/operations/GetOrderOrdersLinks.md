# GetOrderOrdersLinks

An object with several relevant URLs. Every URL object will contain an `href` and a `type` field.


## Fields

| Field                                                                                      | Type                                                                                       | Required                                                                                   | Description                                                                                |
| ------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------ |
| `self`                                                                                     | [Optional\<GetOrderOrdersSelf>](../../models/operations/GetOrderOrdersSelf.md)             | :heavy_minus_sign:                                                                         | In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field. |
| `imageUrl`                                                                                 | [Optional\<ImageUrl>](../../models/operations/ImageUrl.md)                                 | :heavy_minus_sign:                                                                         | A link pointing to an image of the product sold.                                           |
| `productUrl`                                                                               | [Optional\<ProductUrl>](../../models/operations/ProductUrl.md)                             | :heavy_minus_sign:                                                                         | A link pointing to the product page in your web shop of the product sold.                  |