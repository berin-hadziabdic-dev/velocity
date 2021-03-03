package com.pixelcat.velocity.entity.jsonentities.entitybuilders;

import java.util.List;
import java.util.Map;

import com.pixelcat.velocity.entity.jsonentities.dto.JsonFieldDTO;
import com.pixelcat.velocity.entity.jsonentities.dto.JsonObjectTemplateDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JsonBuilder {
    
    FieldBuilderDelagateStrategy delagateStrategy;

    @Autowired
    public JsonBuilder(FieldBuilderDelagateStrategy injectedDelagateStrategy)
    {
        this.delagateStrategy = injectedDelagateStrategy;
    }

    public String buildJsonString(JsonObjectTemplateDTO jsonObjectTemplate) throws Exception {
        StringBuilder jsonBuilder = new StringBuilder();
        String jsonFieldValue = null;
        List<JsonFieldDTO> primitiveFields = jsonObjectTemplate.getPrimitiveFields();



        for(JsonFieldDTO jsonElement: primitiveFields){
            jsonFieldValue = "\""  + jsonElement.getFieldName() + "\"" + " : ";
            jsonFieldValue = jsonFieldValue + this.delagateStrategy.doStrategy(jsonElement.getFieldType(), jsonElement.getRestrictions());
            jsonBuilder.append(jsonFieldValue);
            jsonBuilder.append(",\n");
            
        }
     
        if(jsonObjectTemplate.getNestedObjects() != null && !jsonObjectTemplate.getNestedObjects().isEmpty()){
            Map<String,JsonObjectTemplateDTO> nestedObjects = jsonObjectTemplate.getNestedObjects();
            JsonObjectTemplateDTO nestedObjectIterator = null;

            for(String jsonField: jsonObjectTemplate.getNestedObjects().keySet()){
                nestedObjectIterator = jsonObjectTemplate.getNestedObjects().get(jsonField);
                jsonBuilder.append(jsonField + " : " + this.buildJsonString(nestedObjectIterator));
            }
        }
     

        jsonBuilder.setLength(jsonBuilder.length() - 1); //remove final comma
        jsonBuilder.append("}"); //apend closed brace

        return jsonBuilder.toString();
    }
}
