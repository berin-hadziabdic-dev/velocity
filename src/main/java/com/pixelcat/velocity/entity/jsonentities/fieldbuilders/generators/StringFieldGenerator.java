package com.pixelcat.velocity.entity.jsonentities.fieldbuilders.generators;

import java.util.Map;

import com.pixelcat.velocity.entity.jsonentities.entityInterfaces.GenericFieldGenerator;
import com.pixelcat.velocity.entity.jsonentities.fieldbuilders.fieldRestricitions.FieldRestrictionsLookUp;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;


@Component
public class StringFieldGenerator implements GenericFieldGenerator<Map<String,Object>> {

    @Override
    public Object generate(Map<String,Object> restrictions){

        Integer stringLength = 17;

        if(restrictions != null)
        {
            stringLength = restrictions.get(FieldRestrictionsLookUp.STRING_LENGTH) != null ? (Integer) restrictions.get(FieldRestrictionsLookUp.STRING_LENGTH) : 17;
        }
        
        String randomlyGeneratedString = RandomStringUtils.randomAlphanumeric(stringLength);
       
        return "\"" + randomlyGeneratedString + "\"";
    };
    @Override
    public String getJavaReturnType() {
        // TODO Auto-generated method stub
        return String.class.getName();
    }

    
}
