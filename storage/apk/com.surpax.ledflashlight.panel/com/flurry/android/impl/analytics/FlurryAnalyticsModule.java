// 
// Decompiled by Procyon v0.5.29
// 

package com.flurry.android.impl.analytics;

import android.content.Context;
import com.flurry.sdk.dj;
import com.flurry.sdk.dd;
import com.flurry.sdk.et;

public class FlurryAnalyticsModule implements et
{
    private static FlurryAnalyticsModule a;
    private dd b;
    
    public static FlurryAnalyticsModule getInstance() {
        synchronized (FlurryAnalyticsModule.class) {
            if (FlurryAnalyticsModule.a == null) {
                FlurryAnalyticsModule.a = new FlurryAnalyticsModule();
            }
            return FlurryAnalyticsModule.a;
        }
    }
    
    public dd a() {
        return this.b;
    }
    
    @Override
    public void a(final dj dj) {
    }
    
    @Override
    public void a(final dj dj, final Context context) {
        if (this.b == null) {
            this.b = new dd();
        }
    }
    
    @Override
    public void b(final dj dj, final Context context) {
    }
    
    @Override
    public void c(final dj dj, final Context context) {
    }
}
