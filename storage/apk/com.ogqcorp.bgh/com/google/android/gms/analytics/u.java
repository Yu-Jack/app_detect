// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.analytics;

import android.util.DisplayMetrics;
import android.content.Context;

class u implements ar
{
    private static u a;
    private static Object b;
    private final Context c;
    
    static {
        u.b = new Object();
    }
    
    protected u(final Context c) {
        this.c = c;
    }
    
    public static u a() {
        synchronized (u.b) {
            return u.a;
        }
    }
    
    public static void a(final Context context) {
        synchronized (u.b) {
            if (u.a == null) {
                u.a = new u(context);
            }
        }
    }
    
    @Override
    public String a(final String s) {
        if (s != null && s.equals("&sr")) {
            return this.b();
        }
        return null;
    }
    
    protected String b() {
        final DisplayMetrics displayMetrics = this.c.getResources().getDisplayMetrics();
        return displayMetrics.widthPixels + "x" + displayMetrics.heightPixels;
    }
}
