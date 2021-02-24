package com.pixelcat.velocity.entity.jsonentities.entityInterfaces;

/**FieldGenerator interface can accept a Key with value K and produce a random or predictable pattern 
 * represented by V. For example, if we are generating a username field, then we can implment 
 * this interface to return username appended with an Integer key: username0, username1, ... , usernameX.
 * The implementors of this interface should be completely stateless.
 */
@FunctionalInterface
public interface FieldGenerator<K,V> {

    public V generate(K key);
    
}
