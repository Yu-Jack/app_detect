import android.view.animation.Interpolator;

// 
// Decompiled by Procyon v0.5.29
// 

final class du implements Interpolator
{
    public final float getInterpolation(final float n) {
        final float n2 = n - 1.0f;
        return 1.0f + n2 * (n2 * (n2 * (n2 * n2)));
    }
}
