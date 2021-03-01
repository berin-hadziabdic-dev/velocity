package com.pixelcat.velocity.entity.jsonentities.fieldbuilders;

import com.pixelcat.velocity.entity.jsonentities.entityInterfaces.MaxMin;
import com.pixelcat.velocity.entity.jsonentities.entityInterfaces.NumericFieldGenerator;

import org.springframework.stereotype.Component;

@Component
/**The float field generator is a NumericFieldGenerator, and it generates floats between max and min.*/
public class FloatFieldGenerator extends MaxMin implements NumericFieldGenerator<Float> {

    @Override
    public Float generate(Float min, Float max) {
        // TODO Auto-generated method stub
        Float randFloat = this.getRandBetweenMaxAndMin(min,max);

        return randFloat;
    }

    @Override
    public String getJavaReturnType() {
        // TODO Auto-generated method stub
        return Float.class.getName();
    }
    
}
