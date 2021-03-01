package com.pixelcat.velocity.entity.jsonentities.entitybuilders;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import com.pixelcat.velocity.entity.exceptions.UnmappedFieldGeneratorException;
import com.pixelcat.velocity.entity.jsonentities.entityInterfaces.GenericFieldGenerator;
import com.pixelcat.velocity.entity.jsonentities.entityInterfaces.NumericFieldGenerator;
import com.pixelcat.velocity.entity.jsonentities.fieldbuilders.BooleanFieldGenerator;
import com.pixelcat.velocity.entity.jsonentities.fieldbuilders.FloatFieldGenerator;
import com.pixelcat.velocity.entity.jsonentities.fieldbuilders.IntegerFieldGenerator;
import com.pixelcat.velocity.entity.jsonentities.fieldbuilders.StringFieldGenerator;
import com.pixelcat.velocity.j2eepatterns.exceptions.StrategyNotFoundException;
import com.pixelcat.velocity.j2eepatterns.patterninterfaces.KeyValueStrategy;
import com.pixelcat.velocity.javaandjavascripttypes.JavascriptField;
import com.pixelcat.velocity.javaandjavascripttypes.JavascriptType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * The default delagate Strategy is used to select a field generator based on
 * the JavascriptType of a json object field, and create a random value for said
 * type.
 */
@Component
public class FieldBuilderDelagateStrategy implements KeyValueStrategy<Integer, Map<String, Object>, String> {

    private Map<String, NumericFieldGenerator> numericGenerators;
    private Map<String, GenericFieldGenerator> genericFieldGenerators;

    @Autowired
    public FieldBuilderDelagateStrategy(IntegerFieldGenerator integerFieldBuilder, FloatFieldGenerator floatGenerator,
            StringFieldGenerator stringFieldBuilder, BooleanFieldGenerator booleanFieldBuilder) {
        this.genericFieldGenerators = new HashMap<>(); // create map for numeric generatiors
        this.numericGenerators = new HashMap<>(); // create map for string,boolean, and object geerators

        this.numericGenerators.put(Integer.class.getName(), integerFieldBuilder); // register float and int
        this.numericGenerators.put(Float.class.getName(), floatGenerator);

        // register all non numeric data
        this.numericGenerators.put(Float.class.getName(), floatGenerator);
        this.genericFieldGenerators.put(String.class.getName(), stringFieldBuilder);
        this.genericFieldGenerators.put(Boolean.class.getName(), booleanFieldBuilder);
    }

    @Override
    public String doStrategy(String typeInformation, Map<String, Object> restrictions)
            throws Exception {
        // TODO Auto-generated method stub
        String returnObject = null;
        String javaTypeFromJavascriptTypeMapping = JavascriptType.toJavaTypeString(typeInformation);

        NumericFieldGenerator numericFieldGenerator = null;
        GenericFieldGenerator genericGenerator = null;

        numericFieldGenerator = this.numericGenerators.get(javaTypeFromJavascriptTypeMapping);
        genericGenerator = this.genericFieldGenerators.get(javaTypeFromJavascriptTypeMapping);

        if (numericFieldGenerator == null && genericGenerator == null)
            throw new UnmappedFieldGeneratorException();

        if (numericFieldGenerator != null)
        {
            Float max = (Float) restrictions.get(JavascriptField.MAX);
            Float min = (Float) restrictions.get(JavascriptField.MIN);
            returnObject = numericFieldGenerator.generate(min, max).toString();
        }
        else 
        {
            returnObject = genericGenerator.generate(restrictions).toString();
        }

        return returnObject;
    }

  


    }

  
    
    
    

