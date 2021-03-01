package com.pixelcat.velocity.j2eepatterns.patterninterfaces;

/*
The build interface is use to build a JSON field. It accepts a type R 
which represents field restricitions and type T which represents the 
concrete java field representation of said JSON field.
*/
public interface FieldBuilder<R,T> {

    /**
     * Build builds Java representation of a json field.
     * @param R the restrictions of the field to build, if any.Can be null to indicate no restrictions.
     * @returns T the Java representation of a JSON field */
    public T build(R restrictions);
    
}
