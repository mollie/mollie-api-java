# CaptureMode

Indicate if the funds should be captured immediately or if you want to [place a hold](https://docs.mollie.com/docs/place-a-hold-for-a-payment#/) 
and capture at a later time.

This field needs to be set to `manual` for method `riverty`.

## Example Usage

```java
import com.mollie.mollie.models.components.CaptureMode;

CaptureMode value = CaptureMode.AUTOMATIC;
```


## Values

| Name        | Value       |
| ----------- | ----------- |
| `AUTOMATIC` | automatic   |
| `MANUAL`    | manual      |