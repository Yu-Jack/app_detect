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

public final class ct extends db$a
{
    private String lr;
    private Context mContext;
    private String pf;
    private ArrayList pg;
    
    public ct(final String pf, final ArrayList pg, final Context mContext, final String lr) {
        this.pf = pf;
        this.pg = pg;
        this.lr = lr;
        this.mContext = mContext;
    }
    
    private void bj() {
        try {
            this.mContext.getClassLoader().loadClass("com.google.ads.conversiontracking.IAPConversionReporter").getDeclaredMethod("reportWithProductId", Context.class, String.class, String.class, Boolean.TYPE).invoke(null, this.mContext, this.pf, "", true);
        }
        catch (ClassNotFoundException ex2) {
            eu.D("Google Conversion Tracking SDK 1.2.0 or above is required to report a conversion.");
        }
        catch (NoSuchMethodException ex3) {
            eu.D("Google Conversion Tracking SDK 1.2.0 or above is required to report a conversion.");
        }
        catch (Exception ex) {
            eu.c("Fail to report a conversion.", ex);
        }
    }
    
    protected String a(String replaceAll, final HashMap hashMap) {
        final String packageName = this.mContext.getPackageName();
        String versionName;
        long l;
        while (true) {
            try {
                versionName = this.mContext.getPackageManager().getPackageInfo(packageName, 0).versionName;
                l = SystemClock.elapsedRealtime() - eh.bK().bO();
                for (final String key : hashMap.keySet()) {
                    replaceAll = replaceAll.replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", key), String.format("$1%s$2", hashMap.get(key)));
                }
            }
            catch (PackageManager$NameNotFoundException ex) {
                eu.c("Error to retrieve app version", (Throwable)ex);
                versionName = "";
                continue;
            }
            break;
        }
        return replaceAll.replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", "sessionid"), String.format("$1%s$2", eh.rQ)).replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", "appid"), String.format("$1%s$2", packageName)).replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", "osversion"), String.format("$1%s$2", String.valueOf(Build$VERSION.SDK_INT))).replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", "sdkversion"), String.format("$1%s$2", this.lr)).replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", "appversion"), String.format("$1%s$2", versionName)).replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", "timestamp"), String.format("$1%s$2", String.valueOf(l))).replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", "[^@]+"), String.format("$1%s$2", "")).replaceAll("@@", "@");
    }
    
    public String getProductId() {
        return this.pf;
    }
    
    protected int l(final int n) {
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
    
    public void recordPlayBillingResolution(final int i) {
        if (i == 0) {
            this.bj();
        }
        final HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("google_play_status", String.valueOf(i));
        hashMap.put("sku", this.pf);
        hashMap.put("status", String.valueOf(this.l(i)));
        final Iterator<String> iterator = (Iterator<String>)this.pg.iterator();
        while (iterator.hasNext()) {
            new es(this.mContext, this.lr, this.a(iterator.next(), hashMap)).start();
        }
    }
    
    public void recordResolution(final int i) {
        if (i == 1) {
            this.bj();
        }
        final HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("status", String.valueOf(i));
        hashMap.put("sku", this.pf);
        final Iterator<String> iterator = (Iterator<String>)this.pg.iterator();
        while (iterator.hasNext()) {
            new es(this.mContext, this.lr, this.a(iterator.next(), hashMap)).start();
        }
    }
}
