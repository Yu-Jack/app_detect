// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.Parcel;
import java.util.Iterator;
import java.util.HashSet;
import java.util.Set;
import java.util.HashMap;
import com.google.android.gms.plus.a.b.i;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class ih$g extends ga implements SafeParcelable, i
{
    public static final jq CREATOR;
    private static final HashMap<String, ga$a<?, ?>> a;
    private final Set<Integer> b;
    private final int c;
    private boolean d;
    private String e;
    
    static {
        CREATOR = new jq();
        (a = new HashMap<String, ga$a<?, ?>>()).put("primary", ga$a.c("primary", 2));
        ih$g.a.put("value", ga$a.d("value", 3));
    }
    
    public ih$g() {
        this.c = 1;
        this.b = new HashSet<Integer>();
    }
    
    ih$g(final Set<Integer> b, final int c, final boolean d, final String e) {
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
        return ih$g.a;
    }
    
    @Override
    protected boolean b(final String s) {
        return false;
    }
    
    public int describeContents() {
        final jq creator = ih$g.CREATOR;
        return 0;
    }
    
    Set<Integer> e() {
        return this.b;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (!(o instanceof ih$g)) {
            return false;
        }
        if (this == o) {
            return true;
        }
        final ih$g ih$g = (ih$g)o;
        for (final ga$a<?, ?> ga$a : com.google.android.gms.internal.ih$g.a.values()) {
            if (this.a(ga$a)) {
                if (!ih$g.a(ga$a)) {
                    return false;
                }
                if (!this.b(ga$a).equals(ih$g.b(ga$a))) {
                    return false;
                }
                continue;
            }
            else {
                if (ih$g.a(ga$a)) {
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
    
    public boolean g() {
        return this.d;
    }
    
    public String h() {
        return this.e;
    }
    
    @Override
    public int hashCode() {
        final Iterator<ga$a<?, ?>> iterator = ih$g.a.values().iterator();
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
    
    public ih$g i() {
        return this;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        final jq creator = ih$g.CREATOR;
        jq.a(this, parcel, n);
    }
}
