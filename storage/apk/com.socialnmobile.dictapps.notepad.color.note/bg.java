import java.util.Map;

// 
// Decompiled by Procyon v0.5.29
// 

public class bg
{
    static Object[] b;
    static int c;
    static Object[] d;
    static int e;
    int[] f;
    Object[] g;
    int h;
    
    public bg() {
        this.f = ax.a;
        this.g = ax.c;
        this.h = 0;
    }
    
    static void a(final int[] array, final Object[] array2, final int n) {
        Label_0076: {
            if (array.length != 8) {
                break Label_0076;
            }
            synchronized (av.class) {
                if (bg.e < 10) {
                    array2[0] = bg.d;
                    array2[1] = array;
                    for (int i = -1 + (n << 1); i >= 2; --i) {
                        array2[i] = null;
                    }
                    bg.d = array2;
                    ++bg.e;
                }
                return;
            }
        }
        if (array.length != 4) {
            return;
        }
        synchronized (av.class) {
            if (bg.c < 10) {
                array2[0] = bg.b;
                array2[1] = array;
                for (int j = -1 + (n << 1); j >= 2; --j) {
                    array2[j] = null;
                }
                bg.b = array2;
                ++bg.c;
            }
        }
    }
    
    private Object d(final int n) {
        return this.g[n << 1];
    }
    
    final int a() {
        final int h = this.h;
        int a;
        if (h == 0) {
            a = -1;
        }
        else {
            a = ax.a(this.f, h, 0);
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
    
    final int a(final Object o) {
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
    
    final int a(final Object o, final int n) {
        final int h = this.h;
        int a;
        if (h == 0) {
            a = -1;
        }
        else {
            a = ax.a(this.f, h, n);
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
    
    final void a(final int n) {
        while (true) {
            Label_0104: {
                if (n != 8) {
                    break Label_0104;
                }
                synchronized (av.class) {
                    if (bg.d != null) {
                        final Object[] d = bg.d;
                        this.g = d;
                        bg.d = (Object[])d[0];
                        this.f = (int[])d[1];
                        d[0] = (d[1] = null);
                        --bg.e;
                        return;
                    }
                    // monitorexit(av.class)
                    this.f = new int[n];
                    this.g = new Object[n << 1];
                    return;
                }
            }
            if (n == 4) {
                synchronized (av.class) {
                    if (bg.b != null) {
                        final Object[] b = bg.b;
                        this.g = b;
                        bg.b = (Object[])b[0];
                        this.f = (int[])b[1];
                        b[0] = (b[1] = null);
                        --bg.c;
                        return;
                    }
                }
                // monitorexit(av.class)
                continue;
            }
            continue;
        }
    }
    
    public final Object b(final int n) {
        return this.g[1 + (n << 1)];
    }
    
    public final Object c(final int n) {
        int n2 = 8;
        final Object o = this.g[1 + (n << 1)];
        if (this.h <= 1) {
            a(this.f, this.g, this.h);
            this.f = ax.a;
            this.g = ax.c;
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
                return o;
            }
            if (this.h > n2) {
                n2 = this.h + (this.h >> 1);
            }
            final int[] f = this.f;
            final Object[] g = this.g;
            this.a(n2);
            --this.h;
            if (n > 0) {
                System.arraycopy(f, 0, this.f, 0, n);
                System.arraycopy(g, 0, this.g, 0, n << 1);
            }
            if (n < this.h) {
                System.arraycopy(f, n + 1, this.f, n, this.h - n);
                System.arraycopy(g, n + 1 << 1, this.g, n << 1, this.h - n << 1);
                return o;
            }
        }
        return o;
    }
    
    public void clear() {
        if (this.h != 0) {
            a(this.f, this.g, this.h);
            this.f = ax.a;
            this.g = ax.c;
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
                        final Object d = this.d(i);
                        final Object b = this.b(i);
                        final Object value = map.get(d);
                        if (b == null) {
                            if (value != null || !map.containsKey(d)) {
                                return false;
                            }
                        }
                        else if (!b.equals(value)) {
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
    
    public Object get(final Object o) {
        int n;
        if (o == null) {
            n = this.a();
        }
        else {
            n = this.a(o, o.hashCode());
        }
        if (n >= 0) {
            return this.g[1 + (n << 1)];
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
    
    public Object put(final Object o, final Object o2) {
        int n = 8;
        int n2;
        int hashCode;
        if (o == null) {
            n2 = this.a();
            hashCode = 0;
        }
        else {
            hashCode = o.hashCode();
            n2 = this.a(o, hashCode);
        }
        if (n2 >= 0) {
            final int n3 = 1 + (n2 << 1);
            final Object o3 = this.g[n3];
            this.g[n3] = o2;
            return o3;
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
            this.a(n);
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
        this.g[n4 << 1] = o;
        this.g[1 + (n4 << 1)] = o2;
        ++this.h;
        return null;
    }
    
    public Object remove(final Object o) {
        int n;
        if (o == null) {
            n = this.a();
        }
        else {
            n = this.a(o, o.hashCode());
        }
        if (n >= 0) {
            return this.c(n);
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
            final Object d = this.d(i);
            if (d != this) {
                sb.append(d);
            }
            else {
                sb.append("(this Map)");
            }
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
