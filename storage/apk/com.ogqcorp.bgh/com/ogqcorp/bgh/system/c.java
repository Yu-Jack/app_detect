// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.system;

import com.google.android.gms.analytics.be;
import com.google.android.gms.analytics.bd;
import com.google.android.gms.analytics.h;
import com.ogqcorp.bgh.item.License;
import com.ogqcorp.bgh.item.Category;
import com.ogqcorp.bgh.item.Background;
import com.ogqcorp.bgh.item.Author;
import android.app.Activity;
import com.google.android.gms.analytics.k;
import java.util.Map;
import com.google.android.gms.analytics.f;
import com.google.android.gms.analytics.c;
import android.content.Context;

public final class c
{
    private static final c a;
    
    static {
        a = new c();
    }
    
    public static c a() {
        return c.a;
    }
    
    private void a(final Context context, final String s, final String s2, final Object o, final Long n) {
        final k a = com.google.android.gms.analytics.c.a(context).a(2131034112);
        long longValue;
        if (n == null) {
            longValue = 0L;
        }
        else {
            longValue = n;
        }
        final f b = new f().a(s).b(s2);
        String string;
        if (o != null) {
            string = o.toString();
        }
        else {
            string = null;
        }
        a.a(b.c(string).a(longValue).a());
    }
    
    public void a(final Activity activity) {
        com.google.android.gms.analytics.c.a((Context)activity).a(activity);
    }
    
    public void a(final Context context) {
        String f = v.a().f(context);
        if (f == null) {
            f = "null";
        }
        this.a(context, "APP_START", "SERVER_NAME", f, null);
    }
    
    public void a(final Context context, final int i) {
        this.a(context, "DATA", "SCREEN_SWIPE", i, null);
    }
    
    public void a(final Context context, final Author author) {
        this.a(context, "ACTION", "AUTHOR", author.getId(), null);
    }
    
    public void a(final Context context, final Background background) {
        this.a(context, "ACTION", "AUTHOR_HOMEPAGE", background.getAuthor().getId(), null);
    }
    
    public void a(final Context context, final Category category) {
        this.a(context, "VISIT", "CATEGORY", category.getId(), null);
    }
    
    public void a(final Context context, final License license) {
        this.a(context, "ACTION", "LICENSE", license.getType(), null);
    }
    
    public void a(final Context context, final Class<?> clazz) {
        final m m = clazz.getAnnotation(m.class);
        if (m == null) {
            return;
        }
        this.a(context, "VISIT", "TAB", m.a(), null);
    }
    
    public void a(final Context context, final String s) {
        this.a(context, "ACTION", "TAG", s, null);
    }
    
    public void a(final Context context, final boolean b) {
        int i;
        if (b) {
            i = 1;
        }
        else {
            i = 0;
        }
        this.a(context, "DATA", "HAS_CONTACT", i, null);
    }
    
    public void b(final Activity activity) {
        com.google.android.gms.analytics.c.a((Context)activity).b(activity);
    }
    
    public void b(final Context context) {
        this.a(context, "ACTION", "WALLPAPER_USER_FILE", null, null);
    }
    
    public void b(final Context context, final Author author) {
        this.a(context, "VISIT", "AUTHOR", author.getId(), null);
    }
    
    public void b(final Context context, final Background background) {
        this.a(context, "ACTION", "CONTACT", background.getId(), null);
    }
    
    public void b(final Context context, final String s) {
        this.a(context, "VISIT", "TAG", s, null);
    }
    
    public void c(final Context context) {
        this.a(context, "DATA", "GOTO_FLICKR_GROUP", null, null);
    }
    
    public void c(final Context context, final Background background) {
        this.a(context, "ACTION", "FAVORITE", background.getId(), null);
    }
    
    public void d(final Context context, final Background background) {
        this.a(context, "ACTION", "PREVIEW", background.getId(), null);
    }
    
    public void e(final Context context, final Background background) {
        this.a(context, "ACTION", "SAVE", background.getId(), null);
    }
    
    public void f(final Context context, final Background background) {
        this.a(context, "ACTION", "SHARE", background.getId(), null);
    }
    
    public void g(final Context context, final Background background) {
        this.a(context, "ACTION", "WALLPAPER", background.getId(), null);
    }
}
