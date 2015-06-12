// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.content.Context;

public final class hu
{
    public static boolean a(final Context context) {
        return context.getPackageManager().hasSystemFeature("android.hardware.type.watch");
    }
}
