// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

import android.view.Display;
import android.content.Context;
import android.annotation.TargetApi;

@TargetApi(8)
class AndroidTargetUtils$FroyoTargetUtils
{
    protected static String getPackageCodePath(final Context context) {
        return context.getPackageCodePath();
    }
    
    protected static int getRotation(final Display display) {
        return display.getRotation();
    }
}
