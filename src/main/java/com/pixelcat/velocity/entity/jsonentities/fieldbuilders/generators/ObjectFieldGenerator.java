package com.pixelcat.velocity.entity.jsonentities.fieldbuilders.generators;




import com.pixelcat.velocity.entity.jsonentities.dto.JsonObjectTemplateDTO;
import com.pixelcat.velocity.entity.jsonentities.entityInterfaces.GenericFieldGenerator;
import com.pixelcat.velocity.entity.jsonentities.entitybuilders.JsonBuilder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ObjectFieldGenerator implements GenericFieldGenerator<JsonObjectTemplateDTO> {

    JsonBuilder jsonBuilder;

    @Autowired
    public ObjectFieldGenerator(JsonBuilder injectedJsonBuilder){
        this.jsonBuilder = injectedJsonBuilder;
    }
    @Override
    public String getJavaReturnType() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object generate(JsonObjectTemplateDTO objectTemplate) throws Exception {
        // TODO Auto-generated method stub
        String objectJson = (String)this.jsonBuilder.buildJsonString(objectTemplate);
        return objectJson;
    }
    
}
