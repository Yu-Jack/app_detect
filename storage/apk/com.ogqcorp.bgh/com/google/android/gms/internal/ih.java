// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.Parcel;
import java.util.Iterator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.HashMap;
import com.google.android.gms.plus.a.b.a;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class ih extends ga implements SafeParcelable, a
{
    public static final je CREATOR;
    private static final HashMap<String, ga$a<?, ?>> a;
    private boolean A;
    private final Set<Integer> b;
    private final int c;
    private String d;
    private ih$a e;
    private String f;
    private String g;
    private int h;
    private ih$b i;
    private String j;
    private String k;
    private int l;
    private String m;
    private ih$c n;
    private boolean o;
    private String p;
    private ih$d q;
    private String r;
    private int s;
    private List<ih$f> t;
    private List<ih$g> u;
    private int v;
    private int w;
    private String x;
    private String y;
    private List<ih$h> z;
    
    static {
        CREATOR = new je();
        (a = new HashMap<String, ga$a<?, ?>>()).put("aboutMe", ga$a.d("aboutMe", 2));
        ih.a.put("ageRange", ga$a.a("ageRange", 3, (Class<?>)ih$a.class));
        ih.a.put("birthday", ga$a.d("birthday", 4));
        ih.a.put("braggingRights", ga$a.d("braggingRights", 5));
        ih.a.put("circledByCount", ga$a.a("circledByCount", 6));
        ih.a.put("cover", ga$a.a("cover", 7, (Class<?>)ih$b.class));
        ih.a.put("currentLocation", ga$a.d("currentLocation", 8));
        ih.a.put("displayName", ga$a.d("displayName", 9));
        ih.a.put("gender", ga$a.a("gender", 12, new fx().a("male", 0).a("female", 1).a("other", 2), false));
        ih.a.put("id", ga$a.d("id", 14));
        ih.a.put("image", ga$a.a("image", 15, (Class<?>)ih$c.class));
        ih.a.put("isPlusUser", ga$a.c("isPlusUser", 16));
        ih.a.put("language", ga$a.d("language", 18));
        ih.a.put("name", ga$a.a("name", 19, (Class<?>)ih$d.class));
        ih.a.put("nickname", ga$a.d("nickname", 20));
        ih.a.put("objectType", ga$a.a("objectType", 21, new fx().a("person", 0).a("page", 1), false));
        ih.a.put("organizations", ga$a.b("organizations", 22, ih$f.class));
        ih.a.put("placesLived", ga$a.b("placesLived", 23, ih$g.class));
        ih.a.put("plusOneCount", ga$a.a("plusOneCount", 24));
        ih.a.put("relationshipStatus", ga$a.a("relationshipStatus", 25, new fx().a("single", 0).a("in_a_relationship", 1).a("engaged", 2).a("married", 3).a("its_complicated", 4).a("open_relationship", 5).a("widowed", 6).a("in_domestic_partnership", 7).a("in_civil_union", 8), false));
        ih.a.put("tagline", ga$a.d("tagline", 26));
        ih.a.put("url", ga$a.d("url", 27));
        ih.a.put("urls", ga$a.b("urls", 28, ih$h.class));
        ih.a.put("verified", ga$a.c("verified", 29));
    }
    
    public ih() {
        this.c = 2;
        this.b = new HashSet<Integer>();
    }
    
    ih(final Set<Integer> b, final int c, final String d, final ih$a e, final String f, final String g, final int h, final ih$b i, final String j, final String k, final int l, final String m, final ih$c n, final boolean o, final String p26, final ih$d q, final String r, final int s, final List<ih$f> t, final List<ih$g> u, final int v, final int w, final String x, final String y, final List<ih$h> z, final boolean a) {
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
        this.m = m;
        this.n = n;
        this.o = o;
        this.p = p26;
        this.q = q;
        this.r = r;
        this.s = s;
        this.t = t;
        this.u = u;
        this.v = v;
        this.w = w;
        this.x = x;
        this.y = y;
        this.z = z;
        this.A = a;
    }
    
    public String A() {
        return this.x;
    }
    
    public String B() {
        return this.y;
    }
    
    List<ih$h> C() {
        return this.z;
    }
    
    public boolean D() {
        return this.A;
    }
    
    public ih E() {
        return this;
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
            case 12: {
                return this.l;
            }
            case 14: {
                return this.m;
            }
            case 15: {
                return this.n;
            }
            case 16: {
                return this.o;
            }
            case 18: {
                return this.p;
            }
            case 19: {
                return this.q;
            }
            case 20: {
                return this.r;
            }
            case 21: {
                return this.s;
            }
            case 22: {
                return this.t;
            }
            case 23: {
                return this.u;
            }
            case 24: {
                return this.v;
            }
            case 25: {
                return this.w;
            }
            case 26: {
                return this.x;
            }
            case 27: {
                return this.y;
            }
            case 28: {
                return this.z;
            }
            case 29: {
                return this.A;
            }
        }
    }
    
    @Override
    public HashMap<String, ga$a<?, ?>> b() {
        return ih.a;
    }
    
    @Override
    protected boolean b(final String s) {
        return false;
    }
    
    public int describeContents() {
        final je creator = ih.CREATOR;
        return 0;
    }
    
    Set<Integer> e() {
        return this.b;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (!(o instanceof ih)) {
            return false;
        }
        if (this == o) {
            return true;
        }
        final ih ih = (ih)o;
        for (final ga$a<?, ?> ga$a : com.google.android.gms.internal.ih.a.values()) {
            if (this.a(ga$a)) {
                if (!ih.a(ga$a)) {
                    return false;
                }
                if (!this.b(ga$a).equals(ih.b(ga$a))) {
                    return false;
                }
                continue;
            }
            else {
                if (ih.a(ga$a)) {
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
    
    ih$a h() {
        return this.e;
    }
    
    @Override
    public int hashCode() {
        final Iterator<ga$a<?, ?>> iterator = ih.a.values().iterator();
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
    
    public int k() {
        return this.h;
    }
    
    ih$b l() {
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
    
    public String p() {
        return this.m;
    }
    
    ih$c q() {
        return this.n;
    }
    
    public boolean r() {
        return this.o;
    }
    
    public String s() {
        return this.p;
    }
    
    ih$d t() {
        return this.q;
    }
    
    public String u() {
        return this.r;
    }
    
    public int v() {
        return this.s;
    }
    
    List<ih$f> w() {
        return this.t;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        final je creator = ih.CREATOR;
        je.a(this, parcel, n);
    }
    
    List<ih$g> x() {
        return this.u;
    }
    
    public int y() {
        return this.v;
    }
    
    public int z() {
        return this.w;
    }
}
