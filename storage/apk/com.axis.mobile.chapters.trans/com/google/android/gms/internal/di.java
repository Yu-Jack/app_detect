// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.IBinder;
import com.google.android.gms.dynamic.g$a;
import android.os.RemoteException;
import com.google.android.gms.dynamic.e;
import android.content.Context;
import android.content.Intent;
import android.app.Activity;
import com.google.android.gms.dynamic.g;

public final class di extends g
{
    private static final di pv;
    
    static {
        pv = new di();
    }
    
    private di() {
        super("com.google.android.gms.ads.InAppPurchaseManagerCreatorImpl");
    }
    
    private static boolean b(final Activity activity) {
        final Intent intent = activity.getIntent();
        if (!intent.hasExtra("com.google.android.gms.ads.internal.purchase.useClientJar")) {
            throw new di$a("InAppPurchaseManager requires the useClientJar flag in intent extras.");
        }
        return intent.getBooleanExtra("com.google.android.gms.ads.internal.purchase.useClientJar", false);
    }
    
    public static dd d(final Activity activity) {
        try {
            if (b(activity)) {
                eu.z("Using AdOverlay from the client jar.");
                return new cu(activity);
            }
            return di.pv.e(activity);
        }
        catch (di$a di$a) {
            eu.D(di$a.getMessage());
            return null;
        }
    }
    
    private dd e(final Activity activity) {
        try {
            return dd$a.r(((de)this.G((Context)activity)).b(e.h(activity)));
        }
        catch (RemoteException ex) {
            eu.c("Could not create remote InAppPurchaseManager.", (Throwable)ex);
            return null;
        }
        catch (g$a g$a) {
            eu.c("Could not create remote InAppPurchaseManager.", g$a);
            return null;
        }
    }
    
    protected de v(final IBinder binder) {
        return de$a.s(binder);
    }
}
