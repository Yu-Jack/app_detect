// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.view.MotionEvent;
import java.util.Iterator;
import java.util.Map;
import android.net.Uri;
import android.content.DialogInterface$OnClickListener;
import android.app.AlertDialog$Builder;
import android.net.Uri$Builder;
import android.text.TextUtils;
import android.content.Context;

public final class ep
{
    private final Context mContext;
    private int mState;
    private String so;
    private final float sp;
    private float sq;
    private float sr;
    private float ss;
    
    public ep(final Context mContext) {
        this.mState = 0;
        this.mContext = mContext;
        this.sp = mContext.getResources().getDisplayMetrics().density;
    }
    
    public ep(final Context context, final String so) {
        this(context);
        this.so = so;
    }
    
    private void a(final int n, final float sq, final float n2) {
        if (n == 0) {
            this.mState = 0;
            this.sq = sq;
            this.sr = n2;
            this.ss = n2;
        }
        else if (this.mState != -1) {
            if (n == 2) {
                if (n2 > this.sr) {
                    this.sr = n2;
                }
                else if (n2 < this.ss) {
                    this.ss = n2;
                }
                if (this.sr - this.ss > 30.0f * this.sp) {
                    this.mState = -1;
                    return;
                }
                if (this.mState == 0 || this.mState == 2) {
                    if (sq - this.sq >= 50.0f * this.sp) {
                        this.sq = sq;
                        ++this.mState;
                    }
                }
                else if ((this.mState == 1 || this.mState == 3) && sq - this.sq <= -50.0f * this.sp) {
                    this.sq = sq;
                    ++this.mState;
                }
                if (this.mState == 1 || this.mState == 3) {
                    if (sq > this.sq) {
                        this.sq = sq;
                    }
                }
                else if (this.mState == 2 && sq < this.sq) {
                    this.sq = sq;
                }
            }
            else if (n == 1 && this.mState == 4) {
                this.showDialog();
            }
        }
    }
    
    private void showDialog() {
        String trim;
        if (!TextUtils.isEmpty((CharSequence)this.so)) {
            final Uri build = new Uri$Builder().encodedQuery(this.so).build();
            final StringBuilder sb = new StringBuilder();
            final Map c = eo.c(build);
            for (final String str : c.keySet()) {
                sb.append(str).append(" = ").append((String)c.get(str)).append("\n\n");
            }
            trim = sb.toString().trim();
            if (TextUtils.isEmpty((CharSequence)trim)) {
                trim = "No debug information";
            }
        }
        else {
            trim = "No debug information";
        }
        final AlertDialog$Builder alertDialog$Builder = new AlertDialog$Builder(this.mContext);
        alertDialog$Builder.setMessage((CharSequence)trim);
        alertDialog$Builder.setTitle((CharSequence)"Ad Information");
        alertDialog$Builder.setPositiveButton((CharSequence)"Share", (DialogInterface$OnClickListener)new ep$1(this, trim));
        alertDialog$Builder.setNegativeButton((CharSequence)"Close", (DialogInterface$OnClickListener)new ep$2(this));
        alertDialog$Builder.create().show();
    }
    
    public void c(final MotionEvent motionEvent) {
        for (int historySize = motionEvent.getHistorySize(), i = 0; i < historySize; ++i) {
            this.a(motionEvent.getActionMasked(), motionEvent.getHistoricalX(0, i), motionEvent.getHistoricalY(0, i));
        }
        this.a(motionEvent.getActionMasked(), motionEvent.getX(), motionEvent.getY());
    }
    
    public void x(final String so) {
        this.so = so;
    }
}
