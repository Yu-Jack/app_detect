// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.cf.commons;

import android.graphics.Point;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.content.Context;

public final class a
{
    private static final a a;
    
    static {
        a = new a();
    }
    
    public static a a() {
        return com.ogqcorp.bgh.cf.commons.a.a;
    }
    
    private WindowManager b(final Context context) {
        return (WindowManager)context.getSystemService("window");
    }
    
    private DisplayMetrics c(final Context context) {
        final DisplayMetrics displayMetrics = new DisplayMetrics();
        this.b(context).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;
    }
    
    public Point a(final Context context) {
        final DisplayMetrics c = this.c(context);
        return new Point(c.widthPixels, c.heightPixels);
    }
}
