import android.widget.TextView;
import android.os.Build$VERSION;

// 
// Decompiled by Procyon v0.5.29
// 

public final class jf
{
    static final jg a;
    
    static {
        if (Build$VERSION.SDK_INT >= 11) {
            a = new ji();
            return;
        }
        a = new jh();
    }
    
    public static void a(final TextView textView, final yo yo) {
        jf.a.a(textView, yo);
    }
}
