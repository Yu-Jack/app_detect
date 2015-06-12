// 
// Decompiled by Procyon v0.5.29
// 

package com.flurry.android.impl.ads.avro.protocol.v10;

import com.flurry.sdk.fk;
import com.flurry.sdk.fn$q;
import java.util.List;
import java.util.Map;
import com.flurry.sdk.fn;
import com.flurry.sdk.gv;
import com.flurry.sdk.gw;

public class AdRequest extends gw implements gv
{
    public static final fn SCHEMA$;
    @Deprecated
    public boolean A;
    @Deprecated
    public Map B;
    @Deprecated
    public CharSequence a;
    @Deprecated
    public CharSequence b;
    @Deprecated
    public CharSequence c;
    @Deprecated
    public long d;
    @Deprecated
    public List e;
    @Deprecated
    public Location f;
    @Deprecated
    public boolean g;
    @Deprecated
    public List h;
    @Deprecated
    public AdViewContainer i;
    @Deprecated
    public CharSequence j;
    @Deprecated
    public CharSequence k;
    @Deprecated
    public CharSequence l;
    @Deprecated
    public CharSequence m;
    @Deprecated
    public TestAds n;
    @Deprecated
    public Map o;
    @Deprecated
    public boolean p;
    @Deprecated
    public boolean q;
    @Deprecated
    public int r;
    @Deprecated
    public List s;
    @Deprecated
    public boolean t;
    @Deprecated
    public CharSequence u;
    @Deprecated
    public List v;
    @Deprecated
    public CharSequence w;
    @Deprecated
    public TargetingOverride x;
    @Deprecated
    public boolean y;
    @Deprecated
    public List z;
    
    static {
        SCHEMA$ = new fn$q().a("{\"type\":\"record\",\"name\":\"AdRequest\",\"namespace\":\"com.flurry.android.impl.ads.avro.protocol.v10\",\"fields\":[{\"name\":\"apiKey\",\"type\":\"string\"},{\"name\":\"agentVersion\",\"type\":\"string\",\"default\":\"null\"},{\"name\":\"adSpaceName\",\"type\":\"string\"},{\"name\":\"sessionId\",\"type\":\"long\"},{\"name\":\"adReportedIds\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"AdReportedId\",\"fields\":[{\"name\":\"type\",\"type\":\"int\"},{\"name\":\"id\",\"type\":\"bytes\"}]}}},{\"name\":\"location\",\"type\":{\"type\":\"record\",\"name\":\"Location\",\"fields\":[{\"name\":\"lat\",\"type\":\"float\",\"default\":0.0},{\"name\":\"lon\",\"type\":\"float\",\"default\":0.0}]},\"default\":\"null\"},{\"name\":\"testDevice\",\"type\":\"boolean\",\"default\":false},{\"name\":\"bindings\",\"type\":{\"type\":\"array\",\"items\":\"int\"}},{\"name\":\"adViewContainer\",\"type\":{\"type\":\"record\",\"name\":\"AdViewContainer\",\"fields\":[{\"name\":\"viewWidth\",\"type\":\"int\",\"default\":0},{\"name\":\"viewHeight\",\"type\":\"int\",\"default\":0},{\"name\":\"screenWidth\",\"type\":\"int\",\"default\":0},{\"name\":\"screenHeight\",\"type\":\"int\",\"default\":0},{\"name\":\"density\",\"type\":\"float\",\"default\":1.0},{\"name\":\"screenOrientation\",\"type\":{\"type\":\"enum\",\"name\":\"ScreenOrientationType\",\"symbols\":[\"PORTRAIT\",\"LANDSCAPE\",\"UNKNOWN\"]},\"default\":\"UNKNOWN\"}]},\"default\":\"null\"},{\"name\":\"locale\",\"type\":\"string\",\"default\":\"null\"},{\"name\":\"timezone\",\"type\":\"string\",\"default\":\"null\"},{\"name\":\"osVersion\",\"type\":\"string\",\"default\":\"null\"},{\"name\":\"devicePlatform\",\"type\":\"string\",\"default\":\"null\"},{\"name\":\"testAds\",\"type\":{\"type\":\"record\",\"name\":\"TestAds\",\"fields\":[{\"name\":\"adspacePlacement\",\"type\":\"int\",\"default\":0}]},\"default\":\"null\"},{\"name\":\"keywords\",\"type\":{\"type\":\"map\",\"values\":\"string\"},\"default\":[]},{\"name\":\"refresh\",\"type\":\"boolean\",\"default\":false},{\"name\":\"canDoSKAppStore\",\"type\":\"boolean\",\"default\":false},{\"name\":\"networkStatus\",\"type\":\"int\",\"default\":1},{\"name\":\"frequencyCapInfos\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"FrequencyCapInfo\",\"fields\":[{\"name\":\"idHash\",\"type\":\"string\",\"default\":\"null\"},{\"name\":\"serveTime\",\"type\":\"long\"},{\"name\":\"expirationTime\",\"type\":\"long\"},{\"name\":\"views\",\"type\":\"int\"},{\"name\":\"newCap\",\"type\":\"int\"},{\"name\":\"previousCap\",\"type\":\"int\"},{\"name\":\"previousCapType\",\"type\":\"int\"}]}}},{\"name\":\"adTrackingEnabled\",\"type\":\"boolean\"},{\"name\":\"preferredLanguage\",\"type\":\"string\"},{\"name\":\"bcat\",\"type\":{\"type\":\"array\",\"items\":\"string\"}},{\"name\":\"userAgent\",\"type\":\"string\",\"default\":\"null\"},{\"name\":\"targetingOverride\",\"type\":{\"type\":\"record\",\"name\":\"TargetingOverride\",\"fields\":[{\"name\":\"ageRange\",\"type\":\"int\",\"default\":-2},{\"name\":\"gender\",\"type\":\"int\",\"default\":-2},{\"name\":\"personas\",\"type\":{\"type\":\"array\",\"items\":\"int\"},\"default\":[]}]},\"default\":[]},{\"name\":\"sendConfiguration\",\"type\":\"boolean\",\"default\":false},{\"name\":\"origins\",\"type\":{\"type\":\"array\",\"items\":\"string\"},\"default\":[]},{\"name\":\"renderTime\",\"type\":\"boolean\",\"default\":false},{\"name\":\"clientSideRtbPayload\",\"type\":{\"type\":\"map\",\"values\":\"string\"},\"default\":[]}]}");
    }
    
    public static AdRequest$Builder b() {
        return new AdRequest$Builder((AdRequest$1)null);
    }
    
    @Override
    public fn a() {
        return AdRequest.SCHEMA$;
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
            case 23: {
                return this.x;
            }
            case 24: {
                return this.y;
            }
            case 25: {
                return this.z;
            }
            case 26: {
                return this.A;
            }
            case 27: {
                return this.B;
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
                this.b = (CharSequence)o;
            }
            case 2: {
                this.c = (CharSequence)o;
            }
            case 3: {
                this.d = (long)o;
            }
            case 4: {
                this.e = (List)o;
            }
            case 5: {
                this.f = (Location)o;
            }
            case 6: {
                this.g = (boolean)o;
            }
            case 7: {
                this.h = (List)o;
            }
            case 8: {
                this.i = (AdViewContainer)o;
            }
            case 9: {
                this.j = (CharSequence)o;
            }
            case 10: {
                this.k = (CharSequence)o;
            }
            case 11: {
                this.l = (CharSequence)o;
            }
            case 12: {
                this.m = (CharSequence)o;
            }
            case 13: {
                this.n = (TestAds)o;
            }
            case 14: {
                this.o = (Map)o;
            }
            case 15: {
                this.p = (boolean)o;
            }
            case 16: {
                this.q = (boolean)o;
            }
            case 17: {
                this.r = (int)o;
            }
            case 18: {
                this.s = (List)o;
            }
            case 19: {
                this.t = (boolean)o;
            }
            case 20: {
                this.u = (CharSequence)o;
            }
            case 21: {
                this.v = (List)o;
            }
            case 22: {
                this.w = (CharSequence)o;
            }
            case 23: {
                this.x = (TargetingOverride)o;
            }
            case 24: {
                this.y = (boolean)o;
            }
            case 25: {
                this.z = (List)o;
            }
            case 26: {
                this.A = (boolean)o;
            }
            case 27: {
                this.B = (Map)o;
            }
        }
    }
    
    public void a(final TestAds n) {
        this.n = n;
    }
    
    public void a(final Boolean b) {
        this.p = b;
    }
    
    public void a(final CharSequence c) {
        this.c = c;
    }
    
    public void a(final Map o) {
        this.o = o;
    }
    
    public void b(final Map b) {
        this.B = b;
    }
}
