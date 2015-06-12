// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.widget;

import android.graphics.Canvas;
import android.content.Context;
import android.os.Build$VERSION;

public class i
{
    private static final l b;
    private Object a;
    
    static {
        if (Build$VERSION.SDK_INT >= 14) {
            b = new k();
            return;
        }
        b = new j();
    }
    
    public i(final Context context) {
        this.a = i.b.a(context);
    }
    
    public void a(final int n, final int n2) {
        i.b.a(this.a, n, n2);
    }
    
    public boolean a() {
        return i.b.a(this.a);
    }
    
    public boolean a(final float n) {
        return i.b.a(this.a, n);
    }
    
    public boolean a(final int n) {
        return i.b.a(this.a, n);
    }
    
    public boolean a(final Canvas canvas) {
        return i.b.a(this.a, canvas);
    }
    
    public void b() {
        i.b.b(this.a);
    }
    
    public boolean c() {
        return i.b.c(this.a);
    }
}
