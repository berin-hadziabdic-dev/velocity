package com.pixelcat.velocity.entity.jsonentities.entitybuilders;

import com.pixelcat.velocity.entity.jsonentities.entityInterfaces.FieldGenerator;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class EntityBuilderBeans {

    @Bean
    public FieldGenerator<Integer,String> getIntegerStringFieldBuilder(){

        FieldGenerator<Integer,String> stringGenerator = (Integer key)-> {
            String randomlyGeneratedString = RandomStringUtils.randomAlphanumeric(17);
            randomlyGeneratedString = randomlyGeneratedString + key.toString();
            return randomlyGeneratedString;
        };
        return stringGenerator;
    }

    @Bean
    public FieldGenerator<Integer,Boolean> getIntegerBooleanFieldBuilder(){

        FieldGenerator<Integer,Boolean> stringGenerator = (Integer key)-> {
     
            return key % 2 == 0 ? true : false;
        };
        return stringGenerator;
    }

    @Bean
    public FieldGenerator<Integer,Integer> getIntegerIntegerBuilder(){

        FieldGenerator<Integer,Integer> integerGenerator = (Integer upperLimit)-> {
            Double randDouble = Math.random();
            randDouble *= upperLimit;

            return randDouble.intValue();
        };
        return integerGenerator;
    }

    @Bean
    public FieldGenerator<Integer,Double> getIntegerDoubleFieldBuilder(){

        FieldGenerator<Integer,Double> doubleGenerator = (Integer upperLimit)-> {
            return Math.random() * upperLimit;
        };
        return doubleGenerator;
    }

    
}
