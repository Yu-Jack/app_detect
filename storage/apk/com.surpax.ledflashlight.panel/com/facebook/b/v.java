// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook.b;

import java.util.Iterator;
import java.util.Map;
import android.util.Log;
import com.facebook.bq;
import com.facebook.ak;
import java.util.HashMap;

public final class v
{
    private static final HashMap a;
    private final ak b;
    private final String c;
    private StringBuilder d;
    private int e;
    
    static {
        a = new HashMap();
    }
    
    public v(final ak b, final String str) {
        this.e = 3;
        al.a(str, "tag");
        this.b = b;
        this.c = "FacebookSDK." + str;
        this.d = new StringBuilder();
    }
    
    public static void a(final ak ak, final int n, String string, final String s) {
        if (bq.a(ak)) {
            final String c = c(s);
            if (!string.startsWith("FacebookSDK.")) {
                string = "FacebookSDK." + string;
            }
            Log.println(n, string, c);
            if (ak == ak.f) {
                new Exception().printStackTrace();
            }
        }
    }
    
    public static void a(final ak ak, final String s, final String s2) {
        a(ak, 3, s, s2);
    }
    
    public static void a(final ak ak, final String s, final String format, final Object... args) {
        if (bq.a(ak)) {
            a(ak, 3, s, String.format(format, args));
        }
    }
    
    public static void a(final String s) {
        synchronized (v.class) {
            if (!bq.a(ak.b)) {
                a(s, "ACCESS_TOKEN_REMOVED");
            }
        }
    }
    
    private static void a(final String key, final String value) {
        synchronized (v.class) {
            v.a.put(key, value);
        }
    }
    
    private static String c(String replace) {
        synchronized (v.class) {
            for (final Map.Entry<CharSequence, V> entry : v.a.entrySet()) {
                replace = replace.replace(entry.getKey(), (CharSequence)entry.getValue());
            }
            return replace;
        }
    }
    
    public final void a() {
        a(this.b, this.e, this.c, this.d.toString());
        this.d = new StringBuilder();
    }
    
    public final void a(final String s, final Object o) {
        final Object[] args = { s, o };
        if (bq.a(this.b)) {
            this.d.append(String.format("  %s:\t%s\n", args));
        }
    }
    
    public final void b(final String str) {
        if (bq.a(this.b)) {
            this.d.append(str);
        }
    }
}
