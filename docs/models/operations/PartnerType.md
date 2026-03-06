# PartnerType

Indicates the type of partner. Will be `null` if the currently authenticated organization is not
enrolled as a partner.

## Example Usage

```java
import com.mollie.mollie.models.operations.PartnerType;

PartnerType value = PartnerType.OAUTH;
```


## Values

| Name         | Value        |
| ------------ | ------------ |
| `OAUTH`      | oauth        |
| `SIGNUPLINK` | signuplink   |
| `USERAGENT`  | useragent    |