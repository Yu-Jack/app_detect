// 
// Decompiled by Procyon v0.5.29
// 

package com.flurry.android.monolithic.sdk.impl;

import com.flurry.android.impl.ads.avro.protocol.v6.AdFrame;
import android.view.KeyEvent;
import android.content.DialogInterface;
import android.view.View;
import java.util.Collections;
import android.media.MediaPlayer;
import com.flurry.android.impl.ads.avro.protocol.v6.AdUnit;
import java.util.Map;
import java.util.List;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.annotation.SuppressLint;
import android.media.MediaPlayer$OnPreparedListener;
import android.media.MediaPlayer$OnErrorListener;
import android.media.MediaPlayer$OnCompletionListener;
import android.content.DialogInterface$OnKeyListener;

@SuppressLint({ "SetJavaScriptEnabled" })
public class o extends ac implements DialogInterface$OnKeyListener, MediaPlayer$OnCompletionListener, MediaPlayer$OnErrorListener, MediaPlayer$OnPreparedListener
{
    private final String e;
    private ProgressDialog f;
    private n g;
    private boolean h;
    private AlertDialog i;
    private List j;
    
    private void a(final String str, final Map obj, final AdUnit adUnit, final gn gn, final int n) {
        final String e = this.e;
        gj.a(3, "fireEvent(event=" + str + ",params=" + obj + ")");
        this.a.a((bh)new el(str, obj, this.getContext(), adUnit, gn, n), (ci)this, 0);
    }
    
    public void onCompletion(final MediaPlayer mediaPlayer) {
        this.a("videoCompleted", Collections.emptyMap(), this.c, this.b, this.d);
    }
    
    public boolean onError(final MediaPlayer mediaPlayer, final int n, final int n2) {
        if (this.f != null && this.f.isShowing()) {
            this.f.dismiss();
        }
        this.a("renderFailed", Collections.emptyMap(), this.c, this.b, this.d);
        this.removeView((View)this.g);
        return false;
    }
    
    public boolean onKey(final DialogInterface dialogInterface, final int i, final KeyEvent keyEvent) {
        gj.a(3, "onkey,keycode=" + i + ",event=" + keyEvent.getAction());
        if (dialogInterface == this.f && i == 4 && keyEvent.getAction() == 0) {
            this.a("adWillClose", Collections.emptyMap(), this.c, this.b, this.d);
            dialogInterface.dismiss();
            return true;
        }
        return false;
    }
    
    public void onPrepared(final MediaPlayer mediaPlayer) {
        if (this.j.get(this.d).b() == 3) {
            if (this.f.isShowing()) {
                this.f.dismiss();
            }
            if ((this.i == null || !this.i.isShowing()) && this.g != null && this.h) {
                this.g.start();
            }
            this.a("rendered", Collections.emptyMap(), this.c, this.b, this.d);
            this.a("videoStart", Collections.emptyMap(), this.c, this.b, this.d);
        }
    }
}
