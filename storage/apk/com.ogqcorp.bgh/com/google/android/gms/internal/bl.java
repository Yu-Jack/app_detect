// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import com.google.android.gms.ads.g;
import com.google.android.gms.ads.c.f;
import java.util.Set;
import java.util.Date;
import android.content.Context;
import java.util.Collection;
import java.util.HashSet;
import com.google.android.gms.ads.c.e;
import com.google.android.gms.a.d;
import com.google.android.gms.ads.c.c;
import java.util.Iterator;
import com.google.a.a.a.a;
import android.os.RemoteException;
import org.json.JSONObject;
import android.os.Bundle;
import com.google.android.gms.ads.c.b;

public final class bl extends bf
{
    private final b a;
    private final Bundle b;
    
    public bl(final b a, final Bundle b) {
        this.a = a;
        this.b = b;
    }
    
    private Bundle a(final String str, final int n, final String s) {
        en.e("Server parameters: " + str);
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
                en.c("Could not get Server Parameters Bundle.", t);
                throw new RemoteException();
            }
            bundle = bundle2;
        }
        if (this.a instanceof a) {
            bundle.putString("adJson", s);
            bundle.putInt("tagForChildDirectedTreatment", n);
        }
        return bundle;
    }
    
    public com.google.android.gms.a.a a() {
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
    
    public void a(final com.google.android.gms.a.a a, final ah ah, final String s, final bh bh) {
        this.a(a, ah, s, null, bh);
    }
    
    public void a(final com.google.android.gms.a.a a, final ah ah, final String s, final String s2, final bh bh) {
        if (!(this.a instanceof e)) {
            en.e("MediationAdapter is not a MediationInterstitialAdapter: " + this.a.getClass().getCanonicalName());
            throw new RemoteException();
        }
        en.a("Requesting interstitial ad from adapter.");
        try {
            final e e = (e)this.a;
            HashSet<String> set;
            if (ah.e != null) {
                set = new HashSet<String>(ah.e);
            }
            else {
                set = null;
            }
            e.a(d.a(a), new bm(bh), this.a(s, ah.g, s2), new bk(new Date(ah.b), ah.d, set, ah.f, ah.g), this.b);
        }
        catch (Throwable t) {
            en.c("Could not request interstitial ad from adapter.", t);
            throw new RemoteException();
        }
    }
    
    public void a(final com.google.android.gms.a.a a, final ak ak, final ah ah, final String s, final bh bh) {
        this.a(a, ak, ah, s, null, bh);
    }
    
    public void a(final com.google.android.gms.a.a a, final ak ak, final ah ah, final String s, final String s2, final bh bh) {
        if (!(this.a instanceof c)) {
            en.e("MediationAdapter is not a MediationBannerAdapter: " + this.a.getClass().getCanonicalName());
            throw new RemoteException();
        }
        en.a("Requesting banner ad from adapter.");
        try {
            final c c = (c)this.a;
            HashSet<String> set;
            if (ah.e != null) {
                set = new HashSet<String>(ah.e);
            }
            else {
                set = null;
            }
            c.a(d.a(a), new bm(bh), this.a(s, ah.g, s2), g.a(ak.f, ak.c, ak.b), new bk(new Date(ah.b), ah.d, set, ah.f, ah.g), this.b);
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
            ((e)this.a).e();
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
        try {
            this.a.b();
        }
        catch (Throwable t) {
            en.c("Could not pause adapter.", t);
            throw new RemoteException();
        }
    }
    
    public void e() {
        try {
            this.a.c();
        }
        catch (Throwable t) {
            en.c("Could not resume adapter.", t);
            throw new RemoteException();
        }
    }
}
