// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.IBinder;
import com.google.android.gms.a.f;
import android.os.RemoteException;
import com.google.android.gms.a.d;
import com.google.android.gms.common.g;
import android.content.Context;
import com.google.android.gms.a.e;

public final class h extends e<t>
{
    private static final h a;
    
    static {
        a = new h();
    }
    
    private h() {
        super("com.google.android.gms.ads.AdManagerCreatorImpl");
    }
    
    public static q a(final Context context, final ak ak, final String s, final ba ba) {
        if (g.a(context) == 0) {
            final q b = h.a.b(context, ak, s, ba);
            if (b != null) {
                return b;
            }
        }
        en.a("Using AdManager from the client jar.");
        return new li(context, ak, s, ba, new dx(4452000, 4452000, true));
    }
    
    private q b(final Context context, final ak ak, final String s, final ba ba) {
        try {
            return r.a(this.a(context).a(d.a(context), ak, s, ba, 4452000));
        }
        catch (RemoteException ex) {
            en.c("Could not create remote AdManager.", (Throwable)ex);
            return null;
        }
        catch (f f) {
            en.c("Could not create remote AdManager.", f);
            return null;
        }
    }
    
    protected t b(final IBinder binder) {
        return u.a(binder);
    }
}
