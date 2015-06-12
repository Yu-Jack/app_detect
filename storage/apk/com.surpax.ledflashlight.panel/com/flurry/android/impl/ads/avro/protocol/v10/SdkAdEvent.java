// 
// Decompiled by Procyon v0.5.29
// 

package com.flurry.android.impl.ads.avro.protocol.v10;

import com.flurry.sdk.fk;
import com.flurry.sdk.fn$q;
import java.util.Map;
import com.flurry.sdk.fn;
import com.flurry.sdk.gv;
import com.flurry.sdk.gw;

public class SdkAdEvent extends gw implements gv
{
    public static final fn SCHEMA$;
    @Deprecated
    public CharSequence a;
    @Deprecated
    public Map b;
    @Deprecated
    public long c;
    
    static {
        SCHEMA$ = new fn$q().a("{\"type\":\"record\",\"name\":\"SdkAdEvent\",\"namespace\":\"com.flurry.android.impl.ads.avro.protocol.v10\",\"fields\":[{\"name\":\"type\",\"type\":\"string\"},{\"name\":\"params\",\"type\":{\"type\":\"map\",\"values\":\"string\"}},{\"name\":\"timeOffset\",\"type\":\"long\"}]}");
    }
    
    @Override
    public fn a() {
        return SdkAdEvent.SCHEMA$;
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
                this.a = (CharSequence)o;
            }
            case 1: {
                this.b = (Map)o;
            }
            case 2: {
                this.c = (long)o;
            }
        }
    }
    
    public void a(final CharSequence a) {
        this.a = a;
    }
    
    public void a(final Long n) {
        this.c = n;
    }
    
    public void a(final Map b) {
        this.b = b;
    }
}
