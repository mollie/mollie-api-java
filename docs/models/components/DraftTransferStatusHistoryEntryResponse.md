# DraftTransferStatusHistoryEntryResponse

A single entry in the draft transfer's status history.


## Fields

| Field                                                                                     | Type                                                                                      | Required                                                                                  | Description                                                                               | Example                                                                                   |
| ----------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------- |
| `status`                                                                                  | [DraftTransferStatusResponse](../../models/components/DraftTransferStatusResponse.md)     | :heavy_check_mark:                                                                        | The status of the draft transfer.                                                         | awaiting-initiation                                                                       |
| `createdAt`                                                                               | [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html) | :heavy_check_mark:                                                                        | The date and time the draft transfer entered this status, in ISO 8601 format.             | 2025-01-01T12:00:00+00:00                                                                 |