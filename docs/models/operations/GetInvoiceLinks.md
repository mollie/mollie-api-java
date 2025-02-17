# GetInvoiceLinks

An object with several relevant URLs. Every URL object will contain an `href` and a `type` field.


## Fields

| Field                                                                                      | Type                                                                                       | Required                                                                                   | Description                                                                                |
| ------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------ |
| `self`                                                                                     | [Optional\<GetInvoiceSelf>](../../models/operations/GetInvoiceSelf.md)                     | :heavy_minus_sign:                                                                         | In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field. |
| `pdf`                                                                                      | [Optional\<Pdf>](../../models/operations/Pdf.md)                                           | :heavy_minus_sign:                                                                         | URL to a downloadable PDF of the invoice.                                                  |
| `documentation`                                                                            | [Optional\<GetInvoiceDocumentation>](../../models/operations/GetInvoiceDocumentation.md)   | :heavy_minus_sign:                                                                         | In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field. |