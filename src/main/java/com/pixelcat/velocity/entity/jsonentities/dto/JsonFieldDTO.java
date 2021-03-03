package com.pixelcat.velocity.entity.jsonentities.dto;

import java.util.List;
import java.util.Map;

import lombok.Data;

/**This DTO is used to describe a  primitive field of a JSON object.*/
@Data
public class JsonFieldDTO {
    private String fieldName;
    private String fieldType;

    /**This restriction map holds the restrictions of a particular object. For example, 
     * numeric fields have maximum and minumum restrictions. A list of complete restrictions can 
     * be found in the FieldRestrictionsLookUp class file.
     */
    private Map<String,Object> restrictions;
  
}
