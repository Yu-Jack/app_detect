// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.a;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.dynamic.e;
import android.content.Context;
import java.util.Set;
import java.util.Date;
import java.util.Collection;
import java.util.HashSet;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.dynamic.d;
import java.util.Iterator;
import com.google.ads.mediation.admob.AdMobAdapter;
import android.os.RemoteException;
import org.json.JSONObject;
import android.os.Bundle;
import com.google.android.gms.ads.mediation.MediationAdapter;

public final class bx extends bu$a
{
    private final MediationAdapter nS;
    
    public bx(final MediationAdapter ns) {
        this.nS = ns;
    }
    
    private Bundle a(final String str, final int n, final String s) {
        eu.D("Server parameters: " + str);
        Bundle bundle = null;
        Label_0121: {
            Bundle bundle2;
            try {
                bundle = new Bundle();
                if (str == null) {
                    break Label_0121;
                }
                final JSONObject jsonObject = new JSONObject(str);
                bundle2 = new Bundle();
                final Iterator keys = jsonObject.keys();
                while (keys.hasNext()) {
                    final String s2 = keys.next();
                    bundle2.putString(s2, jsonObject.getString(s2));
                }
            }
            catch (Throwable t) {
                eu.c("Could not get Server Parameters Bundle.", t);
                throw new RemoteException();
            }
            bundle = bundle2;
        }
        if (this.nS instanceof AdMobAdapter) {
            bundle.putString("adJson", s);
            bundle.putInt("tagForChildDirectedTreatment", n);
        }
        return bundle;
    }
    
    public void a(final d d, final ai ai, final String s, final bv bv) {
        this.a(d, ai, s, null, bv);
    }
    
    public void a(final d d, final ai ai, final String s, final String s2, final bv bv) {
        if (!(this.nS instanceof MediationInterstitialAdapter)) {
            eu.D("MediationAdapter is not a MediationInterstitialAdapter: " + this.nS.getClass().getCanonicalName());
            throw new RemoteException();
        }
        eu.z("Requesting interstitial ad from adapter.");
        try {
            final MediationInterstitialAdapter mediationInterstitialAdapter = (MediationInterstitialAdapter)this.nS;
            HashSet set;
            if (ai.lU != null) {
                set = new HashSet(ai.lU);
            }
            else {
                set = null;
            }
            final bw bw = new bw(new Date(ai.lS), ai.lT, set, ai.lV, ai.lW);
            final Bundle mc = ai.mc;
            Bundle bundle = null;
            if (mc != null) {
                bundle = ai.mc.getBundle(mediationInterstitialAdapter.getClass().getName());
            }
            mediationInterstitialAdapter.requestInterstitialAd((Context)e.e(d), new by(bv), this.a(s, ai.lW, s2), bw, bundle);
        }
        catch (Throwable t) {
            eu.c("Could not request interstitial ad from adapter.", t);
            throw new RemoteException();
        }
    }
    
    public void a(final d d, final al al, final ai ai, final String s, final bv bv) {
        this.a(d, al, ai, s, null, bv);
    }
    
    public void a(final d d, final al al, final ai ai, final String s, final String s2, final bv bv) {
        if (!(this.nS instanceof MediationBannerAdapter)) {
            eu.D("MediationAdapter is not a MediationBannerAdapter: " + this.nS.getClass().getCanonicalName());
            throw new RemoteException();
        }
        eu.z("Requesting banner ad from adapter.");
        try {
            final MediationBannerAdapter mediationBannerAdapter = (MediationBannerAdapter)this.nS;
            HashSet set;
            if (ai.lU != null) {
                set = new HashSet(ai.lU);
            }
            else {
                set = null;
            }
            final bw bw = new bw(new Date(ai.lS), ai.lT, set, ai.lV, ai.lW);
            final Bundle mc = ai.mc;
            Bundle bundle = null;
            if (mc != null) {
                bundle = ai.mc.getBundle(mediationBannerAdapter.getClass().getName());
            }
            mediationBannerAdapter.requestBannerAd((Context)e.e(d), new by(bv), this.a(s, ai.lW, s2), a.a(al.width, al.height, al.me), bw, bundle);
        }
        catch (Throwable t) {
            eu.c("Could not request banner ad from adapter.", t);
            throw new RemoteException();
        }
    }
    
    public void destroy() {
        try {
            this.nS.onDestroy();
        }
        catch (Throwable t) {
            eu.c("Could not destroy adapter.", t);
            throw new RemoteException();
        }
    }
    
    public d getView() {
        if (!(this.nS instanceof MediationBannerAdapter)) {
            eu.D("MediationAdapter is not a MediationBannerAdapter: " + this.nS.getClass().getCanonicalName());
            throw new RemoteException();
        }
        try {
            return e.h(((MediationBannerAdapter)this.nS).getBannerView());
        }
        catch (Throwable t) {
            eu.c("Could not get banner view from adapter.", t);
            throw new RemoteException();
        }
    }
    
    public void pause() {
        try {
            this.nS.onPause();
        }
        catch (Throwable t) {
            eu.c("Could not pause adapter.", t);
            throw new RemoteException();
        }
    }
    
    public void resume() {
        try {
            this.nS.onResume();
        }
        catch (Throwable t) {
            eu.c("Could not resume adapter.", t);
            throw new RemoteException();
        }
    }
    
    public void showInterstitial() {
        if (!(this.nS instanceof MediationInterstitialAdapter)) {
            eu.D("MediationAdapter is not a MediationInterstitialAdapter: " + this.nS.getClass().getCanonicalName());
            throw new RemoteException();
        }
        eu.z("Showing interstitial from adapter.");
        try {
            ((MediationInterstitialAdapter)this.nS).showInterstitial();
        }
        catch (Throwable t) {
            eu.c("Could not show interstitial from adapter.", t);
            throw new RemoteException();
        }
    }
}
