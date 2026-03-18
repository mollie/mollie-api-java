# SessionResponseStatus

The session's status.

## Example Usage

```java
import com.mollie.mollie.models.components.SessionResponseStatus;

SessionResponseStatus value = SessionResponseStatus.OPEN;

// Open enum: use .of() to create instances from custom string values
SessionResponseStatus custom = SessionResponseStatus.of("custom_value");
```


## Values

| Name        | Value       |
| ----------- | ----------- |
| `OPEN`      | open        |
| `COMPLETED` | completed   |
| `EXPIRED`   | expired     |