package com.pixelcat.velocity.entity.jsonentities.fieldbuilders.generators;

import com.pixelcat.velocity.entity.jsonentities.entityInterfaces.MaxMin;
import com.pixelcat.velocity.entity.jsonentities.entityInterfaces.NumericFieldGenerator;

import org.springframework.stereotype.Component;

@Component
/**The float field generator is a NumericFieldGenerator, and it generates floats between max and min.*/
public class DoubleFieldGenerator extends MaxMin implements NumericFieldGenerator<Double> {

    @Override
    public Double generate(Double min, Double max) {
        // TODO Auto-generated method stub
        Double randDouble = this.getRandBetweenMaxAndMin(min,max);

        return randDouble;
    }

    @Override
    public String getJavaReturnType() {
        // TODO Auto-generated method stub
        return Float.class.getName();
    }
    
}
