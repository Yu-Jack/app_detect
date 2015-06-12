// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.media.MediaPlayer;
import android.text.TextUtils;
import android.view.MotionEvent;
import java.util.Map;
import java.util.HashMap;
import android.view.ViewGroup$LayoutParams;
import android.view.View;
import android.widget.FrameLayout$LayoutParams;
import android.content.Context;
import android.widget.VideoView;
import android.widget.MediaController;
import android.media.MediaPlayer$OnPreparedListener;
import android.media.MediaPlayer$OnErrorListener;
import android.media.MediaPlayer$OnCompletionListener;
import android.widget.FrameLayout;

public final class by extends FrameLayout implements MediaPlayer$OnCompletionListener, MediaPlayer$OnErrorListener, MediaPlayer$OnPreparedListener
{
    private final ep a;
    private final MediaController b;
    private final bz c;
    private final VideoView d;
    private long e;
    private String f;
    
    public by(final Context context, final ep a) {
        super(context);
        this.a = a;
        this.addView((View)(this.d = new VideoView(context)), (ViewGroup$LayoutParams)new FrameLayout$LayoutParams(-1, -1, 17));
        this.b = new MediaController(context);
        (this.c = new bz(this)).b();
        this.d.setOnCompletionListener((MediaPlayer$OnCompletionListener)this);
        this.d.setOnPreparedListener((MediaPlayer$OnPreparedListener)this);
        this.d.setOnErrorListener((MediaPlayer$OnErrorListener)this);
    }
    
    private static void a(final ep ep, final String s) {
        a(ep, s, new HashMap<String, String>(1));
    }
    
    public static void a(final ep ep, final String value, final String value2) {
        boolean b;
        if (value2 == null) {
            b = true;
        }
        else {
            b = false;
        }
        int initialCapacity;
        if (b) {
            initialCapacity = 2;
        }
        else {
            initialCapacity = 3;
        }
        final HashMap hashMap = new HashMap<String, String>(initialCapacity);
        hashMap.put("what", value);
        if (!b) {
            hashMap.put("extra", value2);
        }
        a(ep, "error", (Map<String, String>)hashMap);
    }
    
    private static void a(final ep ep, final String s, final String key, final String value) {
        final HashMap<String, String> hashMap = new HashMap<String, String>(2);
        hashMap.put(key, value);
        a(ep, s, hashMap);
    }
    
    private static void a(final ep ep, final String s, final Map<String, String> map) {
        map.put("event", s);
        ep.a("onVideoEvent", map);
    }
    
    public void a() {
        this.c.a();
        this.d.stopPlayback();
    }
    
    public void a(final int n) {
        this.d.seekTo(n);
    }
    
    public void a(final MotionEvent motionEvent) {
        this.d.dispatchTouchEvent(motionEvent);
    }
    
    public void a(final String f) {
        this.f = f;
    }
    
    public void a(final boolean b) {
        if (b) {
            this.d.setMediaController(this.b);
            return;
        }
        this.b.hide();
        this.d.setMediaController((MediaController)null);
    }
    
    public void b() {
        if (!TextUtils.isEmpty((CharSequence)this.f)) {
            this.d.setVideoPath(this.f);
            return;
        }
        a(this.a, "no_src", (String)null);
    }
    
    public void c() {
        this.d.pause();
    }
    
    public void d() {
        this.d.start();
    }
    
    public void e() {
        final long e = this.d.getCurrentPosition();
        if (this.e != e) {
            a(this.a, "timeupdate", "time", String.valueOf(e / 1000.0f));
            this.e = e;
        }
    }
    
    public void onCompletion(final MediaPlayer mediaPlayer) {
        a(this.a, "ended");
    }
    
    public boolean onError(final MediaPlayer mediaPlayer, final int i, final int j) {
        a(this.a, String.valueOf(i), String.valueOf(j));
        return true;
    }
    
    public void onPrepared(final MediaPlayer mediaPlayer) {
        a(this.a, "canplaythrough", "duration", String.valueOf(this.d.getDuration() / 1000.0f));
    }
}
