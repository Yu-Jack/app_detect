// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.content.pm.PackageInfo;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager$NameNotFoundException;
import android.net.Uri;
import android.content.pm.ResolveInfo;
import android.net.NetworkInfo;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.util.DisplayMetrics;
import android.os.Build$VERSION;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.telephony.TelephonyManager;
import java.util.Locale;
import android.net.ConnectivityManager;
import android.media.AudioManager;
import android.content.Context;

public final class ec
{
    public final int rb;
    public final boolean rc;
    public final boolean rd;
    public final String re;
    public final String rf;
    public final boolean rg;
    public final boolean rh;
    public final boolean ri;
    public final String rj;
    public final String rk;
    public final int rl;
    public final int rm;
    public final int rn;
    public final int ro;
    public final int rp;
    public final int rq;
    public final float rr;
    public final int rs;
    public final int rt;
    public final double ru;
    public final boolean rv;
    public final boolean rw;
    public final int rx;
    
    public ec(final Context context) {
        boolean rv = true;
        final AudioManager audioManager = (AudioManager)context.getSystemService("audio");
        final ConnectivityManager connectivityManager = (ConnectivityManager)context.getSystemService("connectivity");
        final DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        final Locale default1 = Locale.getDefault();
        final PackageManager packageManager = context.getPackageManager();
        final TelephonyManager telephonyManager = (TelephonyManager)context.getSystemService("phone");
        final Intent registerReceiver = context.registerReceiver((BroadcastReceiver)null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        this.rb = audioManager.getMode();
        this.rc = (a(packageManager, "geo:0,0?q=donuts") != null && rv);
        this.rd = (a(packageManager, "http://www.google.com") != null && rv);
        this.re = telephonyManager.getNetworkOperator();
        this.rf = default1.getCountry();
        this.rg = et.bV();
        this.rh = audioManager.isMusicActive();
        this.ri = audioManager.isSpeakerphoneOn();
        this.rj = default1.getLanguage();
        this.rk = a(packageManager);
        this.rl = audioManager.getStreamVolume(3);
        this.rm = a(context, connectivityManager, packageManager);
        this.rn = telephonyManager.getNetworkType();
        this.ro = telephonyManager.getPhoneType();
        this.rp = audioManager.getRingerMode();
        this.rq = audioManager.getStreamVolume(2);
        this.rr = displayMetrics.density;
        this.rs = displayMetrics.widthPixels;
        this.rt = displayMetrics.heightPixels;
        if (registerReceiver != null) {
            final int intExtra = registerReceiver.getIntExtra("status", -1);
            this.ru = registerReceiver.getIntExtra("level", -1) / registerReceiver.getIntExtra("scale", -1);
            if (intExtra != 2 && intExtra != 5) {
                rv = false;
            }
            this.rv = rv;
        }
        else {
            this.ru = -1.0;
            this.rv = false;
        }
        if (Build$VERSION.SDK_INT < 16) {
            this.rw = false;
            this.rx = -1;
            return;
        }
        this.rw = connectivityManager.isActiveNetworkMetered();
        if (connectivityManager.getActiveNetworkInfo() != null) {
            this.rx = connectivityManager.getActiveNetworkInfo().getDetailedState().ordinal();
            return;
        }
        this.rx = -1;
    }
    
    private static int a(final Context context, final ConnectivityManager connectivityManager, final PackageManager packageManager) {
        int type = -2;
        if (eo.a(packageManager, context.getPackageName(), "android.permission.ACCESS_NETWORK_STATE")) {
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
