# ListEntityMethodAllId

The unique identifier of the payment method. When used during [payment creation](create-payment), the payment
method selection screen will be skipped.

## Example Usage

```java
import com.mollie.mollie.models.components.ListEntityMethodAllId;

ListEntityMethodAllId value = ListEntityMethodAllId.ALMA;

// Open enum: use .of() to create instances from custom string values
ListEntityMethodAllId custom = ListEntityMethodAllId.of("custom_value");
```


## Values

| Name           | Value          |
| -------------- | -------------- |
| `ALMA`         | alma           |
| `APPLEPAY`     | applepay       |
| `BACS`         | bacs           |
| `BANCOMATPAY`  | bancomatpay    |
| `BANCONTACT`   | bancontact     |
| `BANKTRANSFER` | banktransfer   |
| `BELFIUS`      | belfius        |
| `BILLIE`       | billie         |
| `BIZUM`        | bizum          |
| `BLIK`         | blik           |
| `CREDITCARD`   | creditcard     |
| `DIRECTDEBIT`  | directdebit    |
| `EPS`          | eps            |
| `GIFTCARD`     | giftcard       |
| `IDEAL`        | ideal          |
| `IN3`          | in3            |
| `KBC`          | kbc            |
| `KLARNA`       | klarna         |
| `MBWAY`        | mbway          |
| `MOBILEPAY`    | mobilepay      |
| `MULTIBANCO`   | multibanco     |
| `MYBANK`       | mybank         |
| `PAYBYBANK`    | paybybank      |
| `PAYPAL`       | paypal         |
| `PAYSAFECARD`  | paysafecard    |
| `PRZELEWY24`   | przelewy24     |
| `RIVERTY`      | riverty        |
| `SATISPAY`     | satispay       |
| `SWISH`        | swish          |
| `TRUSTLY`      | trustly        |
| `TWINT`        | twint          |
| `VIPPS`        | vipps          |
| `VOUCHER`      | voucher        |