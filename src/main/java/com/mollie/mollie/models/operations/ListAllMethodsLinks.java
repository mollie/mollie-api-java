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
import java.util.Objects;
import java.util.Optional;

public class ListAllMethodsLinks {

    /**
     * In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("self")
    private Optional<? extends ListAllMethodsSelf> self;

    /**
     * In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field.
     */
    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("documentation")
    private Optional<? extends ListAllMethodsDocumentation> documentation;

    @JsonCreator
    public ListAllMethodsLinks(
            @JsonProperty("self") Optional<? extends ListAllMethodsSelf> self,
            @JsonProperty("documentation") Optional<? extends ListAllMethodsDocumentation> documentation) {
        Utils.checkNotNull(self, "self");
        Utils.checkNotNull(documentation, "documentation");
        this.self = self;
        this.documentation = documentation;
    }
    
    public ListAllMethodsLinks() {
        this(Optional.empty(), Optional.empty());
    }

    /**
     * In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field.
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<ListAllMethodsSelf> self() {
        return (Optional<ListAllMethodsSelf>) self;
    }

    /**
     * In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field.
     */
    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<ListAllMethodsDocumentation> documentation() {
        return (Optional<ListAllMethodsDocumentation>) documentation;
    }

    public final static Builder builder() {
        return new Builder();
    }    

    /**
     * In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field.
     */
    public ListAllMethodsLinks withSelf(ListAllMethodsSelf self) {
        Utils.checkNotNull(self, "self");
        this.self = Optional.ofNullable(self);
        return this;
    }

    /**
     * In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field.
     */
    public ListAllMethodsLinks withSelf(Optional<? extends ListAllMethodsSelf> self) {
        Utils.checkNotNull(self, "self");
        this.self = self;
        return this;
    }

    /**
     * In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field.
     */
    public ListAllMethodsLinks withDocumentation(ListAllMethodsDocumentation documentation) {
        Utils.checkNotNull(documentation, "documentation");
        this.documentation = Optional.ofNullable(documentation);
        return this;
    }

    /**
     * In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field.
     */
    public ListAllMethodsLinks withDocumentation(Optional<? extends ListAllMethodsDocumentation> documentation) {
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
        ListAllMethodsLinks other = (ListAllMethodsLinks) o;
        return 
            Objects.deepEquals(this.self, other.self) &&
            Objects.deepEquals(this.documentation, other.documentation);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(
            self,
            documentation);
    }
    
    @Override
    public String toString() {
        return Utils.toString(ListAllMethodsLinks.class,
                "self", self,
                "documentation", documentation);
    }
    
    public final static class Builder {
 
        private Optional<? extends ListAllMethodsSelf> self = Optional.empty();
 
        private Optional<? extends ListAllMethodsDocumentation> documentation = Optional.empty();
        
        private Builder() {
          // force use of static builder() method
        }

        /**
         * In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field.
         */
        public Builder self(ListAllMethodsSelf self) {
            Utils.checkNotNull(self, "self");
            this.self = Optional.ofNullable(self);
            return this;
        }

        /**
         * In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field.
         */
        public Builder self(Optional<? extends ListAllMethodsSelf> self) {
            Utils.checkNotNull(self, "self");
            this.self = self;
            return this;
        }

        /**
         * In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field.
         */
        public Builder documentation(ListAllMethodsDocumentation documentation) {
            Utils.checkNotNull(documentation, "documentation");
            this.documentation = Optional.ofNullable(documentation);
            return this;
        }

        /**
         * In v2 endpoints, URLs are commonly represented as objects with an `href` and `type` field.
         */
        public Builder documentation(Optional<? extends ListAllMethodsDocumentation> documentation) {
            Utils.checkNotNull(documentation, "documentation");
            this.documentation = documentation;
            return this;
        }
        
        public ListAllMethodsLinks build() {
            return new ListAllMethodsLinks(
                self,
                documentation);
        }
    }
}
