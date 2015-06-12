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

public final class cm extends g
{
    private static final cm oS;
    
    static {
        oS = new cm();
    }
    
    private cm() {
        super("com.google.android.gms.ads.AdOverlayCreatorImpl");
    }
    
    public static cn a(final Activity activity) {
        try {
            if (b(activity)) {
                eu.z("Using AdOverlay from the client jar.");
                return new cf(activity);
            }
            return cm.oS.c(activity);
        }
        catch (cm$a cm$a) {
            eu.D(cm$a.getMessage());
            return null;
        }
    }
    
    private static boolean b(final Activity activity) {
        final Intent intent = activity.getIntent();
        if (!intent.hasExtra("com.google.android.gms.ads.internal.overlay.useClientJar")) {
            throw new cm$a("Ad overlay requires the useClientJar flag in intent extras.");
        }
        return intent.getBooleanExtra("com.google.android.gms.ads.internal.overlay.useClientJar", false);
    }
    
    private cn c(final Activity activity) {
        try {
            return cn$a.m(((co)this.G((Context)activity)).a(e.h(activity)));
        }
        catch (RemoteException ex) {
            eu.c("Could not create remote AdOverlay.", (Throwable)ex);
            return null;
        }
        catch (g$a g$a) {
            eu.c("Could not create remote AdOverlay.", g$a);
            return null;
        }
    }
    
    protected co l(final IBinder binder) {
        return co$a.n(binder);
    }
}
