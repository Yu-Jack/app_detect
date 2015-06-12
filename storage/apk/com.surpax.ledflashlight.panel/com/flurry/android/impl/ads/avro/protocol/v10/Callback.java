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

public class Callback extends gw implements gv
{
    public static final fn SCHEMA$;
    @Deprecated
    public CharSequence a;
    @Deprecated
    public List b;
    
    static {
        SCHEMA$ = new fn$q().a("{\"type\":\"record\",\"name\":\"Callback\",\"namespace\":\"com.flurry.android.impl.ads.avro.protocol.v10\",\"fields\":[{\"name\":\"event\",\"type\":\"string\"},{\"name\":\"actions\",\"type\":{\"type\":\"array\",\"items\":\"string\"}}]}");
    }
    
    @Override
    public fn a() {
        return Callback.SCHEMA$;
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
                this.a = (CharSequence)o;
            }
            case 1: {
                this.b = (List)o;
            }
        }
    }
    
    public CharSequence b() {
        return this.a;
    }
    
    public List c() {
        return this.b;
    }
}
