import android.view.ViewGroup;
import android.os.Build$VERSION;

// 
// Decompiled by Procyon v0.5.29
// 

public final class cx
{
    static final da a;
    
    static {
        final int sdk_INT = Build$VERSION.SDK_INT;
        if (sdk_INT >= 18) {
            a = new db();
            return;
        }
        if (sdk_INT >= 14) {
            a = new cz();
            return;
        }
        if (sdk_INT >= 11) {
            a = new cy();
            return;
        }
        a = new dc();
    }
    
    public static void a(final ViewGroup viewGroup, final boolean b) {
        cx.a.a(viewGroup, b);
    }
}
