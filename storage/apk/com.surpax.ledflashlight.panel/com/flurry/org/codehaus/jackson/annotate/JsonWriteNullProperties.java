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
@Deprecated
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE, ElementType.METHOD, ElementType.FIELD })
public @interface JsonWriteNullProperties {
    boolean value() default true;
}