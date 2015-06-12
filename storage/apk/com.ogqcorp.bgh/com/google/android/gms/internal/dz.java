// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.Bundle;

public class dz
{
    private final Object a;
    private final String b;
    private int c;
    private long d;
    private long e;
    private int f;
    private int g;
    
    public dz(final String b) {
        this.a = new Object();
        this.c = 0;
        this.d = -1L;
        this.e = -1L;
        this.f = 0;
        this.g = -1;
        this.b = b;
    }
    
    public long a() {
        return this.e;
    }
    
    public Bundle a(final String s) {
        synchronized (this.a) {
            final Bundle bundle = new Bundle();
            bundle.putString("session_id", this.b);
            bundle.putLong("basets", this.e);
            bundle.putLong("currts", this.d);
            bundle.putString("seq_num", s);
            bundle.putInt("preqs", this.g);
            bundle.putInt("pclick", this.c);
            bundle.putInt("pimp", this.f);
            return bundle;
        }
    }
    
    public void a(final ah ah, final long n) {
        synchronized (this.a) {
            if (this.e == -1L) {
                this.e = n;
                this.d = this.e;
            }
            else {
                this.d = n;
            }
            if (ah.c != null && ah.c.getInt("gw", 2) == 1) {
                return;
            }
        }
        ++this.g;
    }
    // monitorexit(o)
    
    public void b() {
        synchronized (this.a) {
            ++this.c;
        }
    }
    
    public void c() {
        synchronized (this.a) {
            ++this.f;
        }
    }
}
