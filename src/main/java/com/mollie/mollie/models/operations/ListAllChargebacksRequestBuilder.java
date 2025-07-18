/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.mollie.mollie.models.operations;

import static com.mollie.mollie.operations.Operations.RequestOperation;

import com.mollie.mollie.SDKConfiguration;
import com.mollie.mollie.operations.ListAllChargebacksOperation;
import com.mollie.mollie.utils.Options;
import com.mollie.mollie.utils.RetryConfig;
import com.mollie.mollie.utils.Utils;
import java.lang.Exception;
import java.util.Optional;

public class ListAllChargebacksRequestBuilder {

    private ListAllChargebacksRequest request;
    private Optional<RetryConfig> retryConfig = Optional.empty();
    private final SDKConfiguration sdkConfiguration;

    public ListAllChargebacksRequestBuilder(SDKConfiguration sdkConfiguration) {
        this.sdkConfiguration = sdkConfiguration;
    }

    public ListAllChargebacksRequestBuilder request(ListAllChargebacksRequest request) {
        Utils.checkNotNull(request, "request");
        this.request = request;
        return this;
    }
                
    public ListAllChargebacksRequestBuilder retryConfig(RetryConfig retryConfig) {
        Utils.checkNotNull(retryConfig, "retryConfig");
        this.retryConfig = Optional.of(retryConfig);
        return this;
    }

    public ListAllChargebacksRequestBuilder retryConfig(Optional<RetryConfig> retryConfig) {
        Utils.checkNotNull(retryConfig, "retryConfig");
        this.retryConfig = retryConfig;
        return this;
    }

    public ListAllChargebacksResponse call() throws Exception {
        Optional<Options> options = Optional.of(Options.builder()
            .retryConfig(retryConfig)
            .build());

        RequestOperation<ListAllChargebacksRequest, ListAllChargebacksResponse> operation
              = new ListAllChargebacksOperation(sdkConfiguration, options);

        return operation.handleResponse(operation.doRequest(request));
    }
}
