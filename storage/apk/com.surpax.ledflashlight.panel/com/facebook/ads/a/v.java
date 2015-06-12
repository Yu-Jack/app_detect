// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook.ads.a;

import java.lang.reflect.Method;
import android.os.Looper;
import android.content.Context;

public final class v
{
    private final String a;
    private final boolean b;
    
    private v(final String a, final boolean b) {
        this.a = a;
        this.b = b;
    }
    
    public static v a(final Context context, final s s) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException("Cannot get advertising info on main thread.");
        }
        if (s != null && !ab.a(s.b)) {
            return new v(s.b, s.c);
        }
        final Method a = r.a("com.google.android.gms.common.GooglePlayServicesUtil", "isGooglePlayServicesAvailable", Context.class);
        if (a == null) {
            return null;
        }
        final Object a2 = r.a(null, a, context);
        if (a2 == null || (int)a2 != 0) {
            return null;
        }
        final Method a3 = r.a("com.google.android.gms.ads.identifier.AdvertisingIdClient", "getAdvertisingIdInfo", Context.class);
        if (a3 == null) {
            return null;
        }
        final Object a4 = r.a(null, a3, context);
        if (a4 == null) {
            return null;
        }
        final Method a5 = r.a(a4.getClass(), "getId", new Class[0]);
        final Method a6 = r.a(a4.getClass(), "isLimitAdTrackingEnabled", new Class[0]);
        if (a5 == null || a6 == null) {
            return null;
        }
        return new v((String)r.a(a4, a5, new Object[0]), (boolean)r.a(a4, a6, new Object[0]));
    }
    
    public final String a() {
        return this.a;
    }
    
    public final boolean b() {
        return this.b;
    }
}
