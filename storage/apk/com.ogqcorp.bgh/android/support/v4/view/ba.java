// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.view;

import android.graphics.Paint;
import android.view.View;

class ba
{
    public static int a(final View view) {
        return view.getLayoutDirection();
    }
    
    public static void a(final View view, final Paint layerPaint) {
        view.setLayerPaint(layerPaint);
    }
}
