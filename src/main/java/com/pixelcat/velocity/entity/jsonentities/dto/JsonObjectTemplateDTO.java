package com.pixelcat.velocity.entity.jsonentities.dto;

import java.util.List;
import java.util.Map;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class JsonObjectTemplateDTO {
    

    List<JsonFieldDTO> primitiveFields;
    Map<String,JsonObjectTemplateDTO> nestedObjects;
    

    public JsonObjectTemplateDTO (List<JsonFieldDTO> primitiveFields) {
        this.primitiveFields = primitiveFields;
        this.nestedObjects = null;
    }
    public  JsonObjectTemplateDTO(List<JsonFieldDTO> primitiveFields, Map<String,JsonObjectTemplateDTO> nestedObjects ){

        this.primitiveFields = primitiveFields;
        this.nestedObjects = nestedObjects;
    }

    
}
