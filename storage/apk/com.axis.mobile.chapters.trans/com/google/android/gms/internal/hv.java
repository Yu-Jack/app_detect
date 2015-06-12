// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.Parcel;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.HashMap;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class hv implements SafeParcelable, hy$b
{
    public static final hw CREATOR;
    private final HashMap GW;
    private final HashMap GX;
    private final ArrayList GY;
    private final int xM;
    
    static {
        CREATOR = new hw();
    }
    
    public hv() {
        this.xM = 1;
        this.GW = new HashMap();
        this.GX = new HashMap();
        this.GY = null;
    }
    
    hv(final int xm, final ArrayList list) {
        this.xM = xm;
        this.GW = new HashMap();
        this.GX = new HashMap();
        this.GY = null;
        this.a(list);
    }
    
    private void a(final ArrayList list) {
        for (final hv$a hv$a : list) {
            this.f(hv$a.GZ, hv$a.Ha);
        }
    }
    
    public String a(final Integer key) {
        String s = this.GX.get(key);
        if (s == null && this.GW.containsKey("gms_unknown")) {
            s = "gms_unknown";
        }
        return s;
    }
    
    public int describeContents() {
        final hw creator = hv.CREATOR;
        return 0;
    }
    
    public hv f(final String s, final int n) {
        this.GW.put(s, n);
        this.GX.put(n, s);
        return this;
    }
    
    ArrayList fD() {
        final ArrayList<hv$a> list = new ArrayList<hv$a>();
        for (final String key : this.GW.keySet()) {
            list.add(new hv$a(key, (int)this.GW.get(key)));
        }
        return list;
    }
    
    @Override
    public int fE() {
        return 7;
    }
    
    @Override
    public int fF() {
        return 0;
    }
    
    int getVersionCode() {
        return this.xM;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        final hw creator = hv.CREATOR;
        hw.a(this, parcel, n);
    }
}
