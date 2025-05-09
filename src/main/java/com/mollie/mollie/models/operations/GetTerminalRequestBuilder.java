/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.mollie.mollie.models.operations;

import com.fasterxml.jackson.core.type.TypeReference;
import com.mollie.mollie.utils.LazySingletonValue;
import com.mollie.mollie.utils.Options;
import com.mollie.mollie.utils.RetryConfig;
import com.mollie.mollie.utils.Utils;
import java.lang.Boolean;
import java.lang.Exception;
import java.lang.String;
import java.util.Optional;
import org.openapitools.jackson.nullable.JsonNullable;

public class GetTerminalRequestBuilder {

    private String terminalId;
    private JsonNullable<Boolean> testmode = Utils.readDefaultOrConstValue(
                            "testmode",
                            "false",
                            new TypeReference<JsonNullable<Boolean>>() {});
    private Optional<RetryConfig> retryConfig = Optional.empty();
    private final SDKMethodInterfaces.MethodCallGetTerminal sdk;

    public GetTerminalRequestBuilder(SDKMethodInterfaces.MethodCallGetTerminal sdk) {
        this.sdk = sdk;
    }

    public GetTerminalRequestBuilder terminalId(String terminalId) {
        Utils.checkNotNull(terminalId, "terminalId");
        this.terminalId = terminalId;
        return this;
    }

    public GetTerminalRequestBuilder testmode(boolean testmode) {
        Utils.checkNotNull(testmode, "testmode");
        this.testmode = JsonNullable.of(testmode);
        return this;
    }

    public GetTerminalRequestBuilder testmode(JsonNullable<Boolean> testmode) {
        Utils.checkNotNull(testmode, "testmode");
        this.testmode = testmode;
        return this;
    }
                
    public GetTerminalRequestBuilder retryConfig(RetryConfig retryConfig) {
        Utils.checkNotNull(retryConfig, "retryConfig");
        this.retryConfig = Optional.of(retryConfig);
        return this;
    }

    public GetTerminalRequestBuilder retryConfig(Optional<RetryConfig> retryConfig) {
        Utils.checkNotNull(retryConfig, "retryConfig");
        this.retryConfig = retryConfig;
        return this;
    }

    public GetTerminalResponse call() throws Exception {
        if (testmode == null) {
            testmode = _SINGLETON_VALUE_Testmode.value();
        }        Optional<Options> options = Optional.of(Options.builder()
                                                    .retryConfig(retryConfig)
                                                    .build());
        return sdk.get(
            terminalId,
            testmode,
            options);
    }

    private static final LazySingletonValue<JsonNullable<Boolean>> _SINGLETON_VALUE_Testmode =
            new LazySingletonValue<>(
                    "testmode",
                    "false",
                    new TypeReference<JsonNullable<Boolean>>() {});
}
