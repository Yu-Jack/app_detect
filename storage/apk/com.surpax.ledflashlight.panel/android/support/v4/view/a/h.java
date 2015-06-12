// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.view.a;

import java.util.List;
import android.os.Build$VERSION;

public final class h
{
    private static final i a;
    private final Object b;
    
    static {
        if (Build$VERSION.SDK_INT >= 19) {
            a = new k();
            return;
        }
        if (Build$VERSION.SDK_INT >= 16) {
            a = new j();
            return;
        }
        a = new l();
    }
    
    public h() {
        this.b = h.a.a(this);
    }
    
    public h(final Object b) {
        this.b = b;
    }
    
    public static a b() {
        return null;
    }
    
    public static boolean c() {
        return false;
    }
    
    public static List d() {
        return null;
    }
    
    public static a e() {
        return null;
    }
    
    public final Object a() {
        return this.b;
    }
}
