// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.Parcel;
import java.util.Iterator;
import java.util.HashSet;
import java.util.Set;
import java.util.HashMap;
import com.google.android.gms.plus.a.b.d;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class ih$b$a extends ga implements SafeParcelable, d
{
    public static final jh CREATOR;
    private static final HashMap<String, ga$a<?, ?>> a;
    private final Set<Integer> b;
    private final int c;
    private int d;
    private int e;
    
    static {
        CREATOR = new jh();
        (a = new HashMap<String, ga$a<?, ?>>()).put("leftImageOffset", ga$a.a("leftImageOffset", 2));
        ih$b$a.a.put("topImageOffset", ga$a.a("topImageOffset", 3));
    }
    
    public ih$b$a() {
        this.c = 1;
        this.b = new HashSet<Integer>();
    }
    
    ih$b$a(final Set<Integer> b, final int c, final int d, final int e) {
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
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
        }
    }
    
    @Override
    public HashMap<String, ga$a<?, ?>> b() {
        return ih$b$a.a;
    }
    
    @Override
    protected boolean b(final String s) {
        return false;
    }
    
    public int describeContents() {
        final jh creator = ih$b$a.CREATOR;
        return 0;
    }
    
    Set<Integer> e() {
        return this.b;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (!(o instanceof ih$b$a)) {
            return false;
        }
        if (this == o) {
            return true;
        }
        final ih$b$a ih$b$a = (ih$b$a)o;
        for (final ga$a<?, ?> ga$a : com.google.android.gms.internal.ih$b$a.a.values()) {
            if (this.a(ga$a)) {
                if (!ih$b$a.a(ga$a)) {
                    return false;
                }
                if (!this.b(ga$a).equals(ih$b$a.b(ga$a))) {
                    return false;
                }
                continue;
            }
            else {
                if (ih$b$a.a(ga$a)) {
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
    
    public int g() {
        return this.d;
    }
    
    public int h() {
        return this.e;
    }
    
    @Override
    public int hashCode() {
        final Iterator<ga$a<?, ?>> iterator = ih$b$a.a.values().iterator();
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
    
    public ih$b$a i() {
        return this;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        final jh creator = ih$b$a.CREATOR;
        jh.a(this, parcel, n);
    }
}
