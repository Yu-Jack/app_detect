// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.location.Location;
import java.util.Date;
import com.google.android.gms.ads.mediation.NetworkExtras;
import android.os.Bundle;
import com.google.android.gms.ads.c.b;
import java.util.HashMap;
import java.util.HashSet;

public final class aa
{
    private final HashSet<String> a;
    private final HashMap<Class<? extends b>, Bundle> b;
    private final HashMap<Class<? extends NetworkExtras>, NetworkExtras> c;
    private final HashSet<String> d;
    private Date e;
    private String f;
    private int g;
    private Location h;
    private boolean i;
    private String j;
    private int k;
    
    public aa() {
        this.a = new HashSet<String>();
        this.b = new HashMap<Class<? extends b>, Bundle>();
        this.c = new HashMap<Class<? extends NetworkExtras>, NetworkExtras>();
        this.d = new HashSet<String>();
        this.g = -1;
        this.i = false;
        this.k = -1;
    }
    
    public void a(final int g) {
        this.g = g;
    }
    
    public void a(final Class<? extends b> key, final Bundle value) {
        this.b.put(key, value);
    }
    
    public void a(final String e) {
        this.a.add(e);
    }
    
    public void a(final Date e) {
        this.e = e;
    }
    
    public void a(final boolean b) {
        int k;
        if (b) {
            k = 1;
        }
        else {
            k = 0;
        }
        this.k = k;
    }
    
    public void b(final String e) {
        this.d.add(e);
    }
}
