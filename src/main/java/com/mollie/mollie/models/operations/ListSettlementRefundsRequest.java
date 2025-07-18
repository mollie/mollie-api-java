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


public class ListSettlementRefundsRequest {
    /**
     * Provide the ID of the related settlement.
     */
    @SpeakeasyMetadata("pathParam:style=simple,explode=false,name=settlementId")
    private String settlementId;

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
    private JsonNullable<? extends ListSettlementRefundsQueryParamInclude> include;

    /**
     * Most API credentials are specifically created for either live mode or test mode. In those cases the `testmode` query parameter can be omitted. For organization-level credentials such as OAuth access tokens, you can enable test mode by setting the `testmode` query parameter to `true`.
     * 
     * <p>Test entities cannot be retrieved when the endpoint is set to live mode, and vice versa.
     */
    @SpeakeasyMetadata("queryParam:style=form,explode=true,name=testmode")
    private JsonNullable<Boolean> testmode;

    @JsonCreator
    public ListSettlementRefundsRequest(
            String settlementId,
            Optional<String> from,
            JsonNullable<Long> limit,
            JsonNullable<? extends ListSettlementRefundsQueryParamInclude> include,
            JsonNullable<Boolean> testmode) {
        Utils.checkNotNull(settlementId, "settlementId");
        Utils.checkNotNull(from, "from");
        Utils.checkNotNull(limit, "limit");
        Utils.checkNotNull(include, "include");
        Utils.checkNotNull(testmode, "testmode");
        this.settlementId = settlementId;
        this.from = from;
        this.limit = limit;
        this.include = include;
        this.testmode = testmode;
    }
    
    public ListSettlementRefundsRequest(
            String settlementId) {
        this(settlementId, Optional.empty(), JsonNullable.undefined(),
            JsonNullable.undefined(), JsonNullable.undefined());
    }

    /**
     * Provide the ID of the related settlement.
     */
    @JsonIgnore
    public String settlementId() {
        return settlementId;
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
    public JsonNullable<ListSettlementRefundsQueryParamInclude> include() {
        return (JsonNullable<ListSettlementRefundsQueryParamInclude>) include;
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
     * Provide the ID of the related settlement.
     */
    public ListSettlementRefundsRequest withSettlementId(String settlementId) {
        Utils.checkNotNull(settlementId, "settlementId");
        this.settlementId = settlementId;
        return this;
    }

    /**
     * Provide an ID to start the result set from the item with the given ID and onwards. This allows you to paginate the result set.
     */
    public ListSettlementRefundsRequest withFrom(String from) {
        Utils.checkNotNull(from, "from");
        this.from = Optional.ofNullable(from);
        return this;
    }


    /**
     * Provide an ID to start the result set from the item with the given ID and onwards. This allows you to paginate the result set.
     */
    public ListSettlementRefundsRequest withFrom(Optional<String> from) {
        Utils.checkNotNull(from, "from");
        this.from = from;
        return this;
    }

    /**
     * The maximum number of items to return. Defaults to 50 items.
     */
    public ListSettlementRefundsRequest withLimit(long limit) {
        Utils.checkNotNull(limit, "limit");
        this.limit = JsonNullable.of(limit);
        return this;
    }

    /**
     * The maximum number of items to return. Defaults to 50 items.
     */
    public ListSettlementRefundsRequest withLimit(JsonNullable<Long> limit) {
        Utils.checkNotNull(limit, "limit");
        this.limit = limit;
        return this;
    }

    /**
     * This endpoint allows you to include additional information via the `include` query string parameter.
     */
    public ListSettlementRefundsRequest withInclude(ListSettlementRefundsQueryParamInclude include) {
        Utils.checkNotNull(include, "include");
        this.include = JsonNullable.of(include);
        return this;
    }

    /**
     * This endpoint allows you to include additional information via the `include` query string parameter.
     */
    public ListSettlementRefundsRequest withInclude(JsonNullable<? extends ListSettlementRefundsQueryParamInclude> include) {
        Utils.checkNotNull(include, "include");
        this.include = include;
        return this;
    }

    /**
     * Most API credentials are specifically created for either live mode or test mode. In those cases the `testmode` query parameter can be omitted. For organization-level credentials such as OAuth access tokens, you can enable test mode by setting the `testmode` query parameter to `true`.
     * 
     * <p>Test entities cannot be retrieved when the endpoint is set to live mode, and vice versa.
     */
    public ListSettlementRefundsRequest withTestmode(boolean testmode) {
        Utils.checkNotNull(testmode, "testmode");
        this.testmode = JsonNullable.of(testmode);
        return this;
    }

    /**
     * Most API credentials are specifically created for either live mode or test mode. In those cases the `testmode` query parameter can be omitted. For organization-level credentials such as OAuth access tokens, you can enable test mode by setting the `testmode` query parameter to `true`.
     * 
     * <p>Test entities cannot be retrieved when the endpoint is set to live mode, and vice versa.
     */
    public ListSettlementRefundsRequest withTestmode(JsonNullable<Boolean> testmode) {
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
        ListSettlementRefundsRequest other = (ListSettlementRefundsRequest) o;
        return 
            Utils.enhancedDeepEquals(this.settlementId, other.settlementId) &&
            Utils.enhancedDeepEquals(this.from, other.from) &&
            Utils.enhancedDeepEquals(this.limit, other.limit) &&
            Utils.enhancedDeepEquals(this.include, other.include) &&
            Utils.enhancedDeepEquals(this.testmode, other.testmode);
    }
    
    @Override
    public int hashCode() {
        return Utils.enhancedHash(
            settlementId, from, limit,
            include, testmode);
    }
    
    @Override
    public String toString() {
        return Utils.toString(ListSettlementRefundsRequest.class,
                "settlementId", settlementId,
                "from", from,
                "limit", limit,
                "include", include,
                "testmode", testmode);
    }

    @SuppressWarnings("UnusedReturnValue")
    public final static class Builder {

        private String settlementId;

        private Optional<String> from = Optional.empty();

        private JsonNullable<Long> limit;

        private JsonNullable<? extends ListSettlementRefundsQueryParamInclude> include = JsonNullable.undefined();

        private JsonNullable<Boolean> testmode = JsonNullable.undefined();

        private Builder() {
          // force use of static builder() method
        }


        /**
         * Provide the ID of the related settlement.
         */
        public Builder settlementId(String settlementId) {
            Utils.checkNotNull(settlementId, "settlementId");
            this.settlementId = settlementId;
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
        public Builder include(ListSettlementRefundsQueryParamInclude include) {
            Utils.checkNotNull(include, "include");
            this.include = JsonNullable.of(include);
            return this;
        }

        /**
         * This endpoint allows you to include additional information via the `include` query string parameter.
         */
        public Builder include(JsonNullable<? extends ListSettlementRefundsQueryParamInclude> include) {
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

        public ListSettlementRefundsRequest build() {
            if (limit == null) {
                limit = _SINGLETON_VALUE_Limit.value();
            }

            return new ListSettlementRefundsRequest(
                settlementId, from, limit,
                include, testmode);
        }


        private static final LazySingletonValue<JsonNullable<Long>> _SINGLETON_VALUE_Limit =
                new LazySingletonValue<>(
                        "limit",
                        "50",
                        new TypeReference<JsonNullable<Long>>() {});
    }
}
