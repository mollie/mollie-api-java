/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.mollie.mollie.models.errors;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mollie.mollie.utils.Utils;
import java.lang.Override;
import java.lang.String;

/**
 * CreateRefundRefundsDocumentation
 * 
 * <p>The URL to the generic Mollie API error handling guide.
 */
public class CreateRefundRefundsDocumentation {

    @JsonProperty("href")
    private String href;


    @JsonProperty("type")
    private String type;

    @JsonCreator
    public CreateRefundRefundsDocumentation(
            @JsonProperty("href") String href,
            @JsonProperty("type") String type) {
        Utils.checkNotNull(href, "href");
        Utils.checkNotNull(type, "type");
        this.href = href;
        this.type = type;
    }

    @JsonIgnore
    public String href() {
        return href;
    }

    @JsonIgnore
    public String type() {
        return type;
    }

    public static Builder builder() {
        return new Builder();
    }


    public CreateRefundRefundsDocumentation withHref(String href) {
        Utils.checkNotNull(href, "href");
        this.href = href;
        return this;
    }

    public CreateRefundRefundsDocumentation withType(String type) {
        Utils.checkNotNull(type, "type");
        this.type = type;
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
        CreateRefundRefundsDocumentation other = (CreateRefundRefundsDocumentation) o;
        return 
            Utils.enhancedDeepEquals(this.href, other.href) &&
            Utils.enhancedDeepEquals(this.type, other.type);
    }
    
    @Override
    public int hashCode() {
        return Utils.enhancedHash(
            href, type);
    }
    
    @Override
    public String toString() {
        return Utils.toString(CreateRefundRefundsDocumentation.class,
                "href", href,
                "type", type);
    }

    @SuppressWarnings("UnusedReturnValue")
    public final static class Builder {

        private String href;

        private String type;

        private Builder() {
          // force use of static builder() method
        }


        public Builder href(String href) {
            Utils.checkNotNull(href, "href");
            this.href = href;
            return this;
        }


        public Builder type(String type) {
            Utils.checkNotNull(type, "type");
            this.type = type;
            return this;
        }

        public CreateRefundRefundsDocumentation build() {

            return new CreateRefundRefundsDocumentation(
                href, type);
        }

    }
}
