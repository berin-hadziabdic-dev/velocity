package com.pixelcat.velocity.entity.jsonentities.fieldbuilders;

import com.pixelcat.velocity.entity.jsonentities.entityInterfaces.MaxMin;
import com.pixelcat.velocity.entity.jsonentities.entityInterfaces.NumericFieldGenerator;

import org.springframework.stereotype.Component;

@Component
public class IntegerFieldGenerator extends MaxMin implements NumericFieldGenerator<Integer,Integer>{


        @Override
        public Integer generate(Integer key, Integer min, Integer max) {
            Float randDouble = this.getRandBetweenMaxAndMin(Float.valueOf(min), Float.valueOf(max));
    
            return randDouble.intValue();
        };

        @Override
	public String getJavaReturnType() {
		// TODO Auto-generated method stub
		return Integer.class.getName();
	}
       
}
