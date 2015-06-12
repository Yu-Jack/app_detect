// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.Build;
import android.view.ViewGroup$LayoutParams;
import android.view.View;
import android.widget.FrameLayout$LayoutParams;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.view.ViewGroup;
import java.security.NoSuchAlgorithmException;
import java.math.BigInteger;
import java.util.Locale;
import java.security.MessageDigest;
import android.provider.Settings$Secure;
import android.util.TypedValue;
import android.util.DisplayMetrics;
import android.content.Context;
import android.os.Looper;
import android.os.Handler;

public final class em
{
    public static final Handler a;
    
    static {
        a = new Handler(Looper.getMainLooper());
    }
    
    public static int a(final Context context, final int n) {
        return a(context.getResources().getDisplayMetrics(), n);
    }
    
    public static int a(final DisplayMetrics displayMetrics, final int n) {
        return (int)TypedValue.applyDimension(1, (float)n, displayMetrics);
    }
    
    public static String a(final Context context) {
        String string = Settings$Secure.getString(context.getContentResolver(), "android_id");
        if (string == null || a()) {
            string = "emulator";
        }
        return a(string);
    }
    
    public static String a(final String s) {
        int i = 0;
        while (i < 2) {
            try {
                final MessageDigest instance = MessageDigest.getInstance("MD5");
                instance.update(s.getBytes());
                return String.format(Locale.US, "%032X", new BigInteger(1, instance.digest()));
            }
            catch (NoSuchAlgorithmException ex) {
                ++i;
                continue;
            }
            break;
        }
        return null;
    }
    
    public static void a(final ViewGroup viewGroup, final ak ak, final String s) {
        a(viewGroup, ak, s, -16777216, -1);
    }
    
    private static void a(final ViewGroup viewGroup, final ak ak, final String text, final int n, final int backgroundColor) {
        if (viewGroup.getChildCount() != 0) {
            return;
        }
        final Context context = viewGroup.getContext();
        final TextView textView = new TextView(context);
        textView.setGravity(17);
        textView.setText((CharSequence)text);
        textView.setTextColor(n);
        textView.setBackgroundColor(backgroundColor);
        final FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setBackgroundColor(n);
        final int a = a(context, 3);
        frameLayout.addView((View)textView, (ViewGroup$LayoutParams)new FrameLayout$LayoutParams(ak.g - a, ak.d - a, 17));
        viewGroup.addView((View)frameLayout, ak.g, ak.d);
    }
    
    public static void a(final ViewGroup viewGroup, final ak ak, final String s, final String s2) {
        en.e(s2);
        a(viewGroup, ak, s, -65536, -16777216);
    }
    
    public static boolean a() {
        return Build.DEVICE.startsWith("generic");
    }
    
    public static boolean b() {
        return Looper.myLooper() == Looper.getMainLooper();
    }
}
