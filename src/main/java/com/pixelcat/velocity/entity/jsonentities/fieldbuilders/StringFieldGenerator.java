package com.pixelcat.velocity.entity.jsonentities.fieldbuilders;

import com.pixelcat.velocity.entity.jsonentities.entityInterfaces.GenericFieldGenerator;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;


@Component
public class StringFieldGenerator implements GenericFieldGenerator<Integer> {

    @Override
    public Object generate(Integer key){
        String randomlyGeneratedString = RandomStringUtils.randomAlphanumeric(17);
        randomlyGeneratedString = randomlyGeneratedString + key.toString();
        return randomlyGeneratedString;
    };
    @Override
    public String getJavaReturnType() {
        // TODO Auto-generated method stub
        return String.class.getName();
    }
    
}
