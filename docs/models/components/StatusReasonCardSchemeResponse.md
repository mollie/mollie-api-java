# StatusReasonCardSchemeResponse

## Example Usage

```java
import com.mollie.mollie.models.components.StatusReasonCardSchemeResponse;

StatusReasonCardSchemeResponse value = StatusReasonCardSchemeResponse.APPROVED_OR_COMPLETED_SUCCESSFULLY;

// Open enum: use .of() to create instances from custom string values
StatusReasonCardSchemeResponse custom = StatusReasonCardSchemeResponse.of("custom_value");
```


## Values

| Name                                               | Value                                              |
| -------------------------------------------------- | -------------------------------------------------- |
| `APPROVED_OR_COMPLETED_SUCCESSFULLY`               | approved_or_completed_successfully                 |
| `REFER_TO_CARD_ISSUER`                             | refer_to_card_issuer                               |
| `INVALID_MERCHANT`                                 | invalid_merchant                                   |
| `CAPTURE_CARD`                                     | capture_card                                       |
| `DO_NOT_HONOR`                                     | do_not_honor                                       |
| `ERROR`                                            | error                                              |
| `PARTIAL_APPROVAL`                                 | partial_approval                                   |
| `INVALID_TRANSACTION`                              | invalid_transaction                                |
| `INVALID_AMOUNT`                                   | invalid_amount                                     |
| `INVALID_ISSUER`                                   | invalid_issuer                                     |
| `LOST_CARD`                                        | lost_card                                          |
| `STOLEN_CARD`                                      | stolen_card                                        |
| `INSUFFICIENT_FUNDS`                               | insufficient_funds                                 |
| `EXPIRED_CARD`                                     | expired_card                                       |
| `INVALID_PIN`                                      | invalid_pin                                        |
| `TRANSACTION_NOT_PERMITTED_TO_CARDHOLDER`          | transaction_not_permitted_to_cardholder            |
| `TRANSACTION_NOT_ALLOWED_AT_TERMINAL`              | transaction_not_allowed_at_terminal                |
| `EXCEEDS_WITHDRAWAL_AMOUNT_LIMIT`                  | exceeds_withdrawal_amount_limit                    |
| `RESTRICTED_CARD`                                  | restricted_card                                    |
| `SECURITY_VIOLATION`                               | security_violation                                 |
| `EXCEEDS_WITHDRAWAL_COUNT_LIMIT`                   | exceeds_withdrawal_count_limit                     |
| `ALLOWABLE_NUMBER_OF_PIN_TRIES_EXCEEDED`           | allowable_number_of_pin_tries_exceeded             |
| `NO_REASON_TO_DECLINE`                             | no_reason_to_decline                               |
| `CANNOT_VERIFY_PIN`                                | cannot_verify_pin                                  |
| `ISSUER_UNAVAILABLE`                               | issuer_unavailable                                 |
| `UNABLE_TO_ROUTE_TRANSACTION`                      | unable_to_route_transaction                        |
| `DUPLICATE_TRANSACTION`                            | duplicate_transaction                              |
| `SYSTEM_MALFUNCTION`                               | system_malfunction                                 |
| `HONOR_WITH_ID`                                    | honor_with_id                                      |
| `INVALID_CARD_NUMBER`                              | invalid_card_number                                |
| `FORMAT_ERROR`                                     | format_error                                       |
| `CONTACT_CARD_ISSUER`                              | contact_card_issuer                                |
| `PIN_NOT_CHANGED`                                  | pin_not_changed                                    |
| `INVALID_NONEXISTENT_TO_ACCOUNT_SPECIFIED`         | invalid_nonexistent_to_account_specified           |
| `INVALID_NONEXISTENT_FROM_ACCOUNT_SPECIFIED`       | invalid_nonexistent_from_account_specified         |
| `INVALID_NONEXISTENT_ACCOUNT_SPECIFIED`            | invalid_nonexistent_account_specified              |
| `LIFECYCLE_RELATED`                                | lifecycle_related                                  |
| `DOMESTIC_DEBIT_TRANSACTION_NOT_ALLOWED`           | domestic_debit_transaction_not_allowed             |
| `POLICY_RELATED`                                   | policy_related                                     |
| `FRAUD_SECURITY_RELATED`                           | fraud_security_related                             |
| `INVALID_AUTHORIZATION_LIFE_CYCLE`                 | invalid_authorization_life_cycle                   |
| `PURCHASE_AMOUNT_ONLY_NO_CASH_BACK_ALLOWED`        | purchase_amount_only_no_cash_back_allowed          |
| `CRYPTOGRAPHIC_FAILURE`                            | cryptographic_failure                              |
| `UNACCEPTABLE_PIN`                                 | unacceptable_pin                                   |
| `REFER_TO_CARD_ISSUER_SPECIAL_CONDITION`           | refer_to_card_issuer_special_condition             |
| `PICK_UP_CARD_SPECIAL_CONDITION`                   | pick_up_card_special_condition                     |
| `VIP_APPROVAL`                                     | vip_approval                                       |
| `INVALID_ACCOUNT_NUMBER`                           | invalid_account_number                             |
| `RE_ENTER_TRANSACTION`                             | re_enter_transaction                               |
| `NO_ACTION_TAKEN`                                  | no_action_taken                                    |
| `UNABLE_TO_LOCATE_RECORD`                          | unable_to_locate_record                            |
| `FILE_TEMPORARILY_UNAVAILABLE`                     | file_temporarily_unavailable                       |
| `NO_CREDIT_ACCOUNT`                                | no_credit_account                                  |
| `CLOSED_ACCOUNT`                                   | closed_account                                     |
| `NO_CHECKING_ACCOUNT`                              | no_checking_account                                |
| `NO_SAVINGS_ACCOUNT`                               | no_savings_account                                 |
| `SUSPECTED_FRAUD`                                  | suspected_fraud                                    |
| `TRANSACTION_DOES_NOT_FULFILL_AML_REQUIREMENT`     | transaction_does_not_fulfill_aml_requirement       |
| `PIN_DATA_REQUIRED`                                | pin_data_required                                  |
| `UNABLE_TO_LOCATE_PREVIOUS_MESSAGE`                | unable_to_locate_previous_message                  |
| `PREVIOUS_MESSAGE_LOCATED_INCONSISTENT_DATA`       | previous_message_located_inconsistent_data         |
| `BLOCKED_FIRST_USED`                               | blocked_first_used                                 |
| `TRANSACTION_REVERSED`                             | transaction_reversed                               |
| `CREDIT_ISSUER_UNAVAILABLE`                        | credit_issuer_unavailable                          |
| `PIN_CRYPTOGRAPHIC_ERROR_FOUND`                    | pin_cryptographic_error_found                      |
| `NEGATIVE_ONLINE_CAM_RESULT`                       | negative_online_cam_result                         |
| `VIOLATION_OF_LAW`                                 | violation_of_law                                   |
| `FORCE_STIP`                                       | force_stip                                         |
| `CASH_SERVICE_NOT_AVAILABLE`                       | cash_service_not_available                         |
| `CASHBACK_REQUEST_EXCEEDS_ISSUER_LIMIT`            | cashback_request_exceeds_issuer_limit              |
| `DECLINE_FOR_CVV2_FAILURE`                         | decline_for_cvv2_failure                           |
| `TRANSACTION_AMOUNT_EXCEEDS_PRE_AUTHORIZED_AMOUNT` | transaction_amount_exceeds_pre_authorized_amount   |
| `INVALID_BILLER_INFORMATION`                       | invalid_biller_information                         |
| `PIN_CHANGE_UNBLOCK_REQUEST_DECLINED`              | pin_change_unblock_request_declined                |
| `UNSAFE_PIN`                                       | unsafe_pin                                         |
| `CARD_AUTHENTICATION_FAILED`                       | card_authentication_failed                         |
| `STOP_PAYMENT_ORDER`                               | stop_payment_order                                 |
| `REVOCATION_OF_AUTHORIZATION`                      | revocation_of_authorization                        |
| `REVOCATION_OF_ALL_AUTHORIZATIONS`                 | revocation_of_all_authorizations                   |
| `FORWARD_TO_ISSUER_XA`                             | forward_to_issuer_xa                               |
| `FORWARD_TO_ISSUER_XD`                             | forward_to_issuer_xd                               |
| `UNABLE_TO_GO_ONLINE`                              | unable_to_go_online                                |
| `ADDITIONAL_CUSTOMER_AUTHENTICATION_REQUIRED`      | additional_customer_authentication_required        |