<!-- Start SDK Example Usage [usage] -->
```java
package hello.world;

import com.mollie.mollie.Client;
import com.mollie.mollie.models.components.OauthGrantType;
import com.mollie.mollie.models.errors.ErrorResponse;
import com.mollie.mollie.models.operations.*;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorResponse, Exception {

        Client sdk = Client.builder()
            .build();

        OauthGenerateTokensResponse res = sdk.oauth().generate()
                .security(OauthGenerateTokensSecurity.builder()
                    .username("")
                    .password("")
                    .build())
                .idempotencyKey("123e4567-e89b-12d3-a456-426")
                .requestBody(OauthGenerateTokensRequestBody.builder()
                    .grantType(OauthGrantType.AUTHORIZATION_CODE)
                    .code("auth_...")
                    .refreshToken("refresh_...")
                    .redirectUri("https://example.com/redirect")
                    .build())
                .call();

        if (res.object().isPresent()) {
            System.out.println(res.object().get());
        }
    }
}
```
<!-- End SDK Example Usage [usage] -->