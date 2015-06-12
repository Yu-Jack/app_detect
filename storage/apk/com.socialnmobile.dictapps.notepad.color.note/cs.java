import android.view.ViewConfiguration;
import android.os.Build$VERSION;

// 
// Decompiled by Procyon v0.5.29
// 

public final class cs
{
    static final cv a;
    
    static {
        if (Build$VERSION.SDK_INT >= 11) {
            a = new cu();
            return;
        }
        a = new ct();
    }
    
    public static int a(final ViewConfiguration viewConfiguration) {
        return cs.a.a(viewConfiguration);
    }
}
