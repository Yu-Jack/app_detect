// 
// Decompiled by Procyon v0.5.29
// 

package com.flurry.org.codehaus.jackson.annotate;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Annotation;

@JacksonAnnotation
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER })
public @interface JsonTypeInfo {
    Class defaultImpl() default "Lcom/flurry/org/codehaus/jackson/annotate/JsonTypeInfo$None;";
    
    JsonTypeInfo$As include() default JsonTypeInfo$As.PROPERTY;
    
    String property() default "";
    
    JsonTypeInfo$Id use();
}
