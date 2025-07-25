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


public class ListBalanceTransactionsRequest {
    /**
     * Provide the ID of the related balance.
     */
    @SpeakeasyMetadata("pathParam:style=simple,explode=false,name=balanceId")
    private String balanceId;

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
     * Most API credentials are specifically created for either live mode or test mode. In those cases the `testmode` query parameter can be omitted. For organization-level credentials such as OAuth access tokens, you can enable test mode by setting the `testmode` query parameter to `true`.
     * 
     * <p>Test entities cannot be retrieved when the endpoint is set to live mode, and vice versa.
     */
    @SpeakeasyMetadata("queryParam:style=form,explode=true,name=testmode")
    private JsonNullable<Boolean> testmode;

    @JsonCreator
    public ListBalanceTransactionsRequest(
            String balanceId,
            Optional<String> from,
            JsonNullable<Long> limit,
            JsonNullable<Boolean> testmode) {
        Utils.checkNotNull(balanceId, "balanceId");
        Utils.checkNotNull(from, "from");
        Utils.checkNotNull(limit, "limit");
        Utils.checkNotNull(testmode, "testmode");
        this.balanceId = balanceId;
        this.from = from;
        this.limit = limit;
        this.testmode = testmode;
    }
    
    public ListBalanceTransactionsRequest(
            String balanceId) {
        this(balanceId, Optional.empty(), JsonNullable.undefined(),
            JsonNullable.undefined());
    }

    /**
     * Provide the ID of the related balance.
     */
    @JsonIgnore
    public String balanceId() {
        return balanceId;
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
     * Provide the ID of the related balance.
     */
    public ListBalanceTransactionsRequest withBalanceId(String balanceId) {
        Utils.checkNotNull(balanceId, "balanceId");
        this.balanceId = balanceId;
        return this;
    }

    /**
     * Provide an ID to start the result set from the item with the given ID and onwards. This allows you to paginate the result set.
     */
    public ListBalanceTransactionsRequest withFrom(String from) {
        Utils.checkNotNull(from, "from");
        this.from = Optional.ofNullable(from);
        return this;
    }


    /**
     * Provide an ID to start the result set from the item with the given ID and onwards. This allows you to paginate the result set.
     */
    public ListBalanceTransactionsRequest withFrom(Optional<String> from) {
        Utils.checkNotNull(from, "from");
        this.from = from;
        return this;
    }

    /**
     * The maximum number of items to return. Defaults to 50 items.
     */
    public ListBalanceTransactionsRequest withLimit(long limit) {
        Utils.checkNotNull(limit, "limit");
        this.limit = JsonNullable.of(limit);
        return this;
    }

    /**
     * The maximum number of items to return. Defaults to 50 items.
     */
    public ListBalanceTransactionsRequest withLimit(JsonNullable<Long> limit) {
        Utils.checkNotNull(limit, "limit");
        this.limit = limit;
        return this;
    }

    /**
     * Most API credentials are specifically created for either live mode or test mode. In those cases the `testmode` query parameter can be omitted. For organization-level credentials such as OAuth access tokens, you can enable test mode by setting the `testmode` query parameter to `true`.
     * 
     * <p>Test entities cannot be retrieved when the endpoint is set to live mode, and vice versa.
     */
    public ListBalanceTransactionsRequest withTestmode(boolean testmode) {
        Utils.checkNotNull(testmode, "testmode");
        this.testmode = JsonNullable.of(testmode);
        return this;
    }

    /**
     * Most API credentials are specifically created for either live mode or test mode. In those cases the `testmode` query parameter can be omitted. For organization-level credentials such as OAuth access tokens, you can enable test mode by setting the `testmode` query parameter to `true`.
     * 
     * <p>Test entities cannot be retrieved when the endpoint is set to live mode, and vice versa.
     */
    public ListBalanceTransactionsRequest withTestmode(JsonNullable<Boolean> testmode) {
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
        ListBalanceTransactionsRequest other = (ListBalanceTransactionsRequest) o;
        return 
            Utils.enhancedDeepEquals(this.balanceId, other.balanceId) &&
            Utils.enhancedDeepEquals(this.from, other.from) &&
            Utils.enhancedDeepEquals(this.limit, other.limit) &&
            Utils.enhancedDeepEquals(this.testmode, other.testmode);
    }
    
    @Override
    public int hashCode() {
        return Utils.enhancedHash(
            balanceId, from, limit,
            testmode);
    }
    
    @Override
    public String toString() {
        return Utils.toString(ListBalanceTransactionsRequest.class,
                "balanceId", balanceId,
                "from", from,
                "limit", limit,
                "testmode", testmode);
    }

    @SuppressWarnings("UnusedReturnValue")
    public final static class Builder {

        private String balanceId;

        private Optional<String> from = Optional.empty();

        private JsonNullable<Long> limit;

        private JsonNullable<Boolean> testmode = JsonNullable.undefined();

        private Builder() {
          // force use of static builder() method
        }


        /**
         * Provide the ID of the related balance.
         */
        public Builder balanceId(String balanceId) {
            Utils.checkNotNull(balanceId, "balanceId");
            this.balanceId = balanceId;
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

        public ListBalanceTransactionsRequest build() {
            if (limit == null) {
                limit = _SINGLETON_VALUE_Limit.value();
            }

            return new ListBalanceTransactionsRequest(
                balanceId, from, limit,
                testmode);
        }


        private static final LazySingletonValue<JsonNullable<Long>> _SINGLETON_VALUE_Limit =
                new LazySingletonValue<>(
                        "limit",
                        "50",
                        new TypeReference<JsonNullable<Long>>() {});
    }
}
