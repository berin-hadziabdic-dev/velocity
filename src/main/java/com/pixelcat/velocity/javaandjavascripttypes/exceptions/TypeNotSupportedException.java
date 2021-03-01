package com.pixelcat.velocity.javaandjavascripttypes.exceptions;

/**TypeNotSupportedException is thrown when the user requests to build a JSON with an 
 * unsupported type regardless if the type itself could be a valid Javascript type or an invalid javascript type.
 *  For example, if a user requests to build a JSON with type Date or type foo, this
 * exception will be thrown.
 */
public class TypeNotSupportedException extends RuntimeException {
    
    public TypeNotSupportedException() {
        super("The application was asked to construct a JSON with a type not supported by the JSON spec.");
    }

    public TypeNotSupportedException(String message){
        super(message);
    }
}
