// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.annotate;

import java.lang.annotation.Annotation;

public @interface JsonSubTypes$Type {
    String name() default "";
    
    Class<?> value();
}
