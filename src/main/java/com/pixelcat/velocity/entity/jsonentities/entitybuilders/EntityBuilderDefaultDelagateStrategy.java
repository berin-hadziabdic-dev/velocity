package com.pixelcat.velocity.entity.jsonentities.entitybuilders;

import java.util.List;

import com.pixelcat.velocity.entity.jsonentities.entityInterfaces.FieldGenerator;
import com.pixelcat.velocity.globaltypes.JavascriptType;
import com.pixelcat.velocity.j2eepatterns.exceptions.StrategyNotFoundException;
import com.pixelcat.velocity.j2eepatterns.patterninterfaces.KeyValueStrategy;

import org.springframework.stereotype.Component;
import org.springframework.web.util.JavaScriptUtils;


/**The default delagate Strategy is used to select  */
@Component
public class EntityBuilderDefaultDelagateStrategy implements KeyValueStrategy<JavascriptType, FieldGenerator<Object, Object>> {

    List<FieldGenerator<Object,Object>> jsonFieldGenerators;


    @Override
    public FieldGenerator<Object, Object> doStrategy(JavascriptType typeInformation) throws StrategyNotFoundException{
        // TODO Auto-generated method stub
        return null;
    }

    private boolean isMatchingStrategy(JavascriptType type, FieldGenerator<Object,Object> selectedFieldGenerator){

        final String javascriptType = type.getTypeOfField();
        String generatorValueClass = selectedFieldGenerator.getClass().getGenericInterfaces()[1].getClass().toString();
        
        boolean isMatchingStrategy = false;

        switch(javascriptType){
            case JavascriptType.string:
                if(generatorValueClass.equals(String.class.toString()))
                    isMatchingStrategy = true;
            break;
            case JavascriptType.number:
                if(
                   generatorValueClass.equals(Integer.class.toString()) 
                || generatorValueClass.equals(Double.class.toString())
                || generatorValueClass.equals(Long.class.toString())
                || generatorValueClass.equals(Float.class.toString())
                )
                    isMatchingStrategy = true;
                break;
            case JavascriptType.object:
                isMatchingStrategy = true;
                break;
            case JavascriptType.boolean_:
                isMatchingStrategy = true;
                break;
        }

        return isMatchingStrategy;
    }
    
    
}
