// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.widget;

import android.os.Parcelable;
import android.view.View$MeasureSpec;
import android.view.MotionEvent;
import android.view.ViewGroup$MarginLayoutParams;
import android.graphics.Bitmap;
import android.util.Log;
import android.graphics.Canvas;
import android.view.ViewGroup$LayoutParams;
import android.graphics.ColorFilter;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuff$Mode;
import android.graphics.Paint;
import android.support.v4.view.a;
import android.support.v4.view.ah;
import android.view.ViewConfiguration;
import android.util.AttributeSet;
import android.content.Context;
import android.os.Build$VERSION;
import java.util.ArrayList;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.view.View;

final class q extends aa
{
    final /* synthetic */ SlidingPaneLayout a;
    
    private q(final SlidingPaneLayout a) {
        this.a = a;
    }
    
    @Override
    public final void a(final int n) {
        if (this.a.q.a() == 0) {
            if (this.a.i != 0.0f) {
                final SlidingPaneLayout a = this.a;
                this.a.h;
                a.a();
                this.a.r = true;
                return;
            }
            this.a.a(this.a.h);
            final SlidingPaneLayout a2 = this.a;
            this.a.h;
            a2.b();
            this.a.r = false;
        }
    }
    
    @Override
    public final void a(final int n, final int n2) {
        this.a.q.a(this.a.h, n2);
    }
    
    @Override
    public final void a(final View view, final float n) {
        final SlidingPaneLayout$LayoutParams slidingPaneLayout$LayoutParams = (SlidingPaneLayout$LayoutParams)view.getLayoutParams();
        int n3;
        if (this.a.e()) {
            int n2 = this.a.getPaddingRight() + slidingPaneLayout$LayoutParams.rightMargin;
            if (n < 0.0f || (n == 0.0f && this.a.i > 0.5f)) {
                n2 += this.a.k;
            }
            n3 = this.a.getWidth() - n2 - this.a.h.getWidth();
        }
        else {
            n3 = this.a.getPaddingLeft() + slidingPaneLayout$LayoutParams.leftMargin;
            if (n > 0.0f || (n == 0.0f && this.a.i > 0.5f)) {
                n3 += this.a.k;
            }
        }
        this.a.q.a(n3, view.getTop());
        this.a.invalidate();
    }
    
    @Override
    public final void a(final View view, final int n) {
        SlidingPaneLayout.a(this.a, n);
        this.a.invalidate();
    }
    
    @Override
    public final boolean a(final View view) {
        return !this.a.l && ((SlidingPaneLayout$LayoutParams)view.getLayoutParams()).b;
    }
    
    @Override
    public final int b(final View view, final int n) {
        final SlidingPaneLayout$LayoutParams slidingPaneLayout$LayoutParams = (SlidingPaneLayout$LayoutParams)this.a.h.getLayoutParams();
        if (this.a.e()) {
            final int b = this.a.getWidth() - (this.a.getPaddingRight() + slidingPaneLayout$LayoutParams.rightMargin + this.a.h.getWidth());
            return Math.max(Math.min(n, b), b - this.a.k);
        }
        final int b2 = this.a.getPaddingLeft() + slidingPaneLayout$LayoutParams.leftMargin;
        return Math.min(Math.max(n, b2), b2 + this.a.k);
    }
    
    @Override
    public final void b(final View view) {
        this.a.c();
    }
    
    @Override
    public final int c(final View view) {
        return this.a.k;
    }
    
    @Override
    public final int d(final View view) {
        return view.getTop();
    }
}
