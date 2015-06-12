// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.c;

import java.util.Map;

public class l<K, V>
{
    static Object[] b;
    static int c;
    static Object[] d;
    static int e;
    int[] f;
    Object[] g;
    int h;
    
    public l() {
        this.f = android.support.v4.c.b.a;
        this.g = android.support.v4.c.b.c;
        this.h = 0;
    }
    
    private static void a(final int[] array, final Object[] array2, final int n) {
        if (array.length == 8) {
            synchronized (a.class) {
                if (l.e < 10) {
                    array2[0] = l.d;
                    array2[1] = array;
                    for (int i = -1 + (n << 1); i >= 2; --i) {
                        array2[i] = null;
                    }
                    l.d = array2;
                    ++l.e;
                }
                return;
            }
        }
        if (array.length == 4) {
            synchronized (a.class) {
                if (l.c < 10) {
                    array2[0] = l.b;
                    array2[1] = array;
                    for (int j = -1 + (n << 1); j >= 2; --j) {
                        array2[j] = null;
                    }
                    l.b = array2;
                    ++l.c;
                }
            }
        }
    }
    
    private void e(final int n) {
        while (true) {
            Label_0104: {
                if (n != 8) {
                    break Label_0104;
                }
                synchronized (a.class) {
                    if (l.d != null) {
                        final Object[] d = l.d;
                        this.g = d;
                        l.d = (Object[])d[0];
                        this.f = (int[])d[1];
                        d[0] = (d[1] = null);
                        --l.e;
                        return;
                    }
                    // monitorexit(a.class)
                    this.f = new int[n];
                    this.g = new Object[n << 1];
                    return;
                }
            }
            if (n == 4) {
                synchronized (a.class) {
                    if (l.b != null) {
                        final Object[] b = l.b;
                        this.g = b;
                        l.b = (Object[])b[0];
                        this.f = (int[])b[1];
                        b[0] = (b[1] = null);
                        --l.c;
                        return;
                    }
                }
                // monitorexit(a.class)
                continue;
            }
            continue;
        }
    }
    
    int a() {
        final int h = this.h;
        int a;
        if (h == 0) {
            a = -1;
        }
        else {
            a = android.support.v4.c.b.a(this.f, h, 0);
            if (a >= 0 && this.g[a << 1] != null) {
                int n;
                for (n = a + 1; n < h && this.f[n] == 0; ++n) {
                    if (this.g[n << 1] == null) {
                        return n;
                    }
                }
                --a;
                while (a >= 0 && this.f[a] == 0) {
                    if (this.g[a << 1] == null) {
                        return a;
                    }
                    --a;
                }
                return ~n;
            }
        }
        return a;
    }
    
    int a(final Object o) {
        int i = 1;
        final int n = 2 * this.h;
        final Object[] g = this.g;
        if (o == null) {
            while (i < n) {
                if (g[i] == null) {
                    return i >> 1;
                }
                i += 2;
            }
        }
        else {
            while (i < n) {
                if (o.equals(g[i])) {
                    return i >> 1;
                }
                i += 2;
            }
        }
        return -1;
    }
    
    int a(final Object o, final int n) {
        final int h = this.h;
        int a;
        if (h == 0) {
            a = -1;
        }
        else {
            a = android.support.v4.c.b.a(this.f, h, n);
            if (a >= 0 && !o.equals(this.g[a << 1])) {
                int n2;
                for (n2 = a + 1; n2 < h && this.f[n2] == n; ++n2) {
                    if (o.equals(this.g[n2 << 1])) {
                        return n2;
                    }
                }
                --a;
                while (a >= 0 && this.f[a] == n) {
                    if (o.equals(this.g[a << 1])) {
                        return a;
                    }
                    --a;
                }
                return ~n2;
            }
        }
        return a;
    }
    
    public V a(final int n, final V v) {
        final int n2 = 1 + (n << 1);
        final Object o = this.g[n2];
        this.g[n2] = v;
        return (V)o;
    }
    
    public void a(final int n) {
        if (this.f.length < n) {
            final int[] f = this.f;
            final Object[] g = this.g;
            this.e(n);
            if (this.h > 0) {
                System.arraycopy(f, 0, this.f, 0, this.h);
                System.arraycopy(g, 0, this.g, 0, this.h << 1);
            }
            a(f, g, this.h);
        }
    }
    
    public K b(final int n) {
        return (K)this.g[n << 1];
    }
    
    public V c(final int n) {
        return (V)this.g[1 + (n << 1)];
    }
    
    public void clear() {
        if (this.h != 0) {
            a(this.f, this.g, this.h);
            this.f = android.support.v4.c.b.a;
            this.g = android.support.v4.c.b.c;
            this.h = 0;
        }
    }
    
    public boolean containsKey(final Object o) {
        if (o == null) {
            if (this.a() < 0) {
                return false;
            }
        }
        else if (this.a(o, o.hashCode()) < 0) {
            return false;
        }
        return true;
    }
    
    public boolean containsValue(final Object o) {
        return this.a(o) >= 0;
    }
    
    public V d(final int n) {
        int n2 = 8;
        final Object o = this.g[1 + (n << 1)];
        if (this.h <= 1) {
            a(this.f, this.g, this.h);
            this.f = android.support.v4.c.b.a;
            this.g = android.support.v4.c.b.c;
            this.h = 0;
        }
        else {
            if (this.f.length <= n2 || this.h >= this.f.length / 3) {
                --this.h;
                if (n < this.h) {
                    System.arraycopy(this.f, n + 1, this.f, n, this.h - n);
                    System.arraycopy(this.g, n + 1 << 1, this.g, n << 1, this.h - n << 1);
                }
                this.g[this.h << 1] = null;
                this.g[1 + (this.h << 1)] = null;
                return (V)o;
            }
            if (this.h > n2) {
                n2 = this.h + (this.h >> 1);
            }
            final int[] f = this.f;
            final Object[] g = this.g;
            this.e(n2);
            --this.h;
            if (n > 0) {
                System.arraycopy(f, 0, this.f, 0, n);
                System.arraycopy(g, 0, this.g, 0, n << 1);
            }
            if (n < this.h) {
                System.arraycopy(f, n + 1, this.f, n, this.h - n);
                System.arraycopy(g, n + 1 << 1, this.g, n << 1, this.h - n << 1);
                return (V)o;
            }
        }
        return (V)o;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this != o) {
            if (o instanceof Map) {
                final Map map = (Map)o;
                if (this.size() != map.size()) {
                    return false;
                }
                int i = 0;
                try {
                    while (i < this.h) {
                        final K b = this.b(i);
                        final V c = this.c(i);
                        final Object value = map.get(b);
                        if (c == null) {
                            if (value != null || !map.containsKey(b)) {
                                return false;
                            }
                        }
                        else if (!c.equals(value)) {
                            return false;
                        }
                        ++i;
                    }
                    return true;
                }
                catch (NullPointerException ex) {
                    return false;
                }
                catch (ClassCastException ex2) {
                    return false;
                }
                return false;
            }
            return false;
        }
        return true;
    }
    
    public V get(final Object o) {
        int n;
        if (o == null) {
            n = this.a();
        }
        else {
            n = this.a(o, o.hashCode());
        }
        if (n >= 0) {
            return (V)this.g[1 + (n << 1)];
        }
        return null;
    }
    
    @Override
    public int hashCode() {
        final int[] f = this.f;
        final Object[] g = this.g;
        final int h = this.h;
        int n = 1;
        int i = 0;
        int n2 = 0;
        while (i < h) {
            final Object o = g[n];
            final int n3 = f[i];
            int hashCode;
            if (o == null) {
                hashCode = 0;
            }
            else {
                hashCode = o.hashCode();
            }
            n2 += (hashCode ^ n3);
            ++i;
            n += 2;
        }
        return n2;
    }
    
    public boolean isEmpty() {
        return this.h <= 0;
    }
    
    public V put(final K k, final V v) {
        int n = 8;
        int n2;
        int hashCode;
        if (k == null) {
            n2 = this.a();
            hashCode = 0;
        }
        else {
            hashCode = k.hashCode();
            n2 = this.a(k, hashCode);
        }
        if (n2 >= 0) {
            final int n3 = 1 + (n2 << 1);
            final Object o = this.g[n3];
            this.g[n3] = v;
            return (V)o;
        }
        final int n4 = ~n2;
        if (this.h >= this.f.length) {
            if (this.h >= n) {
                n = this.h + (this.h >> 1);
            }
            else if (this.h < 4) {
                n = 4;
            }
            final int[] f = this.f;
            final Object[] g = this.g;
            this.e(n);
            if (this.f.length > 0) {
                System.arraycopy(f, 0, this.f, 0, f.length);
                System.arraycopy(g, 0, this.g, 0, g.length);
            }
            a(f, g, this.h);
        }
        if (n4 < this.h) {
            System.arraycopy(this.f, n4, this.f, n4 + 1, this.h - n4);
            System.arraycopy(this.g, n4 << 1, this.g, n4 + 1 << 1, this.h - n4 << 1);
        }
        this.f[n4] = hashCode;
        this.g[n4 << 1] = k;
        this.g[1 + (n4 << 1)] = v;
        ++this.h;
        return null;
    }
    
    public V remove(final Object o) {
        int n;
        if (o == null) {
            n = this.a();
        }
        else {
            n = this.a(o, o.hashCode());
        }
        if (n >= 0) {
            return this.d(n);
        }
        return null;
    }
    
    public int size() {
        return this.h;
    }
    
    @Override
    public String toString() {
        if (this.isEmpty()) {
            return "{}";
        }
        final StringBuilder sb = new StringBuilder(28 * this.h);
        sb.append('{');
        for (int i = 0; i < this.h; ++i) {
            if (i > 0) {
                sb.append(", ");
            }
            final K b = this.b(i);
            if (b != this) {
                sb.append(b);
            }
            else {
                sb.append("(this Map)");
            }
            sb.append('=');
            final V c = this.c(i);
            if (c != this) {
                sb.append(c);
            }
            else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
