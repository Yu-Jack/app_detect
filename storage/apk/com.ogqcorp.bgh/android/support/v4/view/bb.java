// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.view;

import android.view.ViewConfiguration;
import android.os.Build$VERSION;

public class bb
{
    static final be a;
    
    static {
        if (Build$VERSION.SDK_INT >= 11) {
            a = new bd();
            return;
        }
        a = new bc();
    }
    
    public static int a(final ViewConfiguration viewConfiguration) {
        return bb.a.a(viewConfiguration);
    }
}
