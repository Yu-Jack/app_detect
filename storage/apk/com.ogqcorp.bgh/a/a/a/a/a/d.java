// 
// Decompiled by Procyon v0.5.29
// 

package a.a.a.a.a;

import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.List;

class d extends a
{
    private final List<b> b;
    
    public d(final String s, final Charset charset, final String s2, final List<b> b) {
        super(s, charset, s2);
        this.b = b;
    }
    
    @Override
    public List<b> a() {
        return this.b;
    }
    
    @Override
    protected void a(final b b, final OutputStream outputStream) {
        final c c = b.c();
        a.a.a.a.a.a.a(c.a("Content-Disposition"), this.a, outputStream);
        if (b.b().c() != null) {
            a.a.a.a.a.a.a(c.a("Content-Type"), this.a, outputStream);
        }
    }
}
