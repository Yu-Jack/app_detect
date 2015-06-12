// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.IBinder;
import com.google.android.gms.a.f;
import android.os.RemoteException;
import com.google.android.gms.a.d;
import android.content.Context;
import android.content.Intent;
import android.app.Activity;
import com.google.android.gms.a.e;

public final class cd extends e<cj>
{
    private static final cd a;
    
    static {
        a = new cd();
    }
    
    private cd() {
        super("com.google.android.gms.ads.AdOverlayCreatorImpl");
    }
    
    public static cg a(final Activity activity) {
        try {
            if (b(activity)) {
                en.a("Using AdOverlay from the client jar.");
                return new bs(activity);
            }
            return cd.a.c(activity);
        }
        catch (cf cf) {
            en.e(cf.getMessage());
            return null;
        }
    }
    
    private static boolean b(final Activity activity) {
        final Intent intent = activity.getIntent();
        if (!intent.hasExtra("com.google.android.gms.ads.internal.overlay.useClientJar")) {
            throw new cf("Ad overlay requires the useClientJar flag in intent extras.");
        }
        return intent.getBooleanExtra("com.google.android.gms.ads.internal.overlay.useClientJar", false);
    }
    
    private cg c(final Activity activity) {
        try {
            return ch.a(this.a((Context)activity).a(d.a(activity)));
        }
        catch (RemoteException ex) {
            en.c("Could not create remote AdOverlay.", (Throwable)ex);
            return null;
        }
        catch (f f) {
            en.c("Could not create remote AdOverlay.", f);
            return null;
        }
    }
    
    protected cj b(final IBinder binder) {
        return ck.a(binder);
    }
}
