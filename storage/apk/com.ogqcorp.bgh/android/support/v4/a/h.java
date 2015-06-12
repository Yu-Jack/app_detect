// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.a;

import android.content.Intent;
import android.content.ComponentName;

class h implements g
{
    @Override
    public Intent a(final ComponentName component) {
        final Intent intent = new Intent("android.intent.action.MAIN");
        intent.setComponent(component);
        intent.addCategory("android.intent.category.LAUNCHER");
        return intent;
    }
}
