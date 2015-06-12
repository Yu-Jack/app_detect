// 
// Decompiled by Procyon v0.5.29
// 

package com.flurry.sdk;

import android.content.Context;
import android.content.pm.PackageManager$NameNotFoundException;
import android.content.ComponentName;
import android.content.pm.PackageManager;
import android.annotation.TargetApi;
import android.content.pm.ActivityInfo;
import com.flurry.android.impl.ads.avro.protocol.v10.ScreenOrientationType;
import android.util.SparseIntArray;
import android.app.Activity;
import android.util.SparseArray;

public final class cb
{
    private static final String a;
    private static final SparseArray b;
    
    static {
        a = cb.class.getSimpleName();
        b = c();
    }
    
    public static int a() {
        return 7;
    }
    
    public static int a(final Activity activity, final int n, final int n2) {
        if (activity == null) {
            return -1;
        }
        final SparseIntArray sparseIntArray = (SparseIntArray)cb.b.get(n2);
        int value;
        if (sparseIntArray != null) {
            value = sparseIntArray.get(n, -1);
        }
        else {
            value = -1;
        }
        return value;
    }
    
    public static int a(final Activity activity, final ScreenOrientationType screenOrientationType) {
        int n;
        if (ScreenOrientationType.a.equals(screenOrientationType)) {
            n = 1;
        }
        else {
            final boolean equals = ScreenOrientationType.b.equals(screenOrientationType);
            n = 0;
            if (equals) {
                n = 2;
            }
        }
        return a(activity, -1, n);
    }
    
    @TargetApi(13)
    public static int a(final ActivityInfo activityInfo) {
        int configChanges;
        if (activityInfo == null) {
            configChanges = 0;
        }
        else {
            configChanges = activityInfo.configChanges;
            if (activityInfo.applicationInfo.targetSdkVersion < 13) {
                return configChanges | 0xC00;
            }
        }
        return configChanges;
    }
    
    public static ActivityInfo a(final Activity activity) {
        if (activity == null) {
            return null;
        }
        return a(activity.getPackageManager(), activity.getComponentName());
    }
    
    public static ActivityInfo a(final PackageManager packageManager, final ComponentName obj) {
        if (packageManager == null || obj == null) {
            return null;
        }
        try {
            return packageManager.getActivityInfo(obj, 0);
        }
        catch (PackageManager$NameNotFoundException ex) {
            eo.a(5, cb.a, "cannot find info for activity: " + obj);
            return null;
        }
    }
    
    public static void a(final Activity activity, final int n) {
        if (activity == null) {
            eo.b(cb.a, "Context is null. Cannot set requested orientation.");
            return;
        }
        if (a((Context)activity)) {
            eo.b(cb.a, "setRequestedOrientation SCREEN_ORIENTATION_SENSOR");
            activity.setRequestedOrientation(4);
            return;
        }
        eo.b(cb.a, "setRequestedOrientation " + n);
        activity.setRequestedOrientation(n);
    }
    
    public static boolean a(final Activity activity, int n, boolean b) {
        boolean b2 = true;
        if (activity == null) {
            b2 = false;
        }
        else {
            if (!b(activity)) {
                final int b3 = b(activity, n);
                if (-1 == b3) {
                    eo.a(5, cb.a, "cannot set requested orientation without restarting activity, requestedOrientation = " + n);
                    eo.b(cb.a, "cannot set requested orientation without restarting activity. It is recommended to add keyboardHidden|orientation|screenSize for android:configChanges attribute for activity: " + activity.getComponentName().getClassName());
                    return false;
                }
                n = b3;
                b = b2;
            }
            activity.setRequestedOrientation(n);
            if (!b) {
                activity.setRequestedOrientation(-1);
                return b2;
            }
        }
        return b2;
    }
    
    public static boolean a(final Context context) {
        final boolean b = (0xF & context.getResources().getConfiguration().screenLayout) >= 3;
        eo.b(cb.a, "isTablet " + b);
        return b;
    }
    
    public static int b() {
        return 6;
    }
    
    public static int b(final Activity activity, final int n) {
        if (activity == null) {
            return -1;
        }
        return a(activity, n, activity.getResources().getConfiguration().orientation);
    }
    
    public static boolean b(final Activity activity) {
        final int a = a(a(activity));
        return (a & 0x80) != 0x0 && (a & 0x400) != 0x0;
    }
    
    private static SparseArray c() {
        final SparseArray sparseArray = new SparseArray();
        sparseArray.put(1, (Object)d());
        sparseArray.put(2, (Object)e());
        return sparseArray;
    }
    
    private static SparseIntArray d() {
        final int a = a();
        final SparseIntArray sparseIntArray = new SparseIntArray();
        sparseIntArray.put(-1, a);
        sparseIntArray.put(2, a);
        sparseIntArray.put(3, a);
        sparseIntArray.put(4, a);
        sparseIntArray.put(1, 1);
        sparseIntArray.put(5, 5);
        sparseIntArray.put(7, 7);
        sparseIntArray.put(9, 9);
        sparseIntArray.put(10, 7);
        return sparseIntArray;
    }
    
    private static SparseIntArray e() {
        final int b = b();
        final SparseIntArray sparseIntArray = new SparseIntArray();
        sparseIntArray.put(-1, b);
        sparseIntArray.put(2, b);
        sparseIntArray.put(3, b);
        sparseIntArray.put(4, b);
        sparseIntArray.put(0, 0);
        sparseIntArray.put(5, 5);
        sparseIntArray.put(6, 6);
        sparseIntArray.put(8, 8);
        sparseIntArray.put(10, 6);
        return sparseIntArray;
    }
}
