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


public class ListOrderRefundsLinks {
    /**
     * The URL to the generic Mollie API error handling guide.
     */
    @JsonProperty("documentation")
    private ListOrderRefundsDocumentation documentation;

    @JsonCreator
    public ListOrderRefundsLinks(
            @JsonProperty("documentation") ListOrderRefundsDocumentation documentation) {
        Utils.checkNotNull(documentation, "documentation");
        this.documentation = documentation;
    }

    /**
     * The URL to the generic Mollie API error handling guide.
     */
    @JsonIgnore
    public ListOrderRefundsDocumentation documentation() {
        return documentation;
    }

    public static Builder builder() {
        return new Builder();
    }


    /**
     * The URL to the generic Mollie API error handling guide.
     */
    public ListOrderRefundsLinks withDocumentation(ListOrderRefundsDocumentation documentation) {
        Utils.checkNotNull(documentation, "documentation");
        this.documentation = documentation;
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
        ListOrderRefundsLinks other = (ListOrderRefundsLinks) o;
        return 
            Utils.enhancedDeepEquals(this.documentation, other.documentation);
    }
    
    @Override
    public int hashCode() {
        return Utils.enhancedHash(
            documentation);
    }
    
    @Override
    public String toString() {
        return Utils.toString(ListOrderRefundsLinks.class,
                "documentation", documentation);
    }

    @SuppressWarnings("UnusedReturnValue")
    public final static class Builder {

        private ListOrderRefundsDocumentation documentation;

        private Builder() {
          // force use of static builder() method
        }


        /**
         * The URL to the generic Mollie API error handling guide.
         */
        public Builder documentation(ListOrderRefundsDocumentation documentation) {
            Utils.checkNotNull(documentation, "documentation");
            this.documentation = documentation;
            return this;
        }

        public ListOrderRefundsLinks build() {

            return new ListOrderRefundsLinks(
                documentation);
        }

    }
}
