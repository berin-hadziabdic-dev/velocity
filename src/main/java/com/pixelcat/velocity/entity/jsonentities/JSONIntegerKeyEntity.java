package com.pixelcat.velocity.entity.jsonentities;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.pixelcat.velocity.javaandjavascripttypes.JavascriptType;

import lombok.Data;

/**The JSON entity class contains the necessary information to build a fully custom json object.
 * It contains both a string description
 */
@Data
public class JSONIntegerKeyEntity  {

    private Map<String,JavascriptType> JSONtypes;
  
    public JSONIntegerKeyEntity(){
        this.JSONtypes = new HashMap<String,JavascriptType>();
    }

    public String buildJsonString(Integer dataElement) {
        Set<String> fieldNames = JSONtypes.keySet();
        JavascriptType fieldTypeJsonIterator;

        for(String field : fieldNames){
            fieldTypeJsonIterator = this.JSONtypes.get(field);
        }

        return null;
        
    }
     
}
