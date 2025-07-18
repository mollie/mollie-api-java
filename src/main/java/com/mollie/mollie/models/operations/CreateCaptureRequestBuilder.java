/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.mollie.mollie.models.operations;

import static com.mollie.mollie.operations.Operations.RequestOperation;

import com.mollie.mollie.SDKConfiguration;
import com.mollie.mollie.operations.CreateCaptureOperation;
import com.mollie.mollie.utils.Options;
import com.mollie.mollie.utils.RetryConfig;
import com.mollie.mollie.utils.Utils;
import java.lang.Exception;
import java.lang.String;
import java.util.Optional;

public class CreateCaptureRequestBuilder {

    private String paymentId;
    private Optional<? extends CreateCaptureRequestBody> requestBody = Optional.empty();
    private Optional<RetryConfig> retryConfig = Optional.empty();
    private final SDKConfiguration sdkConfiguration;

    public CreateCaptureRequestBuilder(SDKConfiguration sdkConfiguration) {
        this.sdkConfiguration = sdkConfiguration;
    }

    public CreateCaptureRequestBuilder paymentId(String paymentId) {
        Utils.checkNotNull(paymentId, "paymentId");
        this.paymentId = paymentId;
        return this;
    }
                
    public CreateCaptureRequestBuilder requestBody(CreateCaptureRequestBody requestBody) {
        Utils.checkNotNull(requestBody, "requestBody");
        this.requestBody = Optional.of(requestBody);
        return this;
    }

    public CreateCaptureRequestBuilder requestBody(Optional<? extends CreateCaptureRequestBody> requestBody) {
        Utils.checkNotNull(requestBody, "requestBody");
        this.requestBody = requestBody;
        return this;
    }
                
    public CreateCaptureRequestBuilder retryConfig(RetryConfig retryConfig) {
        Utils.checkNotNull(retryConfig, "retryConfig");
        this.retryConfig = Optional.of(retryConfig);
        return this;
    }

    public CreateCaptureRequestBuilder retryConfig(Optional<RetryConfig> retryConfig) {
        Utils.checkNotNull(retryConfig, "retryConfig");
        this.retryConfig = retryConfig;
        return this;
    }


    private CreateCaptureRequest buildRequest() {

        CreateCaptureRequest request = new CreateCaptureRequest(paymentId,
            requestBody);

        return request;
    }

    public CreateCaptureResponse call() throws Exception {
        Optional<Options> options = Optional.of(Options.builder()
            .retryConfig(retryConfig)
            .build());

        RequestOperation<CreateCaptureRequest, CreateCaptureResponse> operation
              = new CreateCaptureOperation(sdkConfiguration, options);
        CreateCaptureRequest request = buildRequest();

        return operation.handleResponse(operation.doRequest(request));
    }
}
