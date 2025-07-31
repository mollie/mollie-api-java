# CreateCustomerPaymentCustomersLocale

Allows you to preset the language to be used in the hosted payment pages shown to the customer. Setting a locale
is highly recommended and will greatly improve your conversion rate. When this parameter is omitted the browser
language will be used instead if supported by the payment method. You can provide any `xx_XX` format ISO 15897
locale, but our hosted payment pages currently only support the specified languages.

For bank transfer payments specifically, the locale will determine the target bank account the customer has to
transfer the money to. We have dedicated bank accounts for Belgium, Germany, and The Netherlands. Having the
customer use a local bank account greatly increases the conversion and speed of payment.


## Values

| Name    | Value   |
| ------- | ------- |
| `EN_US` | en_US   |
| `EN_GB` | en_GB   |
| `NLNL`  | nl_NL   |
| `NL_BE` | nl_BE   |
| `DEDE`  | de_DE   |
| `DE_AT` | de_AT   |
| `DE_CH` | de_CH   |
| `FRFR`  | fr_FR   |
| `FR_BE` | fr_BE   |
| `ESES`  | es_ES   |
| `CA_ES` | ca_ES   |
| `PTPT`  | pt_PT   |
| `ITIT`  | it_IT   |
| `NB_NO` | nb_NO   |
| `SV_SE` | sv_SE   |
| `FIFI`  | fi_FI   |
| `DA_DK` | da_DK   |
| `ISIS`  | is_IS   |
| `HUHU`  | hu_HU   |
| `PLPL`  | pl_PL   |
| `LVLV`  | lv_LV   |
| `LTLT`  | lt_LT   |