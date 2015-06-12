// 
// Decompiled by Procyon v0.5.29
// 

package com.flurry.android.impl.ads.avro.protocol.v10;

import com.flurry.sdk.fk;
import com.flurry.sdk.gx;

public class TestAds$Builder extends gx
{
    private int a;
    
    private TestAds$Builder() {
        super(TestAds.SCHEMA$);
    }
    
    public TestAds$Builder a(final int n) {
        this.a(this.b()[0], n);
        this.a = n;
        this.c()[0] = true;
        return this;
    }
    
    public TestAds a() {
        try {
            final TestAds testAds = new TestAds();
            int a;
            if (this.c()[0]) {
                a = this.a;
            }
            else {
                a = (int)this.a(this.b()[0]);
            }
            testAds.a = a;
            return testAds;
        }
        catch (Exception ex) {
            throw new fk(ex);
        }
    }
}
