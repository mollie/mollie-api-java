/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.mollie.mollie.models.operations;

import static com.mollie.mollie.operations.Operations.RequestOperation;

import com.mollie.mollie.SDKConfiguration;
import com.mollie.mollie.operations.GetPaymentOperation;
import com.mollie.mollie.utils.Options;
import com.mollie.mollie.utils.RetryConfig;
import com.mollie.mollie.utils.Utils;
import java.lang.Boolean;
import java.lang.Exception;
import java.lang.String;
import java.util.Optional;
import org.openapitools.jackson.nullable.JsonNullable;

public class GetPaymentRequestBuilder {

    private String paymentId;
    private JsonNullable<? extends QueryParamInclude> include = JsonNullable.undefined();
    private JsonNullable<? extends Embed> embed = JsonNullable.undefined();
    private JsonNullable<Boolean> testmode = JsonNullable.undefined();
    private Optional<RetryConfig> retryConfig = Optional.empty();
    private final SDKConfiguration sdkConfiguration;

    public GetPaymentRequestBuilder(SDKConfiguration sdkConfiguration) {
        this.sdkConfiguration = sdkConfiguration;
    }

    public GetPaymentRequestBuilder paymentId(String paymentId) {
        Utils.checkNotNull(paymentId, "paymentId");
        this.paymentId = paymentId;
        return this;
    }

    public GetPaymentRequestBuilder include(QueryParamInclude include) {
        Utils.checkNotNull(include, "include");
        this.include = JsonNullable.of(include);
        return this;
    }

    public GetPaymentRequestBuilder include(JsonNullable<? extends QueryParamInclude> include) {
        Utils.checkNotNull(include, "include");
        this.include = include;
        return this;
    }

    public GetPaymentRequestBuilder embed(Embed embed) {
        Utils.checkNotNull(embed, "embed");
        this.embed = JsonNullable.of(embed);
        return this;
    }

    public GetPaymentRequestBuilder embed(JsonNullable<? extends Embed> embed) {
        Utils.checkNotNull(embed, "embed");
        this.embed = embed;
        return this;
    }

    public GetPaymentRequestBuilder testmode(boolean testmode) {
        Utils.checkNotNull(testmode, "testmode");
        this.testmode = JsonNullable.of(testmode);
        return this;
    }

    public GetPaymentRequestBuilder testmode(JsonNullable<Boolean> testmode) {
        Utils.checkNotNull(testmode, "testmode");
        this.testmode = testmode;
        return this;
    }
                
    public GetPaymentRequestBuilder retryConfig(RetryConfig retryConfig) {
        Utils.checkNotNull(retryConfig, "retryConfig");
        this.retryConfig = Optional.of(retryConfig);
        return this;
    }

    public GetPaymentRequestBuilder retryConfig(Optional<RetryConfig> retryConfig) {
        Utils.checkNotNull(retryConfig, "retryConfig");
        this.retryConfig = retryConfig;
        return this;
    }


    private GetPaymentRequest buildRequest() {

        GetPaymentRequest request = new GetPaymentRequest(paymentId,
            include,
            embed,
            testmode);

        return request;
    }

    public GetPaymentResponse call() throws Exception {
        Optional<Options> options = Optional.of(Options.builder()
            .retryConfig(retryConfig)
            .build());

        RequestOperation<GetPaymentRequest, GetPaymentResponse> operation
              = new GetPaymentOperation(sdkConfiguration, options);
        GetPaymentRequest request = buildRequest();

        return operation.handleResponse(operation.doRequest(request));
    }
}
