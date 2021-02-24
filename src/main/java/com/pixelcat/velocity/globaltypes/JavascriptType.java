package com.pixelcat.velocity.globaltypes;

import com.pixelcat.velocity.globaltypes.exceptions.TypeNotSupportedException;

import lombok.Getter;

/**
 * This wrapper entity is used to represent a Javascript type that will be a
 * field inside a Java generated JSON object. It's main purpose is to ensure the
 * user of the application is building valid JSON objects. If the entity detects
 * an unsupported JSON type, it will throw a TypeNotSupportedException.
 */


public  class JavascriptType {
    public static final String number = "number";
    public static final String boolean_ = "boolean";
    public static final String string = "string";
    public static final String undefined = "undefined";
    public static final String object = "object";
    
    Integer id;
    @Getter
    String  typeOfField;

    private JavascriptType() {

    }

    public JavascriptType(Integer id, String type){
        if(this.isValidType(type)){
            
            this.id = id;
        }
        else {
            throw new TypeNotSupportedException();
        }

        if(id != null){
            this.id = id;
        } else {
            throw new NullPointerException("A null entity id was detected in the JavascriptType class.");
        }
    }

    private boolean isValidType(String jsTypeArgument){
        boolean isValidType = false;

        if(jsTypeArgument != null && jsTypeArgument.length() > 0)
            switch(jsTypeArgument){
                case JavascriptType.number:
                case JavascriptType.boolean_:
                case JavascriptType.string:
                case JavascriptType.undefined:
                case JavascriptType.object:
                    isValidType = true;
                break;
            }

        return isValidType;
    }
    
}
