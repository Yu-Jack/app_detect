// 
// Decompiled by Procyon v0.5.29
// 

package com.google.a.a;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Annotation;

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD })
public @interface i {
    String a();
    
    boolean b() default true;
}
