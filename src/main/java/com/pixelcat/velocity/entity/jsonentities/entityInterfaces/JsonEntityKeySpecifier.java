package com.pixelcat.velocity.entity.jsonentities.entityInterfaces;

/**JsonEntityKeySpecifier interface is used to specify a key and guarantee uniqueness for a particular JSON. 
 * Generally speaking, these JSON objects will be tied to a particular user and the Key type K can be used 
 * to determine uniqueness among the various JSON data delivered to different api endpoints.
 * I.e, 
*/
public interface JsonEntityKeySpecifier<K> {
    public String buildJsonString(K key);
}
