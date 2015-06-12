import android.graphics.Canvas;
import android.content.Context;
import android.os.Build$VERSION;

// 
// Decompiled by Procyon v0.5.29
// 

public class di
{
    private static final dl b;
    private Object a;
    
    static {
        if (Build$VERSION.SDK_INT >= 14) {
            b = new dk();
            return;
        }
        b = new dj();
    }
    
    public di(final Context context) {
        this.a = di.b.a(context);
    }
    
    public void a(final int n, final int n2) {
        di.b.a(this.a, n, n2);
    }
    
    public boolean a() {
        return di.b.a(this.a);
    }
    
    public boolean a(final float n) {
        return di.b.a(this.a, n);
    }
    
    public boolean a(final Canvas canvas) {
        return di.b.a(this.a, canvas);
    }
    
    public boolean b() {
        return di.b.b(this.a);
    }
}
