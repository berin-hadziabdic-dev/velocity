package com.pixelcat.velocity.entity.jsonentities.entityInterfaces;

import java.util.Random;

/**MaxMin is an abstract class that acts as a base for Numeric field generators. It produces 
 * a random double between a maximum and minimum value using the getRandBetweenManAndMin method.
 * 
 */
public abstract class  MaxMin {
    
 
    protected Random randomNumberGenerator;

    public MaxMin(){
        this.randomNumberGenerator = new Random();
    }

  
    /**getRandBetweenMaxAndMin produces a random float between min and max.
     * @param min the minumum of the range of desired values
     * @param max the maximum of the range of desired values
     * @return Float returns a float between max and min
     * @throws NullPointerException,ArithmeticException when min or max have invalid states.
     */
    public Double getRandBetweenMaxAndMin(Double min,Double max) throws NullPointerException,ArithmeticException{

        if(max == null || min == null)
        throw new NullPointerException("Max or Min value in MaxMin class passed a null reference value.");

        if(max <= min)
            throw new ArithmeticException("Max value in numeric MaxMin class cannot be less than min value.");

        Double randomFloat = randomNumberGenerator.nextDouble();
        Double maxMinScalingFactor = max-min; //absolute diiference between max and min
        Double returnValue = maxMinScalingFactor * randomFloat + min; //offset scaled absolute difference from zero by min,
        
        return returnValue;

    }


}
