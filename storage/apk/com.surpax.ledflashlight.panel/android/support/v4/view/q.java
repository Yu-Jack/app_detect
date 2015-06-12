// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.view;

import android.view.KeyEvent;

final class q extends p
{
    @Override
    public final int a(final int n) {
        return KeyEvent.normalizeMetaState(n);
    }
    
    @Override
    public final boolean b(final int n) {
        return KeyEvent.metaStateHasModifiers(n, 1);
    }
    
    @Override
    public final boolean c(final int n) {
        return KeyEvent.metaStateHasNoModifiers(n);
    }
}
