// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.view.MotionEvent;
import android.os.SystemClock;
import java.util.Map;
import android.util.DisplayMetrics;

public final class an implements aj
{
    private static int a(final DisplayMetrics displayMetrics, final Map<String, String> map, final String str, int a) {
        final String s = map.get(str);
        if (s == null) {
            return a;
        }
        try {
            a = em.a(displayMetrics, Integer.parseInt(s));
            return a;
        }
        catch (NumberFormatException ex) {
            en.e("Could not parse " + str + " in a video GMSG: " + s);
            return a;
        }
    }
    
    @Override
    public void a(final ep ep, final Map<String, String> map) {
        final String s = map.get("action");
        if (s == null) {
            en.e("Action missing from video GMSG.");
            return;
        }
        final bs d = ep.d();
        if (d == null) {
            en.e("Could not get ad overlay for a video GMSG.");
            return;
        }
        final boolean equalsIgnoreCase = "new".equalsIgnoreCase(s);
        final boolean equalsIgnoreCase2 = "position".equalsIgnoreCase(s);
        if (equalsIgnoreCase || equalsIgnoreCase2) {
            final DisplayMetrics displayMetrics = ep.getContext().getResources().getDisplayMetrics();
            final int a = a(displayMetrics, map, "x", 0);
            final int a2 = a(displayMetrics, map, "y", 0);
            final int a3 = a(displayMetrics, map, "w", -1);
            final int a4 = a(displayMetrics, map, "h", -1);
            if (equalsIgnoreCase && d.b() == null) {
                d.b(a, a2, a3, a4);
                return;
            }
            d.a(a, a2, a3, a4);
        }
        else {
            final by b = d.b();
            if (b == null) {
                by.a(ep, "no_video_view", (String)null);
                return;
            }
            if ("click".equalsIgnoreCase(s)) {
                final DisplayMetrics displayMetrics2 = ep.getContext().getResources().getDisplayMetrics();
                final int a5 = a(displayMetrics2, map, "x", 0);
                final int a6 = a(displayMetrics2, map, "y", 0);
                final long uptimeMillis = SystemClock.uptimeMillis();
                final MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, (float)a5, (float)a6, 0);
                b.a(obtain);
                obtain.recycle();
                return;
            }
            if ("controls".equalsIgnoreCase(s)) {
                final String s2 = map.get("enabled");
                if (s2 == null) {
                    en.e("Enabled parameter missing from controls video GMSG.");
                    return;
                }
                b.a(Boolean.parseBoolean(s2));
            }
            else {
                if ("currentTime".equalsIgnoreCase(s)) {
                    final String s3 = map.get("time");
                    if (s3 == null) {
                        en.e("Time parameter missing from currentTime video GMSG.");
                        return;
                    }
                    try {
                        b.a((int)(1000.0f * Float.parseFloat(s3)));
                        return;
                    }
                    catch (NumberFormatException ex) {
                        en.e("Could not parse time parameter from currentTime video GMSG: " + s3);
                        return;
                    }
                }
                if ("hide".equalsIgnoreCase(s)) {
                    b.setVisibility(4);
                    return;
                }
                if ("load".equalsIgnoreCase(s)) {
                    b.b();
                    return;
                }
                if ("pause".equalsIgnoreCase(s)) {
                    b.c();
                    return;
                }
                if ("play".equalsIgnoreCase(s)) {
                    b.d();
                    return;
                }
                if ("show".equalsIgnoreCase(s)) {
                    b.setVisibility(0);
                    return;
                }
                if ("src".equalsIgnoreCase(s)) {
                    b.a(map.get("src"));
                    return;
                }
                en.e("Unknown video action: " + s);
            }
        }
    }
}
