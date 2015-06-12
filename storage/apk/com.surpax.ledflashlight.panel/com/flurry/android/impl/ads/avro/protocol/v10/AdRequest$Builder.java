// 
// Decompiled by Procyon v0.5.29
// 

package com.flurry.android.impl.ads.avro.protocol.v10;

import com.flurry.sdk.fk;
import java.util.List;
import java.util.Map;
import com.flurry.sdk.gx;

public class AdRequest$Builder extends gx
{
    private boolean A;
    private Map B;
    private CharSequence a;
    private CharSequence b;
    private CharSequence c;
    private long d;
    private List e;
    private Location f;
    private boolean g;
    private List h;
    private AdViewContainer i;
    private CharSequence j;
    private CharSequence k;
    private CharSequence l;
    private CharSequence m;
    private TestAds n;
    private Map o;
    private boolean p;
    private boolean q;
    private int r;
    private List s;
    private boolean t;
    private CharSequence u;
    private List v;
    private CharSequence w;
    private TargetingOverride x;
    private boolean y;
    private List z;
    
    private AdRequest$Builder() {
        super(AdRequest.SCHEMA$);
    }
    
    public AdRequest$Builder a(final int n) {
        this.a(this.b()[17], n);
        this.r = n;
        this.c()[17] = true;
        return this;
    }
    
    public AdRequest$Builder a(final long n) {
        this.a(this.b()[3], n);
        this.d = n;
        this.c()[3] = true;
        return this;
    }
    
    public AdRequest$Builder a(final AdViewContainer i) {
        this.a(this.b()[8], i);
        this.i = i;
        this.c()[8] = true;
        return this;
    }
    
    public AdRequest$Builder a(final Location f) {
        this.a(this.b()[5], f);
        this.f = f;
        this.c()[5] = true;
        return this;
    }
    
    public AdRequest$Builder a(final CharSequence a) {
        this.a(this.b()[0], a);
        this.a = a;
        this.c()[0] = true;
        return this;
    }
    
    public AdRequest$Builder a(final List e) {
        this.a(this.b()[4], e);
        this.e = e;
        this.c()[4] = true;
        return this;
    }
    
    public AdRequest$Builder a(final boolean b) {
        this.a(this.b()[6], b);
        this.g = b;
        this.c()[6] = true;
        return this;
    }
    
    public AdRequest a() {
        try {
            final AdRequest adRequest = new AdRequest();
            CharSequence a;
            if (this.c()[0]) {
                a = this.a;
            }
            else {
                a = (CharSequence)this.a(this.b()[0]);
            }
            adRequest.a = a;
            CharSequence b;
            if (this.c()[1]) {
                b = this.b;
            }
            else {
                b = (CharSequence)this.a(this.b()[1]);
            }
            adRequest.b = b;
            CharSequence c;
            if (this.c()[2]) {
                c = this.c;
            }
            else {
                c = (CharSequence)this.a(this.b()[2]);
            }
            adRequest.c = c;
            long d;
            if (this.c()[3]) {
                d = this.d;
            }
            else {
                d = (long)this.a(this.b()[3]);
            }
            adRequest.d = d;
            List e;
            if (this.c()[4]) {
                e = this.e;
            }
            else {
                e = (List)this.a(this.b()[4]);
            }
            adRequest.e = e;
            Location f;
            if (this.c()[5]) {
                f = this.f;
            }
            else {
                f = (Location)this.a(this.b()[5]);
            }
            adRequest.f = f;
            boolean g;
            if (this.c()[6]) {
                g = this.g;
            }
            else {
                g = (boolean)this.a(this.b()[6]);
            }
            adRequest.g = g;
            List h;
            if (this.c()[7]) {
                h = this.h;
            }
            else {
                h = (List)this.a(this.b()[7]);
            }
            adRequest.h = h;
            AdViewContainer i;
            if (this.c()[8]) {
                i = this.i;
            }
            else {
                i = (AdViewContainer)this.a(this.b()[8]);
            }
            adRequest.i = i;
            CharSequence j;
            if (this.c()[9]) {
                j = this.j;
            }
            else {
                j = (CharSequence)this.a(this.b()[9]);
            }
            adRequest.j = j;
            CharSequence k;
            if (this.c()[10]) {
                k = this.k;
            }
            else {
                k = (CharSequence)this.a(this.b()[10]);
            }
            adRequest.k = k;
            CharSequence l;
            if (this.c()[11]) {
                l = this.l;
            }
            else {
                l = (CharSequence)this.a(this.b()[11]);
            }
            adRequest.l = l;
            CharSequence m;
            if (this.c()[12]) {
                m = this.m;
            }
            else {
                m = (CharSequence)this.a(this.b()[12]);
            }
            adRequest.m = m;
            TestAds n;
            if (this.c()[13]) {
                n = this.n;
            }
            else {
                n = (TestAds)this.a(this.b()[13]);
            }
            adRequest.n = n;
            Map o;
            if (this.c()[14]) {
                o = this.o;
            }
            else {
                o = (Map)this.a(this.b()[14]);
            }
            adRequest.o = o;
            boolean p;
            if (this.c()[15]) {
                p = this.p;
            }
            else {
                p = (boolean)this.a(this.b()[15]);
            }
            adRequest.p = p;
            boolean q;
            if (this.c()[16]) {
                q = this.q;
            }
            else {
                q = (boolean)this.a(this.b()[16]);
            }
            adRequest.q = q;
            int r;
            if (this.c()[17]) {
                r = this.r;
            }
            else {
                r = (int)this.a(this.b()[17]);
            }
            adRequest.r = r;
            List s;
            if (this.c()[18]) {
                s = this.s;
            }
            else {
                s = (List)this.a(this.b()[18]);
            }
            adRequest.s = s;
            boolean t;
            if (this.c()[19]) {
                t = this.t;
            }
            else {
                t = (boolean)this.a(this.b()[19]);
            }
            adRequest.t = t;
            CharSequence u;
            if (this.c()[20]) {
                u = this.u;
            }
            else {
                u = (CharSequence)this.a(this.b()[20]);
            }
            adRequest.u = u;
            List v;
            if (this.c()[21]) {
                v = this.v;
            }
            else {
                v = (List)this.a(this.b()[21]);
            }
            adRequest.v = v;
            CharSequence w;
            if (this.c()[22]) {
                w = this.w;
            }
            else {
                w = (CharSequence)this.a(this.b()[22]);
            }
            adRequest.w = w;
            TargetingOverride x;
            if (this.c()[23]) {
                x = this.x;
            }
            else {
                x = (TargetingOverride)this.a(this.b()[23]);
            }
            adRequest.x = x;
            boolean y;
            if (this.c()[24]) {
                y = this.y;
            }
            else {
                y = (boolean)this.a(this.b()[24]);
            }
            adRequest.y = y;
            List z;
            if (this.c()[25]) {
                z = this.z;
            }
            else {
                z = (List)this.a(this.b()[25]);
            }
            adRequest.z = z;
            boolean a2;
            if (this.c()[26]) {
                a2 = this.A;
            }
            else {
                a2 = (boolean)this.a(this.b()[26]);
            }
            adRequest.A = a2;
            Map b2;
            if (this.c()[27]) {
                b2 = this.B;
            }
            else {
                b2 = (Map)this.a(this.b()[27]);
            }
            adRequest.B = b2;
            return adRequest;
        }
        catch (Exception ex) {
            throw new fk(ex);
        }
    }
    
    public AdRequest$Builder b(final CharSequence b) {
        this.a(this.b()[1], b);
        this.b = b;
        this.c()[1] = true;
        return this;
    }
    
    public AdRequest$Builder b(final List h) {
        this.a(this.b()[7], h);
        this.h = h;
        this.c()[7] = true;
        return this;
    }
    
    public AdRequest$Builder b(final boolean b) {
        this.a(this.b()[16], b);
        this.q = b;
        this.c()[16] = true;
        return this;
    }
    
    public AdRequest$Builder c(final CharSequence c) {
        this.a(this.b()[2], c);
        this.c = c;
        this.c()[2] = true;
        return this;
    }
    
    public AdRequest$Builder c(final List s) {
        this.a(this.b()[18], s);
        this.s = s;
        this.c()[18] = true;
        return this;
    }
    
    public AdRequest$Builder c(final boolean b) {
        this.a(this.b()[19], b);
        this.t = b;
        this.c()[19] = true;
        return this;
    }
    
    public AdRequest$Builder d(final CharSequence j) {
        this.a(this.b()[9], j);
        this.j = j;
        this.c()[9] = true;
        return this;
    }
    
    public AdRequest$Builder d(final List v) {
        this.a(this.b()[21], v);
        this.v = v;
        this.c()[21] = true;
        return this;
    }
    
    public AdRequest$Builder d(final boolean b) {
        this.a(this.b()[24], b);
        this.y = b;
        this.c()[24] = true;
        return this;
    }
    
    public AdRequest$Builder e(final CharSequence k) {
        this.a(this.b()[10], k);
        this.k = k;
        this.c()[10] = true;
        return this;
    }
    
    public AdRequest$Builder e(final List z) {
        this.a(this.b()[25], z);
        this.z = z;
        this.c()[25] = true;
        return this;
    }
    
    public AdRequest$Builder e(final boolean b) {
        this.a(this.b()[26], b);
        this.A = b;
        this.c()[26] = true;
        return this;
    }
    
    public AdRequest$Builder f(final CharSequence l) {
        this.a(this.b()[11], l);
        this.l = l;
        this.c()[11] = true;
        return this;
    }
    
    public AdRequest$Builder g(final CharSequence m) {
        this.a(this.b()[12], m);
        this.m = m;
        this.c()[12] = true;
        return this;
    }
    
    public AdRequest$Builder h(final CharSequence u) {
        this.a(this.b()[20], u);
        this.u = u;
        this.c()[20] = true;
        return this;
    }
    
    public AdRequest$Builder i(final CharSequence w) {
        this.a(this.b()[22], w);
        this.w = w;
        this.c()[22] = true;
        return this;
    }
}
