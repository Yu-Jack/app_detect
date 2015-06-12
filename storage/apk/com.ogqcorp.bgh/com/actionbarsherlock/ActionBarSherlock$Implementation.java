// 
// Decompiled by Procyon v0.5.29
// 

package com.actionbarsherlock;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Annotation;

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE })
public @interface ActionBarSherlock$Implementation {
    public static final int DEFAULT_API = -1;
    public static final int DEFAULT_DPI = -1;
    
    int api() default -1;
    
    int dpi() default -1;
}
