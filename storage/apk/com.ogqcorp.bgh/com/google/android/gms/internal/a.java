// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.WeakHashMap;

public final class a implements c
{
    private final Object a;
    private WeakHashMap<du, b> b;
    private ArrayList<b> c;
    
    public a() {
        this.a = new Object();
        this.b = new WeakHashMap<du, b>();
        this.c = new ArrayList<b>();
    }
    
    public b a(final ak ak, final du du) {
        synchronized (this.a) {
            if (this.a(du)) {
                return this.b.get(du);
            }
            final b b = new b(ak, du);
            b.a(this);
            this.b.put(du, b);
            this.c.add(b);
            return b;
        }
    }
    
    @Override
    public void a(final b o) {
        synchronized (this.a) {
            if (!o.e()) {
                this.c.remove(o);
            }
        }
    }
    
    public boolean a(final du key) {
        while (true) {
            synchronized (this.a) {
                final b b = this.b.get(key);
                if (b != null && b.e()) {
                    return true;
                }
            }
            return false;
        }
    }
    
    public void b(final du key) {
        synchronized (this.a) {
            final b b = this.b.get(key);
            if (b != null) {
                b.c();
            }
        }
    }
}
