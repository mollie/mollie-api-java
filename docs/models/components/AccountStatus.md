# AccountStatus

The status of the business account.

## Example Usage

```java
import com.mollie.mollie.models.components.AccountStatus;

AccountStatus value = AccountStatus.ACTIVE;

// Open enum: use .of() to create instances from custom string values
AccountStatus custom = AccountStatus.of("custom_value");
```


## Values

| Name      | Value     |
| --------- | --------- |
| `ACTIVE`  | active    |
| `BLOCKED` | blocked   |
| `CLOSED`  | closed    |