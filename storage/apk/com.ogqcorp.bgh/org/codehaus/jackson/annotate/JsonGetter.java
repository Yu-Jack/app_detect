// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.annotate;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Annotation;

@Deprecated
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD })
@JacksonAnnotation
public @interface JsonGetter {
    String value() default "";
}
