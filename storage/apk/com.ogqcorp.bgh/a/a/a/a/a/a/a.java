// 
// Decompiled by Procyon v0.5.29
// 

package a.a.a.a.a.a;

import java.nio.charset.Charset;
import a.a.a.a.a;

public abstract class a implements b
{
    private final a.a.a.a.a a;
    
    public a(final a.a.a.a.a a) {
        a.a.a.c.a.a(a, "Content type");
        this.a = a;
    }
    
    @Override
    public String a() {
        return this.a.a();
    }
    
    @Override
    public String b() {
        final Charset b = this.a.b();
        if (b != null) {
            return b.name();
        }
        return null;
    }
}
