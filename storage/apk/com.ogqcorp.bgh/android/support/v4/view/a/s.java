// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.view.a;

import android.os.Build$VERSION;

public class s
{
    private static final v a;
    private final Object b;
    
    static {
        if (Build$VERSION.SDK_INT >= 16) {
            a = new w();
            return;
        }
        if (Build$VERSION.SDK_INT >= 15) {
            a = new u();
            return;
        }
        if (Build$VERSION.SDK_INT >= 14) {
            a = new t();
            return;
        }
        a = new x();
    }
    
    public s(final Object b) {
        this.b = b;
    }
    
    public static s a() {
        return new s(s.a.a());
    }
    
    public void a(final int n) {
        s.a.b(this.b, n);
    }
    
    public void a(final boolean b) {
        s.a.a(this.b, b);
    }
    
    public void b(final int n) {
        s.a.a(this.b, n);
    }
    
    public void c(final int n) {
        s.a.c(this.b, n);
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this != o) {
            if (o == null) {
                return false;
            }
            if (this.getClass() != o.getClass()) {
                return false;
            }
            final s s = (s)o;
            if (this.b == null) {
                if (s.b != null) {
                    return false;
                }
            }
            else if (!this.b.equals(s.b)) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public int hashCode() {
        if (this.b == null) {
            return 0;
        }
        return this.b.hashCode();
    }
}
