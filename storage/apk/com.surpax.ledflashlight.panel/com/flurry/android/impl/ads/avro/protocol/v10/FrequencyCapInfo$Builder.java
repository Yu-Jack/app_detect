// 
// Decompiled by Procyon v0.5.29
// 

package com.flurry.android.impl.ads.avro.protocol.v10;

import com.flurry.sdk.fk;
import com.flurry.sdk.gx;

public class FrequencyCapInfo$Builder extends gx
{
    private CharSequence a;
    private long b;
    private long c;
    private int d;
    private int e;
    private int f;
    private int g;
    
    private FrequencyCapInfo$Builder() {
        super(FrequencyCapInfo.SCHEMA$);
    }
    
    public FrequencyCapInfo$Builder a(final int n) {
        this.a(this.b()[3], n);
        this.d = n;
        this.c()[3] = true;
        return this;
    }
    
    public FrequencyCapInfo$Builder a(final long n) {
        this.a(this.b()[1], n);
        this.b = n;
        this.c()[1] = true;
        return this;
    }
    
    public FrequencyCapInfo$Builder a(final CharSequence a) {
        this.a(this.b()[0], a);
        this.a = a;
        this.c()[0] = true;
        return this;
    }
    
    public FrequencyCapInfo a() {
        try {
            final FrequencyCapInfo frequencyCapInfo = new FrequencyCapInfo();
            CharSequence a;
            if (this.c()[0]) {
                a = this.a;
            }
            else {
                a = (CharSequence)this.a(this.b()[0]);
            }
            frequencyCapInfo.a = a;
            long b;
            if (this.c()[1]) {
                b = this.b;
            }
            else {
                b = (long)this.a(this.b()[1]);
            }
            frequencyCapInfo.b = b;
            long c;
            if (this.c()[2]) {
                c = this.c;
            }
            else {
                c = (long)this.a(this.b()[2]);
            }
            frequencyCapInfo.c = c;
            int d;
            if (this.c()[3]) {
                d = this.d;
            }
            else {
                d = (int)this.a(this.b()[3]);
            }
            frequencyCapInfo.d = d;
            int e;
            if (this.c()[4]) {
                e = this.e;
            }
            else {
                e = (int)this.a(this.b()[4]);
            }
            frequencyCapInfo.e = e;
            int f;
            if (this.c()[5]) {
                f = this.f;
            }
            else {
                f = (int)this.a(this.b()[5]);
            }
            frequencyCapInfo.f = f;
            int g;
            if (this.c()[6]) {
                g = this.g;
            }
            else {
                g = (int)this.a(this.b()[6]);
            }
            frequencyCapInfo.g = g;
            return frequencyCapInfo;
        }
        catch (Exception ex) {
            throw new fk(ex);
        }
    }
    
    public FrequencyCapInfo$Builder b(final int n) {
        this.a(this.b()[4], n);
        this.e = n;
        this.c()[4] = true;
        return this;
    }
    
    public FrequencyCapInfo$Builder b(final long n) {
        this.a(this.b()[2], n);
        this.c = n;
        this.c()[2] = true;
        return this;
    }
    
    public FrequencyCapInfo$Builder c(final int n) {
        this.a(this.b()[5], n);
        this.f = n;
        this.c()[5] = true;
        return this;
    }
    
    public FrequencyCapInfo$Builder d(final int n) {
        this.a(this.b()[6], n);
        this.g = n;
        this.c()[6] = true;
        return this;
    }
}
