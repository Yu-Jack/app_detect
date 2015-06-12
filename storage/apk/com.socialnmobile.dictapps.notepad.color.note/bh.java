// 
// Decompiled by Procyon v0.5.29
// 

public final class bh implements Cloneable
{
    private static final Object a;
    private boolean b;
    private int[] c;
    private Object[] d;
    private int e;
    
    static {
        a = new Object();
    }
    
    public bh() {
        this((byte)0);
    }
    
    private bh(final byte b) {
        this.b = false;
        final int a = ax.a(10);
        this.c = new int[a];
        this.d = new Object[a];
        this.e = 0;
    }
    
    private bh c() {
        bh bh;
        try {
            final bh bh2;
            bh = (bh2 = (bh)super.clone());
            final bh bh3 = this;
            final int[] array = bh3.c;
            final int[] array2 = array.clone();
            final int[] array3 = array2;
            bh2.c = array3;
            final bh bh4 = bh;
            final bh bh5 = this;
            final Object[] array4 = bh5.d;
            final Object[] array5 = array4.clone();
            final Object[] array6 = array5;
            bh4.d = array6;
            return bh;
        }
        catch (CloneNotSupportedException ex) {
            return null;
        }
        try {
            final bh bh2 = bh;
            final bh bh3 = this;
            final int[] array = bh3.c;
            final int[] array2 = array.clone();
            final int[] array3 = array2;
            bh2.c = array3;
            final bh bh4 = bh;
            final bh bh5 = this;
            final Object[] array4 = bh5.d;
            final Object[] array5 = array4.clone();
            final Object[] array6 = array5;
            bh4.d = array6;
            return bh;
        }
        catch (CloneNotSupportedException ex2) {
            return bh;
        }
    }
    
    private void d() {
        final int e = this.e;
        final int[] c = this.c;
        final Object[] d = this.d;
        int i = 0;
        int e2 = 0;
        while (i < e) {
            final Object o = d[i];
            if (o != bh.a) {
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
    
    public final int a() {
        if (this.b) {
            this.d();
        }
        return this.e;
    }
    
    public final Object a(final int n) {
        final int a = ax.a(this.c, this.e, n);
        if (a < 0 || this.d[a] == bh.a) {
            return null;
        }
        return this.d[a];
    }
    
    public final void a(final int n, final Object o) {
        final int a = ax.a(this.c, this.e, n);
        if (a >= 0) {
            this.d[a] = o;
            return;
        }
        int n2 = ~a;
        if (n2 < this.e && this.d[n2] == bh.a) {
            this.c[n2] = n;
            this.d[n2] = o;
            return;
        }
        if (this.b && this.e >= this.c.length) {
            this.d();
            n2 = (-1 ^ ax.a(this.c, this.e, n));
        }
        if (this.e >= this.c.length) {
            final int a2 = ax.a(1 + this.e);
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
        this.d[n2] = o;
        ++this.e;
    }
    
    public final void b() {
        final int e = this.e;
        final Object[] d = this.d;
        for (int i = 0; i < e; ++i) {
            d[i] = null;
        }
        this.e = 0;
        this.b = false;
    }
    
    public final void b(final int n) {
        final int a = ax.a(this.c, this.e, n);
        if (a >= 0 && this.d[a] != bh.a) {
            this.d[a] = bh.a;
            this.b = true;
        }
    }
    
    public final int c(final int n) {
        if (this.b) {
            this.d();
        }
        return this.c[n];
    }
    
    public final Object d(final int n) {
        if (this.b) {
            this.d();
        }
        return this.d[n];
    }
    
    @Override
    public final String toString() {
        if (this.a() <= 0) {
            return "{}";
        }
        final StringBuilder sb = new StringBuilder(28 * this.e);
        sb.append('{');
        for (int i = 0; i < this.e; ++i) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(this.c(i));
            sb.append('=');
            final Object d = this.d(i);
            if (d != this) {
                sb.append(d);
            }
            else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
