// 
// Decompiled by Procyon v0.5.29
// 

package com.flurry.android.impl.ads.avro.protocol.v10;

import com.flurry.sdk.fk;
import com.flurry.sdk.fn$q;
import java.util.List;
import com.flurry.sdk.fn;
import com.flurry.sdk.gv;
import com.flurry.sdk.gw;

public class SdkAdLog extends gw implements gv
{
    public static final fn SCHEMA$;
    @Deprecated
    public long a;
    @Deprecated
    public CharSequence b;
    @Deprecated
    public List c;
    
    static {
        SCHEMA$ = new fn$q().a("{\"type\":\"record\",\"name\":\"SdkAdLog\",\"namespace\":\"com.flurry.android.impl.ads.avro.protocol.v10\",\"fields\":[{\"name\":\"sessionId\",\"type\":\"long\"},{\"name\":\"adLogGUID\",\"type\":\"string\"},{\"name\":\"sdkAdEvents\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"SdkAdEvent\",\"fields\":[{\"name\":\"type\",\"type\":\"string\"},{\"name\":\"params\",\"type\":{\"type\":\"map\",\"values\":\"string\"}},{\"name\":\"timeOffset\",\"type\":\"long\"}]}}}]}");
    }
    
    @Override
    public fn a() {
        return SdkAdLog.SCHEMA$;
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
            case 2: {
                return this.c;
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
                this.a = (long)o;
            }
            case 1: {
                this.b = (CharSequence)o;
            }
            case 2: {
                this.c = (List)o;
            }
        }
    }
    
    public void a(final CharSequence b) {
        this.b = b;
    }
    
    public void a(final Long n) {
        this.a = n;
    }
    
    public void a(final List c) {
        this.c = c;
    }
}
