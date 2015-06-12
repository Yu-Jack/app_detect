// 
// Decompiled by Procyon v0.5.29
// 

package com.flurry.sdk;

import com.flurry.android.impl.ads.avro.protocol.v10.ScreenOrientationType;
import java.util.List;
import com.flurry.android.impl.ads.avro.protocol.v10.AdFrame;
import com.flurry.android.impl.ads.avro.protocol.v10.AdUnit;
import com.flurry.android.AdCreative;
import com.flurry.android.impl.ads.avro.protocol.v10.AdSpaceLayout;

public final class cc
{
    public static AdCreative a(final AdSpaceLayout adSpaceLayout) {
        if (adSpaceLayout == null) {
            return null;
        }
        return new AdCreative(adSpaceLayout.c(), adSpaceLayout.b(), adSpaceLayout.e().toString(), adSpaceLayout.d().toString(), adSpaceLayout.f().toString());
    }
    
    public static AdCreative a(final AdUnit adUnit) {
        if (adUnit == null) {
            return null;
        }
        final List d = adUnit.d();
        if (d == null || d.isEmpty()) {
            return null;
        }
        final AdFrame adFrame = d.get(0);
        if (adFrame == null) {
            return null;
        }
        final AdSpaceLayout e = adFrame.e();
        if (e == null) {
            return null;
        }
        return a(e);
    }
    
    public static ScreenOrientationType a() {
        final int i = fc.i();
        if (i == 1) {
            return ScreenOrientationType.a;
        }
        if (i == 2) {
            return ScreenOrientationType.b;
        }
        return ScreenOrientationType.c;
    }
}
