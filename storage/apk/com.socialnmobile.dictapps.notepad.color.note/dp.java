import android.widget.Scroller;
import android.view.animation.Interpolator;
import android.content.Context;

// 
// Decompiled by Procyon v0.5.29
// 

final class dp implements do
{
    @Override
    public final Object a(final Context context, final Interpolator interpolator) {
        if (interpolator != null) {
            return new Scroller(context, interpolator);
        }
        return new Scroller(context);
    }
    
    @Override
    public final void a(final Object o, final int n, final int n2, final int n3, final int n4, final int n5) {
        ((Scroller)o).startScroll(n, n2, n3, n4, n5);
    }
    
    @Override
    public final boolean a(final Object o) {
        return ((Scroller)o).isFinished();
    }
    
    @Override
    public final int b(final Object o) {
        return ((Scroller)o).getCurrX();
    }
    
    @Override
    public final int c(final Object o) {
        return ((Scroller)o).getCurrY();
    }
    
    @Override
    public final boolean d(final Object o) {
        return ((Scroller)o).computeScrollOffset();
    }
    
    @Override
    public final void e(final Object o) {
        ((Scroller)o).abortAnimation();
    }
    
    @Override
    public final int f(final Object o) {
        return ((Scroller)o).getFinalX();
    }
    
    @Override
    public final int g(final Object o) {
        return ((Scroller)o).getFinalY();
    }
}
