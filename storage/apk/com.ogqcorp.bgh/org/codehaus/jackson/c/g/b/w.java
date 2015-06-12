// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.g.b;

import org.codehaus.jackson.c.f;
import java.util.Collection;

public abstract class w<T extends Collection<?>> extends v<T>
{
    protected final f b;
    
    protected w(final Class<?> clazz, final f b) {
        super(clazz, false);
        this.b = b;
    }
}
