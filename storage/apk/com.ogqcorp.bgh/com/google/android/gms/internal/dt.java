// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.content.pm.PackageInfo;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager$NameNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.content.pm.ResolveInfo;
import android.net.NetworkInfo;
import android.content.pm.PackageManager;
import android.util.DisplayMetrics;
import android.telephony.TelephonyManager;
import java.util.Locale;
import android.net.ConnectivityManager;
import android.media.AudioManager;
import android.content.Context;

public final class dt
{
    public final int a;
    public final boolean b;
    public final boolean c;
    public final String d;
    public final String e;
    public final boolean f;
    public final boolean g;
    public final boolean h;
    public final String i;
    public final String j;
    public final int k;
    public final int l;
    public final int m;
    public final int n;
    public final int o;
    public final int p;
    public final float q;
    public final int r;
    public final int s;
    
    public dt(final Context context) {
        boolean c = true;
        final AudioManager audioManager = (AudioManager)context.getSystemService("audio");
        final ConnectivityManager connectivityManager = (ConnectivityManager)context.getSystemService("connectivity");
        final DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        final Locale default1 = Locale.getDefault();
        final PackageManager packageManager = context.getPackageManager();
        final TelephonyManager telephonyManager = (TelephonyManager)context.getSystemService("phone");
        this.a = audioManager.getMode();
        this.b = (a(packageManager, "geo:0,0?q=donuts") != null && c);
        if (a(packageManager, "http://www.google.com") == null) {
            c = false;
        }
        this.c = c;
        this.d = telephonyManager.getNetworkOperator();
        this.e = default1.getCountry();
        this.f = em.a();
        this.g = audioManager.isMusicActive();
        this.h = audioManager.isSpeakerphoneOn();
        this.i = default1.getLanguage();
        this.j = a(packageManager);
        this.k = audioManager.getStreamVolume(3);
        this.l = a(context, connectivityManager, packageManager);
        this.m = telephonyManager.getNetworkType();
        this.n = telephonyManager.getPhoneType();
        this.o = audioManager.getRingerMode();
        this.p = audioManager.getStreamVolume(2);
        this.q = displayMetrics.density;
        this.r = displayMetrics.widthPixels;
        this.s = displayMetrics.heightPixels;
    }
    
    private static int a(final Context context, final ConnectivityManager connectivityManager, final PackageManager packageManager) {
        int type = -2;
        if (eg.a(packageManager, context.getPackageName(), "android.permission.ACCESS_NETWORK_STATE")) {
            final NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return -1;
            }
            type = activeNetworkInfo.getType();
        }
        return type;
    }
    
    private static ResolveInfo a(final PackageManager packageManager, final String s) {
        return packageManager.resolveActivity(new Intent("android.intent.action.VIEW", Uri.parse(s)), 65536);
    }
    
    private static String a(final PackageManager packageManager) {
        final ResolveInfo a = a(packageManager, "market://details?id=com.google.android.gms.ads");
        if (a != null) {
            final ActivityInfo activityInfo = a.activityInfo;
            if (activityInfo != null) {
                try {
                    final PackageInfo packageInfo = packageManager.getPackageInfo(activityInfo.packageName, 0);
                    if (packageInfo != null) {
                        return packageInfo.versionCode + "." + activityInfo.packageName;
                    }
                }
                catch (PackageManager$NameNotFoundException ex) {
                    return null;
                }
            }
        }
        return null;
    }
}
