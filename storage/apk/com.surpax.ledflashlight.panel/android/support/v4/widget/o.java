// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.widget;

import android.view.accessibility.AccessibilityEvent;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.support.v4.view.ah;
import android.view.View;
import android.graphics.Rect;
import android.support.v4.view.a;

final class o extends a
{
    final /* synthetic */ SlidingPaneLayout b;
    private final Rect c;
    
    o(final SlidingPaneLayout b) {
        this.b = b;
        this.c = new Rect();
    }
    
    private boolean b(final View view) {
        return this.b.b(view);
    }
    
    @Override
    public final void a(final View view, final android.support.v4.view.a.a a) {
        final android.support.v4.view.a.a a2 = android.support.v4.view.a.a.a(a);
        super.a(view, a2);
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
        a.b(a2.c());
        a2.o();
        a.b(SlidingPaneLayout.class.getName());
        a.a(view);
        final ViewParent g = ah.g(view);
        if (g instanceof View) {
            a.c((View)g);
        }
        for (int childCount = this.b.getChildCount(), i = 0; i < childCount; ++i) {
            final View child = this.b.getChildAt(i);
            if (!this.b(child) && child.getVisibility() == 0) {
                ah.b(child, 1);
                a.b(child);
            }
        }
    }
    
    @Override
    public final boolean a(final ViewGroup viewGroup, final View view, final AccessibilityEvent accessibilityEvent) {
        return !this.b(view) && super.a(viewGroup, view, accessibilityEvent);
    }
    
    @Override
    public final void d(final View view, final AccessibilityEvent accessibilityEvent) {
        super.d(view, accessibilityEvent);
        accessibilityEvent.setClassName((CharSequence)SlidingPaneLayout.class.getName());
    }
}
