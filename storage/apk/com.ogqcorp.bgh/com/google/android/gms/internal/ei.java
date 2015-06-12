// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.view.MotionEvent;
import java.util.Iterator;
import java.util.Map;
import android.net.Uri;
import android.content.Intent;
import android.content.DialogInterface;
import android.content.DialogInterface$OnClickListener;
import android.app.AlertDialog$Builder;
import android.net.Uri$Builder;
import android.text.TextUtils;
import android.content.Context;

public final class ei
{
    private final Context a;
    private String b;
    private final float c;
    private float d;
    private float e;
    private float f;
    private int g;
    
    public ei(final Context a) {
        this.g = 0;
        this.a = a;
        this.c = a.getResources().getDisplayMetrics().density;
    }
    
    public ei(final Context context, final String b) {
        this(context);
        this.b = b;
    }
    
    private void a() {
        String trim;
        if (!TextUtils.isEmpty((CharSequence)this.b)) {
            final Uri build = new Uri$Builder().encodedQuery(this.b).build();
            final StringBuilder sb = new StringBuilder();
            final Map<String, String> a = eg.a(build);
            for (final String str : a.keySet()) {
                sb.append(str).append(" = ").append(a.get(str)).append("\n\n");
            }
            trim = sb.toString().trim();
            if (TextUtils.isEmpty((CharSequence)trim)) {
                trim = "No debug information";
            }
        }
        else {
            trim = "No debug information";
        }
        final AlertDialog$Builder alertDialog$Builder = new AlertDialog$Builder(this.a);
        alertDialog$Builder.setMessage((CharSequence)trim);
        alertDialog$Builder.setTitle((CharSequence)"Ad Information");
        alertDialog$Builder.setPositiveButton((CharSequence)"Share", (DialogInterface$OnClickListener)new DialogInterface$OnClickListener() {
            public void onClick(final DialogInterface dialogInterface, final int n) {
                ei.this.a.startActivity(Intent.createChooser(new Intent("android.intent.action.SEND").setType("text/plain").putExtra("android.intent.extra.TEXT", trim), (CharSequence)"Share via"));
            }
        });
        alertDialog$Builder.setNegativeButton((CharSequence)"Close", (DialogInterface$OnClickListener)new DialogInterface$OnClickListener() {
            public void onClick(final DialogInterface dialogInterface, final int n) {
            }
        });
        alertDialog$Builder.create().show();
    }
    
    private void a(final int n, final float d, final float n2) {
        if (n == 0) {
            this.g = 0;
            this.d = d;
            this.e = n2;
            this.f = n2;
        }
        else if (this.g != -1) {
            if (n == 2) {
                if (n2 > this.e) {
                    this.e = n2;
                }
                else if (n2 < this.f) {
                    this.f = n2;
                }
                if (this.e - this.f > 30.0f * this.c) {
                    this.g = -1;
                    return;
                }
                if (this.g == 0 || this.g == 2) {
                    if (d - this.d >= 50.0f * this.c) {
                        this.d = d;
                        ++this.g;
                    }
                }
                else if ((this.g == 1 || this.g == 3) && d - this.d <= -50.0f * this.c) {
                    this.d = d;
                    ++this.g;
                }
                if (this.g == 1 || this.g == 3) {
                    if (d > this.d) {
                        this.d = d;
                    }
                }
                else if (this.g == 2 && d < this.d) {
                    this.d = d;
                }
            }
            else if (n == 1 && this.g == 4) {
                this.a();
            }
        }
    }
    
    public void a(final MotionEvent motionEvent) {
        for (int historySize = motionEvent.getHistorySize(), i = 0; i < historySize; ++i) {
            this.a(motionEvent.getActionMasked(), motionEvent.getHistoricalX(0, i), motionEvent.getHistoricalY(0, i));
        }
        this.a(motionEvent.getActionMasked(), motionEvent.getX(), motionEvent.getY());
    }
    
    public void a(final String b) {
        this.b = b;
    }
}
