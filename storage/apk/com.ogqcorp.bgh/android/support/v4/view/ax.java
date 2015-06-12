// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.view;

import android.graphics.Paint;
import android.animation.ValueAnimator;
import android.view.View;

class ax
{
    public static int a(final View view) {
        return view.getLayerType();
    }
    
    static long a() {
        return ValueAnimator.getFrameDelay();
    }
    
    public static void a(final View view, final int n, final Paint paint) {
        view.setLayerType(n, paint);
    }
}
