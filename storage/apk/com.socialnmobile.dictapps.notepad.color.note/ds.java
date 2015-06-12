import android.widget.OverScroller;
import android.view.animation.Interpolator;
import android.content.Context;

// 
// Decompiled by Procyon v0.5.29
// 

final class ds
{
    public static Object a(final Context context, final Interpolator interpolator) {
        if (interpolator != null) {
            return new OverScroller(context, interpolator);
        }
        return new OverScroller(context);
    }
    
    public static void a(final Object o, final int n, final int n2, final int n3, final int n4, final int n5) {
        ((OverScroller)o).startScroll(n, n2, n3, n4, n5);
    }
    
    public static boolean a(final Object o) {
        return ((OverScroller)o).isFinished();
    }
    
    public static int b(final Object o) {
        return ((OverScroller)o).getCurrX();
    }
    
    public static int c(final Object o) {
        return ((OverScroller)o).getCurrY();
    }
    
    public static boolean d(final Object o) {
        return ((OverScroller)o).computeScrollOffset();
    }
    
    public static void e(final Object o) {
        ((OverScroller)o).abortAnimation();
    }
    
    public static int f(final Object o) {
        return ((OverScroller)o).getFinalX();
    }
    
    public static int g(final Object o) {
        return ((OverScroller)o).getFinalY();
    }
}
