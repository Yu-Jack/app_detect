// 
// Decompiled by Procyon v0.5.29
// 

package com.flurry.sdk;

import android.webkit.WebView;
import android.annotation.TargetApi;
import android.webkit.WebSettings;
import android.os.Build$VERSION;
import android.text.TextUtils;
import android.content.Context;

public final class cg
{
    public static String a(final Context context) {
        CharSequence b;
        if (context == null) {
            b = null;
        }
        else {
            b = b(context);
            if (TextUtils.isEmpty(b)) {
                return c(context);
            }
        }
        return (String)b;
    }
    
    @TargetApi(17)
    static String b(final Context context) {
        if (context != null && Build$VERSION.SDK_INT >= 17) {
            return WebSettings.getDefaultUserAgent(context);
        }
        return null;
    }
    
    static String c(final Context context) {
        if (context == null) {
            return null;
        }
        return new WebView(context).getSettings().getUserAgentString();
    }
}
