// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.system;

import android.content.pm.PackageManager;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.app.WallpaperManager;
import android.os.Build;
import android.content.Context;

public final class e
{
    public static boolean a(final Context context) {
        if (!h.a().g()) {
            final PackageInfo c = c(context);
            if (c != null) {
                if ("com.sec.android.app.launcher".equals(c.packageName) && c.versionCode >= 16) {
                    return true;
                }
                if ("samsung".equalsIgnoreCase(Build.BRAND) && "android".equals(c.packageName)) {
                    final WallpaperManager instance = WallpaperManager.getInstance(context);
                    if (instance.getDesiredMinimumWidth() > 0 && instance.getDesiredMinimumWidth() == 0 + instance.getDesiredMinimumHeight()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public static boolean b(final Context context) {
        if (!h.a().g()) {
            final PackageInfo c = c(context);
            if (c != null && "com.htc.launcher".equals(c.packageName) && c.versionCode >= 300000000) {
                return true;
            }
        }
        return false;
    }
    
    private static PackageInfo c(final Context context) {
        try {
            final Intent intent = new Intent("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.HOME");
            final PackageManager packageManager = context.getPackageManager();
            return packageManager.getPackageInfo(packageManager.resolveActivity(intent, 65536).activityInfo.packageName, 0);
        }
        catch (Exception ex) {
            l.c(ex);
            return null;
        }
    }
}
