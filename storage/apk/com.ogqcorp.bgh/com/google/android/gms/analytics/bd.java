// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.analytics;

import java.io.ObjectInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.TreeSet;
import java.util.SortedSet;

class bd
{
    private static final bd d;
    private SortedSet<be> a;
    private StringBuilder b;
    private boolean c;
    
    static {
        d = new bd();
    }
    
    private bd() {
        this.a = new TreeSet<be>();
        this.b = new StringBuilder();
        this.c = false;
    }
    
    public static bd a() {
        return bd.d;
    }
    
    public void a(final be be) {
        synchronized (this) {
            if (!this.c) {
                this.a.add(be);
                this.b.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_".charAt(be.ordinal()));
            }
        }
    }
    
    public void a(final boolean c) {
        synchronized (this) {
            this.c = c;
        }
    }
    
    public String b() {
        synchronized (this) {
            final StringBuilder sb = new StringBuilder();
            int n = 6;
            int n2 = 0;
            while (this.a.size() > 0) {
                final be be = this.a.first();
                this.a.remove(be);
                while (be.ordinal() >= n) {
                    sb.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_".charAt(n2));
                    n += 6;
                    n2 = 0;
                }
                n2 += 1 << be.ordinal() % 6;
            }
            if (n2 > 0 || sb.length() == 0) {
                sb.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_".charAt(n2));
            }
            this.a.clear();
            return sb.toString();
        }
    }
    
    public String c() {
        synchronized (this) {
            if (this.b.length() > 0) {
                this.b.insert(0, ".");
            }
            final String string = this.b.toString();
            this.b = new StringBuilder();
            return string;
        }
    }
}
