/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.mollie.mollie.models.operations;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mollie.mollie.utils.Utils;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Optional;


public class ListCapabilitiesCapabilitiesLinks {
    /**
     * If known, a deep link to the Mollie dashboard of the client, where the requirement can be fulfilled. For example, where necessary documents are to be uploaded.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("dashboard")
    private Optional<? extends ListCapabilitiesDashboard> dashboard;

    @JsonCreator
    public ListCapabilitiesCapabilitiesLinks(
            @JsonProperty("dashboard") Optional<? extends ListCapabilitiesDashboard> dashboard) {
        Utils.checkNotNull(dashboard, "dashboard");
        this.dashboard = dashboard;
    }
    
    public ListCapabilitiesCapabilitiesLinks() {
        this(Optional.empty());
    }

    /**
     * If known, a deep link to the Mollie dashboard of the client, where the requirement can be fulfilled. For example, where necessary documents are to be uploaded.
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<ListCapabilitiesDashboard> dashboard() {
        return (Optional<ListCapabilitiesDashboard>) dashboard;
    }

    public static Builder builder() {
        return new Builder();
    }


    /**
     * If known, a deep link to the Mollie dashboard of the client, where the requirement can be fulfilled. For example, where necessary documents are to be uploaded.
     */
    public ListCapabilitiesCapabilitiesLinks withDashboard(ListCapabilitiesDashboard dashboard) {
        Utils.checkNotNull(dashboard, "dashboard");
        this.dashboard = Optional.ofNullable(dashboard);
        return this;
    }


    /**
     * If known, a deep link to the Mollie dashboard of the client, where the requirement can be fulfilled. For example, where necessary documents are to be uploaded.
     */
    public ListCapabilitiesCapabilitiesLinks withDashboard(Optional<? extends ListCapabilitiesDashboard> dashboard) {
        Utils.checkNotNull(dashboard, "dashboard");
        this.dashboard = dashboard;
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
        ListCapabilitiesCapabilitiesLinks other = (ListCapabilitiesCapabilitiesLinks) o;
        return 
            Utils.enhancedDeepEquals(this.dashboard, other.dashboard);
    }
    
    @Override
    public int hashCode() {
        return Utils.enhancedHash(
            dashboard);
    }
    
    @Override
    public String toString() {
        return Utils.toString(ListCapabilitiesCapabilitiesLinks.class,
                "dashboard", dashboard);
    }

    @SuppressWarnings("UnusedReturnValue")
    public final static class Builder {

        private Optional<? extends ListCapabilitiesDashboard> dashboard = Optional.empty();

        private Builder() {
          // force use of static builder() method
        }


        /**
         * If known, a deep link to the Mollie dashboard of the client, where the requirement can be fulfilled. For example, where necessary documents are to be uploaded.
         */
        public Builder dashboard(ListCapabilitiesDashboard dashboard) {
            Utils.checkNotNull(dashboard, "dashboard");
            this.dashboard = Optional.ofNullable(dashboard);
            return this;
        }

        /**
         * If known, a deep link to the Mollie dashboard of the client, where the requirement can be fulfilled. For example, where necessary documents are to be uploaded.
         */
        public Builder dashboard(Optional<? extends ListCapabilitiesDashboard> dashboard) {
            Utils.checkNotNull(dashboard, "dashboard");
            this.dashboard = dashboard;
            return this;
        }

        public ListCapabilitiesCapabilitiesLinks build() {

            return new ListCapabilitiesCapabilitiesLinks(
                dashboard);
        }

    }
}
