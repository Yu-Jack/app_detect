// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.view;

import android.view.KeyEvent;
import android.os.Build$VERSION;

public class t
{
    static final x a;
    
    static {
        if (Build$VERSION.SDK_INT >= 11) {
            a = new w();
            return;
        }
        a = new u();
    }
    
    public static boolean a(final KeyEvent keyEvent) {
        return t.a.b(keyEvent.getMetaState());
    }
    
    public static boolean a(final KeyEvent keyEvent, final int n) {
        return t.a.a(keyEvent.getMetaState(), n);
    }
    
    public static void b(final KeyEvent keyEvent) {
        t.a.a(keyEvent);
    }
}
