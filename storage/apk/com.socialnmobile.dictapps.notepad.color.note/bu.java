import android.view.KeyEvent;

// 
// Decompiled by Procyon v0.5.29
// 

final class bu
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
