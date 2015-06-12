// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.Parcel;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.HashMap;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class fx implements SafeParcelable, hh<String, Integer>
{
    public static final hc CREATOR;
    private final int a;
    private final HashMap<String, Integer> b;
    private final HashMap<Integer, String> c;
    private final ArrayList<fx$a> d;
    
    static {
        CREATOR = new hc();
    }
    
    public fx() {
        this.a = 1;
        this.b = new HashMap<String, Integer>();
        this.c = new HashMap<Integer, String>();
        this.d = null;
    }
    
    fx(final int a, final ArrayList<fx$a> list) {
        this.a = a;
        this.b = new HashMap<String, Integer>();
        this.c = new HashMap<Integer, String>();
        this.d = null;
        this.a(list);
    }
    
    private void a(final ArrayList<fx$a> list) {
        for (final fx$a fx$a : list) {
            this.a(fx$a.b, fx$a.c);
        }
    }
    
    int a() {
        return this.a;
    }
    
    public fx a(final String s, final int n) {
        this.b.put(s, n);
        this.c.put(n, s);
        return this;
    }
    
    @Override
    public String a(final Integer key) {
        String s = this.c.get(key);
        if (s == null && this.b.containsKey("gms_unknown")) {
            s = "gms_unknown";
        }
        return s;
    }
    
    ArrayList<fx$a> b() {
        final ArrayList<fx$a> list = new ArrayList<fx$a>();
        for (final String key : this.b.keySet()) {
            list.add(new fx$a(key, this.b.get(key)));
        }
        return list;
    }
    
    @Override
    public int c() {
        return 7;
    }
    
    @Override
    public int d() {
        return 0;
    }
    
    public int describeContents() {
        final hc creator = fx.CREATOR;
        return 0;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        final hc creator = fx.CREATOR;
        hc.a(this, parcel, n);
    }
}
