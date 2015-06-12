import android.view.KeyEvent;
import android.os.Build$VERSION;

// 
// Decompiled by Procyon v0.5.29
// 

public final class bo
{
    static final bs a;
    
    static {
        if (Build$VERSION.SDK_INT >= 11) {
            a = new br();
            return;
        }
        a = new bp();
    }
    
    public static boolean a(final KeyEvent keyEvent) {
        return bo.a.b(keyEvent.getMetaState());
    }
    
    public static boolean a(final KeyEvent keyEvent, final int n) {
        return bo.a.a(keyEvent.getMetaState(), n);
    }
    
    public static void b(final KeyEvent keyEvent) {
        bo.a.a(keyEvent);
    }
}
