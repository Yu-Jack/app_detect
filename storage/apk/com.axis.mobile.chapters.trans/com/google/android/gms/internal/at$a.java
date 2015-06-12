// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.mediation.admob.AdMobExtras;
import com.google.android.gms.ads.mediation.NetworkExtras;
import java.util.HashMap;
import java.util.HashSet;
import android.os.Bundle;
import android.location.Location;
import java.util.Date;

public final class at$a
{
    private Date d;
    private Location h;
    private String mk;
    private int ml;
    private boolean mm;
    private final Bundle mn;
    private String mp;
    private int mr;
    private final HashSet mt;
    private final HashMap mu;
    private final HashSet mv;
    
    public at$a() {
        this.mt = new HashSet();
        this.mn = new Bundle();
        this.mu = new HashMap();
        this.mv = new HashSet();
        this.ml = -1;
        this.mm = false;
        this.mr = -1;
    }
    
    public void a(final Location h) {
        this.h = h;
    }
    
    @Deprecated
    public void a(final NetworkExtras value) {
        if (value instanceof AdMobExtras) {
            this.a(AdMobAdapter.class, ((AdMobExtras)value).getExtras());
            return;
        }
        this.mu.put(value.getClass(), value);
    }
    
    public void a(final Class clazz, final Bundle bundle) {
        this.mn.putBundle(clazz.getName(), bundle);
    }
    
    public void a(final Date d) {
        this.d = d;
    }
    
    public void b(final Class clazz, final Bundle bundle) {
        if (this.mn.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter") == null) {
            this.mn.putBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter", new Bundle());
        }
        this.mn.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter").putBundle(clazz.getName(), bundle);
    }
    
    public void e(final int ml) {
        this.ml = ml;
    }
    
    public void g(final String e) {
        this.mt.add(e);
    }
    
    public void g(final boolean mm) {
        this.mm = mm;
    }
    
    public void h(final String e) {
        this.mv.add(e);
    }
    
    public void h(final boolean b) {
        int mr;
        if (b) {
            mr = 1;
        }
        else {
            mr = 0;
        }
        this.mr = mr;
    }
    
    public void i(final String mk) {
        this.mk = mk;
    }
    
    public void j(final String mp) {
        this.mp = mp;
    }
}
