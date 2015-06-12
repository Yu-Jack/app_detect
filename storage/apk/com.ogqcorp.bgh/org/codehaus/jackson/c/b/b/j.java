// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.b.b;

import java.io.Serializable;
import org.codehaus.jackson.c.i.l;
import org.codehaus.jackson.c.p;
import org.codehaus.jackson.k;
import org.codehaus.jackson.c.e.f;
import java.lang.reflect.Method;

public class j extends bt<Object>
{
    protected final Class<?> a;
    protected final Class<?> b;
    protected final Method c;
    
    public j(final Class<?> a, final f f, final Class<?> b) {
        super(Enum.class);
        this.a = a;
        this.c = f.e();
        this.b = b;
    }
    
    @Override
    public Object a(final k k, final p p2) {
        Label_0036: {
            if (this.b != null) {
                break Label_0036;
            }
            Serializable s = k.k();
            try {
                return this.c.invoke(this.a, s);
                // iftrue(Label_0056:, this.b != Integer.class)
                // iftrue(Label_0076:, this.b != Long.class)
            Block_3:
                while (true) {
                    s = k.B();
                    return this.c.invoke(this.a, s);
                    Label_0076: {
                        throw p2.b(this.a);
                    }
                    break Block_3;
                    Label_0056:
                    continue;
                }
                s = k.A();
                return this.c.invoke(this.a, s);
            }
            catch (Exception ex) {
                l.c(ex);
                return null;
            }
        }
    }
}
