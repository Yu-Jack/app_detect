// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.Parcel;
import java.util.Iterator;
import java.util.HashSet;
import java.util.Set;
import java.util.HashMap;
import com.google.android.gms.plus.a.b.j;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class ih$h extends ga implements SafeParcelable, j
{
    public static final jr CREATOR;
    private static final HashMap<String, ga$a<?, ?>> a;
    private final Set<Integer> b;
    private final int c;
    private String d;
    private final int e;
    private int f;
    private String g;
    
    static {
        CREATOR = new jr();
        (a = new HashMap<String, ga$a<?, ?>>()).put("label", ga$a.d("label", 5));
        ih$h.a.put("type", ga$a.a("type", 6, new fx().a("home", 0).a("work", 1).a("blog", 2).a("profile", 3).a("other", 4).a("otherProfile", 5).a("contributor", 6).a("website", 7), false));
        ih$h.a.put("value", ga$a.d("value", 4));
    }
    
    public ih$h() {
        this.e = 4;
        this.c = 2;
        this.b = new HashSet<Integer>();
    }
    
    ih$h(final Set<Integer> b, final int c, final String d, final int f, final String g, final int n) {
        this.e = 4;
        this.b = b;
        this.c = c;
        this.d = d;
        this.f = f;
        this.g = g;
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
            case 5: {
                return this.d;
            }
            case 6: {
                return this.f;
            }
            case 4: {
                return this.g;
            }
        }
    }
    
    @Override
    public HashMap<String, ga$a<?, ?>> b() {
        return ih$h.a;
    }
    
    @Override
    protected boolean b(final String s) {
        return false;
    }
    
    public int describeContents() {
        final jr creator = ih$h.CREATOR;
        return 0;
    }
    
    Set<Integer> e() {
        return this.b;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (!(o instanceof ih$h)) {
            return false;
        }
        if (this == o) {
            return true;
        }
        final ih$h ih$h = (ih$h)o;
        for (final ga$a<?, ?> ga$a : com.google.android.gms.internal.ih$h.a.values()) {
            if (this.a(ga$a)) {
                if (!ih$h.a(ga$a)) {
                    return false;
                }
                if (!this.b(ga$a).equals(ih$h.b(ga$a))) {
                    return false;
                }
                continue;
            }
            else {
                if (ih$h.a(ga$a)) {
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
    
    @Deprecated
    public int h() {
        return 4;
    }
    
    @Override
    public int hashCode() {
        final Iterator<ga$a<?, ?>> iterator = ih$h.a.values().iterator();
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
    
    public int i() {
        return this.f;
    }
    
    public String j() {
        return this.g;
    }
    
    public ih$h k() {
        return this;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        final jr creator = ih$h.CREATOR;
        jr.a(this, parcel, n);
    }
}
