// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import com.google.android.gms.ads.c.e;
import android.os.RemoteException;
import com.google.android.gms.ads.c.c;
import com.google.android.gms.ads.c.f;
import com.google.android.gms.ads.c.d;

public final class bm implements d, f
{
    private final bh a;
    
    public bm(final bh a) {
        this.a = a;
    }
    
    @Override
    public void a(final c c) {
        gz.b("onAdLoaded must be called on the main UI thread.");
        en.a("Adapter called onAdLoaded.");
        try {
            this.a.e();
        }
        catch (RemoteException ex) {
            en.c("Could not call onAdLoaded.", (Throwable)ex);
        }
    }
    
    @Override
    public void a(final c c, final int i) {
        gz.b("onAdFailedToLoad must be called on the main UI thread.");
        en.a("Adapter called onAdFailedToLoad with error. " + i);
        try {
            this.a.a(i);
        }
        catch (RemoteException ex) {
            en.c("Could not call onAdFailedToLoad.", (Throwable)ex);
        }
    }
    
    @Override
    public void a(final e e) {
        gz.b("onAdLoaded must be called on the main UI thread.");
        en.a("Adapter called onAdLoaded.");
        try {
            this.a.e();
        }
        catch (RemoteException ex) {
            en.c("Could not call onAdLoaded.", (Throwable)ex);
        }
    }
    
    @Override
    public void a(final e e, final int i) {
        gz.b("onAdFailedToLoad must be called on the main UI thread.");
        en.a("Adapter called onAdFailedToLoad with error " + i + ".");
        try {
            this.a.a(i);
        }
        catch (RemoteException ex) {
            en.c("Could not call onAdFailedToLoad.", (Throwable)ex);
        }
    }
    
    @Override
    public void b(final c c) {
        gz.b("onAdOpened must be called on the main UI thread.");
        en.a("Adapter called onAdOpened.");
        try {
            this.a.d();
        }
        catch (RemoteException ex) {
            en.c("Could not call onAdOpened.", (Throwable)ex);
        }
    }
    
    @Override
    public void b(final e e) {
        gz.b("onAdOpened must be called on the main UI thread.");
        en.a("Adapter called onAdOpened.");
        try {
            this.a.d();
        }
        catch (RemoteException ex) {
            en.c("Could not call onAdOpened.", (Throwable)ex);
        }
    }
    
    @Override
    public void c(final c c) {
        gz.b("onAdClosed must be called on the main UI thread.");
        en.a("Adapter called onAdClosed.");
        try {
            this.a.b();
        }
        catch (RemoteException ex) {
            en.c("Could not call onAdClosed.", (Throwable)ex);
        }
    }
    
    @Override
    public void c(final e e) {
        gz.b("onAdClosed must be called on the main UI thread.");
        en.a("Adapter called onAdClosed.");
        try {
            this.a.b();
        }
        catch (RemoteException ex) {
            en.c("Could not call onAdClosed.", (Throwable)ex);
        }
    }
    
    @Override
    public void d(final c c) {
        gz.b("onAdLeftApplication must be called on the main UI thread.");
        en.a("Adapter called onAdLeftApplication.");
        try {
            this.a.c();
        }
        catch (RemoteException ex) {
            en.c("Could not call onAdLeftApplication.", (Throwable)ex);
        }
    }
    
    @Override
    public void d(final e e) {
        gz.b("onAdLeftApplication must be called on the main UI thread.");
        en.a("Adapter called onAdLeftApplication.");
        try {
            this.a.c();
        }
        catch (RemoteException ex) {
            en.c("Could not call onAdLeftApplication.", (Throwable)ex);
        }
    }
    
    @Override
    public void e(final c c) {
        gz.b("onClick must be called on the main UI thread.");
        en.a("Adapter called onClick.");
        try {
            this.a.a();
        }
        catch (RemoteException ex) {
            en.c("Could not call onAdClicked.", (Throwable)ex);
        }
    }
}
