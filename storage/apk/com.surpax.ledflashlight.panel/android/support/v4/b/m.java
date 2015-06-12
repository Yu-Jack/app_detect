// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.b;

public final class m implements Cloneable
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
        this((byte)0);
    }
    
    private m(final byte b) {
        this.b = false;
        android.support.v4.b.b.a();
        this.c = new int[13];
        this.d = new Object[13];
        this.e = 0;
    }
    
    private m c() {
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
    
    public final int a() {
        if (this.b) {
            this.d();
        }
        return this.e;
    }
    
    public final int a(final int n) {
        if (this.b) {
            this.d();
        }
        return this.c[n];
    }
    
    public final Object b(final int n) {
        if (this.b) {
            this.d();
        }
        return this.d[n];
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
            sb.append(this.a(i));
            sb.append('=');
            final Object b = this.b(i);
            if (b != this) {
                sb.append(b);
            }
            else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
