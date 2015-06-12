// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.Parcel;
import java.util.Iterator;
import java.util.HashSet;
import java.util.Set;
import java.util.HashMap;
import com.google.android.gms.plus.a.b.c;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class ih$b extends ga implements SafeParcelable, c
{
    public static final jg CREATOR;
    private static final HashMap<String, ga$a<?, ?>> a;
    private final Set<Integer> b;
    private final int c;
    private ih$b$a d;
    private ih$b$b e;
    private int f;
    
    static {
        CREATOR = new jg();
        (a = new HashMap<String, ga$a<?, ?>>()).put("coverInfo", ga$a.a("coverInfo", 2, (Class<?>)ih$b$a.class));
        ih$b.a.put("coverPhoto", ga$a.a("coverPhoto", 3, (Class<?>)ih$b$b.class));
        ih$b.a.put("layout", ga$a.a("layout", 4, new fx().a("banner", 0), false));
    }
    
    public ih$b() {
        this.c = 1;
        this.b = new HashSet<Integer>();
    }
    
    ih$b(final Set<Integer> b, final int c, final ih$b$a d, final ih$b$b e, final int f) {
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
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
        }
    }
    
    @Override
    public HashMap<String, ga$a<?, ?>> b() {
        return ih$b.a;
    }
    
    @Override
    protected boolean b(final String s) {
        return false;
    }
    
    public int describeContents() {
        final jg creator = ih$b.CREATOR;
        return 0;
    }
    
    Set<Integer> e() {
        return this.b;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (!(o instanceof ih$b)) {
            return false;
        }
        if (this == o) {
            return true;
        }
        final ih$b ih$b = (ih$b)o;
        for (final ga$a<?, ?> ga$a : com.google.android.gms.internal.ih$b.a.values()) {
            if (this.a(ga$a)) {
                if (!ih$b.a(ga$a)) {
                    return false;
                }
                if (!this.b(ga$a).equals(ih$b.b(ga$a))) {
                    return false;
                }
                continue;
            }
            else {
                if (ih$b.a(ga$a)) {
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
    
    ih$b$a g() {
        return this.d;
    }
    
    ih$b$b h() {
        return this.e;
    }
    
    @Override
    public int hashCode() {
        final Iterator<ga$a<?, ?>> iterator = ih$b.a.values().iterator();
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
    
    public ih$b j() {
        return this;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        final jg creator = ih$b.CREATOR;
        jg.a(this, parcel, n);
    }
}
