// 
// Decompiled by Procyon v0.5.29
// 

package com.flurry.android;

import java.util.Map;
import android.os.Looper;
import android.view.ViewGroup;
import android.content.Context;
import com.flurry.android.impl.ads.FlurryAdModule;
import com.flurry.sdk.dz;
import com.flurry.sdk.eo;
import android.os.Build$VERSION;

public class FlurryAds
{
    private static final String a;
    
    static {
        a = FlurryAds.class.getSimpleName();
    }
    
    public static void clearLocation() {
        if (Build$VERSION.SDK_INT < 10) {
            eo.b(FlurryAds.a, "Device SDK Version older than 10");
            return;
        }
        dz.a().e();
    }
    
    public static void clearTargetingKeywords() {
        if (Build$VERSION.SDK_INT < 10) {
            eo.b(FlurryAds.a, "Device SDK Version older than 10");
            return;
        }
        FlurryAdModule.getInstance().A();
    }
    
    public static void clearUserCookies() {
        if (Build$VERSION.SDK_INT < 10) {
            eo.b(FlurryAds.a, "Device SDK Version older than 10");
            return;
        }
        FlurryAdModule.getInstance().y();
    }
    
    public static void displayAd(final Context context, final String s, final ViewGroup viewGroup) {
        if (Build$VERSION.SDK_INT < 10) {
            eo.b(FlurryAds.a, "Device SDK Version older than 10");
            return;
        }
        if (context == null) {
            eo.b(FlurryAds.a, "Context passed to displayAd was null.");
            return;
        }
        if (s == null) {
            eo.b(FlurryAds.a, "Ad space name passed to displayAd was null.");
            return;
        }
        if (s.length() == 0) {
            eo.b(FlurryAds.a, "Ad space name passed to displayAd was empty.");
            return;
        }
        if (viewGroup == null) {
            eo.b(FlurryAds.a, "ViewGroup passed to displayAd was null.");
            return;
        }
        try {
            FlurryAdModule.getInstance().d().a(context, s, viewGroup);
        }
        catch (Throwable t) {
            eo.a(FlurryAds.a, "Exception while displaying Ad: ", t);
        }
    }
    
    public static void enableTestAds(final boolean b) {
        if (Build$VERSION.SDK_INT < 10) {
            eo.b(FlurryAds.a, "Device SDK Version older than 10");
            return;
        }
        FlurryAdModule.getInstance().a(b);
    }
    
    public static void fetchAd(final Context context, final String s, final ViewGroup viewGroup, final FlurryAdSize flurryAdSize) {
        if (Build$VERSION.SDK_INT < 10) {
            eo.b(FlurryAds.a, "Device SDK Version older than 10");
            return;
        }
        if (context == null) {
            eo.b(FlurryAds.a, "Context passed to fetchAd was null.");
            return;
        }
        if (s == null) {
            eo.b(FlurryAds.a, "Ad space name passed to fetchAd was null.");
            return;
        }
        if (s.length() == 0) {
            eo.b(FlurryAds.a, "Ad space name passed to fetchAd was empty.");
            return;
        }
        if (viewGroup == null) {
            eo.b(FlurryAds.a, "ViewGroup passed to fetchAd was null.");
            return;
        }
        if (flurryAdSize == null) {
            eo.b(FlurryAds.a, "FlurryAdSize passed to fetchAd was null.");
            return;
        }
        try {
            FlurryAdModule.getInstance().d().a(context, s, viewGroup, flurryAdSize, false);
        }
        catch (Throwable t) {
            eo.a(FlurryAds.a, "Exception while fetching Ad: ", t);
        }
    }
    
    @Deprecated
    public static boolean getAd(final Context context, final String s, final ViewGroup viewGroup, final FlurryAdSize flurryAdSize, final long n) {
        if (Build$VERSION.SDK_INT < 10) {
            eo.b(FlurryAds.a, "Device SDK Version older than 10");
            return false;
        }
        if (context == null) {
            eo.b(FlurryAds.a, "Context passed to getAd was null.");
            return false;
        }
        if (s == null) {
            eo.b(FlurryAds.a, "Ad space name passed to getAd was null.");
            return false;
        }
        if (s.length() == 0) {
            eo.b(FlurryAds.a, "Ad space name passed to getAd was empty.");
            return false;
        }
        if (viewGroup == null) {
            eo.b(FlurryAds.a, "ViewGroup passed to getAd was null.");
            return false;
        }
        if (flurryAdSize == null) {
            eo.b(FlurryAds.a, "FlurryAdSize passed to getAd was null.");
            return false;
        }
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            eo.b(FlurryAds.a, "getAd must be called from UI thread.");
            return false;
        }
        try {
            return FlurryAdModule.getInstance().d().a(context, s, viewGroup, flurryAdSize);
        }
        catch (Throwable t) {
            eo.a(FlurryAds.a, "Exception while getting Ad : ", t);
            return false;
        }
    }
    
    @Deprecated
    public static void initializeAds(final Context context) {
    }
    
    @Deprecated
    public static boolean isAdAvailable(final Context context, final String s, final FlurryAdSize flurryAdSize, final long n) {
        if (Build$VERSION.SDK_INT < 10) {
            eo.b(FlurryAds.a, "Device SDK Version older than 10");
            return false;
        }
        if (context == null) {
            eo.b(FlurryAds.a, "Context passed to isAdAvailable was null.");
            return false;
        }
        if (s == null) {
            eo.b(FlurryAds.a, "Ad space name passed to isAdAvailable was null.");
            return false;
        }
        if (s.length() == 0) {
            eo.b(FlurryAds.a, "Ad space name passed to isAdAvailable was empty.");
            return false;
        }
        if (flurryAdSize == null) {
            eo.b(FlurryAds.a, "FlurryAdSize passed to isAdAvailable was null.");
            return false;
        }
        try {
            return FlurryAdModule.getInstance().d().a(context, s, flurryAdSize);
        }
        catch (Throwable t) {
            eo.a(FlurryAds.a, "Exception while checking Ads if available: ", t);
            return false;
        }
    }
    
    public static boolean isAdReady(final String s) {
        if (Build$VERSION.SDK_INT < 10) {
            eo.b(FlurryAds.a, "Device SDK Version older than 10");
            return false;
        }
        if (s == null) {
            eo.b(FlurryAds.a, "Ad space name passed to isAdReady was null.");
            return false;
        }
        if (s.length() == 0) {
            eo.b(FlurryAds.a, "Ad space name passed to isAdReady was empty.");
            return false;
        }
        return FlurryAdModule.getInstance().d().a(s);
    }
    
    public static void removeAd(final Context context, final String s, final ViewGroup viewGroup) {
        if (Build$VERSION.SDK_INT < 10) {
            eo.b(FlurryAds.a, "Device SDK Version older than 10");
            return;
        }
        if (context == null) {
            eo.b(FlurryAds.a, "Context passed to removeAd was null.");
            return;
        }
        if (s == null) {
            eo.b(FlurryAds.a, "Ad space name passed to removeAd was null.");
            return;
        }
        if (s.length() == 0) {
            eo.b(FlurryAds.a, "Ad space name passed to removeAd was empty.");
            return;
        }
        if (viewGroup == null) {
            eo.b(FlurryAds.a, "ViewGroup passed to removeAd was null.");
            return;
        }
        try {
            FlurryAdModule.getInstance().d().a(context, s);
        }
        catch (Throwable t) {
            eo.a(FlurryAds.a, "Exception while removing Ad: ", t);
        }
    }
    
    public static void setAdListener(final FlurryAdListener flurryAdListener) {
        if (Build$VERSION.SDK_INT < 10) {
            eo.b(FlurryAds.a, "Device SDK Version older than 10");
            return;
        }
        FlurryAdModule.getInstance().a(flurryAdListener);
    }
    
    public static void setAdLogUrl(final String s) {
        if (Build$VERSION.SDK_INT < 10) {
            eo.b(FlurryAds.a, "Device SDK Version older than 10");
            return;
        }
        FlurryAdModule.getInstance().f(s);
    }
    
    public static void setAdServerUrl(final String s) {
        if (Build$VERSION.SDK_INT < 10) {
            eo.b(FlurryAds.a, "Device SDK Version older than 10");
            return;
        }
        FlurryAdModule.getInstance().e(s);
    }
    
    public static void setCustomAdNetworkHandler(final ICustomAdNetworkHandler customAdNetworkHandler) {
        if (Build$VERSION.SDK_INT < 10) {
            eo.b(FlurryAds.a, "Device SDK Version older than 10");
            return;
        }
        if (customAdNetworkHandler == null) {
            eo.b(FlurryAds.a, "ICustomAdNetworkHandler passed to setCustomAdNetworkHandler was null.");
            return;
        }
        FlurryAdModule.getInstance().a(customAdNetworkHandler);
    }
    
    public static void setLocation(final float n, final float n2) {
        if (Build$VERSION.SDK_INT < 10) {
            eo.b(FlurryAds.a, "Device SDK Version older than 10");
            return;
        }
        dz.a().a(n, n2);
    }
    
    public static void setTargetingKeywords(final Map map) {
        if (Build$VERSION.SDK_INT < 10) {
            eo.b(FlurryAds.a, "Device SDK Version older than 10");
        }
        else {
            if (map == null) {
                eo.b(FlurryAds.a, "targetingKeywords Map passed to setTargetingKeywords was null.");
                return;
            }
            if (map != null) {
                FlurryAdModule.getInstance().b(map);
            }
        }
    }
    
    public static void setUserCookies(final Map map) {
        if (Build$VERSION.SDK_INT < 10) {
            eo.b(FlurryAds.a, "Device SDK Version older than 10");
            return;
        }
        if (map == null) {
            eo.b(FlurryAds.a, "userCookies Map passed to setUserCookies was null.");
            return;
        }
        FlurryAdModule.getInstance().a(map);
    }
}
