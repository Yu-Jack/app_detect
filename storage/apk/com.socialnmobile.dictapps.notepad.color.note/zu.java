import android.view.MenuItem;
import android.view.Menu;
import android.view.MenuInflater;
import android.os.Build$VERSION;
import android.widget.TextView;

// 
// Decompiled by Procyon v0.5.29
// 

public final class zu implements yo
{
    static final zv a;
    TextView b;
    
    static {
        if (Build$VERSION.SDK_INT >= 11) {
            a = new zv();
            return;
        }
        a = null;
    }
    
    public final zu a(final TextView b) {
        this.b = b;
        return this;
    }
    
    @Override
    public final boolean a() {
        if (zu.a != null) {
            final zv a = zu.a;
        }
        return false;
    }
    
    @Override
    public final boolean a(final MenuInflater menuInflater, final Menu menu) {
        if (zu.a != null) {
            final zv a = zu.a;
            final TextView b = this.b;
            menuInflater.inflate(2131558417, menu);
            final MenuItem item = menu.findItem(2131624178);
            int n;
            if (Build$VERSION.SDK_INT < 16 && (Build$VERSION.SDK_INT < 11 || Build$VERSION.SDK_INT >= 14)) {
                n = 0;
            }
            else {
                n = 1;
            }
            if (n == 0) {
                item.setIcon(2130837563);
                return true;
            }
            if (!gr.a(b.getContext()).a()) {
                item.setIcon(2130837563);
                return true;
            }
            item.setIcon(2130837564);
        }
        return true;
    }
    
    @Override
    public final boolean a(final MenuItem menuItem) {
        if (zu.a != null) {
            final zv a = zu.a;
            return zv.a(this.b, menuItem);
        }
        return false;
    }
    
    @Override
    public final void b() {
        if (zu.a != null) {
            final zv a = zu.a;
        }
    }
}
