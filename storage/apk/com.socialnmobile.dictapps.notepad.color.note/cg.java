import android.view.View;
import java.util.WeakHashMap;

// 
// Decompiled by Procyon v0.5.29
// 

class cg implements co
{
    WeakHashMap a;
    
    cg() {
        this.a = null;
    }
    
    @Override
    public void a(final View view) {
        view.invalidate();
    }
    
    @Override
    public boolean a(final View view, final int n) {
        return false;
    }
    
    @Override
    public int b(final View view) {
        return 0;
    }
    
    @Override
    public void b(final View view, final int n) {
    }
}
