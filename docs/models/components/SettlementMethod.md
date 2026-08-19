# SettlementMethod

The method the cost or revenue subtotal applies to. This is usually a payment method, but can also represent a
correction or transaction type that is not tied to a specific payment method.

## Example Usage

```java
import com.mollie.mollie.models.components.SettlementMethod;

SettlementMethod value = SettlementMethod.ALMA;
```


## Values

| Name                    | Value                   |
| ----------------------- | ----------------------- |
| `ALMA`                  | alma                    |
| `APPLICATIONFEE`        | applicationfee          |
| `AUTHORIZATIONREVERSAL` | authorizationreversal   |
| `BACS`                  | bacs                    |
| `BANCOMATPAY`           | bancomatpay             |
| `BANCONTACT`            | bancontact              |
| `BANKTRANSFER`          | banktransfer            |
| `BELFIUS`               | belfius                 |
| `BILLIE`                | billie                  |
| `BILLINK`               | billink                 |
| `BITCOIN`               | bitcoin                 |
| `BIZUM`                 | bizum                   |
| `BLIK`                  | blik                    |
| `CAPTURE`               | capture                 |
| `CHARGEBACK`            | chargeback              |
| `CREDITCARD`            | creditcard              |
| `DIRECTDEBIT`           | directdebit             |
| `EPS`                   | eps                     |
| `GIFTCARD`              | giftcard                |
| `GIROPAY`               | giropay                 |
| `IDEAL`                 | ideal                   |
| `IN3`                   | in3                     |
| `INGHOMEPAY`            | inghomepay              |
| `KBC`                   | kbc                     |
| `KICKBACK`              | kickback                |
| `KLARNA`                | klarna                  |
| `KLARNAPAYLATER`        | klarnapaylater          |
| `KLARNAPAYNOW`          | klarnapaynow            |
| `KLARNASLICEIT`         | klarnasliceit           |
| `MBWAY`                 | mbway                   |
| `MOBILEPAY`             | mobilepay               |
| `MULTIBANCO`            | multibanco              |
| `MYBANK`                | mybank                  |
| `PAYBYBANK`             | paybybank               |
| `PAYPAL`                | paypal                  |
| `PAYSAFECARD`           | paysafecard             |
| `PODIUMCADEAUKAART`     | podiumcadeaukaart       |
| `POINTOFSALE`           | pointofsale             |
| `PRZELEWY24`            | przelewy24              |
| `REFUND`                | refund                  |
| `RIVERTY`               | riverty                 |
| `ROLLINGRESERVE`        | rollingreserve          |
| `SATISPAY`              | satispay                |
| `SHIFTEDFEE`            | shiftedfee              |
| `SOFORT`                | sofort                  |
| `SWISH`                 | swish                   |
| `TRUSTLY`               | trustly                 |
| `TWINT`                 | twint                   |
| `VIPPS`                 | vipps                   |
| `VOUCHER`               | voucher                 |