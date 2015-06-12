// 
// Decompiled by Procyon v0.5.29
// 

package com.google.analytics.tracking.android;

import android.util.DisplayMetrics;
import com.google.android.gms.common.util.VisibleForTesting;
import android.content.Context;

class ScreenResolutionDefaultProvider implements DefaultProvider
{
    private static ScreenResolutionDefaultProvider sInstance;
    private static Object sInstanceLock;
    private final Context mContext;
    
    static {
        ScreenResolutionDefaultProvider.sInstanceLock = new Object();
    }
    
    protected ScreenResolutionDefaultProvider(final Context mContext) {
        this.mContext = mContext;
    }
    
    @VisibleForTesting
    static void dropInstance() {
        synchronized (ScreenResolutionDefaultProvider.sInstanceLock) {
            ScreenResolutionDefaultProvider.sInstance = null;
        }
    }
    
    public static ScreenResolutionDefaultProvider getProvider() {
        synchronized (ScreenResolutionDefaultProvider.sInstanceLock) {
            return ScreenResolutionDefaultProvider.sInstance;
        }
    }
    
    public static void initializeProvider(final Context context) {
        synchronized (ScreenResolutionDefaultProvider.sInstanceLock) {
            if (ScreenResolutionDefaultProvider.sInstance == null) {
                ScreenResolutionDefaultProvider.sInstance = new ScreenResolutionDefaultProvider(context);
            }
        }
    }
    
    protected String getScreenResolutionString() {
        final DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
        return displayMetrics.widthPixels + "x" + displayMetrics.heightPixels;
    }
    
    @Override
    public String getValue(final String s) {
        if (s != null && s.equals("&sr")) {
            return this.getScreenResolutionString();
        }
        return null;
    }
    
    @Override
    public boolean providesField(final String anObject) {
        return "&sr".equals(anObject);
    }
}
