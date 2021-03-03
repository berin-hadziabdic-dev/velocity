package com.pixelcat.velocity.javaandjavascripttypes.javascript;

import com.pixelcat.velocity.javaandjavascripttypes.exceptions.TypeNotSupportedException;

import lombok.Getter;

/**
 * This wrapper entity is used to represent a Javascript type that will be a
 * field inside a Java generated JSON object. It's main purpose is to ensure the
 * user of the application is building valid JSON objects. If the entity detects
 * an unsupported JSON type, it will throw a TypeNotSupportedException.
 */


public  class JavascriptType {
    public static final String integer = "integer";
    public static final String double_  = "double";
    public static final String boolean_ = "boolean";
    public static final String string = "string";
    public static final String undefined = "undefined";
    public static final String object = "object";
    

    public static String toJavaTypeString(String typeOfField) throws RuntimeException {
        String returnString  = null;

        switch(typeOfField){
            case JavascriptType.string:
                returnString = String.class.getName();
            break;
            case JavascriptType.boolean_:
                returnString = Boolean.class.getName();
            break;
            case JavascriptType.integer:
                returnString = Integer.class.getName();
            break;
            case JavascriptType.double_:
                returnString = Double.class.getName();
            break;
            case JavascriptType.object:
                returnString = Object.class.getName(); 
            break;   
            default:
                throw new TypeNotSupportedException();
        }

        return returnString;

    }
    

    
    
}
