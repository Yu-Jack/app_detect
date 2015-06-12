import android.view.MenuItem;
import android.view.Menu;
import java.util.Iterator;
import android.view.View$OnClickListener;
import java.util.ArrayList;

// 
// Decompiled by Procyon v0.5.29
// 

public final class rc
{
    ra a;
    qq b;
    public ArrayList c;
    public ArrayList d;
    ArrayList e;
    public String f;
    public int g;
    public View$OnClickListener h;
    public View$OnClickListener i;
    
    public rc(final ra a, final int g) {
        this.h = (View$OnClickListener)new rd(this);
        this.i = (View$OnClickListener)new re(this);
        this.a = a;
        this.g = g;
        this.c = new ArrayList();
        this.d = new ArrayList();
        this.e = new ArrayList();
    }
    
    public final rf a(final int n) {
        for (final rf rf : this.d) {
            if (rf.a == n) {
                return rf;
            }
        }
        return null;
    }
    
    public final void a(final int n, final int n2, final int n3) {
        this.e.add(new rf(n, n2, n3));
    }
    
    public final void a(final Menu menu) {
        menu.clear();
        for (final rf rf : this.e) {
            final MenuItem add = menu.add(0, rf.a, 0, rf.c);
            if (rf.g) {
                add.setIcon(rf.f);
            }
            else {
                add.setIcon(rf.b);
            }
            add.setVisible(rf.h);
            add.setEnabled(rf.i);
        }
    }
    
    public final boolean a() {
        boolean b = true;
        switch (this.g) {
            default: {
                b = false;
                break;
            }
            case 1: {
                if (this.d.size() != 2) {
                    return false;
                }
                break;
            }
            case 3: {
                if (this.d.size() != 3) {
                    return false;
                }
                break;
            }
        }
        return b;
    }
    
    public final ArrayList b(final int n) {
        final ArrayList<rf> list = new ArrayList<rf>();
        for (final rf e : this.c) {
            if (e.a == n) {
                list.add(e);
            }
        }
        for (final rf e2 : this.e) {
            if (e2.a == n) {
                list.add(e2);
            }
        }
        for (final rf e3 : this.d) {
            if (e3.a == n) {
                list.add(e3);
            }
        }
        return list;
    }
    
    public final rf b() {
        switch (this.g) {
            default: {
                return null;
            }
            case 1: {
                return this.d.get(1);
            }
            case 3: {
                return this.d.get(2);
            }
        }
    }
    
    public final void b(final int n, final int n2, final int n3) {
        this.d.add(new rf(n, n2, n3));
    }
    
    public final void c() {
        if (this.b != null && this.b.c()) {
            this.b.b();
        }
    }
    
    public final void c(final int n, final int n2, final int n3) {
        this.c.add(new rf(n, n2, n3));
        this.e.add(new rf(n, n2, n3));
    }
}
