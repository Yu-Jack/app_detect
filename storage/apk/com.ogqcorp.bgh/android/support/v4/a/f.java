// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.a;

import android.content.Intent;
import android.content.ComponentName;
import android.os.Build$VERSION;

public class f
{
    private static final g a;
    
    static {
        final int sdk_INT = Build$VERSION.SDK_INT;
        if (sdk_INT >= 15) {
            a = new j();
            return;
        }
        if (sdk_INT >= 11) {
            a = new i();
            return;
        }
        a = new h();
    }
    
    public static Intent a(final ComponentName componentName) {
        return f.a.a(componentName);
    }
}
