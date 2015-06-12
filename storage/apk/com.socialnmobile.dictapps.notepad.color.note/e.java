import android.view.View;
import android.support.v4.app.Fragment;

// 
// Decompiled by Procyon v0.5.29
// 

public final class e implements l
{
    final /* synthetic */ Fragment a;
    
    public e(final Fragment a) {
        this.a = a;
    }
    
    @Override
    public final View a(final int n) {
        if (this.a.R == null) {
            throw new IllegalStateException("Fragment does not have a view");
        }
        return this.a.R.findViewById(n);
    }
}
