// 
// Decompiled by Procyon v0.5.29
// 

package com.flurry.android.impl.ads.avro.protocol.v10;

import com.flurry.sdk.fk;
import java.nio.ByteBuffer;
import com.flurry.sdk.gx;

public class AdReportedId$Builder extends gx
{
    private int a;
    private ByteBuffer b;
    
    private AdReportedId$Builder() {
        super(AdReportedId.SCHEMA$);
    }
    
    public AdReportedId$Builder a(final int n) {
        this.a(this.b()[0], n);
        this.a = n;
        this.c()[0] = true;
        return this;
    }
    
    public AdReportedId$Builder a(final ByteBuffer b) {
        this.a(this.b()[1], b);
        this.b = b;
        this.c()[1] = true;
        return this;
    }
    
    public AdReportedId a() {
        try {
            final AdReportedId adReportedId = new AdReportedId();
            int a;
            if (this.c()[0]) {
                a = this.a;
            }
            else {
                a = (int)this.a(this.b()[0]);
            }
            adReportedId.a = a;
            ByteBuffer b;
            if (this.c()[1]) {
                b = this.b;
            }
            else {
                b = (ByteBuffer)this.a(this.b()[1]);
            }
            adReportedId.b = b;
            return adReportedId;
        }
        catch (Exception ex) {
            throw new fk(ex);
        }
    }
}
