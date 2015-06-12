// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.Bundle;

public class eb
{
    private final Object a;
    private int b;
    private int c;
    private final dy d;
    private final String e;
    
    eb(final dy d, final String e) {
        this.a = new Object();
        this.d = d;
        this.e = e;
    }
    
    public eb(final String s) {
        this(dy.a(), s);
    }
    
    public Bundle a() {
        synchronized (this.a) {
            final Bundle bundle = new Bundle();
            bundle.putInt("pmnli", this.b);
            bundle.putInt("pmnll", this.c);
            return bundle;
        }
    }
    
    public void a(final int b, final int c) {
        synchronized (this.a) {
            this.b = b;
            this.c = c;
            this.d.a(this.e, this);
        }
    }
}
