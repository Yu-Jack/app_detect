// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook.ads;

import android.view.Display;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.content.Intent;
import com.facebook.ads.a.x;
import com.facebook.ads.a.q;
import java.util.UUID;
import com.facebook.ads.a.o;
import com.facebook.ads.a.m;
import android.content.Context;

public final class i implements a
{
    private final Context a;
    private final String b;
    private m c;
    private final j d;
    private l e;
    private boolean f;
    private o g;
    
    public i(final Context a, final String s) {
        this.f = false;
        this.a = a;
        this.b = UUID.randomUUID().toString();
        this.c = new m(this.a, s, com.facebook.ads.e.b, false, q.a, new com.facebook.ads.a.l() {
            @Override
            public final void a(final o o) {
                i.this.g = o;
                if (o.d() != null && o.d() instanceof x) {
                    i.this.f = true;
                    if (i.this.e != null) {
                        i.this.e.onAdLoaded(i.this);
                    }
                }
                else if (o.d() == null) {
                    i.this.f = false;
                    if (i.this.e != null) {
                        final com.facebook.ads.l a = i.this.e;
                        final i a2 = i.this;
                        b b;
                        if (o.e() != null) {
                            b = o.e();
                        }
                        else {
                            b = com.facebook.ads.b.c;
                        }
                        a.onError(a2, b);
                    }
                }
                else {
                    i.this.f = false;
                    if (i.this.e != null) {
                        i.this.e.onError(i.this, com.facebook.ads.b.c);
                    }
                }
            }
            
            @Override
            public final void a(final b b) {
                i.this.f = false;
                if (i.this.e != null) {
                    i.this.e.onError(i.this, b);
                }
            }
        });
        (this.d = new j(this, (byte)0)).a();
    }
    
    public final void a() {
        if (this.c == null) {
            throw new RuntimeException("No request controller available, has the InterstitialAd been destroyed?");
        }
        this.f = false;
        this.c.b();
    }
    
    public final void a(final l e) {
        this.e = e;
    }
    
    public final void b() {
        if (this.c != null) {
            this.c.c();
            this.c = null;
            this.d.b();
        }
    }
    
    public final boolean c() {
        return this.f;
    }
    
    public final boolean d() {
        if (!this.f) {
            if (this.e != null) {
                this.e.onError(this, com.facebook.ads.b.c);
            }
            return false;
        }
        final Intent intent = new Intent(this.a, (Class)InterstitialAdActivity.class);
        ((x)this.g.d()).a(intent);
        this.f = false;
        final Display defaultDisplay = ((WindowManager)this.a.getSystemService("window")).getDefaultDisplay();
        final DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        intent.putExtra("displayRotation", defaultDisplay.getRotation());
        intent.putExtra("displayWidth", displayMetrics.widthPixels);
        intent.putExtra("displayHeight", displayMetrics.heightPixels);
        intent.putExtra("adInterstitialUniqueId", this.b);
        this.a.startActivity(intent);
        return true;
    }
}
