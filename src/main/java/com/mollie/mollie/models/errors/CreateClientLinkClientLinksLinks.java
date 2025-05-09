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

public class CreateClientLinkClientLinksLinks {

    /**
     * The URL to the generic Mollie API error handling guide.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("documentation")
    private Optional<? extends CreateClientLinkClientLinksDocumentation> documentation;

    @JsonCreator
    public CreateClientLinkClientLinksLinks(
            @JsonProperty("documentation") Optional<? extends CreateClientLinkClientLinksDocumentation> documentation) {
        Utils.checkNotNull(documentation, "documentation");
        this.documentation = documentation;
    }
    
    public CreateClientLinkClientLinksLinks() {
        this(Optional.empty());
    }

    /**
     * The URL to the generic Mollie API error handling guide.
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<CreateClientLinkClientLinksDocumentation> documentation() {
        return (Optional<CreateClientLinkClientLinksDocumentation>) documentation;
    }

    public final static Builder builder() {
        return new Builder();
    }    

    /**
     * The URL to the generic Mollie API error handling guide.
     */
    public CreateClientLinkClientLinksLinks withDocumentation(CreateClientLinkClientLinksDocumentation documentation) {
        Utils.checkNotNull(documentation, "documentation");
        this.documentation = Optional.ofNullable(documentation);
        return this;
    }

    /**
     * The URL to the generic Mollie API error handling guide.
     */
    public CreateClientLinkClientLinksLinks withDocumentation(Optional<? extends CreateClientLinkClientLinksDocumentation> documentation) {
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
        CreateClientLinkClientLinksLinks other = (CreateClientLinkClientLinksLinks) o;
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
        return Utils.toString(CreateClientLinkClientLinksLinks.class,
                "documentation", documentation);
    }
    
    public final static class Builder {
 
        private Optional<? extends CreateClientLinkClientLinksDocumentation> documentation = Optional.empty();
        
        private Builder() {
          // force use of static builder() method
        }

        /**
         * The URL to the generic Mollie API error handling guide.
         */
        public Builder documentation(CreateClientLinkClientLinksDocumentation documentation) {
            Utils.checkNotNull(documentation, "documentation");
            this.documentation = Optional.ofNullable(documentation);
            return this;
        }

        /**
         * The URL to the generic Mollie API error handling guide.
         */
        public Builder documentation(Optional<? extends CreateClientLinkClientLinksDocumentation> documentation) {
            Utils.checkNotNull(documentation, "documentation");
            this.documentation = documentation;
            return this;
        }
        
        public CreateClientLinkClientLinksLinks build() {
            return new CreateClientLinkClientLinksLinks(
                documentation);
        }
    }
}
