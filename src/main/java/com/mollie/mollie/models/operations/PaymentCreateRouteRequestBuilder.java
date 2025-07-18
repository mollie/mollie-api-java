/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.mollie.mollie.models.operations;

import static com.mollie.mollie.operations.Operations.RequestOperation;

import com.mollie.mollie.SDKConfiguration;
import com.mollie.mollie.operations.PaymentCreateRouteOperation;
import com.mollie.mollie.utils.Options;
import com.mollie.mollie.utils.RetryConfig;
import com.mollie.mollie.utils.Utils;
import java.lang.Exception;
import java.lang.String;
import java.util.Optional;

public class PaymentCreateRouteRequestBuilder {

    private String paymentId;
    private Optional<? extends PaymentCreateRouteRequestBody> requestBody = Optional.empty();
    private Optional<RetryConfig> retryConfig = Optional.empty();
    private final SDKConfiguration sdkConfiguration;

    public PaymentCreateRouteRequestBuilder(SDKConfiguration sdkConfiguration) {
        this.sdkConfiguration = sdkConfiguration;
    }

    public PaymentCreateRouteRequestBuilder paymentId(String paymentId) {
        Utils.checkNotNull(paymentId, "paymentId");
        this.paymentId = paymentId;
        return this;
    }
                
    public PaymentCreateRouteRequestBuilder requestBody(PaymentCreateRouteRequestBody requestBody) {
        Utils.checkNotNull(requestBody, "requestBody");
        this.requestBody = Optional.of(requestBody);
        return this;
    }

    public PaymentCreateRouteRequestBuilder requestBody(Optional<? extends PaymentCreateRouteRequestBody> requestBody) {
        Utils.checkNotNull(requestBody, "requestBody");
        this.requestBody = requestBody;
        return this;
    }
                
    public PaymentCreateRouteRequestBuilder retryConfig(RetryConfig retryConfig) {
        Utils.checkNotNull(retryConfig, "retryConfig");
        this.retryConfig = Optional.of(retryConfig);
        return this;
    }

    public PaymentCreateRouteRequestBuilder retryConfig(Optional<RetryConfig> retryConfig) {
        Utils.checkNotNull(retryConfig, "retryConfig");
        this.retryConfig = retryConfig;
        return this;
    }


    private PaymentCreateRouteRequest buildRequest() {

        PaymentCreateRouteRequest request = new PaymentCreateRouteRequest(paymentId,
            requestBody);

        return request;
    }

    public PaymentCreateRouteResponse call() throws Exception {
        Optional<Options> options = Optional.of(Options.builder()
            .retryConfig(retryConfig)
            .build());

        RequestOperation<PaymentCreateRouteRequest, PaymentCreateRouteResponse> operation
              = new PaymentCreateRouteOperation(sdkConfiguration, options);
        PaymentCreateRouteRequest request = buildRequest();

        return operation.handleResponse(operation.doRequest(request));
    }
}
