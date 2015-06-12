// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import com.google.a.a.f;
import android.app.Activity;
import com.google.a.a.e;
import com.google.android.gms.a.d;
import com.google.a.a.c;
import com.google.android.gms.a.a;
import java.util.Iterator;
import java.util.Map;
import android.os.RemoteException;
import java.util.HashMap;
import org.json.JSONObject;
import com.google.a.a.b;
import com.google.a.a.g;
import com.google.a.a.j;

public final class bn<NETWORK_EXTRAS extends j, SERVER_PARAMETERS extends g> extends bf
{
    private final b<NETWORK_EXTRAS, SERVER_PARAMETERS> a;
    private final NETWORK_EXTRAS b;
    
    public bn(final b<NETWORK_EXTRAS, SERVER_PARAMETERS> a, final NETWORK_EXTRAS b) {
        this.a = a;
        this.b = b;
    }
    
    private SERVER_PARAMETERS a(final String s, final int n, final String s2) {
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
                    en.c("Could not get MediationServerParameters.", t);
                    throw new RemoteException();
                }
            }
            hashMap = new HashMap<String, String>(0);
        }
        final Class<SERVER_PARAMETERS> c = this.a.c();
        g g = null;
        if (c != null) {
            g = c.newInstance();
            g.a(hashMap);
        }
        return (SERVER_PARAMETERS)g;
    }
    
    public a a() {
        if (!(this.a instanceof c)) {
            en.e("MediationAdapter is not a MediationBannerAdapter: " + this.a.getClass().getCanonicalName());
            throw new RemoteException();
        }
        try {
            return d.a(((c)this.a).d());
        }
        catch (Throwable t) {
            en.c("Could not get banner view from adapter.", t);
            throw new RemoteException();
        }
    }
    
    public void a(final a a, final ah ah, final String s, final bh bh) {
        this.a(a, ah, s, null, bh);
    }
    
    public void a(final a a, final ah ah, final String s, final String s2, final bh bh) {
        if (!(this.a instanceof e)) {
            en.e("MediationAdapter is not a MediationInterstitialAdapter: " + this.a.getClass().getCanonicalName());
            throw new RemoteException();
        }
        en.a("Requesting interstitial ad from adapter.");
        try {
            ((e)this.a).a(new bo<Object, Object>(bh), d.a(a), this.a(s, ah.g, s2), bp.a(ah), this.b);
        }
        catch (Throwable t) {
            en.c("Could not request interstitial ad from adapter.", t);
            throw new RemoteException();
        }
    }
    
    public void a(final a a, final ak ak, final ah ah, final String s, final bh bh) {
        this.a(a, ak, ah, s, null, bh);
    }
    
    public void a(final a a, final ak ak, final ah ah, final String s, final String s2, final bh bh) {
        if (!(this.a instanceof c)) {
            en.e("MediationAdapter is not a MediationBannerAdapter: " + this.a.getClass().getCanonicalName());
            throw new RemoteException();
        }
        en.a("Requesting banner ad from adapter.");
        try {
            ((c)this.a).a(new bo<Object, Object>(bh), d.a(a), this.a(s, ah.g, s2), bp.a(ak), bp.a(ah), this.b);
        }
        catch (Throwable t) {
            en.c("Could not request banner ad from adapter.", t);
            throw new RemoteException();
        }
    }
    
    public void b() {
        if (!(this.a instanceof e)) {
            en.e("MediationAdapter is not a MediationInterstitialAdapter: " + this.a.getClass().getCanonicalName());
            throw new RemoteException();
        }
        en.a("Showing interstitial from adapter.");
        try {
            ((e)this.a).d();
        }
        catch (Throwable t) {
            en.c("Could not show interstitial from adapter.", t);
            throw new RemoteException();
        }
    }
    
    public void c() {
        try {
            this.a.a();
        }
        catch (Throwable t) {
            en.c("Could not destroy adapter.", t);
            throw new RemoteException();
        }
    }
    
    public void d() {
        throw new RemoteException();
    }
    
    public void e() {
        throw new RemoteException();
    }
}
