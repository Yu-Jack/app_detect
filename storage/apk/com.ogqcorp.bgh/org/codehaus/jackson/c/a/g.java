// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.a;

import org.codehaus.jackson.c.ad;
import org.codehaus.jackson.annotate.JacksonAnnotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Annotation;

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.TYPE, ElementType.PARAMETER })
@JacksonAnnotation
public @interface g {
    Class<? extends ad<?>> a() default "Lorg/codehaus/jackson/c/ae;";
    
    Class<? extends ad<?>> b() default "Lorg/codehaus/jackson/c/ae;";
    
    Class<? extends ad<?>> c() default "Lorg/codehaus/jackson/c/ae;";
    
    Class<?> d() default "Lorg/codehaus/jackson/c/a/n;";
    
    Class<?> e() default "Lorg/codehaus/jackson/c/a/n;";
    
    Class<?> f() default "Lorg/codehaus/jackson/c/a/n;";
    
    i g() default i.DYNAMIC;
    
    h h() default h.ALWAYS;
}
