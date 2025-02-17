<!-- Start SDK Example Usage [usage] -->
```java
package hello.world;

import com.mollie.mollie.Mollie;
import com.mollie.mollie.models.errors.ListBalancesBalancesAPIResponseBody;
import com.mollie.mollie.models.errors.ListBalancesResponseBody;
import com.mollie.mollie.models.operations.ListBalancesResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ListBalancesResponseBody, ListBalancesBalancesAPIResponseBody, Exception {

        Mollie sdk = Mollie.builder()
                .oAuth("<YOUR_O_AUTH_HERE>")
            .build();

        ListBalancesResponse res = sdk.balancesAPI().list()
                .currency("EUR")
                .from("bal_gVMhHKqSSRYJyPsuoPNFH")
                .limit(50L)
                .testmode(false)
                .call();

        if (res.object().isPresent()) {
            // handle response
        }
    }
}
```
<!-- End SDK Example Usage [usage] -->