package com.pixelcat.velocity.entity.jsonentities.fieldbuilders.generators;

import java.util.Map;

import com.pixelcat.velocity.entity.jsonentities.entityInterfaces.GenericFieldGenerator;
import com.pixelcat.velocity.entity.jsonentities.fieldbuilders.fieldRestricitions.FieldRestrictionsLookUp;

import org.springframework.stereotype.Component;

/**The BooleanFieldGenerator generates pseudo random boolean values based on the value of the Integer
 * key.
 */
@Component
public class BooleanFieldGenerator implements GenericFieldGenerator<Map<String,Object>> {
    
    @Override
    public Object generate(Map<String,Object> restrictions)   {

        Boolean returnBoolean = null;
        
        //If restrictions is null for some reason..., return a random boolean anyways, instead of throwin excepttiiooon.
            if(restrictions == null)
            {
                returnBoolean = (int) (Math.random() * 100) % 2 == 0 ? true : false;
            }
            else if(restrictions.get(FieldRestrictionsLookUp.ALL_TRUE) != null)
            {
                returnBoolean = true;
            }
            else if(restrictions.get(FieldRestrictionsLookUp.ALL_FALSE) != null)
            {
                returnBoolean = false;
            }
            else if (restrictions.get(FieldRestrictionsLookUp.ALL_TRUE_OR_FALSE)!= null)
            {
                returnBoolean = (int) (Math.random() * 100) % 2 == 0 ? true : false;
            }   
          
            
        return returnBoolean;
    }

    @Override
    public String getJavaReturnType() {
        // TODO Auto-generated method stub
        return Boolean.class.getName();
    };
}
