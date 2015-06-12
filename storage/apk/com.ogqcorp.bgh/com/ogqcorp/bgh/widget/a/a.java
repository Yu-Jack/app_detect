// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.widget.a;

import android.content.pm.PackageManager;
import android.content.pm.PackageManager$NameNotFoundException;
import android.content.ComponentName;
import android.content.Intent;
import android.content.Context;

public final class a
{
    private static final String[][] a;
    
    static {
        a = new String[][] { { "HTC Alarm ClockDT", "com.htc.android.worldclock", "com.htc.android.worldclock.WorldClockTabControl" }, { "Standar Alarm ClockDT", "com.android.deskclock", "com.android.deskclock.AlarmClock" }, { "Froyo Nexus Alarm ClockDT", "com.google.android.deskclock", "com.android.deskclock.DeskClock" }, { "Moto Blur Alarm ClockDT", "com.motorola.blur.alarmclock", "com.motorola.blur.alarmclock.AlarmClock" }, { "Samsung Galaxy S", "com.sec.android.app.clockpackage", "com.sec.android.app.clockpackage.ClockPackage" } };
    }
    
    public static final Intent a(final Context context) {
        final PackageManager packageManager = context.getPackageManager();
        final Intent addCategory = new Intent("android.intent.action.MAIN").addCategory("android.intent.category.LAUNCHER");
        final String[][] a = com.ogqcorp.bgh.widget.a.a.a;
        final int length = a.length;
        int i = 0;
        while (i < length) {
            final String[] array = a[i];
            try {
                final ComponentName component = new ComponentName(array[1], array[2]);
                packageManager.getActivityInfo(component, 128);
                addCategory.setComponent(component);
                return addCategory;
            }
            catch (PackageManager$NameNotFoundException ex) {
                ++i;
                continue;
            }
            break;
        }
        return null;
    }
}
