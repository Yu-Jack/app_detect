// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.analytics;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager$NameNotFoundException;
import android.content.Context;

class ak implements ar
{
    private static ak e;
    private static Object f;
    protected String a;
    protected String b;
    protected String c;
    protected String d;
    
    static {
        ak.f = new Object();
    }
    
    protected ak() {
    }
    
    private ak(final Context context) {
        final PackageManager packageManager = context.getPackageManager();
        this.c = context.getPackageName();
        this.d = packageManager.getInstallerPackageName(this.c);
        String s = this.c;
        while (true) {
            try {
                final PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
                String versionName = null;
                if (packageInfo != null) {
                    s = packageManager.getApplicationLabel(packageInfo.applicationInfo).toString();
                    versionName = packageInfo.versionName;
                }
                this.a = s;
                this.b = versionName;
            }
            catch (PackageManager$NameNotFoundException ex) {
                p.a("Error retrieving package info: appName set to " + s);
                final String versionName = null;
                continue;
            }
            break;
        }
    }
    
    public static ak a() {
        return ak.e;
    }
    
    public static void a(final Context context) {
        synchronized (ak.f) {
            if (ak.e == null) {
                ak.e = new ak(context);
            }
        }
    }
    
    @Override
    public String a(final String s) {
        if (s != null) {
            if (s.equals("&an")) {
                return this.a;
            }
            if (s.equals("&av")) {
                return this.b;
            }
            if (s.equals("&aid")) {
                return this.c;
            }
            if (s.equals("&aiid")) {
                return this.d;
            }
        }
        return null;
    }
}
