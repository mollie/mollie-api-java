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
import java.lang.SuppressWarnings;
import java.util.Optional;
import org.openapitools.jackson.nullable.JsonNullable;


public class ListRefundsRequest {
    /**
     * Provide the ID of the related payment.
     */
    @SpeakeasyMetadata("pathParam:style=simple,explode=false,name=paymentId")
    private String paymentId;

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
     * This endpoint allows you to include additional information via the `include` query string parameter.
     */
    @SpeakeasyMetadata("queryParam:style=form,explode=true,name=include")
    private JsonNullable<? extends ListRefundsQueryParamInclude> include;

    /**
     * Most API credentials are specifically created for either live mode or test mode. In those cases the `testmode` query parameter can be omitted. For organization-level credentials such as OAuth access tokens, you can enable test mode by setting the `testmode` query parameter to `true`.
     * 
     * <p>Test entities cannot be retrieved when the endpoint is set to live mode, and vice versa.
     */
    @SpeakeasyMetadata("queryParam:style=form,explode=true,name=testmode")
    private JsonNullable<Boolean> testmode;

    @JsonCreator
    public ListRefundsRequest(
            String paymentId,
            Optional<String> from,
            JsonNullable<Long> limit,
            JsonNullable<? extends ListRefundsQueryParamInclude> include,
            JsonNullable<Boolean> testmode) {
        Utils.checkNotNull(paymentId, "paymentId");
        Utils.checkNotNull(from, "from");
        Utils.checkNotNull(limit, "limit");
        Utils.checkNotNull(include, "include");
        Utils.checkNotNull(testmode, "testmode");
        this.paymentId = paymentId;
        this.from = from;
        this.limit = limit;
        this.include = include;
        this.testmode = testmode;
    }
    
    public ListRefundsRequest(
            String paymentId) {
        this(paymentId, Optional.empty(), JsonNullable.undefined(),
            JsonNullable.undefined(), JsonNullable.undefined());
    }

    /**
     * Provide the ID of the related payment.
     */
    @JsonIgnore
    public String paymentId() {
        return paymentId;
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
     * This endpoint allows you to include additional information via the `include` query string parameter.
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public JsonNullable<ListRefundsQueryParamInclude> include() {
        return (JsonNullable<ListRefundsQueryParamInclude>) include;
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
     * Provide the ID of the related payment.
     */
    public ListRefundsRequest withPaymentId(String paymentId) {
        Utils.checkNotNull(paymentId, "paymentId");
        this.paymentId = paymentId;
        return this;
    }

    /**
     * Provide an ID to start the result set from the item with the given ID and onwards. This allows you to paginate the result set.
     */
    public ListRefundsRequest withFrom(String from) {
        Utils.checkNotNull(from, "from");
        this.from = Optional.ofNullable(from);
        return this;
    }


    /**
     * Provide an ID to start the result set from the item with the given ID and onwards. This allows you to paginate the result set.
     */
    public ListRefundsRequest withFrom(Optional<String> from) {
        Utils.checkNotNull(from, "from");
        this.from = from;
        return this;
    }

    /**
     * The maximum number of items to return. Defaults to 50 items.
     */
    public ListRefundsRequest withLimit(long limit) {
        Utils.checkNotNull(limit, "limit");
        this.limit = JsonNullable.of(limit);
        return this;
    }

    /**
     * The maximum number of items to return. Defaults to 50 items.
     */
    public ListRefundsRequest withLimit(JsonNullable<Long> limit) {
        Utils.checkNotNull(limit, "limit");
        this.limit = limit;
        return this;
    }

    /**
     * This endpoint allows you to include additional information via the `include` query string parameter.
     */
    public ListRefundsRequest withInclude(ListRefundsQueryParamInclude include) {
        Utils.checkNotNull(include, "include");
        this.include = JsonNullable.of(include);
        return this;
    }

    /**
     * This endpoint allows you to include additional information via the `include` query string parameter.
     */
    public ListRefundsRequest withInclude(JsonNullable<? extends ListRefundsQueryParamInclude> include) {
        Utils.checkNotNull(include, "include");
        this.include = include;
        return this;
    }

    /**
     * Most API credentials are specifically created for either live mode or test mode. In those cases the `testmode` query parameter can be omitted. For organization-level credentials such as OAuth access tokens, you can enable test mode by setting the `testmode` query parameter to `true`.
     * 
     * <p>Test entities cannot be retrieved when the endpoint is set to live mode, and vice versa.
     */
    public ListRefundsRequest withTestmode(boolean testmode) {
        Utils.checkNotNull(testmode, "testmode");
        this.testmode = JsonNullable.of(testmode);
        return this;
    }

    /**
     * Most API credentials are specifically created for either live mode or test mode. In those cases the `testmode` query parameter can be omitted. For organization-level credentials such as OAuth access tokens, you can enable test mode by setting the `testmode` query parameter to `true`.
     * 
     * <p>Test entities cannot be retrieved when the endpoint is set to live mode, and vice versa.
     */
    public ListRefundsRequest withTestmode(JsonNullable<Boolean> testmode) {
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
        ListRefundsRequest other = (ListRefundsRequest) o;
        return 
            Utils.enhancedDeepEquals(this.paymentId, other.paymentId) &&
            Utils.enhancedDeepEquals(this.from, other.from) &&
            Utils.enhancedDeepEquals(this.limit, other.limit) &&
            Utils.enhancedDeepEquals(this.include, other.include) &&
            Utils.enhancedDeepEquals(this.testmode, other.testmode);
    }
    
    @Override
    public int hashCode() {
        return Utils.enhancedHash(
            paymentId, from, limit,
            include, testmode);
    }
    
    @Override
    public String toString() {
        return Utils.toString(ListRefundsRequest.class,
                "paymentId", paymentId,
                "from", from,
                "limit", limit,
                "include", include,
                "testmode", testmode);
    }

    @SuppressWarnings("UnusedReturnValue")
    public final static class Builder {

        private String paymentId;

        private Optional<String> from = Optional.empty();

        private JsonNullable<Long> limit;

        private JsonNullable<? extends ListRefundsQueryParamInclude> include = JsonNullable.undefined();

        private JsonNullable<Boolean> testmode = JsonNullable.undefined();

        private Builder() {
          // force use of static builder() method
        }


        /**
         * Provide the ID of the related payment.
         */
        public Builder paymentId(String paymentId) {
            Utils.checkNotNull(paymentId, "paymentId");
            this.paymentId = paymentId;
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
         * This endpoint allows you to include additional information via the `include` query string parameter.
         */
        public Builder include(ListRefundsQueryParamInclude include) {
            Utils.checkNotNull(include, "include");
            this.include = JsonNullable.of(include);
            return this;
        }

        /**
         * This endpoint allows you to include additional information via the `include` query string parameter.
         */
        public Builder include(JsonNullable<? extends ListRefundsQueryParamInclude> include) {
            Utils.checkNotNull(include, "include");
            this.include = include;
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

        public ListRefundsRequest build() {
            if (limit == null) {
                limit = _SINGLETON_VALUE_Limit.value();
            }

            return new ListRefundsRequest(
                paymentId, from, limit,
                include, testmode);
        }


        private static final LazySingletonValue<JsonNullable<Long>> _SINGLETON_VALUE_Limit =
                new LazySingletonValue<>(
                        "limit",
                        "50",
                        new TypeReference<JsonNullable<Long>>() {});
    }
}
