// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.a;

import org.codehaus.jackson.c.af;
import org.codehaus.jackson.c.x;
import org.codehaus.jackson.annotate.JacksonAnnotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Annotation;

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.TYPE, ElementType.PARAMETER })
@JacksonAnnotation
public @interface d {
    Class<? extends x<?>> a() default "Lorg/codehaus/jackson/c/y;";
    
    Class<? extends x<?>> b() default "Lorg/codehaus/jackson/c/y;";
    
    Class<? extends af> c() default "Lorg/codehaus/jackson/c/ag;";
    
    Class<?> d() default "Lorg/codehaus/jackson/c/a/n;";
    
    Class<?> e() default "Lorg/codehaus/jackson/c/a/n;";
    
    Class<?> f() default "Lorg/codehaus/jackson/c/a/n;";
}
