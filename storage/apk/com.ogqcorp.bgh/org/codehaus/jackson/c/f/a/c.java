// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.f.a;

import org.codehaus.jackson.annotate.JsonTypeInfo$As;
import org.codehaus.jackson.c.f;
import org.codehaus.jackson.c.f.c;

public class c extends a
{
    protected final String a;
    
    public c(final org.codehaus.jackson.f.a a, final org.codehaus.jackson.c.f.c c, final f f, final Class<?> clazz, final String a2) {
        super(a, c, f, clazz);
        this.a = a2;
    }
    
    @Override
    public JsonTypeInfo$As a() {
        return JsonTypeInfo$As.EXTERNAL_PROPERTY;
    }
    
    @Override
    public String b() {
        return this.a;
    }
}
