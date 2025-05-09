/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.mollie.mollie.models.errors;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mollie.mollie.utils.Utils;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Objects;
import java.util.Optional;

public class ListProfilesLinks {

    /**
     * The URL to the generic Mollie API error handling guide.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("documentation")
    private Optional<? extends ListProfilesDocumentation> documentation;

    @JsonCreator
    public ListProfilesLinks(
            @JsonProperty("documentation") Optional<? extends ListProfilesDocumentation> documentation) {
        Utils.checkNotNull(documentation, "documentation");
        this.documentation = documentation;
    }
    
    public ListProfilesLinks() {
        this(Optional.empty());
    }

    /**
     * The URL to the generic Mollie API error handling guide.
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<ListProfilesDocumentation> documentation() {
        return (Optional<ListProfilesDocumentation>) documentation;
    }

    public final static Builder builder() {
        return new Builder();
    }    

    /**
     * The URL to the generic Mollie API error handling guide.
     */
    public ListProfilesLinks withDocumentation(ListProfilesDocumentation documentation) {
        Utils.checkNotNull(documentation, "documentation");
        this.documentation = Optional.ofNullable(documentation);
        return this;
    }

    /**
     * The URL to the generic Mollie API error handling guide.
     */
    public ListProfilesLinks withDocumentation(Optional<? extends ListProfilesDocumentation> documentation) {
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
        ListProfilesLinks other = (ListProfilesLinks) o;
        return 
            Objects.deepEquals(this.documentation, other.documentation);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(
            documentation);
    }
    
    @Override
    public String toString() {
        return Utils.toString(ListProfilesLinks.class,
                "documentation", documentation);
    }
    
    public final static class Builder {
 
        private Optional<? extends ListProfilesDocumentation> documentation = Optional.empty();
        
        private Builder() {
          // force use of static builder() method
        }

        /**
         * The URL to the generic Mollie API error handling guide.
         */
        public Builder documentation(ListProfilesDocumentation documentation) {
            Utils.checkNotNull(documentation, "documentation");
            this.documentation = Optional.ofNullable(documentation);
            return this;
        }

        /**
         * The URL to the generic Mollie API error handling guide.
         */
        public Builder documentation(Optional<? extends ListProfilesDocumentation> documentation) {
            Utils.checkNotNull(documentation, "documentation");
            this.documentation = documentation;
            return this;
        }
        
        public ListProfilesLinks build() {
            return new ListProfilesLinks(
                documentation);
        }
    }
}
