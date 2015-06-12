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

public class AdFrame extends gw implements gv
{
    public static final fn SCHEMA$;
    @Deprecated
    public int a;
    @Deprecated
    public CharSequence b;
    @Deprecated
    public CharSequence c;
    @Deprecated
    public AdSpaceLayout d;
    @Deprecated
    public List e;
    @Deprecated
    public CharSequence f;
    @Deprecated
    public int g;
    @Deprecated
    public long h;
    @Deprecated
    public List i;
    @Deprecated
    public List j;
    
    static {
        SCHEMA$ = new fn$q().a("{\"type\":\"record\",\"name\":\"AdFrame\",\"namespace\":\"com.flurry.android.impl.ads.avro.protocol.v10\",\"fields\":[{\"name\":\"binding\",\"type\":\"int\"},{\"name\":\"display\",\"type\":\"string\"},{\"name\":\"content\",\"type\":\"string\"},{\"name\":\"adSpaceLayout\",\"type\":{\"type\":\"record\",\"name\":\"AdSpaceLayout\",\"fields\":[{\"name\":\"adWidth\",\"type\":\"int\"},{\"name\":\"adHeight\",\"type\":\"int\"},{\"name\":\"fix\",\"type\":\"string\"},{\"name\":\"format\",\"type\":\"string\"},{\"name\":\"alignment\",\"type\":\"string\"}]}},{\"name\":\"callbacks\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"Callback\",\"fields\":[{\"name\":\"event\",\"type\":\"string\"},{\"name\":\"actions\",\"type\":{\"type\":\"array\",\"items\":\"string\"}}]}}},{\"name\":\"adGuid\",\"type\":\"string\"},{\"name\":\"cachingEnum\",\"type\":\"int\",\"default\":1},{\"name\":\"assetExpirationTimestampUTCMillis\",\"type\":\"long\"},{\"name\":\"cacheWhitelistedAssets\",\"type\":{\"type\":\"array\",\"items\":\"string\"},\"default\":[]},{\"name\":\"cacheBlacklistedAssets\",\"type\":{\"type\":\"array\",\"items\":\"string\"},\"default\":[]}]}");
    }
    
    @Override
    public fn a() {
        return AdFrame.SCHEMA$;
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
            case 7: {
                return this.h;
            }
            case 8: {
                return this.i;
            }
            case 9: {
                return this.j;
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
                this.b = (CharSequence)o;
            }
            case 2: {
                this.c = (CharSequence)o;
            }
            case 3: {
                this.d = (AdSpaceLayout)o;
            }
            case 4: {
                this.e = (List)o;
            }
            case 5: {
                this.f = (CharSequence)o;
            }
            case 6: {
                this.g = (int)o;
            }
            case 7: {
                this.h = (long)o;
            }
            case 8: {
                this.i = (List)o;
            }
            case 9: {
                this.j = (List)o;
            }
        }
    }
    
    public Integer b() {
        return this.a;
    }
    
    public CharSequence c() {
        return this.b;
    }
    
    public CharSequence d() {
        return this.c;
    }
    
    public AdSpaceLayout e() {
        return this.d;
    }
    
    public List f() {
        return this.e;
    }
    
    public CharSequence g() {
        return this.f;
    }
    
    public Integer h() {
        return this.g;
    }
    
    public Long i() {
        return this.h;
    }
    
    public List j() {
        return this.i;
    }
    
    public List k() {
        return this.j;
    }
}
