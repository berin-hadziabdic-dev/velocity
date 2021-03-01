package com.pixelcat.velocity.entity.jsonentities.fieldbuilders;

import java.util.Map;

import com.pixelcat.velocity.entity.jsonentities.entityInterfaces.GenericFieldGenerator;
import com.pixelcat.velocity.entity.jsonentities.exceptions.RestrictionNotSupported;
import com.pixelcat.velocity.javaandjavascripttypes.JavascriptField;

import org.springframework.stereotype.Component;

/**The BooleanFieldGenerator generates pseudo random boolean values based on the value of the Integer
 * key.
 */
@Component
public class BooleanFieldGenerator implements GenericFieldGenerator<Map<String,Object>> {
    
    @Override
    public Object generate(Map<String,Object> restrictions)   {
        
        if(restrictions != null)
        {

        }
        else 
        {
            if(restrictions.get(JavascriptField.ALL_TRUE) != null)
            {

            }
            else if(restrictions.get(JavascriptField.ALL_FALSE) != null)
            {

            }
            else if (restrictions.get(JavascriptField.ALL_TRUE_OR_FALSE)!= null)
            {

            }
            else
            {
                throw new RestrictionNotSupported("The application was asked to produce a randomly generated boolean field, but did not specify a valid boolean restriction.Boolean restrictions must be: all_true, all_false, and all_true_or_false");    
            }
        }

        return true;
    }

    @Override
    public String getJavaReturnType() {
        // TODO Auto-generated method stub
        return Boolean.class.getName();
    };
}
