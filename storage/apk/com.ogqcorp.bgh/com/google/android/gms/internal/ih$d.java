// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.Parcel;
import java.util.Iterator;
import java.util.HashSet;
import java.util.Set;
import java.util.HashMap;
import com.google.android.gms.plus.a.b.g;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class ih$d extends ga implements SafeParcelable, g
{
    public static final jl CREATOR;
    private static final HashMap<String, ga$a<?, ?>> a;
    private final Set<Integer> b;
    private final int c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    
    static {
        CREATOR = new jl();
        (a = new HashMap<String, ga$a<?, ?>>()).put("familyName", ga$a.d("familyName", 2));
        ih$d.a.put("formatted", ga$a.d("formatted", 3));
        ih$d.a.put("givenName", ga$a.d("givenName", 4));
        ih$d.a.put("honorificPrefix", ga$a.d("honorificPrefix", 5));
        ih$d.a.put("honorificSuffix", ga$a.d("honorificSuffix", 6));
        ih$d.a.put("middleName", ga$a.d("middleName", 7));
    }
    
    public ih$d() {
        this.c = 1;
        this.b = new HashSet<Integer>();
    }
    
    ih$d(final Set<Integer> b, final int c, final String d, final String e, final String f, final String g, final String h, final String i) {
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        this.g = g;
        this.h = h;
        this.i = i;
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
            case 3: {
                return this.e;
            }
            case 4: {
                return this.f;
            }
            case 5: {
                return this.g;
            }
            case 6: {
                return this.h;
            }
            case 7: {
                return this.i;
            }
        }
    }
    
    @Override
    public HashMap<String, ga$a<?, ?>> b() {
        return ih$d.a;
    }
    
    @Override
    protected boolean b(final String s) {
        return false;
    }
    
    public int describeContents() {
        final jl creator = ih$d.CREATOR;
        return 0;
    }
    
    Set<Integer> e() {
        return this.b;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (!(o instanceof ih$d)) {
            return false;
        }
        if (this == o) {
            return true;
        }
        final ih$d ih$d = (ih$d)o;
        for (final ga$a<?, ?> ga$a : com.google.android.gms.internal.ih$d.a.values()) {
            if (this.a(ga$a)) {
                if (!ih$d.a(ga$a)) {
                    return false;
                }
                if (!this.b(ga$a).equals(ih$d.b(ga$a))) {
                    return false;
                }
                continue;
            }
            else {
                if (ih$d.a(ga$a)) {
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
    
    public String h() {
        return this.e;
    }
    
    @Override
    public int hashCode() {
        final Iterator<ga$a<?, ?>> iterator = ih$d.a.values().iterator();
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
    
    public String j() {
        return this.g;
    }
    
    public String k() {
        return this.h;
    }
    
    public String l() {
        return this.i;
    }
    
    public ih$d m() {
        return this;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        final jl creator = ih$d.CREATOR;
        jl.a(this, parcel, n);
    }
}
