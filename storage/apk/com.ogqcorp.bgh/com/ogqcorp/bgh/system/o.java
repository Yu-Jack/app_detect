// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.system;

import java.io.File;
import java.util.Locale;
import android.content.Context;

public class o extends p
{
    private static o a;
    
    static {
        o.a = new o();
    }
    
    private StringBuilder a(final Context context, final boolean b) {
        final StringBuilder append = new StringBuilder("http://").append(this.i(context)).append(".bghcdn.ogqcorp.com");
        if (b) {
            this.a(append);
        }
        return append;
    }
    
    private StringBuilder a(final StringBuilder sb) {
        return sb.append('/').append(f.a().b());
    }
    
    private StringBuilder a(final boolean b) {
        final StringBuilder sb = new StringBuilder("http://bgh.ogqcorp.com");
        if (b) {
            this.a(sb);
        }
        return sb;
    }
    
    public static o b() {
        return o.a;
    }
    
    private StringBuilder h(final Context context) {
        return new StringBuilder("http://").append(this.i(context)).append(".bghcdn.ogqcorp.com");
    }
    
    private String i(final Context context) {
        String f = v.a().f(context);
        if (context.getResources().getConfiguration().locale.equals(Locale.KOREA) && com.ogqcorp.bgh.system.f.a().e(context)) {
            f = "winter";
        }
        else if ("autumn".equals(f) && !com.ogqcorp.bgh.system.f.a().d(context)) {
            return "summer";
        }
        return f;
    }
    
    @Override
    protected File a() {
        return new File(p.p(), "/OGQ/BackgroundsHD");
    }
    
    public File a(final int i) {
        return new File(this.h(i), "/T" + String.valueOf(i));
    }
    
    public File a(final Context context, final int i, final boolean b) {
        final String e = v.a().e(context);
        final Locale us = Locale.US;
        final Object[] args = { i, null };
        String s;
        if (!b) {
            s = "BG";
        }
        else {
            s = "HD";
        }
        args[1] = s;
        return new File(e, String.format(us, "%05d_%s.jpg", args));
    }
    
    public String a(final Context context) {
        return this.a(context, true).append("/recent").toString();
    }
    
    public String a(final Context context, final int i) {
        return this.h(context).append("/thumbnail/").append(i).append('/').append(f.a().b(context)[0]).toString();
    }
    
    public String a(final String str) {
        return this.a(false).append("/share/h/").append(str).toString();
    }
    
    public File b(final int i) {
        return new File(this.h(i), "/P" + String.valueOf(i));
    }
    
    public String b(final Context context) {
        return this.a(context, true).append("/ranking").toString();
    }
    
    public String b(final Context context, final int i) {
        return this.h(context).append("/preview/").append(i).append('/').append(f.a().b(context)[1]).toString();
    }
    
    public String b(final Context context, final int i, final boolean b) {
        final int j = f.a().b(context)[2];
        final StringBuilder append = this.h(context).append("/image/").append(i).append('/');
        String value;
        if (!b) {
            value = String.valueOf(j);
        }
        else {
            value = "max";
        }
        return append.append(value).toString();
    }
    
    public File c() {
        return new File(this.a(), "/Images");
    }
    
    public File c(final int i) {
        return new File(this.h(i), "/A" + String.valueOf(i));
    }
    
    public String c(final Context context) {
        return this.a(context, true).append("/ranking/monthly").toString();
    }
    
    public String c(final Context context, final int i) {
        return this.h(context).append("/author/picture/").append(i).toString();
    }
    
    public File d() {
        return new File(this.a(), "/Favorite.db");
    }
    
    public File d(final int i) {
        return new File(this.h(i), "/C" + String.valueOf(i));
    }
    
    public String d(final Context context) {
        return this.a(context, true).append("/ranking/weekly").toString();
    }
    
    public String d(final Context context, final int i) {
        return this.h(context).append("/category/image/").append(i).toString();
    }
    
    public File e() {
        return new File(this.a(), "/History.db");
    }
    
    public String e(final int i) {
        return this.a(true).append("/info/").append(i).toString();
    }
    
    public String e(final Context context) {
        return this.a(context, true).append("/ranking/daily").toString();
    }
    
    public String e(final Context context, final int i) {
        return this.a(context, false).append("/category/").append(i).toString();
    }
    
    public File f() {
        return new File(this.a(), "/Wallpaper");
    }
    
    public String f(final int i) {
        return this.a(false).append("/author/homepage/").append(i).toString();
    }
    
    public String f(final Context context) {
        return this.a(context, true).append("/categories").toString();
    }
    
    public String f(final Context context, final int i) {
        return this.a(context, false).append("/author/").append(i).toString();
    }
    
    public File g() {
        return new File(this.r(), "/Contact.jpg");
    }
    
    public String g(final int i) {
        return this.a(false).append("/api/v2/background/").append(i).append("/count").toString();
    }
    
    public String g(final Context context) {
        return this.a(context, false).append("/notification").toString();
    }
    
    public String h() {
        return this.a(false).append("/ready").toString();
    }
    
    public String i() {
        return this.a(false).append("/ready/country").toString();
    }
    
    public String j() {
        return this.a(false).append("/api/v2/stats/acquisition").toString();
    }
    
    public String k() {
        return this.a(false).append("/api/v2/stats/contentad").toString();
    }
    
    public String l() {
        return this.a(false).append("/api/v2/stats/info").toString();
    }
}
