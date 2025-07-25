/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.mollie.mollie.models.operations;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mollie.mollie.utils.SpeakeasyMetadata;
import com.mollie.mollie.utils.Utils;
import java.lang.Boolean;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import org.openapitools.jackson.nullable.JsonNullable;


public class GetRefundRequest {
    /**
     * Provide the ID of the related payment.
     */
    @SpeakeasyMetadata("pathParam:style=simple,explode=false,name=paymentId")
    private String paymentId;

    /**
     * Provide the ID of the related refund.
     */
    @SpeakeasyMetadata("pathParam:style=simple,explode=false,name=refundId")
    private String refundId;

    /**
     * This endpoint allows you to include additional information via the `include` query string parameter.
     */
    @SpeakeasyMetadata("queryParam:style=form,explode=true,name=include")
    private JsonNullable<? extends GetRefundQueryParamInclude> include;

    /**
     * Most API credentials are specifically created for either live mode or test mode. In those cases the `testmode` query parameter can be omitted. For organization-level credentials such as OAuth access tokens, you can enable test mode by setting the `testmode` query parameter to `true`.
     * 
     * <p>Test entities cannot be retrieved when the endpoint is set to live mode, and vice versa.
     */
    @SpeakeasyMetadata("queryParam:style=form,explode=true,name=testmode")
    private JsonNullable<Boolean> testmode;

    @JsonCreator
    public GetRefundRequest(
            String paymentId,
            String refundId,
            JsonNullable<? extends GetRefundQueryParamInclude> include,
            JsonNullable<Boolean> testmode) {
        Utils.checkNotNull(paymentId, "paymentId");
        Utils.checkNotNull(refundId, "refundId");
        Utils.checkNotNull(include, "include");
        Utils.checkNotNull(testmode, "testmode");
        this.paymentId = paymentId;
        this.refundId = refundId;
        this.include = include;
        this.testmode = testmode;
    }
    
    public GetRefundRequest(
            String paymentId,
            String refundId) {
        this(paymentId, refundId, JsonNullable.undefined(),
            JsonNullable.undefined());
    }

    /**
     * Provide the ID of the related payment.
     */
    @JsonIgnore
    public String paymentId() {
        return paymentId;
    }

    /**
     * Provide the ID of the related refund.
     */
    @JsonIgnore
    public String refundId() {
        return refundId;
    }

    /**
     * This endpoint allows you to include additional information via the `include` query string parameter.
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public JsonNullable<GetRefundQueryParamInclude> include() {
        return (JsonNullable<GetRefundQueryParamInclude>) include;
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
    public GetRefundRequest withPaymentId(String paymentId) {
        Utils.checkNotNull(paymentId, "paymentId");
        this.paymentId = paymentId;
        return this;
    }

    /**
     * Provide the ID of the related refund.
     */
    public GetRefundRequest withRefundId(String refundId) {
        Utils.checkNotNull(refundId, "refundId");
        this.refundId = refundId;
        return this;
    }

    /**
     * This endpoint allows you to include additional information via the `include` query string parameter.
     */
    public GetRefundRequest withInclude(GetRefundQueryParamInclude include) {
        Utils.checkNotNull(include, "include");
        this.include = JsonNullable.of(include);
        return this;
    }

    /**
     * This endpoint allows you to include additional information via the `include` query string parameter.
     */
    public GetRefundRequest withInclude(JsonNullable<? extends GetRefundQueryParamInclude> include) {
        Utils.checkNotNull(include, "include");
        this.include = include;
        return this;
    }

    /**
     * Most API credentials are specifically created for either live mode or test mode. In those cases the `testmode` query parameter can be omitted. For organization-level credentials such as OAuth access tokens, you can enable test mode by setting the `testmode` query parameter to `true`.
     * 
     * <p>Test entities cannot be retrieved when the endpoint is set to live mode, and vice versa.
     */
    public GetRefundRequest withTestmode(boolean testmode) {
        Utils.checkNotNull(testmode, "testmode");
        this.testmode = JsonNullable.of(testmode);
        return this;
    }

    /**
     * Most API credentials are specifically created for either live mode or test mode. In those cases the `testmode` query parameter can be omitted. For organization-level credentials such as OAuth access tokens, you can enable test mode by setting the `testmode` query parameter to `true`.
     * 
     * <p>Test entities cannot be retrieved when the endpoint is set to live mode, and vice versa.
     */
    public GetRefundRequest withTestmode(JsonNullable<Boolean> testmode) {
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
        GetRefundRequest other = (GetRefundRequest) o;
        return 
            Utils.enhancedDeepEquals(this.paymentId, other.paymentId) &&
            Utils.enhancedDeepEquals(this.refundId, other.refundId) &&
            Utils.enhancedDeepEquals(this.include, other.include) &&
            Utils.enhancedDeepEquals(this.testmode, other.testmode);
    }
    
    @Override
    public int hashCode() {
        return Utils.enhancedHash(
            paymentId, refundId, include,
            testmode);
    }
    
    @Override
    public String toString() {
        return Utils.toString(GetRefundRequest.class,
                "paymentId", paymentId,
                "refundId", refundId,
                "include", include,
                "testmode", testmode);
    }

    @SuppressWarnings("UnusedReturnValue")
    public final static class Builder {

        private String paymentId;

        private String refundId;

        private JsonNullable<? extends GetRefundQueryParamInclude> include = JsonNullable.undefined();

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
         * Provide the ID of the related refund.
         */
        public Builder refundId(String refundId) {
            Utils.checkNotNull(refundId, "refundId");
            this.refundId = refundId;
            return this;
        }


        /**
         * This endpoint allows you to include additional information via the `include` query string parameter.
         */
        public Builder include(GetRefundQueryParamInclude include) {
            Utils.checkNotNull(include, "include");
            this.include = JsonNullable.of(include);
            return this;
        }

        /**
         * This endpoint allows you to include additional information via the `include` query string parameter.
         */
        public Builder include(JsonNullable<? extends GetRefundQueryParamInclude> include) {
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

        public GetRefundRequest build() {

            return new GetRefundRequest(
                paymentId, refundId, include,
                testmode);
        }

    }
}
