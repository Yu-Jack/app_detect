// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.b.b;

import org.codehaus.jackson.c.z;
import org.codehaus.jackson.c.p;
import org.codehaus.jackson.k;

public class bb extends bt<StackTraceElement>
{
    public bb() {
        super(StackTraceElement.class);
    }
    
    public StackTraceElement b(final k k, final p p2) {
        final org.codehaus.jackson.p e = k.e();
        if (e != org.codehaus.jackson.p.b) {
            throw p2.a(this.q, e);
        }
        String i = "";
        String j = "";
        String l = "";
        int t = -1;
        while (true) {
            final org.codehaus.jackson.p c = k.c();
            if (c == org.codehaus.jackson.p.c) {
                return new StackTraceElement(i, j, l, t);
            }
            final String g = k.g();
            if ("className".equals(g)) {
                i = k.k();
            }
            else if ("fileName".equals(g)) {
                l = k.k();
            }
            else if ("lineNumber".equals(g)) {
                if (!c.c()) {
                    throw z.a(k, "Non-numeric token (" + c + ") for property 'lineNumber'");
                }
                t = k.t();
            }
            else if ("methodName".equals(g)) {
                j = k.k();
            }
            else {
                if ("nativeMethod".equals(g)) {
                    continue;
                }
                this.a(k, p2, this.q, g);
            }
        }
    }
}
