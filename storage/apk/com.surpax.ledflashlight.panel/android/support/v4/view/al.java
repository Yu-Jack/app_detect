// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.view;

import android.graphics.Paint;
import android.view.View;
import android.animation.ValueAnimator;

class al extends ak
{
    @Override
    final long a() {
        return ValueAnimator.getFrameDelay();
    }
    
    @Override
    public final void a(final View view, final int n, final Paint paint) {
        view.setLayerType(n, paint);
    }
    
    @Override
    public void a(final View view, final Paint paint) {
        view.setLayerType(view.getLayerType(), paint);
        view.invalidate();
    }
    
    @Override
    public final int e(final View view) {
        return view.getLayerType();
    }
}
