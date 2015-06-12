// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.widget;

import android.widget.Scroller;
import android.view.animation.Interpolator;
import android.content.Context;

class q implements p
{
    @Override
    public Object a(final Context context, final Interpolator interpolator) {
        if (interpolator != null) {
            return new Scroller(context, interpolator);
        }
        return new Scroller(context);
    }
    
    @Override
    public void a(final Object o, final int n, final int n2, final int n3, final int n4, final int n5) {
        ((Scroller)o).startScroll(n, n2, n3, n4, n5);
    }
    
    @Override
    public void a(final Object o, final int n, final int n2, final int n3, final int n4, final int n5, final int n6, final int n7, final int n8) {
        ((Scroller)o).fling(n, n2, n3, n4, n5, n6, n7, n8);
    }
    
    @Override
    public boolean a(final Object o) {
        return ((Scroller)o).isFinished();
    }
    
    @Override
    public int b(final Object o) {
        return ((Scroller)o).getCurrX();
    }
    
    @Override
    public int c(final Object o) {
        return ((Scroller)o).getCurrY();
    }
    
    @Override
    public float d(final Object o) {
        return 0.0f;
    }
    
    @Override
    public boolean e(final Object o) {
        return ((Scroller)o).computeScrollOffset();
    }
    
    @Override
    public void f(final Object o) {
        ((Scroller)o).abortAnimation();
    }
    
    @Override
    public int g(final Object o) {
        return ((Scroller)o).getFinalX();
    }
    
    @Override
    public int h(final Object o) {
        return ((Scroller)o).getFinalY();
    }
}
