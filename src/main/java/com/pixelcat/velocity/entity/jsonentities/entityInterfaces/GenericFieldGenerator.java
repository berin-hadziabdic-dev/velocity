package com.pixelcat.velocity.entity.jsonentities.entityInterfaces;

/**The GenericFieldGenerator interface can accept a Key with value K and produce a random or predictable pattern 
 * represented by V. For example, if we are generating a username field, then we can implment 
 * this interface to return username appended with an Integer key: username0, username1, ... , usernameX.
 * The implementors of this interface should be completely stateless.
 */
public interface GenericFieldGenerator<K> extends GeneratorTypeIdentifier{

    public Object generate(K key);
    
}
