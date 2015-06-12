// 
// Decompiled by Procyon v0.5.29
// 

package com.flurry.android.impl.ads.avro.protocol.v10;

import com.flurry.sdk.fk;
import com.flurry.sdk.fn$q;
import com.flurry.sdk.fn;
import com.flurry.sdk.gv;
import com.flurry.sdk.gw;

public class AdSpaceLayout extends gw implements gv
{
    public static final fn SCHEMA$;
    @Deprecated
    public int a;
    @Deprecated
    public int b;
    @Deprecated
    public CharSequence c;
    @Deprecated
    public CharSequence d;
    @Deprecated
    public CharSequence e;
    
    static {
        SCHEMA$ = new fn$q().a("{\"type\":\"record\",\"name\":\"AdSpaceLayout\",\"namespace\":\"com.flurry.android.impl.ads.avro.protocol.v10\",\"fields\":[{\"name\":\"adWidth\",\"type\":\"int\"},{\"name\":\"adHeight\",\"type\":\"int\"},{\"name\":\"fix\",\"type\":\"string\"},{\"name\":\"format\",\"type\":\"string\"},{\"name\":\"alignment\",\"type\":\"string\"}]}");
    }
    
    @Override
    public fn a() {
        return AdSpaceLayout.SCHEMA$;
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
                this.b = (int)o;
            }
            case 2: {
                this.c = (CharSequence)o;
            }
            case 3: {
                this.d = (CharSequence)o;
            }
            case 4: {
                this.e = (CharSequence)o;
            }
        }
    }
    
    public Integer b() {
        return this.a;
    }
    
    public Integer c() {
        return this.b;
    }
    
    public CharSequence d() {
        return this.c;
    }
    
    public CharSequence e() {
        return this.d;
    }
    
    public CharSequence f() {
        return this.e;
    }
}
