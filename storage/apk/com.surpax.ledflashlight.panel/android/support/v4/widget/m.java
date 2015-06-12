// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.widget;

import android.widget.OverScroller;
import android.view.animation.Interpolator;
import android.content.Context;

class m implements k
{
    @Override
    public final Object a(final Context context, final Interpolator interpolator) {
        if (interpolator != null) {
            return new OverScroller(context, interpolator);
        }
        return new OverScroller(context);
    }
    
    @Override
    public final void a(final Object o, final int n, final int n2, final int n3, final int n4, final int n5) {
        ((OverScroller)o).startScroll(n, n2, n3, n4, n5);
    }
    
    @Override
    public final boolean a(final Object o) {
        return ((OverScroller)o).isFinished();
    }
    
    @Override
    public final int b(final Object o) {
        return ((OverScroller)o).getCurrX();
    }
    
    @Override
    public final int c(final Object o) {
        return ((OverScroller)o).getCurrY();
    }
    
    @Override
    public final boolean d(final Object o) {
        return ((OverScroller)o).computeScrollOffset();
    }
    
    @Override
    public final void e(final Object o) {
        ((OverScroller)o).abortAnimation();
    }
    
    @Override
    public final int f(final Object o) {
        return ((OverScroller)o).getFinalX();
    }
    
    @Override
    public final int g(final Object o) {
        return ((OverScroller)o).getFinalY();
    }
}
