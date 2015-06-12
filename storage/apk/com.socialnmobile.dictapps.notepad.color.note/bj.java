import android.os.Build$VERSION;

// 
// Decompiled by Procyon v0.5.29
// 

public final class bj
{
    static final bk a;
    
    static {
        if (Build$VERSION.SDK_INT >= 17) {
            a = new bm();
            return;
        }
        a = new bl();
    }
    
    public static int a(final int n, final int n2) {
        return bj.a.a(n, n2);
    }
}
