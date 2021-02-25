package com.pixelcat.velocity.entity.jsonentities.fieldbuilders;

import com.pixelcat.velocity.entity.jsonentities.entityInterfaces.GenericFieldGenerator;

import org.springframework.stereotype.Component;

/**The BooleanFieldGenerator generates pseudo random boolean values based on the value of the Integer
 * key.
 */
@Component
public class BooleanFieldGenerator implements GenericFieldGenerator<Integer> {
    
    @Override
    public Object generate(Integer key)   {
        return key % 2 == 0 ? true : false;
    }

    @Override
    public String getJavaReturnType() {
        // TODO Auto-generated method stub
        return Boolean.class.getName();
    };
}
