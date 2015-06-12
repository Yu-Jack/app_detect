import android.graphics.Canvas;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.content.Context;
import android.view.animation.Interpolator;

// 
// Decompiled by Procyon v0.5.29
// 

public final class aaa extends di
{
    public float a;
    float b;
    float c;
    float d;
    private long e;
    private float f;
    private final Interpolator g;
    private int h;
    
    public aaa(final Context context) {
        super(context);
        this.h = 0;
        context.getResources();
        this.g = (Interpolator)new DecelerateInterpolator();
    }
    
    @Override
    public final void a(final int n, final int n2) {
    }
    
    @Override
    public final boolean a() {
        return this.h == 0;
    }
    
    @Override
    public final boolean a(final float n) {
        final long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        if (this.h == 4 && currentAnimationTimeMillis - this.e < this.f) {
            return true;
        }
        this.h = 1;
        this.e = currentAnimationTimeMillis;
        this.f = 167.0f;
        this.d += n;
        this.a = this.d;
        this.c = this.d;
        return true;
    }
    
    @Override
    public final boolean a(final Canvas canvas) {
        final float min = Math.min((AnimationUtils.currentAnimationTimeMillis() - this.e) / this.f, 1.0f);
        final float interpolation = this.g.getInterpolation(min);
        if (this.h == 3) {
            this.a = this.b + interpolation * (this.c - this.b);
        }
        if (min >= 0.999f) {
            switch (this.h) {
                case 3: {
                    this.h = 0;
                    break;
                }
            }
        }
        final int h = this.h;
        boolean b = false;
        if (h != 0) {
            b = true;
        }
        return b;
    }
    
    @Override
    public final boolean b() {
        this.d = 0.0f;
        if (this.h != 1 && this.h != 4) {
            return this.a();
        }
        this.h = 3;
        this.b = this.a;
        this.c = 0.0f;
        this.e = AnimationUtils.currentAnimationTimeMillis();
        this.f = 200.0f;
        return this.a();
    }
}
