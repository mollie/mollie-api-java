/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.mollie.mollie;

import static com.mollie.mollie.operations.Operations.RequestOperation;

import com.mollie.mollie.models.operations.GetMethodRequest;
import com.mollie.mollie.models.operations.GetMethodRequestBuilder;
import com.mollie.mollie.models.operations.GetMethodResponse;
import com.mollie.mollie.models.operations.ListAllMethodsRequest;
import com.mollie.mollie.models.operations.ListAllMethodsRequestBuilder;
import com.mollie.mollie.models.operations.ListAllMethodsResponse;
import com.mollie.mollie.models.operations.ListMethodsRequest;
import com.mollie.mollie.models.operations.ListMethodsRequestBuilder;
import com.mollie.mollie.models.operations.ListMethodsResponse;
import com.mollie.mollie.operations.GetMethodOperation;
import com.mollie.mollie.operations.ListAllMethodsOperation;
import com.mollie.mollie.operations.ListMethodsOperation;
import com.mollie.mollie.utils.Options;
import java.lang.Exception;
import java.util.Optional;


public class Methods {
    private final SDKConfiguration sdkConfiguration;

    Methods(SDKConfiguration sdkConfiguration) {
        this.sdkConfiguration = sdkConfiguration;
    }

    /**
     * List payment methods
     * 
     * <p>Retrieve all enabled payment methods. The results of this endpoint are **not** paginated — unlike most other list endpoints in our API.
     * 
     * <p>For test mode, all pending and enabled payment methods are returned. If no payment methods are requested yet, the most popular payment methods are returned in the test mode. For live mode, only fully enabled payment methods are returned.
     * 
     * <p>Payment methods can be requested and enabled via the Mollie Dashboard, or via the [Enable payment method endpoint](enable-method) of the Profiles API.
     * 
     * <p>The list can optionally be filtered using a number of parameters described below.
     * 
     * <p>By default, only payment methods for the Euro currency are returned. If you wish to retrieve payment methods which exclusively support other currencies (e.g. Twint), you need to use the `amount` parameters.
     * 
     * <p>&gt; 🔑 Access with
     * &gt;
     * &gt; [API key](/reference/authentication)
     * &gt;
     * &gt; [Access token with **payments.read**](/reference/authentication)
     * 
     * @return The call builder
     */
    public ListMethodsRequestBuilder list() {
        return new ListMethodsRequestBuilder(sdkConfiguration);
    }

    /**
     * List payment methods
     * 
     * <p>Retrieve all enabled payment methods. The results of this endpoint are **not** paginated — unlike most other list endpoints in our API.
     * 
     * <p>For test mode, all pending and enabled payment methods are returned. If no payment methods are requested yet, the most popular payment methods are returned in the test mode. For live mode, only fully enabled payment methods are returned.
     * 
     * <p>Payment methods can be requested and enabled via the Mollie Dashboard, or via the [Enable payment method endpoint](enable-method) of the Profiles API.
     * 
     * <p>The list can optionally be filtered using a number of parameters described below.
     * 
     * <p>By default, only payment methods for the Euro currency are returned. If you wish to retrieve payment methods which exclusively support other currencies (e.g. Twint), you need to use the `amount` parameters.
     * 
     * <p>&gt; 🔑 Access with
     * &gt;
     * &gt; [API key](/reference/authentication)
     * &gt;
     * &gt; [Access token with **payments.read**](/reference/authentication)
     * 
     * @param request The request object containing all the parameters for the API call.
     * @return The response from the API call
     * @throws Exception if the API call fails
     */
    public ListMethodsResponse list(ListMethodsRequest request) throws Exception {
        return list(request, Optional.empty());
    }

    /**
     * List payment methods
     * 
     * <p>Retrieve all enabled payment methods. The results of this endpoint are **not** paginated — unlike most other list endpoints in our API.
     * 
     * <p>For test mode, all pending and enabled payment methods are returned. If no payment methods are requested yet, the most popular payment methods are returned in the test mode. For live mode, only fully enabled payment methods are returned.
     * 
     * <p>Payment methods can be requested and enabled via the Mollie Dashboard, or via the [Enable payment method endpoint](enable-method) of the Profiles API.
     * 
     * <p>The list can optionally be filtered using a number of parameters described below.
     * 
     * <p>By default, only payment methods for the Euro currency are returned. If you wish to retrieve payment methods which exclusively support other currencies (e.g. Twint), you need to use the `amount` parameters.
     * 
     * <p>&gt; 🔑 Access with
     * &gt;
     * &gt; [API key](/reference/authentication)
     * &gt;
     * &gt; [Access token with **payments.read**](/reference/authentication)
     * 
     * @param request The request object containing all the parameters for the API call.
     * @param options additional options
     * @return The response from the API call
     * @throws Exception if the API call fails
     */
    public ListMethodsResponse list(ListMethodsRequest request, Optional<Options> options) throws Exception {
        RequestOperation<ListMethodsRequest, ListMethodsResponse> operation
              = new ListMethodsOperation(sdkConfiguration, options);
        return operation.handleResponse(operation.doRequest(request));
    }

    /**
     * List all payment methods
     * 
     * <p>Retrieve all payment methods that Mollie offers, regardless of the eligibility of the organization for the specific method. The results of this endpoint are **not** paginated — unlike most other list endpoints in our API.
     * 
     * <p>The list can optionally be filtered using a number of parameters described below.
     * 
     * <p>&gt; 🔑 Access with
     * &gt;
     * &gt; [API key](/reference/authentication)
     * &gt;
     * &gt; [Access token with **payments.read**](/reference/authentication)
     * 
     * @return The call builder
     */
    public ListAllMethodsRequestBuilder all() {
        return new ListAllMethodsRequestBuilder(sdkConfiguration);
    }

    /**
     * List all payment methods
     * 
     * <p>Retrieve all payment methods that Mollie offers, regardless of the eligibility of the organization for the specific method. The results of this endpoint are **not** paginated — unlike most other list endpoints in our API.
     * 
     * <p>The list can optionally be filtered using a number of parameters described below.
     * 
     * <p>&gt; 🔑 Access with
     * &gt;
     * &gt; [API key](/reference/authentication)
     * &gt;
     * &gt; [Access token with **payments.read**](/reference/authentication)
     * 
     * @param request The request object containing all the parameters for the API call.
     * @return The response from the API call
     * @throws Exception if the API call fails
     */
    public ListAllMethodsResponse all(ListAllMethodsRequest request) throws Exception {
        return all(request, Optional.empty());
    }

    /**
     * List all payment methods
     * 
     * <p>Retrieve all payment methods that Mollie offers, regardless of the eligibility of the organization for the specific method. The results of this endpoint are **not** paginated — unlike most other list endpoints in our API.
     * 
     * <p>The list can optionally be filtered using a number of parameters described below.
     * 
     * <p>&gt; 🔑 Access with
     * &gt;
     * &gt; [API key](/reference/authentication)
     * &gt;
     * &gt; [Access token with **payments.read**](/reference/authentication)
     * 
     * @param request The request object containing all the parameters for the API call.
     * @param options additional options
     * @return The response from the API call
     * @throws Exception if the API call fails
     */
    public ListAllMethodsResponse all(ListAllMethodsRequest request, Optional<Options> options) throws Exception {
        RequestOperation<ListAllMethodsRequest, ListAllMethodsResponse> operation
              = new ListAllMethodsOperation(sdkConfiguration, options);
        return operation.handleResponse(operation.doRequest(request));
    }

    /**
     * Get payment method
     * 
     * <p>Retrieve a single payment method by its ID.
     * 
     * <p>If a method is not available on this profile, a `404 Not Found` response is returned. If the method is available but not enabled yet, a status `403 Forbidden` is returned. You can enable payments methods via the [Enable payment method endpoint](enable-method) of the Profiles API, or via the Mollie Dashboard.
     * 
     * <p>If you do not know the method's ID, you can use the [methods list endpoint](list-methods) to retrieve all payment methods that are available.
     * 
     * <p>Additionally, it is possible to check if wallet methods such as Apple Pay are enabled by passing the wallet ID (`applepay`) as the method ID.
     * 
     * <p>&gt; 🔑 Access with
     * &gt;
     * &gt; [API key](/reference/authentication)
     * &gt;
     * &gt; [Access token with **payments.read**](/reference/authentication)
     * 
     * @return The call builder
     */
    public GetMethodRequestBuilder get() {
        return new GetMethodRequestBuilder(sdkConfiguration);
    }

    /**
     * Get payment method
     * 
     * <p>Retrieve a single payment method by its ID.
     * 
     * <p>If a method is not available on this profile, a `404 Not Found` response is returned. If the method is available but not enabled yet, a status `403 Forbidden` is returned. You can enable payments methods via the [Enable payment method endpoint](enable-method) of the Profiles API, or via the Mollie Dashboard.
     * 
     * <p>If you do not know the method's ID, you can use the [methods list endpoint](list-methods) to retrieve all payment methods that are available.
     * 
     * <p>Additionally, it is possible to check if wallet methods such as Apple Pay are enabled by passing the wallet ID (`applepay`) as the method ID.
     * 
     * <p>&gt; 🔑 Access with
     * &gt;
     * &gt; [API key](/reference/authentication)
     * &gt;
     * &gt; [Access token with **payments.read**](/reference/authentication)
     * 
     * @param request The request object containing all the parameters for the API call.
     * @return The response from the API call
     * @throws Exception if the API call fails
     */
    public GetMethodResponse get(GetMethodRequest request) throws Exception {
        return get(request, Optional.empty());
    }

    /**
     * Get payment method
     * 
     * <p>Retrieve a single payment method by its ID.
     * 
     * <p>If a method is not available on this profile, a `404 Not Found` response is returned. If the method is available but not enabled yet, a status `403 Forbidden` is returned. You can enable payments methods via the [Enable payment method endpoint](enable-method) of the Profiles API, or via the Mollie Dashboard.
     * 
     * <p>If you do not know the method's ID, you can use the [methods list endpoint](list-methods) to retrieve all payment methods that are available.
     * 
     * <p>Additionally, it is possible to check if wallet methods such as Apple Pay are enabled by passing the wallet ID (`applepay`) as the method ID.
     * 
     * <p>&gt; 🔑 Access with
     * &gt;
     * &gt; [API key](/reference/authentication)
     * &gt;
     * &gt; [Access token with **payments.read**](/reference/authentication)
     * 
     * @param request The request object containing all the parameters for the API call.
     * @param options additional options
     * @return The response from the API call
     * @throws Exception if the API call fails
     */
    public GetMethodResponse get(GetMethodRequest request, Optional<Options> options) throws Exception {
        RequestOperation<GetMethodRequest, GetMethodResponse> operation
              = new GetMethodOperation(sdkConfiguration, options);
        return operation.handleResponse(operation.doRequest(request));
    }

}
