// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.Bundle;
import android.content.pm.PackageManager$NameNotFoundException;
import android.content.ComponentName;
import android.content.Context;

public class ei
{
    private final Object ls;
    private final String rR;
    private int rX;
    private long rY;
    private long rZ;
    private int sa;
    private int sb;
    
    public ei(final String rr) {
        this.ls = new Object();
        this.rX = 0;
        this.rY = -1L;
        this.rZ = -1L;
        this.sa = 0;
        this.sb = -1;
        this.rR = rr;
    }
    
    public static boolean l(final Context context) {
        final int identifier = context.getResources().getIdentifier("Theme.Translucent", "style", "android");
        if (identifier == 0) {
            eu.B("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
            return false;
        }
        final ComponentName componentName = new ComponentName(context.getPackageName(), "com.google.android.gms.ads.AdActivity");
        try {
            if (identifier == context.getPackageManager().getActivityInfo(componentName, 0).theme) {
                return true;
            }
            eu.B("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
            return false;
        }
        catch (PackageManager$NameNotFoundException ex) {
            eu.D("Fail to fetch AdActivity theme");
            eu.B("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
            return false;
        }
    }
    
    public Bundle b(final Context context, final String s) {
        synchronized (this.ls) {
            final Bundle bundle = new Bundle();
            bundle.putString("session_id", this.rR);
            bundle.putLong("basets", this.rZ);
            bundle.putLong("currts", this.rY);
            bundle.putString("seq_num", s);
            bundle.putInt("preqs", this.sb);
            bundle.putInt("pclick", this.rX);
            bundle.putInt("pimp", this.sa);
            bundle.putBoolean("support_transparent_background", l(context));
            return bundle;
        }
    }
    
    public void b(final ai ai, final long n) {
        synchronized (this.ls) {
            if (this.rZ == -1L) {
                this.rZ = n;
                this.rY = this.rZ;
            }
            else {
                this.rY = n;
            }
            if (ai.extras != null && ai.extras.getInt("gw", 2) == 1) {
                return;
            }
        }
        ++this.sb;
    }
    // monitorexit(o)
    
    public void bB() {
        synchronized (this.ls) {
            ++this.sa;
        }
    }
    
    public void bC() {
        synchronized (this.ls) {
            ++this.rX;
        }
    }
    
    public long bO() {
        return this.rZ;
    }
}
