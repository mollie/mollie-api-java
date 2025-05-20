# GetOpenSettlementRate

The service rates, further divided into `fixed` and `percentage` costs.


## Fields

| Field                                                                                             | Type                                                                                              | Required                                                                                          | Description                                                                                       |
| ------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------- |
| `fixed`                                                                                           | [Optional\<GetOpenSettlementFixed>](../../models/operations/GetOpenSettlementFixed.md)            | :heavy_minus_sign:                                                                                | In v2 endpoints, monetary amounts are represented as objects with a `currency` and `value` field. |
| `percentage`                                                                                      | [Optional\<GetOpenSettlementPercentage>](../../models/operations/GetOpenSettlementPercentage.md)  | :heavy_minus_sign:                                                                                | In v2 endpoints, monetary amounts are represented as objects with a `currency` and `value` field. |