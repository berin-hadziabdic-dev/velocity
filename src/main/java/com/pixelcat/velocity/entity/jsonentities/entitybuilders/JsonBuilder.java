package com.pixelcat.velocity.entity.jsonentities.entitybuilders;

import java.util.List;

import com.pixelcat.velocity.entity.jsonentities.dto.JsonFieldDTO;
import com.pixelcat.velocity.entity.jsonentities.dto.JsonObjectTemplateDTO;
import com.pixelcat.velocity.javaandjavascripttypes.JavascriptField;
import com.pixelcat.velocity.javaandjavascripttypes.JavascriptType;

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

        if(jsonObjectTemplate.getNestedJsonFieldName() != null)
            jsonBuilder.append( "\"" + jsonObjectTemplate.getNestedJsonFieldName() +"\"" + ": ");
        jsonBuilder.append("{\n");

        for(JsonFieldDTO jsonElement: primitiveFields){
            jsonFieldValue = "\""  + jsonElement.getFieldName() + "\"" + " : ";
            jsonFieldValue = jsonFieldValue + this.delagateStrategy.doStrategy(jsonElement.getFieldType(), jsonElement.getRestrictions());
            jsonBuilder.append(jsonFieldValue);
            jsonBuilder.append(",\n");
            
        }
     
        if(jsonObjectTemplate.hasNestedObjectFields())
        {
            

            for(JsonObjectTemplateDTO jsonObjectTemplateDTO : jsonObjectTemplate.getNestedObjectFields())
            {
                jsonFieldValue =  this.buildJsonString(jsonObjectTemplateDTO);
                jsonBuilder.append(jsonFieldValue);
                jsonBuilder.append(",\n");
            }
            
            jsonBuilder.setLength(jsonBuilder.length() - 1); //remove final comma

        
        }
     

        jsonBuilder.setLength(jsonBuilder.length() - 1); //remove final comma
        jsonBuilder.append("}"); //apend closed brace

        return jsonBuilder.toString();
    }
}
