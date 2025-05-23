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
import java.util.Objects;
import org.openapitools.jackson.nullable.JsonNullable;

public class DeletePaymentLinkRequest {

    /**
     * Provide the ID of the related payment link.
     */
    @SpeakeasyMetadata("pathParam:style=simple,explode=false,name=paymentLinkId")
    private String paymentLinkId;

    /**
     * Most API credentials are specifically created for either live mode or test mode. In those cases the `testmode` query parameter can be omitted. For organization-level credentials such as OAuth access tokens, you can enable test mode by setting the `testmode` query parameter to `true`.
     * 
     * <p>Test entities cannot be retrieved when the endpoint is set to live mode, and vice versa.
     */
    @SpeakeasyMetadata("queryParam:style=form,explode=true,name=testmode")
    private JsonNullable<Boolean> testmode;

    @JsonCreator
    public DeletePaymentLinkRequest(
            String paymentLinkId,
            JsonNullable<Boolean> testmode) {
        Utils.checkNotNull(paymentLinkId, "paymentLinkId");
        Utils.checkNotNull(testmode, "testmode");
        this.paymentLinkId = paymentLinkId;
        this.testmode = testmode;
    }
    
    public DeletePaymentLinkRequest(
            String paymentLinkId) {
        this(paymentLinkId, JsonNullable.undefined());
    }

    /**
     * Provide the ID of the related payment link.
     */
    @JsonIgnore
    public String paymentLinkId() {
        return paymentLinkId;
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

    public final static Builder builder() {
        return new Builder();
    }    

    /**
     * Provide the ID of the related payment link.
     */
    public DeletePaymentLinkRequest withPaymentLinkId(String paymentLinkId) {
        Utils.checkNotNull(paymentLinkId, "paymentLinkId");
        this.paymentLinkId = paymentLinkId;
        return this;
    }

    /**
     * Most API credentials are specifically created for either live mode or test mode. In those cases the `testmode` query parameter can be omitted. For organization-level credentials such as OAuth access tokens, you can enable test mode by setting the `testmode` query parameter to `true`.
     * 
     * <p>Test entities cannot be retrieved when the endpoint is set to live mode, and vice versa.
     */
    public DeletePaymentLinkRequest withTestmode(boolean testmode) {
        Utils.checkNotNull(testmode, "testmode");
        this.testmode = JsonNullable.of(testmode);
        return this;
    }

    /**
     * Most API credentials are specifically created for either live mode or test mode. In those cases the `testmode` query parameter can be omitted. For organization-level credentials such as OAuth access tokens, you can enable test mode by setting the `testmode` query parameter to `true`.
     * 
     * <p>Test entities cannot be retrieved when the endpoint is set to live mode, and vice versa.
     */
    public DeletePaymentLinkRequest withTestmode(JsonNullable<Boolean> testmode) {
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
        DeletePaymentLinkRequest other = (DeletePaymentLinkRequest) o;
        return 
            Objects.deepEquals(this.paymentLinkId, other.paymentLinkId) &&
            Objects.deepEquals(this.testmode, other.testmode);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(
            paymentLinkId,
            testmode);
    }
    
    @Override
    public String toString() {
        return Utils.toString(DeletePaymentLinkRequest.class,
                "paymentLinkId", paymentLinkId,
                "testmode", testmode);
    }
    
    public final static class Builder {
 
        private String paymentLinkId;
 
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
        
        public DeletePaymentLinkRequest build() {
            return new DeletePaymentLinkRequest(
                paymentLinkId,
                testmode);
        }
    }
}
