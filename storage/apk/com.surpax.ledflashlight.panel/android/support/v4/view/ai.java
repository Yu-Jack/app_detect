// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.view;

import android.graphics.drawable.Drawable;
import android.view.ViewParent;
import android.graphics.Paint;
import android.view.View;
import java.util.WeakHashMap;

class ai implements aq
{
    WeakHashMap a;
    
    ai() {
        this.a = null;
    }
    
    long a() {
        return 10L;
    }
    
    @Override
    public void a(final View view, final int n, final int n2, final int n3, final int n4) {
        view.invalidate(n, n2, n3, n4);
    }
    
    @Override
    public void a(final View view, final int n, final Paint paint) {
    }
    
    @Override
    public void a(final View view, final Paint paint) {
    }
    
    @Override
    public void a(final View view, final a a) {
    }
    
    @Override
    public void a(final View view, final Runnable runnable) {
        view.postDelayed(runnable, this.a());
    }
    
    @Override
    public boolean a(final View view) {
        return false;
    }
    
    @Override
    public boolean a(final View view, final int n) {
        return false;
    }
    
    @Override
    public int b(final View view) {
        return 2;
    }
    
    @Override
    public void b(final View view, final int n) {
    }
    
    @Override
    public void c(final View view) {
        view.invalidate();
    }
    
    @Override
    public int d(final View view) {
        return 0;
    }
    
    @Override
    public int e(final View view) {
        return 0;
    }
    
    @Override
    public int f(final View view) {
        return 0;
    }
    
    @Override
    public ViewParent g(final View view) {
        return view.getParent();
    }
    
    @Override
    public boolean h(final View view) {
        final Drawable background = view.getBackground();
        boolean b = false;
        if (background != null) {
            final int opacity = background.getOpacity();
            b = false;
            if (opacity == -1) {
                b = true;
            }
        }
        return b;
    }
}
