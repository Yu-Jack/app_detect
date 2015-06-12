// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.ads;

import com.google.android.gms.internal.em;
import com.google.android.gms.internal.ak;
import android.content.Context;

public final class d
{
    public static final d a;
    public static final d b;
    public static final d c;
    public static final d d;
    public static final d e;
    public static final d f;
    public static final d g;
    private final int h;
    private final int i;
    private final String j;
    
    static {
        a = new d(320, 50, "320x50_mb");
        b = new d(468, 60, "468x60_as");
        c = new d(320, 100, "320x100_as");
        d = new d(728, 90, "728x90_as");
        e = new d(300, 250, "300x250_as");
        f = new d(160, 600, "160x600_as");
        g = new d(-1, -2, "smart_banner");
    }
    
    public d(final int i, final int j) {
        final StringBuilder sb = new StringBuilder();
        String value;
        if (i == -1) {
            value = "FULL";
        }
        else {
            value = String.valueOf(i);
        }
        final StringBuilder append = sb.append(value).append("x");
        String value2;
        if (j == -2) {
            value2 = "AUTO";
        }
        else {
            value2 = String.valueOf(j);
        }
        this(i, j, append.append(value2).append("_as").toString());
    }
    
    d(final int n, final int n2, final String j) {
        if (n < 0 && n != -1) {
            throw new IllegalArgumentException("Invalid width for AdSize: " + n);
        }
        if (n2 < 0 && n2 != -2) {
            throw new IllegalArgumentException("Invalid height for AdSize: " + n2);
        }
        this.h = n;
        this.i = n2;
        this.j = j;
    }
    
    public int a() {
        return this.i;
    }
    
    public int a(final Context context) {
        if (this.i == -2) {
            return ak.b(context.getResources().getDisplayMetrics());
        }
        return em.a(context, this.i);
    }
    
    public int b() {
        return this.h;
    }
    
    public int b(final Context context) {
        if (this.h == -1) {
            return ak.a(context.getResources().getDisplayMetrics());
        }
        return em.a(context, this.h);
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o != this) {
            if (!(o instanceof d)) {
                return false;
            }
            final d d = (d)o;
            if (this.h != d.h || this.i != d.i || !this.j.equals(d.j)) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public int hashCode() {
        return this.j.hashCode();
    }
    
    @Override
    public String toString() {
        return this.j;
    }
}
