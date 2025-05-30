/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.mollie.mollie.models.operations;

import com.mollie.mollie.utils.Options;
import com.mollie.mollie.utils.RetryConfig;
import com.mollie.mollie.utils.Utils;
import java.lang.Exception;
import java.lang.String;
import java.util.Optional;

public class UpdatePaymentLinkRequestBuilder {

    private String paymentLinkId;
    private Optional<? extends UpdatePaymentLinkRequestBody> requestBody = Optional.empty();
    private Optional<RetryConfig> retryConfig = Optional.empty();
    private final SDKMethodInterfaces.MethodCallUpdatePaymentLink sdk;

    public UpdatePaymentLinkRequestBuilder(SDKMethodInterfaces.MethodCallUpdatePaymentLink sdk) {
        this.sdk = sdk;
    }

    public UpdatePaymentLinkRequestBuilder paymentLinkId(String paymentLinkId) {
        Utils.checkNotNull(paymentLinkId, "paymentLinkId");
        this.paymentLinkId = paymentLinkId;
        return this;
    }
                
    public UpdatePaymentLinkRequestBuilder requestBody(UpdatePaymentLinkRequestBody requestBody) {
        Utils.checkNotNull(requestBody, "requestBody");
        this.requestBody = Optional.of(requestBody);
        return this;
    }

    public UpdatePaymentLinkRequestBuilder requestBody(Optional<? extends UpdatePaymentLinkRequestBody> requestBody) {
        Utils.checkNotNull(requestBody, "requestBody");
        this.requestBody = requestBody;
        return this;
    }
                
    public UpdatePaymentLinkRequestBuilder retryConfig(RetryConfig retryConfig) {
        Utils.checkNotNull(retryConfig, "retryConfig");
        this.retryConfig = Optional.of(retryConfig);
        return this;
    }

    public UpdatePaymentLinkRequestBuilder retryConfig(Optional<RetryConfig> retryConfig) {
        Utils.checkNotNull(retryConfig, "retryConfig");
        this.retryConfig = retryConfig;
        return this;
    }

    public UpdatePaymentLinkResponse call() throws Exception {
        Optional<Options> options = Optional.of(Options.builder()
                                                    .retryConfig(retryConfig)
                                                    .build());
        return sdk.update(
            paymentLinkId,
            requestBody,
            options);
    }
}
