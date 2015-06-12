// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.b.a;

import org.codehaus.jackson.c.b.i;
import org.codehaus.jackson.g.m;
import java.util.HashMap;
import java.util.ArrayList;

public class g
{
    private final ArrayList<h> a;
    private final HashMap<String, Integer> b;
    
    public g() {
        this.a = new ArrayList<h>();
        this.b = new HashMap<String, Integer>();
    }
    
    public f a() {
        return new f(this.a.toArray(new h[this.a.size()]), this.b, null, null);
    }
    
    public void a(final i i, final String key) {
        final Integer value = this.a.size();
        this.a.add(new h(i, key));
        this.b.put(i.c(), value);
        this.b.put(key, value);
    }
}
