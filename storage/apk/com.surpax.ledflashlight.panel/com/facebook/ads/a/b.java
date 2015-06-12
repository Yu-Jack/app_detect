// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook.ads.a;

import android.content.Intent;
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
import android.hardware.SensorManager;
import android.hardware.SensorEvent;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;

final class b implements SensorEventListener
{
    public final void onAccuracyChanged(final Sensor sensor, final int n) {
    }
    
    public final void onSensorChanged(final SensorEvent sensorEvent) {
        if (sensorEvent.sensor == a.b) {
            a.d = sensorEvent.values;
        }
        else if (sensorEvent.sensor == a.c) {
            a.e = sensorEvent.values;
        }
        a.a(this);
    }
}
