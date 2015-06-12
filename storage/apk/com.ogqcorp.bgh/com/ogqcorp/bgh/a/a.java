// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.a;

import java.io.File;
import com.ogqcorp.commons.u;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;
import com.ogqcorp.bgh.item.License;
import com.ogqcorp.bgh.item.Author;
import android.content.Context;
import com.ogqcorp.bgh.item.Background;
import android.content.Intent;
import android.app.Activity;

public final class a
{
    public static void a(final Activity activity, final int n, final int n2, final Intent intent, final Background background) {
        try {
            new p(activity).a(n, n2, intent, background);
        }
        catch (Exception ex) {
            a((Context)activity, ex);
        }
    }
    
    public static void a(final Activity activity, final Author author) {
        try {
            new b(activity).a(author);
        }
        catch (Exception ex) {
            a((Context)activity, ex);
        }
    }
    
    public static void a(final Activity activity, final Background background) {
        try {
            new c(activity).a(background);
        }
        catch (Exception ex) {
            a((Context)activity, ex);
        }
    }
    
    public static void a(final Activity activity, final Background background, final Runnable runnable) {
        try {
            new f(activity).a(background, runnable);
        }
        catch (Exception ex) {
            a((Context)activity, ex);
        }
    }
    
    public static void a(final Activity activity, final License license) {
        try {
            new g(activity).a(license);
        }
        catch (Exception ex) {
            a((Context)activity, ex);
        }
    }
    
    public static void a(final Activity activity, final String s) {
        try {
            new m(activity).a(s);
        }
        catch (Exception ex) {
            a((Context)activity, ex);
        }
    }
    
    private static void a(final Context context, final Exception ex) {
        Toast.makeText(context, (CharSequence)ex.getMessage(), 0).show();
    }
    
    public static void a(final FragmentActivity fragmentActivity, final Background background) {
        try {
            new i(fragmentActivity).a(background);
        }
        catch (Exception ex) {
            a((Context)fragmentActivity, ex);
        }
    }
    
    public static void a(final FragmentActivity fragmentActivity, final Background background, final boolean b, final u<File> u, final u<Exception> u2) {
        try {
            new k(fragmentActivity).a(background, b, u, u2);
        }
        catch (Exception ex) {
            a((Context)fragmentActivity, ex);
        }
    }
    
    public static void a(final FragmentActivity fragmentActivity, final File file) {
        try {
            new n(fragmentActivity).a(file);
        }
        catch (Exception ex) {
            a((Context)fragmentActivity, ex);
        }
    }
    
    public static void b(final Activity activity, final Background background) {
        try {
            new e(activity).a(background);
        }
        catch (Exception ex) {
            a((Context)activity, ex);
        }
    }
    
    public static void b(final FragmentActivity fragmentActivity, final Background background) {
        try {
            new n(fragmentActivity).a(background);
        }
        catch (Exception ex) {
            a((Context)fragmentActivity, ex);
        }
    }
    
    public static void c(final Activity activity, final Background background) {
        try {
            new h(activity).a(background);
        }
        catch (Exception ex) {
            a((Context)activity, ex);
        }
    }
    
    public static void d(final Activity activity, final Background background) {
        try {
            new l(activity).a(background);
        }
        catch (Exception ex) {
            a((Context)activity, ex);
        }
    }
}
