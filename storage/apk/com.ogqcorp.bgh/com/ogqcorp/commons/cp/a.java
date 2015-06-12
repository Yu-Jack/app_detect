// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.commons.cp;

import android.view.ViewGroup$LayoutParams;
import android.widget.RelativeLayout$LayoutParams;
import android.content.DialogInterface$OnCancelListener;
import android.content.DialogInterface;
import android.content.DialogInterface$OnClickListener;
import android.app.AlertDialog$Builder;
import android.view.ViewTreeObserver$OnGlobalLayoutListener;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.graphics.Color;
import android.view.MotionEvent;
import android.content.Context;
import android.view.View;
import android.app.AlertDialog;
import android.view.View$OnTouchListener;

public class a
{
    final View$OnTouchListener a;
    private View$OnTouchListener b;
    private AlertDialog c;
    private b d;
    private ColorBrowser e;
    private View f;
    private View g;
    private View h;
    private View i;
    private View j;
    private View k;
    private float[] l;
    
    public a(final Context context, final int n, final b d) {
        this.b = (View$OnTouchListener)new View$OnTouchListener() {
            public boolean onTouch(final View view, final MotionEvent motionEvent) {
                if (motionEvent.getAction() == 2 || motionEvent.getAction() == 0 || motionEvent.getAction() == 1) {
                    float x = motionEvent.getX();
                    final float y = motionEvent.getY();
                    if (x < 0.0f) {
                        x = 0.0f;
                    }
                    if (x > com.ogqcorp.commons.cp.a.this.e.getMeasuredWidth()) {
                        x = com.ogqcorp.commons.cp.a.this.e.getMeasuredWidth();
                    }
                    final float n = fcmpg(y, 0.0f);
                    float n2 = 0.0f;
                    if (n >= 0) {
                        n2 = y;
                    }
                    if (n2 > com.ogqcorp.commons.cp.a.this.e.getMeasuredHeight()) {
                        n2 = com.ogqcorp.commons.cp.a.this.e.getMeasuredHeight();
                    }
                    com.ogqcorp.commons.cp.a.this.b(x * (1.0f / com.ogqcorp.commons.cp.a.this.e.getMeasuredWidth()));
                    com.ogqcorp.commons.cp.a.this.c(1.0f - n2 * (1.0f / com.ogqcorp.commons.cp.a.this.e.getMeasuredHeight()));
                    com.ogqcorp.commons.cp.a.this.g();
                    com.ogqcorp.commons.cp.a.this.k.setBackgroundColor(com.ogqcorp.commons.cp.a.this.c());
                    return true;
                }
                return false;
            }
        };
        this.a = (View$OnTouchListener)new View$OnTouchListener() {
            public boolean onTouch(final View view, final MotionEvent motionEvent) {
                if (motionEvent.getAction() == 2 || motionEvent.getAction() == 0 || motionEvent.getAction() == 1) {
                    float y = motionEvent.getY();
                    if (y < 0.0f) {
                        y = 0.0f;
                    }
                    if (y > com.ogqcorp.commons.cp.a.this.g.getMeasuredHeight()) {
                        y = com.ogqcorp.commons.cp.a.this.g.getMeasuredHeight() - 0.001f;
                    }
                    final float n = 360.0f - y * (360.0f / com.ogqcorp.commons.cp.a.this.g.getMeasuredHeight());
                    final float n2 = fcmpl(n, 360.0f);
                    float hue = 0.0f;
                    if (n2 != 0) {
                        hue = n;
                    }
                    com.ogqcorp.commons.cp.a.this.a(hue);
                    com.ogqcorp.commons.cp.a.this.e.setHue(hue);
                    com.ogqcorp.commons.cp.a.this.h();
                    com.ogqcorp.commons.cp.a.this.k.setBackgroundColor(com.ogqcorp.commons.cp.a.this.c());
                    return true;
                }
                return false;
            }
        };
        Color.colorToHSV(n, this.l = new float[3]);
        this.d = d;
        final View inflate = LayoutInflater.from(context).inflate(com.ogqcorp.commons.cp.e.cmcp_dialog, (ViewGroup)null);
        this.a(inflate, n);
        (this.c = this.a(context)).setView(inflate, 0, 0, 0, 0);
        inflate.getViewTreeObserver().addOnGlobalLayoutListener((ViewTreeObserver$OnGlobalLayoutListener)new ViewTreeObserver$OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                com.ogqcorp.commons.cp.a.this.g();
                com.ogqcorp.commons.cp.a.this.h();
                com.ogqcorp.commons.cp.a.this.a(inflate, (ViewTreeObserver$OnGlobalLayoutListener)this);
            }
        });
    }
    
    private AlertDialog a(final Context context) {
        final AlertDialog$Builder alertDialog$Builder = new AlertDialog$Builder(context);
        alertDialog$Builder.setPositiveButton(17039370, (DialogInterface$OnClickListener)new DialogInterface$OnClickListener() {
            public void onClick(final DialogInterface dialogInterface, final int n) {
                if (com.ogqcorp.commons.cp.a.this.d != null) {
                    com.ogqcorp.commons.cp.a.this.d.a(com.ogqcorp.commons.cp.a.this, com.ogqcorp.commons.cp.a.this.c());
                }
            }
        });
        alertDialog$Builder.setNegativeButton(17039360, (DialogInterface$OnClickListener)new DialogInterface$OnClickListener() {
            public void onClick(final DialogInterface dialogInterface, final int n) {
                if (com.ogqcorp.commons.cp.a.this.d != null) {
                    com.ogqcorp.commons.cp.a.this.d.onCancel(com.ogqcorp.commons.cp.a.this);
                }
            }
        });
        alertDialog$Builder.setOnCancelListener((DialogInterface$OnCancelListener)new DialogInterface$OnCancelListener() {
            public void onCancel(final DialogInterface dialogInterface) {
                if (com.ogqcorp.commons.cp.a.this.d != null) {
                    com.ogqcorp.commons.cp.a.this.d.onCancel(com.ogqcorp.commons.cp.a.this);
                }
            }
        });
        return alertDialog$Builder.create();
    }
    
    private void a(final View view, final int n) {
        (this.e = (ColorBrowser)view.findViewById(com.ogqcorp.commons.cp.d.cmcp_color_browser)).setHue(this.d());
        this.e.setOnTouchListener(this.b);
        this.f = view.findViewById(com.ogqcorp.commons.cp.d.cmcp_container);
        (this.g = view.findViewById(com.ogqcorp.commons.cp.d.cmcp_hue)).setOnTouchListener(this.a);
        this.h = view.findViewById(com.ogqcorp.commons.cp.d.cmcp_cursor);
        this.i = view.findViewById(com.ogqcorp.commons.cp.d.cmcp_target);
        (this.j = view.findViewById(com.ogqcorp.commons.cp.d.cmcp_old)).setBackgroundColor(n);
        (this.k = view.findViewById(com.ogqcorp.commons.cp.d.cmcp_new)).setBackgroundColor(n);
    }
    
    private void a(final View view, final ViewTreeObserver$OnGlobalLayoutListener viewTreeObserver$OnGlobalLayoutListener) {
        view.getViewTreeObserver().removeGlobalOnLayoutListener(viewTreeObserver$OnGlobalLayoutListener);
    }
    
    private void g() {
        final float n = this.e() * this.e.getMeasuredWidth();
        final float n2 = (1.0f - this.f()) * this.e.getMeasuredHeight();
        final RelativeLayout$LayoutParams layoutParams = (RelativeLayout$LayoutParams)this.i.getLayoutParams();
        layoutParams.leftMargin = (int)(n + this.e.getLeft() - Math.floor(this.i.getMeasuredWidth() / 2) - this.f.getPaddingLeft());
        layoutParams.topMargin = (int)(n2 + this.e.getTop() - Math.floor(this.i.getMeasuredHeight() / 2) - this.f.getPaddingTop());
        this.i.setLayoutParams((ViewGroup$LayoutParams)layoutParams);
    }
    
    private void h() {
        final float n = this.g.getMeasuredHeight() - this.d() * this.g.getMeasuredHeight() / 360.0f;
        float n2;
        if (n == this.g.getMeasuredHeight()) {
            n2 = 0.0f;
        }
        else {
            n2 = n;
        }
        final RelativeLayout$LayoutParams layoutParams = (RelativeLayout$LayoutParams)this.h.getLayoutParams();
        layoutParams.leftMargin = (int)(this.g.getLeft() - Math.floor(this.h.getMeasuredWidth() / 2) - this.f.getPaddingLeft());
        layoutParams.topMargin = (int)(n2 + this.g.getTop() - Math.floor(this.h.getMeasuredHeight() / 2) - this.f.getPaddingTop());
        this.h.setLayoutParams((ViewGroup$LayoutParams)layoutParams);
    }
    
    public void a() {
        this.c.show();
    }
    
    public void a(final float n) {
        this.l[0] = n;
    }
    
    public AlertDialog b() {
        return this.c;
    }
    
    public void b(final float n) {
        this.l[1] = n;
    }
    
    public int c() {
        return Color.HSVToColor(this.l);
    }
    
    public void c(final float n) {
        this.l[2] = n;
    }
    
    public float d() {
        return this.l[0];
    }
    
    public float e() {
        return this.l[1];
    }
    
    public float f() {
        return this.l[2];
    }
}
