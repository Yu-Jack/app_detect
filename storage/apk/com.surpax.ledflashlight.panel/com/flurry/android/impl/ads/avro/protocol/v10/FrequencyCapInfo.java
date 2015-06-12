// 
// Decompiled by Procyon v0.5.29
// 

package com.flurry.android.impl.ads.avro.protocol.v10;

import com.flurry.sdk.fk;
import com.flurry.sdk.fn$q;
import com.flurry.sdk.fn;
import com.flurry.sdk.gv;
import com.flurry.sdk.gw;

public class FrequencyCapInfo extends gw implements gv
{
    public static final fn SCHEMA$;
    @Deprecated
    public CharSequence a;
    @Deprecated
    public long b;
    @Deprecated
    public long c;
    @Deprecated
    public int d;
    @Deprecated
    public int e;
    @Deprecated
    public int f;
    @Deprecated
    public int g;
    
    static {
        SCHEMA$ = new fn$q().a("{\"type\":\"record\",\"name\":\"FrequencyCapInfo\",\"namespace\":\"com.flurry.android.impl.ads.avro.protocol.v10\",\"fields\":[{\"name\":\"idHash\",\"type\":\"string\",\"default\":\"null\"},{\"name\":\"serveTime\",\"type\":\"long\"},{\"name\":\"expirationTime\",\"type\":\"long\"},{\"name\":\"views\",\"type\":\"int\"},{\"name\":\"newCap\",\"type\":\"int\"},{\"name\":\"previousCap\",\"type\":\"int\"},{\"name\":\"previousCapType\",\"type\":\"int\"}]}");
    }
    
    public static FrequencyCapInfo$Builder b() {
        return new FrequencyCapInfo$Builder((FrequencyCapInfo$1)null);
    }
    
    @Override
    public fn a() {
        return FrequencyCapInfo.SCHEMA$;
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
            case 6: {
                return this.g;
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
                this.b = (long)o;
            }
            case 2: {
                this.c = (long)o;
            }
            case 3: {
                this.d = (int)o;
            }
            case 4: {
                this.e = (int)o;
            }
            case 5: {
                this.f = (int)o;
            }
            case 6: {
                this.g = (int)o;
            }
        }
    }
}
