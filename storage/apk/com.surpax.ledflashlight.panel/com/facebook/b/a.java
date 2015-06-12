// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook.b;

import java.lang.reflect.Method;
import com.facebook.ab;
import android.os.Looper;
import android.database.Cursor;
import android.util.Log;
import android.content.Context;
import android.net.Uri;

public class a
{
    private static final String a;
    private static final Uri b;
    private static a g;
    private String c;
    private String d;
    private boolean e;
    private long f;
    
    static {
        a = a.class.getCanonicalName();
        b = Uri.parse("content://com.facebook.katana.provider.AttributionIdProvider");
    }
    
    public static a a(final Context context) {
        if (com.facebook.b.a.g != null && System.currentTimeMillis() - com.facebook.b.a.g.f < 3600000L) {
            return com.facebook.b.a.g;
        }
        final a b = b(context);
        try {
            final Cursor query = context.getContentResolver().query(com.facebook.b.a.b, new String[] { "aid", "androidid", "limit_tracking" }, (String)null, (String[])null, (String)null);
            if (query != null) {
                if (query.moveToFirst()) {
                    final int columnIndex = query.getColumnIndex("aid");
                    final int columnIndex2 = query.getColumnIndex("androidid");
                    final int columnIndex3 = query.getColumnIndex("limit_tracking");
                    b.c = query.getString(columnIndex);
                    if (columnIndex2 > 0 && columnIndex3 > 0 && b.d == null) {
                        b.d = query.getString(columnIndex2);
                        b.e = Boolean.parseBoolean(query.getString(columnIndex3));
                    }
                    query.close();
                    b.f = System.currentTimeMillis();
                    return com.facebook.b.a.g = b;
                }
            }
        }
        catch (Exception ex) {
            Log.d(com.facebook.b.a.a, "Caught unexpected exception in getAttributionId(): " + ex.toString());
            return null;
        }
        return null;
    }
    
    private static a b(final Context context) {
        final a a = new a();
        Label_0036: {
            try {
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    throw new ab("getAndroidId cannot be called on the main thread.");
                }
                break Label_0036;
            }
            catch (Exception ex) {
                aj.a("android_id", ex);
            }
            return a;
        }
        final Method a2 = aj.a("com.google.android.gms.common.GooglePlayServicesUtil", "isGooglePlayServicesAvailable", Context.class);
        if (a2 == null) {
            return a;
        }
        final Object a3 = aj.a((Object)null, a2, context);
        if (!(a3 instanceof Integer) || (int)a3 != 0) {
            return a;
        }
        final Method a4 = aj.a("com.google.android.gms.ads.identifier.AdvertisingIdClient", "getAdvertisingIdInfo", Context.class);
        if (a4 == null) {
            return a;
        }
        final Object a5 = aj.a((Object)null, a4, context);
        if (a5 == null) {
            return a;
        }
        final Method a6 = aj.a(a5.getClass(), "getId", new Class[0]);
        final Method a7 = aj.a(a5.getClass(), "isLimitAdTrackingEnabled", new Class[0]);
        if (a6 != null && a7 != null) {
            a.d = (String)aj.a(a5, a6, new Object[0]);
            a.e = (boolean)aj.a(a5, a7, new Object[0]);
            return a;
        }
        return a;
    }
    
    public final String a() {
        return this.c;
    }
    
    public final String b() {
        return this.d;
    }
    
    public final boolean c() {
        return this.e;
    }
}
