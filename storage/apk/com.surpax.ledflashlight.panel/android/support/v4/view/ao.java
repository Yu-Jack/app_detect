// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.view;

import android.graphics.Paint;
import android.view.View;

class ao extends an
{
    @Override
    public final void a(final View view, final Paint layerPaint) {
        view.setLayerPaint(layerPaint);
    }
    
    @Override
    public final int f(final View view) {
        return view.getLayoutDirection();
    }
}
