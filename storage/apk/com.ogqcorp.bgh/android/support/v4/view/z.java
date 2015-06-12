// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.view;

import android.view.KeyEvent;

class z
{
    public static int a(final int n) {
        return KeyEvent.normalizeMetaState(n);
    }
    
    public static boolean a(final int n, final int n2) {
        return KeyEvent.metaStateHasModifiers(n, n2);
    }
    
    public static boolean b(final int n) {
        return KeyEvent.metaStateHasNoModifiers(n);
    }
}
