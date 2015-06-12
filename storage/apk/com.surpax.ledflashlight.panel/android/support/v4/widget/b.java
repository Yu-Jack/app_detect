// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.widget;

import android.os.Parcelable;
import android.view.View$MeasureSpec;
import android.support.v4.view.n;
import android.view.KeyEvent;
import android.support.v4.view.s;
import android.view.ViewGroup$MarginLayoutParams;
import android.graphics.Canvas;
import android.view.ViewGroup$LayoutParams;
import android.view.MotionEvent;
import android.os.SystemClock;
import android.support.v4.view.j;
import android.support.v4.view.av;
import android.util.AttributeSet;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.Paint;
import java.util.List;
import android.view.accessibility.AccessibilityEvent;
import android.view.ViewParent;
import android.view.ViewGroup;
import android.support.v4.view.ah;
import android.view.View;
import android.graphics.Rect;
import android.support.v4.view.a;

final class b extends a
{
    final /* synthetic */ DrawerLayout b;
    private final Rect c;
    
    b(final DrawerLayout b) {
        this.b = b;
        this.c = new Rect();
    }
    
    @Override
    public final void a(final View view, final android.support.v4.view.a.a a) {
        final android.support.v4.view.a.a a2 = android.support.v4.view.a.a.a(a);
        super.a(view, a2);
        a.b(DrawerLayout.class.getName());
        a.a(view);
        final ViewParent g = ah.g(view);
        if (g instanceof View) {
            a.c((View)g);
        }
        final Rect c = this.c;
        a2.a(c);
        a.b(c);
        a2.c(c);
        a.d(c);
        a.c(a2.f());
        a.a(a2.l());
        a.b(a2.m());
        a.c(a2.n());
        a.h(a2.k());
        a.f(a2.i());
        a.a(a2.d());
        a.b(a2.e());
        a.d(a2.g());
        a.e(a2.h());
        a.g(a2.j());
        a.a(a2.b());
        a2.o();
        final ViewGroup viewGroup = (ViewGroup)view;
        for (int childCount = viewGroup.getChildCount(), i = 0; i < childCount; ++i) {
            final View child = viewGroup.getChildAt(i);
            if (DrawerLayout.f(child)) {
                a.b(child);
            }
        }
    }
    
    @Override
    public final boolean a(final ViewGroup viewGroup, final View view, final AccessibilityEvent accessibilityEvent) {
        return DrawerLayout.f(view) && super.a(viewGroup, view, accessibilityEvent);
    }
    
    @Override
    public final boolean b(final View view, final AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() == 32) {
            final List text = accessibilityEvent.getText();
            final View a = this.b.c();
            if (a != null) {
                final CharSequence a2 = this.b.a(this.b.c(a));
                if (a2 != null) {
                    text.add(a2);
                }
            }
            return true;
        }
        return super.b(view, accessibilityEvent);
    }
    
    @Override
    public final void d(final View view, final AccessibilityEvent accessibilityEvent) {
        super.d(view, accessibilityEvent);
        accessibilityEvent.setClassName((CharSequence)DrawerLayout.class.getName());
    }
}
