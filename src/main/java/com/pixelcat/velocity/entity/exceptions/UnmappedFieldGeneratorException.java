package com.pixelcat.velocity.entity.exceptions;

/**The unmapped generator exception is thrown when a valid Javascript type needs value generation,
 * but its matching generator cannot be found.
  */
public class UnmappedFieldGeneratorException extends RuntimeException {

    public UnmappedFieldGeneratorException(){
        super("A valid type requested value generation but the associated generator could not be found.");
    }
    
}
