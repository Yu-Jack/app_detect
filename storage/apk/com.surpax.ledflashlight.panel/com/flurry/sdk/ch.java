// 
// Decompiled by Procyon v0.5.29
// 

package com.flurry.sdk;

import android.annotation.TargetApi;
import android.os.Build$VERSION;
import android.view.Window;

public final class ch
{
    @TargetApi(11)
    public static void a(final Window window) {
        if (window != null && Build$VERSION.SDK_INT >= 11) {
            window.setFlags(16777216, 16777216);
        }
    }
}
