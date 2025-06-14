/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.mollie.mollie;

import com.fasterxml.jackson.core.type.TypeReference;
import com.mollie.mollie.models.errors.APIException;
import com.mollie.mollie.models.errors.RequestApplePayPaymentSessionResponseBody;
import com.mollie.mollie.models.operations.RequestApplePayPaymentSessionRequestBody;
import com.mollie.mollie.models.operations.RequestApplePayPaymentSessionRequestBuilder;
import com.mollie.mollie.models.operations.RequestApplePayPaymentSessionResponse;
import com.mollie.mollie.models.operations.SDKMethodInterfaces.*;
import com.mollie.mollie.utils.BackoffStrategy;
import com.mollie.mollie.utils.HTTPClient;
import com.mollie.mollie.utils.HTTPRequest;
import com.mollie.mollie.utils.Hook.AfterErrorContextImpl;
import com.mollie.mollie.utils.Hook.AfterSuccessContextImpl;
import com.mollie.mollie.utils.Hook.BeforeRequestContextImpl;
import com.mollie.mollie.utils.Options;
import com.mollie.mollie.utils.Retries.NonRetryableException;
import com.mollie.mollie.utils.Retries;
import com.mollie.mollie.utils.RetryConfig;
import com.mollie.mollie.utils.SerializedBody;
import com.mollie.mollie.utils.Utils.JsonShape;
import com.mollie.mollie.utils.Utils;
import java.io.InputStream;
import java.lang.Exception;
import java.lang.Object;
import java.lang.String;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

public class Wallets implements
            MethodCallRequestApplePayPaymentSession {

    private final SDKConfiguration sdkConfiguration;

    Wallets(SDKConfiguration sdkConfiguration) {
        this.sdkConfiguration = sdkConfiguration;
    }

    /**
     * Request Apple Pay payment session
     * 
     * <p>When integrating Apple Pay in your own checkout on the web, you need to [provide merchant validation](https://developer.apple.com/documentation/apple_pay_on_the_web/apple_pay_js_api/providing_merchant_validation). This is normally done using Apple's [Requesting an Apple Pay Session](https://developer.apple.com/documentation/apple_pay_on_the_web/apple_pay_js_api/requesting_an_apple_pay_payment_session). The merchant validation proves to Apple that a validated merchant is calling the Apple Pay Javascript APIs.
     * 
     * <p>To integrate Apple Pay via Mollie, you will have to call the Mollie API instead of Apple's API. The response of this API call can then be passed as-is to the completion method, `completeMerchantValidation`.
     * 
     * <p>Before requesting an Apple Pay Payment Session, you must place the domain validation file on your server at: `https://[domain]/.well-known/apple-developer-merchantid-domain-association`. Without this file, it will not be possible to use Apple Pay on your domain.
     * 
     * <p>Each new transaction requires a new payment session object. Merchant session objects are not reusable, and they expire after five minutes.
     * 
     * <p>Payment sessions cannot be requested directly from the browser. The request must be sent from your server. For the full documentation, see the official [Apple Pay JS API](https://developer.apple.com/documentation/apple_pay_on_the_web/apple_pay_js_api) documentation.
     * 
     * <p>&gt; 🔑 Access with
     * &gt;
     * &gt; [API key](/reference/authentication)
     * &gt;
     * &gt; [Access token with **payments.write**](/reference/authentication)
     * 
     * @return The call builder
     */
    public RequestApplePayPaymentSessionRequestBuilder requestApplePaySession() {
        return new RequestApplePayPaymentSessionRequestBuilder(this);
    }

    /**
     * Request Apple Pay payment session
     * 
     * <p>When integrating Apple Pay in your own checkout on the web, you need to [provide merchant validation](https://developer.apple.com/documentation/apple_pay_on_the_web/apple_pay_js_api/providing_merchant_validation). This is normally done using Apple's [Requesting an Apple Pay Session](https://developer.apple.com/documentation/apple_pay_on_the_web/apple_pay_js_api/requesting_an_apple_pay_payment_session). The merchant validation proves to Apple that a validated merchant is calling the Apple Pay Javascript APIs.
     * 
     * <p>To integrate Apple Pay via Mollie, you will have to call the Mollie API instead of Apple's API. The response of this API call can then be passed as-is to the completion method, `completeMerchantValidation`.
     * 
     * <p>Before requesting an Apple Pay Payment Session, you must place the domain validation file on your server at: `https://[domain]/.well-known/apple-developer-merchantid-domain-association`. Without this file, it will not be possible to use Apple Pay on your domain.
     * 
     * <p>Each new transaction requires a new payment session object. Merchant session objects are not reusable, and they expire after five minutes.
     * 
     * <p>Payment sessions cannot be requested directly from the browser. The request must be sent from your server. For the full documentation, see the official [Apple Pay JS API](https://developer.apple.com/documentation/apple_pay_on_the_web/apple_pay_js_api) documentation.
     * 
     * <p>&gt; 🔑 Access with
     * &gt;
     * &gt; [API key](/reference/authentication)
     * &gt;
     * &gt; [Access token with **payments.write**](/reference/authentication)
     * 
     * @return The response from the API call
     * @throws Exception if the API call fails
     */
    public RequestApplePayPaymentSessionResponse requestApplePaySessionDirect() throws Exception {
        return requestApplePaySession(Optional.empty(), Optional.empty());
    }
    
    /**
     * Request Apple Pay payment session
     * 
     * <p>When integrating Apple Pay in your own checkout on the web, you need to [provide merchant validation](https://developer.apple.com/documentation/apple_pay_on_the_web/apple_pay_js_api/providing_merchant_validation). This is normally done using Apple's [Requesting an Apple Pay Session](https://developer.apple.com/documentation/apple_pay_on_the_web/apple_pay_js_api/requesting_an_apple_pay_payment_session). The merchant validation proves to Apple that a validated merchant is calling the Apple Pay Javascript APIs.
     * 
     * <p>To integrate Apple Pay via Mollie, you will have to call the Mollie API instead of Apple's API. The response of this API call can then be passed as-is to the completion method, `completeMerchantValidation`.
     * 
     * <p>Before requesting an Apple Pay Payment Session, you must place the domain validation file on your server at: `https://[domain]/.well-known/apple-developer-merchantid-domain-association`. Without this file, it will not be possible to use Apple Pay on your domain.
     * 
     * <p>Each new transaction requires a new payment session object. Merchant session objects are not reusable, and they expire after five minutes.
     * 
     * <p>Payment sessions cannot be requested directly from the browser. The request must be sent from your server. For the full documentation, see the official [Apple Pay JS API](https://developer.apple.com/documentation/apple_pay_on_the_web/apple_pay_js_api) documentation.
     * 
     * <p>&gt; 🔑 Access with
     * &gt;
     * &gt; [API key](/reference/authentication)
     * &gt;
     * &gt; [Access token with **payments.write**](/reference/authentication)
     * 
     * @param request The request object containing all of the parameters for the API call.
     * @param options additional options
     * @return The response from the API call
     * @throws Exception if the API call fails
     */
    public RequestApplePayPaymentSessionResponse requestApplePaySession(
            Optional<? extends RequestApplePayPaymentSessionRequestBody> request,
            Optional<Options> options) throws Exception {

        if (options.isPresent()) {
          options.get().validate(Arrays.asList(Options.Option.RETRY_CONFIG));
        }
        String _baseUrl = this.sdkConfiguration.serverUrl();
        String _url = Utils.generateURL(
                _baseUrl,
                "/wallets/applepay/sessions");
        
        HTTPRequest _req = new HTTPRequest(_url, "POST");
        Object _convertedRequest = Utils.convertToShape(
                request, 
                JsonShape.DEFAULT,
                new TypeReference<Optional<? extends RequestApplePayPaymentSessionRequestBody>>() {});
        SerializedBody _serializedRequestBody = Utils.serializeRequestBody(
                _convertedRequest, 
                "request",
                "json",
                false);
        _req.setBody(Optional.ofNullable(_serializedRequestBody));
        _req.addHeader("Accept", "application/hal+json")
            .addHeader("user-agent", 
                SDKConfiguration.USER_AGENT);
        
        Optional<SecuritySource> _hookSecuritySource = Optional.of(this.sdkConfiguration.securitySource());
        Utils.configureSecurity(_req,  
                this.sdkConfiguration.securitySource().getSecurity());
        HTTPClient _client = this.sdkConfiguration.client();
        HTTPRequest _finalReq = _req;
        RetryConfig _retryConfig;
        if (options.isPresent() && options.get().retryConfig().isPresent()) {
            _retryConfig = options.get().retryConfig().get();
        } else if (this.sdkConfiguration.retryConfig().isPresent()) {
            _retryConfig = this.sdkConfiguration.retryConfig().get();
        } else {
            _retryConfig = RetryConfig.builder()
                .backoff(BackoffStrategy.builder()
                            .initialInterval(500, TimeUnit.MILLISECONDS)
                            .maxInterval(60000, TimeUnit.MILLISECONDS)
                            .baseFactor((double)(1.5))
                            .maxElapsedTime(3600000, TimeUnit.MILLISECONDS)
                            .retryConnectError(true)
                            .build())
                .build();
        }
        List<String> _statusCodes = new ArrayList<>();
        _statusCodes.add("5xx");
        Retries _retries = Retries.builder()
            .action(() -> {
                HttpRequest _r = null;
                try {
                    _r = sdkConfiguration.hooks()
                        .beforeRequest(
                            new BeforeRequestContextImpl(
                                this.sdkConfiguration,
                                _baseUrl,
                                "request-apple-pay-payment-session", 
                                Optional.of(List.of()), 
                                _hookSecuritySource),
                            _finalReq.build());
                } catch (Exception _e) {
                    throw new NonRetryableException(_e);
                }
                try {
                    return _client.send(_r);
                } catch (Exception _e) {
                    return sdkConfiguration.hooks()
                        .afterError(
                            new AfterErrorContextImpl(
                                this.sdkConfiguration,
                                _baseUrl,
                                "request-apple-pay-payment-session",
                                 Optional.of(List.of()),
                                 _hookSecuritySource), 
                            Optional.empty(),
                            Optional.of(_e));
                }
            })
            .retryConfig(_retryConfig)
            .statusCodes(_statusCodes)
            .build();
        HttpResponse<InputStream> _httpRes = sdkConfiguration.hooks()
                 .afterSuccess(
                     new AfterSuccessContextImpl(
                         this.sdkConfiguration,
                         _baseUrl,
                         "request-apple-pay-payment-session", 
                         Optional.of(List.of()), 
                         _hookSecuritySource),
                     _retries.run());
        String _contentType = _httpRes
            .headers()
            .firstValue("Content-Type")
            .orElse("application/octet-stream");
        RequestApplePayPaymentSessionResponse.Builder _resBuilder = 
            RequestApplePayPaymentSessionResponse
                .builder()
                .contentType(_contentType)
                .statusCode(_httpRes.statusCode())
                .rawResponse(_httpRes);

        RequestApplePayPaymentSessionResponse _res = _resBuilder.build();
        
        if (Utils.statusCodeMatches(_httpRes.statusCode(), "201")) {
            if (Utils.contentTypeMatches(_contentType, "application/hal+json")) {
                Map<String, Object> _out = Utils.mapper().readValue(
                    Utils.toUtf8AndClose(_httpRes.body()),
                    new TypeReference<Map<String, Object>>() {});
                _res.withObject(Optional.ofNullable(_out));
                return _res;
            } else {
                throw new APIException(
                    _httpRes, 
                    _httpRes.statusCode(), 
                    "Unexpected content-type received: " + _contentType, 
                    Utils.extractByteArrayFromBody(_httpRes));
            }
        }
        if (Utils.statusCodeMatches(_httpRes.statusCode(), "422")) {
            if (Utils.contentTypeMatches(_contentType, "application/hal+json")) {
                RequestApplePayPaymentSessionResponseBody _out = Utils.mapper().readValue(
                    Utils.toUtf8AndClose(_httpRes.body()),
                    new TypeReference<RequestApplePayPaymentSessionResponseBody>() {});
                    _out.withRawResponse(Optional.ofNullable(_httpRes));
                
                throw _out;
            } else {
                throw new APIException(
                    _httpRes, 
                    _httpRes.statusCode(), 
                    "Unexpected content-type received: " + _contentType, 
                    Utils.extractByteArrayFromBody(_httpRes));
            }
        }
        if (Utils.statusCodeMatches(_httpRes.statusCode(), "4XX")) {
            // no content 
            throw new APIException(
                    _httpRes, 
                    _httpRes.statusCode(), 
                    "API error occurred", 
                    Utils.extractByteArrayFromBody(_httpRes));
        }
        if (Utils.statusCodeMatches(_httpRes.statusCode(), "5XX")) {
            // no content 
            throw new APIException(
                    _httpRes, 
                    _httpRes.statusCode(), 
                    "API error occurred", 
                    Utils.extractByteArrayFromBody(_httpRes));
        }
        throw new APIException(
            _httpRes, 
            _httpRes.statusCode(), 
            "Unexpected status code received: " + _httpRes.statusCode(), 
            Utils.extractByteArrayFromBody(_httpRes));
    }

}
