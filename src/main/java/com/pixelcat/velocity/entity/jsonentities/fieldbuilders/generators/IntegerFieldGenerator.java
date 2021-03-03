package com.pixelcat.velocity.entity.jsonentities.fieldbuilders.generators;

import com.pixelcat.velocity.entity.jsonentities.entityInterfaces.MaxMin;
import com.pixelcat.velocity.entity.jsonentities.entityInterfaces.NumericFieldGenerator;

import org.springframework.stereotype.Component;

/**
 * 
 */
@Component
public class IntegerFieldGenerator extends MaxMin implements NumericFieldGenerator<Integer>{


        @Override
        public Integer generate(Double min, Double max) {
            Double randDouble = this.getRandBetweenMaxAndMin(min, max);
    
            return randDouble.intValue();
        };

        @Override
	public String getJavaReturnType() {
		// TODO Auto-generated method stub
		return Integer.class.getName();
	}
       
}
