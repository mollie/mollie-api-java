# CaptureModeResponse

Indicate if the funds should be captured immediately or if you want to [place a hold](https://docs.mollie.com/docs/place-a-hold-for-a-payment#/) 
and capture at a later time.

This field needs to be set to `manual` for method `riverty`.

## Example Usage

```java
import com.mollie.mollie.models.components.CaptureModeResponse;

CaptureModeResponse value = CaptureModeResponse.AUTOMATIC;

// Open enum: use .of() to create instances from custom string values
CaptureModeResponse custom = CaptureModeResponse.of("custom_value");
```


## Values

| Name        | Value       |
| ----------- | ----------- |
| `AUTOMATIC` | automatic   |
| `MANUAL`    | manual      |