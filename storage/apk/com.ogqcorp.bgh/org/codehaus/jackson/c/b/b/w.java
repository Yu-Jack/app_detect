// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.b.b;

import org.codehaus.jackson.c.p;
import org.codehaus.jackson.k;
import org.codehaus.jackson.f.a;

public class w extends bt<a>
{
    public w() {
        super(a.class);
    }
    
    public a b(final k k, final p p2) {
        final org.codehaus.jackson.p e = k.e();
        if (e == org.codehaus.jackson.p.h) {
            final String trim = k.k().trim();
            if (trim.length() == 0) {
                return this.c();
            }
            return p2.f().b(trim);
        }
        else {
            if (e == org.codehaus.jackson.p.g) {
                return (a)k.z();
            }
            throw p2.b(this.q);
        }
    }
}
