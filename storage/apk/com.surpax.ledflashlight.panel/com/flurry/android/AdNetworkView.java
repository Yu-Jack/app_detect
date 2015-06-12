// 
// Decompiled by Procyon v0.5.29
// 

package com.flurry.android;

import java.util.Map;
import com.flurry.sdk.e;
import com.flurry.android.impl.ads.FlurryAdModule;
import android.content.Context;
import com.flurry.sdk.i;

public abstract class AdNetworkView extends i
{
    private final AdCreative a;
    
    public AdNetworkView(final Context context, final AdCreative a) {
        super(context, null, null);
        this.a = a;
    }
    
    public AdNetworkView(final Context context, final FlurryAdModule flurryAdModule, final e e, final AdCreative a) {
        super(context, flurryAdModule, e);
        this.a = a;
    }
    
    public AdCreative getAdCreative() {
        return this.a;
    }
    
    public void onAdClicked(final Map map) {
        super.onEvent("clicked", map);
    }
    
    public void onAdClosed(final Map map) {
        super.onEvent("adClosed", map);
    }
    
    public void onAdFilled(final Map map) {
        super.onEvent("filled", map);
    }
    
    public void onAdPrepared(final Map map) {
        super.onEvent("prepared", map);
    }
    
    public void onAdShown(final Map map) {
        super.onEvent("rendered", map);
    }
    
    public void onAdUnFilled(final Map map) {
        super.onEvent("unfilled", map);
    }
    
    public void onRenderFailed(final Map map) {
        super.onEvent("renderFailed", map);
    }
}
