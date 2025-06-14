/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.mollie.mollie.models.operations;

import com.mollie.mollie.utils.Options;
import com.mollie.mollie.utils.RetryConfig;
import com.mollie.mollie.utils.Utils;
import java.lang.Boolean;
import java.lang.Exception;
import java.lang.String;
import java.util.Optional;
import org.openapitools.jackson.nullable.JsonNullable;

public class DeleteWebhookRequestBuilder {

    private String id;
    private JsonNullable<Boolean> testmode = JsonNullable.undefined();
    private Optional<RetryConfig> retryConfig = Optional.empty();
    private final SDKMethodInterfaces.MethodCallDeleteWebhook sdk;

    public DeleteWebhookRequestBuilder(SDKMethodInterfaces.MethodCallDeleteWebhook sdk) {
        this.sdk = sdk;
    }

    public DeleteWebhookRequestBuilder id(String id) {
        Utils.checkNotNull(id, "id");
        this.id = id;
        return this;
    }

    public DeleteWebhookRequestBuilder testmode(boolean testmode) {
        Utils.checkNotNull(testmode, "testmode");
        this.testmode = JsonNullable.of(testmode);
        return this;
    }

    public DeleteWebhookRequestBuilder testmode(JsonNullable<Boolean> testmode) {
        Utils.checkNotNull(testmode, "testmode");
        this.testmode = testmode;
        return this;
    }
                
    public DeleteWebhookRequestBuilder retryConfig(RetryConfig retryConfig) {
        Utils.checkNotNull(retryConfig, "retryConfig");
        this.retryConfig = Optional.of(retryConfig);
        return this;
    }

    public DeleteWebhookRequestBuilder retryConfig(Optional<RetryConfig> retryConfig) {
        Utils.checkNotNull(retryConfig, "retryConfig");
        this.retryConfig = retryConfig;
        return this;
    }

    public DeleteWebhookResponse call() throws Exception {
        Optional<Options> options = Optional.of(Options.builder()
                                                    .retryConfig(retryConfig)
                                                    .build());
        return sdk.delete(
            id,
            testmode,
            options);
    }
}
