// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.system;

import java.io.File;
import android.content.Context;
import com.ogqcorp.commons.v;

public final class v extends com.ogqcorp.commons.v
{
    private static final v a;
    
    static {
        a = new v();
    }
    
    public static v a() {
        return v.a;
    }
    
    public int a(final Context context) {
        return this.a(context, "LAST_BACKGROUND_ID", 0);
    }
    
    public void a(final Context context, final int n) {
        this.b(context, "LAST_BACKGROUND_ID", n);
    }
    
    public void a(final Context context, final long n) {
        this.b(context, "NOTIFICATION_TIME", n);
    }
    
    public void a(final Context context, final String pathname) {
        this.b(context, "SAVE_DIRECTORY", pathname);
        new File(pathname).mkdirs();
    }
    
    public long b(final Context context) {
        return this.a(context, "NOTIFICATION_TIME", 0L);
    }
    
    public void b(final Context context, final int n) {
        this.b(context, "POPULAR_MODE", n);
    }
    
    public void b(final Context context, final long n) {
        this.b(context, "WALLPAPER_TIME", n);
    }
    
    public void b(final Context context, final String s) {
        this.b(context, "SERVER_NAME_006", s);
    }
    
    public int c(final Context context) {
        return this.a(context, "POPULAR_MODE", 3);
    }
    
    public void c(final Context context, final int n) {
        this.b(context, "RATE_CHANCE", n);
    }
    
    public int d(final Context context) {
        return this.a(context, "RATE_CHANCE", 0);
    }
    
    public void d(final Context context, final int n) {
        this.b(context, "WALLPAPER_CX", n);
    }
    
    public String e(final Context context) {
        String s = this.a(context, "SAVE_DIRECTORY", "");
        if (s.length() == 0) {
            s = o.b().c().getAbsolutePath();
            this.a(context, s);
        }
        return s;
    }
    
    public void e(final Context context, final int n) {
        this.b(context, "WALLPAPER_CY", n);
    }
    
    public String f(final Context context) {
        return this.a(context, "SERVER_NAME_006", null);
    }
    
    public boolean g(final Context context) {
        return this.a(context, "USE_NOTIFICATION", true);
    }
    
    public boolean h(final Context context) {
        return this.a(context, "USE_DEFAULT_WALLPAPER_MANAGER", false);
    }
    
    public int i(final Context context) {
        return this.a(context, "WALLPAPER_CX", -1);
    }
    
    public int j(final Context context) {
        return this.a(context, "WALLPAPER_CY", -1);
    }
    
    public long k(final Context context) {
        return this.a(context, "WALLPAPER_TIME", 0L);
    }
}
