// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.widget;

import android.graphics.Canvas;
import android.widget.EdgeEffect;
import android.content.Context;

class m
{
    public static Object a(final Context context) {
        return new EdgeEffect(context);
    }
    
    public static void a(final Object o, final int n, final int n2) {
        ((EdgeEffect)o).setSize(n, n2);
    }
    
    public static boolean a(final Object o) {
        return ((EdgeEffect)o).isFinished();
    }
    
    public static boolean a(final Object o, final float n) {
        ((EdgeEffect)o).onPull(n);
        return true;
    }
    
    public static boolean a(final Object o, final int n) {
        ((EdgeEffect)o).onAbsorb(n);
        return true;
    }
    
    public static boolean a(final Object o, final Canvas canvas) {
        return ((EdgeEffect)o).draw(canvas);
    }
    
    public static void b(final Object o) {
        ((EdgeEffect)o).finish();
    }
    
    public static boolean c(final Object o) {
        final EdgeEffect edgeEffect = (EdgeEffect)o;
        edgeEffect.onRelease();
        return edgeEffect.isFinished();
    }
}
