/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.mollie.mollie;

import static com.mollie.mollie.operations.Operations.RequestOperation;
import static com.mollie.mollie.operations.Operations.RequestlessOperation;

import com.mollie.mollie.models.operations.CreateProfileRequestBody;
import com.mollie.mollie.models.operations.CreateProfileRequestBuilder;
import com.mollie.mollie.models.operations.CreateProfileResponse;
import com.mollie.mollie.models.operations.DeleteProfileRequest;
import com.mollie.mollie.models.operations.DeleteProfileRequestBuilder;
import com.mollie.mollie.models.operations.DeleteProfileResponse;
import com.mollie.mollie.models.operations.GetCurrentProfileRequestBuilder;
import com.mollie.mollie.models.operations.GetCurrentProfileResponse;
import com.mollie.mollie.models.operations.GetProfileRequest;
import com.mollie.mollie.models.operations.GetProfileRequestBuilder;
import com.mollie.mollie.models.operations.GetProfileResponse;
import com.mollie.mollie.models.operations.ListProfilesRequest;
import com.mollie.mollie.models.operations.ListProfilesRequestBuilder;
import com.mollie.mollie.models.operations.ListProfilesResponse;
import com.mollie.mollie.models.operations.UpdateProfileRequest;
import com.mollie.mollie.models.operations.UpdateProfileRequestBody;
import com.mollie.mollie.models.operations.UpdateProfileRequestBuilder;
import com.mollie.mollie.models.operations.UpdateProfileResponse;
import com.mollie.mollie.operations.CreateProfileOperation;
import com.mollie.mollie.operations.DeleteProfileOperation;
import com.mollie.mollie.operations.GetCurrentProfileOperation;
import com.mollie.mollie.operations.GetProfileOperation;
import com.mollie.mollie.operations.ListProfilesOperation;
import com.mollie.mollie.operations.UpdateProfileOperation;
import com.mollie.mollie.utils.Options;
import java.lang.Boolean;
import java.lang.Exception;
import java.lang.Long;
import java.lang.String;
import java.util.Optional;
import org.openapitools.jackson.nullable.JsonNullable;


public class Profiles {
    private final SDKConfiguration sdkConfiguration;

    Profiles(SDKConfiguration sdkConfiguration) {
        this.sdkConfiguration = sdkConfiguration;
    }

    /**
     * Create profile
     * 
     * <p>Create a profile to process payments on.
     * 
     * <p>Profiles are required for payment processing. Normally they are created via the Mollie dashboard. Alternatively, you can use this endpoint to automate profile creation.
     * 
     * <p>&gt; 🔑 Access with
     * &gt;
     * &gt; [Access token with **profiles.write**](/reference/authentication)
     * 
     * @return The call builder
     */
    public CreateProfileRequestBuilder create() {
        return new CreateProfileRequestBuilder(sdkConfiguration);
    }

    /**
     * Create profile
     * 
     * <p>Create a profile to process payments on.
     * 
     * <p>Profiles are required for payment processing. Normally they are created via the Mollie dashboard. Alternatively, you can use this endpoint to automate profile creation.
     * 
     * <p>&gt; 🔑 Access with
     * &gt;
     * &gt; [Access token with **profiles.write**](/reference/authentication)
     * 
     * @param request The request object containing all the parameters for the API call.
     * @return The response from the API call
     * @throws Exception if the API call fails
     */
    public CreateProfileResponse create(CreateProfileRequestBody request) throws Exception {
        return create(request, Optional.empty());
    }

    /**
     * Create profile
     * 
     * <p>Create a profile to process payments on.
     * 
     * <p>Profiles are required for payment processing. Normally they are created via the Mollie dashboard. Alternatively, you can use this endpoint to automate profile creation.
     * 
     * <p>&gt; 🔑 Access with
     * &gt;
     * &gt; [Access token with **profiles.write**](/reference/authentication)
     * 
     * @param request The request object containing all the parameters for the API call.
     * @param options additional options
     * @return The response from the API call
     * @throws Exception if the API call fails
     */
    public CreateProfileResponse create(CreateProfileRequestBody request, Optional<Options> options) throws Exception {
        RequestOperation<CreateProfileRequestBody, CreateProfileResponse> operation
              = new CreateProfileOperation(sdkConfiguration, options);
        return operation.handleResponse(operation.doRequest(request));
    }

    /**
     * List profiles
     * 
     * <p>Retrieve a list of all of your profiles.
     * 
     * <p>The results are paginated.
     * 
     * <p>&gt; 🔑 Access with
     * &gt;
     * &gt; [Access token with **profiles.read**](/reference/authentication)
     * 
     * @return The call builder
     */
    public ListProfilesRequestBuilder list() {
        return new ListProfilesRequestBuilder(sdkConfiguration);
    }

    /**
     * List profiles
     * 
     * <p>Retrieve a list of all of your profiles.
     * 
     * <p>The results are paginated.
     * 
     * <p>&gt; 🔑 Access with
     * &gt;
     * &gt; [Access token with **profiles.read**](/reference/authentication)
     * 
     * @return The response from the API call
     * @throws Exception if the API call fails
     */
    public ListProfilesResponse listDirect() throws Exception {
        return list(Optional.empty(), JsonNullable.undefined(), Optional.empty());
    }

    /**
     * List profiles
     * 
     * <p>Retrieve a list of all of your profiles.
     * 
     * <p>The results are paginated.
     * 
     * <p>&gt; 🔑 Access with
     * &gt;
     * &gt; [Access token with **profiles.read**](/reference/authentication)
     * 
     * @param from Provide an ID to start the result set from the item with the given ID and onwards. This allows you to paginate the result set.
     * @param limit The maximum number of items to return. Defaults to 50 items.
     * @param options additional options
     * @return The response from the API call
     * @throws Exception if the API call fails
     */
    public ListProfilesResponse list(
            Optional<String> from, JsonNullable<Long> limit,
            Optional<Options> options) throws Exception {
        ListProfilesRequest request =
            ListProfilesRequest
                .builder()
                .from(from)
                .limit(limit)
                .build();
        RequestOperation<ListProfilesRequest, ListProfilesResponse> operation
              = new ListProfilesOperation(sdkConfiguration, options);
        return operation.handleResponse(operation.doRequest(request));
    }

    /**
     * Get profile
     * 
     * <p>Retrieve a single profile by its ID.
     * 
     * <p>&gt; 🔑 Access with
     * &gt;
     * &gt; [Access token with **profiles.read**](/reference/authentication)
     * 
     * @return The call builder
     */
    public GetProfileRequestBuilder get() {
        return new GetProfileRequestBuilder(sdkConfiguration);
    }

    /**
     * Get profile
     * 
     * <p>Retrieve a single profile by its ID.
     * 
     * <p>&gt; 🔑 Access with
     * &gt;
     * &gt; [Access token with **profiles.read**](/reference/authentication)
     * 
     * @param id Provide the ID of the item you want to perform this operation on.
     * @return The response from the API call
     * @throws Exception if the API call fails
     */
    public GetProfileResponse get(String id) throws Exception {
        return get(id, JsonNullable.undefined(), Optional.empty());
    }

    /**
     * Get profile
     * 
     * <p>Retrieve a single profile by its ID.
     * 
     * <p>&gt; 🔑 Access with
     * &gt;
     * &gt; [Access token with **profiles.read**](/reference/authentication)
     * 
     * @param id Provide the ID of the item you want to perform this operation on.
     * @param testmode Most API credentials are specifically created for either live mode or test mode. In those cases the `testmode` query parameter can be omitted. For organization-level credentials such as OAuth access tokens, you can enable test mode by setting the `testmode` query parameter to `true`.
     *         
     *         Test entities cannot be retrieved when the endpoint is set to live mode, and vice versa.
     * @param options additional options
     * @return The response from the API call
     * @throws Exception if the API call fails
     */
    public GetProfileResponse get(
            String id, JsonNullable<Boolean> testmode,
            Optional<Options> options) throws Exception {
        GetProfileRequest request =
            GetProfileRequest
                .builder()
                .id(id)
                .testmode(testmode)
                .build();
        RequestOperation<GetProfileRequest, GetProfileResponse> operation
              = new GetProfileOperation(sdkConfiguration, options);
        return operation.handleResponse(operation.doRequest(request));
    }

    /**
     * Update profile
     * 
     * <p>Update an existing profile.
     * 
     * <p>Profiles are required for payment processing. Normally they are created and updated via the Mollie dashboard. Alternatively, you can use this endpoint to automate profile management.
     * 
     * <p>&gt; 🔑 Access with
     * &gt;
     * &gt; [Access token with **profiles.write**](/reference/authentication)
     * 
     * @return The call builder
     */
    public UpdateProfileRequestBuilder update() {
        return new UpdateProfileRequestBuilder(sdkConfiguration);
    }

    /**
     * Update profile
     * 
     * <p>Update an existing profile.
     * 
     * <p>Profiles are required for payment processing. Normally they are created and updated via the Mollie dashboard. Alternatively, you can use this endpoint to automate profile management.
     * 
     * <p>&gt; 🔑 Access with
     * &gt;
     * &gt; [Access token with **profiles.write**](/reference/authentication)
     * 
     * @param id Provide the ID of the item you want to perform this operation on.
     * @param requestBody 
     * @return The response from the API call
     * @throws Exception if the API call fails
     */
    public UpdateProfileResponse update(String id, UpdateProfileRequestBody requestBody) throws Exception {
        return update(id, requestBody, Optional.empty());
    }

    /**
     * Update profile
     * 
     * <p>Update an existing profile.
     * 
     * <p>Profiles are required for payment processing. Normally they are created and updated via the Mollie dashboard. Alternatively, you can use this endpoint to automate profile management.
     * 
     * <p>&gt; 🔑 Access with
     * &gt;
     * &gt; [Access token with **profiles.write**](/reference/authentication)
     * 
     * @param id Provide the ID of the item you want to perform this operation on.
     * @param requestBody 
     * @param options additional options
     * @return The response from the API call
     * @throws Exception if the API call fails
     */
    public UpdateProfileResponse update(
            String id, UpdateProfileRequestBody requestBody,
            Optional<Options> options) throws Exception {
        UpdateProfileRequest request =
            UpdateProfileRequest
                .builder()
                .id(id)
                .requestBody(requestBody)
                .build();
        RequestOperation<UpdateProfileRequest, UpdateProfileResponse> operation
              = new UpdateProfileOperation(sdkConfiguration, options);
        return operation.handleResponse(operation.doRequest(request));
    }

    /**
     * Delete profile
     * 
     * <p>Delete a profile. A deleted profile and its related credentials can no longer be used for accepting payments.
     * 
     * <p>&gt; 🔑 Access with
     * &gt;
     * &gt; [Access token with **profiles.write**](/reference/authentication)
     * 
     * @return The call builder
     */
    public DeleteProfileRequestBuilder delete() {
        return new DeleteProfileRequestBuilder(sdkConfiguration);
    }

    /**
     * Delete profile
     * 
     * <p>Delete a profile. A deleted profile and its related credentials can no longer be used for accepting payments.
     * 
     * <p>&gt; 🔑 Access with
     * &gt;
     * &gt; [Access token with **profiles.write**](/reference/authentication)
     * 
     * @param id Provide the ID of the item you want to perform this operation on.
     * @return The response from the API call
     * @throws Exception if the API call fails
     */
    public DeleteProfileResponse delete(String id) throws Exception {
        return delete(id, Optional.empty());
    }

    /**
     * Delete profile
     * 
     * <p>Delete a profile. A deleted profile and its related credentials can no longer be used for accepting payments.
     * 
     * <p>&gt; 🔑 Access with
     * &gt;
     * &gt; [Access token with **profiles.write**](/reference/authentication)
     * 
     * @param id Provide the ID of the item you want to perform this operation on.
     * @param options additional options
     * @return The response from the API call
     * @throws Exception if the API call fails
     */
    public DeleteProfileResponse delete(String id, Optional<Options> options) throws Exception {
        DeleteProfileRequest request =
            DeleteProfileRequest
                .builder()
                .id(id)
                .build();
        RequestOperation<DeleteProfileRequest, DeleteProfileResponse> operation
              = new DeleteProfileOperation(sdkConfiguration, options);
        return operation.handleResponse(operation.doRequest(request));
    }

    /**
     * Get current profile
     * 
     * <p>Retrieve the currently authenticated profile. A convenient alias of the [Get profile](get-profile) endpoint.
     * 
     * <p>For a complete reference of the profile object, refer to the [Get profile](get-profile) endpoint documentation.
     * 
     * <p>&gt; 🔑 Access with
     * &gt;
     * &gt; [API key](/reference/authentication)
     * 
     * @return The call builder
     */
    public GetCurrentProfileRequestBuilder getCurrent() {
        return new GetCurrentProfileRequestBuilder(sdkConfiguration);
    }

    /**
     * Get current profile
     * 
     * <p>Retrieve the currently authenticated profile. A convenient alias of the [Get profile](get-profile) endpoint.
     * 
     * <p>For a complete reference of the profile object, refer to the [Get profile](get-profile) endpoint documentation.
     * 
     * <p>&gt; 🔑 Access with
     * &gt;
     * &gt; [API key](/reference/authentication)
     * 
     * @return The response from the API call
     * @throws Exception if the API call fails
     */
    public GetCurrentProfileResponse getCurrentDirect() throws Exception {
        return getCurrent(Optional.empty());
    }

    /**
     * Get current profile
     * 
     * <p>Retrieve the currently authenticated profile. A convenient alias of the [Get profile](get-profile) endpoint.
     * 
     * <p>For a complete reference of the profile object, refer to the [Get profile](get-profile) endpoint documentation.
     * 
     * <p>&gt; 🔑 Access with
     * &gt;
     * &gt; [API key](/reference/authentication)
     * 
     * @param options additional options
     * @return The response from the API call
     * @throws Exception if the API call fails
     */
    public GetCurrentProfileResponse getCurrent(Optional<Options> options) throws Exception {
        RequestlessOperation<GetCurrentProfileResponse> operation
            = new GetCurrentProfileOperation(sdkConfiguration, options);
        return operation.handleResponse(operation.doRequest());
    }

}
