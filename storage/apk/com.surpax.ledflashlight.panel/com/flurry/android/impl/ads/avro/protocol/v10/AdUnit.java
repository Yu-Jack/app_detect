// 
// Decompiled by Procyon v0.5.29
// 

package com.flurry.android.impl.ads.avro.protocol.v10;

import com.flurry.sdk.fk;
import com.flurry.sdk.fn$q;
import java.util.Map;
import java.util.List;
import com.flurry.sdk.fn;
import com.flurry.sdk.gv;
import com.flurry.sdk.gw;

public class AdUnit extends gw implements gv
{
    public static final fn SCHEMA$;
    @Deprecated
    public CharSequence a;
    @Deprecated
    public long b;
    @Deprecated
    public List c;
    @Deprecated
    public int d;
    @Deprecated
    public CharSequence e;
    @Deprecated
    public CharSequence f;
    @Deprecated
    public long g;
    @Deprecated
    public int h;
    @Deprecated
    public int i;
    @Deprecated
    public int j;
    @Deprecated
    public long k;
    @Deprecated
    public long l;
    @Deprecated
    public CharSequence m;
    @Deprecated
    public long n;
    @Deprecated
    public boolean o;
    @Deprecated
    public long p;
    @Deprecated
    public int q;
    @Deprecated
    public boolean r;
    @Deprecated
    public boolean s;
    @Deprecated
    public boolean t;
    @Deprecated
    public boolean u;
    @Deprecated
    public Map v;
    @Deprecated
    public ScreenOrientationType w;
    
    static {
        SCHEMA$ = new fn$q().a("{\"type\":\"record\",\"name\":\"AdUnit\",\"namespace\":\"com.flurry.android.impl.ads.avro.protocol.v10\",\"fields\":[{\"name\":\"adSpace\",\"type\":\"string\"},{\"name\":\"expiration\",\"type\":\"long\"},{\"name\":\"adFrames\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"AdFrame\",\"fields\":[{\"name\":\"binding\",\"type\":\"int\"},{\"name\":\"display\",\"type\":\"string\"},{\"name\":\"content\",\"type\":\"string\"},{\"name\":\"adSpaceLayout\",\"type\":{\"type\":\"record\",\"name\":\"AdSpaceLayout\",\"fields\":[{\"name\":\"adWidth\",\"type\":\"int\"},{\"name\":\"adHeight\",\"type\":\"int\"},{\"name\":\"fix\",\"type\":\"string\"},{\"name\":\"format\",\"type\":\"string\"},{\"name\":\"alignment\",\"type\":\"string\"}]}},{\"name\":\"callbacks\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"Callback\",\"fields\":[{\"name\":\"event\",\"type\":\"string\"},{\"name\":\"actions\",\"type\":{\"type\":\"array\",\"items\":\"string\"}}]}}},{\"name\":\"adGuid\",\"type\":\"string\"},{\"name\":\"cachingEnum\",\"type\":\"int\",\"default\":1},{\"name\":\"assetExpirationTimestampUTCMillis\",\"type\":\"long\"},{\"name\":\"cacheWhitelistedAssets\",\"type\":{\"type\":\"array\",\"items\":\"string\"},\"default\":[]},{\"name\":\"cacheBlacklistedAssets\",\"type\":{\"type\":\"array\",\"items\":\"string\"},\"default\":[]}]}}},{\"name\":\"combinable\",\"type\":\"int\",\"default\":0},{\"name\":\"groupId\",\"type\":\"string\"},{\"name\":\"idHash\",\"type\":\"string\",\"default\":\"null\"},{\"name\":\"serveTime\",\"type\":\"long\"},{\"name\":\"newCap\",\"type\":\"int\",\"default\":-1},{\"name\":\"previousCap\",\"type\":\"int\",\"default\":-1},{\"name\":\"previousCapType\",\"type\":\"int\",\"default\":0},{\"name\":\"expirationTime\",\"type\":\"long\"},{\"name\":\"price\",\"type\":\"long\",\"default\":0},{\"name\":\"adomain\",\"type\":\"string\",\"default\":\"null\"},{\"name\":\"closableTime\",\"type\":\"long\",\"default\":0},{\"name\":\"rewardable\",\"type\":\"boolean\",\"default\":false},{\"name\":\"preRenderTimeoutMillis\",\"type\":\"long\",\"default\":10000},{\"name\":\"preCacheAdSkippableTimeLimitMillis\",\"type\":\"int\",\"default\":20000},{\"name\":\"videoAutoPlay\",\"type\":\"boolean\",\"default\":false},{\"name\":\"supportMRAID\",\"type\":\"boolean\",\"default\":false},{\"name\":\"preRender\",\"type\":\"boolean\",\"default\":true},{\"name\":\"renderTime\",\"type\":\"boolean\",\"default\":false},{\"name\":\"clientSideRtbPayload\",\"type\":{\"type\":\"map\",\"values\":\"string\"},\"default\":[]},{\"name\":\"screenOrientation\",\"type\":{\"type\":\"enum\",\"name\":\"ScreenOrientationType\",\"symbols\":[\"PORTRAIT\",\"LANDSCAPE\",\"UNKNOWN\"]},\"default\":\"UNKNOWN\"}]}");
    }
    
    @Override
    public fn a() {
        return AdUnit.SCHEMA$;
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
            case 10: {
                return this.k;
            }
            case 11: {
                return this.l;
            }
            case 12: {
                return this.m;
            }
            case 13: {
                return this.n;
            }
            case 14: {
                return this.o;
            }
            case 15: {
                return this.p;
            }
            case 16: {
                return this.q;
            }
            case 17: {
                return this.r;
            }
            case 18: {
                return this.s;
            }
            case 19: {
                return this.t;
            }
            case 20: {
                return this.u;
            }
            case 21: {
                return this.v;
            }
            case 22: {
                return this.w;
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
                this.c = (List)o;
            }
            case 3: {
                this.d = (int)o;
            }
            case 4: {
                this.e = (CharSequence)o;
            }
            case 5: {
                this.f = (CharSequence)o;
            }
            case 6: {
                this.g = (long)o;
            }
            case 7: {
                this.h = (int)o;
            }
            case 8: {
                this.i = (int)o;
            }
            case 9: {
                this.j = (int)o;
            }
            case 10: {
                this.k = (long)o;
            }
            case 11: {
                this.l = (long)o;
            }
            case 12: {
                this.m = (CharSequence)o;
            }
            case 13: {
                this.n = (long)o;
            }
            case 14: {
                this.o = (boolean)o;
            }
            case 15: {
                this.p = (long)o;
            }
            case 16: {
                this.q = (int)o;
            }
            case 17: {
                this.r = (boolean)o;
            }
            case 18: {
                this.s = (boolean)o;
            }
            case 19: {
                this.t = (boolean)o;
            }
            case 20: {
                this.u = (boolean)o;
            }
            case 21: {
                this.v = (Map)o;
            }
            case 22: {
                this.w = (ScreenOrientationType)o;
            }
        }
    }
    
    public void a(final Boolean b) {
        this.u = b;
    }
    
    public void a(final CharSequence e) {
        this.e = e;
    }
    
    public void a(final List c) {
        this.c = c;
    }
    
    public void a(final Map v) {
        this.v = v;
    }
    
    public CharSequence b() {
        return this.a;
    }
    
    public void b(final CharSequence f) {
        this.f = f;
    }
    
    public Long c() {
        return this.b;
    }
    
    public List d() {
        return this.c;
    }
    
    public Integer e() {
        return this.d;
    }
    
    public CharSequence f() {
        return this.e;
    }
    
    public CharSequence g() {
        return this.f;
    }
    
    public Long h() {
        return this.g;
    }
    
    public Integer i() {
        return this.h;
    }
    
    public Integer j() {
        return this.i;
    }
    
    public Integer k() {
        return this.j;
    }
    
    public Long l() {
        return this.k;
    }
    
    public Long m() {
        return this.n;
    }
    
    public Boolean n() {
        return this.o;
    }
    
    public Long o() {
        return this.p;
    }
    
    public Integer p() {
        return this.q;
    }
    
    public Boolean q() {
        return this.r;
    }
    
    public Boolean r() {
        return this.s;
    }
    
    public Boolean s() {
        return this.u;
    }
    
    public Map t() {
        return this.v;
    }
    
    public ScreenOrientationType u() {
        return this.w;
    }
}
