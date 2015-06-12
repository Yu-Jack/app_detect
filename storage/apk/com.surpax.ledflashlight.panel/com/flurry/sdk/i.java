// 
// Decompiled by Procyon v0.5.29
// 

package com.flurry.sdk;

import java.util.Map;
import com.flurry.android.impl.ads.avro.protocol.v10.AdFrame;
import android.content.Context;
import com.flurry.android.impl.ads.avro.protocol.v10.AdUnit;
import com.flurry.android.impl.ads.FlurryAdModule;
import android.widget.RelativeLayout;

public abstract class i extends RelativeLayout
{
    private static final String a;
    private FlurryAdModule b;
    private e c;
    private AdUnit d;
    private int e;
    
    static {
        a = i.class.getSimpleName();
    }
    
    protected i(final Context context) {
        super(context);
    }
    
    public i(final Context context, final FlurryAdModule b, final e c) {
        super(context);
        this.b = b;
        this.c = c;
    }
    
    boolean g() {
        return !this.d.d().get(this.e).e().e().toString().equals("takeover");
    }
    
    public int getAdFrameIndex() {
        return this.e;
    }
    
    public e getAdLog() {
        return this.c;
    }
    
    public AdUnit getAdUnit() {
        return this.d;
    }
    
    public FlurryAdModule getPlatformModule() {
        return this.b;
    }
    
    public abstract void initLayout();
    
    public void onDestroy() {
    }
    
    public void onEvent(final String str, final Map map) {
        eo.a(3, i.a, "AppSpotBannerView.onEvent " + str);
        if (this.d != null) {
            this.b.a(new q(str, map, this.getContext(), this.d, this.c, this.e), this.b.a(), 0);
            return;
        }
        eo.a(3, i.a, "fAdUnit == null");
    }
    
    public void setAdFrameIndex(final int e) {
        this.e = e;
    }
    
    public void setAdLog(final e c) {
        this.c = c;
    }
    
    public void setAdUnit(final AdUnit d) {
        this.d = d;
    }
    
    public void setPlatformModule(final FlurryAdModule b) {
        this.b = b;
    }
}
