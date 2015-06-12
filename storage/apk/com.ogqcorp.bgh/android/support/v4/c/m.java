// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.c;

public class m<E> implements Cloneable
{
    private static final Object a;
    private boolean b;
    private int[] c;
    private Object[] d;
    private int e;
    
    static {
        a = new Object();
    }
    
    public m() {
        this(10);
    }
    
    public m(final int n) {
        this.b = false;
        if (n == 0) {
            this.c = android.support.v4.c.b.a;
            this.d = android.support.v4.c.b.c;
        }
        else {
            final int a = android.support.v4.c.b.a(n);
            this.c = new int[a];
            this.d = new Object[a];
        }
        this.e = 0;
    }
    
    private void d() {
        final int e = this.e;
        final int[] c = this.c;
        final Object[] d = this.d;
        int i = 0;
        int e2 = 0;
        while (i < e) {
            final Object o = d[i];
            if (o != m.a) {
                if (i != e2) {
                    c[e2] = c[i];
                    d[e2] = o;
                    d[i] = null;
                }
                ++e2;
            }
            ++i;
        }
        this.b = false;
        this.e = e2;
    }
    
    public m<E> a() {
        m m;
        try {
            final m i;
            m = (i = (m)super.clone());
            final m j = this;
            final int[] array = j.c;
            final int[] array2 = array.clone();
            final int[] array3 = array2;
            i.c = array3;
            final m k = m;
            final m l = this;
            final Object[] array4 = l.d;
            final Object[] array5 = array4.clone();
            final Object[] array6 = array5;
            k.d = array6;
            return m;
        }
        catch (CloneNotSupportedException ex) {
            return null;
        }
        try {
            final m i = m;
            final m j = this;
            final int[] array = j.c;
            final int[] array2 = array.clone();
            final int[] array3 = array2;
            i.c = array3;
            final m k = m;
            final m l = this;
            final Object[] array4 = l.d;
            final Object[] array5 = array4.clone();
            final Object[] array6 = array5;
            k.d = array6;
            return m;
        }
        catch (CloneNotSupportedException ex2) {
            return m;
        }
    }
    
    public E a(final int n) {
        return this.a(n, null);
    }
    
    public E a(final int n, final E e) {
        final int a = android.support.v4.c.b.a(this.c, this.e, n);
        if (a < 0 || this.d[a] == m.a) {
            return e;
        }
        return (E)this.d[a];
    }
    
    public int b() {
        if (this.b) {
            this.d();
        }
        return this.e;
    }
    
    public void b(final int n) {
        final int a = android.support.v4.c.b.a(this.c, this.e, n);
        if (a >= 0 && this.d[a] != m.a) {
            this.d[a] = m.a;
            this.b = true;
        }
    }
    
    public void b(final int n, final E e) {
        final int a = android.support.v4.c.b.a(this.c, this.e, n);
        if (a >= 0) {
            this.d[a] = e;
            return;
        }
        int n2 = ~a;
        if (n2 < this.e && this.d[n2] == m.a) {
            this.c[n2] = n;
            this.d[n2] = e;
            return;
        }
        if (this.b && this.e >= this.c.length) {
            this.d();
            n2 = (-1 ^ android.support.v4.c.b.a(this.c, this.e, n));
        }
        if (this.e >= this.c.length) {
            final int a2 = android.support.v4.c.b.a(1 + this.e);
            final int[] c = new int[a2];
            final Object[] d = new Object[a2];
            System.arraycopy(this.c, 0, c, 0, this.c.length);
            System.arraycopy(this.d, 0, d, 0, this.d.length);
            this.c = c;
            this.d = d;
        }
        if (this.e - n2 != 0) {
            System.arraycopy(this.c, n2, this.c, n2 + 1, this.e - n2);
            System.arraycopy(this.d, n2, this.d, n2 + 1, this.e - n2);
        }
        this.c[n2] = n;
        this.d[n2] = e;
        ++this.e;
    }
    
    public void c() {
        final int e = this.e;
        final Object[] d = this.d;
        for (int i = 0; i < e; ++i) {
            d[i] = null;
        }
        this.e = 0;
        this.b = false;
    }
    
    public void c(final int n) {
        this.b(n);
    }
    
    public void d(final int n) {
        if (this.d[n] != m.a) {
            this.d[n] = m.a;
            this.b = true;
        }
    }
    
    public int e(final int n) {
        if (this.b) {
            this.d();
        }
        return this.c[n];
    }
    
    public E f(final int n) {
        if (this.b) {
            this.d();
        }
        return (E)this.d[n];
    }
    
    public int g(final int n) {
        if (this.b) {
            this.d();
        }
        return android.support.v4.c.b.a(this.c, this.e, n);
    }
    
    @Override
    public String toString() {
        if (this.b() <= 0) {
            return "{}";
        }
        final StringBuilder sb = new StringBuilder(28 * this.e);
        sb.append('{');
        for (int i = 0; i < this.e; ++i) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(this.e(i));
            sb.append('=');
            final E f = this.f(i);
            if (f != this) {
                sb.append(f);
            }
            else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
