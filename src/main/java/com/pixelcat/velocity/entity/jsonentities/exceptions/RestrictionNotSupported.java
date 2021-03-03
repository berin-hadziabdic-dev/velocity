package com.pixelcat.velocity.entity.jsonentities.exceptions;

/**RestrictionNotSupported is an exception that can be thrown when a user submitted JSON contains an unrecognized restriction 
 * type.
 */
public class RestrictionNotSupported extends RuntimeException
{
    public RestrictionNotSupported(){
        super("The application was asked to produce a json field whose restrictions did not contain valid values.");
    }

    public RestrictionNotSupported(String message){
        super(message);
    }
}
