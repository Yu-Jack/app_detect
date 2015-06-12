// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.e;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

public final class a
{
    protected final a a;
    protected final AtomicReference<c> b;
    protected final boolean c;
    protected int d;
    protected int e;
    protected int f;
    protected int[] g;
    protected f[] h;
    protected b[] i;
    protected int j;
    protected int k;
    private final int l;
    private transient boolean m;
    private boolean n;
    private boolean o;
    private boolean p;
    
    private a(int n, final boolean c, final int l) {
        int i = 16;
        this.a = null;
        this.l = l;
        this.c = c;
        if (n < i) {
            n = i;
        }
        else if ((n & n - 1) != 0x0) {
            while (i < n) {
                i += i;
            }
            n = i;
        }
        this.b = new AtomicReference<c>(this.e(n));
    }
    
    private a(final a a, final boolean c, final int l, final c c2) {
        this.a = a;
        this.l = l;
        this.c = c;
        this.b = null;
        this.d = c2.a;
        this.f = c2.b;
        this.g = c2.c;
        this.h = c2.d;
        this.i = c2.e;
        this.j = c2.f;
        this.k = c2.g;
        this.e = c2.h;
        this.m = false;
        this.n = true;
        this.o = true;
        this.p = true;
    }
    
    public static a a() {
        final long currentTimeMillis = System.currentTimeMillis();
        return a(0x1 | (int)currentTimeMillis + ((int)currentTimeMillis >>> 32));
    }
    
    protected static a a(final int n) {
        return new a(64, true, n);
    }
    
    private static f a(final int n, final String s, final int[] array, final int n2) {
        if (n2 < 4) {
            switch (n2) {
                case 1: {
                    return new g(s, n, array[0]);
                }
                case 2: {
                    return new h(s, n, array[0], array[1]);
                }
                case 3: {
                    return new i(s, n, array[0], array[1], array[2]);
                }
            }
        }
        final int[] array2 = new int[n2];
        for (int i = 0; i < n2; ++i) {
            array2[i] = array[i];
        }
        return new j(s, n, array2, n2);
    }
    
    private void a(final int n, final f f) {
        if (this.n) {
            this.h();
        }
        if (this.m) {
            this.e();
        }
        ++this.d;
        final int n2 = n & this.f;
        if (this.h[n2] == null) {
            this.g[n2] = n << 8;
            if (this.o) {
                this.j();
            }
            this.h[n2] = f;
        }
        else {
            if (this.p) {
                this.i();
            }
            ++this.j;
            final int n3 = this.g[n2];
            final int n4 = n3 & 0xFF;
            int n5;
            if (n4 == 0) {
                if (this.k <= 254) {
                    n5 = this.k;
                    ++this.k;
                    if (n5 >= this.i.length) {
                        this.k();
                    }
                }
                else {
                    n5 = this.g();
                }
                this.g[n2] = ((n3 & 0xFFFFFF00) | n5 + 1);
            }
            else {
                n5 = n4 - 1;
            }
            final b b = new b(f, this.i[n5]);
            this.i[n5] = b;
            this.e = Math.max(b.a(), this.e);
            if (this.e > 255) {
                this.d(255);
            }
        }
        final int length = this.g.length;
        if (this.d > length >> 1) {
            final int n6 = length >> 2;
            if (this.d > length - n6) {
                this.m = true;
            }
            else if (this.j >= n6) {
                this.m = true;
            }
        }
    }
    
    private void a(c e) {
        final int a = e.a;
        final c expect = this.b.get();
        if (a <= expect.a) {
            return;
        }
        if (a > 6000 || e.h > 63) {
            e = this.e(64);
        }
        this.b.compareAndSet(expect, e);
    }
    
    public static f d() {
        return g.b();
    }
    
    private c e(final int n) {
        return new c(0, n - 1, new int[n], new f[n], null, 0, 0, 0);
    }
    
    private void e() {
        int n = 0;
        this.m = false;
        this.o = false;
        final int length = this.g.length;
        final int n2 = length + length;
        if (n2 > 65536) {
            this.f();
        }
        else {
            this.g = new int[n2];
            this.f = n2 - 1;
            final f[] h = this.h;
            this.h = new f[n2];
            int i = 0;
            int n3 = 0;
            while (i < length) {
                final f f = h[i];
                if (f != null) {
                    ++n3;
                    final int hashCode = f.hashCode();
                    final int n4 = hashCode & this.f;
                    this.h[n4] = f;
                    this.g[n4] = hashCode << 8;
                }
                ++i;
            }
            final int k = this.k;
            if (k == 0) {
                this.e = 0;
                return;
            }
            this.j = 0;
            this.k = 0;
            this.p = false;
            final b[] j = this.i;
            this.i = new b[j.length];
            int l = 0;
            int m = n3;
            while (l < k) {
                final b b = j[l];
                int n5 = m;
                int n6;
                int max;
                for (b b2 = b; b2 != null; b2 = b2.b, n = max, n5 = n6) {
                    n6 = n5 + 1;
                    final f a = b2.a;
                    final int hashCode2 = a.hashCode();
                    final int n7 = hashCode2 & this.f;
                    final int n8 = this.g[n7];
                    if (this.h[n7] == null) {
                        this.g[n7] = hashCode2 << 8;
                        this.h[n7] = a;
                        max = n;
                    }
                    else {
                        ++this.j;
                        final int n9 = n8 & 0xFF;
                        int n10;
                        if (n9 == 0) {
                            if (this.k <= 254) {
                                n10 = this.k;
                                ++this.k;
                                if (n10 >= this.i.length) {
                                    this.k();
                                }
                            }
                            else {
                                n10 = this.g();
                            }
                            this.g[n7] = ((n8 & 0xFFFFFF00) | n10 + 1);
                        }
                        else {
                            n10 = n9 - 1;
                        }
                        final b b3 = new b(a, this.i[n10]);
                        this.i[n10] = b3;
                        max = Math.max(n, b3.a());
                    }
                }
                ++l;
                m = n5;
            }
            this.e = n;
            if (m != this.d) {
                throw new RuntimeException("Internal error: count after rehash " + m + "; should be " + this.d);
            }
        }
    }
    
    private void f() {
        this.d = 0;
        this.e = 0;
        Arrays.fill(this.g, 0);
        Arrays.fill(this.h, null);
        Arrays.fill(this.i, null);
        this.j = 0;
        this.k = 0;
    }
    
    private int g() {
        final b[] i = this.i;
        int n = Integer.MAX_VALUE;
        int n2 = -1;
        int a;
        for (int j = 0; j < this.k; ++j, n = a) {
            a = i[j].a();
            if (a < n) {
                if (a == 1) {
                    return j;
                }
                n2 = j;
            }
            else {
                a = n;
            }
        }
        return n2;
    }
    
    private void h() {
        final int[] g = this.g;
        final int length = this.g.length;
        System.arraycopy(g, 0, this.g = new int[length], 0, length);
        this.n = false;
    }
    
    private void i() {
        final b[] i = this.i;
        if (i == null) {
            this.i = new b[32];
        }
        else {
            final int length = i.length;
            System.arraycopy(i, 0, this.i = new b[length], 0, length);
        }
        this.p = false;
    }
    
    private void j() {
        final f[] h = this.h;
        final int length = h.length;
        System.arraycopy(h, 0, this.h = new f[length], 0, length);
        this.o = false;
    }
    
    private void k() {
        final b[] i = this.i;
        final int length = i.length;
        System.arraycopy(i, 0, this.i = new b[length + length], 0, length);
    }
    
    public a a(final boolean b, final boolean b2) {
        return new a(this, b2, this.l, this.b.get());
    }
    
    public f a(final int n, final int n2) {
        int n3;
        if (n2 == 0) {
            n3 = this.c(n);
        }
        else {
            n3 = this.b(n, n2);
        }
        final int n4 = n3 & this.f;
        final int n5 = this.g[n4];
        if ((n3 ^ n5 >> 8) << 8 == 0) {
            final f f = this.h[n4];
            if (f == null) {
                return null;
            }
            if (f.a(n, n2)) {
                return f;
            }
        }
        else if (n5 == 0) {
            return null;
        }
        final int n6 = n5 & 0xFF;
        if (n6 > 0) {
            final b b = this.i[n6 - 1];
            if (b != null) {
                return b.a(n3, n, n2);
            }
        }
        return null;
    }
    
    public f a(String a, final int[] array, final int n) {
        if (this.c) {
            a = org.codehaus.jackson.g.i.a.a(a);
        }
        int n2;
        if (n < 3) {
            if (n == 1) {
                n2 = this.c(array[0]);
            }
            else {
                n2 = this.b(array[0], array[1]);
            }
        }
        else {
            n2 = this.b(array, n);
        }
        final f a2 = a(n2, a, array, n);
        this.a(n2, a2);
        return a2;
    }
    
    public f a(final int[] array, final int n) {
        if (n >= 3) {
            final int b = this.b(array, n);
            final int n2 = b & this.f;
            final int n3 = this.g[n2];
            if ((b ^ n3 >> 8) << 8 == 0) {
                final f a = this.h[n2];
                if (a == null || a.a(array, n)) {
                    return a;
                }
            }
            else if (n3 == 0) {
                return null;
            }
            final int n4 = n3 & 0xFF;
            if (n4 > 0) {
                final b b2 = this.i[n4 - 1];
                if (b2 != null) {
                    return b2.a(b, array, n);
                }
            }
            return null;
        }
        final int n5 = array[0];
        int n6 = 0;
        if (n >= 2) {
            n6 = array[1];
        }
        return this.a(n5, n6);
    }
    
    public final int b(final int n, final int n2) {
        final int n3 = (n ^ n >>> 15) + n2 * 33 ^ this.l;
        return n3 + (n3 >>> 7);
    }
    
    public final int b(final int[] array, final int n) {
        int i = 3;
        if (n < i) {
            throw new IllegalArgumentException();
        }
        final int n2 = array[0] ^ this.l;
        final int n3 = 65599 * (33 * (n2 + (n2 >>> 9)) + array[1]);
        final int n4 = n3 + (n3 >>> 15) ^ array[2];
        int n5 = n4 + (n4 >>> 17);
        while (i < n) {
            final int n6 = n5 * 31 ^ array[i];
            final int n7 = n6 + (n6 >>> 3);
            n5 = (n7 ^ n7 << 7);
            ++i;
        }
        final int n8 = n5 + (n5 >>> 15);
        return n8 ^ n8 << 9;
    }
    
    public f b(final int n) {
        final int c = this.c(n);
        final int n2 = c & this.f;
        final int n3 = this.g[n2];
        Label_0066: {
            if ((c ^ n3 >> 8) << 8 == 0) {
                final f f = this.h[n2];
                if (f != null) {
                    if (f.a(n)) {
                        return f;
                    }
                    break Label_0066;
                }
            }
            else if (n3 != 0) {
                break Label_0066;
            }
            return null;
        }
        final int n4 = n3 & 0xFF;
        if (n4 <= 0) {
            return null;
        }
        final b b = this.i[n4 - 1];
        if (b != null) {
            return b.a(c, n, 0);
        }
        return null;
    }
    
    public void b() {
        if (this.a != null && this.c()) {
            this.a.a(new c(this));
            this.n = true;
            this.o = true;
            this.p = true;
        }
    }
    
    public final int c(final int n) {
        final int n2 = n ^ this.l;
        final int n3 = n2 + (n2 >>> 15);
        return n3 ^ n3 >>> 9;
    }
    
    public boolean c() {
        return !this.n;
    }
    
    protected void d(final int i) {
        throw new IllegalStateException("Longest collision chain in symbol table (of size " + this.d + ") now exceeds maximum, " + i + " -- suspect a DoS attack based on hash collisions");
    }
}
