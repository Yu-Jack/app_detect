// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook.ads;

import com.facebook.ads.a.a.b;
import com.facebook.ads.a.a.c;
import android.media.MediaPlayer$OnCompletionListener;
import android.media.MediaPlayer$OnPreparedListener;
import android.view.View$OnClickListener;
import android.view.MotionEvent;
import android.view.View$OnTouchListener;
import java.util.Arrays;
import android.view.ViewGroup$LayoutParams;
import android.widget.RelativeLayout$LayoutParams;
import android.os.Bundle;
import android.view.ViewTreeObserver$OnGlobalLayoutListener;
import android.content.res.Configuration;
import android.view.Display;
import com.facebook.ads.a.x;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.content.Context;
import android.content.Intent;
import java.util.Iterator;
import java.util.List;
import android.net.Uri;
import android.widget.RelativeLayout;
import android.os.Handler;
import android.media.MediaPlayer;
import android.widget.ImageButton;
import android.view.View;
import android.widget.VideoView;
import android.app.Activity;

public class VideoAdActivity extends Activity
{
    private VideoView a;
    private View b;
    private ImageButton c;
    private ImageButton d;
    private ImageButton e;
    private ImageButton f;
    private p g;
    private boolean h;
    private MediaPlayer i;
    private long j;
    private int k;
    private Handler l;
    private boolean m;
    private RelativeLayout n;
    private Uri o;
    private Uri p;
    private String q;
    private String r;
    private List s;
    private List t;
    private List u;
    private List v;
    private List w;
    private List x;
    
    public VideoAdActivity() {
        this.h = false;
        this.k = -1;
        this.l = new Handler();
        this.m = false;
    }
    
    private void a() {
        this.j = System.currentTimeMillis();
        this.b();
        this.l.removeCallbacksAndMessages((Object)null);
        this.l.postDelayed((Runnable)new Runnable() {
            @Override
            public final void run() {
                VideoAdActivity.this.b();
            }
        }, 3000L);
    }
    
    private void a(final p g) {
        if (g != this.g) {
            this.g = g;
            this.a();
        }
    }
    
    private void a(final List list) {
        for (final ImageButton imageButton : this.s) {
            if (list.contains(imageButton)) {
                imageButton.setVisibility(0);
            }
            else {
                imageButton.setVisibility(8);
            }
        }
    }
    
    private void b() {
        this.c.setAlpha(1.0f);
        this.d.setAlpha(1.0f);
        this.f.setAlpha(1.0f);
        this.a.setAlpha(1.0f);
        switch (VideoAdActivity$4.a[this.g.ordinal()]) {
            default: {}
            case 1: {
                if (System.currentTimeMillis() - this.j >= 3000L) {
                    this.a(this.u);
                    this.c.setAlpha(0.5f);
                    this.d.setAlpha(0.5f);
                    this.f.setAlpha(0.5f);
                    return;
                }
                this.a(this.t);
            }
            case 2: {
                this.a(this.v);
            }
            case 3: {
                this.a(this.x);
            }
            case 4: {
                this.a(this.x);
            }
            case 5: {
                this.a(this.w);
                this.i.seekTo((int)(0.75f * this.i.getDuration()));
                this.a.setAlpha(1.0f);
            }
        }
    }
    
    static /* synthetic */ void b(final VideoAdActivity videoAdActivity) {
        if (videoAdActivity.i != null) {
            final float min = Math.min(videoAdActivity.b.getWidth() / videoAdActivity.i.getVideoWidth(), videoAdActivity.b.getHeight() / videoAdActivity.i.getVideoHeight());
            videoAdActivity.a.getHolder().setFixedSize((int)(min * videoAdActivity.i.getVideoWidth()), (int)(min * videoAdActivity.i.getVideoHeight()));
            videoAdActivity.a.requestLayout();
            videoAdActivity.a.invalidate();
        }
    }
    
    private void c() {
        if (this.a.isPlaying()) {
            this.k = this.a.getCurrentPosition();
        }
        this.a.pause();
        this.l.removeCallbacksAndMessages((Object)null);
        this.i = null;
    }
    
    static /* synthetic */ void d(final VideoAdActivity videoAdActivity) {
        final Intent intent = new Intent((Context)videoAdActivity, (Class)InterstitialAdActivity.class);
        final Display defaultDisplay = ((WindowManager)videoAdActivity.getSystemService("window")).getDefaultDisplay();
        final DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        intent.putExtra("displayRotation", defaultDisplay.getRotation());
        intent.putExtra("displayWidth", displayMetrics.widthPixels);
        intent.putExtra("displayHeight", displayMetrics.heightPixels);
        intent.putExtra("adInterstitialUniqueId", videoAdActivity.r);
        x.b(videoAdActivity.getIntent()).a(intent);
        videoAdActivity.startActivity(intent);
        videoAdActivity.finish();
    }
    
    static /* synthetic */ void e(final VideoAdActivity videoAdActivity) {
        if (videoAdActivity.g != p.a) {
            if (videoAdActivity.h) {
                videoAdActivity.i.setVolume(1.0f, 1.0f);
                videoAdActivity.e.setBackground(videoAdActivity.getResources().getDrawable(17301554));
            }
            else {
                videoAdActivity.i.setVolume(0.0f, 0.0f);
                videoAdActivity.e.setBackground(videoAdActivity.getResources().getDrawable(17301553));
            }
            videoAdActivity.h = !videoAdActivity.h;
        }
    }
    
    static /* synthetic */ void k(final VideoAdActivity videoAdActivity) {
        if (videoAdActivity.g != p.a && videoAdActivity.g != p.c) {
            if (videoAdActivity.g == p.e) {
                videoAdActivity.a.seekTo(0);
            }
            videoAdActivity.a.start();
            videoAdActivity.k = videoAdActivity.a.getCurrentPosition();
            videoAdActivity.a(p.c);
        }
    }
    
    public void onConfigurationChanged(final Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.b.getViewTreeObserver().addOnGlobalLayoutListener((ViewTreeObserver$OnGlobalLayoutListener)new ViewTreeObserver$OnGlobalLayoutListener() {
            public final void onGlobalLayout() {
                VideoAdActivity.this.b.getViewTreeObserver().removeOnGlobalLayoutListener((ViewTreeObserver$OnGlobalLayoutListener)this);
                VideoAdActivity.b(VideoAdActivity.this);
            }
        });
    }
    
    public void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        this.requestWindowFeature(1);
        this.getWindow().setFlags(1024, 1024);
        this.n = new RelativeLayout((Context)this);
        final RelativeLayout$LayoutParams layoutParams = new RelativeLayout$LayoutParams(-1, -1);
        layoutParams.addRule(15);
        this.setContentView((View)this.n, (ViewGroup$LayoutParams)layoutParams);
        (this.a = new VideoView((Context)this)).setLayoutParams((ViewGroup$LayoutParams)layoutParams);
        this.n.addView((View)this.a);
        this.b = new View((Context)this);
        this.c = new ImageButton((Context)this);
        this.d = new ImageButton((Context)this);
        this.e = new ImageButton((Context)this);
        this.f = new ImageButton((Context)this);
        final Bundle extras = this.getIntent().getExtras();
        this.o = Uri.parse(extras.getString("adUri"));
        this.p = Uri.parse(extras.getString("adMarketUri"));
        this.q = extras.getString("adVideoPath");
        this.r = extras.getString("adInterstitialUniqueId");
        this.setVolumeControlStream(3);
        this.s = Arrays.asList(this.c, this.e, this.f, this.d);
        this.t = Arrays.asList(this.c, this.e, this.f, this.d);
        this.u = Arrays.asList(this.f, this.c, this.d);
        this.v = Arrays.asList(this.c, this.e, this.f, this.d);
        this.w = Arrays.asList(this.c, this.e, this.f, this.d);
        this.x = Arrays.asList(this.c, this.f, this.d);
        final View$OnTouchListener view$OnTouchListener = (View$OnTouchListener)new View$OnTouchListener() {
            public final boolean onTouch(final View view, final MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    view.setAlpha(0.5f);
                }
                else if (motionEvent.getAction() == 1) {
                    view.setAlpha(1.0f);
                }
                return false;
            }
        };
        this.c.setOnTouchListener((View$OnTouchListener)view$OnTouchListener);
        this.d.setOnTouchListener((View$OnTouchListener)view$OnTouchListener);
        this.e.setOnTouchListener((View$OnTouchListener)view$OnTouchListener);
        this.f.setOnTouchListener((View$OnTouchListener)view$OnTouchListener);
        this.c.setOnClickListener((View$OnClickListener)new View$OnClickListener() {
            public final void onClick(final View view) {
                VideoAdActivity.this.m = true;
                VideoAdActivity.this.finish();
            }
        });
        this.d.setOnClickListener((View$OnClickListener)new View$OnClickListener() {
            public final void onClick(final View view) {
                VideoAdActivity.d(VideoAdActivity.this);
            }
        });
        this.e.setOnClickListener((View$OnClickListener)new View$OnClickListener() {
            public final void onClick(final View view) {
                VideoAdActivity.e(VideoAdActivity.this);
            }
        });
        this.f.setOnClickListener((View$OnClickListener)new View$OnClickListener() {
            public final void onClick(final View view) {
                VideoAdActivity.this.finish();
            }
        });
        this.b.setOnTouchListener((View$OnTouchListener)new View$OnTouchListener() {
            public final boolean onTouch(final View view, final MotionEvent motionEvent) {
                VideoAdActivity.this.a();
                return false;
            }
        });
        this.a.setOnPreparedListener((MediaPlayer$OnPreparedListener)new MediaPlayer$OnPreparedListener() {
            public final void onPrepared(final MediaPlayer mediaPlayer) {
                VideoAdActivity.this.i = mediaPlayer;
                if (VideoAdActivity.this.h) {
                    VideoAdActivity.this.i.setVolume(0.0f, 0.0f);
                }
                else {
                    VideoAdActivity.this.i.setVolume(1.0f, 1.0f);
                }
                VideoAdActivity.b(VideoAdActivity.this);
                if (VideoAdActivity.this.g == com.facebook.ads.p.d || VideoAdActivity.this.g == com.facebook.ads.p.e) {
                    VideoAdActivity.this.i.seekTo(VideoAdActivity.this.k);
                }
                else {
                    if (VideoAdActivity.this.g == com.facebook.ads.p.c) {
                        VideoAdActivity.this.i.seekTo(VideoAdActivity.this.k);
                        VideoAdActivity.k(VideoAdActivity.this);
                        return;
                    }
                    if (VideoAdActivity.this.g == com.facebook.ads.p.a) {
                        VideoAdActivity.this.a(com.facebook.ads.p.b);
                        VideoAdActivity.k(VideoAdActivity.this);
                    }
                }
            }
        });
        this.a.setOnCompletionListener((MediaPlayer$OnCompletionListener)new MediaPlayer$OnCompletionListener() {
            public final void onCompletion(final MediaPlayer mediaPlayer) {
                VideoAdActivity.this.a(com.facebook.ads.p.e);
                VideoAdActivity.d(VideoAdActivity.this);
            }
        });
        this.a.setOnTouchListener((View$OnTouchListener)new View$OnTouchListener() {
            public final boolean onTouch(final View view, final MotionEvent motionEvent) {
                VideoAdActivity.this.a();
                return false;
            }
        });
        this.a(com.facebook.ads.p.a);
        this.c.setBackground(this.getResources().getDrawable(17301633));
        this.d.setBackground(this.getResources().getDrawable(17301569));
        this.e.setBackground(this.getResources().getDrawable(17301554));
        this.f.setBackground(this.getResources().getDrawable(17301560));
        this.a.setVideoPath(this.q);
        this.c.setX(270.0f);
        this.c.setY(1400.0f);
        this.d.setX(700.0f);
        this.d.setY(1400.0f);
        this.e.setX(10.0f);
        this.e.setY(1160.0f);
        this.f.setX(970.0f);
        this.c.setScaleX(1.5f);
        this.c.setScaleY(1.5f);
        this.d.setScaleX(1.5f);
        this.d.setScaleY(1.5f);
        this.n.addView(this.b);
        this.n.addView((View)this.c);
        this.n.addView((View)this.d);
        this.n.addView((View)this.e);
        this.n.addView((View)this.f);
    }
    
    protected void onDestroy() {
        super.onDestroy();
        if (this.m) {
            ((c)com.facebook.ads.a.a.b.a((Context)this, this.o)).b();
        }
    }
    
    protected void onPause() {
        super.onPause();
        this.c();
    }
    
    protected void onResume() {
        super.onResume();
        if (this.g == com.facebook.ads.p.c && !this.a.isPlaying()) {
            this.a.seekTo(this.k);
            this.a.start();
        }
        this.a();
    }
    
    protected void onStop() {
        super.onStop();
        this.c();
    }
}
