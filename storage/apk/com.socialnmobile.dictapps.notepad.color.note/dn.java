import android.os.Build$VERSION;
import android.view.animation.Interpolator;
import android.content.Context;

// 
// Decompiled by Procyon v0.5.29
// 

public final class dn
{
    Object a;
    do b;
    
    private dn(final int n, final Context context, final Interpolator interpolator) {
        if (n >= 14) {
            this.b = new dr();
        }
        else if (n >= 9) {
            this.b = new dq();
        }
        else {
            this.b = new dp();
        }
        this.a = this.b.a(context, interpolator);
    }
    
    private dn(final Context context, final Interpolator interpolator) {
        this(Build$VERSION.SDK_INT, context, interpolator);
    }
    
    public static dn a(final Context context, final Interpolator interpolator) {
        return new dn(context, interpolator);
    }
    
    public final void a() {
        this.b.e(this.a);
    }
}
