// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.widget;

import android.os.Build$VERSION;
import android.view.animation.Interpolator;
import android.content.Context;

public final class j
{
    Object a;
    k b;
    
    private j(final int n, final Context context, final Interpolator interpolator) {
        if (n >= 14) {
            this.b = new n();
        }
        else if (n >= 9) {
            this.b = new m();
        }
        else {
            this.b = new l();
        }
        this.a = this.b.a(context, interpolator);
    }
    
    j(final Context context, final Interpolator interpolator) {
        this(Build$VERSION.SDK_INT, context, interpolator);
    }
    
    public final int a() {
        return this.b.b(this.a);
    }
    
    public final int b() {
        return this.b.c(this.a);
    }
    
    public final void c() {
        this.b.e(this.a);
    }
}
