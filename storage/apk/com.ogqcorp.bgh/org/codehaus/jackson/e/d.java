// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.e;

import org.codehaus.jackson.g.i;
import java.util.Arrays;

public final class d
{
    static final d a;
    protected d b;
    protected final boolean c;
    protected final boolean d;
    protected String[] e;
    protected e[] f;
    protected int g;
    protected int h;
    protected int i;
    protected int j;
    protected boolean k;
    private final int l;
    
    static {
        a = new d();
    }
    
    private d() {
        this.d = true;
        this.c = true;
        this.k = true;
        this.l = 0;
        this.j = 0;
        this.d(64);
    }
    
    private d(final d b, final boolean d, final boolean c, final String[] e, final e[] f, final int g, final int l, final int j) {
        this.b = b;
        this.d = d;
        this.c = c;
        this.e = e;
        this.f = f;
        this.g = g;
        this.l = l;
        final int length = e.length;
        this.h = e(length);
        this.i = length - 1;
        this.j = j;
        this.k = false;
    }
    
    public static d a() {
        final long currentTimeMillis = System.currentTimeMillis();
        return a(0x1 | (int)currentTimeMillis + ((int)currentTimeMillis >>> 32));
    }
    
    protected static d a(final int n) {
        return d.a.f(n);
    }
    
    private void a(final d d) {
        if (d.c() > 12000 || d.j > 63) {
            synchronized (this) {
                this.d(64);
                this.k = false;
                return;
            }
        }
        if (d.c() > this.c()) {
            synchronized (this) {
                this.e = d.e;
                this.f = d.f;
                this.g = d.g;
                this.h = d.h;
                this.i = d.i;
                this.j = d.j;
                this.k = false;
            }
        }
    }
    
    private void d(final int n) {
        this.e = new String[n];
        this.f = new e[n >> 1];
        this.i = n - 1;
        this.g = 0;
        this.j = 0;
        this.h = e(n);
    }
    
    private static final int e(final int n) {
        return n - (n >> 2);
    }
    
    private void e() {
        final String[] e = this.e;
        final int length = e.length;
        System.arraycopy(e, 0, this.e = new String[length], 0, length);
        final e[] f = this.f;
        final int length2 = f.length;
        System.arraycopy(f, 0, this.f = new e[length2], 0, length2);
    }
    
    private d f(final int n) {
        return new d(null, true, true, this.e, this.f, this.g, n, this.j);
    }
    
    private void f() {
        final int length = this.e.length;
        final int n = length + length;
        if (n > 65536) {
            this.g = 0;
            Arrays.fill(this.e, null);
            Arrays.fill(this.f, null);
            this.k = true;
        }
        else {
            final String[] e = this.e;
            final e[] f = this.f;
            this.e = new String[n];
            this.f = new e[n >> 1];
            this.i = n - 1;
            this.h = e(n);
            int i = 0;
            int max = 0;
            int n2 = 0;
            while (i < length) {
                final String s = e[i];
                if (s != null) {
                    ++n2;
                    final int b = this.b(this.a(s));
                    if (this.e[b] == null) {
                        this.e[b] = s;
                    }
                    else {
                        final int n3 = b >> 1;
                        final e e2 = new e(s, this.f[n3]);
                        this.f[n3] = e2;
                        max = Math.max(max, e2.c());
                    }
                }
                ++i;
            }
            final int n4 = length >> 1;
            int j = 0;
            int k = n2;
            int l = max;
            while (j < n4) {
                final e e3 = f[j];
                int max2 = l;
                for (e b2 = e3; b2 != null; b2 = b2.b()) {
                    ++k;
                    final String a = b2.a();
                    final int b3 = this.b(this.a(a));
                    if (this.e[b3] == null) {
                        this.e[b3] = a;
                    }
                    else {
                        final int n5 = b3 >> 1;
                        final e e4 = new e(a, this.f[n5]);
                        this.f[n5] = e4;
                        max2 = Math.max(max2, e4.c());
                    }
                }
                ++j;
                l = max2;
            }
            this.j = l;
            if (k != this.g) {
                throw new Error("Internal error on SymbolTable.rehash(): had " + this.g + " entries; now have " + k + ".");
            }
        }
    }
    
    public int a(final String s) {
        final int length = s.length();
        int l = this.l;
        int n;
        for (int i = 0; i < length; ++i, l = n) {
            n = l * 33 + s.charAt(i);
        }
        if (l == 0) {
            l = 1;
        }
        return l;
    }
    
    public int a(final char[] array, final int n, final int n2) {
        int l = this.l;
        int n3;
        for (int i = 0; i < n2; ++i, l = n3) {
            n3 = l * 33 + array[i];
        }
        if (l == 0) {
            l = 1;
        }
        return l;
    }
    
    public String a(final char[] array, final int n, final int n2, final int n3) {
        String a;
        if (n2 < 1) {
            a = "";
        }
        else {
            if (!this.d) {
                return new String(array, n, n2);
            }
            final int b = this.b(n3);
            final String s = this.e[b];
            if (s != null) {
                if (s.length() == n2) {
                    int index = 0;
                    while (s.charAt(index) == array[n + index] && ++index < n2) {}
                    if (index == n2) {
                        return s;
                    }
                }
                final e e = this.f[b >> 1];
                if (e != null) {
                    final String a2 = e.a(array, n, n2);
                    if (a2 != null) {
                        return a2;
                    }
                }
            }
            int b2;
            if (!this.k) {
                this.e();
                this.k = true;
                b2 = b;
            }
            else if (this.g >= this.h) {
                this.f();
                b2 = this.b(this.a(array, n, n2));
            }
            else {
                b2 = b;
            }
            a = new String(array, n, n2);
            if (this.c) {
                a = org.codehaus.jackson.g.i.a.a(a);
            }
            ++this.g;
            if (this.e[b2] == null) {
                return this.e[b2] = a;
            }
            final int n4 = b2 >> 1;
            final e e2 = new e(a, this.f[n4]);
            this.f[n4] = e2;
            this.j = Math.max(e2.c(), this.j);
            if (this.j > 255) {
                this.c(255);
                return a;
            }
        }
        return a;
    }
    
    public d a(final boolean b, final boolean b2) {
        synchronized (this) {
            synchronized (this) {
                final String[] e = this.e;
                final e[] f = this.f;
                final int g = this.g;
                final int l = this.l;
                final int j = this.j;
                // monitorexit(this)
                return new d(this, b, b2, e, f, g, l, j);
            }
        }
    }
    
    public final int b(final int n) {
        return n + (n >>> 15) & this.i;
    }
    
    public void b() {
        if (this.d() && this.b != null) {
            this.b.a(this);
            this.k = false;
        }
    }
    
    public int c() {
        return this.g;
    }
    
    protected void c(final int i) {
        throw new IllegalStateException("Longest collision chain in symbol table (of size " + this.g + ") now exceeds maximum, " + i + " -- suspect a DoS attack based on hash collisions");
    }
    
    public boolean d() {
        return this.k;
    }
}
