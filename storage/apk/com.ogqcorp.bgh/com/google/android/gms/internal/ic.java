// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.Parcel;
import java.util.Iterator;
import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.HashMap;
import com.google.android.gms.plus.a.a.a;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class ic extends ga implements SafeParcelable, a
{
    public static final jc CREATOR;
    private static final HashMap<String, ga$a<?, ?>> a;
    private String A;
    private String B;
    private String C;
    private String D;
    private ic E;
    private String F;
    private String G;
    private String H;
    private String I;
    private ic J;
    private double K;
    private ic L;
    private double M;
    private String N;
    private ic O;
    private List<ic> P;
    private String Q;
    private String R;
    private String S;
    private String T;
    private ic U;
    private String V;
    private String W;
    private String X;
    private ic Y;
    private String Z;
    private String aa;
    private String ab;
    private String ac;
    private String ad;
    private String ae;
    private final Set<Integer> b;
    private final int c;
    private ic d;
    private List<String> e;
    private ic f;
    private String g;
    private String h;
    private String i;
    private List<ic> j;
    private int k;
    private List<ic> l;
    private ic m;
    private List<ic> n;
    private String o;
    private String p;
    private ic q;
    private String r;
    private String s;
    private String t;
    private List<ic> u;
    private String v;
    private String w;
    private String x;
    private String y;
    private String z;
    
    static {
        CREATOR = new jc();
        (a = new HashMap<String, ga$a<?, ?>>()).put("about", ga$a.a("about", 2, (Class<?>)ic.class));
        ic.a.put("additionalName", ga$a.e("additionalName", 3));
        ic.a.put("address", ga$a.a("address", 4, (Class<?>)ic.class));
        ic.a.put("addressCountry", ga$a.d("addressCountry", 5));
        ic.a.put("addressLocality", ga$a.d("addressLocality", 6));
        ic.a.put("addressRegion", ga$a.d("addressRegion", 7));
        ic.a.put("associated_media", ga$a.b("associated_media", 8, ic.class));
        ic.a.put("attendeeCount", ga$a.a("attendeeCount", 9));
        ic.a.put("attendees", ga$a.b("attendees", 10, ic.class));
        ic.a.put("audio", ga$a.a("audio", 11, (Class<?>)ic.class));
        ic.a.put("author", ga$a.b("author", 12, ic.class));
        ic.a.put("bestRating", ga$a.d("bestRating", 13));
        ic.a.put("birthDate", ga$a.d("birthDate", 14));
        ic.a.put("byArtist", ga$a.a("byArtist", 15, (Class<?>)ic.class));
        ic.a.put("caption", ga$a.d("caption", 16));
        ic.a.put("contentSize", ga$a.d("contentSize", 17));
        ic.a.put("contentUrl", ga$a.d("contentUrl", 18));
        ic.a.put("contributor", ga$a.b("contributor", 19, ic.class));
        ic.a.put("dateCreated", ga$a.d("dateCreated", 20));
        ic.a.put("dateModified", ga$a.d("dateModified", 21));
        ic.a.put("datePublished", ga$a.d("datePublished", 22));
        ic.a.put("description", ga$a.d("description", 23));
        ic.a.put("duration", ga$a.d("duration", 24));
        ic.a.put("embedUrl", ga$a.d("embedUrl", 25));
        ic.a.put("endDate", ga$a.d("endDate", 26));
        ic.a.put("familyName", ga$a.d("familyName", 27));
        ic.a.put("gender", ga$a.d("gender", 28));
        ic.a.put("geo", ga$a.a("geo", 29, (Class<?>)ic.class));
        ic.a.put("givenName", ga$a.d("givenName", 30));
        ic.a.put("height", ga$a.d("height", 31));
        ic.a.put("id", ga$a.d("id", 32));
        ic.a.put("image", ga$a.d("image", 33));
        ic.a.put("inAlbum", ga$a.a("inAlbum", 34, (Class<?>)ic.class));
        ic.a.put("latitude", ga$a.b("latitude", 36));
        ic.a.put("location", ga$a.a("location", 37, (Class<?>)ic.class));
        ic.a.put("longitude", ga$a.b("longitude", 38));
        ic.a.put("name", ga$a.d("name", 39));
        ic.a.put("partOfTVSeries", ga$a.a("partOfTVSeries", 40, (Class<?>)ic.class));
        ic.a.put("performers", ga$a.b("performers", 41, ic.class));
        ic.a.put("playerType", ga$a.d("playerType", 42));
        ic.a.put("postOfficeBoxNumber", ga$a.d("postOfficeBoxNumber", 43));
        ic.a.put("postalCode", ga$a.d("postalCode", 44));
        ic.a.put("ratingValue", ga$a.d("ratingValue", 45));
        ic.a.put("reviewRating", ga$a.a("reviewRating", 46, (Class<?>)ic.class));
        ic.a.put("startDate", ga$a.d("startDate", 47));
        ic.a.put("streetAddress", ga$a.d("streetAddress", 48));
        ic.a.put("text", ga$a.d("text", 49));
        ic.a.put("thumbnail", ga$a.a("thumbnail", 50, (Class<?>)ic.class));
        ic.a.put("thumbnailUrl", ga$a.d("thumbnailUrl", 51));
        ic.a.put("tickerSymbol", ga$a.d("tickerSymbol", 52));
        ic.a.put("type", ga$a.d("type", 53));
        ic.a.put("url", ga$a.d("url", 54));
        ic.a.put("width", ga$a.d("width", 55));
        ic.a.put("worstRating", ga$a.d("worstRating", 56));
    }
    
    public ic() {
        this.c = 1;
        this.b = new HashSet<Integer>();
    }
    
    ic(final Set<Integer> b, final int c, final ic d, final List<String> e, final ic f, final String g, final String h, final String i, final List<ic> j, final int k, final List<ic> l, final ic m, final List<ic> n, final String o, final String p56, final ic q, final String r, final String s, final String t, final List<ic> u, final String v, final String w, final String x, final String y, final String z, final String a, final String b2, final String c2, final String d2, final ic e2, final String f2, final String g2, final String h2, final String i2, final ic j2, final double k2, final ic l2, final double m2, final String n2, final ic o2, final List<ic> p57, final String q2, final String r2, final String s2, final String t2, final ic u2, final String v2, final String w2, final String x2, final ic y2, final String z2, final String aa, final String ab, final String ac, final String ad, final String ae) {
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
        this.p = p56;
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
        this.B = b2;
        this.C = c2;
        this.D = d2;
        this.E = e2;
        this.F = f2;
        this.G = g2;
        this.H = h2;
        this.I = i2;
        this.J = j2;
        this.K = k2;
        this.L = l2;
        this.M = m2;
        this.N = n2;
        this.O = o2;
        this.P = p57;
        this.Q = q2;
        this.R = r2;
        this.S = s2;
        this.T = t2;
        this.U = u2;
        this.V = v2;
        this.W = w2;
        this.X = x2;
        this.Y = y2;
        this.Z = z2;
        this.aa = aa;
        this.ab = ab;
        this.ac = ac;
        this.ad = ad;
        this.ae = ae;
    }
    
    public String A() {
        return this.x;
    }
    
    public String B() {
        return this.y;
    }
    
    public String C() {
        return this.z;
    }
    
    public String D() {
        return this.A;
    }
    
    public String E() {
        return this.B;
    }
    
    public String F() {
        return this.C;
    }
    
    public String G() {
        return this.D;
    }
    
    ic H() {
        return this.E;
    }
    
    public String I() {
        return this.F;
    }
    
    public String J() {
        return this.G;
    }
    
    public String K() {
        return this.H;
    }
    
    public String L() {
        return this.I;
    }
    
    ic M() {
        return this.J;
    }
    
    public double N() {
        return this.K;
    }
    
    ic O() {
        return this.L;
    }
    
    public double P() {
        return this.M;
    }
    
    public String Q() {
        return this.N;
    }
    
    ic R() {
        return this.O;
    }
    
    List<ic> S() {
        return this.P;
    }
    
    public String T() {
        return this.Q;
    }
    
    public String U() {
        return this.R;
    }
    
    public String V() {
        return this.S;
    }
    
    public String W() {
        return this.T;
    }
    
    ic X() {
        return this.U;
    }
    
    public String Y() {
        return this.V;
    }
    
    public String Z() {
        return this.W;
    }
    
    @Override
    protected Object a(final String s) {
        return null;
    }
    
    @Override
    protected boolean a(final ga$a ga$a) {
        return this.b.contains(ga$a.g());
    }
    
    public String aa() {
        return this.X;
    }
    
    ic ab() {
        return this.Y;
    }
    
    public String ac() {
        return this.Z;
    }
    
    public String ad() {
        return this.aa;
    }
    
    public String ae() {
        return this.ab;
    }
    
    public String af() {
        return this.ac;
    }
    
    public String ag() {
        return this.ad;
    }
    
    public String ah() {
        return this.ae;
    }
    
    public ic ai() {
        return this;
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
            case 11: {
                return this.m;
            }
            case 12: {
                return this.n;
            }
            case 13: {
                return this.o;
            }
            case 14: {
                return this.p;
            }
            case 15: {
                return this.q;
            }
            case 16: {
                return this.r;
            }
            case 17: {
                return this.s;
            }
            case 18: {
                return this.t;
            }
            case 19: {
                return this.u;
            }
            case 20: {
                return this.v;
            }
            case 21: {
                return this.w;
            }
            case 22: {
                return this.x;
            }
            case 23: {
                return this.y;
            }
            case 24: {
                return this.z;
            }
            case 25: {
                return this.A;
            }
            case 26: {
                return this.B;
            }
            case 27: {
                return this.C;
            }
            case 28: {
                return this.D;
            }
            case 29: {
                return this.E;
            }
            case 30: {
                return this.F;
            }
            case 31: {
                return this.G;
            }
            case 32: {
                return this.H;
            }
            case 33: {
                return this.I;
            }
            case 34: {
                return this.J;
            }
            case 36: {
                return this.K;
            }
            case 37: {
                return this.L;
            }
            case 38: {
                return this.M;
            }
            case 39: {
                return this.N;
            }
            case 40: {
                return this.O;
            }
            case 41: {
                return this.P;
            }
            case 42: {
                return this.Q;
            }
            case 43: {
                return this.R;
            }
            case 44: {
                return this.S;
            }
            case 45: {
                return this.T;
            }
            case 46: {
                return this.U;
            }
            case 47: {
                return this.V;
            }
            case 48: {
                return this.W;
            }
            case 49: {
                return this.X;
            }
            case 50: {
                return this.Y;
            }
            case 51: {
                return this.Z;
            }
            case 52: {
                return this.aa;
            }
            case 53: {
                return this.ab;
            }
            case 54: {
                return this.ac;
            }
            case 55: {
                return this.ad;
            }
            case 56: {
                return this.ae;
            }
        }
    }
    
    @Override
    public HashMap<String, ga$a<?, ?>> b() {
        return ic.a;
    }
    
    @Override
    protected boolean b(final String s) {
        return false;
    }
    
    public int describeContents() {
        final jc creator = ic.CREATOR;
        return 0;
    }
    
    Set<Integer> e() {
        return this.b;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (!(o instanceof ic)) {
            return false;
        }
        if (this == o) {
            return true;
        }
        final ic ic = (ic)o;
        for (final ga$a<?, ?> ga$a : com.google.android.gms.internal.ic.a.values()) {
            if (this.a(ga$a)) {
                if (!ic.a(ga$a)) {
                    return false;
                }
                if (!this.b(ga$a).equals(ic.b(ga$a))) {
                    return false;
                }
                continue;
            }
            else {
                if (ic.a(ga$a)) {
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
    
    ic g() {
        return this.d;
    }
    
    public List<String> h() {
        return this.e;
    }
    
    @Override
    public int hashCode() {
        final Iterator<ga$a<?, ?>> iterator = ic.a.values().iterator();
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
    
    ic i() {
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
    
    List<ic> m() {
        return this.j;
    }
    
    public int n() {
        return this.k;
    }
    
    List<ic> o() {
        return this.l;
    }
    
    ic p() {
        return this.m;
    }
    
    List<ic> q() {
        return this.n;
    }
    
    public String r() {
        return this.o;
    }
    
    public String s() {
        return this.p;
    }
    
    ic t() {
        return this.q;
    }
    
    public String u() {
        return this.r;
    }
    
    public String v() {
        return this.s;
    }
    
    public String w() {
        return this.t;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        final jc creator = ic.CREATOR;
        jc.a(this, parcel, n);
    }
    
    List<ic> x() {
        return this.u;
    }
    
    public String y() {
        return this.v;
    }
    
    public String z() {
        return this.w;
    }
}
