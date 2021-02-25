package com.pixelcat.velocity.entity.jsonentities.entityInterfaces;

/**The generator type identifier returns the fully qualified class name of 
 * a field generator. For example, a generator the generates Integers will 
 * return Integer.class.getName().
 */
public interface GeneratorTypeIdentifier {
    public String getJavaReturnType();
  
}
