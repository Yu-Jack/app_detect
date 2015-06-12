// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.annotate;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Annotation;

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE })
@JacksonAnnotation
public @interface JsonAutoDetect {
    JsonAutoDetect$Visibility creatorVisibility() default JsonAutoDetect$Visibility.DEFAULT;
    
    JsonAutoDetect$Visibility fieldVisibility() default JsonAutoDetect$Visibility.DEFAULT;
    
    JsonAutoDetect$Visibility getterVisibility() default JsonAutoDetect$Visibility.DEFAULT;
    
    JsonAutoDetect$Visibility isGetterVisibility() default JsonAutoDetect$Visibility.DEFAULT;
    
    JsonAutoDetect$Visibility setterVisibility() default JsonAutoDetect$Visibility.DEFAULT;
    
    JsonMethod[] value() default { JsonMethod.ALL };
}
