package com.pixelcat.velocity.velocity.javascripttypetests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;

import com.pixelcat.velocity.javaandjavascripttypes.exceptions.TypeNotSupportedException;
import com.pixelcat.velocity.javaandjavascripttypes.javascript.JavascriptType;

import org.junit.Test;

public class JavscriptTypeTest {
    
    @Test
    public  void testNegativeCase(){

        assertThrows(TypeNotSupportedException.class, () -> {
            JavascriptType.toJavaTypeString(Float.class.getName());
        });
    }

    @Test
    public  void testCorrectTypeMappings() {
        assertEquals(JavascriptType.toJavaTypeString(JavascriptType.boolean_),Boolean.class.getName());
        assertEquals(JavascriptType.toJavaTypeString(JavascriptType.integer),Integer.class.getName());
        assertEquals(JavascriptType.toJavaTypeString(JavascriptType.string),String.class.getName());
        assertEquals(JavascriptType.toJavaTypeString(JavascriptType.object),Object.class.getName());
        assertEquals(JavascriptType.toJavaTypeString(JavascriptType.double_),Double.class.getName());
    }
}
