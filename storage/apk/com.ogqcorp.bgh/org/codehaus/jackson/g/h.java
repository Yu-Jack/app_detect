// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.g;

import org.codehaus.jackson.f;
import java.util.Arrays;
import org.codehaus.jackson.a.b;

public class h implements b
{
    static final String a;
    static final char[] b;
    
    static {
        while (true) {
            try {
                String property = System.getProperty("line.separator");
                if (property == null) {
                    property = "\n";
                }
                a = property;
                Arrays.fill(b = new char[64], ' ');
            }
            catch (Throwable t) {
                final String property = null;
                continue;
            }
            break;
        }
    }
    
    @Override
    public void a(final f f, final int n) {
        f.c(h.a);
        if (n > 0) {
            int i;
            for (i = n + n; i > 64; i -= h.b.length) {
                f.b(h.b, 0, 64);
            }
            f.b(h.b, 0, i);
        }
    }
    
    @Override
    public boolean a() {
        return false;
    }
}
