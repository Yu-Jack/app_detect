// 
// Decompiled by Procyon v0.5.29
// 

package com.flurry.android;

import java.util.Map;
import java.util.Collections;
import android.view.KeyEvent;
import com.flurry.sdk.n$d;
import com.flurry.sdk.n$f;
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
import com.flurry.android.impl.ads.FlurryAdModule;
import android.content.Context;
import com.flurry.sdk.z;
import android.content.Intent;
import com.flurry.sdk.f;
import android.view.ViewGroup;
import com.flurry.android.impl.ads.avro.protocol.v10.AdUnit;
import com.flurry.sdk.g;
import android.app.Activity;
import com.flurry.sdk.n$e;
import com.flurry.sdk.n;
import com.flurry.sdk.n$c;

final class FlurryFullscreenTakeoverActivity$a implements n$c
{
    final /* synthetic */ FlurryFullscreenTakeoverActivity a;
    
    private FlurryFullscreenTakeoverActivity$a(final FlurryFullscreenTakeoverActivity a) {
        this.a = a;
    }
    
    @Override
    public final void a(final n n, final n$e n$e) {
        this.a.p = n$e;
        if (this.a.p == n$e.c) {
            FlurryFullscreenTakeoverActivity.fBasicWebViewClosingHandlerFired = true;
        }
        this.a.finish();
    }
}
