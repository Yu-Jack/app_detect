// 
// Decompiled by Procyon v0.5.29
// 

package com.flurry.android.monolithic.sdk.impl;

import com.flurry.android.impl.ads.avro.protocol.v6.AdUnit;
import com.flurry.android.impl.ads.FlurryAdModule;
import android.widget.RelativeLayout;

public abstract class ac extends RelativeLayout
{
    private static final String e;
    FlurryAdModule a;
    gn b;
    AdUnit c;
    int d;
    
    static {
        e = ac.class.getSimpleName();
    }
    
    public void setAdFrameIndex(final int d) {
        this.d = d;
    }
    
    public void setAdLog(final gn b) {
        this.b = b;
    }
    
    public void setAdUnit(final AdUnit c) {
        this.c = c;
    }
    
    public void setPlatformModule(final FlurryAdModule a) {
        this.a = a;
    }
}
