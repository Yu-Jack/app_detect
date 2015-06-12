// 
// Decompiled by Procyon v0.5.29
// 

package com.flurry.android.impl.ads.avro.protocol.v10;

import com.flurry.sdk.fk;
import com.flurry.sdk.fn$q;
import com.flurry.sdk.fn;
import com.flurry.sdk.gv;
import com.flurry.sdk.gw;

public class AdViewContainer extends gw implements gv
{
    public static final fn SCHEMA$;
    @Deprecated
    public int a;
    @Deprecated
    public int b;
    @Deprecated
    public int c;
    @Deprecated
    public int d;
    @Deprecated
    public float e;
    @Deprecated
    public ScreenOrientationType f;
    
    static {
        SCHEMA$ = new fn$q().a("{\"type\":\"record\",\"name\":\"AdViewContainer\",\"namespace\":\"com.flurry.android.impl.ads.avro.protocol.v10\",\"fields\":[{\"name\":\"viewWidth\",\"type\":\"int\",\"default\":0},{\"name\":\"viewHeight\",\"type\":\"int\",\"default\":0},{\"name\":\"screenWidth\",\"type\":\"int\",\"default\":0},{\"name\":\"screenHeight\",\"type\":\"int\",\"default\":0},{\"name\":\"density\",\"type\":\"float\",\"default\":1.0},{\"name\":\"screenOrientation\",\"type\":{\"type\":\"enum\",\"name\":\"ScreenOrientationType\",\"symbols\":[\"PORTRAIT\",\"LANDSCAPE\",\"UNKNOWN\"]},\"default\":\"UNKNOWN\"}]}");
    }
    
    public static AdViewContainer$Builder b() {
        return new AdViewContainer$Builder((AdViewContainer$1)null);
    }
    
    @Override
    public fn a() {
        return AdViewContainer.SCHEMA$;
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
                this.a = (int)o;
            }
            case 1: {
                this.b = (int)o;
            }
            case 2: {
                this.c = (int)o;
            }
            case 3: {
                this.d = (int)o;
            }
            case 4: {
                this.e = (float)o;
            }
            case 5: {
                this.f = (ScreenOrientationType)o;
            }
        }
    }
}
