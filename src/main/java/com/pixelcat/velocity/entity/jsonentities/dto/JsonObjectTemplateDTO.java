package com.pixelcat.velocity.entity.jsonentities.dto;

import java.util.List;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class JsonObjectTemplateDTO {
    
    String nestedJsonFieldName;
    List<JsonFieldDTO> primitiveFields;
    List<JsonObjectTemplateDTO> nestedObjectFields;
    

    /**This constructor will make a parent level json. It is not a nested json and to indicate it is not a nested 
     * json nestedJsonFieldNAme is set to null.
     */
    public JsonObjectTemplateDTO(List<JsonFieldDTO> primitiveFields){
        this.primitiveFields = primitiveFields;
        this.nestedObjectFields = null;
        this.nestedJsonFieldName = null;
    }
     /**This constructor will make a child level json field.To indicate it is a nested json, we pass a fieldName to the Json.
     */
    public JsonObjectTemplateDTO(String fieldName, List<JsonFieldDTO> primitiveFields){
        this.nestedJsonFieldName = fieldName;
        this.primitiveFields = primitiveFields;
        this.nestedObjectFields = null;
    }

    /**
     * This constructo will make a parent level JsonObjectDTO with primitive fields and nested child json objects. 
    */
    public JsonObjectTemplateDTO(List<JsonFieldDTO> primitiveFields, List<JsonObjectTemplateDTO> nestedObjects){

        this.primitiveFields = primitiveFields;
        this.nestedObjectFields = nestedObjects;
        this.nestedJsonFieldName = null;
    }

        /**
     *
     *  This constructor will make a child level JsonObjectDTO with primitive fields and nested child json objects.
     *  To indicate this is a child level json, we will pass the json its fieldName in the constructor. 
    */
    public JsonObjectTemplateDTO(String fieldName, List<JsonFieldDTO> primitiveFields, List<JsonObjectTemplateDTO> nestedObjects){

        this.primitiveFields = primitiveFields;
        this.nestedObjectFields = nestedObjects;
        this.nestedJsonFieldName = fieldName;
    }

    public boolean hasNestedObjectFields(){
        return this.nestedObjectFields != null && nestedObjectFields.size() > 0;
    }

    
}
