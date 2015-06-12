// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.view.a;

import android.os.Build$VERSION;

public final class q
{
    private static final t a;
    private final Object b;
    
    static {
        if (Build$VERSION.SDK_INT >= 16) {
            a = new u();
            return;
        }
        if (Build$VERSION.SDK_INT >= 15) {
            a = new s();
            return;
        }
        if (Build$VERSION.SDK_INT >= 14) {
            a = new r();
            return;
        }
        a = new v();
    }
    
    private q(final Object b) {
        this.b = b;
    }
    
    public static q a() {
        return new q(q.a.a());
    }
    
    public final void a(final int n) {
        q.a.b(this.b, n);
    }
    
    public final void a(final boolean b) {
        q.a.a(this.b, b);
    }
    
    public final void b(final int n) {
        q.a.a(this.b, n);
    }
    
    public final void c(final int n) {
        q.a.c(this.b, n);
    }
    
    @Override
    public final boolean equals(final Object o) {
        if (this != o) {
            if (o == null) {
                return false;
            }
            if (this.getClass() != o.getClass()) {
                return false;
            }
            final q q = (q)o;
            if (this.b == null) {
                if (q.b != null) {
                    return false;
                }
            }
            else if (!this.b.equals(q.b)) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public final int hashCode() {
        if (this.b == null) {
            return 0;
        }
        return this.b.hashCode();
    }
}
