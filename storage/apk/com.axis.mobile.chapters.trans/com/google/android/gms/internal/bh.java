// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.view.MotionEvent;
import android.os.SystemClock;
import java.util.Map;
import android.util.DisplayMetrics;

public final class bh implements bc
{
    private static int a(final DisplayMetrics displayMetrics, final Map map, final String str, int a) {
        final String s = map.get(str);
        if (s == null) {
            return a;
        }
        try {
            a = et.a(displayMetrics, Integer.parseInt(s));
            return a;
        }
        catch (NumberFormatException ex) {
            eu.D("Could not parse " + str + " in a video GMSG: " + s);
            return a;
        }
    }
    
    @Override
    public void b(final ex ex, final Map map) {
        final String s = map.get("action");
        if (s == null) {
            eu.D("Action missing from video GMSG.");
            return;
        }
        final cf ca = ex.ca();
        if (ca == null) {
            eu.D("Could not get ad overlay for a video GMSG.");
            return;
        }
        final boolean equalsIgnoreCase = "new".equalsIgnoreCase(s);
        final boolean equalsIgnoreCase2 = "position".equalsIgnoreCase(s);
        if (equalsIgnoreCase || equalsIgnoreCase2) {
            final DisplayMetrics displayMetrics = ex.getContext().getResources().getDisplayMetrics();
            final int a = a(displayMetrics, map, "x", 0);
            final int a2 = a(displayMetrics, map, "y", 0);
            final int a3 = a(displayMetrics, map, "w", -1);
            final int a4 = a(displayMetrics, map, "h", -1);
            if (equalsIgnoreCase && ca.aQ() == null) {
                ca.c(a, a2, a3, a4);
                return;
            }
            ca.b(a, a2, a3, a4);
        }
        else {
            final cj aq = ca.aQ();
            if (aq == null) {
                cj.a(ex, "no_video_view", (String)null);
                return;
            }
            if ("click".equalsIgnoreCase(s)) {
                final DisplayMetrics displayMetrics2 = ex.getContext().getResources().getDisplayMetrics();
                final int a5 = a(displayMetrics2, map, "x", 0);
                final int a6 = a(displayMetrics2, map, "y", 0);
                final long uptimeMillis = SystemClock.uptimeMillis();
                final MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, (float)a5, (float)a6, 0);
                aq.b(obtain);
                obtain.recycle();
                return;
            }
            if ("controls".equalsIgnoreCase(s)) {
                final String s2 = map.get("enabled");
                if (s2 == null) {
                    eu.D("Enabled parameter missing from controls video GMSG.");
                    return;
                }
                aq.l(Boolean.parseBoolean(s2));
            }
            else {
                if ("currentTime".equalsIgnoreCase(s)) {
                    final String s3 = map.get("time");
                    if (s3 == null) {
                        eu.D("Time parameter missing from currentTime video GMSG.");
                        return;
                    }
                    try {
                        aq.seekTo((int)(1000.0f * Float.parseFloat(s3)));
                        return;
                    }
                    catch (NumberFormatException ex2) {
                        eu.D("Could not parse time parameter from currentTime video GMSG: " + s3);
                        return;
                    }
                }
                if ("hide".equalsIgnoreCase(s)) {
                    aq.setVisibility(4);
                    return;
                }
                if ("load".equalsIgnoreCase(s)) {
                    aq.ba();
                    return;
                }
                if ("pause".equalsIgnoreCase(s)) {
                    aq.pause();
                    return;
                }
                if ("play".equalsIgnoreCase(s)) {
                    aq.play();
                    return;
                }
                if ("show".equalsIgnoreCase(s)) {
                    aq.setVisibility(0);
                    return;
                }
                if ("src".equalsIgnoreCase(s)) {
                    aq.o(map.get("src"));
                    return;
                }
                eu.D("Unknown video action: " + s);
            }
        }
    }
}
