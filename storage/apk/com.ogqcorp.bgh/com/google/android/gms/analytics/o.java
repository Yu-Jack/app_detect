// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.analytics;

import com.google.android.gms.common.e;
import java.io.IOException;
import com.google.android.gms.common.f;
import com.google.android.gms.ads.b.a;
import android.content.Context;
import com.google.android.gms.ads.b.b;

class o implements ar
{
    private static Object a;
    private static o b;
    private b c;
    private long d;
    private Context e;
    
    static {
        o.a = new Object();
    }
    
    o(final Context e) {
        this.e = e;
    }
    
    private b a() {
        try {
            return com.google.android.gms.ads.b.a.b(this.e);
        }
        catch (IllegalStateException ex) {
            p.d("IllegalStateException getting Ad Id Info. If you would like to see Audience reports, please ensure that you have added '<meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />' to your application manifest file. See http://goo.gl/naFqQk for details.");
            return null;
        }
        catch (f f) {
            p.d("GooglePlayServicesRepairableException getting Ad Id Info");
            return null;
        }
        catch (IOException ex2) {
            p.d("IOException getting Ad Id Info");
            return null;
        }
        catch (e e) {
            p.d("GooglePlayServicesNotAvailableException getting Ad Id Info");
            return null;
        }
        catch (Exception ex3) {
            p.d("Unknown exception. Could not get the ad Id.");
            return null;
        }
    }
    
    public static ar a(final Context context) {
        Label_0031: {
            if (o.b != null) {
                break Label_0031;
            }
            synchronized (o.a) {
                if (o.b == null) {
                    o.b = new o(context);
                }
                return o.b;
            }
        }
    }
    
    @Override
    public String a(final String s) {
        final long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.d > 1000L) {
            this.c = this.a();
            this.d = currentTimeMillis;
        }
        if (this.c != null) {
            if ("&adid".equals(s)) {
                return this.c.a();
            }
            if ("&ate".equals(s)) {
                if (this.c.b()) {
                    return "0";
                }
                return "1";
            }
        }
        return null;
    }
}
