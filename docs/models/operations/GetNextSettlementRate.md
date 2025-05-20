# GetNextSettlementRate

The service rates, further divided into `fixed` and `percentage` costs.


## Fields

| Field                                                                                             | Type                                                                                              | Required                                                                                          | Description                                                                                       |
| ------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------- |
| `fixed`                                                                                           | [Optional\<GetNextSettlementFixed>](../../models/operations/GetNextSettlementFixed.md)            | :heavy_minus_sign:                                                                                | In v2 endpoints, monetary amounts are represented as objects with a `currency` and `value` field. |
| `percentage`                                                                                      | [Optional\<GetNextSettlementPercentage>](../../models/operations/GetNextSettlementPercentage.md)  | :heavy_minus_sign:                                                                                | In v2 endpoints, monetary amounts are represented as objects with a `currency` and `value` field. |