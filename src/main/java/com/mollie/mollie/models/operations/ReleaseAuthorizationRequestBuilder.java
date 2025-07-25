/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.mollie.mollie.models.operations;

import static com.mollie.mollie.operations.Operations.RequestOperation;

import com.mollie.mollie.SDKConfiguration;
import com.mollie.mollie.operations.ReleaseAuthorizationOperation;
import com.mollie.mollie.utils.Options;
import com.mollie.mollie.utils.RetryConfig;
import com.mollie.mollie.utils.Utils;
import java.lang.Exception;
import java.lang.String;
import java.util.Optional;

public class ReleaseAuthorizationRequestBuilder {

    private String paymentId;
    private Optional<? extends ReleaseAuthorizationRequestBody> requestBody = Optional.empty();
    private Optional<RetryConfig> retryConfig = Optional.empty();
    private final SDKConfiguration sdkConfiguration;

    public ReleaseAuthorizationRequestBuilder(SDKConfiguration sdkConfiguration) {
        this.sdkConfiguration = sdkConfiguration;
    }

    public ReleaseAuthorizationRequestBuilder paymentId(String paymentId) {
        Utils.checkNotNull(paymentId, "paymentId");
        this.paymentId = paymentId;
        return this;
    }
                
    public ReleaseAuthorizationRequestBuilder requestBody(ReleaseAuthorizationRequestBody requestBody) {
        Utils.checkNotNull(requestBody, "requestBody");
        this.requestBody = Optional.of(requestBody);
        return this;
    }

    public ReleaseAuthorizationRequestBuilder requestBody(Optional<? extends ReleaseAuthorizationRequestBody> requestBody) {
        Utils.checkNotNull(requestBody, "requestBody");
        this.requestBody = requestBody;
        return this;
    }
                
    public ReleaseAuthorizationRequestBuilder retryConfig(RetryConfig retryConfig) {
        Utils.checkNotNull(retryConfig, "retryConfig");
        this.retryConfig = Optional.of(retryConfig);
        return this;
    }

    public ReleaseAuthorizationRequestBuilder retryConfig(Optional<RetryConfig> retryConfig) {
        Utils.checkNotNull(retryConfig, "retryConfig");
        this.retryConfig = retryConfig;
        return this;
    }


    private ReleaseAuthorizationRequest buildRequest() {

        ReleaseAuthorizationRequest request = new ReleaseAuthorizationRequest(paymentId,
            requestBody);

        return request;
    }

    public ReleaseAuthorizationResponse call() throws Exception {
        Optional<Options> options = Optional.of(Options.builder()
            .retryConfig(retryConfig)
            .build());

        RequestOperation<ReleaseAuthorizationRequest, ReleaseAuthorizationResponse> operation
              = new ReleaseAuthorizationOperation(sdkConfiguration, options);
        ReleaseAuthorizationRequest request = buildRequest();

        return operation.handleResponse(operation.doRequest(request));
    }
}
