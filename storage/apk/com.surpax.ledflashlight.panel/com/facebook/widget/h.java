// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook.widget;

import android.view.ViewGroup;
import com.facebook.a.f;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.FrameLayout;
import android.view.View$OnClickListener;
import android.view.View$MeasureSpec;
import android.app.Activity;
import com.facebook.a.d;
import com.facebook.a.e;
import android.widget.TextView;
import android.view.View;
import android.view.ViewTreeObserver$OnScrollChangedListener;
import android.widget.PopupWindow;
import android.content.Context;
import java.lang.ref.WeakReference;

public final class h
{
    private final String a;
    private final WeakReference b;
    private final Context c;
    private i d;
    private PopupWindow e;
    private j f;
    private long g;
    private final ViewTreeObserver$OnScrollChangedListener h;
    
    public h(final String a, final View referent) {
        this.f = j.a;
        this.g = 6000L;
        this.h = (ViewTreeObserver$OnScrollChangedListener)new ViewTreeObserver$OnScrollChangedListener() {
            public final void onScrollChanged() {
                if (com.facebook.widget.h.this.b.get() != null && com.facebook.widget.h.this.e != null && com.facebook.widget.h.this.e.isShowing()) {
                    if (!com.facebook.widget.h.this.e.isAboveAnchor()) {
                        com.facebook.widget.h.this.d.a();
                        return;
                    }
                    com.facebook.widget.h.this.d.b();
                }
            }
        };
        this.a = a;
        this.b = new WeakReference((T)referent);
        this.c = referent.getContext();
    }
    
    private void c() {
        if (this.b.get() != null) {
            ((View)this.b.get()).getViewTreeObserver().removeOnScrollChangedListener(this.h);
        }
    }
    
    public final void a() {
        if (this.b.get() != null) {
            this.d = new i(this, this.c);
            ((TextView)this.d.findViewById(com.facebook.a.e.e)).setText((CharSequence)this.a);
            if (this.f == j.a) {
                this.d.d.setBackgroundResource(com.facebook.a.d.j);
                this.d.c.setImageResource(com.facebook.a.d.k);
                this.d.b.setImageResource(com.facebook.a.d.l);
                this.d.e.setImageResource(com.facebook.a.d.m);
            }
            else {
                this.d.d.setBackgroundResource(com.facebook.a.d.f);
                this.d.c.setImageResource(com.facebook.a.d.g);
                this.d.b.setImageResource(com.facebook.a.d.h);
                this.d.e.setImageResource(com.facebook.a.d.i);
            }
            final View decorView = ((Activity)this.c).getWindow().getDecorView();
            final int width = decorView.getWidth();
            final int height = decorView.getHeight();
            this.c();
            if (this.b.get() != null) {
                ((View)this.b.get()).getViewTreeObserver().addOnScrollChangedListener(this.h);
            }
            this.d.onMeasure(View$MeasureSpec.makeMeasureSpec(width, Integer.MIN_VALUE), View$MeasureSpec.makeMeasureSpec(height, Integer.MIN_VALUE));
            (this.e = new PopupWindow((View)this.d, this.d.getMeasuredWidth(), this.d.getMeasuredHeight())).showAsDropDown((View)this.b.get());
            if (this.e != null && this.e.isShowing()) {
                if (this.e.isAboveAnchor()) {
                    this.d.b();
                }
                else {
                    this.d.a();
                }
            }
            if (this.g > 0L) {
                this.d.postDelayed((Runnable)new Runnable() {
                    @Override
                    public final void run() {
                        com.facebook.widget.h.this.b();
                    }
                }, this.g);
            }
            this.e.setTouchable(true);
            this.d.setOnClickListener((View$OnClickListener)new View$OnClickListener() {
                public final void onClick(final View view) {
                    com.facebook.widget.h.this.b();
                }
            });
        }
    }
    
    public final void a(final long g) {
        this.g = g;
    }
    
    public final void a(final j f) {
        this.f = f;
    }
    
    public final void b() {
        this.c();
        if (this.e != null) {
            this.e.dismiss();
        }
    }
}
