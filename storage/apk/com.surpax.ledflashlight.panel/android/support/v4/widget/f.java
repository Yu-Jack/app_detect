// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.widget;

import android.graphics.Canvas;
import android.content.Context;
import android.os.Build$VERSION;

public final class f
{
    private static final i b;
    private Object a;
    
    static {
        if (Build$VERSION.SDK_INT >= 14) {
            b = new h();
            return;
        }
        b = new g();
    }
    
    public f(final Context context) {
        this.a = f.b.a(context);
    }
    
    public final void a(final int n, final int n2) {
        f.b.a(this.a, n, n2);
    }
    
    public final boolean a() {
        return f.b.a(this.a);
    }
    
    public final boolean a(final float n) {
        return f.b.a(this.a, n);
    }
    
    public final boolean a(final Canvas canvas) {
        return f.b.a(this.a, canvas);
    }
    
    public final void b() {
        f.b.b(this.a);
    }
    
    public final boolean c() {
        return f.b.c(this.a);
    }
}
