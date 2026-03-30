<!-- Start SDK Example Usage [usage] -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.ListBalancesRequest;
import com.mollie.mollie.models.operations.ListBalancesResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
                .testmode(false)
                .security(Security.builder()
                    .organizationAccessToken(System.getenv().getOrDefault("ORGANIZATION_ACCESS_TOKEN", ""))
                    .build())
            .build();

        ListBalancesRequest req = ListBalancesRequest.builder()
                .currency("EUR")
                .from("bal_gVMhHKqSSRYJyPsuoPNFH")
                .limit(50L)
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .build();


        sdk.balances().list()
                .callAsStream()
                .forEach((ListBalancesResponse item) -> {
                   // handle page
                });

    }
}
```
<!-- End SDK Example Usage [usage] -->