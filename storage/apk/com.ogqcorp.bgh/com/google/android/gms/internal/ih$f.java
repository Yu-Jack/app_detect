// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.Parcel;
import java.util.Iterator;
import java.util.HashSet;
import java.util.Set;
import java.util.HashMap;
import com.google.android.gms.plus.a.b.h;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class ih$f extends ga implements SafeParcelable, h
{
    public static final jn CREATOR;
    private static final HashMap<String, ga$a<?, ?>> a;
    private final Set<Integer> b;
    private final int c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private boolean i;
    private String j;
    private String k;
    private int l;
    
    static {
        CREATOR = new jn();
        (a = new HashMap<String, ga$a<?, ?>>()).put("department", ga$a.d("department", 2));
        ih$f.a.put("description", ga$a.d("description", 3));
        ih$f.a.put("endDate", ga$a.d("endDate", 4));
        ih$f.a.put("location", ga$a.d("location", 5));
        ih$f.a.put("name", ga$a.d("name", 6));
        ih$f.a.put("primary", ga$a.c("primary", 7));
        ih$f.a.put("startDate", ga$a.d("startDate", 8));
        ih$f.a.put("title", ga$a.d("title", 9));
        ih$f.a.put("type", ga$a.a("type", 10, new fx().a("work", 0).a("school", 1), false));
    }
    
    public ih$f() {
        this.c = 1;
        this.b = new HashSet<Integer>();
    }
    
    ih$f(final Set<Integer> b, final int c, final String d, final String e, final String f, final String g, final String h, final boolean i, final String j, final String k, final int l) {
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        this.g = g;
        this.h = h;
        this.i = i;
        this.j = j;
        this.k = k;
        this.l = l;
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
            case 8: {
                return this.j;
            }
            case 9: {
                return this.k;
            }
            case 10: {
                return this.l;
            }
        }
    }
    
    @Override
    public HashMap<String, ga$a<?, ?>> b() {
        return ih$f.a;
    }
    
    @Override
    protected boolean b(final String s) {
        return false;
    }
    
    public int describeContents() {
        final jn creator = ih$f.CREATOR;
        return 0;
    }
    
    Set<Integer> e() {
        return this.b;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (!(o instanceof ih$f)) {
            return false;
        }
        if (this == o) {
            return true;
        }
        final ih$f ih$f = (ih$f)o;
        for (final ga$a<?, ?> ga$a : com.google.android.gms.internal.ih$f.a.values()) {
            if (this.a(ga$a)) {
                if (!ih$f.a(ga$a)) {
                    return false;
                }
                if (!this.b(ga$a).equals(ih$f.b(ga$a))) {
                    return false;
                }
                continue;
            }
            else {
                if (ih$f.a(ga$a)) {
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
        final Iterator<ga$a<?, ?>> iterator = ih$f.a.values().iterator();
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
    
    public boolean l() {
        return this.i;
    }
    
    public String m() {
        return this.j;
    }
    
    public String n() {
        return this.k;
    }
    
    public int o() {
        return this.l;
    }
    
    public ih$f p() {
        return this;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        final jn creator = ih$f.CREATOR;
        jn.a(this, parcel, n);
    }
}
