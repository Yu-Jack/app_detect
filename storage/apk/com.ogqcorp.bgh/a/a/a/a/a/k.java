// 
// Decompiled by Procyon v0.5.29
// 

package a.a.a.a.a;

import java.io.OutputStream;
import a.a.a.c;
import a.a.a.d;

class k implements d
{
    private final a a;
    private final c b;
    private final long c;
    
    k(final a a, final String s, final long c) {
        this.a = a;
        this.b = new a.a.a.b.a("Content-Type", s);
        this.c = c;
    }
    
    @Override
    public c a() {
        return this.b;
    }
    
    @Override
    public void a(final OutputStream outputStream) {
        this.a.a(outputStream);
    }
}
