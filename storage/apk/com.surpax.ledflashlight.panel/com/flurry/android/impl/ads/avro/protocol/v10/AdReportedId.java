// 
// Decompiled by Procyon v0.5.29
// 

package com.flurry.android.impl.ads.avro.protocol.v10;

import com.flurry.sdk.fk;
import com.flurry.sdk.fn$q;
import java.nio.ByteBuffer;
import com.flurry.sdk.fn;
import com.flurry.sdk.gv;
import com.flurry.sdk.gw;

public class AdReportedId extends gw implements gv
{
    public static final fn SCHEMA$;
    @Deprecated
    public int a;
    @Deprecated
    public ByteBuffer b;
    
    static {
        SCHEMA$ = new fn$q().a("{\"type\":\"record\",\"name\":\"AdReportedId\",\"namespace\":\"com.flurry.android.impl.ads.avro.protocol.v10\",\"fields\":[{\"name\":\"type\",\"type\":\"int\"},{\"name\":\"id\",\"type\":\"bytes\"}]}");
    }
    
    public static AdReportedId$Builder b() {
        return new AdReportedId$Builder((AdReportedId$1)null);
    }
    
    @Override
    public fn a() {
        return AdReportedId.SCHEMA$;
    }
    
    @Override
    public Object a(final int n) {
        switch (n) {
            default: {
                throw new fk("Bad index");
            }
            case 0: {
                return this.a;
            }
            case 1: {
                return this.b;
            }
        }
    }
    
    @Override
    public void a(final int n, final Object o) {
        switch (n) {
            default: {
                throw new fk("Bad index");
            }
            case 0: {
                this.a = (int)o;
            }
            case 1: {
                this.b = (ByteBuffer)o;
            }
        }
    }
}
