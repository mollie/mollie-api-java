/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.mollie.mollie;

import com.fasterxml.jackson.core.type.TypeReference;
import com.mollie.mollie.models.errors.APIException;
import com.mollie.mollie.models.errors.ListAllChargebacksChargebacksResponseBody;
import com.mollie.mollie.models.errors.ListChargebacksChargebacksResponseBody;
import com.mollie.mollie.models.operations.GetChargebackQueryParamEmbed;
import com.mollie.mollie.models.operations.GetChargebackRequest;
import com.mollie.mollie.models.operations.GetChargebackRequestBuilder;
import com.mollie.mollie.models.operations.GetChargebackResponse;
import com.mollie.mollie.models.operations.GetChargebackResponseBody;
import com.mollie.mollie.models.operations.ListAllChargebacksRequest;
import com.mollie.mollie.models.operations.ListAllChargebacksRequestBuilder;
import com.mollie.mollie.models.operations.ListAllChargebacksResponse;
import com.mollie.mollie.models.operations.ListAllChargebacksResponseBody;
import com.mollie.mollie.models.operations.ListChargebacksRequest;
import com.mollie.mollie.models.operations.ListChargebacksRequestBuilder;
import com.mollie.mollie.models.operations.ListChargebacksResponse;
import com.mollie.mollie.models.operations.ListChargebacksResponseBody;
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
import com.mollie.mollie.utils.Utils;
import java.io.InputStream;
import java.lang.Boolean;
import java.lang.Exception;
import java.lang.String;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import org.openapitools.jackson.nullable.JsonNullable;

public class Chargebacks implements
            MethodCallListChargebacks,
            MethodCallGetChargeback,
            MethodCallListAllChargebacks {

    private final SDKConfiguration sdkConfiguration;

    Chargebacks(SDKConfiguration sdkConfiguration) {
        this.sdkConfiguration = sdkConfiguration;
    }

    /**
     * List payment chargebacks
     * 
     * <p>Retrieve the chargebacks initiated for a specific payment.
     * 
     * <p>The results are paginated.
     * 
     * <p>&gt; 🔑 Access with
     * &gt;
     * &gt; [API key](/reference/authentication)
     * &gt;
     * &gt; [Access token with **payments.read**](/reference/authentication)
     * 
     * @return The call builder
     */
    public ListChargebacksRequestBuilder list() {
        return new ListChargebacksRequestBuilder(this);
    }

    /**
     * List payment chargebacks
     * 
     * <p>Retrieve the chargebacks initiated for a specific payment.
     * 
     * <p>The results are paginated.
     * 
     * <p>&gt; 🔑 Access with
     * &gt;
     * &gt; [API key](/reference/authentication)
     * &gt;
     * &gt; [Access token with **payments.read**](/reference/authentication)
     * 
     * @param request The request object containing all of the parameters for the API call.
     * @return The response from the API call
     * @throws Exception if the API call fails
     */
    public ListChargebacksResponse list(
            ListChargebacksRequest request) throws Exception {
        return list(request, Optional.empty());
    }
    
    /**
     * List payment chargebacks
     * 
     * <p>Retrieve the chargebacks initiated for a specific payment.
     * 
     * <p>The results are paginated.
     * 
     * <p>&gt; 🔑 Access with
     * &gt;
     * &gt; [API key](/reference/authentication)
     * &gt;
     * &gt; [Access token with **payments.read**](/reference/authentication)
     * 
     * @param request The request object containing all of the parameters for the API call.
     * @param options additional options
     * @return The response from the API call
     * @throws Exception if the API call fails
     */
    public ListChargebacksResponse list(
            ListChargebacksRequest request,
            Optional<Options> options) throws Exception {

        if (options.isPresent()) {
          options.get().validate(Arrays.asList(Options.Option.RETRY_CONFIG));
        }
        String _baseUrl = this.sdkConfiguration.serverUrl();
        String _url = Utils.generateURL(
                ListChargebacksRequest.class,
                _baseUrl,
                "/payments/{paymentId}/chargebacks",
                request, null);
        
        HTTPRequest _req = new HTTPRequest(_url, "GET");
        _req.addHeader("Accept", "application/hal+json")
            .addHeader("user-agent", 
                SDKConfiguration.USER_AGENT);

        _req.addQueryParams(Utils.getQueryParams(
                ListChargebacksRequest.class,
                request, 
                null));
        
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
                                "list-chargebacks", 
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
                                "list-chargebacks",
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
                         "list-chargebacks", 
                         Optional.of(List.of()), 
                         _hookSecuritySource),
                     _retries.run());
        String _contentType = _httpRes
            .headers()
            .firstValue("Content-Type")
            .orElse("application/octet-stream");
        ListChargebacksResponse.Builder _resBuilder = 
            ListChargebacksResponse
                .builder()
                .contentType(_contentType)
                .statusCode(_httpRes.statusCode())
                .rawResponse(_httpRes);

        ListChargebacksResponse _res = _resBuilder.build();
        
        if (Utils.statusCodeMatches(_httpRes.statusCode(), "200")) {
            if (Utils.contentTypeMatches(_contentType, "application/hal+json")) {
                ListChargebacksResponseBody _out = Utils.mapper().readValue(
                    Utils.toUtf8AndClose(_httpRes.body()),
                    new TypeReference<ListChargebacksResponseBody>() {});
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
        if (Utils.statusCodeMatches(_httpRes.statusCode(), "400")) {
            if (Utils.contentTypeMatches(_contentType, "application/hal+json")) {
                com.mollie.mollie.models.errors.ListChargebacksResponseBody _out = Utils.mapper().readValue(
                    Utils.toUtf8AndClose(_httpRes.body()),
                    new TypeReference<com.mollie.mollie.models.errors.ListChargebacksResponseBody>() {});
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
        if (Utils.statusCodeMatches(_httpRes.statusCode(), "404")) {
            if (Utils.contentTypeMatches(_contentType, "application/hal+json")) {
                ListChargebacksChargebacksResponseBody _out = Utils.mapper().readValue(
                    Utils.toUtf8AndClose(_httpRes.body()),
                    new TypeReference<ListChargebacksChargebacksResponseBody>() {});
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


    /**
     * Get payment chargeback
     * 
     * <p>Retrieve a single payment chargeback by its ID and the ID of its parent payment.
     * 
     * <p>&gt; 🔑 Access with
     * &gt;
     * &gt; [API key](/reference/authentication)
     * &gt;
     * &gt; [Access token with **payments.read**](/reference/authentication)
     * 
     * @return The call builder
     */
    public GetChargebackRequestBuilder get() {
        return new GetChargebackRequestBuilder(this);
    }

    /**
     * Get payment chargeback
     * 
     * <p>Retrieve a single payment chargeback by its ID and the ID of its parent payment.
     * 
     * <p>&gt; 🔑 Access with
     * &gt;
     * &gt; [API key](/reference/authentication)
     * &gt;
     * &gt; [Access token with **payments.read**](/reference/authentication)
     * 
     * @param paymentId Provide the ID of the related payment.
     * @param chargebackId Provide the ID of the related chargeback.
     * @return The response from the API call
     * @throws Exception if the API call fails
     */
    public GetChargebackResponse get(
            String paymentId,
            String chargebackId) throws Exception {
        return get(paymentId, chargebackId, JsonNullable.undefined(), JsonNullable.undefined(), Optional.empty());
    }
    
    /**
     * Get payment chargeback
     * 
     * <p>Retrieve a single payment chargeback by its ID and the ID of its parent payment.
     * 
     * <p>&gt; 🔑 Access with
     * &gt;
     * &gt; [API key](/reference/authentication)
     * &gt;
     * &gt; [Access token with **payments.read**](/reference/authentication)
     * 
     * @param paymentId Provide the ID of the related payment.
     * @param chargebackId Provide the ID of the related chargeback.
     * @param embed This endpoint allows you to embed additional information via the `embed` query string parameter.
     * @param testmode Most API credentials are specifically created for either live mode or test mode. In those cases the `testmode` query parameter can be omitted. For organization-level credentials such as OAuth access tokens, you can enable test mode by setting the `testmode` query parameter to `true`.
     *         
     *         Test entities cannot be retrieved when the endpoint is set to live mode, and vice versa.
     * @param options additional options
     * @return The response from the API call
     * @throws Exception if the API call fails
     */
    public GetChargebackResponse get(
            String paymentId,
            String chargebackId,
            JsonNullable<? extends GetChargebackQueryParamEmbed> embed,
            JsonNullable<Boolean> testmode,
            Optional<Options> options) throws Exception {

        if (options.isPresent()) {
          options.get().validate(Arrays.asList(Options.Option.RETRY_CONFIG));
        }
        GetChargebackRequest request =
            GetChargebackRequest
                .builder()
                .paymentId(paymentId)
                .chargebackId(chargebackId)
                .embed(embed)
                .testmode(testmode)
                .build();
        
        String _baseUrl = this.sdkConfiguration.serverUrl();
        String _url = Utils.generateURL(
                GetChargebackRequest.class,
                _baseUrl,
                "/payments/{paymentId}/chargebacks/{chargebackId}",
                request, null);
        
        HTTPRequest _req = new HTTPRequest(_url, "GET");
        _req.addHeader("Accept", "application/hal+json")
            .addHeader("user-agent", 
                SDKConfiguration.USER_AGENT);

        _req.addQueryParams(Utils.getQueryParams(
                GetChargebackRequest.class,
                request, 
                null));
        
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
                                "get-chargeback", 
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
                                "get-chargeback",
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
                         "get-chargeback", 
                         Optional.of(List.of()), 
                         _hookSecuritySource),
                     _retries.run());
        String _contentType = _httpRes
            .headers()
            .firstValue("Content-Type")
            .orElse("application/octet-stream");
        GetChargebackResponse.Builder _resBuilder = 
            GetChargebackResponse
                .builder()
                .contentType(_contentType)
                .statusCode(_httpRes.statusCode())
                .rawResponse(_httpRes);

        GetChargebackResponse _res = _resBuilder.build();
        
        if (Utils.statusCodeMatches(_httpRes.statusCode(), "200")) {
            if (Utils.contentTypeMatches(_contentType, "application/hal+json")) {
                GetChargebackResponseBody _out = Utils.mapper().readValue(
                    Utils.toUtf8AndClose(_httpRes.body()),
                    new TypeReference<GetChargebackResponseBody>() {});
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
        if (Utils.statusCodeMatches(_httpRes.statusCode(), "404")) {
            if (Utils.contentTypeMatches(_contentType, "application/hal+json")) {
                com.mollie.mollie.models.errors.GetChargebackResponseBody _out = Utils.mapper().readValue(
                    Utils.toUtf8AndClose(_httpRes.body()),
                    new TypeReference<com.mollie.mollie.models.errors.GetChargebackResponseBody>() {});
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


    /**
     * List all chargebacks
     * 
     * <p>Retrieve all chargebacks initiated for all your payments.
     * 
     * <p>The results are paginated.
     * 
     * <p>&gt; 🔑 Access with
     * &gt;
     * &gt; [API key](/reference/authentication)
     * &gt;
     * &gt; [Access token with **payments.read**](/reference/authentication)
     * 
     * @return The call builder
     */
    public ListAllChargebacksRequestBuilder all() {
        return new ListAllChargebacksRequestBuilder(this);
    }

    /**
     * List all chargebacks
     * 
     * <p>Retrieve all chargebacks initiated for all your payments.
     * 
     * <p>The results are paginated.
     * 
     * <p>&gt; 🔑 Access with
     * &gt;
     * &gt; [API key](/reference/authentication)
     * &gt;
     * &gt; [Access token with **payments.read**](/reference/authentication)
     * 
     * @param request The request object containing all of the parameters for the API call.
     * @return The response from the API call
     * @throws Exception if the API call fails
     */
    public ListAllChargebacksResponse all(
            ListAllChargebacksRequest request) throws Exception {
        return all(request, Optional.empty());
    }
    
    /**
     * List all chargebacks
     * 
     * <p>Retrieve all chargebacks initiated for all your payments.
     * 
     * <p>The results are paginated.
     * 
     * <p>&gt; 🔑 Access with
     * &gt;
     * &gt; [API key](/reference/authentication)
     * &gt;
     * &gt; [Access token with **payments.read**](/reference/authentication)
     * 
     * @param request The request object containing all of the parameters for the API call.
     * @param options additional options
     * @return The response from the API call
     * @throws Exception if the API call fails
     */
    public ListAllChargebacksResponse all(
            ListAllChargebacksRequest request,
            Optional<Options> options) throws Exception {

        if (options.isPresent()) {
          options.get().validate(Arrays.asList(Options.Option.RETRY_CONFIG));
        }
        String _baseUrl = this.sdkConfiguration.serverUrl();
        String _url = Utils.generateURL(
                _baseUrl,
                "/chargebacks");
        
        HTTPRequest _req = new HTTPRequest(_url, "GET");
        _req.addHeader("Accept", "application/hal+json")
            .addHeader("user-agent", 
                SDKConfiguration.USER_AGENT);

        _req.addQueryParams(Utils.getQueryParams(
                ListAllChargebacksRequest.class,
                request, 
                null));
        
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
                                "list-all-chargebacks", 
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
                                "list-all-chargebacks",
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
                         "list-all-chargebacks", 
                         Optional.of(List.of()), 
                         _hookSecuritySource),
                     _retries.run());
        String _contentType = _httpRes
            .headers()
            .firstValue("Content-Type")
            .orElse("application/octet-stream");
        ListAllChargebacksResponse.Builder _resBuilder = 
            ListAllChargebacksResponse
                .builder()
                .contentType(_contentType)
                .statusCode(_httpRes.statusCode())
                .rawResponse(_httpRes);

        ListAllChargebacksResponse _res = _resBuilder.build();
        
        if (Utils.statusCodeMatches(_httpRes.statusCode(), "200")) {
            if (Utils.contentTypeMatches(_contentType, "application/hal+json")) {
                ListAllChargebacksResponseBody _out = Utils.mapper().readValue(
                    Utils.toUtf8AndClose(_httpRes.body()),
                    new TypeReference<ListAllChargebacksResponseBody>() {});
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
        if (Utils.statusCodeMatches(_httpRes.statusCode(), "400")) {
            if (Utils.contentTypeMatches(_contentType, "application/hal+json")) {
                com.mollie.mollie.models.errors.ListAllChargebacksResponseBody _out = Utils.mapper().readValue(
                    Utils.toUtf8AndClose(_httpRes.body()),
                    new TypeReference<com.mollie.mollie.models.errors.ListAllChargebacksResponseBody>() {});
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
        if (Utils.statusCodeMatches(_httpRes.statusCode(), "404")) {
            if (Utils.contentTypeMatches(_contentType, "application/hal+json")) {
                ListAllChargebacksChargebacksResponseBody _out = Utils.mapper().readValue(
                    Utils.toUtf8AndClose(_httpRes.body()),
                    new TypeReference<ListAllChargebacksChargebacksResponseBody>() {});
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
