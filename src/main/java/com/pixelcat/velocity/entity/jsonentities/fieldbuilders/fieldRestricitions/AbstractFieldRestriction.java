package com.pixelcat.velocity.entity.jsonentities.fieldbuilders.fieldRestricitions;

import java.util.HashMap;
import java.util.Map;

import com.pixelcat.velocity.javaandjavascripttypes.exceptions.TypeNotSupportedException;


/**
 * IRestriction interface is a contract for field generators that must follow
 * some kind of field domain restriction. For example, a numeric field may have
 * a max min restriction. Implemenenting this Abstract class would ensure that
 * field generators are able to produce field restrictions. Restrictions
 * themselves are stored as Object values instead of their implemented type.
 * This is ok as it is convinient and there are only a handful of types we need
 * to account for so it is managable.
 */
public abstract class AbstractFieldRestriction<V> {
   
    private Map<String, Object> restrictions;

    public AbstractFieldRestriction(String javaPrimitiveType){
        super();
        this.restrictions = null;
    }
    public abstract V getRestriction(String restrictionName);

    private void buildRestriction(String javaPrimitiveType) throws NullPointerException, TypeNotSupportedException {
        if(javaPrimitiveType == null)
            throw new NullPointerException("The application waas asked to build restricitions for a null pointer. Restrictions can only be built for valid JSON compatible Java types.");
        //if(restrictionName)

    }
}
