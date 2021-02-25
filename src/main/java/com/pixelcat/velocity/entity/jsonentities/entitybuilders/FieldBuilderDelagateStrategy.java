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
import com.pixelcat.velocity.javascriptypes.*;
import com.pixelcat.velocity.j2eepatterns.patterninterfaces.KeyValueStrategy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/** The default delagate Strategy is used to select a field generator based on the JavascriptType 
 * of a json object field, and create a random value for said type.
 */
@Component
public class FieldBuilderDelagateStrategy implements KeyValueStrategy<Integer, JavascriptType> {

    private Map<String, NumericFieldGenerator> numericGenerators;
    private Map<String, GenericFieldGenerator> genericFieldGenerators;

    @Autowired
    public FieldBuilderDelagateStrategy(IntegerFieldGenerator integerFieldBuilder, FloatFieldGenerator floatGenerator,
            StringFieldGenerator stringFieldBuilder, BooleanFieldGenerator booleanFieldBuilder) {
        this.genericFieldGenerators = new HashMap<>();
        this.numericGenerators = new HashMap<>();

        this.numericGenerators.put(Integer.class.getName(), integerFieldBuilder);
        this.numericGenerators.put(Float.class.getName(), floatGenerator);

        this.genericFieldGenerators.put(String.class.getName(), stringFieldBuilder);
        this.genericFieldGenerators.put(String.class.getName(), booleanFieldBuilder);
    }

    @Override
    public Object doStrategy(JavascriptType typeInformation, Integer key) throws Exception {
        // TODO Auto-generated method stub
        Object returnObject = null;
        String javaTypeFromJavascriptTypeMapping = typeInformation.toJavaTypeString();

        NumericFieldGenerator numericFieldGenerator= null;
        GenericFieldGenerator genericGenerator =null;

        numericFieldGenerator = this.numericGenerators.get(typeInformation.toJavaTypeString());
        genericGenerator = this.genericFieldGenerators.get(typeInformation.toJavaTypeString());

        if(numericFieldGenerator == null && genericGenerator == null)
            throw new UnmappedFieldGeneratorException();

        if(numericFieldGenerator != null)
            returnObject = numericFieldGenerator.generate(key, 10, -1);


        return returnObject;
    }



    }

  
    
    
    

