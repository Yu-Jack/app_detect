// 
// Decompiled by Procyon v0.5.29
// 

package a.a.a.a.a;

import java.util.Iterator;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.List;

class g extends a
{
    private final List<b> b;
    
    public g(final String s, final Charset charset, final String s2, final List<b> b) {
        super(s, charset, s2);
        this.b = b;
    }
    
    @Override
    public List<b> a() {
        return this.b;
    }
    
    @Override
    protected void a(final b b, final OutputStream outputStream) {
        final Iterator<i> iterator = b.c().iterator();
        while (iterator.hasNext()) {
            a.a.a.a.a.a.a(iterator.next(), outputStream);
        }
    }
}
