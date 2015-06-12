// 
// Decompiled by Procyon v0.5.29
// 

package com.flurry.android.impl.ads.avro.protocol.v10;

import com.flurry.sdk.fk;
import com.flurry.sdk.fn$q;
import com.flurry.sdk.fn;
import com.flurry.sdk.gv;
import com.flurry.sdk.gw;

public class Configuration extends gw implements gv
{
    public static final fn SCHEMA$;
    @Deprecated
    public CharSequence a;
    @Deprecated
    public int b;
    @Deprecated
    public int c;
    
    static {
        SCHEMA$ = new fn$q().a("{\"type\":\"record\",\"name\":\"Configuration\",\"namespace\":\"com.flurry.android.impl.ads.avro.protocol.v10\",\"fields\":[{\"name\":\"sdkAssetUrl\",\"type\":\"string\"},{\"name\":\"cacheSizeMb\",\"type\":\"int\",\"default\":20},{\"name\":\"maxAssetSizeKb\",\"type\":\"int\",\"default\":2024}]}");
    }
    
    @Override
    public fn a() {
        return Configuration.SCHEMA$;
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
                this.b = (int)o;
            }
            case 2: {
                this.c = (int)o;
            }
        }
    }
    
    public CharSequence b() {
        return this.a;
    }
    
    public Integer c() {
        return this.b;
    }
    
    public Integer d() {
        return this.c;
    }
}
