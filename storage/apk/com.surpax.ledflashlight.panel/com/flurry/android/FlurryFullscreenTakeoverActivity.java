// 
// Decompiled by Procyon v0.5.29
// 

package com.flurry.android;

import java.util.Map;
import java.util.Collections;
import android.view.KeyEvent;
import com.flurry.sdk.n$d;
import com.flurry.sdk.n$c;
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
import com.flurry.sdk.n$e;
import com.flurry.sdk.z;
import android.content.Intent;
import com.flurry.sdk.f;
import com.flurry.sdk.n;
import android.view.ViewGroup;
import com.flurry.android.impl.ads.avro.protocol.v10.AdUnit;
import com.flurry.sdk.g;
import android.app.Activity;

public final class FlurryFullscreenTakeoverActivity extends Activity
{
    public static final String EXTRA_KEY_ADSPACENAME = "adSpaceName";
    public static final String EXTRA_KEY_FRAMEINDEX = "frameIndex";
    public static final String EXTRA_KEY_IS_MRAID_AD = "is_mraid_ad";
    public static final String EXTRA_KEY_SHOULD_CLOSE_AD = "should_close_ad";
    public static final String EXTRA_KEY_TARGETINTENT = "targetIntent";
    public static final String EXTRA_KEY_URL = "url";
    private static final String a;
    public static boolean fBasicWebViewClosingHandlerFired;
    private String b;
    private g c;
    private AdUnit d;
    private ViewGroup e;
    private n f;
    private f g;
    private boolean h;
    private boolean i;
    private Intent j;
    private String k;
    private long l;
    private boolean m;
    private boolean n;
    private z o;
    private n$e p;
    
    static {
        a = FlurryFullscreenTakeoverActivity.class.getSimpleName();
    }
    
    public FlurryFullscreenTakeoverActivity() {
        this.m = false;
        this.o = null;
        this.p = n$e.a;
    }
    
    private void a() {
        long longValue;
        boolean booleanValue;
        if (this.d != null) {
            longValue = this.d.m();
            booleanValue = this.d.q();
        }
        else {
            longValue = 0L;
            booleanValue = false;
        }
        if (this.m) {
            this.o = new z((Context)this, 0L, true, false, false);
            return;
        }
        this.o = new z((Context)this, longValue, booleanValue, true, false);
    }
    
    private void a(final int n) {
        final FlurryAdModule instance = FlurryAdModule.getInstance();
        AdUnit d = instance.Q();
        e e = instance.P();
        if (d == null && this.m) {
            d = instance.S();
            e = instance.R();
        }
        this.d = d;
        this.c = new g((Context)this, instance, e, d, n);
    }
    
    private void a(final String s, final int n) {
        if (!TextUtils.isEmpty((CharSequence)s) && this.g != null && this.e != null) {
            if (this.o == null) {
                this.a();
            }
            final FlurryAdModule instance = FlurryAdModule.getInstance();
            this.a(n);
            final AdUnit d = this.d;
            int a = 0;
            if (d != null) {
                this.o.setAdUnityView(this.c);
                final am c = instance.c(this.d.d().get(this.c.getAdFrameIndex()).g().toString());
                this.o.setVideoState(c);
                a = c.a();
            }
            this.setVideoOrientation();
            this.g.setMediaController(this.o);
            this.g.a();
            this.g.a(Uri.parse(s), a);
            this.e.addView((View)this.g, (ViewGroup$LayoutParams)new FrameLayout$LayoutParams(-1, -1, 17));
            if (this.f != null) {
                this.f.setVisibility(8);
            }
        }
    }
    
    private void a(final boolean b) {
        this.a();
        if (b) {
            this.g = new f((Context)this, this.c, this, this.o);
            return;
        }
        this.g = new f((Context)this, null, this, this.o);
    }
    
    private boolean a(final String s) {
        final boolean empty = TextUtils.isEmpty((CharSequence)s);
        boolean b = false;
        if (!empty) {
            final String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(s));
            b = false;
            if (mimeTypeFromExtension != null) {
                final boolean startsWith = mimeTypeFromExtension.startsWith("video/");
                b = false;
                if (startsWith) {
                    b = true;
                }
            }
        }
        return b;
    }
    
    private boolean a(final String anotherString, final String s) {
        if (!TextUtils.isEmpty((CharSequence)anotherString) && !TextUtils.isEmpty((CharSequence)s)) {
            final String queryParameter = Uri.parse(s).getQueryParameter("link");
            if (!TextUtils.isEmpty((CharSequence)queryParameter) && queryParameter.equalsIgnoreCase(anotherString)) {
                return true;
            }
        }
        return false;
    }
    
    private boolean b() {
        return !cb.a((Context)this) && this.c != null && this.c.getVideoView() != null && (this.c.getCurrentBinding() == 3 || this.c.getCurrentBinding() == 2);
    }
    
    public final void finish() {
        synchronized (this) {
            if (this.n) {
                return;
            }
            this.n = true;
            // monitorexit(this)
            super.finish();
        }
    }
    
    public final AdUnit getAdUnit() {
        return this.d;
    }
    
    public final g getAdUnityView() {
        return this.c;
    }
    
    public final n$e getResult() {
        return this.p;
    }
    
    public final boolean isMraidVideoActivity() {
        return this.m;
    }
    
    public final void onConfigurationChanged(final Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.setVideoOrientation();
    }
    
    public final void onCreate(final Bundle bundle) {
        int n = -1;
        eo.a(3, FlurryFullscreenTakeoverActivity.a, "onCreate");
        this.setTheme(16973831);
        super.onCreate(bundle);
        ch.a(this.getWindow());
        this.setVolumeControlStream(3);
        this.b = FlurryAdModule.getInstance().j();
        final Intent intent = this.getIntent();
        this.j = (Intent)intent.getParcelableExtra("targetIntent");
        this.k = intent.getStringExtra("adSpaceName");
        this.getWindowManager().getDefaultDisplay().getMetrics(new DisplayMetrics());
        final float density = this.getResources().getDisplayMetrics().density;
        FlurryFullscreenTakeoverActivity.fBasicWebViewClosingHandlerFired = false;
    Label_0157:
        while (true) {
            Label_0166: {
                if (bundle != null) {
                    break Label_0166;
                }
                while (true) {
                    if (n < 0) {
                        n = intent.getIntExtra("frameIndex", 0);
                    }
                    this.m = intent.getBooleanExtra("is_mraid_ad", false);
                    if (this.j == null) {
                        break Label_0166;
                    }
                    try {
                        this.startActivity(this.j);
                        this.l = SystemClock.elapsedRealtime();
                        FlurryAdModule.getInstance().a(this, bundle);
                        return;
                        n = bundle.getInt("frameIndex", n);
                        continue;
                    }
                    catch (ActivityNotFoundException ex) {
                        eo.a(FlurryFullscreenTakeoverActivity.a, "Cannot launch Activity", (Throwable)ex);
                        this.j = null;
                        this.finish();
                        continue Label_0157;
                    }
                    break;
                }
            }
            final String stringExtra = intent.getStringExtra("url");
            if (stringExtra == null) {
                this.e = (ViewGroup)new RelativeLayout((Context)this);
                final FlurryAdModule instance = FlurryAdModule.getInstance();
                this.d = instance.Q();
                if (this.d != null) {
                    (this.c = new g((Context)this, instance, instance.P(), this.d, n)).setFullScreenTakeover(this);
                    this.c.initLayout();
                    final RelativeLayout$LayoutParams relativeLayout$LayoutParams = new RelativeLayout$LayoutParams(-2, -2);
                    relativeLayout$LayoutParams.addRule(13);
                    this.e.addView((View)this.c, (ViewGroup$LayoutParams)relativeLayout$LayoutParams);
                    this.setContentView((View)this.e);
                    continue Label_0157;
                }
                eo.a(3, FlurryFullscreenTakeoverActivity.a, "appSpotModule.getTakeoverAdUnit() IS null ");
                continue Label_0157;
            }
            else {
                this.setContentView((View)(this.e = (ViewGroup)new FrameLayout((Context)this)));
                if (!this.a(stringExtra)) {
                    (this.f = new n((Context)this, stringExtra, intent.getBooleanExtra("should_close_ad", false))).setBasicWebViewUrlLoadingHandler(new FlurryFullscreenTakeoverActivity$c(this, n));
                    this.f.setBasicWebViewClosingHandler(new FlurryFullscreenTakeoverActivity$a(this, null));
                    this.f.setBasicWebViewFullScreenTransitionHandler(new FlurryFullscreenTakeoverActivity$b(this, null));
                    this.e.addView((View)this.f);
                    this.f.a((Context)this);
                    continue Label_0157;
                }
                this.a(n);
                if (this.d != null) {
                    this.a(true);
                    this.a(stringExtra, n);
                    continue Label_0157;
                }
                continue Label_0157;
            }
            break;
        }
    }
    
    protected final void onDestroy() {
        eo.a(3, FlurryFullscreenTakeoverActivity.a, "onDestroy");
        this.terminateVideoPlayback();
        if (this.f != null) {
            this.f.d();
        }
        if (this.c != null) {
            this.c.onDestroy();
        }
        FlurryAdModule.getInstance().b(this);
        super.onDestroy();
    }
    
    public final boolean onKeyUp(final int n, final KeyEvent keyEvent) {
        if (n == 4) {
            if (this.c != null) {
                this.c.a("adWillClose", Collections.emptyMap(), this.c.getAdUnit(), this.c.getAdLog(), this.c.getAdFrameIndex(), 0);
                return true;
            }
            if (this.g != null) {
                if (this.f != null) {
                    if (!this.h) {
                        this.terminateVideoPlayback();
                        return true;
                    }
                    if (this.f.a()) {
                        this.f.c();
                        this.terminateVideoPlayback();
                        return true;
                    }
                }
            }
            else if (this.f != null) {
                if (this.f.a()) {
                    this.f.c();
                }
                else if (this.f.b()) {
                    this.p = n$e.c;
                    this.finish();
                }
                else {
                    this.p = n$e.b;
                    this.finish();
                }
                return true;
            }
        }
        return super.onKeyUp(n, keyEvent);
    }
    
    protected final void onPause() {
        eo.a(3, FlurryFullscreenTakeoverActivity.a, "onPause");
        this.i = false;
        if (this.g != null && this.g.isPlaying()) {
            this.g.pause();
            eo.a(3, FlurryFullscreenTakeoverActivity.a, "in onPause in FFTA, should call suspend in AdUnityVideoView");
            this.g.d();
        }
        if (this.c != null) {
            this.c.c();
        }
        super.onPause();
    }
    
    protected final void onRestart() {
        eo.a(3, FlurryFullscreenTakeoverActivity.a, "onRestart");
        super.onRestart();
    }
    
    protected final void onResume() {
        eo.a(3, FlurryFullscreenTakeoverActivity.a, "onResume");
        super.onResume();
        this.i = true;
        if (this.c != null) {
            this.c.b();
        }
    }
    
    public final void onSaveInstanceState(final Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.c != null) {
            bundle.putInt("frameIndex", this.c.getAdFrameIndex());
        }
    }
    
    public final void onStart() {
        eo.a(3, FlurryFullscreenTakeoverActivity.a, "onStart");
        super.onStart();
        if (this.b != null) {
            FlurryAgent.onStartSession((Context)this, this.b);
            return;
        }
        this.finish();
    }
    
    public final void onStop() {
        eo.a(3, FlurryFullscreenTakeoverActivity.a, "onStop");
        if (this.b != null) {
            FlurryAgent.onEndSession((Context)this);
        }
        super.onStop();
    }
    
    public final void onWindowFocusChanged(final boolean b) {
        eo.a(3, FlurryFullscreenTakeoverActivity.a, "onWindowFocusChanged hasFocus = " + b);
        if (this.i && b && this.j != null && SystemClock.elapsedRealtime() - this.l > 250L) {
            eo.a(3, FlurryFullscreenTakeoverActivity.a, "terminate this launcher activity because launched activity was terminated or wasn't launched");
            this.finish();
        }
        super.onWindowFocusChanged(b);
    }
    
    public final void setVideoMoreInfoInProgress(final am videoState) {
        if (this.c != null && videoState != null) {
            this.c.setVideoState(videoState);
        }
    }
    
    public final void setVideoOrientation() {
        if (cb.a((Context)this)) {
            eo.b(FlurryFullscreenTakeoverActivity.a, "setVideoOrientation SCREEN_ORIENTATION_SENSOR");
            this.setRequestedOrientation(4);
        }
        else if (this.b()) {
            eo.b(FlurryFullscreenTakeoverActivity.a, "setVideoOrientation SCREEN_ORIENTATION_SENSOR_LANDSCAPE");
            this.setRequestedOrientation(6);
        }
    }
    
    public final void terminateVideoPlayback() {
        if (this.f != null) {
            this.f.setVisibility(0);
        }
        if (this.g != null) {
            this.g.c();
            if (this.e != null) {
                this.e.removeView((View)this.g);
            }
            this.g = null;
        }
        this.h = false;
    }
    
    public final void terminateVideoPlaybackDueToError() {
        eo.a(3, FlurryFullscreenTakeoverActivity.a, "onError");
        eo.b(FlurryFullscreenTakeoverActivity.a, "Error occurs during video playback");
        if (this.f == null) {
            this.finish();
            return;
        }
        if (!this.h) {
            this.terminateVideoPlayback();
            return;
        }
        if (this.f.a()) {
            this.f.c();
            this.terminateVideoPlayback();
            return;
        }
        this.finish();
    }
}
