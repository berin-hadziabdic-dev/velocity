package com.pixelcat.velocity.entity.jsonentities.entityInterfaces;

/**The NumericFieldGenerator<K,T> is a contract that requires its implementors 
 * to generate a numeric value of type T between min and max. 
 * K represents the Key used to distinguish the owning user of the JSON, usually an integer.
 */
public interface NumericFieldGenerator<T>  {

    public T generate(Double min, Double max);
    public String getJavaReturnType();
}
