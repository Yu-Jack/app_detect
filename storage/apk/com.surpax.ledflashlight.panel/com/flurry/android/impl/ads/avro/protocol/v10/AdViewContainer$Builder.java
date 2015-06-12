// 
// Decompiled by Procyon v0.5.29
// 

package com.flurry.android.impl.ads.avro.protocol.v10;

import com.flurry.sdk.fk;
import com.flurry.sdk.gx;

public class AdViewContainer$Builder extends gx
{
    private int a;
    private int b;
    private int c;
    private int d;
    private float e;
    private ScreenOrientationType f;
    
    private AdViewContainer$Builder() {
        super(AdViewContainer.SCHEMA$);
    }
    
    public AdViewContainer$Builder a(final float n) {
        this.a(this.b()[4], n);
        this.e = n;
        this.c()[4] = true;
        return this;
    }
    
    public AdViewContainer$Builder a(final int n) {
        this.a(this.b()[0], n);
        this.a = n;
        this.c()[0] = true;
        return this;
    }
    
    public AdViewContainer$Builder a(final ScreenOrientationType f) {
        this.a(this.b()[5], f);
        this.f = f;
        this.c()[5] = true;
        return this;
    }
    
    public AdViewContainer a() {
        try {
            final AdViewContainer adViewContainer = new AdViewContainer();
            int a;
            if (this.c()[0]) {
                a = this.a;
            }
            else {
                a = (int)this.a(this.b()[0]);
            }
            adViewContainer.a = a;
            int b;
            if (this.c()[1]) {
                b = this.b;
            }
            else {
                b = (int)this.a(this.b()[1]);
            }
            adViewContainer.b = b;
            int c;
            if (this.c()[2]) {
                c = this.c;
            }
            else {
                c = (int)this.a(this.b()[2]);
            }
            adViewContainer.c = c;
            int d;
            if (this.c()[3]) {
                d = this.d;
            }
            else {
                d = (int)this.a(this.b()[3]);
            }
            adViewContainer.d = d;
            float e;
            if (this.c()[4]) {
                e = this.e;
            }
            else {
                e = (float)this.a(this.b()[4]);
            }
            adViewContainer.e = e;
            ScreenOrientationType f;
            if (this.c()[5]) {
                f = this.f;
            }
            else {
                f = (ScreenOrientationType)this.a(this.b()[5]);
            }
            adViewContainer.f = f;
            return adViewContainer;
        }
        catch (Exception ex) {
            throw new fk(ex);
        }
    }
    
    public AdViewContainer$Builder b(final int n) {
        this.a(this.b()[1], n);
        this.b = n;
        this.c()[1] = true;
        return this;
    }
    
    public AdViewContainer$Builder c(final int n) {
        this.a(this.b()[2], n);
        this.c = n;
        this.c()[2] = true;
        return this;
    }
    
    public AdViewContainer$Builder d(final int n) {
        this.a(this.b()[3], n);
        this.d = n;
        this.c()[3] = true;
        return this;
    }
}
