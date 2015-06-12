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

public final class cj extends FrameLayout implements MediaPlayer$OnCompletionListener, MediaPlayer$OnErrorListener, MediaPlayer$OnPreparedListener
{
    private final ex lN;
    private final MediaController oI;
    private final cj$a oJ;
    private final VideoView oK;
    private long oL;
    private String oM;
    
    public cj(final Context context, final ex ln) {
        super(context);
        this.lN = ln;
        this.addView((View)(this.oK = new VideoView(context)), (ViewGroup$LayoutParams)new FrameLayout$LayoutParams(-1, -1, 17));
        this.oI = new MediaController(context);
        (this.oJ = new cj$a(this)).bc();
        this.oK.setOnCompletionListener((MediaPlayer$OnCompletionListener)this);
        this.oK.setOnPreparedListener((MediaPlayer$OnPreparedListener)this);
        this.oK.setOnErrorListener((MediaPlayer$OnErrorListener)this);
    }
    
    private static void a(final ex ex, final String s) {
        a(ex, s, new HashMap(1));
    }
    
    public static void a(final ex ex, final String value, final String value2) {
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
        a(ex, "error", hashMap);
    }
    
    private static void a(final ex ex, final String s, final String key, final String value) {
        final HashMap<String, String> hashMap = new HashMap<String, String>(2);
        hashMap.put(key, value);
        a(ex, s, hashMap);
    }
    
    private static void a(final ex ex, final String s, final Map map) {
        map.put("event", s);
        ex.a("onVideoEvent", map);
    }
    
    public void b(final MotionEvent motionEvent) {
        this.oK.dispatchTouchEvent(motionEvent);
    }
    
    public void ba() {
        if (!TextUtils.isEmpty((CharSequence)this.oM)) {
            this.oK.setVideoPath(this.oM);
            return;
        }
        a(this.lN, "no_src", (String)null);
    }
    
    public void bb() {
        final long ol = this.oK.getCurrentPosition();
        if (this.oL != ol) {
            a(this.lN, "timeupdate", "time", String.valueOf(ol / 1000.0f));
            this.oL = ol;
        }
    }
    
    public void destroy() {
        this.oJ.cancel();
        this.oK.stopPlayback();
    }
    
    public void l(final boolean b) {
        if (b) {
            this.oK.setMediaController(this.oI);
            return;
        }
        this.oI.hide();
        this.oK.setMediaController((MediaController)null);
    }
    
    public void o(final String om) {
        this.oM = om;
    }
    
    public void onCompletion(final MediaPlayer mediaPlayer) {
        a(this.lN, "ended");
    }
    
    public boolean onError(final MediaPlayer mediaPlayer, final int i, final int j) {
        a(this.lN, String.valueOf(i), String.valueOf(j));
        return true;
    }
    
    public void onPrepared(final MediaPlayer mediaPlayer) {
        a(this.lN, "canplaythrough", "duration", String.valueOf(this.oK.getDuration() / 1000.0f));
    }
    
    public void pause() {
        this.oK.pause();
    }
    
    public void play() {
        this.oK.start();
    }
    
    public void seekTo(final int n) {
        this.oK.seekTo(n);
    }
}
