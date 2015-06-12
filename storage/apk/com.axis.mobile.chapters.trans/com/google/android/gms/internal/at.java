// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.mediation.admob.AdMobExtras;
import java.util.HashMap;
import java.util.HashSet;
import android.content.Context;
import com.google.android.gms.ads.mediation.NetworkExtras;
import java.util.Collections;
import com.google.android.gms.ads.search.SearchAdRequest;
import java.util.Map;
import android.os.Bundle;
import android.location.Location;
import java.util.Set;
import java.util.Date;

public final class at
{
    public static final String DEVICE_ID_EMULATOR;
    private final Date d;
    private final Set f;
    private final Location h;
    private final String mk;
    private final int ml;
    private final boolean mm;
    private final Bundle mn;
    private final Map mo;
    private final String mp;
    private final SearchAdRequest mq;
    private final int mr;
    private final Set ms;
    
    static {
        DEVICE_ID_EMULATOR = et.y("emulator");
    }
    
    public at(final at$a at$a) {
        this(at$a, null);
    }
    
    public at(final at$a at$a, final SearchAdRequest mq) {
        this.d = at$a.d;
        this.mk = at$a.mk;
        this.ml = at$a.ml;
        this.f = Collections.unmodifiableSet((Set<?>)at$a.mt);
        this.h = at$a.h;
        this.mm = at$a.mm;
        this.mn = at$a.mn;
        this.mo = Collections.unmodifiableMap((Map<?, ?>)at$a.mu);
        this.mp = at$a.mp;
        this.mq = mq;
        this.mr = at$a.mr;
        this.ms = Collections.unmodifiableSet((Set<?>)at$a.mv);
    }
    
    public SearchAdRequest aH() {
        return this.mq;
    }
    
    public Map aI() {
        return this.mo;
    }
    
    public Bundle aJ() {
        return this.mn;
    }
    
    public int aK() {
        return this.mr;
    }
    
    public Date getBirthday() {
        return this.d;
    }
    
    public String getContentUrl() {
        return this.mk;
    }
    
    public Bundle getCustomEventExtrasBundle(final Class clazz) {
        final Bundle bundle = this.mn.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter");
        if (bundle != null) {
            return bundle.getBundle(clazz.getClass().getName());
        }
        return null;
    }
    
    public int getGender() {
        return this.ml;
    }
    
    public Set getKeywords() {
        return this.f;
    }
    
    public Location getLocation() {
        return this.h;
    }
    
    public boolean getManualImpressionsEnabled() {
        return this.mm;
    }
    
    @Deprecated
    public NetworkExtras getNetworkExtras(final Class clazz) {
        return this.mo.get(clazz);
    }
    
    public Bundle getNetworkExtrasBundle(final Class clazz) {
        return this.mn.getBundle(clazz.getName());
    }
    
    public String getPublisherProvidedId() {
        return this.mp;
    }
    
    public boolean isTestDevice(final Context context) {
        return this.ms.contains(et.r(context));
    }
}
