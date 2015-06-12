// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.view;

import android.view.View$MeasureSpec;
import android.graphics.Canvas;
import android.os.Build$VERSION;
import android.view.KeyEvent;
import android.view.ViewGroup$LayoutParams;
import android.view.SoundEffectConstants;
import android.view.FocusFinder;
import android.util.Log;
import java.util.List;
import java.util.Collections;
import android.content.res.Resources$NotFoundException;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.ViewParent;
import android.view.ViewConfiguration;
import android.util.AttributeSet;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.Scroller;
import android.os.Parcelable;
import android.graphics.Rect;
import java.util.ArrayList;
import android.support.v4.widget.f;
import android.view.VelocityTracker;
import android.view.animation.Interpolator;
import java.util.Comparator;
import android.view.ViewGroup;
import android.support.v4.view.a.q;
import android.view.accessibility.AccessibilityEvent;
import android.os.Bundle;
import android.view.View;

final class bd extends a
{
    final /* synthetic */ ViewPager b;
    
    bd(final ViewPager b) {
        this.b = b;
    }
    
    private boolean b() {
        return this.b.h != null && this.b.h.a() > 1;
    }
    
    @Override
    public final void a(final View view, final android.support.v4.view.a.a a) {
        super.a(view, a);
        a.b(ViewPager.class.getName());
        a.i(this.b());
        if (this.b.canScrollHorizontally(1)) {
            a.a(4096);
        }
        if (this.b.canScrollHorizontally(-1)) {
            a.a(8192);
        }
    }
    
    @Override
    public final boolean a(final View view, final int n, final Bundle bundle) {
        if (super.a(view, n, bundle)) {
            return true;
        }
        switch (n) {
            default: {
                return false;
            }
            case 4096: {
                if (this.b.canScrollHorizontally(1)) {
                    this.b.a(1 + this.b.i);
                    return true;
                }
                return false;
            }
            case 8192: {
                if (this.b.canScrollHorizontally(-1)) {
                    this.b.a(-1 + this.b.i);
                    return true;
                }
                return false;
            }
        }
    }
    
    @Override
    public final void d(final View view, final AccessibilityEvent accessibilityEvent) {
        super.d(view, accessibilityEvent);
        accessibilityEvent.setClassName((CharSequence)ViewPager.class.getName());
        final q a = q.a();
        a.a(this.b());
        if (accessibilityEvent.getEventType() == 4096 && this.b.h != null) {
            a.a(this.b.h.a());
            a.b(this.b.i);
            a.c(this.b.i);
        }
    }
}
