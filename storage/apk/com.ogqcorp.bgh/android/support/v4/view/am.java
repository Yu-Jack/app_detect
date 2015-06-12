// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.view;

import android.graphics.drawable.Drawable;
import android.graphics.Paint;
import android.view.View;

class am implements au
{
    @Override
    public int a(final View view) {
        return 2;
    }
    
    long a() {
        return 10L;
    }
    
    @Override
    public void a(final View view, final int n, final int n2, final int n3, final int n4) {
        view.postInvalidateDelayed(this.a(), n, n2, n3, n4);
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
    public boolean a(final View view, final int n) {
        return false;
    }
    
    @Override
    public void b(final View view) {
        view.postInvalidateDelayed(this.a());
    }
    
    @Override
    public void b(final View view, final int n) {
    }
    
    @Override
    public int c(final View view) {
        return 0;
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
    public boolean f(final View view) {
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
