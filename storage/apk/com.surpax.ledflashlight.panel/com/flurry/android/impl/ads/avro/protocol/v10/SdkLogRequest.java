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

public class SdkLogRequest extends gw implements gv
{
    public static final fn SCHEMA$;
    @Deprecated
    public CharSequence a;
    @Deprecated
    public List b;
    @Deprecated
    public List c;
    @Deprecated
    public long d;
    @Deprecated
    public CharSequence e;
    @Deprecated
    public boolean f;
    
    static {
        SCHEMA$ = new fn$q().a("{\"type\":\"record\",\"name\":\"SdkLogRequest\",\"namespace\":\"com.flurry.android.impl.ads.avro.protocol.v10\",\"fields\":[{\"name\":\"apiKey\",\"type\":\"string\"},{\"name\":\"adReportedIds\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"AdReportedId\",\"fields\":[{\"name\":\"type\",\"type\":\"int\"},{\"name\":\"id\",\"type\":\"bytes\"}]}}},{\"name\":\"sdkAdLogs\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"SdkAdLog\",\"fields\":[{\"name\":\"sessionId\",\"type\":\"long\"},{\"name\":\"adLogGUID\",\"type\":\"string\"},{\"name\":\"sdkAdEvents\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"SdkAdEvent\",\"fields\":[{\"name\":\"type\",\"type\":\"string\"},{\"name\":\"params\",\"type\":{\"type\":\"map\",\"values\":\"string\"}},{\"name\":\"timeOffset\",\"type\":\"long\"}]}}}]}}},{\"name\":\"agentTimestamp\",\"type\":\"long\"},{\"name\":\"agentVersion\",\"type\":\"string\"},{\"name\":\"testDevice\",\"type\":\"boolean\",\"default\":false}]}");
    }
    
    public static SdkLogRequest$Builder b() {
        return new SdkLogRequest$Builder((SdkLogRequest$1)null);
    }
    
    @Override
    public fn a() {
        return SdkLogRequest.SCHEMA$;
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
            case 3: {
                return this.d;
            }
            case 4: {
                return this.e;
            }
            case 5: {
                return this.f;
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
                this.b = (List)o;
            }
            case 2: {
                this.c = (List)o;
            }
            case 3: {
                this.d = (long)o;
            }
            case 4: {
                this.e = (CharSequence)o;
            }
            case 5: {
                this.f = (boolean)o;
            }
        }
    }
}
