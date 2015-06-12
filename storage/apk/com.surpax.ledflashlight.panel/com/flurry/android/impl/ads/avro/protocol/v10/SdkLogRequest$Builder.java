// 
// Decompiled by Procyon v0.5.29
// 

package com.flurry.android.impl.ads.avro.protocol.v10;

import com.flurry.sdk.fk;
import java.util.List;
import com.flurry.sdk.gx;

public class SdkLogRequest$Builder extends gx
{
    private CharSequence a;
    private List b;
    private List c;
    private long d;
    private CharSequence e;
    private boolean f;
    
    private SdkLogRequest$Builder() {
        super(SdkLogRequest.SCHEMA$);
    }
    
    public SdkLogRequest$Builder a(final long n) {
        this.a(this.b()[3], n);
        this.d = n;
        this.c()[3] = true;
        return this;
    }
    
    public SdkLogRequest$Builder a(final CharSequence a) {
        this.a(this.b()[0], a);
        this.a = a;
        this.c()[0] = true;
        return this;
    }
    
    public SdkLogRequest$Builder a(final List b) {
        this.a(this.b()[1], b);
        this.b = b;
        this.c()[1] = true;
        return this;
    }
    
    public SdkLogRequest$Builder a(final boolean b) {
        this.a(this.b()[5], b);
        this.f = b;
        this.c()[5] = true;
        return this;
    }
    
    public SdkLogRequest a() {
        try {
            final SdkLogRequest sdkLogRequest = new SdkLogRequest();
            CharSequence a;
            if (this.c()[0]) {
                a = this.a;
            }
            else {
                a = (CharSequence)this.a(this.b()[0]);
            }
            sdkLogRequest.a = a;
            List b;
            if (this.c()[1]) {
                b = this.b;
            }
            else {
                b = (List)this.a(this.b()[1]);
            }
            sdkLogRequest.b = b;
            List c;
            if (this.c()[2]) {
                c = this.c;
            }
            else {
                c = (List)this.a(this.b()[2]);
            }
            sdkLogRequest.c = c;
            long d;
            if (this.c()[3]) {
                d = this.d;
            }
            else {
                d = (long)this.a(this.b()[3]);
            }
            sdkLogRequest.d = d;
            CharSequence e;
            if (this.c()[4]) {
                e = this.e;
            }
            else {
                e = (CharSequence)this.a(this.b()[4]);
            }
            sdkLogRequest.e = e;
            boolean f;
            if (this.c()[5]) {
                f = this.f;
            }
            else {
                f = (boolean)this.a(this.b()[5]);
            }
            sdkLogRequest.f = f;
            return sdkLogRequest;
        }
        catch (Exception ex) {
            throw new fk(ex);
        }
    }
    
    public SdkLogRequest$Builder b(final CharSequence e) {
        this.a(this.b()[4], e);
        this.e = e;
        this.c()[4] = true;
        return this;
    }
    
    public SdkLogRequest$Builder b(final List c) {
        this.a(this.b()[2], c);
        this.c = c;
        this.c()[2] = true;
        return this;
    }
}
