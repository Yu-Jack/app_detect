// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.b.a;

import org.codehaus.jackson.g.m;
import org.codehaus.jackson.c.p;
import org.codehaus.jackson.k;
import org.codehaus.jackson.c.b.i;
import java.util.ArrayList;

public class o
{
    protected final ArrayList<i> a;
    
    public o() {
        this.a = new ArrayList<i>();
    }
    
    public Object a(final k k, final p p4, final Object o, final m m) {
        for (int size = this.a.size(), i = 0; i < size; ++i) {
            final i j = this.a.get(i);
            final k h = m.h();
            h.b();
            j.a(h, p4, o);
        }
        return o;
    }
    
    public void a(final i e) {
        this.a.add(e);
    }
}
