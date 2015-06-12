// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.g;

import org.codehaus.jackson.b.g;
import java.math.BigDecimal;
import java.util.ArrayList;

public final class l
{
    static final char[] a;
    private final a b;
    private char[] c;
    private int d;
    private int e;
    private ArrayList<char[]> f;
    private boolean g;
    private int h;
    private char[] i;
    private int j;
    private String k;
    private char[] l;
    
    static {
        a = new char[0];
    }
    
    public l(final a b) {
        this.g = false;
        this.b = b;
    }
    
    private final char[] b(final int a) {
        if (this.b != null) {
            return this.b.a(org.codehaus.jackson.g.c.c, a);
        }
        return new char[Math.max(a, 1000)];
    }
    
    private void c(final int n) {
        final int e = this.e;
        this.e = 0;
        final char[] c = this.c;
        this.c = null;
        final int d = this.d;
        this.d = -1;
        final int n2 = e + n;
        if (this.i == null || n2 > this.i.length) {
            this.i = this.b(n2);
        }
        if (e > 0) {
            System.arraycopy(c, d, this.i, 0, e);
        }
        this.h = 0;
        this.j = e;
    }
    
    private void d(int n) {
        if (this.f == null) {
            this.f = new ArrayList<char[]>();
        }
        final char[] i = this.i;
        this.g = true;
        this.f.add(i);
        this.h += i.length;
        final int length = i.length;
        final int n2 = length >> 1;
        if (n2 >= n) {
            n = n2;
        }
        final char[] e = this.e(Math.min(262144, length + n));
        this.j = 0;
        this.i = e;
    }
    
    private final char[] e(final int n) {
        return new char[n];
    }
    
    private final void o() {
        this.g = false;
        this.f.clear();
        this.h = 0;
        this.j = 0;
    }
    
    private char[] p() {
        if (this.k != null) {
            return this.k.toCharArray();
        }
        if (this.d >= 0) {
            if (this.e < 1) {
                return org.codehaus.jackson.g.l.a;
            }
            final char[] e = this.e(this.e);
            System.arraycopy(this.c, this.d, e, 0, this.e);
            return e;
        }
        else {
            final int c = this.c();
            if (c < 1) {
                return org.codehaus.jackson.g.l.a;
            }
            final char[] e2 = this.e(c);
            int n2;
            if (this.f != null) {
                final int size = this.f.size();
                int i = 0;
                int n = 0;
                while (i < size) {
                    final char[] array = this.f.get(i);
                    final int length = array.length;
                    System.arraycopy(array, 0, e2, n, length);
                    n += length;
                    ++i;
                }
                n2 = n;
            }
            else {
                n2 = 0;
            }
            System.arraycopy(this.i, 0, e2, n2, this.j);
            return e2;
        }
    }
    
    public void a() {
        if (this.b == null) {
            this.b();
        }
        else if (this.i != null) {
            this.b();
            final char[] i = this.i;
            this.i = null;
            this.b.a(org.codehaus.jackson.g.c.c, i);
        }
    }
    
    public void a(final char c) {
        if (this.d >= 0) {
            this.c(16);
        }
        this.k = null;
        this.l = null;
        char[] array = this.i;
        if (this.j >= array.length) {
            this.d(1);
            array = this.i;
        }
        array[this.j++] = c;
    }
    
    public void a(final int j) {
        this.j = j;
    }
    
    public void a(final String k) {
        this.c = null;
        this.d = -1;
        this.e = 0;
        this.k = k;
        this.l = null;
        if (this.g) {
            this.o();
        }
        this.j = 0;
    }
    
    public void a(final String s, int srcBegin, int i) {
        if (this.d >= 0) {
            this.c(i);
        }
        this.k = null;
        this.l = null;
        final char[] j = this.i;
        final int n = j.length - this.j;
        if (n >= i) {
            s.getChars(srcBegin, srcBegin + i, j, this.j);
            this.j += i;
            return;
        }
        if (n > 0) {
            s.getChars(srcBegin, srcBegin + n, j, this.j);
            i -= n;
            srcBegin += n;
        }
        do {
            this.d(i);
            final int min = Math.min(this.i.length, i);
            s.getChars(srcBegin, srcBegin + min, this.i, 0);
            this.j += min;
            srcBegin += min;
            i -= min;
        } while (i > 0);
    }
    
    public void a(final char[] c, final int d, final int e) {
        this.k = null;
        this.l = null;
        this.c = c;
        this.d = d;
        this.e = e;
        if (this.g) {
            this.o();
        }
    }
    
    public void b() {
        this.d = -1;
        this.j = 0;
        this.e = 0;
        this.c = null;
        this.k = null;
        this.l = null;
        if (this.g) {
            this.o();
        }
    }
    
    public void b(final char[] array, final int n, final int n2) {
        this.c = null;
        this.d = -1;
        this.e = 0;
        this.k = null;
        this.l = null;
        if (this.g) {
            this.o();
        }
        else if (this.i == null) {
            this.i = this.b(n2);
        }
        this.h = 0;
        this.j = 0;
        this.c(array, n, n2);
    }
    
    public int c() {
        if (this.d >= 0) {
            return this.e;
        }
        if (this.l != null) {
            return this.l.length;
        }
        if (this.k != null) {
            return this.k.length();
        }
        return this.h + this.j;
    }
    
    public void c(final char[] array, int n, int i) {
        if (this.d >= 0) {
            this.c(i);
        }
        this.k = null;
        this.l = null;
        final char[] j = this.i;
        final int n2 = j.length - this.j;
        if (n2 >= i) {
            System.arraycopy(array, n, j, this.j, i);
            this.j += i;
            return;
        }
        if (n2 > 0) {
            System.arraycopy(array, n, j, this.j, n2);
            n += n2;
            i -= n2;
        }
        do {
            this.d(i);
            final int min = Math.min(this.i.length, i);
            System.arraycopy(array, n, this.i, 0, min);
            this.j += min;
            n += min;
            i -= min;
        } while (i > 0);
    }
    
    public int d() {
        if (this.d >= 0) {
            return this.d;
        }
        return 0;
    }
    
    public char[] e() {
        if (this.d >= 0) {
            return this.c;
        }
        if (this.l != null) {
            return this.l;
        }
        if (this.k != null) {
            return this.l = this.k.toCharArray();
        }
        if (!this.g) {
            return this.i;
        }
        return this.g();
    }
    
    public String f() {
        if (this.k == null) {
            if (this.l != null) {
                this.k = new String(this.l);
            }
            else if (this.d >= 0) {
                if (this.e < 1) {
                    return this.k = "";
                }
                this.k = new String(this.c, this.d, this.e);
            }
            else {
                final int h = this.h;
                final int j = this.j;
                if (h == 0) {
                    String k;
                    if (j == 0) {
                        k = "";
                    }
                    else {
                        k = new String(this.i, 0, j);
                    }
                    this.k = k;
                }
                else {
                    final StringBuilder sb = new StringBuilder(h + j);
                    if (this.f != null) {
                        for (int size = this.f.size(), i = 0; i < size; ++i) {
                            final char[] str = this.f.get(i);
                            sb.append(str, 0, str.length);
                        }
                    }
                    sb.append(this.i, 0, this.j);
                    this.k = sb.toString();
                }
            }
        }
        return this.k;
    }
    
    public char[] g() {
        char[] l = this.l;
        if (l == null) {
            l = this.p();
            this.l = l;
        }
        return l;
    }
    
    public BigDecimal h() {
        if (this.l != null) {
            return new BigDecimal(this.l);
        }
        if (this.d >= 0) {
            return new BigDecimal(this.c, this.d, this.e);
        }
        if (this.h == 0) {
            return new BigDecimal(this.i, 0, this.j);
        }
        return new BigDecimal(this.g());
    }
    
    public double i() {
        return org.codehaus.jackson.b.g.c(this.f());
    }
    
    public char[] j() {
        if (this.d >= 0) {
            this.c(1);
        }
        else {
            final char[] i = this.i;
            if (i == null) {
                this.i = this.b(0);
            }
            else if (this.j >= i.length) {
                this.d(1);
            }
        }
        return this.i;
    }
    
    public final char[] k() {
        this.d = -1;
        this.j = 0;
        this.e = 0;
        this.c = null;
        this.k = null;
        this.l = null;
        if (this.g) {
            this.o();
        }
        char[] i = this.i;
        if (i == null) {
            i = this.b(0);
            this.i = i;
        }
        return i;
    }
    
    public int l() {
        return this.j;
    }
    
    public char[] m() {
        if (this.f == null) {
            this.f = new ArrayList<char[]>();
        }
        this.g = true;
        this.f.add(this.i);
        final int length = this.i.length;
        this.h += length;
        final char[] e = this.e(Math.min(length + (length >> 1), 262144));
        this.j = 0;
        return this.i = e;
    }
    
    public char[] n() {
        final char[] i = this.i;
        final int length = i.length;
        int min;
        if (length == 262144) {
            min = 262145;
        }
        else {
            min = Math.min(262144, length + (length >> 1));
        }
        System.arraycopy(i, 0, this.i = this.e(min), 0, length);
        return this.i;
    }
    
    @Override
    public String toString() {
        return this.f();
    }
}
