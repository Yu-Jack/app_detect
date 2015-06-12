// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.view;

import android.database.DataSetObserver;
import android.view.View$MeasureSpec;
import android.graphics.Canvas;
import android.view.SoundEffectConstants;
import android.view.FocusFinder;
import android.util.Log;
import android.view.ViewGroup$LayoutParams;
import android.os.Build$VERSION;
import android.view.KeyEvent;
import android.content.res.Resources$NotFoundException;
import android.view.ViewConfiguration;
import java.util.List;
import java.util.Collections;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.ViewParent;
import android.util.AttributeSet;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.Scroller;
import android.os.Parcelable;
import android.graphics.Rect;
import java.util.ArrayList;
import java.lang.reflect.Method;
import android.support.v4.widget.i;
import android.view.VelocityTracker;
import android.view.animation.Interpolator;
import java.util.Comparator;
import android.view.ViewGroup;
import android.support.v4.view.a.s;
import android.view.accessibility.AccessibilityEvent;
import android.os.Bundle;
import android.view.View;

class bj extends a
{
    final /* synthetic */ ViewPager b;
    
    bj(final ViewPager b) {
        this.b = b;
    }
    
    private boolean b() {
        return this.b.h != null && this.b.h.getCount() > 1;
    }
    
    @Override
    public void a(final View view, final android.support.v4.view.a.a a) {
        super.a(view, a);
        a.a(ViewPager.class.getName());
        a.a(this.b());
        if (this.b.canScrollHorizontally(1)) {
            a.a(4096);
        }
        if (this.b.canScrollHorizontally(-1)) {
            a.a(8192);
        }
    }
    
    @Override
    public boolean a(final View view, final int n, final Bundle bundle) {
        if (super.a(view, n, bundle)) {
            return true;
        }
        switch (n) {
            default: {
                return false;
            }
            case 4096: {
                if (this.b.canScrollHorizontally(1)) {
                    this.b.setCurrentItem(1 + this.b.i);
                    return true;
                }
                return false;
            }
            case 8192: {
                if (this.b.canScrollHorizontally(-1)) {
                    this.b.setCurrentItem(-1 + this.b.i);
                    return true;
                }
                return false;
            }
        }
    }
    
    @Override
    public void d(final View view, final AccessibilityEvent accessibilityEvent) {
        super.d(view, accessibilityEvent);
        accessibilityEvent.setClassName((CharSequence)ViewPager.class.getName());
        final s a = s.a();
        a.a(this.b());
        if (accessibilityEvent.getEventType() == 4096 && this.b.h != null) {
            a.a(this.b.h.getCount());
            a.b(this.b.i);
            a.c(this.b.i);
        }
    }
}
