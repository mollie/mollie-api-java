/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.mollie.mollie.models.operations;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mollie.mollie.utils.SpeakeasyMetadata;
import com.mollie.mollie.utils.Utils;
import java.lang.Override;
import java.lang.String;


public class DeleteProfileRequest {
    /**
     * Provide the ID of the item you want to perform this operation on.
     */
    @SpeakeasyMetadata("pathParam:style=simple,explode=false,name=id")
    private String id;

    @JsonCreator
    public DeleteProfileRequest(
            String id) {
        Utils.checkNotNull(id, "id");
        this.id = id;
    }

    /**
     * Provide the ID of the item you want to perform this operation on.
     */
    @JsonIgnore
    public String id() {
        return id;
    }

    public static Builder builder() {
        return new Builder();
    }


    /**
     * Provide the ID of the item you want to perform this operation on.
     */
    public DeleteProfileRequest withId(String id) {
        Utils.checkNotNull(id, "id");
        this.id = id;
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
        DeleteProfileRequest other = (DeleteProfileRequest) o;
        return 
            Utils.enhancedDeepEquals(this.id, other.id);
    }
    
    @Override
    public int hashCode() {
        return Utils.enhancedHash(
            id);
    }
    
    @Override
    public String toString() {
        return Utils.toString(DeleteProfileRequest.class,
                "id", id);
    }

    @SuppressWarnings("UnusedReturnValue")
    public final static class Builder {

        private String id;

        private Builder() {
          // force use of static builder() method
        }


        /**
         * Provide the ID of the item you want to perform this operation on.
         */
        public Builder id(String id) {
            Utils.checkNotNull(id, "id");
            this.id = id;
            return this;
        }

        public DeleteProfileRequest build() {

            return new DeleteProfileRequest(
                id);
        }

    }
}
