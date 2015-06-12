// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.Parcel;
import java.util.Iterator;
import java.util.HashSet;
import java.util.Set;
import java.util.HashMap;
import com.google.android.gms.plus.a.a.b;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class ie extends ga implements SafeParcelable, b
{
    public static final jd CREATOR;
    private static final HashMap<String, ga$a<?, ?>> a;
    private final Set<Integer> b;
    private final int c;
    private String d;
    private ic e;
    private String f;
    private ic g;
    private String h;
    
    static {
        CREATOR = new jd();
        (a = new HashMap<String, ga$a<?, ?>>()).put("id", ga$a.d("id", 2));
        ie.a.put("result", ga$a.a("result", 4, (Class<?>)ic.class));
        ie.a.put("startDate", ga$a.d("startDate", 5));
        ie.a.put("target", ga$a.a("target", 6, (Class<?>)ic.class));
        ie.a.put("type", ga$a.d("type", 7));
    }
    
    public ie() {
        this.c = 1;
        this.b = new HashSet<Integer>();
    }
    
    ie(final Set<Integer> b, final int c, final String d, final ic e, final String f, final ic g, final String h) {
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        this.g = g;
        this.h = h;
    }
    
    @Override
    protected Object a(final String s) {
        return null;
    }
    
    @Override
    protected boolean a(final ga$a ga$a) {
        return this.b.contains(ga$a.g());
    }
    
    @Override
    protected Object b(final ga$a ga$a) {
        switch (ga$a.g()) {
            default: {
                throw new IllegalStateException("Unknown safe parcelable id=" + ga$a.g());
            }
            case 2: {
                return this.d;
            }
            case 4: {
                return this.e;
            }
            case 5: {
                return this.f;
            }
            case 6: {
                return this.g;
            }
            case 7: {
                return this.h;
            }
        }
    }
    
    @Override
    public HashMap<String, ga$a<?, ?>> b() {
        return ie.a;
    }
    
    @Override
    protected boolean b(final String s) {
        return false;
    }
    
    public int describeContents() {
        final jd creator = ie.CREATOR;
        return 0;
    }
    
    Set<Integer> e() {
        return this.b;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (!(o instanceof ie)) {
            return false;
        }
        if (this == o) {
            return true;
        }
        final ie ie = (ie)o;
        for (final ga$a<?, ?> ga$a : com.google.android.gms.internal.ie.a.values()) {
            if (this.a(ga$a)) {
                if (!ie.a(ga$a)) {
                    return false;
                }
                if (!this.b(ga$a).equals(ie.b(ga$a))) {
                    return false;
                }
                continue;
            }
            else {
                if (ie.a(ga$a)) {
                    return false;
                }
                continue;
            }
        }
        return true;
    }
    
    int f() {
        return this.c;
    }
    
    public String g() {
        return this.d;
    }
    
    ic h() {
        return this.e;
    }
    
    @Override
    public int hashCode() {
        final Iterator<ga$a<?, ?>> iterator = ie.a.values().iterator();
        int n = 0;
        while (iterator.hasNext()) {
            final ga$a<?, ?> ga$a = iterator.next();
            int n2;
            if (this.a(ga$a)) {
                n2 = n + ga$a.g() + this.b(ga$a).hashCode();
            }
            else {
                n2 = n;
            }
            n = n2;
        }
        return n;
    }
    
    public String i() {
        return this.f;
    }
    
    ic j() {
        return this.g;
    }
    
    public String k() {
        return this.h;
    }
    
    public ie l() {
        return this;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        final jd creator = ie.CREATOR;
        jd.a(this, parcel, n);
    }
}
