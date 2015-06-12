// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.view;

import android.view.KeyEvent;
import android.os.Build$VERSION;

public final class n
{
    static final r a;
    
    static {
        if (Build$VERSION.SDK_INT >= 11) {
            a = new q();
            return;
        }
        a = new o();
    }
    
    public static boolean a(final KeyEvent keyEvent) {
        return n.a.b(keyEvent.getMetaState());
    }
    
    public static boolean b(final KeyEvent keyEvent) {
        return n.a.c(keyEvent.getMetaState());
    }
    
    public static void c(final KeyEvent keyEvent) {
        n.a.a(keyEvent);
    }
}
