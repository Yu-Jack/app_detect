// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook.ads.a;

import android.content.Intent;
import android.hardware.SensorEventListener;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.os.StatFs;
import android.os.Environment;
import android.app.ActivityManager;
import android.app.ActivityManager$MemoryInfo;
import android.content.Context;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;
import android.hardware.Sensor;
import android.hardware.SensorManager;

public final class a
{
    private static SensorManager a;
    private static Sensor b;
    private static Sensor c;
    private static volatile float[] d;
    private static volatile float[] e;
    private static Map f;
    private static String[] g;
    
    static {
        com.facebook.ads.a.a.a = null;
        com.facebook.ads.a.a.b = null;
        com.facebook.ads.a.a.c = null;
        com.facebook.ads.a.a.f = new ConcurrentHashMap();
        com.facebook.ads.a.a.g = new String[] { "x", "y", "z" };
    }
    
    public static Map a() {
        final HashMap hashMap = new HashMap();
        hashMap.putAll(com.facebook.ads.a.a.f);
        a(hashMap);
        return hashMap;
    }
    
    public static void a(final Context context) {
        while (true) {
            while (true) {
                Label_0356: {
                    synchronized (a.class) {
                        final ActivityManager$MemoryInfo activityManager$MemoryInfo = new ActivityManager$MemoryInfo();
                        ((ActivityManager)context.getSystemService("activity")).getMemoryInfo(activityManager$MemoryInfo);
                        com.facebook.ads.a.a.f.put("available_memory", String.valueOf(activityManager$MemoryInfo.availMem));
                        final StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                        com.facebook.ads.a.a.f.put("free_space", statFs.getBlockSize() * statFs.getAvailableBlocks());
                        final Intent registerReceiver = context.registerReceiver((BroadcastReceiver)null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
                        if (registerReceiver != null) {
                            final int intExtra = registerReceiver.getIntExtra("level", -1);
                            final int intExtra2 = registerReceiver.getIntExtra("scale", -1);
                            final int intExtra3 = registerReceiver.getIntExtra("status", -1);
                            if (intExtra3 == 2) {
                                break Label_0356;
                            }
                            if (intExtra3 == 5) {
                                break Label_0356;
                            }
                            final int n = 0;
                            float f = 0.0f;
                            if (intExtra2 > 0) {
                                f = 100.0f * (intExtra / intExtra2);
                            }
                            com.facebook.ads.a.a.f.put("battery", f);
                            final Map f2 = com.facebook.ads.a.a.f;
                            int i;
                            if (n != 0) {
                                i = 1;
                            }
                            else {
                                i = 0;
                            }
                            f2.put("charging", i);
                        }
                        if (com.facebook.ads.a.a.a != null || (com.facebook.ads.a.a.a = (SensorManager)context.getSystemService("sensor")) != null) {
                            if (com.facebook.ads.a.a.b == null) {
                                com.facebook.ads.a.a.b = com.facebook.ads.a.a.a.getDefaultSensor(1);
                            }
                            if (com.facebook.ads.a.a.c == null) {
                                com.facebook.ads.a.a.c = com.facebook.ads.a.a.a.getDefaultSensor(4);
                            }
                            if (com.facebook.ads.a.a.b != null) {
                                com.facebook.ads.a.a.a.registerListener((SensorEventListener)new b((byte)0), com.facebook.ads.a.a.b, 3);
                            }
                            if (com.facebook.ads.a.a.c != null) {
                                com.facebook.ads.a.a.a.registerListener((SensorEventListener)new b((byte)0), com.facebook.ads.a.a.c, 3);
                            }
                        }
                        return;
                    }
                }
                final int n = 1;
                continue;
            }
        }
    }
    
    public static void a(final b b) {
        synchronized (a.class) {
            if (com.facebook.ads.a.a.a != null) {
                com.facebook.ads.a.a.a.unregisterListener((SensorEventListener)b);
            }
        }
    }
    
    private static void a(final Map map) {
        final float[] d = com.facebook.ads.a.a.d;
        final float[] e = com.facebook.ads.a.a.e;
        if (d != null) {
            for (int i = 0; i < d.length; ++i) {
                map.put("accelerometer_" + com.facebook.ads.a.a.g[i], d[i]);
            }
        }
        int j = 0;
        if (e != null) {
            while (j < e.length) {
                map.put("rotation_" + com.facebook.ads.a.a.g[j], e[j]);
                ++j;
            }
        }
    }
}
