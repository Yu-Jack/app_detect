// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.webkit.WebSettings;
import android.content.Context;

public final class ek
{
    public static String a(final Context context) {
        return WebSettings.getDefaultUserAgent(context);
    }
    
    public static void a(final Context context, final WebSettings webSettings) {
        ej.a(context, webSettings);
        webSettings.setMediaPlaybackRequiresUserGesture(false);
    }
}
