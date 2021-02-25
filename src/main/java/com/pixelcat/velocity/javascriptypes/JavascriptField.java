package com.pixelcat.velocity.javascriptypes;

import lombok.Data;

@Data
public class JavascriptField {
    
    String fieldName;
    String javascriptFieldType; 


    Float min;
    Float max;


    public JavascriptType getJavascriptType(){
        return null;
    }
}
