// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.widget;

import android.graphics.Canvas;
import android.widget.EdgeEffect;
import android.content.Context;

final class h implements i
{
    @Override
    public final Object a(final Context context) {
        return new EdgeEffect(context);
    }
    
    @Override
    public final void a(final Object o, final int n, final int n2) {
        ((EdgeEffect)o).setSize(n, n2);
    }
    
    @Override
    public final boolean a(final Object o) {
        return ((EdgeEffect)o).isFinished();
    }
    
    @Override
    public final boolean a(final Object o, final float n) {
        ((EdgeEffect)o).onPull(n);
        return true;
    }
    
    @Override
    public final boolean a(final Object o, final Canvas canvas) {
        return ((EdgeEffect)o).draw(canvas);
    }
    
    @Override
    public final void b(final Object o) {
        ((EdgeEffect)o).finish();
    }
    
    @Override
    public final boolean c(final Object o) {
        final EdgeEffect edgeEffect = (EdgeEffect)o;
        edgeEffect.onRelease();
        return edgeEffect.isFinished();
    }
}
