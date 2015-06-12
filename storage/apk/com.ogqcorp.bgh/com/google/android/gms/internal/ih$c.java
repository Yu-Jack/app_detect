// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.Parcel;
import java.util.Iterator;
import java.util.HashSet;
import java.util.Set;
import java.util.HashMap;
import com.google.android.gms.plus.a.b.f;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class ih$c extends ga implements SafeParcelable, f
{
    public static final jj CREATOR;
    private static final HashMap<String, ga$a<?, ?>> a;
    private final Set<Integer> b;
    private final int c;
    private String d;
    
    static {
        CREATOR = new jj();
        (a = new HashMap<String, ga$a<?, ?>>()).put("url", ga$a.d("url", 2));
    }
    
    public ih$c() {
        this.c = 1;
        this.b = new HashSet<Integer>();
    }
    
    ih$c(final Set<Integer> b, final int c, final String d) {
        this.b = b;
        this.c = c;
        this.d = d;
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
        }
    }
    
    @Override
    public HashMap<String, ga$a<?, ?>> b() {
        return ih$c.a;
    }
    
    @Override
    protected boolean b(final String s) {
        return false;
    }
    
    public int describeContents() {
        final jj creator = ih$c.CREATOR;
        return 0;
    }
    
    Set<Integer> e() {
        return this.b;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (!(o instanceof ih$c)) {
            return false;
        }
        if (this == o) {
            return true;
        }
        final ih$c ih$c = (ih$c)o;
        for (final ga$a<?, ?> ga$a : com.google.android.gms.internal.ih$c.a.values()) {
            if (this.a(ga$a)) {
                if (!ih$c.a(ga$a)) {
                    return false;
                }
                if (!this.b(ga$a).equals(ih$c.b(ga$a))) {
                    return false;
                }
                continue;
            }
            else {
                if (ih$c.a(ga$a)) {
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
    
    public ih$c h() {
        return this;
    }
    
    @Override
    public int hashCode() {
        final Iterator<ga$a<?, ?>> iterator = ih$c.a.values().iterator();
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
    
    public void writeToParcel(final Parcel parcel, final int n) {
        final jj creator = ih$c.CREATOR;
        jj.a(this, parcel, n);
    }
}
