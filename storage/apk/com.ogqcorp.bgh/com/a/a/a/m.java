// 
// Decompiled by Procyon v0.5.29
// 

package com.a.a.a;

import java.io.UnsupportedEncodingException;
import com.a.a.q;
import com.a.a.k;
import com.a.a.r;
import com.a.a.s;
import com.a.a.n;

public class m extends n<String>
{
    private final s<String> a;
    
    public m(final int n, final String s, final s<String> a, final r r) {
        super(n, s, r);
        this.a = a;
    }
    
    @Override
    protected q<String> a(final k k) {
        try {
            final String s = new String(k.b, com.a.a.a.h.a(k.c));
            return q.a(s, com.a.a.a.h.a(k));
        }
        catch (UnsupportedEncodingException ex) {
            final String s = new String(k.b);
            return q.a(s, com.a.a.a.h.a(k));
        }
    }
    
    protected void c(final String s) {
        this.a.a(s);
    }
}
