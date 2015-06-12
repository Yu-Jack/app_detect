// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.f;

import org.codehaus.jackson.annotate.JsonTypeInfo$Id;
import org.codehaus.jackson.annotate.JsonTypeInfo$As;
import org.codehaus.jackson.c.ba;
import org.codehaus.jackson.c.at;
import org.codehaus.jackson.c.az;
import org.codehaus.jackson.c.f;
import java.util.Collection;
import org.codehaus.jackson.f.a;
import org.codehaus.jackson.c.n;

public interface d<T extends d<T>>
{
    Class<?> a();
    
    az a(n p0, a p1, Collection<org.codehaus.jackson.c.f.a> p2, f p3);
    
    ba a(at p0, a p1, Collection<org.codehaus.jackson.c.f.a> p2, f p3);
    
    T a(Class<?> p0);
    
    T a(String p0);
    
    T a(JsonTypeInfo$As p0);
    
    T a(JsonTypeInfo$Id p0, c p1);
}
