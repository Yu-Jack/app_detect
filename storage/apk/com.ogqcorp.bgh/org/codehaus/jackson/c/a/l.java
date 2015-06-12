// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.a;

import org.codehaus.jackson.c.b.t;
import org.codehaus.jackson.annotate.JacksonAnnotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Annotation;

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE })
@JacksonAnnotation
public @interface l {
    Class<? extends t> a();
}
