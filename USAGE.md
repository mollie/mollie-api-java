<!-- Start SDK Example Usage [usage] -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.Security;
import com.mollie.mollie.models.operations.OauthGenerateTokensResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        Client sdk = Client.builder()
                .security(Security.builder()
                    .oAuth(System.getenv().getOrDefault("O_AUTH", ""))
                    .build())
            .build();

        OauthGenerateTokensResponse res = sdk.oauth().generate()
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .call();

        if (res.body().isPresent()) {
            System.out.println(res.body().get());
        }
    }
}
```
<!-- End SDK Example Usage [usage] -->