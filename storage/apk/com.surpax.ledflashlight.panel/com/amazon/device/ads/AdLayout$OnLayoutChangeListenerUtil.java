// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

import android.webkit.WebViewDatabase;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.content.IntentFilter;
import java.util.HashMap;
import android.content.Intent;
import android.view.ViewGroup$LayoutParams;
import android.widget.FrameLayout$LayoutParams;
import android.widget.TextView;
import java.util.Locale;
import android.util.AttributeSet;
import android.app.Activity;
import java.util.concurrent.TimeUnit;
import android.content.BroadcastReceiver;
import java.util.concurrent.atomic.AtomicBoolean;
import android.content.Context;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import android.widget.FrameLayout;
import android.annotation.TargetApi;
import android.view.View;
import android.view.View$OnLayoutChangeListener;

class AdLayout$OnLayoutChangeListenerUtil
{
    @TargetApi(11)
    protected static void setOnLayoutChangeListenerForRoot(final AdLayout adLayout, final AdLoader$AdReadyToLoadListener adLoader$AdReadyToLoadListener) {
        adLayout.activityRootView.addOnLayoutChangeListener((View$OnLayoutChangeListener)new View$OnLayoutChangeListener() {
            public final void onLayoutChange(final View view, final int n, final int n2, final int n3, final int n4, final int n5, final int n6, final int n7, final int n8) {
                if (adLayout.needsToLoadAdOnLayout.getAndSet(false)) {
                    adLayout.setFloatingWindowDimensions();
                    adLayout.loadAdFromAdController(adLoader$AdReadyToLoadListener);
                    adLayout.activityRootView.removeOnLayoutChangeListener((View$OnLayoutChangeListener)this);
                }
            }
        });
    }
}
