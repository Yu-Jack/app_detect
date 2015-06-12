// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.common.data;

import android.net.Uri;
import com.google.android.gms.internal.gw;
import com.google.android.gms.internal.gz;

public abstract class d
{
    protected final DataHolder a;
    protected final int b;
    private final int c;
    
    public d(final DataHolder dataHolder, final int b) {
        this.a = gz.a(dataHolder);
        gz.a(b >= 0 && b < dataHolder.g());
        this.b = b;
        this.c = dataHolder.a(this.b);
    }
    
    public boolean a_(final String s) {
        return this.a.a(s);
    }
    
    protected long b(final String s) {
        return this.a.a(s, this.b, this.c);
    }
    
    protected int c(final String s) {
        return this.a.b(s, this.b, this.c);
    }
    
    protected boolean d(final String s) {
        return this.a.d(s, this.b, this.c);
    }
    
    protected String e(final String s) {
        return this.a.c(s, this.b, this.c);
    }
    
    @Override
    public boolean equals(final Object o) {
        final boolean b = o instanceof d;
        boolean b2 = false;
        if (b) {
            final d d = (d)o;
            final boolean a = gw.a((Object)d.b, this.b);
            b2 = false;
            if (a) {
                final boolean a2 = gw.a((Object)d.c, this.c);
                b2 = false;
                if (a2) {
                    final DataHolder a3 = d.a;
                    final DataHolder a4 = this.a;
                    b2 = false;
                    if (a3 == a4) {
                        b2 = true;
                    }
                }
            }
        }
        return b2;
    }
    
    protected byte[] f(final String s) {
        return this.a.e(s, this.b, this.c);
    }
    
    protected Uri g(final String s) {
        return this.a.f(s, this.b, this.c);
    }
    
    protected boolean h(final String s) {
        return this.a.g(s, this.b, this.c);
    }
    
    @Override
    public int hashCode() {
        return gw.a(this.b, this.c, this.a);
    }
}
