// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import java.util.Iterator;
import android.os.Build$VERSION;
import android.content.pm.PackageManager$NameNotFoundException;
import android.os.SystemClock;
import java.util.HashMap;
import java.util.ArrayList;
import android.content.Context;

public final class cm extends co
{
    private String a;
    private Context b;
    private String c;
    private ArrayList<String> d;
    
    public cm(final String c, final ArrayList<String> d, final Context b, final String a) {
        this.c = c;
        this.d = d;
        this.a = a;
        this.b = b;
    }
    
    private void b() {
        try {
            this.b.getClassLoader().loadClass("com.google.ads.conversiontracking.IAPConversionReporter").getDeclaredMethod("reportWithProductId", Context.class, String.class, String.class, Boolean.TYPE).invoke(null, this.b, this.c, "", true);
        }
        catch (ClassNotFoundException ex2) {
            en.e("Google Conversion Tracking SDK 1.2.0 or above is required to report a conversion.");
        }
        catch (NoSuchMethodException ex3) {
            en.e("Google Conversion Tracking SDK 1.2.0 or above is required to report a conversion.");
        }
        catch (Exception ex) {
            en.c("Fail to report a conversion.", ex);
        }
    }
    
    protected int a(final int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 2;
        }
        if (n == 4) {
            return 3;
        }
        return 0;
    }
    
    public String a() {
        return this.c;
    }
    
    protected String a(String replaceAll, final HashMap<String, String> hashMap) {
        final String packageName = this.b.getPackageName();
        String versionName;
        long l;
        while (true) {
            try {
                versionName = this.b.getPackageManager().getPackageInfo(packageName, 0).versionName;
                l = SystemClock.elapsedRealtime() - dy.d().a();
                for (final String key : hashMap.keySet()) {
                    replaceAll = replaceAll.replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", key), String.format("$1%s$2", hashMap.get(key)));
                }
            }
            catch (PackageManager$NameNotFoundException ex) {
                en.c("Error to retrieve app version", (Throwable)ex);
                versionName = "";
                continue;
            }
            break;
        }
        return replaceAll.replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", "sessionid"), String.format("$1%s$2", dy.a)).replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", "appid"), String.format("$1%s$2", packageName)).replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", "osversion"), String.format("$1%s$2", String.valueOf(Build$VERSION.SDK_INT))).replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", "sdkversion"), String.format("$1%s$2", this.a)).replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", "appversion"), String.format("$1%s$2", versionName)).replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", "timestamp"), String.format("$1%s$2", String.valueOf(l))).replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", "[^@]+"), String.format("$1%s$2", "")).replaceAll("@@", "@");
    }
    
    public void b(final int i) {
        if (i == 1) {
            this.b();
        }
        final HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("status", String.valueOf(i));
        hashMap.put("sku", this.c);
        final Iterator<String> iterator = this.d.iterator();
        while (iterator.hasNext()) {
            new el(this.b, this.a, this.a(iterator.next(), hashMap)).e();
        }
    }
    
    public void c(final int i) {
        if (i == 0) {
            this.b();
        }
        final HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("google_play_status", String.valueOf(i));
        hashMap.put("sku", this.c);
        hashMap.put("status", String.valueOf(this.a(i)));
        final Iterator<String> iterator = this.d.iterator();
        while (iterator.hasNext()) {
            new el(this.b, this.a, this.a(iterator.next(), hashMap)).e();
        }
    }
}
