/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.mollie.mollie.models.operations;

import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.mollie.mollie.utils.OneOfDeserializer;
import com.mollie.mollie.utils.TypedObject;
import com.mollie.mollie.utils.Utils.JsonShape;
import com.mollie.mollie.utils.Utils.TypeReferenceWithShape;
import com.mollie.mollie.utils.Utils;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.List;

/**
 * CreateCaptureCapturesMetadata
 * 
 * <p>Provide any data you like, for example a string or a JSON object. We will save the data alongside the entity. Whenever you fetch the entity with our API, we will also include the metadata. You can use up to approximately 1kB.
 */
@JsonDeserialize(using = CreateCaptureCapturesMetadata._Deserializer.class)
public class CreateCaptureCapturesMetadata {

    @JsonValue
    private TypedObject value;
    
    private CreateCaptureCapturesMetadata(TypedObject value) {
        this.value = value;
    }

    public static CreateCaptureCapturesMetadata of(String value) {
        Utils.checkNotNull(value, "value");
        return new CreateCaptureCapturesMetadata(TypedObject.of(value, JsonShape.DEFAULT, new TypeReference<String>(){}));
    }

    public static CreateCaptureCapturesMetadata of(CreateCaptureMetadataCaptures2 value) {
        Utils.checkNotNull(value, "value");
        return new CreateCaptureCapturesMetadata(TypedObject.of(value, JsonShape.DEFAULT, new TypeReference<CreateCaptureMetadataCaptures2>(){}));
    }

    public static CreateCaptureCapturesMetadata of(List<String> value) {
        Utils.checkNotNull(value, "value");
        return new CreateCaptureCapturesMetadata(TypedObject.of(value, JsonShape.DEFAULT, new TypeReference<List<String>>(){}));
    }
    
    /**
     * Returns an instance of one of these types:
     * <ul>
     * <li>{@code java.lang.String}</li>
     * <li>{@code com.mollie.mollie.models.operations.CreateCaptureMetadataCaptures2}</li>
     * <li>{@code java.util.List<java.lang.String>}</li>
     * </ul>
     * 
     * <p>Use {@code instanceof} to determine what type is returned. For example:
     * 
     * <pre>
     * if (obj.value() instanceof String) {
     *     String answer = (String) obj.value();
     *     System.out.println("answer=" + answer);
     * }
     * </pre>
     * 
     * @return value of oneOf type
     **/ 
    public java.lang.Object value() {
        return value.value();
    }    
    
    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CreateCaptureCapturesMetadata other = (CreateCaptureCapturesMetadata) o;
        return Utils.enhancedDeepEquals(this.value.value(), other.value.value()); 
    }
    
    @Override
    public int hashCode() {
        return Utils.enhancedHash(value.value());
    }
    
    @SuppressWarnings("serial")
    public static final class _Deserializer extends OneOfDeserializer<CreateCaptureCapturesMetadata> {

        public _Deserializer() {
            super(CreateCaptureCapturesMetadata.class, false,
                  TypeReferenceWithShape.of(new TypeReference<List<String>>() {}, JsonShape.DEFAULT),
                  TypeReferenceWithShape.of(new TypeReference<String>() {}, JsonShape.DEFAULT),
                  TypeReferenceWithShape.of(new TypeReference<CreateCaptureMetadataCaptures2>() {}, JsonShape.DEFAULT));
        }
    }
    
    @Override
    public String toString() {
        return Utils.toString(CreateCaptureCapturesMetadata.class,
                "value", value);
    }
 
}

