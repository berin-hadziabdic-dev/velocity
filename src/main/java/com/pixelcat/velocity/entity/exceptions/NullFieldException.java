package com.pixelcat.velocity.entity.exceptions;

/**NullFieldException is thrown when a JSON metadata maps a field name to Java's null value instead of 
 * a valid JavascriptType object.
 */
public class NullFieldException extends RuntimeException {
    
    public NullFieldException(){
        super("A fieldname was mapped to a null type specifier in a JSON metadata map. Fieldnames must be mapped to valid JSON types in order to construct valid JSON objects.");
    }

    public NullFieldException(String message){
        super(message);
    }
}
