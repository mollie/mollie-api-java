<!-- Start SDK Example Usage [usage] -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.ListBalancesBalancesResponseBody;
import com.mollie.mollie.models.errors.ListBalancesResponseBody;
import com.mollie.mollie.models.operations.ListBalancesResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ListBalancesResponseBody, ListBalancesBalancesResponseBody, Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .apiKey(System.getenv().getOrDefault("API_KEY", ""))
                    .build())
            .build();

        ListBalancesResponse res = sdk.balances().list()
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