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


public class ListBalanceTransactionsBalancesLinks {
    /**
     * The URL to the generic Mollie API error handling guide.
     */
    @JsonProperty("documentation")
    private ListBalanceTransactionsBalancesDocumentation documentation;

    @JsonCreator
    public ListBalanceTransactionsBalancesLinks(
            @JsonProperty("documentation") ListBalanceTransactionsBalancesDocumentation documentation) {
        Utils.checkNotNull(documentation, "documentation");
        this.documentation = documentation;
    }

    /**
     * The URL to the generic Mollie API error handling guide.
     */
    @JsonIgnore
    public ListBalanceTransactionsBalancesDocumentation documentation() {
        return documentation;
    }

    public static Builder builder() {
        return new Builder();
    }


    /**
     * The URL to the generic Mollie API error handling guide.
     */
    public ListBalanceTransactionsBalancesLinks withDocumentation(ListBalanceTransactionsBalancesDocumentation documentation) {
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
        ListBalanceTransactionsBalancesLinks other = (ListBalanceTransactionsBalancesLinks) o;
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
        return Utils.toString(ListBalanceTransactionsBalancesLinks.class,
                "documentation", documentation);
    }

    @SuppressWarnings("UnusedReturnValue")
    public final static class Builder {

        private ListBalanceTransactionsBalancesDocumentation documentation;

        private Builder() {
          // force use of static builder() method
        }


        /**
         * The URL to the generic Mollie API error handling guide.
         */
        public Builder documentation(ListBalanceTransactionsBalancesDocumentation documentation) {
            Utils.checkNotNull(documentation, "documentation");
            this.documentation = documentation;
            return this;
        }

        public ListBalanceTransactionsBalancesLinks build() {

            return new ListBalanceTransactionsBalancesLinks(
                documentation);
        }

    }
}
