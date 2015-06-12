// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.b.b;

import org.codehaus.jackson.c.t;
import org.codehaus.jackson.c.n;
import org.codehaus.jackson.c.p;
import org.codehaus.jackson.k;
import org.codehaus.jackson.c.x;
import org.codehaus.jackson.c.f;
import org.codehaus.jackson.f.a;
import org.codehaus.jackson.c.ar;
import java.util.concurrent.atomic.AtomicReference;

public class b extends bt<AtomicReference<?>> implements ar
{
    protected final a a;
    protected final f b;
    protected x<?> c;
    
    public b(final a a, final f b) {
        super(AtomicReference.class);
        this.a = a;
        this.b = b;
    }
    
    @Override
    public void a(final n n, final t t) {
        this.c = t.a(n, this.a, this.b);
    }
    
    public AtomicReference<?> b(final k k, final p p2) {
        return new AtomicReference<Object>(this.c.a(k, p2));
    }
}
