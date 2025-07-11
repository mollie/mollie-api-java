/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.mollie.mollie.models.operations;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;
import com.mollie.mollie.utils.LazySingletonValue;
import com.mollie.mollie.utils.SpeakeasyMetadata;
import com.mollie.mollie.utils.Utils;
import java.lang.Boolean;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.util.Optional;
import org.openapitools.jackson.nullable.JsonNullable;


public class GetPaymentLinkPaymentsRequest {
    /**
     * Provide the ID of the related payment link.
     */
    @SpeakeasyMetadata("pathParam:style=simple,explode=false,name=paymentLinkId")
    private String paymentLinkId;

    /**
     * Provide an ID to start the result set from the item with the given ID and onwards. This allows you to paginate the result set.
     */
    @SpeakeasyMetadata("queryParam:style=form,explode=true,name=from")
    private Optional<String> from;

    /**
     * The maximum number of items to return. Defaults to 50 items.
     */
    @SpeakeasyMetadata("queryParam:style=form,explode=true,name=limit")
    private JsonNullable<Long> limit;

    /**
     * Used for setting the direction of the result set. Defaults to descending order, meaning the results are ordered from newest to oldest.
     * 
     * <p>Possible values: `asc` `desc` (default: `desc`)
     */
    @SpeakeasyMetadata("queryParam:style=form,explode=true,name=sort")
    private JsonNullable<String> sort;

    /**
     * Most API credentials are specifically created for either live mode or test mode. In those cases the `testmode` query parameter can be omitted. For organization-level credentials such as OAuth access tokens, you can enable test mode by setting the `testmode` query parameter to `true`.
     * 
     * <p>Test entities cannot be retrieved when the endpoint is set to live mode, and vice versa.
     */
    @SpeakeasyMetadata("queryParam:style=form,explode=true,name=testmode")
    private JsonNullable<Boolean> testmode;

    @JsonCreator
    public GetPaymentLinkPaymentsRequest(
            String paymentLinkId,
            Optional<String> from,
            JsonNullable<Long> limit,
            JsonNullable<String> sort,
            JsonNullable<Boolean> testmode) {
        Utils.checkNotNull(paymentLinkId, "paymentLinkId");
        Utils.checkNotNull(from, "from");
        Utils.checkNotNull(limit, "limit");
        Utils.checkNotNull(sort, "sort");
        Utils.checkNotNull(testmode, "testmode");
        this.paymentLinkId = paymentLinkId;
        this.from = from;
        this.limit = limit;
        this.sort = sort;
        this.testmode = testmode;
    }
    
    public GetPaymentLinkPaymentsRequest(
            String paymentLinkId) {
        this(paymentLinkId, Optional.empty(), JsonNullable.undefined(),
            JsonNullable.undefined(), JsonNullable.undefined());
    }

    /**
     * Provide the ID of the related payment link.
     */
    @JsonIgnore
    public String paymentLinkId() {
        return paymentLinkId;
    }

    /**
     * Provide an ID to start the result set from the item with the given ID and onwards. This allows you to paginate the result set.
     */
    @JsonIgnore
    public Optional<String> from() {
        return from;
    }

    /**
     * The maximum number of items to return. Defaults to 50 items.
     */
    @JsonIgnore
    public JsonNullable<Long> limit() {
        return limit;
    }

    /**
     * Used for setting the direction of the result set. Defaults to descending order, meaning the results are ordered from newest to oldest.
     * 
     * <p>Possible values: `asc` `desc` (default: `desc`)
     */
    @JsonIgnore
    public JsonNullable<String> sort() {
        return sort;
    }

    /**
     * Most API credentials are specifically created for either live mode or test mode. In those cases the `testmode` query parameter can be omitted. For organization-level credentials such as OAuth access tokens, you can enable test mode by setting the `testmode` query parameter to `true`.
     * 
     * <p>Test entities cannot be retrieved when the endpoint is set to live mode, and vice versa.
     */
    @JsonIgnore
    public JsonNullable<Boolean> testmode() {
        return testmode;
    }

    public static Builder builder() {
        return new Builder();
    }


    /**
     * Provide the ID of the related payment link.
     */
    public GetPaymentLinkPaymentsRequest withPaymentLinkId(String paymentLinkId) {
        Utils.checkNotNull(paymentLinkId, "paymentLinkId");
        this.paymentLinkId = paymentLinkId;
        return this;
    }

    /**
     * Provide an ID to start the result set from the item with the given ID and onwards. This allows you to paginate the result set.
     */
    public GetPaymentLinkPaymentsRequest withFrom(String from) {
        Utils.checkNotNull(from, "from");
        this.from = Optional.ofNullable(from);
        return this;
    }


    /**
     * Provide an ID to start the result set from the item with the given ID and onwards. This allows you to paginate the result set.
     */
    public GetPaymentLinkPaymentsRequest withFrom(Optional<String> from) {
        Utils.checkNotNull(from, "from");
        this.from = from;
        return this;
    }

    /**
     * The maximum number of items to return. Defaults to 50 items.
     */
    public GetPaymentLinkPaymentsRequest withLimit(long limit) {
        Utils.checkNotNull(limit, "limit");
        this.limit = JsonNullable.of(limit);
        return this;
    }

    /**
     * The maximum number of items to return. Defaults to 50 items.
     */
    public GetPaymentLinkPaymentsRequest withLimit(JsonNullable<Long> limit) {
        Utils.checkNotNull(limit, "limit");
        this.limit = limit;
        return this;
    }

    /**
     * Used for setting the direction of the result set. Defaults to descending order, meaning the results are ordered from newest to oldest.
     * 
     * <p>Possible values: `asc` `desc` (default: `desc`)
     */
    public GetPaymentLinkPaymentsRequest withSort(String sort) {
        Utils.checkNotNull(sort, "sort");
        this.sort = JsonNullable.of(sort);
        return this;
    }

    /**
     * Used for setting the direction of the result set. Defaults to descending order, meaning the results are ordered from newest to oldest.
     * 
     * <p>Possible values: `asc` `desc` (default: `desc`)
     */
    public GetPaymentLinkPaymentsRequest withSort(JsonNullable<String> sort) {
        Utils.checkNotNull(sort, "sort");
        this.sort = sort;
        return this;
    }

    /**
     * Most API credentials are specifically created for either live mode or test mode. In those cases the `testmode` query parameter can be omitted. For organization-level credentials such as OAuth access tokens, you can enable test mode by setting the `testmode` query parameter to `true`.
     * 
     * <p>Test entities cannot be retrieved when the endpoint is set to live mode, and vice versa.
     */
    public GetPaymentLinkPaymentsRequest withTestmode(boolean testmode) {
        Utils.checkNotNull(testmode, "testmode");
        this.testmode = JsonNullable.of(testmode);
        return this;
    }

    /**
     * Most API credentials are specifically created for either live mode or test mode. In those cases the `testmode` query parameter can be omitted. For organization-level credentials such as OAuth access tokens, you can enable test mode by setting the `testmode` query parameter to `true`.
     * 
     * <p>Test entities cannot be retrieved when the endpoint is set to live mode, and vice versa.
     */
    public GetPaymentLinkPaymentsRequest withTestmode(JsonNullable<Boolean> testmode) {
        Utils.checkNotNull(testmode, "testmode");
        this.testmode = testmode;
        return this;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GetPaymentLinkPaymentsRequest other = (GetPaymentLinkPaymentsRequest) o;
        return 
            Utils.enhancedDeepEquals(this.paymentLinkId, other.paymentLinkId) &&
            Utils.enhancedDeepEquals(this.from, other.from) &&
            Utils.enhancedDeepEquals(this.limit, other.limit) &&
            Utils.enhancedDeepEquals(this.sort, other.sort) &&
            Utils.enhancedDeepEquals(this.testmode, other.testmode);
    }
    
    @Override
    public int hashCode() {
        return Utils.enhancedHash(
            paymentLinkId, from, limit,
            sort, testmode);
    }
    
    @Override
    public String toString() {
        return Utils.toString(GetPaymentLinkPaymentsRequest.class,
                "paymentLinkId", paymentLinkId,
                "from", from,
                "limit", limit,
                "sort", sort,
                "testmode", testmode);
    }

    @SuppressWarnings("UnusedReturnValue")
    public final static class Builder {

        private String paymentLinkId;

        private Optional<String> from = Optional.empty();

        private JsonNullable<Long> limit;

        private JsonNullable<String> sort = JsonNullable.undefined();

        private JsonNullable<Boolean> testmode = JsonNullable.undefined();

        private Builder() {
          // force use of static builder() method
        }


        /**
         * Provide the ID of the related payment link.
         */
        public Builder paymentLinkId(String paymentLinkId) {
            Utils.checkNotNull(paymentLinkId, "paymentLinkId");
            this.paymentLinkId = paymentLinkId;
            return this;
        }


        /**
         * Provide an ID to start the result set from the item with the given ID and onwards. This allows you to paginate the result set.
         */
        public Builder from(String from) {
            Utils.checkNotNull(from, "from");
            this.from = Optional.ofNullable(from);
            return this;
        }

        /**
         * Provide an ID to start the result set from the item with the given ID and onwards. This allows you to paginate the result set.
         */
        public Builder from(Optional<String> from) {
            Utils.checkNotNull(from, "from");
            this.from = from;
            return this;
        }


        /**
         * The maximum number of items to return. Defaults to 50 items.
         */
        public Builder limit(long limit) {
            Utils.checkNotNull(limit, "limit");
            this.limit = JsonNullable.of(limit);
            return this;
        }

        /**
         * The maximum number of items to return. Defaults to 50 items.
         */
        public Builder limit(JsonNullable<Long> limit) {
            Utils.checkNotNull(limit, "limit");
            this.limit = limit;
            return this;
        }


        /**
         * Used for setting the direction of the result set. Defaults to descending order, meaning the results are ordered from newest to oldest.
         * 
         * <p>Possible values: `asc` `desc` (default: `desc`)
         */
        public Builder sort(String sort) {
            Utils.checkNotNull(sort, "sort");
            this.sort = JsonNullable.of(sort);
            return this;
        }

        /**
         * Used for setting the direction of the result set. Defaults to descending order, meaning the results are ordered from newest to oldest.
         * 
         * <p>Possible values: `asc` `desc` (default: `desc`)
         */
        public Builder sort(JsonNullable<String> sort) {
            Utils.checkNotNull(sort, "sort");
            this.sort = sort;
            return this;
        }


        /**
         * Most API credentials are specifically created for either live mode or test mode. In those cases the `testmode` query parameter can be omitted. For organization-level credentials such as OAuth access tokens, you can enable test mode by setting the `testmode` query parameter to `true`.
         * 
         * <p>Test entities cannot be retrieved when the endpoint is set to live mode, and vice versa.
         */
        public Builder testmode(boolean testmode) {
            Utils.checkNotNull(testmode, "testmode");
            this.testmode = JsonNullable.of(testmode);
            return this;
        }

        /**
         * Most API credentials are specifically created for either live mode or test mode. In those cases the `testmode` query parameter can be omitted. For organization-level credentials such as OAuth access tokens, you can enable test mode by setting the `testmode` query parameter to `true`.
         * 
         * <p>Test entities cannot be retrieved when the endpoint is set to live mode, and vice versa.
         */
        public Builder testmode(JsonNullable<Boolean> testmode) {
            Utils.checkNotNull(testmode, "testmode");
            this.testmode = testmode;
            return this;
        }

        public GetPaymentLinkPaymentsRequest build() {
            if (limit == null) {
                limit = _SINGLETON_VALUE_Limit.value();
            }

            return new GetPaymentLinkPaymentsRequest(
                paymentLinkId, from, limit,
                sort, testmode);
        }


        private static final LazySingletonValue<JsonNullable<Long>> _SINGLETON_VALUE_Limit =
                new LazySingletonValue<>(
                        "limit",
                        "50",
                        new TypeReference<JsonNullable<Long>>() {});
    }
}
