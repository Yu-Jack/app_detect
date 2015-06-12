// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook.b;

import android.graphics.Bitmap;
import java.io.InputStream;
import java.net.URI;
import java.io.Closeable;
import android.graphics.BitmapFactory;
import android.content.Context;
import android.os.Looper;
import java.util.HashMap;
import java.util.Map;
import android.os.Handler;

public final class k
{
    private static Handler a;
    private static am b;
    private static am c;
    private static final Map d;
    
    static {
        k.b = new am(8);
        k.c = new am(2);
        d = new HashMap();
    }
    
    private static Handler a() {
        synchronized (k.class) {
            if (k.a == null) {
                k.a = new Handler(Looper.getMainLooper());
            }
            return k.a;
        }
    }
    
    private static n a(final o o) {
        synchronized (k.d) {
            return k.d.remove(o);
        }
    }
    
    public static void a(final Context context) {
        t.a(context);
        ai.a(context);
    }
    
    private static void a(final o o, final Exception ex, final Bitmap bitmap, final boolean b) {
        final n a = a(o);
        if (a != null && !a.c) {
            final p b2 = a.b;
            final r c = b2.c();
            if (c != null) {
                a().post((Runnable)new Runnable() {
                    @Override
                    public final void run() {
                        c.a(new s(b2, ex, b, bitmap));
                    }
                });
            }
        }
    }
    
    public static void a(final p b) {
        if (b == null) {
            return;
        }
        while (true) {
            final o o = new o(b.b(), b.e());
            synchronized (k.d) {
                final n n = k.d.get(o);
                if (n != null) {
                    n.b = b;
                    n.c = false;
                    n.a.b();
                    return;
                }
            }
            a(b, o, b.d());
        }
    }
    
    private static void a(final p b, final o o, final am am, final Runnable runnable) {
        synchronized (k.d) {
            final n n = new n((byte)0);
            n.b = b;
            k.d.put(o, n);
            n.a = am.a(runnable);
        }
    }
    
    private static void a(final p p3, final o o, final boolean b) {
        a(p3, o, k.c, new l(p3.a(), o, b));
    }
    
    public static boolean b(final p p) {
        while (true) {
            final o o = new o(p.b(), p.e());
            synchronized (k.d) {
                final n n = k.d.get(o);
                if (n != null) {
                    boolean b;
                    if (n.a.a()) {
                        k.d.remove(o);
                        b = true;
                    }
                    else {
                        n.c = true;
                        b = true;
                    }
                    return b;
                }
            }
            return false;
        }
    }
}
