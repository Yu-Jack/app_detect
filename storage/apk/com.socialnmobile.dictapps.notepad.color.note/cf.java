import android.view.View;
import android.os.Build$VERSION;

// 
// Decompiled by Procyon v0.5.29
// 

public final class cf
{
    static final co a;
    
    static {
        final int sdk_INT = Build$VERSION.SDK_INT;
        if (sdk_INT >= 19) {
            a = new cn();
            return;
        }
        if (sdk_INT >= 17) {
            a = new cm();
            return;
        }
        if (sdk_INT >= 16) {
            a = new cl();
            return;
        }
        if (sdk_INT >= 14) {
            a = new ck();
            return;
        }
        if (sdk_INT >= 11) {
            a = new cj();
            return;
        }
        if (sdk_INT >= 9) {
            a = new ci();
            return;
        }
        a = new cg();
    }
    
    public static void a(final View view) {
        cf.a.a(view);
    }
    
    public static boolean a(final View view, final int n) {
        return cf.a.a(view, n);
    }
    
    public static int b(final View view) {
        return cf.a.b(view);
    }
    
    public static void b(final View view, final int n) {
        cf.a.b(view, n);
    }
}
