// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.widget.a;

import android.view.WindowManager;
import android.widget.ImageView;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.content.Context;
import android.util.DisplayMetrics;

public class h
{
    private static DisplayMetrics a;
    
    public static int a(final Context context, final float n) {
        if (h.a == null) {
            h.a = a(context);
        }
        return (int)TypedValue.applyDimension(1, n, h.a);
    }
    
    private static DisplayMetrics a(final Context context) {
        final DisplayMetrics displayMetrics = new DisplayMetrics();
        b(context).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;
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
    
    private static WindowManager b(final Context context) {
        return (WindowManager)context.getSystemService("window");
    }
}
