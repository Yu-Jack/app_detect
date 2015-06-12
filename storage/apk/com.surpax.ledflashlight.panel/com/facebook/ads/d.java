// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook.ads;

import android.content.SharedPreferences;
import android.util.Log;
import java.util.UUID;
import com.facebook.ads.a.ab;
import android.os.Build;
import android.content.Context;
import java.util.HashSet;
import java.util.Collection;

public class d
{
    public static final String a;
    static volatile boolean b;
    private static final Collection c;
    private static final Collection d;
    private static String e;
    private static boolean f;
    private static String g;
    
    static {
        a = d.class.getSimpleName();
        com.facebook.ads.d.e = null;
        com.facebook.ads.d.f = false;
        com.facebook.ads.d.g = null;
        c = new HashSet();
        (d = new HashSet()).add("sdk");
        com.facebook.ads.d.d.add("google_sdk");
        com.facebook.ads.d.d.add("vbox86p");
        com.facebook.ads.d.d.add("vbox86tp");
        com.facebook.ads.d.b = false;
    }
    
    public static String a() {
        return com.facebook.ads.d.e;
    }
    
    public static void a(final String s) {
        com.facebook.ads.d.c.add(s);
    }
    
    public static boolean a(final Context context) {
        if (!com.facebook.ads.d.d.contains(Build.PRODUCT)) {
            if (com.facebook.ads.d.g == null) {
                final SharedPreferences sharedPreferences = context.getSharedPreferences("FBAdPrefs", 0);
                if (ab.a(com.facebook.ads.d.g = sharedPreferences.getString("deviceIdHash", (String)null))) {
                    com.facebook.ads.d.g = ab.b(UUID.randomUUID().toString());
                    sharedPreferences.edit().putString("deviceIdHash", com.facebook.ads.d.g).commit();
                }
            }
            if (!com.facebook.ads.d.c.contains(com.facebook.ads.d.g)) {
                final String g = com.facebook.ads.d.g;
                if (!com.facebook.ads.d.b) {
                    com.facebook.ads.d.b = true;
                    Log.d(com.facebook.ads.d.a, "Test mode device hash: " + g);
                    Log.d(com.facebook.ads.d.a, "When testing your app with Facebook's ad units you must specify the device hashed ID to ensure the delivery of test ads, add the following code before loading an ad: AdSettings.addTestDevice(\"" + g + "\");");
                }
                return false;
            }
        }
        return true;
    }
    
    public static boolean b() {
        return com.facebook.ads.d.f;
    }
}
