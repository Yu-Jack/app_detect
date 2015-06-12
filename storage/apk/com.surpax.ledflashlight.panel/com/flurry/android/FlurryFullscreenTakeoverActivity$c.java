// 
// Decompiled by Procyon v0.5.29
// 

package com.flurry.android;

import java.util.Map;
import java.util.Collections;
import android.view.KeyEvent;
import com.flurry.sdk.n$d;
import com.flurry.sdk.n$c;
import android.widget.FrameLayout;
import android.widget.RelativeLayout$LayoutParams;
import android.widget.RelativeLayout;
import android.content.ActivityNotFoundException;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import com.flurry.sdk.ch;
import com.flurry.sdk.eo;
import android.os.Bundle;
import android.content.res.Configuration;
import com.flurry.sdk.cb;
import android.webkit.MimeTypeMap;
import com.flurry.sdk.am;
import android.view.ViewGroup$LayoutParams;
import android.view.View;
import android.widget.FrameLayout$LayoutParams;
import android.net.Uri;
import com.flurry.android.impl.ads.avro.protocol.v10.AdFrame;
import android.text.TextUtils;
import com.flurry.sdk.e;
import com.flurry.sdk.n$e;
import com.flurry.sdk.z;
import android.content.Intent;
import com.flurry.sdk.f;
import android.view.ViewGroup;
import com.flurry.android.impl.ads.avro.protocol.v10.AdUnit;
import com.flurry.sdk.g;
import android.app.Activity;
import android.content.Context;
import com.flurry.android.impl.ads.FlurryAdModule;
import com.flurry.sdk.cf;
import com.flurry.sdk.n;
import com.flurry.sdk.n$f;

final class FlurryFullscreenTakeoverActivity$c implements n$f
{
    final /* synthetic */ FlurryFullscreenTakeoverActivity a;
    private int b;
    
    public FlurryFullscreenTakeoverActivity$c(final FlurryFullscreenTakeoverActivity a, final int b) {
        this.a = a;
        this.b = 0;
        this.b = b;
    }
    
    @Override
    public final boolean a(final n n, final String s, boolean b) {
        boolean b2 = true;
        if (this.a.a(s)) {
            this.a.h = b;
            this.a.a(false);
            this.a.a(s, this.b);
        }
        else if (cf.d(s)) {
            if (!b) {
                b = this.a.a(s, n.getUrl());
            }
            FlurryAdModule.getInstance().a().a((Context)this.a, s, this.a.k);
            if (b) {
                n.post((Runnable)new Runnable() {
                    @Override
                    public void run() {
                        if (n.a()) {
                            n.c();
                            return;
                        }
                        FlurryFullscreenTakeoverActivity$c.this.a.finish();
                    }
                });
                return b2;
            }
        }
        else if (cf.e(s)) {
            b2 = FlurryAdModule.getInstance().a().b((Context)this.a, s, this.a.k);
            if (b2) {
                if (!b) {
                    b = this.a.a(s, n.getUrl());
                }
                if (b) {
                    n.post((Runnable)new Runnable() {
                        @Override
                        public void run() {
                            if (n.a()) {
                                n.c();
                                return;
                            }
                            FlurryFullscreenTakeoverActivity$c.this.a.finish();
                        }
                    });
                    return b2;
                }
            }
        }
        else {
            b2 = FlurryAdModule.getInstance().a().c((Context)this.a, s, this.a.k);
            if (b2) {
                if (!b) {
                    b = this.a.a(s, n.getUrl());
                }
                if (b) {
                    n.post((Runnable)new Runnable() {
                        @Override
                        public void run() {
                            if (n.a()) {
                                n.c();
                                return;
                            }
                            FlurryFullscreenTakeoverActivity$c.this.a.finish();
                        }
                    });
                    return b2;
                }
            }
        }
        return b2;
    }
}
