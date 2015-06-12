// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.dynamic.e;
import android.app.Activity;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.dynamic.d;
import java.util.Iterator;
import java.util.Map;
import android.os.RemoteException;
import java.util.HashMap;
import org.json.JSONObject;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;
import com.google.ads.mediation.MediationAdapter;

public final class bz extends bu$a
{
    private final MediationAdapter nU;
    private final NetworkExtras nV;
    
    public bz(final MediationAdapter nu, final NetworkExtras nv) {
        this.nU = nu;
        this.nV = nv;
    }
    
    private MediationServerParameters b(final String s, final int n, final String s2) {
        HashMap<String, String> hashMap = null;
        Label_0104: {
            if (s != null) {
                try {
                    final JSONObject jsonObject = new JSONObject(s);
                    hashMap = new HashMap<String, String>(jsonObject.length());
                    final Iterator keys = jsonObject.keys();
                    while (keys.hasNext()) {
                        final String s3 = keys.next();
                        hashMap.put(s3, jsonObject.getString(s3));
                    }
                    break Label_0104;
                }
                catch (Throwable t) {
                    eu.c("Could not get MediationServerParameters.", t);
                    throw new RemoteException();
                }
            }
            hashMap = new HashMap<String, String>(0);
        }
        final Class serverParametersType = this.nU.getServerParametersType();
        MediationServerParameters mediationServerParameters = null;
        if (serverParametersType != null) {
            mediationServerParameters = serverParametersType.newInstance();
            mediationServerParameters.load(hashMap);
        }
        return mediationServerParameters;
    }
    
    public void a(final d d, final ai ai, final String s, final bv bv) {
        this.a(d, ai, s, null, bv);
    }
    
    public void a(final d d, final ai ai, final String s, final String s2, final bv bv) {
        if (!(this.nU instanceof MediationInterstitialAdapter)) {
            eu.D("MediationAdapter is not a MediationInterstitialAdapter: " + this.nU.getClass().getCanonicalName());
            throw new RemoteException();
        }
        eu.z("Requesting interstitial ad from adapter.");
        try {
            ((MediationInterstitialAdapter)this.nU).requestInterstitialAd(new ca(bv), (Activity)e.e(d), this.b(s, ai.lW, s2), cb.e(ai), this.nV);
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
        if (!(this.nU instanceof MediationBannerAdapter)) {
            eu.D("MediationAdapter is not a MediationBannerAdapter: " + this.nU.getClass().getCanonicalName());
            throw new RemoteException();
        }
        eu.z("Requesting banner ad from adapter.");
        try {
            ((MediationBannerAdapter)this.nU).requestBannerAd(new ca(bv), (Activity)e.e(d), this.b(s, ai.lW, s2), cb.b(al), cb.e(ai), this.nV);
        }
        catch (Throwable t) {
            eu.c("Could not request banner ad from adapter.", t);
            throw new RemoteException();
        }
    }
    
    public void destroy() {
        try {
            this.nU.destroy();
        }
        catch (Throwable t) {
            eu.c("Could not destroy adapter.", t);
            throw new RemoteException();
        }
    }
    
    public d getView() {
        if (!(this.nU instanceof MediationBannerAdapter)) {
            eu.D("MediationAdapter is not a MediationBannerAdapter: " + this.nU.getClass().getCanonicalName());
            throw new RemoteException();
        }
        try {
            return e.h(((MediationBannerAdapter)this.nU).getBannerView());
        }
        catch (Throwable t) {
            eu.c("Could not get banner view from adapter.", t);
            throw new RemoteException();
        }
    }
    
    public void pause() {
        throw new RemoteException();
    }
    
    public void resume() {
        throw new RemoteException();
    }
    
    public void showInterstitial() {
        if (!(this.nU instanceof MediationInterstitialAdapter)) {
            eu.D("MediationAdapter is not a MediationInterstitialAdapter: " + this.nU.getClass().getCanonicalName());
            throw new RemoteException();
        }
        eu.z("Showing interstitial from adapter.");
        try {
            ((MediationInterstitialAdapter)this.nU).showInterstitial();
        }
        catch (Throwable t) {
            eu.c("Could not show interstitial from adapter.", t);
            throw new RemoteException();
        }
    }
}
