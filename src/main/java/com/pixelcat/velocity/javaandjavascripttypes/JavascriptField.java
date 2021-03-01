package com.pixelcat.velocity.javaandjavascripttypes;

import java.util.Map;
import java.util.regex.Pattern;

import com.pixelcat.velocity.entity.jsonentities.dto.JsonFieldDTO;
import com.pixelcat.velocity.entity.jsonentities.entityInterfaces.GeneratorTypeIdentifier;
import com.pixelcat.velocity.entity.jsonentities.entityInterfaces.GenericFieldGenerator;
import com.pixelcat.velocity.entity.jsonentities.entityInterfaces.NumericFieldGenerator;
import com.pixelcat.velocity.entity.jsonentities.entitybuilders.FieldBuilderDelagateStrategy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class JavascriptField {
    
    public final static String  MAX = "max";
    public final static String  MIN = "min";
    
    public final static String STRING_LENGTH = "string_length";
    public final static String PROHIBITED_CHARACTERS = "prohibited_chars";
    public final static String REQUIRED_CHARACTERS = "required_character_ranges";
	public static final String ALL_TRUE_OR_FALSE = "all_true_or_false";
	public static final String ALL_FALSE = "all_false";
	public static final String ALL_TRUE = "all_true";

    private FieldBuilderDelagateStrategy strategy;

    String fieldName;
    String javaClassType; 

    Map<String,Object> restricitions;
    FieldBuilderDelagateStrategy defaultStrategy;
    
   



    
    public JavascriptField(FieldBuilderDelagateStrategy defaultStrategy,JsonFieldDTO dto){
        
        if(dto == null)
            throw new NullPointerException("A null JsonFieldDTO was passed to a JavascriptField obect. Null dto's cannot be passed into the JavascriptField.");
        
        this.fieldName = dto.getFieldName();
        this.javaClassType = JavascriptType.toJavaTypeString(dto.getFieldType());
        this.restricitions = dto.getRestrictions();
        this.defaultStrategy = defaultStrategy;
    }

   
    public String buildJsonString(Integer key) throws Exception {
        
        String value = (String) this.defaultStrategy.doStrategy(this.javaClassType,this.restricitions);
        value = "\"" + this.fieldName + "\"" + ":" + value;
    
        return value;
    }







}
