// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.cf.c.b.a;

import java.util.LinkedList;
import com.a.a.n;
import com.a.a.r;
import android.graphics.Bitmap$Config;
import com.a.a.s;
import java.util.Iterator;
import com.a.a.x;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.os.Handler;
import java.util.HashMap;
import com.a.a.p;

public class a
{
    private final p a;
    private int b;
    private final c c;
    private final HashMap<String, b> d;
    private final HashMap<String, b> e;
    private final Handler f;
    private Runnable g;
    
    public a(final p a, final c c) {
        this.b = 100;
        this.d = new HashMap<String, b>();
        this.e = new HashMap<String, b>();
        this.f = new Handler(Looper.getMainLooper());
        this.a = a;
        this.c = c;
    }
    
    private static String a(final String str, final int i, final int j) {
        return new StringBuilder(12 + str.length()).append("#W").append(i).append("#H").append(j).append(str).toString();
    }
    
    private void a() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalStateException("ImageLoader must be invoked from the main thread.");
        }
    }
    
    private void a(final String key, final Drawable drawable) {
        this.c.a(key, drawable);
        final b b = this.d.remove(key);
        if (b != null) {
            b.c = drawable;
            this.a(key, b);
        }
    }
    
    private void a(final String key, final x x) {
        final b b = this.d.remove(key);
        if (b != null) {
            b.a(x);
            this.a(key, b);
        }
    }
    
    private void a(final String key, final b value) {
        this.e.put(key, value);
        if (this.g == null) {
            this.g = new Runnable() {
                @Override
                public void run() {
                    for (final b b : com.ogqcorp.bgh.cf.c.b.a.a.this.e.values()) {
                        for (final d d : b.e) {
                            if (d.c != null) {
                                if (b.a() == null) {
                                    d.b = b.c;
                                    d.c.a(d, false);
                                }
                                else {
                                    d.c.a(b.a());
                                }
                            }
                        }
                    }
                    com.ogqcorp.bgh.cf.c.b.a.a.this.e.clear();
                    com.ogqcorp.bgh.cf.c.b.a.a.this.g = null;
                }
            };
            this.f.postDelayed(this.g, (long)this.b);
        }
    }
    
    public d a(final String s, final e e, final int n, final int n2) {
        this.a();
        final String a = a(s, n, n2);
        final Drawable a2 = this.c.a(a);
        if (a2 != null) {
            final d d = new d(this, a2, s, null, null);
            e.a(d, true);
            return d;
        }
        final d d2 = new d(this, null, s, a, e);
        e.a(d2, true);
        final b b = this.d.get(a);
        if (b != null) {
            b.a(d2);
            return d2;
        }
        final f f = new f(s, new s<Drawable>() {
            @Override
            public void a(final Drawable drawable) {
                com.ogqcorp.bgh.cf.c.b.a.a.this.a(a, drawable);
            }
        }, n, n2, Bitmap$Config.RGB_565, new r() {
            @Override
            public void a(final x x) {
                com.ogqcorp.bgh.cf.c.b.a.a.this.a(a, x);
            }
        });
        this.a.a((n<Object>)f);
        this.d.put(a, new b(f, d2));
        return d2;
    }
}
