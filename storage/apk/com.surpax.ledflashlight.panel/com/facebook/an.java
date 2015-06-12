// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook;

import java.util.HashMap;
import android.os.Handler;
import java.util.Map;
import java.io.OutputStream;

final class an extends OutputStream implements az
{
    private final Map a;
    private final Handler b;
    private Request c;
    private ba d;
    private int e;
    
    an(final Handler b) {
        this.a = new HashMap();
        this.b = b;
    }
    
    final int a() {
        return this.e;
    }
    
    final void a(final long n) {
        if (this.d == null) {
            this.d = new ba(this.b, this.c);
            this.a.put(this.c, this.d);
        }
        this.d.b(n);
        this.e += (int)n;
    }
    
    @Override
    public final void a(final Request c) {
        this.c = c;
        ba d;
        if (c != null) {
            d = this.a.get(c);
        }
        else {
            d = null;
        }
        this.d = d;
    }
    
    final Map b() {
        return this.a;
    }
    
    @Override
    public final void write(final int n) {
        this.a(1L);
    }
    
    @Override
    public final void write(final byte[] array) {
        this.a(array.length);
    }
    
    @Override
    public final void write(final byte[] array, final int n, final int n2) {
        this.a(n2);
    }
}
