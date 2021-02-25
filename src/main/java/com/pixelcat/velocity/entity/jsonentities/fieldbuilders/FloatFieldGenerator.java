package com.pixelcat.velocity.entity.jsonentities.fieldbuilders;

import com.pixelcat.velocity.entity.jsonentities.entityInterfaces.MaxMin;
import com.pixelcat.velocity.entity.jsonentities.entityInterfaces.NumericFieldGenerator;

/**The float field generator is a NumericFieldGenerator, and it generates floats between max and min.*/
public class FloatFieldGenerator extends MaxMin implements NumericFieldGenerator<Integer,Float> {

    @Override
    public Float generate(Integer key, Float min, Float max) {
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
