// 
// Decompiled by Procyon v0.5.29
// 

package com.flurry.android;

import android.view.ViewGroup$LayoutParams;
import android.widget.FrameLayout$LayoutParams;
import android.content.Context;
import android.view.ViewGroup;
import com.flurry.sdk.n;
import android.widget.FrameLayout;
import com.flurry.sdk.n$d$a;
import android.view.View;
import com.flurry.sdk.n$d;

final class FlurryFullscreenTakeoverActivity$b implements n$d
{
    final /* synthetic */ FlurryFullscreenTakeoverActivity a;
    private View b;
    private int c;
    private n$d$a d;
    private FrameLayout e;
    
    private FlurryFullscreenTakeoverActivity$b(final FlurryFullscreenTakeoverActivity a) {
        this.a = a;
    }
    
    @Override
    public final void a(final n n) {
        if (this.b == null) {
            return;
        }
        ((ViewGroup)this.a.getWindow().getDecorView()).removeView((View)this.e);
        this.e.removeView(this.b);
        if (this.d != null) {
            this.d.a();
        }
        this.a.setRequestedOrientation(this.c);
        this.d = null;
        this.e = null;
        this.b = null;
    }
    
    @Override
    public final void a(final n n, final View b, final int requestedOrientation, final n$d$a d) {
        if (this.b != null) {
            this.a(n);
        }
        this.b = b;
        this.c = this.a.getRequestedOrientation();
        this.d = d;
        (this.e = new FrameLayout((Context)this.a)).setBackgroundColor(-16777216);
        this.e.addView(this.b, (ViewGroup$LayoutParams)new FrameLayout$LayoutParams(-1, -1, 17));
        ((ViewGroup)this.a.getWindow().getDecorView()).addView((View)this.e, -1, -1);
        this.a.setRequestedOrientation(requestedOrientation);
    }
    
    @Override
    public final void a(final n n, final View view, final n$d$a n$d$a) {
        this.a(n, view, this.a.getRequestedOrientation(), n$d$a);
    }
}
