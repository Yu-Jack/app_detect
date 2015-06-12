// 
// Decompiled by Procyon v0.5.29
// 

package com.flurry.sdk;

import android.content.Intent;
import com.flurry.android.FlurryFullscreenTakeoverActivity;
import com.flurry.android.impl.ads.avro.protocol.v10.AdUnit;
import com.flurry.android.impl.ads.FlurryAdModule;
import android.content.Context;

public final class ab extends aj
{
    public ab(final Context context, final FlurryAdModule flurryAdModule, final e e, final AdUnit adUnit) {
        super(context, flurryAdModule, e, adUnit);
    }
    
    @Override
    public final void a() {
        if (!this.c().a().a(this.b(), new Intent(do.a().b(), (Class)FlurryFullscreenTakeoverActivity.class), this.e().b().toString())) {
            eo.b(ab.a, "Unable to launch FlurryFullscreenTakeoverActivity. Fix by declaring this Activity in your AndroidManifest.xml");
        }
    }
}
