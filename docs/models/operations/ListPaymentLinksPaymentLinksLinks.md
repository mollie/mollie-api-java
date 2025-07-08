# ListPaymentLinksPaymentLinksLinks

An object with several relevant URLs. Every URL object will contain an `href` and a `type` field.


## Fields

| Field                                                                                                      | Type                                                                                                       | Required                                                                                                   | Description                                                                                                |
| ---------------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------- |
| `self`                                                                                                     | [ListPaymentLinksPaymentLinksSelf](../../models/operations/ListPaymentLinksPaymentLinksSelf.md)            | :heavy_check_mark:                                                                                         | In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field.                 |
| `paymentLink`                                                                                              | [ListPaymentLinksPaymentLink](../../models/operations/ListPaymentLinksPaymentLink.md)                      | :heavy_check_mark:                                                                                         | The URL your customer should visit to make the payment. This is where you should redirect the customer to. |