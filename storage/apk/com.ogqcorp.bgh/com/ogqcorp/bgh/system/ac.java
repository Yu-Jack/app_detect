// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.system;

import android.view.WindowManager;
import android.view.ViewConfiguration;
import android.view.Display;
import android.graphics.Point;
import android.widget.ImageView;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.annotation.TargetApi;
import android.os.Build$VERSION;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import java.util.Locale;
import android.widget.Toast;
import android.content.pm.PackageInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.PackageManager;
import android.util.TypedValue;
import android.content.Context;
import android.util.DisplayMetrics;
import java.text.DecimalFormat;

public class ac
{
    private static final DecimalFormat a;
    private static DisplayMetrics b;
    
    static {
        a = new DecimalFormat("###,###,###");
    }
    
    public static int a(final Context context, final float n) {
        if (ac.b == null) {
            ac.b = g(context);
        }
        return (int)TypedValue.applyDimension(1, n, ac.b);
    }
    
    public static PackageInfo a(final PackageManager packageManager, final ResolveInfo resolveInfo) {
        try {
            return packageManager.getPackageInfo(resolveInfo.activityInfo.packageName, 0);
        }
        catch (Exception ex) {
            return null;
        }
    }
    
    public static Toast a(final Context context, final int n, final int n2, final Object... array) {
        return Toast.makeText(context, (CharSequence)context.getString(n2, array), n);
    }
    
    public static String a(final Object obj) {
        return ac.a.format(obj);
    }
    
    public static Locale a(final Context context) {
        try {
            return context.getResources().getConfiguration().locale;
        }
        catch (Exception ex) {
            l.a(ex);
            return new Locale("", "");
        }
    }
    
    public static void a(final long n) {
        try {
            Thread.sleep(n);
        }
        catch (InterruptedException ex) {
            l.b(ex);
        }
    }
    
    @TargetApi(8)
    public static void a(final Activity activity, final String s, final Bundle bundle) {
        try {
            final Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(s));
            if (Build$VERSION.SDK_INT >= 8 && bundle != null) {
                intent.putExtra("com.android.browser.headers", bundle);
            }
            activity.startActivity(intent);
        }
        catch (Exception ex) {
            l.c(ex);
        }
    }
    
    public static void a(final Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            final BitmapDrawable bitmapDrawable = (BitmapDrawable)drawable;
            if (bitmapDrawable.getBitmap() != null) {
                bitmapDrawable.getBitmap().recycle();
            }
        }
    }
    
    public static void a(final ImageView imageView) {
        a(imageView.getDrawable());
        imageView.destroyDrawingCache();
        imageView.setImageDrawable((Drawable)null);
    }
    
    public static Point b(final Context context) {
        final DisplayMetrics g = g(context);
        return new Point(g.widthPixels, g.heightPixels);
    }
    
    @TargetApi(17)
    public static Point c(final Context context) {
        if (Build$VERSION.SDK_INT >= 17) {
            final DisplayMetrics h = h(context);
            return new Point(h.widthPixels, h.heightPixels);
        }
        final Display defaultDisplay = i(context).getDefaultDisplay();
        try {
            return new Point((int)Display.class.getMethod("getRawWidth", (Class<?>[])new Class[0]).invoke(defaultDisplay, new Object[0]), (int)Display.class.getMethod("getRawHeight", (Class<?>[])new Class[0]).invoke(defaultDisplay, new Object[0]));
        }
        catch (Exception ex) {
            return b(context);
        }
    }
    
    public static String d(final Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        }
        catch (Exception ex) {
            l.a(ex);
            return "";
        }
    }
    
    public static int e(final Context context) {
        if (ac.b == null) {
            ac.b = g(context);
        }
        final TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(16843499, typedValue, true)) {
            return TypedValue.complexToDimensionPixelSize(typedValue.data, ac.b);
        }
        if (context.getTheme().resolveAttribute(2130771981, typedValue, true)) {
            return TypedValue.complexToDimensionPixelSize(typedValue.data, ac.b);
        }
        return 0;
    }
    
    @TargetApi(14)
    public static boolean f(final Context context) {
        return Build$VERSION.SDK_INT <= 10 || (Build$VERSION.SDK_INT >= 14 && ViewConfiguration.get(context).hasPermanentMenuKey());
    }
    
    private static DisplayMetrics g(final Context context) {
        final DisplayMetrics displayMetrics = new DisplayMetrics();
        i(context).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;
    }
    
    @TargetApi(17)
    private static DisplayMetrics h(final Context context) {
        final DisplayMetrics displayMetrics = new DisplayMetrics();
        i(context).getDefaultDisplay().getRealMetrics(displayMetrics);
        return displayMetrics;
    }
    
    private static WindowManager i(final Context context) {
        return (WindowManager)context.getSystemService("window");
    }
}
