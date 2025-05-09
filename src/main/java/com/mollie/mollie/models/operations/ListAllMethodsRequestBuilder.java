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
import org.openapitools.jackson.nullable.JsonNullable;

public class ListAllMethodsRequestBuilder {

    private Optional<String> locale = Optional.empty();
    private Optional<? extends ListAllMethodsQueryParamAmount> amount = Optional.empty();
    private JsonNullable<? extends ListAllMethodsQueryParamInclude> include = JsonNullable.undefined();
    private Optional<String> sequenceType = Optional.empty();
    private Optional<RetryConfig> retryConfig = Optional.empty();
    private final SDKMethodInterfaces.MethodCallListAllMethods sdk;

    public ListAllMethodsRequestBuilder(SDKMethodInterfaces.MethodCallListAllMethods sdk) {
        this.sdk = sdk;
    }
                
    public ListAllMethodsRequestBuilder locale(String locale) {
        Utils.checkNotNull(locale, "locale");
        this.locale = Optional.of(locale);
        return this;
    }

    public ListAllMethodsRequestBuilder locale(Optional<String> locale) {
        Utils.checkNotNull(locale, "locale");
        this.locale = locale;
        return this;
    }
                
    public ListAllMethodsRequestBuilder amount(ListAllMethodsQueryParamAmount amount) {
        Utils.checkNotNull(amount, "amount");
        this.amount = Optional.of(amount);
        return this;
    }

    public ListAllMethodsRequestBuilder amount(Optional<? extends ListAllMethodsQueryParamAmount> amount) {
        Utils.checkNotNull(amount, "amount");
        this.amount = amount;
        return this;
    }

    public ListAllMethodsRequestBuilder include(ListAllMethodsQueryParamInclude include) {
        Utils.checkNotNull(include, "include");
        this.include = JsonNullable.of(include);
        return this;
    }

    public ListAllMethodsRequestBuilder include(JsonNullable<? extends ListAllMethodsQueryParamInclude> include) {
        Utils.checkNotNull(include, "include");
        this.include = include;
        return this;
    }
                
    public ListAllMethodsRequestBuilder sequenceType(String sequenceType) {
        Utils.checkNotNull(sequenceType, "sequenceType");
        this.sequenceType = Optional.of(sequenceType);
        return this;
    }

    public ListAllMethodsRequestBuilder sequenceType(Optional<String> sequenceType) {
        Utils.checkNotNull(sequenceType, "sequenceType");
        this.sequenceType = sequenceType;
        return this;
    }
                
    public ListAllMethodsRequestBuilder retryConfig(RetryConfig retryConfig) {
        Utils.checkNotNull(retryConfig, "retryConfig");
        this.retryConfig = Optional.of(retryConfig);
        return this;
    }

    public ListAllMethodsRequestBuilder retryConfig(Optional<RetryConfig> retryConfig) {
        Utils.checkNotNull(retryConfig, "retryConfig");
        this.retryConfig = retryConfig;
        return this;
    }

    public ListAllMethodsResponse call() throws Exception {
        Optional<Options> options = Optional.of(Options.builder()
                                                    .retryConfig(retryConfig)
                                                    .build());
        return sdk.all(
            locale,
            amount,
            include,
            sequenceType,
            options);
    }
}
